package space.bisseuva.discretemath;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Lecture2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lecture);



        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageView lecturetext = findViewById(R.id.imageView4);
        lecturetext.setImageResource(R.drawable.lecture2);


        Button buttonStart = (Button)findViewById(R.id.button2);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Lecture2.this, Test2.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        Button button_back_to_menu = (Button)findViewById(R.id.button5);
        button_back_to_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Lecture2.this, Levels.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });
    }
}
