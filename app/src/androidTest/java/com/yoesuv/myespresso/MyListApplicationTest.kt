package com.yoesuv.myespresso

import android.os.SystemClock
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.test.uiautomator.UiDevice
import android.support.v7.widget.RecyclerView
import com.yoesuv.myespresso.menu.list.adapters.MyListAdapter
import com.yoesuv.myespresso.menu.list.views.MyListActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
@LargeTest
class MyListApplicationTest {

    private val delay = 2000L
    private val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @JvmField
    @Rule
    val myListActivityRule: ActivityTestRule<MyListActivity> = ActivityTestRule(MyListActivity::class.java)

    @Test
    fun startApplication(){
        SystemClock.sleep(delay)
        onView(withId(R.id.recyclerViewList)).perform(swipeUp())
        SystemClock.sleep(delay)
        onView(withId(R.id.recyclerViewList)).perform(swipeUp())
        SystemClock.sleep(delay)
        SystemClock.sleep(delay)
        onView(withId(R.id.recyclerViewList)).perform(swipeDown())
        SystemClock.sleep(delay)
        onView(withId(R.id.recyclerViewList)).perform(swipeDown())
        SystemClock.sleep(delay)

        onView(withId(R.id.recyclerViewList)).perform(RecyclerViewActions.actionOnItemAtPosition<MyListAdapter.MyViewHolder>(getRandomPosition(), click()))
        SystemClock.sleep(delay)
        device.pressBack()
        SystemClock.sleep(delay)
        onView(withId(R.id.recyclerViewList)).perform(RecyclerViewActions.actionOnItemAtPosition<MyListAdapter.MyViewHolder>(getRandomPosition(), click()))
        SystemClock.sleep(delay)
        device.pressBack()
        SystemClock.sleep(delay)
    }

    private fun getRandomPosition(): Int{
        val ran = Random()
        val rcView: RecyclerView = myListActivityRule.activity.findViewById(R.id.recyclerViewList)
        val n = rcView.adapter?.itemCount
        return ran.nextInt(n!!)
    }

}