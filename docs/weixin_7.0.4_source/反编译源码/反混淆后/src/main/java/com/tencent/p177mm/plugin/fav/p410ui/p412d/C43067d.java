package com.tencent.p177mm.plugin.fav.p410ui.p412d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.fav.p407a.C20679y;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p410ui.C45939l;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C20714a.C3084b;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abh;

/* renamed from: com.tencent.mm.plugin.fav.ui.d.d */
public final class C43067d extends C20714a {
    private static int moM;

    /* renamed from: com.tencent.mm.plugin.fav.ui.d.d$a */
    public static class C43066a extends C3084b {
        ImageView moN;
    }

    public C43067d(C45939l c45939l) {
        super(c45939l);
        AppMethodBeat.m2504i(74620);
        moM = C1338a.m2856al(c45939l.context, C25738R.dimen.f9853hx);
        AppMethodBeat.m2505o(74620);
    }

    /* renamed from: a */
    public final View mo7336a(View view, ViewGroup viewGroup, C27966g c27966g) {
        C3084b c3084b;
        AppMethodBeat.m2504i(74621);
        Context context = viewGroup.getContext();
        if (view == null) {
            C3084b c43066a = new C43066a();
            view = mo36015a(View.inflate(context, 2130969511, null), c43066a, c27966g);
            c43066a.moN = (ImageView) view.findViewById(2131823917);
            c3084b = c43066a;
        } else {
            C43066a c3084b2 = (C43066a) view.getTag();
        }
        mo36016a(c3084b2, c27966g);
        aar c = C39037b.m66378c(c27966g);
        ImageView imageView = c3084b2.moN;
        int i = moM;
        C45939l.m85278a(imageView, c, c27966g, false, i, i);
        AppMethodBeat.m2505o(74621);
        return view;
    }

    /* renamed from: a */
    public final void mo7337a(View view, abh abh) {
        AppMethodBeat.m2504i(74622);
        C43066a c43066a = (C43066a) view.getTag();
        ((C20679y) C1720g.m3528K(C20679y.class)).mo35978a(view.getContext(), c43066a.mgf, abh);
        AppMethodBeat.m2505o(74622);
    }
}
