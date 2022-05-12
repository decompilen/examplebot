package com.github.decompilen.examplebot;

import java.io.Closeable;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class ExampleBot implements Runnable, Closeable {

    private JDA jda;

    @Override
    public void run() {
        JDABuilder jdaBuilder = JDABuilder.createLight("token");
        
        for (GatewayIntent intent : GatewayIntent.values()) {
            jdaBuilder.enableIntents(intent);
        }

        jdaBuilder.setMemberCachePolicy(MemberCachePolicy.ALL);
        jdaBuilder.setActivity(Activity.competing("against the Entity!"));
    
        try {
            this.jda = jdaBuilder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        jda.shutdown();
    }
}
