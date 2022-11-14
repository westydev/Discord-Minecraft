package comtr.botcunuz.westy.bukkit.events;

import comtr.botcunuz.westy.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.awt.*;

public class PlayerQuit implements Listener {
    public static JDA bot;
    public static Boolean LogUserJoin;
    public static String LogChannel;

    @EventHandler
    public void event(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        bot = Main.getInstance().getBot();

        LogUserJoin = Main.getInstance().getConfig().getBoolean("Logging.PlayerQuit.enabled");
        LogChannel = Main.getInstance().getConfig().getString("Logging.PlayerQuit.channelID");

        if(LogUserJoin == true) {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(Color.red);
            eb.setDescription(player.getName() + " Oyuncusu sunucudan ayrıldı.");

            bot.getTextChannelById(LogChannel).sendMessageEmbeds(eb.build()).queue();
        } else {
            return;
        }
    }
}
