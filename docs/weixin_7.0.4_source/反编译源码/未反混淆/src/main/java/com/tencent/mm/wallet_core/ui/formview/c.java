package com.tencent.mm.wallet_core.ui.formview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tenpay.android.wechat.TenpaySecureEditText;

interface c {

    public static class c {
        public static String b(int i, TenpaySecureEditText tenpaySecureEditText) {
            AppMethodBeat.i(49409);
            String encryptDataWithHash;
            switch (i) {
                case 0:
                    com.tencent.mm.wallet_core.b.dNA();
                    encryptDataWithHash = tenpaySecureEditText.getEncryptDataWithHash(false, com.tencent.mm.wallet_core.b.dNB());
                    AppMethodBeat.o(49409);
                    return encryptDataWithHash;
                case 1:
                    com.tencent.mm.wallet_core.b.dNA();
                    encryptDataWithHash = tenpaySecureEditText.getEncryptDataWithHash(true, com.tencent.mm.wallet_core.b.dNB());
                    AppMethodBeat.o(49409);
                    return encryptDataWithHash;
                case 2:
                    encryptDataWithHash = tenpaySecureEditText.get3DesEncrptData();
                    AppMethodBeat.o(49409);
                    return encryptDataWithHash;
                case 3:
                    encryptDataWithHash = tenpaySecureEditText.get3DesVerifyCode();
                    AppMethodBeat.o(49409);
                    return encryptDataWithHash;
                default:
                    if (tenpaySecureEditText.getText().toString() == null) {
                        encryptDataWithHash = "";
                        AppMethodBeat.o(49409);
                        return encryptDataWithHash;
                    }
                    encryptDataWithHash = tenpaySecureEditText.getText().toString();
                    AppMethodBeat.o(49409);
                    return encryptDataWithHash;
            }
        }
    }

    public static class a {
        public static String a(int i, TenpaySecureEditText tenpaySecureEditText) {
            AppMethodBeat.i(49407);
            String b;
            if (r.YM()) {
                ab.v("MicroMsg.IEncryptDelegate", "hy: is payu. encrypt with payu");
                b bVar = new b();
                b = b.b(i, tenpaySecureEditText);
                AppMethodBeat.o(49407);
                return b;
            }
            ab.v("MicroMsg.IEncryptDelegate", "hy: is tenpay. encrypt with tenpay");
            c cVar = new c();
            b = c.b(i, tenpaySecureEditText);
            AppMethodBeat.o(49407);
            return b;
        }
    }

    public static class b {
        public static String b(int i, TenpaySecureEditText tenpaySecureEditText) {
            AppMethodBeat.i(49408);
            tenpaySecureEditText.setSecureEncrypt(new com.tencent.mm.wallet_core.a.a(i));
            String str = tenpaySecureEditText.get3DesEncrptData();
            AppMethodBeat.o(49408);
            return str;
        }
    }
}
