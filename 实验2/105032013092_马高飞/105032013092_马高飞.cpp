#include <stdio.h>
int main()
{
	int a[15],i,j,k,m,temp,p=0,q=14;
	for(i=0;i<15;i++)
		scanf("%d",&a[i]);
	printf("\n");
    for(i=0;i<15;i++)
    {  k=i;
        for(j=i+1;j<15;j++)
            if(a[j]>a[k])  k=j;
        if(i!=k)
        {  temp=a[i]; a[i]=a[k]; a[k]=temp;}
    }
	for(i=0;i<15;i++)
		printf("%5d",a[i]);
	printf("\n");
    scanf("%d",&m);
	for(i=1,j=15;i<5;i++)
	{
		if(m<a[(p+q)/2])
			p=(p+q)/2;
		if(m>a[(p+q)/2])
			q=(p+q)/2;
		if(m==a[(p+q)/2])
		{
			j=(p+q)/2+1;
			break;
		}
	}
	if(j!=15)
		printf("%d\n",j);
	else printf("ÎÞ´ËÊý\n");
	return 0;
}
