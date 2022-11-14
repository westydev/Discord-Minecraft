package comtr.botcunuz.westy.bot.events;

import comtr.botcunuz.westy.Main;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.hooks.EventListener;

public class ReadyEvent implements EventListener {

	@Override
	public void onEvent(GenericEvent event) {
		 if (event instanceof ReadyEvent) {
			 Main.getInstance().getServer().getLogger().info("[BOTCUNUZ.COM.TR-MINECRAFT] Bot is ready!");
   }
  }
}

