
@Naaptol
Feature:  Bike Accessories

  @BikeAccessoriesScenarios
  
  Scenario: Validating the working functionality of Pincodes
  
    Given User Opened the Browser and Entered Url
        
    When User Moves to Shopping Categories and Car and Bike Accessories 
    
    And Clicks on Bike Accessories
    
    And Enters Pincode and Click on Set
    
    Then That area available products would have been shown
    
    
   Scenario: Validating the working functionality of Applying and Narrowin Filters
  
    Given User Opened the Browser and Entered Url
        
    When User Moves to Shopping Categories and Car and Bike Accessories 
    
    And Clicks on Bike Accessories
    
    And Enters Pincode ,Clicks on Cash On Delivery
    
    And Clicks on Branded,Search By Price and Clicks on Clear All
    
    Then All filters should get cleared
    
    
    
     Scenario: Validating the working functionality of Price Range Checkboxes
  
    Given User Opened the Browser and Entered Url
        
    When User Moves to Shopping Categories and Car and Bike Accessories 
    
    And Clicks on Bike Accessories
    
    And Clicked on All Checkboxes 
    
    And Unchecked All CheckBoxes
    
    Then All Range products should be available
    
    
    
    Scenario: Validating the working functionality of Different Price Range Product
  
    Given User Opened the Browser and Entered Url
        
    When User Moves to Shopping Categories and Car and Bike Accessories 
    
    And Clicks on Bike Accessories
    
    And Enters Minimum and Maximum Ranges and Clicks on Go button
    
    Then Products should be shown
    
    
    Scenario: Validating the working functionality of Car and Bike Accessories
  
    Given User Opened the Browser and Entered Url
        
    When User Moves to Shopping Categories  
    
    And Clicks on Car and Bike Accessories
    
    And Clicks on Every Brand Name 
    
    Then Every Brand Products name should be visible
    
    
    
    Scenario: Validating the working functionality of Increasing product Quantities
  
    Given User Opened the Browser and Entered Url
        
    When User Moves to Shopping Categories  
    
    And Clicks on Car and Bike Accessories
    
    And Clicks on Bike Accessories and on a Product
    
    And Added Product to the Cart and Increased the number of Product  
    
    Then Message should be displayed
    
    
    