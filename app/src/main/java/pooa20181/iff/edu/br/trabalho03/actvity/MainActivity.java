package pooa20181.iff.edu.br.trabalho03.actvity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import  pooa20181.iff.edu.br.trabalho03.R;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private String[] activities = {"ListaOficina"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, activities);
        ListView listView = findViewById(R.id.listaMenu);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent = null;
        try {
            Class obj = Class.forName("pooa20181.iff.edu.br.trabalho03.actvity." + activities[position]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        startActivity(intent);
    }
}