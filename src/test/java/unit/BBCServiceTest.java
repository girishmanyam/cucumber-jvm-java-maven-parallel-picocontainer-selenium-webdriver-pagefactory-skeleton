package unit;

import automation.services.BBCService;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.*;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BBCServiceTest {

    private BBCService service;

    private static final String cannedResponse = "{\"programme\":{\"type\":\"brand\",\"pid\":\"b008ncn6\",\"expected_child_count\":null," +
            "\"position\":null,\"image\":{\"pid\":\"p020h1fn\"},\"media_type\":null,\"title\":\"Red Dwarf\",\"short_synopsis\":" +
            "\"Cult space comedy by Rob Grant and Doug Naylor.\",\"medium_synopsis\":\"Cult space comedy by Rob Grant and Doug Naylor.\"" +
            ",\"long_synopsis\":null,\"first_broadcast_date\":\"1988-09-06T21:00:00+01:00\",\"display_title\":{\"title\":\"Red Dwarf\"," +
            "\"subtitle\":\"\"},\"ownership\":{\"service\":{\"type\":\"tv\",\"id\":\"bbc_two\",\"key\":\"bbctwo\",\"title\":\"BBC Two\"}}," +
            "\"links\":[{\"type\":\"miscellaneous\",\"title\":\"Find the next scheduled repeat of Red Dwarf on other channels\",\"url\":" +
            "\"http://uktv.co.uk/dave/series/tvseries/250517\"}],\"supporting_content_items\":[],\"categories\":[{\"type\":\"genre\",\"id\"" +
            ":\"C00196\",\"key\":\"sitcoms\",\"title\":\"Sitcoms\",\"narrower\":[],\"broader\":{\"category\":{\"type\":\"genre\",\"id\":\"C00193\"," +
            "\"key\":\"comedy\",\"title\":\"Comedy\",\"broader\":{},\"has_topic_page\":false,\"sameAs\":null}},\"has_topic_page\":false,\"sameAs\":null}]}}";


    @ClassRule
    public static WireMockRule wireMockRule = new WireMockRule(18089);

    @BeforeClass
    public static void setUpStub() {
        stubFor(get(urlEqualTo("/programmes/b008ncn6.json")).withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(cannedResponse)));
    }

    @Before
    public void setUp() {
        service = new BBCService("http://localhost:18089");
    }

    @Test
    public void testICanGetTheTitle() throws Throwable {
        assertThat(service.getTitle(), is("Red Dwarf"));
    }

    @Test
    public void testICanGetTheShortSynopsis() throws Throwable {
        assertThat(service.getShortSynopsis(), is("Cult space comedy by Rob Grant and Doug Naylor."));
    }
}
