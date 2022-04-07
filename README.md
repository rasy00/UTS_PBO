# UTS PBO
Sourcode dari aplikasi untuk pengelolaan parkir dalam rangka memenuhi tugas PBO

## Deskripsi 
Aplikasi pengelolaan parkir ini dapat memudahkan kita dalam mengelola kendaraan yang masuk maupun keluar.

## Cara pakai
- **Download semua file dan folder.**
- **Buka Terminal**
- **Pindah ke direktori yang terdapat file dan folder yang sudah didownload**
- **Ketikan command ini : **
  ```
   javac UTS/App.java
   java UTS.App
  ```
  
## Fitur
#### Mengganti tarif
- Masuk kedalam class Parkir
- cari baris kode :
``` 
tarif = x.type.toLowerCase().equals("motor") ? 2000 + (dt[0]*1000) + (dt[1]*100) : 5000 + (dt[0]*2000) + (dt[1]*200); 
```
  - Jika ingin merubah tarif awal untuk motor : ganti angka '2000' menjadi nominal yang mau anda tetapkan.
    contoh :
    ``` 
    tarif = x.type.toLowerCase().equals("motor") ? 1000 + (dt[0]*1000) + (dt[1]*100) : 5000 + (dt[0]*2000) + (dt[1]*200); 
    ```
    atau
    ``` 
    tarif = x.type.toLowerCase().equals("motor") ? 3000 + (dt[0]*1000) + (dt[1]*100) : 5000 + (dt[0]*2000) + (dt[1]*200); 
    ```
    
  - Jika ingin merubah tarif awal untuk mobil : ganti angka '5000' menjadi nominal yang mau anda tetapkan
    contoh :
    ``` 
    tarif = x.type.toLowerCase().equals("motor") ? 2000 + (dt[0]*1000) + (dt[1]*100) : 3000 + (dt[0]*2000) + (dt[1]*200); 
    ```
    atau
    ``` 
    tarif = x.type.toLowerCase().equals("motor") ? 2000 + (dt[0]*1000) + (dt[1]*100) : 4000 + (dt[0]*2000) + (dt[1]*200); 
    ```

  - Jika ingin merubah tarif berdasarkan kenaikan jam : ganti angka setelah ```dt[0]*```
    contoh :
    ``` 
    tarif = x.type.toLowerCase().equals("motor") ? 2000 + (dt[0]*2000) + (dt[1]*100) : 4000 + (dt[0]*4000) + (dt[1]*200); 
    ```
    atau
    ``` 
    tarif = x.type.toLowerCase().equals("motor") ? 2000 + (dt[0]*900) + (dt[1]*100) : 4000 + (dt[0]*1000) + (dt[1]*200); 
    ```
    
   
