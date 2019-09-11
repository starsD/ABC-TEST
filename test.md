- 最长公共子序列
  - O(NlogN)算法
        static int MaxSubSum(const int A[], int left, int right)
        {
        	int MaxLeftSum,MaxRightSum;
        	int MaxLeftBorderSum,MaxRightBorderSum;
        	int LeftBorderSum,RightBorderSum;
        	int Center, i;
        
        	if(Left==Right)
        		if(A[left]>0)
        			return A[left]
        		else
        			return 0;
        
        	Center = (Left + Right)/2;
        	MaxLeftSum = MaxSubSum(A, Left, Center);	//计算左侧最大值
        	MaxRightSUm = MaxSubSum(A, Center+1,Right);	//计算右侧最大值
        
        	MaxLeftBorderSum = 0;LeftBorderSum = 0;		//计算中间边界最大值
        	for(i=Center+1;i>=Left;i-)
        	{
        		LeftBorderSum +=A[i];
        		if (LeftBorderSum>MaxLeftBorderSum)
        		{
        			MaxLeftBorderSum = LeftBorderSum;
        		}
        	}
        
        	MaxRightBorderSum = 0;RightBorderSum = 0;
        	for(i=Center+1;i>=Right;i-)
        	{
        		RightBorderSum +=A[i];
        		if (RightBorderSum>MaxRightBorderSum)
        		{
        			MaxRightBorderSum = RightBorderSum;
        		}
        	} 
        
        	return Max3(MaxLeftSum,MaxRightSUm,MaxLeftBorderSum+MaxRightBorderSum);
        }
    ---
  - O(N) 算法
        int MaxSubsequenceSum(const int A[], int N)
        {
        	int	ThisSum,MaxSum,j;
        	ThisSum = MaxSum = 0;
        	for (int  j= 0; j < N; ++j)
        	{
        		ThisSum += A[j];
        
        		if (ThisSum>MaxSum)
        		{
        			MaxSum = ThisSum;
        		}
        		else if (ThisSum<0)
        		{
        			ThisSum = 0;
        		}
        	}
        }
    

- 最大公因数
  - 欧几里得算法(O(logN))
        unsigned int
        Gcd(unsigned int M,unsigned int N)
        {
        	unsigned int Rem;
        
        	while(N>0)
        	{
        		Rem = M % N;
        		M = N;
        		N = Rem;
        	}
        
        	return M;
        }
    
- 取幂操作
  - O(logN)
        long int Pow(long int X, unsigned int N)
        {
        	if(N==0)
        		return 1;
        	if(N==1)
        		return X;
        	if(IsEven(N))
        		return Pow(X*X, N/2);
        	else
        		return Pow(X*X, N/2)* X;
        }
- 桶排序->多趟桶排序
- 插入排序
      void InsertionSort(ElementType A[],int N)
      {
        int j,P;
        Element Type tmp;
        for(p=1;p<N;p++)
        {
          tmp = A[p];
          for(j=P;j>0&&a[j-1]>tmp;j--)
            A[j]=A[j-1];
          A[j]=tmp;
        }
      }
- 希尔排序
      void ShellSort(ElementType A[],int N)
      {
        int i,j,Increment;
        ElementType Tmp;
        
        for(Increment=N/2;Increment>0;Increment/=2)
        	for(i=Increment;i<N;i++)
          {
            Tmp=A[i];
            for(j=i;j>Increment;j-=Increment)
              if(Tmp<A[j-Increment])
                A[j]=A[j-Increment];
            	else
                break;
            A[j]=Tmp;
          }
      }
  
- 快速排序
      #define Cufoff 3
      
      void Qsort(ElementType A[], int Left, int Right)
      {
      	int i,j;
      	ElementType Pivot;
      
      	if(Left + Cufoff<=Right)
      	{
      		Pivot = Median3(A,Left,Right);
      		for(;;)
      		{
      			while(A[++i]<Pivot){}
      			while(A[--j]>Pivot){}
      			if (i<j)
      			{
      				Swap(&A[i]，&A[j]);
      			}
      			else
      				break;
      
      		}
      		Swap(&A[i],&A[j]);
      
      		Qsort(A,Left,i-1);
      		Qsort(A,i+1,Right);
      		else
      			InsertionSort(A+Left,Right-Left-1);
      	}
      }
  
- KMP算法
  移动位数 = 已匹配的字符数 - 对应的部分匹配值

  设主串（下文中我们称作T）为：a b a c a a b a c a b a c a b a a b b

  模式串（下文中我们称作W）为：a b a c a b

  用暴力算法匹配字符串过程中，我们会把T[0] 跟 W[0] 匹配，如果相同则匹配下一个字符，直到出现不相同的情况，此时我们会丢弃前面的匹配信息，然后把T[1] 跟 W[0]匹配，循环进行，直到主串结束，或者出现匹配成功的情况。这种丢弃前面的匹配信息的方法，极大地降低了匹配效率。

  而在KMP算法中，对于每一个模式串我们会事先计算出模式串的内部匹配信息，在匹配失败时最大的移动模式串，以减少匹配次数。

  比如，在简单的一次匹配失败后，我们会想将模式串尽量的右移和主串进行匹配。右移的距离在KMP算法中是如此计算的：在已经匹配的模式串子串中，找出最长的相同的前缀和后缀，然后移动使它们重叠。

  在第一次匹配过程中

  T: a b a c a a b a c a b a c a b a a b b

  W: a b a c a b

  在T[5]与W[5]出现了不匹配，而T[0]~T[4]是匹配的，现在T[0]~T[4]就是上文中说的已经匹配的模式串子串，现在移动找出最长的相同的前缀和后缀并使他们重叠：

  T: a b a c aa b a c a b a c a b a a b b

  W: a b a c a b

  然后在从上次匹配失败的地方进行匹配，这样就减少了匹配次数，增加了效率。

  然而，如果每次都要计算最长的相同的前缀反而会浪费时间，所以对于模式串来说，我们会提前计算出每个匹配失败的位置应该移动的距离，花费的时间就成了常数时间。





- 多路合并
  - 败者树
    	叶子节点记录k个段中的最小数据，然后两两进行比赛。败者树是在双亲节点中记录下刚刚进行完的这场比赛的败者，让胜者去参加更高一层的比赛。决赛，根节点记录输者，所以需要重建一个新的根节点，记录胜者.
      #include <iostream>  
      using namespace std;  
        
      #define LEN 10          //最大归并段长  
      #define MINKEY -1     //默认全为正数  
      #define MAXKEY 100    //最大值,当一个段全部输出后的赋值  
        
      struct Array  
      {  
          int arr[LEN];  
          int num;  
          int pos;  
      }*A;  
        
      int k,count;  
      int *LoserTree,*External;  
        
      void Adjust(int s)  
      {  
          int t=(s+k)/2;//ls[t]是b[s]的双亲结点的下标  
          int temp;  
          while(t>0)  
          {  
              if(External[s] > External[LoserTree[t]])  
              {  
                  temp = s;  
                  s = LoserTree[t];  
                  LoserTree[t]=temp;  
              }  
              t=t/2;  
          }  
          LoserTree[0]=s;  
      }  
        
      void CreateLoserTree()  
      {  
          External[k]=MINKEY;  
          int i;  
          for(i=0;i<k;i++)LoserTree[i]=k;//设置ls中败者的初值，简化了败者树的建立过程，这样就可以直接通过(调整过程)来建立败者树。  
          for(i=k-1;i>=0;i--)Adjust(i);  
      }  
        
      void K_Merge()  
      {  
          int i,p;  
          //初始化External数组，用以接下来创建LoserTree  
          for(i=0;i<k;i++)  
          {  
              p = A[i].pos;  
              External[i]=A[i].arr[p];  
              //cout<<External[i]<<",";  
              A[i].pos++;  
          }  
          //创建LoserTree  
          CreateLoserTree();  
          int NO = 0;  
          //输出最小值，并替代调整  
          while(NO<count)  
          {  
              p=LoserTree[0];  
              cout<<External[p]<<",";  
              NO++;  
              if(A[p].pos>=A[p].num)External[p]=MAXKEY;  
              else   
              {  
                  External[p]=A[p].arr[A[p].pos];  
                  A[p].pos++;  
              }  
              Adjust(p);  
          }  
          cout<<endl;  
      }  
  


