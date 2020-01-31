package com.beer.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beer.model.dao.BeerDAO;
import com.beer.model.dto.Beer;

@Service
public class BeerServiceImp implements BeerService{
	@Autowired
	private BeerDAO dao;

	@Override
	public Beer search(int beerId) {
		try {
			Beer beer = dao.search(beerId);
			System.out.println("검색된 맥주: " + beer);

			return beer;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Beer> searchByName(String beerName) {
		try {
			List<Beer> list = dao.searchByName(beerName);

			System.out.print("맥주이름으로 검색: ");
			for(Beer beer:list)
				System.out.print(beer + " ");

			return list;
		} catch(Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Beer> searchByBrewer(String brewer) {
		try {
			List<Beer> list = dao.searchByBrewer(brewer);

			System.out.print("맥주 제조업체로 검색: ");
			for(Beer beer:list)
				System.out.print(beer + " ");

			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Beer> searchByNation(String nation) {
		try {
			List<Beer> list = dao.searchByNation(nation);

			System.out.print("맥주 원산지로 검색: ");
			for(Beer beer:list) System.out.print(beer + " ");

			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Beer> searchByAlcohol(String alcohol) {
		try {
			List<Beer> list = dao.searchByAlcohol(alcohol);

			System.out.print("맥주 도수로 검색: ");
			for(Beer beer:list) System.out.print(beer + " ");

			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public List<Beer> searchByCategory(String category) {
		try {
			List<Beer> list = dao.searchByCategory(category);
			for(Beer beer:list) System.out.println(beer + " ");
		
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public List<Beer> searchAll() {
		try {
			List<Beer> list = dao.searchAll();
			for(Beer beer:list) System.out.print(beer + " ");

			return list;
		} catch(Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void insert(Beer beer) {
		try {
			dao.insert(beer);
			System.out.println("insert success");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Beer beer) {
		try {
			dao.update(beer);
			System.out.println("update success");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int beerId) {
		try {
			dao.delete(beerId);
			System.out.println("delete success");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}