package com.wxx.bank;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private FieldFactory factory;

    @Before
    public void before() {
        factory = new FieldFactory();
    }

    @Test
    public void valueOfText() throws Exception {

        /*第2域*/
        Field field = factory.createFieldByPredefine(2, "62220237000155875980", 19);
        assertEquals(field.toString(), "1962220237000155875980");

        /*第3域*/
        field =factory.createFieldByPredefine(3, "190000",6);
        assertEquals(field.toString(),"190000");
        assertEquals(field.getLength(),6);
    }
}
