package com.example.sp22_bse_6a_demo.basics

fun main() {
//    val age: Int  = 19;
//    val name: String = "Anwar"
//
//    if(age < 10) {
//        print("You are a choota bacha")
//    } else if(age < 20) {
//        print("You are a darmiyana bacha")
//    } else {
//        print("You are unknown kind of person")
//    }


//    int a = 20;
//    switch(a) {
//        case 5:
//            cout<<"sanbdjs"<<endl;
//            break;
//        case 5:
//            cout<<"sanbdjs"<<endl;
//            break;
//        case 5:
//            cout<<"sanbdjs"<<endl;
//            break;
//        default:
//            cout<<"Not batched"<<endl;
//    }

    val age = 50;
//
    when (age) {
        in 1..9 -> {
            print("You are a choota bacha")
        }
        2 -> {
            print("You are a darmiyana bacha")
        }
        10 -> {
            print("You are of age 10")
        }
        else -> {
            print("You are unknown kind of person")
        }
    }

    val user = User(name = "Ali Usman", userType = UserType.SuperAdmin)

//    when(user.userType) {
//        UserType.Default -> {
            print("User is a ${user.userType}")
//        }
//
//        UserType.Admin -> {
//            print("User is a ${user.userType}")
//        }
//
//        UserType.SuperAdmin -> {
//            print("User is a ${user.userType}")
//        }
//    }
}

data class User (
    val name: String,
    val userType: UserType
)

enum class UserType {
    Default,
    Admin,
    SuperAdmin
}