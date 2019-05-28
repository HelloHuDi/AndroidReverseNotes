package com.tencent.p177mm.plugin.luckymoney.f2f.p448ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.luckymoney.f2f.p1279a.C34433c;
import com.tencent.p177mm.plugin.luckymoney.model.C12428k;
import com.tencent.p177mm.plugin.luckymoney.model.C46063x;
import com.tencent.p177mm.plugin.luckymoney.p449ui.LuckyMoneyBaseUI;
import com.tencent.p177mm.plugin.luckymoney.p449ui.LuckyMoneyBeforeDetailUI;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.protocal.protobuf.bpt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C40931c.C30857a;
import java.io.IOException;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI */
public class LuckyMoneyF2FReceiveUI extends LuckyMoneyBaseUI {
    private DisplayMetrics ghw;
    private String lvz;
    private String nSX;
    private ImageView nUG;
    private TextView nUH;
    private String nUe;
    private int nUf;
    private String nUk;
    private View nVH;
    private TextView nVI;
    private ImageView nVJ;
    private ValueAnimator nVK;
    private ValueAnimator nVL;
    private Intent nVM;
    private boolean nVN = false;

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI$5 */
    class C33725 implements OnClickListener {
        C33725() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(42215);
            LuckyMoneyF2FReceiveUI.this.finish();
            AppMethodBeat.m2505o(42215);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI$6 */
    class C33736 implements OnClickListener {
        C33736() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(42216);
            LuckyMoneyF2FReceiveUI.this.finish();
            AppMethodBeat.m2505o(42216);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI$7 */
    class C33747 implements C30857a {
        C33747() {
        }

        /* renamed from: n */
        public final Intent mo7785n(int i, Bundle bundle) {
            AppMethodBeat.m2504i(42217);
            LuckyMoneyF2FReceiveUI.this.finish();
            AppMethodBeat.m2505o(42217);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI$4 */
    class C124214 implements AnimatorListener {
        C124214() {
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(42214);
            C4990ab.m7416i("LuckyMoneyF2FReceiveUI", "packet exit animator end");
            if (LuckyMoneyF2FReceiveUI.this.nVM != null) {
                LuckyMoneyF2FReceiveUI.m66988a(LuckyMoneyF2FReceiveUI.this, LuckyMoneyBeforeDetailUI.class, LuckyMoneyF2FReceiveUI.this.nVM);
            }
            LuckyMoneyF2FReceiveUI.this.setResult(-1, null);
            LuckyMoneyF2FReceiveUI.this.finish();
            if (LuckyMoneyF2FReceiveUI.this.nVM != null) {
                LuckyMoneyF2FReceiveUI.this.overridePendingTransition(C25738R.anim.f8362c4, C25738R.anim.f8367c9);
            }
            AppMethodBeat.m2505o(42214);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI$2 */
    class C344342 implements AnimatorUpdateListener {
        C344342() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(42212);
            LuckyMoneyF2FReceiveUI.this.nVH.setTranslationY((-((Float) valueAnimator.getAnimatedValue()).floatValue()) * ((float) LuckyMoneyF2FReceiveUI.this.ghw.heightPixels));
            AppMethodBeat.m2505o(42212);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI$3 */
    class C344353 implements AnimatorListener {
        C344353() {
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(42213);
            C4990ab.m7416i("LuckyMoneyF2FReceiveUI", "packet top in animator end");
            LuckyMoneyF2FReceiveUI.this.nVL.start();
            AppMethodBeat.m2505o(42213);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI$1 */
    class C393121 implements View.OnClickListener {
        C393121() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42211);
            LuckyMoneyF2FReceiveUI.this.nVL.cancel();
            LuckyMoneyF2FReceiveUI.this.finish();
            AppMethodBeat.m2505o(42211);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI$8 */
    class C393138 implements OnClickListener {
        C393138() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(42218);
            LuckyMoneyF2FReceiveUI.this.finish();
            AppMethodBeat.m2505o(42218);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m66988a(LuckyMoneyF2FReceiveUI luckyMoneyF2FReceiveUI, Class cls, Intent intent) {
        AppMethodBeat.m2504i(42223);
        luckyMoneyF2FReceiveUI.mo17381a(cls, intent);
        AppMethodBeat.m2505o(42223);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(42219);
        super.onCreate(bundle);
        this.nVH = findViewById(2131825520);
        this.nUG = (ImageView) findViewById(2131825516);
        this.nUH = (TextView) findViewById(2131825517);
        this.nVI = (TextView) findViewById(2131825522);
        this.nVJ = (ImageView) findViewById(2131825524);
        this.nVJ.setOnClickListener(new C393121());
        this.mController.contentView.setVisibility(8);
        this.lvz = getIntent().getStringExtra("key_share_url");
        C22594k.m34292Hp(6);
        mo24301b(new C34433c(this.lvz), true);
        this.ghw = getResources().getDisplayMetrics();
        this.nVK = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(300);
        this.nVL = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(300);
        this.nVL.setStartDelay(1000);
        this.nVK.addUpdateListener(new C344342());
        this.nVK.addListener(new C344353());
        this.nVL.addListener(new C124214());
        AppMethodBeat.m2505o(42219);
    }

    public final int getLayoutId() {
        return 2130969981;
    }

    public void onResume() {
        AppMethodBeat.m2504i(42220);
        super.onResume();
        mo24305nf(1997);
        if (this.nVN) {
            finish();
        }
        AppMethodBeat.m2505o(42220);
    }

    public void onStop() {
        AppMethodBeat.m2504i(42221);
        super.onStop();
        mo24306ng(1997);
        AppMethodBeat.m2505o(42221);
    }

    /* renamed from: c */
    public final boolean mo7808c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(42222);
        C4990ab.m7417i("LuckyMoneyF2FReceiveUI", "errType: %d,errCode: %d,errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (c1207m instanceof C34433c) {
            C34433c c34433c = (C34433c) c1207m;
            int i3 = c34433c.cRU;
            int i4 = c34433c.nUd;
            this.nUf = c34433c.nUf;
            int i5 = c34433c.nUh;
            String str2 = c34433c.nUi;
            String str3 = c34433c.nUj;
            C4990ab.m7417i("LuckyMoneyF2FReceiveUI", "hbStatus: %d, recvStatus:%d, errorType:%d", Integer.valueOf(c34433c.cRU), Integer.valueOf(c34433c.nUd), Integer.valueOf(c34433c.cvG));
            bpt bpt;
            RealnameGuideHelper realnameGuideHelper;
            if (i4 == 2) {
                if (i3 == 5) {
                    C30379h.m48438a((Context) this, getString(C25738R.string.cqp), "", new C33725());
                } else {
                    this.nSX = c34433c.nSX;
                    this.nUe = c34433c.nUe;
                    this.nUk = c34433c.nUk;
                    this.nVM = new Intent();
                    if (!(C5046bo.isNullOrNil(this.nUe) || C1855t.m3912mY(this.nUe))) {
                        C17880h c17880h = new C17880h();
                        c17880h.username = this.nUe;
                        C17884o.act().mo33391b(c17880h);
                    }
                    C46063x.m85811b(this.nUG, null, this.nUe);
                    C12428k c12428k = new C12428k();
                    c12428k.cSh = (long) this.nUf;
                    c12428k.nSX = this.nSX;
                    c12428k.cRU = i3;
                    c12428k.cRV = i4;
                    c12428k.nUj = str3;
                    c12428k.nUh = i5;
                    c12428k.nXl = this.nUe;
                    c12428k.nUi = str2;
                    c12428k.nWQ = C46063x.m85824mI(this.nUe);
                    c12428k.nUk = this.nUk;
                    c12428k.cRT = 2;
                    C4990ab.m7417i("LuckyMoneyF2FReceiveUI", "is most lucky %d", Integer.valueOf(c34433c.nUl));
                    if (c34433c.nUl > 0) {
                        c12428k.nWP = getString(C25738R.string.crh);
                    }
                    c12428k.nWR = C46063x.m85798Qj(this.nUe);
                    try {
                        this.nVM.putExtra("key_detail_info", c12428k.toByteArray());
                        bpt = c34433c.nUg;
                        if (bpt != null) {
                            realnameGuideHelper = new RealnameGuideHelper();
                            realnameGuideHelper.mo74571a(String.valueOf(bpt.vAF), bpt.nZa, bpt.nZb, bpt.nZc, bpt.nZd, c1207m.getType());
                            this.nVM.putExtra("key_realname_guide_helper", realnameGuideHelper);
                        }
                    } catch (IOException e) {
                        C4990ab.m7412e("LuckyMoneyF2FReceiveUI", "lucky detail toBytes error: " + e.getMessage());
                    }
                    if (!C5046bo.m7510Q(this.nSX, this.nUe)) {
                        C46063x.m85800a((Context) this, this.nUH, C46063x.m85824mI(this.nUe));
                        C46063x.m85800a((Context) this, this.nVI, this.nUk);
                        this.nVK.start();
                        this.mController.contentView.setVisibility(0);
                    }
                }
                AppMethodBeat.m2505o(42222);
                return true;
            }
            if (c34433c.nUg != null) {
                C4990ab.m7416i("LuckyMoneyF2FReceiveUI", "need real name verify");
                bpt = c34433c.nUg;
                realnameGuideHelper = new RealnameGuideHelper();
                realnameGuideHelper.mo74571a(String.valueOf(bpt.vAF), bpt.nZa, bpt.nZb, bpt.nZc, bpt.nZd, c1207m.getType());
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".f2f.ui.LuckyMoneyF2FReceiveUI");
                bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                if (realnameGuideHelper.mo74573a(this, bundle, new C33736(), new C33747(), false)) {
                    this.nVN = true;
                    AppMethodBeat.m2505o(42222);
                    return true;
                }
            }
            if (C5046bo.isNullOrNil(str)) {
                str = getString(C25738R.string.cqv);
            }
            C30379h.m48438a((Context) this, str, "", new C393138());
            AppMethodBeat.m2505o(42222);
            return true;
        }
        AppMethodBeat.m2505o(42222);
        return true;
    }
}
