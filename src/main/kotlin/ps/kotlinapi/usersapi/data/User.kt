package ps.kotlinapi.usersapi.data

import jakarta.persistence.*
import ps.kotlinapi.usersapi.dto.UserDto
import java.util.*

@Entity
@Table(name = "users")
data class User(@Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                var id: Long?,
                var name:String,
                var email: String,
                var created: Date){
    constructor(): this(null,"","",Date())
    constructor(userDto: UserDto) : this(null, userDto.name, userDto.email, Date())

}


