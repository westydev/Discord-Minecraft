package comtr.botcunuz.westy;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Main extends JavaPlugin {
    private static Main plugin;
	FileConfiguration config = getConfig();
	
	@Override
	public void onEnable() {
         plugin=this;
		 getLogger().info("[BOTCUNUZ.COM.TR-MINECRAFT] Plugin is ready!");
		 config.options().copyDefaults(true);
		 saveConfig();
		 JDA bot = JDABuilder.createDefault(config.getString("DiscordBot.token")).build();
	}
	
	@Override
	public void onDisable() {
		 saveConfig();
	}
	
	
	  public static Main getInstance(){
	        return plugin;
	}
}
