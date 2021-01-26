package com.coccoc.checkin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.coccoc.checkin.R
import com.coccoc.checkin.base.BaseFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : BaseFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val bottomNavigation: BottomNavigationView = view.findViewById(R.id.bottomNavigationView)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
//        openFragment(ScanFragment.newInstance())
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_scan -> {
//                val scanFragment = ScanFragment.newInstance()
//                openFragment(scanFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_history -> {
                    val historyFragment = HistoryFragment.newInstance()
                    openFragment(historyFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_account -> {
                    val accountFragment = AccountFragment.newInstance()
                    openFragment(accountFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun openFragment(fragment: Fragment) {
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.container, fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
    }

}