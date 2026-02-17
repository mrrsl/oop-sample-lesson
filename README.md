Lab and sample solution written up as part of the missed OOP lesson for 12-02-2026.

## Lab Scenario
This lab will demonstrate the use of generics by implementing a train cart class that can hold generic types of cargo. Note that in this situation, using polymorphism would be better but this exercise is focused on learning how to use generics.
#### 1. Cargo Hierarchy
Every type of cargo extends the abstract base class:
```java
public abstract class Cargo implements Comparable<Cargo>
```
The train station handles exactly three types of cargo:
**Minerals**
Field: `double densityKgm3`
**Oil**
Field: `double apiGravity` (API Gravity measurement)
**Toys**
Field: `int lowAgeDemoYears`

You can use a subclass defined method or an abstract method on `Cargo` to handle comparisons between the different cargo subclasses.

#### 2. TrainCart Class (Using Lower-Bound Generics)
Each TrainCart can carry cargo of a specific type, but the scheduling system must allow future expansion to support superclasses of existing cargo types.
To support this, the station requires the use of upper-bounded generics (e.g., `T extends Cargo`) when loading cargo.
Each `TrainCart<T>` must include:
* A field of generic type `T` cargo
* A field `int grossWeightKgs` representing the cart’s current weight
* Accessor methods for all fields
#### 3. Train Class
A `Train<T>` represents an entire sequence of `TrainCart` objects.
It must contain:
* A field int grossWeight
* A field for the first TrainCart
* `void addCart(TrainCart<T> cart)` to attach this cart’s front couple to another cart’s back couple
* `void unhook()` to detach itself from the train
* A method `boolean compliantCartOrder()` that returns true so long as the front-to-back order of carts follow these rules for each cargo type:
    * Minerals: Densest carts at the back
    * Oil: Lower gravity carts at the front.
    * Toys: toys for younger children at the back
#### 4. What Students Will Implement
Students must write:
* `Cargo` (given abstract class)
* `Minerals`, `Oil`, `Toys` subclasses
* `TrainCart<T>` class
* `Train<T>` class
* A test driver (Main) that:
    * Creates some `TrainCarts`
    * Attaches the `TrainCarts` to a `Train`
    * Prints the final train configuration, weights, and whether the attachment order results in a compliant Train
