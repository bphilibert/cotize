package net.bons.comptes.cqrs;

import org.junit.Test;

public class ContributionHandlerTest {

    @Test
    public void computeTest() {
        // given
//        ContributionHandler contributionHandler = new ContributionHandler(mock(MongoClient.class), mock(CommandExtractor.class));
//        JsonObject entries = new JsonObject()
//                .put("name", "Anniversaire de Vanessa")
//                .put("author", "Michel Barret")
//                .put("description", "C'est l'anniversaire de Vanessa")
//                .put("identifier", "e679d4ed-d")
//                .put("passAdmin", "e2f901eb-0")
//                .put("amount", 0);
//        RawProject project = new RawProject(entries);
//        ContributeProject contribute = new ContributeProject("Michel", "exemple@exemple.com", 100);
//
//        // when
//        RawProject projectResult = contributionHandler.compute(project, contribute);
//
//        // then
//        assertThat(projectResult).isNotNull();
//        assertThat(projectResult.getContributions().size()).isEqualTo(1);
//        assertThat(projectResult.getAmount()).isEqualTo(100);
    }

    @Test
    public void computeTest2() {
        // given
//        ContributionHandler contributionHandler = new ContributionHandler(mock(MongoClient.class), mock(CommandExtractor.class));
//        String authorDeal = "Michel";
//        JsonObject entriesDeals = new JsonObject()
//                .put("author", authorDeal)
//                .put("amount", 42)
//                .put("email", "foo")
//                .put("date", System.currentTimeMillis());
//        JsonObject entriesProject = new JsonObject()
//                .put("name", "Anniversaire de Vanessa")
//                .put("author", "Michel Barret")
//                .put("description", "C'est l'anniversaire de Vanessa")
//                .put("identifier", "e679d4ed-d")
//                .put("passAdmin", "e2f901eb-0")
//                .put("amount", 42)
//                .put("contributions", new JsonArray().add(entriesDeals));
//        RawProject project = new RawProject(entriesProject);
//        ContributeProject contribute = new ContributeProject(authorDeal, "exemple@exemple.com", 100);
//
//        // when
//        RawProject projectResult = contributionHandler.compute(project, contribute);
//
//        // then
//        assertThat(projectResult).isNotNull();
//        assertThat(projectResult.getContributions().size()).isEqualTo(1);
//        assertThat(projectResult.getAmount()).isEqualTo(42);
    }
}
