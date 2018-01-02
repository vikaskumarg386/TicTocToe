package com.example.vikas.tictoctoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button reset;
    private int[] img={R.drawable.zero,R.drawable.cross};
    private ImageView imageView;
    private int[] gameState={2,2,2,2,2,2,2,2,2};
    private LinearLayout linearLayout;
    private TextView name;

    private int k=0;

     public void onTapped(View view){

        ImageView imageView=(ImageView)view;
        name=(TextView)findViewById(R.id.nameOfWonPlayer);

        int imgeNumber=Integer.parseInt(imageView.getTag().toString());

        if(gameState[imgeNumber-1]==2){
        imageView.setImageResource(img[k]);
        imageView.animate().rotationBy(360).setDuration(1000);}
        gameState[imgeNumber-1]=k;
        if(k==0){
            k=1;}
        else
        { k=0;}


        //winning logic

         for(int i=0;i<7;i+=3)
         {
            if(gameState[i]==0&&gameState[i+1]==0&&gameState[i+2]==0){
               // Toast.makeText(MainActivity.this,"first player won",Toast.LENGTH_LONG).show();
                name.setText("first player won");
                for(int j=0;j<9;j++)
                    gameState[j]=3;
            }

             if(gameState[i]==1&&gameState[i+1]==1&&gameState[i+2]==1) {
               // Toast.makeText(MainActivity.this, "second player won", Toast.LENGTH_LONG).show();
                name.setText("second player won");
                 for(int j=0;j<9;j++)
                     gameState[j]=3;
            }


         }
         for(int i=0;i<3;i++)
         {
             if(gameState[i]==0&&gameState[i+3]==0&&gameState[i+6]==0){
                // Toast.makeText(MainActivity.this,"first player won",Toast.LENGTH_LONG).show();
                 name.setText("first player won");
                 for(int j=0;j<9;j++)
                     gameState[j]=3;
             }

             if(gameState[i]==1&&gameState[i+3]==1&&gameState[i+6]==1){
                // Toast.makeText(MainActivity.this,"second player won",Toast.LENGTH_LONG).show();
                 name.setText("second player won");
                 for(int j=0;j<9;j++)
                     gameState[j]=3;
             }


         }


             if (gameState[0]==0&&gameState[4]==0&&gameState[8]==0){
                // Toast.makeText(MainActivity.this,"first player won",Toast.LENGTH_LONG).show();
                 name.setText("first player won");
                 for(int j=0;j<9;j++)
                     gameState[j]=3;
             }
             if (gameState[2]==0&&gameState[4]==0&&gameState[6]==0){
             Toast.makeText(MainActivity.this,"first player won",Toast.LENGTH_LONG).show();
                 name.setText("first player won");
                 for(int j=0;j<9;j++)
                     gameState[j]=3;
             }


         if (gameState[0]==1&&gameState[4]==1&&gameState[8]==1){
            // Toast.makeText(MainActivity.this,"second player won",Toast.LENGTH_LONG).show();name.setText("first player won");
             name.setText("second player won");
             for(int j=0;j<9;j++)
                 gameState[j]=3;
         }

         if (gameState[2]==1&&gameState[4]==1&&gameState[6]==1){
             //Toast.makeText(MainActivity.this,"second player won",Toast.LENGTH_LONG).show();
                 name.setText("second player won");
             for(int j=0;j<9;j++)
                 gameState[j]=3;
             }





     }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reset=(Button)findViewById(R.id.reset);
        name=(TextView)findViewById(R.id.nameOfWonPlayer);



        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name.setText("");
                  for(int i=0;i<9;i++)
                      gameState[i]=2;
                  k=0;

                linearLayout=(LinearLayout)findViewById(R.id.linearLayoutOne);
                for(int i=0;i<linearLayout.getChildCount();i++)
                    ((ImageView)linearLayout.getChildAt(i)).setImageResource(R.drawable.avatar);

                linearLayout=(LinearLayout)findViewById(R.id.linearLayoutTwo);
                for(int i=0;i<linearLayout.getChildCount();i++)
                    ((ImageView)linearLayout.getChildAt(i)).setImageResource(R.drawable.avatar);
                linearLayout=(LinearLayout)findViewById(R.id.linearLayoutThree);
                for(int i=0;i<linearLayout.getChildCount();i++)
                    ((ImageView)linearLayout.getChildAt(i)).setImageResource(R.drawable.avatar);


            }
        });
    }
}
