import java.util.*;
import java.io.*;
public class gt{
	public static void main(String[] args) throws Exception{
		FileWriter fw=new FileWriter("gametheory.txt"); 
		StringBuilder fin = new StringBuilder("");
		Random rand  = new Random();
		int total[][] = new int[5][5];
		int cor[][] = new int[5][5];
		ArrayList<ArrayList<Integer>> db = new ArrayList<ArrayList<Integer>> ();
		for(int i=0;i<8;++i) db.add(new ArrayList<Integer>());
		int fll=1;
		ArrayList<ArrayList<Integer>> rb = new ArrayList<ArrayList<Integer>> ();
		for(int i=0;i<8;++i) rb.add(new ArrayList<Integer>());
		for(int times =0;times<50;++times)
		{
			System.out.println("Time Slot : " + times);
			int sender = times;
			sender = sender %5;
			int reciever = rand.nextInt(5);
			if(reciever == sender) reciever = (reciever +1)%5;
			db.get(sender).add(reciever);
			int get = db.get(sender).get(0);
			for(int ttt=1;ttt<=2;++ttt)
			{
				int friend = (ttt+sender)%5;
				int binar = rand.nextInt(5);
				total[sender][friend]++;
				if(binar != 0)
				{
					cor[sender][friend]++;
					rb.get(friend).add(get);
				}
			}
			if(fll==1)
			{
				fin.append("0.2 1 1.2 1.4 2\n");
			}
			for(int i = 0;i<5;++i)
			{
				System.out.print("Relay Buffer of " + i + " :  ");
				System.out.println(rb.get(i));
				System.out.print("Data Buffer of " + i + " :  ");
				System.out.println(db.get(i));
				if(fll==1)
				fin.append(i+1).append(" ");
			}
			fll++;
			System.out.println();
			System.out.println("Sender is " + sender);
			System.out.println();
			double u1=0,u2=0;
			if(total[sender][get] != 0)
				u1 = cor[sender][get]/total[sender][get];
			u1+=0.1;
			int ind=-1;
			if(fll==2)
			{
				fin.append("\n0.1 0.9 1.12 1.32 1.88\n");
				fll++;
			}
			if(rb.get(sender).size()!=0)
			{
				for(int j = 0;j<rb.get(sender).size();++j)
				{
					if(total[sender][rb.get(sender).get(j)] !=0)
					{
						if(u2 <= cor[sender][rb.get(sender).get(j)]/total[sender][rb.get(sender).get(j)])
						{
							u2 = cor[sender][rb.get(sender).get(j)]/total[sender][rb.get(sender).get(j)];
							ind = j;
						}
					}
				}
			}
			System.out.println("Utility Value(Data Buffer ) : " + u1);
			System.out.println("Utility Value(Relay Buffer) : " + u2);
			if(u1 >= u2)
			{
				System.out.println("Reciever is " + get);
				int sends = rand.nextInt(5);
				total[sender][get]++;
				if(sends ==0)
				{
					System.out.println("Unsucessfull Transmission");
				}
				else
				{
					System.out.println("Sucessfull Transmission");
					cor[sender][get]++;
					db.get(sender).remove(0);
				}
			}
			else
			{
				System.out.println("Reciever is " + rb.get(sender).get(ind));
				int sends = rand.nextInt(5);
				total[sender][rb.get(sender).get(ind)]++;
				if(sends ==0)
				{
					System.out.println("Unsucessfull Transmission");
				}
				else
				{
					System.out.println("Sucessfull Transmission");
					cor[sender][rb.get(sender).get(ind)]++;
					rb.get(sender).remove(ind);
				}
			}
			
			
		}
		for(int i=1;i<=5;++i)
			fin.append(i).append(" ");
		fw.write(fin.toString());
		fw.close();
			
}
}
