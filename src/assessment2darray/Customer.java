/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assessment2darray;


public class Customer implements Comparable {
    
        int id;
        String name;
        String age;
        String classType;
        String seatType;
        int seatRow;
        int seatColumn;
        
        public Customer() {
            
        }
        public Customer (int cId, String cName, String cAge, String cClassType, String cSeatType, int cSeatRow, int cSeatColumn ){
            id = cId;
            name = cName;
            age = cAge;
            classType = cClassType;
            seatType = cSeatType;
            seatRow = cSeatRow;
            seatColumn = cSeatColumn;
        }
        
        public int compareTo(Object o) {
            Customer c = (Customer) o;
            return this.name.compareTo(c.name);
        }
        
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(int seatColumn) {
        this.seatColumn = seatColumn;
    }

        public String toString() {
            String details = "";
            
            details = "Customer: " + name + " Age: " + age + " Class Type: " + classType + " Seat Type: " + seatType + " Seat Assigned: [" + seatRow + ", " + seatColumn + "]";
            
            return details;
        }
        
      
}
