#1. Class UserDetailService 

	- Created UserDetailService class which implements following interface :
 	   org.springframework.security.core.userdetails.UserDetailsService	
	
	- In this class has we implement "loadUserByUsername" method to read the user object from db with the given credentials and return access token.

	- For further info check :
	https://docs.spring.io/spring-security/site/docs/4.2.4.RELEASE/apidocs/org/springframework/security/core/userdetails/UserDetailsService.html


#2. Class AuthorizationServerConfiguration for all the config related to Authorization Server which we want to get access token

#3. Class OAuth2SecurityConfiguration for enabling oauth security

 for more details go to - http://websystique.com/spring-security/secure-spring-rest-api-using-oauth2/

#4. Class ResourceServerConfiguration for app configuration

#5. Run application it will create database and collections.

#6. API details: 

After that Insert a primary user in "oauth" db and "user" collection for getting access token:

API - api to create user

Request Method - POST

Request Uri - http://localhost:9000/api/v1/user

Request Headers -

	Content-Type : application/json

Request Body

	{
		  "email": "test@gmail.com",
		  "first": "test",
		  "last": "demo",
		  "password": "welcome@123",
		  "username": "test@gmail.com"
	}




API - api to get access token

Request Method - POST

Request Uri - http://localhost:9000/oauth/token?grant_type=password&username=test@gmail.com&password=welcome@123

Request Headers -

  Authorization   :  Basic Mjg3MDA0OTU4NDg4LTg3cGRpdmFrNWd1OTczN3Ywb3V2Zm81NjM4NW5nb3RyLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tOlk5X3F1d1pFM05rY2U2MVI4WjVSelVibQ==


Response Body sample -

	{
	    "access_token": "74ed9e63-10e4-4061-a8c8-ba208a227c72",
	    "token_type": "bearer",
	    "refresh_token": "c5469e21-913c-48e3-aa5c-18375e8eff90",
	    "expires_in": 1055,
	    "scope": "trust read write"
	}



API - api to get access token from refresh token

Request Method - POST

Request Uri - http://localhost:9000/oauth/token?refresh_token={refresh_token_value_from_above_api_response}&grant_type=refresh_token

Request Headers -

  Authorization   :  Basic Mjg3MDA0OTU4NDg4LTg3cGRpdmFrNWd1OTczN3Ywb3V2Zm81NjM4NW5nb3RyLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tOlk5X3F1d1pFM05rY2U2MVI4WjVSelVibQ==


Response Body sample -

	{
	    "access_token": "74ed9e63-10e4-4061-a8c8-ba208a227c72",
	    "token_type": "bearer",
	    "refresh_token": "c5469e21-913c-48e3-aa5c-18375e8eff90",
	    "expires_in": 1055,
	    "scope": "trust read write"
	}
