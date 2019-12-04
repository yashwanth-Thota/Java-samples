/*
*
* Author :yashwanth thota.
* Inventory Application using Collections,
* 
*/

Inventory Application	:-
-----------------------
Entry point :Inventory(Main class)

Demonstration :-
--------------
1) Navigate Inventory folder,
2) Operminal Terminal(Commandprompt),
3) Run command "java Inventory"

Source Code :-
--------------
Available in the src folder for Banking

Packages:-
---------
1. Factory :- Contains Modelfactory class which gives instances of User, Product, Category and Order,
2. Logic   :- Contains all business logic from DataBaseHelper,
3. Models  :- Contains all models (User,Order,Product,Category),
4. Server  :- Contains DataSource( with records of users, orders ,products, and categories) and DBHelper(all operations on records) classes,
5. Utils   :- Contains Enums(UserLevel,AccountStatus) ,
	      Constants(StringLiterals) and 
	      Session(with currentUser variable to store loggged in user).
