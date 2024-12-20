package com.example.dummy;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView tshirtImage;
    private RecyclerView tshirtRecyclerView;
    private TshirtAdapter tshirtAdapter;

    // Shirt details views
    private TextView shirtName;
    private TextView shirtDescription;
    private TextView shirtSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Make sure this matches your activity layout XML

        // Initialize the views
        tshirtImage = findViewById(R.id.tshirtImage);
        tshirtRecyclerView = findViewById(R.id.tshirtRecyclerView);
        shirtName = findViewById(R.id.shirtName);
        shirtDescription = findViewById(R.id.shirtDescription);
        shirtSize = findViewById(R.id.shirtSize);

        // Set up RecyclerView with a horizontal LinearLayoutManager
        tshirtRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Prepare the list of T-shirt images, adding the "None" option first with vector icon
        List<Integer> tshirtList = new ArrayList<>();
        tshirtList.add(R.drawable.ic_none);  // Add the "None" option as a vector asset
        tshirtList.add(R.drawable.tshirt1);  // Example image resource
        tshirtList.add(R.drawable.tshirt2);  // Example image resource
        tshirtList.add(R.drawable.tshirt3);  // Example image resource
        tshirtList.add(R.drawable.tshirt4);  // Example image resource
        tshirtList.add(R.drawable.tshirt5);  // Example image resource
        tshirtList.add(R.drawable.tshirt6);  // Example image resource
        tshirtList.add(R.drawable.tshirt1);  // Example image resource
        tshirtList.add(R.drawable.tshirt2);  // Example image resource
        tshirtList.add(R.drawable.tshirt3);  // Example image resource
        tshirtList.add(R.drawable.tshirt4);  // Example image resource
        tshirtList.add(R.drawable.tshirt5);  // Example image resource
        tshirtList.add(R.drawable.tshirt6);  // Example image resource

        // Create an adapter for the RecyclerView
        tshirtAdapter = new TshirtAdapter(tshirtList, this::onTshirtClick);
        tshirtRecyclerView.setAdapter(tshirtAdapter);
    }

    /**
     * Called when an item is clicked in the RecyclerView.
     * Updates the t-shirt overlay image and shirt details.
     *
     * @param resourceId The resource ID of the clicked t-shirt image.
     */
    private void onTshirtClick(int resourceId) {
        if (resourceId == R.drawable.ic_none) {
            // "None" option, remove the t-shirt image (or reset)
            tshirtImage.setImageResource(0);  // Clears the image

            // Clear shirt details
            shirtName.setText("Shirt Name");
            shirtDescription.setText("Shirt Description");
            shirtSize.setText("Size: M");
        } else {
            // Set the selected t-shirt image on the dummy
            tshirtImage.setImageResource(resourceId);

            // Update shirt details based on selected T-shirt
            updateShirtDetails(resourceId);
        }
    }

    /**
     * Update the shirt details based on the selected T-shirt.
     *
     * @param resourceId The resource ID of the selected T-shirt image.
     */
    private void updateShirtDetails(int resourceId) {
        // Using if-else to update details
        if (resourceId == R.drawable.tshirt1) {
            shirtName.setText("T-shirt 1");
            shirtDescription.setText("A cool red t-shirt with a nice design.");
            shirtSize.setText("Size: M");
        } else if (resourceId == R.drawable.tshirt2) {
            shirtName.setText("T-shirt 2");
            shirtDescription.setText("A casual blue t-shirt with a simple logo.");
            shirtSize.setText("Size: L");
        } else if (resourceId == R.drawable.tshirt3) {
            shirtName.setText("T-shirt 3");
            shirtDescription.setText("A stylish green t-shirt with a graphic print.");
            shirtSize.setText("Size: S");
        } else {
            // Default case if no shirt matches
            shirtName.setText("Unknown Shirt");
            shirtDescription.setText("No description available.");
            shirtSize.setText("Size: N/A");
        }
    }
}
