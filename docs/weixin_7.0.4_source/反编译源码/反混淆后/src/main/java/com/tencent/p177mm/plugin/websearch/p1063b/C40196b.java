package com.tencent.p177mm.plugin.websearch.p1063b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.plugin.websearch.api.C14423an;
import com.tencent.p177mm.plugin.websearch.api.C40191d;
import com.tencent.p177mm.plugin.websearch.api.C46402e;
import com.tencent.p177mm.protocal.protobuf.bvj;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p639e.C5685b;
import java.lang.ref.WeakReference;
import org.xwalk.core.Log;

/* renamed from: com.tencent.mm.plugin.websearch.b.b */
public final class C40196b implements C46402e {
    /* renamed from: a */
    public final void mo63535a(final String str, C40191d c40191d, C5685b c5685b) {
        AppMethodBeat.m2504i(91365);
        if (TextUtils.isEmpty(str)) {
            Log.m81051w("RelevantSearchService", "empty query");
            if (c40191d != null) {
                c40191d.mo7467a(false, null, null, null);
            }
        }
        final WeakReference weakReference = new WeakReference(c40191d);
        new C46406a(str).acy().mo60488b(c5685b).mo60487b(new C5681a<Void, C37441a<bvj>>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(91364);
                C37441a c37441a = (C37441a) obj;
                C40191d c40191d = (C40191d) weakReference.get();
                if (c40191d != null) {
                    if (c37441a.errType == 0 && c37441a.errCode == 0) {
                        c40191d.mo7467a(true, ((bvj) c37441a.fsy).wWx, ((bvj) c37441a.fsy).vQg, str);
                    } else {
                        Log.m81051w("RelevantSearchService", "search local page error " + c37441a.aIm);
                        c40191d.mo7467a(false, null, null, null);
                    }
                }
                AppMethodBeat.m2505o(91364);
                return null;
            }
        });
        AppMethodBeat.m2505o(91365);
    }

    /* renamed from: ar */
    public final void mo63536ar(String str, String str2, String str3) {
        AppMethodBeat.m2504i(91366);
        C14423an.m22646a(str, str2, System.currentTimeMillis(), str3);
        AppMethodBeat.m2505o(91366);
    }

    /* renamed from: d */
    public final void mo63537d(String str, String str2, int i, String str3) {
        AppMethodBeat.m2504i(91367);
        C14423an.m22654e(str, str2, i, str3);
        AppMethodBeat.m2505o(91367);
    }
}
