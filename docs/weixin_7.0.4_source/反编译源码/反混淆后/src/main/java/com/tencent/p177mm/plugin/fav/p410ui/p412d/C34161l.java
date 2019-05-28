package com.tencent.p177mm.plugin.fav.p410ui.p412d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMImageView;
import com.tencent.p177mm.plugin.fav.p407a.C20679y;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p410ui.C45939l;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C20714a.C3084b;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.protocal.protobuf.abo;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.fav.ui.d.l */
public final class C34161l extends C20714a {
    private final int moM;
    private final String mpi = "";

    /* renamed from: com.tencent.mm.plugin.fav.ui.d.l$a */
    public static class C34162a extends C3084b {
        TextView gnB;
        TextView gnC;
        MMImageView mlG;
        TextView moL;
    }

    public C34161l(C45939l c45939l) {
        super(c45939l);
        AppMethodBeat.m2504i(74648);
        this.moM = C1338a.m2856al(c45939l.context, C25738R.dimen.f9852hw);
        AppMethodBeat.m2505o(74648);
    }

    /* renamed from: a */
    public final View mo7336a(View view, ViewGroup viewGroup, C27966g c27966g) {
        C3084b c34162a;
        AppMethodBeat.m2504i(74649);
        Context context = viewGroup.getContext();
        if (view == null) {
            c34162a = new C34162a();
            view = mo36015a(View.inflate(context, 2130969506, null), c34162a, c27966g);
            c34162a.mlG = (MMImageView) view.findViewById(2131821479);
            c34162a.gnB = (TextView) view.findViewById(2131820619);
            c34162a.gnC = (TextView) view.findViewById(2131820602);
            c34162a.moL = (TextView) view.findViewById(2131820615);
            c34162a.moL.setVisibility(0);
        } else {
            c34162a = (C34162a) view.getTag();
        }
        mo36016a(c34162a, c27966g);
        abo abo = c27966g.field_favProto.whE;
        if (abo != null) {
            c34162a.gnB.setText(C5046bo.nullAsNil(abo.title));
            c34162a.gnC.setText(C5046bo.nullAsNil(abo.desc));
        } else {
            c34162a.gnB.setText("");
            c34162a.gnC.setText("");
        }
        c34162a.moL.setText(C5046bo.m7532bc(C39037b.getAppName(context, c27966g.field_favProto.wit.appId), this.mpi));
        this.mhy.mo73786a(c34162a.mlG, null, c27966g, (int) C1318a.app_attach_file_icon_unknow, this.moM, this.moM);
        AppMethodBeat.m2505o(74649);
        return view;
    }

    /* renamed from: a */
    public final void mo7337a(View view, abh abh) {
        AppMethodBeat.m2504i(74650);
        C34162a c34162a = (C34162a) view.getTag();
        ((C20679y) C1720g.m3528K(C20679y.class)).mo35978a(view.getContext(), c34162a.mgf, abh);
        AppMethodBeat.m2505o(74650);
    }
}
