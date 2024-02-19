Feature: Release Test cases

Scenario: User should move to Alternative med flow through PA when PA preference is Phil Send me 3 subs
	Given User lands on OPSdash Login page
	And User logged in to "OPSdash"
	And Mock order created for Program:"med" at Stage:"stage" with paymentType:"insType" from MD:"pref_npi"
	And MD preference is Let Phil Send me substitutes to choose from
	When Order routed to PP
	And User logged in to "PPdash"
	And Initiated PA from Cannot Fill
	Then Order should move to "expectedLabelForRTC1"
	And Close Browser tabs
	
Scenario: Validate Insurance upload flow and success toast displayed in Myphil
	Given User lands on OPSdash Login page
	And User logged in to "OPSdash"
	And Mock order created for Program:"med" at Stage:"stage" with paymentType:"insType" from MD:"npi"
	And AddRx order created with "patient" for "existing" order
	When User logged in to "Myphil"
	And Insurance uploaded to manager and patient
	Then Success toast should display after new Insurance uploaded
	And Close Browser tabs
	
Scenario: Validate Ask for Chart Note via fax flow
	Given User lands on OPSdash Login page
	And User logged in to "OPSdash"
	And Mock order created for Program:"med" at Stage:"stage" with paymentType:"insType" from MD:"npi"
	When Initiated PA and moved to Ask for CN via fax
	Then Order should move to "expectedLabelForRTC3"
	And Close Browser tabs
