package space.bisseuva.discretemath;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Levels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levels);



        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button_back_to_menu = (Button)findViewById(R.id.button5);
        button_back_to_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Levels.this, Menu.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        Button button_test_1_1 = (Button)findViewById(R.id.button6);
        button_test_1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Levels.this, Lecture.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        Button button_test_1_2 = (Button)findViewById(R.id.button7);
        button_test_1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Levels.this, Lecture2.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });
    }



}
