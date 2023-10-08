package istg.edu.ec.myapplication.ui.notifications;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import istg.edu.ec.myapplication.R;
import istg.edu.ec.myapplication.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    FloatingActionButton fab;

    ImageButton btnISTG;
    ImageButton btnIngles;

    private boolean isIconoOriginal = true;
    ImageButton btnSpanish;

    ImageButton btnAltavoz;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
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
        super.onViewCreated(view, savedInstanceState);
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