public class TrainLine {

    private static final String DEFAULT_NAME = "Hogwarts Express";

    /** The name of the train line */
    private String name;
    /** The head station of the train line */
    private Station head;
    /** Current number of stations in the line */
    private int numberOfStations;
    /** The tail station of the train line */
    private Station tail;

    /** Basic constructor */
    public TrainLine(String name) {
        this.name = name;
        this.head = null;
        this.numberOfStations = 0;
        this.tail = null; // Initalize the reference
    } // basic constructor

    /** Default constructor */
    public TrainLine() {
        this(DEFAULT_NAME);
    } // default constructor

    /** Accessor for the number of stations */
    public int getNumberOfStations() {
        return this.numberOfStations;
    }

    /**
     * Adds a new station after the last station
     * 
     * Strategy: Instead of traversing the entire list to find last station,
     * keep a 'tail' referenec that always points to the last station of line.
     * 
     * 
     * Steps:
     * 1. Keep a 'tail' reference variable that points to last station
     * 2. When adding first station, both head and tail point to it
     * 3. When adding other stations, use tail.setnNext() method and update tail
     * 4. Should eliminate the need for the while loop
     * @param name String with name of new station to create and add
     */
    public void add(String name) {
        Station newStation = new Station(name);
        if (this.head == null) {
            // No stations exist in this line. Make this new station
            // the head station of the line
            this.head = newStation;
            this.tail = newStation;
        } else {
            // Instead of traversing list, use tail reference
            this.tail.setNext(newStation);
            this.tail = newStation; // Update tail to point to new last station

            }
            
            this.numberOfStations = this.numberOfStations + 1;
        } // method add

    /**
     * Finds how many stations are in a train line
     * 
     * METHOD MADE OBSOLETE BY INTRODUCTING TrainLine.numberOfStations
     */
    public int stationCounter() {
        int counter = 0;
        if (this.head != null) {
            // Train line not empty
            Station cursor = this.head;
            while (cursor != null) {
                counter = counter + 1;
                cursor = cursor.getNext();
            }
        }
        return counter;
    } // method countStations

    /**
     * Returns the position of named station in train line
     * @param stationName the name of the station to search for
     * @return the position of that station, or -1 if not found
     */

    public int indexOf(String stationName) {
        int index = 0;
        Station cursor = this.head;

        while (cursor != null) {
            if (cursor.getName().equals(stationName)) {
                return index;
                
            }
            cursor = cursor.getNext();
            index++;
        
        }

        return -1;
       
    } // method indexOf

    /**
     * Checks if the named station is in the train line
     * 
     * @param stationName the name of the station to search for
     * @return true if station is found, false otherwise
     * 
     * 
     */

     public boolean contains(String stationName) {
        // Start the traversal from head
        Station cursor = this.head;

        // Traverse the entire linked-list
        while (cursor != null) {
            // Compare current station's name with the target station name
            // Using .equals() for proper String comparison (not ==)
            if (cursor.getName().equals(stationName)) {
                // Station found return true
                return true;
            }

            // Move on to next station in the line

            cursor = cursor.getNext();
        }

        // Traversed entire list without finding the station
        // Return false to indicate station is not present

        return false;
     }


    /**
     * String representation of the object
     */
    private static final String EMPTY_TRAIN_LINE = "The train line is empty";
    private static final String TRAIN_LINE_HEADER = "\"%s\" has the following stations: %s";
    private static final String NEXT_ARROW = " --> ";

    public String toString() {
        if (this.head == null) {
            return EMPTY_TRAIN_LINE;
        } else {
            String stations = String.format(TRAIN_LINE_HEADER, this.name, this.head.getName());
            Station cursor = this.head.getNext();
            while (cursor != null) {
                stations = stations + NEXT_ARROW + cursor.getName();
                cursor = cursor.getNext();
            }
            return stations;
        }
    } // method toString
} // class TrainLine
