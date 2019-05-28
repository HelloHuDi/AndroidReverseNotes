package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.ac.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class e {
    private static boolean isSoLoaded = false;

    public static String getUserId() {
        AppMethodBeat.i(41458);
        String ck = ag.ck(ag.ck(com.tencent.mm.wallet_core.ui.e.getUsername()) + ag.ck(q.LM()));
        AppMethodBeat.o(41458);
        return ck;
    }

    public static String bxC() {
        AppMethodBeat.i(41459);
        String cvT = m.cvT();
        AppMethodBeat.o(41459);
        return cvT;
    }

    public static void bxD() {
        AppMethodBeat.i(41460);
        g.RQ();
        g.RP().Ry().set(a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_BOOLEAN_SYNC, Boolean.TRUE);
        AppMethodBeat.o(41460);
    }

    public static boolean bxE() {
        boolean booleanValue;
        AppMethodBeat.i(41461);
        g.RQ();
        Object obj = g.RP().Ry().get(a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj != null) {
            booleanValue = ((Boolean) obj).booleanValue();
        } else {
            booleanValue = false;
        }
        AppMethodBeat.o(41461);
        return booleanValue;
    }

    public static void bxF() {
        AppMethodBeat.i(41462);
        g.RQ();
        g.RP().Ry().set(a.USERINFO_FINGER_PRINT_SHOW_OPEN_HWFPMANAGER_BOOLEAN_SYNC, Boolean.TRUE);
        AppMethodBeat.o(41462);
    }

    public static void hs(boolean z) {
        AppMethodBeat.i(41463);
        g.RQ();
        g.RP().Ry().set(a.USERINFO_FINGER_PRINT_IS_OPEN_BOOLEAN_SYNC, Boolean.valueOf(z));
        AppMethodBeat.o(41463);
    }

    public static boolean bxG() {
        boolean booleanValue;
        AppMethodBeat.i(41464);
        g.RQ();
        Object obj = g.RP().Ry().get(a.USERINFO_FINGER_PRINT_IS_OPEN_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj != null) {
            booleanValue = ((Boolean) obj).booleanValue();
        } else {
            booleanValue = false;
        }
        AppMethodBeat.o(41464);
        return booleanValue;
    }

    public static void ht(boolean z) {
        AppMethodBeat.i(41465);
        g.RQ();
        g.RP().Ry().set(a.USERINFO_FINGER_PRINT_IS_SO_LOAD_SUCCESS_BOOLEAN_SYNC, Boolean.valueOf(z));
        AppMethodBeat.o(41465);
    }

    public static boolean bxH() {
        boolean booleanValue;
        AppMethodBeat.i(41466);
        g.RQ();
        Object obj = g.RP().Ry().get(a.USERINFO_FINGER_PRINT_IS_SO_LOAD_SUCCESS_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj != null) {
            booleanValue = ((Boolean) obj).booleanValue();
        } else {
            booleanValue = false;
        }
        AppMethodBeat.o(41466);
        return booleanValue;
    }

    public static void hu(boolean z) {
        isSoLoaded = z;
    }

    public static boolean bxI() {
        return isSoLoaded;
    }

    public static boolean bxs() {
        AppMethodBeat.i(41467);
        if (c.bxj() && bxH() && isSoLoaded) {
            AppMethodBeat.o(41467);
            return true;
        }
        AppMethodBeat.o(41467);
        return false;
    }

    public static boolean bxJ() {
        AppMethodBeat.i(41468);
        ab.i("MicroMsg.FingerPrintUtil", "isShowFPSettingGuide");
        if (bxG()) {
            ab.e("MicroMsg.FingerPrintUtil", "the fingerprint is open ready");
            AppMethodBeat.o(41468);
            return false;
        } else if (!c.bxj()) {
            ab.e("MicroMsg.FingerPrintUtil", "device is not support");
            AppMethodBeat.o(41468);
            return false;
        } else if (r.cPI().cQi() || r.cPI().cQh()) {
            ab.e("MicroMsg.FingerPrintUtil", "user had not reg wxpay");
            AppMethodBeat.o(41468);
            return false;
        } else if (r.cPI().cQo().cPY()) {
            c cVar = new c();
            if (!c.bxl()) {
                boolean booleanValue;
                g.RQ();
                Object obj = g.RP().Ry().get(a.USERINFO_FINGER_PRINT_SHOW_OPEN_HWFPMANAGER_BOOLEAN_SYNC, Boolean.FALSE);
                if (obj != null) {
                    booleanValue = ((Boolean) obj).booleanValue();
                } else {
                    booleanValue = false;
                }
                if (!booleanValue) {
                    ab.i("MicroMsg.FingerPrintUtil", "will call showSetFingerPrintGuide()");
                    AppMethodBeat.o(41468);
                    return true;
                }
            }
            AppMethodBeat.o(41468);
            return false;
        } else {
            ab.e("MicroMsg.FingerPrintUtil", "isSupportTouchPay is false");
            AppMethodBeat.o(41468);
            return false;
        }
    }

    public static final String dQ(Context context) {
        AppMethodBeat.i(41469);
        String str = context.getApplicationContext().getFilesDir().getAbsolutePath() + "/b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec";
        AppMethodBeat.o(41469);
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
    public static int dR(Context context) {
        int i;
        InputStream inputStream;
        Throwable e;
        AppMethodBeat.i(41470);
        InputStream inputStream2 = null;
        String dQ = dQ(context);
        File file = new File(dQ);
        if (file.exists()) {
            String v = com.tencent.mm.a.g.v(file);
            CharSequence charSequence = "";
            try {
                inputStream2 = context.getAssets().open("b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec");
                if (inputStream2 != null) {
                    charSequence = com.tencent.mm.a.g.b(inputStream2, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e2) {
                        ab.printErrStackTrace("MicroMsg.FingerPrintUtil", e2, "", new Object[0]);
                    }
                }
            } catch (IOException e22) {
                ab.printErrStackTrace("MicroMsg.FingerPrintUtil", e22, "", new Object[0]);
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e222) {
                        ab.printErrStackTrace("MicroMsg.FingerPrintUtil", e222, "", new Object[0]);
                    }
                }
            } catch (Throwable th) {
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e3) {
                        ab.printErrStackTrace("MicroMsg.FingerPrintUtil", e3, "", new Object[0]);
                    }
                }
                AppMethodBeat.o(41470);
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
                            ab.printErrStackTrace("MicroMsg.FingerPrintUtil", e4, "", new Object[0]);
                            ab.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + e4.getMessage());
                        }
                    }
                    try {
                        fileOutputStream.close();
                        i = 0;
                    } catch (IOException e42) {
                        ab.printErrStackTrace("MicroMsg.FingerPrintUtil", e42, "", new Object[0]);
                        ab.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + e42.getMessage());
                        i = 0;
                    }
                } catch (Exception e5) {
                    e = e5;
                    try {
                        ab.printErrStackTrace("MicroMsg.FingerPrintUtil", e, "", new Object[0]);
                        ab.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets Exception " + e.getMessage());
                        if (inputStream != null) {
                        }
                        if (fileOutputStream == null) {
                        }
                        if (Runtime.getRuntime().exec("chmod 777 ".concat(String.valueOf(dQ))).waitFor() == 0) {
                        }
                        AppMethodBeat.o(41470);
                        return i;
                    } catch (Throwable th2) {
                        e = th2;
                        if (inputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        AppMethodBeat.o(41470);
                        throw e;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                fileOutputStream = null;
                ab.printErrStackTrace("MicroMsg.FingerPrintUtil", e, "", new Object[0]);
                ab.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets Exception " + e.getMessage());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e422) {
                        ab.printErrStackTrace("MicroMsg.FingerPrintUtil", e422, "", new Object[0]);
                        ab.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + e422.getMessage());
                    }
                }
                if (fileOutputStream == null) {
                    try {
                        fileOutputStream.close();
                        i = -1;
                    } catch (IOException e4222) {
                        ab.printErrStackTrace("MicroMsg.FingerPrintUtil", e4222, "", new Object[0]);
                        ab.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + e4222.getMessage());
                        i = -1;
                    }
                } else {
                    i = -1;
                }
                if (Runtime.getRuntime().exec("chmod 777 ".concat(String.valueOf(dQ))).waitFor() == 0) {
                }
                AppMethodBeat.o(41470);
                return i;
            } catch (Throwable th3) {
                e = th3;
                fileOutputStream = null;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2222) {
                        ab.printErrStackTrace("MicroMsg.FingerPrintUtil", e2222, "", new Object[0]);
                        ab.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + e2222.getMessage());
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e32) {
                        ab.printErrStackTrace("MicroMsg.FingerPrintUtil", e32, "", new Object[0]);
                        ab.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + e32.getMessage());
                    }
                }
                AppMethodBeat.o(41470);
                throw e;
            }
            try {
                if (Runtime.getRuntime().exec("chmod 777 ".concat(String.valueOf(dQ))).waitFor() == 0) {
                    ab.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                } else {
                    ab.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                }
            } catch (Exception e7) {
                ab.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file Exception " + e7.getMessage());
            }
        } else {
            i = 0;
        }
        AppMethodBeat.o(41470);
        return i;
    }
}
