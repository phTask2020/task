package com.yjj.cqbarbershopapi.service.impl;

import com.yjj.cqbarbershopapi.dao.VipRepository;
import com.yjj.cqbarbershopapi.entity.Vip;
import com.yjj.cqbarbershopapi.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VipServiceimpl implements VipService {

    @Autowired
    VipRepository vipRepository;

    @Override
    public boolean save(Vip vip) {
        if (findByName(vip)){
            vipRepository.save(vip);
            return true;
        }
        return false;
//        if (vip.getName()!=null){
//            ExampleMatcher matcher = ExampleMatcher.matching().
//                    withIgnorePaths("id").withIgnorePaths("pass").
//                    withIgnorePaths("tel").withIgnorePaths("create_date").
//                    withIgnorePaths("balance").withIgnorePaths("card_no");
//            Example<VIP> example = Example.of(vip, matcher);
//            Optional<VIP> vip1 = vipRepository.findOne(example);
//            if (vip1.isPresent()){
//                return false;
//            }else{
//                vipRepository.save(vip);
//                return true;
//            }
//        }
//        return false;
    }

    @Override
    @CacheEvict(value = "vip",key = "#ids.get(0)",beforeInvocation = true)
    public void deleteById(List<Integer> ids) {
        for (Integer id : ids){
            vipRepository.deleteById(id);
        }
    }

    @Override
    @Cacheable(cacheNames = {"vip"})
    public Vip findById(Integer id) {
       return vipRepository.findById(id).get();
//        return vipRepository.getOne(id);
    }

    @Override
    public Page<Vip> findAll(int page, int size, String username) {
        Vip vip =new Vip();
        vip.setName(username);
        ExampleMatcher matcher = ExampleMatcher.matching().
                withMatcher("name", match->match.startsWith()).
                withIgnorePaths("id").withIgnorePaths("pass");
        Example<Vip> example = Example.of(vip, matcher);
        PageRequest pageRequest = PageRequest.of(page, size , JpaSort.unsafe(Sort.Direction.DESC,"id"));
        return vipRepository.findAll(example,pageRequest);
    }

    @Override
    @CachePut(value = "vip",key = "#vip.id")
    public Vip update(Vip vip) {
        if (vip.getId()!=null){
            int id = vip.getId();
            Vip vip1 = vipRepository.findById(id).get();
            if (vip1==null){
                return null;
            }
            if (findByName(vip)){
                vip1.setName(vip.getName());
            }
            vip1.setTel(vip.getTel());
            vip1.setPass(vip.getPass());
            vipRepository.save(vip1);
            return vip1;
        }
        return null;
    }

    @Caching(
            cacheable = {
                    @Cacheable(value = "vip" ,key = "#vip.name")
            }
    )
    public boolean findByName(Vip vip){
        if (vip.getName()!=null){
            ExampleMatcher matcher = ExampleMatcher.matching().
                    withIgnorePaths("id").withIgnorePaths("pass").
                    withIgnorePaths("tel").withIgnorePaths("create_date").
                    withIgnorePaths("balance").withIgnorePaths("card_no");
            Example<Vip> example = Example.of(vip, matcher);
            Optional<Vip> vip1 = vipRepository.findOne(example);
            if (vip1.isPresent()){
                return false;
            }else{
                return true;
            }
        }
        return false;
    }

}
