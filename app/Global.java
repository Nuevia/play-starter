import play.*;
import play.libs.*;

import java.util.*;

import com.avaje.ebean.Ebean;

import models.*;

public class Global extends GlobalSettings {
    
    public void onStart(Application app) {
        InitialData.insert(app);
    }
    
    static class InitialData {
        
        public static void insert(Application app) {
            if(Mapping.find.findRowCount() == 0) {
                
            	//Ebean.save((List) Yaml.load("initial-data.yml"));
            	Map<String,List<Object>> all = (Map<String,List<Object>>)Yaml.load("initial-data.yml");
            	Ebean.save(all.get("sample_mappings"));

            }
        }
        
    }
    
}