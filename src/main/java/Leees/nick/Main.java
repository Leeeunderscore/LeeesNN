package Leees.nick;

import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.YELLOW + "LeeesNN " + ChatColor.DARK_AQUA + "You must be a player to execute this command");
            return false;
        } else {
            Player player = (Player)sender;
            if (!cmd.getName().equalsIgnoreCase("LeeesNN")) {
                return false;
            } else if (args.length == 0) {
                player.sendMessage(ChatColor.YELLOW + "LeeesNN " + ChatColor.DARK_AQUA + "Type a nickname - /nick <nickname> or /nick reset to reset");
                return true;
            } else {
                String nick = "";
                String[] arrayOfString = args;
                int j = args.length;

                for(int i = 0; i < j; ++i) {
                    String arg = arrayOfString[i];
                    nick = nick + arg;
                }

                if (nick.equals("reset")) {
                    player.kickPlayer(ChatColor.GOLD + "Nickname has been reset.");
                    this.getConfig().set(player.getName(), "k e k");
                    this.saveConfig();
                    this.reloadConfig();
                    return true;
                } else if (player.hasPermission("Leee.nick") && nick.length() < 20) {
                    nick = nick.replaceAll("Leeeunderscore", "im-gay-bro");
                    nick = nick.replaceAll("Leeeupperscore", "im-gay-bro");
                    nick = nick.replaceAll("Leeeforwardslash", "im-gay-bro");
                    nick = nick.replaceAll("Leeebackslash", "im-gay-bro");
                    nick = nick.replaceAll("Leeeleftarrow", "im-gay-bro");
                    nick = nick.replaceAll("Leee_", "im-gay-bro");
                    nick = nick.replaceAll("@everyone", "" + ChatColor.AQUA + "im-rarted-bro");
                    nick = nick.replaceAll("@here", "" + ChatColor.DARK_AQUA + "im-rarted-bro");
                    player.setDisplayName(nick);
                    this.getConfig().set(player.getName(), nick);
                    this.saveConfig();
                    player.sendMessage(ChatColor.YELLOW + "LeeesNN " + ChatColor.DARK_AQUA + "Your nickname has been successfully set (" + nick + ChatColor.DARK_AQUA + ")");
                    return true;
                } else if (!player.hasPermission("Leee.nick")) {
                    player.sendMessage(ChatColor.YELLOW + "LeeesNN " + ChatColor.DARK_AQUA + "You need to donate to use this - /buy");
                    return true;
                } else {
                    player.sendMessage(ChatColor.YELLOW + "LeeesNN " + ChatColor.DARK_AQUA + "Error please contact server owner / admin");
                    return true;
                }
            }
        }
    }

    public boolean onCmmand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.YELLOW + "LeeesNN " + ChatColor.DARK_AQUA + "You must be a player to execute this command");
            return false;
        } else {
            Player player = (Player)sender;
            if (cmd.getName().equalsIgnoreCase("resetnick")) {
                player.sendMessage("dsfjsdlk");
                player.kickPlayer(ChatColor.YELLOW + "LeeesNN " + ChatColor.DARK_AQUA + "Nickname has been reset.");
                this.getConfig().set(player.getName(), "k e k");
                this.saveConfig();
                this.reloadConfig();
                return true;
            } else {
                return true;
            }
        }
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        if (this.getConfig().getString(e.getPlayer().getName()) != null) {
            if (this.getConfig().getString(e.getPlayer().getName()).equals("k e k")) {
                return;
            }

            player.setDisplayName(this.getConfig().getString(player.getName()));
            Logger.getLogger("Minecraft").info(this.getConfig().getStringList(player.getName()).toString());
        }

    }
}
