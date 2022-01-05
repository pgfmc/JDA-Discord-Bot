package net.pgfmc.bot.events;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.pgfmc.bot.Main;

public class ReadyEvent implements EventListener {
	
	@Override
	public void onEvent(GenericEvent event) {
		// If the event isn't ReadyEvent, don't run this code
		if (!(event instanceof ReadyEvent)) { return; }
		
		// Get a guild by it's ID
		Guild guild = Main.JDA.getGuildById("721951670132801596");
		
		// Get the guild's system channel and send a message
		// The system channel is defined in the server settings (in Discord)
		guild.getSystemChannel().sendMessage("Bot has been turned on!");
	}

}
