package istg.edu.ec.myapplication.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import istg.edu.ec.myapplication.R;
import istg.edu.ec.myapplication.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    FloatingActionButton fab;

    ImageButton btnISTG;
    ImageButton btnIngles;
    ImageButton btnSpanish;

    ImageButton btnAltavoz;

    ImageView imageView9;
    ImageView imageView11;

    ImageView imageView10;
    private boolean isIconoOriginal = true;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textHome;
        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fab = view.findViewById(R.id.floatingActionButton);
        btnISTG = view.findViewById(R.id.btnISTG);
        btnIngles = view.findViewById(R.id.btnIngles);
        btnSpanish = view.findViewById(R.id.btnSpanish);
        btnAltavoz=view.findViewById(R.id.btnAltavoz);
        imageView9= view.findViewById(R.id.imageView9);
        imageView11= view.findViewById(R.id.imageView11);
        imageView10= view.findViewById(R.id.imageView10);
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
        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://earth.jpl.nasa.gov/emit/resources/98/emit-installation-animation/");

            }
        });

        imageView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.youtube.com/watch?v=UORfDpQBi0o");

            }
        });

        imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://earth.jpl.nasa.gov/emit/news/22/nasa-to-discuss-latest-emit-findings-helps-address-climate-change/");

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
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

    public void launch(View view){
        gotoUrl("https://earth.jpl.nasa.gov/emit/resources/98/emit-installation-animation/");
    }

}