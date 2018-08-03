package pooa20181.iff.edu.br.trabalho03.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import pooa20181.iff.edu.br.trabalho03.R;
import pooa20181.iff.edu.br.trabalho03.model.Mecanico;


public class MecanicoAdapter extends RecyclerView.Adapter{

    private List<Mecanico> mecanicos;
    private Context context;
    private static  ClickRecyclerViewListener clickRecyclerViewListener;

    public MecanicoAdapter(List<Mecanico> mecanicos, Context context, ClickRecyclerViewListener clickRecyclerViewListener) {

        this.mecanicos = mecanicos;
        this.context = context;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_mecanico_cv, parent, false);
        MecanicoViewHolder mecanicoViewHolder = new MecanicoViewHolder(view);

        return mecanicoViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        MecanicoViewHolder mecanicoHolder = (MecanicoViewHolder) viewHolder;
        Mecanico mecanico = this.mecanicos.get(position);

        mecanicoHolder.nomeMecanico.setText(mecanico.getNome());
        mecanicoHolder.funcaoMecanico.setText(mecanico.getFuncao());

        mecanicoHolder.txtNomeMecanico.setText("Nome do Mecanico: ");
        mecanicoHolder.txtfuncaoMecanico.setText("Nome da Função: ");

    }

    @Override
    public int getItemCount() {
        return mecanicos.size();
    }

    public class MecanicoViewHolder extends RecyclerView.ViewHolder{

        private final TextView nomeMecanico;
        private final TextView funcaoMecanico;


        private final TextView txtNomeMecanico;
        private final TextView txtfuncaoMecanico;


        public MecanicoViewHolder(View itemView){
            super(itemView);

            nomeMecanico = (TextView) itemView.findViewById(R.id.tvNomeMecanico);
            funcaoMecanico = (TextView) itemView.findViewById(R.id.tvfuncaoMecanico);


            txtNomeMecanico = (TextView) itemView.findViewById(R.id.textNomeMecanico);
            txtfuncaoMecanico = (TextView) itemView.findViewById(R.id.textfuncaoMecanico);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(mecanicos.get(getLayoutPosition()));
                }
            });
        }
    }

}
