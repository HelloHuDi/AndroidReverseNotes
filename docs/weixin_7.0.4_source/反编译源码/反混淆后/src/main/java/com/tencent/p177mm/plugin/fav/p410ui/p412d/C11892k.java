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
import com.tencent.p177mm.plugin.fav.p410ui.C34171j;
import com.tencent.p177mm.plugin.fav.p410ui.C45939l;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C20714a.C3084b;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abh;
import java.util.HashSet;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.fav.ui.d.k */
public final class C11892k extends C20714a {
    final int moM;
    private HashSet<Long> mpq = new HashSet();

    /* renamed from: com.tencent.mm.plugin.fav.ui.d.k$a */
    public static class C11893a extends C3084b {
        ImageView moN;
        TextView mps;
    }

    public C11892k(C45939l c45939l) {
        super(c45939l);
        AppMethodBeat.m2504i(74645);
        this.moM = C1338a.m2856al(c45939l.context, C25738R.dimen.f9853hx);
        AppMethodBeat.m2505o(74645);
    }

    /* renamed from: a */
    public final View mo7336a(View view, ViewGroup viewGroup, final C27966g c27966g) {
        C11893a c11893a;
        AppMethodBeat.m2504i(74646);
        Context context = viewGroup.getContext();
        if (view == null) {
            c11893a = new C11893a();
            view = mo36015a(View.inflate(context, 2130969513, null), (C3084b) c11893a, c27966g);
            c11893a.moN = (ImageView) view.findViewById(2131823917);
            c11893a.mps = (TextView) view.findViewById(2131823925);
        } else {
            c11893a = (C11893a) view.getTag();
        }
        LinkedList linkedList = c27966g.field_favProto.wiv;
        if (linkedList.size() > 0) {
            int i = ((aar) linkedList.getFirst()).duration;
            c11893a.mps.setText(C34171j.m56018B(context, i));
            if (!(c27966g == null || i > 1 || this.mpq.contains(Long.valueOf(c27966g.field_localId)))) {
                this.mpq.add(Long.valueOf(c27966g.field_localId));
                C1720g.m3539RS().mo10302aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(74644);
                        C39037b.m66414o(c27966g);
                        AppMethodBeat.m2505o(74644);
                    }
                });
            }
            c11893a.mps.setVisibility(0);
        } else {
            c11893a.mps.setVisibility(8);
        }
        mo36016a((C3084b) c11893a, c27966g);
        this.mhy.mo73786a(c11893a.moN, C39037b.m66378c(c27966g), c27966g, (int) C1318a.app_attach_file_icon_video, this.moM, this.moM);
        AppMethodBeat.m2505o(74646);
        return view;
    }

    /* renamed from: a */
    public final void mo7337a(View view, abh abh) {
        AppMethodBeat.m2504i(74647);
        C11893a c11893a = (C11893a) view.getTag();
        ((C20679y) C1720g.m3528K(C20679y.class)).mo35978a(view.getContext(), c11893a.mgf, abh);
        AppMethodBeat.m2505o(74647);
    }
}
