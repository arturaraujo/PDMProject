package br.edu.ifpb.tsi.pdm.pdmproject;

import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import br.edu.ifpb.tsi.pdm.pdmproject.dao.AtividadeDAO;
import br.edu.ifpb.tsi.pdm.pdmproject.dao.DisciplinaDAO;
import br.edu.ifpb.tsi.pdm.pdmproject.model.Atividade;
import br.edu.ifpb.tsi.pdm.pdmproject.model.Disciplina;

public class NovaTarefaActivity extends Activity {
	
	Spinner atividade, disciplina;
	EditText etDataTarefa;
	Button btnCriar;
	Calendar c = Calendar.getInstance();
	int posicaoTarefa;
	
	AtividadeDAO daoAtividade = new AtividadeDAO(this);
	DisciplinaDAO daoDisciplina = new DisciplinaDAO(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nova_tarefa);
		this.carrregaComponentes();
		
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
}
