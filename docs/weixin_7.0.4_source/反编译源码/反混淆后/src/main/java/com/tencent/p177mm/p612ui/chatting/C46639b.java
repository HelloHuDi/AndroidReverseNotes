package com.tencent.p177mm.p612ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.b */
final class C46639b extends BaseAdapter {
    private Context context;
    private C25814c lyr;
    private List<C40830z> yGD;
    boolean yGE = false;

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(30377);
        C40830z Oc = m88263Oc(i);
        AppMethodBeat.m2505o(30377);
        return Oc;
    }

    public C46639b(Context context) {
        AppMethodBeat.m2504i(30370);
        this.context = context;
        this.yGD = new ArrayList();
        C17927a c17927a = new C17927a();
        c17927a.ePT = C25738R.drawable.ajl;
        this.lyr = c17927a.ahG();
        mo74845bw(null);
        AppMethodBeat.m2505o(30370);
    }

    /* renamed from: bw */
    public final void mo74845bw(List<C40830z> list) {
        AppMethodBeat.m2504i(30371);
        this.yGD.clear();
        if (!(list == null || list.size() == 0)) {
            this.yGD.addAll(list);
        }
        if (this.yGE) {
            this.yGD.add(dBv());
        }
        this.yGD.add(dBu());
        C4990ab.m7411d("MicroMsg.AppInfoListAdapter", "updateData mDeviceInfoList.size() = %d.", Integer.valueOf(this.yGD.size()));
        AppMethodBeat.m2505o(30371);
    }

    private C40830z dBu() {
        AppMethodBeat.m2504i(30372);
        C40830z c40830z = new C40830z();
        c40830z.resId = C25738R.drawable.bgy;
        c40830z.eoz = this.context.getString(C25738R.string.ebr);
        AppMethodBeat.m2505o(30372);
        return c40830z;
    }

    private C40830z dBv() {
        AppMethodBeat.m2504i(30373);
        C40830z c40830z = new C40830z();
        c40830z.resId = C25738R.drawable.bgz;
        c40830z.eoz = this.context.getString(C25738R.string.aok);
        AppMethodBeat.m2505o(30373);
        return c40830z;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(30374);
        int size = this.yGD.size();
        AppMethodBeat.m2505o(30374);
        return size;
    }

    /* renamed from: Oc */
    private C40830z m88263Oc(int i) {
        AppMethodBeat.m2504i(30375);
        C40830z c40830z = (C40830z) this.yGD.get(i);
        AppMethodBeat.m2505o(30375);
        return c40830z;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C23704aq c23704aq;
        AppMethodBeat.m2504i(30376);
        C40830z Oc = m88263Oc(i);
        if (view == null) {
            C23704aq c23704aq2 = new C23704aq();
            view = View.inflate(viewGroup.getContext(), 2130970614, null);
            c23704aq2.lBq = view.findViewById(2131821064);
            c23704aq2.gxi = (TextView) view.findViewById(2131823625);
            c23704aq2.iqT = (ImageView) view.findViewById(2131823624);
            c23704aq2.yKX = (TextView) view.findViewById(2131827346);
            c23704aq2.yMM = (SendDataToDeviceProgressBar) view.findViewById(2131827345);
            c23704aq2.yMM.setVisibility(4);
            view.setTag(c23704aq2);
            c23704aq = c23704aq2;
        } else {
            c23704aq = (C23704aq) view.getTag();
        }
        c23704aq.gxi.setText(Oc.eoz);
        C4990ab.m7419v("MicroMsg.AppInfoListAdapter", "position(%s), name(%s).", Integer.valueOf(i), Oc.eoz);
        if (Oc.resId != 0) {
            c23704aq.iqT.setImageResource(Oc.resId);
        } else {
            Bitmap b = C46494g.m87732b(Oc.appId, 1, C1338a.getDensity(this.context));
            if (b == null || b.isRecycled()) {
                C32291o.ahp().mo43766a(Oc.iconUrl, c23704aq.iqT, this.lyr);
            } else {
                c23704aq.iqT.setImageBitmap(b);
            }
        }
        c23704aq.lBq.setTag(Integer.valueOf(i));
        AppMethodBeat.m2505o(30376);
        return view;
    }
}
