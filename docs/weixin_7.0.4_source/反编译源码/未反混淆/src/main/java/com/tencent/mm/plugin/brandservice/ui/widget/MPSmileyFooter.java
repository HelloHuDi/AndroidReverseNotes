package com.tencent.mm.plugin.brandservice.ui.widget;

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
import com.tencent.mm.R;
import com.tencent.mm.api.u;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.MMEditText;

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

    static /* synthetic */ void a(MPSmileyFooter mPSmileyFooter) {
        AppMethodBeat.i(14484);
        mPSmileyFooter.aRe();
        AppMethodBeat.o(14484);
    }

    public MPSmileyFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(14472);
        this.crP = (MMActivity) context;
        this.jZh = (ImageButton) ((ViewGroup) v.hu(this.crP).inflate(R.layout.ahg, this)).findViewById(R.id.d0w);
        this.jZh.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(14467);
                MPSmileyFooter.b(MPSmileyFooter.this);
                AppMethodBeat.o(14467);
            }
        });
        if (e.vom == null) {
            this.eAk = new d(this.crP);
            AppMethodBeat.o(14472);
            return;
        }
        this.eAk = u.i(this.crP, true);
        this.eAk.setEntranceScene(ChatFooterPanel.vhj);
        this.eAk.setBackgroundResource(R.color.n0);
        this.eAk.setVisibility(8);
        this.jZi = (LinearLayout) findViewById(R.id.dcy);
        this.jZj = (LinearLayout) findViewById(R.id.dcx);
        this.jZi.setOnClickListener(null);
        this.jZm = x.gs(getContext());
        this.jZi.addView(this.eAk, -1, this.jZm);
        this.eAk.AD();
        this.eAk.bf(false);
        aYX();
        this.eAk.setOnTextOperationListener(new a() {
            public final void aYY() {
            }

            public final void fC(boolean z) {
            }

            public final void aRg() {
                AppMethodBeat.i(14468);
                MPSmileyFooter.this.jZg.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
                MPSmileyFooter.this.jZg.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
                AppMethodBeat.o(14468);
            }

            public final void append(String str) {
                AppMethodBeat.i(14469);
                try {
                    MPSmileyFooter.this.jZg.asB(str);
                    AppMethodBeat.o(14469);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.SnsUploadSayFooter", e, "", new Object[0]);
                    AppMethodBeat.o(14469);
                }
            }
        });
        AppMethodBeat.o(14472);
    }

    public final void aYS() {
        AppMethodBeat.i(14473);
        setVisibility(0);
        if (this.jZh != null) {
            this.jZh.setImageResource(R.drawable.bcc);
        }
        AppMethodBeat.o(14473);
    }

    public final void aYT() {
        AppMethodBeat.i(14474);
        if (aYV()) {
            AppMethodBeat.o(14474);
            return;
        }
        setVisibility(8);
        AppMethodBeat.o(14474);
    }

    public void setMMEditText(MMEditText mMEditText) {
        AppMethodBeat.i(14475);
        this.jZg = mMEditText;
        mMEditText.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(14466);
                if (MPSmileyFooter.this.getVisibility() == 8) {
                    MPSmileyFooter.this.setVisibility(0);
                }
                if (MPSmileyFooter.this.aYV()) {
                    MPSmileyFooter.a(MPSmileyFooter.this);
                }
                AppMethodBeat.o(14466);
            }
        });
        mMEditText.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return false;
            }
        });
        AppMethodBeat.o(14475);
    }

    public final boolean aYU() {
        AppMethodBeat.i(14476);
        if (aYV() || getVisibility() == 0) {
            AppMethodBeat.o(14476);
            return true;
        }
        AppMethodBeat.o(14476);
        return false;
    }

    public final boolean aYV() {
        AppMethodBeat.i(14477);
        if (this.eAk.getVisibility() == 0) {
            AppMethodBeat.o(14477);
            return true;
        }
        AppMethodBeat.o(14477);
        return false;
    }

    public final void aYW() {
        AppMethodBeat.i(14478);
        aRe();
        setVisibility(8);
        AppMethodBeat.o(14478);
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(14479);
        super.onConfigurationChanged(configuration);
        if (this.eAk != null) {
            aYX();
            this.eAk.refresh();
        }
        AppMethodBeat.o(14479);
    }

    private void aRe() {
        AppMethodBeat.i(14480);
        this.eAk.onPause();
        if (x.gu(getContext())) {
            getInputPanelHelper().az(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(14470);
                    MPSmileyFooter.this.eAk.setVisibility(8);
                    AppMethodBeat.o(14470);
                }
            });
            AppMethodBeat.o(14480);
            return;
        }
        this.eAk.setVisibility(8);
        AppMethodBeat.o(14480);
    }

    public final void m(boolean z, int i) {
        AppMethodBeat.i(14481);
        super.m(z, i);
        if (!(this.jZm == i || i == 0)) {
            this.jZm = i;
            j.x(getContext(), i);
            aYX();
        }
        AppMethodBeat.o(14481);
    }

    private void aYX() {
        AppMethodBeat.i(14482);
        LayoutParams layoutParams = this.jZi.getLayoutParams();
        layoutParams.height = this.jZm;
        this.jZi.setLayoutParams(layoutParams);
        int gs = x.gs(getContext());
        this.eAk.setPortHeightPx(gs);
        this.eAk.AG();
        LayoutParams layoutParams2 = this.eAk.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = gs;
        }
        AppMethodBeat.o(14482);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(14483);
        super.onLayout(z, i, i2, i3, i4);
        this.jZk = this.jZk < i4 ? i4 : this.jZk;
        this.jZl = i4;
        AppMethodBeat.o(14483);
    }

    static /* synthetic */ void b(MPSmileyFooter mPSmileyFooter) {
        int i = 1;
        AppMethodBeat.i(14485);
        if (mPSmileyFooter.eAk.getVisibility() == 8) {
            mPSmileyFooter.crP.aqX();
            mPSmileyFooter.eAk.onResume();
            mPSmileyFooter.aYX();
            if (x.gu(mPSmileyFooter.getContext())) {
                ab.i("MicroMsg.SnsUploadSayFooter", "is show key board %d, %d, %d", Integer.valueOf(mPSmileyFooter.jZl), Integer.valueOf(mPSmileyFooter.jZk), Integer.valueOf(ae.fr(mPSmileyFooter.getContext())));
                if (mPSmileyFooter.jZl <= 0 || mPSmileyFooter.jZl >= mPSmileyFooter.jZk - r2) {
                    i = 0;
                }
                if (i != 0 || mPSmileyFooter.jZn) {
                    mPSmileyFooter.jZn = false;
                    mPSmileyFooter.getInputPanelHelper().aA(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(14471);
                            MPSmileyFooter.this.eAk.setVisibility(0);
                            AppMethodBeat.o(14471);
                        }
                    });
                    mPSmileyFooter.jZg.requestFocus();
                    mPSmileyFooter.jZh.setImageResource(R.drawable.bcd);
                    AppMethodBeat.o(14485);
                    return;
                }
            }
            mPSmileyFooter.eAk.setVisibility(0);
            mPSmileyFooter.jZg.requestFocus();
            mPSmileyFooter.jZh.setImageResource(R.drawable.bcd);
            AppMethodBeat.o(14485);
            return;
        }
        mPSmileyFooter.jZg.requestFocus();
        mPSmileyFooter.aRe();
        mPSmileyFooter.crP.showVKB();
        mPSmileyFooter.jZh.setImageResource(R.drawable.bcc);
        AppMethodBeat.o(14485);
    }
}
