package space.katliya.english;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GameMain3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamethemain);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(GameMain3.this, Main2.class);
                    startActivity(intent); finish();
                }catch (Exception e){

                }
            }
        });

        Button level1 = (Button)findViewById(R.id.level1);
        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(GameMain3.this, Level7.class);
                    startActivity(intent); finish();
                }catch (Exception e){

                }
            }
        });

        Button level2 = (Button)findViewById(R.id.level2);
        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(GameMain3.this, Level8.class);
                    startActivity(intent); finish();
                }catch (Exception e){

                }
            }
        });

        Button level3 = (Button)findViewById(R.id.level3);
        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(GameMain3.this, Level9.class);
                    startActivity(intent); finish();
                }catch (Exception e){

                }
            }
        });

        Button next = (Button)findViewById(R.id.button_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(GameMain3.this, Main4.class);
                    startActivity(intent); finish();
                }catch (Exception e){

                }
            }
        });
    }
    //?????????????????? ???????????? ??????????
    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(GameMain3.this, Main2.class);
            startActivity(intent); finish();
        }catch (Exception e){

        }
    }
}