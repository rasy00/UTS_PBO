package UTS;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Kendaraan {
    public String nopol,type,tglMasuk,jamMasuk;
 
    public Kendaraan(){
        this.nopol = null;
        this.type = null;
        this.tglMasuk = generateTime()[0];
        this.jamMasuk = generateTime()[1];
    }

    public void setProperty(String nopol,String type){
        this.nopol = nopol;
        this.type = type;
        
    }

    public String[] generateTime(){
        LocalDateTime a = LocalDateTime.now();
        String b = a.format(DateTimeFormatter.ofPattern("dd-MM-yy,HH:mm:ss"));
        String tgl = b.substring(0, 8);
        String jam = b.substring(9, 17);
        String []result = {tgl,jam};
        return result;
    }
}
