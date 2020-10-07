package com.makemytrip.Base;

import io.cucumber.testng.CucumberOptions;


@CucumberOptions
( 
		features ={"./src/test/java/FeatureFileRepo/01_Login.feature",
				"./src/test/java/FeatureFileRepo/02_HotelSearch.feature"
		
		}, 
		glue={"src/test/java/com/makemytrip/StepDefinition"}, 
		dryRun = true,
		monochrome = true
)

public class MakemyTrip_Runner {

}
