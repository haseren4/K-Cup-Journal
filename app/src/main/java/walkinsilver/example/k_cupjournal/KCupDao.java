package walkinsilver.example.k_cupjournal;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface KCupDao {
    @Insert
    void insertKCup(KCup kcup);

    @Delete
    void deleteKCup(KCup kCup);
    @Query("SELECT * FROM kcup")
    List<KCup> getAll();
    @Query("SELECT * FROM kcup WHERE id = :id")
    KCup getKCupByID(int id);

    @Query("SELECT * FROM kcup ORDER BY company, rating, name")
    List<KCup> getAllMainSorted();
}
