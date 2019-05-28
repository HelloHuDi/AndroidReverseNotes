package com.tencent.p177mm.plugin.emojicapture.model.p950a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.emojicapture.model.p1254c.C20433d;
import com.tencent.p177mm.plugin.emojicapture.model.p1254c.C42976i;
import com.tencent.p177mm.plugin.emojicapture.model.p1254c.C45869a;
import com.tencent.p177mm.plugin.emojicapture.model.p1254c.C45869a.C20432a;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, dWq = {"checkStickerValid", "", "item", "Lcom/tencent/mm/plugin/emojicapture/model/xml/EmoticonLensItem;", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.model.a.d */
public final class C38908d {
    /* renamed from: a */
    public static final boolean m66044a(C20433d c20433d) {
        AppMethodBeat.m2504i(2646);
        C25052j.m39376p(c20433d, "item");
        C45865e c45865e = C45865e.lii;
        String uw = C45865e.m84969uw(c20433d.ljp);
        C42976i c42976i = new C42976i();
        C20432a c20432a = C45869a.ljn;
        C20432a.m31586a(uw, c42976i);
        if (c42976i.ljI >= c20433d.ljr) {
            AppMethodBeat.m2505o(2646);
            return true;
        }
        AppMethodBeat.m2505o(2646);
        return false;
    }
}
