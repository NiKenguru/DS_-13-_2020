                                             Отчет по самостоятельной работе 1
                                                        Вариант13
                                                    Магазин цветов
Цель: освоение базового уровня программирования Java.
1) Код программы:

Tovar.java

package types;

public class Tovar {

    public Tovar() {
        this.name = "";
        this.kol = 0;
        this.price = 0;
    }

    public Tovar(String name, int kol, double price) {
        this.name = name;
        this.kol = kol;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKol() {
        return kol;
    }

    public void setKol(int kol) {
        this.kol = kol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    private String name;
    private int kol;
    private double price;
}

TovarOperation.java

package operation;
import java.util.List;
import types.Tovar;


public interface TovarOperation {
List<Tovar> getListOfTovar();
List<Tovar> addNewTovar(Tovar item);
int getSumOfTovar();
}
  
 
TovarOperationImpl.java

package operation;
import java.util.ArrayList;

import java.util.List;

import types.Tovar;
public class TovarOperationImpl implements TovarOperation{
    static List<Tovar> lstTovar = new ArrayList<Tovar>();


@Override

public List<Tovar> getListOfTovar(){

return lstTovar;

}

@Override

public List<Tovar> addNewTovar(Tovar item){

lstTovar.add(item);

return lstTovar;

}

@Override

public int getSumOfTovar(){

int sum = 0;

for(Tovar tovar: lstTovar)

sum += tovar.getKol() * tovar.getPrice();

return sum;

}
}

Frame.java
package base;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import operation.TovarOperationImpl;
//import types.Buketi;
//import operation.BuketiOperationImpl;
import types.Tovar;
 
public class Frame extends javax.swing.JFrame {


    public Frame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    
    TovarOperationImpl tovarOperation = new TovarOperationImpl();
    static DefaultTableModel model = new DefaultTableModel();
 
 ...
 
    private void ContactsActionPerformed(java.awt.event.ActionEvent evt) {                                         
    dlgContacts.setSize(300, 320);
    dlgContacts.setLocationRelativeTo(null);
    dlgContacts.setVisible(true);    // TODO add your handling code here:
    }                                        

    private void BuyActionPerformed(java.awt.event.ActionEvent evt) {                                    
    dlgTabl.setSize(300, 320);
    dlgTabl.setLocationRelativeTo(null);
    dlgTabl.setVisible(true);         // TODO add your handling code here:
    }                                   

    private void cmbNameFActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {                                       
    dlgCat.setSize(300, 320);
    dlgCat.setLocationRelativeTo(null);
    dlgCat.setVisible(true);        // TODO add your handling code here:
    }                                      

    private void btnDecideActionPerformed(java.awt.event.ActionEvent evt) {                                          
    txt.setText(Integer.toString(tovarOperation.getSumOfTovar()));        // TODO add your handling code here:
    }                                         

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {                                        
    dlgTabl.setVisible(false);       // TODO add your handling code here:
    }                                       

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {                                     
    setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    System.exit(0);        // TODO add your handling code here:
    }                                    

    private void dlgTablWindowOpened(java.awt.event.WindowEvent evt) {                                     
        model = (DefaultTableModel)tbl.getModel();
    }                                    

    private void scrPriceFAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {                                                 
            lblPriceInfoF.setText(Integer.toString((int) scrPriceF.getValue()));        // TODO add your handling code here:
    }                                                

    private void scrPriceBAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {                                                 
        lblPriceInfoB.setText(Integer.toString((int) scrPriceB.getValue()));        // TODO add your handling code here:
    }                                                

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {                                          
    dlgCat.setVisible(false);        // TODO add your handling code here:
    }                                         

    private void btnCancelFActionPerformed(java.awt.event.ActionEvent evt) {                                           
    dlgAddFlover.setVisible(false);           // TODO add your handling code here:
    }                                          

    private void btnCancelBActionPerformed(java.awt.event.ActionEvent evt) {                                           
    dlgAddBuketi.setVisible(false);        // TODO add your handling code here:
    }                                          

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {                                          
    DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        try
        {
             int SelectRowIndex =tbl.getSelectedRow();
            model.removeRow(SelectRowIndex);
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }        // TODO add your handling code here:
    }                                         

    private void btnAddFActionPerformed(java.awt.event.ActionEvent evt) {                                        
    dlgAddFlover.setVisible(false);
        // д.б. код для проверки полей на правильность ввода
        Tovar el;
            el = new Tovar(cmbNameF.getSelectedItem().toString(), (int) spnKolF.getValue(), scrPriceF.getValue());
        doVivod(tovarOperation.addNewTovar(el));
    }                                           

    private void doVivod(List<Tovar> lstTovar){
        doClearTable();
        int i = 1;
        for(Tovar tovar: lstTovar){
            Object[] rowData = new Object[5];
            rowData[0] = i++;
            rowData[1] = tovar.getName();
            rowData[2] = tovar.getPrice();
            rowData[3] = tovar.getKol();
            rowData[4] = tovar.getPrice() * tovar.getKol();
            model.addRow(rowData);
        }
        // TODO add your handling code here:
    }                                       

    private void btnAddBActionPerformed(java.awt.event.ActionEvent evt) {                                        
    dlgAddBuketi.setVisible(false);
        // д.б. код для проверки полей на правильность ввода
        Tovar el;
        
            el = new Tovar(cmbNameB.getSelectedItem().toString(), (int) spnKolB.getValue(), scrPriceB.getValue());
        
            
      
        doVivod(tovarOperation.addNewTovar(el));        // TODO add your handling code here:
    }                                       

    private void btnFloverActionPerformed(java.awt.event.ActionEvent evt) {                                          
    dlgAddFlover.setSize(300, 320);
    dlgAddFlover.setLocationRelativeTo(null);
    dlgAddFlover.setVisible(true); 
    dlgCat.setVisible(false);// TODO add your handling code here:
    }                                         

    private void btnBuketiActionPerformed(java.awt.event.ActionEvent evt) {                                          
    dlgAddBuketi.setSize(300, 320);
    dlgAddBuketi.setLocationRelativeTo(null);
    dlgAddBuketi.setVisible(true); 
    dlgCat.setVisible(false);     // TODO add your handling code here:
    }                                         

    private void scrPriceRMAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {                                                  
       lblPriceInfoRM.setText(Integer.toString((int) scrPriceRM.getValue())); // TODO add your handling code here:
    }                                                 

    private void cmbNameRMActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void btnAddRMActionPerformed(java.awt.event.ActionEvent evt) {                                         
      dlgRM.setVisible(false);
        // д.б. код для проверки полей на правильность ввода
        Tovar el;
            el = new Tovar(cmbNameRM.getSelectedItem().toString(), (int) spnKolRM.getValue(), scrPriceRM.getValue());
        doVivod(tovarOperation.addNewTovar(el));
    }                                        

    private void btnCancelRMActionPerformed(java.awt.event.ActionEvent evt) {                                            
       dlgRM.setVisible(false);   // TODO add your handling code here:
    }                                           

    private void scrPriceSJAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {                                                  
      lblPriceInfoSJ.setText(Integer.toString((int) scrPriceSJ.getValue()));  // TODO add your handling code here:
    }                                                 

    private void cmbNameSJActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void btnAddSJActionPerformed(java.awt.event.ActionEvent evt) {                                         
         dlgSJ.setVisible(false);
        // д.б. код для проверки полей на правильность ввода
        Tovar el;
            el = new Tovar(cmbNameSJ.getSelectedItem().toString(), (int) spnKolSJ.getValue(), scrPriceSJ.getValue());
        doVivod(tovarOperation.addNewTovar(el));// TODO add your handling code here:
    }                                        

    private void btnCancelSJActionPerformed(java.awt.event.ActionEvent evt) {                                            
       dlgSJ.setVisible(false);    // TODO add your handling code here:
    }                                           

    private void scrPriceKMAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {                                                  
       lblPriceInfoKM.setText(Integer.toString((int) scrPriceKM.getValue())); // TODO add your handling code here:
    }                                                 

    private void cmbNameKMActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void btnAddKMActionPerformed(java.awt.event.ActionEvent evt) {                                         
       dlgKM.setVisible(false);
        // д.б. код для проверки полей на правильность ввода
        Tovar el;
            el = new Tovar(cmbNameKM.getSelectedItem().toString(), (int) spnKolKM.getValue(), scrPriceKM.getValue());
        doVivod(tovarOperation.addNewTovar(el));  // TODO add your handling code here:
    }                                        

    private void btnCancelKMActionPerformed(java.awt.event.ActionEvent evt) {                                            
       dlgKM.setVisible(false);    // TODO add your handling code here:
    }                                           

    private void btnRMActionPerformed(java.awt.event.ActionEvent evt) {                                      
    dlgRM.setSize(300, 320);
    dlgRM.setLocationRelativeTo(null);
    dlgRM.setVisible(true); 
    dlgPost.setVisible(false);//  // TODO add your handling code here:
    }                                     

    private void btnSJActionPerformed(java.awt.event.ActionEvent evt) {                                      
    dlgSJ.setSize(300, 320);
    dlgSJ.setLocationRelativeTo(null);
    dlgSJ.setVisible(true); 
    dlgPost.setVisible(false);        // TODO add your handling code here:
    }                                     

    private void btnKMActionPerformed(java.awt.event.ActionEvent evt) {                                      
    dlgKM.setSize(300, 320);
    dlgKM.setLocationRelativeTo(null);
    dlgKM.setVisible(true); 
    dlgPost.setVisible(false);        // TODO add your handling code here:
    }                                     

    private void btnPostavActionPerformed(java.awt.event.ActionEvent evt) {                                          
    dlgPost.setSize(300, 320);
    dlgPost.setLocationRelativeTo(null);
    dlgPost.setVisible(true); 
    dlgCat.setVisible(false);     // TODO add your handling code here:
    }                                         
       
    
        private void doClearTable(){
          while (model.getRowCount()>0){
          model.removeRow(0);
                }
        }

2) Интирфейс программы:
![](https://github.com/NiKenguru/DS_13_2020/blob/Work-1/Menu.jpg)
![](https://github.com/NiKenguru/DS_13_2020/blob/Work-1/1.jpg)
![](https://github.com/NiKenguru/DS_13_2020/blob/Work-1/2.jpg)
![](https://github.com/NiKenguru/DS_13_2020/blob/Work-1/3.jpg)
![](https://github.com/NiKenguru/DS_13_2020/blob/Work-1/4.jpg)
![](https://github.com/NiKenguru/DS_13_2020/blob/Work-1/5.jpg)
![](https://github.com/NiKenguru/DS_13_2020/blob/Work-1/6.jpg)
![](https://github.com/NiKenguru/DS_13_2020/blob/Work-1/7.jpg)
![](https://github.com/NiKenguru/DS_13_2020/blob/Work-1/8.jpg)
![](https://github.com/NiKenguru/DS_13_2020/blob/Work-1/9.jpg)
![](https://github.com/NiKenguru/DS_13_2020/blob/Work-1/Results.jpg)

Выводы: были освоены базовые уровни программирования Java.  
