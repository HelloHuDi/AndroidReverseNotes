package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.luckymoney.model.an;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.e;

@a(3)
public class LuckyMoneyNewYearReceiveUI extends LuckyMoneyBaseUI {
    private String cRS;
    private String emo;
    private String imageId = "";
    private String imagePath = "";
    private TextView iqw;
    private ImageView kEn;
    private d.a kVj = new d.a() {
        public final void a(final boolean z, final EmojiInfo emojiInfo) {
            AppMethodBeat.i(42784);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(42783);
                    if (!(emojiInfo == null || LuckyMoneyNewYearReceiveUI.this.kZa == null || !LuckyMoneyNewYearReceiveUI.this.kZa.Aq().equals(emojiInfo.Aq()))) {
                        if (z) {
                            ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "somethings success.");
                            LuckyMoneyNewYearReceiveUI.this.kZa = j.getEmojiStorageMgr().xYn.aqi(LuckyMoneyNewYearReceiveUI.this.kZa.Aq());
                            LuckyMoneyNewYearReceiveUI.this.ofo.setVisibility(8);
                            LuckyMoneyNewYearReceiveUI.this.ofy.setVisibility(0);
                            LuckyMoneyNewYearReceiveUI.this.ofy.setEmojiInfo(LuckyMoneyNewYearReceiveUI.this.kZa);
                            AppMethodBeat.o(42783);
                            return;
                        }
                        ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "somethings error.");
                        LuckyMoneyNewYearReceiveUI.this.ofo.setVisibility(8);
                        LuckyMoneyNewYearReceiveUI.this.ofq.setVisibility(0);
                    }
                    AppMethodBeat.o(42783);
                }
            });
            AppMethodBeat.o(42784);
        }
    };
    private EmojiInfo kZa;
    private bi kua;
    private ak mHandler = new ak();
    private View nTI;
    public int nYW = 0;
    private TextView nsq;
    private String ocI;
    private String ofA = "";
    private int ofB;
    private String ofC = "";
    private boolean ofD = false;
    private LuckyMoneyAutoScrollView ofi;
    private TextView ofj;
    private TextView ofk;
    private LinearLayout ofl;
    private ImageView ofm;
    private LinearLayout ofn;
    private LinearLayout ofo;
    private MMAnimateView ofp;
    private TextView ofq;
    private LinearLayout ofr;
    private TextView ofs;
    private ImageView oft;
    private ImageView ofu;
    private MMAnimateView ofv;
    private ImageView ofw;
    private View ofx;
    private BaseEmojiView ofy;
    private boolean ofz = false;
    private p tipDialog = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LuckyMoneyNewYearReceiveUI() {
        AppMethodBeat.i(42795);
        AppMethodBeat.o(42795);
    }

    static /* synthetic */ void a(LuckyMoneyNewYearReceiveUI luckyMoneyNewYearReceiveUI, int i, int i2, String str, String str2, String str3) {
        AppMethodBeat.i(42807);
        luckyMoneyNewYearReceiveUI.a(i, i2, str, str2, str3);
        AppMethodBeat.o(42807);
    }

    static /* synthetic */ void e(LuckyMoneyNewYearReceiveUI luckyMoneyNewYearReceiveUI) {
        AppMethodBeat.i(42806);
        luckyMoneyNewYearReceiveUI.bMD();
        AppMethodBeat.o(42806);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42796);
        super.onCreate(bundle);
        this.emo = getIntent().getStringExtra("key_username");
        this.ofA = getIntent().getStringExtra("key_emoji_md5");
        this.kua = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf(getIntent().getLongExtra("key_msgid", 0));
        this.ofB = getIntent().getIntExtra("key_msg_newyear_localreceivestatus", 0);
        this.cRS = getIntent().getStringExtra("key_native_url");
        ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "emojiMd5:" + this.ofA);
        Uri parse = Uri.parse(bo.nullAsNil(this.cRS));
        try {
            this.ocI = parse.getQueryParameter("sendid");
        } catch (Exception e) {
            ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "onCreate() Exception:%s", e.getMessage());
        }
        initView();
        if (bo.isNullOrNil(this.ocI)) {
            finish();
            ab.w("MicroMsg.LuckyMoneyNewYearReceiveUI", "sendid null & finish");
            AppMethodBeat.o(42796);
            return;
        }
        b(new aq(bo.getInt(parse.getQueryParameter("channelid"), 1), this.ocI, this.cRS, 1, "v1.0"), false);
        if (this.tipDialog != null) {
            this.tipDialog.show();
        }
        AppMethodBeat.o(42796);
    }

    public void onResume() {
        AppMethodBeat.i(42797);
        super.onResume();
        if (this.ofD) {
            finish();
        }
        AppMethodBeat.o(42797);
    }

    public void onDestroy() {
        AppMethodBeat.i(42798);
        super.onDestroy();
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        j.bkh().kVj = null;
        AppMethodBeat.o(42798);
    }

    public final void initView() {
        AppMethodBeat.i(42799);
        xE(-839716110);
        this.nTI = findViewById(R.id.cy3);
        this.ofi = (LuckyMoneyAutoScrollView) findViewById(R.id.cy9);
        this.ofj = (TextView) findViewById(R.id.cxz);
        this.nsq = (TextView) findViewById(R.id.cy8);
        this.kEn = (ImageView) findViewById(R.id.cyi);
        this.ofl = (LinearLayout) findViewById(R.id.cy_);
        this.iqw = (TextView) findViewById(R.id.cyb);
        this.ofm = (ImageView) findViewById(R.id.cya);
        this.ofk = (TextView) findViewById(R.id.cyj);
        this.ofn = (LinearLayout) findViewById(R.id.cyh);
        this.ofv = (MMAnimateView) findViewById(R.id.cyc);
        this.ofw = (ImageView) findViewById(R.id.cxm);
        this.ofx = findViewById(R.id.cxq);
        this.ofy = (BaseEmojiView) findViewById(R.id.cxs);
        this.ofq = (TextView) findViewById(R.id.cy5);
        this.ofo = (LinearLayout) findViewById(R.id.cy6);
        this.ofp = (MMAnimateView) findViewById(R.id.cxw);
        this.ofr = (LinearLayout) findViewById(R.id.cye);
        this.ofs = (TextView) findViewById(R.id.cyf);
        this.ofq.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42785);
                LuckyMoneyNewYearReceiveUI.e(LuckyMoneyNewYearReceiveUI.this);
                AppMethodBeat.o(42785);
            }
        });
        this.oft = (ImageView) findViewById(R.id.cy2);
        this.oft.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42786);
                LuckyMoneyNewYearReceiveUI.this.finish();
                h.pYm.e(13079, Integer.valueOf(6), Integer.valueOf(2));
                AppMethodBeat.o(42786);
            }
        });
        this.ofu = (ImageView) findViewById(R.id.cyk);
        this.ofu.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42787);
                LuckyMoneyNewYearReceiveUI.this.finish();
                h.pYm.e(13079, Integer.valueOf(6), Integer.valueOf(2));
                AppMethodBeat.o(42787);
            }
        });
        AM(8);
        this.tipDialog = com.tencent.mm.ui.base.h.b(this.mController.ylL, getString(R.string.cn5), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(42788);
                if (LuckyMoneyNewYearReceiveUI.this.tipDialog != null && LuckyMoneyNewYearReceiveUI.this.tipDialog.isShowing()) {
                    LuckyMoneyNewYearReceiveUI.this.tipDialog.dismiss();
                }
                LuckyMoneyNewYearReceiveUI.this.ocz.bLz();
                if (LuckyMoneyNewYearReceiveUI.this.mController.contentView.getVisibility() == 8 || LuckyMoneyNewYearReceiveUI.this.mController.contentView.getVisibility() == 4) {
                    ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "usr cancel, & visibility not visiable, so finish");
                    LuckyMoneyNewYearReceiveUI.this.finish();
                }
                AppMethodBeat.o(42788);
            }
        });
        AppMethodBeat.o(42799);
    }

    private void bMD() {
        AppMethodBeat.i(42800);
        this.ofq.setVisibility(8);
        this.kZa = j.getEmojiStorageMgr().xYn.aqi(this.ofA);
        if (this.kZa == null) {
            ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showExpression() mEmojiInfo == null ");
            AppMethodBeat.o(42800);
        } else if (e.asZ(this.kZa.dve()) > 0 || this.kZa.xy() || this.kZa.duS()) {
            this.ofy.setVisibility(0);
            this.ofy.setEmojiInfo(this.kZa);
            AppMethodBeat.o(42800);
        } else {
            this.ofy.setVisibility(8);
            this.ofo.setVisibility(0);
            this.ofp.setImageResource(R.raw.lucky_money_newyear_creat_loading);
            j.bkh().kVj = this.kVj;
            j.bkh().s(this.kZa);
            AppMethodBeat.o(42800);
        }
    }

    private void bME() {
        AppMethodBeat.i(42801);
        this.ofv.setImageResource(R.raw.lucky_money_newyear_particle);
        AppMethodBeat.o(42801);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(42802);
        ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "onSceneEnd() errType:" + i + " errCode:" + i2 + " errMsg:" + str + " netsceneType:" + mVar.getType());
        boolean a;
        if (!(mVar instanceof aq)) {
            if (mVar instanceof an) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.dismiss();
                }
                if (i == 0 && i2 == 0) {
                    final an anVar = (an) mVar;
                    this.nYW = anVar.nYW;
                    if (!bo.gW(this.nYW, 1)) {
                        this.ofx.setVisibility(8);
                        this.ofw.setVisibility(0);
                    }
                    k kVar = anVar.nYn;
                    this.iqw.setText(anVar.nYn.nWO);
                    String F = com.tencent.mm.wallet_core.ui.e.F(((double) anVar.nYn.cSh) / 100.0d);
                    this.ofi.setContentDescription(F);
                    this.ofi.setFinalText(F);
                    this.ofi.a(new LuckyMoneyAutoScrollView.a() {
                        public final void bMo() {
                            AppMethodBeat.i(42792);
                            LuckyMoneyNewYearReceiveUI.this.nsq.setVisibility(4);
                            x.a(LuckyMoneyNewYearReceiveUI.this.mController.ylL, LuckyMoneyNewYearReceiveUI.this.nsq, anVar.nYn.nSd);
                            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                            alphaAnimation.setDuration(500);
                            alphaAnimation.setAnimationListener(new AnimationListener() {
                                public final void onAnimationStart(Animation animation) {
                                    AppMethodBeat.i(42790);
                                    LuckyMoneyNewYearReceiveUI.this.nsq.setVisibility(0);
                                    AppMethodBeat.o(42790);
                                }

                                public final void onAnimationRepeat(Animation animation) {
                                }

                                public final void onAnimationEnd(Animation animation) {
                                    AppMethodBeat.i(42791);
                                    if (com.tencent.mm.m.g.Nu().getInt("PlayCoinSound", 0) > 0) {
                                        k.a(LuckyMoneyNewYearReceiveUI.this, a.oiu);
                                    }
                                    if (anVar.nTN != null) {
                                        anVar.nTN.b(LuckyMoneyNewYearReceiveUI.this, null, null);
                                    }
                                    AppMethodBeat.o(42791);
                                }
                            });
                            LuckyMoneyNewYearReceiveUI.this.nsq.startAnimation(alphaAnimation);
                            AppMethodBeat.o(42792);
                        }
                    });
                    if (kVar.cRU == 4 && !TextUtils.isEmpty(anVar.nYn.nWO)) {
                        this.ofm.setVisibility(8);
                    }
                    iL(false);
                    AM(0);
                    x.a(this.nTI, null);
                    yc(2);
                    bME();
                    AppMethodBeat.o(42802);
                    return true;
                } else if (i2 == 416) {
                    if (this.tipDialog != null && this.tipDialog.isShowing()) {
                        this.tipDialog.dismiss();
                    }
                    this.ofD = true;
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyNewYearReceiveUI");
                    bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                    a = x.a(this, i2, mVar, bundle, true, null, 1004);
                    AppMethodBeat.o(42802);
                    return a;
                }
            }
            AppMethodBeat.o(42802);
            return false;
        } else if (i == 0 && i2 == 0) {
            Object obj;
            LayoutParams layoutParams;
            final aq aqVar = (aq) mVar;
            this.nYW = aqVar.nYW;
            if (aqVar.nWZ == 1) {
                obj = 1;
            } else {
                obj = null;
            }
            String F2;
            RelativeLayout.LayoutParams layoutParams2;
            if (obj != null) {
                ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is Sender hb!");
                if (aqVar.cRU != 4) {
                    this.ofn.setVisibility(8);
                }
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.dismiss();
                }
                if (aqVar.cRU != 5) {
                    F2 = com.tencent.mm.wallet_core.ui.e.F(((double) aqVar.nZh) / 100.0d);
                    this.ofi.setContentDescription(F2);
                    this.ofi.setFinalText(F2);
                    this.ofi.bMn();
                    x.a(this.mController.ylL, this.nsq, aqVar.nSd);
                    this.ofl.setVisibility(8);
                    this.ofn.setVisibility(0);
                    if (aqVar.cRU == 4) {
                        b.r(this.kEn, this.emo);
                        yc(2);
                    } else {
                        this.kEn.setVisibility(8);
                    }
                    this.ofk.setText(aqVar.nWO);
                    this.ofk.setTextSize(1, 16.0f);
                    layoutParams2 = (RelativeLayout.LayoutParams) this.ofn.getLayoutParams();
                    layoutParams2.bottomMargin = com.tencent.mm.bz.a.fromDPToPix(this, 82);
                    this.ofn.setLayoutParams(layoutParams2);
                    this.ofn.invalidate();
                    bME();
                } else {
                    findViewById(R.id.cy7).setVisibility(8);
                    ((TextView) findViewById(R.id.cyd)).setText(aqVar.nWO);
                    ((TextView) findViewById(R.id.cyd)).setVisibility(0);
                    ((TextView) findViewById(R.id.cyd)).setTextSize(24.0f);
                    iL(true);
                    yc(1);
                }
                AM(0);
                x.a(this.nTI, null);
                this.oft.setVisibility(0);
                this.ofu.setVisibility(8);
            } else {
                ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is receiver hb!");
                if (!TextUtils.isEmpty(getIntent().getStringExtra("key_username"))) {
                    b.r(this.kEn, getIntent().getStringExtra("key_username"));
                } else if (!TextUtils.isEmpty(aqVar.nWR)) {
                    x.b(this.kEn, aqVar.nWR, aqVar.nXl);
                }
                this.ofk.setTextSize(1, 16.0f);
                x.a(this.mController.ylL, this.ofk, aqVar.nZg + getString(R.string.crx));
                layoutParams2 = (RelativeLayout.LayoutParams) this.ofn.getLayoutParams();
                layoutParams2.bottomMargin = com.tencent.mm.bz.a.fromDPToPix(this, 30);
                this.ofn.setLayoutParams(layoutParams2);
                this.ofn.invalidate();
                this.ofn.setVisibility(0);
                this.ofl.setVisibility(8);
                if (aqVar.cRV != 0 || aqVar.cRU == 4 || aqVar.cRU == 5 || aqVar.cRU == 1) {
                    if (this.tipDialog != null && this.tipDialog.isShowing()) {
                        this.tipDialog.dismiss();
                    }
                    if (aqVar.cRU != 5) {
                        F2 = com.tencent.mm.wallet_core.ui.e.F(((double) aqVar.nZh) / 100.0d);
                        this.ofi.setContentDescription(F2);
                        this.ofi.setFinalText(F2);
                        this.ofi.bMn();
                        x.a(this.mController.ylL, this.nsq, aqVar.nSd);
                        yc(2);
                        bME();
                        iL(false);
                    } else {
                        this.ofr.setVisibility(8);
                        findViewById(R.id.cy7).setVisibility(8);
                        ((TextView) findViewById(R.id.cyd)).setText(aqVar.nWO);
                        ((TextView) findViewById(R.id.cyd)).setVisibility(0);
                        ((TextView) findViewById(R.id.cyd)).setTextSize(24.0f);
                        yc(1);
                    }
                    AM(0);
                    x.a(this.nTI, null);
                } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(aqVar.nYs)) {
                    new com.tencent.mm.plugin.wallet_core.id_verify.util.a().a(this, this.ocz, aqVar.nYt, aqVar.nYu, aqVar.nYv, aqVar.nYw, new com.tencent.mm.plugin.wallet_core.id_verify.util.a.a() {
                        public final boolean c(int i, int i2, String str, boolean z) {
                            AppMethodBeat.i(42789);
                            ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showDisclaimerDialog resultCode=" + i + ";errCode=" + i2 + ";errMsg=" + str + ";hadAgree = " + z);
                            if (i == 1) {
                                LuckyMoneyNewYearReceiveUI.this.finish();
                            } else if (i == 2) {
                                LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, aqVar.msgType, aqVar.cdf, aqVar.nSX, aqVar.cRS, aqVar.nZl);
                            } else if (i == 0 && z) {
                                LuckyMoneyNewYearReceiveUI.a(LuckyMoneyNewYearReceiveUI.this, aqVar.msgType, aqVar.cdf, aqVar.nSX, aqVar.cRS, aqVar.nZl);
                            }
                            AppMethodBeat.o(42789);
                            return true;
                        }
                    }, true, 1005);
                } else {
                    a(aqVar.msgType, aqVar.cdf, aqVar.nSX, aqVar.cRS, aqVar.nZl);
                }
                layoutParams = (LayoutParams) this.ofl.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.a5b);
                this.ofl.setLayoutParams(layoutParams);
                this.ofl.invalidate();
                this.iqw.setTextSize(1, 12.0f);
                this.oft.setVisibility(8);
                this.ofu.setVisibility(0);
            }
            a = true;
            if (aqVar.cRU == 5 || aqVar.cRU == 1) {
                a = false;
            }
            ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "receiveScene.hbStatus is " + aqVar.cRU + ", isValidStatus is " + a);
            Object obj2 = (!bo.gW(this.nYW, 1) || bo.isNullOrNil(this.ofA)) ? null : 1;
            if (obj2 == null || !a) {
                this.ofx.setVisibility(8);
                this.ofw.setVisibility(0);
            } else {
                this.ofx.setVisibility(0);
                this.ofw.setVisibility(8);
                bMD();
            }
            if (obj2 == null || !a) {
                this.nsq.setTextSize(1, 21.0f);
                this.ofj.setTextSize(1, 18.0f);
                this.ofi.eu(getResources().getDimensionPixelOffset(R.dimen.a59), getResources().getDimensionPixelOffset(R.dimen.a55));
                this.ofi.invalidate();
            } else {
                this.nsq.getLayoutParams();
                this.nsq.setTextSize(1, 21.0f);
                this.ofj.setTextSize(1, 15.0f);
                this.ofi.eu(getResources().getDimensionPixelOffset(R.dimen.a58), getResources().getDimensionPixelOffset(R.dimen.a54));
                layoutParams = (LayoutParams) this.ofi.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.a4r);
                this.ofi.setLayoutParams(layoutParams);
                this.ofi.invalidate();
            }
            AppMethodBeat.o(42802);
            return true;
        } else {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            AppMethodBeat.o(42802);
            return false;
        }
    }

    private void a(int i, int i2, String str, String str2, String str3) {
        AppMethodBeat.i(42803);
        b(new an(i, i2, str, str2, x.bLC(), r.YB(), getIntent().getStringExtra("key_username"), "v1.0", str3), false);
        AppMethodBeat.o(42803);
    }

    public final int getLayoutId() {
        return R.layout.aae;
    }

    private void yc(int i) {
        AppMethodBeat.i(42804);
        ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() localReceiveStatus:%s newStatus:%s", Integer.valueOf(this.ofB), Integer.valueOf(i));
        if (this.kua == null) {
            ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() mEmojiInfo == null");
            AppMethodBeat.o(42804);
        } else if (bo.gW(this.ofB, i) || bo.gW(this.ofB, 2)) {
            AppMethodBeat.o(42804);
        } else {
            try {
                StringBuilder stringBuilder = new StringBuilder(this.kua.field_content);
                StringBuilder stringBuilder2 = new StringBuilder();
                int indexOf = stringBuilder.indexOf("<localreceivestatus>");
                StringBuilder stringBuilder3;
                if (indexOf <= 0 || indexOf >= stringBuilder.length()) {
                    indexOf = stringBuilder.indexOf("<emoji>");
                    if (indexOf <= 0 || indexOf >= stringBuilder.length()) {
                        indexOf = stringBuilder.indexOf("<wcpayinfo>");
                        stringBuilder2.append("<emoji><localreceivestatus>").append(i).append("</localreceivestatus></emoji>");
                        stringBuilder3 = new StringBuilder(stringBuilder.substring(0, indexOf));
                        stringBuilder3.append(stringBuilder2).append(stringBuilder.substring(indexOf).trim());
                        stringBuilder = stringBuilder3;
                    } else {
                        stringBuilder2.append("<localreceivestatus>").append(i).append("</localreceivestatus>");
                        stringBuilder3 = new StringBuilder(stringBuilder.substring(0, indexOf + 7));
                        stringBuilder3.append(stringBuilder2).append(stringBuilder.substring(indexOf + 7).trim());
                        stringBuilder = stringBuilder3;
                    }
                } else {
                    stringBuilder3 = new StringBuilder(stringBuilder.substring(0, indexOf + 20));
                    stringBuilder3.append(i).append(stringBuilder.substring(indexOf + 21));
                    stringBuilder = stringBuilder3;
                }
                this.kua.setContent(stringBuilder.toString());
                ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(this.kua.field_msgId, this.kua);
                ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() success msgXml:%s", stringBuilder);
                AppMethodBeat.o(42804);
            } catch (Exception e) {
                ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() Exception:%s", e.getMessage());
                AppMethodBeat.o(42804);
            }
        }
    }

    private void iL(boolean z) {
        AppMethodBeat.i(42805);
        if (z) {
            this.ofr.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.ofr.getLayoutParams()).addRule(3, R.id.cyd);
            this.ofs.setText(getString(R.string.csv));
            this.ofr.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(42793);
                    ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "goto detail!");
                    Intent intent = new Intent();
                    intent.putExtra("key_native_url", LuckyMoneyNewYearReceiveUI.this.cRS);
                    com.tencent.mm.bp.d.b(LuckyMoneyNewYearReceiveUI.this, "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", intent);
                    AppMethodBeat.o(42793);
                }
            });
            AppMethodBeat.o(42805);
            return;
        }
        this.ofr.setVisibility(0);
        this.ofr.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42794);
                ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "goto BalanceManagerUI!");
                com.tencent.mm.pluginsdk.wallet.h.ak(LuckyMoneyNewYearReceiveUI.this.mController.ylL, 1);
                AppMethodBeat.o(42794);
            }
        });
        this.ofs.setText(getString(R.string.cst));
        AppMethodBeat.o(42805);
    }
}
