#include <stdio.h>
void main(int* nums, int numsSize, int k){
    k%=numsSize;
    int new_num[numsSize];
    for(int i=0;i<k;i++){
        new_num[i]=(int)*(nums+numsSize-k+i);
    }
    for(int i=numsSize-1;i>=k;i--){
        nums[i]=(int)*(nums+i-k);
    }
    for(int i=0;i<k;i++) nums[i]=new_num[i];
}