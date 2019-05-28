package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.game.model.C28219aa;
import com.tencent.p177mm.plugin.game.model.C28219aa.C28220a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.plugin.game.ui.i */
public final class C12202i extends BaseAdapter {
    /* renamed from: Rt */
    int f2909Rt;
    private Context mContext;
    int mXC;
    private C28219aa ngk;

    /* renamed from: com.tencent.mm.plugin.game.ui.i$a */
    class C12203a {
        public ImageView gvq;
        public TextView ngm;
        public TextView ngn;
        public TextView ngo;
        public TextView ngp;
        GameDetailRankLikeView ngq;

        private C12203a() {
        }

        /* synthetic */ C12203a(C12202i c12202i, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.i$1 */
    class C122041 implements Runnable {
        C122041() {
        }

        public final void run() {
            AppMethodBeat.m2504i(111811);
            C12202i.this.notifyDataSetChanged();
            AppMethodBeat.m2505o(111811);
        }
    }

    public C12202i(Context context) {
        this.mContext = context;
    }

    /* renamed from: a */
    public final void mo24034a(C28219aa c28219aa) {
        AppMethodBeat.m2504i(111812);
        this.ngk = c28219aa;
        C5004al.m7441d(new C122041());
        AppMethodBeat.m2505o(111812);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(111813);
        if (this.ngk == null) {
            AppMethodBeat.m2505o(111813);
            return 0;
        }
        int size = this.ngk.mXO.size();
        AppMethodBeat.m2505o(111813);
        return size;
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(111814);
        Object obj = this.ngk.mXO.get(i);
        AppMethodBeat.m2505o(111814);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C12203a c12203a;
        AppMethodBeat.m2504i(111815);
        if (view == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(this.f2909Rt, viewGroup, false);
            c12203a = new C12203a(this, (byte) 0);
            c12203a.ngm = (TextView) inflate.findViewById(2131824453);
            c12203a.gvq = (ImageView) inflate.findViewById(2131824454);
            c12203a.ngn = (TextView) inflate.findViewById(2131824455);
            c12203a.ngo = (TextView) inflate.findViewById(2131824456);
            c12203a.ngp = (TextView) inflate.findViewById(2131824457);
            c12203a.ngq = (GameDetailRankLikeView) inflate.findViewById(2131824458);
            c12203a.ngq.setSourceScene(this.mXC);
            m20132o((ViewGroup) inflate);
            inflate.setTag(c12203a);
            view = inflate;
        } else {
            c12203a = (C12203a) view.getTag();
        }
        C28220a c28220a = (C28220a) getItem(i);
        c12203a.ngm.setText(c28220a.mXP);
        C40460b.m69433a(c12203a.gvq, c28220a.cIS, 0.5f, false);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c28220a.cIS);
        if (aoO != null) {
            c12203a.ngn.setText(new SpannableString(C44089j.m79293b(this.mContext, aoO.mo16707Oj(), c12203a.ngn.getTextSize())));
        } else {
            c12203a.ngn.setText("");
        }
        if (C5046bo.isNullOrNil(c28220a.tag)) {
            c12203a.ngo.setVisibility(8);
        } else {
            c12203a.ngo.setVisibility(0);
            c12203a.ngo.setText(c28220a.tag);
        }
        if (C5046bo.isNullOrNil(c28220a.mXS)) {
            c12203a.ngp.setText(c28220a.mEA);
            GameDetailRankLikeView gameDetailRankLikeView = c12203a.ngq;
            C28219aa c28219aa = this.ngk;
            gameDetailRankLikeView.ngr = c28219aa;
            gameDetailRankLikeView.mAppId = c28219aa.mAppId;
            gameDetailRankLikeView.ngs = (C28220a) c28219aa.mXO.get(i);
            gameDetailRankLikeView.resetState();
            c12203a.ngq.setVisibility(0);
        } else {
            c12203a.ngp.setText(c28220a.mXS);
            c12203a.ngq.setVisibility(8);
        }
        AppMethodBeat.m2505o(111815);
        return view;
    }

    /* renamed from: o */
    private void m20132o(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(111816);
        viewGroup.setClipChildren(false);
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                ((ViewGroup) childAt).setClipChildren(false);
                m20132o((ViewGroup) childAt);
            }
        }
        AppMethodBeat.m2505o(111816);
    }
}
