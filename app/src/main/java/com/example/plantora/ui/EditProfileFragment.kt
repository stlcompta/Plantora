package com.example.plantora.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.plantora.databinding.ActivityMainBinding
import com.example.plantora.databinding.EditProfileBinding
import com.example.plantora.databinding.FragmentDashboardBinding
import com.example.plantora.ui.dashboard.DashboardViewModel


class EditProfileFragment : Fragment() {

    private var _binding: EditProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val editProfileViewModel =
            ViewModelProvider(this).get(EditProfileViewModel::class.java)

        _binding = EditProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root


//        //BINDING VOIR RECYCLER VIEW ADAPTER ARTIST
//        val textView: TextView = binding.textDashboard
//        dashboardViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


//    private lateinit var binding: EditProfileBinding
//    private lateinit var navController: NavController
//
//    companion object{
//        private const val TAG = "MyActivity"
//    }
//
//
}