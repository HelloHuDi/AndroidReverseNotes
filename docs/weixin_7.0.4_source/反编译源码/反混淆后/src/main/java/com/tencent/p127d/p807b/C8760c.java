package com.tencent.p127d.p807b;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p127d.p128c.p129a.C0918b;
import com.tencent.p127d.p128c.p129a.C32108c;
import com.tencent.p127d.p132e.p133a.p1165b.C17729a;
import com.tencent.p127d.p132e.p133a.p134a.C25599a;
import com.tencent.p127d.p135f.C0924l;
import com.tencent.p127d.p135f.C25603d;
import com.tencent.p127d.p135f.C25603d.C25604a;
import com.tencent.p127d.p135f.C32114i;
import com.tencent.p127d.p135f.C41670b;
import com.tencent.p127d.p135f.C8768c;

/* renamed from: com.tencent.d.b.c */
public final class C8760c {
    private int ArJ = -1;
    private C32108c ArL = null;
    private Context mContext;
    private String mVersionName = null;

    public C8760c(Context context) {
        AppMethodBeat.m2504i(114475);
        this.mContext = context;
        C25599a cd = C32114i.m52252cd(context, context.getPackageName());
        this.mVersionName = cd.versionName;
        this.ArJ = cd.versionCode;
        AppMethodBeat.m2505o(114475);
    }

    /* renamed from: c */
    public final byte[] mo19821c(String str, String str2, C17729a c17729a) {
        AppMethodBeat.m2504i(114476);
        byte[] bArr = null;
        try {
            C0924l c0924l = new C0924l();
            c0924l.dQJ();
            c0924l.atX(str);
            c0924l.atY(str2);
            c0924l.atW("UTF-8");
            c0924l.put("userInfo", m15587a(c17729a));
            c0924l.put("req", c17729a);
            byte[] compress = C41670b.compress(c0924l.mo3757AL());
            if (compress == null) {
                RuntimeException runtimeException = new RuntimeException("compress data fail");
                AppMethodBeat.m2505o(114476);
                throw runtimeException;
            }
            bArr = C8768c.m15598m(compress, C8768c.dQC());
            AppMethodBeat.m2505o(114476);
            return bArr;
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private C32108c m15587a(C17729a c17729a) {
        AppMethodBeat.m2504i(114477);
        if (this.ArL == null) {
            this.ArL = new C32108c();
            this.ArL.ArW = 82;
            this.ArL.Asb = this.ArJ;
            this.ArL.ArT = c17729a.cIb;
            this.ArL.ArS = c17729a.ArS;
            try {
                int i;
                int i2;
                int i3;
                String[] split = this.mVersionName.trim().split("[\\.]");
                if (split == null || split.length < 3) {
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                } else {
                    i3 = Integer.parseInt(split[0]);
                    i2 = Integer.parseInt(split[1]);
                    i = Integer.parseInt(split[2]);
                }
                this.ArL.ArX = new C0918b();
                this.ArL.ArX.ArP = i3;
                this.ArL.ArX.ArQ = i2;
                this.ArL.ArX.ArR = i;
            } catch (Exception e) {
            }
            this.ArL.ArY = 0;
            this.ArL.Asa = C25603d.dQD();
            this.ArL.imei = C8760c.atO(c17729a.imei);
            this.ArL.imsi = C8760c.atO(c17729a.imsi);
            this.ArL.ArU = C8760c.atO(Build.MODEL);
            this.ArL.qTL = C8760c.atO(C25603d.m40621iL(this.mContext));
            this.ArL.Asg = C8760c.atO(C25603d.m40624ro(true));
            this.ArL.Ash = C8760c.atO(C25603d.m40624ro(false));
            this.ArL.ArZ = 0;
        }
        this.ArL.ArV = getNetworkType();
        this.ArL.guid = C8760c.atO(C25603d.m40623iN(this.mContext));
        C32108c c32108c = this.ArL;
        AppMethodBeat.m2505o(114477);
        return c32108c;
    }

    private int getNetworkType() {
        AppMethodBeat.m2504i(114478);
        try {
            if (C25603d.m40622iM(this.mContext) == C25604a.CONN_WIFI) {
                AppMethodBeat.m2505o(114478);
                return 2;
            }
            AppMethodBeat.m2505o(114478);
            return 1;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(114478);
            return 2;
        }
    }

    private static String atO(String str) {
        return str == null ? "" : str;
    }
}
