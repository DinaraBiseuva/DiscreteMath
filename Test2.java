package space.bisseuva.discretemath;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Test2 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogend;
    public boolean answer_top;


    public int question_first_level;
    Array array = new Array();
    Random random = new Random();
    public int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        TextView text_levels = findViewById(R.id.textView28);
        text_levels.setText(R.string.Logic);


        final TextView question = findViewById(R.id.textView29);
        final ImageView img_top = (ImageView)findViewById(R.id.imageView5);
        final ImageView img_second = (ImageView)findViewById(R.id.imageView3);
        final ImageView img_choose = (ImageView)findViewById(R.id.imageView6);


        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.pretest);
        dialog.setCancelable(false);

        //меняем уровни здесь
        TextView topic = (TextView)dialog.findViewById(R.id.textView18);
        topic.setText(R.string.Compound);

        TextView answer_text = findViewById(R.id.textView30);
        answer_text.setText(R.string.answer1_2);
        TextView answer_text1 = findViewById(R.id.textView31);
        answer_text1.setText(R.string.answer2_2);



        Button button_back = (Button)dialog.findViewById(R.id.button18);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Test2.this, Lecture.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
                dialog.dismiss();
            }
        });
        Button button_lecture = (Button)dialog.findViewById(R.id.button10);
        button_lecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Test2.this, Lecture.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
                dialog.dismiss();
            }
        });

        Button button_start = (Button)dialog.findViewById(R.id.button2);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    dialog.dismiss();
                }catch (Exception e){

                }

            }
        });
        dialog.show();

        //___________________________________________start

        dialogend = new Dialog(this);
        dialogend.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogend.setContentView(R.layout.successfull);
        dialogend.setCancelable(false);





        Button button_back_2 = (Button)dialogend.findViewById(R.id.button18);
        button_back_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Test2.this, Levels.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
                dialogend.dismiss();
            }
        });
        Button button_restart = (Button)dialogend.findViewById(R.id.button10);
        button_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Test2.this, Lecture.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
                dialogend.dismiss();
            }
        });

        Button button_good = (Button)dialogend.findViewById(R.id.button2);
        button_good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Test2.this, Lecture2.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
                dialogend.dismiss();
            }
        });


        //___________________________________________end








        Button button_back_to_menu = (Button)findViewById(R.id.button4);
        button_back_to_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Test2.this, Levels.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        final int[] progress = {
                R.id.textView32, R.id.textView33,R.id.textView34,
        };

        final Animation a = AnimationUtils.loadAnimation(Test2.this, R.anim.alpha);


        question_first_level = 0;

        question.setText(array.questions1_2[question_first_level]);
        //fdbnlfdbmd
        answer_top = array.answers_top[question_first_level];
        //boolean answer_second = array.answers_top[question_first_level];
        //dfbdbd





        img_top.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //условие касания картинки начало
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //если коснулся картинки начало
                    img_second.setEnabled(false);
                    if (answer_top) {
                        img_top.setImageResource(R.drawable.correct);
                    } else {
                        img_top.setImageResource(R.drawable.incorrect);
                    }
                    //Если коснулся картинки конец
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    //если отпустил палец начало
                    if (answer_top) {
                        //если верхняя правильная
                        if (count < 3) {
                            count++;
                        }
                        img_top.setImageResource(R.drawable.answer1);
                        //закрашиваем прогресс серым цветом начало
                        for (int i = 0; i < 3; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс серым цветом конец
                        //определяем правильные ответы и закрашиваем зеленым-начало
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_done);
                        }
                        //определяем правильные ответы и закрашиваем зеленым-конец
                        //МЕНЯЕМ ВОПРОС!!!
                    } else {
                        //если верхняя не правильная
                        if(count>0){
                            if(count==1){
                                count=0;
                            }else{
                                count=count-2;
                            }
                        }
                        //закрашиваем прогресс серым цветом начало
                        for (int i = 0; i < 3; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс серым цветом конец
                        //определяем правильные ответы и закрашиваем зеленым-начало
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_done);
                        }
                        //определяем правильные ответы и закрашиваем зеленым-конец
                        //МЕНЯЕМ ВОПРОС!!!
                    }
//если отпустил палец кон
                    if(count==3){
                        //выход
                        dialogend.show();
                    } else{
                        if(question_first_level<2){
                            question_first_level=question_first_level+1;
                        }else {
                            if(question_first_level==2){
                                question_first_level=0;
                            }
                        }
                        question.setText(array.questions1_2[question_first_level]);
                        answer_top = array.answers_top[question_first_level];
                        img_top.startAnimation(a);
                        //boolean answer_second = array.answers_top[question_first_level];
                        //img_top.startAnimation(a);
                        img_top.setImageResource(R.drawable.answer1);

                        img_second.setEnabled(true);
                    }

                }
                //условие касания картинки конец
                return true;
            }
        });

        //second
        img_second.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //условие касания картинки начало
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //если коснулся картинки начало
                    img_top.setEnabled(false);//----------------------------
                    if (!answer_top) {
                        img_second.setImageResource(R.drawable.correct);
                    } else {
                        img_second.setImageResource(R.drawable.incorrect);
                    }
                    //Если коснулся картинки конец
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    //если отпустил палец начало
                    if (!answer_top) {
                        //если нижняя правильная
                        if (count < 3) {
                            count++;
                        }
                        img_second.setImageResource(R.drawable.answer1);
                        //закрашиваем прогресс серым цветом начало
                        for (int i = 0; i < 3; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс серым цветом конец
                        //определяем правильные ответы и закрашиваем зеленым-начало
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_done);
                        }
                        //определяем правильные ответы и закрашиваем зеленым-конец
                        //МЕНЯЕМ ВОПРОС!!!
                    } else {
                        //если нижняя не правильная
                        if(count>0){
                            if(count==1){
                                count=0;
                            }else{
                                count=count-2;
                            }
                        }
                        //закрашиваем прогресс серым цветом начало
                        for (int i = 0; i < 3; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс серым цветом конец
                        //определяем правильные ответы и закрашиваем зеленым-начало
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_done);
                        }
                        //определяем правильные ответы и закрашиваем зеленым-конец
                        //МЕНЯЕМ ВОПРОС!!!
                    }
//если отпустил палец кон
                    if(count==3){
                        //выход
                        dialogend.show();
                    } else{
                        if(question_first_level<2){
                            question_first_level ++;
                        }else{
                            question_first_level=0;
                        }
                        question.setText(array.questions1_2[question_first_level]);
                        answer_top = array.answers_top[question_first_level];
                        //img_second.startAnimation(a);
                        //boolean answer_second = array.answers_top[question_first_level];
                        //img_second.startAnimation(a);
                        img_second.setImageResource(R.drawable.answer1);


                        img_top.setEnabled(true);//------------------------------------------
                    }

                }
                //условие касания картинки конец
                return true;
            }
        });




    }

    @Override
    public void onBackPressed() {
        try{
            Intent intent = new Intent(Test2.this, Levels.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }

    }

}
