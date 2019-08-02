package apithree.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sun.tools.jconsole.Plotter;

import java.util.List;

@Component
public class RestTesting implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate  = new RestTemplate();

        ResponseEntity<List<University>> response = restTemplate.exchange(
                "http://10.51.10.111:1000/units",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<University>>(){});
        List<University> units = response.getBody();

        for(University university : units){
            System.out.println(university.toString());
        }

        System.err.println("Find One(GET)--------------------------------");

        University university = restTemplate.getForObject(
                "http://10.51.10.111:8080/units/",
                University.class);
        System.out.println(university.toString());

        System.err.println("Creating(POST)______________________________");

        University newUniversity = new University("Chuka",
                "Meru",200);
       University createdUniversity = restTemplate.postForObject(
                "http://10.51.10.111:8080/universities",
                newUniversity, University.class);
        System.out.println(createdUniversity.toString());

       // System.err.println("____________________________________");
       // String createCourseUrl = "http://10.51.10.111:8080/Courses"
           //     +createdUniversity.getId()+"/Courses";


    }
}
