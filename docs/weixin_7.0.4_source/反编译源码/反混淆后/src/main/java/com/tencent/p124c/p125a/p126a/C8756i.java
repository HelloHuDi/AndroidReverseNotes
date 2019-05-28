package com.tencent.p124c.p125a.p126a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

/* renamed from: com.tencent.c.a.a.i */
public class C8756i {
    private static C8756i cbt = null;
    static C45079f cbu = null;
    public static volatile long cbv = 0;
    static C45080h cbw = null;
    public static Context mContext = null;
    public static Handler mHandler = null;
    private C37314g cbx = null;

    /* renamed from: com.tencent.c.a.a.i$1 */
    public class C87571 implements Runnable {
        private final /* synthetic */ String cbz;

        public C87571(String str) {
            this.cbz = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(125770);
            try {
                new StringBuilder("receive data:").append(this.cbz);
                C0916s.m2088zX();
                int i = 100;
                int i2 = 3;
                if (C0916s.m2085co(this.cbz)) {
                    JSONObject jSONObject = new JSONObject(this.cbz);
                    if (!jSONObject.isNull("mid")) {
                        String optString = jSONObject.optString("mid");
                        if (C0916s.m2086cp(optString) && !C0916s.m2086cp(C8756i.this.mo19813zR())) {
                            C8756i.this.cbx.cbr = optString;
                            C8756i.this.cbx.cbq = C0916s.m2078aK(C8756i.mContext);
                            C8756i.this.cbx.bFQ = C0916s.getImei(C8756i.mContext);
                            if (jSONObject.isNull("ts")) {
                                C8756i.this.cbx.cbs = System.currentTimeMillis();
                            } else {
                                long optLong = jSONObject.optLong("ts");
                                if (optLong > 0) {
                                    C8756i.this.cbx.cbs = optLong;
                                }
                            }
                            new StringBuilder("new mid midEntity:").append(C8756i.this.cbx.toString());
                            C0916s.m2088zX();
                            C0914r.m2068aI(C8756i.mContext).mo3746b(C8756i.this.cbx);
                        }
                    }
                    if (!jSONObject.isNull(C25593a.cbb)) {
                        i = jSONObject.getInt(C25593a.cbb);
                    }
                    if (!jSONObject.isNull(C25593a.cbc)) {
                        i2 = jSONObject.getInt(C25593a.cbc);
                    }
                    C0913j.cbA = jSONObject.optInt("disable", 0);
                    C0913j.cbB = jSONObject.optInt("limit", 0);
                }
                C0914r aI = C0914r.m2068aI(C8756i.mContext);
                C25593a zW = aI.mo3748zW();
                if (i > 0) {
                    zW.caX = i;
                }
                if (i2 > 0) {
                    zW.caY = i2;
                }
                zW.caV = System.currentTimeMillis();
                zW.caW = 0;
                aI.mo3745b(zW);
                AppMethodBeat.m2505o(125770);
            } catch (Throwable th) {
                C0916s.m2090zZ();
                AppMethodBeat.m2505o(125770);
            }
        }
    }

    private C8756i(Context context) {
        AppMethodBeat.m2504i(125771);
        HandlerThread handlerThread = new HandlerThread(C8756i.class.getSimpleName());
        handlerThread.start();
        mHandler = new Handler(handlerThread.getLooper());
        Context applicationContext = context.getApplicationContext();
        mContext = applicationContext;
        cbv = PreferenceManager.getDefaultSharedPreferences(applicationContext).getLong("__MID_LAST_CHECK_TIME__", 0);
        AppMethodBeat.m2505o(125771);
    }

    /* renamed from: aG */
    public static C8756i m15580aG(Context context) {
        AppMethodBeat.m2504i(125772);
        if (cbt == null) {
            synchronized (C8756i.class) {
                try {
                    if (cbt == null) {
                        cbt = new C8756i(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(125772);
                    }
                }
            }
        }
        C8756i c8756i = cbt;
        AppMethodBeat.m2505o(125772);
        return c8756i;
    }

    /* renamed from: a */
    public static void m15579a(C45079f c45079f) {
        cbu = c45079f;
    }

    /* renamed from: zR */
    public final String mo19813zR() {
        AppMethodBeat.m2504i(125773);
        if (this.cbx == null || !C0916s.m2086cp(this.cbx.cbr)) {
            int i;
            this.cbx = C0914r.m2068aI(mContext).mo3747zV();
            if (C0916s.m2086cp(this.cbx.cbr)) {
                i = 2;
            } else {
                i = 1;
            }
            if (mHandler != null) {
                mHandler.post(new C32106n(mContext, i));
            }
            new StringBuilder("wx get mid:").append(this.cbx.cbr);
        }
        String str = this.cbx.cbr;
        AppMethodBeat.m2505o(125773);
        return str;
    }

    /* renamed from: zS */
    public final String mo19814zS() {
        AppMethodBeat.m2504i(125774);
        if (this.cbx == null || !C0916s.m2086cp(this.cbx.cbr)) {
            this.cbx = C0914r.m2068aI(mContext).mo3747zV();
        }
        String str = this.cbx.cbr;
        AppMethodBeat.m2505o(125774);
        return str;
    }
}
