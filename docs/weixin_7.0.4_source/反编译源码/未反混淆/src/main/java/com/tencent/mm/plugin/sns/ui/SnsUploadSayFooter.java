package com.tencent.mm.plugin.sns.ui;

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

public class SnsUploadSayFooter extends InputPanelLinearLayout {
    private MMActivity crP;
    ChatFooterPanel eAk;
    private MMEditText jZg = null;
    private ImageButton jZh;
    private int jZk = -1;
    private int jZl = -1;
    private int jZm = 0;
    private boolean jZn = true;

    static /* synthetic */ void a(SnsUploadSayFooter snsUploadSayFooter) {
        AppMethodBeat.i(39733);
        snsUploadSayFooter.aRe();
        AppMethodBeat.o(39733);
    }

    public SnsUploadSayFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(39723);
        this.crP = (MMActivity) context;
        this.jZh = (ImageButton) ((ViewGroup) v.hu(this.crP).inflate(R.layout.ax0, this)).findViewById(R.id.d0w);
        this.jZh.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39718);
                SnsUploadSayFooter.b(SnsUploadSayFooter.this);
                AppMethodBeat.o(39718);
            }
        });
        if (e.vom == null) {
            this.eAk = new d(this.crP);
            AppMethodBeat.o(39723);
            return;
        }
        this.eAk = e.vom.dF(getContext());
        this.eAk.setEntranceScene(ChatFooterPanel.vhj);
        this.eAk.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.l_);
        linearLayout.setOnClickListener(null);
        this.jZm = x.gs(getContext());
        linearLayout.addView(this.eAk, -1, this.jZm);
        this.eAk.AD();
        this.eAk.bf(false);
        aYX();
        this.eAk.setOnTextOperationListener(new a() {
            public final void aYY() {
            }

            public final void fC(boolean z) {
            }

            public final void aRg() {
                AppMethodBeat.i(39719);
                SnsUploadSayFooter.this.jZg.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
                SnsUploadSayFooter.this.jZg.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
                AppMethodBeat.o(39719);
            }

            public final void append(String str) {
                AppMethodBeat.i(39720);
                try {
                    SnsUploadSayFooter.this.jZg.asB(str);
                    AppMethodBeat.o(39720);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.SnsUploadSayFooter", e, "", new Object[0]);
                    AppMethodBeat.o(39720);
                }
            }
        });
        AppMethodBeat.o(39723);
    }

    public final void aYS() {
        AppMethodBeat.i(39724);
        setVisibility(0);
        if (this.jZh != null) {
            this.jZh.setImageResource(R.drawable.a1p);
        }
        AppMethodBeat.o(39724);
    }

    public void setMMEditText(MMEditText mMEditText) {
        AppMethodBeat.i(39725);
        this.jZg = mMEditText;
        mMEditText.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39717);
                if (SnsUploadSayFooter.this.getVisibility() == 8) {
                    SnsUploadSayFooter.this.setVisibility(0);
                }
                if (SnsUploadSayFooter.this.aYV()) {
                    SnsUploadSayFooter.a(SnsUploadSayFooter.this);
                }
                AppMethodBeat.o(39717);
            }
        });
        mMEditText.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return false;
            }
        });
        AppMethodBeat.o(39725);
    }

    public final boolean aYV() {
        AppMethodBeat.i(39726);
        if (this.eAk.getVisibility() == 0) {
            AppMethodBeat.o(39726);
            return true;
        }
        AppMethodBeat.o(39726);
        return false;
    }

    public final void aYW() {
        AppMethodBeat.i(39727);
        aRe();
        setVisibility(8);
        AppMethodBeat.o(39727);
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(39728);
        super.onConfigurationChanged(configuration);
        if (this.eAk != null) {
            aYX();
            this.eAk.refresh();
        }
        AppMethodBeat.o(39728);
    }

    private void aRe() {
        AppMethodBeat.i(39729);
        this.eAk.onPause();
        if (x.gu(getContext())) {
            getInputPanelHelper().az(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(39721);
                    SnsUploadSayFooter.this.eAk.setVisibility(8);
                    AppMethodBeat.o(39721);
                }
            });
            AppMethodBeat.o(39729);
            return;
        }
        this.eAk.setVisibility(8);
        AppMethodBeat.o(39729);
    }

    public final void m(boolean z, int i) {
        AppMethodBeat.i(39730);
        super.m(z, i);
        if (!(this.jZm == i || i == 0)) {
            this.jZm = i;
            j.x(getContext(), i);
            aYX();
        }
        AppMethodBeat.o(39730);
    }

    private void aYX() {
        AppMethodBeat.i(39731);
        int gs = x.gs(getContext());
        this.eAk.setPortHeightPx(gs);
        this.eAk.AG();
        LayoutParams layoutParams = this.eAk.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = gs;
        }
        AppMethodBeat.o(39731);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(39732);
        super.onLayout(z, i, i2, i3, i4);
        this.jZk = this.jZk < i4 ? i4 : this.jZk;
        this.jZl = i4;
        AppMethodBeat.o(39732);
    }

    static /* synthetic */ void b(SnsUploadSayFooter snsUploadSayFooter) {
        int i = 1;
        AppMethodBeat.i(39734);
        if (snsUploadSayFooter.eAk.getVisibility() == 8) {
            snsUploadSayFooter.crP.aqX();
            snsUploadSayFooter.eAk.onResume();
            snsUploadSayFooter.aYX();
            if (x.gu(snsUploadSayFooter.getContext())) {
                ab.i("MicroMsg.SnsUploadSayFooter", "is show key board %d, %d, %d", Integer.valueOf(snsUploadSayFooter.jZl), Integer.valueOf(snsUploadSayFooter.jZk), Integer.valueOf(ae.fr(snsUploadSayFooter.getContext())));
                if (snsUploadSayFooter.jZl <= 0 || snsUploadSayFooter.jZl >= snsUploadSayFooter.jZk - r2) {
                    i = 0;
                }
                if (i != 0 || snsUploadSayFooter.jZn) {
                    snsUploadSayFooter.jZn = false;
                    snsUploadSayFooter.getInputPanelHelper().aA(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(39722);
                            SnsUploadSayFooter.this.eAk.setVisibility(0);
                            AppMethodBeat.o(39722);
                        }
                    });
                    snsUploadSayFooter.jZg.requestFocus();
                    snsUploadSayFooter.jZh.setImageResource(R.drawable.a1e);
                    AppMethodBeat.o(39734);
                    return;
                }
            }
            snsUploadSayFooter.eAk.setVisibility(0);
            snsUploadSayFooter.jZg.requestFocus();
            snsUploadSayFooter.jZh.setImageResource(R.drawable.a1e);
            AppMethodBeat.o(39734);
            return;
        }
        snsUploadSayFooter.jZg.requestFocus();
        snsUploadSayFooter.aRe();
        snsUploadSayFooter.crP.showVKB();
        snsUploadSayFooter.jZh.setImageResource(R.drawable.a1p);
        AppMethodBeat.o(39734);
    }
}
