package com.tarik.crud_product.controller;

import com.tarik.crud_product.Dao.JpaDao;
import com.tarik.crud_product.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProductController {
    @Autowired
    private JpaDao jpaDao;
    @RequestMapping(path="/")
    public String index(Model model,@RequestParam(name="page",defaultValue ="0") int page,@RequestParam(name="mc", defaultValue ="") String mc){
        Page<Product> produits=jpaDao.findByDesignationContains(mc,PageRequest.of(page,4));
        model.addAttribute("model",produits.getContent());
        model.addAttribute("pages",new int [produits.getTotalPages()]);
        model.addAttribute("pageCurrent",page);
        model.addAttribute("search",mc);
        return "index";
    }
    @GetMapping("/addPage")
    public String addPage(){
        return "add";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute Product product){
        jpaDao.save(product);
        System.out.println(product);
        return "redirect:/";
    }
    @GetMapping(path="/delete")
    public String deleteProduct(@RequestParam(name="id") Long id){
        jpaDao.deleteById(id);
        return "redirect:/";
    }
    @GetMapping("/login")
    public String form(){
        return "loginForm";
    }
    @PostMapping("/login")
    public String login(){
        return "redirect:/";
    }
}
