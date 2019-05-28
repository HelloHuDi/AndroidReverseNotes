package com.tencent.p177mm.plugin.downloader_app.p377b;

import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C19679b;
import com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a.C27701f;
import com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a.C33904d;
import com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a.C42906b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.downloader_app.b.f */
public final class C27715f {
    public C42906b kOS;
    private Map<String, C38861i> kOT;
    private LinkedList<C38861i> kOU;
    public C27701f kOV;
    private String kOW;

    public C27715f(C42906b c42906b) {
        AppMethodBeat.m2504i(136135);
        this.kOT = new HashMap();
        this.kOU = new LinkedList();
        this.kOW = "";
        if (c42906b == null) {
            this.kOS = new C42906b();
            AppMethodBeat.m2505o(136135);
            return;
        }
        this.kOS = c42906b;
        m44023Kh();
        AppMethodBeat.m2505o(136135);
    }

    public C27715f(byte[] bArr) {
        AppMethodBeat.m2504i(136136);
        this.kOT = new HashMap();
        this.kOU = new LinkedList();
        this.kOW = "";
        this.kOS = new C42906b();
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.m2505o(136136);
            return;
        }
        try {
            this.kOS.parseFrom(bArr);
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.PBAppInfo", "Parsing Failed: %s", e.getMessage());
        }
        m44023Kh();
        AppMethodBeat.m2505o(136136);
    }

    /* renamed from: Kh */
    private void m44023Kh() {
        AppMethodBeat.m2504i(136137);
        this.kOV = this.kOS.kKp;
        if (C5046bo.m7548ek(this.kOS.kKo)) {
            AppMethodBeat.m2505o(136137);
            return;
        }
        Iterator it = this.kOS.kKo.iterator();
        while (it.hasNext()) {
            C33904d c33904d = (C33904d) it.next();
            if (c33904d.kKr.kLy == null || c33904d.kKr.kLy.kLn == null) {
                C4990ab.m7413e("MicroMsg.PBAppInfo", "download info is null, appid:%s", c33904d.kKr.kLw.csB);
            } else {
                C38861i c38861i = new C38861i();
                c38861i.appId = c33904d.kKr.kLw.csB;
                c38861i.appName = c33904d.kKr.kLw.kKY;
                c38861i.iconUrl = c33904d.kKr.kLw.kKZ;
                c38861i.packageName = c33904d.kKr.kLy.kLn.kKO;
                c38861i.kPc = c33904d.kKr.kLy.kLn;
                c38861i.jumpUrl = c33904d.kKt != null ? c33904d.kKt.kKq : "";
                if (!C5046bo.isNullOrNil(c38861i.jumpUrl)) {
                    this.kOW = c38861i.jumpUrl;
                }
                c38861i.kPa = c33904d.kKr.kLy.kLn.kKW;
                c38861i.kPe = c33904d.kKr.kLA;
                if (C45837j.m84845IM(c33904d.kKr.kLw.csB) == C38862k.UN_INSTALLED) {
                    c38861i.type = 2;
                } else {
                    PackageInfo packageInfo = C19679b.getPackageInfo(C4996ah.getContext(), c33904d.kKr.kLy.kLn.kKO);
                    if (packageInfo == null || packageInfo.versionCode >= c33904d.kKr.kLy.kLn.kKS) {
                        c38861i.type = 6;
                    } else {
                        c38861i.type = 4;
                    }
                }
                this.kOT.put(c38861i.appId, c38861i);
            }
        }
        AppMethodBeat.m2505o(136137);
    }

    /* renamed from: IL */
    public final C38861i mo45550IL(String str) {
        AppMethodBeat.m2504i(136138);
        C38861i c38861i = (C38861i) this.kOT.get(str);
        AppMethodBeat.m2505o(136138);
        return c38861i;
    }

    /* renamed from: O */
    public final LinkedList<C38861i> mo45551O(LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(136139);
        this.kOU.clear();
        if (!C5046bo.m7548ek(linkedList)) {
            C38861i c38861i;
            Iterator it = linkedList.iterator();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                c38861i = (C38861i) this.kOT.get((String) it.next());
                if (c38861i != null) {
                    switch (c38861i.type) {
                        case 2:
                            i3++;
                            c38861i.position = i3;
                            break;
                        case 4:
                            i2++;
                            c38861i.position = i2;
                            break;
                        case 6:
                            i++;
                            c38861i.position = i;
                            break;
                    }
                    this.kOU.add(c38861i);
                }
                i = i;
            }
            c38861i = new C38861i(8);
            c38861i.kPd = this.kOV;
            this.kOU.add(c38861i);
        }
        LinkedList linkedList2 = this.kOU;
        AppMethodBeat.m2505o(136139);
        return linkedList2;
    }

    public final boolean biL() {
        AppMethodBeat.m2504i(136140);
        if (this.kOT.size() == 0) {
            AppMethodBeat.m2505o(136140);
            return true;
        }
        AppMethodBeat.m2505o(136140);
        return false;
    }
}
