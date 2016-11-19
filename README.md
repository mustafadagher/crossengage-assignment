# CrossEngage Assignment

## Run
java -jar target/crossengage-assignment-0.0.1.jar users_file_path  batchSize <optional>

##### users_file_path: 
      the file path of the users, user entries should be formatted in csv like format
##### batchSize: 
      the size of each chunk 


## Performance
In case of very large files, it's unacceptable to load all users and send them email in one shot!
I've handled this by using a BlockingQueue in which I collect user entries until the queue size meets the configured (default of 1000 if not configured) batchSize, or the file ends
 
### Author
Mustafa Dagher <dagher.mustafa@gmail.com>
