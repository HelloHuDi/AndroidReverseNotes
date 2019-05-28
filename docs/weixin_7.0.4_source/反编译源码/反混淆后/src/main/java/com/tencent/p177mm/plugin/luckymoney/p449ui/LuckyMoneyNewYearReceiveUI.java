package com.tencent.p177mm.plugin.luckymoney.p449ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.emoji.view.BaseEmojiView;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.emoji.model.C20378d.C11556a;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.gif.MMAnimateView;
import com.tencent.p177mm.plugin.luckymoney.model.C12428k;
import com.tencent.p177mm.plugin.luckymoney.model.C36786an;
import com.tencent.p177mm.plugin.luckymoney.model.C36787aq;
import com.tencent.p177mm.plugin.luckymoney.model.C46063x;
import com.tencent.p177mm.plugin.luckymoney.p449ui.C43285k.C28461a;
import com.tencent.p177mm.plugin.luckymoney.p449ui.LuckyMoneyAutoScrollView.C43266a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.C43795a;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.C43795a.C43798a;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI */
public class LuckyMoneyNewYearReceiveUI extends LuckyMoneyBaseUI {
    private String cRS;
    private String emo;
    private String imageId = "";
    private String imagePath = "";
    private TextView iqw;
    private ImageView kEn;
    private C11556a kVj = new C168051();
    private EmojiInfo kZa;
    private C7620bi kua;
    private C7306ak mHandler = new C7306ak();
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
    private C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI$8 */
    class C34188 implements OnClickListener {
        C34188() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42793);
            C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearReceiveUI", "goto detail!");
            Intent intent = new Intent();
            intent.putExtra("key_native_url", LuckyMoneyNewYearReceiveUI.this.cRS);
            C25985d.m41467b(LuckyMoneyNewYearReceiveUI.this, "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", intent);
            AppMethodBeat.m2505o(42793);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI$9 */
    class C34199 implements OnClickListener {
        C34199() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42794);
            C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearReceiveUI", "goto BalanceManagerUI!");
            C35899h.m58862ak(LuckyMoneyNewYearReceiveUI.this.mController.ylL, 1);
            AppMethodBeat.m2505o(42794);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI$2 */
    class C124462 implements OnClickListener {
        C124462() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42785);
            LuckyMoneyNewYearReceiveUI.m32607e(LuckyMoneyNewYearReceiveUI.this);
            AppMethodBeat.m2505o(42785);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI$1 */
    class C168051 implements C11556a {
        C168051() {
        }

        /* renamed from: a */
        public final void mo23264a(final boolean z, final EmojiInfo emojiInfo) {
            AppMethodBeat.m2504i(42784);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(42783);
                    if (!(emojiInfo == null || LuckyMoneyNewYearReceiveUI.this.kZa == null || !LuckyMoneyNewYearReceiveUI.this.kZa.mo20410Aq().equals(emojiInfo.mo20410Aq()))) {
                        if (z) {
                            C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearReceiveUI", "somethings success.");
                            LuckyMoneyNewYearReceiveUI.this.kZa = C42952j.getEmojiStorageMgr().xYn.aqi(LuckyMoneyNewYearReceiveUI.this.kZa.mo20410Aq());
                            LuckyMoneyNewYearReceiveUI.this.ofo.setVisibility(8);
                            LuckyMoneyNewYearReceiveUI.this.ofy.setVisibility(0);
                            LuckyMoneyNewYearReceiveUI.this.ofy.setEmojiInfo(LuckyMoneyNewYearReceiveUI.this.kZa);
                            AppMethodBeat.m2505o(42783);
                            return;
                        }
                        C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearReceiveUI", "somethings error.");
                        LuckyMoneyNewYearReceiveUI.this.ofo.setVisibility(8);
                        LuckyMoneyNewYearReceiveUI.this.ofq.setVisibility(0);
                    }
                    AppMethodBeat.m2505o(42783);
                }
            });
            AppMethodBeat.m2505o(42784);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI$3 */
    class C212263 implements OnClickListener {
        C212263() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42786);
            LuckyMoneyNewYearReceiveUI.this.finish();
            C7060h.pYm.mo8381e(13079, Integer.valueOf(6), Integer.valueOf(2));
            AppMethodBeat.m2505o(42786);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI$4 */
    class C212274 implements OnClickListener {
        C212274() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42787);
            LuckyMoneyNewYearReceiveUI.this.finish();
            C7060h.pYm.mo8381e(13079, Integer.valueOf(6), Integer.valueOf(2));
            AppMethodBeat.m2505o(42787);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI$5 */
    class C212295 implements OnCancelListener {
        C212295() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(42788);
            if (LuckyMoneyNewYearReceiveUI.this.tipDialog != null && LuckyMoneyNewYearReceiveUI.this.tipDialog.isShowing()) {
                LuckyMoneyNewYearReceiveUI.this.tipDialog.dismiss();
            }
            LuckyMoneyNewYearReceiveUI.this.ocz.bLz();
            if (LuckyMoneyNewYearReceiveUI.this.mController.contentView.getVisibility() == 8 || LuckyMoneyNewYearReceiveUI.this.mController.contentView.getVisibility() == 4) {
                C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearReceiveUI", "usr cancel, & visibility not visiable, so finish");
                LuckyMoneyNewYearReceiveUI.this.finish();
            }
            AppMethodBeat.m2505o(42788);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public LuckyMoneyNewYearReceiveUI() {
        AppMethodBeat.m2504i(42795);
        AppMethodBeat.m2505o(42795);
    }

    /* renamed from: a */
    static /* synthetic */ void m32603a(LuckyMoneyNewYearReceiveUI luckyMoneyNewYearReceiveUI, int i, int i2, String str, String str2, String str3) {
        AppMethodBeat.m2504i(42807);
        luckyMoneyNewYearReceiveUI.m32602a(i, i2, str, str2, str3);
        AppMethodBeat.m2505o(42807);
    }

    /* renamed from: e */
    static /* synthetic */ void m32607e(LuckyMoneyNewYearReceiveUI luckyMoneyNewYearReceiveUI) {
        AppMethodBeat.m2504i(42806);
        luckyMoneyNewYearReceiveUI.bMD();
        AppMethodBeat.m2505o(42806);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(42796);
        super.onCreate(bundle);
        this.emo = getIntent().getStringExtra("key_username");
        this.ofA = getIntent().getStringExtra("key_emoji_md5");
        this.kua = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(getIntent().getLongExtra("key_msgid", 0));
        this.ofB = getIntent().getIntExtra("key_msg_newyear_localreceivestatus", 0);
        this.cRS = getIntent().getStringExtra("key_native_url");
        C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearReceiveUI", "emojiMd5:" + this.ofA);
        Uri parse = Uri.parse(C5046bo.nullAsNil(this.cRS));
        try {
            this.ocI = parse.getQueryParameter("sendid");
        } catch (Exception e) {
            C4990ab.m7417i("MicroMsg.LuckyMoneyNewYearReceiveUI", "onCreate() Exception:%s", e.getMessage());
        }
        initView();
        if (C5046bo.isNullOrNil(this.ocI)) {
            finish();
            C4990ab.m7420w("MicroMsg.LuckyMoneyNewYearReceiveUI", "sendid null & finish");
            AppMethodBeat.m2505o(42796);
            return;
        }
        mo24301b(new C36787aq(C5046bo.getInt(parse.getQueryParameter("channelid"), 1), this.ocI, this.cRS, 1, "v1.0"), false);
        if (this.tipDialog != null) {
            this.tipDialog.show();
        }
        AppMethodBeat.m2505o(42796);
    }

    public void onResume() {
        AppMethodBeat.m2504i(42797);
        super.onResume();
        if (this.ofD) {
            finish();
        }
        AppMethodBeat.m2505o(42797);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(42798);
        super.onDestroy();
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        C42952j.bkh().kVj = null;
        AppMethodBeat.m2505o(42798);
    }

    public final void initView() {
        AppMethodBeat.m2504i(42799);
        mo17446xE(-839716110);
        this.nTI = findViewById(2131825578);
        this.ofi = (LuckyMoneyAutoScrollView) findViewById(2131825584);
        this.ofj = (TextView) findViewById(2131825574);
        this.nsq = (TextView) findViewById(2131825583);
        this.kEn = (ImageView) findViewById(2131825594);
        this.ofl = (LinearLayout) findViewById(2131825585);
        this.iqw = (TextView) findViewById(2131825587);
        this.ofm = (ImageView) findViewById(2131825586);
        this.ofk = (TextView) findViewById(2131825595);
        this.ofn = (LinearLayout) findViewById(2131825593);
        this.ofv = (MMAnimateView) findViewById(2131825588);
        this.ofw = (ImageView) findViewById(2131825561);
        this.ofx = findViewById(2131825565);
        this.ofy = (BaseEmojiView) findViewById(2131825567);
        this.ofq = (TextView) findViewById(2131825580);
        this.ofo = (LinearLayout) findViewById(2131825581);
        this.ofp = (MMAnimateView) findViewById(2131825571);
        this.ofr = (LinearLayout) findViewById(2131825590);
        this.ofs = (TextView) findViewById(2131825591);
        this.ofq.setOnClickListener(new C124462());
        this.oft = (ImageView) findViewById(2131825577);
        this.oft.setOnClickListener(new C212263());
        this.ofu = (ImageView) findViewById(2131825596);
        this.ofu.setOnClickListener(new C212274());
        mo9439AM(8);
        this.tipDialog = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.cn5), true, new C212295());
        AppMethodBeat.m2505o(42799);
    }

    private void bMD() {
        AppMethodBeat.m2504i(42800);
        this.ofq.setVisibility(8);
        this.kZa = C42952j.getEmojiStorageMgr().xYn.aqi(this.ofA);
        if (this.kZa == null) {
            C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showExpression() mEmojiInfo == null ");
            AppMethodBeat.m2505o(42800);
        } else if (C5730e.asZ(this.kZa.dve()) > 0 || this.kZa.mo48552xy() || this.kZa.duS()) {
            this.ofy.setVisibility(0);
            this.ofy.setEmojiInfo(this.kZa);
            AppMethodBeat.m2505o(42800);
        } else {
            this.ofy.setVisibility(8);
            this.ofo.setVisibility(0);
            this.ofp.setImageResource(C1318a.lucky_money_newyear_creat_loading);
            C42952j.bkh().kVj = this.kVj;
            C42952j.bkh().mo35676s(this.kZa);
            AppMethodBeat.m2505o(42800);
        }
    }

    private void bME() {
        AppMethodBeat.m2504i(42801);
        this.ofv.setImageResource(C1318a.lucky_money_newyear_particle);
        AppMethodBeat.m2505o(42801);
    }

    /* renamed from: c */
    public final boolean mo7808c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(42802);
        C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearReceiveUI", "onSceneEnd() errType:" + i + " errCode:" + i2 + " errMsg:" + str + " netsceneType:" + c1207m.getType());
        boolean a;
        if (!(c1207m instanceof C36787aq)) {
            if (c1207m instanceof C36786an) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.dismiss();
                }
                if (i == 0 && i2 == 0) {
                    final C36786an c36786an = (C36786an) c1207m;
                    this.nYW = c36786an.nYW;
                    if (!C5046bo.m7563gW(this.nYW, 1)) {
                        this.ofx.setVisibility(8);
                        this.ofw.setVisibility(0);
                    }
                    C12428k c12428k = c36786an.nYn;
                    this.iqw.setText(c36786an.nYn.nWO);
                    String F = C36391e.m59971F(((double) c36786an.nYn.cSh) / 100.0d);
                    this.ofi.setContentDescription(F);
                    this.ofi.setFinalText(F);
                    this.ofi.mo68803a(new C43266a() {

                        /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI$7$1 */
                        class C212251 implements AnimationListener {
                            C212251() {
                            }

                            public final void onAnimationStart(Animation animation) {
                                AppMethodBeat.m2504i(42790);
                                LuckyMoneyNewYearReceiveUI.this.nsq.setVisibility(0);
                                AppMethodBeat.m2505o(42790);
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }

                            public final void onAnimationEnd(Animation animation) {
                                AppMethodBeat.m2504i(42791);
                                if (C26373g.m41964Nu().getInt("PlayCoinSound", 0) > 0) {
                                    C43285k.m77151a(LuckyMoneyNewYearReceiveUI.this, C28461a.oiu);
                                }
                                if (c36786an.nTN != null) {
                                    c36786an.nTN.mo74574b(LuckyMoneyNewYearReceiveUI.this, null, null);
                                }
                                AppMethodBeat.m2505o(42791);
                            }
                        }

                        public final void bMo() {
                            AppMethodBeat.m2504i(42792);
                            LuckyMoneyNewYearReceiveUI.this.nsq.setVisibility(4);
                            C46063x.m85800a(LuckyMoneyNewYearReceiveUI.this.mController.ylL, LuckyMoneyNewYearReceiveUI.this.nsq, c36786an.nYn.nSd);
                            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                            alphaAnimation.setDuration(500);
                            alphaAnimation.setAnimationListener(new C212251());
                            LuckyMoneyNewYearReceiveUI.this.nsq.startAnimation(alphaAnimation);
                            AppMethodBeat.m2505o(42792);
                        }
                    });
                    if (c12428k.cRU == 4 && !TextUtils.isEmpty(c36786an.nYn.nWO)) {
                        this.ofm.setVisibility(8);
                    }
                    m32612iL(false);
                    mo9439AM(0);
                    C46063x.m85801a(this.nTI, null);
                    m32614yc(2);
                    bME();
                    AppMethodBeat.m2505o(42802);
                    return true;
                } else if (i2 == 416) {
                    if (this.tipDialog != null && this.tipDialog.isShowing()) {
                        this.tipDialog.dismiss();
                    }
                    this.ofD = true;
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyNewYearReceiveUI");
                    bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                    a = C46063x.m85808a(this, i2, c1207m, bundle, true, null, 1004);
                    AppMethodBeat.m2505o(42802);
                    return a;
                }
            }
            AppMethodBeat.m2505o(42802);
            return false;
        } else if (i == 0 && i2 == 0) {
            Object obj;
            LayoutParams layoutParams;
            final C36787aq c36787aq = (C36787aq) c1207m;
            this.nYW = c36787aq.nYW;
            if (c36787aq.nWZ == 1) {
                obj = 1;
            } else {
                obj = null;
            }
            String F2;
            RelativeLayout.LayoutParams layoutParams2;
            if (obj != null) {
                C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is Sender hb!");
                if (c36787aq.cRU != 4) {
                    this.ofn.setVisibility(8);
                }
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.dismiss();
                }
                if (c36787aq.cRU != 5) {
                    F2 = C36391e.m59971F(((double) c36787aq.nZh) / 100.0d);
                    this.ofi.setContentDescription(F2);
                    this.ofi.setFinalText(F2);
                    this.ofi.bMn();
                    C46063x.m85800a(this.mController.ylL, this.nsq, c36787aq.nSd);
                    this.ofl.setVisibility(8);
                    this.ofn.setVisibility(0);
                    if (c36787aq.cRU == 4) {
                        C40460b.m69437r(this.kEn, this.emo);
                        m32614yc(2);
                    } else {
                        this.kEn.setVisibility(8);
                    }
                    this.ofk.setText(c36787aq.nWO);
                    this.ofk.setTextSize(1, 16.0f);
                    layoutParams2 = (RelativeLayout.LayoutParams) this.ofn.getLayoutParams();
                    layoutParams2.bottomMargin = C1338a.fromDPToPix(this, 82);
                    this.ofn.setLayoutParams(layoutParams2);
                    this.ofn.invalidate();
                    bME();
                } else {
                    findViewById(2131825582).setVisibility(8);
                    ((TextView) findViewById(2131825589)).setText(c36787aq.nWO);
                    ((TextView) findViewById(2131825589)).setVisibility(0);
                    ((TextView) findViewById(2131825589)).setTextSize(24.0f);
                    m32612iL(true);
                    m32614yc(1);
                }
                mo9439AM(0);
                C46063x.m85801a(this.nTI, null);
                this.oft.setVisibility(0);
                this.ofu.setVisibility(8);
            } else {
                C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is receiver hb!");
                if (!TextUtils.isEmpty(getIntent().getStringExtra("key_username"))) {
                    C40460b.m69437r(this.kEn, getIntent().getStringExtra("key_username"));
                } else if (!TextUtils.isEmpty(c36787aq.nWR)) {
                    C46063x.m85811b(this.kEn, c36787aq.nWR, c36787aq.nXl);
                }
                this.ofk.setTextSize(1, 16.0f);
                C46063x.m85800a(this.mController.ylL, this.ofk, c36787aq.nZg + getString(C25738R.string.crx));
                layoutParams2 = (RelativeLayout.LayoutParams) this.ofn.getLayoutParams();
                layoutParams2.bottomMargin = C1338a.fromDPToPix(this, 30);
                this.ofn.setLayoutParams(layoutParams2);
                this.ofn.invalidate();
                this.ofn.setVisibility(0);
                this.ofl.setVisibility(8);
                if (c36787aq.cRV != 0 || c36787aq.cRU == 4 || c36787aq.cRU == 5 || c36787aq.cRU == 1) {
                    if (this.tipDialog != null && this.tipDialog.isShowing()) {
                        this.tipDialog.dismiss();
                    }
                    if (c36787aq.cRU != 5) {
                        F2 = C36391e.m59971F(((double) c36787aq.nZh) / 100.0d);
                        this.ofi.setContentDescription(F2);
                        this.ofi.setFinalText(F2);
                        this.ofi.bMn();
                        C46063x.m85800a(this.mController.ylL, this.nsq, c36787aq.nSd);
                        m32614yc(2);
                        bME();
                        m32612iL(false);
                    } else {
                        this.ofr.setVisibility(8);
                        findViewById(2131825582).setVisibility(8);
                        ((TextView) findViewById(2131825589)).setText(c36787aq.nWO);
                        ((TextView) findViewById(2131825589)).setVisibility(0);
                        ((TextView) findViewById(2131825589)).setTextSize(24.0f);
                        m32614yc(1);
                    }
                    mo9439AM(0);
                    C46063x.m85801a(this.nTI, null);
                } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(c36787aq.nYs)) {
                    new C43795a().mo69476a(this, this.ocz, c36787aq.nYt, c36787aq.nYu, c36787aq.nYv, c36787aq.nYw, new C43798a() {
                        /* renamed from: c */
                        public final boolean mo24759c(int i, int i2, String str, boolean z) {
                            AppMethodBeat.m2504i(42789);
                            C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearReceiveUI", "showDisclaimerDialog resultCode=" + i + ";errCode=" + i2 + ";errMsg=" + str + ";hadAgree = " + z);
                            if (i == 1) {
                                LuckyMoneyNewYearReceiveUI.this.finish();
                            } else if (i == 2) {
                                LuckyMoneyNewYearReceiveUI.m32603a(LuckyMoneyNewYearReceiveUI.this, c36787aq.msgType, c36787aq.cdf, c36787aq.nSX, c36787aq.cRS, c36787aq.nZl);
                            } else if (i == 0 && z) {
                                LuckyMoneyNewYearReceiveUI.m32603a(LuckyMoneyNewYearReceiveUI.this, c36787aq.msgType, c36787aq.cdf, c36787aq.nSX, c36787aq.cRS, c36787aq.nZl);
                            }
                            AppMethodBeat.m2505o(42789);
                            return true;
                        }
                    }, true, 1005);
                } else {
                    m32602a(c36787aq.msgType, c36787aq.cdf, c36787aq.nSX, c36787aq.cRS, c36787aq.nZl);
                }
                layoutParams = (LayoutParams) this.ofl.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelOffset(C25738R.dimen.a5b);
                this.ofl.setLayoutParams(layoutParams);
                this.ofl.invalidate();
                this.iqw.setTextSize(1, 12.0f);
                this.oft.setVisibility(8);
                this.ofu.setVisibility(0);
            }
            a = true;
            if (c36787aq.cRU == 5 || c36787aq.cRU == 1) {
                a = false;
            }
            C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearReceiveUI", "receiveScene.hbStatus is " + c36787aq.cRU + ", isValidStatus is " + a);
            Object obj2 = (!C5046bo.m7563gW(this.nYW, 1) || C5046bo.isNullOrNil(this.ofA)) ? null : 1;
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
                this.ofi.mo68805eu(getResources().getDimensionPixelOffset(C25738R.dimen.a59), getResources().getDimensionPixelOffset(C25738R.dimen.a55));
                this.ofi.invalidate();
            } else {
                this.nsq.getLayoutParams();
                this.nsq.setTextSize(1, 21.0f);
                this.ofj.setTextSize(1, 15.0f);
                this.ofi.mo68805eu(getResources().getDimensionPixelOffset(C25738R.dimen.a58), getResources().getDimensionPixelOffset(C25738R.dimen.a54));
                layoutParams = (LayoutParams) this.ofi.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelOffset(C25738R.dimen.a4r);
                this.ofi.setLayoutParams(layoutParams);
                this.ofi.invalidate();
            }
            AppMethodBeat.m2505o(42802);
            return true;
        } else {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            AppMethodBeat.m2505o(42802);
            return false;
        }
    }

    /* renamed from: a */
    private void m32602a(int i, int i2, String str, String str2, String str3) {
        AppMethodBeat.m2504i(42803);
        mo24301b(new C36786an(i, i2, str, str2, C46063x.bLC(), C1853r.m3820YB(), getIntent().getStringExtra("key_username"), "v1.0", str3), false);
        AppMethodBeat.m2505o(42803);
    }

    public final int getLayoutId() {
        return 2130969990;
    }

    /* renamed from: yc */
    private void m32614yc(int i) {
        AppMethodBeat.m2504i(42804);
        C4990ab.m7417i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() localReceiveStatus:%s newStatus:%s", Integer.valueOf(this.ofB), Integer.valueOf(i));
        if (this.kua == null) {
            C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() mEmojiInfo == null");
            AppMethodBeat.m2505o(42804);
        } else if (C5046bo.m7563gW(this.ofB, i) || C5046bo.m7563gW(this.ofB, 2)) {
            AppMethodBeat.m2505o(42804);
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
                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(this.kua.field_msgId, this.kua);
                C4990ab.m7417i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() success msgXml:%s", stringBuilder);
                AppMethodBeat.m2505o(42804);
            } catch (Exception e) {
                C4990ab.m7417i("MicroMsg.LuckyMoneyNewYearReceiveUI", "dealMessageInfo() Exception:%s", e.getMessage());
                AppMethodBeat.m2505o(42804);
            }
        }
    }

    /* renamed from: iL */
    private void m32612iL(boolean z) {
        AppMethodBeat.m2504i(42805);
        if (z) {
            this.ofr.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.ofr.getLayoutParams()).addRule(3, 2131825589);
            this.ofs.setText(getString(C25738R.string.csv));
            this.ofr.setOnClickListener(new C34188());
            AppMethodBeat.m2505o(42805);
            return;
        }
        this.ofr.setVisibility(0);
        this.ofr.setOnClickListener(new C34199());
        this.ofs.setText(getString(C25738R.string.cst));
        AppMethodBeat.m2505o(42805);
    }
}
