package task.com.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_user")
data class UserModel(
    var userName: String,
    var age: Int,
    var jobTitle: String,
    var gender: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}