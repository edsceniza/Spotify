package edna.ceniza.com.spotify

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.recyclerView)
        rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val song = ArrayList<Song>()


        song.add(Song("Havana", "Camilla Cabello", "Havana"))
        song.add(Song("Candles", "Camilla Cabello", "Havana"))
        val adapter = CustomAdapter(song)
        rv.adapter = adapter

    }
}
