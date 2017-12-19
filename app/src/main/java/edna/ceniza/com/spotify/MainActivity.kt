package edna.ceniza.com.spotify

import android.annotation.SuppressLint
import android.app.Fragment
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v4.widget.NestedScrollView
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import edna.ceniza.com.spotify.CustomAdapter
import edna.ceniza.com.spotify.Song
import edna.ceniza.com.spotify.R
import kotlinx.android.synthetic.main.activity_main.*
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.util.Log

class MainActivity : AppCompatActivity() {
    private var mRecyclerView: RecyclerView? = null
    private var mNestedScrollView: NestedScrollView? = null

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initCollapsingToolbar()
        findView()


        val toolbar = findViewById<Toolbar>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        BottomNavigationHelper.disableShiftMode(bottomNavigationView)

        mRecyclerView!!.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val songList = ArrayList<Song>()
        songList.add(Song("Titibo-Tibo", "Moira Dela Torre", "Himig Handog 2017"))
        songList.add(Song("Havana", "Camila Cabello, Young Thug", "Havana"))
        songList.add(Song("Young Dumb & Broke", "Khalid", "American Teen"))
        songList.add(Song("What Lovers Do (feat. SZA)", "Maroon 5, SZA", "Red Pill Blues(Deluxe)"))
        songList.add(Song("Perfect", "Ed Sheeran", "♠(Deluxe)" ))
        songList.add(Song("Super Far", "LANY", "LANY"))
        songList.add(Song("Too Good at Goodbyes", "Sam Smith", "The Thrill of It All" ))
        songList.add(Song("Titibo-Tibo", "Moira Dela Torre", "Himig Handog 2017"))
        songList.add(Song("Havana", "Camila Cabello, Young Thug", "Havana"))
        songList.add(Song("Young Dumb & Broke", "Khalid", "American Teen" ))
        songList.add(Song("What Lovers Do (feat. SZA)", "Maroon 5, SZA", "Red Pill Blues(Deluxe)"))
        songList.add(Song("Perfect", "Ed Sheeran", "♠(Deluxe)" ))
        songList.add(Song("Super Far", "LANY", "LANY"))
        songList.add(Song("Too Good at Goodbyes", "Sam Smith", "The Thrill of It All"))
        val adapter = CustomAdapter(songList)

        mRecyclerView!!.adapter = adapter

        mRecyclerView!!.addItemDecoration(DividerItemDecoration(recyclerView.getContext(), LinearLayoutManager.VERTICAL))


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun initCollapsingToolbar() {

        val collapsingToolbar = findViewById<View>(R.id.collapsing) as CollapsingToolbarLayout
        collapsingToolbar.title = " "
        val appBarLayout = findViewById<View>(R.id.appbarlayout) as AppBarLayout
        appBarLayout.setExpanded(true)

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            internal var isShow = false
            internal var scrollRange = -1

            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.title = "Top Hits Philippines"
                    collapsingToolbar.setCollapsedTitleTextColor(Color.WHITE)
                    isShow = true
                } else if (isShow) {
                    collapsingToolbar.title = " "
                    collapsingToolbar.setCollapsedTitleTextColor(Color.TRANSPARENT)
                    isShow = false
                }
            }
        })
    }

    fun findView() {
        mRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        mNestedScrollView = findViewById<NestedScrollView>(R.id.nestedScrollView)

    }
}
