package mikiponix.io.l4ssns;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class toukou extends AppCompatActivity {

    EditText titleText;
    EditText contentText;
    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toukou);

        titleText = (EditText) findViewById(R.id.title_text);
        contentText = (EditText) findViewById(R.id.content_text);
        sendButton = (Button) findViewById(R.id.send_button);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Toast.makeText(toukou.this, "追加！！", Toast.LENGTH_SHORT).show();
            }
        });
    }
}