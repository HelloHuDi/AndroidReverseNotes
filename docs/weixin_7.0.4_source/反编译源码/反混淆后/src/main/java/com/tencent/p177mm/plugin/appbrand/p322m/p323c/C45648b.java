package com.tencent.p177mm.plugin.appbrand.p322m.p323c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C41726i;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19092p;
import com.tencent.p177mm.plugin.appbrand.appstorage.C33102s;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42368m;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C19597c;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C42626d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.m.c.b */
public final class C45648b extends C42626d {
    private C42368m iqe = null;

    public final int aIT() {
        return 7;
    }

    /* renamed from: b */
    public final String mo61136b(C41726i c41726i, C19597c c19597c) {
        AppMethodBeat.m2504i(102193);
        C38492q c38492q = c19597c.gMN;
        if (this.iqe == null) {
            C6750i runtime = c38492q.getRuntime();
            if (c38492q.getRuntime().asE() instanceof C33102s) {
                LinkedList linkedList = ((C33102s) runtime.asE()).gYd;
                for (int i = 0; i < linkedList.size(); i++) {
                    C19092p c19092p = (C19092p) linkedList.get(i);
                    if (c19092p instanceof C42368m) {
                        this.iqe = (C42368m) c19092p;
                        break;
                    }
                }
            } else {
                IllegalStateException illegalStateException = new IllegalStateException("getFlattenFileSystem not LuggageFileSystemRegistry");
                AppMethodBeat.m2505o(102193);
                throw illegalStateException;
            }
        }
        C42368m c42368m = this.iqe;
        Object obj = null;
        if (c42368m != null) {
            obj = c42368m.mo67883yl(c41726i.optString("path"));
        } else {
            C4990ab.m7412e("MicroMsg.GetFullPathOfFlatFSSync", "getFlattenFileSystem null");
        }
        C4990ab.m7411d("MicroMsg.GetFullPathOfFlatFSSync", "path:%s fullPath:%s", c41726i.optString("path"), obj);
        HashMap hashMap = new HashMap();
        hashMap.put("fullPath", obj);
        String B = c19597c.mo34803B(hashMap);
        AppMethodBeat.m2505o(102193);
        return B;
    }
}
