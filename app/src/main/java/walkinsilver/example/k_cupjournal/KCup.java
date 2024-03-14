package walkinsilver.example.k_cupjournal;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import javax.annotation.processing.Generated;

@Entity(tableName = "kcup")
public class KCup {

    @PrimaryKey@Generated(value = "auto")
    private int id;
    @ColumnInfo(name= "name")
    private String name;
    @ColumnInfo(name = "company")
    private String company;
    @ColumnInfo(name = "rating")
    private int rating;
    @ColumnInfo(name = "overall")
    private int overall;
    @ColumnInfo(name = "flavor")
    private int flavor;
    @ColumnInfo(name = "bitterness")
    private int bitterness;
    @ColumnInfo(name = "sweetness")
    private int sweetness;
    @ColumnInfo(name = "comments")
    private String comments;

    public KCup(int id, String name, String company, int rating, int overall, int flavor, int bitterness, int sweetness, String comments) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.rating = rating;
        this.overall = overall;
        this.flavor = flavor;
        this.bitterness = bitterness;
        this.sweetness = sweetness;
        this.comments = comments;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getOverall() {
        return overall;
    }

    public void setOverall(int overall) {
        this.overall = overall;
    }

    public int getFlavor() {
        return flavor;
    }

    public void setFlavor(int flavor) {
        this.flavor = flavor;
    }

    public int getBitterness() {
        return bitterness;
    }

    public void setBitterness(int bitterness) {
        this.bitterness = bitterness;
    }

    public int getSweetness() {
        return sweetness;
    }

    public void setSweetness(int sweetness) {
        this.sweetness = sweetness;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
