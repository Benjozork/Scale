package me.codevision.scale.handlers;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Allows for a simple implementation of a customizable message system.<br/>
 *
 * {@link MessageHandler#setConfiguration(FileConfiguration)} must be used to provide a<br/>
 * valid {@link FileConfiguration} source for the messages to be taken from. A {@code prefix}<br/>
 * field is required in said configuration in order to display a prefix before every message.
 *
 * @author Benjozork
 */
public class MessageHandler {

    private static FileConfiguration configuration;

    /**
     * Returns a message with the given identifier, with appropriate colors using {@code &}<br/>
     * and a prefix that is located in the {@code prefix} field of the configuration provided with<br/>
     * {@link MessageHandler#setConfiguration(FileConfiguration)}.
     *
     * @param id the identifier of the message
     * @return the message, along with a prefix and appropriate color codes
     */
    public static String getMessage(String id) {
        return ChatColor.translateAlternateColorCodes('&', configuration.getString("prefix") + " " + configuration.getString(id));
    }

    /**
     * Returns a message with the given identifier, with appropriate colors using {@code &}.<br/>
     *
     * @param id the identifier of the message
     * @return the message, along appropriate color codes
     */
    public static String getRawMessage(String id) {
        return ChatColor.translateAlternateColorCodes('&', configuration.getString(id));
    }


    /**
     * Sets the internal {@link FileConfiguration} object from which the messages are taken<br/>
     * by {@link MessageHandler#getMessage(String)} and {@link MessageHandler#getRawMessage(String)}.
     *
     * @param configuration the {@link FileConfiguration to be used}
     */
    public static void setConfiguration(FileConfiguration configuration) {
        MessageHandler.configuration = configuration;
    }

}