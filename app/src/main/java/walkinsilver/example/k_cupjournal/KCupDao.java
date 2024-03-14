package walkinsilver.example.k_cupjournal;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Upsert;

import java.util.List;

@Dao
public interface KCupDao {
    @Upsert
    void upsertKCup(KCup kcup);

    @Delete
    void deleteKCup(KCup kCup);
    @Query("SELECT * FROM kcup")
    List<KCup> getAll();
}
