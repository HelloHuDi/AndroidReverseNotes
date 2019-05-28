package com.tencent.p124c.p125a.p126a;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: com.tencent.c.a.a.b */
final class C8754b {
    static C8755a cbd;
    Integer cbe = null;
    String cbf = null;

    /* renamed from: com.tencent.c.a.a.b$a */
    static class C8755a {
        String aOt;
        String appVersion;
        String cbg;
        DisplayMetrics cbh;
        int cbi;
        String cbj;
        String cbk;
        String cbl;
        int cbm;
        String cbn;
        String cbo;
        String channel;
        Context ctx;
        String imsi;
        String model;
        String packageName;
        String timezone;

        private C8755a(Context context) {
            AppMethodBeat.m2504i(125744);
            this.cbg = "2.21";
            this.cbi = VERSION.SDK_INT;
            this.model = Build.MODEL;
            this.cbj = Build.MANUFACTURER;
            this.aOt = Locale.getDefault().getLanguage();
            this.channel = "WX";
            this.cbm = 0;
            this.packageName = null;
            this.ctx = null;
            this.cbn = null;
            this.cbo = null;
            this.ctx = context.getApplicationContext();
            try {
                this.appVersion = this.ctx.getPackageManager().getPackageInfo(this.ctx.getPackageName(), 0).versionName;
            } catch (NameNotFoundException e) {
                C0916s.m2089zY();
            }
            this.cbh = new DisplayMetrics();
            ((WindowManager) this.ctx.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(this.cbh);
            if (C0916s.m2087q(context, "android.permission.READ_PHONE_STATE")) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    this.cbk = telephonyManager.getSimOperator();
                    this.imsi = telephonyManager.getSubscriberId();
                }
            }
            this.timezone = TimeZone.getDefault().getID();
            this.cbl = C0916s.m2082aO(this.ctx);
            this.packageName = this.ctx.getPackageName();
            this.cbo = C0916s.m2074Aa();
            AppMethodBeat.m2505o(125744);
        }

        /* synthetic */ C8755a(Context context, byte b) {
            this(context);
        }
    }

    /* renamed from: aF */
    private static synchronized C8755a m15577aF(Context context) {
        C8755a c8755a;
        synchronized (C8754b.class) {
            AppMethodBeat.m2504i(125745);
            if (cbd == null) {
                cbd = new C8755a(context.getApplicationContext(), (byte) 0);
            }
            c8755a = cbd;
            AppMethodBeat.m2505o(125745);
        }
        return c8755a;
    }

    public C8754b(Context context) {
        AppMethodBeat.m2504i(125746);
        try {
            C8754b.m15577aF(context);
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                this.cbe = Integer.valueOf(telephonyManager.getNetworkType());
            }
            this.cbf = C0916s.m2083aP(context);
            AppMethodBeat.m2505o(125746);
        } catch (Throwable th) {
            C0916s.m2089zY();
            AppMethodBeat.m2505o(125746);
        }
    }
}
