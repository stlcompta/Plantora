package com.example.plantora.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.plantora.MainActivity
import com.example.plantora.MainActivity.Companion.txtMail
import com.example.plantora.R
import com.example.plantora.databinding.EditProfileBinding
import com.google.android.material.textfield.TextInputLayout


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

        (activity as AppCompatActivity).supportActionBar?.title = "Modifier mes données"


        val mail = binding.username2
        val error2 = binding.error2
        val buttonLogout = binding.buttonLogout
        val username2 = binding.username2

        val layoutUser: TextInputLayout


        _binding!!.buttonLogout.setOnClickListener {
            txtMail = mail.text.toString()
            MainActivity.email = txtMail


            if (txtMail.trim().isEmpty()) {
                error2.text = "Veuillez remplir l'adresse mail"
                error2.visibility = View.VISIBLE
            } else {
                MainActivity.email = txtMail
                Navigation.findNavController(requireView()).navigate(R.id.action_editProfileFragment_to_navigation_notifications)
            }
        }

        return root
    }

//    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        getSupportActionBar().setTitle("Hello world App");
//    }

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
