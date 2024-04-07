# Smart Fridge

> This Kata has been designed as a final hands-on exam for undergraduate students at [IUT Charlemagne](https://iut-charlemagne.univ-lorraine.fr/).  
> It borrows many ideas from [Gilded Rose](https://github.com/emilybache/GildedRose-Refactoring-Kata) and [Trip Service](https://github.com/sandromancuso/trip-service-kata).  
> Kudos to Emily Bache and Sandro Mancuso for these amazing kata !

Welcome to Smart Stuff Society !

You are now in charge of our SmartFridge™ internal software.
Your job is to implement the next update, detailed in the [todo](https://github.com/NiziL/Smart-Fridge-Kata#todo) section.  
The original developper left few weeks ago, telling us "the code is a little messy" so feel free to refactor it as you wish !  
However, you **MUST NOT** change the files in the `protocol` subpackage.

### Current system

- every day, the fridge run the following routine
  - scan every new products
  - update the freshness of all products
  - destroy all expired products (freshness <= 0)
- freshness update is done according to the following rules
  - for type `eternal`, it never decreasess
  - for type `yogourt`, it decreasess by 5% per day
  - for type `vegetable`, it decreasess randomly by 20% to 25% per day
  - for type `mushroom`, it decreasess by 10% per day while it is greater than 50%, and then decreases by 5% per day
  - for type `meat`, it decreases by 10% per day during a random number of days between 3 and 5, and then decreases by 20% per day
  - for others type, it decreases randomly by 5% to 15% per day 
- the fridge also has the following features:
  - list all the products expiring tomorrow
  - list all the products with a set of tags
- the fridge is connected to our SmartRecognitionServer™, which give these informations about a product on scan
  - its name
  - a type of product (e.g. meat, vegetable, fruit...)
  - a set of tags (e.g. sweet, salty, healthy, organic...)

### Todo

Our customers reported that the fridge quickly becomes slow and needs frequents reboot since the `meat` update, you need to investiguate !

We want to introduce two new types with the following rules

- type `egg`, freshness decrease by 3% per day 
- type `fruit`, freshness decreases by 5% per day while it is greater than 25%, and then decrease by 15% per day