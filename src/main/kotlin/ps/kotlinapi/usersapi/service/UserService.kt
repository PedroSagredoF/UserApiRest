package ps.kotlinapi.usersapi.service

import ps.kotlinapi.usersapi.data.User
import java.util.*

interface UserService {
    fun findById(id:Long): Optional<User>
    fun create(user: User): User
    fun all(): Iterable<User>

}