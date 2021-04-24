package space.katliya.english;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Main3 extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStart = (Button)findViewById(R.id.buttonStart);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Main3.this, GameMain3.class);
                    startActivity(intent); finish();
                }catch (Exception e){

                }
            }
        });

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final ImageView img = (ImageView) findViewById(R.id.osnova);
        img.setImageResource(R.drawable.eda);

        final TextView txt = (TextView) findViewById(R.id.textView);
        txt.setText(R.string.eat);
    }
    //Системная кнопка назад
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Main3.this, Main2.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
    }
}