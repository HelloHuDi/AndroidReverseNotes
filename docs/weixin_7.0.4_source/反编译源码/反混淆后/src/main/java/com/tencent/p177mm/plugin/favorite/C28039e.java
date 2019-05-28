package com.tencent.p177mm.plugin.favorite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C6892ab;
import com.tencent.p177mm.pluginsdk.model.C44065o;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35844g.C23273a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C44094a;

/* renamed from: com.tencent.mm.plugin.favorite.e */
public final class C28039e implements C6892ab {
    /* renamed from: a */
    public final int mo15147a(WXMediaMessage wXMediaMessage, String str, String str2, String str3) {
        AppMethodBeat.m2504i(20527);
        int a = C4733l.m7090a(wXMediaMessage, str, str2, str3, 3, null);
        AppMethodBeat.m2505o(20527);
        return a;
    }

    /* renamed from: a */
    public final int mo15146a(C8910b c8910b, WXMediaMessage wXMediaMessage, String str) {
        AppMethodBeat.m2504i(20528);
        int a = C4733l.m7085a(c8910b, wXMediaMessage, str);
        AppMethodBeat.m2505o(20528);
        return a;
    }

    /* renamed from: a */
    public final void mo15148a(Activity activity, String str, String str2) {
        AppMethodBeat.m2504i(20529);
        C44094a.m79368a(activity, str, str2, 2);
        AppMethodBeat.m2505o(20529);
    }

    /* renamed from: b */
    public final void mo15150b(Activity activity, int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(20530);
        C44094a.m79367a(activity, i, i2, intent, true, C25738R.string.d7m, C25738R.string.d7n, 2);
        AppMethodBeat.m2505o(20530);
    }

    /* renamed from: LU */
    public final int mo15145LU(String str) {
        AppMethodBeat.m2504i(20531);
        int aiD = C44065o.aiD(str);
        AppMethodBeat.m2505o(20531);
        return aiD;
    }

    /* renamed from: a */
    public final void mo15149a(Context context, String str, C27966g c27966g, boolean z, C30111a c30111a) {
        AppMethodBeat.m2504i(20532);
        C23273a c23273a = new C23273a(context);
        c23273a.mo38972cx(str);
        C43093d.m76580a(c23273a, context, c27966g);
        C43093d.m76585b(c23273a, context, c27966g);
        c23273a.mo38977h(Boolean.valueOf(z)).mo38965KQ(C25738R.string.f9221tf).mo38966a(c30111a).gud.show();
        AppMethodBeat.m2505o(20532);
    }
}
