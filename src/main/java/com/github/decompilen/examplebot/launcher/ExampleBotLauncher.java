package com.github.decompilen.examplebot.launcher;

import com.github.decompilen.examplebot.ExampleBot;

public class ExampleBotLauncher {

    public static void main(String[] args) {
        ExampleBot exampleBot = new ExampleBot();
        exampleBot.run();
        Runtime.getRuntime().addShutdownHook(new Thread(exampleBot::close));
    }
}
