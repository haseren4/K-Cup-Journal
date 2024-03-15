package walkinsilver.example.k_cupjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class KCupListView extends LinearLayout {
    TextView nameTxtVw, companyTxtVw;
    RatingBar ratingBar;

    public KCupListView(Context context, KCup kcup) {
        super(context);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.kcup_list_view_layout, this, true);

        nameTxtVw = findViewById(R.id.nameTxt);
        companyTxtVw = findViewById(R.id.companyTxt);
        ratingBar = findViewById(R.id.ratingBar2);

        nameTxtVw.setText(kcup.getName());
        companyTxtVw.setText(kcup.getCompany());
        ratingBar.setRating(kcup.getRating());


        this.setOnClickListener(l ->{

        });
    }

}
