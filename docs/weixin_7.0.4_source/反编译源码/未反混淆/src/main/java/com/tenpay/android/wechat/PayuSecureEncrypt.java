package com.tenpay.android.wechat;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class PayuSecureEncrypt implements ISecureEncrypt {
    protected static final String CHARSET = "UTF-8";
    public static final String ENCRYPT_VERSION_DEFAULT = "10";
    public static final String ENCRYPT_VERSION_HASH = "30";
    private static final String RSA_E_KEY = "10001";
    private static final String RSA_N_KEY = "b2f690b296060c441416f269e2eea0e8279e139b43c7e9e7d16a2bed62cba4e9456a5071154e8929a016c70ec64a05c47e4854b933ca85ada97f75335ff3de9aa998c1f5b63b14e0bbea3392fd159c53e5a2b14b0698e1061e9410380565206f5427681f845f1932a42320646ab69a41a1becdb083048d8d045ce5f4aee88e35";
    protected int mEncrptType = 0;

    public interface EncrptType {
        public static final int CARD_NUMBER = 50;
        public static final int CVV = 30;
        public static final int DEFAULT = 0;
        public static final int HASHED_PASSWORD = -10;
        public static final int HASHED_SECRET_ANSWER = -20;
        public static final int PASSWORD = 20;
        public static final int SECRET_ANSWER = 40;
        public static final int VERIFY_CODE = 60;
    }

    public String encryptPasswdWithRSA2048(boolean z, String str, String str2) {
        return "";
    }

    public String encryptPasswd(boolean z, String str, String str2) {
        return null;
    }

    public String desedeEncode(String str, String str2) {
        return null;
    }

    public String desedeVerifyCode(String str, String str2) {
        return null;
    }

    public String getRsaNKey() {
        AppMethodBeat.i(49459);
        String str = new String(RSA_N_KEY);
        AppMethodBeat.o(49459);
        return str;
    }

    public String getRsaEKey() {
        AppMethodBeat.i(49460);
        String str = new String(RSA_E_KEY);
        AppMethodBeat.o(49460);
        return str;
    }

    public void setEncryptType(int i) {
        this.mEncrptType = i;
    }
}
