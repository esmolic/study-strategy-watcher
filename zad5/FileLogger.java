package zad5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;

public class FileLogger extends IntegerCollectionObserver{

    @Override
    void notifyCollectionUpdated(Collection<Integer> collection) {
       File log = new File("./log.txt");

       if (!log.isFile())
        try {
            log.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter bw = new FileWriter(log)){
  

            StringBuilder outputSB = new StringBuilder();

            collection.forEach(x -> outputSB.append(x.toString() + "\n"));
            
            LocalDateTime now = LocalDateTime.now();  
            outputSB.append(now.toString());

            bw.write(outputSB.toString());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
