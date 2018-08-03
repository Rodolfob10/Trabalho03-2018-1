package pooa20181.iff.edu.br.trabalho03.actvity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import pooa20181.iff.edu.br.trabalho03.adapter.ClickRecyclerViewListener;
import pooa20181.iff.edu.br.trabalho03.R;
import pooa20181.iff.edu.br.trabalho03.adapter.MecanicoAdapter;
import io.realm.Realm;
import pooa20181.iff.edu.br.trabalho03.model.Mecanico;


public class ListaMecanico extends AppCompatActivity implements ClickRecyclerViewListener {

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mecanico);

        realm = Realm.getDefaultInstance();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaMecanico.this, MecanicoDetalhe.class);
                intent.putExtra("id", 0);
                startActivity(intent);
            }
        });
    }

    public void onResume()
    {
        super.onResume();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvMecanicos);
        recyclerView.setAdapter(new MecanicoAdapter(getMecanico(), this, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onClick(Object object) {
        Mecanico mecanico = (Mecanico) object;
        Intent intent = new Intent( ListaMecanico.this, MecanicoDetalhe.class);
        intent.putExtra("id", mecanico.getId());
        startActivity(intent);
    }

    public void finish(){
        super.finish();
        realm.close();
    }

    public List<Mecanico> getMecanico() {
        return (List) realm.where(Mecanico.class).findAll();
    }
}