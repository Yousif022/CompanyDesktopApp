
package Entity;

import company.TheTools;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class Employee implements mainData{
    private int EmpNo;
    private String EmpName;
    private Double Salary;
    private String Adress;
    private String HiringDate;
    private String BirthDate;
    private int DeptNo;

    public int getEmpNo() {
        return EmpNo;
    }

    public void setEmpNo(int EmpNo) {
        this.EmpNo = EmpNo;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String EmpName) {
        this.EmpName = EmpName;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double Salary) {
        this.Salary = Salary;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    public String getHiringDate() {
        return HiringDate;
    }

    public void setHiringDate(String HiringDate) {
        this.HiringDate = HiringDate;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String BirthDate) {
        this.BirthDate = BirthDate;
    }

    public int getDeptNo() {
        return DeptNo;
    }

    public void setDeptNo(int DeptNo) {
        this.DeptNo = DeptNo;
    }

    @Override
    public void add() {
        String Insert = " insert into employee values ( " 
                  + EmpNo + "," 
                +"'" +EmpName + "', "
                + Salary + "," +
                "'" + Adress  + "'," 
               + "'" + BirthDate + "'," 
               + "'" + HiringDate + " '," +    
                      + DeptNo +  ")";
                
       String  isAdded = (db.go.runNonQuery(Insert)) ? "The Info is added at Employee ’s Table"  : "There is a problem";
         JOptionPane.showMessageDialog(null, isAdded);
        
    }

    @Override
    public void update() {
        String Update = "update employee set " 
                + " EmpName= ' " + EmpName +"'," 
                + "Salary= " + Salary + "," +
               
        "Adress= '" + Adress + "',"
        + "HiringDate='" + HiringDate + "'," 
                + "BirthDate='" + BirthDate + "'," +
                "DeptNo=" + DeptNo 
               + "  where EmpNo = " + EmpNo;
        boolean isUpdated = db.go.runNonQuery(Update);
        if(isUpdated) {
            TheTools.msgBox("Employee  is Updated");
        }
        
    }

    @Override
    public void delete() {
        String delete = " delete from employee where " +
                "EmpNo= " + EmpNo;
        boolean isdeleted = db.go.runNonQuery(delete);
        if(isdeleted){
            TheTools.msgBox("The info is Deleted");
        }
    }

    @Override
    public String getAutoNumber() {
        return db.go.getAutoNumber("employee", "EmpNo");
    }

    @Override
    public void getAllRows(JTable table) {
            db.go.fillToJTable("employee", table);
        }

    @Override
    public void getOneRow(JTable table) {
         String StrSelect = "select * from employee where "+
                 "EmpNo = " + EmpNo;
                 db.go.fillToJTable(StrSelect, table);

    }

    @Override
    public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTable(Statement, table);
    }

    @Override
    public String getValueByname(String Name) {
         String  strSelect = "select EmpNo from employee " +
                "where EmpName= '" + Name + "'" ;
      String strval =(String) db.go.getTableData(strSelect).Items[0][0];
      return strval;
    }

    @Override
    public String getNameByValue(String Value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
