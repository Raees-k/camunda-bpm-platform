/*
 * Copyright © 2013-2019 camunda services GmbH and various authors (info@camunda.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.qa.upgrade.scenarios7110.timestamp;

import org.camunda.bpm.qa.upgrade.Origin;
import org.camunda.bpm.qa.upgrade.ScenarioUnderTest;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Nikola Koevski
 */
@ScenarioUnderTest("DeploymentDeployTimeScenario")
@Origin("7.11.0")
public class MeterLogTimestampTest extends AbstractTimestampMigrationTest {

  protected static final String REPORTER_NAME = "MeterLogTimestampTest";

  @ScenarioUnderTest("initMeterLogTimestamp.1")
  @Test
  public void testMeterLogTimestampConversion() {

    long timestampLogs = managementService.createMetricsQuery()
      .reporter(REPORTER_NAME)
      .name(REPORTER_NAME)
      .startDate(new Date(TIME))
      .endDate(new Date(TIME + 1000L))
      .sum();

    assertThat(timestampLogs, is(1L));
  }
}