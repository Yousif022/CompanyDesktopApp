
package Entity;

import company.TheTools;
import javax.swing.JTable;




public class Department implements mainData{
    private int DeptNo;
    private String DeptName;
    private String Location;

    public int getDeptNo() {
        return DeptNo;
    }

    public void setDeptNo(int DeptNo) {
        this.DeptNo = DeptNo;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String DeptName) {
        this.DeptName = DeptName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    
    @Override
    public void add() {
        String Insert = " insert into department values (" 
                + DeptNo + ","
                + "'" + DeptName + "'," +
                 "'"+ Location + "')";
        
        boolean isAdded = db.go.runNonQuery(Insert);
                if(isAdded){
                    TheTools.msgBox("Department is Added");
                }
    }

    @Override
    public void update() {
        String Update = "update department set "
                + "DeptName= ' " + DeptName + " ' ,"
        + "Location= '" + Location + "' " 
               + "where DeptNo =" + DeptNo;
        
        boolean isUbdated = db.go.runNonQuery(Update);
        
        if(isUbdated){
            TheTools.msgBox("Department is Ubdated");
        }
        
    }

    @Override
    public void delete() {
        String delete = " delete from department "
               +  "where DeptNo =" + DeptNo;
        boolean isdeleted =db.go.runNonQuery(delete);
        if(isdeleted){
            
            TheTools.msgBox("Dept is Deleted");
        }
    }

    @Override
    public String getAutoNumber() {
        return db.go.getAutoNumber("department", "DeptNo");
    }

    @Override
    public void getAllRows(JTable table) {
        db.go.fillToJTable("department", table);
    }

    @Override
    public void getOneRow(JTable table) {
        String strSelect = "select * from department "
                +" where DeptNo= " + DeptNo;
        db.go.fillToJTable(strSelect, table);
    }

    @Override
    public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTable(Statement, table);
    }

    @Override
    public String getValueByname(String Name) {
        
        String strSelect = "select DeptNo from department " +
                "where DeptName= " + "'" + Name  + "'";
         String strVal = (String)db.go.getTableData(strSelect).Items[0][0];

        return strVal;

    }

    @Override
    public String getNameByValue(String Value) {
        
        
       String strSelect = " select DeptName from depatment " +
                "where DeptNo = " + Value;
       
     String strName =  (String) db.go.getTableData(strSelect).Items[0][0];


     return strName;

    }

  
    
}
