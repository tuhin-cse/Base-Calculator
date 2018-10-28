package tk.stsoftwaresolution.basecalculator;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;




import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.text.DecimalFormat;

import static java.lang.Math.pow;

public class MainActivity extends AppCompatActivity {

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,
            btn9, btna, btnb, btnc, btnd, btne, btnf, btnplus,
            btnminus, btnmul, btndiv, btnequal, btnac, btndel, btndec,
            btnhex, btnoct, btnbin, btndot;
    private TextView inputtxt, solution,basename;
    private boolean dot, isdec, ishex, isoct, isbin;
    private int Base;
    private String input, result;
    public char sign;
    private String decin,decout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        final Calculator calculator=new Calculator();
        final Convetor convetor = new Convetor();


        Base = 10;
        isdec = true;
        sign='+';

        decin="0";
        decout="0";


        input = "";


        btn0 = findViewById(R.id.btnZero);
        btn1 = findViewById(R.id.btnOne);
        btn2 = findViewById(R.id.btnTwo);
        btn3 = findViewById(R.id.btnThree);
        btn4 = findViewById(R.id.btnFour);
        btn5 = findViewById(R.id.btnFive);
        btn6 = findViewById(R.id.btnSix);
        btn7 = findViewById(R.id.btnSeven);
        btn8 = findViewById(R.id.btnEight);
        btn9 = findViewById(R.id.btnNine);
        btna = findViewById(R.id.btna);
        btnb = findViewById(R.id.btnb);
        btnc = findViewById(R.id.btnc);
        btnd = findViewById(R.id.btnd);
        btne = findViewById(R.id.btne);
        btnf = findViewById(R.id.btnf);
        btnplus = findViewById(R.id.btnAdd);
        btnminus = findViewById(R.id.btnSubtract);
        btnmul = findViewById(R.id.btnMultiply);
        btndiv = findViewById(R.id.btnDivide);
        btnequal = findViewById(R.id.btnEquals);
        btnac = findViewById(R.id.btnAC);
        btndel = findViewById(R.id.btnDEl);
        btndec = findViewById(R.id.btndec);
        btnhex = findViewById(R.id.btnhex);
        btnoct = findViewById(R.id.btnoct);
        btnbin = findViewById(R.id.btnbin);
        btndot = findViewById(R.id.btnDecimal);
        inputtxt = findViewById(R.id.txtInput);
        solution = findViewById(R.id.txtSolution);
        basename = findViewById(R.id.basename);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "0";
                inputtxt.setText(input);
                decin = convetor.convertDec(input,Base);
              //  Toast.makeText(MainActivity.this,""+decin,Toast.LENGTH_LONG).show();

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "1";
                inputtxt.setText(input);
                decin = convetor.convertDec(input,Base);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    if (isdec || ishex || isoct) {
                        input += "2";
                        inputtxt.setText(input);
                        decin = convetor.convertDec(input,Base);

                    }
                }

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isdec || ishex || isoct) {
                    input += "3";
                    inputtxt.setText(input);
                    decin = convetor.convertDec(input,Base);

                }

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isdec || ishex || isoct) {
                    input += "4";
                    inputtxt.setText(input);
                    decin = convetor.convertDec(input,Base);
                }

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isdec || ishex || isoct) {
                    input += "5";
                    inputtxt.setText(input);
                    decin = convetor.convertDec(input,Base);
                }

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isdec || ishex || isoct) {
                    input += "6";
                    inputtxt.setText(input);
                    decin = convetor.convertDec(input,Base);
                }


            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isdec || ishex || isoct) {
                    input += "7";
                    inputtxt.setText(input);
                    decin = convetor.convertDec(input,Base);
                }


            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isdec || ishex) {
                    input += "8";
                    inputtxt.setText(input);
                    decin = convetor.convertDec(input,Base);
                }


            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isdec || ishex) {
                    input += "9";
                    inputtxt.setText(input);
                    decin = convetor.convertDec(input,Base);
                }


            }
        });


        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ishex) {
                    input += "A";
                    inputtxt.setText(input);
                    decin = convetor.convertDec(input,Base);
                }


            }
        });

        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ishex) {
                    input += "B";
                    inputtxt.setText(input);
                    decin = convetor.convertDec(input,Base);
                }

            }
        });


        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ishex) {
                    input += "C";
                    inputtxt.setText(input);
                    decin = convetor.convertDec(input,Base);
                }

            }
        });

        btnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ishex) {
                    input += "D";
                    inputtxt.setText(input);
                    decin = convetor.convertDec(input,Base);
                }

            }
        });

        btne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ishex) {
                    input += "E";
                    inputtxt.setText(input);
                    decin = convetor.convertDec(input,Base);
                }

            }
        });

        btnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ishex) {
                    input += "F";
                    inputtxt.setText(input);
                    decin = convetor.convertDec(input,Base);
                }

            }
        });


        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(decout=="Math Error")
                    decout="0";
                try {
                    if (sign == '+')
                        decout=calculator.sum(decout,decin);
                    if (sign == '-')
                        decout=calculator.sub(decout,decin);
                    if (sign == '*')
                        decout=calculator.mul(decout,decin);
                    if (sign == '/')
                        decout=calculator.div(decout,decin);
                    sign = '+';
                    solution.setText(convetor.converttobase(decout,Base));
                    inputtxt.setText("");
                    input = "";
                    decin="0";
                }
                catch(Exception e)
                {
                    sign = '+';
                    inputtxt.setText("");
                    solution.setText("");
                    decout="0";
                    decin="0";
                    input = "";
                }

            }
        });


        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(decout=="Math Error")
                    decout="0";
                if(input=="" )
                {
                    input+="-";
                    inputtxt.setText(input);
                }
                else if(input.compareTo("-")==0)
                {
                    inputtxt.setText("");
                    input="";
                }
                else
                {
                    try {
                        if (sign == '+')
                            decout= calculator.sum(decout,decin);
                        if (sign == '-')
                            decout= calculator.sub(decout,decin);
                        if (sign == '*')
                            decout= calculator.mul(decout,decin);
                        if (sign == '/')
                            decout= calculator.div(decout,decin);
                        sign = '-';
                        solution.setText(convetor.converttobase(decout,Base));
                        inputtxt.setText("");
                        input = "";
                       decin="0";
                   }
                    catch(Exception e)
                    {
                        sign = '-';
                        inputtxt.setText("");
                        input = "";
                        decin="0";
                        decout="0";
                    }

                }

            }
        });


        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(decout=="Math Error")
                    decout="0";
                try {
                    if (sign == '+')
                        decout = calculator.sum(decout, decin);
                    if (sign == '-')
                        decout = calculator.sub(decout, decin);
                    if (sign == '*')
                        decout = calculator.mul(decout, decin);
                    if (sign == '/')
                        decout = calculator.div(decout, decin);
                    sign = '*';
                    solution.setText(convetor.converttobase(decout, Base));
                    inputtxt.setText("");
                    input = "";
                    decin = "0";
                }
                catch(Exception e)
                {
                    sign = '*';
                    inputtxt.setText("");
                    input = "";
                    decin="0";
                    decout="0";
                }


            }
        });

        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(decout=="Math Error")
                    decout="0";
                try {
                    if (sign == '+')
                        decout= calculator.sum(decout,decin);
                    if (sign == '-')
                        decout= calculator.sub(decout,decin);
                    if (sign == '*')
                        decout= calculator.mul(decout,decin);
                    if (sign == '/')
                        decout=calculator.div(decout,decin);
                    sign = '/';
                    solution.setText(convetor.converttobase(decout,Base));
                    inputtxt.setText("");
                    input = "";
                    decin="0";
                 }
                catch(Exception e)
                {
                sign = '*';
                inputtxt.setText("");
                input = "";
                decin="0";
                decout="0";
               }


            }
        });

        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(decout=="Math Error")
                    decout="0";
                try {
                    //   Toast.makeText(MainActivity.this,decout + " " + sign  + " " + decin,Toast.LENGTH_SHORT).show();
                    if (sign == '+')
                        decout = calculator.sum(decout, decin);
                    if (sign == '-')
                        decout = calculator.sub(decout, decin);
                    if (sign == '*')
                        decout = calculator.mul(decout, decin);
                    if (sign == '/')
                        decout = calculator.div(decout, decin);
                    solution.setText(convetor.converttobase(decout, Base));
                    //   Toast.makeText(MainActivity.this,convetor.converttobase(decout,Base),Toast.LENGTH_SHORT).show();
                    sign = '+';
                    input = "";
                    inputtxt.setText("");
                    decin = "0";
                }
                catch (Exception e)
                {
                    decout="0";
                    decin="0";
                    inputtxt.setText(null);
                    solution.setText("Error");
                    sign='+';
                }



            }
        });


        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    input = input.substring(0,input.length()-1);
                    inputtxt.setText(input);
                    decin = convetor.convertDec(input,Base);
                }
                catch (Exception e)
                {
                    inputtxt.setText(null);
                    solution.setText(null);
                    input = "";
                    decin="0";
                    decout="0";
                }

            }
        });

        btnac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputtxt.setText(null);
                solution.setText(null);
                input = "";
                decin="0";
                decout="0";

            }
        });

        btndec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (Base != 10) {

                        ishex = false;
                        isdec = true;
                        isoct = false;
                        Base = 10;
                        basenameset();
                        if (decin.compareTo("0")!=0)
                              inputtxt.setText(decin);
                        if (decout.compareTo("0")!=0)
                            solution.setText(decout);

                    }
                } catch (Exception e) {
                    inputtxt.setText("");
                    solution.setText("");
                    decin="0";
                    decout="0";
                    sign='+';
                    ishex = false;
                    isdec = true;
                    isoct = false;
                    Base = 10;

                }

            }
        });

        btnhex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (Base != 16) {

                        ishex = true;
                        isdec = false;
                        isoct = false;
                        Base = 16;
                        basenameset();

                        if (decin.compareTo("0")!=0)
                            inputtxt.setText(convetor.converttobase(decin,16));
                       if (decout.compareTo("0")!=0)
                            solution.setText(convetor.converttobase(decout,16));

                    }
                } catch (Exception e) {
                    inputtxt.setText("");
                    solution.setText("");
                    decin="0";
                    decout="0";
                    sign='+';
                    ishex = true;
                    isdec = false;
                    isoct = false;
                    Base = 16;

                }
                //    btnbin.setBackground(btnbackground);
                //     btnhex.setBackground(btnbackgroundfucas);
                //      btndec.setBackground(btnbackground);
                //       btnoct.setBackground(btnbackground);

            }
        });

        btnoct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (Base != 8) {

                        ishex = false;
                        isdec = false;
                        isoct = true;
                        Base = 8;
                        basenameset();
                        if (decin.compareTo("0")!=0)
                            inputtxt.setText(convetor.converttobase(decin,Base));
                        if (decout.compareTo("0")!=0)
                            solution.setText(convetor.converttobase(decout,Base));
                    }
                } catch (Exception e) {
                    inputtxt.setText("");
                    solution.setText("");
                    decin="0";
                    decout="0";
                    sign='+';
                    Base = 8;
                    ishex = false;
                    isdec = false;
                    isoct = true;

                }


            }
        });

        btnbin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (Base != 2) {

                        ishex = false;
                        isdec = false;
                        isoct = false;
                        Base = 2;
                        basenameset();
                        if (decin.compareTo("0")!=0)
                            inputtxt.setText(convetor.converttobase(decin,Base));
                        if (decout.compareTo("0")!=0)
                            solution.setText(convetor.converttobase(decout,Base));
                    }
                } catch (Exception e) {
                    inputtxt.setText("");
                    solution.setText("");
                    decin="0";
                    decout="0";
                    sign='+';
                    Base = 2;
                    ishex = false;
                    isdec = false;
                    isoct = false;
                }

                //    btnbin.setBackground(btnbackgroundfucas);
                //     btnhex.setBackground(btnbackground);
                //      btndec.setBackground(btnbackground);
                //       btnoct.setBackground(btnbackground);
            }
        });

        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += ".";
                inputtxt.setText(input);

            }
        });


    }
    
  

    public void basenameset()
    {
        if(Base==10)
            basename.setText("Decimal");
        else if(Base==16)
            basename.setText("Hexa Decimal");
        else if(Base==8)
            basename.setText("Octal");
        else if(Base==2)
            basename.setText("Binary");

    }
}

