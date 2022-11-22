
package com.cybage.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.FavouriteItemRepository;
import com.cybage.daos.PetAccessoriesRepository;
import com.cybage.daos.PetCategoryRepository;
import com.cybage.daos.PetFoodRepository;
import com.cybage.daos.PetRepository;
import com.cybage.daos.UserRepository;
import com.cybage.entities.FavouriteItem;
import com.cybage.entities.Pet;
import com.cybage.entities.PetAccessories;
import com.cybage.entities.PetFood;
import com.cybage.entities.User;

@Service
public class FavouriteListServiceImpl implements IFavouriteListService {

	@Autowired
	FavouriteItemRepository favouriteItemRepository;

	@Autowired
	PetServiceImpl petServiceImpl;

	@Autowired
	PetFoodServiceImpl petFoodServiceImpl;

	@Autowired
	PetAccessoriesServiceImpl petAccessoriesServiceImpl;
	
	@Autowired
	PetCategoryRepository petCategoryRepository;
	
	@Autowired
	PetRepository petRepository;
	
	@Autowired
	PetFoodRepository petFoodRepository;
	
	@Autowired
	PetAccessoriesRepository petAccessoriesRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public FavouriteItem addToFavouriteList(int id , String userEmail) {
		FavouriteItem favouriteItem = new FavouriteItem();
		List<FavouriteItem> favouriteItemList = new ArrayList<>();
		
		List<Pet> petList = new ArrayList<>();
		List<PetFood> petFoodsList = new ArrayList<>();
		List<PetAccessories> petAccessoriesList = new ArrayList<>();
		
		User user = userRepository.findByUserEmail(userEmail);
		
		Pet pet = petRepository.findByPetId(id);
		
		if(pet != null)
		{
			String categoryName = pet.getPetCategory().getCategoryName();
			
			if(categoryName.equals("Dog"))
			{
				petList.add(petServiceImpl.findByPetId(id));
				favouriteItem.setPets(petList);
				favouriteItemList.add(favouriteItem);
			}
//			else if(categoryName.equals("Cat"))
//			{
//				petList.add(petServiceImpl.findByPetId(id));
//				favouriteItem.setPets(petList);
//				favouriteItemList.add(favouriteItem);
//				favouriteList.setFavouriteItems(favouriteItemList);
//				
//			}
//			else if(categoryName.equals("Bird"))
//			{
//				petList.add(petServiceImpl.findByPetId(id));
//				favouriteItem.setPets(petList);
//				favouriteItemList.add(favouriteItem);
//				favouriteList.setFavouriteItems(favouriteItemList);
//				
//			}
//			else if(categoryName.equals("Fish"))
//			{
//				petList.add(petServiceImpl.findByPetId(id));
//				favouriteItem.setPets(petList);
//				favouriteItemList.add(favouriteItem);
//				favouriteList.setFavouriteItems(favouriteItemList);
//				
//			}
			pet.getFavouriteItem().addAll(favouriteItemList);
		}
		
		
		PetFood petFood = petFoodRepository.findByFoodId(id);
		
		if(petFood != null)
		{
			String foodCategory = petFood.getFoodCategory();
			
			if(foodCategory.equals("Dog food"))
			{
				
				petFoodsList.add(petFoodServiceImpl.findByFoodId(id));
				System.out.println(petFoodServiceImpl.findByFoodId(id).getFoodName());
				favouriteItem.setPetFoods(petFoodsList);
				favouriteItemList.add(favouriteItem);
			}
			
			petFood.getFavouriteItem().addAll(favouriteItemList);
		}
//			else if(foodCategory.equals("Cat food"))
//			{
//				petFoodsList.add(petFoodServiceImpl.findByFoodId(id));
//				favouriteItem.setPetFoods(petFoodsList);
//				favouriteItemList.add(favouriteItem);
//				favouriteList.setFavouriteItems(favouriteItemList);
//			}
//			else if(foodCategory.equals("Bird food"))
//			{
//				petFoodsList.add(petFoodServiceImpl.findByFoodId(id));
//				favouriteItem.setPetFoods(petFoodsList);
//				favouriteItemList.add(favouriteItem);
//				favouriteList.setFavouriteItems(favouriteItemList);
//			}
//			else if(foodCategory.equals("Fish food"))
//			{
//				petFoodsList.add(petFoodServiceImpl.findByFoodId(id));
//				favouriteItem.setPetFoods(petFoodsList);
//				favouriteItemList.add(favouriteItem);
//				favouriteList.setFavouriteItems(favouriteItemList);
//			}
//		}
//		
//		
//		PetAccessories petAccessories = petAccessoriesRepository.findByItemId(id);
//		
//		if(petAccessories != null)
//		{
//			String itemCategory = petAccessories.getItemCategory();
//			
//			if(itemCategory.equals("Dog accessories"))
//			{
//				petAccessoriesList.add(petAccessoriesServiceImpl.findByItemId(id));
//				favouriteItem.setPetAccessories(petAccessoriesList);
//				favouriteItemList.add(favouriteItem);
//				favouriteList.setFavouriteItems(favouriteItemList);
//			}
//			else if(itemCategory.equals("Cat accessories"))
//			{
//				petAccessoriesList.add(petAccessoriesServiceImpl.findByItemId(id));
//				favouriteItem.setPetAccessories(petAccessoriesList);
//				favouriteItemList.add(favouriteItem);
//				favouriteList.setFavouriteItems(favouriteItemList);
//			}
//			else if(itemCategory.equals("Bird accessories"))
//			{
//				petAccessoriesList.add(petAccessoriesServiceImpl.findByItemId(id));
//				favouriteItem.setPetAccessories(petAccessoriesList);
//				favouriteItemList.add(favouriteItem);
//				favouriteList.setFavouriteItems(favouriteItemList);
//			}
//			else if(itemCategory.equals("Fish accessories"))
//			{
//				petAccessoriesList.add(petAccessoriesServiceImpl.findByItemId(id));
//				favouriteItem.setPetAccessories(petAccessoriesList);
//				favouriteItemList.add(favouriteItem);
//				favouriteList.setFavouriteItems(favouriteItemList);
//			}
//		}
//		
//		favouriteList.setSessionToken(sessionToken);
//		System.out.println("fav item"+favouriteItem);
//		System.out.println("fav list"+favouriteList);
		
		
//		
		favouriteItem.setUserMail(user);
//		
		return favouriteItemRepository.save(favouriteItem);
	}

	@Override
	public List<FavouriteItem> getFavouriteList(String userEmail) {
		return favouriteItemRepository.getFavouriteList(userEmail);
	}
//	@Override
//	public FavouriteList removeFavouriteItemFromFavouriteList(int id, String sessionToken) {
//		FavouriteList favouriteList = favouriteListRepository.findBySessionToken(sessionToken);
//		List<FavouriteItem> favouriteItems = favouriteList.getFavouriteItems();
//		FavouriteItem item = null;
//		for (FavouriteItem item1 : favouriteItems) {
//			if (item1.getId() == id) {
//				item = item1;
//			}
//		}
//		favouriteItems.remove(item);
//		favouriteItemRepository.delete(item);
//		favouriteList.setFavouriteItems(favouriteItems);
//		return favouriteListRepository.save(favouriteList);
//	}
//
//	@Override
//	public void clearFavouriteList(String sessionToken) {
//		FavouriteList favouriteList = favouriteListRepository.findBySessionToken(sessionToken);
//		favouriteListRepository.delete(favouriteList);
//	}
	
}