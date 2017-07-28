package chapter10SortingAndSearching;

/**
 * 
 * Problem: Imagine you have a 20 GB file with one string per line. Explain how
 * you would sort the file.
 * 
 * Solution: Divide the file into N chunks which are x megabytes each, where x
 * is the amount of memory we have available. Each chunk is sorted separately
 * and then saved back to the file system. Once all the chunks are sorted, we
 * then merge the chunks according to the following algorithm:
 * 
 * 1. Divide your memory into (N+1) parts. First N parts are used to read data
 * from N chunks, the last one is used as a buffer.
 * 
 * 2. Load data to fill the first N data parts from N chunks respectively,
 * perform an N-way merge sort to the buffer.
 * 
 * 3. While any data part is not empty, perform sort to the buffer.
 * 
 * 4. If any data part is empty, load new content from the corresponding chunk.
 * 
 * 5. If the buffer is full, write buffer to the disk as output file, clear
 * buffer.
 * 
 * 6. Repeat step 4-5 until all N chunks and buffer are empty.
 * 
 * At the end, we have output that is fully sorted on the disk. This algorithm
 * is known as external sort.
 * 
 * One example of external sorting is the external merge sort algorithm, which
 * sorts chunks that each fit in RAM, then merges the sorted chunks
 * together.[1][2] For example, for sorting 900 megabytes of data using only 100
 * megabytes of RAM:
 * 
 * 1. Read 100 MB of the data in main memory and sort by some conventional
 * method, like quicksort.
 * 
 * 2. Write the sorted data to disk.
 * 
 * 3. Repeat steps 1 and 2 until all of the data is in sorted 100 MB chunks
 * (there are 900MB / 100MB = 9 chunks), which now need to be merged into one
 * single output file.
 * 
 * 4. Read the first 10 MB (= 100MB / (9 chunks + 1)) of each sorted chunk into
 * input buffers in main memory and allocate the remaining 10 MB for an output
 * buffer. (In practice, it might provide better performance to make the output
 * buffer larger and the input buffers slightly smaller.)
 * 
 * 5. Perform a 9-way merge and store the result in the output buffer. Whenever
 * the output buffer fills, write it to the final sorted file and empty it.
 * Whenever any of the 9 input buffers empties, fill it with the next 10 MB of
 * its associated 100 MB sorted chunk until no more data from the chunk is
 * available. This is the key step that makes external merge sort work
 * externally -- because the merge algorithm only makes one pass sequentially
 * through each of the chunks, each chunk does not have to be loaded completely;
 * rather, sequential parts of the chunk can be loaded as needed.
 *
 */
public class SortBigFile {

}
