package com.tencent.d.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.d.c.b.d;
import com.tencent.d.d.a.b;
import com.tencent.d.d.a.c;
import com.tencent.d.d.a.e;
import com.tencent.d.d.a.f;
import com.tencent.d.d.a.g;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public b ArH;
    public Context mContext = null;

    public a(Context context) {
        AppMethodBeat.i(114469);
        this.mContext = context;
        this.ArH = new b(context);
        AppMethodBeat.o(114469);
    }

    public static d dQj() {
        AppMethodBeat.i(114470);
        d dVar = new d();
        try {
            int i;
            dVar.AsX = Build.FINGERPRINT;
            dVar.AsY = com.tencent.d.f.d.dQE();
            dVar.fwM = Build.BRAND;
            dVar.model = Build.MODEL;
            dVar.AsZ = VERSION.SDK_INT;
            dVar.Ata = Build.CPU_ABI;
            dVar.platform = com.tencent.d.f.d.atU("ro.board.platform");
            if (f.dQn()) {
                i = 2;
            } else {
                Object obj;
                List<com.tencent.d.d.b.d.a> dQo = com.tencent.d.d.b.d.dQo();
                if (dQo.isEmpty()) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    ArrayList<b> arrayList = new ArrayList(3);
                    arrayList.add(new g());
                    arrayList.add(new com.tencent.d.d.a.d());
                    if (com.tencent.d.d.b.f.dQp()) {
                        arrayList.add(new c());
                    }
                    for (com.tencent.d.d.b.d.a aVar : dQo) {
                        if (aVar != null) {
                            for (b a : arrayList) {
                                a.a(aVar);
                            }
                        }
                    }
                    for (b dQl : arrayList) {
                        if (dQl.dQl()) {
                            obj = 1;
                            break;
                        }
                    }
                }
                obj = null;
                if (obj != null) {
                    i = 2;
                } else if (e.dQm()) {
                    i = 1;
                } else {
                    if (!com.tencent.d.d.a.a.atP("/system/bin/debuggerd")) {
                        obj = 1;
                    } else if (!com.tencent.d.d.a.a.atP("/system/bin/debuggerd64")) {
                        i = 1;
                    } else if (!com.tencent.d.d.a.a.atP("/system/bin/ddexe")) {
                        i = 1;
                    } else if (!com.tencent.d.d.a.a.atQ("/system/etc/install-recovery.sh")) {
                        i = 1;
                    } else if (com.tencent.d.d.a.a.atQ("/system/bin/install-recovery.sh")) {
                        h.dQG();
                        obj = null;
                    } else {
                        i = 1;
                    }
                    if (obj != null) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                }
            }
            dVar.Atb = i;
        } catch (Exception e) {
        }
        AppMethodBeat.o(114470);
        return dVar;
    }

    public static com.tencent.d.c.b.b a(Context context, com.tencent.d.a.a aVar, int i) {
        AppMethodBeat.i(114471);
        if (aVar == null) {
            AppMethodBeat.o(114471);
            return null;
        }
        com.tencent.d.c.b.b bVar = new com.tencent.d.c.b.b();
        bVar.Asp = i;
        bVar.Asq = null;
        bVar.Asr = aVar.ceO;
        bVar.Ass = com.tencent.d.f.e.atV(aVar.ArC);
        List<byte[]> cb = com.tencent.d.f.a.cb(context, aVar.ceO);
        if (cb.size() > 1) {
            bVar.AsH = new ArrayList();
            for (byte[] add : cb) {
                bVar.AsH.add(add);
            }
        }
        bVar.Ast = aVar.fileSize;
        bVar.Asu = aVar.ArB;
        bVar.Asv = aVar.versionCode;
        bVar.Asw = aVar.versionName;
        bVar.Asx = 0;
        if (aVar.egi == 1) {
            bVar.Asx |= 1;
        }
        bVar.Asx |= 2;
        if (!(aVar.ArD.startsWith("/data") || aVar.ArD.startsWith("/system"))) {
            bVar.Asx |= 4;
        }
        bVar.Asy = "";
        bVar.Asz = 0;
        bVar.AsA = 0;
        bVar.AsB = 0;
        bVar.AsC = null;
        bVar.AsD = 0;
        bVar.AsE = false;
        bVar.AsF = 0;
        bVar.AsG = 0;
        AppMethodBeat.o(114471);
        return bVar;
    }
}
