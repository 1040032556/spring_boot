package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminDao adminDao;
    // alt + enter  enter  enter  把勾去掉
    @Override
    public Admin find(Admin admin) {
        return adminDao.query(admin);
    }

    @Override
    public void add(Admin admin) {
        admin.setId(UUID.randomUUID().toString());
        adminDao.save(admin);
    }
}
