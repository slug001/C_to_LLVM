#include <stdio.h>
int a=19;
float b=1.45628;

int test(int k){
    int k=k+1;
    return k;
}


int main(){
    //Keywords
    int kk=9;
    char c='c';
    float f=0.5673;
    double k =9.35747265;
    short op=36;
    unsigned int un_int = 987;
    const int o=98;
    typedef(un_int);
    kk = test(kk);
    printf("%d\n", kk);
    //flow control
    if (kk){
        scanf("%d",&kk);
    }else if(f){
        op=9;
    }else{
        return 0;
    }
    while(k==1) continue;
    switch(kk){
        case(1): break;
    }
    for(int i=0;i<10;i++){
        break;
    }

    //relational operator
    kk==kk<=kk>=kk!=kk>kk<kk;
    //unary operator
    kk++;kk--;
    //Bitwise operator
    kk>>1; kk<<1; kk&kk; kk|kk; ~kk;
    //arithmetic operator
    kk=1;kk+=1;kk-=1;kk*=1;kk/=1;
    //logical operator
    kk&&kk||!kk;
    /*------Punctuation------*/
    int array[5] = {1, 2, 3, 4, 5};

    /* Comments */
    //test
    /*comment*/

    return 0;
}

