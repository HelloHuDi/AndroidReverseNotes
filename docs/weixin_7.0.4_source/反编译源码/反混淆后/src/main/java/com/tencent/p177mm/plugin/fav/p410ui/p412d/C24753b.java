package com.tencent.p177mm.plugin.fav.p410ui.p412d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.plugin.fav.p407a.C20679y;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p410ui.C45939l;
import com.tencent.p177mm.plugin.fav.p410ui.p412d.C20714a.C3084b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi.C5135a;

/* renamed from: com.tencent.mm.plugin.fav.ui.d.b */
public final class C24753b extends C20714a {

    /* renamed from: com.tencent.mm.plugin.fav.ui.d.b$a */
    public static class C24754a extends C3084b {
        TextView gnB;
        TextView gnC;
        ImageView iqT;
        TextView moL;
    }

    public C24753b(C45939l c45939l) {
        super(c45939l);
    }

    /* renamed from: a */
    public final View mo7336a(View view, ViewGroup viewGroup, C27966g c27966g) {
        C3084b c24754a;
        AppMethodBeat.m2504i(74615);
        Context context = viewGroup.getContext();
        if (view == null) {
            c24754a = new C24754a();
            view = mo36015a(View.inflate(context, 2130969506, null), c24754a, c27966g);
            c24754a.iqT = (ImageView) view.findViewById(2131821479);
            c24754a.gnB = (TextView) view.findViewById(2131820619);
            c24754a.gnB.setSingleLine(false);
            c24754a.gnB.setMaxLines(2);
            c24754a.gnC = (TextView) view.findViewById(2131820602);
            c24754a.moL = (TextView) view.findViewById(2131820615);
        } else {
            c24754a = (C24754a) view.getTag();
        }
        mo36016a(c24754a, c27966g);
        C5135a Rn = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15260Rn(C39037b.m66378c(c27966g).desc);
        if (Rn.svN == null || Rn.svN.length() <= 0) {
            C4990ab.m7412e("MicroMsg.FavCardListItem", "parse possible friend msg failed");
        }
        if (C5046bo.isNullOrNil(C24753b.m38641a(Rn))) {
            c24754a.gnC.setVisibility(8);
        } else {
            c24754a.gnC.setText(C24753b.m38641a(Rn));
        }
        c24754a.moL.setText(C25738R.string.bp3);
        c24754a.moL.setVisibility(0);
        ImageView imageView = c24754a.iqT;
        String str = Rn.svN;
        if (C5046bo.isNullOrNil(str)) {
            imageView.setImageResource(C25738R.drawable.ad2);
        } else {
            C40460b.m69434b(imageView, str);
        }
        AppMethodBeat.m2505o(74615);
        return view;
    }

    /* renamed from: a */
    public final void mo7337a(View view, abh abh) {
        AppMethodBeat.m2504i(74616);
        C24754a c24754a = (C24754a) view.getTag();
        ((C20679y) C1720g.m3528K(C20679y.class)).mo35978a(view.getContext(), c24754a.mgf, abh);
        AppMethodBeat.m2505o(74616);
    }

    /* renamed from: a */
    private static String m38641a(C5135a c5135a) {
        Object obj;
        Object obj2 = 1;
        Object obj3 = null;
        AppMethodBeat.m2504i(74617);
        String str = c5135a.dFl;
        if (C5046bo.isNullOrNil(str)) {
            str = c5135a.svN;
            if (C7616ad.aoA(str) || C1855t.m3911mX(str)) {
                obj3 = 1;
            }
            obj = obj3;
        } else {
            obj = null;
        }
        if (obj != null || ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoJ(str)) {
            obj2 = obj;
        }
        boolean kv = C1855t.m3897kv(c5135a.ufB);
        if (obj2 != null || kv) {
            String str2 = "";
            AppMethodBeat.m2505o(74617);
            return str2;
        }
        AppMethodBeat.m2505o(74617);
        return str;
    }
}
