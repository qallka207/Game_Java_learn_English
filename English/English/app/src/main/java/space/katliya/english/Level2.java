package space.katliya.english;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Level2 extends AppCompatActivity {

    public int count = 0, i = 0, j = 0, k = 0;
    Array array = new Array();
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);

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
                    Intent intent = new Intent(Level2.this, GameMain.class);
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
                    Intent intent = new Intent(Level2.this, Level3.class);
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
                    Intent intent = new Intent(Level2.this, GameMain.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });

        final ImageView img1 = (ImageView) findViewById(R.id.lv2img);
        final int[] progress = {R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,};
        final ImageView imgd = (ImageView) dialog.findViewById(R.id.dialogimg);

        // Подключаем анимацию
        final Animation a = AnimationUtils.loadAnimation(Level2.this, R.anim.alpha);

        final TextView text_1 = findViewById(R.id.bukva1);
        final TextView text_2 = findViewById(R.id.bukva2);
        final TextView text_3 = findViewById(R.id.bukva3);

        img1.setImageResource(array.image2[i]);
        text_1.setText(array.bukva1[i]);
        text_3.setText(array.bukva3[i]);
        final String[] answer = new String[]{"a", "u", "e", "o", "o",};
        final int[] aq = new int[5];
        // Ввод буквы
        text_2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String bukva2 = text_2.getText().toString();
                    if (bukva2.equals(answer[i])){
                        count = 1;
                        k++;
                    }
                    else {
                        count = 0;
                    }
                    return true;
                }
                aq[i] = count;
                for (int i = 0; i <= j; i++) {
                    if (aq[i] == 1) {
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                    } else {
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.style_points_red);
                    }
                }
                if (i == 4){
                    imgd.setImageResource(array.dialog[k]);
                    dialog.show();
                }
                else {
                    i++;
                    j++;
                    text_2.setText("");
                    img1.setImageResource(array.image2[i]);
                    text_1.setText(array.bukva1[i]);
                    text_3.setText(array.bukva3[i]);
                }
                return false;
            }
        });

    }
    //Системная кнопка назад
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Level2.this, GameMain.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
    }
}