/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assessment2darray;


public class Customer {
   
        String name;
        String age;
        String classType;
        String seatType;
        int seatRow;
        int seatColumn;
        
        public Customer() {
            
        }
        public Customer (String cName, String cAge, String cClassType, String cSeatType, int cSeatRow, int cSeatColumn ){
            name = cName;
            age = cAge;
            classType = cClassType;
            seatType = cSeatType;
            seatRow = cSeatRow;
            seatColumn = cSeatColumn;
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

        
        
      
}
