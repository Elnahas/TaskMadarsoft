package task.com.ui.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_list.*
import task.com.R
import task.com.adapter.UserAdapter
import task.com.ui.viewmodel.UserViewModel


@AndroidEntryPoint
class ListFragment : Fragment(R.layout.fragment_list) {

    val viewModel : UserViewModel by viewModels()
    lateinit var userAdapter: UserAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        fab.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        viewModel.users.observe(viewLifecycleOwner, Observer {

            userAdapter.submitList(it)
        })
    }

    private fun setupRecyclerView() = recyclerView.apply {
        userAdapter = UserAdapter()
        adapter = userAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }

}