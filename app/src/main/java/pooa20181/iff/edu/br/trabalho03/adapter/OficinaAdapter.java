package pooa20181.iff.edu.br.trabalho03.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import pooa20181.iff.edu.br.trabalho03.R;
import pooa20181.iff.edu.br.trabalho03.model.Oficina;


public class OficinaAdapter extends RecyclerView.Adapter{

    private List<Oficina> oficinas;
    private Context context;
    private static  ClickRecyclerViewListener clickRecyclerViewListener;

    public OficinaAdapter(List<Oficina> oficinas, Context context, ClickRecyclerViewListener clickRecyclerViewListener) {

        this.oficinas = oficinas;
        this.context = context;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_oficina_cv, parent, false);
        OficinaViewHolder oficinaViewHolder = new OficinaViewHolder(view);

        return oficinaViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        OficinaViewHolder oficinaHolder = (OficinaViewHolder) viewHolder;
        Oficina oficina = this.oficinas.get(position);

        oficinaHolder.nomeOficina.setText(oficina.getNome());
        oficinaHolder.ruaOficina.setText(oficina.getRua());

        oficinaHolder.txtNomeOficina.setText("Nome da Oficina: ");
        oficinaHolder.txtruaOficina.setText("Nome da Rua: ");

    }

    @Override
    public int getItemCount() {
        return oficinas.size();
    }

    public class OficinaViewHolder extends RecyclerView.ViewHolder{

        private final TextView nomeOficina;
        private final TextView ruaOficina;


        private final TextView txtNomeOficina;
        private final TextView txtruaOficina;


        public OficinaViewHolder(View itemView){
            super(itemView);

            nomeOficina = (TextView) itemView.findViewById(R.id.tvNomeOficina);
            ruaOficina = (TextView) itemView.findViewById(R.id.tvruaOficina);


            txtNomeOficina = (TextView) itemView.findViewById(R.id.textNomeOficina);
            txtruaOficina = (TextView) itemView.findViewById(R.id.textruaOficina);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(oficinas.get(getLayoutPosition()));
                }
            });
        }
    }

}
