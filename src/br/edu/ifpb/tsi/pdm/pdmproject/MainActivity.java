package br.edu.ifpb.tsi.pdm.pdmproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView lvProximasTarefas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.carregaComponentes();
		
		

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
