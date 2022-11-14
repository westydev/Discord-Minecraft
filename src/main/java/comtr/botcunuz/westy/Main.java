package comtr.botcunuz.westy;

import comtr.botcunuz.westy.bot.commands.CommandManager;
import comtr.botcunuz.westy.bot.events.ReadyEvent;
import comtr.botcunuz.westy.bukkit.events.PlayerJoin;
import comtr.botcunuz.westy.bukkit.events.PlayerQuit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Main extends JavaPlugin {
    private static Main plugin;
    public static JDA bot;
    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        plugin=this;
        getLogger().info( "[BOTCUNUZ.COM.TR-MINECRAFT] Plugin is ready!");
        config.options().copyDefaults(true);
        saveConfig();
        registerBukkitEvents();
        bot = JDABuilder.createDefault(config.getString("DiscordBot.token")).build();
        bot.addEventListener(new ReadyEvent());
        bot.addEventListener(new CommandManager());
    }

    @Override
    public void onDisable() {
        saveConfig();
    }

    private void registerBukkitEvents() {
        this.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
    }

    public static Main getInstance(){
        return plugin;
    }

    public  JDA getBot() {
        return  bot;
    }

}
