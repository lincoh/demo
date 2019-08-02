import apithree.demo.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.client.RestTemplate;

public class RestTestingCat2 {

    public class RestTestingCat2 implements CommandLineRunner {

        @Override
        public  void run(String... args) throws Exception {
            RestTemplate restTemplate = new RestTemplate();

//        ResponseEntity<List<University>> response = restTemplate.exchange(
//                "http://10.51.10.111:1000/registrations",
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<Student>>(){});


            //  Register a new student
            System.out.println("Registering a new student(POST)-----------------------------------------------");

            Student newStudent = new Student("Lincoln Memba", 101929);
            Student registeredStudent = restTemplate.postForObject(
                    "http://10.51.10.111:1000/registrations",
                    newStudent,
                    Student.class);

            System.out.println(registeredStudent.toString());

        }


    }
}
