package test.Models;

import main.Enums.Resource;
import main.Exceptions.InvalidPlayerTransactionException;
import main.Models.Player;
import main.Models.PlayerTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTransactionTest {

    Player player;
    PlayerTransaction pt;

    @BeforeEach
    public void loadData() {
        player = new Player();
        pt = new PlayerTransaction(player, "test");
    }

    @ParameterizedTest
    @EnumSource(
            value = Resource.class
    )
    void onlyCredProdutionCanBeNegativeTest(Resource resource) {
        try {
            pt.addResource(resource, -1);
            pt.execute();
            assertSame(resource, Resource.CREDIT_PRODUCTION);
        } catch (InvalidPlayerTransactionException e) {
            assertNotSame(resource, Resource.CREDIT_PRODUCTION);
        }
    }

}
