package com.shop.sphere.dao;

import com.shop.sphere.models.Buyer;
import com.shop.sphere.dao.BuyerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TestRepositories {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BuyerRepository buyerRepository;

    @Test
    public void testBuyerCreate() {
        Buyer buyer = new Buyer();
        buyer.setFirstName("Achraf");
        buyer.setLastName("ZERHOUNI");
        buyer.setEmail("achraf.zerhouni@shopsphere.com");
        buyer.setPassword("achrafPassword");
        buyer.setAddress("123 Boulevard Achraf");

        Buyer savedBuyer = buyerRepository.save(buyer);
        entityManager.flush();  // Ensure changes are pushed to the test database

        Buyer foundBuyer = entityManager.find(Buyer.class, savedBuyer.getId());

        assertThat(foundBuyer).isNotNull();
        assertThat(foundBuyer.getFirstName()).isEqualTo(buyer.getFirstName());
        assertThat(foundBuyer.getLastName()).isEqualTo(buyer.getLastName());
        assertThat(foundBuyer.getEmail()).isEqualTo(buyer.getEmail());
        assertThat(foundBuyer.getPassword()).isEqualTo(buyer.getPassword());
        assertThat(foundBuyer.getAddress()).isEqualTo(buyer.getAddress());
    }

    @Test
    public void testBuyerUpdate() {
        // 1. Create and save an initial buyer (Juba OUARAB)
        Buyer buyer = new Buyer();
        buyer.setFirstName("Juba");
        buyer.setLastName("OUARAB");
        buyer.setEmail("juba.ouarab@shopsphere.com");
        buyer.setPassword("jubaPassword");
        buyer.setAddress("456 Avenue Juba");
        Buyer savedBuyer = buyerRepository.save(buyer);
        entityManager.flush();

        // 2. Update the saved buyer's attributes
        savedBuyer.setFirstName("Kpotivi");
        savedBuyer.setLastName("KPOTY");
        savedBuyer.setEmail("kpotivi.kpoty@shopsphere.com");
        savedBuyer.setPassword("kpotiviPassword");
        savedBuyer.setAddress("789 Street Kpotivi");
        Buyer updatedBuyer = buyerRepository.save(savedBuyer);
        entityManager.flush();

        // 3. Fetch the updated buyer from the database and verify the changes
        Buyer foundBuyer = entityManager.find(Buyer.class, updatedBuyer.getId());

        assertThat(foundBuyer).isNotNull();
        assertThat(foundBuyer.getFirstName()).isEqualTo("Kpotivi");
        assertThat(foundBuyer.getLastName()).isEqualTo("KPOTY");
        assertThat(foundBuyer.getEmail()).isEqualTo("kpotivi.kpoty@shopsphere.com");
        assertThat(foundBuyer.getPassword()).isEqualTo("kpotiviPassword");
        assertThat(foundBuyer.getAddress()).isEqualTo("789 Street Kpotivi");
    }
}
