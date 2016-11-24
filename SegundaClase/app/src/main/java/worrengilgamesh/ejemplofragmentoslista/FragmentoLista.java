package worrengilgamesh.ejemplofragmentoslista;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentoLista extends ListFragment {

    ListView lv;
    InterfazBd iBD;

    public FragmentoLista() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Cursor res;
        //adaptador
        SimpleCursorAdapter sca;
        View v=super.onCreateView(inflater,container,savedInstanceState);
        String []arregloColumnas = {"_id", "datos"};
        int []to={R.id.texto1, R.id.texto2};
        //Crear la conexion con la base de datos
        iBD= new InterfazBd(this.getActivity());
        //cursor de la bd con los resultados de la tabla
        res= iBD.traerDatos();
        //pasarle el cursor a la actividad y crear el adaptador para mostrar los datos
        sca=new SimpleCursorAdapter(this.getActivity(), R.layout.formato_renglon,res,arregloColumnas,to,0);
        this.setListAdapter(sca);
        return v;
    }

    public void onListItemClick(ListView l, View v, int position, long id){
        if (iBD==null){
            iBD=new InterfazBd(this.getActivity());
        }
        String s = iBD.traerDatos(id);
        Toast t = Toast.makeText(getActivity(),s,Toast.LENGTH_LONG);
        t.show();
    }

}
