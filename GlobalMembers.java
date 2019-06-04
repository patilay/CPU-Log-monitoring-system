import java.io.*;
import java.text.SimpleDateFormat;  
import java.util.Date; 
import java.util.Random; 
import java.text.DateFormat;



public class GlobalMembers
{
	public static final int NUM_OF_SERVERS = 1000; //Number of servers
	public static final int MINUTES_IN_A_DAY = 1440; // Number of minutes in a day 24*60
	

	public static void main(String[] args)
	{   
		/* Allocate memory for 1000 servers */
		
		monitoring_system_t[] server = new monitoring_system_t[NUM_OF_SERVERS];
		
		FileWriter fileWriter=null;
	try{	
      fileWriter = new FileWriter(args[0]);
      //printWriter = new PrintWriter(fileWriter);
	 } catch (FileNotFoundException e) {
	System.err.print("File not Found");
    } catch (IOException e) {
        System.err.print("Something went wrong");
    }


		if (server == null)
		{
			System.out.print("Memory allocation failure");
		}


		System.out.println("Generating Logs!!Please wait");

		
		long unix_timestamp=0;
		try{
		  
		  String dateString = "Thu, 31 Oct 2014 00:01 GMT";
		  DateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy hh:mm z");
		  Date date = dateFormat.parse(dateString );
		    unix_timestamp = (long) date.getTime()/1000;
		}catch (Exception e) {
			System.err.print("wrong date format");
		}
         
	

		/* Add title to the output file */
		try{
		fileWriter.write(String.format("%s %10s %20s %10s \r\n","TIMESTAMP","IP","CPU_ID","CPU_USAGE"));} 
		catch (IOException e) {
        System.err.print("Something went wrong");
        }



		/* Loop through every minute and log it to the file */
		for (int j = 0; j < MINUTES_IN_A_DAY; j++)
		{
			/* Flags to set ip addresses */
			int ip_3 = 1;
			int ip_4 = 1;
			

			for (int i = 0; i < NUM_OF_SERVERS; i++)
			{
				/* Save CPU_IDs */
				short cpu_1 = 0;
				short cpu_2 = 1;

				/*CPU usage.Just a random number*/
				Random r =new Random();
				
				int cpu_usage_1 = r.nextInt(100-10)+10;
				int cpu_usage_2 =  r.nextInt(100-10)+10;
				
				/*Assign IP addresses to each server */
				short ip0 = 192;
				short ip1 = 168;
				short ip2 = (short)ip_3;
			    short ip3 = (short)ip_4;
				/* To restrict ip address to not go beyond 255 */
				if (ip_4 <= 255)
				{
					 ip2 = (short)ip_3;
					 ip3 = (short)(ip_4++);
				}
				else
				{
					
					ip_4 = 1;
					ip_3++;
					ip2 = (short)ip_3;
					ip3 = (short)(ip_4++);
				}
				server[i] = new monitoring_system_t(unix_timestamp,ip0,ip1,ip2,ip3,cpu_1,cpu_2,cpu_usage_1,cpu_usage_2);

				/* Log the saved values to output file */
				try{
				fileWriter.write(String.format("%s ",unix_timestamp ));

				
				fileWriter.write(String.format("%10d.%d.%d.%d ",ip0,ip1,ip2,ip3));
				
				fileWriter.write(String.format("%20d %10d \r\n",cpu_1,cpu_usage_1));
				
				fileWriter.write(String.format("%s ",unix_timestamp ));
				
				fileWriter.write(String.format("%10d.%d.%d.%d ",ip0,ip1,ip2,ip3));
				
				fileWriter.write(String.format("%20d %10d \r\n",cpu_2,cpu_usage_2));}
		 		catch (IOException e) {
                System.err.print("Something went wrong");
                }
				
				
			} //End for

			/* Since we need to log every minute increment by 60s */
			unix_timestamp = unix_timestamp + 60;

		} //End for

		/* Free allocated Server memory */
		server = null;


		System.out.println("DONE");
	}
}