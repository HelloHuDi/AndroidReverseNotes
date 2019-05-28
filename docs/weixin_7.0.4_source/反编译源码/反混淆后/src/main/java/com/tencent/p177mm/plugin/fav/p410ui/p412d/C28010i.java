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
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p410ui.C45939l;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C20714a.C3084b;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.fav.ui.d.i */
public final class C28010i extends C20714a {
    private final int moM;
    private final String mpi;

    /* renamed from: com.tencent.mm.plugin.fav.ui.d.i$a */
    public static class C11889a extends C3084b {
        TextView gnB;
        TextView gnC;
        ImageView iqT;
        TextView moL;
    }

    public C28010i(C45939l c45939l) {
        super(c45939l);
        AppMethodBeat.m2504i(74636);
        this.moM = C1338a.m2856al(c45939l.context, C25738R.dimen.f9852hw);
        this.mpi = c45939l.context.getString(C25738R.string.bqc);
        AppMethodBeat.m2505o(74636);
    }

    /* renamed from: a */
    public final View mo7336a(View view, ViewGroup viewGroup, C27966g c27966g) {
        C3084b c11889a;
        AppMethodBeat.m2504i(74637);
        Context context = viewGroup.getContext();
        if (view == null) {
            c11889a = new C11889a();
            view = mo36015a(View.inflate(context, 2130969506, null), c11889a, c27966g);
            c11889a.iqT = (ImageView) view.findViewById(2131821479);
            c11889a.gnB = (TextView) view.findViewById(2131820619);
            c11889a.gnC = (TextView) view.findViewById(2131820602);
            c11889a.gnC.setVisibility(8);
            c11889a.moL = (TextView) view.findViewById(2131820615);
            c11889a.moL.setVisibility(0);
        } else {
            c11889a = (C11889a) view.getTag();
        }
        mo36016a(c11889a, c27966g);
        c11889a.gnB.setText(C5046bo.nullAsNil(c27966g.field_favProto.whC.title));
        c11889a.moL.setText(C5046bo.m7532bc(C39037b.getAppName(context, c27966g.field_favProto.wit.appId), this.mpi));
        this.mhy.mo73786a(c11889a.iqT, null, c27966g, (int) C1318a.app_attach_file_icon_unknow, this.moM, this.moM);
        AppMethodBeat.m2505o(74637);
        return view;
    }

    /* renamed from: a */
    public final void mo7337a(View view, abh abh) {
        AppMethodBeat.m2504i(74638);
        C11889a c11889a = (C11889a) view.getTag();
        ((C20679y) C1720g.m3528K(C20679y.class)).mo35978a(view.getContext(), c11889a.mgf, abh);
        AppMethodBeat.m2505o(74638);
    }
}
