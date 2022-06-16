package com.example.plantora

import OnePostAdaptor
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.plantora.data.classes.Post
import com.example.plantora.databinding.FragmentPostDetails4Binding
import com.example.plantora.ui.home.HomeViewModel


class PostDetailsFragment : Fragment() {
    private var _binding: FragmentPostDetails4Binding?= null

    private val binding get() = _binding!!
    var postsArray2 = ArrayList<Post>()

    lateinit var adapter: OnePostAdaptor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true);
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentPostDetails4Binding.inflate(inflater, container, false)
        val root: View = binding.root


        var title :String = arguments?.get("titre").toString()
        var id : String = arguments?.get("id").toString()


        (activity as AppCompatActivity).supportActionBar?.title = title


        return root
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}