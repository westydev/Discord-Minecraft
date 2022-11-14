package comtr.botcunuz.westy.bot.commands;

import comtr.botcunuz.westy.Main;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CommandManager extends ListenerAdapter {

    public boolean contains(String commandAuthorID, String[] owners) {
        for (String s : owners) {
            if (commandAuthorID.equals(s)) return true;
        }
        return false;
    }
    
    @Override
    synchronized public void onSlashCommandInteraction(@NotNull  SlashCommandInteractionEvent event) {
       String command = event.getName();
       String[] owners = Main.getInstance().getConfig().getStringList("DiscordBot.serverOwnerIDS").toArray(new String[0]);
       String commandAuthorID = event.getMember().getId();


        switch (command) {
            case "reload":
                if(contains(commandAuthorID, owners)) {
                    event.reply("Sunucu Yeniden Başlatılıyor...").queue();
                    Main.getInstance().getServer().reload();
                } else {
                    event.reply("Bunu yapabilmek için yönetici olmalısın").queue();
                }
                break;
            case "stop":
                if(contains(commandAuthorID, owners)) {
                event.reply("Sunucu Durduruluyor...").queue();
                Main.getInstance().getServer().shutdown();
                } else {
                    event.reply("Bunu yapabilmek için yönetici olmalısın").queue();
                }
                break;
        }
    }

    @Override
    synchronized  public void onReady(@NotNull ReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("reload", "Minecraft Sunucusunu Yeniden Başlatır."));
        commandData.add(Commands.slash("stop", "Minecraft Sunucusunu Durdurur."));
        event.getJDA().updateCommands().addCommands(commandData).queue();
    }
}
