//package app.github.services.impl;
//
//import app.github.clients.GithubClient;
//import app.github.dtos.PositionDTO;
//import app.github.services.GithubService;
//import org.junit.jupiter.api.BeforeEach;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class GithubServiceImplTest {
//
//  @Autowired
//  GithubService githubService;
//
//  @BeforeEach
//  void init(@Mock GithubClient githubClient) {
//    PositionDTO positionDTO = new PositionDTO(
//      "8297ba2e-fe78-4812-a130-918c176127d3",
//      "Full Time",
//      "https://jobs.github.com/positions/8297ba2e-fe78-4812-a130-918c176127d3",
//      "Wed Jul 24 21:30:18 UTC 2019",
//      "Motion Picture Industry Pension and Health Plan",
//      "http:",
//      "Studio City, California",
//      "Software Developer- MS Dynamics",
//      "<p>Immediate opportunity for experienced Software Engineer with CRM experience to design, develop, and maintain interfaces, using integration platforms.  This key role requires hands on experience in programming and configuration, with a high level of software development expertise and experience to ensure accuracy, security, and stability throughout the development and implementation lifecycle.</p>\n<p>For immediate consideration, submit letter of interest with resume and salary requirements.</p>\n<p>Required</p>\n<ul>\n<li>5+ years of software analysis, design, development, implementation, testing, maintenance with 3+ years of experience in EAI (Enterprise Application Integration) on Windows platform.</li>\n<li>Experience in implementing CRMs such as Salesforce or MS Dynamics.</li>\n<li>Expert knowledge of .NET Framework (3.5 or higher) ASP.Net, MVC. C#, ADO.NET, JSON.</li>\n<li>High level of experience building and supporting SSIS and SSRS packages.</li>\n<li>Demonstrated knowledge of Microsoft development and application technologies.</li>\n<li>Excellent understanding of SDLC processes and requirements.</li>\n<li>Experience in deploying full life-cycle enterprise-wide solutions.</li>\n<li>Bachelor’s degree or equivalent work experience.</li>\n<li>Availability to work extended hours as required by business needs.</li>\n</ul>\n<p>Preferred</p>\n<ul>\n<li>Experience with integration platforms such as Informatica Intelligent Cloud Services.</li>\n<li>Hands on experience with integration projects and migrating from legacy point-to-point\ninterfaces to Web Services and RESTful APIs.</li>\n<li>Strong understanding of understanding of enterprise application integration patterns such as messaging, Remote Procedure Invocation, Point to Point Channel, Publish-Subscribe Channel, etc.</li>\n<li>Experience with TFS (Team Foundation Server) release management (promoting code and building release packages).</li>\n</ul>\n<p>Responsibilities</p>\n<ul>\n<li>Analysis, Design, and development of interfaces using Informatica Intelligent Cloud Services.</li>\n<li>Participate in implementation of CRM application, develop reference, implementation integrations and testing, creation of detailed design documents, and develop interfaces to and from CRM to other applications.</li>\n<li>Design, develop, and implement moderate to highly complex web-based solutions in a multi-tiered architecture.</li>\n<li>Develop application/enhancement support documents (Business requirements/Technical Design documents/Test Cases/Change Management).</li>\n</ul>\n<p>MPI does not file visa petitions or sponsor applicants for work visas in this job classification.</p>\n<p>MPI offers free employee health, dental, vision and life insurance ($50/month for family coverage), retirement and pension plan benefits, and generous paid time off.\nRecognized as an Employer of Choice for its employee-focused work environment, competitive compensation and benefits, MPI is a recipient of the World at Work Seal of Distinction.</p>\n<p>Submissions will be reviewed; only candidates most closely matching the requirements of the position will be contacted.</p>\n<p>Relocation Assistance is not provided for this role.</p>\n",
//      "<p>Send resume with salary requirements to <a href=\"mailto:careers@mpiphp.org\">careers@mpiphp.org</a></p>\n",
//      "");
//
//    List<PositionDTO> mockedResponse = new ArrayList<PositionDTO>();
//    Mockito.lenient().when(githubClient.getPositions(1)).thenReturn(mockedResponse);
//  };
//
//  // TODO Fix this test (the mock is not intercepting the service (rest call)
////  @Test
////  void getPositions() {
////
////    Position position = new Position(
////      1,
////      LocalDateTime.now(),
////      LocalDateTime.now(),
////      "8297ba2e-fe78-4812-a130-918c176127d3",
////      "Software Developer- MS Dynamics",
////      "Motion Picture Industry Pension and Health Plan",
////      "Full Time",
////      "Studio City, California"
////    );
////
////    List<Position> expected = new ArrayList<Position>();
////    expected.add(position);
////
////    assertEquals(1, githubService.getPositions(1).size());
////
////  }
//
//}
