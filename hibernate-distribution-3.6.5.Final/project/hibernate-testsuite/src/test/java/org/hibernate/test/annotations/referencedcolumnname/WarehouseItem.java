//$Id$
package org.hibernate.test.annotations.referencedcolumnname;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

/**
 * @author Emmanuel Bernard
 */
@Entity
public class WarehouseItem {

	int id;
	Item item;
	Vendor vendor;
	ItemCost defaultCost;
	BigDecimal qtyInStock;

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getQtyInStock() {
		return qtyInStock;
	}

	public void setQtyInStock(BigDecimal qtyInStock) {
		this.qtyInStock = qtyInStock;
	}

	@ManyToOne
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@ManyToOne
	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

    @ManyToOne
	@JoinColumns({
     	@JoinColumn(name="vendor_id", referencedColumnName="vendor_id", insertable=false, updatable=false),
     	@JoinColumn(name="item_id", referencedColumnName="item_id", insertable=false, updatable=false)
     })
	public ItemCost getDefaultCost() {
		return defaultCost;
	}

	public void setDefaultCost(ItemCost defaultCost) {
		this.defaultCost = defaultCost;
	}
}

