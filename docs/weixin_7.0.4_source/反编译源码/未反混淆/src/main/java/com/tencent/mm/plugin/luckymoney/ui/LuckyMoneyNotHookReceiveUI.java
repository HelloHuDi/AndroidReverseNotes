package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.widget.q;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.b.a.aa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.an;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.protocal.protobuf.atb;
import com.tencent.mm.protocal.protobuf.hv;
import com.tencent.mm.protocal.protobuf.xx;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.io.IOException;

@a(7)
@i
public class LuckyMoneyNotHookReceiveUI extends LuckyMoneyBaseUI {
    private ViewGroup ius;
    private TextView kGq;
    private d.a kVj = new d.a() {
        public final void a(final boolean z, final EmojiInfo emojiInfo) {
            AppMethodBeat.i(42850);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(42849);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(42848);
                            if (!(emojiInfo == null || LuckyMoneyNotHookReceiveUI.this.kZa == null || !LuckyMoneyNotHookReceiveUI.this.kZa.Aq().equals(emojiInfo.Aq()))) {
                                if (z) {
                                    ab.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "somethings success.");
                                    LuckyMoneyNotHookReceiveUI.this.kZa = j.getEmojiStorageMgr().xYn.aqi(LuckyMoneyNotHookReceiveUI.this.kZa.Aq());
                                    LuckyMoneyNotHookReceiveUI.this.odJ.setVisibility(8);
                                    LuckyMoneyNotHookReceiveUI.this.odH.setVisibility(0);
                                    LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, 3);
                                    LuckyMoneyNotHookReceiveUI.b(LuckyMoneyNotHookReceiveUI.this, LuckyMoneyNotHookReceiveUI.this.kZa);
                                    AppMethodBeat.o(42848);
                                    return;
                                }
                                ab.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "somethings error.");
                                LuckyMoneyNotHookReceiveUI.this.odJ.setVisibility(8);
                                LuckyMoneyNotHookReceiveUI.this.odI.setVisibility(0);
                                LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, 1);
                            }
                            AppMethodBeat.o(42848);
                        }
                    });
                    AppMethodBeat.o(42849);
                }
            });
            AppMethodBeat.o(42850);
        }
    };
    private String kWO;
    private EmojiInfo kZa;
    private String mXq;
    private int maxSize = 0;
    private ImageView nSM;
    private TextView nTD;
    Button nTE;
    private View nTF;
    private ImageView nTG;
    private TextView nTH;
    private ImageView nVJ;
    public int nZk = 0;
    aq nZs;
    private TextView nsq;
    private String ocI;
    private String ocK;
    private RelativeLayout odG;
    private BaseEmojiView odH;
    private TextView odI;
    private LinearLayout odJ;
    private MMAnimateView odK;
    private int odX;
    private aa oec;
    private long oes = 0;
    private int oeu = 3;
    private f oev = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(42856);
            if (bo.gW(mVar.getType(), 697) && (mVar instanceof e)) {
                e eVar = (e) mVar;
                if (i == 0 && i2 == 0) {
                    hv bku = eVar.bku();
                    if (bku != null && bku.vKl != null && bku.vKl.size() > 0 && bo.isEqual(((xx) bku.vKl.get(0)).Md5, LuckyMoneyNotHookReceiveUI.this.kZa.Aq())) {
                        LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, false);
                    }
                }
            }
            AppMethodBeat.o(42856);
        }
    };
    private int oex = 0;
    private LinearLayout ogp;
    private View ogq;
    private ImageView ogr;
    private ImageView ogs;
    private RelativeLayout ogt;
    private com.tencent.mm.plugin.wallet_core.model.ab ogu = null;
    private String ogv;
    private boolean ogw = false;
    private int textSize = 0;
    private p tipDialog = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LuckyMoneyNotHookReceiveUI() {
        AppMethodBeat.i(42860);
        AppMethodBeat.o(42860);
    }

    static /* synthetic */ void b(LuckyMoneyNotHookReceiveUI luckyMoneyNotHookReceiveUI, EmojiInfo emojiInfo) {
        AppMethodBeat.i(42875);
        luckyMoneyNotHookReceiveUI.z(emojiInfo);
        AppMethodBeat.o(42875);
    }

    static /* synthetic */ int j(LuckyMoneyNotHookReceiveUI luckyMoneyNotHookReceiveUI) {
        AppMethodBeat.i(42879);
        int bMH = luckyMoneyNotHookReceiveUI.bMH();
        AppMethodBeat.o(42879);
        return bMH;
    }

    static /* synthetic */ int yi(int i) {
        AppMethodBeat.i(42878);
        int yh = yh(i);
        AppMethodBeat.o(42878);
        return yh;
    }

    public void onDestroy() {
        AppMethodBeat.i(42862);
        super.onDestroy();
        if (this.oex == 1 || this.oex == 2) {
            this.oec = new aa();
            this.oec.cVT = 9;
            this.oec.ajK();
        }
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        j.bkh().kVj = null;
        g.RO().eJo.b(697, this.oev);
        AppMethodBeat.o(42862);
    }

    public void onResume() {
        AppMethodBeat.i(42863);
        super.onResume();
        this.oes = bo.anT();
        AppMethodBeat.o(42863);
    }

    public void onPause() {
        AppMethodBeat.i(42864);
        super.onPause();
        com.tencent.mm.modelstat.d.h("LuckyMoneyReceiveUI", this.oes, bo.anT());
        AppMethodBeat.o(42864);
    }

    public void finish() {
        AppMethodBeat.i(42865);
        super.finish();
        overridePendingTransition(0, R.anim.b4);
        AppMethodBeat.o(42865);
    }

    public boolean enableActivityAnimation() {
        return false;
    }

    public final void initView() {
        int i;
        AppMethodBeat.i(42866);
        xE(-839716110);
        this.ogq = findViewById(R.id.czt);
        this.ius = (ViewGroup) findViewById(R.id.czs);
        this.ogp = (LinearLayout) findViewById(R.id.d00);
        this.nSM = (ImageView) findViewById(R.id.cwe);
        this.nTD = (TextView) findViewById(R.id.cwf);
        this.kGq = (TextView) findViewById(R.id.cwk);
        this.nsq = (TextView) findViewById(R.id.d01);
        this.odG = (RelativeLayout) findViewById(R.id.cv5);
        this.odH = (BaseEmojiView) findViewById(R.id.cv6);
        this.odI = (TextView) findViewById(R.id.cv7);
        this.odJ = (LinearLayout) findViewById(R.id.cv8);
        this.odK = (MMAnimateView) findViewById(R.id.cv9);
        this.nTE = (Button) findViewById(R.id.d02);
        this.nTH = (TextView) findViewById(R.id.d04);
        this.nTF = findViewById(R.id.d03);
        this.nTG = (ImageView) findViewById(R.id.cwl);
        this.ogr = (ImageView) findViewById(R.id.czu);
        this.nVJ = (ImageView) findViewById(R.id.cwm);
        this.nVJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42853);
                LuckyMoneyNotHookReceiveUI.this.finish();
                AppMethodBeat.o(42853);
            }
        });
        this.ogs = (ImageView) findViewById(R.id.czz);
        this.ogt = (RelativeLayout) findViewById(R.id.czw);
        this.odI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42854);
                LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, true);
                AppMethodBeat.o(42854);
            }
        });
        this.kGq.setLines(2);
        q.d(this.kGq);
        this.maxSize = (int) (((float) com.tencent.mm.bz.a.am(this.mController.ylL, R.dimen.a4j)) * 1.375f);
        this.textSize = com.tencent.mm.bz.a.al(this.mController.ylL, R.dimen.a4j);
        if (this.textSize > this.maxSize) {
            i = this.maxSize;
        } else {
            i = this.textSize;
        }
        this.textSize = i;
        this.mController.contentView.setVisibility(8);
        this.tipDialog = h.a(this.mController.ylL, 3, (int) R.style.kd, getString(R.string.cn5), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(42855);
                if (LuckyMoneyNotHookReceiveUI.this.tipDialog != null && LuckyMoneyNotHookReceiveUI.this.tipDialog.isShowing()) {
                    LuckyMoneyNotHookReceiveUI.this.tipDialog.dismiss();
                }
                LuckyMoneyNotHookReceiveUI.this.ocz.bLz();
                if (LuckyMoneyNotHookReceiveUI.this.mController.contentView.getVisibility() == 8 || LuckyMoneyNotHookReceiveUI.this.mController.contentView.getVisibility() == 4) {
                    ab.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "user cancel & finish");
                    LuckyMoneyNotHookReceiveUI.this.finish();
                }
                AppMethodBeat.o(42855);
            }
        });
        bLf();
        AppMethodBeat.o(42866);
    }

    private void bLf() {
        AppMethodBeat.i(42867);
        if (this.nTE == null) {
            AppMethodBeat.o(42867);
            return;
        }
        b.oTO.Ao(this.nTE.getId());
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences(ah.doA(), 0);
        ah.getContext();
        String g = com.tencent.mm.sdk.platformtools.aa.g(sharedPreferences);
        if (g == null || g.length() <= 0 || !(g.equals("zh_CN") || g.equals("zh_TW") || g.equals("zh_HK"))) {
            this.nTE.setBackgroundResource(R.drawable.sx);
            this.nTE.setText(R.string.csa);
            AppMethodBeat.o(42867);
            return;
        }
        AppMethodBeat.o(42867);
    }

    private void iK(boolean z) {
        AppMethodBeat.i(42868);
        ab.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "showEmoji() circle:%s", Boolean.TRUE);
        this.odI.setVisibility(8);
        this.oex = 1;
        if (z) {
            this.oeu = 3;
        } else {
            this.oeu--;
            if (this.oeu == 0) {
                ab.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "showEmoji() circle fail!");
                this.odJ.setVisibility(8);
                this.odI.setVisibility(0);
                yg(1);
                this.oex = 2;
                AppMethodBeat.o(42868);
                return;
            }
        }
        this.kZa = j.getEmojiStorageMgr().xYn.aqi(this.kWO);
        if (this.kZa == null) {
            this.kZa = new EmojiInfo();
            this.kZa.field_md5 = this.kWO;
            this.kZa.field_type = this.odX;
        } else if (com.tencent.mm.vfs.e.asZ(this.kZa.dve()) > 0 || this.kZa.xy() || this.kZa.duS()) {
            this.odH.setVisibility(0);
            z(this.kZa);
            yg(3);
            AppMethodBeat.o(42868);
            return;
        }
        if (z) {
            this.odH.setVisibility(8);
            yg(2);
            this.odJ.setVisibility(0);
            this.odK.setImageResource(R.raw.lucky_money_newyear_creat_loading);
            j.bkh().kVj = this.kVj;
        }
        j.bkh().s(this.kZa);
        g.RO().eJo.a(697, this.oev);
        AppMethodBeat.o(42868);
    }

    private void z(EmojiInfo emojiInfo) {
        AppMethodBeat.i(42869);
        this.oex = 4;
        this.odH.setEmojiInfo(emojiInfo);
        this.ogs.setVisibility(0);
        this.oec = new aa();
        this.oec.cVT = 8;
        this.oec.ajK();
        AppMethodBeat.o(42869);
    }

    private void yg(int i) {
        int b;
        AppMethodBeat.i(42870);
        LayoutParams layoutParams = (LayoutParams) this.ogp.getLayoutParams();
        switch (i) {
            case 1:
                b = BackwardSupportUtil.b.b((Context) this, 113.0f);
                break;
            case 2:
                b = BackwardSupportUtil.b.b((Context) this, 97.0f);
                break;
            case 3:
                com.tencent.mm.emoji.decode.b decoder = MMGIFJNIFactory.Companion.getDecoder(this.kZa);
                int Ov = (int) (((float) decoder.Ov()) * this.odH.getEmojiDensityScale());
                decoder.destroy();
                b = BackwardSupportUtil.b.b((Context) this, 150.0f);
                if (Ov < b && !bo.gW(Ov, 0)) {
                    b = ((b - Ov) / 2) + BackwardSupportUtil.b.b((Context) this, 53.0f);
                    break;
                }
                b = BackwardSupportUtil.b.b((Context) this, 53.0f);
                break;
            default:
                b = BackwardSupportUtil.b.b((Context) this, 53.0f);
                break;
        }
        layoutParams.topMargin = b;
        this.ogp.setLayoutParams(layoutParams);
        this.ogp.invalidate();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ogt.getLayoutParams();
        layoutParams2.topMargin = b - BackwardSupportUtil.b.b((Context) this, 53.0f);
        this.ogt.setLayoutParams(layoutParams2);
        this.ogt.invalidate();
        AppMethodBeat.o(42870);
    }

    public final int getLayoutId() {
        return R.layout.aaj;
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(42871);
        ab.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "onSceneEnd() errType:" + i + " errCode:" + i2 + " errMsg:" + str + " netsceneType:" + mVar.getType());
        boolean a;
        if (!(mVar instanceof aq)) {
            if (mVar instanceof an) {
                x.d(this.nTE);
                this.nTE.setClickable(true);
                bLf();
                if (i == 0 && i2 == 0) {
                    final an anVar = (an) mVar;
                    k.a(this, a.NOTSET);
                    if (anVar.bLD() && anVar.nYe.a((Activity) this, new com.tencent.mm.wallet_core.c.f() {
                        public final void bMI() {
                            AppMethodBeat.i(42851);
                            LuckyMoneyNotHookReceiveUI.a(LuckyMoneyNotHookReceiveUI.this, anVar);
                            AppMethodBeat.o(42851);
                        }
                    })) {
                        AppMethodBeat.o(42871);
                        return true;
                    }
                    a(anVar);
                    if (this.ogw) {
                        com.tencent.mm.plugin.report.service.h.pYm.k(991, 13, 1);
                    }
                    AppMethodBeat.o(42871);
                    return true;
                } else if (i2 == 416) {
                    if (this.tipDialog != null && this.tipDialog.isShowing()) {
                        this.tipDialog.dismiss();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyNotHookReceiveUI");
                    bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                    this.nTE.setBackgroundResource(R.drawable.b5t);
                    AnonymousClass4 anonymousClass4 = new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    };
                    a = x.a(this, i2, mVar, bundle, false, null, 1003);
                    AppMethodBeat.o(42871);
                    return a;
                }
            } else if (mVar instanceof af) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.dismiss();
                }
                if (i == 0 && i2 == 0) {
                    af afVar = (af) mVar;
                    Intent intent = new Intent();
                    intent.setClass(this.mController.ylL, LuckyMoneyBeforeDetailUI.class);
                    intent.putExtra("key_lucky_money_can_received", true);
                    try {
                        intent.putExtra("key_detail_info", afVar.nYn.toByteArray());
                        intent.putExtra("key_jump_from", 2);
                    } catch (IOException e) {
                        ab.w("MicroMsg.LuckyMoneyNotHookReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e.getLocalizedMessage());
                    }
                    intent.putExtra("key_native_url", this.ocK);
                    intent.putExtra("key_sendid", this.ocI);
                    intent.putExtra("key_anim_slide", true);
                    intent.putExtra("key_detail_emoji_md5", afVar.nYA);
                    intent.putExtra("key_detail_emoji_type", afVar.nYB);
                    intent.putExtra("key_username", getIntent().getStringExtra("key_username"));
                    intent.putExtra("key_emoji_switch", afVar.nYC);
                    startActivity(intent);
                    finish();
                    AppMethodBeat.o(42871);
                    return true;
                }
                h.bQ(this, str);
                finish();
                AppMethodBeat.o(42871);
                return true;
            }
            AppMethodBeat.o(42871);
            return false;
        } else if (i == 0 && i2 == 0) {
            this.nZs = (aq) mVar;
            this.nZk = this.nZs.nZk;
            com.tencent.mm.plugin.report.service.h.pYm.e(11701, Integer.valueOf(5), Integer.valueOf(yh(this.nZs.cRT)), Integer.valueOf(bMH()), Integer.valueOf(0), Integer.valueOf(1));
            com.tencent.mm.plugin.wallet_core.model.ab abVar = new com.tencent.mm.plugin.wallet_core.model.ab();
            abVar.field_mNativeUrl = this.ocK;
            abVar.field_hbType = this.nZs.cRT;
            abVar.field_hbStatus = this.nZs.cRU;
            abVar.field_receiveStatus = this.nZs.cRV;
            r.cPF().a(abVar);
            if (this.nZs.cRV == 2) {
                b(new af(this.ocI, 11, 0, this.ocK, "v1.0"), false);
            } else {
                if (!bo.isNullOrNil(this.nZs.nYA)) {
                    this.oec = new aa();
                    this.oec.cVT = 7;
                    this.oec.ajK();
                }
                x.b(this.nSM, this.nZs.nWR, this.nZs.nXl);
                x.a(this.mController.ylL, this.nTD, getString(R.string.cts, new Object[]{this.nZs.nZg}));
                this.ogp.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(42857);
                        LuckyMoneyNotHookReceiveUI.h(LuckyMoneyNotHookReceiveUI.this);
                        AppMethodBeat.o(42857);
                    }
                });
                LayoutParams layoutParams;
                RelativeLayout.LayoutParams layoutParams2;
                if (this.nZs.cRV == 1 || this.nZs.cRU == 4 || this.nZs.cRU == 5 || this.nZs.cRU == 1) {
                    this.nTE.setVisibility(8);
                    if (bo.isNullOrNil(this.nZs.nUk)) {
                        this.kGq.setVisibility(8);
                    } else {
                        this.kGq.setText(this.nZs.nUk);
                        this.kGq.setVisibility(0);
                    }
                    if (bo.isNullOrNil(this.nZs.nWO)) {
                        this.nsq.setVisibility(8);
                    } else {
                        this.nsq.setText(this.nZs.nWO);
                        this.nsq.setVisibility(0);
                        this.nsq.setSingleLine(false);
                    }
                    layoutParams = (LayoutParams) this.ogp.getLayoutParams();
                    layoutParams.topMargin = BackwardSupportUtil.b.b(this.mController.ylL, 106.0f);
                    this.ogp.setLayoutParams(layoutParams);
                    layoutParams2 = (RelativeLayout.LayoutParams) this.nTF.getLayoutParams();
                    layoutParams2.bottomMargin = BackwardSupportUtil.b.b(this.mController.ylL, 30.0f);
                    this.nTF.setLayoutParams(layoutParams2);
                    layoutParams2 = (RelativeLayout.LayoutParams) this.ogt.getLayoutParams();
                    layoutParams2.topMargin = layoutParams.topMargin - BackwardSupportUtil.b.b((Context) this, 53.0f);
                    this.ogt.setLayoutParams(layoutParams2);
                    this.ogt.invalidate();
                    a = true;
                } else {
                    if (!bo.isNullOrNil(this.nZs.nWO)) {
                        this.kGq.setText(this.nZs.nWO);
                        this.kGq.setVisibility(0);
                    }
                    if (!bo.isNullOrNil(this.nZs.nSd)) {
                        x.a(this.mController.ylL, this.nsq, this.nZs.nSd);
                        this.nsq.setVisibility(0);
                        this.kGq.setVisibility(8);
                    }
                    if (bo.isNullOrNil(this.nZs.nYA) || !bo.gW(this.nZk, 1)) {
                        layoutParams = (LayoutParams) this.ogp.getLayoutParams();
                        layoutParams.topMargin = BackwardSupportUtil.b.b(this.mController.ylL, 106.0f);
                        this.ogp.setLayoutParams(layoutParams);
                        layoutParams2 = (RelativeLayout.LayoutParams) this.ogt.getLayoutParams();
                        layoutParams2.topMargin = layoutParams.topMargin - BackwardSupportUtil.b.b((Context) this, 53.0f);
                        this.ogt.setLayoutParams(layoutParams2);
                        this.ogt.invalidate();
                    } else {
                        layoutParams = (LayoutParams) this.ogp.getLayoutParams();
                        layoutParams.topMargin = BackwardSupportUtil.b.b(this.mController.ylL, 53.0f);
                        this.ogp.setLayoutParams(layoutParams);
                        this.kWO = this.nZs.nYA;
                        this.odX = this.nZs.nYB;
                        this.odG.setVisibility(0);
                        iK(true);
                    }
                    this.nTE.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(42858);
                            ((com.tencent.mm.pluginsdk.wallet.b) g.K(com.tencent.mm.pluginsdk.wallet.b.class)).eA(10, 3);
                            com.tencent.mm.plugin.report.service.h.pYm.e(11701, Integer.valueOf(5), Integer.valueOf(LuckyMoneyNotHookReceiveUI.yi(LuckyMoneyNotHookReceiveUI.this.nZs.cRT)), Integer.valueOf(LuckyMoneyNotHookReceiveUI.j(LuckyMoneyNotHookReceiveUI.this)), Integer.valueOf(0), Integer.valueOf(2));
                            ab.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "open btn click!");
                            LuckyMoneyNotHookReceiveUI.this.nTE.setClickable(false);
                            LuckyMoneyNotHookReceiveUI luckyMoneyNotHookReceiveUI = LuckyMoneyNotHookReceiveUI.this;
                            luckyMoneyNotHookReceiveUI.b(new an(luckyMoneyNotHookReceiveUI.nZs.msgType, luckyMoneyNotHookReceiveUI.nZs.cdf, luckyMoneyNotHookReceiveUI.nZs.nSX, luckyMoneyNotHookReceiveUI.nZs.cRS, x.bLC(), com.tencent.mm.model.r.YB(), luckyMoneyNotHookReceiveUI.getIntent().getStringExtra("key_username"), "v1.0", luckyMoneyNotHookReceiveUI.nZs.nZl), false);
                            x.c(luckyMoneyNotHookReceiveUI.nTE);
                            AppMethodBeat.o(42858);
                        }
                    });
                    a = false;
                }
                if (com.tencent.mm.model.r.Yz().equals(this.mXq) || (this.nZs.cRT == 1 && a)) {
                    if (this.nZs.cRT == 1) {
                        this.nTH.setText(R.string.cqh);
                    }
                    this.nTF.setVisibility(0);
                    this.nTF.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(42859);
                            if (a) {
                                com.tencent.mm.plugin.report.service.h.pYm.e(11701, Integer.valueOf(6), Integer.valueOf(LuckyMoneyNotHookReceiveUI.yi(LuckyMoneyNotHookReceiveUI.this.nZs.cRT)), Integer.valueOf(LuckyMoneyNotHookReceiveUI.j(LuckyMoneyNotHookReceiveUI.this)), Integer.valueOf(0), Integer.valueOf(1));
                            }
                            Intent intent = new Intent();
                            intent.setClass(LuckyMoneyNotHookReceiveUI.this.mController.ylL, LuckyMoneyBeforeDetailUI.class);
                            intent.putExtra("key_native_url", LuckyMoneyNotHookReceiveUI.this.nZs.cRS);
                            intent.putExtra("key_sendid", LuckyMoneyNotHookReceiveUI.this.nZs.nSX);
                            intent.putExtra("key_lucky_money_can_received", true);
                            intent.putExtra("key_username", LuckyMoneyNotHookReceiveUI.this.getIntent().getStringExtra("key_username"));
                            LuckyMoneyNotHookReceiveUI.this.startActivity(intent);
                            LuckyMoneyNotHookReceiveUI.this.finish();
                            AppMethodBeat.o(42859);
                        }
                    });
                    this.nTG.setVisibility(8);
                } else {
                    this.nTF.setVisibility(8);
                    this.nTG.setVisibility(0);
                }
                if (!(this.nZs.nZm == null || this.nZs.nZm.nZq == null)) {
                    atb atb = this.nZs.nZm.nZq;
                    ab.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "render envelope");
                    if (atb != null) {
                        ((com.tencent.mm.plugin.luckymoney.a.a) g.K(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.ogr, atb, null);
                        this.ogr.setVisibility(0);
                        this.nTG.setVisibility(8);
                        this.ogw = true;
                    }
                    String str2 = this.nZs.nZm.nZq.wwQ != null ? this.nZs.nZm.nZq.wwQ.wwW : "";
                    String stringExtra = getIntent().getStringExtra("key_username");
                    if (!bo.isNullOrNil(this.nZs.nZm.nZq.wwP)) {
                        this.ogv = this.nZs.nZm.nZq.wwP;
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.e(16598, Integer.valueOf(2), this.ogv, str2, stringExtra);
                }
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.setOnDismissListener(new OnDismissListener() {
                        public final void onDismiss(DialogInterface dialogInterface) {
                        }
                    });
                    this.tipDialog.dismiss();
                }
                this.ius.setBackgroundResource(R.color.tz);
                ae.m(this, getResources().getColor(R.color.tz));
                this.mController.contentView.setVisibility(0);
                this.ogq.setVisibility(0);
                x.dn(this.ogq);
            }
            AppMethodBeat.o(42871);
            return true;
        } else {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            AppMethodBeat.o(42871);
            return false;
        }
    }

    private void a(final an anVar) {
        AppMethodBeat.i(42872);
        k kVar = anVar.nYn;
        if (kVar.cRV == 2) {
            Intent intent = new Intent();
            intent.setClass(this.mController.ylL, LuckyMoneyBeforeDetailUI.class);
            intent.putExtra("key_lucky_money_can_received", true);
            try {
                intent.putExtra("key_detail_info", anVar.nYn.toByteArray());
                intent.putExtra("key_jump_from", 2);
            } catch (IOException e) {
                ab.w("MicroMsg.LuckyMoneyNotHookReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e.getLocalizedMessage());
            }
            intent.putExtra("key_native_url", anVar.cRS);
            intent.putExtra("key_sendid", anVar.nSX);
            if (com.tencent.mm.m.g.Nu().getInt("PlayCoinSound", 0) > 0) {
                intent.putExtra("play_sound", true);
            }
            if (anVar.nTN != null) {
                intent.putExtra("key_realname_guide_helper", anVar.nTN);
            }
            intent.putExtra("key_username", getIntent().getStringExtra("key_username"));
            intent.putExtra("key_emoji_switch", anVar.nYC);
            intent.putExtra("key_detail_emoji_md5", anVar.nYA);
            intent.putExtra("key_detail_emoji_type", anVar.nYB);
            startActivity(intent);
            finish();
            com.tencent.mm.plugin.wallet_core.model.ab abVar = new com.tencent.mm.plugin.wallet_core.model.ab();
            abVar.field_mNativeUrl = this.ocK;
            abVar.field_hbType = kVar.cRT;
            abVar.field_receiveAmount = kVar.cSh;
            abVar.field_receiveTime = System.currentTimeMillis();
            abVar.field_hbStatus = kVar.cRU;
            abVar.field_receiveStatus = kVar.cRV;
            if (abVar.field_receiveAmount > 0) {
                r.cPF().a(abVar);
            }
            AppMethodBeat.o(42872);
            return;
        }
        this.nTE.setBackgroundResource(R.drawable.ban);
        this.nTE.setText(R.string.cs8);
        this.nTE.setOnClickListener(null);
        this.nTE.setVisibility(8);
        if (bo.isNullOrNil(kVar.nUk)) {
            this.kGq.setVisibility(8);
        } else {
            this.kGq.setText(kVar.nUk);
            this.kGq.setVisibility(0);
        }
        this.nsq.setText(kVar.nWO);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nTF.getLayoutParams();
        layoutParams.bottomMargin = BackwardSupportUtil.b.b(this.mController.ylL, 30.0f);
        this.nTF.setLayoutParams(layoutParams);
        if (com.tencent.mm.model.r.Yz().equals(this.mXq) || kVar.cRT == 1) {
            this.nTF.setVisibility(0);
            this.nTF.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(42852);
                    Intent intent = new Intent();
                    if (anVar.nTN != null) {
                        intent.putExtra("key_realname_guide_helper", anVar.nTN);
                    }
                    intent.setClass(LuckyMoneyNotHookReceiveUI.this.mController.ylL, LuckyMoneyBeforeDetailUI.class);
                    intent.putExtra("key_lucky_money_can_received", true);
                    intent.putExtra("key_native_url", anVar.cRS);
                    intent.putExtra("key_sendid", anVar.nSX);
                    intent.putExtra("key_username", LuckyMoneyNotHookReceiveUI.this.getIntent().getStringExtra("key_username"));
                    intent.putExtra("key_emoji_switch", anVar.nYC);
                    intent.putExtra("key_detail_emoji_md5", anVar.nYA);
                    intent.putExtra("key_detail_emoji_type", anVar.nYB);
                    LuckyMoneyNotHookReceiveUI.this.startActivity(intent);
                    LuckyMoneyNotHookReceiveUI.this.finish();
                    AppMethodBeat.o(42852);
                }
            });
            this.nTG.setVisibility(8);
            AppMethodBeat.o(42872);
            return;
        }
        this.nTF.setVisibility(8);
        this.nTG.setVisibility(0);
        AppMethodBeat.o(42872);
    }

    private int bMH() {
        AppMethodBeat.i(42873);
        if (com.tencent.mm.model.r.Yz().equals(this.mXq)) {
            AppMethodBeat.o(42873);
            return 1;
        }
        AppMethodBeat.o(42873);
        return 0;
    }

    private static int yh(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 0) {
            return 2;
        }
        return 0;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42861);
        this.yll = true;
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(android.support.v4.widget.j.INVALID_ID);
            window.setStatusBarColor(getResources().getColor(R.color.a3p));
        }
        this.ocK = getIntent().getStringExtra("key_native_url");
        this.ogv = getIntent().getStringExtra("key_cropname");
        ab.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "nativeUrl= " + bo.nullAsNil(this.ocK));
        initView();
        Uri parse = Uri.parse(bo.nullAsNil(this.ocK));
        try {
            this.ocI = parse.getQueryParameter("sendid");
        } catch (Exception e) {
        }
        this.ogu = r.cPF().acN(this.ocK);
        if (this.ogu != null && this.ogu.field_receiveAmount > 0 && bo.gb(this.ogu.field_receiveTime) < 86400000) {
            ab.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "use cache this item %s %s", Long.valueOf(this.ogu.field_receiveTime), bo.nullAsNil(this.ocK));
            Intent intent = new Intent();
            intent.setClass(this.mController.ylL, LuckyMoneyBeforeDetailUI.class);
            intent.putExtra("key_native_url", this.ogu.field_mNativeUrl);
            intent.putExtra("key_sendid", this.ocI);
            intent.putExtra("key_anim_slide", true);
            intent.putExtra("key_lucky_money_can_received", true);
            intent.putExtra("key_username", getIntent().getStringExtra("key_username"));
            startActivity(intent);
            finish();
            AppMethodBeat.o(42861);
        } else if (bo.isNullOrNil(this.ocI)) {
            finish();
            ab.w("MicroMsg.LuckyMoneyNotHookReceiveUI", "sendid null & finish");
            AppMethodBeat.o(42861);
        } else {
            int i = bo.getInt(parse.getQueryParameter("channelid"), 1);
            this.mXq = parse.getQueryParameter("sendusername");
            b(new aq(i, this.ocI, this.ocK, getIntent().getIntExtra("key_way", 0), "v1.0"), false);
            if (this.tipDialog != null) {
                this.tipDialog.show();
            }
            AppMethodBeat.o(42861);
        }
    }

    static /* synthetic */ void h(LuckyMoneyNotHookReceiveUI luckyMoneyNotHookReceiveUI) {
        AppMethodBeat.i(42877);
        ImageView imageView = (ImageView) luckyMoneyNotHookReceiveUI.findViewById(R.id.czy);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = luckyMoneyNotHookReceiveUI.nsq.getMeasuredWidth() + 130;
        imageView.setLayoutParams(layoutParams);
        imageView = (ImageView) luckyMoneyNotHookReceiveUI.findViewById(R.id.czx);
        layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = luckyMoneyNotHookReceiveUI.ogp.getMeasuredWidth() + 130;
        imageView.setLayoutParams(layoutParams);
        luckyMoneyNotHookReceiveUI.ogt.setVisibility(0);
        luckyMoneyNotHookReceiveUI.ogt.invalidate();
        AppMethodBeat.o(42877);
    }
}
