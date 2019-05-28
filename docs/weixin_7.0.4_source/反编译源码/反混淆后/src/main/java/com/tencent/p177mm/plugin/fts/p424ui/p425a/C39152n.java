package com.tencent.p177mm.plugin.fts.p424ui.p425a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3155a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3156b;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.fts.ui.a.n */
public class C39152n extends C3154a {
    public String mLd;
    private C28146b mLe = new C28146b();
    private C39151a mLf = new C39151a();

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.n$b */
    public class C28146b extends C3156b {
        public C28146b() {
            super();
        }

        /* renamed from: a */
        public final View mo7420a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(62018);
            View inflate = LayoutInflater.from(context).inflate(2130969636, viewGroup, false);
            C39151a c39151a = new C39151a();
            c39151a.mJS = (TextView) inflate.findViewById(2131821051);
            c39151a.iqT = (ImageView) inflate.findViewById(2131821226);
            c39151a.contentView = inflate.findViewById(2131821182);
            inflate.setTag(c39151a);
            AppMethodBeat.m2505o(62018);
            return inflate;
        }

        /* renamed from: a */
        public final void mo7421a(Context context, C3155a c3155a, C3154a c3154a, Object... objArr) {
            AppMethodBeat.m2504i(62019);
            C39151a c39151a = (C39151a) c3155a;
            C39152n c39152n = (C39152n) c3154a;
            C3201m.m5503p(c39151a.contentView, C39152n.this.mFk);
            c39151a.mJS.setText(c39152n.mLd);
            c39151a.iqT.setImageResource(C1318a.fts_more_button_icon);
            AppMethodBeat.m2505o(62019);
        }

        /* renamed from: a */
        public final boolean mo7422a(Context context, C3154a c3154a) {
            AppMethodBeat.m2504i(62020);
            Intent intent = new Intent();
            intent.putExtra("detail_query", C39152n.this.mDz.mDY);
            intent.putExtra("detail_type", C39152n.this.mFl);
            intent.putExtra("Search_Scene", C39152n.this.mFa);
            C3161d.m5413c(context, ".ui.FTSDetailUI", intent);
            AppMethodBeat.m2505o(62020);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.n$a */
    public class C39151a extends C3155a {
        public View contentView;
        public ImageView iqT;
        public TextView mJS;

        public C39151a() {
            super();
        }
    }

    public C39152n(int i) {
        super(12, i);
        AppMethodBeat.m2504i(62021);
        AppMethodBeat.m2505o(62021);
    }

    /* renamed from: a */
    public final void mo7413a(Context context, C3155a c3155a, Object... objArr) {
        AppMethodBeat.m2504i(62022);
        if (C3201m.m5505wf(this.mFl) == null) {
            this.mLd = "";
        } else {
            this.mLd = context.getResources().getString(C25738R.string.dzq, new Object[]{r0});
        }
        C4990ab.m7417i("MicroMsg.FTS.FTSMoreDataItem", "fillDataItem: tip=%s", this.mLd);
        AppMethodBeat.m2505o(62022);
    }

    /* renamed from: Ps */
    public C3156b mo7412Ps() {
        return this.mLe;
    }
}
