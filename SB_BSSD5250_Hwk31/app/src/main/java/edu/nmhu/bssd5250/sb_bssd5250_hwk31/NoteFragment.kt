package edu.nmhu.bssd5250.sb_bssd5250_hwk31

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import org.w3c.dom.Text
import com.google.android.material.internal.ViewUtils.dpToPx

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [NoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NoteFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    val buttonWidth:Int = 200
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val nameView = TextView(context).apply {
            setText(R.string.name_place_holder)
        }
        val editButton = Button(context).apply {
            this.setText(R.string.edit_place_holder)
            this.setWidth(buttonWidth)
            this.gravity = Gravity.END
            this.minimumWidth = 800
            layoutParams = LinearLayout.LayoutParams(200, 100)
        }
        val dateView = TextView(context).apply {
            setText(R.string.date_place_holder)
        }
        val descView = TextView(context).apply {
            setText(R.string.desc_place_holder)
        }

        val rightParams = LinearLayout.LayoutParams(
            LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
            LinearLayoutCompat.LayoutParams.WRAP_CONTENT
        ).apply {
            weight = 1.0f
            gravity = Gravity.END
        }
        rightParams.height = 100;
        rightParams.width = 150;
        //rightParams.gravity=Gravity.END
        editButton.setLayoutParams(rightParams);

        val innerLinearLayout = LinearLayoutCompat(requireContext()).apply {
            setBackgroundColor(Color.WHITE)
            orientation = LinearLayoutCompat.HORIZONTAL
            val layoutParams = LinearLayoutCompat.LayoutParams(
                LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
                LinearLayoutCompat.LayoutParams.WRAP_CONTENT
            )
            layoutParams.height = 100;
            layoutParams.width = 150;
            layoutParams.gravity=Gravity.END
            editButton.setLayoutParams(layoutParams);
            addView(nameView)
            addView(editButton)
        }

        val outerLinearLayout = LinearLayoutCompat(requireContext()).apply {
            setBackgroundColor(Color.WHITE)
            orientation = LinearLayoutCompat.VERTICAL
            layoutParams = LinearLayoutCompat.LayoutParams(
                LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                LinearLayoutCompat.LayoutParams.WRAP_CONTENT
            )
            addView(innerLinearLayout)
            addView(dateView)
            addView(descView)
        }
        // Inflate the layout for this fragment
        return outerLinearLayout
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NoteFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            NoteFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}