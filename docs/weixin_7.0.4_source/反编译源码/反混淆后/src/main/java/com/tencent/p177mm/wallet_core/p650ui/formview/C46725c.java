package com.tencent.p177mm.wallet_core.p650ui.formview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C46719b;
import com.tencent.p177mm.wallet_core.p1348a.C24142a;
import com.tenpay.android.wechat.TenpaySecureEditText;

/* renamed from: com.tencent.mm.wallet_core.ui.formview.c */
interface C46725c {

    /* renamed from: com.tencent.mm.wallet_core.ui.formview.c$c */
    public static class C24185c {
        /* renamed from: b */
        public static String m37169b(int i, TenpaySecureEditText tenpaySecureEditText) {
            AppMethodBeat.m2504i(49409);
            String encryptDataWithHash;
            switch (i) {
                case 0:
                    C46719b.dNA();
                    encryptDataWithHash = tenpaySecureEditText.getEncryptDataWithHash(false, C46719b.dNB());
                    AppMethodBeat.m2505o(49409);
                    return encryptDataWithHash;
                case 1:
                    C46719b.dNA();
                    encryptDataWithHash = tenpaySecureEditText.getEncryptDataWithHash(true, C46719b.dNB());
                    AppMethodBeat.m2505o(49409);
                    return encryptDataWithHash;
                case 2:
                    encryptDataWithHash = tenpaySecureEditText.get3DesEncrptData();
                    AppMethodBeat.m2505o(49409);
                    return encryptDataWithHash;
                case 3:
                    encryptDataWithHash = tenpaySecureEditText.get3DesVerifyCode();
                    AppMethodBeat.m2505o(49409);
                    return encryptDataWithHash;
                default:
                    if (tenpaySecureEditText.getText().toString() == null) {
                        encryptDataWithHash = "";
                        AppMethodBeat.m2505o(49409);
                        return encryptDataWithHash;
                    }
                    encryptDataWithHash = tenpaySecureEditText.getText().toString();
                    AppMethodBeat.m2505o(49409);
                    return encryptDataWithHash;
            }
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.formview.c$a */
    public static class C30899a {
        /* renamed from: a */
        public static String m49314a(int i, TenpaySecureEditText tenpaySecureEditText) {
            AppMethodBeat.m2504i(49407);
            String b;
            if (C1853r.m3831YM()) {
                C4990ab.m7418v("MicroMsg.IEncryptDelegate", "hy: is payu. encrypt with payu");
                C30900b c30900b = new C30900b();
                b = C30900b.m49315b(i, tenpaySecureEditText);
                AppMethodBeat.m2505o(49407);
                return b;
            }
            C4990ab.m7418v("MicroMsg.IEncryptDelegate", "hy: is tenpay. encrypt with tenpay");
            C24185c c24185c = new C24185c();
            b = C24185c.m37169b(i, tenpaySecureEditText);
            AppMethodBeat.m2505o(49407);
            return b;
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.formview.c$b */
    public static class C30900b {
        /* renamed from: b */
        public static String m49315b(int i, TenpaySecureEditText tenpaySecureEditText) {
            AppMethodBeat.m2504i(49408);
            tenpaySecureEditText.setSecureEncrypt(new C24142a(i));
            String str = tenpaySecureEditText.get3DesEncrptData();
            AppMethodBeat.m2505o(49408);
            return str;
        }
    }
}
