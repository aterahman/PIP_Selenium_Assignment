package Utils;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class CSVParser {
   public List<String> parser()
   {
       String path = "src\\main\\resources\\Data.csv";
       File csvFile = new File(path);
       Reader filereader = new FileReader(csvFile);
       csvParser
   }
}
