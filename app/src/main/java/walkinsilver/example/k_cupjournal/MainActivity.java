package walkinsilver.example.k_cupjournal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import walkinsilver.example.k_cupjournal.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    LinearLayout recordContainer;
    FloatingActionButton addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBtn = findViewById(R.id.addBtn);
        recordContainer = findViewById(R.id.recordContainer);

        Context con = this.getApplication().getApplicationContext();

        loadDatabase();
        addViews();
        
        addBtn.setOnClickListener(l ->{
            TextView tv = new TextView(con);
            tv.setText(R.string.lorem_ipsum_title);
            recordContainer.addView(tv);
            this.finish();
            Intent addIntent = new Intent(this, AddRecordActivity.class);
            startActivity(addIntent);
        });

   }

    private void addViews() {
    }

    private void loadDatabase() {
    }

}