package ps.kotlinapi.usersapi.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import ps.kotlinapi.usersapi.data.User
import ps.kotlinapi.usersapi.dto.UserDto
import ps.kotlinapi.usersapi.service.UserService


@RestController
@RequestMapping("v1/user")
class UserController(@Autowired private val userService: UserService){
    @PostMapping
    fun createUser(@RequestBody userDto: UserDto): ResponseEntity<User>{
       return ResponseEntity.ok(userService.create(User(userDto)))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<User>{
        val userOptional = userService.findById(id)
        if (userOptional.isPresent){
            return ResponseEntity.ok(userOptional.get())
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "User with id $id not found")
        }
    }


    @GetMapping("/items")
    fun findAll():ResponseEntity<Iterable<User>>{
        return ResponseEntity.ok(userService.all())
    }
}


