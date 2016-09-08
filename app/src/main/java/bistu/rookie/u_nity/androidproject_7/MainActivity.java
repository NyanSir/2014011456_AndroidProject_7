package bistu.rookie.u_nity.androidproject_7;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button alertButton = (Button) findViewById(R.id.AlertButton);
        Button loginButton = (Button) findViewById(R.id.LoginButton);

        alertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Alert Dialog").setTitle("Alert!!!");

                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Confirm", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNeutralButton("Ignore", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Ignore", Toast.LENGTH_SHORT).show();
                    }

                });

                builder.show();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View v = inflater.inflate(R.layout.login_layout, null);
                final EditText editId = (EditText) v.findViewById(R.id.UserId);
                final EditText editPassword = (EditText) v.findViewById(R.id.Password);

                builder.setView(v)
                        .setTitle("Login")
                        .setPositiveButton("Sign In", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                String inputId = editId.getText().toString();
                                String inputPassword = editPassword.getText().toString();
                                if (inputId.equals("abc") && inputPassword.equals("123"))
                                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                                else
                                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.show();
            }
        });


    }
}
