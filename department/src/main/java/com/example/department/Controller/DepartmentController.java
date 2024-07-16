Upgraded Java 17 compatible code:

```java
package com.example.department.controller;

import com.example.department.entity.Department;
import com.example.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentRepository repo;

    @PostMapping("/submit")
    public ResponseEntity<Department> submit(@RequestBody Department department) {
        return ResponseEntity.ok().body(repo.save(department));
    }

    @GetMapping("/dept")
    public ResponseEntity<List<Department>> getAllDept() {
        return ResponseEntity.ok().body(repo.findAll());
    }

    @GetMapping("/{did}")
    public ResponseEntity<Department> getById(@PathVariable int did) {
        Optional<Department> department = repo.findById(did);
        if (department.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(department.get());
    }
}
```

Note: The changes made include updating the class names to follow standard Java naming conventions (camel case), renaming the repository class to match the updated package name, and updating the `getById` method to use `Optional`.