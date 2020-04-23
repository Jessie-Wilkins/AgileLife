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

   @Test
   public void canSetSprintLabelInBuilder() {
      SprintBuilder sprint_builder = SprintBuilder.initiateSprintBuilder();

      sprint_builder.setLabel("Test Label");

      assertEquals("Test Label", sprint_builder.getLabel());
   }

   @Test
   public void canSetSprintLengthInBuilder() {
      SprintBuilder sprint_builder = SprintBuilder.initiateSprintBuilder();

      sprint_builder.setLabel("Test Label");

      sprint_builder.setLength(5);

      assertEquals(5, sprint_builder.getLength());
   }

   @Test
   public void canSetSprintCapacityInBuilder() {
      SprintBuilder sprint_builder = SprintBuilder.initiateSprintBuilder();

      sprint_builder.setLabel("Test Label");

      sprint_builder.setLength(5);

      sprint_builder.setCapacity(8);

      assertEquals(8, sprint_builder.getCapacity());
   }

   @Test
   public void canSetSprintFrequencyInBuilder() {
      SprintBuilder sprint_builder = SprintBuilder.initiateSprintBuilder();

      sprint_builder.setLabel("Test Label");

      sprint_builder.setLength(5);

      sprint_builder.setCapacity(8);

      sprint_builder.setFrequency(14);

      assertEquals(14, sprint_builder.getFrequency());
   }

   @Test
   public void canAddSprintToSprintList() {

      IdGenerator.setStrategy(SprintIdGenerator.getSprintIdGenerator());

      IdGenerator.resetId();

      SprintManager sprint_manager = SprintManager.initiateSprintManager();

      SprintBuilder sprint_builder = SprintBuilder.initiateSprintBuilder();

      sprint_manager.addSprint();

      assertEquals(1, sprint_manager.getSprint(1).getId());
   }

   @Test
   public void canAddSprintToSprintListAndSetParametersWithBuilder() {
      SprintBuilder sprint_builder = SprintBuilder.initiateSprintBuilder();

      sprint_builder.setLabel("Test Label");

      sprint_builder.setLength(5);

      sprint_builder.setCapacity(8);

      sprint_builder.setFrequency(14);

      IdGenerator.setStrategy(SprintIdGenerator.getSprintIdGenerator());

      IdGenerator.resetId();

      SprintManager sprint_manager = SprintManager.initiateSprintManager();

      sprint_manager.addSprint();

      sprint_manager.addSprint(sprint_builder);

      assertEquals(2, sprint_manager.getSprint(2).getId());
   }

   @Test
   public void canRemoveSprintFromSprintList() {
      SprintBuilder sprint_builder = SprintBuilder.initiateSprintBuilder();

      sprint_builder.setLabel("Test Label");

      sprint_builder.setLength(5);

      sprint_builder.setCapacity(8);

      sprint_builder.setFrequency(14);

      IdGenerator.setStrategy(SprintIdGenerator.getSprintIdGenerator());

      IdGenerator.resetId();

      SprintManager sprint_manager = SprintManager.initiateSprintManager();

      sprint_manager.addSprint();

      sprint_manager.addSprint(sprint_builder);

      sprint_manager.removeSprint(1);

      System.out.println(Integer.MAX_VALUE);

      assertEquals(null, sprint_manager.getSprint(1));
   }

   @Test
   public void canGetRemovedSprintFromRemovedList() {
      SprintBuilder sprint_builder = SprintBuilder.initiateSprintBuilder();

      sprint_builder.setLabel("Test Label");

      sprint_builder.setLength(5);

      sprint_builder.setCapacity(8);

      sprint_builder.setFrequency(14);

      IdGenerator.setStrategy(SprintIdGenerator.getSprintIdGenerator());

      IdGenerator.resetId();

      SprintManager sprint_manager = SprintManager.initiateSprintManager();

      sprint_manager.addSprint();

      sprint_manager.addSprint(sprint_builder);

      sprint_manager.removeSprint(1);

      assertEquals(1, sprint_manager.getRemovedSprint(1).getId());
   }

   @Test
   public void canSaveSprintAndRemoveFromCurrentSprintList() {
      SprintBuilder sprint_builder = SprintBuilder.initiateSprintBuilder();

      sprint_builder.setLabel("Test Label");

      sprint_builder.setLength(5);

      sprint_builder.setCapacity(8);

      sprint_builder.setFrequency(14);

      IdGenerator.setStrategy(SprintIdGenerator.getSprintIdGenerator());

      IdGenerator.resetId();

      SprintManager sprint_manager = SprintManager.initiateSprintManager();

      sprint_manager.addSprint();

      sprint_manager.addSprint(sprint_builder);

      sprint_manager.removeSprint(1);

      sprint_manager.addSprint();

      sprint_manager.saveSprint(3);

      assertEquals(null, sprint_manager.getSprint(3));
   }

   @Test
   public void canSaveSprintToSavedSprintList() {
      SprintBuilder sprint_builder = SprintBuilder.initiateSprintBuilder();

      sprint_builder.setLabel("Test Label");

      sprint_builder.setLength(5);

      sprint_builder.setCapacity(8);

      sprint_builder.setFrequency(14);

      IdGenerator.setStrategy(SprintIdGenerator.getSprintIdGenerator());

      IdGenerator.resetId();

      SprintManager sprint_manager = SprintManager.initiateSprintManager();

      sprint_manager.addSprint();

      sprint_manager.addSprint(sprint_builder);

      sprint_manager.removeSprint(1);

      sprint_manager.addSprint();

      sprint_manager.saveSprint(3);

      assertEquals(3, sprint_manager.getSavedSprint(3).getId());
   }

   @Test
   public void canLoadSprintFromSavedSprintListToCurrentSprintList() {
      SprintBuilder sprint_builder = SprintBuilder.initiateSprintBuilder();

      sprint_builder.setLabel("Test Label");

      sprint_builder.setLength(5);

      sprint_builder.setCapacity(8);

      sprint_builder.setFrequency(14);

      IdGenerator.setStrategy(SprintIdGenerator.getSprintIdGenerator());

      IdGenerator.resetId();

      SprintManager sprint_manager = SprintManager.initiateSprintManager();

      sprint_manager.addSprint();

      sprint_manager.addSprint(sprint_builder);

      sprint_manager.removeSprint(1);

      sprint_manager.addSprint();

      sprint_manager.saveSprint(3);

      sprint_manager.loadSprint(3);

      assertEquals(3, sprint_manager.getSprint(3).getId());
   }

   @Test
   public void canRetrieveDeletedSprintIntoCurrentSprintList() {}
}