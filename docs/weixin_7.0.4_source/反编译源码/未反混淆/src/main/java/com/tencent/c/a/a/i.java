package com.tencent.c.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class i {
    private static i cbt = null;
    static f cbu = null;
    public static volatile long cbv = 0;
    static h cbw = null;
    public static Context mContext = null;
    public static Handler mHandler = null;
    private g cbx = null;

    /* renamed from: com.tencent.c.a.a.i$1 */
    public class AnonymousClass1 implements Runnable {
        private final /* synthetic */ String cbz;

        public AnonymousClass1(String str) {
            this.cbz = str;
        }

        public final void run() {
            AppMethodBeat.i(125770);
            try {
                new StringBuilder("receive data:").append(this.cbz);
                s.zX();
                int i = 100;
                int i2 = 3;
                if (s.co(this.cbz)) {
                    JSONObject jSONObject = new JSONObject(this.cbz);
                    if (!jSONObject.isNull("mid")) {
                        String optString = jSONObject.optString("mid");
                        if (s.cp(optString) && !s.cp(i.this.zR())) {
                            i.this.cbx.cbr = optString;
                            i.this.cbx.cbq = s.aK(i.mContext);
                            i.this.cbx.bFQ = s.getImei(i.mContext);
                            if (jSONObject.isNull("ts")) {
                                i.this.cbx.cbs = System.currentTimeMillis();
                            } else {
                                long optLong = jSONObject.optLong("ts");
                                if (optLong > 0) {
                                    i.this.cbx.cbs = optLong;
                                }
                            }
                            new StringBuilder("new mid midEntity:").append(i.this.cbx.toString());
                            s.zX();
                            r.aI(i.mContext).b(i.this.cbx);
                        }
                    }
                    if (!jSONObject.isNull(a.cbb)) {
                        i = jSONObject.getInt(a.cbb);
                    }
                    if (!jSONObject.isNull(a.cbc)) {
                        i2 = jSONObject.getInt(a.cbc);
                    }
                    j.cbA = jSONObject.optInt("disable", 0);
                    j.cbB = jSONObject.optInt("limit", 0);
                }
                r aI = r.aI(i.mContext);
                a zW = aI.zW();
                if (i > 0) {
                    zW.caX = i;
                }
                if (i2 > 0) {
                    zW.caY = i2;
                }
                zW.caV = System.currentTimeMillis();
                zW.caW = 0;
                aI.b(zW);
                AppMethodBeat.o(125770);
            } catch (Throwable th) {
                s.zZ();
                AppMethodBeat.o(125770);
            }
        }
    }

    private i(Context context) {
        AppMethodBeat.i(125771);
        HandlerThread handlerThread = new HandlerThread(i.class.getSimpleName());
        handlerThread.start();
        mHandler = new Handler(handlerThread.getLooper());
        Context applicationContext = context.getApplicationContext();
        mContext = applicationContext;
        cbv = PreferenceManager.getDefaultSharedPreferences(applicationContext).getLong("__MID_LAST_CHECK_TIME__", 0);
        AppMethodBeat.o(125771);
    }

    public static i aG(Context context) {
        AppMethodBeat.i(125772);
        if (cbt == null) {
            synchronized (i.class) {
                try {
                    if (cbt == null) {
                        cbt = new i(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(125772);
                    }
                }
            }
        }
        i iVar = cbt;
        AppMethodBeat.o(125772);
        return iVar;
    }

    public static void a(f fVar) {
        cbu = fVar;
    }

    public final String zR() {
        AppMethodBeat.i(125773);
        if (this.cbx == null || !s.cp(this.cbx.cbr)) {
            int i;
            this.cbx = r.aI(mContext).zV();
            if (s.cp(this.cbx.cbr)) {
                i = 2;
            } else {
                i = 1;
            }
            if (mHandler != null) {
                mHandler.post(new n(mContext, i));
            }
            new StringBuilder("wx get mid:").append(this.cbx.cbr);
        }
        String str = this.cbx.cbr;
        AppMethodBeat.o(125773);
        return str;
    }

    public final String zS() {
        AppMethodBeat.i(125774);
        if (this.cbx == null || !s.cp(this.cbx.cbr)) {
            this.cbx = r.aI(mContext).zV();
        }
        String str = this.cbx.cbr;
        AppMethodBeat.o(125774);
        return str;
    }
}
