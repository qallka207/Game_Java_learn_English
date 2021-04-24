package space.katliya.english;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Level3 extends AppCompatActivity {

    public int count = 0;
    Dialog dialog;
    int k = 0;
    Array array = new Array();
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button_next = (Button) findViewById(R.id.button_next1);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level3.this, Main2.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });

        final TextView text1 = (TextView)findViewById(R.id.text1);
        final TextView text2 = (TextView)findViewById(R.id.text2);
        final TextView text3 = (TextView)findViewById(R.id.text3);
        final TextView text4 = (TextView)findViewById(R.id.text4);
        final TextView text5 = (TextView)findViewById(R.id.text5);

        text1.setText(array.vopros3[0]);
        text2.setText(array.vopros3[1]);
        text3.setText(array.vopros3[2]);
        text4.setText(array.vopros3[3]);
        text5.setText(array.vopros3[4]);

        final ImageView img1 = (ImageView) findViewById(R.id.imag31);
        final ImageView img2 = (ImageView) findViewById(R.id.imag32);
        final ImageView img3 = (ImageView) findViewById(R.id.imag33);
        final ImageView img4 = (ImageView) findViewById(R.id.imag34);
        final ImageView img5 = (ImageView) findViewById(R.id.imag35);

        final RadioButton rb1 = (RadioButton) findViewById(R.id.r11);
        final RadioButton rb2 = (RadioButton) findViewById(R.id.r21);
        final RadioButton rb3 = (RadioButton) findViewById(R.id.r31);
        final RadioButton rb4 = (RadioButton) findViewById(R.id.r41);
        final RadioButton rb5 = (RadioButton) findViewById(R.id.r51);
        final RadioButton rb11 = (RadioButton) findViewById(R.id.r12);
        final RadioButton rb21 = (RadioButton) findViewById(R.id.r22);
        final RadioButton rb31 = (RadioButton) findViewById(R.id.r32);
        final RadioButton rb41 = (RadioButton) findViewById(R.id.r42);
        final RadioButton rb51 = (RadioButton) findViewById(R.id.r52);

        final int[] progress = {R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,};
        final ImageView imgdialog = (ImageView) findViewById(R.id.dialogimg);

        final boolean[] ok = new boolean[] {true, false, false, true, false};

        Button button_proverka = (Button) findViewById(R.id.btnproverka);

        button_proverka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if ((rb1.isChecked() || rb11.isChecked()) && (rb2.isChecked() || rb21.isChecked())
                            && (rb3.isChecked() || rb31.isChecked()) && (rb4.isChecked() || rb41.isChecked())
                            && (rb5.isChecked() || rb51.isChecked())) {
                        if (rb1.isChecked() == ok[0]) {
                            img1.setImageResource(R.drawable.yes);
                        } else {
                            img1.setImageResource(R.drawable.no);
                        }

                        if (rb2.isChecked() == ok[1]) {
                            img2.setImageResource(R.drawable.yes);
                        } else {
                            img2.setImageResource(R.drawable.no);
                        }
                        if (rb3.isChecked() == ok[2]) {
                            img3.setImageResource(R.drawable.yes);
                        } else {
                            img3.setImageResource(R.drawable.no);
                        }
                        if (rb4.isChecked() == ok[3]) {
                            img4.setImageResource(R.drawable.yes);
                        } else {
                            img4.setImageResource(R.drawable.no);
                        }
                        if (rb5.isChecked() == ok[4]) {
                            img5.setImageResource(R.drawable.yes);
                        } else {
                            img5.setImageResource(R.drawable.no);
                        }
                    } else {
                        backToast = Toast.makeText(getBaseContext(), "Заполните все поля", Toast.LENGTH_SHORT);
                        backToast.show();
                    }

                } catch (Exception e) {

                }
            }
        });
    }

    //Системная кнопка назад
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Level3.this, GameMain.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
    }
}