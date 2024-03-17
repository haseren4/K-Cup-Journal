package walkinsilver.example.k_cupjournal;

import android.content.Context;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

public class ViewKCupReviewActivity extends AppCompatActivity {
    Context con;
    KCupDB db;
    KCupDao dao;

    TextView nameTxt, companyTxt, commentsTxt;
    ProgressBar overallPbar, bitternessPBar,flavorPbar, sweetnessPbar;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kcup_list_view_toast_layout);
        int passedID = getIntent().getExtras().getInt("KCUP_ID_INT");
        System.out.println("KCup ID: " + passedID);
        con = getApplicationContext();

        nameTxt = findViewById(R.id.viewNameTbx);
        companyTxt = findViewById(R.id.viewcompanyTxt);
        commentsTxt = findViewById(R.id.viewCommentsTxt);
        overallPbar = findViewById(R.id.viewOverallPbar);
        bitternessPBar = findViewById(R.id.viewBitternessPbar);
        flavorPbar = findViewById(R.id.viewFlavorPBar);
        sweetnessPbar = findViewById(R.id.viewSweetnessPbar);
        ratingBar = findViewById(R.id.viewRatingBar);

        db = Room.databaseBuilder(getApplicationContext(), KCupDB.class, "KCupDatabase").allowMainThreadQueries().build();
        dao = db.kcupDao();

        KCup record = dao.getKCupByID(passedID);

        nameTxt.setText(record.getName());
        companyTxt.setText(record.getCompany());
        commentsTxt.setText(record.getComments());

        overallPbar.setProgress(record.getOverall());
        bitternessPBar.setProgress(record.getBitterness());
        flavorPbar.setProgress(record.getFlavor());
        sweetnessPbar.setProgress(record.getSweetness());

        ratingBar.setRating(record.getRating());
    }
    public void loadKCup(KCup kCup){}
}