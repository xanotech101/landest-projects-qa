Feature: Agency Registration Functionality
  Agency Representative should be able to register his Agency

  #Background:
    #Given The Agency representative opens the portal


@backOffice @onboarding
  Scenario: Agency Registration and Verification
  Given The Agency representative opens the portal
  When Representative clicks on register link
    When Representative fills registration form correctly
    When Representative clicks sign up button
    When Representative receives email and extracts the OTP
    When Representative specifies valid OTP
  When Representative clicks on submit button



  #Scenario: Agency Representative submits an empty form
    #When Representative submits an empty form
    #Then Representative should see error messages