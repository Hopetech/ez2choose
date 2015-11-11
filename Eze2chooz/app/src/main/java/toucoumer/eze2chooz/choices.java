package toucoumer.eze2chooz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class choices extends AppCompatActivity {

    private final static String EXTRA_CHOICES = "user_choices";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices);

        final EditText choice1 = (EditText) findViewById(R.id.editTextChoice1);
        final EditText choice2 = (EditText) findViewById(R.id.editTextChoice2);
        final EditText choice3 = (EditText) findViewById(R.id.editTextChoice3);
        final EditText choice4 = (EditText) findViewById(R.id.editTextChoice4);
        final EditText choice5 = (EditText) findViewById(R.id.editTextChoice5);

        // Hide EditText if EditText below isn't fill
        choice2.setVisibility(View.INVISIBLE);
        choice3.setVisibility(View.INVISIBLE);
        choice4.setVisibility(View.INVISIBLE);
        choice5.setVisibility(View.INVISIBLE);

        choice1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (!choice1.getText().toString().equals("")) {
                    choice2.setVisibility(View.VISIBLE);
                    return false;
                } else {
                    return true;
                }
            }
        });
        choice2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (!choice2.getText().toString().equals("")) {
                    choice3.setVisibility(View.VISIBLE);
                    return false;
                } else {
                    return true;
                }
            }
        });
        choice3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ( !choice3.getText().toString().equals("") ) {
                    choice4.setVisibility(View.VISIBLE);
                    return false;
                }
                else {
                    return true;
                }
            }
        });
        choice4.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ( !choice4.getText().toString().equals("") ) {
                    choice5.setVisibility(View.VISIBLE);
                    return false;
                }
                else {
                    return true;
                }
            }
        });

        final ImageButton ButtonGoNext = (ImageButton) findViewById(R.id.imageButtonNext);
        ButtonGoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] Choices = {
                        choice1.getText().toString(),
                        choice2.getText().toString(),
                        choice3.getText().toString(),
                        choice4.getText().toString(),
                        choice5.getText().toString()
                };
                Intent intent = new Intent(choices.this, shake.class);
                intent.putExtra(EXTRA_CHOICES, Choices);

                // Check that the two first editText are fill
                if (choice1.getText().toString().equals("") || choice2.getText().toString().equals("")) {
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.activity_custom__toast,
                            (ViewGroup) findViewById(R.id.toast_layout_root));

                    TextView text = (TextView) layout.findViewById(R.id.text);
                    text.setText(R.string.Error_nb_choices);

                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();
                    return;
                }
                startActivity(intent);
            }
        });

        final ImageButton ButtonGoHome = (ImageButton) findViewById(R.id.imageButtonHome);
        ButtonGoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choices.this, home.class);
                startActivity(intent);
            }
        });

    }
}
