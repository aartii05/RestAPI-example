package rest.api.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.api.example.dao.CourseDao;
import rest.api.example.entities.Courses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseDao courseDao;





    List<Courses> list;

    public CourseServiceImpl() {
        list=new ArrayList<>();
        list.add(new Courses(12,"Java","this is a java"));
        list.add(new Courses(13,"Spring","this is a spring"));
    }
    @Override
    public List<Courses> getCourses() {
        return list;
    }

    @Override
    public Courses getCourse(long courseId) {
        Courses c=null;
        for(Courses courses:list){
            if(courses.getId()==courseId){
                c=courses;
                break;
            }
        }
        return c;
    }

    @Override
    public Courses addCourse(Courses courses) {
       list.add(courses);
       return courses;

    }

    @Override
    public Courses updateCourse(Courses courses) {
        list.forEach(e ->{
            if(e.getId()==courses.getId()){
                e.setTitle(courses.getTitle());
                e.setDescription(courses.getDescription());
            }
        });
        return courses;
    }

    @Override
    public void deleteCourse(long parseLong) {
        list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());

    }
}
