# Critters

In this program, there are 4 main java classes: Main, Critter, CritterWorld and Point. And then we also added Critters 1,2,3,4 and also CritterTest for testing purposes.

Main was given to us, and in it, all the input operations the user may use are defined and given code to do the given tasks.

Critter was given to us as well. In it is the filled in methods given as well as a few extra added: addCritter and handleInteractions. 
addCritter: adds the critter to CritterWorld, giving it a location and such
handleInteractions: handles fights and when critters are in the same space as each other.

CritterWorld is a new class that we made. It has a 2D array of strings, for storing the critter toStrings for printing. It also has 2 hashmaps for storing the critters and babies in the world and all their data and such.also has int width and height. 
CritterWorld has lots of fun and entertaining methods. Here are some examples: 
addCritter: adds a critter at a point into the critterMap
isOccupied: checks to see if location has a critter stored in it
makeAlgae: adds algae into the world
tryMove: attempts to move the critter during fight stage, checking if the critter can move
removeDead: removes the dead from the world
doTimeStep: goes through all the critters in world and calls their timeStep
getRandomLocation: returns a random location
addBabies: add babies from the babies HashMap
clearWorld: clears the world
printWorld: prints world to consule or file
topBottomRow: returns a string for output on the top and bottom of the display
cleanWorld: resets output matrix

Point is a new class that we made so that we werent having to deal with 2 ints for locations. it has a constructor, and getters and setters. It also has an update which intakes a direction and updates the point to the location in the direction from the original point. And it has an equals method to compare points. 


