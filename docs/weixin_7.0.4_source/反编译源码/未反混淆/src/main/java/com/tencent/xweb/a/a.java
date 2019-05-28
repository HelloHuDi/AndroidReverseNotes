package com.tencent.xweb.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.n;

public final class a {
    n ANo;

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Bundle getBundle() {
        int i;
        AppMethodBeat.i(84556);
        if (!(this.ANo == null || this.ANo.getRequestHeaders() == null || this.ANo.isForMainFrame() || !this.ANo.getRequestHeaders().containsKey("Accept"))) {
            String str = (String) this.ANo.getRequestHeaders().get("Accept");
            if (str != null && str.startsWith("text/html")) {
                i = 1;
                if (i == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("resourceType", 1);
                    AppMethodBeat.o(84556);
                    return bundle;
                }
                AppMethodBeat.o(84556);
                return null;
            }
        }
        i = 0;
        if (i == 0) {
        }
    }

    public a(n nVar) {
        this.ANo = nVar;
    }
}
