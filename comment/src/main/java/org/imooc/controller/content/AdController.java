package org.imooc.controller.content;

import org.imooc.bean.Ad;
import org.imooc.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/ad")
public class AdController {


    @Autowired
    private AdService adService;

    @RequestMapping("/modify")
    public String modify(Ad ad,MultipartFile newImgFile){

        //判断是否更新了图片
        if(newImgFile != null){
            String filename = newImgFile.getOriginalFilename();
            ad.setImgFileName(filename);
        }
        //更新ad信息到数据库
        adService.modifyAd(ad);
        return "/ad";
    }


    @RequestMapping("/modifyInit")
    public String modifyAd(@RequestParam("id")String id,Model model){

        Ad ad = adService.getModifyAdById(id);
        model.addAttribute("modifyObj",ad);
        return "/content/adModify";
    }


    @RequestMapping()
    public String list(Model model){

        List<Ad> list =  adService.getList();
        model.addAttribute("list",list);
        return "/content/adList";
    }

}
