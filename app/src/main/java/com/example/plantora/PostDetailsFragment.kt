package com.example.plantora

import PostAdaptor
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.plantora.data.classes.AppDatabase
import com.example.plantora.data.classes.Post
import com.example.plantora.databinding.ActivityMainBinding
import com.example.plantora.databinding.FragmentHomeBinding
import com.example.plantora.databinding.FragmentPostDetails2Binding
import com.example.plantora.ui.home.HomeViewModel


class PostDetailsFragment : Fragment() {
    private var _binding: FragmentPostDetails2Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    var postsArray = ArrayList<Post>()

    lateinit var adapter: PostAdaptor

        //
//        supportActionBar!!.title = title

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true);


//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        val tvTitrePost = findViewById<TextView>(R.id.tvPostTitre)
//        val title = intent.getStringExtra("title")
//        tvTitrePost.text = title



//        //val email = intent.getStringExtra("email")
//        val listPosts = findViewById<ListView>(R.id.listPosts)
//        val adapter = PostAdaptor(this, R.layout.recycler_item_accueil,postsArray)
//        listPosts.adapter = adapter
//        _binding!!.
//        listPosts = findView
//        listPosts = PostAdaptor(this, R.layout.recycler_item_accueil, postsArray)
//        listPosts.adapter = adapter
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentPostDetails2Binding.inflate(inflater, container, false)
        val root: View = binding.root


        var title :String = arguments?.get("titre").toString()

        var tvPostTitre : TextView = binding.tvPostTitre
//        val intent = Intent (getActivity(), AddPostActivity::class.java)
//        getActivity()?.startActivity(intent)
//        val title = intent.getStringExtra("title")
        tvPostTitre.text = title

        (activity as AppCompatActivity).supportActionBar?.title = title


//        val textView: TextView = binding.textHome
//
//
//
//        var db : AppDatabase = AppDatabase(requireContext())
//
//        _binding!!.itemAdd.setOnClickListener{
//            val intent = Intent (getActivity(), AddPostActivity::class.java)
//            getActivity()?.startActivity(intent)
//        }
//        var listPosts : ListView
//        listPosts = binding.listPosts
//
//        postsArray = db.findPosts()
//        var adapter = this.parentFragment?.context?.let { PostAdaptor(it, R.layout.recycler_item_accueil,postsArray) }
//        listPosts.adapter = adapter
//
//
//        listPosts.setOnItemClickListener{ adapterView, view, position, id ->
//            val clickedPost = postsArray[position]
//            val intent = Intent (getActivity(), DetailsPostActivity::class.java)
//            val send = clickedPost.title
//            intent.putExtra("title",send)
//            getActivity()?.startActivity(intent)
//            // intent.putExta("titre", clickedPost.titre)
////            Intent(this, DetailsPostActivity::class.java).also{
////                startActivity(it)
//            }


        //registerForContextMenu(listPosts)


        return root
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
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