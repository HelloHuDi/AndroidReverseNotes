package com.tencent.xweb.p1428a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.C24530n;

/* renamed from: com.tencent.xweb.a.a */
public final class C31137a {
    C24530n ANo;

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Bundle getBundle() {
        int i;
        AppMethodBeat.m2504i(84556);
        if (!(this.ANo == null || this.ANo.getRequestHeaders() == null || this.ANo.isForMainFrame() || !this.ANo.getRequestHeaders().containsKey("Accept"))) {
            String str = (String) this.ANo.getRequestHeaders().get("Accept");
            if (str != null && str.startsWith("text/html")) {
                i = 1;
                if (i == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("resourceType", 1);
                    AppMethodBeat.m2505o(84556);
                    return bundle;
                }
                AppMethodBeat.m2505o(84556);
                return null;
            }
        }
        i = 0;
        if (i == 0) {
        }
    }

    public C31137a(C24530n c24530n) {
        this.ANo = c24530n;
    }
}
