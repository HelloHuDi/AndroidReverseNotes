package com.tencent.p177mm.plugin.shake.p511ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.MMSlideDelView;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23597d;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23599f;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C41338bt;
import com.tencent.p177mm.storage.C46622bu;
import com.tencent.p177mm.storage.C7620bi.C5138d;

/* renamed from: com.tencent.mm.plugin.shake.ui.b */
final class C43526b extends C46692p<C41338bt> {
    private MMActivity crP;
    protected C23600g jJO;
    protected C15521c jJP;
    protected C23597d jJR = MMSlideDelView.getItemStatusCallBack();
    private int limit = -1;
    protected C23599f oQS;
    private C46622bu qui;

    /* renamed from: com.tencent.mm.plugin.shake.ui.b$a */
    static class C3847a {
        ImageView eks;
        TextView gtG;
        View jJW;
        TextView jJX;
        TextView ooM;

        C3847a() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.b$1 */
    class C349141 implements OnClickListener {
        C349141() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(24700);
            C4990ab.m7418v("MicroMsg.SayHiAdapter", "on delView clicked");
            C43526b.this.jJR.bIq();
            if (C43526b.this.oQS != null) {
                C43526b.this.oQS.mo11067bN(view.getTag());
            }
            AppMethodBeat.m2505o(24700);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
        AppMethodBeat.m2504i(24706);
        C41338bt c41338bt = (C41338bt) obj;
        if (c41338bt == null) {
            c41338bt = new C41338bt();
        }
        c41338bt.mo8995d(cursor);
        AppMethodBeat.m2505o(24706);
        return c41338bt;
    }

    public C43526b(Context context, C46622bu c46622bu, int i) {
        super(context, new C41338bt());
        AppMethodBeat.m2504i(24701);
        this.crP = (MMActivity) context;
        this.limit = i;
        this.qui = c46622bu;
        AppMethodBeat.m2505o(24701);
    }

    public final void setPerformItemClickListener(C23600g c23600g) {
        this.jJO = c23600g;
    }

    /* renamed from: a */
    public final void mo69080a(C23599f c23599f) {
        this.oQS = c23599f;
    }

    public final void setGetViewPositionCallback(C15521c c15521c) {
        this.jJP = c15521c;
    }

    /* renamed from: CA */
    public final void mo69079CA(int i) {
        AppMethodBeat.m2504i(24702);
        bIf();
        this.limit = i;
        mo6869KC();
        AppMethodBeat.m2505o(24702);
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(24703);
        mo6869KC();
        AppMethodBeat.m2505o(24703);
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        AppMethodBeat.m2504i(24704);
        setCursor(this.qui.mo74765xm(this.limit));
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(24704);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C3847a c3847a;
        AppMethodBeat.m2504i(24705);
        C41338bt c41338bt = (C41338bt) getItem(i);
        if (view == null) {
            View view2 = (MMSlideDelView) View.inflate(this.crP, 2130968832, null);
            C3847a c3847a2 = new C3847a();
            View inflate = View.inflate(this.crP, 2130970535, null);
            c3847a2.eks = (ImageView) inflate.findViewById(2131823840);
            c3847a2.gtG = (TextView) inflate.findViewById(2131827176);
            c3847a2.ooM = (TextView) inflate.findViewById(2131827177);
            c3847a2.jJW = view2.findViewById(2131821704);
            c3847a2.jJX = (TextView) view2.findViewById(2131821082);
            view2.setView(inflate);
            view2.setPerformItemClickListener(this.jJO);
            view2.setGetViewPositionCallback(this.jJP);
            view2.setItemStatusCallBack(this.jJR);
            view2.setEnable(false);
            view2.setTag(c3847a2);
            c3847a = c3847a2;
            view = view2;
        } else {
            c3847a = (C3847a) view.getTag();
        }
        c3847a.jJW.setTag(Long.valueOf(c41338bt.field_svrid));
        c3847a.jJW.setOnClickListener(new C349141());
        c3847a.gtG.setText(C44089j.m79293b(this.crP, C5138d.apF(c41338bt.field_content).getDisplayName(), c3847a.gtG.getTextSize()));
        c3847a.ooM.setText(c41338bt.field_sayhicontent);
        C40460b.m69434b(c3847a.eks, c41338bt.field_sayhiuser);
        AppMethodBeat.m2505o(24705);
        return view;
    }
}
