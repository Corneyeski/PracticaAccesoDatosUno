package practica1.Entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BugPackage {

    private long id;
    private List<String> name = new ArrayList<>();

    public BugPackage() {}

    public BugPackage(String[] separar) {
        if(separar.length == 2){
            this.id = Long.parseLong(separar[0]);
            if(separar[1].contains(",")){
                this.name.addAll(Arrays.asList(separar[1].split(",")));
            } else{
                this.name.add(separar[1]);
            }
        }
    }

    public BugPackage(long id, List<String> name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }
}
