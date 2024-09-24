void main(){
    //算術運算
	int i1; int i2; int i3;
	float f1; float f2; float f3;
	char c1='u'; char s1[3]="uuu";
	// +-
	i1=i1+i2;
	i1=i1+f1;
	i1=f1+f2;
	i1=1+2;
	i1=1+2.3;
	i1=1.2+3.4;

	//*/
	i1=i1/i2;
	i1=i1/f1;
	i1=f1/f2;
	i1=1*2;
	i1=1*2.3;
	i1=1.2*3.4;

	// add -
	i1=-i1;
	i1=-3;
    i1=-s1;

	// '++' '--'
	i1=i1++;
	i1=i1--;
	f2=f1++;
	i2=f1--;

	//primary
	i1=c1+s1;
	i1=i2+i3;
}
