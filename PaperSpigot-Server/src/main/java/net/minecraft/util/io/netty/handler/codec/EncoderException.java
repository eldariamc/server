//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraft.util.io.netty.handler.codec;

public class EncoderException extends CodecException {
	private static final long serialVersionUID = -5086121160476476774L;

	public EncoderException() {
	}

	public EncoderException(String message, Throwable cause) {
		super(message, cause);
		System.err.println("[Dabsunters] EncoderException -> Throwable + '" + message + "'");
		cause.printStackTrace();
	}

	public EncoderException(String message) {
		super(message);
		System.err.println("[Dabsunter] EncoderException -> '" + message + "'");
	}

	public EncoderException(Throwable cause) {
		super(cause);
		System.err.println("[Dabsunter] EncoderException -> Throwable");
		cause.printStackTrace();
	}
}
