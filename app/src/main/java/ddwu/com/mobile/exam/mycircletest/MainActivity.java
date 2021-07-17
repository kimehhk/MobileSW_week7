package ddwu.com.mobile.exam.mycircletest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MyCircle myCircle;
    private int btnColor = R.id.red;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Custom View 객체*/
        myCircle = findViewById(R.id.myCircle);

        registerForContextMenu(myCircle);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.memu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.bigger:
                myCircle.setR(200);
                break;
            case R.id.smaller:
                myCircle.setR(50);
                break;
        }
        myCircle.invalidate();

        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()) {
            case R.id.myCircle :
                menu.setHeaderTitle("Change Color");
                getMenuInflater().inflate(R.menu.menu_context, menu);
                menu.findItem(btnColor).setChecked(true);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        btnColor = item.getItemId();
        switch (btnColor) {
            case R.id.red:
                myCircle.setMyPaint(Color.RED);
                break;
            case R.id.green:
                myCircle.setMyPaint(Color.GREEN);
                break;
            case R.id.blue:
                myCircle.setMyPaint(Color.BLUE);
                break;
        }
        myCircle.invalidate();

        return true;
    }
}
