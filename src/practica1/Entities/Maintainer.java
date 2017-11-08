package practica1.Entities;

import java.util.List;

public class Maintainer {

    private String packageName;
    private String name;
    private String email;

    public Maintainer() {}

    public Maintainer(String[] separar) {
        if(separar.length == 3){
            this.packageName = separar[0];
            this.name = separar[1];
            this.email = separar[2];
        }
    }

    public Maintainer(String packageName, String name, String email) {
        this.packageName = packageName;
        this.name = name;
        this.email = email;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean equals(List<String> s){
        final boolean[] check = {false};
        s.forEach(s1 -> {
            System.out.println(s1 + " " + this.getName());
            if (this.name != null && s1.contains(this.name)){
                check[0] = true;
            }
        });
        return check[0];
    }

    /*public boolean containsName(final List<Maintainer> list, final String name){
        return list.stream().filter(o -> o.getName().contains(name)).findFirst().isPresent();
    }*/
}
