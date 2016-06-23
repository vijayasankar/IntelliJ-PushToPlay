package stepdefinitions;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Created by vr1470 on 20-Jun-16.
 * Copyright Solnet SOlutions 2016
 */

@RunWith(ExtendedCucumber.class)

@ExtendedCucumberOptions
                (jsonReport = "results/cucumber.json",
                retryCount = 0,
                detailedReport = true,
                detailedAggregatedReport = true,
                overviewReport = true,
                coverageReport = true,
                jsonUsageReport = "results/cucumber-usage.json",
                usageReport = false,
                toPDF = true,
                excludeCoverageTags = {"@flaky" },
                includeCoverageTags = {"@passed" },
                outputFolder = "results/Jun-23")


@CucumberOptions
        (
                features = "./src/test/resources/features",
                plugin = {"pretty",
                        "html:results/html-report",
                        "json:results/cucumber.json",
                        "usage:results/cucumber-usage.json"},
                tags = {"@regression"}
        )



public class Runner {

}



