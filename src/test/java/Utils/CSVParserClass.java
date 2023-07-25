package Utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

public class CSVParserClass {
    public String email,FirstName,LastName,Company,Address,City,PostCode,PhoneNumber;


   public void parsefile() throws IOException
   {

       String email=null,FirstName=null,LastName=null,Company=null,Address=null,City=null,PostCode=null,PhoneNumber=null;
           String path = "src\\main\\resources\\Data.csv";
           File csvFile = new File(path);
           Reader filereader = new FileReader(csvFile);
           CSVParser parser = CSVFormat.DEFAULT.withDelimiter(',').withHeader().parse(filereader);


           for (CSVRecord record : parser)
           {
                email = record.get(0);
                FirstName=record.get(1);
                LastName=record.get(2);
                Company=record.get(3);
                Address=record.get(4);
                City=record.get(5);
                PostCode=record.get(6);
                PhoneNumber=record.get(7);
           }

           this.email=email;
           this.FirstName=FirstName;
           this.LastName=LastName;
           this.Company=Company;
           this.Address = Address;
           this.City = City;
           this.PostCode = PostCode;
           this.PhoneNumber = PhoneNumber;

   }
}
