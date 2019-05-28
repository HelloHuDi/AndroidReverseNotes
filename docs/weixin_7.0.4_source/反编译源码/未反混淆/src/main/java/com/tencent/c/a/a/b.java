package com.tencent.c.a.a;

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

final class b {
    static a cbd;
    Integer cbe = null;
    String cbf = null;

    static class a {
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

        private a(Context context) {
            AppMethodBeat.i(125744);
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
                s.zY();
            }
            this.cbh = new DisplayMetrics();
            ((WindowManager) this.ctx.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(this.cbh);
            if (s.q(context, "android.permission.READ_PHONE_STATE")) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    this.cbk = telephonyManager.getSimOperator();
                    this.imsi = telephonyManager.getSubscriberId();
                }
            }
            this.timezone = TimeZone.getDefault().getID();
            this.cbl = s.aO(this.ctx);
            this.packageName = this.ctx.getPackageName();
            this.cbo = s.Aa();
            AppMethodBeat.o(125744);
        }

        /* synthetic */ a(Context context, byte b) {
            this(context);
        }
    }

    private static synchronized a aF(Context context) {
        a aVar;
        synchronized (b.class) {
            AppMethodBeat.i(125745);
            if (cbd == null) {
                cbd = new a(context.getApplicationContext(), (byte) 0);
            }
            aVar = cbd;
            AppMethodBeat.o(125745);
        }
        return aVar;
    }

    public b(Context context) {
        AppMethodBeat.i(125746);
        try {
            aF(context);
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                this.cbe = Integer.valueOf(telephonyManager.getNetworkType());
            }
            this.cbf = s.aP(context);
            AppMethodBeat.o(125746);
        } catch (Throwable th) {
            s.zY();
            AppMethodBeat.o(125746);
        }
    }
}
