package com.tencent.p177mm.plugin.forcenotify.p1263b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.plugin.forcenotify.p1262a.C28062a;
import com.tencent.p177mm.plugin.forcenotify.p1613c.C43101b;
import com.tencent.p177mm.plugin.forcenotify.p1648d.C45947a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.storage.C7620bi;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J*\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nH\u0016¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/forcenotify/core/ForceNotifyReport;", "Lcom/tencent/mm/plugin/forcenotify/api/IForceNotifyReport;", "()V", "_16505", "", "toUsername", "", "clickType", "", "clickTime", "", "sessionId", "_16506", "_16507", "noticeState", "receiveTime", "plugin-force-notify_release"})
/* renamed from: com.tencent.mm.plugin.forcenotify.b.b */
public final class C20774b implements C28062a {
    public static final C20774b mtb = new C20774b();

    static {
        AppMethodBeat.m2504i(51035);
        AppMethodBeat.m2505o(51035);
    }

    private C20774b() {
    }

    /* renamed from: b */
    public final void mo36076b(String str, String str2, int i, long j) {
        AppMethodBeat.m2504i(51031);
        C25052j.m39376p(str2, "sessionId");
        C1694a K = C1720g.m3528K(C6982j.class);
        C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
        C7620bi Rb = ((C6982j) K).bOr().mo15248Rb(str);
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[6];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(i);
        Long valueOf = Rb != null ? Long.valueOf(Rb.mo14768HD()) : null;
        if (valueOf == null) {
            C25052j.dWJ();
        }
        objArr[2] = Long.valueOf(valueOf.longValue() / 1000);
        int i2 = (Rb.isSystem() || Rb.dtv()) ? 0 : (Rb == null || Rb.mo14767HC() != 1) ? 2 : 1;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = str2;
        objArr[5] = Long.valueOf(j);
        c7060h.mo8381e(16505, objArr);
        AppMethodBeat.m2505o(51031);
    }

    /* renamed from: f */
    public final void mo36079f(String str, int i, long j) {
        AppMethodBeat.m2504i(51032);
        C43101b c43101b = new C43101b();
        c43101b.field_UserName = str;
        if (C45947a.mth.mo10102b((C4925c) c43101b, new String[0])) {
            mo36076b(str, String.valueOf(c43101b.field_CreateTime / 1000) + c43101b.field_UserName, i, j);
        }
        AppMethodBeat.m2505o(51032);
    }

    /* renamed from: e */
    public final void mo36078e(String str, int i, long j) {
        AppMethodBeat.m2504i(51033);
        C7060h.pYm.mo8381e(16506, str, Integer.valueOf(i), Long.valueOf(j));
        AppMethodBeat.m2505o(51033);
    }

    /* renamed from: d */
    public final void mo36077d(String str, int i, long j) {
        AppMethodBeat.m2504i(51034);
        C7060h.pYm.mo8381e(16507, str, Integer.valueOf(i), Long.valueOf(j));
        AppMethodBeat.m2505o(51034);
    }
}
