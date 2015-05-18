package example.hideorviewpassword;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {

    private EditText passwordET;
    private boolean isPasswordShown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        passwordET = (EditText) findViewById(R.id.passwordET);
        passwordET.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_RIGHT = 2;
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (passwordET.getRight() - passwordET.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        if(isPasswordShown) {
                            isPasswordShown = false;
                            passwordET.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.eye_icon, 0);
                            passwordET.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        }
                        else {
                            isPasswordShown = true;
                            passwordET.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.eye_visible_icon, 0);
                            passwordET.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                        }
                        passwordET.setSelection(passwordET.getText().length());
                    }
                }
                return false;
            }
        });
    }
}
