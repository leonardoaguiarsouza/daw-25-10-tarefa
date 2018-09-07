/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Vendedor;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import org.postgresql.translation.messages_bg;

/**
 *
 * @author 201613260113
 */
public class VendedorDAO implements Serializable{
    private String mensagem = "";
    private EntityManager em;
    
    public VendedorDAO(){
        em = EntityManagerUtil.getEntityManager();
    }

    public List<Vendedor> getLista(){
        return em.createQuery(" from Vendedor order by nome").getResultList();
    }
    
    public boolean salvar(Vendedor obj){
        try {
            em.getTransaction().begin();
            if(obj.getId() == null){
                em.persist(obj);
            } else {
                em.merge(obj);
            }
            em.getTransaction().commit();
            mensagem = "Objeto persistio com sucesso!";
            return true;
        } catch (Exception e) {
            if(em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            mensagem = "Erro ao persistir: " + Util.getMensagemErro(e);
            return false;
       }
    }
    
    public boolean remover(Vendedor obj){
        try {
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
            mensagem = "Objeto removido com sucesso!";
            return true;
        } catch (Exception e) {
            if(em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            mensagem = "Erro ao persistir: " + Util.getMensagemErro(e);
            return false;
       }
    }
    
    public Vendedor localizar(Object id){
        return em.find(Vendedor.class, id);
    }
    
    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    
}
