package com.tencent.p177mm.jni.utils;

/* renamed from: com.tencent.mm.jni.utils.UtilsJni */
public class UtilsJni {
    public static native byte[] AesGcmDecrypt(byte[] bArr, byte[] bArr2);

    public static native byte[] AesGcmDecryptWithUncompress(byte[] bArr, byte[] bArr2);

    public static native byte[] AesGcmEncrypt(byte[] bArr, byte[] bArr2);

    public static native byte[] AesGcmEncryptWithCompress(byte[] bArr, byte[] bArr2);

    public static native long CreateHybridEcdhCryptoEngine(int i, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native byte[] DecryptAvatar(byte[] bArr);

    public static native byte[] Ecdh(byte[] bArr, byte[] bArr2);

    public static native byte[] EcdsaSign(byte[] bArr, byte[] bArr2);

    public static native int EcdsaVerify(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native byte[][] GenEcdhKeyPair();

    public static native byte[][] GenEcdsaKeyPair();

    public static native byte[] HKDF(byte[] bArr, byte[] bArr2, String str, int i);

    public static native byte[] HybridEcdhDecrypt(long j, byte[] bArr);

    public static native byte[] HybridEcdhEncrypt(long j, byte[] bArr);

    public static native void ReleaseHybridEcdhCryptoEngine(long j);

    public static native void ResetHybridEcdhCryptoEngine(long j);

    public static native byte[] cryptGenRandom(int i);

    public static native int doEcdsaSHAVerify(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native int doEcdsaVerify(byte[] bArr, byte[] bArr2, byte[] bArr3);
}
