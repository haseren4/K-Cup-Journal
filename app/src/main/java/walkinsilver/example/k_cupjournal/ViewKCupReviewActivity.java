package walkinsilver.example.k_cupjournal;

import android.content.Context;
import android.content.Intent;
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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ViewKCupReviewActivity extends AppCompatActivity {
    Context con;
    KCupDB db;
    KCupDao dao;

    FloatingActionButton sharingFAB;
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
        sharingFAB = findViewById(R.id.sharingFAB);

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

        sharingFAB.setOnClickListener(l -> {
            shareReviewDetails();
        });
    }
    public void loadKCup(KCup kCup){}
    private void shareReviewDetails() {
        String shareText = "K-Cup Details:\n" +
                "Title: " + nameTxt.getText().toString() + "\n" +
                "By: " + companyTxt.getText().toString() +"\n" +
                "Rating: " + ratingBar.getRating() +"/" + ratingBar.getNumStars() + "\n" +
                "Overall Score: " + overallPbar.getProgress() + "\n" +
                "Bitterness: " + bitternessPBar.getProgress() + "\n"+
                "Flavor: " + flavorPbar.getProgress() + "\n"+
                "Sweetness: "+ sweetnessPbar.getProgress() +"\n\n"+

                "Comments: \n" + commentsTxt.getText();


        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);

        startActivity(Intent.createChooser(shareIntent, "Share Vacation Details"));
    }
}