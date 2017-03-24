package com.github.s_matyukevich.spring_boot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.s_matyukevich.spring_boot.domain.model.StockItem;
import com.github.s_matyukevich.spring_boot.domain.model.StockItemRepository;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(value = "/stock", produces = MediaType.APPLICATION_JSON_VALUE)
public class StockResource { 
	  @Autowired
	  private StockItemRepository stockItemRepository;

	  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
	  public StockItem stockItem(@PathVariable("id") Long id, HttpServletResponse response) {

	      StockItem stockItem = stockItemRepository.findOne(id);

	      if (stockItem == null) {
	          response.setStatus(HttpStatus.NOT_FOUND.value());
	          return null;
	      }

	      return stockItem;
	  }

	  @RequestMapping(value = "", method = RequestMethod.POST)
	  public StockItem storeInStock(@RequestBody StockItem stockItem, HttpServletResponse response) {
	      StockItem storedItem = stockItemRepository.save(stockItem);

	      response.setStatus(HttpStatus.CREATED.value());

	      return storedItem;
	  }

	  @RequestMapping(value = "", method = RequestMethod.PUT)
	  public StockItem update(@RequestBody StockItem stockItem, HttpServletResponse response) {
	      if (!stockItemRepository.exists(stockItem.getId())) {
	          response.setStatus(HttpStatus.NOT_FOUND.value());
	          return stockItem;
	      }

	      return stockItemRepository.save(stockItem);
	  }

	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void removeFromStock(@PathVariable("id") Long id, HttpServletResponse response) {
	      StockItem stockItemToRemove = stockItemRepository.findOne(id);

	      if (stockItemToRemove == null) {
	          response.setStatus(HttpStatus.NOT_FOUND.value());
	          return;
	      }

	      stockItemRepository.delete(stockItemToRemove);
	  }

	  @RequestMapping(value = "", method = RequestMethod.GET)
	  public Iterable<StockItem> items() {
	      return stockItemRepository.findAll();
	  }

}