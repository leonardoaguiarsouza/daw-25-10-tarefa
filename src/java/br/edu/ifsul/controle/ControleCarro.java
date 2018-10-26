package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CarroDAO;
import br.edu.ifsul.dao.ModeloDAO;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@ManagedBean(name = "controleCarro")
@SessionScoped
public class ControleCarro implements Serializable {

    private CarroDAO<Carro> dao;
    private Carro objeto;
    private ModeloDAO daoModelo;
    
    public ControleCarro(){
        dao = new CarroDAO<>();
        daoModelo = new ModeloDAO<>();
    }
    
    public String listar(){
        return "/privado/carro/listar?faces-redirect=true";
    }
    
    public String novo(){
        objeto = new Carro();
        return "formulario?faces-redirect=true";
    }
    
    public String salvar(){
        boolean persistiu;
        if(objeto.getId() == null){
            persistiu = dao.persist(objeto);
        } else {
            persistiu = dao.merge(objeto);
        }
        if (persistiu){
            Util.mensagemInformacao(dao.getMensagem());
            return "listar?faces-redirect=true";
        } else {
            Util.mensagemErro(dao.getMensagem());
            return "formulario?faces-redirect=true";
        }
    }
    
    public String cancelar(){
        return "listar?faces-redirect=true";
    }
    
    public String editar(Integer id){
        try {
            objeto = dao.localizar(id);
            return "formulario?faces-redirect=true";
        } catch (Exception e){
            Util.mensagemErro("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
            return "listar?faces-redirect=true";
        }
    }
    
    public void remover(Integer id){
        objeto = dao.localizar(id);
        if (dao.remover(objeto)){
            Util.mensagemInformacao(dao.getMensagem());
        } else {
            Util.mensagemErro(dao.getMensagem());
        }
    }

    public CarroDAO getDao() {
        return dao;
    }

    public void setDao(CarroDAO dao) {
        this.dao = dao;
    }

    public Carro getObjeto() {
        return objeto;
    }

    public void setObjeto(Carro objeto) {
        this.objeto = objeto;
    }

    /**
     * @return the daoModelo
     */
    public ModeloDAO getDaoModelo() {
        return daoModelo;
    }

    /**
     * @param daoModelo the daoModelo to set
     */
    public void setDaoModelo(ModeloDAO daoModelo) {
        this.daoModelo = daoModelo;
    }

}
