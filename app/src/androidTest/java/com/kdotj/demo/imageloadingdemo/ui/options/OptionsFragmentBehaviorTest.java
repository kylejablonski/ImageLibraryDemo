package com.kdotj.demo.imageloadingdemo.ui.options;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.kdotj.demo.imageloadingdemo.R;
import com.kdotj.demo.imageloadingdemo.ui.main.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by kyle.jablonski on 10/27/17.
 */
@RunWith(AndroidJUnit4.class)
public class OptionsFragmentBehaviorTest {

  @Rule
  public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(
      MainActivity.class);

  @Test
  public void optionsSelected_shouldShow_OptionsFragment() {
    // Tap the Options Menu Item
    onView(withId(R.id.action_options)).perform(click());

    // Assert that the Toolbar in the Options Fragment is showing
    onView(withId(R.id.toolbar_options)).check(matches(isDisplayed()));
  }

  @Test
  public void openDrawer_selectLibrary_ShouldMatchChecked() {
    // Tap the Options Menu Item to open the draw
    onView(withId(R.id.action_options)).perform(click());

    onView(withId(R.id.lib_glide)).perform(click());

    onView((withId(R.id.lib_glide))).check(matches(isChecked()));

  }

  @Test
  public void openDrawer_selectRepo_ShouldMatchChecked() {
    // Tap the Options Menu Item to open the draw
    onView(withId(R.id.action_options)).perform(click());

    onView(withId(R.id.repo_regular)).perform(click());

    onView((withId(R.id.repo_regular))).check(matches(isChecked()));
  }

  @Test
  public void openDrawer_selectOptions_selectApply() {
    // Tap the Options Menu Item to open the draw
    onView(withId(R.id.action_options)).perform(click());

    onView(withId(R.id.lib_glide)).perform(click());

    onView(withId(R.id.repo_regular)).perform(click());

    onView(withId(R.id.action_apply)).perform(click());

    onView(withId(R.id.action_apply))
        .check(matches(not(isDisplayed())));
  }
}
