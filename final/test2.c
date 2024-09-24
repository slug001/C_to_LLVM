void main()
{
   int a;
   int b;
   a=6;
   b=3;

   //if elseif else
   if(a>b){
      printf("a>b\n");
   }else if(a==b){
      printf("a==b\n");
   }else if(a<b){
      printf("a<b\n");
   }else{
      printf("bad\n");
   }
   //if
   if(a>b){
      printf("equal\n");
   }
   //Nested if construct
   if(a>b){
      if(a>b){
         if(a>b){
            printf("hehe\n");
         }
      }
   }
}
