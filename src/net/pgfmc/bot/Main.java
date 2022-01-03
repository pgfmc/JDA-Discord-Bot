package net.pgfmc.bot;

import javax.security.auth.login.LoginException;

import events.MessageEvent;
import events.ReadyEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class Main extends ListenerAdapter {
	
	// JDA, this is essentially your bot
	public static JDA JDA;
	
	// Bot token, DON'T SHARE THIS!
	private static String token = "OTI3Njk2MDUxNDYzMzg5MjQ1.YdN-Rg.JhzeGBoOAAnanTsivNLLhIFrTKM";
	
	// Runs when you double click the jar
	public static void main(String[] args) throws LoginException, InterruptedException {
		// Make a JDABuilder, this will create your bot
		JDABuilder builder = JDABuilder.createDefault(token); // bot token, don't share.
		
		// Register all classes that need to listen to events
		registerEventListeners(builder);
		
		// Build it to your bot (JDA)
		JDA = builder
				// Options and intents
				.setChunkingFilter(ChunkingFilter.ALL)
				.setMemberCachePolicy(MemberCachePolicy.ALL)
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .build();
		
		// Turn your bot on!
		JDA.awaitReady();
	}
	
	private static void registerEventListeners(JDABuilder b)
	{
		b.addEventListeners(new MessageEvent());
		b.addEventListeners(new ReadyEvent());
	}
}