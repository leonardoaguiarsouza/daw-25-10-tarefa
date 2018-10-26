package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Cliente;
import java.io.Serializable;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class ClienteDAO<TIPO> extends DAOGenerico<Cliente> implements Serializable {
    
    public ClienteDAO(){
        super();
        classePersistente = Cliente.class;
        // inicializar a ordem padrão
    }
   
}
