package com.luxoft.selenium.introduction.pageobject;

import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class SmokeEtsyComTest extends PageObjectTestBase {

    EtsyComPageObject etsyCom;

    @Test
    public void shouldApplyFilterCriteriaToSearchREsult(){
        etsyCom = new EtsyComPageObject(webDriver);
        etsyCom.goToMainPage()
                .acceptGDPRPolicy()
                .searchFor("leather bag")
                .selectShippingOption("Free shipping")
                .selectShippingDestination("Poland");
        List<String> appliedFilters =etsyCom.getSearchResultAppliedFilters();
        assertThat(appliedFilters, containsInAnyOrder(
                "Free shipping", "Ships to Poland"
        ));
    }
}
