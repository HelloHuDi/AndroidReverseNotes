package com.tencent.p177mm.p612ui.p1093d;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.model.p871b.C45437b;
import com.tencent.p177mm.model.p871b.C45437b.C9646b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C14933b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.d.a */
public final class C24001a extends C14933b {
    String mUrl = null;
    private String nER = null;
    private boolean ysf = false;
    private C9646b ysg = null;
    private String ysh = "";

    /* renamed from: com.tencent.mm.ui.d.a$1 */
    class C158781 implements OnClickListener {
        C158781() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(29989);
            C24001a.this.mo39808Nx(1);
            C24001a c24001a = C24001a.this;
            String str = C24001a.this.mUrl;
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.ChattingMonitoredBanner", "hy: not provide url");
                AppMethodBeat.m2505o(29989);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            C25985d.m41467b((Context) c24001a.vlu.get(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(29989);
        }
    }

    /* renamed from: com.tencent.mm.ui.d.a$2 */
    class C158792 implements OnClickListener {
        C158792() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(29990);
            C4990ab.m7416i("MicroMsg.ChattingMonitoredBanner", "hy: user required close the banner");
            C24001a.this.mo39808Nx(2);
            C9638aw.m17190ZK().mo33887Ym().mo73240c(C9646b.Main);
            C9638aw.m17190ZK().mo33887Ym().mo73240c(C9646b.Chatting);
            C24001a.this.setVisibility(8);
            AppMethodBeat.m2505o(29990);
        }
    }

    public C24001a(Context context, C9646b c9646b) {
        super(context);
        AppMethodBeat.m2504i(29991);
        this.ysg = c9646b;
        refresh();
        AppMethodBeat.m2505o(29991);
    }

    public final int getLayoutId() {
        return 2130969118;
    }

    private void refresh() {
        AppMethodBeat.m2504i(29992);
        C9638aw.m17190ZK().mo33887Ym();
        if (C45437b.m83691a(this.ysg)) {
            C4990ab.m7417i("MicroMsg.ChattingMonitoredBanner", "hy: start show banner: %s, %s, %s, %b", this.ysg, this.nER, this.mUrl, Boolean.valueOf(this.ysf));
            if (this.ysg == C9646b.Chatting) {
                C9638aw.m17190ZK().mo33887Ym();
                this.nER = C45437b.aaQ();
                C9638aw.m17190ZK().mo33887Ym();
                this.mUrl = C45437b.aaR();
                C9638aw.m17190ZK().mo33887Ym();
                this.ysf = C45437b.aaS();
            } else {
                C9638aw.m17190ZK().mo33887Ym();
                this.nER = C45437b.aaN();
                C9638aw.m17190ZK().mo33887Ym();
                this.mUrl = C45437b.aaO();
                C9638aw.m17190ZK().mo33887Ym();
                this.ysf = C45437b.aaP();
            }
            TextView textView = (TextView) getView().findViewById(2131822693);
            ImageView imageView = (ImageView) getView().findViewById(2131822694);
            if (C5046bo.isNullOrNil(this.nER)) {
                textView.setText(C25738R.string.f9260un);
            } else {
                textView.setText(this.nER);
            }
            textView.setSelected(true);
            if (C5046bo.isNullOrNil(this.mUrl)) {
                getView().findViewById(2131822692).setBackgroundResource(C25738R.color.a34);
                imageView.setImageResource(C25738R.drawable.f6911v7);
                textView.setTextColor(C4996ah.getContext().getResources().getColor(C25738R.color.a69));
            } else {
                getView().findViewById(2131822692).setBackgroundResource(C25738R.drawable.a3h);
                imageView.setImageResource(C25738R.drawable.f6912v8);
                textView.setTextColor(C4996ah.getContext().getResources().getColor(C25738R.color.a3_));
            }
            getView().setOnClickListener(new C158781());
            if (getView().getVisibility() != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                C1720g.m3534RN();
                this.ysh = stringBuilder.append(C1668a.m3383QF()).append("_").append(System.currentTimeMillis()).toString();
                mo39808Nx(0);
            }
            setVisibility(0);
            if (this.ysf) {
                imageView.setVisibility(0);
                imageView.setOnClickListener(new C158792());
                AppMethodBeat.m2505o(29992);
                return;
            }
            imageView.setVisibility(8);
            AppMethodBeat.m2505o(29992);
            return;
        }
        C4990ab.m7416i("MicroMsg.ChattingMonitoredBanner", "hy: should not show banner");
        setVisibility(8);
        AppMethodBeat.m2505o(29992);
    }

    public final void setVisibility(int i) {
        AppMethodBeat.m2504i(29993);
        super.setVisibility(i);
        getView().findViewById(2131822692).setVisibility(i);
        AppMethodBeat.m2505o(29993);
    }

    public final boolean aMN() {
        AppMethodBeat.m2504i(29994);
        refresh();
        boolean aMN = super.aMN();
        AppMethodBeat.m2505o(29994);
        return aMN;
    }

    public final void destroy() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Nx */
    public final void mo39808Nx(int i) {
        int i2 = 1;
        AppMethodBeat.m2504i(29995);
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[3];
        objArr[0] = this.ysh;
        objArr[1] = Integer.valueOf(i);
        if (this.ysg == C9646b.Main) {
            i2 = 0;
        }
        objArr[2] = Integer.valueOf(i2);
        c7060h.mo8381e(14439, objArr);
        C7060h.pYm.mo8378a(633, (long) i, 1, false);
        AppMethodBeat.m2505o(29995);
    }
}
