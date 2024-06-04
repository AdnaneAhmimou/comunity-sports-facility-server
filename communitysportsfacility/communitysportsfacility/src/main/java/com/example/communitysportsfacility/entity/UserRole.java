//package com.example.communitysportsfacility.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//
//@Entity
//@NoArgsConstructor
//@Getter
//@Setter
//public class UserRole {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Enumerated(EnumType.STRING) // Add this line
//    private RoleType  role;
//
//
//}

package com.example.communitysportsfacility.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType role;
}
