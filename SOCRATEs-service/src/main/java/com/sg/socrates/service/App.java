package com.sg.socrates.service;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

		String[] springConfig  = 
			{	"batch/config/database.xml", 
				"batch/config/context.xml",
				"batch/jobs/job-report.xml" 
			};
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(springConfig);
		JobParametersBuilder jobparmBuilder=new JobParametersBuilder();
	
		jobparmBuilder.addString("key.file", "file:"+"F:/workspace/SOCRATEs/SOCRATEs-service/src/main/resource/excel\\Test.xlsx");
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("excelReportJob");

		try {

			JobExecution execution = jobLauncher.run(job, jobparmBuilder.toJobParameters());
			System.out.println("Exit Status : " + execution.getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done");

	}
}
