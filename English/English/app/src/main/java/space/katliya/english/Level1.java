package space.katliya.english;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
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

import java.util.logging.Level;

public class Level1 extends AppCompatActivity {

    Dialog dialog;
    public int i = 0, j = 0, k = 0;
    public String answer1;
    public int count = 0;
    Array array = new Array();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);
        //Скругление краёв картинки
        final ImageView img1 = (ImageView) findViewById(R.id.img1);
        img1.setClipToOutline(true);
        final ImageView img2 = (ImageView) findViewById(R.id.img2);
        img2.setClipToOutline(true);
        final ImageView img3 = (ImageView) findViewById(R.id.img3);
        img3.setClipToOutline(true);
        final ImageView img4 = (ImageView) findViewById(R.id.img4);
        img4.setClipToOutline(true);
        //

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Вызов диалогового окна
        dialog = new Dialog(this); // Создаём окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // Скрываем заголовок
        dialog.setContentView(R.layout.ball); // путь
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон окна
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setCancelable(false);

        //Крестик
        TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level1.this, GameMain.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e){

                }
                dialog.dismiss();
            }
        });
        //
        // Продолжить
        Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level1.this, Level2.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e){

                }
                dialog.dismiss();
            }
        });
        //

        // Кнопка назад
        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level1.this, GameMain.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });

        final ImageView imgd = (ImageView) dialog.findViewById(R.id.dialogimg);

        final int[] progress = {R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,};

        // Подключаем анимацию
        final Animation a = AnimationUtils.loadAnimation(Level1.this, R.anim.alpha);

        final TextView text_1 = findViewById(R.id.text_1);
        final TextView text_2 = findViewById(R.id.text_2);
        final TextView text_3 = findViewById(R.id.text_3);
        final TextView text_4 = findViewById(R.id.text_4);
        final TextView vopros = findViewById(R.id.vopros);

        final String[] answer = new String[]{"girl", "book", "boy", "man", "woman",};

        //1 уровень
        final int[] aq = new int[5];

        answer1 = answer[j];
        img1.setImageResource(array.image1[i]);
        text_1.setText(array.text1[i]);
        img2.setImageResource(array.image1[i + 1]);
        text_2.setText(array.text1[i + 1]);
        img3.setImageResource(array.image1[i + 2]);
        text_3.setText(array.text1[i + 2]);
        img4.setImageResource(array.image1[i + 3]);
        text_4.setText(array.text1[i + 3]);

        vopros.setText(array.vopros[j]);
        // 1 картинка
        img1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                // Условие касания картинки
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // Коснулся картинки
                    String text1 = new String(text_1.getText().toString());
                    if (text1.equals(answer1)) {
                        img1.setImageResource(R.drawable.yes);
                        count = 1;
                        k++;
                    } else {
                        img1.setImageResource(R.drawable.no);
                        count = 0;
                    }

                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    // Отпустил палец
                    //Опредляем правильные и неправильные ответы и закрашиваем
                    aq[j] = count;
                    for (int i = 0; i <= j; i++) {
                        if (aq[i] == 1) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        } else {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_red);
                        }
                    }
                    if (j == 4) {
                        imgd.setImageResource(array.dialog[k]);
                        dialog.show();
                    }else {
                        i += 4;
                        j++;
                        answer1 = answer[j];
                        img1.setImageResource(array.image1[i]);
                        text_1.setText(array.text1[i]);
                        img2.setImageResource(array.image1[i + 1]);
                        text_2.setText(array.text1[i + 1]);
                        img3.setImageResource(array.image1[i + 2]);
                        text_3.setText(array.text1[i + 2]);
                        img4.setImageResource(array.image1[i + 3]);
                        text_4.setText(array.text1[i + 3]);
                        vopros.setText(array.vopros[j]);
                    }
                }
                return true;
            }
        });

        // 2 картинка
        img2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                // Условие касания картинки
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // Коснулся картинки
                    String text2 = new String(text_2.getText().toString());
                    if (text2.equals(answer1)) {
                        img2.setImageResource(R.drawable.yes);
                        count = 1;
                        k++;
                    } else {
                        img2.setImageResource(R.drawable.no);
                        count = 0;
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    // Отпустил палец
                    //Опредляем правильные и неправильные ответы и закрашиваем
                    aq[j] = count;
                    for (int i = 0; i <= j; i++) {
                        if (aq[i] == 1) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        } else {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_red);
                        }
                    }
                    if (j == 4) {
                        imgd.setImageResource(array.dialog[k]);
                        dialog.show();
                    }else {
                        i += 4;
                        j++;
                        answer1 = answer[j];
                        img1.setImageResource(array.image1[i]);
                        text_1.setText(array.text1[i]);
                        img2.setImageResource(array.image1[i + 1]);
                        text_2.setText(array.text1[i + 1]);
                        img3.setImageResource(array.image1[i + 2]);
                        text_3.setText(array.text1[i + 2]);
                        img4.setImageResource(array.image1[i + 3]);
                        text_4.setText(array.text1[i + 3]);
                        vopros.setText(array.vopros[j]);
                    }
                }
                return true;
            }
        });

        // 3 картинка
        img3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                // Условие касания картинки
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // Коснулся картинки
                    String text3 = new String(text_3.getText().toString());
                    if (text3.equals(answer1)) {
                        img3.setImageResource(R.drawable.yes);
                        count = 1;
                        k++;
                    } else {
                        img3.setImageResource(R.drawable.no);
                        count = 0;
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    // Отпустил палец
                    //Опредляем правильные и неправильные ответы и закрашиваем
                    aq[j] = count;
                    for (int i = 0; i <= j; i++) {
                        if (aq[i] == 1) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        } else {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_red);
                        }
                    }
                    if (j == 4) {
                        imgd.setImageResource(array.dialog[k]);
                        dialog.show();
                    }else {
                        i += 4;
                        j++;
                        answer1 = answer[j];
                        img1.setImageResource(array.image1[i]);
                        text_1.setText(array.text1[i]);
                        img2.setImageResource(array.image1[i + 1]);
                        text_2.setText(array.text1[i + 1]);
                        img3.setImageResource(array.image1[i + 2]);
                        text_3.setText(array.text1[i + 2]);
                        img4.setImageResource(array.image1[i + 3]);
                        text_4.setText(array.text1[i + 3]);
                        vopros.setText(array.vopros[j]);
                    }
                }
                return true;
            }
        });

        // 4 картинка
        img4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                // Условие касания картинки
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // Коснулся картинки
                    String text4 = new String(text_4.getText().toString());
                    if (text4.equals(answer[0])) {
                        img4.setImageResource(R.drawable.yes);
                        count = 1;
                        k++;
                    } else {
                        img4.setImageResource(R.drawable.no);
                        count = 0;
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    // Отпустил палец
                    //Опредляем правильные и неправильные ответы и закрашиваем
                    aq[j] = count;
                    for (int i = 0; i <= j; i++) {
                        if (aq[i] == 1) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        } else {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_red);
                        }
                    }
                    if (j == 4) {
                        imgd.setImageResource(array.dialog[k]);
                        dialog.show();
                    }else{
                        i += 4;
                        j++;
                        answer1 = answer[j];
                        img1.setImageResource(array.image1[i]);
                        text_1.setText(array.text1[i]);
                        img2.setImageResource(array.image1[i + 1]);
                        text_2.setText(array.text1[i + 1]);
                        img3.setImageResource(array.image1[i + 2]);
                        text_3.setText(array.text1[i + 2]);
                        img4.setImageResource(array.image1[i + 3]);
                        text_4.setText(array.text1[i + 3]);
                        vopros.setText(array.vopros[j]);
                    }
                }
                return true;
            }
        });
    }

    //Системная кнопка назад
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Level1.this, GameMain.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
    }
}