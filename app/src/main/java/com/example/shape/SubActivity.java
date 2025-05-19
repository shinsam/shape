package com.example.shape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.shape.databinding.ActivitySubBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubActivity extends AppCompatActivity implements View.OnClickListener {

    ActivitySubBinding binding;
    String mainShape;

    int count = 0;
    int selectTag[] = new int[6];
    int CorrectCount = 0;   //정답 개수


    // 이미지 리소스 ID 배열
    int[] imageResIds = {
            R.drawable.cat01, R.drawable.cat02, R.drawable.dog01,
            R.drawable.dog02, R.drawable.bear01, R.drawable.deer01
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySubBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //찾아야 하는 모양 화면에 표시
        Intent intent = getIntent();
        mainShape = intent.getStringExtra("shape");

        if(mainShape.equals("cat")){
            binding.imageView.setImageResource(R.drawable.cat_main);
        }
        else if(mainShape.equals("dog")){
            binding.imageView.setImageResource(R.drawable.dog_main);
        }
        //이미지 리소스 배열
        ImageView imgViews[] = {
                binding.image01,
                binding.image02,
                binding.image03,
                binding.image04,
                binding.image05,
                binding.image06
        };

        // 이미지 리소스 ID 리스트로 변환
        List<Integer> listForRand = new ArrayList<>();
        for (int id : imageResIds) {
            listForRand.add(id);
        }

        // 이미지 순서 랜덤 섞기
        Collections.shuffle(listForRand); //drawble에 저장된 그림 순서 셔플


        //랜덤으로 섞인 이미지 리소스 ID를 ImageView에 설정
        for (int i = 0; i < 6; i++) {
            int resId = listForRand.get(i); //랜덤으로 섞인 이미지 리소스 ID
            imgViews[i].setImageResource(resId);
            imgViews[i].setTag(resId); //이미지 이름을 알기 위함
        }

        //선택해야 하는 6개의 이미지에 리스너 달기
        for (int i = 0; i < 6; i++) {
            imgViews[i].setOnClickListener(this);
        }

        //결과보기 이미지 버튼을 클릭했을때
        binding.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = getIntent();
                intent1.putExtra("answer", selectTag);
                setResult(RESULT_OK, intent1);
                finish();
            }
        });


    }

    @Override
    public void onClick(View view) {

        int id = (int)view.getTag();
        String imageName = getResources().getResourceEntryName(id);
        Log.d("test", imageName);


        ImageView checkImage = new ImageView(this);
        checkImage.setScaleType(ImageView.ScaleType.CENTER_INSIDE);


        if(imageName.contains(mainShape)){
            checkImage.setImageResource(R.drawable.ok_sign);
            CorrectCount++;
        }else {
            checkImage.setImageResource(R.drawable.no_sign);
        }

//        if (imageName.contains("dog")) {
//            //Toast.makeText(this, "이건 강아지입니다 🐶", Toast.LENGTH_SHORT).show();
//            Log.d("test", imageName + "강아지입니다 🐶");
//        } else if (imageName.contains("cat")) {
//            //Toast.makeText(this, "이건 고양이입니다 🐱", Toast.LENGTH_SHORT).show();
//            Log.d("test", imageName + "고양이입니다\uD83D\uDC31");
//        } else {
//            //Toast.makeText(this, "알 수 없는 동물입니다", Toast.LENGTH_SHORT).show();
//            Log.d("test", imageName + "알 수 없는 동물입니다");
//        }
        count ++;
        if(count==2){
            if(CorrectCount == 2)
                Toast.makeText(this, "완벽해요!", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "다음기회에...", Toast.LENGTH_SHORT).show();

        }else if(count>=2){
            Toast.makeText(this, "기회는 2번 입니다", Toast.LENGTH_SHORT).show();
            return;
        }



        int res_id = view.getId();
        if (res_id == R.id.image01) {
            binding.frameLayout01.addView(checkImage);
            selectTag[0] = res_id;
        } else if (res_id == R.id.image02) {
            binding.frameLayout02.addView(checkImage);
            selectTag[1] = res_id;
        } else if (res_id == R.id.image03) {
            binding.frameLayout03.addView(checkImage);
            selectTag[2] = res_id;
        } else if (res_id == R.id.image04) {
            binding.frameLayout04.addView(checkImage);
            selectTag[3] = res_id;
        } else if (res_id == R.id.image05) {
            binding.frameLayout05.addView(checkImage);
            selectTag[4] = res_id;
        } else if (res_id == R.id.image06) {
            binding.frameLayout06.addView(checkImage);
            selectTag[5] = res_id;
        }
    }
}