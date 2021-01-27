package com.coccoc.checkin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.coccoc.checkin.extension.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var currentNavController: LiveData<NavController>? = null
    private lateinit var mNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getPreferences(Context.MODE_PRIVATE)!!
//        if (sharedPref.getString(getString(R.string.student_last_name_key),"").isNullOrEmpty())

//        val service = ApiService.create()
//        val call = service.getCheckInHistory()

        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        val navGraphIds = listOf(
            R.navigation.navigation_scan,
            R.navigation.navigation_history,
            R.navigation.navigation_feedback,
            R.navigation.navigation_review,
            R.navigation.navigation_account
        )
        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds,
            supportFragmentManager,
            R.id.nav_host_fragment,
            intent
        )
        controller.observe(this, Observer { navController ->
            mNavController = navController
            setupActionBarWithNavController(navController)
        })
        currentNavController = controller
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        if (requestCode == QR_REQUEST) {
        if (resultCode == RESULT_OK) {
            val info = data!!.getStringExtra(RESULT_QR) ?: return
            val bundle = bundleOf(info to info)
            mNavController.navigate(R.id.action_studentNameFragment_to_scanFragment, bundle)
        }
//        }
    }

    companion object {
        const val QR_REQUEST = 1001;
        const val RESULT_QR = "result_qr";
    }

}
