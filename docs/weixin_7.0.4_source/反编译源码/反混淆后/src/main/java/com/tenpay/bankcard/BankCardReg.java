package com.tenpay.bankcard;

import com.tencent.bankcardrecog.BankCardInfo;
import com.tencent.bankcardrecog.BankCardRecog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.ndk.Encrypt;

public class BankCardReg {
    private static final String TAG = "MyTag";

    public static int recognizeBankCardInit(int i, int i2, boolean z) {
        AppMethodBeat.m2504i(49514);
        int recognizeBankCardInit = BankCardRecog.recognizeBankCardInit(i, i2, z);
        AppMethodBeat.m2505o(49514);
        return recognizeBankCardInit;
    }

    public static int recognizeBankCardProcess(byte[] bArr, BankCardInfo bankCardInfo, boolean[] zArr) {
        AppMethodBeat.m2504i(49515);
        int recognizeBankCardProcess = BankCardRecog.recognizeBankCardProcess(bArr, bankCardInfo, zArr);
        AppMethodBeat.m2505o(49515);
        return recognizeBankCardProcess;
    }

    public static String getBankCardSegmentNumber(String str, int i, int[] iArr) {
        AppMethodBeat.m2504i(49516);
        LogUtil.m71577d(TAG, "getBankCardSegmentNumber");
        LogUtil.m71577d(TAG, "cardNum=".concat(String.valueOf(str)));
        Encrypt encrypt = new Encrypt();
        String desedeDecode = encrypt.desedeDecode(str, encrypt.getRandomKey());
        LogUtil.m71577d(TAG, "cardNum=".concat(String.valueOf(desedeDecode)));
        desedeDecode = BankCardRecog.getBankCardSegmentNumber(desedeDecode, i, iArr);
        LogUtil.m71577d(TAG, desedeDecode);
        String desedeEncode = encrypt.desedeEncode(desedeDecode, encrypt.getRandomKey());
        AppMethodBeat.m2505o(49516);
        return desedeEncode;
    }

    public static int recognizeBankCardRelease() {
        AppMethodBeat.m2504i(49517);
        int recognizeBankCardRelease = BankCardRecog.recognizeBankCardRelease();
        AppMethodBeat.m2505o(49517);
        return recognizeBankCardRelease;
    }

    public static int recognizeBankCardGetVersion() {
        AppMethodBeat.m2504i(49518);
        int recognizeBankCardGetVersion = BankCardRecog.recognizeBankCardGetVersion();
        AppMethodBeat.m2505o(49518);
        return recognizeBankCardGetVersion;
    }
}
