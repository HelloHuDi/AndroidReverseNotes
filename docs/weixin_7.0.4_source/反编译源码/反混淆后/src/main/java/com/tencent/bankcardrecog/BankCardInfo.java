package com.tencent.bankcardrecog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.ndk.Encrypt;

public class BankCardInfo {
    public byte[] bitmapData;
    public int bitmapLen = 0;
    private String cardNum = "";
    private int cardNumLen = 0;
    public int height = 0;
    private int[] rectX = new int[20];
    private int[] rectY = new int[20];
    public int width = 0;

    public BankCardInfo(int i, int i2) {
        AppMethodBeat.m2504i(40551);
        this.bitmapData = new byte[(((((int) (0.8d * ((double) i))) * ((int) (0.52d * ((double) i)))) * 3) + 54)];
        AppMethodBeat.m2505o(40551);
    }

    public int getCardNumLen() {
        return this.cardNumLen;
    }

    public void setCardNumLen(int i) {
        this.cardNumLen = i;
    }

    public String getCardNum() {
        AppMethodBeat.m2504i(40552);
        Encrypt encrypt = new Encrypt();
        String desedeEncode = encrypt.desedeEncode(this.cardNum, encrypt.getRandomKey());
        AppMethodBeat.m2505o(40552);
        return desedeEncode;
    }

    public void setCardNum(String str) {
        this.cardNum = str;
    }

    public int[] getRectY() {
        return this.rectY;
    }

    public void setRectY(int[] iArr) {
        this.rectY = iArr;
    }

    public int[] getRectX() {
        return this.rectX;
    }

    public void setRectX(int[] iArr) {
        this.rectX = iArr;
    }
}
