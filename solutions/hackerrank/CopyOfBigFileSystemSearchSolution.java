package hackerrank;

/*
 * public class CopyOfBigFileSystemSearchSolution {
 * 
 * DataFile[] inputFiles; QueryFile[] allQueries;
 * 
 * public static void main(String[] args) { CopyOfBigFileSystemSearchSolution
 * testSystem1 = new CopyOfBigFileSystemSearchSolution(); // 1. Read all N
 * inputs and Q queries and save in respective data structures
 * testSystem1.readInput();
 * 
 * // 2. Process Queries based on type testSystem1.processQuery(); }
 * 
 * // read file and queries public void readInput() { // read all inputs and put
 * into array of DataFile Scanner in = new Scanner(System.in); int N =
 * in.nextInt();
 * 
 * inputFiles = new DataFile[N];
 * 
 * for (int i = 0; i < N; ++i) { // read and scan each file description int M =
 * in.nextInt(); int tempArray[] = new int[M];
 * 
 * // read and add to an array for (int j = 0; j < M; ++j) { tempArray[j] =
 * in.nextInt(); } inputFiles[i] = new DataFile(tempArray, M); }
 * 
 * // read all Queries // 1. Read total number of queries int Q =
 * in.nextInt();// total no of queries allQueries = new QueryFile[Q];
 * 
 * int index = 0; String oneLine; while (index < Q && in.hasNextLine()) {
 * oneLine = in.nextLine(); if (oneLine.length() == 0) continue;
 * 
 * // split the line based on space String temp[] = oneLine.split(" "); //
 * temp[0] = type; // temp[1] = length of query
 * 
 * if (index < Q) allQueries[index++] = new QueryFile(temp); else break; }
 * in.close(); }
 * 
 * // process Queries public void processQuery() { //process all queries final
 * int numberOfQueries = allQueries.length; int[] result = new
 * int[numberOfQueries];
 * 
 * QueryFile oneQuery = null; for(int i = 0 ; i < numberOfQueries; ++i){
 * oneQuery = allQueries[i]; int type = oneQuery.type;
 * 
 * switch(type){ case 1: result[i] = queryAll(oneQuery.mapQueryNumber); break;
 * case 2: result[i] = queryAny(oneQuery.mapQueryNumber); break; case 3:
 * result[i] = querySome(oneQuery.mapQueryNumber); } } for(int i : result)
 * System.out.println(i); }
 * 
 * private int queryAll(HashMap<Integer, Integer> queryMap) { int resultQueryAll
 * = 0; HashMap<Integer, Integer> ithFileMap = null; // compare two HashMaps for
 * (int fileIndex = 0; fileIndex < inputFiles.length; ++fileIndex) { boolean
 * query_all_flag = true; ithFileMap = inputFiles[fileIndex].mapFileNumber; for
 * (Map.Entry<Integer, Integer> query : queryMap.entrySet()) { Integer queryKey
 * = query.getKey(); Integer queryValue = query.getValue();
 * 
 * Integer fileValue = ithFileMap.get(queryKey); if(fileValue == null ||
 * fileValue < queryValue){ query_all_flag = false; break; } } //for current
 * file, if (query_all_flag) resultQueryAll++; } return resultQueryAll; }
 * 
 * private int queryAny(HashMap<Integer, Integer> queryMap) { int resultQueryAny
 * = 0; HashMap<Integer, Integer> ithFileMap = null; // compare two HashMaps for
 * (int fileIndex = 0; fileIndex < inputFiles.length; ++fileIndex) { boolean
 * query_one_flag = false; ithFileMap = inputFiles[fileIndex].mapFileNumber;
 * 
 * for (Map.Entry<Integer, Integer> query : queryMap.entrySet() ) { Integer
 * queryKey = query.getKey();
 * 
 * Integer fileValue = ithFileMap.get(queryKey);
 * 
 * if(fileValue != null){ query_one_flag = true; break; } } if (query_one_flag)
 * resultQueryAny++; } return resultQueryAny; }
 * 
 * private int querySome(HashMap<Integer, Integer> queryMap) { int
 * resultQuerySome = 0; HashMap<Integer, Integer> ithFileMap = null; // compare
 * two HashMaps for (int fileIndex = 0; fileIndex < inputFiles.length;
 * ++fileIndex) { ithFileMap = inputFiles[fileIndex].mapFileNumber; boolean
 * query_one_flag = false; boolean query_all_flag = true;
 * 
 * for (Map.Entry<Integer, Integer> query : queryMap.entrySet()) { Integer
 * queryKey = query.getKey(); Integer queryValue = query.getValue();
 * 
 * Integer fileValue = ithFileMap.get(queryKey); if (fileValue == null ||
 * fileValue < queryValue) { query_all_flag = false; if (query_one_flag ||
 * fileValue != null) break; } else query_one_flag = true; } if (!query_all_flag
 * && query_one_flag) resultQuerySome++; } return resultQuerySome; }
 * 
 * // public void showInput(){ // for(int i = 0; i < files.length; ++i){ //
 * System.out.println((i+1) + " - Numbers in file " + // files[i].totalNumbers);
 * // //display count // Set<Integer> keySet = files[i].countOfNumbers.keySet();
 * // for(Integer oneKey : keySet ){ // System.out.println(oneKey + " - " +
 * files[i].countOfNumbers.get(oneKey)); // } // System.out.println(""); // } //
 * } }
 * 
 * 
 * // internal dataStructure for a query data class QueryFile { int[] array =
 * null; int type; int length; HashMap<Integer, Integer> mapQueryNumber;
 * 
 * // constructor public QueryFile(String[] stringToken) {
 * 
 * this.type = Integer.parseInt(stringToken[0]); this.length =
 * Integer.parseInt(stringToken[1]); this.mapQueryNumber = new HashMap<Integer,
 * Integer>();
 * 
 * int tempKey = 0; Integer prevListing = null; for (int i = 0; i < this.length;
 * ++i) { tempKey = Integer.parseInt(stringToken[i + 2]);
 * 
 * //get previous count, get returns null, if key not present prevListing =
 * mapQueryNumber.get(tempKey);
 * 
 * if (prevListing == null) mapQueryNumber.put(tempKey, 1); else
 * mapQueryNumber.put(tempKey, (prevListing + 1)); } }
 * 
 * 
 * // show QueryFile public void displayQuery() {
 * System.out.printf("%s %d, Length = %d \nElements are { ",
 * "The type of Query is ", this.type, this.length); for (int i = 0; i <
 * this.length; ++i) System.out.printf("%d ", array[i]);
 * 
 * System.out.print(" }\n"); }
 * 
 * }
 * 
 * // internal data structure for Input file. class DataFile { HashMap<Integer,
 * Integer> mapFileNumber; int totalNumbers;
 * 
 * // default constructor public DataFile() { mapFileNumber = null; totalNumbers
 * = 0; }
 * 
 * // constructor public DataFile(int[] array, int length) { this.mapFileNumber
 * = new HashMap<Integer, Integer>(); this.totalNumbers = length; // scan and
 * add to hashmap int key = 0; Integer prevListing = 0; for (int i = 0; i <
 * length; ++i) { key = array[i]; prevListing = mapFileNumber.get(key);
 * 
 * if (prevListing == null) mapFileNumber.put(key, 1); else
 * mapFileNumber.put(key, (prevListing+1) ); } } }
 */