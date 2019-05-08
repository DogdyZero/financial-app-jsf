package br.com.financial_app.persistency.queries;

import java.util.List;

import br.com.financial_app.domain.EntidadeDominio;


public interface IFactoryQuery {
	public void setMaps(EntidadeDominio entidade);
	public String gerarString(String tipoConsulta);
	public List<Object> retornoParametros();
}
