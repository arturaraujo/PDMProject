package br.edu.ifpb.tsi.pdm.pdmproject.model;

import java.util.Calendar;

public class Tarefa {
	private int id;
	private Atividade atividade;
	private Disciplina disciplina;
	private Calendar dataHora;
	private Calendar dataHoraNotificacao;

	public Calendar getDataHoraNotificacao() {
		return dataHoraNotificacao;
	}

	public void setDataHoraNotificacao(Calendar dataHoraNotificacao) {
		this.dataHoraNotificacao = dataHoraNotificacao;
	}
	
	public void setDataHoraNotificacao(long dataHoraNotificacao) {
		this.dataHoraNotificacao = Calendar.getInstance();
		this.dataHoraNotificacao.setTimeInMillis(dataHoraNotificacao);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Calendar getDataHora() {
		return dataHora;
	}

	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}
	
	public void setDataHora(long dataHora) {
		this.dataHora = Calendar.getInstance();
		this.dataHora.setTimeInMillis(dataHora);
	}
	

}
