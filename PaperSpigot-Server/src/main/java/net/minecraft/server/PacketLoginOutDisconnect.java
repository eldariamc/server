//
// Source code recreated from deserialize .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraft.server;

import java.io.IOException;

public class PacketLoginOutDisconnect extends Packet {
	private IChatBaseComponent a;

	public PacketLoginOutDisconnect() {
	}

	public PacketLoginOutDisconnect(IChatBaseComponent var1) {
		this.a = var1;
	}

	public void a(PacketDataSerializer var1) throws IOException {
		this.a = ChatSerializer.a(var1.c(32767));
	}

	public void b(PacketDataSerializer var1) throws IOException {
		var1.a(ChatSerializer.a(this.a));
	}

	@Override
	public void handle(PacketListener packetlistener) {
		this.a((PacketLoginOutListener) packetlistener);
	}

	public void a(PacketLoginOutListener var1) {
		var1.a(this);
	}

	public boolean a() {
		return true;
	}
}
