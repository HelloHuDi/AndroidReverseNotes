package com.tencent.p177mm.plugin.downloader_app.p377b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.downloader.p723c.p724b.C20310a;
import com.tencent.p177mm.plugin.downloader.p723c.p724b.C27704b;
import com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a.C27701f;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.downloader_app.b.i */
public final class C38861i extends C20337e {
    public String appId = "";
    public String appName;
    public boolean gBF = false;
    public boolean hNO = true;
    public String iconUrl;
    public String jumpUrl;
    public boolean kOZ;
    public String kPa;
    public int kPb = 0;
    public C27704b kPc;
    public C27701f kPd;
    public C20310a kPe;
    public boolean kci = false;
    public String packageName;
    public int position;
    public int type;

    public C38861i(int i) {
        this.type = i;
    }

    public final boolean biN() {
        return this.type == 2 || this.type == 4 || this.type == 6;
    }

    public final int biK() {
        return this.type;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(136146);
        if (obj == null || !(obj instanceof C38861i) || C5046bo.isNullOrNil(((C38861i) obj).appId) || C5046bo.isNullOrNil(this.appId)) {
            AppMethodBeat.m2505o(136146);
            return false;
        }
        boolean equals = ((C38861i) obj).appId.equals(this.appId);
        AppMethodBeat.m2505o(136146);
        return equals;
    }
}
