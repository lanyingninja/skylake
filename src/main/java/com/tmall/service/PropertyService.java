package com.tmall.service;

import com.tmall.dao.CategoryDAO;
import com.tmall.dao.PropertyDAO;
import com.tmall.pojo.Category;
import com.tmall.pojo.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {
    @Autowired
    PropertyDAO PropertyDAO;

    @Autowired
    CategoryService categoryService;

    public Page<Property> listProperty(int start, int size,int cid){
        Category category = categoryService.get(cid);
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size, sort);
        Page page =PropertyDAO.findByCategory(category,pageable);
        return page;
    }

    public List<Property> listByCategory(int cid){
        Category category = categoryService.get(cid);
        return PropertyDAO.findByCategory(category);
    }

   
    public void add(Property p){
        PropertyDAO.save(p);
    }

    public void delete(int id){
        PropertyDAO.deleteById(id);
    }

    public void edit(Property p){
        PropertyDAO.save(p);
    }

    public Property get(int id) {
        Optional<Property> PropertyInfoOptional = PropertyDAO.findById(id);
        if (!PropertyInfoOptional.isPresent()) {
            return null;
        }
        return PropertyInfoOptional.get();
    }

}
