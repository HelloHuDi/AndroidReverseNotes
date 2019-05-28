package com.tencent.p177mm.plugin.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.plugin.mmsight.api.C46074a;
import com.tencent.p177mm.plugin.mmsight.api.C46074a.C43300b;
import com.tencent.p177mm.plugin.mmsight.model.p995b.C28504c;
import com.tencent.p177mm.plugin.mmsight.model.p995b.C39381b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.api.a */
public final class C10041a implements C43300b {
    /* renamed from: b */
    public final C46074a mo21398b(String str, String str2, int i, int i2, int i3, int i4) {
        C46074a c28504c;
        AppMethodBeat.m2504i(76300);
        int i5 = C1427q.etj.etI;
        C4990ab.m7417i("MicroMsg.MMSightPresendRemuxerImpl", "get, configRemuxerType: %s", Integer.valueOf(i5));
        if (i5 != -1) {
            if (i5 == 1) {
                C39381b c39381b = new C39381b(str, str2, i, i2, i3, i4);
                AppMethodBeat.m2505o(76300);
                return c39381b;
            } else if (i5 == 2) {
                c28504c = new C28504c(str, str2, i, i2, i3, i4);
                AppMethodBeat.m2505o(76300);
                return c28504c;
            }
        }
        if (C1443d.m3068iW(19)) {
            c28504c = new C39381b(str, str2, i, i2, i3, i4);
            AppMethodBeat.m2505o(76300);
            return c28504c;
        }
        c28504c = new C28504c(str, str2, i, i2, i3, i4);
        AppMethodBeat.m2505o(76300);
        return c28504c;
    }

    /* renamed from: a */
    public final C46074a mo21397a(String str, String str2, int i, int i2, int i3, int i4, long j, long j2) {
        C46074a c28504c;
        AppMethodBeat.m2504i(76301);
        int i5 = C1427q.etj.etI;
        C4990ab.m7417i("MicroMsg.MMSightPresendRemuxerImpl", "get, configRemuxerType: %s", Integer.valueOf(i5));
        if (i5 != -1) {
            if (i5 == 1) {
                C39381b c39381b = new C39381b(str, str2, i, i2, i3, i4, j, j2);
                AppMethodBeat.m2505o(76301);
                return c39381b;
            } else if (i5 == 2) {
                c28504c = new C28504c(str, str2, i, i2, i3, i4, j, j2);
                AppMethodBeat.m2505o(76301);
                return c28504c;
            }
        }
        if (C1443d.m3068iW(19)) {
            c28504c = new C39381b(str, str2, i, i2, i3, i4, j, j2);
            AppMethodBeat.m2505o(76301);
            return c28504c;
        }
        c28504c = new C28504c(str, str2, i, i2, i3, i4, j, j2);
        AppMethodBeat.m2505o(76301);
        return c28504c;
    }

    /* renamed from: a */
    public final C46074a mo21395a(int i, String str, String str2, int i2, int i3, int i4, int i5) {
        AppMethodBeat.m2504i(76302);
        if (i == 1) {
            C39381b c39381b = new C39381b(str, str2, i2, i3, i4, i5);
            AppMethodBeat.m2505o(76302);
            return c39381b;
        } else if (i == 2) {
            C46074a c28504c = new C28504c(str, str2, i2, i3, i4, i5);
            AppMethodBeat.m2505o(76302);
            return c28504c;
        } else {
            AppMethodBeat.m2505o(76302);
            return null;
        }
    }

    /* renamed from: a */
    public final C46074a mo21396a(int i, String str, String str2, int i2, int i3, int i4, int i5, long j, long j2) {
        AppMethodBeat.m2504i(76303);
        if (i == 1) {
            C39381b c39381b = new C39381b(str, str2, i2, i3, i4, i5, j, j2);
            AppMethodBeat.m2505o(76303);
            return c39381b;
        } else if (i == 2) {
            C46074a c28504c = new C28504c(str, str2, i2, i3, i4, i5, j, j2);
            AppMethodBeat.m2505o(76303);
            return c28504c;
        } else {
            AppMethodBeat.m2505o(76303);
            return null;
        }
    }
}
