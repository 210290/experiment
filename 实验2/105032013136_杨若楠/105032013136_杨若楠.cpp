#include<stdio.h>
#include<math.h>
int main()
{
	int a,b,c,m,n,k,h=0;
	printf("105032013136  杨若楠\n");
	printf( "请输入a和b:\n" );
	scanf("%d%d",&a,&b);
	c=b-a;
	if(a<b && b<=1000000000000 && c<=1000000)
	{
		for(m=a;m<b;m++)
		{
			if(m/2==1) h++;
			else if(m%2==0) continue;
			else
			{ 
				k = 0;
			    for(n=2;n<=sqrt(m);n++)
				{
			 	   if(m%n==0) k++;
				   if(k!=0) break; 
				}
			if(k==0) h++;
			}
		}
		printf("请输出在a和b之间的素数个数：%d\n",h);
	}
	return 0;
}