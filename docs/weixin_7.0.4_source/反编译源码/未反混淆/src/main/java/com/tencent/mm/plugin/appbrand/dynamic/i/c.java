package com.tencent.mm.plugin.appbrand.dynamic.i;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class c implements a {
    private String appId;
    private String hcx;
    private String hlm;
    private Map<String, Integer> hoQ = new HashMap();

    public c(String str, String str2) {
        AppMethodBeat.i(10977);
        this.appId = str;
        this.hlm = str2;
        this.hcx = this.hlm + "-" + this.appId;
        AppMethodBeat.o(10977);
    }

    public final void Al(String str) {
        AppMethodBeat.i(10978);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(10978);
            return;
        }
        Integer num = (Integer) this.hoQ.get(str);
        if (num == null) {
            num = Integer.valueOf(0);
        }
        this.hoQ.put(str, Integer.valueOf(num.intValue() + 1));
        AppMethodBeat.o(10978);
    }

    public final void IF() {
        AppMethodBeat.i(10979);
        for (Entry entry : this.hoQ.entrySet()) {
            h.pYm.e(14705, entry.getKey(), entry.getValue(), this.hcx, this.hlm, this.appId);
        }
        this.hoQ.clear();
        AppMethodBeat.o(10979);
    }
}
