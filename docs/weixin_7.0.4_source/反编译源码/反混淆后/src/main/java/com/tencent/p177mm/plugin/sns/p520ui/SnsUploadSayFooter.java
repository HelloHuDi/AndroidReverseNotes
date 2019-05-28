package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C18175j;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.widget.InputPanelLinearLayout;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel.C44073a;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44080d;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44081e;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadSayFooter */
public class SnsUploadSayFooter extends InputPanelLinearLayout {
    private MMActivity crP;
    ChatFooterPanel eAk;
    private MMEditText jZg = null;
    private ImageButton jZh;
    private int jZk = -1;
    private int jZl = -1;
    private int jZm = 0;
    private boolean jZn = true;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadSayFooter$4 */
    class C135794 implements C44073a {
        C135794() {
        }

        public final void aYY() {
        }

        /* renamed from: fC */
        public final void mo24351fC(boolean z) {
        }

        public final void aRg() {
            AppMethodBeat.m2504i(39719);
            SnsUploadSayFooter.this.jZg.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
            SnsUploadSayFooter.this.jZg.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
            AppMethodBeat.m2505o(39719);
        }

        public final void append(String str) {
            AppMethodBeat.m2504i(39720);
            try {
                SnsUploadSayFooter.this.jZg.asB(str);
                AppMethodBeat.m2505o(39720);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SnsUploadSayFooter", e, "", new Object[0]);
                AppMethodBeat.m2505o(39720);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadSayFooter$5 */
    class C135805 implements Runnable {
        C135805() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39721);
            SnsUploadSayFooter.this.eAk.setVisibility(8);
            AppMethodBeat.m2505o(39721);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadSayFooter$6 */
    class C291646 implements Runnable {
        C291646() {
        }

        public final void run() {
            AppMethodBeat.m2504i(39722);
            SnsUploadSayFooter.this.eAk.setVisibility(0);
            AppMethodBeat.m2505o(39722);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadSayFooter$2 */
    class C398202 implements OnEditorActionListener {
        C398202() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadSayFooter$1 */
    class C462441 implements OnClickListener {
        C462441() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39717);
            if (SnsUploadSayFooter.this.getVisibility() == 8) {
                SnsUploadSayFooter.this.setVisibility(0);
            }
            if (SnsUploadSayFooter.this.aYV()) {
                SnsUploadSayFooter.m89542a(SnsUploadSayFooter.this);
            }
            AppMethodBeat.m2505o(39717);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsUploadSayFooter$3 */
    class C462453 implements OnClickListener {
        C462453() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39718);
            SnsUploadSayFooter.m89543b(SnsUploadSayFooter.this);
            AppMethodBeat.m2505o(39718);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m89542a(SnsUploadSayFooter snsUploadSayFooter) {
        AppMethodBeat.m2504i(39733);
        snsUploadSayFooter.aRe();
        AppMethodBeat.m2505o(39733);
    }

    public SnsUploadSayFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(39723);
        this.crP = (MMActivity) context;
        this.jZh = (ImageButton) ((ViewGroup) C5616v.m8409hu(this.crP).inflate(2130970826, this)).findViewById(2131825682);
        this.jZh.setOnClickListener(new C462453());
        if (C44081e.vom == null) {
            this.eAk = new C44080d(this.crP);
            AppMethodBeat.m2505o(39723);
            return;
        }
        this.eAk = C44081e.vom.mo35682dF(getContext());
        this.eAk.setEntranceScene(ChatFooterPanel.vhj);
        this.eAk.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) findViewById(2131820987);
        linearLayout.setOnClickListener(null);
        this.jZm = C40619x.m70073gs(getContext());
        linearLayout.addView(this.eAk, -1, this.jZm);
        this.eAk.mo11687AD();
        this.eAk.mo11691bf(false);
        aYX();
        this.eAk.setOnTextOperationListener(new C135794());
        AppMethodBeat.m2505o(39723);
    }

    public final void aYS() {
        AppMethodBeat.m2504i(39724);
        setVisibility(0);
        if (this.jZh != null) {
            this.jZh.setImageResource(C25738R.drawable.a1p);
        }
        AppMethodBeat.m2505o(39724);
    }

    public void setMMEditText(MMEditText mMEditText) {
        AppMethodBeat.m2504i(39725);
        this.jZg = mMEditText;
        mMEditText.setOnClickListener(new C462441());
        mMEditText.setOnEditorActionListener(new C398202());
        AppMethodBeat.m2505o(39725);
    }

    public final boolean aYV() {
        AppMethodBeat.m2504i(39726);
        if (this.eAk.getVisibility() == 0) {
            AppMethodBeat.m2505o(39726);
            return true;
        }
        AppMethodBeat.m2505o(39726);
        return false;
    }

    public final void aYW() {
        AppMethodBeat.m2504i(39727);
        aRe();
        setVisibility(8);
        AppMethodBeat.m2505o(39727);
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(39728);
        super.onConfigurationChanged(configuration);
        if (this.eAk != null) {
            aYX();
            this.eAk.refresh();
        }
        AppMethodBeat.m2505o(39728);
    }

    private void aRe() {
        AppMethodBeat.m2504i(39729);
        this.eAk.onPause();
        if (C40619x.m70075gu(getContext())) {
            getInputPanelHelper().mo64518az(new C135805());
            AppMethodBeat.m2505o(39729);
            return;
        }
        this.eAk.setVisibility(8);
        AppMethodBeat.m2505o(39729);
    }

    /* renamed from: m */
    public final void mo39878m(boolean z, int i) {
        AppMethodBeat.m2504i(39730);
        super.mo39878m(z, i);
        if (!(this.jZm == i || i == 0)) {
            this.jZm = i;
            C18175j.m28620x(getContext(), i);
            aYX();
        }
        AppMethodBeat.m2505o(39730);
    }

    private void aYX() {
        AppMethodBeat.m2504i(39731);
        int gs = C40619x.m70073gs(getContext());
        this.eAk.setPortHeightPx(gs);
        this.eAk.mo11690AG();
        LayoutParams layoutParams = this.eAk.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = gs;
        }
        AppMethodBeat.m2505o(39731);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(39732);
        super.onLayout(z, i, i2, i3, i4);
        this.jZk = this.jZk < i4 ? i4 : this.jZk;
        this.jZl = i4;
        AppMethodBeat.m2505o(39732);
    }

    /* renamed from: b */
    static /* synthetic */ void m89543b(SnsUploadSayFooter snsUploadSayFooter) {
        int i = 1;
        AppMethodBeat.m2504i(39734);
        if (snsUploadSayFooter.eAk.getVisibility() == 8) {
            snsUploadSayFooter.crP.aqX();
            snsUploadSayFooter.eAk.onResume();
            snsUploadSayFooter.aYX();
            if (C40619x.m70075gu(snsUploadSayFooter.getContext())) {
                C4990ab.m7417i("MicroMsg.SnsUploadSayFooter", "is show key board %d, %d, %d", Integer.valueOf(snsUploadSayFooter.jZl), Integer.valueOf(snsUploadSayFooter.jZk), Integer.valueOf(C5222ae.m7944fr(snsUploadSayFooter.getContext())));
                if (snsUploadSayFooter.jZl <= 0 || snsUploadSayFooter.jZl >= snsUploadSayFooter.jZk - r2) {
                    i = 0;
                }
                if (i != 0 || snsUploadSayFooter.jZn) {
                    snsUploadSayFooter.jZn = false;
                    snsUploadSayFooter.getInputPanelHelper().mo64517aA(new C291646());
                    snsUploadSayFooter.jZg.requestFocus();
                    snsUploadSayFooter.jZh.setImageResource(C25738R.drawable.a1e);
                    AppMethodBeat.m2505o(39734);
                    return;
                }
            }
            snsUploadSayFooter.eAk.setVisibility(0);
            snsUploadSayFooter.jZg.requestFocus();
            snsUploadSayFooter.jZh.setImageResource(C25738R.drawable.a1e);
            AppMethodBeat.m2505o(39734);
            return;
        }
        snsUploadSayFooter.jZg.requestFocus();
        snsUploadSayFooter.aRe();
        snsUploadSayFooter.crP.showVKB();
        snsUploadSayFooter.jZh.setImageResource(C25738R.drawable.a1p);
        AppMethodBeat.m2505o(39734);
    }
}
