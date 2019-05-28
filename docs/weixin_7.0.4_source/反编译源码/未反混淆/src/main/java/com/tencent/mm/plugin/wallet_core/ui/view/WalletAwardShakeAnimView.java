package com.tencent.mm.plugin.wallet_core.ui.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.v;

public class WalletAwardShakeAnimView extends RelativeLayout {
    private long mfT;
    private d oOS;
    private View tNB;
    private TextView tNC;
    private boolean tND = false;
    private boolean tNE = false;
    private String tNF;
    private int tNG = 0;
    private String tNH;
    private int tNI = 0;
    private ValueAnimator tNJ;
    private a tNK;
    private Runnable tNL = new Runnable() {
        public final void run() {
            AppMethodBeat.i(47889);
            WalletAwardShakeAnimView.a(WalletAwardShakeAnimView.this);
            AppMethodBeat.o(47889);
        }
    };

    public interface a {
        void ns(boolean z);
    }

    static /* synthetic */ void h(WalletAwardShakeAnimView walletAwardShakeAnimView) {
        AppMethodBeat.i(47903);
        walletAwardShakeAnimView.cSx();
        AppMethodBeat.o(47903);
    }

    public WalletAwardShakeAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(47893);
        init();
        AppMethodBeat.o(47893);
    }

    public WalletAwardShakeAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(47894);
        init();
        AppMethodBeat.o(47894);
    }

    private void init() {
        AppMethodBeat.i(47895);
        v.hu(getContext()).inflate(R.layout.b2t, this);
        findViewById(R.id.btd).setBackground(getResources().getDrawable(R.raw.wallet_new_shakea_anim_view_bg));
        this.tNB = findViewById(R.id.f5n);
        this.tNC = (TextView) findViewById(R.id.f5o);
        AppMethodBeat.o(47895);
    }

    public void setShakeOrClickCallback(a aVar) {
        this.tNK = aVar;
    }

    public void setShakeHintWording(String str) {
        AppMethodBeat.i(47896);
        this.tNF = str;
        this.tNC.setText(str);
        AppMethodBeat.o(47896);
    }

    public void setShakeHintWordingColor(int i) {
        AppMethodBeat.i(47897);
        this.tNG = i;
        this.tNC.setTextColor(i);
        AppMethodBeat.o(47897);
    }

    public void setAfterHintWording(String str) {
        this.tNH = str;
    }

    public void setAfterHintWordingColor(int i) {
        this.tNI = i;
    }

    public final void cSw() {
        AppMethodBeat.i(47898);
        ab.i("MicroMsg.WalletAwardShakeAnimView", "startShake");
        this.oOS = new d(getContext());
        this.oOS.a(new com.tencent.mm.pluginsdk.i.d.a() {
            public final void bUT() {
                AppMethodBeat.i(47890);
                ab.i("MicroMsg.WalletAwardShakeAnimView", "onShake");
                long az = bo.az(WalletAwardShakeAnimView.this.mfT);
                if (WalletAwardShakeAnimView.this.tND) {
                    if (az < 80) {
                        AppMethodBeat.o(47890);
                        return;
                    }
                } else if (az < 1200) {
                    AppMethodBeat.o(47890);
                    return;
                }
                WalletAwardShakeAnimView.this.mfT = bo.yz();
                WalletAwardShakeAnimView.this.tND = true;
                if (!WalletAwardShakeAnimView.this.tNE) {
                    WalletAwardShakeAnimView.this.tNE = true;
                    WalletAwardShakeAnimView.g(WalletAwardShakeAnimView.this);
                }
                AppMethodBeat.o(47890);
            }
        });
        this.mfT = bo.yz();
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47891);
                if (!WalletAwardShakeAnimView.this.tNE) {
                    WalletAwardShakeAnimView.this.tNE = true;
                    ay.au(WalletAwardShakeAnimView.this.getContext(), R.string.eg4);
                    WalletAwardShakeAnimView.h(WalletAwardShakeAnimView.this);
                    if (WalletAwardShakeAnimView.this.tNK != null) {
                        WalletAwardShakeAnimView.this.tNK.ns(false);
                    }
                }
                AppMethodBeat.o(47891);
            }
        });
        al.af(this.tNL);
        al.n(this.tNL, 3000);
        AppMethodBeat.o(47898);
    }

    private void cSx() {
        AppMethodBeat.i(47899);
        if (this.tNJ != null) {
            this.tNJ.cancel();
        }
        this.tNJ = ValueAnimator.ofFloat(new float[]{-30.0f, 30.0f});
        this.tNJ.setInterpolator(new LinearInterpolator());
        this.tNJ.setRepeatMode(2);
        this.tNJ.setRepeatCount(-1);
        this.tNJ.setDuration(300);
        this.tNJ.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(47892);
                WalletAwardShakeAnimView.this.tNB.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
                AppMethodBeat.o(47892);
            }
        });
        this.tNJ.start();
        AppMethodBeat.o(47899);
    }

    public final void destroy() {
        AppMethodBeat.i(47900);
        if (this.oOS != null) {
            this.oOS.bgr();
            this.oOS = null;
        }
        this.tNE = false;
        this.tND = false;
        if (this.tNJ != null) {
            this.tNJ.cancel();
        }
        this.tNB.setRotation(0.0f);
        if (bo.isNullOrNil(this.tNF)) {
            this.tNC.setText(getResources().getText(R.string.fti));
        } else {
            this.tNC.setText(this.tNF);
        }
        if (this.tNG != 0) {
            this.tNC.setTextColor(this.tNG);
        } else {
            this.tNC.setTextColor(Color.parseColor("#E24C4C"));
        }
        al.af(this.tNL);
        AppMethodBeat.o(47900);
    }

    static /* synthetic */ void a(WalletAwardShakeAnimView walletAwardShakeAnimView) {
        AppMethodBeat.i(47901);
        ab.i("MicroMsg.WalletAwardShakeAnimView", "delayNotifyClick, isInvokeCallback: %s", Boolean.valueOf(walletAwardShakeAnimView.tNE));
        if (!walletAwardShakeAnimView.tNE) {
            if (bo.isNullOrNil(walletAwardShakeAnimView.tNH)) {
                walletAwardShakeAnimView.tNC.setText(walletAwardShakeAnimView.getContext().getString(R.string.fth));
            } else {
                walletAwardShakeAnimView.tNC.setText(walletAwardShakeAnimView.tNH);
            }
            if (walletAwardShakeAnimView.tNI != 0) {
                walletAwardShakeAnimView.tNC.setTextColor(walletAwardShakeAnimView.tNI);
            }
        }
        AppMethodBeat.o(47901);
    }

    static /* synthetic */ void g(WalletAwardShakeAnimView walletAwardShakeAnimView) {
        AppMethodBeat.i(47902);
        ab.i("MicroMsg.WalletAwardShakeAnimView", "onStartShakeOrClick");
        ay.au(walletAwardShakeAnimView.getContext(), R.string.eg4);
        walletAwardShakeAnimView.cSx();
        if (walletAwardShakeAnimView.tNK != null) {
            walletAwardShakeAnimView.tNK.ns(true);
        }
        AppMethodBeat.o(47902);
    }
}
