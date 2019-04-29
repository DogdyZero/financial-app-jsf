package br.com.financial_app.persistency.queries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.financial_app.domain.EntidadeDominio;
import br.com.financial_app.domain.Usuario;

public class UsuarioQuery implements IFactoryQuery {
	private static UsuarioQuery usuarioQuery;
	private Map<String,String> mapQuery;
	private Map<String,List<Object>> mapParameters;
	private Usuario usuario;
	private String tipoConsulta;
	private final String NOME_CLASSE ="Usuario";
	
	private UsuarioQuery(EntidadeDominio entidade) {
		if(entidade.getClass().getSimpleName().equals(NOME_CLASSE)) {
			this.usuario = (Usuario) entidade;
			mapQuery = new HashMap<String,String>();
			mapParameters = new HashMap<String,List<Object>>();
			
			List<Object> listLogin = new ArrayList<Object>();
			mapQuery.put("login", "from Usuario where login = :param1 "
					+ " and senha = :param2");
			listLogin.add(this.usuario.getLogin());
			listLogin.add(this.usuario.getSenha());
			mapParameters.put("login", listLogin);
		}
	}
	public static IFactoryQuery createUsuarioQuery(EntidadeDominio entidade) {
		if(usuarioQuery==null) {
			usuarioQuery = new UsuarioQuery(entidade);
		}
		return usuarioQuery;
	}
	
	@Override
	public String gerarString(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
		return mapQuery.get(tipoConsulta);
	}

	@Override
	public List<Object> retornoParametros() {
		return mapParameters.get(this.tipoConsulta);
	}

}
