# PointwiseWelcome

This is the demo application with two simple services:

package com.gedevanishvili.pointwisewelcome.services

ProducerService:
Every T1 seconds it generates tuples of type (string, random weight)
Where string is arbitrary string of size 4 and random weight is a random number from 1 to 10. After tuple is generated producer puts the tuple into priority queue.

ConsumerService:
Every T2 seconds it checks a queue. 
If there is a tuple in the queue Consumer takes it and updates the user view with the most important (with the largest weight) data and queue size.
If a Runtime Error occurs it returns tuple in the queue


package com.gedevanishvili.pointwisewelcome.data

Here are the classes for working with the data.

Priority queue is implemented in MaxHeap class which implements PQ interface.

In MyConfig class you can find config data of the application.


package com.gedevanishvili.pointwisewelcome.modules

There is PQManager Singleton class, which creates a single object for Priority Queue. All it's methods are synchronized, so it's thread-safe.

There is also RandomErrorGenerator class, that throws errors with 20% Probability, to imitate error in ConsumerService.
