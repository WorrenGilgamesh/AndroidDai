package worrengilgamesh.ejemplofragmentoslista;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    Button agregar;
    EditText dato;
    InterfazBd iBD;
    FragmentManager fm;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        agregar=(Button)v.findViewById(R.id.botonAgregar);
        dato = (EditText)v.findViewById(R.id.datoUsuario);
        fm=this.getActivity().getFragmentManager();

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=dato.getText().toString();
                //Instanciar objeto para conexion a bd
                iBD=new InterfazBd(v.getContext());
                //Insertar dato en la bd - ver el codigo de insertarDatos en la clase
                //InterfazBD
                long clave=iBD.insertarDatos(s);
                //Mostrar la llave primaria en un toast
                Toast.makeText(v.getContext(),"Llave: "+clave, Toast.LENGTH_SHORT).show();
                FragmentTransaction ft=fm.beginTransaction();
                android.app.Fragment fl=new FragmentoLista();
                ft.replace(R.id.actividadPrincipal,fl);
                ft.commit();
            }
        });
        return v;
    }

}
