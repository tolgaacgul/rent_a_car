package com.rentacar.tool;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

// Oluşturulan Yardımcı fonksiyonlar
public class Tool {


    /**
     * @param theme
     * Parametreye girilen tema aktif olur
     */
    public static void setTheme(String theme){
        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            if(theme.equals(info.getName())){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }
    public static void getThemes(){
        // # Tema Yapıları Sıralar
        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            System.out.println(info.getName() + "->" + info.getClassName());
        }
    }


    /**
     * @param axis
     * @param size
     * Pencerelerin eksenlerini ortalar
     * iki parametre alır. eksen ve dialog'un boyutu.
     */
    public static int screenCenterAxis(String axis, Dimension size){
        int point = 0;
        switch (axis){
            case "x" :
                point = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2 ;
                break;
            case "y" :
                point = (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
                break;
            default:
                point = 0;
        }
        return point;
    }


    /**
     * @param field
     * Parametreye girilen Text ve Password alanlarının içi
     * boş ise true, dolu ise false döner
     */
    public static boolean isFieldEmpty(JTextComponent field){
        return field.getText().trim().isEmpty();
    }

    /**
    * @param info
     * girilen bilgiye göre Dialog penceresi
     * ile geri bildirim verir.
     */
    public static void showDialog(String info){
        optionPageTR();
        String msg;
        String title = "Bilgi";
        switch (info){
            case "empty" :
                msg = "Lütfen boş alanları doldurunuz.";
                title = "Uyarı";
                break;
            case "done" :
                msg = "İşleminiz başarılı şekilde gerçekleşti.";
                title = "Başarılı";
                break;
            case "error" :
                msg = "Yaptığınız işlemlerde bir hata var. Düzeltip tekrar deneyiniz!";
                title = "HATA";
            case "wrong_info" :
                msg = "Yanlış veya hatalı giriş yaptınız. Bilgilerinizi kontrol edin.";
                title = "Hatalı İşlem";
                break;
            case "not_register" :
                msg = "Kayıt işleminizi gerçekleştiremedik. Lütfen Tekrar deneyin";
                title = "HATA";
                break;
            case "not_equal_pass":
                msg = "Şifreleriniz bir biri ile eşleşmiyor. Lütfen kontrol edip tekrar deneyin.";
                title = "Şifreler Uyuşmuyor";
                break;
            default:
                msg = info;
        }
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.WARNING_MESSAGE);
    }


    public static void optionPageTR(){
        UIManager.put("OptionPane.okButtonText", "Tamam");
    }

    public static String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String tarih = sdf.format(date);
        return tarih;
    }


}
