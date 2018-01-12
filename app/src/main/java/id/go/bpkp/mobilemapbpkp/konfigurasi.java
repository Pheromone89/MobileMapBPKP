package id.go.bpkp.mobilemapbpkp;

/**
 * Created by ASUS on 11/01/2018.
 */

public class konfigurasi {

    //Dibawah ini merupakan Pengalamatan dimana Lokasi Skrip CRUD PHP disimpan
    //Pada tutorial Kali ini, karena kita membuat localhost maka alamatnya tertuju ke IP komputer
    //dimana File PHP tersebut berada
    //PENTING! JANGAN LUPA GANTI IP SESUAI DENGAN IP KOMPUTER DIMANA DATA PHP BERADA
    //ADD
    public static final String URL_ADD="http://192.168.32.57/map-android/tambahPgw.php";
    //ALL PEGAWAI
    public static final String URL_GET_ALL = "http://mahasiswaonline.com/mapapi/tampilPegawaiAll.php";
    //ID
    public static final String URL_GET_EMP = "http://mahasiswaonline.com/mapapi/tampilPegawaiById.php?term=";
    //UDPATE
    public static final String URL_UPDATE_EMP = "http://192.168.32.57/map-android/updatePgw.php";
    //HAPUS
    public static final String URL_DELETE_EMP = "http://192.0168.32.57/map-android/hapusPgw.php?id=";


    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NAMA = "name";
    public static final String KEY_EMP_NIPLAMA = "niplama";
    public static final String KEY_EMP_NIPBARU = "nipbaru";
    public static final String KEY_EMP_PANGKAT = "pangkat";
    public static final String KEY_EMP_JABATAN = "jabatan";
    public static final String KEY_EMP_UNIT = "unit";
    public static final String KEY_EMP_PENDIDIKAN = "pendidikan";
    public static final String KEY_EMP_FOTO = "foto";
    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAMA = "name";
    public static final String TAG_NIPLAMA = "niplama";
    public static final String TAG_NIPBARU = "nipbaru";
    public static final String TAG_PANGKAT = "pangkat";
    public static final String TAG_JABATAN = "jabatan";
    public static final String TAG_UNIT = "unit";
    public static final String TAG_PENDIDIKAN = "pendidikan";
    public static final String TAG_FOTO = "foto";
    //emp itu singkatan dari Employee
    public static final String EMP_ID = "emp_id";
    public static final String EMP_NAMA = "emp_nama";
    public static final String EMP_NIPLAMA = "emp_niplama";
    public static final String EMP_NIPBARU = "emp_nipbaru";
    public static final String EMP_PANGKAT = "emp_pangkat";
    public static final String EMP_JABATAN = "emp_jabatan";
    public static final String EMP_UNIT = "emp_unit";
    public static final String EMP_PENDIDIKAN = "emp_pendidikan";
    public static final String EMP_FOTO = "emp_foto";

}
