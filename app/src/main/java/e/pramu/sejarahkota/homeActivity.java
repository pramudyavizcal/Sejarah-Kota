package e.pramu.sejarahkota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.bumptech.glide.load.engine.Resource;

import java.util.ArrayList;

public class homeActivity extends AppCompatActivity {
    private RecyclerView rvKota;
    private ArrayList<Kota> list = new ArrayList<>();
    ListKotaAdapter LK;
    ImageButton profil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        profil = findViewById(R.id.profil);
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeActivity.this,profilActivity.class));
            }
        });

        rvKota = findViewById(R.id.rv_kota);
        rvKota.setHasFixedSize(true);

        list.addAll(DataKota.getListData());
        showRecyclerList();

    }

    private void showRecyclerList() {
        LK = new ListKotaAdapter(this,list);
        rvKota.setLayoutManager(new LinearLayoutManager(this));
        rvKota.setAdapter(LK);
    }


    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are You Sure Want to Exit?")
                .setCancelable(true)//tidak bisa tekan tombol back
                //jika pilih yess
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        moveTaskToBack(true);
                        finish();
                    }
                })
                //jika pilih no
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }
}
