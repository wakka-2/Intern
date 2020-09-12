package com.intern.app.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.intern.app.R
import com.intern.app.adapter.ItemsAdapter
import com.intern.app.adapter.PreviousAdapter
import com.intern.app.model.Previous
import com.intern.app.ui.MainActivity
import com.intern.app.ui.fragments.ItemsFragmentDirections.Companion.actionItemsFragmentToDetailsFragment
import com.intern.app.util.ClickListenerString
import com.khayat.app.util.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_items.*


class ItemsFragment : BaseFragment() {

    var title = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = arguments?.getString("title").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (context as MainActivity).toolbar.title = title
        showNavigationBottom()
        setupAdapter2()
    }
    private fun setupAdapter2() {
        val arrayPrevious:ArrayList<Previous> = ArrayList()
        arrayPrevious.add(Previous(R.drawable.shampoo,"$ 120","Shampoo","1 L"))
        arrayPrevious.add(Previous(R.drawable.shampoo,"$ 40","Shampoo","1 L"))
        arrayPrevious.add(Previous(R.drawable.shampoo,"$ 50","Shampoo","1 L"))
        arrayPrevious.add(Previous(R.drawable.shampoo,"$ 200","Shampoo","1 L"))
        arrayPrevious.add(Previous(R.drawable.shampoo,"$ 200","Shampoo","1 L"))
        arrayPrevious.add(Previous(R.drawable.shampoo,"$ 200","Shampoo","1 L"))
        arrayPrevious.add(Previous(R.drawable.shampoo,"$ 200","Shampoo","1 L"))

        val adapter = ItemsAdapter(arrayPrevious,object : ClickListenerString {
            override fun onClick(string: String, position: Int) {
                findNavController().navigate(actionItemsFragmentToDetailsFragment())
            }

        })
        rvItems.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        rvItems.adapter = adapter
    }
}