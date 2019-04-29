package br.com.financial_app.persistency.queries;

import java.util.List;

import br.com.financial_app.domain.EntidadeDominio;

public class TransacaoQuery implements IFactoryQuery {
	
	private static TransacaoQuery transacaoQuery;
	
	private TransacaoQuery(EntidadeDominio entidadeDominio) {
	
	}
	
	public static IFactoryQuery createTransacaoQuery(EntidadeDominio entidade) {
		if(transacaoQuery==null) {
			transacaoQuery = new TransacaoQuery(entidade);
		}
		return transacaoQuery;
	}

	@Override
	public String gerarString(String tipoConsulta) {
		return null;
	}

	@Override
	public List<Object> retornoParametros() {
		return null;
	}



}
