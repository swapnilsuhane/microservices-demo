package com.example.jedisdemo.test;

import redis.clients.jedis.Jedis;

import java.util.HashMap;

public class RedisJava {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connected Successfully");
        System.out.println("Ping: "+jedis.ping());

        //String
        System.out.println("String..");
        jedis.set("name", "reyom");
        String nm = jedis.get("name");
        System.out.println("name: "+nm);

        //List
        //while(jedis.lpop("number")!=null){
        //
        //}
        jedis.lpush("number", "1", "2", "3", "4", "5");
        jedis.rpush("number", "10");

        jedis.lrange("number", 0, 10).forEach(System.out::println);

        //Hash
        System.out.println("\nHash..");

        jedis.hset("employee", "name", "swapnil");
        jedis.hset("employee", "age", "25");
        jedis.hset("employee", "phone", "94343322");

        HashMap<String, String> map = new HashMap<>();
        map.put("name", "madan");
        map.put("age", "22");
        map.put("phone", "9434333");
        jedis.hmset("employee2", map);

        System.out.println("employee");
        jedis.hgetAll("employee").forEach((k,v) -> System.out.println(k + " - " + v));
        jedis.hgetAll("employee2").forEach((k,v) -> System.out.println(k + " - " + v));

        //Set
        System.out.println("\nSet..");
        jedis.sadd("colors", "yellow", "red", "green", "blue");
        jedis.smembers("colors").forEach(System.out::println);
        System.out.println("scard: " + jedis.scard("colors"));

        //Sorted Set
        System.out.println("\nSorted Set..");
        jedis.zadd("sizes", 10, "small");
        jedis.zadd("sizes", 20, "medium");
        jedis.zadd("sizes", 30, "large");
        jedis.zrange("sizes", 0, 2).forEach(System.out::println);


        jedis.save();

    }
}
