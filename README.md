# CocusCC
Android Project for Cocus


**Cache**

CocusCC's APP have a caches to avoid user to send request all the time, that is the OkHTTP cache.

OkHTTP take cares of API Requests, so when the request is in the cache OkHTTP quickly answer with that cache for the request.

**DI**

For DI I used Dagger 2

**Architecture**

CocusCC’s App follows the MVVM design pattern with clean architecture principles, code is divided between 3 layers (Data, Domain and Feature):

The Data layer has the call for Service and Database
The Domain layer has the UseCases interactors
The Feature layer is the View, so view and viewModel are inside that layer

The communication between the layers is made by using Coroutines flow.

**Database**

To able CocusCC’s App to save the last five search users, I implemented a Database with room to save them, and delete the oldest member when the maximum of 5 members are showed

**WIP**

 - Create Unit Tests to validate Search flow
 - Create the two others screens
 - 
