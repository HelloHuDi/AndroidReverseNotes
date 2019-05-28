package com.tencent.p177mm.plugin.fts.p424ui.p425a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3155a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3156b;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;
import com.tencent.p177mm.plugin.fts.p424ui.C45976b.C3197c;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C45974m.C43131a;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C45974m.C44741b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.plugin.fts.ui.a.d */
public final class C43129d extends C45974m {
    public C7577u mIy;
    public CharSequence mKe;
    private C39146a mKf = new C39146a();

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.d$a */
    public class C39146a extends C44741b {
        public C39146a() {
            super();
        }

        /* renamed from: a */
        public final void mo7421a(Context context, C3155a c3155a, C3154a c3154a, Object... objArr) {
            AppMethodBeat.m2504i(61975);
            C43129d c43129d = (C43129d) c3154a;
            C43131a c43131a = (C43131a) c3155a;
            C3201m.m5503p(c43131a.contentView, C43129d.this.mFk);
            if (C5046bo.isNullOrNil(c43129d.hpS.talker)) {
                C40460b.m69434b(c43131a.ejo, c43129d.hpS.mDx);
            } else {
                C40460b.m69434b(c43131a.ejo, c43129d.hpS.talker);
            }
            C3201m.m5501a(c43129d.mKe, c43131a.ejp);
            C3201m.m5501a(c43129d.gny, c43131a.ene);
            C3201m.m5501a(c43129d.mKZ, c43131a.enf);
            AppMethodBeat.m2505o(61975);
        }
    }

    public C43129d(int i) {
        super(i);
        AppMethodBeat.m2504i(61976);
        AppMethodBeat.m2505o(61976);
    }

    /* renamed from: Ps */
    public final C3156b mo7412Ps() {
        return this.mKf;
    }

    /* renamed from: a */
    public final void mo7413a(Context context, C3155a c3155a, Object... objArr) {
        CharSequence LC;
        AppMethodBeat.m2504i(61977);
        super.mo7413a(context, c3155a, objArr);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.hpS.talker);
        if (aoO == null) {
            LC = C3161d.m5401LC(this.hpS.mDx);
        } else if (!C5046bo.isNullOrNil(aoO.field_conRemark)) {
            LC = aoO.field_conRemark;
        } else if (this.mIy != null) {
            LC = this.mIy.mo16807mJ(this.hpS.talker);
            if (C5046bo.isNullOrNil(LC)) {
                LC = aoO.field_nickname;
            }
        } else {
            LC = aoO.field_nickname;
        }
        if (!C5046bo.isNullOrNil(LC)) {
            this.mKe = C44089j.m79300d(context, LC, (float) C3197c.mHy);
        }
        AppMethodBeat.m2505o(61977);
    }
}
