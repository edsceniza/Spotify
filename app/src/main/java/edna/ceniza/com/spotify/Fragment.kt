package edna.ceniza.com.spotify

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edna.ceniza.com.spotify.R
/**
 * Created by Edna Ceniza on 19/12/2017.
 */
class Fragment: Fragment () {
    val TAG = "Fragment"
    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private var songs: List<String>? = null
    private var albums: List<String>? = null
    private val PARTS_SONG = "parts_list"
    private val PARTS_ALBUM = "parts_number"

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (savedInstanceState != null) {
            songs = savedInstanceState.getStringArrayList(PARTS_SONG)
            albums = savedInstanceState.getStringArrayList(PARTS_ALBUM)

        }

        val rootView = inflater?.inflate(R.layout.on_play, container, false)
        return rootView

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
    }

}