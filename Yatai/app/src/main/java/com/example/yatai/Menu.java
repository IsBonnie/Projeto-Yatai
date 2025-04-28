package com.example.yatai;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.List;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Agora sim: inicializa o RecyclerView e seus dados AQUI dentro!
        RecyclerView rvCategories = findViewById(R.id.rvCategories);

        List<Prato> entradas = Arrays.asList(
                new Prato("Gyoza", R.drawable.gyoza),
                new Prato("Harumaki", R.drawable.harumaki),
                new Prato("Shumai", R.drawable.shumai),
                new Prato("Oniguiri", R.drawable.oniguiri)
        );

        List<Prato> yakissobas = Arrays.asList(
                new Prato("Yakissoba da Casa", R.drawable.yakissoba_casa),
                new Prato("Yakissoba de Frango", R.drawable.yakissoba_frango),
                new Prato("Sossusoba", R.drawable.sossusoba),
                new Prato("Yakissoba Frutos do Mar", R.drawable.yakissoba_mar)
        );

        List<Categoria> categorias = Arrays.asList(
                new Categoria("Entradas", entradas),
                new Categoria("Yakissoba", yakissobas)
        );

        CategoriaAdapter categoriaAdapter = new CategoriaAdapter(categorias);
        rvCategories.setLayoutManager(new LinearLayoutManager(this));
        rvCategories.setAdapter(categoriaAdapter);
    }

    // ----------------- Classes internas --------------------

    // Prato.java
    public class Prato {
        private String nome;
        private int imagemResId; // ID da imagem no drawable

        public Prato(String nome, int imagemResId) {
            this.nome = nome;
            this.imagemResId = imagemResId;
        }

        public String getNome() {
            return nome;
        }

        public int getImagemResId() {
            return imagemResId;
        }
    }

    // Categoria.java
    public class Categoria {
        private String titulo;
        private List<Prato> pratos;

        public Categoria(String titulo, List<Prato> pratos) {
            this.titulo = titulo;
            this.pratos = pratos;
        }

        public String getTitulo() {
            return titulo;
        }

        public List<Prato> getPratos() {
            return pratos;
        }
    }

    // Adapter dos pratos
    public class PratoAdapter extends RecyclerView.Adapter<PratoAdapter.PratoViewHolder> {

        private List<Prato> pratos;

        public PratoAdapter(List<Prato> pratos) {
            this.pratos = pratos;
        }

        @NonNull
        @Override
        public PratoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prato, parent, false);
            return new PratoViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PratoViewHolder holder, int position) {
            Prato prato = pratos.get(position);
            holder.tvNome.setText(prato.getNome());
            holder.ivImagem.setImageResource(prato.getImagemResId());
        }

        @Override
        public int getItemCount() {
            return pratos.size();
        }

        static class PratoViewHolder extends RecyclerView.ViewHolder {
            ImageView ivImagem;
            TextView tvNome;

            PratoViewHolder(@NonNull View itemView) {
                super(itemView);
                ivImagem = itemView.findViewById(R.id.ivImagemPrato);
                tvNome = itemView.findViewById(R.id.tvNomePrato);
            }
        }
    }

    // Adapter das categorias
    public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder> {

        private List<Categoria> categorias;

        public CategoriaAdapter(List<Categoria> categorias) {
            this.categorias = categorias;
        }

        @NonNull

        @Override
        public void onBindViewHolder(@NonNull CategoriaViewHolder holder, int position) {
            Categoria categoria = categorias.get(position);
            holder.tvTitulo.setText(categoria.getTitulo());

            // Configura o RecyclerView dos pratos dentro de cada categoria
            holder.rvPratos.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
            holder.rvPratos.setAdapter(new PratoAdapter(categoria.getPratos()));
        }

        @Override
        public int getItemCount() {
            return categorias.size();
        }

        static class CategoriaViewHolder extends RecyclerView.ViewHolder {
            TextView tvTitulo;
            RecyclerView rvPratos;

            CategoriaViewHolder(@NonNull View itemView) {
                super(itemView);
                tvTitulo = itemView.findViewById(R.id.tvTituloCategoria);
                rvPratos = itemView.findViewById(R.id.rvPratos);
            }
        }
    }
}
