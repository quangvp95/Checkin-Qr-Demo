package com.coccoc.checkin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.*
import androidx.fragment.app.Fragment
import com.coccoc.checkin.ui.AccountFragment
import com.coccoc.checkin.ui.HistoryFragment
import com.coccoc.checkin.ui.ScanFragment
import com.coccoc.checkin.ui.StudentIdFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getPreferences(Context.MODE_PRIVATE)!!
//        if (sharedPref.getString(getString(R.string.student_last_name_key),"").isNullOrEmpty())
        openFragment(StudentIdFragment.newInstance())

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_scan -> {
//                    val scanFragment = ScanFragment.newInstance()
//                    openFragment(scanFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_history -> {
                    val historyFragment = HistoryFragment.newInstance()
                    openFragment(historyFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_feedback -> {
                    val accountFragment = AccountFragment.newInstance()
                    openFragment(accountFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_review -> {
                    val accountFragment = AccountFragment.newInstance()
                    openFragment(accountFragment)
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

    fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        if (requestCode == QR_REQUEST) {
        if (resultCode == RESULT_OK) {
            val info = data!!.getStringExtra(RESULT_QR) ?: return
            openFragment(ScanFragment.newInstance(info))
        }
//        }
    }

    companion object {
        const val QR_REQUEST = 1001
        const val RESULT_QR = "result_qr"
    }

}
