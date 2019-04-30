package br.com.financial_app.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.financial_app.domain.Categoria;
import br.com.financial_app.domain.FormaPagamento;
import br.com.financial_app.domain.TipoTransacao;
import br.com.financial_app.domain.Transacao;

@ManagedBean
@RequestScoped
public class FinanceiroController {
	private String mensagem;
	private Transacao transacao;
	private List<TipoTransacao> tipoTransacao;
	private List<FormaPagamento> formasPagamento;
	private List<Categoria> categorias;

	public FinanceiroController() {
		transacao = new Transacao();
	}
	
	@PostConstruct
	public void init() {
		tipoTransacao = Arrays.asList(TipoTransacao.values());
		formasPagamento = Arrays.asList(FormaPagamento.values());

	}
	
	public void salvar() {
		
	}
	
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Transacao getTransacao() {
		return transacao;
	}
	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}

	public List<TipoTransacao> getTipoTransacao() {
		return tipoTransacao;
	}

	public List<FormaPagamento> getFormasPagamento() {
		return formasPagamento;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	
	
}
