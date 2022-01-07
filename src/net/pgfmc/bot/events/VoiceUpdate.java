package net.pgfmc.bot.events;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.guild.voice.GenericGuildVoiceUpdateEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.pgfmc.bot.Main;

public class VoiceUpdate implements EventListener {
	
	@Override
	public void onEvent(GenericEvent event) {
		if (!(event instanceof GenericGuildVoiceUpdateEvent)) return;
		GenericGuildVoiceUpdateEvent e = (GenericGuildVoiceUpdateEvent) event;
		String member = e.getMember().getUser().getName();
		
		if (event instanceof GuildVoiceJoinEvent)
		{ 
		  String channelName = e.getChannelJoined().getName();
		  Main.JDA.getTextChannelById("721951670132801596").sendMessage(member + "has left" + channelName);
		} else if (event instanceof GuildVoiceLeaveEvent)
		{
		  String channelName = e.getChannelLeft().getName();
		  Main.JDA.getTextChannelById("721951670132801596").sendMessage(member + "has joined" + channelName);
		}
	}
}
