package edna.ceniza.com.spotify

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
/**
 * Created by Edna Ceniza on 18/12/2017.
 */
class CustomAdapter(val songList: ArrayList<Song>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.title?.text = songList[position].title
        holder?.singer?.text = songList[position].singer
        holder?.album?.text = songList[position].album

        holder?.mLinear?.setOnClickListener(object: View.OnClickListener{
            @SuppressLint("ResourceAsColor")
            override fun onClick(v: View) {
                if (!songList.stat) {
                    holder?.title.setTextColor(Color.parseColor("#1DB954"));
                    songList.stat!=true
                }
                if(songList.stat){
                    holder?.title.setTextColor(Color.parseColor("#fffff"));
                    song.stat!=false
                }
            }
        })

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.song, parent, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.txtName)
        val singer = itemView.findViewById<TextView>(R.id.txtDesc2)
        val album = itemView.findViewById<TextView>(R.id.txtDesc)
    }
}