package edu.cuhksz.swaggergenerator.controller;

import java.util.Collections;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.cuhksz.swaggergenerator.entity.param.UserParam;
import edu.cuhksz.swaggergenerator.entity.vo.AddressVo;
import edu.cuhksz.swaggergenerator.entity.vo.UserVo;

/**
 * @author pdai
 */
@Api(value = "User Interfaces", tags = "User Interfaces")
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * http://localhost:8080/user/add .
     *
     * @param userParam user param
     * @return user
     */
    @ApiOperation("Add User")
    @ApiImplicitParam(name = "userParam", type = "body", dataTypeClass = UserParam.class, required = true)
    @PostMapping("add")
    public ResponseEntity<String> add(@RequestBody UserParam userParam) {
        return ResponseEntity.ok("success");
    }

    /**
     * http://localhost:8080/user/list .
     *
     * @return user list
     */
    @ApiOperation("Query User List")
    @GetMapping("list")
    public ResponseEntity<List<UserVo>> list() {
        List<UserVo> userVoList = Collections.singletonList(UserVo.builder().name("dai").age(18)
                .address(AddressVo.builder().city("SZ").zipcode("10001").build()).build());
        return ResponseEntity.ok(userVoList);
    }
}
