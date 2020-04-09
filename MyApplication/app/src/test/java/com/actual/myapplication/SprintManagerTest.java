package com.actual.myapplication;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SprintManagerTest {

   @Test
    public void canInitiateSprintManager() {
       SprintManager sprint_manager = SprintManager.initiateSprintManager();
       assertThat(sprint_manager, instanceOf(SprintManager.class));
   }

   @Test
    public void canOnlyCreateOneSprintManagerObjectAtATime() {
       SprintManager sprint_manager = SprintManager.initiateSprintManager();
       SprintManager sprint_manager2 = SprintManager.initiateSprintManager();
       assertEquals(sprint_manager, sprint_manager2);
   }

   @Test
   public void canInitiateSprintBuilder() {
      SprintBuilder sprint_builder = SprintBuilder.initiateSprintBuilder();

      assertThat(sprint_builder, instanceOf(SprintBuilder.class));
   }

   @Test
   public void canOnlyCreateOneSprintBuilderObjectAtATime() {
      SprintBuilder sprint_builder = SprintBuilder.initiateSprintBuilder();
      SprintBuilder sprint_builder2 = SprintBuilder.initiateSprintBuilder();

      assertEquals(sprint_builder, sprint_builder2);
   }

   //@Test
   public void canAddSprintToSprintList() {
      SprintManager sprint_manager = SprintManager.initiateSprintManager();

      SprintBuilder sprint_builder = SprintBuilder.initiateSprintBuilder();

      sprint_manager.addSprint(sprint_builder);
   }

}