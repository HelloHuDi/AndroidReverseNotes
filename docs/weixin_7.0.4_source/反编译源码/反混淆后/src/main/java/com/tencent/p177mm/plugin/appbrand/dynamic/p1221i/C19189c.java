package com.tencent.p177mm.plugin.appbrand.dynamic.p1221i;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.i.c */
public final class C19189c implements C33163a {
    private String appId;
    private String hcx;
    private String hlm;
    private Map<String, Integer> hoQ = new HashMap();

    public C19189c(String str, String str2) {
        AppMethodBeat.m2504i(10977);
        this.appId = str;
        this.hlm = str2;
        this.hcx = this.hlm + "-" + this.appId;
        AppMethodBeat.m2505o(10977);
    }

    /* renamed from: Al */
    public final void mo34424Al(String str) {
        AppMethodBeat.m2504i(10978);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(10978);
            return;
        }
        Integer num = (Integer) this.hoQ.get(str);
        if (num == null) {
            num = Integer.valueOf(0);
        }
        this.hoQ.put(str, Integer.valueOf(num.intValue() + 1));
        AppMethodBeat.m2505o(10978);
    }

    /* renamed from: IF */
    public final void mo34425IF() {
        AppMethodBeat.m2504i(10979);
        for (Entry entry : this.hoQ.entrySet()) {
            C7060h.pYm.mo8381e(14705, entry.getKey(), entry.getValue(), this.hcx, this.hlm, this.appId);
        }
        this.hoQ.clear();
        AppMethodBeat.m2505o(10979);
    }
}
