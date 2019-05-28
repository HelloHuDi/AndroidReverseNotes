package com.tencent.p177mm.plugin.fts.p424ui.p425a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3155a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3156b;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.fts.ui.a.k */
public class C39147k extends C3154a {
    public String mKQ;
    private C28145b mKR = new C28145b();
    private C12064a mKS = new C12064a();

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.k$a */
    public class C12064a extends C3155a {
        public View contentView;
        public TextView kxr;
        public View mKk;

        public C12064a() {
            super();
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.k$b */
    public class C28145b extends C3156b {
        public C28145b() {
            super();
        }

        /* renamed from: a */
        public final View mo7420a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(62005);
            View inflate = LayoutInflater.from(context).inflate(2130969624, viewGroup, false);
            C12064a c12064a = (C12064a) C39147k.this.bBi();
            c12064a.kxr = (TextView) inflate.findViewById(2131822768);
            c12064a.mKk = inflate.findViewById(2131820896);
            c12064a.contentView = inflate.findViewById(2131821182);
            inflate.setTag(c12064a);
            AppMethodBeat.m2505o(62005);
            return inflate;
        }

        /* renamed from: a */
        public final void mo7421a(Context context, C3155a c3155a, C3154a c3154a, Object... objArr) {
            AppMethodBeat.m2504i(62006);
            C12064a c12064a = (C12064a) c3155a;
            C3201m.m5502b(C39147k.this.mKQ, c12064a.kxr);
            if (C39147k.this.position == 0) {
                c12064a.mKk.setVisibility(8);
            } else {
                c12064a.mKk.setVisibility(0);
            }
            C3201m.m5504q(c12064a.contentView, C39147k.this.mFk);
            AppMethodBeat.m2505o(62006);
        }

        /* renamed from: a */
        public final boolean mo7422a(Context context, C3154a c3154a) {
            return false;
        }
    }

    public C39147k(int i) {
        super(0, i);
        AppMethodBeat.m2504i(62007);
        AppMethodBeat.m2505o(62007);
    }

    /* renamed from: a */
    public void mo7413a(Context context, C3155a c3155a, Object... objArr) {
        AppMethodBeat.m2504i(62008);
        this.mKQ = C5046bo.m7532bc(C3201m.m5505wf(this.mFl), "");
        C4990ab.m7417i("MicroMsg.FTS.FTSHeaderDataItem", "fillingDataItem: header=%s", this.mKQ);
        AppMethodBeat.m2505o(62008);
    }

    /* renamed from: Ps */
    public C3156b mo7412Ps() {
        return this.mKR;
    }

    public C3155a bBi() {
        return this.mKS;
    }
}
