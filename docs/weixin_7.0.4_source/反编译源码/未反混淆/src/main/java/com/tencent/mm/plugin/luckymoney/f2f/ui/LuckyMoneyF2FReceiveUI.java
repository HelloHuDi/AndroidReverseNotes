package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.luckymoney.f2f.a.c;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bpt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import java.io.IOException;

@a(3)
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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(LuckyMoneyF2FReceiveUI luckyMoneyF2FReceiveUI, Class cls, Intent intent) {
        AppMethodBeat.i(42223);
        luckyMoneyF2FReceiveUI.a(cls, intent);
        AppMethodBeat.o(42223);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42219);
        super.onCreate(bundle);
        this.nVH = findViewById(R.id.cwi);
        this.nUG = (ImageView) findViewById(R.id.cwe);
        this.nUH = (TextView) findViewById(R.id.cwf);
        this.nVI = (TextView) findViewById(R.id.cwk);
        this.nVJ = (ImageView) findViewById(R.id.cwm);
        this.nVJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42211);
                LuckyMoneyF2FReceiveUI.this.nVL.cancel();
                LuckyMoneyF2FReceiveUI.this.finish();
                AppMethodBeat.o(42211);
            }
        });
        this.mController.contentView.setVisibility(8);
        this.lvz = getIntent().getStringExtra("key_share_url");
        k.Hp(6);
        b(new c(this.lvz), true);
        this.ghw = getResources().getDisplayMetrics();
        this.nVK = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(300);
        this.nVL = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(300);
        this.nVL.setStartDelay(1000);
        this.nVK.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(42212);
                LuckyMoneyF2FReceiveUI.this.nVH.setTranslationY((-((Float) valueAnimator.getAnimatedValue()).floatValue()) * ((float) LuckyMoneyF2FReceiveUI.this.ghw.heightPixels));
                AppMethodBeat.o(42212);
            }
        });
        this.nVK.addListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(42213);
                ab.i("LuckyMoneyF2FReceiveUI", "packet top in animator end");
                LuckyMoneyF2FReceiveUI.this.nVL.start();
                AppMethodBeat.o(42213);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        this.nVL.addListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(42214);
                ab.i("LuckyMoneyF2FReceiveUI", "packet exit animator end");
                if (LuckyMoneyF2FReceiveUI.this.nVM != null) {
                    LuckyMoneyF2FReceiveUI.a(LuckyMoneyF2FReceiveUI.this, LuckyMoneyBeforeDetailUI.class, LuckyMoneyF2FReceiveUI.this.nVM);
                }
                LuckyMoneyF2FReceiveUI.this.setResult(-1, null);
                LuckyMoneyF2FReceiveUI.this.finish();
                if (LuckyMoneyF2FReceiveUI.this.nVM != null) {
                    LuckyMoneyF2FReceiveUI.this.overridePendingTransition(R.anim.c4, R.anim.c9);
                }
                AppMethodBeat.o(42214);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        AppMethodBeat.o(42219);
    }

    public final int getLayoutId() {
        return R.layout.aa6;
    }

    public void onResume() {
        AppMethodBeat.i(42220);
        super.onResume();
        nf(1997);
        if (this.nVN) {
            finish();
        }
        AppMethodBeat.o(42220);
    }

    public void onStop() {
        AppMethodBeat.i(42221);
        super.onStop();
        ng(1997);
        AppMethodBeat.o(42221);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(42222);
        ab.i("LuckyMoneyF2FReceiveUI", "errType: %d,errCode: %d,errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (mVar instanceof c) {
            c cVar = (c) mVar;
            int i3 = cVar.cRU;
            int i4 = cVar.nUd;
            this.nUf = cVar.nUf;
            int i5 = cVar.nUh;
            String str2 = cVar.nUi;
            String str3 = cVar.nUj;
            ab.i("LuckyMoneyF2FReceiveUI", "hbStatus: %d, recvStatus:%d, errorType:%d", Integer.valueOf(cVar.cRU), Integer.valueOf(cVar.nUd), Integer.valueOf(cVar.cvG));
            bpt bpt;
            RealnameGuideHelper realnameGuideHelper;
            if (i4 == 2) {
                if (i3 == 5) {
                    h.a((Context) this, getString(R.string.cqp), "", new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(42215);
                            LuckyMoneyF2FReceiveUI.this.finish();
                            AppMethodBeat.o(42215);
                        }
                    });
                } else {
                    this.nSX = cVar.nSX;
                    this.nUe = cVar.nUe;
                    this.nUk = cVar.nUk;
                    this.nVM = new Intent();
                    if (!(bo.isNullOrNil(this.nUe) || t.mY(this.nUe))) {
                        com.tencent.mm.ah.h hVar = new com.tencent.mm.ah.h();
                        hVar.username = this.nUe;
                        o.act().b(hVar);
                    }
                    x.b(this.nUG, null, this.nUe);
                    com.tencent.mm.plugin.luckymoney.model.k kVar = new com.tencent.mm.plugin.luckymoney.model.k();
                    kVar.cSh = (long) this.nUf;
                    kVar.nSX = this.nSX;
                    kVar.cRU = i3;
                    kVar.cRV = i4;
                    kVar.nUj = str3;
                    kVar.nUh = i5;
                    kVar.nXl = this.nUe;
                    kVar.nUi = str2;
                    kVar.nWQ = x.mI(this.nUe);
                    kVar.nUk = this.nUk;
                    kVar.cRT = 2;
                    ab.i("LuckyMoneyF2FReceiveUI", "is most lucky %d", Integer.valueOf(cVar.nUl));
                    if (cVar.nUl > 0) {
                        kVar.nWP = getString(R.string.crh);
                    }
                    kVar.nWR = x.Qj(this.nUe);
                    try {
                        this.nVM.putExtra("key_detail_info", kVar.toByteArray());
                        bpt = cVar.nUg;
                        if (bpt != null) {
                            realnameGuideHelper = new RealnameGuideHelper();
                            realnameGuideHelper.a(String.valueOf(bpt.vAF), bpt.nZa, bpt.nZb, bpt.nZc, bpt.nZd, mVar.getType());
                            this.nVM.putExtra("key_realname_guide_helper", realnameGuideHelper);
                        }
                    } catch (IOException e) {
                        ab.e("LuckyMoneyF2FReceiveUI", "lucky detail toBytes error: " + e.getMessage());
                    }
                    if (!bo.Q(this.nSX, this.nUe)) {
                        x.a((Context) this, this.nUH, x.mI(this.nUe));
                        x.a((Context) this, this.nVI, this.nUk);
                        this.nVK.start();
                        this.mController.contentView.setVisibility(0);
                    }
                }
                AppMethodBeat.o(42222);
                return true;
            }
            if (cVar.nUg != null) {
                ab.i("LuckyMoneyF2FReceiveUI", "need real name verify");
                bpt = cVar.nUg;
                realnameGuideHelper = new RealnameGuideHelper();
                realnameGuideHelper.a(String.valueOf(bpt.vAF), bpt.nZa, bpt.nZb, bpt.nZc, bpt.nZd, mVar.getType());
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".f2f.ui.LuckyMoneyF2FReceiveUI");
                bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                if (realnameGuideHelper.a(this, bundle, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(42216);
                        LuckyMoneyF2FReceiveUI.this.finish();
                        AppMethodBeat.o(42216);
                    }
                }, new com.tencent.mm.wallet_core.c.a() {
                    public final Intent n(int i, Bundle bundle) {
                        AppMethodBeat.i(42217);
                        LuckyMoneyF2FReceiveUI.this.finish();
                        AppMethodBeat.o(42217);
                        return null;
                    }
                }, false)) {
                    this.nVN = true;
                    AppMethodBeat.o(42222);
                    return true;
                }
            }
            if (bo.isNullOrNil(str)) {
                str = getString(R.string.cqv);
            }
            h.a((Context) this, str, "", new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(42218);
                    LuckyMoneyF2FReceiveUI.this.finish();
                    AppMethodBeat.o(42218);
                }
            });
            AppMethodBeat.o(42222);
            return true;
        }
        AppMethodBeat.o(42222);
        return true;
    }
}
