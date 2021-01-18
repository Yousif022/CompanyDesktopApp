
package Entity;

import company.TheTools;
import javax.swing.JTable;

public class WorkOn implements mainData{
    private int EmpNo;
    private int ProjectNo;
    private String EmpName;
    private String ProjName;
    

    public int getEmpNo() {
        return EmpNo;
    }

    public void setEmpNo(int EmpNo) {
        this.EmpNo = EmpNo;
    }

    public int getProjectNo() {
        return ProjectNo;
    }

    public void setProjectNo(int ProjectNo) {
        this.ProjectNo = ProjectNo;
    }

    @Override
    public void add() {
        String strinsert = " insert into WorkNo values( " +
                EmpNo + " , " +
                ProjectNo; 
        boolean isadded = db.go.runNonQuery(strinsert);
        if(isadded){
            TheTools.msgBox("The ifo is Added.....");
            
        }

    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        String strdelete = " delete from WorkOn where "
                + "EmpNo= " + EmpNo + " And " +
                "ProjectNo= " +ProjectNo;
        boolean isdelete = db.go.runNonQuery(strdelete);
        if(isdelete){
            TheTools.msgBox("The info is deleted");
        }
    }

    @Override
    public String getAutoNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getAllRows(JTable table) {
        try{
        db.go.fillToJTable("WorkOn", table);
        }
        catch(Exception ex){
          TheTools.msgBox(ex.getMessage());
      }

    }

    @Override
    public void getOneRow(JTable table) {
        String strSelect = " select * from WorkOn where " +
                "EmpNo= " + EmpNo + " And " + 
                "ProjectNo= " + ProjectNo;
        db.go.fillToJTable(strSelect, table);

    }

    @Override
    public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTable(Statement, table);

    }

    @Override
    public String getValueByname(String Name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNameByValue(String Value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String EmpName) {
        this.EmpName = EmpName;
    }

    public String getProjName() {
        return ProjName;
    }

    public void setProjName(String ProjName) {
        this.ProjName = ProjName;
    }
    
    
}
