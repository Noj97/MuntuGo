package com.example.muntugo; // Remplacez par votre package

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Arrays;
import java.util.List;
import android.os.Handler;

public class VoyageHome extends AppCompatActivity {

    private ViewPager2 viewPager;
    private Handler handler = new Handler();
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voyagehome); // Assurez-vous que le nom du fichier XML est correct

        // Configuration des boutons
        Button buttonBus = findViewById(R.id.button_bus);
        buttonBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Naviguer vers l'activité de réservation de bus
                Intent intent = new Intent(VoyageHome.this, BusReservationActivity.class);
                startActivity(intent);
            }
        });

        Button buttonTrain = findViewById(R.id.button_train);
        buttonTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Naviguer vers l'activité de réservation de train
                Intent intent = new Intent(VoyageHome.this, TrainReservationActivity.class);
                startActivity(intent);
            }
        });

        Button buttonAvion = findViewById(R.id.button_avion);
        buttonAvion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Naviguer vers l'activité de réservation d'avion
                Intent intent = new Intent(VoyageHome.this, VolReservationActivity.class);
                startActivity(intent);
            }
        });

        // Liste des annonces
        List<String> announcements = Arrays.asList(
                "Annonce 1: Réduction de 20% sur les voyages en bus!",
                "Annonce 2: Voyage en train à moitié prix ce week-end!"
        );

        // Configuration du ViewPager2
        viewPager = findViewById(R.id.viewPager);
        AnnouncementAdapter adapter = new AnnouncementAdapter(announcements);
        viewPager.setAdapter(adapter);

        // Défilement automatique
        runnable = new Runnable() {
            int currentPage = 0;

            @Override
            public void run() {
                if (currentPage == announcements.size()) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
                handler.postDelayed(this, 3000); // Change de page toutes les 3 secondes
            }
        };
        handler.postDelayed(runnable, 3000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable); // Arrête le défilement automatique
    }
}