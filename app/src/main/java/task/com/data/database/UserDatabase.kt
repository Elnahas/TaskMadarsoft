package task.com.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import task.com.data.models.UserModel

@Database(version = 1, entities = [UserModel::class], exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDoa(): UserDao

}