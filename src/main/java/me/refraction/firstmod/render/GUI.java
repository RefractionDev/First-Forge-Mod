package me.refraction.firstmod.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

import java.awt.*;

/**
 * Created by Refraction on 27/10/2017.
 */
public class GUI extends GuiScreen {

    private GuiButton button1;
    private byte byte0 = -16;

    public void initGui() {
        button1 = new GuiButton(1, this.getCenter() - 100, this.getRowPos(4), 200, 20, "Button 1");
        this.buttonList.add(button1);
    }

    @Override
    public void drawScreen(final int x, final int y, final float partialTicks) {
        // dark background
        // super.drawDefaultBackground();
        this.fontRendererObj.drawString("Button 1 Label", this.getCenter(), this.getRowPos(2), this.getChromaColor());
        super.drawScreen(x, y, partialTicks);
    }

    protected void actionPerformed(final GuiButton guiButton) {
        if (guiButton.enabled) {
            switch (guiButton.id) {
                case 1: {
                    guiButton.displayString = "Changed";
                    Minecraft.getMinecraft().thePlayer.addChatMessage((IChatComponent) new ChatComponentText("The button was pressed!"));
                    break;
                }
            }
        }
    }

    public int getRowPos(final int rowNumber) {
        return this.height / 4 + (24 * rowNumber - 24) + this.byte0;
    }

    public int getCenter() {
        return this.width / 2;
    }

    public static int getChromaColor() {
        return Color.HSBtoRGB(System.currentTimeMillis() % 1000L / 1000.0f, 0.8f, 0.8f);
    }

}
