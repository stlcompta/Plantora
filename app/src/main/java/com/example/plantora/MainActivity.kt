package com.example.plantora

import PostAdaptor
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.plantora.data.classes.AppDatabase
import com.example.plantora.data.classes.Post
import com.example.plantora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    var db = AppDatabase(this)
    var titreMain : String = ""

    var postsArray = ArrayList<Post>()

    companion object{
        private const val TAG = "MyActivity"
        var email : String = ""
        var txtMail : String = ""
       // var listPosts : ListView =
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Plantora);

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //var db : AppDatabase
        db = AppDatabase(this)
        val email = intent.getStringExtra("email")
        //val tvMail: View = binding.tvMail

       // val mail = intent.getString

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //this.par


//        MainActivity.listPosts = binding.listPosts
//        val adapter = PostAdaptor(this, R.layout.recycler_item_accueil,postsArray)
//        listPosts.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        var db : AppDatabase
        db = AppDatabase(this)
        val search = menu.findItem(R.id.action_search)
        val searchView: SearchView = search.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d(TAG, "onQueryTextSubmit ${query}")
                val args = bundleOf("artist" to query)
                navController.navigate(R.id.navigation_home, args) //CHANG2 action... ? voir truc de navigation
                invalidateOptionsMenu()
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d(TAG, "onQueryTextChange ${newText}")
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}