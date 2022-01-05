package net.pgfmc.bot.events;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;

                         // Implements EventListener
public class MessageEvent implements EventListener {
	
	// This is the method that gets called 
	@Override
	public void onEvent(GenericEvent event) {
		// If GenericEvent isn't of type MessageReceivedEvent, don't run this code
		if (!(event instanceof MessageReceivedEvent)) return;
		
		// Cast GenericEvent into MessageReceivedEvent
		MessageReceivedEvent e = (MessageReceivedEvent) event;
		
		// Get the message content as a String :)
		String message = e.getMessage().getContentDisplay();
		
		// Get the author of the message as a User object
		User user = e.getAuthor();
		
		// Don't run this code if the user is a bot
		if (user.isBot()) { return; }
		
		// If NOT channel id "721951670132801600" (#general in BTS), don't run this code
		if (!e.getChannel().getId().equals("721951670132801600")) { return; }
		
		// Get the channel the message came from and send a message back to it!
		e.getChannel().sendMessage("Poop" + user.getName() + " -> " + message).queue(); // queue so it runs when it can
//		e.getMessage().delete().queue(); // Delete the received message, queue so it runs when it can
	}

}
