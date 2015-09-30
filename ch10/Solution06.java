package Ch10;
/* Image you have a 20GB file with one string per line. Explain how you would sort the file.*/

/*Answer:
 * I will use the external sort method.
 * (1)Pre-treatment:
 * Divide the file with n records to be m sub-files with length t;
 * Sort the content of sub-files and write them in the external memory with m runs.
 * (2) Merge sort:
 * Merge the subfiles by sorting the smallest record in each sub-file and put the subfile 
 * from input cache into the output cache using the search tree. */