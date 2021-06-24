package task.com.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import task.com.data.models.UserModel

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(userModel: UserModel)

    @Query("SELECT * FROM tb_user")
    fun getAllData() : LiveData<List<UserModel>>

}