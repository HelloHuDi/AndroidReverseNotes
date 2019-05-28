package com.tencent.p177mm.plugin.fts.p424ui.p425a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3155a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3156b;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;
import com.tencent.p177mm.plugin.fts.p424ui.C45976b.C3197c;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;

/* renamed from: com.tencent.mm.plugin.fts.ui.a.e */
public final class C43130e extends C39147k {
    public int count;
    private C20871a mKh = new C20871a();
    C34227b mKi = new C34227b();
    public String talker;

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.e$a */
    public class C20871a extends C3156b {
        public C20871a() {
            super();
        }

        /* renamed from: a */
        public final View mo7420a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(61978);
            View inflate = LayoutInflater.from(context).inflate(2130969614, viewGroup, false);
            C34227b c34227b = C43130e.this.mKi;
            c34227b.kxr = (TextView) inflate.findViewById(2131822768);
            c34227b.contentView = inflate.findViewById(2131821182);
            c34227b.mKk = inflate.findViewById(2131820896);
            c34227b.ejo = (ImageView) inflate.findViewById(2131821183);
            inflate.setTag(c34227b);
            AppMethodBeat.m2505o(61978);
            return inflate;
        }

        /* renamed from: a */
        public final void mo7421a(Context context, C3155a c3155a, C3154a c3154a, Object... objArr) {
            AppMethodBeat.m2504i(61979);
            C34227b c34227b = (C34227b) c3155a;
            C3201m.m5502b(C43130e.this.mKQ, c34227b.kxr);
            c34227b.contentView.setBackgroundResource(C25738R.drawable.a_r);
            C40460b.m69434b(c34227b.ejo, C43130e.this.talker);
            if (C43130e.this.position == 0) {
                c34227b.mKk.setVisibility(8);
                AppMethodBeat.m2505o(61979);
                return;
            }
            c34227b.mKk.setVisibility(0);
            AppMethodBeat.m2505o(61979);
        }

        /* renamed from: a */
        public final boolean mo7422a(Context context, C3154a c3154a) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.e$b */
    public class C34227b extends C3155a {
        public View contentView;
        public ImageView ejo;
        public TextView kxr;
        public View mKk;

        public C34227b() {
            super();
        }
    }

    public C43130e(int i) {
        super(i);
        AppMethodBeat.m2504i(61980);
        AppMethodBeat.m2505o(61980);
    }

    /* renamed from: a */
    public final void mo7413a(Context context, C3155a c3155a, Object... objArr) {
        AppMethodBeat.m2504i(61981);
        this.mKQ = context.getString(C25738R.string.e0y, new Object[]{TextUtils.ellipsize(C3161d.m5401LC(this.talker), C3197c.mHz, 500.0f, TruncateAt.MIDDLE)});
        AppMethodBeat.m2505o(61981);
    }

    /* renamed from: Ps */
    public final C3156b mo7412Ps() {
        return this.mKh;
    }

    public final C3155a bBi() {
        return this.mKi;
    }
}
