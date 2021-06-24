package task.com.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import task.com.data.models.UserModel
import task.com.data.repository.UserRepository

class UserViewModel @ViewModelInject constructor(val userRepository: UserRepository) : ViewModel() {


    private val getDataLiveData = userRepository.getAllData()

    val users = MediatorLiveData<List<UserModel>>()


    init {
        users.addSource(getDataLiveData) { result ->
            result?.let { users.value = it }
        }
    }

    fun insertData(userModel: UserModel) = viewModelScope.launch {
        userRepository.insertData(userModel)
    }
}