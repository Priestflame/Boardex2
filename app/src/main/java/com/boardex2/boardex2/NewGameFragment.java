package com.boardex2.boardex2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewGameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewGameFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewGameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewGameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewGameFragment newInstance(String param1, String param2) {
        NewGameFragment fragment = new NewGameFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MaterialButton bt_agregar = getView().findViewById(R.id.bt_agregar);
        TextInputEditText tx_nombre = getView().findViewById(R.id.input_name);
        Spinner sp_categoria = getView().findViewById(R.id.spinner_categoria);

        /*bt_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModeloSQLite obj = new ModeloSQLite();
                JuegosDTO juego = new JuegosDTO();

                juego.setId("1");
                juego.setNombre(tx_nombre.getText().toString());
                juego.setCategoria(sp_categoria.getSelectedItem().toString());
                int resInsert = obj.insertaJuego(getContext(), juego);
                if (resInsert == 1){
                    Toast.makeText(getContext(), "OK", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getContext(), "No insert??", Toast.LENGTH_SHORT).show();
                }
            }
        });*/

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_game, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Seccion logica Spinner categorias
        Spinner spinner_category = view.findViewById(R.id.spinner_categoria);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.array_gameCategory,
                android.R.layout.simple_spinner_item);
        //Seteamos el adaptador al spinner
        spinner_category.setAdapter(adapter);
        //Desplegamos seleccionado en Toast
        spinner_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(adapterView.getContext(), adapterView.getItemAtPosition(i).toString(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}