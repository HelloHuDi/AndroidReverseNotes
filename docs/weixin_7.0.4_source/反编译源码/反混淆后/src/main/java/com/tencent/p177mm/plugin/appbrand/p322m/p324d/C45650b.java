package com.tencent.p177mm.plugin.appbrand.p322m.p324d;

import com.tencent.luggage.sdk.p148b.C25697b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C42627e;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C42627e.C38438a;
import com.tencent.p177mm.plugin.appbrand.permission.C33491e;
import com.tencent.p177mm.plugin.appbrand.permission.C33491e.C33492c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.m.d.b */
public final class C45650b extends C42627e {
    private C33492c iql;

    /* renamed from: com.tencent.mm.plugin.appbrand.m.d.b$1 */
    class C271951 implements C33492c {
        C271951() {
        }

        /* renamed from: f */
        public final void mo44862f(byte[] bArr, byte[] bArr2) {
            AppMethodBeat.m2504i(102207);
            C4990ab.m7416i("MicroMsg.ProxyOnPermissionUpdateListener", "onUpdate");
            HashMap hashMap = new HashMap();
            hashMap.put("fg", bArr);
            hashMap.put("bg", bArr2);
            C45650b.this.mo68067D(hashMap);
            AppMethodBeat.m2505o(102207);
        }
    }

    public C45650b(C38438a c38438a, C38492q c38492q) {
        super(c38438a, c38492q);
    }

    public final void aIV() {
        AppMethodBeat.m2504i(102208);
        C33491e xY = ((C25697b) this.gMN.getRuntime()).mo43488xY();
        if (xY == null) {
            C4990ab.m7412e("MicroMsg.ProxyOnPermissionUpdateListener", "AppRuntimeApiPermissionController null");
            AppMethodBeat.m2505o(102208);
            return;
        }
        this.iql = new C271951();
        C33492c c33492c = this.iql;
        synchronized (xY.iwO) {
            try {
                xY.iwQ.add(c33492c);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(102208);
            }
        }
    }

    public final void removeListener() {
        AppMethodBeat.m2504i(102209);
        if (this.iql == null) {
            AppMethodBeat.m2505o(102209);
        } else if (this.gMN.getRuntime() == null) {
            AppMethodBeat.m2505o(102209);
        } else {
            C33491e xY = ((C25697b) this.gMN.getRuntime()).mo43488xY();
            if (xY == null) {
                AppMethodBeat.m2505o(102209);
                return;
            }
            C33492c c33492c = this.iql;
            synchronized (xY.iwO) {
                try {
                    xY.iwQ.remove(c33492c);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(102209);
                }
            }
        }
    }

    public final int getType() {
        return 3;
    }
}
