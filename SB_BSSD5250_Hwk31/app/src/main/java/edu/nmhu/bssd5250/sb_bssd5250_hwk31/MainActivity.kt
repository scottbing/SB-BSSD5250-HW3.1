package edu.nmhu.bssd5250.sb_bssd5250_hwk31

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RelativeLayout
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fragmentContainerView = FragmentContainerView(this).apply {
            id = View.generateViewId()
            setBackgroundColor(Color.BLUE)
            layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT)
        }

        val relativeLayout = RelativeLayout(this).apply {
            setBackgroundColor(Color.GRAY)
            addView(fragmentContainerView)
        }

        setContentView(relativeLayout)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(fragmentContainerView.id, NoteFragment.newInstance(), null)
        }
    }
}