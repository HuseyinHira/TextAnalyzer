/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdpödev1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
*
* @author HÜSEYİN HIRA huseyin.hira@ogr.sakarya.edu.tr
* @since 05.03.2020
* <p>
* 
* </p>
*/
public class PDPÖdev1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
            File dosya=new File("C:/Users/Hüseyin Hıra/Documents/NetBeansProjects/PDPÖdev1/icerik.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(dosya)));



            // DEĞİŞKENLERİN TANIMLANDIĞI BÖLÜM
            int emailSayac=0;
            int websiteSayac=0;
            int kelimeSayac=1;
            int sesliHarfSayac=0;
            int cumleSayac=0;
            char ch;          
            int harfler;
            harfler = reader.read();
            
            String veriler = "";
            while(harfler!=-1)
            {
                ch=(char)harfler;
                harfler=reader.read();
            
                veriler+=ch;
            }
            
          
        
            
            Pattern patternmail = Pattern.compile("[\\w.]+@[A-Za-z]+[.].[A-Za-z.]{2,}");// MAİL KONTROL ŞARTLARININ BULUNDUĞU KISIM
            Pattern patternWebsite = Pattern.compile("[\\w.]+(.com|.edu|.net|.org|.com.tr|.edu.tr|.net.tr|.org.tr+)");// WEBSİTE KONTROL ŞARTLARININ BULUNDUĞU KISIM 
            Pattern patternKelimeSayisi = Pattern.compile("[ ]*$|[ ]");// KELİME KONTROL ŞARTLARININ BULUNDUĞU KISIM 
            Pattern patternSesliHarf = Pattern.compile("[aeıioöüuAEIİOÖÜU]");// SESLİHARF KONTROL ŞARTLARININ BULUNDUĞU KISIM
            Pattern patternCumle = Pattern.compile("[.][ ]|[.][ ]*$");// CUMLE KONTROL ŞARTLARININ BULUNDUĞU KISIM 
            
            
            // KRİTERLERE GÖRE OLUŞTURDUĞUMUZ PATTERNLERİ MATCHERLARA EŞİTLEDİĞİMİZ BÖLÜM
            Matcher matchermail = patternmail.matcher(veriler);
            Matcher matcherWebsite = patternWebsite.matcher(veriler);
            Matcher matcherKelimeSayisi = patternKelimeSayisi.matcher(veriler);
            Matcher matcherKelime = patternSesliHarf.matcher(veriler);
            Matcher matcherCumle = patternCumle.matcher(veriler);
            
            
            //BU KISIMDA MATCHER FONKSİYONUNUN FİND KOMUTUNU KULLANARAK ŞARTLARIMIZA GÖRE EŞLEŞTİRMELERİ YAPIYOUZ
            //MAİLLERİ BULUP SAYDIRAN BÖLÜM
            while (matchermail.find()) {
                emailSayac++;         
            }
            
            //WEBSİTELERİ BULUP SAYDIRAN BÖLÜM
            while (matcherWebsite.find()) {
                websiteSayac++;         
            }
            
            //CUMLELERİ BULUP SAYDIRAN BÖLÜM
            while (matcherKelimeSayisi.find()) {
                kelimeSayac++;         
            }
            //CUMLELERİ BULUP SAYDIRAN BÖLÜM
            while (matcherKelime.find()) {
                sesliHarfSayac++;         
            }
            // CUMLELERİ BULUP SAYDIRAN BÖLÜM
            while (matcherCumle.find()) {
                cumleSayac++;         
            }
            
            
            
            
            //BULUNNANLARI YAZDIRMA BÖLÜMÜ     
            System.out.println("Toplam Sesli Harf Sayısı : "+ sesliHarfSayac);
            System.out.println("Toplam kelime Sayısı : "+kelimeSayac);
            System.out.println("Toplam Cumle Sayısı : "+ cumleSayac);
            System.out.println("Toplam Mail Sayısı : "+emailSayac);
            System.out.println("Toplam Website Sayısı : "+(websiteSayac-emailSayac));
            
            
    }
    
}
