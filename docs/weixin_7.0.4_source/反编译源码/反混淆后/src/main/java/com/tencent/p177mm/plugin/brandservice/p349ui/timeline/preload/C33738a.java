package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/AppMsgContextEx;", "", "()V", "testClear", "", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.a */
public final class C33738a {
    public static final C33738a jQI = new C33738a();

    static {
        AppMethodBeat.m2504i(14779);
        AppMethodBeat.m2505o(14779);
    }

    private C33738a() {
    }

    public static final void aWM() {
        AppMethodBeat.m2504i(14778);
        long aWQ = (long) C2702b.jQK;
        if (1 <= aWQ) {
            long j = 1;
            while (true) {
                C2702b.m4934gK(j).clear();
                if (j == aWQ) {
                    break;
                }
                j++;
            }
        }
        AppMethodBeat.m2505o(14778);
    }
}
