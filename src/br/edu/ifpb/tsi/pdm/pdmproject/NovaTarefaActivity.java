package br.edu.ifpb.tsi.pdm.pdmproject;

import java.util.Calendar;
import java.util.List;

import android.app.Activity;
//import android.content.DialogInterface;
//import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import br.edu.ifpb.tsi.pdm.pdmproject.dao.AtividadeDAO;
import br.edu.ifpb.tsi.pdm.pdmproject.dao.DisciplinaDAO;
import br.edu.ifpb.tsi.pdm.pdmproject.dao.TarefaDAO;
import br.edu.ifpb.tsi.pdm.pdmproject.model.Atividade;
import br.edu.ifpb.tsi.pdm.pdmproject.model.Disciplina;
import br.edu.ifpb.tsi.pdm.pdmproject.model.Tarefa;

public class NovaTarefaActivity extends Activity {
	
	Spinner atividade, disciplina;
	EditText etDataTarefa;
	Button btnCriar;
	Calendar c = Calendar.getInstance();
	int posicaoTarefa;
	
	AtividadeDAO daoAtividade = new AtividadeDAO(this);
	DisciplinaDAO daoDisciplina = new DisciplinaDAO(this);
	TarefaDAO daoTarefa = new TarefaDAO(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nova_tarefa);
		this.carrregaComponentes();
		this.setListeners();
		
		List<Atividade> atividades = daoAtividade.get();
		setSpinnerAtividade(atividade, atividades);

		List<Disciplina> disciplinas = daoDisciplina.get();
		setSpinnerDisciplina(disciplina, disciplinas);
		
		//TODO Setar datas
		//TODO Setar pra ajustar as notificações

	}

	private void carrregaComponentes(){
		this.atividade = (Spinner) findViewById(R.id.spnAtividade);
		this.disciplina = (Spinner) findViewById(R.id.spnDisciplina);
		this.etDataTarefa = (EditText) findViewById(R.id.etDataTarefa);
		this.btnCriar = (Button) findViewById(R.id.btnOkNovaTarefa);
	}
	
	private void setListeners(){
		this.btnCriar.setOnClickListener(new OnClickBotao());
	}
	
	private void setSpinnerAtividade(Spinner spinner, List<Atividade> list){
		
		ArrayAdapter<Atividade> adapterAtividade = new ArrayAdapter<Atividade>(this, android.R.layout.simple_spinner_item, list);
		adapterAtividade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapterAtividade);
		
		spinner.setOnItemSelectedListener(new AtividadeListener());
	}
	
	private void setSpinnerDisciplina(Spinner spinner, List<Disciplina> list){
		
		ArrayAdapter<Disciplina> adapterDisciplina = new ArrayAdapter<Disciplina>(this, android.R.layout.simple_spinner_item, list);
		adapterDisciplina.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapterDisciplina);
		
		spinner.setOnItemSelectedListener(new AtividadeListener());
	}
	
	
	
	public class AtividadeListener implements OnItemSelectedListener {
		@Override
	    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
			posicaoTarefa = pos;
	    }

		@Override
	    public void onNothingSelected(AdapterView parent) {
	       Log.w("tag", "Passou em nothing selected");
	    }
	}
	
	public class OnClickBotao implements OnClickListener{

		@Override
		public void onClick(View v) {
			Atividade atividade = daoAtividade.ler(1);
			Disciplina disciplina = daoDisciplina.ler(1);
			
			c.add(Calendar.DATE, 1);
			Calendar notificacao = Calendar.getInstance();
			notificacao.add(Calendar.MINUTE, 1);
			Tarefa tarefa =  new Tarefa(atividade, disciplina, c, notificacao);
			
			daoTarefa.inserir(tarefa);
			
			//TODO gerar notificação pra data setada.
		}

	}
}
