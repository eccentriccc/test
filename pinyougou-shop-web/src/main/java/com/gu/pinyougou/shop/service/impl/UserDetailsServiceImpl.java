package com.gu.pinyougou.shop.service.impl;

import com.gu.pinyougou.entity.Seller;
import com.gu.pinyougou.sellergoods.service.SellerService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import sun.security.util.Password;

@Component
public class UserDetailsServiceImpl  implements UserDetailsService {
    @Reference
    private SellerService ss;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = null;
        Seller seller = ss.selectById(s);
        if(seller != null && seller.getStatus().equals("1")){
            user = new User(s,seller.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_SELLER"));
        }
        System.out.println(seller);
        return user;
    }
}
