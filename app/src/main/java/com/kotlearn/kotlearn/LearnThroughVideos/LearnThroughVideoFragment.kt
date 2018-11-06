package com.kotlearn.kotlearn.LearnThroughVideos


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.google.android.youtube.player.YouTubeStandalonePlayer
import com.kotlearn.kotlearn.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LearnThroughVideoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_learn_through_video, container, false)

        val btnIntro = view.findViewById<ImageButton>(R.id.btnIntro)
        btnIntro.setOnClickListener {
            val intent = YouTubeStandalonePlayer.createVideoIntent(activity, "AIzaSyAyOI6PqzjZqURwQVo5as3WRg3bCy-mrlw", "0isrdp5meyQ")
            startActivity(intent)
        }

        val btnGs = view.findViewById<ImageButton>(R.id.btnGs)
        btnGs.setOnClickListener {
            val intent = YouTubeStandalonePlayer.createVideoIntent(activity, "AIzaSyAyOI6PqzjZqURwQVo5as3WRg3bCy-mrlw", "3C-e4dTvrSI")
            startActivity(intent)
        }

        val btnbs = view.findViewById<ImageButton>(R.id.btnbs)
        btnbs.setOnClickListener {
            val intent = YouTubeStandalonePlayer.createVideoIntent(activity, "AIzaSyAyOI6PqzjZqURwQVo5as3WRg3bCy-mrlw", "glX5Yx63_Vs")
            startActivity(intent)
        }

        val btncao = view.findViewById<ImageButton>(R.id.btncao)
        btncao.setOnClickListener {
            val intent = YouTubeStandalonePlayer.createVideoIntent(activity, "AIzaSyAyOI6PqzjZqURwQVo5as3WRg3bCy-mrlw", "NpveMP5869U")
            startActivity(intent)
        }

        val btnfal = view.findViewById<ImageButton>(R.id.btnfal)
        btnfal.setOnClickListener {
            val intent = YouTubeStandalonePlayer.createVideoIntent(activity, "AIzaSyAyOI6PqzjZqURwQVo5as3WRg3bCy-mrlw", "4YF_DUMQqFA")
            startActivity(intent)
        }

        val btno = view.findViewById<ImageButton>(R.id.btno)
        btno.setOnClickListener {
            val intent = YouTubeStandalonePlayer.createVideoIntent(activity, "AIzaSyAyOI6PqzjZqURwQVo5as3WRg3bCy-mrlw", "9XmGh4WgfSg")
            startActivity(intent)
        }

        val btnifelse = view.findViewById<ImageButton>(R.id.ifelse)
        btnifelse.setOnClickListener {
            val intent = YouTubeStandalonePlayer.createVideoIntent(activity, "AIzaSyAyOI6PqzjZqURwQVo5as3WRg3bCy-mrlw", "qaqKps5mNts")
            startActivity(intent)
        }

        val btnrecursion = view.findViewById<ImageButton>(R.id.recursion)
        btnrecursion.setOnClickListener {
            val intent = YouTubeStandalonePlayer.createVideoIntent(activity, "AIzaSyAyOI6PqzjZqURwQVo5as3WRg3bCy-mrlw", "d39zxt6NWNk")
            startActivity(intent)
        }

        val btnarray = view.findViewById<ImageButton>(R.id.btnarray)
        btnarray.setOnClickListener {
            val intent = YouTubeStandalonePlayer.createVideoIntent(activity, "AIzaSyAyOI6PqzjZqURwQVo5as3WRg3bCy-mrlw", "Mq4AbdNsFVw")
            startActivity(intent)
        }

        val btnlist = view.findViewById<ImageButton>(R.id.btnlist)
        btnlist.setOnClickListener {
            val intent = YouTubeStandalonePlayer.createVideoIntent(activity, "AIzaSyAyOI6PqzjZqURwQVo5as3WRg3bCy-mrlw", "FUqD6srpuPY")
            startActivity(intent)
        }

        return view
    }


}
