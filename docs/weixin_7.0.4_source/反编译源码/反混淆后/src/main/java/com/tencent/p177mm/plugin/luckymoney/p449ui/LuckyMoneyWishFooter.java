package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.BasePanelKeybordLayout;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.p612ui.widget.MMEditText.C5620a;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel.C44073a;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44080d;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44081e;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter */
public class LuckyMoneyWishFooter extends BasePanelKeybordLayout {
    private MMActivity crP;
    private ChatFooterPanel eAk;
    private ImageButton jZh;
    private MMEditText oij;
    private Button oik;
    boolean oil = false;
    public boolean oim = false;
    private boolean oin = true;
    boolean oio = true;
    private TextWatcher oip = new C124643();
    private C12466a oiq;
    private C12471c oir;
    private int state = 0;

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter$2 */
    class C124622 implements Runnable {
        C124622() {
        }

        public final void run() {
            AppMethodBeat.m2504i(43048);
            LuckyMoneyWishFooter.this.eAk.setVisibility(0);
            AppMethodBeat.m2505o(43048);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter$4 */
    class C124634 implements OnClickListener {
        C124634() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(43050);
            C4990ab.m7416i("MicroMsg.SnsCommentFooter", "state onClick" + LuckyMoneyWishFooter.this.state);
            if (LuckyMoneyWishFooter.this.state == 0) {
                LuckyMoneyWishFooter.this.setModeClick(true);
                LuckyMoneyWishFooter.this.jZh.setImageResource(C1318a.icons_outlined_emoji);
                LuckyMoneyWishFooter.this.state = 1;
                LuckyMoneyWishFooter.this.oin = false;
            } else {
                LuckyMoneyWishFooter.this.setModeClick(false);
                LuckyMoneyWishFooter.this.oin = false;
                LuckyMoneyWishFooter.this.jZh.setImageResource(C1318a.icons_outlined_emoji);
                LuckyMoneyWishFooter.this.state = 0;
            }
            LuckyMoneyWishFooter.m20378f(LuckyMoneyWishFooter.this);
            AppMethodBeat.m2505o(43050);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter$3 */
    class C124643 implements TextWatcher {
        C124643() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(43049);
            if (LuckyMoneyWishFooter.this.oij.getText() == null) {
                AppMethodBeat.m2505o(43049);
                return;
            }
            LuckyMoneyWishFooter.this.oij.requestFocus();
            boolean z = editable.length() > 0 && editable.toString().trim().length() > 0;
            if (z && LuckyMoneyWishFooter.this.oio) {
                LuckyMoneyWishFooter.m20373a(LuckyMoneyWishFooter.this, true);
                LuckyMoneyWishFooter.this.oio = false;
            }
            if (!z) {
                LuckyMoneyWishFooter.m20373a(LuckyMoneyWishFooter.this, false);
                LuckyMoneyWishFooter.this.oio = true;
            }
            AppMethodBeat.m2505o(43049);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter$5 */
    class C124655 implements OnTouchListener {
        C124655() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(43051);
            LuckyMoneyWishFooter.this.oin = false;
            LuckyMoneyWishFooter.this.eAk.setVisibility(8);
            LuckyMoneyWishFooter.this.eAk.onPause();
            LuckyMoneyWishFooter.this.jZh.setImageResource(C25738R.drawable.f6583iv);
            if (LuckyMoneyWishFooter.this.oiq != null) {
                LuckyMoneyWishFooter.this.oiq;
            }
            LuckyMoneyWishFooter.this.state = 0;
            AppMethodBeat.m2505o(43051);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter$a */
    interface C12466a {
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter$6 */
    class C124676 implements C44073a {
        C124676() {
        }

        public final void aYY() {
        }

        /* renamed from: fC */
        public final void mo24351fC(boolean z) {
        }

        public final void aRg() {
            AppMethodBeat.m2504i(43052);
            LuckyMoneyWishFooter.this.oij.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
            LuckyMoneyWishFooter.this.oij.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
            AppMethodBeat.m2505o(43052);
        }

        public final void append(String str) {
            AppMethodBeat.m2504i(43053);
            try {
                LuckyMoneyWishFooter.this.oij.asB(str);
                AppMethodBeat.m2505o(43053);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SnsCommentFooter", e, "", new Object[0]);
                AppMethodBeat.m2505o(43053);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter$b */
    public interface C12468b {
        /* renamed from: Qm */
        void mo24307Qm(String str);
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter$1 */
    class C124691 implements Runnable {
        C124691() {
        }

        public final void run() {
            AppMethodBeat.m2504i(43047);
            LuckyMoneyWishFooter.this.eAk.setVisibility(4);
            AppMethodBeat.m2505o(43047);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter$c */
    interface C12471c {
    }

    /* renamed from: f */
    static /* synthetic */ void m20378f(LuckyMoneyWishFooter luckyMoneyWishFooter) {
        AppMethodBeat.m2504i(43069);
        luckyMoneyWishFooter.bMN();
        AppMethodBeat.m2505o(43069);
    }

    public void setModeClick(boolean z) {
        this.oil = z;
    }

    public LuckyMoneyWishFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(43055);
        this.crP = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) LuckyMoneyWishFooter.inflate(this.crP, 2130970000, this);
        this.oik = (Button) viewGroup.findViewById(2131825672);
        m20380iP(false);
        this.jZh = (ImageButton) viewGroup.findViewById(2131825671);
        this.jZh.setOnClickListener(new C124634());
        this.oij = (MMEditText) viewGroup.findViewById(2131825670);
        this.oij.setOnTouchListener(new C124655());
        if (C44081e.vom == null) {
            this.eAk = new C44080d(this.crP);
            AppMethodBeat.m2505o(43055);
            return;
        }
        this.eAk = C44081e.vom.mo35682dF(getContext());
        this.eAk.setEntranceScene(ChatFooterPanel.vhh);
        this.eAk.setVisibility(8);
        this.eAk.setBackgroundResource(C25738R.drawable.ay1);
        ((LinearLayout) findViewById(2131820987)).addView(this.eAk, -1, 0);
        this.eAk.mo11687AD();
        this.eAk.mo11691bf(false);
        this.eAk.setOnTextOperationListener(new C124676());
        AppMethodBeat.m2505o(43055);
    }

    public void setVisibility(int i) {
        boolean z;
        AppMethodBeat.m2504i(43056);
        this.state = 0;
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.eAk != null) {
            C4990ab.m7416i("MicroMsg.SnsCommentFooter", "showState ".concat(String.valueOf(z)));
            if (z) {
                bMN();
                this.oin = false;
            } else {
                C4990ab.m7410d("MicroMsg.SnsCommentFooter", C5046bo.dpG());
                this.eAk.setVisibility(8);
                this.jZh.setImageResource(C1318a.icons_outlined_emoji);
                this.crP.aqX();
                setModeClick(true);
                requestLayout();
            }
        }
        super.setVisibility(i);
        AppMethodBeat.m2505o(43056);
    }

    private void bMN() {
        AppMethodBeat.m2504i(43057);
        if (this.state == 0) {
            this.oij.requestFocus();
            this.crP.getWindow().setSoftInputMode(16);
            this.crP.showVKB();
            this.eAk.postDelayed(new C124691(), 200);
            AppMethodBeat.m2505o(43057);
            return;
        }
        this.oij.requestFocus();
        this.crP.getWindow().setSoftInputMode(32);
        this.crP.aqX();
        aRd();
        AppMethodBeat.m2505o(43057);
    }

    private void aRd() {
        AppMethodBeat.m2504i(43058);
        this.eAk.onResume();
        this.eAk.postDelayed(new C124622(), 200);
        LayoutParams layoutParams = this.eAk.getLayoutParams();
        if ((layoutParams != null && layoutParams.height <= 0) || (layoutParams != null && C40619x.m70075gu(getContext()) && this.oin)) {
            layoutParams.height = C40619x.m70073gs(getContext());
            this.eAk.setLayoutParams(layoutParams);
            this.oin = false;
        }
        AppMethodBeat.m2505o(43058);
    }

    public void setMaxLength(int i) {
        AppMethodBeat.m2504i(43059);
        this.oij.setFilters(new InputFilter[]{new LengthFilter(i)});
        AppMethodBeat.m2505o(43059);
    }

    /* renamed from: a */
    public final boolean mo24331a(C5620a c5620a) {
        AppMethodBeat.m2504i(43060);
        if (this.oij != null) {
            this.oij.setBackListener(c5620a);
            AppMethodBeat.m2505o(43060);
            return true;
        }
        AppMethodBeat.m2505o(43060);
        return false;
    }

    public void setText(String str) {
        AppMethodBeat.m2504i(43061);
        if (this.oij != null) {
            this.oij.setText("");
            this.oij.asB(str);
        }
        AppMethodBeat.m2505o(43061);
    }

    public void setHint(String str) {
        AppMethodBeat.m2504i(43062);
        this.oij.setHint(str);
        AppMethodBeat.m2505o(43062);
    }

    public void setOnEditTouchListener(C12466a c12466a) {
        this.oiq = c12466a;
    }

    public void setOnSmileyShowListener(C12471c c12471c) {
        this.oir = c12471c;
    }

    public void setOnWishSendImp(final C12468b c12468b) {
        AppMethodBeat.m2504i(43063);
        this.oik.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(43054);
                c12468b.mo24307Qm(LuckyMoneyWishFooter.this.oij.getText().toString());
                LuckyMoneyWishFooter.this.oij.setText("");
                AppMethodBeat.m2505o(43054);
            }
        });
        AppMethodBeat.m2505o(43063);
    }

    /* renamed from: sD */
    public final void mo24333sD(int i) {
        AppMethodBeat.m2504i(43064);
        super.mo24333sD(i);
        switch (i) {
            case -3:
                this.oim = true;
                AppMethodBeat.m2505o(43064);
                return;
            default:
                this.oim = false;
                AppMethodBeat.m2505o(43064);
                return;
        }
    }

    public final void bMO() {
        AppMethodBeat.m2504i(43065);
        if (this.eAk != null) {
            C4990ab.m7416i("MicroMsg.SnsCommentFooter", "commentfooter release");
            this.eAk.mo11686AC();
            this.eAk.destroy();
        }
        AppMethodBeat.m2505o(43065);
    }

    /* renamed from: iP */
    private void m20380iP(boolean z) {
        AppMethodBeat.m2504i(43066);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8362c4);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8367c9);
        loadAnimation.setDuration(150);
        loadAnimation2.setDuration(150);
        if (this.oik == null) {
            AppMethodBeat.m2505o(43066);
        } else if (z) {
            if (this.oik.getVisibility() == 8 || this.oik.getVisibility() == 4) {
                AppMethodBeat.m2505o(43066);
                return;
            }
            this.oik.startAnimation(loadAnimation2);
            this.oik.setVisibility(8);
            AppMethodBeat.m2505o(43066);
        } else if (this.oik.getVisibility() == 0 || this.oik.getVisibility() == 0) {
            AppMethodBeat.m2505o(43066);
        } else {
            this.oik.startAnimation(loadAnimation);
            this.oik.setVisibility(0);
            AppMethodBeat.m2505o(43066);
        }
    }

    public List<View> getPanelView() {
        AppMethodBeat.m2504i(43067);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.eAk);
        AppMethodBeat.m2505o(43067);
        return arrayList;
    }
}
