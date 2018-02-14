package axisimski.tempconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioButton c2f;
    RadioButton f2c;
    EditText input;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c2f=(RadioButton)findViewById(R.id.c2f);
        f2c=(RadioButton)findViewById(R.id.f2c);
        input=(EditText)findViewById(R.id.input);
        output=(TextView)findViewById(R.id.output);
    }

    public void convert(View v){


        long num =0;

        if(input.getText().toString().equals("")) {
            input.setError("Enter temperature");
        }

        else if(Long.valueOf (input.getText().toString())>1000000000000L) {
            input.setError("Please enter a temperature less than 1,000,000,000,000 C°/F°");
        }


        else{

           StringBuilder TS= new StringBuilder();
           num=Long.valueOf (input.getText().toString());

           if(!c2f.isChecked()&&!f2c.isChecked()){
               input.setError("Please select F° → C° or C° → F°");
           }

           if(c2f.isChecked()){
               if(num<-273.15){
                   input.setError("The temperature you've entered is below absolute zero");
               }
               else{

                   num = TempConv.c2f(num);
                   TS.append(Long.toString(num)+" F°");
               }

           }
           else if(f2c.isChecked()){

               if(num<-459.67){
                   input.setError("The temperature you've entered is below absolute zero");
               }

               else{
                   num=TempConv.f2c(num);
                   TS.append(Long.toString(num)+" C°");
               }

           }

           output.setText(TS);

        }
    }

}
