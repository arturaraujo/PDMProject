package br.edu.ifpb.tsi.pdm.pdmproject;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import br.edu.ifpb.tsi.pdm.pdmproject.dao.AtividadeDAO;
import br.edu.ifpb.tsi.pdm.pdmproject.dao.TarefaDAO;
import br.edu.ifpb.tsi.pdm.pdmproject.model.Atividade;

public class NovaTarefaActivity extends Activity {
	
	Spinner spinnerTarefa;
	
//	TarefaDAO daoTarefa = new TarefaDAO(this);
	AtividadeDAO daoAtividade = new AtividadeDAO(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nova_tarefa);
		this.carrregaComponentes();
		
		List<Atividade> atividades = daoAtividade.get();
		
		ArrayAdapter<Atividade> adapter = new ArrayAdapter<Atividade>(this, 1, atividades);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerTarefa.setAdapter(adapter);
	}
	
	private void carrregaComponentes(){
		this.spinnerTarefa = (Spinner) findViewById(R.id.spnTarefa);
	}
}
