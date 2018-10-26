package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Locacao;
import java.io.Serializable;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class LocacaoDAO<TIPO> extends DAOGenerico<Locacao> implements Serializable {
    
    public LocacaoDAO(){
        super();
        classePersistente = Locacao.class;
        // inicializar a ordem padrão
        ordem = "id";
    }
   
}
