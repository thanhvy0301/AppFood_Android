package com.example.doanngocthanhvy_19dh110622;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {

    Button buttonSignUp,buttonSignIn;
    EditText editTextEmail,editTextPassword;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        //getSupportActionBar().hide();
        buttonSignUp=findViewById(R.id.btnSignUp);
        buttonSignIn=findViewById(R.id.btnSignIn);
        editTextEmail=findViewById(R.id.email);
        editTextPassword=findViewById(R.id.password);

        firebaseAuth=FirebaseAuth.getInstance();
        Intent i=getIntent();


        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                boolean test=true;
                if (editTextEmail.getText().toString().isEmpty())
                {
                    editTextEmail.setError("Vui lòng nhập dữ liệu!!!");
                    test=false;
                }
                if (editTextPassword.getText().toString().isEmpty())
                {
                    editTextPassword.setError("Vui lòng nhập dữ liệu!!!");
                    test=false;
                }
                if (test==true) {
                    DangNhap();
                }
            }
        });



        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignInActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
    private void DangNhap()
    {
        firebaseAuth.signInWithEmailAndPassword(editTextEmail.getText().toString(),editTextPassword.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Intent intent=new Intent(SignInActivity.this,MainActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            editTextEmail.setError("Tài khoản không tồn tại!!!");
                            editTextPassword.setText("");
                        }

                    }
                });
    }
}