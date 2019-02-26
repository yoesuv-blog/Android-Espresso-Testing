package com.yoesuv.myespresso

import android.os.SystemClock
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.test.uiautomator.UiDevice
import com.yoesuv.myespresso.menu.auth.views.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainApplicationTest{

    private val delay = 2000L
    private val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @JvmField
    @Rule
    val mainActivityRule: ActivityTestRule<LoginActivity> = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun startApplication(){

        //login failed
        SystemClock.sleep(delay)
        Espresso.onView(withId(R.id.editTextLoginUsername)).perform(click()).perform(typeText("admin")).perform(closeSoftKeyboard())
        SystemClock.sleep(delay)
        Espresso.onView(withId(R.id.editTextLoginPassword)).perform(click()).perform(typeText("passwordd")).perform(closeSoftKeyboard())
        SystemClock.sleep(delay)
        Espresso.onView(withId(R.id.buttonLogin)).perform(click())
        SystemClock.sleep(delay)
        SystemClock.sleep(delay)

        Espresso.onView(withId(R.id.editTextLoginUsername)).perform(clearText())
        Espresso.onView(withId(R.id.editTextLoginPassword)).perform(clearText())

        //login success
        SystemClock.sleep(delay)
        Espresso.onView(withId(R.id.editTextLoginUsername)).perform(click()).perform(typeText("admin")).perform(closeSoftKeyboard())
        SystemClock.sleep(delay)
        Espresso.onView(withId(R.id.editTextLoginPassword)).perform(click()).perform(typeText("password")).perform(closeSoftKeyboard())
        SystemClock.sleep(delay)
        Espresso.onView(withId(R.id.buttonLogin)).perform(click())
        SystemClock.sleep(delay)

        //show list data
        SystemClock.sleep(delay)
        Espresso.onView(withId(R.id.recyclerViewList)).perform(swipeUp())
        Espresso.onView(withId(R.id.recyclerViewList)).perform(swipeUp())
        SystemClock.sleep(delay)
        Espresso.onView(withId(R.id.recyclerViewList)).perform(swipeUp())
        SystemClock.sleep(delay)
        Espresso.onView(withId(R.id.recyclerViewList)).perform(swipeDown())
        SystemClock.sleep(delay)
        Espresso.onView(withId(R.id.recyclerViewList)).perform(swipeDown())
        SystemClock.sleep(delay)
        Espresso.onView(withId(R.id.recyclerViewList)).perform(swipeDown())
        SystemClock.sleep(delay)
    }
}
