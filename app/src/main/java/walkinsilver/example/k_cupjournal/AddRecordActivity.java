package walkinsilver.example.k_cupjournal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;


public class AddRecordActivity extends AppCompatActivity {
    Button saveBtn;
    KCupDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_record);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        db = Room.databaseBuilder(getApplicationContext(), KCupDB.class, "KCupDatabase").build();

        KCupDao dao = db.kcupDao();

        saveBtn = findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(l ->{
            validateInputs();
            saveToDatabase();
            System.out.println("Save Button Pressed");
            Intent backIntent = new Intent(this, MainActivity.class);
            this.finish();
            startActivity(backIntent);
        });
    }

    private void validateInputs() {
    }

    private void saveToDatabase() {
    }
}