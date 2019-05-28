package com.tencent.mm.plugin.luckymoney.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

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
    private TextWatcher oip = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(43049);
            if (LuckyMoneyWishFooter.this.oij.getText() == null) {
                AppMethodBeat.o(43049);
                return;
            }
            LuckyMoneyWishFooter.this.oij.requestFocus();
            boolean z = editable.length() > 0 && editable.toString().trim().length() > 0;
            if (z && LuckyMoneyWishFooter.this.oio) {
                LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this, true);
                LuckyMoneyWishFooter.this.oio = false;
            }
            if (!z) {
                LuckyMoneyWishFooter.a(LuckyMoneyWishFooter.this, false);
                LuckyMoneyWishFooter.this.oio = true;
            }
            AppMethodBeat.o(43049);
        }
    };
    private a oiq;
    private c oir;
    private int state = 0;

    interface a {
    }

    public interface b {
        void Qm(String str);
    }

    interface c {
    }

    static /* synthetic */ void f(LuckyMoneyWishFooter luckyMoneyWishFooter) {
        AppMethodBeat.i(43069);
        luckyMoneyWishFooter.bMN();
        AppMethodBeat.o(43069);
    }

    public void setModeClick(boolean z) {
        this.oil = z;
    }

    public LuckyMoneyWishFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(43055);
        this.crP = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) inflate(this.crP, R.layout.aao, this);
        this.oik = (Button) viewGroup.findViewById(R.id.d0m);
        iP(false);
        this.jZh = (ImageButton) viewGroup.findViewById(R.id.d0l);
        this.jZh.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(43050);
                ab.i("MicroMsg.SnsCommentFooter", "state onClick" + LuckyMoneyWishFooter.this.state);
                if (LuckyMoneyWishFooter.this.state == 0) {
                    LuckyMoneyWishFooter.this.setModeClick(true);
                    LuckyMoneyWishFooter.this.jZh.setImageResource(R.raw.icons_outlined_emoji);
                    LuckyMoneyWishFooter.this.state = 1;
                    LuckyMoneyWishFooter.this.oin = false;
                } else {
                    LuckyMoneyWishFooter.this.setModeClick(false);
                    LuckyMoneyWishFooter.this.oin = false;
                    LuckyMoneyWishFooter.this.jZh.setImageResource(R.raw.icons_outlined_emoji);
                    LuckyMoneyWishFooter.this.state = 0;
                }
                LuckyMoneyWishFooter.f(LuckyMoneyWishFooter.this);
                AppMethodBeat.o(43050);
            }
        });
        this.oij = (MMEditText) viewGroup.findViewById(R.id.d0k);
        this.oij.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(43051);
                LuckyMoneyWishFooter.this.oin = false;
                LuckyMoneyWishFooter.this.eAk.setVisibility(8);
                LuckyMoneyWishFooter.this.eAk.onPause();
                LuckyMoneyWishFooter.this.jZh.setImageResource(R.drawable.iv);
                if (LuckyMoneyWishFooter.this.oiq != null) {
                    LuckyMoneyWishFooter.this.oiq;
                }
                LuckyMoneyWishFooter.this.state = 0;
                AppMethodBeat.o(43051);
                return false;
            }
        });
        if (e.vom == null) {
            this.eAk = new d(this.crP);
            AppMethodBeat.o(43055);
            return;
        }
        this.eAk = e.vom.dF(getContext());
        this.eAk.setEntranceScene(ChatFooterPanel.vhh);
        this.eAk.setVisibility(8);
        this.eAk.setBackgroundResource(R.drawable.ay1);
        ((LinearLayout) findViewById(R.id.l_)).addView(this.eAk, -1, 0);
        this.eAk.AD();
        this.eAk.bf(false);
        this.eAk.setOnTextOperationListener(new com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a() {
            public final void aYY() {
            }

            public final void fC(boolean z) {
            }

            public final void aRg() {
                AppMethodBeat.i(43052);
                LuckyMoneyWishFooter.this.oij.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
                LuckyMoneyWishFooter.this.oij.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
                AppMethodBeat.o(43052);
            }

            public final void append(String str) {
                AppMethodBeat.i(43053);
                try {
                    LuckyMoneyWishFooter.this.oij.asB(str);
                    AppMethodBeat.o(43053);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.SnsCommentFooter", e, "", new Object[0]);
                    AppMethodBeat.o(43053);
                }
            }
        });
        AppMethodBeat.o(43055);
    }

    public void setVisibility(int i) {
        boolean z;
        AppMethodBeat.i(43056);
        this.state = 0;
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.eAk != null) {
            ab.i("MicroMsg.SnsCommentFooter", "showState ".concat(String.valueOf(z)));
            if (z) {
                bMN();
                this.oin = false;
            } else {
                ab.d("MicroMsg.SnsCommentFooter", bo.dpG());
                this.eAk.setVisibility(8);
                this.jZh.setImageResource(R.raw.icons_outlined_emoji);
                this.crP.aqX();
                setModeClick(true);
                requestLayout();
            }
        }
        super.setVisibility(i);
        AppMethodBeat.o(43056);
    }

    private void bMN() {
        AppMethodBeat.i(43057);
        if (this.state == 0) {
            this.oij.requestFocus();
            this.crP.getWindow().setSoftInputMode(16);
            this.crP.showVKB();
            this.eAk.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(43047);
                    LuckyMoneyWishFooter.this.eAk.setVisibility(4);
                    AppMethodBeat.o(43047);
                }
            }, 200);
            AppMethodBeat.o(43057);
            return;
        }
        this.oij.requestFocus();
        this.crP.getWindow().setSoftInputMode(32);
        this.crP.aqX();
        aRd();
        AppMethodBeat.o(43057);
    }

    private void aRd() {
        AppMethodBeat.i(43058);
        this.eAk.onResume();
        this.eAk.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(43048);
                LuckyMoneyWishFooter.this.eAk.setVisibility(0);
                AppMethodBeat.o(43048);
            }
        }, 200);
        LayoutParams layoutParams = this.eAk.getLayoutParams();
        if ((layoutParams != null && layoutParams.height <= 0) || (layoutParams != null && x.gu(getContext()) && this.oin)) {
            layoutParams.height = x.gs(getContext());
            this.eAk.setLayoutParams(layoutParams);
            this.oin = false;
        }
        AppMethodBeat.o(43058);
    }

    public void setMaxLength(int i) {
        AppMethodBeat.i(43059);
        this.oij.setFilters(new InputFilter[]{new LengthFilter(i)});
        AppMethodBeat.o(43059);
    }

    public final boolean a(com.tencent.mm.ui.widget.MMEditText.a aVar) {
        AppMethodBeat.i(43060);
        if (this.oij != null) {
            this.oij.setBackListener(aVar);
            AppMethodBeat.o(43060);
            return true;
        }
        AppMethodBeat.o(43060);
        return false;
    }

    public void setText(String str) {
        AppMethodBeat.i(43061);
        if (this.oij != null) {
            this.oij.setText("");
            this.oij.asB(str);
        }
        AppMethodBeat.o(43061);
    }

    public void setHint(String str) {
        AppMethodBeat.i(43062);
        this.oij.setHint(str);
        AppMethodBeat.o(43062);
    }

    public void setOnEditTouchListener(a aVar) {
        this.oiq = aVar;
    }

    public void setOnSmileyShowListener(c cVar) {
        this.oir = cVar;
    }

    public void setOnWishSendImp(final b bVar) {
        AppMethodBeat.i(43063);
        this.oik.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(43054);
                bVar.Qm(LuckyMoneyWishFooter.this.oij.getText().toString());
                LuckyMoneyWishFooter.this.oij.setText("");
                AppMethodBeat.o(43054);
            }
        });
        AppMethodBeat.o(43063);
    }

    public final void sD(int i) {
        AppMethodBeat.i(43064);
        super.sD(i);
        switch (i) {
            case -3:
                this.oim = true;
                AppMethodBeat.o(43064);
                return;
            default:
                this.oim = false;
                AppMethodBeat.o(43064);
                return;
        }
    }

    public final void bMO() {
        AppMethodBeat.i(43065);
        if (this.eAk != null) {
            ab.i("MicroMsg.SnsCommentFooter", "commentfooter release");
            this.eAk.AC();
            this.eAk.destroy();
        }
        AppMethodBeat.o(43065);
    }

    private void iP(boolean z) {
        AppMethodBeat.i(43066);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.c4);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.c9);
        loadAnimation.setDuration(150);
        loadAnimation2.setDuration(150);
        if (this.oik == null) {
            AppMethodBeat.o(43066);
        } else if (z) {
            if (this.oik.getVisibility() == 8 || this.oik.getVisibility() == 4) {
                AppMethodBeat.o(43066);
                return;
            }
            this.oik.startAnimation(loadAnimation2);
            this.oik.setVisibility(8);
            AppMethodBeat.o(43066);
        } else if (this.oik.getVisibility() == 0 || this.oik.getVisibility() == 0) {
            AppMethodBeat.o(43066);
        } else {
            this.oik.startAnimation(loadAnimation);
            this.oik.setVisibility(0);
            AppMethodBeat.o(43066);
        }
    }

    public List<View> getPanelView() {
        AppMethodBeat.i(43067);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.eAk);
        AppMethodBeat.o(43067);
        return arrayList;
    }
}
