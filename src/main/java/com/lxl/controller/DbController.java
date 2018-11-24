package com.lxl.controller;

import com.lxl.entity.TStudent;
import com.lxl.service.TStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/db")
public class DbController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TStudentService tStudentService;

//    @Autowired
//    private TStudentMapper tStudentDao;


    @GetMapping("/gettime")
    @ResponseBody
    public Map<String, Object> getTime() {


        String sql = "SELECT now() FROM dual";
        RowMapper mapper = new ColumnMapRowMapper();

        List<Map<String, Object>> st = jdbcTemplate.query(sql, mapper);

        System.out.printf(st.toString());

        return st.get(0);
    }


    @GetMapping("/getStudentDetail")
    @ResponseBody
    public TStudent getStudentDetail() {

       return  tStudentService.getById(1);
    }


}
