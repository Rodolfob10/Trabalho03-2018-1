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
import pooa20181.iff.edu.br.trabalho03.adapter.OficinaAdapter;
import pooa20181.iff.edu.br.trabalho03.model.Oficina;
import io.realm.Realm;


public class ListaOficina extends AppCompatActivity implements ClickRecyclerViewListener {

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_oficinas);

        realm = Realm.getDefaultInstance();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaOficina.this, OficinaDetalhe.class);
                intent.putExtra("id", 0);
                startActivity(intent);
            }
        });
    }

    public void onResume()
    {
        super.onResume();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvOficinas);
        recyclerView.setAdapter(new OficinaAdapter(getOficinas(), this, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onClick(Object object) {
        Oficina oficina = (Oficina) object;
        Intent intent = new Intent( ListaOficina.this, OficinaDetalhe.class);
        intent.putExtra("id", oficina.getId());
        startActivity(intent);
    }

    public void finish(){
        super.finish();
        realm.close();
    }

    public List<Oficina> getOficinas() {
        return (List) realm.where(Oficina.class).findAll();
    }
}