package com.example.kattamputtamrj;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //0:yellow ,red:1

    int []arr={2,2,2,2,2,2,2,2,2};

    int [][]answer={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    int chance=0;

    boolean game=true;

    int count=0;

    public void dropIn(View view)
    {
        ImageView img=(ImageView) view;

        Log.i("Tag",img.getTag().toString());

        int numTag=Integer.parseInt(img.getTag().toString());

        if(arr[numTag]==2 && game) {

            arr[numTag]=chance;

            count++;

            img.setTranslationY(-1500);

            if (chance == 0) {
                img.setImageResource(R.drawable.yellow);
                chance = 1;
            } else {
                img.setImageResource(R.drawable.red);
                chance = 0;
            }
            img.animate().translationYBy(1500).rotation(3600).setDuration(300);

            for (int[] smallArray : answer) {
                if (arr[smallArray[0]] == arr[smallArray[1]] && arr[smallArray[1]] == arr[smallArray[2]] && arr[smallArray[0]] != 2) {
                    game=false;
                    String msg;

                    if (chance == 0) {
                        msg = "Red";
                    } else {
                        msg = "Yellow";
                    }
                    Button playAgain=(Button)findViewById(R.id.playAgain);
                    TextView result=(TextView)findViewById(R.id.result);
                    result.setText(msg+" has won!");
                    playAgain.setVisibility(View.VISIBLE);
                    result.setVisibility(View.VISIBLE);
                }
            }
        }
        if(count==9 && game)
        {
            game=false;
            Button playAgain=(Button)findViewById(R.id.playAgain);
            TextView result=(TextView)findViewById(R.id.result);
            result.setText("Match Drawn!");
            playAgain.setVisibility(View.VISIBLE);
            result.setVisibility(View.VISIBLE);
        }
    }

//    public void play(View view)
//    {
//        Button playAgain=(Button) findViewById(R.id.playAgain);
//
//        TextView result=(TextView) findViewById(R.id.result);
//
//        playAgain.setVisibility(View.INVISIBLE);
//
//        result.setVisibility(View.INVISIBLE);
//
//        GridLayout gridLayout=(GridLayout)findViewById(R.id.gridLayout);
//
//        for(int i=0;i<gridLayout.getChildCount();i++)
//        {
//            ImageView img=(ImageView)gridLayout.getChildAt(i);
//            img.setImageDrawable(null);
//        }
//
//        for(int i=0;i<arr.length;i++)
//        {
//            arr[i]=2;
//        }
//
//        game=true;
//
//        chance=0;
//    }

    public void play(View view)
    {
        Button playAgain=(Button) findViewById(R.id.playAgain);

        TextView result=(TextView) findViewById(R.id.result);

        playAgain.setVisibility(View.INVISIBLE);

        result.setVisibility(View.INVISIBLE);

        ImageView img1=(ImageView)findViewById(R.id.imageView1);
        img1.setImageDrawable(null);

        ImageView img2=(ImageView)findViewById(R.id.imageView2);
        img2.setImageDrawable(null);

        ImageView img3=(ImageView)findViewById(R.id.imageView3);
        img3.setImageDrawable(null);

        ImageView img4=(ImageView)findViewById(R.id.imageView4);
        img4.setImageDrawable(null);

        ImageView img5=(ImageView)findViewById(R.id.imageView5);
        img5.setImageDrawable(null);

        ImageView img6=(ImageView)findViewById(R.id.imageView6);
        img6.setImageDrawable(null);

        ImageView img7=(ImageView)findViewById(R.id.imageView7);
        img7.setImageDrawable(null);

        ImageView img8=(ImageView)findViewById(R.id.imageView8);
        img8.setImageDrawable(null);

        ImageView img9=(ImageView)findViewById(R.id.imageView9);
        img9.setImageDrawable(null);

        for(int i=0;i<arr.length;i++)
        {
            arr[i]=2;
        }

        game=true;

        chance=0;

        count=0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}