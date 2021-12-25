package dev.hoot.api.packets;

import dev.hoot.api.game.Game;
import net.runelite.api.Client;
import net.runelite.api.packets.ClientPacket;
import net.runelite.api.packets.PacketBufferNode;

public class NPCPackets {
    public static void npcFirstOption(net.runelite.api.NPC npc, boolean run) {
        dev.hoot.api.packets.NPCPackets.queueNPCAction1Packet(npc.getIndex(), run);
    }

    public static void npcSecondOption(net.runelite.api.NPC npc, boolean run) {
        dev.hoot.api.packets.NPCPackets.queueNPCAction2Packet(npc.getIndex(), run);
    }

    public static void npcThirdOption(net.runelite.api.NPC npc, boolean run) {
        dev.hoot.api.packets.NPCPackets.queueNPCAction3Packet(npc.getIndex(), run);
    }

    public static void npcFourthOption(net.runelite.api.NPC npc, boolean run) {
        dev.hoot.api.packets.NPCPackets.queueNPCAction4Packet(npc.getIndex(), run);
    }

    public static void npcFifthOption(net.runelite.api.NPC npc, boolean run) {
        dev.hoot.api.packets.NPCPackets.queueNPCAction5Packet(npc.getIndex(), run);
    }

    public static void npcAction(net.runelite.api.NPC npc, java.lang.String action, boolean run) {
        java.util.List<java.lang.String> actions = npc.getActions();
        int index = actions.indexOf(action);
        switch (index) {
            case 0 :
                dev.hoot.api.packets.NPCPackets.npcFirstOption(npc, run);
                break;
            case 1 :
                dev.hoot.api.packets.NPCPackets.npcSecondOption(npc, run);
                break;
            case 2 :
                dev.hoot.api.packets.NPCPackets.npcThirdOption(npc, run);
                break;
            case 3 :
                dev.hoot.api.packets.NPCPackets.npcFourthOption(npc, run);
                break;
            case 4 :
                dev.hoot.api.packets.NPCPackets.npcFifthOption(npc, run);
                break;
        }
    }

    public static void queueItemOnNpcPacket(int npcIndex, int itemWidgetId, int itemId, int itemSlot, boolean run) {
        Client client = Game.getClient();
        ClientPacket clientPacket = Game.getClientPacket();
        PacketBufferNode packetBufferNode = Game.getClient().preparePacket(clientPacket.OPNPCU(), client.getPacketWriter().getIsaacCipher());
        packetBufferNode.getPacketBuffer().writeShortLE(itemId);
        packetBufferNode.getPacketBuffer().writeByteSub(run ? 1 : 0);
        packetBufferNode.getPacketBuffer().writeShortLE(npcIndex);
        packetBufferNode.getPacketBuffer().writeIntIME(itemWidgetId);
        packetBufferNode.getPacketBuffer().writeShortLE(itemSlot);
        client.getPacketWriter().queuePacket(packetBufferNode);
    }

    public static void queueSpellOnNpcPacket(int npcIndex, int spellWidgetId, boolean run) {
        Client client = Game.getClient();
        ClientPacket clientPacket = Game.getClientPacket();
        PacketBufferNode packetBufferNode = Game.getClient().preparePacket(clientPacket.OPNPCT(), client.getPacketWriter().getIsaacCipher());
        packetBufferNode.getPacketBuffer().writeIntLE(spellWidgetId);
        packetBufferNode.getPacketBuffer().writeShortLE(-1);
        packetBufferNode.getPacketBuffer().writeShort(-1);
        packetBufferNode.getPacketBuffer().writeByteNeg(run ? 1 : 0);
        packetBufferNode.getPacketBuffer().writeShort(npcIndex);
        client.getPacketWriter().queuePacket(packetBufferNode);
    }

    public static void queueNPCAction1Packet(int npcIndex, boolean run) {
        Client client = Game.getClient();
        ClientPacket clientPacket = Game.getClientPacket();
        PacketBufferNode packetBufferNode = Game.getClient().preparePacket(clientPacket.OPNPC1(), client.getPacketWriter().getIsaacCipher());
        packetBufferNode.getPacketBuffer().writeShortAdd(npcIndex);
        packetBufferNode.getPacketBuffer().writeByteAdd(run ? 1 : 0);
        client.getPacketWriter().queuePacket(packetBufferNode);
    }

    public static void queueNPCAction2Packet(int npcIndex, boolean run) {
        Client client = Game.getClient();
        ClientPacket clientPacket = Game.getClientPacket();
        PacketBufferNode packetBufferNode = Game.getClient().preparePacket(clientPacket.OPNPC2(), client.getPacketWriter().getIsaacCipher());
        packetBufferNode.getPacketBuffer().writeByteSub(run ? 1 : 0);
        packetBufferNode.getPacketBuffer().writeShortLE(npcIndex);
        client.getPacketWriter().queuePacket(packetBufferNode);
    }

    public static void queueNPCAction3Packet(int npcIndex, boolean run) {
        Client client = Game.getClient();
        ClientPacket clientPacket = Game.getClientPacket();
        PacketBufferNode packetBufferNode = Game.getClient().preparePacket(clientPacket.OPNPC3(), client.getPacketWriter().getIsaacCipher());
        packetBufferNode.getPacketBuffer().writeShortAddLE(npcIndex);
        packetBufferNode.getPacketBuffer().writeByteAdd(run ? 1 : 0);
        client.getPacketWriter().queuePacket(packetBufferNode);
    }

    public static void queueNPCAction4Packet(int npcIndex, boolean run) {
        Client client = Game.getClient();
        ClientPacket clientPacket = Game.getClientPacket();
        PacketBufferNode packetBufferNode = Game.getClient().preparePacket(clientPacket.OPNPC4(), client.getPacketWriter().getIsaacCipher());
        packetBufferNode.getPacketBuffer().writeShort(npcIndex);
        packetBufferNode.getPacketBuffer().writeByte(run ? 1 : 0);
        client.getPacketWriter().queuePacket(packetBufferNode);
    }

    public static void queueNPCAction5Packet(int npcIndex, boolean run) {
        Client client = Game.getClient();
        ClientPacket clientPacket = Game.getClientPacket();
        PacketBufferNode packetBufferNode = Game.getClient().preparePacket(clientPacket.OPNPC5(), client.getPacketWriter().getIsaacCipher());
        packetBufferNode.getPacketBuffer().writeShortLE(npcIndex);
        packetBufferNode.getPacketBuffer().writeByteSub(run ? 1 : 0);
        client.getPacketWriter().queuePacket(packetBufferNode);
    }
}