package com.example.manav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    EditText name,phone,otp;
    Button btn1,btn2;
    FirebaseAuth mAuth;
    String verificationID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      name= findViewById(R.id.a);
      phone=findViewById(R.id.d);
      otp=findViewById(R.id.otp);
      btn1=findViewById(R.id.generate);
      btn2=findViewById(R.id.verify);
      mAuth=FirebaseAuth.getInstance();

      btn1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String number = null;
              if (TextUtils.isEmpty(phone.getText().toString()))
              {
                  Toast.makeText(MainActivity.this, "Enter Valid Phone No.", Toast.LENGTH_SHORT).show();
              }
              else {
                  number = phone.getText().toString();
                  sendverificationcode(number);
              }
          }
      });
      btn2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v)
          {
              if (TextUtils.isEmpty(otp.getText().toString()))
              {
                  Toast.makeText(MainActivity.this, "Wrong OTP Entered", Toast.LENGTH_SHORT).show();
              }
              else
              verifycode(otp.getText().toString());
          }
      });
}

    private void sendverificationcode(String phoneNumber)
    {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+91"+phoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // (optional) Activity for callback binding
                        // If no activity is passed, reCAPTCHA verification can not be used.
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
private PhoneAuthProvider.OnVerificationStateChangedCallbacks
    mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential credential)
        {
            final String code=credential.getSmsCode();
            if (code!=null){
                verifycode();
            }
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(MainActivity.this, "Verification Failed", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCodeSent(@NonNull String s,
                @NonNull PhoneAuthProvider.ForceResendingToken token)
        {
            super.onCodeSent(s, token);
             verificationID=s;
        }
    };

    private void verifycode() {
    }

    private void verifycode(String Code) {PhoneAuthCredential credential=PhoneAuthProvider.getCredential(verificationID,Code);
        signinbyCredentials(credential);
    }

    private void signinbyCredentials(PhoneAuthCredential credential)
    {
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                     if (task.isSuccessful()){
                         Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                         startActivity(new Intent(MainActivity.this, Home.class));
                     }
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser=FirebaseAuth.getInstance().getCurrentUser();
       if(currentUser!=null){
        startActivity(new Intent(MainActivity.this, Home.class));
        finish();
       }
    }
}
//obj.execSQL("CREATE TABLE IF NOT EXISTS books(bid numeric PRIMARY KEY NOT NULL")
