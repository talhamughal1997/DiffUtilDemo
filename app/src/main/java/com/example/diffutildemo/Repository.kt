package com.example.diffutildemo

object Repository {

     val users = listOf(
        User(1, "Jack Nicholson", 10, 1937),
        User(2, "Marlon Brando", 9, 1924),
        User(3, "Robert De Niro", 8, 1943),
        User(4, "Al Pacino", 7, 1940),
        User(5, "Daniel Day-Lewis", 6, 1957),
        User(6, "Dustin Hoffman", 5, 1937),
        User(7, "Tom Hanks", 4, 1956),
        User(8, "Anthony Hopkins", 3, 1937),
        User(9, "Paul Newman", 2, 1925),
        User(10, "Denzel Washington", 1, 1954)
    )

    val userSortedByRating by lazy {  users.sortedByDescending { it.rating }}

    val userSortedByName by lazy { users.sortedBy { it.name }}

    val userSortedByYearOfBirth by lazy { users.sortedBy { it.yearOfBirth }}
}