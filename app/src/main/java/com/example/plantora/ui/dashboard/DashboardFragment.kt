package com.example.plantora.ui.dashboard


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.plantora.AddPostActivity
import com.example.plantora.MainActivity
import com.example.plantora.R
import com.example.plantora.databinding.FragmentDashboardBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!





    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        _binding!!.itemAdd.setOnClickListener{
            val intent = Intent (getActivity(), AddPostActivity::class.java)
               getActivity()?.startActivity(intent)
        }





//        //BINDING VOIR RECYCLER VIEW ADAPTER ARTIST
//        val textView: TextView = binding.textDashboard
//        dashboardViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
       return root
    }

//    override fun onOptionsItemSelected(item: FloatingActionButton): Boolean {
//        when(item.it){
//           R.id.itemAdd -> {
//               val intent = Intent (getActivity(), AddPostActivity::class.java)
//               getActivity()?.startActivity(intent)
////               val intent = Intent(MainActivity, AddPostActivity::class.java)
////               startActivity(intent)
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}