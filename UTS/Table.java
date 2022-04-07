package UTS;
import javax.swing.JTable;
import javax.swing.text.AbstractDocument.Content;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
public class Table extends JFrame{
    public Table(Kendaraan[] data){
        String[][] result;
        
        try{
            result = new String[data.length][3];
            for(int i = 0;i<data.length;i++){
                result[i][0] = data[i].nopol;
                result[i][1] = data[i].type;
                result[i][2] = data[i].tglMasuk.concat(" "+data[i].jamMasuk);
            }
        }catch(Exception e){
            result = new String[1][3];
            result[0][0] = data[0].nopol;
            result[0][1] = data[0].type;
            result[0][2] = data[0].tglMasuk.concat(" "+data[0].jamMasuk);
        }
        String [] columns = {"Nomor Polisi","Type","Masuk"};
        setResizable(true);
		setTitle("Daftar Parkir");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
        JTable tabel = new JTable(result, columns);
        this.getContentPane().add(new JScrollPane(tabel));
    }
}
