package e.pramu.sejarahkota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class detailKota extends AppCompatActivity {
private TextView deskripsi;
private ImageView imgKota;
private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kota);
        deskripsi = findViewById(R.id.deskripsi_detail);
        imgKota = findViewById(R.id.imgKotaDetail);


        int getImage = getIntent().getExtras().getInt("PhotoKota");
        String getDesk = getIntent().getExtras().getString("DetailKota");

        imgKota.setImageResource(getImage);
        deskripsi.setText(getDesk);

    }
}
