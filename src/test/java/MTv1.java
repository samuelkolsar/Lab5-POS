package ee.ut.math.tvt.salessystem.logic;

import ee.ut.math.tvt.salessystem.dao.InMemorySalesSystemDAO;
import ee.ut.math.tvt.salessystem.dataobjects.SoldItem;
import ee.ut.math.tvt.salessystem.dataobjects.StockItem;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class MTv1 {

	private ShoppingCart shoppingCart;

	@Before
	public void setUp() {
		shoppingCart = new ShoppingCart(new InMemorySalesSystemDAO());
		SoldItem soldItem = new SoldItem();
		StockItem stockItem = new StockItem();
	}

	@Test
	public void testAddItemAndRetrieve() {
		SoldItem item = new SoldItem();
		shoppingCart.addItem(item);

		List<SoldItem> items = shoppingCart.getAll();
		assertEquals(1, items.size());
		assertEquals("TestItem", items.get(0).getName());
		assertEquals(2, (int) items.get(0).getQuantity()); // Cast to int if needed

	}

	@Test
	public void testSubmitCurrentPurchaseClearsCart() {
		SoldItem item = new SoldItem();
		shoppingCart.addItem(item);

		shoppingCart.submitCurrentPurchase();

		assertTrue(shoppingCart.getAll().isEmpty());
	}
}
