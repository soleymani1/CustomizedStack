import java.util.Scanner;
public class StackProject {
	static Scanner input = new Scanner (System.in);
	public static void main(String[] args) {
		int m,n,x,op,i,j=0;
		boolean isFull=false,flag;
		System.out.println("Please enter the number of data: "); 
		m=input.nextInt();
		System.out.println("How many part do you want? "); 
		n=input.nextInt();
		while (m%n!=0){
			System.out.println("Wrong Input! Please enter the number of data again: "); 
			m=input.nextInt();
			System.out.println("How many part do you want? "); 
			n=input.nextInt();
		}
		int M []=new int [m];
		int t []=new int [n];
		int b []=new int [n+1];
		
		for(i=0;i<n;i++){
			t[i]=i*(m/n)-1;
		}
		for(i=0;i<=n;i++){
			b[i]=i*(m/n)-1;
		}
		while (true){
			System.out.println("Add (1) or Delete (2) or Print (3)? "); 
			op=input.nextInt();//add (1) or delete (2) or print (3)?
			if (op==1){
				System.out.println("Which stack do you want to add to? ");
				i=input.nextInt();//0 to n-1
				while(i<0||i>=n){
					System.out.println("Wrong Input! Which stack do you want to add to? ");
					i=input.nextInt();//0 to n-1
				}
				System.out.println("Please enter the data that you want to add: ");
				x=input.nextInt();
				if (t[i]==b[i+1]) {
					flag=true;
					for(int k=i+1;k<n&&flag;k++){
						if(t[k]!=b[k+1]) {
							j=k;
							flag=false;
						}
					}//find j in right
					for(int k=i-1;k>=0&&flag;k--){
						if(t[k]!=b[k+1]) {
							j=k;
							flag=false;
						}
					}//find j in left 
					while (flag){
						System.out.println("Can't add to full stack!"); //stack is full
						flag=false;
						isFull=true;
					}
					System.out.println(j+" i" + i);
					if(isFull==false && j>i){
						for(int k=i+1;k<=j;k++){
							b[k]=b[k]+1;
							for(int p=t[k];p>=b[k];p--){
								M[p+1]=M[p];
							}
							t[k]=t[k]+1;
						}
						M[++t[i]]=x;
					}//shift j>i
					if(isFull==false && j<i){
						for(int k=j+1;k<=i;k++){
							
							for(int p=b[k];p<b[k+1];p++){
								M[p]=M[p+1];
							}
							b[k]=b[k]-1;
							t[k]=t[k]-1;
						}
						M[++t[i]]=x;
					}//shift j<i
				}//stack is full
				else M[++t[i]]=x;
			}//ADD
			else if (op==2){
				System.out.println("Which stack do you want to delete from? ");
				i=input.nextInt();//0 to n-1
				if (t[i]==b[i]) 
					System.out.println("Can't delete from empty stack!"); //stack is empty
				else {
					x=M[t[i]];
					M[t[i]]=0;
					t[i]--;
					System.out.println(x);
				}
			}//DEL
			else if(op==3){
				int p=0;
				for(int k=0;k<m;k++){
					if(k==b[p]+1){
						System.out.print("|");
						p++;
					}
					if(M[k]!=0) System.out.print(M[k]+" ");
					else System.out.print("* ");
				}
				System.out.println("|");
			}//print
			else System.out.print("Wrong Input!");
		}
	}//main
}//class