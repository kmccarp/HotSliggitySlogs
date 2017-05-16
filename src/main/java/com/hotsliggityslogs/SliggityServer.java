package com.hotsliggityslogs;

import org.springframework.boot.builder.SpringApplicationBuilder;

public class SliggityServer extends SliggityApp {
    public static void main(String[] args) {
        new SliggityApp().configure(new SpringApplicationBuilder()).run(args);
    }
}
