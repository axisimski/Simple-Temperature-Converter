package axisimski.tempconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    RadioButton c2f;
    RadioButton f2c;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c2f=(RadioButton)findViewById(R.id.c2f);
        f2c=(RadioButton)findViewById(R.id.f2c);
        input=(EditText)findViewById(R.id.input);
    }

    public void convert(View v){


        double num =0;

        if(input.getText().toString().equals("")) {
            input.setError("Enter temperature");
        }

        else{

           num=Double.valueOf (input.getText().toString());

           if(c2f.isChecked()){
               if(num<-273.15){
                   input.setError("The temperature you've entered is below absolute zero");
               }
               else{
                   num = TempConv.c2f(num);
               }

           }
           else if(f2c.isChecked()){

               if(num<-459.67){
                   input.setError("The temperature you've entered is below absolute zero");
               }

               else{
                   num=TempConv.f2c(num);
               }

           }

           input.setText(Double.toString(num));
        }
    }

}
