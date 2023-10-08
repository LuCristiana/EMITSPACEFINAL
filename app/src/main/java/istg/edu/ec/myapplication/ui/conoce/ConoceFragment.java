package istg.edu.ec.myapplication.ui.conoce;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import istg.edu.ec.myapplication.NoticiaEmit;
import istg.edu.ec.myapplication.R;
import istg.edu.ec.myapplication.adapter.NoticiaAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConoceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConoceFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FloatingActionButton fab;
    ImageButton btnISTG;
    ImageButton btnIngles;
    ImageButton btnSpanish;

    ImageButton btnAltavoz;
    private boolean isIconoOriginal = true;

    public ConoceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConoceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConoceFragment newInstance(String param1, String param2) {
        ConoceFragment fragment = new ConoceFragment();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_conoce, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initRecyclerview(view);
        super.onViewCreated(view, savedInstanceState);
        fab = view.findViewById(R.id.floatingActionButton);
        btnISTG = view.findViewById(R.id.btnISTG);
        btnIngles = view.findViewById(R.id.btnIngles);
        btnSpanish = view.findViewById(R.id.btnSpanish);
        btnAltavoz=view.findViewById(R.id.btnAltavoz);
        fab.setOnClickListener(v -> {
            cambiarIconoFab();

            btnISTG.setVisibility(btnISTG.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            btnIngles.setVisibility(btnIngles.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            btnSpanish.setVisibility(btnSpanish.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            btnAltavoz.setVisibility(btnAltavoz.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
        });
        btnISTG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://earth.jpl.nasa.gov/emit/mission/about/");
            }
        });
        btnIngles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://earth.jpl.nasa.gov/emit/mission/about/");
            }
        });

        btnSpanish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://earth.jpl.nasa.gov/emit/mission/about/");
            }
        });

    }

    private void initRecyclerview(View view) {
        ArrayList<NoticiaEmit> items = new ArrayList<>();
        items.add(new NoticiaEmit("EMIT Data Tutorial Series Workshop Open for Registration", "These workshops are a series that will introduce users to the radiance and reflectance data being delivered from the Earth Mineral Dust Source Investigation (EMIT) mission, currently collecting data from the international space station. While registration is not required to attend, please consider registering so that we can ensure sufficient computational resources are allocated and can better meet your needs."
                , "January 26, 2023","noticia_1"));
        items.add(new NoticiaEmit("NASA Sensors to Help Detect Methane Emitted by Landfills", "A nonprofit group, Carbon Mapper, will use data from NASA’s EMIT mission, plus current airborne and future satellite instruments, to survey waste sites for methane emissions."
                , "October 25, 2022","noticia_2"));
        items.add(new NoticiaEmit("Methane ‘Super-Emitters' Mapped by NASA's New Earth Space Mission", "Built to help scientists understand how dust affects climate, the Earth Surface Mineral Dust Source Investigation can also pinpoint emissions of the potent greenhouse gas."
                , "October 25, 2022","noticia_3"));

        RecyclerView recyclerViewFood = view.findViewById(R.id.recyclerNew);
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        RecyclerView.Adapter<NoticiaAdapter.ViewHolder> adapterFoodList = new NoticiaAdapter(items);
        recyclerViewFood.setAdapter(adapterFoodList);
    }

    private void cambiarIconoFab() {
        if (isIconoOriginal) {
            fab.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.baseline_remove_circle_outline_24));
        } else {
            fab.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.baseline_add_24));
        }
        isIconoOriginal = !isIconoOriginal;
    }
    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}