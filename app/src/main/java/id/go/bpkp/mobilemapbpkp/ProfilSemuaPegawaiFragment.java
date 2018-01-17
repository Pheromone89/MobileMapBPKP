package id.go.bpkp.mobilemapbpkp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PegawaiAdapter;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ASUS on 15/01/2018.
 */

public class ProfilSemuaPegawaiFragment extends Fragment implements ListView.OnItemClickListener {

    private ListView listView;
    private String JSON_STRING;
    View fragmentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profil_semua_pegawai, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentView = view;
        listView = (ListView) fragmentView.findViewById(R.id.lv_semua_pegawai);
        listView.setOnItemClickListener(this);
        getJSON();
    }

    private void showEmployee(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(konfigurasi.TAG_ID);
                String name = jo.getString(konfigurasi.TAG_NAMA);
                String niplama = jo.getString(konfigurasi.TAG_NIPLAMA);
                String nipbaru = jo.getString(konfigurasi.TAG_NIPBARU);
                String pangkat = jo.getString(konfigurasi.TAG_PANGKAT);
                String jabatan = jo.getString(konfigurasi.TAG_JABATAN);
                String unit = jo.getString(konfigurasi.TAG_UNIT);
                String pendidikan = jo.getString(konfigurasi.TAG_PENDIDIKAN);
                String foto = jo.getString(konfigurasi.TAG_FOTO);

                HashMap<String,String> employees = new HashMap<>();
                employees.put(konfigurasi.TAG_ID,id);
                employees.put(konfigurasi.TAG_NAMA,name);
                employees.put(konfigurasi.TAG_NIPLAMA,niplama);
                employees.put(konfigurasi.TAG_NIPBARU,nipbaru);
                employees.put(konfigurasi.TAG_PANGKAT,pangkat);
                employees.put(konfigurasi.TAG_JABATAN,jabatan);
                employees.put(konfigurasi.TAG_UNIT,unit);
                employees.put(konfigurasi.TAG_PENDIDIKAN,pendidikan);
                employees.put(konfigurasi.TAG_FOTO,foto);
                list.add(employees);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new PegawaiAdapter(
                getActivity(),
                list,
                R.layout.item_list_pegawai,
                new String[]{
                        konfigurasi.TAG_ID,
                        konfigurasi.TAG_NAMA,
                        konfigurasi.TAG_NIPBARU,
                        konfigurasi.TAG_JABATAN,
                        konfigurasi.TAG_UNIT,
                        konfigurasi.TAG_FOTO
                },
                new int[]{
                        R.id.id,
                        R.id.nama,
                        R.id.nipbaru,
                        R.id.jabatan,
                        R.id.unit,
                        R.id.profic
                });

        listView.setAdapter(adapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(getActivity(),"Mengambil Data","Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showEmployee();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_ALL);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), ProfilPegawaiIndividuActivity.class);

        HashMap<String,String> map =(HashMap)parent.getItemAtPosition(position);
        String empId = map.get(konfigurasi.TAG_ID).toString();
        String empName = map.get(konfigurasi.TAG_NAMA).toString();
        String empNipbaru = map.get(konfigurasi.TAG_NIPBARU).toString();
        String empNiplama = map.get(konfigurasi.TAG_NIPLAMA).toString();
        String empPangkat = map.get(konfigurasi.TAG_PANGKAT).toString();
        String empJabatan = map.get(konfigurasi.TAG_JABATAN).toString();
        String empUnit = map.get(konfigurasi.TAG_UNIT).toString();
        String empFoto = map.get(konfigurasi.TAG_FOTO).toString();
        intent.putExtra(konfigurasi.EMP_ID,empId);
        intent.putExtra(konfigurasi.EMP_NAMA,empName);
        intent.putExtra(konfigurasi.EMP_NIPBARU,empNipbaru);
        intent.putExtra(konfigurasi.EMP_NIPLAMA,empNiplama);
        intent.putExtra(konfigurasi.EMP_PANGKAT,empPangkat);
        intent.putExtra(konfigurasi.EMP_JABATAN,empJabatan);
        intent.putExtra(konfigurasi.EMP_UNIT,empUnit);
        intent.putExtra(konfigurasi.EMP_FOTO,empFoto);
        getActivity().startActivity(intent);

        String[] allPegawaiData = {
                empId,
                empName,
                empNipbaru,
                empNiplama,
                empPangkat,
                empJabatan,
                empUnit,
                empFoto
        };

////
////        Bundle dataPegawai = new Bundle();
////        dataPegawai.putStringArray("all data", new String[]{
////                empId,
////                empName,
////                empNipbaru,
////                empNiplama,
////                empPangkat,
////                empJabatan,
////                empUnit,
////                empFoto});
////        fragment.setArguments(dataPegawai);
////
//        Fragment fragment = new ProfilPegawaiFragment();
////        Bundle args = new Bundle();
////        args.putStringArray("test", allPegawaiData);
////        fragment.setArguments(args);
//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.content_fragment_area, fragment);
//        fragmentTransaction.commit();
    }
}