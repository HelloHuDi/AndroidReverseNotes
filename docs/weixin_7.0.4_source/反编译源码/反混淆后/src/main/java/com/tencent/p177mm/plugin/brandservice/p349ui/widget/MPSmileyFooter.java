package com.tencent.p177mm.plugin.brandservice.p349ui.widget;

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
import com.tencent.p177mm.api.C41757u;
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

/* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPSmileyFooter */
public class MPSmileyFooter extends InputPanelLinearLayout {
    private MMActivity crP;
    private ChatFooterPanel eAk;
    private MMEditText jZg = null;
    private ImageButton jZh;
    private LinearLayout jZi;
    private LinearLayout jZj;
    private int jZk = -1;
    private int jZl = -1;
    private int jZm = 0;
    private boolean jZn = true;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPSmileyFooter$2 */
    class C201132 implements OnEditorActionListener {
        C201132() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPSmileyFooter$3 */
    class C201143 implements OnClickListener {
        C201143() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(14467);
            MPSmileyFooter.m89267b(MPSmileyFooter.this);
            AppMethodBeat.m2505o(14467);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPSmileyFooter$1 */
    class C275651 implements OnClickListener {
        C275651() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(14466);
            if (MPSmileyFooter.this.getVisibility() == 8) {
                MPSmileyFooter.this.setVisibility(0);
            }
            if (MPSmileyFooter.this.aYV()) {
                MPSmileyFooter.m89266a(MPSmileyFooter.this);
            }
            AppMethodBeat.m2505o(14466);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPSmileyFooter$4 */
    class C387194 implements C44073a {
        C387194() {
        }

        public final void aYY() {
        }

        /* renamed from: fC */
        public final void mo24351fC(boolean z) {
        }

        public final void aRg() {
            AppMethodBeat.m2504i(14468);
            MPSmileyFooter.this.jZg.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
            MPSmileyFooter.this.jZg.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
            AppMethodBeat.m2505o(14468);
        }

        public final void append(String str) {
            AppMethodBeat.m2504i(14469);
            try {
                MPSmileyFooter.this.jZg.asB(str);
                AppMethodBeat.m2505o(14469);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SnsUploadSayFooter", e, "", new Object[0]);
                AppMethodBeat.m2505o(14469);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPSmileyFooter$6 */
    class C387206 implements Runnable {
        C387206() {
        }

        public final void run() {
            AppMethodBeat.m2504i(14471);
            MPSmileyFooter.this.eAk.setVisibility(0);
            AppMethodBeat.m2505o(14471);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPSmileyFooter$5 */
    class C457685 implements Runnable {
        C457685() {
        }

        public final void run() {
            AppMethodBeat.m2504i(14470);
            MPSmileyFooter.this.eAk.setVisibility(8);
            AppMethodBeat.m2505o(14470);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m89266a(MPSmileyFooter mPSmileyFooter) {
        AppMethodBeat.m2504i(14484);
        mPSmileyFooter.aRe();
        AppMethodBeat.m2505o(14484);
    }

    public MPSmileyFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(14472);
        this.crP = (MMActivity) context;
        this.jZh = (ImageButton) ((ViewGroup) C5616v.m8409hu(this.crP).inflate(2130970251, this)).findViewById(2131825682);
        this.jZh.setOnClickListener(new C201143());
        if (C44081e.vom == null) {
            this.eAk = new C44080d(this.crP);
            AppMethodBeat.m2505o(14472);
            return;
        }
        this.eAk = C41757u.m73613i(this.crP, true);
        this.eAk.setEntranceScene(ChatFooterPanel.vhj);
        this.eAk.setBackgroundResource(C25738R.color.f11955n0);
        this.eAk.setVisibility(8);
        this.jZi = (LinearLayout) findViewById(2131826165);
        this.jZj = (LinearLayout) findViewById(2131826164);
        this.jZi.setOnClickListener(null);
        this.jZm = C40619x.m70073gs(getContext());
        this.jZi.addView(this.eAk, -1, this.jZm);
        this.eAk.mo11687AD();
        this.eAk.mo11691bf(false);
        aYX();
        this.eAk.setOnTextOperationListener(new C387194());
        AppMethodBeat.m2505o(14472);
    }

    public final void aYS() {
        AppMethodBeat.m2504i(14473);
        setVisibility(0);
        if (this.jZh != null) {
            this.jZh.setImageResource(C25738R.drawable.bcc);
        }
        AppMethodBeat.m2505o(14473);
    }

    public final void aYT() {
        AppMethodBeat.m2504i(14474);
        if (aYV()) {
            AppMethodBeat.m2505o(14474);
            return;
        }
        setVisibility(8);
        AppMethodBeat.m2505o(14474);
    }

    public void setMMEditText(MMEditText mMEditText) {
        AppMethodBeat.m2504i(14475);
        this.jZg = mMEditText;
        mMEditText.setOnClickListener(new C275651());
        mMEditText.setOnEditorActionListener(new C201132());
        AppMethodBeat.m2505o(14475);
    }

    public final boolean aYU() {
        AppMethodBeat.m2504i(14476);
        if (aYV() || getVisibility() == 0) {
            AppMethodBeat.m2505o(14476);
            return true;
        }
        AppMethodBeat.m2505o(14476);
        return false;
    }

    public final boolean aYV() {
        AppMethodBeat.m2504i(14477);
        if (this.eAk.getVisibility() == 0) {
            AppMethodBeat.m2505o(14477);
            return true;
        }
        AppMethodBeat.m2505o(14477);
        return false;
    }

    public final void aYW() {
        AppMethodBeat.m2504i(14478);
        aRe();
        setVisibility(8);
        AppMethodBeat.m2505o(14478);
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(14479);
        super.onConfigurationChanged(configuration);
        if (this.eAk != null) {
            aYX();
            this.eAk.refresh();
        }
        AppMethodBeat.m2505o(14479);
    }

    private void aRe() {
        AppMethodBeat.m2504i(14480);
        this.eAk.onPause();
        if (C40619x.m70075gu(getContext())) {
            getInputPanelHelper().mo64518az(new C457685());
            AppMethodBeat.m2505o(14480);
            return;
        }
        this.eAk.setVisibility(8);
        AppMethodBeat.m2505o(14480);
    }

    /* renamed from: m */
    public final void mo39878m(boolean z, int i) {
        AppMethodBeat.m2504i(14481);
        super.mo39878m(z, i);
        if (!(this.jZm == i || i == 0)) {
            this.jZm = i;
            C18175j.m28620x(getContext(), i);
            aYX();
        }
        AppMethodBeat.m2505o(14481);
    }

    private void aYX() {
        AppMethodBeat.m2504i(14482);
        LayoutParams layoutParams = this.jZi.getLayoutParams();
        layoutParams.height = this.jZm;
        this.jZi.setLayoutParams(layoutParams);
        int gs = C40619x.m70073gs(getContext());
        this.eAk.setPortHeightPx(gs);
        this.eAk.mo11690AG();
        LayoutParams layoutParams2 = this.eAk.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = gs;
        }
        AppMethodBeat.m2505o(14482);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(14483);
        super.onLayout(z, i, i2, i3, i4);
        this.jZk = this.jZk < i4 ? i4 : this.jZk;
        this.jZl = i4;
        AppMethodBeat.m2505o(14483);
    }

    /* renamed from: b */
    static /* synthetic */ void m89267b(MPSmileyFooter mPSmileyFooter) {
        int i = 1;
        AppMethodBeat.m2504i(14485);
        if (mPSmileyFooter.eAk.getVisibility() == 8) {
            mPSmileyFooter.crP.aqX();
            mPSmileyFooter.eAk.onResume();
            mPSmileyFooter.aYX();
            if (C40619x.m70075gu(mPSmileyFooter.getContext())) {
                C4990ab.m7417i("MicroMsg.SnsUploadSayFooter", "is show key board %d, %d, %d", Integer.valueOf(mPSmileyFooter.jZl), Integer.valueOf(mPSmileyFooter.jZk), Integer.valueOf(C5222ae.m7944fr(mPSmileyFooter.getContext())));
                if (mPSmileyFooter.jZl <= 0 || mPSmileyFooter.jZl >= mPSmileyFooter.jZk - r2) {
                    i = 0;
                }
                if (i != 0 || mPSmileyFooter.jZn) {
                    mPSmileyFooter.jZn = false;
                    mPSmileyFooter.getInputPanelHelper().mo64517aA(new C387206());
                    mPSmileyFooter.jZg.requestFocus();
                    mPSmileyFooter.jZh.setImageResource(C25738R.drawable.bcd);
                    AppMethodBeat.m2505o(14485);
                    return;
                }
            }
            mPSmileyFooter.eAk.setVisibility(0);
            mPSmileyFooter.jZg.requestFocus();
            mPSmileyFooter.jZh.setImageResource(C25738R.drawable.bcd);
            AppMethodBeat.m2505o(14485);
            return;
        }
        mPSmileyFooter.jZg.requestFocus();
        mPSmileyFooter.aRe();
        mPSmileyFooter.crP.showVKB();
        mPSmileyFooter.jZh.setImageResource(C25738R.drawable.bcc);
        AppMethodBeat.m2505o(14485);
    }
}
