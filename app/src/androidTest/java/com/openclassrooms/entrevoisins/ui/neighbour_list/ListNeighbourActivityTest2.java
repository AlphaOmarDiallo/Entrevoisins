package com.openclassrooms.entrevoisins.ui.neighbour_list;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.openclassrooms.entrevoisins.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ListNeighbourActivityTest2 {

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityTestRule = new ActivityTestRule<>(ListNeighbourActivity.class);

    @Test
    public void listNeighbourActivityTest2() {
        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.item_list_avatar),
                        childAtPosition(
                                allOf(withId(R.id.userCard),
                                        childAtPosition(
                                                withId(R.id.list_neighbours),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatImageView.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.tVUserName), withText("Caroline"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView.check(matches(withText("Caroline")));

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fabAddToFavourite), withContentDescription("Star"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction imageButton = onView(
                allOf(withId(R.id.fabAddToFavourite), withContentDescription("Star"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        imageButton.check(matches(isDisplayed()));

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.toolbarUserInfo),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction appCompatImageView2 = onView(
                allOf(withId(R.id.item_list_avatar),
                        childAtPosition(
                                allOf(withId(R.id.userCard),
                                        childAtPosition(
                                                withId(R.id.list_neighbours),
                                                1)),
                                0),
                        isDisplayed()));
        appCompatImageView2.perform(click());

        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.fabAddToFavourite), withContentDescription("Star"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        floatingActionButton2.perform(click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.toolbarUserInfo),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction tabView = onView(
                allOf(withContentDescription("Favorites"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                1),
                        isDisplayed()));
        tabView.perform(click());

        ViewInteraction viewPager = onView(
                allOf(withId(R.id.container),
                        childAtPosition(
                                allOf(withId(R.id.main_content),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        viewPager.perform(swipeLeft());

        ViewInteraction appCompatImageView3 = onView(
                allOf(withId(R.id.item_list_avatar),
                        childAtPosition(
                                allOf(withId(R.id.userCard),
                                        childAtPosition(
                                                withId(R.id.list_neighbours),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatImageView3.perform(click());

        ViewInteraction floatingActionButton3 = onView(
                allOf(withId(R.id.fabAddToFavourite), withContentDescription("Star"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        floatingActionButton3.perform(click());

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.toolbarUserInfo),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatImageButton3.perform(click());

        ViewInteraction tabView2 = onView(
                allOf(withContentDescription("My neighbours"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                0),
                        isDisplayed()));
        tabView2.perform(click());

        ViewInteraction viewPager2 = onView(
                allOf(withId(R.id.container),
                        childAtPosition(
                                allOf(withId(R.id.main_content),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        viewPager2.perform(swipeRight());

        ViewInteraction appCompatImageButton4 = onView(
                allOf(withId(R.id.item_list_delete_button),
                        childAtPosition(
                                allOf(withId(R.id.userCard),
                                        childAtPosition(
                                                withId(R.id.list_neighbours),
                                                4)),
                                2),
                        isDisplayed()));
        appCompatImageButton4.perform(click());

        ViewInteraction floatingActionButton4 = onView(
                allOf(withId(R.id.add_neighbour),
                        childAtPosition(
                                allOf(withId(R.id.main_content),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        floatingActionButton4.perform(click());

        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nameLyt),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText.perform(replaceText("John"), closeSoftKeyboard());

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.phoneNumber),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.phoneNumberLyt),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText2.perform(replaceText("555-555-555"), closeSoftKeyboard());

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.address),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.addressLyt),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText3.perform(replaceText("somewhere"), closeSoftKeyboard());

        ViewInteraction textInputEditText4 = onView(
                allOf(withId(R.id.emailAddress),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.emailAddressLyt),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText4.perform(replaceText("my@email.com"), closeSoftKeyboard());

        ViewInteraction textInputEditText5 = onView(
                allOf(withId(R.id.aboutMe),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.aboutMeLyt),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText5.perform(replaceText("I love pancakes"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.create), withText("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.constraint.ConstraintLayout")),
                                        0),
                                6),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatImageView4 = onView(
                allOf(withId(R.id.item_list_avatar),
                        childAtPosition(
                                allOf(withId(R.id.userCard),
                                        childAtPosition(
                                                withId(R.id.list_neighbours),
                                                10)),
                                0),
                        isDisplayed()));
        appCompatImageView4.perform(click());

        ViewInteraction floatingActionButton5 = onView(
                allOf(withId(R.id.fabAddToFavourite), withContentDescription("Star"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        floatingActionButton5.perform(click());

        ViewInteraction appCompatImageButton5 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.toolbarUserInfo),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatImageButton5.perform(click());

        ViewInteraction tabView3 = onView(
                allOf(withContentDescription("Favorites"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                1),
                        isDisplayed()));
        tabView3.perform(click());

        ViewInteraction viewPager3 = onView(
                allOf(withId(R.id.container),
                        childAtPosition(
                                allOf(withId(R.id.main_content),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        viewPager3.perform(swipeLeft());

        ViewInteraction appCompatImageButton6 = onView(
                allOf(withId(R.id.item_list_delete_button),
                        childAtPosition(
                                allOf(withId(R.id.userCard),
                                        childAtPosition(
                                                withId(R.id.list_neighbours),
                                                1)),
                                2),
                        isDisplayed()));
        appCompatImageButton6.perform(click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
