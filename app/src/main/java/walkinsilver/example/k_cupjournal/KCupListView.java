package walkinsilver.example.k_cupjournal;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

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


        this.setOnLongClickListener(l ->{
            LayoutInflater toast_inflater = (LayoutInflater)  context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.kcup_list_view_toast_layout,
                    (ViewGroup) findViewById(R.id.layout));

            Toast toast = new Toast(context);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setDuration(Toast.LENGTH_LONG);

            toast.setView(layout);
            toast.show();
            return false;
        });
    }

}
