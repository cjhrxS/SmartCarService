package ua.ita.smartcarservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.ita.smartcarservice.entity.RoleEntity;
import ua.ita.smartcarservice.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping()
    public ResponseEntity<?> createRole(@RequestBody RoleEntity roleEntity) {

        roleService.createRole(roleEntity);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RoleEntity>> getAll() {

        List<RoleEntity> roles = roleService.findAll();

        return new ResponseEntity<List<RoleEntity>>(roles, HttpStatus.OK);


    }

    @GetMapping("{roleId}")
    public ResponseEntity<RoleEntity> findRoleById(@PathVariable("roleId") Long id) {

        RoleEntity role = roleService.findById(id);

        return new ResponseEntity<RoleEntity>(role, HttpStatus.OK);
    }

    @PostMapping("{roleId}")
    public ResponseEntity<?> updateRole(@PathVariable("roleId") Long id, RoleEntity roleEntity) {

        roleService.updateRoleById(id, roleEntity);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("{roleId}")
    public ResponseEntity<?> deleteRoleById(@PathVariable("roleId") Long id, RoleEntity roleEntity) {

        roleService.deleteById(id, roleEntity);

        return new ResponseEntity<Void>(HttpStatus.OK);

    }


}
