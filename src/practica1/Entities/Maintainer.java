package practica1.Entities;

public class Maintainer {

    private String packageName;
    private String name;
    private String email;

    public Maintainer() {}

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
}
