


/*Monitoring system Server Structure */
public class monitoring_system_t
{ int size;

	public long unix_timestamp; //unix timestamp;
	public short ip1 ; //Ip address
		public short ip2 ; //Ip address

			public short ip3 ; //Ip address

				public short ip4 ; //Ip address

	public short cpu_1; //CPU 1 with id 0
	public short cpu_2; //CPU 2 with id 1
	public int cpu_usage_1; //% of CPU usage of CPU 1
	public int cpu_usage_2; //% of CPU usage of CPU 2
	
	public monitoring_system_t(long timestamp,short ip1,short ip2,short ip3,short ip4,short cpu_1,short cpu_2,int cpu_usage_1,int cpu_usage_2){
       unix_timestamp= timestamp; //unix timestamp;
        ip1 = ip1; //Ip address
		ip2=ip2;
		ip3=ip3;
		ip4=ip4;
	 cpu_1=cpu_1; //CPU 1 with id 0
	 cpu_2=cpu_2; //CPU 2 with id 1
	 cpu_usage_1=cpu_usage_1; //% of CPU usage of CPU 1
	 cpu_usage_2=cpu_usage_2; //% of CPU usage of CPU 2
    
}
}