package br.edu.ifpb.tsi.pdm.pdmproject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.DatePickerDialog;
//import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import br.edu.ifpb.tsi.pdm.pdmproject.dao.AtividadeDAO;
import br.edu.ifpb.tsi.pdm.pdmproject.dao.DisciplinaDAO;
import br.edu.ifpb.tsi.pdm.pdmproject.model.Atividade;
import br.edu.ifpb.tsi.pdm.pdmproject.model.Disciplina;

public class NovaTarefaActivity extends Activity {
	
	Spinner atividade, disciplina;
	EditText etDataTarefa;
	Calendar c = Calendar.getInstance();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nova_tarefa);
		this.carrregaComponentes();

		AtividadeDAO daoAtividade = new AtividadeDAO(this);
		DisciplinaDAO daoDisciplina = new DisciplinaDAO(this);
		
		List<String> stringAtividade = new ArrayList<String>();
		for (Atividade a : daoAtividade.get()){
			stringAtividade.add(a.getNome());
		}
		
		ArrayAdapter<String> adapterAtividade = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, stringAtividade);
		adapterAtividade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.atividade.setAdapter(adapterAtividade);
		
		List<String> stringDisciplina = new ArrayList<String>();
		for (Disciplina d : daoDisciplina.get()){
			stringDisciplina.add(d.getNome());
		}
		
		ArrayAdapter<String> adapterDisciplina = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, stringDisciplina);
		adapterDisciplina.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.disciplina.setAdapter(adapterDisciplina);

	}
	
	private void carrregaComponentes(){
		this.atividade = (Spinner) findViewById(R.id.spnAtividade);
		this.disciplina = (Spinner) findViewById(R.id.spnDisciplina);
		this.etDataTarefa = (EditText) findViewById(R.id.etDataTarefa);
	}
	
}
