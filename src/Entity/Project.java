
package Entity;

import company.TheTools;
import javax.swing.JTable;


public class Project implements mainData{
    private int ProjectNo;
    private String ProjectName;
    private String Location;
    private int DeptNO;

    public int getProjectNo() {
        return ProjectNo;
    }

    public void setProjectNo(int ProjectNo) {
        this.ProjectNo = ProjectNo;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String ProjectName) {
        this.ProjectName = ProjectName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Lcation) {
        this.Location = Lcation;
    }

    public int getDeptNO() {
        return DeptNO;
    }

    public void setDeptNO(int DeptNO) {
        this.DeptNO = DeptNO;
    }

    @Override
    public void add() {
        String strInsert = " insert into project values( "+
                ProjectNo + ",'" + ProjectName + "'," +
              "'" +  Location  + "'," + DeptNO + ")";
        boolean isAdded = db.go.runNonQuery(strInsert);
        if(isAdded){
            TheTools.msgBox("Project is Added");
        }
    }

    @Override
    public void update() {

        String strUpdate = "update project set " +
                
                "ProjectName= '" + ProjectName + "'," +
              "Location= '" + Location + "'," +
                      "DeptNo= " + DeptNO +
                " where ProjectNo = " + ProjectNo;
        boolean isupdated = db.go.runNonQuery(strUpdate);
        if(isupdated){
            TheTools.msgBox("Project is Updated");
        }
        
                      
    }

    @Override
    public void delete() {
        String strdelete = " delete from project " +
                " where ProjectNo= " + ProjectNo;
        boolean isdeleted = db.go.runNonQuery(strdelete);
        if(isdeleted){
            TheTools.msgBox("Project is Deleted");
        }
    }

    @Override
    public String getAutoNumber() {

        return db.go.getAutoNumber("project", "projectNo");
    }

    @Override
    public void getAllRows(JTable table) {
        db.go.fillToJTable("project", table);
    }

    @Override
    public void getOneRow(JTable table) {
       String strselect = "SELECT * FROM project WHERE ProjectNo = " + ProjectNo + ";";
              
        db.go.fillToJTable( strselect , table);
    }

    @Override
    public void getCustomRows(String Statement, JTable table) {
        db.go.fillToJTable( Statement, table);
    }

    @Override
    public String getValueByname(String Name) {

      String  strSelect = "select ProjectNo from project " +
                "where ProjectName= '" + Name + "'" ;
      String strval =(String) db.go.getTableData(strSelect).Items[0][0];
      return strval;
    }

    @Override
    public String getNameByValue(String Value) {

        String strselect = " select ProjectName from project " +
                "where ProjectNo= " + Value;
        String strName = (String)db.go.getTableData(strselect).Items[0][0];
        return strName;
    }
    
    
    
}
