package oicq.wlogin_sdk.request;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.p702a.C7419g;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.C6118c;
import oicq.wlogin_sdk.tools.C6120util;

/* renamed from: oicq.wlogin_sdk.request.b */
public final class C6109b {
    private static /* synthetic */ int[] BUh;
    public C6112i BTY = new C6112i();
    private C7443j BTZ = new C7443j(this.BTY);
    private C7440f BUa = new C7440f(this.BTY);
    private C7441g BUb = new C7441g(this.BTY);
    private C7442h BUc = new C7442h(this.BTY);
    private C7439e BUd = new C7439e(this.BTY);
    public C6111d BUe = null;
    private int BUf = 66560;
    private int BUg = 1404;
    private Context mContext = null;

    /* renamed from: oicq.wlogin_sdk.request.b$a */
    public enum C6108a {
        USER_WITH_PWD,
        USER_WITH_MD5,
        USER_WITH_A1;

        static {
            AppMethodBeat.m2505o(96405);
        }
    }

    private static /* synthetic */ int[] emB() {
        AppMethodBeat.m2504i(96414);
        int[] iArr = BUh;
        if (iArr != null) {
            AppMethodBeat.m2505o(96414);
        } else {
            iArr = new int[C6108a.values().length];
            try {
                iArr[C6108a.USER_WITH_A1.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C6108a.USER_WITH_MD5.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C6108a.USER_WITH_PWD.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            BUh = iArr;
            AppMethodBeat.m2505o(96414);
        }
        return iArr;
    }

    public C6109b(Context context, int i) {
        AppMethodBeat.m2504i(96408);
        this.mContext = context;
        C6112i c6112i = this.BTY;
        c6112i._context = context;
        c6112i.BUM = i;
        c6112i.BVg = new C6110c(context);
        byte[] bArr = new byte[16];
        c6112i.BUD.nextBytes(bArr);
        System.arraycopy(bArr, 0, c6112i.BUG, 0, 16);
        emA();
        AppMethodBeat.m2505o(96408);
    }

    /* JADX WARNING: Missing block: B:17:0x005b, code skipped:
            r11.BTY.BUQ = oicq.wlogin_sdk.tools.C6120util.m9674jL(r11.mContext);
            r11.BTY.BUS = oicq.wlogin_sdk.tools.C6120util.m9677jO(r11.mContext).getBytes();
            r11.BTY._uin = r12;
            r11.BTY.BUJ = 522017402;
            r11.BTY.BUK = 8256;
            r11.BTY.BUH = new oicq.wlogin_sdk.p702a.C7418f();
            r11.BUe = r11.BTZ;
     */
    /* JADX WARNING: Missing block: B:18:0x0091, code skipped:
            if (r1 == 0) goto L_0x015a;
     */
    /* JADX WARNING: Missing block: B:19:0x0093, code skipped:
            r0 = r11.BTZ.mo16233a(r12, r11.BTY.BVe, r5, r11.BUg, r11.BUf, r11.BTY.BVb);
     */
    /* JADX WARNING: Missing block: B:21:0x00a7, code skipped:
            oicq.wlogin_sdk.tools.C6120util.awF("wtlogin login with GetStWithPasswd:user:" + r12 + " appid:522017402 dwSigMap:8256 end");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(96409);
     */
    /* JADX WARNING: Missing block: B:53:0x015a, code skipped:
            r4 = new byte[4];
            oicq.wlogin_sdk.tools.C6120util.m9669d(r4, 0, oicq.wlogin_sdk.request.C6112i.emE());
            r0 = r11.BTZ.mo16234a(r12, r11.BTY.BVe, r4, r5, r11.BUg, r11.BUf, r11.BTY.BVb);
     */
    /* JADX WARNING: Missing block: B:58:?, code skipped:
            return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final byte[] mo13514a(long j, C6108a c6108a, String str) {
        AppMethodBeat.m2504i(96409);
        C6120util.awF("wtlogin login with GetStWithPasswd:user:" + j + " appid:522017402 dwSigMap:8256 ...");
        if (str.length() > 16) {
            str = str.substring(0, 16);
        }
        synchronized (this) {
            try {
                byte[] awD;
                int i;
                switch (C6109b.emB()[c6108a.ordinal()]) {
                    case 1:
                        if (str != null) {
                            if (str.length() != 0) {
                                awD = C6118c.awD(str);
                                i = 0;
                                break;
                            }
                        }
                        C6120util.awF("USER_WITH_PWD userPasswd null");
                        AppMethodBeat.m2505o(96409);
                        return null;
                    case 2:
                        if (str != null) {
                            if (str.length() != 0) {
                                try {
                                    i = 0;
                                    awD = (byte[]) str.getBytes("ISO-8859-1").clone();
                                    break;
                                } catch (Exception e) {
                                    AppMethodBeat.m2505o(96409);
                                    return null;
                                }
                            }
                        }
                        C6120util.awF("USER_WITH_MD5 userPasswd null");
                        AppMethodBeat.m2505o(96409);
                        return null;
                    case 3:
                        WloginSigInfo og = this.BTY.mo13533og(j);
                        if (og == null || og._en_A1 == null || og._en_A1.length <= 0) {
                            C6120util.awF("userAccount:" + j + " appid:522017402 GetA1ByAccount return: null");
                            awD = null;
                        } else {
                            C6120util.awF("userAccount:" + j + " appid:522017402 GetA1ByAccount return: not null");
                            awD = (byte[]) og._en_A1.clone();
                        }
                        if (awD != null && awD.length >= 16) {
                            i = 1;
                            break;
                        }
                        C6120util.awF("USER_WITH_A1 tmp_pwd null");
                        AppMethodBeat.m2505o(96409);
                        return null;
                        break;
                }
            } finally {
                AppMethodBeat.m2505o(96409);
            }
        }
        return null;
    }

    /* renamed from: f */
    public final byte[] mo13515f(long j, byte[] bArr) {
        AppMethodBeat.m2504i(96410);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.m2505o(96410);
            return null;
        }
        byte[] cF;
        C6120util.awF("user:" + j + " CheckPicture ...");
        synchronized (this) {
            try {
                this.BUe = this.BUb;
                cF = this.BUb.mo16232cF(bArr);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(96410);
            }
        }
        C6120util.awF("user:" + j + " CheckPicture end");
        return cF;
    }

    /* renamed from: od */
    public final byte[] mo13516od(long j) {
        byte[] bArr;
        AppMethodBeat.m2504i(96411);
        synchronized (this) {
            try {
                C7419g c7419g = this.BTY.BUI;
                bArr = new byte[c7419g.BVt];
                if (c7419g.BVt > 0) {
                    System.arraycopy(c7419g.BUt, c7419g.BVv, bArr, 0, c7419g.BVt);
                }
            } finally {
                AppMethodBeat.m2505o(96411);
            }
        }
        C6120util.awF("user:" + j + " GetPicture data len:" + bArr.length);
        return bArr;
    }

    /* renamed from: oe */
    public final void mo13517oe(long j) {
        AppMethodBeat.m2504i(96412);
        C6120util.awF("user:" + j + " ClearUserSigInfo");
        this.BTY.mo13532i(Long.valueOf(j));
        AppMethodBeat.m2505o(96412);
    }

    private int emA() {
        AppMethodBeat.m2504i(96413);
        synchronized (this) {
            try {
                Object jQ = C6120util.m9679jQ(this.mContext);
                if (jQ == null || jQ.length <= 0) {
                    jQ = C6120util.m9672jJ(this.mContext);
                    if (jQ == null || jQ.length <= 0) {
                        jQ = new String("%4;7t>;28<fc.5*6").getBytes();
                        this.BTY.BUZ = 0;
                    } else {
                        this.BTY.BUZ = 1;
                    }
                    C6120util.m9661b(this.mContext, jQ);
                    this.BTY.BUY = 1;
                    this.BTY.BVa = 1;
                } else {
                    this.BTY.BUZ = 1;
                    this.BTY.BUY = 0;
                    this.BTY.BVa = 0;
                }
                this.BTY.BUN = new byte[jQ.length];
                System.arraycopy(jQ, 0, this.BTY.BUN, 0, jQ.length);
                byte[] bArr = new byte[(jQ.length + 1)];
                bArr[0] = (byte) 35;
                System.arraycopy(jQ, 0, bArr, 1, jQ.length);
                this.BTY.BUE = C6120util.m9663cN(bArr);
                C6112i.BUO = (byte[]) this.BTY.BUN.clone();
                this.BTY.BUP = C6120util.m9673jK(this.mContext);
                int jM = C6120util.m9675jM(this.mContext);
                this.BTY.BUQ = C6120util.m9674jL(this.mContext);
                if (jM != this.BTY.BUQ) {
                    C6120util.m9676jN(this.mContext);
                    C6120util.m9657aF(this.mContext, this.BTY.BUQ);
                }
                this.BTY.BUS = C6120util.m9677jO(this.mContext).getBytes();
                this.BTY.BVb = C6120util.m9678jP(this.mContext);
                this.BTY.BUR = C6120util.m9680jR(this.mContext);
                this.BTY.BUU = C6120util.m9666cl(this.mContext, new String(this.BTY.BUR));
                this.BTY.BUV = C6120util.m9667cm(this.mContext, new String(this.BTY.BUR));
                String str = Build.MODEL;
                if (str == null) {
                    this.BTY.BUW = new byte[0];
                } else {
                    this.BTY.BUW = str.getBytes();
                }
                if (C6120util.isFileExist("/system/bin/su") || C6120util.isFileExist("/system/xbin/su") || C6120util.isFileExist("/sbin/su")) {
                    jM = 1;
                } else {
                    jM = 0;
                }
                C6112i c6112i = this.BTY;
                if (jM != 0) {
                    jM = 1;
                } else {
                    jM = 0;
                }
                c6112i.BUX = jM;
                str = VERSION.RELEASE;
                if (str == null) {
                    str = "";
                }
                C6120util.awF("WtloginHelper init ok: android version:" + str + " release time:" + C6120util.emR());
            } finally {
                AppMethodBeat.m2505o(96413);
            }
        }
        return 0;
    }
}
