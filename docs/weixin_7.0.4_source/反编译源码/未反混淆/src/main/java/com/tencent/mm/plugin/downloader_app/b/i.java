package com.tencent.mm.plugin.downloader_app.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.a.a.f;
import com.tencent.mm.plugin.downloader.c.b.a;
import com.tencent.mm.plugin.downloader.c.b.b;
import com.tencent.mm.sdk.platformtools.bo;

public final class i extends e {
    public String appId = "";
    public String appName;
    public boolean gBF = false;
    public boolean hNO = true;
    public String iconUrl;
    public String jumpUrl;
    public boolean kOZ;
    public String kPa;
    public int kPb = 0;
    public b kPc;
    public f kPd;
    public a kPe;
    public boolean kci = false;
    public String packageName;
    public int position;
    public int type;

    public i(int i) {
        this.type = i;
    }

    public final boolean biN() {
        return this.type == 2 || this.type == 4 || this.type == 6;
    }

    public final int biK() {
        return this.type;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(136146);
        if (obj == null || !(obj instanceof i) || bo.isNullOrNil(((i) obj).appId) || bo.isNullOrNil(this.appId)) {
            AppMethodBeat.o(136146);
            return false;
        }
        boolean equals = ((i) obj).appId.equals(this.appId);
        AppMethodBeat.o(136146);
        return equals;
    }
}
