package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Modelo;
import java.io.Serializable;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class ModeloDAO<TIPO> extends DAOGenerico<Modelo> implements Serializable {
    
    public ModeloDAO(){
        super();
        classePersistente = Modelo.class;
        // inicializar a ordem padrão
    }
   
}
