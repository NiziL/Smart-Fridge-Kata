# Smart Fridge

> This Kata has been designed as a final hands-on exam for undergraduate students at [IUT Charlemagne](https://iut-charlemagne.univ-lorraine.fr/).  
> It borrows many ideas from [Gilded Rose](https://github.com/emilybache/GildedRose-Refactoring-Kata) and [Trip Service](https://github.com/sandromancuso/trip-service-kata).
> Kudos to Emily Bache and Sandro Mancuso for these amazing kata !

Welcome to Smart Stuff Society !

You are now in charge of our SmartFridge™ internal software.
Your job is to implement the next update, detailed in the [todo](https://github.com/NiziL/Smart-Fridge-Kata#todo) section.  
The original developper left few weeks ago, mentioning that "the code is a little messy" so feel free to refactor it as you wish !  
However, you **MUST NOT** change the files in the `protocol` subpackage.

### Current system

- every day, the fridge run the following routine
  - scan every new products
- every day, the fridge decrements all the freshness of products according to the following rules
  - freshness cannot be negative
  - for type `yogourt`, freshness decrease by 5% per days
  - for type `vegetable`, freshness decrease by 10% per days
  - for type `mushroom`, freshness decrease by 10% per days while freshness is greater than 50%, and then decrease by 5% per days
  - for type `meat`, freshness decrease by 10% per days during three days, and then decrease by 20% per days
- the fridge also has the following features:
  - list all the products expiring tomorrow
  - list all the products with a set of tags
- the fridge is connected to our SmartRecognitionServer™, which give these informations about a product on scan
  - its name
  - a type of product (e.g. meat, vegetable, fruit...)
  - a set of tags (e.g. sweet, salty, healthy, organic...)

### Todo

##### Critical bugfix

It seems that the listing of products according to a set of tags is not working very well, fix it and write a test for it, so we never see it again !

##### New feature

We want to introduce two new types with the following rules

- `fruit`, freshness decrease by 5% per days while freshness is greater than 25%, and then decrease by 15% per days
- `egg`, freshness decrease by 15% per days during 5 days, and then decrease by 1% per days
