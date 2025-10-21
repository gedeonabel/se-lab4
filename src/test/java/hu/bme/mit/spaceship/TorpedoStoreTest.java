package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    private TorpedoStore empty_store;
    private TorpedoStore stable_store;
    private TorpedoStore fail_store;

    @BeforeAll
    public void init() {
        this.empty_store = new TorpedoStore(0);
        this.stable_store = new TorpedoStore(10,0);
        this.fail_store = new TorpedoStore(10,1);
    }

    //Test getTorpedoCount() function and constructors
    @Test
    void itemsInStores_Success() {
        // Assert
        assertEquals(this.empty_store.getTorpedoCount(), 0);
        assertEquals(this.stable_store.getTorpedoCount(), 10);
        assertEquals(this.fail_store.getTorpedoCount(), 10);
    }

    //Test simple firing method
    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    //Test of firing from empty store
    @Test
    void emptyFire_Fail() {
        // Act
        try {
            empty_store.fire(1);
        }
        catch(Exception e) {
            // Assert
            assertEquals(e.getMessage(), "numberOfTorpedos");
        }
    }

    //Test of firing to much torpedo
    @Test
    void toMuchFire_Fail() {
        // Act
        try {
            stable_store.fire(11);
        }
        catch(Exception e) {
            // Assert
            assertEquals(e.getMessage(), "numberOfTorpedos");
        }
    }

    //Test of writing invalid torpedo number
    @Test
    void invalidFiringNumber_Fail() {
        // Act
        try {
            stable_store.fire(0);
        }
        catch(Exception e) {
            // Assert
            assertEquals(e.getMessage(), "numberOfTorpedos");
        }
    }

    //Test of store failing
    @Test
    void storeFailure_Fail() {
        // Act
        boolean result = fail_store.fire(1);

        // Assert
        assertEquals(false, result);
    }

    //Test of isEmpty() method
    @Test
    void isEmpty_Success() {
        // Act
        boolean result = empty_store.isEmpty();

        // Assert
        assertEquals(true, result);
    }
}
