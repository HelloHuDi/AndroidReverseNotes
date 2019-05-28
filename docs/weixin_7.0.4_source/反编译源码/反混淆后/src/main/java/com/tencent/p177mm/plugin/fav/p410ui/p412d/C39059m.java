package com.tencent.p177mm.plugin.fav.p410ui.p412d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.fav.p407a.C20679y;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p410ui.C45939l;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C20714a.C3084b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.abh;

/* renamed from: com.tencent.mm.plugin.fav.ui.d.m */
public final class C39059m extends C20714a {

    /* renamed from: com.tencent.mm.plugin.fav.ui.d.m$a */
    public static class C39058a extends C3084b {
        TextView ene;
    }

    public C39059m(C45939l c45939l) {
        super(c45939l);
    }

    /* renamed from: a */
    public final View mo7336a(View view, ViewGroup viewGroup, C27966g c27966g) {
        C3084b c3084b;
        AppMethodBeat.m2504i(74651);
        Context context = viewGroup.getContext();
        if (view == null) {
            C3084b c39058a = new C39058a();
            view = mo36015a(View.inflate(context, 2130969515, null), c39058a, c27966g);
            c39058a.ene = (TextView) view.findViewById(2131823926);
            c3084b = c39058a;
        } else {
            C39058a c3084b2 = (C39058a) view.getTag();
        }
        mo36016a(c3084b2, c27966g);
        if (c27966g.field_favProto.desc == null || c27966g.field_favProto.desc.length() <= 0) {
            c3084b2.ene.setText("");
            AppMethodBeat.m2505o(74651);
        } else {
            c3084b2.ene.setText(C44089j.m79293b(c3084b2.ene.getContext(), c27966g.field_favProto.desc, c3084b2.ene.getTextSize()));
            AppMethodBeat.m2505o(74651);
        }
        return view;
    }

    /* renamed from: a */
    public final void mo7337a(View view, abh abh) {
        AppMethodBeat.m2504i(74652);
        C39058a c39058a = (C39058a) view.getTag();
        ((C20679y) C1720g.m3528K(C20679y.class)).mo35978a(view.getContext(), c39058a.mgf, abh);
        AppMethodBeat.m2505o(74652);
    }
}
