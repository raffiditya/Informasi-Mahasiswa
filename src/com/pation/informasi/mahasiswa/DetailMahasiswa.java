package com.pation.informasi.mahasiswa;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class DetailMahasiswa extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
          return;
        }
        String strNama = extras.getString("nama");
        String strNpm = extras.getString("npm");
        if (strNama != null && strNpm != null) {
          TextView txtNama = (TextView) findViewById(R.id.txtViewNama);
          TextView txtNpm = (TextView) findViewById(R.id.txtViewNPM);
          txtNama.setText("Nama "+strNama);
          txtNpm.setText("NPM "+strNpm);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_detail_mahasiswa, menu);
        return true;
    }
    
    public void onClick(View view) {
    	finish();
    }
    
    @Override
    public void finish() {
    	Intent data = new Intent();
        // Return some hard-coded values
        data.putExtra("inputlagi", "Terimakasih, silahkan input data lagi");
        setResult(RESULT_OK, data);
        super.finish();
    }
}
