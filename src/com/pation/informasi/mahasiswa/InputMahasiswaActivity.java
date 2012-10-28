package com.pation.informasi.mahasiswa;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InputMahasiswaActivity extends Activity {
	private static final int REQUEST_CODE = 10;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_mahasiswa);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_input_mahasiswa, menu);
        return true;
    }
    
    public void onClick(View view) {
        switch (view.getId()) {
		case R.id.btnKirim:
			EditText editNama = (EditText) findViewById(R.id.editTxtNama);
			EditText editNPM = (EditText) findViewById(R.id.editTxtNPM);
			Intent i = new Intent(this, DetailMahasiswa.class);
	        i.putExtra("nama", editNama.getText().toString());
	        i.putExtra("npm", editNPM.getText().toString());
	        // Kirim informasi dari edittext ke activity detail
	        startActivityForResult(i, REQUEST_CODE);
			break;
		default:
			break;
		}
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
    		if (data.hasExtra("inputlagi")) {
    			Toast.makeText(this, data.getExtras().getString("inputlagi"),
    	            Toast.LENGTH_SHORT).show();
    	      }
    	 }
    }
}
