package net.pgfmc.bot.events;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateNicknameEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.pgfmc.bot.Main;

public class OldNickname implements EventListener{

	@Override
	public void onEvent(GenericEvent event) {
		// TODO Auto-generated method stub
		if (!(event instanceof GuildMemberUpdateNicknameEvent)) return;
		GuildMemberUpdateNicknameEvent e = (GuildMemberUpdateNicknameEvent) event;
		String oldNickname = e.getOldNickname();
		Main.JDA.getTextChannelById("721951670132801600").sendMessage("Old nickname -> " + oldNickname).queue();
	}

}
