package net.pgfmc.bot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.pgfmc.bot.events.MessageEvent;
import net.pgfmc.bot.events.ReadyEvent;

public class Main extends ListenerAdapter {
	
	// JDA, this is essentially your bot
	public static JDA JDA;
	
	// Runs when you double click the jar
	public static void main(String[] args) throws LoginException, InterruptedException {
		// We store the token locally so no one steals our bot
		String token = grabToken();
		
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
	
	/**
	 * Register event listeners here :)
	 * 
	 * @param b JDABuilder object
	 */
	private static void registerEventListeners(JDABuilder b)
	{
		b.addEventListeners(new MessageEvent());
		b.addEventListeners(new ReadyEvent());
	}
	
	/**
	 * Get the bot token from a local file
	 * 
	 * We do this so no one steals our bot token from the source code
	 * @return
	 */
	private static String grabToken()
	{
		String token = "";
		try {
			// Create a file with a given directory
			File tokenFile = new File("C:" + File.separator + "Discord-JDA-Bot-TOKEN" + File.separator + "Discord-JDA-Bot-TOKEN.txt");
			tokenFile.mkdirs(); // Make directory
			tokenFile.createNewFile(); // Make file
			
			// Read the file
			Scanner scanner = new Scanner(tokenFile);
			
			while (scanner.hasNextLine())
			{
				// token variable now has your bot token
				token = scanner.nextLine();
			}
			
			scanner.close();
		} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		return token;
	}
}