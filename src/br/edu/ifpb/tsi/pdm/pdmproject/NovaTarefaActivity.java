package br.edu.ifpb.tsi.pdm.pdmproject;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import br.edu.ifpb.tsi.pdm.pdmproject.dao.AtividadeDAO;
import br.edu.ifpb.tsi.pdm.pdmproject.model.Atividade;

public class NovaTarefaActivity extends Activity {
	
	Spinner atividade;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		TarefaDAO daoTarefa = new TarefaDAO(this);
		AtividadeDAO daoAtividade = new AtividadeDAO(this);
		
		setContentView(R.layout.activity_nova_tarefa);
		this.carrregaComponentes();
		
		List<String> string = new ArrayList<String>();
		for (Atividade a : daoAtividade.get()){
			string.add(a.getNome());
		}
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, string);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.atividade.setAdapter(adapter);
		
	
	}
	
	private void carrregaComponentes(){
		this.atividade = (Spinner) findViewById(R.id.spnAtividade);
	}
}
