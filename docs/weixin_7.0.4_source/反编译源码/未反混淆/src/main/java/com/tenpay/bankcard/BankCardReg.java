package com.tenpay.bankcard;

import com.tencent.bankcardrecog.BankCardInfo;
import com.tencent.bankcardrecog.BankCardRecog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.ndk.Encrypt;

public class BankCardReg {
    private static final String TAG = "MyTag";

    public static int recognizeBankCardInit(int i, int i2, boolean z) {
        AppMethodBeat.i(49514);
        int recognizeBankCardInit = BankCardRecog.recognizeBankCardInit(i, i2, z);
        AppMethodBeat.o(49514);
        return recognizeBankCardInit;
    }

    public static int recognizeBankCardProcess(byte[] bArr, BankCardInfo bankCardInfo, boolean[] zArr) {
        AppMethodBeat.i(49515);
        int recognizeBankCardProcess = BankCardRecog.recognizeBankCardProcess(bArr, bankCardInfo, zArr);
        AppMethodBeat.o(49515);
        return recognizeBankCardProcess;
    }

    public static String getBankCardSegmentNumber(String str, int i, int[] iArr) {
        AppMethodBeat.i(49516);
        LogUtil.d(TAG, "getBankCardSegmentNumber");
        LogUtil.d(TAG, "cardNum=".concat(String.valueOf(str)));
        Encrypt encrypt = new Encrypt();
        String desedeDecode = encrypt.desedeDecode(str, encrypt.getRandomKey());
        LogUtil.d(TAG, "cardNum=".concat(String.valueOf(desedeDecode)));
        desedeDecode = BankCardRecog.getBankCardSegmentNumber(desedeDecode, i, iArr);
        LogUtil.d(TAG, desedeDecode);
        String desedeEncode = encrypt.desedeEncode(desedeDecode, encrypt.getRandomKey());
        AppMethodBeat.o(49516);
        return desedeEncode;
    }

    public static int recognizeBankCardRelease() {
        AppMethodBeat.i(49517);
        int recognizeBankCardRelease = BankCardRecog.recognizeBankCardRelease();
        AppMethodBeat.o(49517);
        return recognizeBankCardRelease;
    }

    public static int recognizeBankCardGetVersion() {
        AppMethodBeat.i(49518);
        int recognizeBankCardGetVersion = BankCardRecog.recognizeBankCardGetVersion();
        AppMethodBeat.o(49518);
        return recognizeBankCardGetVersion;
    }
}
