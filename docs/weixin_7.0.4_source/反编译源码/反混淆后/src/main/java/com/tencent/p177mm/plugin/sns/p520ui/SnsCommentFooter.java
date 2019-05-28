package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.text.Editable;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C18175j;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c.C5581a;
import com.tencent.p177mm.p612ui.widget.InputPanelLinearLayout;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p520ui.widget.C39851d;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel.C44073a;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44080d;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44081e;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.cat;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentFooter */
public class SnsCommentFooter extends InputPanelLinearLayout {
    MMActivity crP;
    ChatFooterPanel eAk;
    private ImageButton jZh;
    private int jZk = -1;
    private int jZl = -1;
    private int jZm = 0;
    MMEditText oij;
    private Button oik;
    private boolean oil = false;
    public boolean oim = false;
    private boolean oin = true;
    boolean oio = true;
    private TextWatcher oip = new C350214();
    cat qJj = null;
    private C3975c rrA;
    private C39839be rrB;
    private ImageView rrq;
    private ImageView rrr;
    private Button rrs;
    int rrt = 0;
    private String rru;
    private boolean rrv = C40619x.m70075gu(getContext());
    public boolean rrw;
    private String rrx = "";
    private boolean rry = false;
    private C3974a rrz;
    int state = 0;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentFooter$8 */
    class C39738 implements OnTouchListener {
        C39738() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(38886);
            SnsCommentFooter.this.oin = false;
            SnsCommentFooter.m57577m(SnsCommentFooter.this);
            SnsCommentFooter.this.jZh.setImageResource(C25738R.drawable.f6583iv);
            if (SnsCommentFooter.this.rrz != null) {
                SnsCommentFooter.this.rrz.ctc();
            }
            SnsCommentFooter.this.state = 0;
            AppMethodBeat.m2505o(38886);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentFooter$a */
    interface C3974a {
        void ctc();
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentFooter$c */
    interface C3975c {
        void onShow();
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentFooter$6 */
    class C135286 implements OnClickListener {
        C135286() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38884);
            if (C26373g.m41964Nu().getInt("SnsAdAtFriendRedDot", 0) == 1) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.NEW_BANDAGE_SNS_AD_COMMENT_AT_RED_DOT_BOOLEAN_SYNC, Boolean.FALSE);
            }
            SnsCommentFooter.this.rrr.setVisibility(8);
            Intent intent = new Intent();
            intent.putExtra("list_attr", 16391);
            intent.putExtra("block_contact", C1853r.m3846Yz());
            intent.putExtra("max_limit_num", 1);
            intent.putExtra("titile", SnsCommentFooter.this.crP.getString(C25738R.string.eiy));
            C25985d.m41466b(SnsCommentFooter.this.crP, ".ui.contact.SelectContactUI", intent, 2333);
            AppMethodBeat.m2505o(38884);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentFooter$7 */
    class C135297 implements OnClickListener {
        C135297() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(38885);
            SnsCommentFooter.this.setModeClick(true);
            C4990ab.m7416i("MicroMsg.SnsCommentFooter", "state onClick" + SnsCommentFooter.this.state);
            if (SnsCommentFooter.this.state == 0) {
                SnsCommentFooter.this.crP.aqX();
                SnsCommentFooter.this.oij.requestFocus();
                SnsCommentFooter.this.state = 1;
                SnsCommentFooter.m57574j(SnsCommentFooter.this);
                SnsCommentFooter.this.jZh.setImageResource(C25738R.drawable.f6584ix);
                SnsCommentFooter.this.oin = false;
                AppMethodBeat.m2505o(38885);
                return;
            }
            SnsCommentFooter.m57577m(SnsCommentFooter.this);
            SnsCommentFooter.this.oin = false;
            SnsCommentFooter.this.oij.requestFocus();
            SnsCommentFooter.this.crP.showVKB();
            SnsCommentFooter.this.jZh.setImageResource(C25738R.drawable.f6583iv);
            SnsCommentFooter.this.state = 0;
            AppMethodBeat.m2505o(38885);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentFooter$9 */
    class C291199 implements C44073a {
        C291199() {
        }

        public final void aYY() {
        }

        /* renamed from: fC */
        public final void mo24351fC(boolean z) {
        }

        public final void aRg() {
            AppMethodBeat.m2504i(38887);
            if (SnsCommentFooter.this.oij != null) {
                if (SnsCommentFooter.this.oij.getInputConnection() == null) {
                    AppMethodBeat.m2505o(38887);
                    return;
                } else {
                    SnsCommentFooter.this.oij.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
                    SnsCommentFooter.this.oij.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
                }
            }
            AppMethodBeat.m2505o(38887);
        }

        public final void append(String str) {
            AppMethodBeat.m2504i(38888);
            try {
                SnsCommentFooter.this.oij.asB(str);
                AppMethodBeat.m2505o(38888);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SnsCommentFooter", e, "", new Object[0]);
                AppMethodBeat.m2505o(38888);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentFooter$b */
    interface C35017b {
        /* renamed from: Zr */
        void mo8842Zr(String str);
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentFooter$3 */
    class C350193 implements Runnable {
        C350193() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38877);
            SnsCommentFooter.this.eAk.setVisibility(8);
            AppMethodBeat.m2505o(38877);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentFooter$2 */
    class C350202 implements Runnable {
        C350202() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38876);
            SnsCommentFooter.this.eAk.setVisibility(0);
            AppMethodBeat.m2505o(38876);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentFooter$4 */
    class C350214 implements TextWatcher {
        private int rrF = 0;

        C350214() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(38878);
            this.rrF = charSequence == null ? 0 : charSequence.length();
            AppMethodBeat.m2505o(38878);
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(38879);
            if (charSequence == null || charSequence.length() < C24826a.qFE) {
                SnsCommentFooter.this.mo55626DW(16);
                C4990ab.m7410d("MicroMsg.SnsCommentFooter", "clean SNS_COMMENT_FLAG_FOLD");
                AppMethodBeat.m2505o(38879);
                return;
            }
            if (charSequence.length() - this.rrF > C24826a.qFE) {
                SnsCommentFooter.this.setCommentFlag(16);
                C4990ab.m7410d("MicroMsg.SnsCommentFooter", "add SNS_COMMENT_FLAG_FOLD");
            }
            AppMethodBeat.m2505o(38879);
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(38880);
            if (SnsCommentFooter.this.oij.getText() == null) {
                AppMethodBeat.m2505o(38880);
                return;
            }
            if (!(!C39851d.m68264fF(SnsCommentFooter.this.rrt, 8) || C5046bo.isNullOrNil(SnsCommentFooter.this.rru) || SnsCommentFooter.this.oij.getText() == null || SnsCommentFooter.this.oij.getText().toString().startsWith(SnsCommentFooter.this.rru))) {
                C4990ab.m7417i("MicroMsg.SnsCommentFooter", "cur text %s", SnsCommentFooter.this.oij.getText());
                SnsCommentFooter.this.rru = "";
                SnsCommentFooter.this.qJj = null;
                SnsCommentFooter.this.mo55626DW(8);
                SnsCommentFooter.this.state = 0;
            }
            SnsCommentFooter.this.oij.requestFocus();
            int i = SnsCommentFooter.this.oij.getText().toString().trim().length() > 0 ? 1 : 0;
            if (i != 0 && SnsCommentFooter.this.oio) {
                SnsCommentFooter.m57564a(SnsCommentFooter.this, true);
                SnsCommentFooter.this.oio = false;
            }
            if (i == 0) {
                SnsCommentFooter.m57564a(SnsCommentFooter.this, false);
                SnsCommentFooter.this.oio = true;
            }
            AppMethodBeat.m2505o(38880);
        }
    }

    /* renamed from: j */
    static /* synthetic */ void m57574j(SnsCommentFooter snsCommentFooter) {
        AppMethodBeat.m2504i(38911);
        snsCommentFooter.aRd();
        AppMethodBeat.m2505o(38911);
    }

    public void setModeClick(boolean z) {
        this.oil = z;
    }

    public final boolean ctd() {
        AppMethodBeat.m2504i(38889);
        if (this.oij.getText() == null || C5046bo.isNullOrNil(this.oij.getText().toString())) {
            AppMethodBeat.m2505o(38889);
            return true;
        }
        AppMethodBeat.m2505o(38889);
        return false;
    }

    public SnsCommentFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(38890);
        this.crP = (MMActivity) context;
        AppMethodBeat.m2505o(38890);
    }

    public void setVisibility(int i) {
        boolean z = false;
        AppMethodBeat.m2504i(38892);
        this.state = 0;
        if (i == 0) {
            z = true;
        }
        mo55636lj(z);
        super.setVisibility(i);
        AppMethodBeat.m2505o(38892);
    }

    /* renamed from: lj */
    public final void mo55636lj(boolean z) {
        AppMethodBeat.m2504i(38893);
        if (this.eAk == null) {
            AppMethodBeat.m2505o(38893);
            return;
        }
        this.rrw = z;
        C4990ab.m7416i("MicroMsg.SnsCommentFooter", "showState ".concat(String.valueOf(z)));
        if (z) {
            if (this.state == 0) {
                this.crP.showVKB();
                this.oij.requestFocus();
                this.eAk.setVisibility(8);
            } else {
                this.crP.aqX();
                this.oij.requestFocus();
                aRd();
            }
            this.oin = false;
            AppMethodBeat.m2505o(38893);
            return;
        }
        this.eAk.setVisibility(8);
        this.jZh.setImageResource(C1318a.icons_outlined_emoji);
        this.crP.aqX();
        requestLayout();
        AppMethodBeat.m2505o(38893);
    }

    private void aRd() {
        AppMethodBeat.m2504i(38894);
        this.eAk.onResume();
        if (C40619x.m70075gu(getContext()) && cth()) {
            getInputPanelHelper().mo64517aA(new C350202());
        } else {
            this.eAk.setVisibility(0);
        }
        if (this.rrA != null) {
            this.rrA.onShow();
        }
        AppMethodBeat.m2505o(38894);
    }

    public final boolean cte() {
        return this.state == 1;
    }

    public final void ctf() {
        AppMethodBeat.m2504i(38895);
        if (this.oij == null) {
            C4990ab.m7412e("MicroMsg.SnsCommentFooter", "send edittext is null");
            AppMethodBeat.m2505o(38895);
            return;
        }
        this.oij.removeTextChangedListener(this.oip);
        this.oij.addTextChangedListener(this.oip);
        AppMethodBeat.m2505o(38895);
    }

    public int getCommentFlag() {
        return this.rrt;
    }

    public void setCommentFlag(int i) {
        this.rrt |= i;
    }

    /* renamed from: DW */
    public final void mo55626DW(int i) {
        this.rrt &= i ^ -1;
    }

    /* renamed from: g */
    public final void mo55632g(final List<C13699k> list, String str) {
        AppMethodBeat.m2504i(38896);
        this.rrx = str;
        if (this.oij != null) {
            String bc;
            String str2 = "";
            if (!C5046bo.isNullOrNil(str)) {
                for (C13699k c13699k : list) {
                    if (str.equals(c13699k.key)) {
                        list.remove(c13699k);
                        bc = C5046bo.m7532bc(c13699k.text, "");
                        break;
                    }
                }
            }
            bc = str2;
            if (C5046bo.isNullOrNil(bc)) {
                this.oij.setText("");
            } else {
                this.rrs.setVisibility(0);
                this.oik.setVisibility(8);
                this.oij.setText("");
                this.oij.asB(bc);
            }
            if (!this.rry) {
                this.oij.addTextChangedListener(new TextWatcher() {
                    int rrF = 0;

                    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        AppMethodBeat.m2504i(38881);
                        if (charSequence == null || charSequence.length() < C24826a.qFE) {
                            SnsCommentFooter.this.mo55626DW(16);
                            C4990ab.m7410d("MicroMsg.SnsCommentFooter", "clean SNS_COMMENT_FLAG_FOLD");
                            AppMethodBeat.m2505o(38881);
                            return;
                        }
                        if (charSequence.length() - this.rrF > C24826a.qFE) {
                            SnsCommentFooter.this.setCommentFlag(16);
                            C4990ab.m7410d("MicroMsg.SnsCommentFooter", "add SNS_COMMENT_FLAG_FOLD");
                        }
                        AppMethodBeat.m2505o(38881);
                    }

                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        AppMethodBeat.m2504i(38882);
                        this.rrF = charSequence == null ? 0 : charSequence.length();
                        AppMethodBeat.m2505o(38882);
                    }

                    public final void afterTextChanged(Editable editable) {
                        AppMethodBeat.m2504i(38883);
                        if (SnsCommentFooter.this.oij.getText() == null) {
                            AppMethodBeat.m2505o(38883);
                            return;
                        }
                        if (!(!C39851d.m68264fF(SnsCommentFooter.this.rrt, 8) || C5046bo.isNullOrNil(SnsCommentFooter.this.rru) || C5046bo.isNullOrNil(SnsCommentFooter.this.oij.getText().toString()) || SnsCommentFooter.this.oij.getText().toString().startsWith(SnsCommentFooter.this.rru))) {
                            C4990ab.m7417i("MicroMsg.SnsCommentFooter", "commentAtPrefix [%s], curTxt [%s]", SnsCommentFooter.this.rru, SnsCommentFooter.this.oij.getText());
                            SnsCommentFooter.this.rru = "";
                            SnsCommentFooter.this.qJj = null;
                            SnsCommentFooter.this.mo55626DW(8);
                            SnsCommentFooter.this.state = 0;
                        }
                        C4990ab.m7410d("MicroMsg.SnsCommentFooter", "update commentkey:" + SnsCommentFooter.this.rrx);
                        if (!C5046bo.isNullOrNil(SnsCommentFooter.this.rrx)) {
                            C13699k c13699k;
                            int i;
                            for (C13699k c13699k2 : list) {
                                if (SnsCommentFooter.this.rrx.equals(c13699k2.key)) {
                                    C4990ab.m7410d("MicroMsg.SnsCommentFooter", "afterTextChanged update");
                                    c13699k2.text = SnsCommentFooter.this.oij.getText().toString();
                                    c13699k2.bJt = SnsCommentFooter.this.rrt;
                                    i = 1;
                                    break;
                                }
                            }
                            i = 0;
                            if (i == 0) {
                                C4990ab.m7410d("MicroMsg.SnsCommentFooter", "afterTextChanged add");
                                c13699k2 = new C13699k();
                                c13699k2.key = SnsCommentFooter.this.rrx;
                                c13699k2.text = SnsCommentFooter.this.oij.getText().toString();
                                c13699k2.bJt = SnsCommentFooter.this.rrt;
                                if (c13699k2.text != null && c13699k2.text.length() > 0) {
                                    list.add(c13699k2);
                                }
                            }
                        }
                        if (list.size() > 5) {
                            C4990ab.m7410d("MicroMsg.SnsCommentFooter", "comments remove");
                            list.remove(0);
                        }
                        SnsCommentFooter.this.oij.requestFocus();
                        boolean z = SnsCommentFooter.this.oij.getText().toString().trim().length() > 0;
                        if (z && SnsCommentFooter.this.oio) {
                            SnsCommentFooter.m57564a(SnsCommentFooter.this, z);
                            SnsCommentFooter.this.oio = false;
                        }
                        if (!z) {
                            SnsCommentFooter.m57564a(SnsCommentFooter.this, z);
                            SnsCommentFooter.this.oio = true;
                        }
                        AppMethodBeat.m2505o(38883);
                    }
                });
            }
            this.rry = true;
        }
        AppMethodBeat.m2505o(38896);
    }

    public void setText(String str) {
        AppMethodBeat.m2504i(38897);
        if (this.oij != null) {
            this.oij.setText("");
            this.oij.asB(str);
        }
        AppMethodBeat.m2505o(38897);
    }

    public void setCommentHint(String str) {
        AppMethodBeat.m2504i(38898);
        if (C5046bo.isNullOrNil(str)) {
            this.oij.setHint("");
            AppMethodBeat.m2505o(38898);
        } else if (C39851d.m68264fF(this.rrt, 1)) {
            this.oij.setHint(C44089j.m79293b(getContext(), this.crP.getString(C25738R.string.eiu) + str + this.crP.getString(C25738R.string.ejk, new Object[]{Float.valueOf(this.oij.getTextSize())}), this.oij.getTextSize()));
            AppMethodBeat.m2505o(38898);
        } else {
            this.oij.setHint(C44089j.m79293b(getContext(), (CharSequence) str, this.oij.getTextSize()));
            AppMethodBeat.m2505o(38898);
        }
    }

    public void setCommentInfo(cat cat) {
        this.qJj = cat;
    }

    public void setCommentAtPrefix(String str) {
        this.rru = str;
    }

    public String getCommentAtPrefix() {
        return this.rru;
    }

    /* renamed from: lk */
    public final void mo55637lk(boolean z) {
        AppMethodBeat.m2504i(38899);
        if (this.rrq != null) {
            if (z) {
                this.rrq.setVisibility(0);
                if (C26373g.m41964Nu().getInt("SnsAdAtFriendRedDot", 0) == 1 && C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.NEW_BANDAGE_SNS_AD_COMMENT_AT_RED_DOT_BOOLEAN_SYNC, true)) {
                    this.rrr.setVisibility(0);
                    AppMethodBeat.m2505o(38899);
                    return;
                }
                this.rrr.setVisibility(8);
                AppMethodBeat.m2505o(38899);
                return;
            }
            this.rrq.setVisibility(8);
            this.rrr.setVisibility(8);
        }
        AppMethodBeat.m2505o(38899);
    }

    public final void ctg() {
        AppMethodBeat.m2504i(38900);
        this.oij.setText("");
        this.oij.setHint("");
        this.qJj = null;
        this.rrt = 0;
        this.state = 0;
        AppMethodBeat.m2505o(38900);
    }

    public cat getCommentInfo() {
        AppMethodBeat.m2504i(38901);
        cat cat;
        if (this.qJj == null) {
            cat = new cat();
            AppMethodBeat.m2505o(38901);
            return cat;
        }
        cat = this.qJj;
        AppMethodBeat.m2505o(38901);
        return cat;
    }

    public void setOnEditTouchListener(C3974a c3974a) {
        this.rrz = c3974a;
    }

    public void setOnSmileyShowListener(C3975c c3975c) {
        this.rrA = c3975c;
    }

    public void setOnCommentSendImp(final C35017b c35017b) {
        AppMethodBeat.m2504i(38902);
        this.rrs.setOnClickListener(new OnClickListener() {

            /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentFooter$1$1 */
            class C291181 implements C5581a {
                C291181() {
                }

                /* renamed from: ki */
                public final void mo11317ki(String str) {
                    AppMethodBeat.m2504i(38873);
                    c35017b.mo8842Zr(SnsCommentFooter.this.oij.getText().toString());
                    SnsCommentFooter.this.oij.setText("");
                    AppMethodBeat.m2505o(38873);
                }

                /* renamed from: JW */
                public final void mo11315JW() {
                }

                /* renamed from: JX */
                public final void mo11316JX() {
                    AppMethodBeat.m2504i(38874);
                    C30379h.m48467g(SnsCommentFooter.this.crP, C25738R.string.eqg, C25738R.string.eqh);
                    AppMethodBeat.m2505o(38874);
                }
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(38875);
                C7357c PM = C7357c.m12555d(SnsCommentFooter.this.oij).mo15877PM(C42164b.m74336MX());
                PM.zIx = true;
                PM.mo15879a(new C291181());
                AppMethodBeat.m2505o(38875);
            }
        });
        AppMethodBeat.m2505o(38902);
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(38903);
        super.onConfigurationChanged(configuration);
        if (this.eAk != null) {
            aYX();
        }
        AppMethodBeat.m2505o(38903);
    }

    /* renamed from: m */
    public final void mo39878m(boolean z, int i) {
        AppMethodBeat.m2504i(38904);
        super.mo39878m(z, i);
        this.oim = z;
        if (z && getVisibility() == 0 && this.rrB != null) {
            C4990ab.m7410d("MicroMsg.SnsCommentFooter", "jacks dynamic adjust animation up");
            this.rrB.cuJ();
        }
        if (!(this.jZm == i || i == 0)) {
            this.jZm = i;
            C18175j.m28620x(getContext(), i);
            aYX();
        }
        AppMethodBeat.m2505o(38904);
    }

    private void aYX() {
        AppMethodBeat.m2504i(38905);
        int gs = C40619x.m70073gs(getContext());
        if (this.eAk != null) {
            this.eAk.setPortHeightPx(gs);
            this.eAk.mo11690AG();
            LayoutParams layoutParams = this.eAk.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = gs;
            }
        }
        AppMethodBeat.m2505o(38905);
    }

    private boolean cth() {
        AppMethodBeat.m2504i(38906);
        C4990ab.m7417i("MicroMsg.SnsCommentFooter", "is show key board %d, %d, %d", Integer.valueOf(this.jZl), Integer.valueOf(this.jZk), Integer.valueOf(C5222ae.m7944fr(getContext())));
        if (this.jZl <= 0 || this.jZl >= this.jZk - r2) {
            AppMethodBeat.m2505o(38906);
            return false;
        }
        AppMethodBeat.m2505o(38906);
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(38907);
        super.onLayout(z, i, i2, i3, i4);
        this.jZk = this.jZk < i4 ? i4 : this.jZk;
        this.jZl = i4;
        AppMethodBeat.m2505o(38907);
    }

    public final void bMO() {
        AppMethodBeat.m2504i(38908);
        this.rrB = null;
        if (this.eAk != null) {
            C4990ab.m7416i("MicroMsg.SnsCommentFooter", "commentfooter release");
            this.eAk.mo11686AC();
            this.eAk.destroy();
        }
        AppMethodBeat.m2505o(38908);
    }

    public void setAnitiomAdjust(C39839be c39839be) {
        this.rrB = c39839be;
    }

    /* renamed from: iP */
    private void m57573iP(boolean z) {
        AppMethodBeat.m2504i(38909);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8362c4);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8367c9);
        loadAnimation.setDuration(150);
        loadAnimation2.setDuration(150);
        if (this.oik == null || this.rrs == null) {
            AppMethodBeat.m2505o(38909);
            return;
        }
        if (z) {
            if (this.oik.getVisibility() == 8 || this.oik.getVisibility() == 4) {
                AppMethodBeat.m2505o(38909);
                return;
            }
            this.rrs.startAnimation(loadAnimation);
            this.rrs.setVisibility(0);
            this.oik.startAnimation(loadAnimation2);
            this.oik.setVisibility(8);
        } else if (this.oik.getVisibility() == 0 || this.oik.getVisibility() == 0) {
            AppMethodBeat.m2505o(38909);
            return;
        } else {
            this.oik.startAnimation(loadAnimation);
            this.oik.setVisibility(0);
            this.rrs.startAnimation(loadAnimation2);
            this.rrs.setVisibility(8);
        }
        this.rrs.getParent().requestLayout();
        AppMethodBeat.m2505o(38909);
    }

    public void setAfterEditAction(Runnable runnable) {
        AppMethodBeat.m2504i(38891);
        ViewGroup viewGroup = (ViewGroup) SnsCommentFooter.inflate(this.crP, 2130970755, this);
        this.rrq = (ImageView) viewGroup.findViewById(2131827735);
        this.rrr = (ImageView) viewGroup.findViewById(2131827736);
        this.oik = (Button) viewGroup.findViewById(2131827738);
        this.rrs = (Button) viewGroup.findViewById(2131827739);
        this.oij = (MMEditText) viewGroup.findViewById(2131827737);
        m57573iP(false);
        this.rrq.setOnClickListener(new C135286());
        this.jZh = (ImageButton) viewGroup.findViewById(2131825682);
        this.jZh.setOnClickListener(new C135297());
        this.oij.setHint(this.crP.getString(C25738R.string.eq9));
        this.oij.setOnTouchListener(new C39738());
        if (C44081e.vom == null) {
            this.eAk = new C44080d(this.crP);
            AppMethodBeat.m2505o(38891);
            return;
        }
        this.eAk = C44081e.vom.mo35682dF(getContext());
        this.eAk.setEntranceScene(ChatFooterPanel.vhj);
        this.eAk.setVisibility(8);
        this.eAk.setBackgroundResource(C25738R.drawable.f6537hh);
        LinearLayout linearLayout = (LinearLayout) findViewById(2131820987);
        this.jZm = C40619x.m70073gs(getContext());
        linearLayout.addView(this.eAk, -1, this.jZm);
        this.eAk.mo11687AD();
        this.eAk.mo11691bf(false);
        this.eAk.setOnTextOperationListener(new C291199());
        AppMethodBeat.m2505o(38891);
    }

    /* renamed from: m */
    static /* synthetic */ void m57577m(SnsCommentFooter snsCommentFooter) {
        AppMethodBeat.m2504i(38912);
        snsCommentFooter.eAk.onPause();
        if (C40619x.m70075gu(snsCommentFooter.getContext())) {
            snsCommentFooter.getInputPanelHelper().mo64518az(new C350193());
            AppMethodBeat.m2505o(38912);
            return;
        }
        snsCommentFooter.eAk.setVisibility(8);
        AppMethodBeat.m2505o(38912);
    }
}
