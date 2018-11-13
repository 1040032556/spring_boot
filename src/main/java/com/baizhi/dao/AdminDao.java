package com.baizhi.dao;

import com.baizhi.entity.Admin;

import java.util.List;

public interface AdminDao {
    Admin query(Admin admin);
    void save(Admin admin);
}
