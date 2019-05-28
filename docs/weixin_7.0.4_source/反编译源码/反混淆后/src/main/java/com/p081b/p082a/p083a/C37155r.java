package com.p081b.p082a.p083a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.p081b.p082a.p083a.C37157x.C17509a;
import com.p081b.p082a.p083a.C8482d.C8483a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.b.a.a.r */
final class C37155r extends C8482d {
    private static final DecimalFormat bFD = new DecimalFormat("0000000000");
    private static final DecimalFormat bFE = new DecimalFormat("0000000000000000");
    private static C37155r bFF;
    private String bFG;
    private String bFH;
    private final C17504b bFI = new C17504b();
    private int bFJ;
    C37158z bFK;
    private SharedPreferences bFL;
    private C37152f bFM;
    private final Object bFN = new Object();
    private final C17506d bFO = new C17506d(this, (byte) 0);
    C31915q bFP;
    String bFQ;
    private int mRetryCount;

    /* renamed from: com.b.a.a.r$b */
    static class C17504b {
        final byte[] bFS;
        private final byte[] bFT;
        int code;

        private C17504b() {
            AppMethodBeat.m2504i(55540);
            this.code = -1;
            this.bFS = new byte[27];
            this.bFT = new byte[8];
            AppMethodBeat.m2505o(55540);
        }

        /* synthetic */ C17504b(byte b) {
            this();
        }
    }

    /* renamed from: com.b.a.a.r$c */
    static class C17505c extends C37156a {
        private final String bFU;
        private final long bFV;
        private final int dataType;

        /* synthetic */ C17505c(C37155r c37155r, String str, long j, int i, byte b) {
            this(c37155r, str, j, i);
        }

        private C17505c(C37155r c37155r, String str, long j, int i) {
            super(c37155r, (byte) 0);
            this.bFU = str;
            this.bFV = j;
            this.dataType = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(55541);
            try {
                switch (this.dataType) {
                    case 0:
                        C37155r.m62248a(mo59237wn(), this.bFU, this.bFV);
                        AppMethodBeat.m2505o(55541);
                        return;
                    case 1:
                        C37155r.m62247a(mo59237wn(), this.bFU);
                        break;
                }
                AppMethodBeat.m2505o(55541);
            } catch (Exception e) {
                AppMethodBeat.m2505o(55541);
            }
        }
    }

    /* renamed from: com.b.a.a.r$d */
    static class C17506d extends C37156a {
        private boolean bFW;

        /* synthetic */ C17506d(C37155r c37155r, byte b) {
            this(c37155r);
        }

        private C17506d(C37155r c37155r) {
            super(c37155r, (byte) 0);
        }

        public final void run() {
            AppMethodBeat.m2504i(55542);
            try {
                C37155r.m62246a(mo59237wn());
                C37152f b = mo59237wn().bFM;
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
            AppMethodBeat.m2505o(55542);
        }

        /* renamed from: a */
        static /* synthetic */ C17506d m27329a(C17506d c17506d) {
            AppMethodBeat.m2504i(55543);
            if (c17506d.bFW) {
                Exception exception = new Exception("OnlineModule: new-session runnable occupied");
                AppMethodBeat.m2505o(55543);
                throw exception;
            }
            c17506d.bFW = true;
            AppMethodBeat.m2505o(55543);
            return c17506d;
        }
    }

    /* renamed from: com.b.a.a.r$e */
    static class C17507e extends C37156a {
        private final String bFU;
        private final long bFV;
        private final long bFX;
        private final boolean bFY;
        private final int bFk;

        /* synthetic */ C17507e(C37155r c37155r, String str, long j, long j2, int i, byte b) {
            this(c37155r, str, j, j2, i);
        }

        private C17507e(C37155r c37155r, String str, long j, long j2, int i) {
            super(c37155r, (byte) 0);
            this.bFU = str;
            this.bFV = j;
            this.bFX = j2;
            this.bFk = i;
            this.bFY = true;
        }

        public final void run() {
            AppMethodBeat.m2504i(55544);
            try {
                C37155r.m62249a(mo59237wn(), this.bFU, this.bFV, this.bFX, this.bFk, this.bFY);
                AppMethodBeat.m2505o(55544);
            } catch (Exception e) {
                AppMethodBeat.m2505o(55544);
            }
        }
    }

    /* renamed from: com.b.a.a.r$f */
    static class C37154f extends C31914p {
        final int bFZ;
        final C37157x bGa;
        final boolean bGb;
        final String message;

        /* synthetic */ C37154f(int i, C37157x c37157x, String str, byte b) {
            this(i, c37157x, str);
        }

        private C37154f(int i, C37157x c37157x, String str) {
            super(202);
            AppMethodBeat.m2504i(55545);
            this.bFZ = i;
            this.bGa = c37157x;
            this.message = str;
            boolean z = (this.bFZ < 0 || this.bFZ == 4 || this.bFZ == 2) ? false : true;
            this.bGb = z;
            AppMethodBeat.m2505o(55545);
        }
    }

    /* renamed from: com.b.a.a.r$a */
    static abstract class C37156a implements Runnable {
        private final WeakReference<C37155r> bFR;

        private C37156a(C37155r c37155r) {
            this.bFR = new WeakReference(c37155r);
        }

        /* synthetic */ C37156a(C37155r c37155r, byte b) {
            this(c37155r);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: wn */
        public final C37155r mo59237wn() {
            C37155r c37155r = (C37155r) this.bFR.get();
            if (c37155r != null) {
                return c37155r;
            }
            throw new Exception("OnlineModule.AbstractOnlineModuleRunnable: online module not available");
        }
    }

    static {
        AppMethodBeat.m2504i(55546);
        AppMethodBeat.m2505o(55546);
    }

    private C37155r() {
        AppMethodBeat.m2504i(55547);
        AppMethodBeat.m2505o(55547);
    }

    /* renamed from: wg */
    static C37155r m62256wg() {
        AppMethodBeat.m2504i(55548);
        if (bFF == null) {
            bFF = new C37155r();
        }
        C37155r c37155r = bFF;
        AppMethodBeat.m2505o(55548);
        return c37155r;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: at */
    public final void mo18560at(Context context) {
        AppMethodBeat.m2504i(55549);
        try {
            String str = this.bFQ;
            if (TextUtils.isEmpty(str)) {
                str = "0000000000";
            }
            this.bFG = C37155r.m62252br(str);
            this.bFH = C37155r.m62245a(Long.valueOf(System.currentTimeMillis() / 1000));
            this.bFM = new C37152f(context);
        } catch (Exception e) {
        }
        this.bFL = context.getSharedPreferences("0-474-85242", 0);
        AppMethodBeat.m2505o(55549);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo18557a(Context context, Handler handler, C8483a c8483a) {
        AppMethodBeat.m2504i(55550);
        this.bFK = C37158z.m62269b(handler);
        mo59235wh();
        AppMethodBeat.m2505o(55550);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: au */
    public final void mo18561au(Context context) {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: vV */
    public final void mo18564vV() {
        this.bFP = null;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: wh */
    public final void mo59235wh() {
        AppMethodBeat.m2504i(55551);
        if (this.bFK != null) {
            try {
                this.bFK.execute(C17506d.m27329a(this.bFO));
                AppMethodBeat.m2505o(55551);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(55551);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bp */
    public final void mo59234bp(String str) {
        AppMethodBeat.m2504i(55552);
        if (this.bFK != null) {
            this.bFK.execute(new C17505c(this, str, 0, 1, (byte) 0));
        }
        AppMethodBeat.m2505o(55552);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: wi */
    public final boolean mo59236wi() {
        return this.bFI.code == 1;
    }

    /* renamed from: d */
    private static C37154f m62253d(String str, long j, long j2) {
        AppMethodBeat.m2504i(55553);
        Exception exception;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("errorcode", -5);
            C37154f c37154f;
            if (optInt != 0) {
                c37154f = new C37154f(optInt, null, null, (byte) 0);
                AppMethodBeat.m2505o(55553);
                return c37154f;
            }
            long optLong = jSONObject.optLong("hitarea", 0);
            String str2 = new String(Base64.decode(jSONObject.optString("swdata", null), 0), "UTF-8");
            if (C44978y.bIM) {
                C31913o.m51802s("data_transaction_log_" + C44978y.bIT, str2);
            }
            if (str2.length() <= C37153h.bDl || !str2.startsWith("$UP,")) {
                exception = new Exception("OnlineModule: parse data upload reply and generate msg: invalid arg");
                AppMethodBeat.m2505o(55553);
                throw exception;
            }
            C37154f c37154f2;
            switch (str2.charAt(C37153h.bDl)) {
                case '0':
                    c37154f2 = new C37154f(0, null, str2.length() > C37153h.bDm ? str2.substring(C37153h.bDm) : null, (byte) 0);
                    AppMethodBeat.m2505o(55553);
                    return c37154f2;
                case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                    if (str2.length() > C37153h.bDm) {
                        C37157x f = C37155r.m62254f(str2.substring(C37153h.bDm), optLong);
                        f.bIA = j;
                        f.bFX = j2;
                        c37154f = new C37154f(1, f, null, (byte) 0);
                        AppMethodBeat.m2505o(55553);
                        return c37154f;
                    }
                    break;
                case '2':
                    c37154f2 = new C37154f(2, null, str2.length() > C37153h.bDm ? str2.substring(C37153h.bDm) : null, (byte) 0);
                    AppMethodBeat.m2505o(55553);
                    return c37154f2;
                case '3':
                    c37154f2 = new C37154f(3, null, str2.length() > C37153h.bDm ? str2.substring(C37153h.bDm) : null, (byte) 0);
                    AppMethodBeat.m2505o(55553);
                    return c37154f2;
                case '4':
                    c37154f2 = new C37154f(4, null, str2.length() > C37153h.bDm ? str2.substring(C37153h.bDm) : null, (byte) 0);
                    AppMethodBeat.m2505o(55553);
                    return c37154f2;
                case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                    c37154f2 = new C37154f(5, null, str2.length() > C37153h.bDm ? str2.substring(C37153h.bDm) : null, (byte) 0);
                    AppMethodBeat.m2505o(55553);
                    return c37154f2;
                case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                    c37154f2 = new C37154f(6, null, str2.length() > C37153h.bDm ? str2.substring(C37153h.bDm) : null, (byte) 0);
                    AppMethodBeat.m2505o(55553);
                    return c37154f2;
            }
            exception = new Exception("OnlineModule: unable to parse data upload reply");
            AppMethodBeat.m2505o(55553);
            throw exception;
        } catch (Exception e) {
            if (C44978y.bIM) {
                C31913o.m51802s("data_transaction_log_" + C44978y.bIT, "parse json data error");
            }
            exception = new Exception("parse json data error");
            AppMethodBeat.m2505o(55553);
            throw exception;
        }
    }

    /* renamed from: f */
    private static C37157x m62254f(String str, long j) {
        int i = 0;
        AppMethodBeat.m2504i(55554);
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
                    C37157x c37157x = new C37157x();
                    c37157x.latitude = parseDouble;
                    c37157x.longitude = parseDouble2;
                    c37157x.bIx = split[2];
                    c37157x.level = parseInt;
                    c37157x.bIz = (long) parseInt2;
                    c37157x.bIC = parseInt3;
                    c37157x.bIy = split[6];
                    c37157x.bID = i;
                    c37157x.bEJ = parseFloat;
                    if (c37157x.bIB == null) {
                        c37157x.bIB = new C17509a();
                    }
                    c37157x.bIB.bIE = f;
                    c37157x.bFo = j;
                    AppMethodBeat.m2505o(55554);
                    return c37157x;
                } catch (NumberFormatException e6) {
                }
            }
        }
        Exception exception = new Exception("OnlineModule: unable to get location from data upload reply");
        AppMethodBeat.m2505o(55554);
        throw exception;
    }

    /* renamed from: g */
    private void m62255g(String str, long j) {
        String str2 = null;
        AppMethodBeat.m2504i(55555);
        String str3 = "1";
        if (!(str == null || str.startsWith("&OD[]="))) {
            String bt = C17508v.m27333bt(C17508v.m27334bu(str));
            if (bt == null) {
                bt = null;
            } else {
                bt = bt.replace("&MD=", "|MD,");
            }
            if (bt != null) {
                str2 = bt.replace("&WD[]=", "|WD,");
            }
            str = C17508v.m27331b(str2, j, str3);
        }
        m62251bq(str);
        AppMethodBeat.m2505o(55555);
    }

    /* renamed from: a */
    static /* synthetic */ void m62247a(C37155r c37155r, String str) {
        AppMethodBeat.m2504i(55566);
        c37155r.m62251bq(str);
        AppMethodBeat.m2505o(55566);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: bq */
    private void m62251bq(String str) {
        AppMethodBeat.m2504i(55556);
        if (str == null) {
            AppMethodBeat.m2505o(55556);
            return;
        }
        synchronized (this.bFN) {
            try {
                String stringBuilder = new StringBuilder(String.valueOf(m62259wl().getString("1-115-10127", ""))).append(str).toString();
                int length = stringBuilder.length() - 307200;
                if (length > 0) {
                    int indexOf = stringBuilder.indexOf("&OD[]=", length);
                    stringBuilder = indexOf >= length ? stringBuilder.substring(indexOf) : "";
                }
                if (VERSION.SDK_INT >= 9) {
                    m62259wl().edit().putString("1-115-10127", stringBuilder).apply();
                } else {
                    m62259wl().edit().putString("1-115-10127", stringBuilder).commit();
                }
            } catch (Exception e) {
            } catch (Error e2) {
                try {
                    if (VERSION.SDK_INT >= 9) {
                        m62259wl().edit().putString("1-115-10127", "").apply();
                    } else {
                        m62259wl().edit().putString("1-115-10127", "").commit();
                    }
                } catch (Exception e3) {
                }
            }
            try {
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(55556);
            }
        }
    }

    /* renamed from: wj */
    private String m62257wj() {
        AppMethodBeat.m2504i(55557);
        String string;
        try {
            string = m62259wl().getString("1-115-10127", "");
            AppMethodBeat.m2505o(55557);
            return string;
        } catch (Exception e) {
            string = "";
            AppMethodBeat.m2505o(55557);
            return string;
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: wk */
    private void m62258wk() {
        AppMethodBeat.m2504i(55558);
        try {
            if (VERSION.SDK_INT >= 9) {
                m62259wl().edit().remove("1-115-10127").apply();
                AppMethodBeat.m2505o(55558);
                return;
            }
            m62259wl().edit().remove("1-115-10127").commit();
            AppMethodBeat.m2505o(55558);
        } catch (Exception e) {
            AppMethodBeat.m2505o(55558);
        }
    }

    /* renamed from: wl */
    private SharedPreferences m62259wl() {
        AppMethodBeat.m2504i(55559);
        if (this.bFL == null) {
            Exception exception = new Exception("OnlineModule: data buffer unavailable");
            AppMethodBeat.m2505o(55559);
            throw exception;
        }
        SharedPreferences sharedPreferences = this.bFL;
        AppMethodBeat.m2505o(55559);
        return sharedPreferences;
    }

    /* renamed from: wm */
    private synchronized void m62260wm() {
        AppMethodBeat.m2504i(55560);
        String str = this.bFG;
        String str2 = this.bFH;
        C17504b c17504b = this.bFI;
        if (str == null || str2 == null || c17504b == null) {
            Exception exception = new Exception("OnlineModule: authenticate: null arg");
            AppMethodBeat.m2505o(55560);
            throw exception;
        }
        System.arraycopy(new StringBuilder(String.valueOf(str)).append(str2).toString().getBytes(), 0, c17504b.bFS, 0, 27);
        c17504b.code = 1;
        AppMethodBeat.m2505o(55560);
    }

    /* renamed from: br */
    private static String m62252br(String str) {
        AppMethodBeat.m2504i(55561);
        try {
            String str2 = "T" + bFE.format(Long.parseLong(str) + System.currentTimeMillis());
            AppMethodBeat.m2505o(55561);
            return str2;
        } catch (NumberFormatException e) {
            Exception exception = new Exception("OnlineModule: invalid device id, type: 0");
            AppMethodBeat.m2505o(55561);
            throw exception;
        }
    }

    /* renamed from: a */
    private static String m62245a(Long l) {
        AppMethodBeat.m2504i(55562);
        Exception exception;
        if (l == null) {
            exception = new Exception("OnlineModule: null source id");
            AppMethodBeat.m2505o(55562);
            throw exception;
        }
        try {
            String format = bFD.format(l);
            AppMethodBeat.m2505o(55562);
            return format;
        } catch (NumberFormatException e) {
            exception = new Exception("OnlineModule: invalid source id");
            AppMethodBeat.m2505o(55562);
            throw exception;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static /* synthetic */ void m62249a(C37155r c37155r, String str, long j, long j2, int i, boolean z) {
        AppMethodBeat.m2504i(55564);
        if (c37155r.isRunning) {
            synchronized (c37155r.bFN) {
                try {
                    String stringBuilder;
                    String wj = c37155r.m62257wj();
                    if (str != null) {
                        stringBuilder = new StringBuilder(String.valueOf(str)).append(wj).toString();
                    } else {
                        stringBuilder = wj;
                    }
                    if (stringBuilder.length() > 0) {
                        long ay = C8481aa.m15061ay(j);
                        int i2 = c37155r.bFJ + 1;
                        c37155r.bFJ = i2;
                        String str2 = C44978y.MODE;
                        String str3 = C44978y.bIL;
                        boolean z2 = C44978y.bIN;
                        int i3 = C44978y.bIH;
                        int i4 = C44978y.bII;
                        if (str2 == null || str3 == null) {
                            Exception exception = new Exception("StringBuilding: null mode or user name");
                            AppMethodBeat.m2505o(55564);
                            throw exception;
                        }
                        wj = new StringBuilder(String.valueOf("ST=" + String.valueOf(ay) + ',' + i2 + ',' + str2 + ',' + str3 + ',' + (z2 ? '1' : '0') + ',' + i3 + ',' + i4 + ',' + i)).append(stringBuilder).toString();
                        if (C44978y.bIM) {
                            C31913o.m51802s("data_transaction_log_" + C44978y.bIT, wj);
                        }
                        byte[] encode = Base64.encode(C44976g.compress(wj.getBytes("UTF-8")), 0);
                        byte[] bArr = new byte[(c37155r.bFI.bFS.length + encode.length)];
                        System.arraycopy(c37155r.bFI.bFS, 0, bArr, 0, c37155r.bFI.bFS.length);
                        System.arraycopy(encode, 0, bArr, c37155r.bFI.bFS.length, encode.length);
                        c37155r.bFM.imei = c37155r.bFQ;
                        stringBuilder = new String(c37155r.bFP.httpRequest(c37155r.bFM.mo59233t(bArr).getBytes("UTF-8")));
                        if (C44978y.bIM) {
                            C31913o.m51802s("data_transaction_log_" + C44978y.bIT, stringBuilder);
                        }
                        C37154f d = C37155r.m62253d(stringBuilder, j, j2);
                        if (d.bGb) {
                            c37155r.m62258wk();
                            c37155r.mRetryCount = 0;
                        } else {
                            c37155r.mRetryCount++;
                            int length = c37155r.m62259wl().getString("1-115-10127", "").length();
                            if (c37155r.mRetryCount > 20 || (length > 10240 && c37155r.mRetryCount > 3)) {
                                c37155r.m62258wk();
                            }
                        }
                        if (d.bFZ == 4) {
                            c37155r.bFI.code = -1;
                        }
                        c37155r.mo18562c(d);
                        if (d.bGb) {
                            AppMethodBeat.m2505o(55564);
                            return;
                        }
                    }
                } catch (Exception e) {
                    c37155r.mo18562c(new C37154f(0, null, "connection failure", (byte) 0));
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(55564);
                    }
                }
            }
        }
        if (z) {
            c37155r.m62255g(str, C8481aa.m15061ay(j));
        }
        AppMethodBeat.m2505o(55564);
        if (z) {
        }
        AppMethodBeat.m2505o(55564);
    }
}
