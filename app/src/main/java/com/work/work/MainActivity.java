package com.work.work;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adapter.DetailsAdapter;
import model.Details;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    Button btnSave;
    EditText etName, etAge;
    RadioGroup radioGroup;
    Spinner upload;

    //DetailsAdapter detailsAdapter = new DetailsAdapter(this, detailsList);
    String name,age, gender;
    int imageId;
    final  List<Details> detailsList = new ArrayList<>();
    String image[] = {"Lion", "Fox"};
    int imageValue[] = {R.drawable.lion, R.drawable.fox};
    Map<String, Integer> imageMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);


        radioGroup = findViewById(R.id.rgGender);
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        btnSave = findViewById(R.id.btnSave);
        upload = findViewById(R.id.upload);

        imageMap = new HashMap<>();
        for (int i = 0; i < image.length; i += 1) {
            imageMap.put(image[i], imageValue[i]);
        }

        ArrayAdapter<String> imageAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<>(imageMap.keySet())
        );
        upload.setAdapter(imageAdapter);

        upload.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String imagePos = parent.getItemAtPosition(position).toString();

                imageId = imageMap.get(imagePos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                name = etName.getText().toString();
//
//                age = etAge.getText().toString();
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == R.id.rbMale){
                    gender = "M";

                }
                else if(selectedId == R.id.rbFemale){
                    gender = "F";
                }
                else if (selectedId == R.id.rbOthers){
                    gender = "O";
                }
                //detailsList.add(new Details(name, age , imageId ,gender));
               detailsList.add(new Details(etName.getText().toString(),etAge.getText().toString(),imageId,gender));

                DetailsAdapter detailsAdapter = new DetailsAdapter(MainActivity.this, detailsList);
                recyclerView.setAdapter(detailsAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }
        });

    }

}
