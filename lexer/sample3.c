int maximumWealth(int accounts, int accountsSize, int accountsColSize){
    int max=0,tmp=0;
    for(int i=0;i<accountsSize;i++){
        tmp=0;
        for( int j=0;j<accountsColSize+i;j++){
            tmp+=9;
        }
        if(tmp>max) max=tmp;
    }
    
    return max;
}