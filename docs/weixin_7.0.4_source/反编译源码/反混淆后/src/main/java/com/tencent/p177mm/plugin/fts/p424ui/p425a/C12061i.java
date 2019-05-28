package com.tencent.p177mm.plugin.fts.p424ui.p425a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.C34204f;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3155a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3156b;
import com.tencent.p177mm.plugin.fts.p424ui.C3201m;
import com.tencent.p177mm.plugin.fts.p424ui.C45976b.C3197c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.fts.ui.a.i */
public final class C12061i extends C3154a {
    public String mEp;
    public boolean mKF;
    public CharSequence mKG;
    private C3192b mKH = new C3192b();
    private C12062a mKI = new C12062a();

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.i$b */
    public class C3192b extends C3156b {
        public C3192b() {
            super();
        }

        /* renamed from: a */
        public final View mo7420a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(61995);
            View inflate = LayoutInflater.from(context).inflate(2130969617, viewGroup, false);
            C12062a c12062a = new C12062a();
            c12062a.mJS = (TextView) inflate.findViewById(2131821051);
            c12062a.iqT = (ImageView) inflate.findViewById(2131821226);
            c12062a.mKk = inflate.findViewById(2131820896);
            c12062a.contentView = inflate.findViewById(2131821182);
            inflate.setTag(c12062a);
            AppMethodBeat.m2505o(61995);
            return inflate;
        }

        /* renamed from: a */
        public final void mo7421a(Context context, C3155a c3155a, C3154a c3154a, Object... objArr) {
            AppMethodBeat.m2504i(61996);
            C12062a c12062a = (C12062a) c3155a;
            C12061i c12061i = (C12061i) c3154a;
            C3201m.m5503p(c12062a.contentView, C12061i.this.mFk);
            c12062a.mJS.setText(c12061i.mKG);
            c12062a.iqT.setImageResource(C1318a.fts_more_button_icon);
            if (C12061i.this.position == 0 || !C12061i.this.mKF) {
                c12062a.mKk.setVisibility(8);
                AppMethodBeat.m2505o(61996);
                return;
            }
            c12062a.mKk.setVisibility(0);
            AppMethodBeat.m2505o(61996);
        }

        /* renamed from: a */
        public final boolean mo7422a(Context context, C3154a c3154a) {
            AppMethodBeat.m2504i(61997);
            Intent intent = new Intent();
            intent.putExtra("key_talker_query", C12061i.this.mDz.mEb[0]);
            intent.putExtra("key_query", C12061i.this.mDz.mEb[1]);
            intent.putExtra("Search_Scene", C12061i.this.mFa);
            if (C5046bo.isNullOrNil(C12061i.this.mEp)) {
                C3161d.m5413c(context, ".ui.FTSTalkerMessageUI", intent);
            } else {
                intent.putExtra("key_conv", C12061i.this.mEp);
                intent.putExtra("detail_type", 1);
                C3161d.m5413c(context, ".ui.FTSConvTalkerMessageUI", intent);
            }
            AppMethodBeat.m2505o(61997);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.i$a */
    public class C12062a extends C3155a {
        public View contentView;
        public ImageView iqT;
        public TextView mJS;
        public View mKk;

        public C12062a() {
            super();
        }
    }

    public C12061i(int i) {
        super(19, i);
        AppMethodBeat.m2504i(61998);
        AppMethodBeat.m2505o(61998);
    }

    /* renamed from: a */
    public final void mo7413a(Context context, C3155a c3155a, Object... objArr) {
        AppMethodBeat.m2504i(61999);
        CharSequence ellipsize = TextUtils.ellipsize(this.mDz.mEb[0], C3197c.mHz, 200.0f, TruncateAt.MIDDLE);
        CharSequence ellipsize2 = TextUtils.ellipsize(this.mDz.mEb[1], C3197c.mHz, 400.0f, TruncateAt.MIDDLE);
        if (C5046bo.isNullOrNil(this.mEp)) {
            this.mKG = TextUtils.concat(new CharSequence[]{context.getString(C25738R.string.e0z), C34204f.m56095j(ellipsize, ellipsize.length()), context.getString(C25738R.string.e10), C34204f.m56095j(ellipsize2, ellipsize2.length()), context.getString(C25738R.string.e11)});
            AppMethodBeat.m2505o(61999);
            return;
        }
        this.mKG = TextUtils.concat(new CharSequence[]{context.getString(C25738R.string.e12), C34204f.m56095j(ellipsize, ellipsize.length()), context.getString(C25738R.string.e10), C34204f.m56095j(ellipsize2, ellipsize2.length()), context.getString(C25738R.string.e11)});
        AppMethodBeat.m2505o(61999);
    }

    /* renamed from: Ps */
    public final C3156b mo7412Ps() {
        return this.mKH;
    }
}
