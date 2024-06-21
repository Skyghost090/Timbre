package com.timbre

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val textview = findViewById<TextView>(R.id.textView)
        val tablayout = findViewById<TabLayout>(R.id.tabLayout)
        val playbutton = findViewById<ImageButton>(R.id.imageButton3)
        val imageView_ = findViewById<ImageView>(R.id.imageView)

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = resources.getColor(R.color.toolbar)

        textview.setBackgroundResource(R.drawable.textview)

        var conditionalPlayClick = true
        var mediaPlayer: MediaPlayer = MediaPlayer.create(this@MainActivity, R.raw.solarplexusmusic)
        mediaPlayer.pause()
        mediaPlayer.isLooping = true
        textview.setText("The Solar Plexus Chakra, known as Manipura in Sanskrit, is the third chakra located in the upper abdomen, around the area of the diaphragm. It is associated with personal power, self-esteem, and confidence. The energy of this chakra governs your sense of self, autonomy, and transformation.\n\nSigns of a Balanced Solar Plexus Chakra:\n- Strong sense of self-worth and self-esteem.\n- Confidence in taking actions and making decisions.\n- Ability to set and achieve goals.\n- Healthy digestive system.\n\nSigns of an Imbalanced Solar Plexus Chakra:\n- Low self-esteem and lack of confidence.\n- Difficulty making decisions or asserting oneself.\n- Digestive issues and problems with metabolism.\n- Overly controlling behavior or excessive competitiveness.")

        fun detectTab() {
            playbutton.isClickable = true
            when(tablayout.selectedTabPosition) {
                0 -> {
                    mediaPlayer.pause()
                    mediaPlayer = MediaPlayer.create(this@MainActivity, R.raw.solarplexusmusic)
                    conditionalPlayClick = false
                    playbutton.setImageDrawable(getDrawable(R.drawable.stop))
                    imageView_.setBackgroundResource(R.mipmap.ic_launcher_foreground)
                    textview.setText(R.string.solarplexus)
                    mediaPlayer.start()
                }
                1 -> {
                    mediaPlayer.pause()
                    mediaPlayer = MediaPlayer.create(this@MainActivity, R.raw.heartmusic)
                    conditionalPlayClick = false
                    playbutton.setImageDrawable(getDrawable(R.drawable.stop))
                    imageView_.setBackgroundResource(R.mipmap.ic_launcher_foreground)
                    textview.setText(R.string.heartchakra)
                    mediaPlayer.start()
                }
                2 -> {
                    mediaPlayer.pause()
                    mediaPlayer = MediaPlayer.create(this@MainActivity, R.raw.throatmusic)
                    conditionalPlayClick = false
                    playbutton.setImageDrawable(getDrawable(R.drawable.stop))
                    imageView_.setBackgroundResource(R.mipmap.ic_launcher_foreground)
                    textview.setText(R.string.throatchakra)
                    mediaPlayer.start()
                }
                3 -> {
                    mediaPlayer.pause()
                    mediaPlayer = MediaPlayer.create(this@MainActivity, R.raw.thirdeyemusic)
                    conditionalPlayClick = false
                    playbutton.setImageDrawable(getDrawable(R.drawable.stop))
                    imageView_.setBackgroundResource(R.mipmap.ic_launcher_foreground)
                    textview.setText(R.string.thirdeye)
                    mediaPlayer.start()
                }
                4 -> {
                    mediaPlayer.pause()
                    mediaPlayer = MediaPlayer.create(this@MainActivity, R.raw.crownmusic)
                    conditionalPlayClick = false
                    playbutton.setImageDrawable(getDrawable(R.drawable.stop))
                    imageView_.setBackgroundResource(R.mipmap.ic_launcher_foreground)
                    textview.setText(R.string.crownchakra)
                    mediaPlayer.start()
                }
                5 -> {
                    mediaPlayer.pause()
                    textview.setText(R.string.abouttext)
                    playbutton.setImageDrawable(getDrawable(R.drawable.github))
                    playbutton.isClickable = false
                    imageView_.setBackgroundResource(R.mipmap.githubuser_foreground)
                    imageView_.setImageDrawable(getDrawable(R.drawable.transparent))
                }
            }
        }

        playbutton.setOnClickListener(View.OnClickListener {
            if(conditionalPlayClick == true){
                detectTab()
                playbutton.setImageDrawable(getDrawable(R.drawable.stop))
                conditionalPlayClick = false
                mediaPlayer.start()
            } else {
                detectTab()
                playbutton.setImageDrawable(getDrawable(R.drawable.play))
                conditionalPlayClick = true
                mediaPlayer.pause()
            }
        })

        tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {detectTab()}
            override fun onTabUnselected(tab: TabLayout.Tab) {detectTab()}
            override fun onTabReselected(tab: TabLayout.Tab) {detectTab()}
        })
    }
}