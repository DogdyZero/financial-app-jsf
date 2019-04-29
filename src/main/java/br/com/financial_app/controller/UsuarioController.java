package br.com.financial_app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.financial_app.domain.EntidadeDominio;
import br.com.financial_app.domain.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioController {
	private Usuario usuario ;
	private String mensagem;
	private final String primeiroAcesso = "primeiro acesso";

	public UsuarioController() {
		this.usuario = new Usuario();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void logar() {
		this.mensagem =null;
		Facede facede = Facede.getInstance(usuario);
		List<EntidadeDominio> resultado = facede.listaEntidades(this.usuario, "login");
		if(resultado !=null){
			try {
				this.usuario = (Usuario)resultado.get(0);
				FacesContext.getCurrentInstance().getExternalContext().
					getSessionMap().put("usuario", this.usuario);
				this.mensagem ="Login Efetuado com sucesso!";
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");

			}
			catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.mensagem ="Os dados não conferem!";
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		

	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
	
	
