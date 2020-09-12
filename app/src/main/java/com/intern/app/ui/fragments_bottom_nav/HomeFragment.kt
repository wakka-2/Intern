package com.intern.app.ui.fragments_bottom_nav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.intern.app.R
import com.intern.app.adapter.CategoriesAdapter
import com.intern.app.adapter.PreviousAdapter
import com.intern.app.model.Category
import com.intern.app.model.Previous
import com.intern.app.ui.MainActivity
import com.intern.app.ui.fragments_bottom_nav.HomeFragmentDirections.Companion.actionHomeFragmentToItemsFragment
import com.intern.app.util.ClickListenerString
import com.khayat.app.util.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupActionBar()
        setupAdapter1()
        setupAdapter2()
    }

    private fun setupAdapter1() {
        val arrayCategory:ArrayList<Category> = ArrayList()
        arrayCategory.add(Category(R.drawable.shampoo,"shampoo"))
        arrayCategory.add(Category(R.drawable.oil,"oil"))
        arrayCategory.add(Category(R.drawable.spices,"species"))
        arrayCategory.add(Category(R.drawable.shampoo,"shampoo"))
        arrayCategory.add(Category(R.drawable.shampoo,"shampoo"))

        val adapter = CategoriesAdapter(arrayCategory,object :ClickListenerString{
            override fun onClick(string: String, position: Int) {
                findNavController().navigate(actionHomeFragmentToItemsFragment(title = string,position))
            }

        })
        recyclerView.adapter = adapter
    }
    private fun setupAdapter2() {
        val arrayPrevious:ArrayList<Previous> = ArrayList()
        arrayPrevious.add(Previous(R.drawable.shampoo,"$ 120","Shampoo","1 Kg"))
        arrayPrevious.add(Previous(R.drawable.oil,"$ 40","Oil","1 L"))
        arrayPrevious.add(Previous(R.drawable.salt,"$ 50","TATA salt lite","1 Kg"))
        arrayPrevious.add(Previous(R.drawable.salt,"$ 200","King's Refine Soyabeam Oil","1 L"))

        val adapter = PreviousAdapter(arrayPrevious,object :ClickListenerString{
            override fun onClick(string: String, position: Int) {

            }

        })
        rvPrevious.adapter = adapter
    }
}