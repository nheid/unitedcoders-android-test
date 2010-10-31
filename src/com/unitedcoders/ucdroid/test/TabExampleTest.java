package com.unitedcoders.ucdroid.test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;

import com.jayway.android.robotium.solo.Solo;
import com.unitedcoders.android.examples.Tabs;
import com.unitedcoders.android.examples.UCdroid;
import com.unitedcoders.android.examples.R;

public class TabExampleTest extends ActivityInstrumentationTestCase2<UCdroid> {

    private Solo solo;

    public TabExampleTest() {
        super(UCdroid.class.getPackage().getName(), UCdroid.class);
    }

    protected void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

//    public void testTabExample() {
//        solo.clickOnText("start tab example");
//        solo.assertCurrentActivity("wrong activiy", Tabs.class);
//        solo.clickOnText("this is a tab one");
//        assertTrue(solo.searchText("this is the other tab one"));
//        solo.clickOnText("this is the other tab one");
//        assertTrue(solo.searchText("this is a tab one"));
//        solo.clickOnText("Tab2");
//        solo.clickOnText("do something");
//        assertTrue(solo.searchText("this is a tab two"));
//        sendKeys(KeyEvent.KEYCODE_BACK);
//        solo.assertCurrentActivity("wrong activiy", UCdroid.class);
//    }
    
    public void testTabExample() {
        Activity a = getActivity();
        String tab1c1 = a.getString(R.string.tab1_content1);
        String tab1c2 = a.getString(R.string.tab1_content2);
        String tab2c1 = a.getString(R.string.tab2_content1);
        
        solo.clickOnText(a.getString(R.string.btn_start_tab_example));
        solo.assertCurrentActivity("wrong activiy", Tabs.class);
        solo.clickOnText(tab1c1);
        assertTrue(solo.searchText(tab1c2));
        solo.clickOnText(tab1c2);
        assertTrue(solo.searchText(tab1c1));
        solo.clickOnText(a.getString(R.string.tabexample_tab2));
        solo.clickOnText(a.getString(R.string.btn_do_something));
        assertTrue(solo.searchText(tab2c1));
        sendKeys(KeyEvent.KEYCODE_BACK);
        solo.assertCurrentActivity("wrong activiy", UCdroid.class);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

}
