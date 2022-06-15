package com.example.plantora.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.plantora.AddPostActivity
import com.example.plantora.MainActivity
import com.example.plantora.R
import com.example.plantora.databinding.FragmentNotificationsBinding
import com.example.plantora.ui.EditProfileFragment

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val textView: TextView = binding.tvMail
//        notificationsViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        _binding!!.editProfileButton.setOnClickListener{view ->
            //view.findNavController().navigate(R.id.EditProfileFragment)
            Navigation.findNavController(view).navigate(R.id.action_navigation_notifications_to_editProfileFragment)
        }

//        _binding!!.editProfileButton.setOnClickListener{
//            val intent = Intent (getActivity(), EditProfileFragment::class.java)
//            getActivity()?.startActivity(intent)
//        }
//        var email = MainActivity.email
//        _binding!!.tvMail.text = email




        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}