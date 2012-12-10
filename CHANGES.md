#Changes

## jdk8-lambda-b67
+ The package 'java.util.functions' has been renamed 'java.util.function'
+ The package 'java.util.streams' has been renamed 'java.util.stream'
+ The class 'java.util.functions.Mapper<R, T>' has been deleted. Now, we use 'java.util.function.Function<T, R>'
+ For Defenders, the 'default' keyword MUST be at the beginning of the abstract method