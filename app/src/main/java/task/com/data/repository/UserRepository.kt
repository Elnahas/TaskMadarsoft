package task.com.data.repository

import task.com.data.database.UserDao
import task.com.data.models.UserModel
import javax.inject.Inject

class UserRepository @Inject constructor(val userDao: UserDao) {

    fun getAllData()  = userDao.getAllData()

    suspend fun insertData(userModel: UserModel) = userDao.insertData(userModel)


}