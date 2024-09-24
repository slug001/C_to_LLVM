void main(){
    //算術運算
	int i1; int i2; int i3;
	float f1; float f2; float f3;
	char c1='u'; char s1[3]="uuu";


	//assign = += -= *= /= test
	i1+=i2+i3;
	i1+=i2+f3; //error
	i1-=i5;
	i5*=i1;
	i1=f3; //error
	i1-=f3; //error
	i1*=f3; //error
	i1/=f3; //error

    int int_1; float fj=0.9;
    char yy[5]="jdhg";	//正常
    char test= 'p'; //正常
    	//printf
	printf("%s%f",int_1,int_1);
	printf("%s%f",fj,fj);
	printf("%s%f",test,test);
	printf("%s%f",yy,yy);

	printf("%d",int_1);
	printf("%d",fj);
	printf("%d",test);
	printf("%d",yy);

	//scanf
	scanf("%s%f",&int_1,&int_1);
	scanf("%s%f",&fj,&fj);
	scanf("%s%f",&test,&test);
	scanf("%s%f",&yy,&yy);

	scanf("%d",int_1);
	scanf("%d",fj);
	scanf("%d",test);
	scanf("%d",yy);
}