package com.rentacar.view;


import com.rentacar.model.Cars;
import com.rentacar.model.Customer;
import com.rentacar.tool.Config;
import com.rentacar.tool.Tool;
import com.rentacar.model.Company;

import javax.swing.*;

public class LoginGUI extends JFrame{
    private JPanel wrapper;
    private JTextField txtFld_uname;
    private JPasswordField psswrdFld_password;
    private JButton btn_login;
    private JLabel lbl_uname;
    private JLabel lbl_password;
    private JComboBox cmbBx_loginType;
    private JLabel lbl_typeLogin;
    private JPanel pnl_center;
    private JPanel pnl_top;
    private JLabel lbl_brand;
    private JButton btn_registerCompany;
    private JButton btn_registerCustomer;
    private JPanel pnl_register;
    private JLabel lbl_info;
    private JLabel lbl_info2;
    private JRadioButton rdBtn_customer;
    private JRadioButton rdBtn_company;

    public LoginGUI(){
        // +Window Kısmı
        {
            Tool.setTheme("Metal");
            // add(wrapper);
            setContentPane(wrapper); // bu add yerine kullanılabilir
            setSize(400, 400);
            setResizable(false);
            setTitle(Config.APP_TITLE);
            setLocation(Tool.screenCenterAxis("x",getSize()), Tool.screenCenterAxis("y", getSize()));

            // setLocationRelativeTo(null);  //ekran ORTALA
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // ekran kapanınca sonlandır.
            setVisible(true);
            String info = Cars.totalCars() + " araç, " + Company.totalCompany() + " şirket ile hizmetinizdeyiz.";
            String info2 = Customer.totalCustomer() + " değerli müşterimizin arasına sende katıl.";
            lbl_info.setText(info);
            lbl_info2.setText(info2);
            //pack();
        }
        // -Window Kısmı


        // +Giriş Butonu
        btn_login.addActionListener(e -> {
            if (Tool.isFieldEmpty(txtFld_uname) || Tool.isFieldEmpty(psswrdFld_password)){
                Tool.showDialog("empty");
            }else{
                if(Config.USER_COMPANY == cmbBx_loginType.getSelectedItem().toString()){
                    // şirket Girişi için
                    Company company = Company.setCompany(txtFld_uname.getText(), psswrdFld_password.getText());
                    if(company == null){
                        Tool.showDialog("wrong_info");
                    } else if (company != null) {
                        CompanyGUI companyGUI = new CompanyGUI(company);
                    }
                }else if(Config.USER_CUSTOMER == cmbBx_loginType.getSelectedItem().toString()){
                    // Müşeri girişi
                    Customer customer = Customer.setCustomer(txtFld_uname.getText(), psswrdFld_password.getText());
                    if(customer == null){
                        Tool.showDialog("wrong_info");
                    } else if(customer != null){
                        CustomerGUI customerGUI = new CustomerGUI(customer);
                    }
                }else{
                    Tool.showDialog("Bu Kullanıcı Türü Bulunamadı");
                }
            }
        });
        // -Giriş Butonu



        // +Şirket Kayıt Butonu
        btn_registerCompany.addActionListener(e -> {
            RegisterCompanyGUI registerCompanyGUI = new RegisterCompanyGUI();
        });
        // -Şirket Kayıt Butonu



        // +Müşteri Kayıt Butonu
        btn_registerCustomer.addActionListener(e -> {
            RegisterCustomerGUI registerCustomerGUI = new RegisterCustomerGUI();
        });
        // -Müşteri Kayıt Butonu

    }
}
