package mx.itesm.cecnn.practica_redes_carlos;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.BitmapRequestListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class DescargaImagenFrag extends Fragment {

    private ImageView ivContenedor;


    @Override
    public void onStart() {
        super.onStart();
        ivContenedor=getView().findViewById(R.id.ivContenedor);
        AndroidNetworking.initialize(getContext());
    }

    @Override
    public void onResume() {
        super.onResume();
        String url="https://upload.wikimedia.org/wikipedia/commons/d/dd/Big_%26_Small_Pumkins.JPG";
        AndroidNetworking.get(url).build().getAsBitmap(new BitmapRequestListener() {
            @Override
            public void onResponse(Bitmap response) {
                ivContenedor.setImageBitmap(response);
            }

            @Override
            public void onError(ANError anError) {
                Toast.makeText(getContext(), "Error en la descarga: "+anError.getErrorCode(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public DescargaImagenFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_descarga_imagen, container, false);
    }

}
