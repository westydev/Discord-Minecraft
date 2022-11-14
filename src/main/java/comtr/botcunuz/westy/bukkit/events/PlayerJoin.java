package comtr.botcunuz.westy.bukkit.events;

import comtr.botcunuz.westy.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.awt.*;

public class PlayerJoin implements Listener {
    public static JDA bot;
    public static Boolean LogUserJoin;
    public static String LogChannel;
    @EventHandler
    public void event(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        bot = Main.getInstance().getBot();

        LogUserJoin = Main.getInstance().getConfig().getBoolean("Logging.PlayerJoin.enabled");
        LogChannel = Main.getInstance().getConfig().getString("Logging.PlayerJoin.channelID");
        if(LogUserJoin == true) {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(Color.green);
            eb.setDescription(player.getName() + " Oyuncusu sunucuya katıldı.");

            bot.getTextChannelById(LogChannel).sendMessageEmbeds(eb.build()).queue();
        } else {
            return;
        }
    }
}
