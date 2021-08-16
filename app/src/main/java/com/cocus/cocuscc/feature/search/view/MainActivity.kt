package com.cocus.cocuscc.feature.search.view

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.cocus.cocuscc.CocusCCApplication
import com.cocus.cocuscc.R
import com.cocus.cocuscc.di.viewModel
import com.cocus.cocuscc.feature.search.view.fragment.SearchUserFragment
import com.cocus.cocuscc.feature.search.view.fragment.viewModel.SearchViewModel

class MainActivity : FragmentActivity() {

    private lateinit var manager: FragmentManager

    private val viewModel: SearchViewModel by viewModel{
        CocusCCApplication.searchUserComponent.viewModelComponent.searchViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main)
        defineFirstScreen()
    }

    private fun defineFirstScreen() {
        manager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.add(R.id.fragment_view, SearchUserFragment())
        transaction.commit()
    }
}