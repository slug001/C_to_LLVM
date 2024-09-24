int main()
{

   int a;
   int b;
   float f;
   float g;

   f=1.2;
   a = 0;
   b = 3;
   //while-loop construc
   while(a<b)
      a=a+1;
   printf("a=%d\n",a);
   b=10;
   //while-loop construc
   while(a<b){
      a=a+1;
   }
   printf("a=%d\n",a);

   //Loop construct + if construct
   for(a=1;a<5;a=a+1){
      if(a>2)
         printf("a=%d\n",a);
   }
   //printf 
   printf("printf test\n");
   printf("a=%d\n",a);

   // int float 四則運算
   //+
   a=a+a;
   printf("a=%d\n",a);
   a=a+1;
   printf("a=%d\n",a);
   a=1+a;
   printf("a=%d\n",a);
   a=1+1;
   printf("a=%d\n",a);
   //-
   a=a-a;
   printf("a=%d\n",a);
   a=a-1;
   printf("a=%d\n",a);
   a=1-a;
   printf("a=%d\n",a);
   a=3-1;
   printf("a=%d\n",a);
   //*
   a=a*a;
   printf("a=%d\n",a);
   a=a*2;
   printf("a=%d\n",a);
   a=2*a;
   printf("a=%d\n",a);
   a=2*1;
   printf("a=%d\n",a);
   ///
   a=a/a;
   printf("a=%d\n",a);
   a=10;
   a=a/2;
   printf("a=%d\n",a);
   a=6/a;
   printf("a=%d\n",a);
   a=4/2;
   printf("a=%d\n",a);
   // '-'
   a=-a;
   printf("a=%d\n",a);

   // Floating point data type
   f=1.2;
   g=2.4;
   //+
   f=f+f;
   printf("f=%f\n",f);
   f=f+1.2;
   printf("f=%f\n",f);
   f=1.2+f;
   printf("f=%f\n",f);
   f=1.2+1.2;
   printf("f=%f\n",f);
   
   //-
   f=f-f;
   printf("f=%f\n",f);
   f=f-1.2;
   printf("f=%f\n",f);
   f=1.2-f;
   printf("f=%f\n",f);
   f=1.3-1.2;
   printf("f=%f\n",f);
   
   //*
   f=f*f;
   printf("f=%f\n",f);
   f=f*1.2;
   printf("f=%f\n",f);
   f=1.2*f;
   printf("f=%f\n",f);
   f=1.3*1.2;
   printf("f=%f\n",f);
   
   //'/'
   f=f/f;
   printf("f=%f\n",f);
   f=f/1.2;
   printf("f=%f\n",f);
   f=1.2/f;
   printf("f=%f\n",f);
   f=1.3/1.2;
   printf("f=%f\n",f);
   // -
   f=-f;
   printf("f=%f\n",f);
   
   float count;
   count = (8.3+0.8)*6.1/2.9;
   printf("count=%f\n",count);

   printf("scanf test input int:\n");
   scanf("%d",&a);
   printf("input=%d\n",a);
   if(a>600){
      printf("a>600\n");
   }else{
      printf("a<=600\n");
   }

   

   return 0;
}
