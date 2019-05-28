package oicq.wlogin_sdk.request;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.SecureRandom;
import oicq.wlogin_sdk.p702a.C7418f;
import oicq.wlogin_sdk.p702a.C7419g;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.C6120util;
import oicq.wlogin_sdk.tools.ErrMsg;

/* renamed from: oicq.wlogin_sdk.request.i */
public final class C6112i {
    public static byte[] BUO = new byte[0];
    public SecureRandom BUD = new SecureRandom();
    public byte[] BUE = C6120util.emO();
    public byte[] BUF = null;
    public byte[] BUG = new byte[16];
    public C7418f BUH = new C7418f();
    public C7419g BUI = new C7419g();
    public long BUJ = 0;
    public int BUK = 0;
    public long BUL = -1;
    public int BUM = 0;
    byte[] BUN = new byte[0];
    byte[] BUP = new byte[0];
    int BUQ = 0;
    byte[] BUR = new byte[0];
    byte[] BUS = new byte[0];
    byte[] BUT = new byte[0];
    byte[] BUU = new byte[0];
    byte[] BUV = new byte[0];
    byte[] BUW = new byte[0];
    int BUX = 0;
    int BUY = 0;
    int BUZ = 0;
    int BVa = 0;
    byte[] BVb = new byte[0];
    ErrMsg BVc = new ErrMsg();
    byte[] BVd = new byte[0];
    byte[] BVe = new byte[4];
    byte[] BVf = new byte[0];
    C6110c BVg = null;
    public Context _context = null;
    public long _uin = 0;

    public C6112i() {
        AppMethodBeat.m2504i(96443);
        AppMethodBeat.m2505o(96443);
    }

    public static long emE() {
        AppMethodBeat.m2504i(96444);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        AppMethodBeat.m2505o(96444);
        return currentTimeMillis;
    }

    /* renamed from: a */
    public final synchronized int mo13531a(long j, long j2, long j3, long j4, long j5, long j6, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[] bArr13, byte[] bArr14, byte[] bArr15, byte[] bArr16, byte[][] bArr17) {
        int i;
        AppMethodBeat.m2504i(96445);
        C6120util.awF("put siginfo:" + j + "," + j2 + "," + j3 + "," + j4 + "," + j5 + "," + j6 + "," + C6120util.m9665cP(bArr) + "," + C6120util.m9665cP(bArr2) + "," + C6120util.m9665cP(bArr3) + "," + C6120util.m9665cP(bArr4) + "," + C6120util.m9665cP(bArr5) + "," + C6120util.m9665cP(bArr6) + "," + C6120util.m9665cP(bArr7) + "," + C6120util.m9665cP(bArr8) + "," + C6120util.m9665cP(bArr9) + "," + C6120util.m9665cP(bArr10) + "," + C6120util.m9665cP(bArr11) + "," + C6120util.m9665cP(bArr12) + "," + C6120util.m9665cP(bArr13) + "," + C6120util.m9665cP(bArr14) + "," + C6120util.m9665cP(bArr15) + "," + C6120util.m9665cP(bArr16));
        Object obj = "";
        for (i = 0; i < bArr17.length; i++) {
            obj = new StringBuilder(String.valueOf(obj)).append(String.format("reserve[%d]: %d ", new Object[]{Integer.valueOf(i), Long.valueOf(C6120util.m9665cP(bArr17[i]))})).toString();
        }
        C6120util.awF("reserve:".concat(String.valueOf(obj)));
        i = this.BVg.mo13518a(j, j2, j3, j4, j5, j6, bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13, bArr14, bArr15, bArr16, bArr17);
        AppMethodBeat.m2505o(96445);
        return i;
    }

    /* renamed from: og */
    public final synchronized WloginSigInfo mo13533og(long j) {
        WloginSigInfo og;
        AppMethodBeat.m2504i(96446);
        C6120util.m9681jh("get_siginfo", "uin=" + j + "appid=522017402");
        og = this.BVg.mo13520og(j);
        if (og != null) {
            AppMethodBeat.m2505o(96446);
        } else {
            AppMethodBeat.m2505o(96446);
        }
        return og;
    }

    /* renamed from: i */
    public final synchronized void mo13532i(Long l) {
        AppMethodBeat.m2504i(96447);
        this.BVg.mo13519i(l);
        AppMethodBeat.m2505o(96447);
    }
}
