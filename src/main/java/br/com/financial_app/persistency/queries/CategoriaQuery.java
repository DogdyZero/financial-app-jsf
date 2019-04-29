package br.com.financial_app.persistency.queries;

import java.util.List;

import br.com.financial_app.domain.EntidadeDominio;

public class CategoriaQuery implements IFactoryQuery {
	private static CategoriaQuery categoriaQuery;
	
	private CategoriaQuery(EntidadeDominio entidadeDominio) {
	
	}
	
	
	public static IFactoryQuery createCategoriaQuery(EntidadeDominio entidade) {
		if(categoriaQuery==null) {
			categoriaQuery = new CategoriaQuery(entidade);
		}
		return categoriaQuery;
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
