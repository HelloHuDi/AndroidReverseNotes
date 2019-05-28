package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.m.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.sns.ui.widget.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.List;

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
    private TextWatcher oip = new TextWatcher() {
        private int rrF = 0;

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.i(38878);
            this.rrF = charSequence == null ? 0 : charSequence.length();
            AppMethodBeat.o(38878);
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.i(38879);
            if (charSequence == null || charSequence.length() < com.tencent.mm.plugin.sns.c.a.qFE) {
                SnsCommentFooter.this.DW(16);
                ab.d("MicroMsg.SnsCommentFooter", "clean SNS_COMMENT_FLAG_FOLD");
                AppMethodBeat.o(38879);
                return;
            }
            if (charSequence.length() - this.rrF > com.tencent.mm.plugin.sns.c.a.qFE) {
                SnsCommentFooter.this.setCommentFlag(16);
                ab.d("MicroMsg.SnsCommentFooter", "add SNS_COMMENT_FLAG_FOLD");
            }
            AppMethodBeat.o(38879);
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(38880);
            if (SnsCommentFooter.this.oij.getText() == null) {
                AppMethodBeat.o(38880);
                return;
            }
            if (!(!d.fF(SnsCommentFooter.this.rrt, 8) || bo.isNullOrNil(SnsCommentFooter.this.rru) || SnsCommentFooter.this.oij.getText() == null || SnsCommentFooter.this.oij.getText().toString().startsWith(SnsCommentFooter.this.rru))) {
                ab.i("MicroMsg.SnsCommentFooter", "cur text %s", SnsCommentFooter.this.oij.getText());
                SnsCommentFooter.this.rru = "";
                SnsCommentFooter.this.qJj = null;
                SnsCommentFooter.this.DW(8);
                SnsCommentFooter.this.state = 0;
            }
            SnsCommentFooter.this.oij.requestFocus();
            int i = SnsCommentFooter.this.oij.getText().toString().trim().length() > 0 ? 1 : 0;
            if (i != 0 && SnsCommentFooter.this.oio) {
                SnsCommentFooter.a(SnsCommentFooter.this, true);
                SnsCommentFooter.this.oio = false;
            }
            if (i == 0) {
                SnsCommentFooter.a(SnsCommentFooter.this, false);
                SnsCommentFooter.this.oio = true;
            }
            AppMethodBeat.o(38880);
        }
    };
    cat qJj = null;
    private c rrA;
    private be rrB;
    private ImageView rrq;
    private ImageView rrr;
    private Button rrs;
    int rrt = 0;
    private String rru;
    private boolean rrv = x.gu(getContext());
    public boolean rrw;
    private String rrx = "";
    private boolean rry = false;
    private a rrz;
    int state = 0;

    interface a {
        void ctc();
    }

    interface c {
        void onShow();
    }

    interface b {
        void Zr(String str);
    }

    static /* synthetic */ void j(SnsCommentFooter snsCommentFooter) {
        AppMethodBeat.i(38911);
        snsCommentFooter.aRd();
        AppMethodBeat.o(38911);
    }

    public void setModeClick(boolean z) {
        this.oil = z;
    }

    public final boolean ctd() {
        AppMethodBeat.i(38889);
        if (this.oij.getText() == null || bo.isNullOrNil(this.oij.getText().toString())) {
            AppMethodBeat.o(38889);
            return true;
        }
        AppMethodBeat.o(38889);
        return false;
    }

    public SnsCommentFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(38890);
        this.crP = (MMActivity) context;
        AppMethodBeat.o(38890);
    }

    public void setVisibility(int i) {
        boolean z = false;
        AppMethodBeat.i(38892);
        this.state = 0;
        if (i == 0) {
            z = true;
        }
        lj(z);
        super.setVisibility(i);
        AppMethodBeat.o(38892);
    }

    public final void lj(boolean z) {
        AppMethodBeat.i(38893);
        if (this.eAk == null) {
            AppMethodBeat.o(38893);
            return;
        }
        this.rrw = z;
        ab.i("MicroMsg.SnsCommentFooter", "showState ".concat(String.valueOf(z)));
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
            AppMethodBeat.o(38893);
            return;
        }
        this.eAk.setVisibility(8);
        this.jZh.setImageResource(R.raw.icons_outlined_emoji);
        this.crP.aqX();
        requestLayout();
        AppMethodBeat.o(38893);
    }

    private void aRd() {
        AppMethodBeat.i(38894);
        this.eAk.onResume();
        if (x.gu(getContext()) && cth()) {
            getInputPanelHelper().aA(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(38876);
                    SnsCommentFooter.this.eAk.setVisibility(0);
                    AppMethodBeat.o(38876);
                }
            });
        } else {
            this.eAk.setVisibility(0);
        }
        if (this.rrA != null) {
            this.rrA.onShow();
        }
        AppMethodBeat.o(38894);
    }

    public final boolean cte() {
        return this.state == 1;
    }

    public final void ctf() {
        AppMethodBeat.i(38895);
        if (this.oij == null) {
            ab.e("MicroMsg.SnsCommentFooter", "send edittext is null");
            AppMethodBeat.o(38895);
            return;
        }
        this.oij.removeTextChangedListener(this.oip);
        this.oij.addTextChangedListener(this.oip);
        AppMethodBeat.o(38895);
    }

    public int getCommentFlag() {
        return this.rrt;
    }

    public void setCommentFlag(int i) {
        this.rrt |= i;
    }

    public final void DW(int i) {
        this.rrt &= i ^ -1;
    }

    public final void g(final List<k> list, String str) {
        AppMethodBeat.i(38896);
        this.rrx = str;
        if (this.oij != null) {
            String bc;
            String str2 = "";
            if (!bo.isNullOrNil(str)) {
                for (k kVar : list) {
                    if (str.equals(kVar.key)) {
                        list.remove(kVar);
                        bc = bo.bc(kVar.text, "");
                        break;
                    }
                }
            }
            bc = str2;
            if (bo.isNullOrNil(bc)) {
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
                        AppMethodBeat.i(38881);
                        if (charSequence == null || charSequence.length() < com.tencent.mm.plugin.sns.c.a.qFE) {
                            SnsCommentFooter.this.DW(16);
                            ab.d("MicroMsg.SnsCommentFooter", "clean SNS_COMMENT_FLAG_FOLD");
                            AppMethodBeat.o(38881);
                            return;
                        }
                        if (charSequence.length() - this.rrF > com.tencent.mm.plugin.sns.c.a.qFE) {
                            SnsCommentFooter.this.setCommentFlag(16);
                            ab.d("MicroMsg.SnsCommentFooter", "add SNS_COMMENT_FLAG_FOLD");
                        }
                        AppMethodBeat.o(38881);
                    }

                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        AppMethodBeat.i(38882);
                        this.rrF = charSequence == null ? 0 : charSequence.length();
                        AppMethodBeat.o(38882);
                    }

                    public final void afterTextChanged(Editable editable) {
                        AppMethodBeat.i(38883);
                        if (SnsCommentFooter.this.oij.getText() == null) {
                            AppMethodBeat.o(38883);
                            return;
                        }
                        if (!(!d.fF(SnsCommentFooter.this.rrt, 8) || bo.isNullOrNil(SnsCommentFooter.this.rru) || bo.isNullOrNil(SnsCommentFooter.this.oij.getText().toString()) || SnsCommentFooter.this.oij.getText().toString().startsWith(SnsCommentFooter.this.rru))) {
                            ab.i("MicroMsg.SnsCommentFooter", "commentAtPrefix [%s], curTxt [%s]", SnsCommentFooter.this.rru, SnsCommentFooter.this.oij.getText());
                            SnsCommentFooter.this.rru = "";
                            SnsCommentFooter.this.qJj = null;
                            SnsCommentFooter.this.DW(8);
                            SnsCommentFooter.this.state = 0;
                        }
                        ab.d("MicroMsg.SnsCommentFooter", "update commentkey:" + SnsCommentFooter.this.rrx);
                        if (!bo.isNullOrNil(SnsCommentFooter.this.rrx)) {
                            k kVar;
                            int i;
                            for (k kVar2 : list) {
                                if (SnsCommentFooter.this.rrx.equals(kVar2.key)) {
                                    ab.d("MicroMsg.SnsCommentFooter", "afterTextChanged update");
                                    kVar2.text = SnsCommentFooter.this.oij.getText().toString();
                                    kVar2.bJt = SnsCommentFooter.this.rrt;
                                    i = 1;
                                    break;
                                }
                            }
                            i = 0;
                            if (i == 0) {
                                ab.d("MicroMsg.SnsCommentFooter", "afterTextChanged add");
                                kVar2 = new k();
                                kVar2.key = SnsCommentFooter.this.rrx;
                                kVar2.text = SnsCommentFooter.this.oij.getText().toString();
                                kVar2.bJt = SnsCommentFooter.this.rrt;
                                if (kVar2.text != null && kVar2.text.length() > 0) {
                                    list.add(kVar2);
                                }
                            }
                        }
                        if (list.size() > 5) {
                            ab.d("MicroMsg.SnsCommentFooter", "comments remove");
                            list.remove(0);
                        }
                        SnsCommentFooter.this.oij.requestFocus();
                        boolean z = SnsCommentFooter.this.oij.getText().toString().trim().length() > 0;
                        if (z && SnsCommentFooter.this.oio) {
                            SnsCommentFooter.a(SnsCommentFooter.this, z);
                            SnsCommentFooter.this.oio = false;
                        }
                        if (!z) {
                            SnsCommentFooter.a(SnsCommentFooter.this, z);
                            SnsCommentFooter.this.oio = true;
                        }
                        AppMethodBeat.o(38883);
                    }
                });
            }
            this.rry = true;
        }
        AppMethodBeat.o(38896);
    }

    public void setText(String str) {
        AppMethodBeat.i(38897);
        if (this.oij != null) {
            this.oij.setText("");
            this.oij.asB(str);
        }
        AppMethodBeat.o(38897);
    }

    public void setCommentHint(String str) {
        AppMethodBeat.i(38898);
        if (bo.isNullOrNil(str)) {
            this.oij.setHint("");
            AppMethodBeat.o(38898);
        } else if (d.fF(this.rrt, 1)) {
            this.oij.setHint(j.b(getContext(), this.crP.getString(R.string.eiu) + str + this.crP.getString(R.string.ejk, new Object[]{Float.valueOf(this.oij.getTextSize())}), this.oij.getTextSize()));
            AppMethodBeat.o(38898);
        } else {
            this.oij.setHint(j.b(getContext(), (CharSequence) str, this.oij.getTextSize()));
            AppMethodBeat.o(38898);
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

    public final void lk(boolean z) {
        AppMethodBeat.i(38899);
        if (this.rrq != null) {
            if (z) {
                this.rrq.setVisibility(0);
                if (g.Nu().getInt("SnsAdAtFriendRedDot", 0) == 1 && com.tencent.mm.kernel.g.RP().Ry().getBoolean(com.tencent.mm.storage.ac.a.NEW_BANDAGE_SNS_AD_COMMENT_AT_RED_DOT_BOOLEAN_SYNC, true)) {
                    this.rrr.setVisibility(0);
                    AppMethodBeat.o(38899);
                    return;
                }
                this.rrr.setVisibility(8);
                AppMethodBeat.o(38899);
                return;
            }
            this.rrq.setVisibility(8);
            this.rrr.setVisibility(8);
        }
        AppMethodBeat.o(38899);
    }

    public final void ctg() {
        AppMethodBeat.i(38900);
        this.oij.setText("");
        this.oij.setHint("");
        this.qJj = null;
        this.rrt = 0;
        this.state = 0;
        AppMethodBeat.o(38900);
    }

    public cat getCommentInfo() {
        AppMethodBeat.i(38901);
        cat cat;
        if (this.qJj == null) {
            cat = new cat();
            AppMethodBeat.o(38901);
            return cat;
        }
        cat = this.qJj;
        AppMethodBeat.o(38901);
        return cat;
    }

    public void setOnEditTouchListener(a aVar) {
        this.rrz = aVar;
    }

    public void setOnSmileyShowListener(c cVar) {
        this.rrA = cVar;
    }

    public void setOnCommentSendImp(final b bVar) {
        AppMethodBeat.i(38902);
        this.rrs.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38875);
                com.tencent.mm.ui.tools.b.c PM = com.tencent.mm.ui.tools.b.c.d(SnsCommentFooter.this.oij).PM(com.tencent.mm.m.b.MX());
                PM.zIx = true;
                PM.a(new com.tencent.mm.ui.tools.b.c.a() {
                    public final void ki(String str) {
                        AppMethodBeat.i(38873);
                        bVar.Zr(SnsCommentFooter.this.oij.getText().toString());
                        SnsCommentFooter.this.oij.setText("");
                        AppMethodBeat.o(38873);
                    }

                    public final void JW() {
                    }

                    public final void JX() {
                        AppMethodBeat.i(38874);
                        h.g(SnsCommentFooter.this.crP, R.string.eqg, R.string.eqh);
                        AppMethodBeat.o(38874);
                    }
                });
                AppMethodBeat.o(38875);
            }
        });
        AppMethodBeat.o(38902);
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(38903);
        super.onConfigurationChanged(configuration);
        if (this.eAk != null) {
            aYX();
        }
        AppMethodBeat.o(38903);
    }

    public final void m(boolean z, int i) {
        AppMethodBeat.i(38904);
        super.m(z, i);
        this.oim = z;
        if (z && getVisibility() == 0 && this.rrB != null) {
            ab.d("MicroMsg.SnsCommentFooter", "jacks dynamic adjust animation up");
            this.rrB.cuJ();
        }
        if (!(this.jZm == i || i == 0)) {
            this.jZm = i;
            com.tencent.mm.compatible.util.j.x(getContext(), i);
            aYX();
        }
        AppMethodBeat.o(38904);
    }

    private void aYX() {
        AppMethodBeat.i(38905);
        int gs = x.gs(getContext());
        if (this.eAk != null) {
            this.eAk.setPortHeightPx(gs);
            this.eAk.AG();
            LayoutParams layoutParams = this.eAk.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = gs;
            }
        }
        AppMethodBeat.o(38905);
    }

    private boolean cth() {
        AppMethodBeat.i(38906);
        ab.i("MicroMsg.SnsCommentFooter", "is show key board %d, %d, %d", Integer.valueOf(this.jZl), Integer.valueOf(this.jZk), Integer.valueOf(ae.fr(getContext())));
        if (this.jZl <= 0 || this.jZl >= this.jZk - r2) {
            AppMethodBeat.o(38906);
            return false;
        }
        AppMethodBeat.o(38906);
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(38907);
        super.onLayout(z, i, i2, i3, i4);
        this.jZk = this.jZk < i4 ? i4 : this.jZk;
        this.jZl = i4;
        AppMethodBeat.o(38907);
    }

    public final void bMO() {
        AppMethodBeat.i(38908);
        this.rrB = null;
        if (this.eAk != null) {
            ab.i("MicroMsg.SnsCommentFooter", "commentfooter release");
            this.eAk.AC();
            this.eAk.destroy();
        }
        AppMethodBeat.o(38908);
    }

    public void setAnitiomAdjust(be beVar) {
        this.rrB = beVar;
    }

    private void iP(boolean z) {
        AppMethodBeat.i(38909);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.c4);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.c9);
        loadAnimation.setDuration(150);
        loadAnimation2.setDuration(150);
        if (this.oik == null || this.rrs == null) {
            AppMethodBeat.o(38909);
            return;
        }
        if (z) {
            if (this.oik.getVisibility() == 8 || this.oik.getVisibility() == 4) {
                AppMethodBeat.o(38909);
                return;
            }
            this.rrs.startAnimation(loadAnimation);
            this.rrs.setVisibility(0);
            this.oik.startAnimation(loadAnimation2);
            this.oik.setVisibility(8);
        } else if (this.oik.getVisibility() == 0 || this.oik.getVisibility() == 0) {
            AppMethodBeat.o(38909);
            return;
        } else {
            this.oik.startAnimation(loadAnimation);
            this.oik.setVisibility(0);
            this.rrs.startAnimation(loadAnimation2);
            this.rrs.setVisibility(8);
        }
        this.rrs.getParent().requestLayout();
        AppMethodBeat.o(38909);
    }

    public void setAfterEditAction(Runnable runnable) {
        AppMethodBeat.i(38891);
        ViewGroup viewGroup = (ViewGroup) inflate(this.crP, R.layout.av3, this);
        this.rrq = (ImageView) viewGroup.findViewById(R.id.eid);
        this.rrr = (ImageView) viewGroup.findViewById(R.id.eie);
        this.oik = (Button) viewGroup.findViewById(R.id.eig);
        this.rrs = (Button) viewGroup.findViewById(R.id.eih);
        this.oij = (MMEditText) viewGroup.findViewById(R.id.eif);
        iP(false);
        this.rrq.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38884);
                if (g.Nu().getInt("SnsAdAtFriendRedDot", 0) == 1) {
                    com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.NEW_BANDAGE_SNS_AD_COMMENT_AT_RED_DOT_BOOLEAN_SYNC, Boolean.FALSE);
                }
                SnsCommentFooter.this.rrr.setVisibility(8);
                Intent intent = new Intent();
                intent.putExtra("list_attr", 16391);
                intent.putExtra("block_contact", r.Yz());
                intent.putExtra("max_limit_num", 1);
                intent.putExtra("titile", SnsCommentFooter.this.crP.getString(R.string.eiy));
                com.tencent.mm.bp.d.b(SnsCommentFooter.this.crP, ".ui.contact.SelectContactUI", intent, 2333);
                AppMethodBeat.o(38884);
            }
        });
        this.jZh = (ImageButton) viewGroup.findViewById(R.id.d0w);
        this.jZh.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38885);
                SnsCommentFooter.this.setModeClick(true);
                ab.i("MicroMsg.SnsCommentFooter", "state onClick" + SnsCommentFooter.this.state);
                if (SnsCommentFooter.this.state == 0) {
                    SnsCommentFooter.this.crP.aqX();
                    SnsCommentFooter.this.oij.requestFocus();
                    SnsCommentFooter.this.state = 1;
                    SnsCommentFooter.j(SnsCommentFooter.this);
                    SnsCommentFooter.this.jZh.setImageResource(R.drawable.ix);
                    SnsCommentFooter.this.oin = false;
                    AppMethodBeat.o(38885);
                    return;
                }
                SnsCommentFooter.m(SnsCommentFooter.this);
                SnsCommentFooter.this.oin = false;
                SnsCommentFooter.this.oij.requestFocus();
                SnsCommentFooter.this.crP.showVKB();
                SnsCommentFooter.this.jZh.setImageResource(R.drawable.iv);
                SnsCommentFooter.this.state = 0;
                AppMethodBeat.o(38885);
            }
        });
        this.oij.setHint(this.crP.getString(R.string.eq9));
        this.oij.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(38886);
                SnsCommentFooter.this.oin = false;
                SnsCommentFooter.m(SnsCommentFooter.this);
                SnsCommentFooter.this.jZh.setImageResource(R.drawable.iv);
                if (SnsCommentFooter.this.rrz != null) {
                    SnsCommentFooter.this.rrz.ctc();
                }
                SnsCommentFooter.this.state = 0;
                AppMethodBeat.o(38886);
                return false;
            }
        });
        if (e.vom == null) {
            this.eAk = new com.tencent.mm.pluginsdk.ui.chat.d(this.crP);
            AppMethodBeat.o(38891);
            return;
        }
        this.eAk = e.vom.dF(getContext());
        this.eAk.setEntranceScene(ChatFooterPanel.vhj);
        this.eAk.setVisibility(8);
        this.eAk.setBackgroundResource(R.drawable.hh);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.l_);
        this.jZm = x.gs(getContext());
        linearLayout.addView(this.eAk, -1, this.jZm);
        this.eAk.AD();
        this.eAk.bf(false);
        this.eAk.setOnTextOperationListener(new com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a() {
            public final void aYY() {
            }

            public final void fC(boolean z) {
            }

            public final void aRg() {
                AppMethodBeat.i(38887);
                if (SnsCommentFooter.this.oij != null) {
                    if (SnsCommentFooter.this.oij.getInputConnection() == null) {
                        AppMethodBeat.o(38887);
                        return;
                    } else {
                        SnsCommentFooter.this.oij.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
                        SnsCommentFooter.this.oij.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
                    }
                }
                AppMethodBeat.o(38887);
            }

            public final void append(String str) {
                AppMethodBeat.i(38888);
                try {
                    SnsCommentFooter.this.oij.asB(str);
                    AppMethodBeat.o(38888);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.SnsCommentFooter", e, "", new Object[0]);
                    AppMethodBeat.o(38888);
                }
            }
        });
        AppMethodBeat.o(38891);
    }

    static /* synthetic */ void m(SnsCommentFooter snsCommentFooter) {
        AppMethodBeat.i(38912);
        snsCommentFooter.eAk.onPause();
        if (x.gu(snsCommentFooter.getContext())) {
            snsCommentFooter.getInputPanelHelper().az(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(38877);
                    SnsCommentFooter.this.eAk.setVisibility(8);
                    AppMethodBeat.o(38877);
                }
            });
            AppMethodBeat.o(38912);
            return;
        }
        snsCommentFooter.eAk.setVisibility(8);
        AppMethodBeat.o(38912);
    }
}
