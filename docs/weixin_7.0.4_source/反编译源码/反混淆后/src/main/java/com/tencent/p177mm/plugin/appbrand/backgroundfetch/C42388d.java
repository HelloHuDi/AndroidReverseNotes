package com.tencent.p177mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.config.C26842p;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.backgroundfetch.d */
public class C42388d extends C7563j<C42387c> {
    public static final String[] fjY = new String[]{C7563j.m13217a(C42387c.hcb, "AppBrandBackgroundFetchData")};

    public C42388d(C4927e c4927e) {
        super(c4927e, C42387c.hcb, "AppBrandBackgroundFetchData", null);
    }

    static {
        AppMethodBeat.m2504i(129776);
        AppMethodBeat.m2505o(129776);
    }

    /* JADX WARNING: Missing block: B:6:0x0049, code skipped:
            if (super.mo10102b((com.tencent.p177mm.sdk.p603e.C4925c) r0, "username", "fetchType") != false) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final boolean mo67888a(String str, int i, String str2, String str3, String str4, int i2, long j) {
        AppMethodBeat.m2504i(129771);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129771);
            return true;
        }
        C42387c c42387c;
        C4925c c42387c2 = new C42387c();
        c42387c2.field_username = str;
        c42387c2.field_fetchType = i;
        c42387c2.field_data = str2;
        c42387c2.field_path = str3;
        c42387c2.field_query = str4;
        c42387c2.field_scene = i2;
        c42387c2.field_updateTime = j;
        if (!C5046bo.isNullOrNil(str)) {
            c42387c = new C42387c();
            c42387c.field_username = str;
            c42387c.field_fetchType = i;
        }
        c42387c = null;
        boolean b;
        if (c42387c == null) {
            b = super.mo10101b(c42387c2);
            AppMethodBeat.m2505o(129771);
            return b;
        }
        b = super.mo10103c(c42387c2, "username", "fetchType");
        AppMethodBeat.m2505o(129771);
        return b;
    }

    /* renamed from: aP */
    private AppBrandBackgroundFetchDataParcel m75002aP(String str, int i) {
        AppMethodBeat.m2504i(129772);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129772);
            return null;
        }
        C4925c c42387c = new C42387c();
        c42387c.field_username = str;
        c42387c.field_fetchType = i;
        if (super.mo10102b(c42387c, "username", "fetchType")) {
            AppBrandBackgroundFetchDataParcel appBrandBackgroundFetchDataParcel = new AppBrandBackgroundFetchDataParcel();
            appBrandBackgroundFetchDataParcel.username = c42387c.field_username;
            appBrandBackgroundFetchDataParcel.hca = c42387c.field_fetchType;
            appBrandBackgroundFetchDataParcel.path = c42387c.field_path;
            appBrandBackgroundFetchDataParcel.query = c42387c.field_query;
            appBrandBackgroundFetchDataParcel.data = c42387c.field_data;
            appBrandBackgroundFetchDataParcel.scene = c42387c.field_scene;
            appBrandBackgroundFetchDataParcel.updateTime = c42387c.field_updateTime;
            AppMethodBeat.m2505o(129772);
            return appBrandBackgroundFetchDataParcel;
        }
        AppMethodBeat.m2505o(129772);
        return null;
    }

    /* renamed from: ao */
    public final boolean mo67891ao(String str, int i) {
        AppMethodBeat.m2504i(129773);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129773);
            return true;
        }
        C4925c c42387c = new C42387c();
        c42387c.field_username = str;
        c42387c.field_fetchType = i;
        boolean a = super.mo16760a(c42387c, "username", "fetchType");
        AppMethodBeat.m2505o(129773);
        return a;
    }

    /* renamed from: aQ */
    public final long mo67889aQ(String str, int i) {
        AppMethodBeat.m2504i(129774);
        AppBrandBackgroundFetchDataParcel aP = m75002aP(str, i);
        if (aP != null) {
            long j = aP.updateTime;
            AppMethodBeat.m2505o(129774);
            return j;
        }
        AppMethodBeat.m2505o(129774);
        return 0;
    }

    /* renamed from: aR */
    public final AppBrandBackgroundFetchDataParcel mo67890aR(String str, int i) {
        AppMethodBeat.m2504i(129775);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129775);
            return null;
        }
        AppBrandBackgroundFetchDataParcel aP = m75002aP(C26842p.m42742zo(str), i);
        AppMethodBeat.m2505o(129775);
        return aP;
    }
}
