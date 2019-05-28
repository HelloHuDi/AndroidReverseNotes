package oicq.wlogin_sdk.request;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.SecureRandom;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public final class i {
    public static byte[] BUO = new byte[0];
    public SecureRandom BUD = new SecureRandom();
    public byte[] BUE = util.emO();
    public byte[] BUF = null;
    public byte[] BUG = new byte[16];
    public f BUH = new f();
    public g BUI = new g();
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
    c BVg = null;
    public Context _context = null;
    public long _uin = 0;

    public i() {
        AppMethodBeat.i(96443);
        AppMethodBeat.o(96443);
    }

    public static long emE() {
        AppMethodBeat.i(96444);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        AppMethodBeat.o(96444);
        return currentTimeMillis;
    }

    public final synchronized int a(long j, long j2, long j3, long j4, long j5, long j6, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[] bArr13, byte[] bArr14, byte[] bArr15, byte[] bArr16, byte[][] bArr17) {
        int i;
        AppMethodBeat.i(96445);
        util.awF("put siginfo:" + j + "," + j2 + "," + j3 + "," + j4 + "," + j5 + "," + j6 + "," + util.cP(bArr) + "," + util.cP(bArr2) + "," + util.cP(bArr3) + "," + util.cP(bArr4) + "," + util.cP(bArr5) + "," + util.cP(bArr6) + "," + util.cP(bArr7) + "," + util.cP(bArr8) + "," + util.cP(bArr9) + "," + util.cP(bArr10) + "," + util.cP(bArr11) + "," + util.cP(bArr12) + "," + util.cP(bArr13) + "," + util.cP(bArr14) + "," + util.cP(bArr15) + "," + util.cP(bArr16));
        Object obj = "";
        for (i = 0; i < bArr17.length; i++) {
            obj = new StringBuilder(String.valueOf(obj)).append(String.format("reserve[%d]: %d ", new Object[]{Integer.valueOf(i), Long.valueOf(util.cP(bArr17[i]))})).toString();
        }
        util.awF("reserve:".concat(String.valueOf(obj)));
        i = this.BVg.a(j, j2, j3, j4, j5, j6, bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13, bArr14, bArr15, bArr16, bArr17);
        AppMethodBeat.o(96445);
        return i;
    }

    public final synchronized WloginSigInfo og(long j) {
        WloginSigInfo og;
        AppMethodBeat.i(96446);
        util.jh("get_siginfo", "uin=" + j + "appid=522017402");
        og = this.BVg.og(j);
        if (og != null) {
            AppMethodBeat.o(96446);
        } else {
            AppMethodBeat.o(96446);
        }
        return og;
    }

    public final synchronized void i(Long l) {
        AppMethodBeat.i(96447);
        this.BVg.i(l);
        AppMethodBeat.o(96447);
    }
}
