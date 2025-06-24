package com.example.t1evaluacion.view.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.t1evaluacion.Model.Picture;
import com.example.t1evaluacion.R;
import com.example.t1evaluacion.adapter.PictureAdapterRecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);
        showToolbar("Buscar", false, view);

        RecyclerView pictureRecycler = (RecyclerView) view.findViewById(R.id.pictureRecyclerView);

        LinearLayoutManager linerLayoutManager = new LinearLayoutManager(getContext());
        linerLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        pictureRecycler.setLayoutManager(linerLayoutManager);
        PictureAdapterRecyclerView pictureAdapterRecyclerView =
                new PictureAdapterRecyclerView(buildPictures(), R.layout.cardview_picture, getActivity());

        pictureRecycler.setAdapter(pictureAdapterRecyclerView);
        return view;

    }


    public ArrayList<Picture> buildPictures() {
        ArrayList<Picture> pictures = new ArrayList<>();

        //PIZZAS
        pictures.add(new Picture("https://www.bareinternational.cl/wp-content/uploads/sites/4/2022/04/Untitled-design-2-300x200.png",
                "Pizza Pepperoni", "10-12 minutos", "9.5/10 Me Gusta"));

        pictures.add(new Picture("https://imag.bonviveur.com/foto-portada-pizza-cuatro-quesos.jpg",
                "Pizza Cuatro Quesos", "10-12 minutos.", "8.5/10 Me Gusta"));

        pictures.add(new Picture("https://mandolina.co/wp-content/uploads/2023/08/pizza-napolitana-1080x550-1.png",
                "Pizza Napolitana", "10-12 minutos.", "7/10 Me Gusta"));

        pictures.add(new Picture("https://api.photon.aremedia.net.au/wp-content/uploads/sites/10/gt/2018/08/15/1534295566210_fb-pizza-diavola.jpg?resize=1200%2C628",
                "Pizza Diávola", "12-14 minutos.", "8/10 Me Gusta"));

        pictures.add(new Picture("https://okdiario.com/img/2015/09/08/receta-pizza-barbacoa.jpg",
                "Pizza Barbacoa", "12-15 minutos.", "9/10 Me Gusta"));

        pictures.add(new Picture("https://www.paulinacocina.net/wp-content/uploads/2023/11/como-hacer-pizza-hawaiana-Paulina-Cocina-Recetas.jpg",
                "Pizza Hawaiana", "10-13 minutos.", "7/10 Me Gusta"));

        pictures.add(new Picture("https://www.thursdaynightpizza.com/wp-content/uploads/2022/06/veggie-pizza-side-view-out-of-oven-720x480.png",
                "Pizza Veggie", "10-12 minutos", "8/10 Me Gusta"));

        pictures.add(new Picture("https://assets.unileversolutions.com/recipes-v2/217210.jpg",
                "Pizza Suprema", "15-18 minutos", "9.2/10 Me Gusta"));

        pictures.add(new Picture("https://jptradingimports.com/wp-content/uploads/2020/07/pizza-mediterranea.png.webp",
                "Pizza Mediterránea", "10-13 minutos", "8.7/10 Me Gusta"));

        pictures.add(new Picture("https://imag.bonviveur.com/pizza-margarita.jpg",
                "Pizza Margherita", "10-15 minutos", "9.1/10 Me Gusta"));


        //HAMBURGESAS

        pictures.add(new Picture("https://assets.unileversolutions.com/recipes-v2/218401.jpg",
                "Hamburguesa Clásica", "5-7 minutos", "9/10 Me Gusta"));

        pictures.add(new Picture("https://bostonschihuahua.com.mx/wp-content/uploads/2015/09/sandyhamb-bbqbluecheese-2x.jpg",
                "Hamburguesa BBQ", "6-8 minutos", "9.5/10 Me Gusta"));

        pictures.add(new Picture("https://www.aldelis.com/wp-content/uploads/2024/08/hamburguesa-pollo-crispy-cocinada-plato_rev01.jpg",
                "Hamburguesa de Pollo", "5-7 minutos", "8/10 Me Gusta"));

        pictures.add(new Picture("https://images.mrcook.app/recipe-image/01911490-ba17-7c29-9ddd-12ba0166dd36",
                "Hamburguesa con Queso", "6-8 minutos", "9/10 Me Gusta"));

        pictures.add(new Picture("https://media-cdn.tripadvisor.com/media/photo-s/18/92/e1/98/hamburguesa-la-neta-doble.jpg",
                "Hamburguesa Doble Carne", "10-12 minutos", "8.8/10 Me Gusta"));

        pictures.add(new Picture("https://www.riscalesalimentacion.com/cdn/shop/articles/Fotos_Recetas_Blog_a406a0bd-7907-425f-b041-c2e2e2d22d7b_1024x1024.png?v=1681204841",
                "Hamburguesa Tex-Mex", "7-9 minutos", "9.2/10 Me Gusta"));

        pictures.add(new Picture("https://www.unileverfoodsolutions.es/dam/global-ufs/mcos/SPAIN/calcmenu/recipes/ES-recipes/general/hamburguesa-de-noternera-picante/main-header.jpg",
                "Hamburguesa Picante", "6-8 minutos", "8.5/10 Me Gusta"));

        pictures.add(new Picture("https://www.conasi.eu/blog/wp-content/uploads/2022/05/hamburguesa-vegana-d.jpg",
                "Hamburguesa Vegana", "5-7 minutos", "8/10 Me Gusta"));

        pictures.add(new Picture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQboW6yB3u96wO8AUL3PdB-WpvQ_dY29mNYFwkit6VNPX7tPjY07xchqlx4rOHVVmCDMJU&usqp=CAU",
                "Hamburguesa Gourmet", "8-10 minutos", "9.3/10 Me Gusta"));

        pictures.add(new Picture("https://ik.imagekit.io/smithfield/farmerjohn/3b1720e5-a9aa-0088-f165-1043ab81f774/4a8e8be6-5c83-4042-b1bd-50bb8ad3567a/Bacon-BBQ-Burger_B_Web_400x250.jpg?tr=w-1160,c-at_max,f-auto",
                "Hamburguesa con Tocino", "7-9 minutos", "9.6/10 Me Gusta"));


        return pictures;

    }

    private void showToolbar(String title, boolean upButton, View view) {

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}