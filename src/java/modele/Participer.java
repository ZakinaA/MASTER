package modele;

/**
 * 
 * @author DUBOSQ
 */
public class Participer {
    private int id;
    private int place;
    private Course uneCourse;
    private Cheval unCheval;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public Course getUneCourse() {
        return uneCourse;
    }

    public void setUneCourse(Course uneCourse) {
        this.uneCourse = uneCourse;
    }

    public Cheval getUnCheval() {
        return unCheval;
    }

    public void setUnCheval(Cheval unCheval) {
        this.unCheval = unCheval;
    }
    
    
    
}
