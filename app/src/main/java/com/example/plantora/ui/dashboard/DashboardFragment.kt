package com.example.plantora.ui.dashboard


import PostAdaptor
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.plantora.AddPostActivity
import com.example.plantora.MainActivity
import com.example.plantora.R
import com.example.plantora.data.classes.AppDatabase
import com.example.plantora.data.classes.Post
import com.example.plantora.databinding.FragmentDashboardBinding
import com.example.plantora.ui.home.HomeViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    var postsArray = ArrayList<Post>()
    lateinit var adapter: PostAdaptor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        var db : AppDatabase = AppDatabase(requireContext())

        _binding!!.itemAdd.setOnClickListener{
            val intent = Intent (getActivity(), AddPostActivity::class.java)
               getActivity()?.startActivity(intent)
        }


        var listMyPosts : ListView
        listMyPosts = binding.listMyPosts

        postsArray = db.findPosts()
        var adapter = this.parentFragment?.context?.let { PostAdaptor(it, R.layout.recycler_item_mesplantes,postsArray) }
        listMyPosts.adapter = adapter


        registerForContextMenu(listMyPosts)



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}