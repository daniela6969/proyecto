package edu.galileo.android.moviemanager.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import edu.galileo.android.moviemanager.R;

public class LoginActivity extends AppCompatActivity {

    private EditText mUsuario, mContraseña;
    private Button btnIngresar, btnRecuperar, btnRegistrar;
    private TextView tv;
    private static String usuario = "admin";
    private static String contraseña = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsuario = (EditText) findViewById(R.id.usuario);
        mContraseña = (EditText) findViewById(R.id.contraseña);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnRecuperar = (Button) findViewById(R.id.btnRecuperar);
        btnRegistrar     = (Button) findViewById(R.id.btnNuevo);
        tv = (TextView) findViewById(R.id.titulo);

        Typeface fuente = Typeface.createFromAsset(getAssets(),"fonts/Good Unicorn - TTF.ttf");
        tv.setTypeface(fuente);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RecuperarActivity.class);
                startActivity(intent);
            }
        });


        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"Ups.. aun no creo la ventana :v",Toast.LENGTH_SHORT).show();
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mUsuario.getText().toString().trim().length() == 0 &&
                mContraseña.getText().toString().length() == 0){
                    Toast.makeText(LoginActivity.this,"Ups.. los campos estan vacios",Toast.LENGTH_SHORT).show();

                }else {

                    if(mUsuario.getText().toString().trim().equals(usuario) &&
                            mContraseña.getText().toString().trim().equals(contraseña)){
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);

                    }else {
                        Toast.makeText(LoginActivity.this,"Los campos son incorrecto",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
