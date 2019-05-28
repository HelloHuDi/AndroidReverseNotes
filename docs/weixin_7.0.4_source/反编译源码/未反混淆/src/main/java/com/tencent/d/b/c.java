package com.tencent.d.b;

import android.content.Context;
import android.os.Build;
import com.tencent.d.e.a.a.a;
import com.tencent.d.f.b;
import com.tencent.d.f.d;
import com.tencent.d.f.i;
import com.tencent.d.f.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    private int ArJ = -1;
    private com.tencent.d.c.a.c ArL = null;
    private Context mContext;
    private String mVersionName = null;

    public c(Context context) {
        AppMethodBeat.i(114475);
        this.mContext = context;
        a cd = i.cd(context, context.getPackageName());
        this.mVersionName = cd.versionName;
        this.ArJ = cd.versionCode;
        AppMethodBeat.o(114475);
    }

    public final byte[] c(String str, String str2, com.tencent.d.e.a.b.a aVar) {
        AppMethodBeat.i(114476);
        byte[] bArr = null;
        try {
            l lVar = new l();
            lVar.dQJ();
            lVar.atX(str);
            lVar.atY(str2);
            lVar.atW("UTF-8");
            lVar.put("userInfo", a(aVar));
            lVar.put("req", aVar);
            byte[] compress = b.compress(lVar.AL());
            if (compress == null) {
                RuntimeException runtimeException = new RuntimeException("compress data fail");
                AppMethodBeat.o(114476);
                throw runtimeException;
            }
            bArr = com.tencent.d.f.c.m(compress, com.tencent.d.f.c.dQC());
            AppMethodBeat.o(114476);
            return bArr;
        } catch (Exception e) {
        }
    }

    private com.tencent.d.c.a.c a(com.tencent.d.e.a.b.a aVar) {
        AppMethodBeat.i(114477);
        if (this.ArL == null) {
            this.ArL = new com.tencent.d.c.a.c();
            this.ArL.ArW = 82;
            this.ArL.Asb = this.ArJ;
            this.ArL.ArT = aVar.cIb;
            this.ArL.ArS = aVar.ArS;
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
                this.ArL.ArX = new com.tencent.d.c.a.b();
                this.ArL.ArX.ArP = i3;
                this.ArL.ArX.ArQ = i2;
                this.ArL.ArX.ArR = i;
            } catch (Exception e) {
            }
            this.ArL.ArY = 0;
            this.ArL.Asa = d.dQD();
            this.ArL.imei = atO(aVar.imei);
            this.ArL.imsi = atO(aVar.imsi);
            this.ArL.ArU = atO(Build.MODEL);
            this.ArL.qTL = atO(d.iL(this.mContext));
            this.ArL.Asg = atO(d.ro(true));
            this.ArL.Ash = atO(d.ro(false));
            this.ArL.ArZ = 0;
        }
        this.ArL.ArV = getNetworkType();
        this.ArL.guid = atO(d.iN(this.mContext));
        com.tencent.d.c.a.c cVar = this.ArL;
        AppMethodBeat.o(114477);
        return cVar;
    }

    private int getNetworkType() {
        AppMethodBeat.i(114478);
        try {
            if (d.iM(this.mContext) == d.a.CONN_WIFI) {
                AppMethodBeat.o(114478);
                return 2;
            }
            AppMethodBeat.o(114478);
            return 1;
        } catch (Throwable th) {
            AppMethodBeat.o(114478);
            return 2;
        }
    }

    private static String atO(String str) {
        return str == null ? "" : str;
    }
}
