What
====

Sample code for basic osgi test with the following bundles 
- be.rds.messaging: public api that is exported and available for other bundles
- be.rds.messaging.provider: contains the(or an) implementation of the provided API.
This is not exported but is made available using using OSGI Service Registry to couple the implementation to the allready available public API.
- be.rds.messaging.consumer: is a bundle which uses the OSGI service via the available public API and the OSGI Service Registry.

Notes
-----
* The whole idea here is that there is no runtime dependency on the bundle containing the implmentation. The only requirements to trigger the service are
- public api must be available to the consumer (consumer has dependency on public api)
- at least one bundle who provides an implementation and 'links' it to the public api via the OSGI registry.
* Important!! Make sure the bundles containing the public api and the provider are started BEFORE the consumer! If not the consumer might get a null for the service because it was not registered yet ... . You can set the run level of the consuming bundle higher then that of the other 2 bundles to solve this problem.

TODO
====
1. Add second and third implementation and use priorities to define which one is used.
Then you can deactivate and activate implementations at runtime and see what happens.
--> mind this will only work when the service is retrieved for each call i guess...
2. Create project with Declarative Services for the same example
3. Create project with Eclipse Gemini (continuation of Spring DM) with same sample

