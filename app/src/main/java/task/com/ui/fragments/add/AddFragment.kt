package task.com.ui.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_add.*
import task.com.R
import task.com.data.models.Gender
import task.com.data.models.UserModel
import task.com.ui.viewmodel.UserViewModel

@AndroidEntryPoint
class AddFragment : Fragment(R.layout.fragment_add) {

    val viewModel: UserViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_save.setOnClickListener {

            val userName = input_user_name.text.toString()
            val age = input_user_age.text.toString()
            val jobTitle = input_job_title.text.toString()
            val gender = if (radioMale.isChecked) Gender.MALE else Gender.FEMALE


            if (validation(userName, age, jobTitle)) {

                viewModel.insertData(UserModel(userName, age.toInt(), jobTitle, gender.name))
                Toast.makeText(requireContext(), "Data saved", Toast.LENGTH_SHORT).show()

                input_user_name.setText("")
                input_user_age.setText("")
                input_job_title.setText("")

            } else
                Toast.makeText(requireContext(), "Fields are required", Toast.LENGTH_SHORT).show()


        }
    }

    private fun validation(userName: String, age: String, jobTitle: String): Boolean {

        return !(userName.isEmpty() || age.isEmpty() || jobTitle.isEmpty())
    }

}