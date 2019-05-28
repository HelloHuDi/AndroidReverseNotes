package com.tencent.p127d.p807b;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p127d.p1164a.C41659a;
import com.tencent.p127d.p128c.p129a.C0917a;
import com.tencent.p127d.p128c.p129a.C0918b;
import com.tencent.p127d.p128c.p129a.C32108c;
import com.tencent.p127d.p128c.p1450b.C41203a;
import com.tencent.p127d.p135f.C0924l;
import com.tencent.p127d.p135f.C25603d;
import com.tencent.p127d.p135f.C25603d.C25604a;
import com.tencent.p127d.p135f.C41669a;
import com.tencent.p127d.p135f.C41670b;
import com.tencent.p127d.p135f.C8768c;

/* renamed from: com.tencent.d.b.b */
public final class C25596b {
    private int ArI = -1;
    private int ArJ = -1;
    private String ArK = null;
    private C32108c ArL = null;
    private C0917a ArM = null;
    private String mChannelId = null;
    private Context mContext = null;
    private String mVersionName = null;

    public C25596b(Context context) {
        AppMethodBeat.m2504i(114472);
        this.mContext = context;
        C41659a cc = C41669a.m73070cc(context, context.getPackageName());
        this.mVersionName = cc.versionName;
        this.ArJ = cc.versionCode;
        this.ArI = 82;
        this.mChannelId = "105901";
        this.ArK = "7AD75E27CD5842F6";
        AppMethodBeat.m2505o(114472);
    }

    /* renamed from: a */
    public final byte[] mo43325a(C41203a c41203a) {
        AppMethodBeat.m2504i(114473);
        byte[] bArr = null;
        try {
            C0924l c0924l = new C0924l();
            c0924l.dQJ();
            c0924l.atX("viruscheck");
            c0924l.atY("RiskCheck");
            c0924l.atW("UTF-8");
            String str = "phonetype";
            if (this.ArM == null) {
                this.ArM = new C0917a();
                this.ArM.ArN = 2;
                this.ArM.ArO = 201;
            }
            c0924l.put(str, this.ArM);
            c0924l.put("userinfo", dQk());
            c0924l.put("req", c41203a);
            byte[] compress = C41670b.compress(c0924l.mo3757AL());
            if (compress == null) {
                RuntimeException runtimeException = new RuntimeException("compress data fail");
                AppMethodBeat.m2505o(114473);
                throw runtimeException;
            }
            bArr = C8768c.m15598m(compress, C8768c.dQC());
            AppMethodBeat.m2505o(114473);
            return bArr;
        } catch (Exception e) {
        }
    }

    private C32108c dQk() {
        int i = 2;
        AppMethodBeat.m2504i(114474);
        if (this.ArL == null) {
            this.ArL = new C32108c();
            this.ArL.ArW = this.ArI;
            this.ArL.Asb = this.ArJ;
            this.ArL.ArT = this.mChannelId;
            this.ArL.ArS = this.ArK;
            try {
                int i2;
                int i3;
                int i4;
                String[] split = this.mVersionName.trim().split("[\\.]");
                if (split == null || split.length < 3) {
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                } else {
                    i4 = Integer.parseInt(split[0]);
                    i3 = Integer.parseInt(split[1]);
                    i2 = Integer.parseInt(split[2]);
                }
                this.ArL.ArX = new C0918b();
                this.ArL.ArX.ArP = i4;
                this.ArL.ArX.ArQ = i3;
                this.ArL.ArX.ArR = i2;
            } catch (Exception e) {
            }
            this.ArL.ArY = 0;
            this.ArL.Asa = C25603d.dQD();
            this.ArL.imei = C25596b.atO(C25603d.getIMEI(this.mContext));
            this.ArL.imsi = C25596b.atO(C25603d.m40620iK(this.mContext));
            this.ArL.ArU = C25596b.atO(Build.MODEL);
            this.ArL.qTL = C25596b.atO(C25603d.m40621iL(this.mContext));
            this.ArL.Asg = C25596b.atO(C25603d.m40624ro(true));
            this.ArL.Ash = C25596b.atO(C25603d.m40624ro(false));
            this.ArL.guid = null;
            this.ArL.ArZ = 0;
        }
        C32108c c32108c = this.ArL;
        if (C25603d.m40622iM(this.mContext) != C25604a.CONN_WIFI) {
            i = 1;
        }
        c32108c.ArV = i;
        C32108c c32108c2 = this.ArL;
        AppMethodBeat.m2505o(114474);
        return c32108c2;
    }

    private static String atO(String str) {
        return str == null ? "" : str;
    }
}
