package uk.com.calculator;

import android.view.View.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bM,bP,bS,bE,bD,bC;
    EditText main;
    double result=0.0; //result value
    int checkfirst=0; //value for check input wrong button
    int numfirst=0; //value for check it is first value
    char before;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button) findViewById(R.id.b1);b2=(Button) findViewById(R.id.b2);b3=(Button) findViewById(R.id.b3);
        b4=(Button) findViewById(R.id.b4);b5=(Button) findViewById(R.id.b5);b6=(Button) findViewById(R.id.b6);
        b7=(Button) findViewById(R.id.b7);b8=(Button) findViewById(R.id.b8);b9=(Button) findViewById(R.id.b9);
        b0=(Button) findViewById(R.id.b0);bM=(Button) findViewById(R.id.bMulti);bD=(Button) findViewById(R.id.bDiv);
        bP=(Button) findViewById(R.id.bPlu);bS=(Button) findViewById(R.id.bSub);bE=(Button) findViewById(R.id.bEq);
        bC=(Button)findViewById(R.id.bC);
        main=(EditText)findViewById(R.id.main);

        b1.setOnClickListener(this);b2.setOnClickListener(this);b3.setOnClickListener(this);b4.setOnClickListener(this);
        b5.setOnClickListener(this);b6.setOnClickListener(this);b7.setOnClickListener(this);b8.setOnClickListener(this);
        b9.setOnClickListener(this);b0.setOnClickListener(this);bM.setOnClickListener(this);bP.setOnClickListener(this);
        bS.setOnClickListener(this);bE.setOnClickListener(this);bD.setOnClickListener(this);bC.setOnClickListener(this);

    }
    //check function for check it is number
    public boolean check(String value){
        int count,judge,i,count2;
        char change[];
        judge=0;
        count2=0;//num of '.' for cheack is number or not

        change=value.toCharArray();
        count=value.length();

        if(count == 0)//if String is null
            judge++;

        for(i=0;i<count;i++){
            if((change[i] < 48 || change[i] > 57)) {
                if(change[i] != '.')
                    judge++;// if chane[i] is not digit
                else
                    count2++;// if change[i] == '.'
            }
        }
        if(judge == 0 && count2 < 2 )
           return true;//return it is number
        else
           return false;//return it is not number
    }

    //
    public void onClick(View view){
        //if pushed button is +, -, *, /, =, C
        if(view.getId() == bE.getId() || view.getId() == bP.getId() || view.getId() == bS.  getId() || view.getId() == bM.getId() || view.getId() ==bD.getId() || view.getId() == bC.getId()){
            //reset all values
            if(view.getId()==bC.getId()){
                main.setText("0.00");
                numfirst=0;
                checkfirst=0;
                result=0;
            }
            //button is +
            else if(view.getId()==bP.getId()){
                //if input first
                if(checkfirst == 0){//if before button is not symbol
                    if(numfirst == 0) {// if it is first number
                        result = Double.valueOf(main.getText().toString());//set first value
                        numfirst++;
                        checkfirst++;
                    }
                    //not first num
                    else {//calculate before result
                        if(before == '+') {
                            result = result + Double.valueOf(main.getText().toString());
                            checkfirst++;
                        }
                        else if(before == '-') {
                            result = result - Double.valueOf(main.getText().toString());
                            checkfirst++;
                        }
                        else if(before == '*') {
                            result = result * Double.valueOf(main.getText().toString());
                            checkfirst++;
                        }
                        else if(before == '/')  { // if dived by 0 toast can't devide by0
                            if(Double.valueOf(main.getText().toString())==00)
                                Toast.makeText(getApplicationContext(),"you can't input 0 number ", Toast.LENGTH_LONG).show();
                            else
                                result = result / Double.valueOf(main.getText().toString());
                            checkfirst++;
                        }
                    }
                    main.setText(String.valueOf(result));
                    before='+'; //value for protect double symbol ex) ** */ // ++
                }
                else
                    Toast.makeText(getApplicationContext(),"you can input number ", Toast.LENGTH_LONG).show();//if before input is Symbol block input
             }
            //button is -  principal is same as button +
            else if(view.getId()==bS.getId()){
                if(checkfirst == 0){
                    if(numfirst == 0) {
                        result = Double.valueOf(main.getText().toString());
                        numfirst++;
                        checkfirst++;
                    }
                    else {
                        if(before == '+') {
                            result = result + Double.valueOf(main.getText().toString());
                            checkfirst++;
                        }
                        else if(before == '-') {
                            result = result - Double.valueOf(main.getText().toString());
                            checkfirst++;
                        }
                        else if(before == '*') {
                            result = result * Double.valueOf(main.getText().toString());
                            checkfirst++;
                        }
                        else if(before == '/') {
                            if(Double.valueOf(main.getText().toString())==00)
                                Toast.makeText(getApplicationContext(),"you can't input 0 number ", Toast.LENGTH_LONG).show();
                            else
                                result = result / Double.valueOf(main.getText().toString());
                           checkfirst++;
                        }
                    }
                    main.setText(String.valueOf(result));
                    before='-';
                }
                else
                    Toast.makeText(getApplicationContext(),"you can input number ", Toast.LENGTH_LONG).show();
            }
            //button is *  principal is same as button +
            else if(view.getId()==bM.getId()){
                if(checkfirst == 0){
                    if(numfirst == 0) {
                        result = Double.valueOf(main.getText().toString());
                        numfirst++;
                        checkfirst++;
                    }
                    else {
                        if(before == '+') {
                            result = result + Double.valueOf(main.getText().toString());
                            checkfirst++;
                        }
                        else if(before == '-') {
                            result = result - Double.valueOf(main.getText().toString());
                            checkfirst++;
                        }
                        else if(before == '*') {
                            result = result * Double.valueOf(main.getText().toString());
                            checkfirst++;
                        }
                        else if(before == '/')  {
                            if(Double.valueOf(main.getText().toString())==00)
                                Toast.makeText(getApplicationContext(),"you can't input 0 number ", Toast.LENGTH_LONG).show();
                            else
                                result = result / Double.valueOf(main.getText().toString());
                            checkfirst++;
                        }
                    }
                    main.setText(String.valueOf(result));
                    before='*';
                }
                else
                    Toast.makeText(getApplicationContext(),"you can input number ", Toast.LENGTH_LONG).show();//if before input is Symbol block input
            }
            //button is  =
            else if(view.getId()==bE.getId()){

                if(checkfirst == 0){//before button is not symbol
                    if(numfirst == 0) //if first button is reject input
                        Toast.makeText(getApplicationContext(), "you can input number ", Toast.LENGTH_LONG).show();

                    else {//calculate before result
                        if(before == '+') {
                            result = result + Double.valueOf(main.getText().toString());
                            checkfirst++;
                        }
                        else if(before == '-') {
                            result = result - Double.valueOf(main.getText().toString());
                            checkfirst++;
                        }
                        else if(before == '*') {
                            result = result * Double.valueOf(main.getText().toString());
                            checkfirst++;
                        }
                        else if(before == '/') {//if divide by 0 reject input
                            if(Double.valueOf(main.getText().toString())==00)
                                Toast.makeText(getApplicationContext(),"you can't input 0 number ", Toast.LENGTH_LONG).show();
                            else
                                result = result / Double.valueOf(main.getText().toString());
                            checkfirst++;
                        }
                    }
                    main.setText(String.valueOf(result));//print totalvalue
                    before='=';
                }
                else
                    Toast.makeText(getApplicationContext(),"you can input number ", Toast.LENGTH_LONG).show();
            }
            //button is /  principal is same as button +
            else if(view.getId()==bD.getId()){

                if(checkfirst == 0){
                    if(numfirst == 0){
                        numfirst++;
                        checkfirst++;
                        result = Double.valueOf(main.getText().toString());
                    }


                    else {//calculate before result
                        if(before == '+') {
                            result = result + Double.valueOf(main.getText().toString());
                            checkfirst++;
                        }
                        else if(before == '-') {
                            result = result - Double.valueOf(main.getText().toString());
                            checkfirst++;
                        }
                        else if(before == '*') {
                            result = result * Double.valueOf(main.getText().toString());
                            checkfirst++;
                        }
                        else if(before == '/')  {
                            if(Double.valueOf(main.getText().toString())==00)
                                Toast.makeText(getApplicationContext(),"you can't input 0 number ", Toast.LENGTH_LONG).show();//if before input is Symbol block input
                            else
                                result = result / Double.valueOf(main.getText().toString());
                            checkfirst++;
                        }
                    }
                    main.setText(String.valueOf(result));
                    before='/';
                }
                else
                    Toast.makeText(getApplicationContext(),"you can input number ", Toast.LENGTH_LONG).show();//여기손봐야됨
            }
        }
        else{
            double temp;
            if(checkfirst ==1) { // check it before button is symbol
                if(before == '=')
                    result=0.0;  //if button is = reset value
                temp = 0.0;
            }
            else
                temp = Double.valueOf(main.getText().toString());

            checkfirst=0;
            if(temp == 0.0){// if input first reset and input new value
                if(view.getId()==b1.getId())
                    main.setText("1");
                else if(view.getId()==b2.getId())
                    main.setText("2");
                else if(view.getId()==b3.getId())
                    main.setText("3");
                else if(view.getId()==b4.getId())
                    main.setText("4");
                else if(view.getId()==b5.getId())
                    main.setText("5");
                else if(view.getId()==b6.getId())
                    main.setText("6");
                else if(view.getId()==b7.getId())
                    main.setText("7");
                else if(view.getId()==b8.getId())
                    main.setText("8");
                else if(view.getId()==b9.getId())
                    main.setText("9");
                else if(view.getId()==b0.getId())
                    main.setText("0");
            }
            else{//continue
                if(view.getId()==b1.getId())
                    main.setText(main.getText()+"1");
               else if(view.getId()==b2.getId())
                    main.setText(main.getText()+"2");
                else if(view.getId()==b3.getId())
                    main.setText(main.getText()+"3");
                else if(view.getId()==b4.getId())
                    main.setText(main.getText()+"4");
                else if(view.getId()==b5.getId())
                    main.setText(main.getText()+"5");
                else if(view.getId()==b6.getId())
                    main.setText(main.getText()+"6");
                else if(view.getId()==b7.getId())
                    main.setText(main.getText()+"7");
                else if(view.getId()==b8.getId())
                    main.setText(main.getText()+"8");
                else if(view.getId()==b9.getId())
                    main.setText(main.getText()+"9");
                else if(view.getId()==b0.getId())
                    main.setText(main.getText()+"0");
            }
        }
    }
}
