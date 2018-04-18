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
        
     /*   public static int compare(Customer a, Customer b)
        {
            return a.getName().compareTo(b.getName());
        }*/
        
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
        
        
        
        
        

    @Override
    public int compareTo(Object o) {     
        if (o == null){
            return 1;
        }
        if (this.name==null) {
            return -1;
        }
        
        Customer c = (Customer) o; 
       
        int result = nullSafeStringComparator(this.name, c.name);
        //if (result != 0) {
            return result;
        //}
        //return nullSafeStringComparator(this.age, c.age);        
    }

    public static int nullSafeStringComparator(final String one, final String two) {
        if (one == null ^ two == null) {
            return (one == null) ? -1 : 1;
        }
        if (one == null && two == null) {
            return 0;
        }
        return one.compareToIgnoreCase(two);
    }


       

  


       
      
}
