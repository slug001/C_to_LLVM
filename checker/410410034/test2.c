#include <string.h>
void main()
{
	int a;
	int u;
	int index;
	float fj=9.6;
	float fhh=9.0;
	k=0;
	num=index+3.21;
	a+=1;
	a=a+(5+fj);
	/*char*/
	char test= 'p'; //正常
	char tt="dfni"; //定義錯誤
	char tt='l';	
	char tt='j';	//重複定義
	/*string*/
	char yy[5]="jdhg";	//正常
	char yy[7.8]="wsh";	//重複定義+型態錯誤
	char ehg[3]=152;	//型態錯誤
	char hw[7]= 'p';	//型態錯誤

	a=a+tt;
	/*compare*/
	if(a>12){
	}else if(a<8.6){
	}else if(a<index){
	}else if(a<fj){
	}
	/*check flow*/
	if(fj)
	if('j')
	if("sbh")
	if(a){
	}else if(fj){
	}else if('j'){
	}else if("bjss"){
	}else if(a){
	}

	while(a>12){}
	while(a<8.4){}
	while(a<index){}
	while("string"){}
	while('p'){}
	while(a+1){}

	int int_1;
	int a=6;
	for(int a=6;int_1>10;int_1++){} //init
	for(a=6;int_1>fj;int_1++){} 	//condition
	for(a=6;int_1+9;int_1++){} 		//condition
	for(a=6;"dgjyf";int_1++){}		//condition
	for(a=6;int_1>10;int_1+0.6){}	//increase
	for(a=6;int_1>10;fj++){}		//increase
	for(a=6;int_1>10;int_1++){}		//correct
	for(char c5[4]="nbc";int_1<70;c5++){}
}
