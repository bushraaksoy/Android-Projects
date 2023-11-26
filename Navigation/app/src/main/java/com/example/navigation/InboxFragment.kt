package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navigation.databinding.FragmentInboxBinding

class InboxFragment : Fragment() {
    private lateinit var binding: FragmentInboxBinding
    private val emailRepository = EmailRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInboxBinding.inflate(inflater, container, false)
        val rootView = binding.root

        val data = emailRepository.getEmails()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = RecyclerViewAdapter(data) { _: EmailDataModel ->
            findNavController().navigate(R.id.action_inboxActivity_to_moviesActivity)
        }
        binding.recyclerView.adapter = adapter

        return rootView
    }
}