package app;

public class Champion {
    private String name;
    private String title;
    private String classOfChampion;
    private String prefLine;

    public Champion() {
    }

    public Champion(String name, String title, String classOfChampion, String prefLine) {
        this.name = name;
        this.title = title;
        this.classOfChampion = classOfChampion;
        this.prefLine = prefLine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getclassOfChampion() {
        return classOfChampion;
    }

    public void setclassOfChampion(String classOfChampion) {
        this.classOfChampion = classOfChampion;
    }

    public String getPrefLine() {
        return prefLine;
    }

    public void setPrefLine(String prefLine) {
        this.prefLine = prefLine;
    }

    @Override
    public String toString() {
        return "Champion{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", classOfChampion='" + classOfChampion + '\'' +
                ", prefLine='" + prefLine + '\'' +
                '}';
    }
}

