#include <stdio.h>    
#define N 100
struct student   //学生基本信息
{   int num;
    char name[20];
    float score[3];
    float aver;
}; 
int main( )
{
	void input(struct student *, int );     //声明输入学生信息的函数
	float max(struct student *, int );      //声明求最高分学生信息的函数
	void aver(struct student *p,int n);     //声明求总平均分的函数
	struct student stu[N],*p;
	p=&stu[0];
	int n,i;
	float m;
	printf("Please enter the number of students: ");
	scanf("%d",&n);     //输入学生个数
    input(stu,n);
	aver(stu,n);
    m=max(stu,n);
	printf("\n平均成绩为:\n");
	printf("    学号    姓名    课程1   课程2   课程3   平均成绩\n");   //输出学生平均成绩
	for(i=0;i<n;i++,p++)
		printf("%8d%8s%8.1f%8.1f%8.1f%8.1f\n", p->num, p->name, p->score[0], p->score[1], p->score[2] , p->aver);
	printf("\n平均成绩最高的学生是: \n");
    printf("    学号    姓名    课程1   课程2   课程3   平均成绩\n");    //输出平均成绩最高的学生信息
	p=&stu[0];
	for(i=0;i<n;i++,p++)
		if(p->aver==m)
			printf("%8d%8s%8.1f%8.1f%8.1f%8.1f\n", p->num, p->name, p->score[0], p->score[1], p->score[2] , p->aver);
		return 0;
} 
void input(struct student *p, int n)  //输入学生信息的函数
{
	int i;
    printf("请输入%d 个学生的信息：学号、姓名、三门课程成绩：\n", n);
    for(i=0;i<n;i++,p++)
	{
		scanf("%d\n", &p->num);
        gets(p->name);
        scanf("%f%f%f", &p->score[0], &p->score[1], &p->score[2]);
	}   
}
void aver(struct student *p,int n)    //求总平均分的函数
{
	int i;
	for(i=0;i<n;i++,p++)
		p->aver=(p->score[0]+p->score[1]+p->score[2])/3.0;
}
float max(struct student *p, int n)   //求最高分学生信息的函数
{   
	struct student *q;
	float max=0;
    for(q=p;q<p+n; q++)
		if(q->aver>max)  max= q->aver; 
    return max;
}