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
}
