package mx.itesm.cecnn.practica_redes_carlos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class DescargaTextoFrag extends Fragment {

    private TextView tvContenido;

    @Override
    public void onStart() {
        super.onStart();
        tvContenido=getView().findViewById(R.id.tvContenido);
        AndroidNetworking.initialize(getContext());
    }

    @Override
    public void onResume() {
        super.onResume();
        String url="https://www.gutenberg.org/cache/epub/2000/pg2000.txt";
        AndroidNetworking.get(url).build().getAsString(new StringRequestListener() {
            @Override
            public void onResponse(String response) {
                tvContenido.setText(response);
            }

            @Override
            public void onError(ANError anError) {
                tvContenido.setText("Error en la descarga: "+anError.getErrorCode());
            }
        });

    }


    public DescargaTextoFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_descarga_texto, container, false);
    }

}
