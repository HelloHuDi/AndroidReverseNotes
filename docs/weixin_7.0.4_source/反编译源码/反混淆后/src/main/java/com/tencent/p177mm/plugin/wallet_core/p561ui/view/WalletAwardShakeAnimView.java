package com.tencent.p177mm.plugin.wallet_core.p561ui.view;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.pluginsdk.p1082i.C30050d;
import com.tencent.p177mm.pluginsdk.p1082i.C30050d.C30051a;
import com.tencent.p177mm.sdk.platformtools.C35988ay;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView */
public class WalletAwardShakeAnimView extends RelativeLayout {
    private long mfT;
    private C30050d oOS;
    private View tNB;
    private TextView tNC;
    private boolean tND = false;
    private boolean tNE = false;
    private String tNF;
    private int tNG = 0;
    private String tNH;
    private int tNI = 0;
    private ValueAnimator tNJ;
    private C22640a tNK;
    private Runnable tNL = new C355151();

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView$a */
    public interface C22640a {
        /* renamed from: ns */
        void mo26613ns(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView$1 */
    class C355151 implements Runnable {
        C355151() {
        }

        public final void run() {
            AppMethodBeat.m2504i(47889);
            WalletAwardShakeAnimView.m78550a(WalletAwardShakeAnimView.this);
            AppMethodBeat.m2505o(47889);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView$2 */
    class C401362 extends C30051a {
        C401362() {
        }

        public final void bUT() {
            AppMethodBeat.m2504i(47890);
            C4990ab.m7416i("MicroMsg.WalletAwardShakeAnimView", "onShake");
            long az = C5046bo.m7525az(WalletAwardShakeAnimView.this.mfT);
            if (WalletAwardShakeAnimView.this.tND) {
                if (az < 80) {
                    AppMethodBeat.m2505o(47890);
                    return;
                }
            } else if (az < 1200) {
                AppMethodBeat.m2505o(47890);
                return;
            }
            WalletAwardShakeAnimView.this.mfT = C5046bo.m7588yz();
            WalletAwardShakeAnimView.this.tND = true;
            if (!WalletAwardShakeAnimView.this.tNE) {
                WalletAwardShakeAnimView.this.tNE = true;
                WalletAwardShakeAnimView.m78556g(WalletAwardShakeAnimView.this);
            }
            AppMethodBeat.m2505o(47890);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView$4 */
    class C401374 implements AnimatorUpdateListener {
        C401374() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(47892);
            WalletAwardShakeAnimView.this.tNB.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
            AppMethodBeat.m2505o(47892);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView$3 */
    class C438173 implements OnClickListener {
        C438173() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47891);
            if (!WalletAwardShakeAnimView.this.tNE) {
                WalletAwardShakeAnimView.this.tNE = true;
                C35988ay.m59201au(WalletAwardShakeAnimView.this.getContext(), C25738R.string.eg4);
                WalletAwardShakeAnimView.m78557h(WalletAwardShakeAnimView.this);
                if (WalletAwardShakeAnimView.this.tNK != null) {
                    WalletAwardShakeAnimView.this.tNK.mo26613ns(false);
                }
            }
            AppMethodBeat.m2505o(47891);
        }
    }

    /* renamed from: h */
    static /* synthetic */ void m78557h(WalletAwardShakeAnimView walletAwardShakeAnimView) {
        AppMethodBeat.m2504i(47903);
        walletAwardShakeAnimView.cSx();
        AppMethodBeat.m2505o(47903);
    }

    public WalletAwardShakeAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(47893);
        init();
        AppMethodBeat.m2505o(47893);
    }

    public WalletAwardShakeAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(47894);
        init();
        AppMethodBeat.m2505o(47894);
    }

    private void init() {
        AppMethodBeat.m2504i(47895);
        C5616v.m8409hu(getContext()).inflate(2130971045, this);
        findViewById(2131824036).setBackground(getResources().getDrawable(C1318a.wallet_new_shakea_anim_view_bg));
        this.tNB = findViewById(2131828596);
        this.tNC = (TextView) findViewById(2131828597);
        AppMethodBeat.m2505o(47895);
    }

    public void setShakeOrClickCallback(C22640a c22640a) {
        this.tNK = c22640a;
    }

    public void setShakeHintWording(String str) {
        AppMethodBeat.m2504i(47896);
        this.tNF = str;
        this.tNC.setText(str);
        AppMethodBeat.m2505o(47896);
    }

    public void setShakeHintWordingColor(int i) {
        AppMethodBeat.m2504i(47897);
        this.tNG = i;
        this.tNC.setTextColor(i);
        AppMethodBeat.m2505o(47897);
    }

    public void setAfterHintWording(String str) {
        this.tNH = str;
    }

    public void setAfterHintWordingColor(int i) {
        this.tNI = i;
    }

    public final void cSw() {
        AppMethodBeat.m2504i(47898);
        C4990ab.m7416i("MicroMsg.WalletAwardShakeAnimView", "startShake");
        this.oOS = new C30050d(getContext());
        this.oOS.mo48276a(new C401362());
        this.mfT = C5046bo.m7588yz();
        setOnClickListener(new C438173());
        C5004al.m7439af(this.tNL);
        C5004al.m7442n(this.tNL, 3000);
        AppMethodBeat.m2505o(47898);
    }

    private void cSx() {
        AppMethodBeat.m2504i(47899);
        if (this.tNJ != null) {
            this.tNJ.cancel();
        }
        this.tNJ = ValueAnimator.ofFloat(new float[]{-30.0f, 30.0f});
        this.tNJ.setInterpolator(new LinearInterpolator());
        this.tNJ.setRepeatMode(2);
        this.tNJ.setRepeatCount(-1);
        this.tNJ.setDuration(300);
        this.tNJ.addUpdateListener(new C401374());
        this.tNJ.start();
        AppMethodBeat.m2505o(47899);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(47900);
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
        if (C5046bo.isNullOrNil(this.tNF)) {
            this.tNC.setText(getResources().getText(C25738R.string.fti));
        } else {
            this.tNC.setText(this.tNF);
        }
        if (this.tNG != 0) {
            this.tNC.setTextColor(this.tNG);
        } else {
            this.tNC.setTextColor(Color.parseColor("#E24C4C"));
        }
        C5004al.m7439af(this.tNL);
        AppMethodBeat.m2505o(47900);
    }

    /* renamed from: a */
    static /* synthetic */ void m78550a(WalletAwardShakeAnimView walletAwardShakeAnimView) {
        AppMethodBeat.m2504i(47901);
        C4990ab.m7417i("MicroMsg.WalletAwardShakeAnimView", "delayNotifyClick, isInvokeCallback: %s", Boolean.valueOf(walletAwardShakeAnimView.tNE));
        if (!walletAwardShakeAnimView.tNE) {
            if (C5046bo.isNullOrNil(walletAwardShakeAnimView.tNH)) {
                walletAwardShakeAnimView.tNC.setText(walletAwardShakeAnimView.getContext().getString(C25738R.string.fth));
            } else {
                walletAwardShakeAnimView.tNC.setText(walletAwardShakeAnimView.tNH);
            }
            if (walletAwardShakeAnimView.tNI != 0) {
                walletAwardShakeAnimView.tNC.setTextColor(walletAwardShakeAnimView.tNI);
            }
        }
        AppMethodBeat.m2505o(47901);
    }

    /* renamed from: g */
    static /* synthetic */ void m78556g(WalletAwardShakeAnimView walletAwardShakeAnimView) {
        AppMethodBeat.m2504i(47902);
        C4990ab.m7416i("MicroMsg.WalletAwardShakeAnimView", "onStartShakeOrClick");
        C35988ay.m59201au(walletAwardShakeAnimView.getContext(), C25738R.string.eg4);
        walletAwardShakeAnimView.cSx();
        if (walletAwardShakeAnimView.tNK != null) {
            walletAwardShakeAnimView.tNK.mo26613ns(true);
        }
        AppMethodBeat.m2505o(47902);
    }
}
