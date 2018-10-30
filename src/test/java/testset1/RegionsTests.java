package testset1;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.maintenance.RegionsPage;


public class RegionsTests extends BaseTest {
	
	@Test 
	//To verify that the add region functionality is working properly
	void addNewRegion() 
	{
		RegionsPage.goTo();
		RegionsPage.addNew();
		Assert.assertTrue(RegionsPage.isAdded(), "New Region is not added");
		RegionsPage.deleteLastAdded();
		RegionsPage.close();
	}
	
	@Test 
	//To verify that the edit region functionality is working properly
	void editRegion() 
	{
		RegionsPage.goTo();
		RegionsPage.addNew();
		RegionsPage.close();
		RegionsPage.goTo();
		RegionsPage.editRegion();
		Assert.assertTrue(RegionsPage.isEdited(), "New Region is not updated");
		RegionsPage.deleteLastAdded();
		RegionsPage.close();
	}
	
	@Test 
	//To verify that canceling modification is working properly
	void cancelEditing() 
	{
		RegionsPage.goTo();
		RegionsPage.addNew();
		RegionsPage.close();
		RegionsPage.goTo();
		RegionsPage.editAndCancelRegion();
		Assert.assertTrue(RegionsPage.isEdited(), "New Region is not updated");
		RegionsPage.deleteLastAdded();
		RegionsPage.close();
	}
	
	@Test 
	//To verify that proper error message is displayed when a duplicate entry is made
	void regionAlreadyExists() 
	{
		RegionsPage.goTo();
		RegionsPage.addNew();
		RegionsPage.addRegionAgain();
		Assert.assertTrue(RegionsPage.checkProperErrorMessage(), "Error message not displayed");
		RegionsPage.deleteLastAdded();
		RegionsPage.close();
	}
	
	@Test //To verify that proper error message is displayed when description is blank
	void invalidDescriptionAdd() 
	{
		RegionsPage.goTo();
		RegionsPage.addNewWithBlankDescription();
		Assert.assertTrue(RegionsPage.checkProperErrorMessage(), "Error message not displayed");
		RegionsPage.close();
	}
	
	
}

