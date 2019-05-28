package com.tencent.p177mm.plugin.fav.p410ui.p412d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.fav.p407a.C20679y;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p410ui.C45939l;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C20714a.C3084b;
import com.tencent.p177mm.protocal.protobuf.abe;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.fav.ui.d.f */
public final class C39057f extends C20714a {
    private final int moM;

    /* renamed from: com.tencent.mm.plugin.fav.ui.d.f$a */
    public static class C28009a extends C3084b {
        TextView gnB;
        TextView gnC;
        ImageView iqT;
        TextView moL;
    }

    public C39057f(C45939l c45939l) {
        super(c45939l);
        AppMethodBeat.m2504i(74625);
        this.moM = C1338a.m2856al(c45939l.context, C25738R.dimen.f9852hw);
        AppMethodBeat.m2505o(74625);
    }

    /* renamed from: a */
    public final View mo7336a(View view, ViewGroup viewGroup, C27966g c27966g) {
        C3084b c28009a;
        AppMethodBeat.m2504i(74626);
        Context context = viewGroup.getContext();
        if (view == null) {
            c28009a = new C28009a();
            view = mo36015a(View.inflate(context, 2130969506, null), c28009a, c27966g);
            c28009a.iqT = (ImageView) view.findViewById(2131821479);
            c28009a.gnB = (TextView) view.findViewById(2131820619);
            c28009a.gnC = (TextView) view.findViewById(2131820602);
            c28009a.moL = (TextView) view.findViewById(2131820615);
            c28009a.moL.setVisibility(8);
        } else {
            c28009a = (C28009a) view.getTag();
        }
        mo36016a(c28009a, c27966g);
        abe abe = c27966g.field_favProto.whC;
        c28009a.gnB.setText(C5046bo.nullAsNil(abe.title));
        c28009a.gnC.setText(C5046bo.nullAsNil(abe.desc));
        c28009a.gnB.setSingleLine(false);
        c28009a.gnB.setMaxLines(2);
        this.mhy.mo73786a(c28009a.iqT, null, c27966g, (int) C1318a.app_attach_file_icon_unknow, this.moM, this.moM);
        AppMethodBeat.m2505o(74626);
        return view;
    }

    /* renamed from: a */
    public final void mo7337a(View view, abh abh) {
        AppMethodBeat.m2504i(74627);
        C28009a c28009a = (C28009a) view.getTag();
        ((C20679y) C1720g.m3528K(C20679y.class)).mo35978a(view.getContext(), c28009a.mgf, abh);
        AppMethodBeat.m2505o(74627);
    }
}
