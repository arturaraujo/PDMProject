package br.edu.ifpb.tsi.pdm.pdmproject;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.edu.ifpb.tsi.pdm.pdmproject.dao.TarefaDAO;
import br.edu.ifpb.tsi.pdm.pdmproject.model.Atividade;
import br.edu.ifpb.tsi.pdm.pdmproject.model.Disciplina;
import br.edu.ifpb.tsi.pdm.pdmproject.model.Tarefa;

public class MainActivity extends Activity {

	private ListView lvProximasTarefas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.carregaComponentes();
		
		TarefaDAO daoTarefa = new TarefaDAO(this);
		Atividade atividade = new Atividade("Prova");
		Disciplina disciplina = new Disciplina("PDM");
		
		daoTarefa.inserir(new Tarefa(atividade, disciplina, Calendar.getInstance(), Calendar.getInstance()));
		
		ArrayAdapter<Tarefa> adapter = new ArrayAdapter<Tarefa>(this, android.R.layout.simple_list_item_1, daoTarefa.get());
		this.lvProximasTarefas.setAdapter(adapter);
	}

	private void carregaComponentes() {
		this.lvProximasTarefas = (ListView) findViewById(R.id.lvProximasTarefas);
		
		this.lvProximasTarefas.setOnItemClickListener(new OnAtividadeListener());
	}

	public class OnAtividadeListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Log.d("tag", position + "  " + id);
			
		}

	}
}
