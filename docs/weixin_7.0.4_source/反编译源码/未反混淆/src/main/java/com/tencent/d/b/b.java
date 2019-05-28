package com.tencent.d.b;

import android.content.Context;
import android.os.Build;
import com.tencent.d.c.a.a;
import com.tencent.d.c.a.c;
import com.tencent.d.f.d;
import com.tencent.d.f.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    private int ArI = -1;
    private int ArJ = -1;
    private String ArK = null;
    private c ArL = null;
    private a ArM = null;
    private String mChannelId = null;
    private Context mContext = null;
    private String mVersionName = null;

    public b(Context context) {
        AppMethodBeat.i(114472);
        this.mContext = context;
        com.tencent.d.a.a cc = com.tencent.d.f.a.cc(context, context.getPackageName());
        this.mVersionName = cc.versionName;
        this.ArJ = cc.versionCode;
        this.ArI = 82;
        this.mChannelId = "105901";
        this.ArK = "7AD75E27CD5842F6";
        AppMethodBeat.o(114472);
    }

    public final byte[] a(com.tencent.d.c.b.a aVar) {
        AppMethodBeat.i(114473);
        byte[] bArr = null;
        try {
            l lVar = new l();
            lVar.dQJ();
            lVar.atX("viruscheck");
            lVar.atY("RiskCheck");
            lVar.atW("UTF-8");
            String str = "phonetype";
            if (this.ArM == null) {
                this.ArM = new a();
                this.ArM.ArN = 2;
                this.ArM.ArO = 201;
            }
            lVar.put(str, this.ArM);
            lVar.put("userinfo", dQk());
            lVar.put("req", aVar);
            byte[] compress = com.tencent.d.f.b.compress(lVar.AL());
            if (compress == null) {
                RuntimeException runtimeException = new RuntimeException("compress data fail");
                AppMethodBeat.o(114473);
                throw runtimeException;
            }
            bArr = com.tencent.d.f.c.m(compress, com.tencent.d.f.c.dQC());
            AppMethodBeat.o(114473);
            return bArr;
        } catch (Exception e) {
        }
    }

    private c dQk() {
        int i = 2;
        AppMethodBeat.i(114474);
        if (this.ArL == null) {
            this.ArL = new c();
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
                this.ArL.ArX = new com.tencent.d.c.a.b();
                this.ArL.ArX.ArP = i4;
                this.ArL.ArX.ArQ = i3;
                this.ArL.ArX.ArR = i2;
            } catch (Exception e) {
            }
            this.ArL.ArY = 0;
            this.ArL.Asa = d.dQD();
            this.ArL.imei = atO(d.getIMEI(this.mContext));
            this.ArL.imsi = atO(d.iK(this.mContext));
            this.ArL.ArU = atO(Build.MODEL);
            this.ArL.qTL = atO(d.iL(this.mContext));
            this.ArL.Asg = atO(d.ro(true));
            this.ArL.Ash = atO(d.ro(false));
            this.ArL.guid = null;
            this.ArL.ArZ = 0;
        }
        c cVar = this.ArL;
        if (d.iM(this.mContext) != d.a.CONN_WIFI) {
            i = 1;
        }
        cVar.ArV = i;
        c cVar2 = this.ArL;
        AppMethodBeat.o(114474);
        return cVar2;
    }

    private static String atO(String str) {
        return str == null ? "" : str;
    }
}
