package tk.stsoftwaresolution.basecalculator;


import static java.lang.Math.pow;

public class Calculator {
    public String sum(String s,String t)
    {
        if(s.length()<=18 && t.length()<=18)
        {
            Double d = (Double.parseDouble(s)+Double.parseDouble(t));
            String ss =(String.format("%.20f", d));
            while(ss.length()>1)
            {
                if(ss.charAt(ss.length()-1)=='0')
                {
                    ss = ss.substring(0, ss.length()-1);
                }
                else break;
            }
            if(ss.charAt(ss.length()-1)=='.')
            {
                ss = ss.substring(0, ss.length()-1);
            }
            return ss;
        }
        String sign="";
        if(s.charAt(0)=='-' && t.charAt(0)=='-')
        {
            s=s.substring(1);
            t=t.substring(1);
            sign ="-";
        }
        else if(s.charAt(0)=='-' )
        {
            s=s.substring(1);
            return sub(t,s);
        }
        else if(t.charAt(0)=='-' )
        {
            t=t.substring(1);
            return sub(s,t);
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
        dot=false;
        String t1="",t2="";
        for(int i=0;i<t.length();i++)
        {
            if(t.charAt(i)=='.')
                dot = true;
            else if(dot)
                t2+=t.charAt(i);
            else
                t1+=t.charAt(i);

        }

        if(s1.length()>t1.length())
        {
            while(s1.length()>t1.length())
                t1="0"+t1;
        }
        if(s1.length()<t1.length())
        {
            while(s1.length()<t1.length())
                s1="0"+s1;
        }

        if(t2.length()>s2.length())
        {
            while(t2.length()>s2.length())
                s2+="0";
        }
        if(t2.length()<s2.length())
        {
            while(t2.length()<s2.length())
                t2+="0";
        }
        int carry =0;

        String sum1="",sum2="";

        if(t2.length()!=0)
        {
            t2 = new StringBuffer(t2).reverse().toString();
            s2 = new StringBuffer(s2).reverse().toString();
            for(int i=0;i<t2.length();i++)
            {
                int z = (t2.charAt(i)-'0')+(s2.charAt(i)-'0')+carry;
                sum2+=z%10;
                carry=z/10;
            }
            if(sum2.length()>0)
            {
                if(sum2.charAt(0)=='0')
                    sum2 = sum2.substring(1);
            }
        }
        sum2 = new StringBuffer(sum2).reverse().toString();
        t1 = new StringBuffer(t1).reverse().toString();
        s1 = new StringBuffer(s1).reverse().toString();
        for(int i=0;i<t1.length();i++)
        {
            int z = (t1.charAt(i)-'0')+(s1.charAt(i)-'0')+carry;
            sum1+=z%10;
            carry=z/10;
        }
        if(carry!=0)
            sum1+=carry;
        sum1 = new StringBuffer(sum1).reverse().toString();
        if(sum1.length()>1)
        {
            if(sum1.charAt(0)=='0')
                sum1 = sum1.substring(1);
        }
        if(sum1=="")
            sum1="0";
        if(sum2.length()!=0)
            sum1+=("."+sum2);
        return sign + sum1;
    }

    public String sub(String s,String t)
    {
        if(s.length()<=18 && t.length()<=18)
        {
            Double d = (Double.parseDouble(s)-Double.parseDouble(t));
            String ss =(String.format("%.20f", d));
            while(ss.length()>1)
            {
                if(ss.charAt(ss.length()-1)=='0')
                {
                    ss = ss.substring(0, ss.length()-1);
                }
                else break;
            }
            if(ss.charAt(ss.length()-1)=='.')
            {
                ss = ss.substring(0, ss.length()-1);
            }
            return ss;
        }
        if(s==t)
            return "0";
        String sign="";
        if(s.charAt(0)=='-' && t.charAt(0)=='-')
        {
            s=s.substring(1);
            t=t.substring(1);
            sign ="-";
        }
        else if(s.charAt(0)=='-' )
        {
            t="-" +t ;
            return sum(s,t);
        }
        else if(t.charAt(0)=='-' )
        {
            t=t.substring(1);
            return sum(s,t);
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
        dot=false;
        String t1="",t2="";
        for(int i=0;i<t.length();i++)
        {
            if(t.charAt(i)=='.')
                dot = true;
            else if(dot)
                t2+=t.charAt(i);
            else
                t1+=t.charAt(i);

        }
        String temp;
        if(t1.length()>s1.length())
        {
            temp = t1;
            t1=s1;
            s1=temp;
            temp = t2;
            t2=s2;
            s2=temp;
            if(sign=="")
                sign = "-";
            else
                sign = "";
        }
        else if(t1.length()==s1.length() )
        {
            if(t1.compareTo(s1)>0)
            {
                temp = t1;
                t1=s1;
                s1=temp;
                temp = t2;
                t2=s2;
                s2=temp;
                if(sign=="")
                    sign = "-";
                else
                    sign = "";
            }
            else if(t1.compareTo(s1)==0)
            {
                if(t2.compareTo(s2)>0)
                {
                    temp = t1;
                    t1=s1;
                    s1=temp;
                    temp = t2;
                    t2=s2;
                    s2=temp;
                    if(sign=="")
                        sign = "-";
                    else
                        sign = "";
                }
            }
        }

        if(s1.length()>t1.length())
        {
            while(s1.length()>t1.length())
                t1="0"+t1;
        }
        if(s1.length()<t1.length())
        {
            while(s1.length()<t1.length())
                s1="0"+s1;
        }

        if(t2.length()>s2.length())
        {
            while(t2.length()>s2.length())
                s2+="0";
        }
        if(t2.length()<s2.length())
        {
            while(t2.length()<s2.length())
                t2+="0";
        }


        int carry =0;

        String sub1="",sub2="";

        if(t2.length()!=0)
        {
            t2 = new StringBuffer(t2).reverse().toString();
            s2 = new StringBuffer(s2).reverse().toString();
            for(int i=0;i<t2.length();i++)
            {
                int z1=s2.charAt(i)-'0';
                int z2=t2.charAt(i)-'0';
                z2+=carry;
                carry=0;
                if(z1<z2)
                {
                    z1+=10;
                    carry =1;
                }
                sub2+=(z1-z2);
            }
            if(sub2.length()>0)
            {
                if(sub2.charAt(0)=='0')
                    sub2 = sub2.substring(1);
            }
        }

        sub2 = new StringBuffer(sub2).reverse().toString();
        t1 = new StringBuffer(t1).reverse().toString();
        s1 = new StringBuffer(s1).reverse().toString();
        for(int i=0;i<t1.length();i++)
        {
            int z1=s1.charAt(i)-'0';
            int z2=t1.charAt(i)-'0';
            z2+=carry;
            carry=0;
            if(z1<z2)
            {
                z1+=10;
                carry =1;
            }
            sub1+=(z1-z2);
        }

        sub1 = new StringBuffer(sub1).reverse().toString();
        if(sub1.length()>1)
        {
            if(sub1.charAt(0)=='0')
                sub1 = sub1.substring(1);
        }
        if(sub1=="")
            sub1="0";
        if(sub2.length()>0)
            sub1+=("."+sub2);
        return sign+sub1;
    }

    public String mul(String s,String t)
    {
        String sign="";
        if(s.charAt(0)=='-' && t.charAt(0)=='-')
        {
            s=s.substring(1);
            t=t.substring(1);
        }
        else if(s.charAt(0)=='-' )
        {
            s=s.substring(1);
            sign="-";
        }
        else if(t.charAt(0)=='-' )
        {
            t=t.substring(1);
            sign="-";
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
        dot=false;
        String t1="",t2="";
        for(int i=0;i<t.length();i++)
        {
            if(t.charAt(i)=='.')
                dot = true;
            else if(dot)
                t2+=t.charAt(i);
            else
                t1+=t.charAt(i);

        }
        if(s1.length()<=9 && t1.length()<=9)
        {
            Double d = (Double.parseDouble(s)*Double.parseDouble(t));
            String ss =(String.format("%.50f", d));
            while(ss.length()>1)
            {
                if(ss.charAt(ss.length()-1)=='0')
                {
                    ss = ss.substring(0, ss.length()-1);
                }
                else break;
            }
            if(ss.charAt(ss.length()-1)=='.')
            {
                ss = ss.substring(0, ss.length()-1);
            }
            return ss;
        }

        if(s1.length()>t1.length())
        {
            while(s1.length()>t1.length())
                t1="0"+t1;
        }
        if(s1.length()<t1.length())
        {
            while(s1.length()<t1.length())
                s1="0"+s1;
        }

        if(t2.length()>s2.length())
        {
            while(t2.length()>s2.length())
                s2+="0";
        }
        if(t2.length()<s2.length())
        {
            while(t2.length()<s2.length())
                t2+="0";
        }

        int ddd = t2.length()+s2.length();

        s=s1+s2;
        t=t1+t2;

        //t = new StringBuffer(t).reverse().toString();

        String mm = "";
        {
            for(int i=0;i<s.length();i++)
            {
                String temp = multi(s,t.charAt(i)-'0');
                mm += "0";
                mm = sum(mm,temp);
            }
        }

        int x = mm.length();
        x-=ddd;
        boolean dt = false;
        if(ddd!=0)
        {
            mm = mm.substring(0, x) + "."+ mm.substring(x);
            dt=true;
        }

        int l = mm.length();
        if(dot) {
            while (mm.charAt(l - 1) == '0') {
                mm = mm.substring(0, l - 1);
                l--;
            }
        }
        if(mm.charAt(l-1)=='.')
            mm= mm.substring(0,l-1);

        return sign + mm;
    }

    public String multi(String s,int n)
    {
        int carry=0;
        String temp="";
        s = new StringBuffer(s).reverse().toString();
        for(int i=0;i<s.length();i++)
        {
            int z = (s.charAt(i)-'0')*n + carry;
            temp= z%10 + temp;
            carry = z/10;
        }
        if(carry!=0)
            temp=carry+temp;

        return temp;
    }

    public String div(String s,String t)
    {
        try{
            if(Double.parseDouble(t)==0.0)
                return "Math Error";

        }
        catch (Exception e)
        {

        }
        if(s.length()<=18 && t.length()<=18)
        {
            Double d = (Double.parseDouble(s)/Double.parseDouble(t));
            String ss =(String.format("%.20f", d));
            while(ss.length()>1)
            {
                if(ss.charAt(ss.length()-1)=='0')
                {
                    ss = ss.substring(0, ss.length()-1);
                }
                else break;
            }
            if(ss.charAt(ss.length()-1)=='.')
            {
                ss = ss.substring(0, ss.length()-1);
            }
            return ss;
        }

        String sign="";
        if(s.charAt(0)=='-' && t.charAt(0)=='-')
        {
            s=s.substring(1);
            t=t.substring(1);
        }
        else if(s.charAt(0)=='-' )
        {
            s=s.substring(1);
            sign="-";
        }
        else if(t.charAt(0)=='-' )
        {
            t=t.substring(1);
            sign="-";
        }

        long z=0;
        long range = (long) pow(10,10);
        String temp=sub(s,t);
        while(temp.charAt(0)!='-')
        {
            s=temp;
            z++;
            temp=sub(s,t);
            if(z>range)
                return "Math Error";
        }
        int x=10;
        String dd = z+".";
        while(x>0)
        {
            z=0;
            s = mul(s,"10");
            temp=sub(s,t);
            while(temp.charAt(0)!='-')
            {
                s=temp;
                z++;
                temp=sub(s,t);
            }
            dd+=z;
            x--;
            if(dd.length()>100);
            break;
        }
        while(dd.charAt(dd.length()-1)=='0')
        {
            dd = dd.substring(0,dd.length()-1);
        }
        if(dd.charAt(dd.length()-1)=='.')
            dd = dd.substring(0,dd.length()-1);

        return dd;
    }
}
