package com.tencent.p177mm.plugin.music.p467ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C37752ke;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C14933b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.music.ui.a */
public final class C3543a extends C14933b {
    private C4884c hAA;
    private View jyC;
    private View jyD;
    private TextView oOp;

    /* renamed from: com.tencent.mm.plugin.music.ui.a$1 */
    class C35441 implements OnClickListener {
        C35441() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(105055);
            C9058e aih = C37494a.aih();
            Intent intent;
            if (aih == null || !aih.fKt || TextUtils.isEmpty(aih.fKu)) {
                intent = new Intent();
                C7060h.pYm.mo8381e(11992, Integer.valueOf(1));
                intent.putExtra("key_scene", 1);
                C25985d.m41467b((Context) C3543a.this.vlu.get(), "music", ".ui.MusicMainUI", intent);
                AppMethodBeat.m2505o(105055);
                return;
            }
            C4990ab.m7417i("MusicBanner", "barBackToWebView is true, start to jump Url:%s", aih.fKu);
            intent = new Intent();
            intent.putExtra("rawUrl", r0);
            C25985d.m41467b((Context) C3543a.this.vlu.get(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(105055);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.ui.a$2 */
    class C35452 extends C4884c<C37752ke> {
        C35452() {
            AppMethodBeat.m2504i(105056);
            this.xxI = C37752ke.class.getName().hashCode();
            AppMethodBeat.m2505o(105056);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(105057);
            switch (((C37752ke) c4883b).cFH.action) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 7:
                    C3543a.m5838a(C3543a.this);
                    break;
            }
            AppMethodBeat.m2505o(105057);
            return false;
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m5838a(C3543a c3543a) {
        AppMethodBeat.m2504i(105064);
        boolean bUK = c3543a.bUK();
        AppMethodBeat.m2505o(105064);
        return bUK;
    }

    public C3543a(Context context) {
        super(context);
        AppMethodBeat.m2504i(105058);
        if (this.view != null) {
            this.oOp = (TextView) this.view.findViewById(2131826252);
            this.jyC = this.view.findViewById(2131826251);
            this.jyD = this.view.findViewById(2131821629);
            this.oOp.setTextSize(0, (float) C1338a.m2856al(C4996ah.getContext(), C25738R.dimen.f9936kr));
            this.view.setOnClickListener(new C35441());
        }
        this.hAA = new C35452();
        C4879a.xxA.mo10052c(this.hAA);
        AppMethodBeat.m2505o(105058);
    }

    public final int getLayoutId() {
        return 2130970271;
    }

    public final void setVisibility(int i) {
        AppMethodBeat.m2504i(105059);
        if (this.view != null) {
            this.view.findViewById(2131826251).setVisibility(i);
        }
        AppMethodBeat.m2505o(105059);
    }

    public final boolean aMN() {
        AppMethodBeat.m2504i(105060);
        boolean bUK = bUK();
        AppMethodBeat.m2505o(105060);
        return bUK;
    }

    public final void destroy() {
        AppMethodBeat.m2504i(105061);
        C4879a.xxA.mo10053d(this.hAA);
        AppMethodBeat.m2505o(105061);
    }

    /* renamed from: Tt */
    private void m5837Tt(String str) {
        AppMethodBeat.m2504i(105062);
        if (this.oOp != null) {
            this.oOp.setText(str);
        }
        AppMethodBeat.m2505o(105062);
    }

    public final int getOrder() {
        return 1;
    }

    private boolean bUK() {
        AppMethodBeat.m2504i(105063);
        if (this.nfA && this.eVH) {
            this.jyD.setBackgroundResource(C25738R.drawable.a3h);
            this.jyC.setBackground(null);
            this.oOp.setBackground(null);
        } else if (this.nfA) {
            this.jyD.setBackgroundResource(C25738R.drawable.f6802r9);
            this.jyC.setBackgroundResource(C25738R.drawable.b7t);
            this.oOp.setBackgroundResource(C25738R.drawable.a_q);
        } else if (this.eVH) {
            this.jyD.setBackgroundResource(C25738R.drawable.f6802r9);
            this.jyC.setBackgroundResource(C25738R.drawable.a_q);
            this.oOp.setBackground(null);
        } else {
            this.jyD.setBackgroundResource(C25738R.drawable.f6802r9);
            this.jyC.setBackground(null);
            this.oOp.setBackgroundResource(C25738R.drawable.a_q);
        }
        if (C37494a.aie()) {
            int i;
            C9058e aih = C37494a.aih();
            m5837Tt(C4996ah.getContext().getString(C25738R.string.d3t) + C4996ah.getContext().getString(C25738R.string.d3u) + aih.fJW);
            if (aih.fKq) {
                i = 8;
            } else {
                i = 0;
            }
            setVisibility(i);
            if (aih.fKq) {
                AppMethodBeat.m2505o(105063);
                return false;
            }
            AppMethodBeat.m2505o(105063);
            return true;
        } else if (C37494a.aif()) {
            setVisibility(0);
            AppMethodBeat.m2505o(105063);
            return true;
        } else {
            setVisibility(8);
            AppMethodBeat.m2505o(105063);
            return false;
        }
    }
}
