#include <stdio.h>    
#define N 100
struct student   //ѧ��������Ϣ
{   int num;
    char name[20];
    float score[3];
    float aver;
}; 
int main( )
{
	void input(struct student *, int );     //��������ѧ����Ϣ�ĺ���
	float max(struct student *, int );      //��������߷�ѧ����Ϣ�ĺ���
	void aver(struct student *p,int n);     //��������ƽ���ֵĺ���
	struct student stu[N],*p;
	p=&stu[0];
	int n,i;
	float m;
	printf("Please enter the number of students: ");
	scanf("%d",&n);     //����ѧ������
    input(stu,n);
	aver(stu,n);
    m=max(stu,n);
	printf("\nƽ���ɼ�Ϊ:\n");
	printf("    ѧ��    ����    �γ�1   �γ�2   �γ�3   ƽ���ɼ�\n");   //���ѧ��ƽ���ɼ�
	for(i=0;i<n;i++,p++)
		printf("%8d%8s%8.1f%8.1f%8.1f%8.1f\n", p->num, p->name, p->score[0], p->score[1], p->score[2] , p->aver);
	printf("\nƽ���ɼ���ߵ�ѧ����: \n");
    printf("    ѧ��    ����    �γ�1   �γ�2   �γ�3   ƽ���ɼ�\n");    //���ƽ���ɼ���ߵ�ѧ����Ϣ
	p=&stu[0];
	for(i=0;i<n;i++,p++)
		if(p->aver==m)
			printf("%8d%8s%8.1f%8.1f%8.1f%8.1f\n", p->num, p->name, p->score[0], p->score[1], p->score[2] , p->aver);
		return 0;
} 
void input(struct student *p, int n)  //����ѧ����Ϣ�ĺ���
{
	int i;
    printf("������%d ��ѧ������Ϣ��ѧ�š����������ſγ̳ɼ���\n", n);
    for(i=0;i<n;i++,p++)
	{
		scanf("%d\n", &p->num);
        gets(p->name);
        scanf("%f%f%f", &p->score[0], &p->score[1], &p->score[2]);
	}   
}
void aver(struct student *p,int n)    //����ƽ���ֵĺ���
{
	int i;
	for(i=0;i<n;i++,p++)
		p->aver=(p->score[0]+p->score[1]+p->score[2])/3.0;
}
float max(struct student *p, int n)   //����߷�ѧ����Ϣ�ĺ���
{   
	struct student *q;
	float max=0;
    for(q=p;q<p+n; q++)
		if(q->aver>max)  max= q->aver; 
    return max;
}