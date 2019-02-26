package com.yoesuv.myespresso

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.yoesuv.myespresso.menu.auth.views.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainApplicationTest{

    @JvmField
    @Rule
    val mainActivityRule: ActivityTestRule<LoginActivity> = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun startApplication(){

    }
}
