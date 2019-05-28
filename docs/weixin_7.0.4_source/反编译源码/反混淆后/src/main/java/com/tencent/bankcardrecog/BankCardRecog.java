package com.tencent.bankcardrecog;

public class BankCardRecog {
    public static native String getBankCardSegmentNumber(String str, int i, int[] iArr);

    public static native int recognizeBankCardGetVersion();

    public static native int recognizeBankCardInit(int i, int i2, boolean z);

    public static native int recognizeBankCardProcess(byte[] bArr, BankCardInfo bankCardInfo, boolean[] zArr);

    public static native int recognizeBankCardRelease();
}
