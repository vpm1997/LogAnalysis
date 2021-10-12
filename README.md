This is the project for analysing log files.

Architecture :

App takes file paths as inputs.
App calls file handler to get custom file object.
App creates a Process Manager object.
App calls Process Manager with list of custom files and gets results object.
Process Manager creates Synchornized Results object.
Then Manager creates a Worker object for every file.
Manager gets fix size thread pool executor from Executor Pool and submits the Worker thread object for processing.
Worker thread pushes the results in the Synchornized Results object.
Manger calls shut down on Executor Pool Manger and returns results object.
App calls print results method of results object.

Concurrency Mangement:

 Synchornized results class have a sychornized block for maintaining concurrency in the results.
 Used concurrenthashmap to store results for improving on consistency.
 Executor of fix size(5) have been created by Executor Pool class for parallel processing.

How to run Application:

Run the main method of App Class.
Provide total file count.
Provide the file paths.
Results will be printed on stdout.

Sample Files:

Ran application on sample files situated in staticfiles folder.
Results are in the results.log folder.







