package com.tencent.p177mm.plugin.fts.p424ui.p425a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3156b;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C45974m.C43131a;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C45974m.C44741b;

/* renamed from: com.tencent.mm.plugin.fts.ui.a.p */
public final class C20874p extends C45974m {
    public C45966l mKp;
    private C3194a mLj = new C3194a();
    public int showType;

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.p$a */
    public class C3194a extends C44741b {
        public C3194a() {
            super();
        }

        /* renamed from: a */
        public final View mo7420a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(62026);
            View inflate = LayoutInflater.from(context).inflate(2130969635, viewGroup, false);
            C43131a c43131a = C20874p.this.mLb;
            c43131a.ejo = (ImageView) inflate.findViewById(2131821183);
            c43131a.ejp = (TextView) inflate.findViewById(2131823149);
            c43131a.ene = (TextView) inflate.findViewById(2131822913);
            c43131a.contentView = inflate.findViewById(2131821182);
            c43131a.enf = (TextView) inflate.findViewById(2131820988);
            c43131a.ejo.getLayoutParams().width = C1338a.m2856al(context, C25738R.dimen.f10001n3);
            c43131a.ejo.getLayoutParams().height = C1338a.m2856al(context, C25738R.dimen.f10001n3);
            inflate.setTag(c43131a);
            AppMethodBeat.m2505o(62026);
            return inflate;
        }

        /* renamed from: a */
        public final boolean mo7422a(Context context, C3154a c3154a) {
            AppMethodBeat.m2504i(62027);
            boolean a = ((C12029n) C1720g.m3530M(C12029n.class)).getItemClickHandler(C20874p.this.klY).mo7423a(context, c3154a);
            AppMethodBeat.m2505o(62027);
            return a;
        }
    }

    public C20874p(int i) {
        super(i);
        AppMethodBeat.m2504i(62028);
        AppMethodBeat.m2505o(62028);
    }

    /* renamed from: Ps */
    public final C3156b mo7412Ps() {
        return this.mLj;
    }

    public final int bAw() {
        if (this.mKY < 2) {
            return 0;
        }
        return 2;
    }
}
