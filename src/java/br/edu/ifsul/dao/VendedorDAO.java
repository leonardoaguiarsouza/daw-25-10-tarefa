package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Vendedor;
import java.io.Serializable;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class VendedorDAO<TIPO> extends DAOGenerico<Vendedor> implements Serializable {
    
    public VendedorDAO(){
        super();
        classePersistente = Vendedor.class;
        // inicializar a ordem padrão
    }
   
}
