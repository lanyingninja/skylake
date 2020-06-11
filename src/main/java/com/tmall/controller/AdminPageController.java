package com.tmall.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//所有的后台页面跳转都放在 AdminPageController 这个控制器,返回字符串，专门处理HTML这种
@Controller
public class AdminPageController {
    @GetMapping(value="/admin")
    public String admin(){
        return "redirect:admin_category_list";
    }

    @GetMapping(value="/admin_category_list")
    public String listCategory(){
        return "admin/listCategory";
    }

    @GetMapping(value="/admin_category_edit")
    public String editCategory(){
        return "admin/editCategory";
    }

    @GetMapping(value="/admin_property_list")
    public String listProperty(){
        return "admin/listProperty";
    }

    @GetMapping(value="/admin_property_edit")
    public String editProperty(){
        return "admin/editProperty";
    }

    @GetMapping(value="/admin_product_list")
    public String listProduct(){
        return "admin/listProduct";
    }

    @GetMapping(value="/admin_product_edit")
    public String editProduct(){
        return "admin/editProduct";
    }

    @GetMapping(value="/admin_productImage_list")
    public String listProductImage(){
        return "admin/listProductImage";
    }

    @GetMapping(value="/admin_propertyValue_edit")
    public String editPropertyValue(){
        return "admin/editPropertyValue";
    }

    @GetMapping(value="/admin_user_list")
    public String listUser(){
        return "admin/listUser";

    }

    @GetMapping(value="/admin_order_list")
    public String listOrder(){
        return "admin/listOrder";

    }
    
    @GetMapping(value="/admin_role_list")
    public String listRole(){
        return "admin/listRole";

    }
    
    @GetMapping(value="/admin_permission_list")
    public String listPermission(){
        return "admin/listPermission";

    }
    
    @GetMapping(value="/admin_user_edit")
    public String editUser(){
        return "admin/editUser";

    }
}