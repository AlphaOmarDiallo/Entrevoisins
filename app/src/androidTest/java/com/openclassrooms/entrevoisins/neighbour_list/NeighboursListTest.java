
package com.openclassrooms.entrevoisins.neighbour_list;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.core.IsNull.notNullValue;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;
import com.openclassrooms.entrevoisins.utils.OpenUserFullProfile;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;


/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {

    // This is fixed
    private static final int ITEMS_COUNT = 12;
    private static final int idNeighbourToTest = 1;

    private NeighbourApiService mService;
    private List<Neighbour> mFavoriteNeighbourList;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule<>(ListNeighbourActivity.class);


    @Before
    public void setUp() {
        ListNeighbourActivity activity = mActivityRule.getActivity();
        assertThat(activity, notNullValue());

        mService = DI.getNewInstanceApiService();
        assertThat(mService, notNullValue());

        mFavoriteNeighbourList = new ArrayList<>();
    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(allOf(withId(R.id.list_neighbours), isCompletelyDisplayed()))
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        // Given : We remove the element at position 2
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isCompletelyDisplayed())).check(withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isCompletelyDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
        // Then : the number of element is 11
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isCompletelyDisplayed())).check(withItemCount(ITEMS_COUNT - 1));
    }

    /**
     * check that the UserActivity launches when an avatar is clicked
     */
    @Test
    public void MyNeighbourList_OpenUserFullProfileAction_ShouldOpenUserProfileWithItsData() {
        // We click on the avatar picture of item 1 and it should open UserActivity
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isCompletelyDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(idNeighbourToTest, new OpenUserFullProfile()));
        onView(withId(R.id.UserActivityLayout)).check(matches(isDisplayed()));
    }

    /**
     * test checking that the username in the new activity matches the username who's avatar was clicked
     */
    @Test
    public void UserInformationActivity_nameIsDisplayed_ShouldMatchUserNameThatWasClickedOn() {
        //Perform click on avatar to open UserActivity with neighbour detail
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(idNeighbourToTest, new OpenUserFullProfile()));
        //check that the UserActivity opens
        onView(withId(R.id.UserActivityLayout)).check(matches(isDisplayed()));
        //check that the name displayed in textView tvUserName is equal to the name of the neighbour who's avatar was clicked
        onView(withId(R.id.tVUserName)).check(matches(withText(mService.getNeighbours().get(idNeighbourToTest).getName())));
    }

    /**
     * test to check that the "Favorites" tab displays only neighbours added to favorite
     */
    @Test
    public void FavouriteNeighbourFragment_ShouldOnlyDisplayFavoriteNeighbours() {
        //empty favorite neighbour list
        mFavoriteNeighbourList.clear();
        //check that the list is empty on Favorites tab
        onView((withContentDescription("Favorites")))
                .perform(click());
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .check(matches(hasChildCount(0)));
        //return on My neighbours tab
        onView((withContentDescription("My neighbours")))
                .perform(click());
        //add 4 neighbours in favorite
        for (int idNeighbourToTest = 0; idNeighbourToTest < 4; idNeighbourToTest++) {
            onView(allOf(ViewMatchers.withId(R.id.list_neighbours), isCompletelyDisplayed()))
                    .perform(RecyclerViewActions.actionOnItemAtPosition(idNeighbourToTest, new OpenUserFullProfile()));
            onView(withId(R.id.fabAddToFavourite))
                    .perform(click());
            onView(withId(R.id.UserActivityLayout))
                    .perform(pressBack());
            mFavoriteNeighbourList.add(mService.getNeighbours().get(idNeighbourToTest));
        }
        //return on favorite tab
        onView((withContentDescription("Favorites")))
                .perform(click());
        //check that the number of neighbour displayed is equal to the number of neighbour added
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .check(matches(hasChildCount(mFavoriteNeighbourList.size())));
    }
}