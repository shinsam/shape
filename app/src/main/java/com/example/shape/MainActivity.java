package com.example.shape;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shape.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    int drawableId[] = {
            R.drawable.dog01, R.drawable.dog02, R.drawable.cat01,
            R.drawable.cat02, R.drawable.bear01, R.drawable.deer01
    };
    boolean answer = false;
    ImageView resultImage[] = new ImageView[2];

    String mainShape="";
    ImageView selectedImageView = null; // 선택된 이미지 뷰를 저장할 변수

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.radioButton1.setChecked(true);
                binding.imageCircle.setBackgroundResource(R.drawable.selected_border); // 테두리 배경 적용
                binding.imageSquare.setBackgroundResource(0); // 배경 제거
            }
        });

        binding.imageSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.radioButton2.setChecked(true);
                binding.imageSquare.setBackgroundResource(R.drawable.selected_border); // 테두리 배경 적용
                binding.imageCircle.setBackgroundResource(0); // 배경 제거
            }
        });

        binding.startImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SubActivity.class);

                if (binding.radioButton1.isChecked()) {   //cat  선택시
                    mainShape = "cat";
                    intent.putExtra("shape", "cat");
                    launcher.launch(intent);
                } else if (binding.radioButton2.isChecked()) { //dog 선택시
                    mainShape = "dog";
                    intent.putExtra("shape", "dog");
                    launcher.launch(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "찾고 싶은 모양을 선택하세요", Toast.LENGTH_SHORT).show();
                }


            }
        });

        Log.d("Life Cycle", "onCreate 메소드가 호출됨");

    }

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    //다시 처음 인텐트로 돌아왔을때 호출되는 부분
                    Log.d("MainActivity", "registerForActivityResult  이 호출됨");

                   /* if (result.getResultCode() == RESULT_OK) {

                        binding.imageResult01.setVisibility(View.VISIBLE);
                        binding.imageResult02.setVisibility(View.VISIBLE);
                        resultImage[0] = binding.imageResult01;
                        resultImage[1] = binding.imageResult02;

                        int num =0;
                        int selectTag[] = new int[6];
                        selectTag = result.getData().getIntArrayExtra("answer");
                        for (int i = 0; i < 6; i++) {
                            if(selectTag[i]!=0 ) {

                                resultImage[num].setImageResource(selectTag[i]);
                                num++;

                            }
                        }*/

                     /*   binding.textViewResult.setText("틀렸습니다.");
                        if (binding.radioButton1.isChecked()) {
                            if (selectTag[0].contains("cat") && selectTag[1].contains("cat"))
                                binding.textViewResult.setText("정답입니다.");

                            } else if (binding.radioButton2.isChecked()) {
                            if (selectTag[0].contains("dog") && selectTag[1].contains("dog"))
                                binding.textViewResult.setText("맞았습니다");
                        }


                    }*/

                }
            }
    );

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Life Cycle", "onStart 메소드");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Life Cycle", "onDestroy 메소드");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Life Cycle", "onResume 메소드");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Life Cycle", "onPause 메소드");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Life Cycle", "onRestart 메소드");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Life Cycle", "onStop 메소드");
    }
}