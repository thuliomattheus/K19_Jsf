package estudo.controleFinancas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Despesa extends TipoFinanca {

	@Id
	@GeneratedValue
	private Long id;
}
