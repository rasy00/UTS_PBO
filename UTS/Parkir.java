package UTS;
public class Parkir {
    public Kendaraan [] field = new Kendaraan[0];
    public int tarifMotorPertama = 2000,tarifMotorPerJam = 1000,tarifMotorPerMenit = 100;
    public int tarifMobilPertama = 5000,tarifMobilPerJam = 2000,tarifMobilPerMenit = 200;

    private String sendData(Kendaraan data){
        Kendaraan[] result;
        try{
           result = this.field[0].nopol == null ? new Kendaraan[this.field.length] : new Kendaraan[this.field.length+1];
        }catch(Exception e){
            result = new Kendaraan[1];
        }

        for(int i = 0;i<=this.field.length;i++){
            if(result.length == (i+1)){
                result[i] = data;
                break;
            }
            try{
                result[i] = this.field[i]; 
            }catch(Exception e){
                result[i] = data;
            } 
        }
        this.field = result;
        String msg = data.nopol + " Berhasil ditambah";
        return msg;
    }

    public boolean tambahData(String nopol,String type){
        try{
          Kendaraan result = new Kendaraan();
            // to capitalize type value
            String a = type.substring(0,1).toUpperCase();
            String b = type.substring(1, type.length());
            type = a.concat(b);
            result.setProperty(nopol.toUpperCase(),type);
            System.out.println(this.sendData(result));   
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public String deleteData(String nopol,String type){
        String msg;
        Kendaraan x = new Kendaraan();
        try{
            x = this.search(nopol, type);
        }catch(Exception e){
            System.out.println("Parkir dalam keadaan Kosong!");
        }
        Kendaraan[] tempArrObjek;
        int index = 0;
        
        if(x == null){
            msg = nopol+" with type : "+ type  + " is not found";
        }else {
            tempArrObjek = new Kendaraan[this.field.length-1];
            for(int i = 0; i<this.field.length; i++){

                if((this.field[i].nopol.toLowerCase().equals(nopol.toLowerCase()))&&(this.field[i].type.toLowerCase().equals(type.toLowerCase()))){
                    continue;
                }else{
                    tempArrObjek[index] = this.field[i];
                    index++;
                }
            }
            this.field = tempArrObjek;
            msg = x.nopol + " Selamat dijalan"; 
        }

        System.out.println(msg +"\t"+ x.type);
        return msg;
    }


    public Kendaraan search(String nopol, String type){
        Kendaraan result = new Kendaraan();
        for(Kendaraan a : this.field){
            if(a.nopol.toLowerCase().equals(nopol.toLowerCase()) && a.type.toLowerCase().equals(type.toLowerCase())){
            result = a;
            break;
            }
        }
        return result;
    }


    public int[] keluar(String nopol,String type){
        Kendaraan x = new Kendaraan();
        int[] dt = new int[2];
        int tarif = 0,jam = 0,menit = 0;
        try{
            x = this.search(nopol, type);
            dt = hitungDurasi(x.tglMasuk, x.jamMasuk);
            jam = dt[0];
            menit = dt[1];
            tarif = x.type.toLowerCase().equals("motor") ? tarifMotorPertama + (jam*tarifMotorPerJam) + (menit*tarifMotorPerMenit) : tarifMobilPertama + (jam*tarifMobilPerJam) + (menit*tarifMobilPerMenit);

        }catch(Exception e){
            System.out.println("Data tidak ditemukan");
        }
        int [] result = {tarif,jam,menit};
        return result;
    }

    

    private int[] hitungDurasi(String tanggal, String jam){
        int tglM = Integer.parseInt(tanggal.substring(0, 2));
        int jamM = Integer.parseInt(jam.substring(0, 2));
        int menitM = Integer.parseInt(jam.substring(3, 5));
        int[] result = new int[2];

        String[] waktu = field[0].generateTime();
        int tglK = Integer.parseInt(waktu[0].substring(0, 2));
        int jamK = Integer.parseInt(waktu[1].substring(0, 2));
        int menitK = Integer.parseInt(waktu[1].substring(3, 5));

        result[0] = (tglK - tglM)*24;
        result[0] = result[0] + (jamK-jamM);
        if(menitK < menitM){
            result[0]--;
            result[1] =  60 + (menitK-menitM);
        }else{
            result[1] =  menitK-menitM;
        }
        return result;
    }
}
