package edu.upc.eseiaat.pma.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.security.acl.Group;

import static edu.upc.eseiaat.pma.quiz.R.id.preg;
import static edu.upc.eseiaat.pma.quiz.R.id.res_grup;

public class QuizActivity extends AppCompatActivity {

    private int id_res[]={
        R.id.res1, R.id.res2, R.id.res3, R.id.res4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView pregunta = (TextView) findViewById(R.id.preg);
        pregunta.setText(R.string.s_pregunta);

        String[]array_res = getResources().getStringArray(R.array.res);

        for (int i=0; i<id_res.length; i++){
            RadioButton rb = (RadioButton) findViewById(id_res[i]);
            rb.setText(array_res[i]);
        }
        
        final RadioGroup rg = (RadioGroup) findViewById(R.id.res_grup);
        Button bt = (Button) findViewById (R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int id = rg.getCheckedRadioButtonId();
                int respuesta = -1;
                for (int i=0; i<id_res.length; i++){
                    if (id_res[i] == id){
                        respuesta = i;
                    }
                }
                if (respuesta == 1){
                    Toast.makeText(QuizActivity.this, R.string.correcta, Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(QuizActivity.this, R.string.incorrecta, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
