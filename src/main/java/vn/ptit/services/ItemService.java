package vn.ptit.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import vn.ptit.models.employee.ItemStat;
import vn.ptit.models.order.LineBookItem;
import vn.ptit.models.order.LineClothesItem;
import vn.ptit.models.order.LineElectronicsItem;
import vn.ptit.models.order.LineShoesItem;
import vn.ptit.models.order.Order;

@Service
public class ItemService {
	public List<ItemStat> statItemBestSeller(List<Order> orders) {
		List<ItemStat> itemStats = new ArrayList<ItemStat>();
		for (Order order : orders) {
			if (order.getShoppingCart().getLineBookItems() != null) {
				for (LineBookItem lineBookItem : order.getShoppingCart().getLineBookItems()) {
					itemStats.add(
							new ItemStat(lineBookItem.getBookItem().getBarCode(), lineBookItem.getBookItem().getPrice(),
									lineBookItem.getBookItem().getBook().getTitle(), lineBookItem.getQuanity()));
				}
			}
			if (order.getShoppingCart().getLineClothesItems() != null) {
				for (LineClothesItem lineClothesItem : order.getShoppingCart().getLineClothesItems()) {
					itemStats.add(
							new ItemStat(lineClothesItem.getClothesItem().getBarCode(), lineClothesItem.getClothesItem().getPrice(),
									lineClothesItem.getClothesItem().getClothes().getName(), lineClothesItem.getQuanity()));
				}
			}
			if (order.getShoppingCart().getLineElectronicsItems() != null) {
				for (LineElectronicsItem lineElectronicsItem : order.getShoppingCart().getLineElectronicsItems()) {
					itemStats.add(
							new ItemStat(lineElectronicsItem.getElectronicsItem().getBarCode(), lineElectronicsItem.getElectronicsItem().getPrice(),
									lineElectronicsItem.getElectronicsItem().getElectronics().getName(), lineElectronicsItem.getQuanity()));
				}
			}
			if (order.getShoppingCart().getLineShoesItems() != null) {
				for (LineShoesItem lineShoesItem : order.getShoppingCart().getLineShoesItems()) {
					itemStats.add(
							new ItemStat(lineShoesItem.getShoesItem().getBarCode(), lineShoesItem.getShoesItem().getPrice(),
									lineShoesItem.getShoesItem().getShoes().getName(), lineShoesItem.getQuanity()));
				}
			}
		}
		
		Collections.sort(itemStats, new Comparator<ItemStat>() {

			@Override
			public int compare(ItemStat o1, ItemStat o2) {
				return o2.getQuantity()-o1.getQuantity();
			}
			
		});
		
		return itemStats;
	}
}
