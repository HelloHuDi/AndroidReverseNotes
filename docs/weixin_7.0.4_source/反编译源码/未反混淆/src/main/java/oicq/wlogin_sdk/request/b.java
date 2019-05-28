package oicq.wlogin_sdk.request;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.c;
import oicq.wlogin_sdk.tools.util;

public final class b {
    private static /* synthetic */ int[] BUh;
    public i BTY = new i();
    private j BTZ = new j(this.BTY);
    private f BUa = new f(this.BTY);
    private g BUb = new g(this.BTY);
    private h BUc = new h(this.BTY);
    private e BUd = new e(this.BTY);
    public d BUe = null;
    private int BUf = 66560;
    private int BUg = 1404;
    private Context mContext = null;

    public enum a {
        USER_WITH_PWD,
        USER_WITH_MD5,
        USER_WITH_A1;

        static {
            AppMethodBeat.o(96405);
        }
    }

    private static /* synthetic */ int[] emB() {
        AppMethodBeat.i(96414);
        int[] iArr = BUh;
        if (iArr != null) {
            AppMethodBeat.o(96414);
        } else {
            iArr = new int[a.values().length];
            try {
                iArr[a.USER_WITH_A1.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[a.USER_WITH_MD5.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[a.USER_WITH_PWD.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            BUh = iArr;
            AppMethodBeat.o(96414);
        }
        return iArr;
    }

    public b(Context context, int i) {
        AppMethodBeat.i(96408);
        this.mContext = context;
        i iVar = this.BTY;
        iVar._context = context;
        iVar.BUM = i;
        iVar.BVg = new c(context);
        byte[] bArr = new byte[16];
        iVar.BUD.nextBytes(bArr);
        System.arraycopy(bArr, 0, iVar.BUG, 0, 16);
        emA();
        AppMethodBeat.o(96408);
    }

    /* JADX WARNING: Missing block: B:17:0x005b, code skipped:
            r11.BTY.BUQ = oicq.wlogin_sdk.tools.util.jL(r11.mContext);
            r11.BTY.BUS = oicq.wlogin_sdk.tools.util.jO(r11.mContext).getBytes();
            r11.BTY._uin = r12;
            r11.BTY.BUJ = 522017402;
            r11.BTY.BUK = 8256;
            r11.BTY.BUH = new oicq.wlogin_sdk.a.f();
            r11.BUe = r11.BTZ;
     */
    /* JADX WARNING: Missing block: B:18:0x0091, code skipped:
            if (r1 == 0) goto L_0x015a;
     */
    /* JADX WARNING: Missing block: B:19:0x0093, code skipped:
            r0 = r11.BTZ.a(r12, r11.BTY.BVe, r5, r11.BUg, r11.BUf, r11.BTY.BVb);
     */
    /* JADX WARNING: Missing block: B:21:0x00a7, code skipped:
            oicq.wlogin_sdk.tools.util.awF("wtlogin login with GetStWithPasswd:user:" + r12 + " appid:522017402 dwSigMap:8256 end");
            com.tencent.matrix.trace.core.AppMethodBeat.o(96409);
     */
    /* JADX WARNING: Missing block: B:53:0x015a, code skipped:
            r4 = new byte[4];
            oicq.wlogin_sdk.tools.util.d(r4, 0, oicq.wlogin_sdk.request.i.emE());
            r0 = r11.BTZ.a(r12, r11.BTY.BVe, r4, r5, r11.BUg, r11.BUf, r11.BTY.BVb);
     */
    /* JADX WARNING: Missing block: B:58:?, code skipped:
            return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] a(long j, a aVar, String str) {
        AppMethodBeat.i(96409);
        util.awF("wtlogin login with GetStWithPasswd:user:" + j + " appid:522017402 dwSigMap:8256 ...");
        if (str.length() > 16) {
            str = str.substring(0, 16);
        }
        synchronized (this) {
            try {
                byte[] awD;
                int i;
                switch (emB()[aVar.ordinal()]) {
                    case 1:
                        if (str != null) {
                            if (str.length() != 0) {
                                awD = c.awD(str);
                                i = 0;
                                break;
                            }
                        }
                        util.awF("USER_WITH_PWD userPasswd null");
                        AppMethodBeat.o(96409);
                        return null;
                    case 2:
                        if (str != null) {
                            if (str.length() != 0) {
                                try {
                                    i = 0;
                                    awD = (byte[]) str.getBytes("ISO-8859-1").clone();
                                    break;
                                } catch (Exception e) {
                                    AppMethodBeat.o(96409);
                                    return null;
                                }
                            }
                        }
                        util.awF("USER_WITH_MD5 userPasswd null");
                        AppMethodBeat.o(96409);
                        return null;
                    case 3:
                        WloginSigInfo og = this.BTY.og(j);
                        if (og == null || og._en_A1 == null || og._en_A1.length <= 0) {
                            util.awF("userAccount:" + j + " appid:522017402 GetA1ByAccount return: null");
                            awD = null;
                        } else {
                            util.awF("userAccount:" + j + " appid:522017402 GetA1ByAccount return: not null");
                            awD = (byte[]) og._en_A1.clone();
                        }
                        if (awD != null && awD.length >= 16) {
                            i = 1;
                            break;
                        }
                        util.awF("USER_WITH_A1 tmp_pwd null");
                        AppMethodBeat.o(96409);
                        return null;
                        break;
                }
            } finally {
                AppMethodBeat.o(96409);
            }
        }
        return null;
    }

    public final byte[] f(long j, byte[] bArr) {
        AppMethodBeat.i(96410);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(96410);
            return null;
        }
        byte[] cF;
        util.awF("user:" + j + " CheckPicture ...");
        synchronized (this) {
            try {
                this.BUe = this.BUb;
                cF = this.BUb.cF(bArr);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(96410);
            }
        }
        util.awF("user:" + j + " CheckPicture end");
        return cF;
    }

    public final byte[] od(long j) {
        byte[] bArr;
        AppMethodBeat.i(96411);
        synchronized (this) {
            try {
                g gVar = this.BTY.BUI;
                bArr = new byte[gVar.BVt];
                if (gVar.BVt > 0) {
                    System.arraycopy(gVar.BUt, gVar.BVv, bArr, 0, gVar.BVt);
                }
            } finally {
                AppMethodBeat.o(96411);
            }
        }
        util.awF("user:" + j + " GetPicture data len:" + bArr.length);
        return bArr;
    }

    public final void oe(long j) {
        AppMethodBeat.i(96412);
        util.awF("user:" + j + " ClearUserSigInfo");
        this.BTY.i(Long.valueOf(j));
        AppMethodBeat.o(96412);
    }

    private int emA() {
        AppMethodBeat.i(96413);
        synchronized (this) {
            try {
                Object jQ = util.jQ(this.mContext);
                if (jQ == null || jQ.length <= 0) {
                    jQ = util.jJ(this.mContext);
                    if (jQ == null || jQ.length <= 0) {
                        jQ = new String("%4;7t>;28<fc.5*6").getBytes();
                        this.BTY.BUZ = 0;
                    } else {
                        this.BTY.BUZ = 1;
                    }
                    util.b(this.mContext, jQ);
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
                this.BTY.BUE = util.cN(bArr);
                i.BUO = (byte[]) this.BTY.BUN.clone();
                this.BTY.BUP = util.jK(this.mContext);
                int jM = util.jM(this.mContext);
                this.BTY.BUQ = util.jL(this.mContext);
                if (jM != this.BTY.BUQ) {
                    util.jN(this.mContext);
                    util.aF(this.mContext, this.BTY.BUQ);
                }
                this.BTY.BUS = util.jO(this.mContext).getBytes();
                this.BTY.BVb = util.jP(this.mContext);
                this.BTY.BUR = util.jR(this.mContext);
                this.BTY.BUU = util.cl(this.mContext, new String(this.BTY.BUR));
                this.BTY.BUV = util.cm(this.mContext, new String(this.BTY.BUR));
                String str = Build.MODEL;
                if (str == null) {
                    this.BTY.BUW = new byte[0];
                } else {
                    this.BTY.BUW = str.getBytes();
                }
                if (util.isFileExist("/system/bin/su") || util.isFileExist("/system/xbin/su") || util.isFileExist("/sbin/su")) {
                    jM = 1;
                } else {
                    jM = 0;
                }
                i iVar = this.BTY;
                if (jM != 0) {
                    jM = 1;
                } else {
                    jM = 0;
                }
                iVar.BUX = jM;
                str = VERSION.RELEASE;
                if (str == null) {
                    str = "";
                }
                util.awF("WtloginHelper init ok: android version:" + str + " release time:" + util.emR());
            } finally {
                AppMethodBeat.o(96413);
            }
        }
        return 0;
    }
}
