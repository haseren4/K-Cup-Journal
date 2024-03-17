package walkinsilver.example.k_cupjournal;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.room.Room;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class KCupListView extends LinearLayout {
    TextView nameTxtVw, companyTxtVw;
    RatingBar ratingBar;
    KCup kCup;
    ImageButton deleteBtn;

    public KCupListView(Context context, KCup kcup) {
        super(context);

        this.kCup = kcup;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.kcup_list_view_layout, this, true);

        nameTxtVw = findViewById(R.id.nameTxt);
        companyTxtVw = findViewById(R.id.companyTxt);
        ratingBar = findViewById(R.id.ratingBar2);
        deleteBtn = findViewById(R.id.imageButton);

        nameTxtVw.setText(kcup.getName());
        companyTxtVw.setText(kcup.getCompany());
        ratingBar.setRating(kcup.getRating());




        this.setOnLongClickListener(l ->{

            Intent viewIntent = new Intent(this.getContext(), ViewKCupReviewActivity.class);
            viewIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Bundle b = new Bundle();
            b.putInt("KCUP_ID_INT", kcup.getId());
            viewIntent.putExtras(b);
            context.startActivity(viewIntent);
            return false;
        });
    }

}
