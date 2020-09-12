package com.intern.app.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.intern.app.R
import com.khayat.app.util.BaseFragment
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : BaseFragment() {

    private var checkedCart = false
    private var checkedBookmark = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickHandle()
        hideNavigationBottom()
    }

    private fun clickHandle() {
        ivCart.setOnClickListener {
            checkedCart = if(checkedCart){
                ivCart.clearColorFilter()
                false
            }else {
                ivCart.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.quantum_black_100
                    ), android.graphics.PorterDuff.Mode.MULTIPLY
                )
                true
            }
        }
        ivBookmark.setOnClickListener {
            checkedBookmark = if(checkedBookmark){
                ivBookmark.clearColorFilter()
                false
            }else {
                ivBookmark.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.quantum_black_100
                    ), android.graphics.PorterDuff.Mode.MULTIPLY
                )
                true
            }
        }
    }
}