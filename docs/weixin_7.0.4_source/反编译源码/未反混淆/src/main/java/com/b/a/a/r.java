package com.b.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

final class r extends d {
    private static final DecimalFormat bFD = new DecimalFormat("0000000000");
    private static final DecimalFormat bFE = new DecimalFormat("0000000000000000");
    private static r bFF;
    private String bFG;
    private String bFH;
    private final b bFI = new b();
    private int bFJ;
    z bFK;
    private SharedPreferences bFL;
    private f bFM;
    private final Object bFN = new Object();
    private final d bFO = new d(this, (byte) 0);
    q bFP;
    String bFQ;
    private int mRetryCount;

    static class b {
        final byte[] bFS;
        private final byte[] bFT;
        int code;

        private b() {
            AppMethodBeat.i(55540);
            this.code = -1;
            this.bFS = new byte[27];
            this.bFT = new byte[8];
            AppMethodBeat.o(55540);
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    static class c extends a {
        private final String bFU;
        private final long bFV;
        private final int dataType;

        /* synthetic */ c(r rVar, String str, long j, int i, byte b) {
            this(rVar, str, j, i);
        }

        private c(r rVar, String str, long j, int i) {
            super(rVar, (byte) 0);
            this.bFU = str;
            this.bFV = j;
            this.dataType = i;
        }

        public final void run() {
            AppMethodBeat.i(55541);
            try {
                switch (this.dataType) {
                    case 0:
                        r.a(wn(), this.bFU, this.bFV);
                        AppMethodBeat.o(55541);
                        return;
                    case 1:
                        r.a(wn(), this.bFU);
                        break;
                }
                AppMethodBeat.o(55541);
            } catch (Exception e) {
                AppMethodBeat.o(55541);
            }
        }
    }

    static class d extends a {
        private boolean bFW;

        /* synthetic */ d(r rVar, byte b) {
            this(rVar);
        }

        private d(r rVar) {
            super(rVar, (byte) 0);
        }

        public final void run() {
            AppMethodBeat.i(55542);
            try {
                r.a(wn());
                f b = wn().bFM;
                try {
                    b.bDa = Build.MODEL;
                    b.bDb = VERSION.RELEASE;
                    b.versionName = b.bCY.versionName;
                    CharSequence loadLabel = b.mContext.getApplicationInfo().loadLabel(b.bCX);
                    b.bCZ = loadLabel != null ? loadLabel.toString() : "unknown";
                    if (b.bCW != null) {
                        Sensor defaultSensor = b.bCW.getDefaultSensor(1);
                        Sensor defaultSensor2 = b.bCW.getDefaultSensor(4);
                        Sensor defaultSensor3 = b.bCW.getDefaultSensor(2);
                        Sensor defaultSensor4 = b.bCW.getDefaultSensor(11);
                        if (defaultSensor != null) {
                            b.bDe = 1;
                        }
                        if (defaultSensor2 != null) {
                            b.bDf = 1;
                        }
                        if (defaultSensor3 != null) {
                            b.bDg = 1;
                        }
                        if (defaultSensor4 != null) {
                            b.bDh = 1;
                        }
                    }
                } catch (Error | Exception e) {
                }
            } catch (Exception e2) {
            }
            this.bFW = false;
            AppMethodBeat.o(55542);
        }

        static /* synthetic */ d a(d dVar) {
            AppMethodBeat.i(55543);
            if (dVar.bFW) {
                Exception exception = new Exception("OnlineModule: new-session runnable occupied");
                AppMethodBeat.o(55543);
                throw exception;
            }
            dVar.bFW = true;
            AppMethodBeat.o(55543);
            return dVar;
        }
    }

    static class e extends a {
        private final String bFU;
        private final long bFV;
        private final long bFX;
        private final boolean bFY;
        private final int bFk;

        /* synthetic */ e(r rVar, String str, long j, long j2, int i, byte b) {
            this(rVar, str, j, j2, i);
        }

        private e(r rVar, String str, long j, long j2, int i) {
            super(rVar, (byte) 0);
            this.bFU = str;
            this.bFV = j;
            this.bFX = j2;
            this.bFk = i;
            this.bFY = true;
        }

        public final void run() {
            AppMethodBeat.i(55544);
            try {
                r.a(wn(), this.bFU, this.bFV, this.bFX, this.bFk, this.bFY);
                AppMethodBeat.o(55544);
            } catch (Exception e) {
                AppMethodBeat.o(55544);
            }
        }
    }

    static class f extends p {
        final int bFZ;
        final x bGa;
        final boolean bGb;
        final String message;

        /* synthetic */ f(int i, x xVar, String str, byte b) {
            this(i, xVar, str);
        }

        private f(int i, x xVar, String str) {
            super(202);
            AppMethodBeat.i(55545);
            this.bFZ = i;
            this.bGa = xVar;
            this.message = str;
            boolean z = (this.bFZ < 0 || this.bFZ == 4 || this.bFZ == 2) ? false : true;
            this.bGb = z;
            AppMethodBeat.o(55545);
        }
    }

    static abstract class a implements Runnable {
        private final WeakReference<r> bFR;

        private a(r rVar) {
            this.bFR = new WeakReference(rVar);
        }

        /* synthetic */ a(r rVar, byte b) {
            this(rVar);
        }

        /* Access modifiers changed, original: final */
        public final r wn() {
            r rVar = (r) this.bFR.get();
            if (rVar != null) {
                return rVar;
            }
            throw new Exception("OnlineModule.AbstractOnlineModuleRunnable: online module not available");
        }
    }

    static {
        AppMethodBeat.i(55546);
        AppMethodBeat.o(55546);
    }

    private r() {
        AppMethodBeat.i(55547);
        AppMethodBeat.o(55547);
    }

    static r wg() {
        AppMethodBeat.i(55548);
        if (bFF == null) {
            bFF = new r();
        }
        r rVar = bFF;
        AppMethodBeat.o(55548);
        return rVar;
    }

    /* Access modifiers changed, original: final */
    public final void at(Context context) {
        AppMethodBeat.i(55549);
        try {
            String str = this.bFQ;
            if (TextUtils.isEmpty(str)) {
                str = "0000000000";
            }
            this.bFG = br(str);
            this.bFH = a(Long.valueOf(System.currentTimeMillis() / 1000));
            this.bFM = new f(context);
        } catch (Exception e) {
        }
        this.bFL = context.getSharedPreferences("0-474-85242", 0);
        AppMethodBeat.o(55549);
    }

    /* Access modifiers changed, original: final */
    public final void a(Context context, Handler handler, a aVar) {
        AppMethodBeat.i(55550);
        this.bFK = z.b(handler);
        wh();
        AppMethodBeat.o(55550);
    }

    /* Access modifiers changed, original: final */
    public final void au(Context context) {
    }

    /* Access modifiers changed, original: final */
    public final void vV() {
        this.bFP = null;
    }

    /* Access modifiers changed, original: final */
    public final void wh() {
        AppMethodBeat.i(55551);
        if (this.bFK != null) {
            try {
                this.bFK.execute(d.a(this.bFO));
                AppMethodBeat.o(55551);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(55551);
    }

    /* Access modifiers changed, original: final */
    public final void bp(String str) {
        AppMethodBeat.i(55552);
        if (this.bFK != null) {
            this.bFK.execute(new c(this, str, 0, 1, (byte) 0));
        }
        AppMethodBeat.o(55552);
    }

    /* Access modifiers changed, original: final */
    public final boolean wi() {
        return this.bFI.code == 1;
    }

    private static f d(String str, long j, long j2) {
        AppMethodBeat.i(55553);
        Exception exception;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("errorcode", -5);
            f fVar;
            if (optInt != 0) {
                fVar = new f(optInt, null, null, (byte) 0);
                AppMethodBeat.o(55553);
                return fVar;
            }
            long optLong = jSONObject.optLong("hitarea", 0);
            String str2 = new String(Base64.decode(jSONObject.optString("swdata", null), 0), "UTF-8");
            if (y.bIM) {
                o.s("data_transaction_log_" + y.bIT, str2);
            }
            if (str2.length() <= h.bDl || !str2.startsWith("$UP,")) {
                exception = new Exception("OnlineModule: parse data upload reply and generate msg: invalid arg");
                AppMethodBeat.o(55553);
                throw exception;
            }
            f fVar2;
            switch (str2.charAt(h.bDl)) {
                case '0':
                    fVar2 = new f(0, null, str2.length() > h.bDm ? str2.substring(h.bDm) : null, (byte) 0);
                    AppMethodBeat.o(55553);
                    return fVar2;
                case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                    if (str2.length() > h.bDm) {
                        x f = f(str2.substring(h.bDm), optLong);
                        f.bIA = j;
                        f.bFX = j2;
                        fVar = new f(1, f, null, (byte) 0);
                        AppMethodBeat.o(55553);
                        return fVar;
                    }
                    break;
                case '2':
                    fVar2 = new f(2, null, str2.length() > h.bDm ? str2.substring(h.bDm) : null, (byte) 0);
                    AppMethodBeat.o(55553);
                    return fVar2;
                case '3':
                    fVar2 = new f(3, null, str2.length() > h.bDm ? str2.substring(h.bDm) : null, (byte) 0);
                    AppMethodBeat.o(55553);
                    return fVar2;
                case '4':
                    fVar2 = new f(4, null, str2.length() > h.bDm ? str2.substring(h.bDm) : null, (byte) 0);
                    AppMethodBeat.o(55553);
                    return fVar2;
                case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                    fVar2 = new f(5, null, str2.length() > h.bDm ? str2.substring(h.bDm) : null, (byte) 0);
                    AppMethodBeat.o(55553);
                    return fVar2;
                case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                    fVar2 = new f(6, null, str2.length() > h.bDm ? str2.substring(h.bDm) : null, (byte) 0);
                    AppMethodBeat.o(55553);
                    return fVar2;
            }
            exception = new Exception("OnlineModule: unable to parse data upload reply");
            AppMethodBeat.o(55553);
            throw exception;
        } catch (Exception e) {
            if (y.bIM) {
                o.s("data_transaction_log_" + y.bIT, "parse json data error");
            }
            exception = new Exception("parse json data error");
            AppMethodBeat.o(55553);
            throw exception;
        }
    }

    private static x f(String str, long j) {
        int i = 0;
        AppMethodBeat.i(55554);
        if (str != null) {
            String[] split = str.split(",", -1);
            if (split.length == 10) {
                try {
                    int parseInt;
                    int parseInt2;
                    int parseInt3;
                    double parseDouble = Double.parseDouble(split[0]);
                    double parseDouble2 = Double.parseDouble(split[1]);
                    float parseFloat = Float.parseFloat(split[8]);
                    try {
                        parseInt = Integer.parseInt(split[3]);
                    } catch (NumberFormatException e) {
                        parseInt = i;
                    }
                    try {
                        parseInt2 = Integer.parseInt(split[4]);
                    } catch (NumberFormatException e2) {
                        parseInt2 = i;
                    }
                    try {
                        parseInt3 = Integer.parseInt(split[5]);
                    } catch (NumberFormatException e3) {
                        parseInt3 = i;
                    }
                    try {
                        i = Integer.parseInt(split[7]);
                    } catch (NumberFormatException e4) {
                    }
                    float f = 0.0f;
                    try {
                        f = Float.parseFloat(split[9]);
                    } catch (NumberFormatException e5) {
                    }
                    x xVar = new x();
                    xVar.latitude = parseDouble;
                    xVar.longitude = parseDouble2;
                    xVar.bIx = split[2];
                    xVar.level = parseInt;
                    xVar.bIz = (long) parseInt2;
                    xVar.bIC = parseInt3;
                    xVar.bIy = split[6];
                    xVar.bID = i;
                    xVar.bEJ = parseFloat;
                    if (xVar.bIB == null) {
                        xVar.bIB = new a();
                    }
                    xVar.bIB.bIE = f;
                    xVar.bFo = j;
                    AppMethodBeat.o(55554);
                    return xVar;
                } catch (NumberFormatException e6) {
                }
            }
        }
        Exception exception = new Exception("OnlineModule: unable to get location from data upload reply");
        AppMethodBeat.o(55554);
        throw exception;
    }

    private void g(String str, long j) {
        String str2 = null;
        AppMethodBeat.i(55555);
        String str3 = "1";
        if (!(str == null || str.startsWith("&OD[]="))) {
            String bt = v.bt(v.bu(str));
            if (bt == null) {
                bt = null;
            } else {
                bt = bt.replace("&MD=", "|MD,");
            }
            if (bt != null) {
                str2 = bt.replace("&WD[]=", "|WD,");
            }
            str = v.b(str2, j, str3);
        }
        bq(str);
        AppMethodBeat.o(55555);
    }

    static /* synthetic */ void a(r rVar, String str) {
        AppMethodBeat.i(55566);
        rVar.bq(str);
        AppMethodBeat.o(55566);
    }

    @SuppressLint({"NewApi"})
    private void bq(String str) {
        AppMethodBeat.i(55556);
        if (str == null) {
            AppMethodBeat.o(55556);
            return;
        }
        synchronized (this.bFN) {
            try {
                String stringBuilder = new StringBuilder(String.valueOf(wl().getString("1-115-10127", ""))).append(str).toString();
                int length = stringBuilder.length() - 307200;
                if (length > 0) {
                    int indexOf = stringBuilder.indexOf("&OD[]=", length);
                    stringBuilder = indexOf >= length ? stringBuilder.substring(indexOf) : "";
                }
                if (VERSION.SDK_INT >= 9) {
                    wl().edit().putString("1-115-10127", stringBuilder).apply();
                } else {
                    wl().edit().putString("1-115-10127", stringBuilder).commit();
                }
            } catch (Exception e) {
            } catch (Error e2) {
                try {
                    if (VERSION.SDK_INT >= 9) {
                        wl().edit().putString("1-115-10127", "").apply();
                    } else {
                        wl().edit().putString("1-115-10127", "").commit();
                    }
                } catch (Exception e3) {
                }
            }
            try {
            } finally {
                while (true) {
                }
                AppMethodBeat.o(55556);
            }
        }
    }

    private String wj() {
        AppMethodBeat.i(55557);
        String string;
        try {
            string = wl().getString("1-115-10127", "");
            AppMethodBeat.o(55557);
            return string;
        } catch (Exception e) {
            string = "";
            AppMethodBeat.o(55557);
            return string;
        }
    }

    @SuppressLint({"NewApi"})
    private void wk() {
        AppMethodBeat.i(55558);
        try {
            if (VERSION.SDK_INT >= 9) {
                wl().edit().remove("1-115-10127").apply();
                AppMethodBeat.o(55558);
                return;
            }
            wl().edit().remove("1-115-10127").commit();
            AppMethodBeat.o(55558);
        } catch (Exception e) {
            AppMethodBeat.o(55558);
        }
    }

    private SharedPreferences wl() {
        AppMethodBeat.i(55559);
        if (this.bFL == null) {
            Exception exception = new Exception("OnlineModule: data buffer unavailable");
            AppMethodBeat.o(55559);
            throw exception;
        }
        SharedPreferences sharedPreferences = this.bFL;
        AppMethodBeat.o(55559);
        return sharedPreferences;
    }

    private synchronized void wm() {
        AppMethodBeat.i(55560);
        String str = this.bFG;
        String str2 = this.bFH;
        b bVar = this.bFI;
        if (str == null || str2 == null || bVar == null) {
            Exception exception = new Exception("OnlineModule: authenticate: null arg");
            AppMethodBeat.o(55560);
            throw exception;
        }
        System.arraycopy(new StringBuilder(String.valueOf(str)).append(str2).toString().getBytes(), 0, bVar.bFS, 0, 27);
        bVar.code = 1;
        AppMethodBeat.o(55560);
    }

    private static String br(String str) {
        AppMethodBeat.i(55561);
        try {
            String str2 = "T" + bFE.format(Long.parseLong(str) + System.currentTimeMillis());
            AppMethodBeat.o(55561);
            return str2;
        } catch (NumberFormatException e) {
            Exception exception = new Exception("OnlineModule: invalid device id, type: 0");
            AppMethodBeat.o(55561);
            throw exception;
        }
    }

    private static String a(Long l) {
        AppMethodBeat.i(55562);
        Exception exception;
        if (l == null) {
            exception = new Exception("OnlineModule: null source id");
            AppMethodBeat.o(55562);
            throw exception;
        }
        try {
            String format = bFD.format(l);
            AppMethodBeat.o(55562);
            return format;
        } catch (NumberFormatException e) {
            exception = new Exception("OnlineModule: invalid source id");
            AppMethodBeat.o(55562);
            throw exception;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(r rVar, String str, long j, long j2, int i, boolean z) {
        AppMethodBeat.i(55564);
        if (rVar.isRunning) {
            synchronized (rVar.bFN) {
                try {
                    String stringBuilder;
                    String wj = rVar.wj();
                    if (str != null) {
                        stringBuilder = new StringBuilder(String.valueOf(str)).append(wj).toString();
                    } else {
                        stringBuilder = wj;
                    }
                    if (stringBuilder.length() > 0) {
                        long ay = aa.ay(j);
                        int i2 = rVar.bFJ + 1;
                        rVar.bFJ = i2;
                        String str2 = y.MODE;
                        String str3 = y.bIL;
                        boolean z2 = y.bIN;
                        int i3 = y.bIH;
                        int i4 = y.bII;
                        if (str2 == null || str3 == null) {
                            Exception exception = new Exception("StringBuilding: null mode or user name");
                            AppMethodBeat.o(55564);
                            throw exception;
                        }
                        wj = new StringBuilder(String.valueOf("ST=" + String.valueOf(ay) + ',' + i2 + ',' + str2 + ',' + str3 + ',' + (z2 ? '1' : '0') + ',' + i3 + ',' + i4 + ',' + i)).append(stringBuilder).toString();
                        if (y.bIM) {
                            o.s("data_transaction_log_" + y.bIT, wj);
                        }
                        byte[] encode = Base64.encode(g.compress(wj.getBytes("UTF-8")), 0);
                        byte[] bArr = new byte[(rVar.bFI.bFS.length + encode.length)];
                        System.arraycopy(rVar.bFI.bFS, 0, bArr, 0, rVar.bFI.bFS.length);
                        System.arraycopy(encode, 0, bArr, rVar.bFI.bFS.length, encode.length);
                        rVar.bFM.imei = rVar.bFQ;
                        stringBuilder = new String(rVar.bFP.httpRequest(rVar.bFM.t(bArr).getBytes("UTF-8")));
                        if (y.bIM) {
                            o.s("data_transaction_log_" + y.bIT, stringBuilder);
                        }
                        f d = d(stringBuilder, j, j2);
                        if (d.bGb) {
                            rVar.wk();
                            rVar.mRetryCount = 0;
                        } else {
                            rVar.mRetryCount++;
                            int length = rVar.wl().getString("1-115-10127", "").length();
                            if (rVar.mRetryCount > 20 || (length > 10240 && rVar.mRetryCount > 3)) {
                                rVar.wk();
                            }
                        }
                        if (d.bFZ == 4) {
                            rVar.bFI.code = -1;
                        }
                        rVar.c(d);
                        if (d.bGb) {
                            AppMethodBeat.o(55564);
                            return;
                        }
                    }
                } catch (Exception e) {
                    rVar.c(new f(0, null, "connection failure", (byte) 0));
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(55564);
                    }
                }
            }
        }
        if (z) {
            rVar.g(str, aa.ay(j));
        }
        AppMethodBeat.o(55564);
        if (z) {
        }
        AppMethodBeat.o(55564);
    }
}
