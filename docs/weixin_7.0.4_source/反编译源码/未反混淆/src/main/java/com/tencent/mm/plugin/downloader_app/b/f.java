package com.tencent.mm.plugin.downloader_app.b;

import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.a.a.b;
import com.tencent.mm.plugin.downloader.c.a.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class f {
    public b kOS;
    private Map<String, i> kOT;
    private LinkedList<i> kOU;
    public com.tencent.mm.plugin.downloader.c.a.a.f kOV;
    private String kOW;

    public f(b bVar) {
        AppMethodBeat.i(136135);
        this.kOT = new HashMap();
        this.kOU = new LinkedList();
        this.kOW = "";
        if (bVar == null) {
            this.kOS = new b();
            AppMethodBeat.o(136135);
            return;
        }
        this.kOS = bVar;
        Kh();
        AppMethodBeat.o(136135);
    }

    public f(byte[] bArr) {
        AppMethodBeat.i(136136);
        this.kOT = new HashMap();
        this.kOU = new LinkedList();
        this.kOW = "";
        this.kOS = new b();
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(136136);
            return;
        }
        try {
            this.kOS.parseFrom(bArr);
        } catch (IOException e) {
            ab.e("MicroMsg.PBAppInfo", "Parsing Failed: %s", e.getMessage());
        }
        Kh();
        AppMethodBeat.o(136136);
    }

    private void Kh() {
        AppMethodBeat.i(136137);
        this.kOV = this.kOS.kKp;
        if (bo.ek(this.kOS.kKo)) {
            AppMethodBeat.o(136137);
            return;
        }
        Iterator it = this.kOS.kKo.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.kKr.kLy == null || dVar.kKr.kLy.kLn == null) {
                ab.e("MicroMsg.PBAppInfo", "download info is null, appid:%s", dVar.kKr.kLw.csB);
            } else {
                i iVar = new i();
                iVar.appId = dVar.kKr.kLw.csB;
                iVar.appName = dVar.kKr.kLw.kKY;
                iVar.iconUrl = dVar.kKr.kLw.kKZ;
                iVar.packageName = dVar.kKr.kLy.kLn.kKO;
                iVar.kPc = dVar.kKr.kLy.kLn;
                iVar.jumpUrl = dVar.kKt != null ? dVar.kKt.kKq : "";
                if (!bo.isNullOrNil(iVar.jumpUrl)) {
                    this.kOW = iVar.jumpUrl;
                }
                iVar.kPa = dVar.kKr.kLy.kLn.kKW;
                iVar.kPe = dVar.kKr.kLA;
                if (j.IM(dVar.kKr.kLw.csB) == k.UN_INSTALLED) {
                    iVar.type = 2;
                } else {
                    PackageInfo packageInfo = com.tencent.mm.plugin.appbrand.r.b.getPackageInfo(ah.getContext(), dVar.kKr.kLy.kLn.kKO);
                    if (packageInfo == null || packageInfo.versionCode >= dVar.kKr.kLy.kLn.kKS) {
                        iVar.type = 6;
                    } else {
                        iVar.type = 4;
                    }
                }
                this.kOT.put(iVar.appId, iVar);
            }
        }
        AppMethodBeat.o(136137);
    }

    public final i IL(String str) {
        AppMethodBeat.i(136138);
        i iVar = (i) this.kOT.get(str);
        AppMethodBeat.o(136138);
        return iVar;
    }

    public final LinkedList<i> O(LinkedList<String> linkedList) {
        AppMethodBeat.i(136139);
        this.kOU.clear();
        if (!bo.ek(linkedList)) {
            i iVar;
            Iterator it = linkedList.iterator();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                iVar = (i) this.kOT.get((String) it.next());
                if (iVar != null) {
                    switch (iVar.type) {
                        case 2:
                            i3++;
                            iVar.position = i3;
                            break;
                        case 4:
                            i2++;
                            iVar.position = i2;
                            break;
                        case 6:
                            i++;
                            iVar.position = i;
                            break;
                    }
                    this.kOU.add(iVar);
                }
                i = i;
            }
            iVar = new i(8);
            iVar.kPd = this.kOV;
            this.kOU.add(iVar);
        }
        LinkedList linkedList2 = this.kOU;
        AppMethodBeat.o(136139);
        return linkedList2;
    }

    public final boolean biL() {
        AppMethodBeat.i(136140);
        if (this.kOT.size() == 0) {
            AppMethodBeat.o(136140);
            return true;
        }
        AppMethodBeat.o(136140);
        return false;
    }
}
