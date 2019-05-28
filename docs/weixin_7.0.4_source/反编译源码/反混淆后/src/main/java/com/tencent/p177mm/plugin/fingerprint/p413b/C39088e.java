package com.tencent.p177mm.plugin.fingerprint.p413b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.soter.p528d.C4104m;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tencent.mm.plugin.fingerprint.b.e */
public final class C39088e {
    private static boolean isSoLoaded = false;

    public static String getUserId() {
        AppMethodBeat.m2504i(41458);
        String ck = C4995ag.m7428ck(C4995ag.m7428ck(C36391e.getUsername()) + C4995ag.m7428ck(C1427q.m3028LM()));
        AppMethodBeat.m2505o(41458);
        return ck;
    }

    public static String bxC() {
        AppMethodBeat.m2504i(41459);
        String cvT = C4104m.cvT();
        AppMethodBeat.m2505o(41459);
        return cvT;
    }

    public static void bxD() {
        AppMethodBeat.m2504i(41460);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_BOOLEAN_SYNC, Boolean.TRUE);
        AppMethodBeat.m2505o(41460);
    }

    public static boolean bxE() {
        boolean booleanValue;
        AppMethodBeat.m2504i(41461);
        C1720g.m3537RQ();
        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj != null) {
            booleanValue = ((Boolean) obj).booleanValue();
        } else {
            booleanValue = false;
        }
        AppMethodBeat.m2505o(41461);
        return booleanValue;
    }

    public static void bxF() {
        AppMethodBeat.m2504i(41462);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_FINGER_PRINT_SHOW_OPEN_HWFPMANAGER_BOOLEAN_SYNC, Boolean.TRUE);
        AppMethodBeat.m2505o(41462);
    }

    /* renamed from: hs */
    public static void m66514hs(boolean z) {
        AppMethodBeat.m2504i(41463);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_FINGER_PRINT_IS_OPEN_BOOLEAN_SYNC, Boolean.valueOf(z));
        AppMethodBeat.m2505o(41463);
    }

    public static boolean bxG() {
        boolean booleanValue;
        AppMethodBeat.m2504i(41464);
        C1720g.m3537RQ();
        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_FINGER_PRINT_IS_OPEN_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj != null) {
            booleanValue = ((Boolean) obj).booleanValue();
        } else {
            booleanValue = false;
        }
        AppMethodBeat.m2505o(41464);
        return booleanValue;
    }

    /* renamed from: ht */
    public static void m66515ht(boolean z) {
        AppMethodBeat.m2504i(41465);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_FINGER_PRINT_IS_SO_LOAD_SUCCESS_BOOLEAN_SYNC, Boolean.valueOf(z));
        AppMethodBeat.m2505o(41465);
    }

    public static boolean bxH() {
        boolean booleanValue;
        AppMethodBeat.m2504i(41466);
        C1720g.m3537RQ();
        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_FINGER_PRINT_IS_SO_LOAD_SUCCESS_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj != null) {
            booleanValue = ((Boolean) obj).booleanValue();
        } else {
            booleanValue = false;
        }
        AppMethodBeat.m2505o(41466);
        return booleanValue;
    }

    /* renamed from: hu */
    public static void m66516hu(boolean z) {
        isSoLoaded = z;
    }

    public static boolean bxI() {
        return isSoLoaded;
    }

    public static boolean bxs() {
        AppMethodBeat.m2504i(41467);
        if (C39086c.bxj() && C39088e.bxH() && isSoLoaded) {
            AppMethodBeat.m2505o(41467);
            return true;
        }
        AppMethodBeat.m2505o(41467);
        return false;
    }

    public static boolean bxJ() {
        AppMethodBeat.m2504i(41468);
        C4990ab.m7416i("MicroMsg.FingerPrintUtil", "isShowFPSettingGuide");
        if (C39088e.bxG()) {
            C4990ab.m7412e("MicroMsg.FingerPrintUtil", "the fingerprint is open ready");
            AppMethodBeat.m2505o(41468);
            return false;
        } else if (!C39086c.bxj()) {
            C4990ab.m7412e("MicroMsg.FingerPrintUtil", "device is not support");
            AppMethodBeat.m2505o(41468);
            return false;
        } else if (C14241r.cPI().cQi() || C14241r.cPI().cQh()) {
            C4990ab.m7412e("MicroMsg.FingerPrintUtil", "user had not reg wxpay");
            AppMethodBeat.m2505o(41468);
            return false;
        } else if (C14241r.cPI().cQo().cPY()) {
            C39086c c39086c = new C39086c();
            if (!C39086c.bxl()) {
                boolean booleanValue;
                C1720g.m3537RQ();
                Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_FINGER_PRINT_SHOW_OPEN_HWFPMANAGER_BOOLEAN_SYNC, Boolean.FALSE);
                if (obj != null) {
                    booleanValue = ((Boolean) obj).booleanValue();
                } else {
                    booleanValue = false;
                }
                if (!booleanValue) {
                    C4990ab.m7416i("MicroMsg.FingerPrintUtil", "will call showSetFingerPrintGuide()");
                    AppMethodBeat.m2505o(41468);
                    return true;
                }
            }
            AppMethodBeat.m2505o(41468);
            return false;
        } else {
            C4990ab.m7412e("MicroMsg.FingerPrintUtil", "isSupportTouchPay is false");
            AppMethodBeat.m2505o(41468);
            return false;
        }
    }

    /* renamed from: dQ */
    public static final String m66512dQ(Context context) {
        AppMethodBeat.m2504i(41469);
        String str = context.getApplicationContext().getFilesDir().getAbsolutePath() + "/b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec";
        AppMethodBeat.m2505o(41469);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:98:0x022f A:{SYNTHETIC, Splitter:B:98:0x022f} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0088 A:{Catch:{ Exception -> 0x023a }} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0066 A:{SYNTHETIC, Splitter:B:17:0x0066} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A:{SYNTHETIC, Splitter:B:20:0x006b} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0088 A:{Catch:{ Exception -> 0x023a }} */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x022f A:{SYNTHETIC, Splitter:B:98:0x022f} */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01d5 A:{SYNTHETIC, Splitter:B:87:0x01d5} */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01da A:{SYNTHETIC, Splitter:B:90:0x01da} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: dR */
    public static int m66513dR(Context context) {
        int i;
        InputStream inputStream;
        Throwable e;
        AppMethodBeat.m2504i(41470);
        InputStream inputStream2 = null;
        String dQ = C39088e.m66512dQ(context);
        File file = new File(dQ);
        if (file.exists()) {
            String v = C1178g.m2589v(file);
            CharSequence charSequence = "";
            try {
                inputStream2 = context.getAssets().open("b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec");
                if (inputStream2 != null) {
                    charSequence = C1178g.m2585b(inputStream2, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e2) {
                        C4990ab.printErrStackTrace("MicroMsg.FingerPrintUtil", e2, "", new Object[0]);
                    }
                }
            } catch (IOException e22) {
                C4990ab.printErrStackTrace("MicroMsg.FingerPrintUtil", e22, "", new Object[0]);
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e222) {
                        C4990ab.printErrStackTrace("MicroMsg.FingerPrintUtil", e222, "", new Object[0]);
                    }
                }
            } catch (Throwable th) {
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e3) {
                        C4990ab.printErrStackTrace("MicroMsg.FingerPrintUtil", e3, "", new Object[0]);
                    }
                }
                AppMethodBeat.m2505o(41470);
            }
            if (!TextUtils.isEmpty(v) && !TextUtils.isEmpty(charSequence) && v.equals(charSequence)) {
                i = 0;
                inputStream = inputStream2;
            } else if (TextUtils.isEmpty(v) || !TextUtils.isEmpty(charSequence)) {
                i = 1;
                inputStream = inputStream2;
            } else {
                i = 0;
                inputStream = inputStream2;
            }
        } else {
            i = 1;
            inputStream = inputStream2;
        }
        if (i != 0) {
            FileOutputStream fileOutputStream;
            try {
                inputStream = context.getAssets().open("b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec");
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                            C4990ab.printErrStackTrace("MicroMsg.FingerPrintUtil", e4, "", new Object[0]);
                            C4990ab.m7412e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + e4.getMessage());
                        }
                    }
                    try {
                        fileOutputStream.close();
                        i = 0;
                    } catch (IOException e42) {
                        C4990ab.printErrStackTrace("MicroMsg.FingerPrintUtil", e42, "", new Object[0]);
                        C4990ab.m7412e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + e42.getMessage());
                        i = 0;
                    }
                } catch (Exception e5) {
                    e = e5;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.FingerPrintUtil", e, "", new Object[0]);
                        C4990ab.m7412e("MicroMsg.FingerPrintUtil", "copyTAFromAssets Exception " + e.getMessage());
                        if (inputStream != null) {
                        }
                        if (fileOutputStream == null) {
                        }
                        if (Runtime.getRuntime().exec("chmod 777 ".concat(String.valueOf(dQ))).waitFor() == 0) {
                        }
                        AppMethodBeat.m2505o(41470);
                        return i;
                    } catch (Throwable th2) {
                        e = th2;
                        if (inputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        AppMethodBeat.m2505o(41470);
                        throw e;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                fileOutputStream = null;
                C4990ab.printErrStackTrace("MicroMsg.FingerPrintUtil", e, "", new Object[0]);
                C4990ab.m7412e("MicroMsg.FingerPrintUtil", "copyTAFromAssets Exception " + e.getMessage());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e422) {
                        C4990ab.printErrStackTrace("MicroMsg.FingerPrintUtil", e422, "", new Object[0]);
                        C4990ab.m7412e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + e422.getMessage());
                    }
                }
                if (fileOutputStream == null) {
                    try {
                        fileOutputStream.close();
                        i = -1;
                    } catch (IOException e4222) {
                        C4990ab.printErrStackTrace("MicroMsg.FingerPrintUtil", e4222, "", new Object[0]);
                        C4990ab.m7412e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + e4222.getMessage());
                        i = -1;
                    }
                } else {
                    i = -1;
                }
                if (Runtime.getRuntime().exec("chmod 777 ".concat(String.valueOf(dQ))).waitFor() == 0) {
                }
                AppMethodBeat.m2505o(41470);
                return i;
            } catch (Throwable th3) {
                e = th3;
                fileOutputStream = null;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2222) {
                        C4990ab.printErrStackTrace("MicroMsg.FingerPrintUtil", e2222, "", new Object[0]);
                        C4990ab.m7412e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + e2222.getMessage());
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e32) {
                        C4990ab.printErrStackTrace("MicroMsg.FingerPrintUtil", e32, "", new Object[0]);
                        C4990ab.m7412e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + e32.getMessage());
                    }
                }
                AppMethodBeat.m2505o(41470);
                throw e;
            }
            try {
                if (Runtime.getRuntime().exec("chmod 777 ".concat(String.valueOf(dQ))).waitFor() == 0) {
                    C4990ab.m7416i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                } else {
                    C4990ab.m7412e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                }
            } catch (Exception e7) {
                C4990ab.m7416i("MicroMsg.FingerPrintUtil", "chmod wechat ta file Exception " + e7.getMessage());
            }
        } else {
            i = 0;
        }
        AppMethodBeat.m2505o(41470);
        return i;
    }
}
