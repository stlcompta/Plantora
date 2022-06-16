package com.example.plantora.ui.home

import PostAdaptor
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.plantora.AddPostActivity
import com.example.plantora.R
import com.example.plantora.data.classes.AppDatabase
import com.example.plantora.data.classes.Post
import com.example.plantora.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

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
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome


        var db : AppDatabase = AppDatabase(requireContext())

        _binding!!.itemAdd.setOnClickListener{
            val intent = Intent (getActivity(), AddPostActivity::class.java)
            getActivity()?.startActivity(intent)
        }
        var listPosts : ListView
        listPosts = binding.listPosts

        postsArray = db.findPosts()
        var adapter = this.parentFragment?.context?.let { PostAdaptor(it, R.layout.recycler_item_accueil,postsArray) }
        listPosts.adapter = adapter


        listPosts.setOnItemClickListener{ adapterView, view, position, id ->
            val clickedPost = postsArray[position]
            val args = bundleOf("titre" to clickedPost.title.toString(),"id" to clickedPost.pid)
            val navController = parentFragment?.findNavController()
            navController?.navigate(R.id.action_navigation_home_to_postDetailsFragment,args)

        }

        registerForContextMenu(listPosts)

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}