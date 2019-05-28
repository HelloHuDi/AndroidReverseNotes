package com.tencent.mm.plugin.forcenotify.b;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.forcenotify.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.storage.bi;

@l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J*\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nH\u0016¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/plugin/forcenotify/core/ForceNotifyReport;", "Lcom/tencent/mm/plugin/forcenotify/api/IForceNotifyReport;", "()V", "_16505", "", "toUsername", "", "clickType", "", "clickTime", "", "sessionId", "_16506", "_16507", "noticeState", "receiveTime", "plugin-force-notify_release"})
public final class b implements a {
    public static final b mtb = new b();

    static {
        AppMethodBeat.i(51035);
        AppMethodBeat.o(51035);
    }

    private b() {
    }

    public final void b(String str, String str2, int i, long j) {
        AppMethodBeat.i(51031);
        j.p(str2, "sessionId");
        com.tencent.mm.kernel.c.a K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
        j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
        bi Rb = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).bOr().Rb(str);
        h hVar = h.pYm;
        Object[] objArr = new Object[6];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(i);
        Long valueOf = Rb != null ? Long.valueOf(Rb.HD()) : null;
        if (valueOf == null) {
            j.dWJ();
        }
        objArr[2] = Long.valueOf(valueOf.longValue() / 1000);
        int i2 = (Rb.isSystem() || Rb.dtv()) ? 0 : (Rb == null || Rb.HC() != 1) ? 2 : 1;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = str2;
        objArr[5] = Long.valueOf(j);
        hVar.e(16505, objArr);
        AppMethodBeat.o(51031);
    }

    public final void f(String str, int i, long j) {
        AppMethodBeat.i(51032);
        com.tencent.mm.plugin.forcenotify.c.b bVar = new com.tencent.mm.plugin.forcenotify.c.b();
        bVar.field_UserName = str;
        if (com.tencent.mm.plugin.forcenotify.d.a.mth.b((c) bVar, new String[0])) {
            b(str, String.valueOf(bVar.field_CreateTime / 1000) + bVar.field_UserName, i, j);
        }
        AppMethodBeat.o(51032);
    }

    public final void e(String str, int i, long j) {
        AppMethodBeat.i(51033);
        h.pYm.e(16506, str, Integer.valueOf(i), Long.valueOf(j));
        AppMethodBeat.o(51033);
    }

    public final void d(String str, int i, long j) {
        AppMethodBeat.i(51034);
        h.pYm.e(16507, str, Integer.valueOf(i), Long.valueOf(j));
        AppMethodBeat.o(51034);
    }
}
