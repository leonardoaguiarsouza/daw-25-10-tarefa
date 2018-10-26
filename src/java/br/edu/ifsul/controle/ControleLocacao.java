package br.edu.ifsul.controle;

import br.edu.ifsul.dao.LocacaoDAO;
import br.edu.ifsul.dao.ModeloDAO;
import br.edu.ifsul.modelo.Locacao;
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
@ManagedBean(name = "controleLocacao")
@SessionScoped
public class ControleLocacao implements Serializable {

    private LocacaoDAO<Locacao> dao;
    private Locacao objeto;
    private ModeloDAO daoModelo;
    
    public ControleLocacao(){
        dao = new LocacaoDAO<>();
        daoModelo = new ModeloDAO<>();
    }
    
    public String listar(){
        return "/privado/locacao/listar?faces-redirect=true";
    }
    
    public String novo(){
        objeto = new Locacao();
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

    public LocacaoDAO getDao() {
        return dao;
    }

    public void setDao(LocacaoDAO dao) {
        this.dao = dao;
    }

    public Locacao getObjeto() {
        return objeto;
    }

    public void setObjeto(Locacao objeto) {
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
