package walkinsilver.example.k_cupjournal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;


public class AddRecordActivity extends AppCompatActivity {

    EditText nameTbx, companyTbx;
    RatingBar ratingBar;
    SeekBar overallSeek, flavorSeek, bitternessSeek, sweetnessSeek;
    EditText commentTbx;
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

        nameTbx = findViewById(R.id.nameTbx);
        companyTbx = findViewById(R.id.companyTbx);

        ratingBar = findViewById(R.id.ratingBar);

        overallSeek = findViewById(R.id.overallSeek);
        flavorSeek = findViewById(R.id.flavorSeek);
        bitternessSeek = findViewById(R.id.bitternessSeek);
        sweetnessSeek = findViewById(R.id.sweetnessSeek);

        commentTbx = findViewById(R.id.commentTbx);

        db = Room.databaseBuilder(getApplicationContext(), KCupDB.class, "KCupDatabase")
                .allowMainThreadQueries()
                .build();

        KCupDao dao = db.kcupDao();

        saveBtn = findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(l ->{
            System.out.println("Save Button Pressed");

            KCup kCup = new KCup(
                    0,
                    nameTbx.getText().toString(),
                    companyTbx.getText().toString(),
                    ratingBar.getRating(),
                    overallSeek.getProgress(),
                    flavorSeek.getProgress(),
                    bitternessSeek.getProgress(),
                    sweetnessSeek.getProgress(),
                    commentTbx.getText().toString());

            dao.insertKCup(kCup);

            Intent backIntent = new Intent(this, MainActivity.class);
            this.finish();
            startActivity(backIntent);
        });
    }

}