package br.com.financial_app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.financial_app.domain.Categoria;
import br.com.financial_app.domain.EntidadeDominio;
import br.com.financial_app.domain.FormaPagamento;
import br.com.financial_app.domain.TipoTransacao;
import br.com.financial_app.domain.Transacao;

@ManagedBean
@RequestScoped
public class FinanceiroController {
	private String mensagem;
	private Transacao transacao;
	private List<Transacao> transacoes;
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
		
		atualizarTransacoes();

	}
	private void atualizarTransacoes() {
		Transacao t = new Transacao();
		Facede facede = Facede.getInstance(t);
		List<EntidadeDominio> resultado = facede.listaEntidades(t, "diaria");
		
		if(resultado!=null) {
			if(transacoes== null) {
				transacoes = new ArrayList<Transacao>();
			}
			for (EntidadeDominio entidade : resultado) {
				Transacao transacao = (Transacao) entidade;
				transacoes.add(transacao);
			}
		}
	}
	
	public void salvar() {
		this.mensagem =  null;
		Facede facede = Facede.getInstance(this.transacao);
		String resultado = facede.salvar(this.transacao);
		if(resultado == null) {
			this.mensagem = "Transação salva com sucesso ! ";
		} else {
			this.mensagem = "Ocorreu um erro no cadastro, verifique as informações e tente novamente! ";

		}
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

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	
	
	
}
