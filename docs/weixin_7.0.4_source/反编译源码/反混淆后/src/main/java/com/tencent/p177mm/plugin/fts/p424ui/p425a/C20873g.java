package com.tencent.p177mm.plugin.fts.p424ui.p425a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3155a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3156b;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;
import com.tencent.p177mm.plugin.fts.p424ui.C45976b.C3197c;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C45974m.C43131a;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C45974m.C44741b;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.fts.ui.a.g */
public final class C20873g extends C45974m {
    private C12060a mKy = new C12060a();
    CharSequence mKz;

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.g$a */
    public class C12060a extends C44741b {
        public C12060a() {
            super();
        }

        /* renamed from: a */
        public final View mo7420a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(61986);
            View inflate = LayoutInflater.from(context).inflate(2130969635, viewGroup, false);
            C43131a c43131a = C20873g.this.mLb;
            c43131a.ejo = (ImageView) inflate.findViewById(2131821183);
            c43131a.ejp = (TextView) inflate.findViewById(2131823149);
            c43131a.ene = (TextView) inflate.findViewById(2131822913);
            c43131a.contentView = inflate.findViewById(2131821182);
            c43131a.enf = (TextView) inflate.findViewById(2131820988);
            c43131a.ejo.getLayoutParams().width = C1338a.m2856al(context, C25738R.dimen.f10001n3);
            c43131a.ejo.getLayoutParams().height = C1338a.m2856al(context, C25738R.dimen.f10001n3);
            inflate.setTag(c43131a);
            AppMethodBeat.m2505o(61986);
            return inflate;
        }

        /* renamed from: a */
        public final void mo7421a(Context context, C3155a c3155a, C3154a c3154a, Object... objArr) {
            AppMethodBeat.m2504i(61987);
            C20873g c20873g = (C20873g) c3154a;
            C43131a c43131a = (C43131a) c3155a;
            C3201m.m5503p(c43131a.contentView, C20873g.this.mFk);
            if (C5046bo.isNullOrNil(c20873g.hpS.talker)) {
                C40460b.m69434b(c43131a.ejo, c20873g.hpS.mDx);
            } else {
                C40460b.m69434b(c43131a.ejo, c20873g.hpS.talker);
            }
            C3201m.m5501a(c20873g.mKz, c43131a.ejp);
            C3201m.m5501a(c20873g.gny, c43131a.ene);
            C3201m.m5501a(c20873g.mKZ, c43131a.enf);
            AppMethodBeat.m2505o(61987);
        }
    }

    public C20873g(int i) {
        super(i);
        AppMethodBeat.m2504i(61988);
        AppMethodBeat.m2505o(61988);
    }

    /* renamed from: Ps */
    public final C3156b mo7412Ps() {
        return this.mKy;
    }

    /* renamed from: a */
    public final void mo7413a(Context context, C3155a c3155a, Object... objArr) {
        AppMethodBeat.m2504i(61989);
        super.mo7413a(context, c3155a, objArr);
        CharSequence LC = C3161d.m5401LC(this.hpS.talker);
        if (C5046bo.isNullOrNil(LC)) {
            LC = C3161d.m5401LC(this.hpS.mDx);
        }
        this.mKz = C44089j.m79300d(context, LC, (float) C3197c.mHy);
        AppMethodBeat.m2505o(61989);
    }
}
