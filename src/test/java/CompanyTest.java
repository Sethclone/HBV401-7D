
import hbv7d.repository.CompanyRepository;
import hbv7d.controller.CompanyController;
import hbv7d.model.Company;
import hbv7d.model.Tour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Tests the Companycontroller using a Mockito-based mock of 
 * CompanyRepository. Demonstrates creating a company, verifying 
 * its existence, adding a tour, and confirming it was persisted correctly.
 */
public class CompanyTest {

    /**
     * Mocked repository used to simulate database operations for testing.
     */
    private CompanyRepository mockRepo;

    /**
     * The controller used to test, which depends on our mocked repository.
     */
    private CompanyController controller;

    /**
     * Creates a mock af CompanyRepository, Which is our mock object
     * and creates a new CompanyController for each test.
     */
    @BeforeEach
    void setUp() {
        // Setur upp mock af CompanyRepository, sem er mock object okkar
        mockRepo = mock(CompanyRepository.class);
        // Setur upp companyController með mockinu í, sem verður þarf svo að skipta fyrir DB aðgang
        controller = new CompanyController(mockRepo);
    }

    /**
     * Test method which will:
     * 1) Create a new company and save it
     * 2) Request the company and make sure it exists
     * 3) Create a new tour and add it to the company
     * 4) Check if tour exists in the company listing
     * 5) Check if save was called twice, which it should have once for both company and tour
     */
    @Test
    void testCompanyFlow() {
        //Býr til nýtt fyrirtæki, skilar null ef það finnst ekki
        Company newCompany = new Company(1, "Company1");
        when(mockRepo.findById(1)).thenReturn(null);

        boolean created = controller.createCompany(newCompany);
        assertTrue(created);
        //Ef verified vistar í Hashmappinu í CompanyRepository
        verify(mockRepo).save(newCompany);

        //Þegar mockRepo kallar á findById með 1, þá á það að skila newCompany en ekki null
        when(mockRepo.findById(1)).thenReturn(newCompany);
        //retrievedCompany geymir Company object sem er með id 1, sem ætti þá að vera newCompany
        Company retrievedCompany = controller.getCompany(1);
        //Checkar hvort við fengum örruglega ekki null
        assertNotNull(retrievedCompany);
        //Sér hvort nafnið á retrievedCompany sé ekki örruglega Company1
        assertEquals(" Company1", retrievedCompany.getName());

        //Bætir við Tour á þetta fyrirtæki sem við gerðum fyrir ofan.
        newCompany.setTour(new ArrayList<>());
        Tour newTour = new Tour(
            101,
            "Tour1",
            "description",
            "Reykjavik",
            500,
            new Date(),
            2,
            10,
            "Easy",
            "Hiking",
            false,
            newCompany
        );
        //Býr til tour með newCompany og sér hvort addTour skilar ekki örruglega True
        boolean tourAdded = controller.addTour(1, newTour);
        assertTrue(tourAdded);
        //Sækir tours frá newCompany og sér hvort að listinn sé örruglega ekki null(Tómur)
        List<Tour> tours = newCompany.viewCompanyTours();
        assertNotNull(tours);
        //Sér hvort að newTour sé ekki örruglega í tours
        assertTrue(tours.contains(newTour));
        //Kíkir hvort að mockRepo hafi ekki örruglega vistað tvisvar, Hann átti að hafa vistað
        // þegar búið til var company, og svo þegar búið var til tour
        verify(mockRepo, times(2)).save(any(Company.class));
    }
}
