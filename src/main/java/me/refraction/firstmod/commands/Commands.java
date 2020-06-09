package me.refraction.firstmod.commands;

import me.refraction.firstmod.FirstMod;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

/**
 * Created by Refraction on 27/10/2017.
 */
public class Commands extends CommandBase {

    private FirstMod mod;

    public Commands(FirstMod mod) {
        this.mod = mod;
    }

    @Override
    public String getCommandName() {
        return "testcommand";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/testcommand";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        Minecraft.getMinecraft().thePlayer.addChatMessage((IChatComponent)new ChatComponentText(this.mod.getMessage()));
        this.mod.openGUI();
    }

    public int getRequiredPermissionLevel() {
        return 0;
    }

    public boolean canCommandSenderUseCommand(final ICommandSender sender) {
        return true;
    }

}
