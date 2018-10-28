package tk.stsoftwaresolution.basecalculator;

import static java.lang.Math.pow;

public class Convetor {
    String temp="";
    public String convertDec(String s,int Base)
    {
        Calculator calculator = new Calculator();
        if(Base==10)
            return s;
        boolean dot=false;
        String s1="",s2="";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='.')
                dot = true;
            else if(dot)
                s2+=s.charAt(i);
            else
                s1+=s.charAt(i);

        }
        String sum="0";
        for(int i=s1.length()-1,j=0;i>=0;i--,j++)
        {
            String temp=""+s1.charAt(i);
            long x=0;
            String pp = "1";
            for(int ji=0;ji<j;ji++)
            {
                pp = calculator.multi(pp, Base);
            }
            pp = calculator.multi(pp,Integer.parseInt(temp,Base));
            sum = sum(sum,pp,false);

        }
        String sum2="0";
        for (int i = 0; i < s2.length(); i++) {
            String temp=""+s2.charAt(i);
            int x=(int) (Integer.parseInt(temp,Base));
            Double d = x/pow(Base,i+1);
            String ss=String.format("%.100f", d);
            ss = ss.substring(2);
            sum2 = sum(sum2,ss,true);
        }
        while(sum2.length()>0 && sum2.charAt(sum2.length()-1)=='0')
            sum2 = sum2.substring(0,(int)sum2.length()-1);
        if(sum2.length()>0)
            sum=sum + "." + sum2;
        return sum;
    }
    public String sum(String s1,String s2,Boolean dot)
    {
        String sum="";
        if(dot)
        {
            if(s1.length()>s2.length())
            {
                while(s1.length()>s2.length())
                    s2+="0";
            }
            if(s1.length()<s2.length())
            {
                while(s1.length()<s2.length())
                    s1+="0";
            }
            int carry=0;
            //	System.out.println(s1 + "  " +s2);
            for(int i=s2.length()-1;i>=0;i--)
            {
                int z=(s1.charAt(i)-'0')+(s2.charAt(i)-'0')+carry;
                sum=(z%10)+sum;
                carry=z/10;
            }
            if(carry!=0)
                sum=carry+sum;
        }
        else
        {
            if(s1.length()>s2.length())
            {
                while(s1.length()>s2.length())
                    s2="0"+s2;
            }
            if(s1.length()<s2.length())
            {
                while(s1.length()<s2.length())
                    s1="0"+s1;
            }
            int carry=0;
            //	System.out.println(s1 + "  " +s2);
            for(int i=s2.length()-1;i>=0;i--)
            {
                int z=(s1.charAt(i)-'0')+(s2.charAt(i)-'0')+carry;
                sum=(z%10)+sum;
                carry=z/10;
            }
            if(carry!=0)
                sum=carry+sum;
        }

        return sum;
    }

    public String converttobase(String s,int base) {
        Calculator calculator = new Calculator();
        if(base == 10)
            return s;
        if(s.charAt(0)=='-')
        {
            s = s.substring(1);
            int l = converttobase(s,base).length();
            l/=8;
            l*=8;
            l+=8;
            String ss = "";
            for(int i=0;i<l;i++)
            {
                if(base==2)
                    ss+="1";
                else if(base==8)
                    ss+="7";
                else if(base==16)
                    ss+="F";
            }
            String temp2 = convertDec(ss,base);
            s = calculator.sub(temp2,s);
            s = calculator.sum(s,"1");

        }
        boolean dot=false;
        String s1="",s2="";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='.')
                dot = true;
            else if(dot)
                s2+=s.charAt(i);
            else
                s1+=s.charAt(i);

        }

        String r = "";
        while(s1.length()>0)
        {
            while(s1.length()>0)
            {
                if(s1.charAt(0)=='0')
                    s1 = s1.substring(1);
                else
                    break;
            }
            temp="";
            r+=carry(s1,base);
            s1=temp;
        }
        r = new StringBuffer(r).reverse().toString();

        if(s2.length()>0)
        {
            r+=".";
            int loop = 100;
            while( loop >0)
            {
                temp="";
                String zz = multicarry(s2,base);
                if(loop<85 && zz.compareTo("0")==0)
                    break;
                r+=zz;
                s2=temp;
                loop--;
            }
            while (r.length() > 0) {
                if (r.charAt(r.length()-1) == '0')
                    r = r.substring(0,r.length()-1);
                else
                    break;
            }
        }

        while (r.length() > 0) {
                if (r.charAt(0) == '0')
                    r = r.substring(1);
                else
                    break;
        }


        return r;
    }

    public String multicarry(String s,int base)
    {
        int carry=0;
        temp="";
        s = new StringBuffer(s).reverse().toString();
        for(int i=0;i<s.length();i++)
        {
            int z = (s.charAt(i)-'0')*base + carry;
            temp= z%10 + temp;
            carry = z/10;
        }
        return Integer.toString(carry,base).toUpperCase();
    }

    public String carry(String s,int base)
    {
        int carry =0;
        for(int i=0;i<s.length();i++)
        {
            int z = (s.charAt(i)-'0') + carry*10;
            temp+=(""+z/base);
            carry = z %base;
        }
        return Integer.toString(carry,base).toUpperCase();

    }
}
