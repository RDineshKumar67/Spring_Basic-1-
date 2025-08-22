package com.example.hello_spring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
 import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}
@RestController
@RequestMapping("/users")
class HelloController{
    // @GetMapping("/get")
    // public String hello(){
	// 	return "Hello Thor";
	// }  
	// @PostMapping("/post")
    // public String posthello(){
	// 	return "post Thor";
	// }
	// @PutMapping("/put")
    // public String puthello(){
	// 	return "put Thor";
	// }
	// @DeleteMapping("/delete")
    // public String deletehello(){
	// 	return "delete Thor";
	// }
	Map<Integer,User> users=new HashMap<>();
    public int currentId=1;

	@PostMapping
	public User creatUser(@RequestBody User user){
		user.id=currentId++;
		users.put(user.id,user);
		return user;
	}
	@GetMapping("/{id}")
	public User getUser(@PathVariable int id){
		return users.get(id);
	}
	@PutMapping("/{id}")
	public User upadateUser(@PathVariable int id,@RequestBody User user){
		if(users.containsKey(id)){
			user.id=id;
		users.put(user.id,user);
		}
		return null;
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable int id){
		return users.remove(id) !=null ?"User deleted":"User not found";
	}
}}





class User{
	public int id;
	public String name;
	public String email;
}

    // public int getId(){
	// 	return id;
	// }
	// public void setId(int id){
	// 	this.id=id;
	// }
	// public String getName(){
	// 	return name;
	// }
    // public void setName(String name){
	// 	this.name=name;
	// }
	// public String getemail(){
	// 	return email;
	// }
    // public void setemail(String email){
	// 	this.email=email;
	// }