package com.p123qq.p803wx.voice.embed.recognizer;

/* renamed from: com.qq.wx.voice.embed.recognizer.GrammarNative */
public class GrammarNative {
    public static native int begin();

    public static native int end();

    public static native int getResult(Grammar grammar);

    public static native int init(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native int recognize(byte[] bArr, int i);

    public static native int update(byte[] bArr);
}
