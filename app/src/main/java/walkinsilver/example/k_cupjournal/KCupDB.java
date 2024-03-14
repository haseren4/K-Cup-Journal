package walkinsilver.example.k_cupjournal;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {KCup.class}, version = 1)
public abstract class KCupDB extends RoomDatabase {
    public abstract KCupDao kcupDao();
}
