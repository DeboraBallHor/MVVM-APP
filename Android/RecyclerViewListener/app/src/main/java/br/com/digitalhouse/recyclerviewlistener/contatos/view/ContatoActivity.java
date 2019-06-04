package br.com.digitalhouse.recyclerviewlistener.contatos.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.recyclerviewlistener.R;
import br.com.digitalhouse.recyclerviewlistener.contatos.RecyclerViewClickListener;
import br.com.digitalhouse.recyclerviewlistener.contatos.adapters.RecyclerViewContatosAdapter;
import br.com.digitalhouse.recyclerviewlistener.contatos.model.Contato;

public class ContatoActivity extends AppCompatActivity implements RecyclerViewClickListener {

    //Atributos
    private RecyclerView recyclerView;
    private RecyclerViewContatosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Inicializamos as views
        recyclerView = findViewById(R.id.recyclerViewContatos);

        // Adiciona o layout manager ao recyclerview
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Adiciona o adapter ao recyclerview
        adapter = new RecyclerViewContatosAdapter(getContatos(), this);
        recyclerView.setAdapter(adapter);

    }

    // REtorna lista de contatos para recycleriew
    private List<Contato> getContatos() {
        List<Contato> contatos = new ArrayList<>();
        contatos.add(new Contato("Tairo", "11-91111-1111", R.drawable.trasformers));
        contatos.add(new Contato("Jessica", "11-91111-1111", R.drawable.android));
        contatos.add(new Contato("Jair", "11-91111-1111", R.drawable.trasformers));
        contatos.add(new Contato("Vinicius", "11-91111-1111", R.drawable.android));
        contatos.add(new Contato("Eduardo", "11-91111-1111", R.drawable.trasformers));
        contatos.add(new Contato("Ivan", "11-91111-1111", R.drawable.android));

        return contatos;
    }

    // Método para escutar evento de click em recyclerview
    @Override
    public void onClick(Contato contato) {
        Intent intent = new Intent(this, DetalheContatoActivity.class);
        intent.putExtra("CONTATO", contato);
        startActivity(intent);
    }
}
