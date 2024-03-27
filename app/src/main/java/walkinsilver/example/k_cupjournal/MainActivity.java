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
import androidx.room.Room;

import java.util.List;

import walkinsilver.example.k_cupjournal.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    KCupDB db;
    KCupDao dao;
    List<KCup> entries;

    Context con;
    LinearLayout recordContainer;
    FloatingActionButton addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBtn = findViewById(R.id.addBtn);
        recordContainer = findViewById(R.id.recordContainer);

        db = Room.databaseBuilder(getApplicationContext(), KCupDB.class, "KCupDatabase").allowMainThreadQueries().build();
        dao = db.kcupDao();

        con = this.getApplication().getApplicationContext();

        addBtn.setOnClickListener(l ->{
            this.finish();
            Intent addIntent = new Intent(this, AddRecordActivity.class);
            startActivity(addIntent);
        });

   }

    @Override
    protected void onResume() {
        super.onResume();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                loadDatabase();
                addViews();
            }
        });
        t.run();
    }

    private void addViews() {
        recordContainer.removeAllViews();
        for(KCup entry : entries){
            KCupListView v = new KCupListView(con, entry);
            v.deleteBtn.setOnClickListener(l->{
                dao.deleteKCup(v.kCup);
                recordContainer.removeView(v);
            });
            recordContainer.addView(v);
        }
    }

    private void loadDatabase() {
        entries = dao.getAllMainSorted();

        if(entries.isEmpty()){
            System.out.println("Create Bootstrap Item(s)");
            KCup chaiLatte = new KCup(0, "Chai Latte", "Walmart",5,100,100,0,40, "So easy and a great Chai Latte for being at home.");
            dao.insertKCup(chaiLatte);
            entries.add(chaiLatte);
        }

    }

}