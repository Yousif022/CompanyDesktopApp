
package Entity;

import company.TheTools;
import javax.swing.JTable;


public class Employee_Phones implements mainData{
    private int EmpNo;
    private String Phone;

    @Override
    public void add() {
        String strinsert = " insert into phones values ( " +
                EmpNo  + "," +
               "'" + Phone + "')";
        boolean isAdded = db.go.runNonQuery(strinsert);
        if(isAdded){
         //   TheTools.msgBox("The Phones Numbers Have Added");
        }
    }

    @Override
    public void update() {
        /*
        String strselect = " updaate phones set " +
                "EmpNo= "  + EmpNo  + "," +
                 "Phone= " + "'" + Phone + "'";
        boolean isUpdated = db.go.runNonQuery(strselect);
        if(isUpdated){
*/
            TheTools.msgBox("Update Methode In Phone Class isnot Workink !!");
        
    }

    @Override
    public void delete() {
        String delete = "delete from phones " + 
                "where EmpNo= " + EmpNo + " and Phone= '" +
                Phone + "'";
        boolean isdeleted = db.go.runNonQuery(delete);
        if(isdeleted){
           // TheTools.msgBox("The Phones Numbers Have deleted");
        }
    }

    public void deletebyEmp(){
        String strdelete = " delete from phones where " +
                "EmpNo= " + EmpNo;
        boolean isdeleted = db.go.runNonQuery(strdelete);
        if(isdeleted){
           // TheTools.msgBox ("The Phones is deleted ");
        }
        
        
    }
    @Override
    public String getAutoNumber() {
        TheTools.msgBox("getAutoNumber Methode In Phone Class isnot Workink !!");
        return "";
    }

    @Override
    public void getAllRows(JTable table) {
try{
       String strSelect = "select phone from phones " +
               " where EmpNo = " + EmpNo;
        db.go.fillToJTable(strSelect, table);
}
 catch(Exception ex){
          TheTools.msgBox(ex.getMessage());
      }
    }

    @Override
    public void getOneRow(JTable table) {
TheTools.msgBox("getOneRow Methode In Phone Class isnot Workink !!");    }

    @Override
    public void getCustomRows(String Statement, JTable table) {
TheTools.msgBox("getCustomRows Methode In Phone Class isnot Workink !!");    }

    @Override
    public String getValueByname(String Name) {
TheTools.msgBox("getValueByname Methode In Phone Class isnot Workink !!");  
    return "";
    }

    @Override
    public String getNameByValue(String Value) {
TheTools.msgBox("getNameByValue Methode In Phone Class isnot Workink !!");
return "";
    }

    public int getEmpNo() {
        return EmpNo;
    }

    public void setEmpNo(int EmpNo) {
        this.EmpNo = EmpNo;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
    
    public String getEmpNoByPhone(String RequestPHone){
      String strSelect = " select Empno from phones " +
                " where phone= '" + RequestPHone + "'";
        Object row[][] = db.go.getTableData(strSelect).Items;
        String strEmpNo = " ";
        if(row.length >0 ){
            strSelect = (String)row[0][0];
        }
        else{
            strSelect = "0";
        }
        
        
        return strSelect;
    }
    
    
    
    
    
    
}
