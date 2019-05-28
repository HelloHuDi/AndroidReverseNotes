package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C17918t.C17917a;
import com.tencent.p177mm.api.C8955k;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C42047qq;
import com.tencent.p177mm.p230g.p232b.p233a.C26272ab;
import com.tencent.p177mm.p230g.p232b.p233a.C9499aa;
import com.tencent.p177mm.p612ui.C24019s;
import com.tencent.p177mm.p612ui.C5510e.C5499f;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.p613a.C5216a.C5215a;
import com.tencent.p177mm.p612ui.widget.C16001d;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.p765a.p1216b.C32921a;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.emojicapture.api.C20423c;
import com.tencent.p177mm.plugin.luckymoney.f2f.p1279a.C21195d;
import com.tencent.p177mm.plugin.luckymoney.model.C12426ao;
import com.tencent.p177mm.plugin.luckymoney.model.C21198ar;
import com.tencent.p177mm.plugin.luckymoney.model.C21200i;
import com.tencent.p177mm.plugin.luckymoney.model.C3381ag;
import com.tencent.p177mm.plugin.luckymoney.model.C3382ah;
import com.tencent.p177mm.plugin.luckymoney.model.C34441ae;
import com.tencent.p177mm.plugin.luckymoney.model.C34443al;
import com.tencent.p177mm.plugin.luckymoney.model.C39319d;
import com.tencent.p177mm.plugin.luckymoney.model.C46059c;
import com.tencent.p177mm.plugin.luckymoney.model.C46061f;
import com.tencent.p177mm.plugin.luckymoney.model.C46063x;
import com.tencent.p177mm.plugin.luckymoney.p449ui.C21249h.C21253c;
import com.tencent.p177mm.plugin.luckymoney.p449ui.C46064a.C34503a;
import com.tencent.p177mm.plugin.luckymoney.p449ui.p1406a.C28459a;
import com.tencent.p177mm.plugin.luckymoney.p735b.C6964a;
import com.tencent.p177mm.plugin.luckymoney.p987a.C12405a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.plugin.wallet_core.model.C29628a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C46373j;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C46373j.C29672a;
import com.tencent.p177mm.plugin.wallet_core.utils.C46374c;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44081e;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.protocal.protobuf.aoj;
import com.tencent.p177mm.protocal.protobuf.atb;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.wallet_core.p649c.C44421a.C40926a;
import com.tencent.p177mm.wallet_core.p649c.C44422ad;
import com.tencent.p177mm.wallet_core.p649c.C44424g;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.MMScrollView;
import com.tencent.smtt.sdk.WebView;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI */
public class LuckyMoneyPrepareUI extends LuckyMoneyBaseUI implements C12472g {
    private int cKs = 0;
    private int emC;
    private C7564ap gGo = null;
    private Dialog gII = null;
    private TextView kGm = null;
    private TextView kGq;
    private EmojiInfo kZa;
    private Button leS = null;
    protected MyKeyboardWindow mKeyboard;
    private int mType;
    private C21200i nSs;
    private LuckyMoneyNumInputView nTd = null;
    private LuckyMoneyTextInputView nTf = null;
    private Button nTg = null;
    protected View nTi;
    private MMScrollView nTk;
    private TextView nTl;
    private C43281b nTn = new C43281b();
    private C39319d nWN;
    private int nYN;
    private LuckyMoneyMoneyInputView obC = null;
    private View obD;
    private View obE;
    private ViewGroup obF;
    private int obG;
    private String obH;
    private int obI;
    private boolean obJ;
    private String obK;
    private int obL;
    private String ocI = "";
    private C46064a odS;
    private View odT;
    private ChatFooterPanel odY;
    private ViewGroup oea;
    private C9499aa oec;
    private int oef = 0;
    private int ogb = 1;
    private String ogi;
    private String ogm = "";
    private long ohA;
    private String ohB;
    private C16001d ohC;
    private boolean ohD = false;
    private boolean ohE = false;
    private boolean ohF = false;
    private boolean ohG = false;
    private C4884c<C42047qq> ohH = new C2845018();
    private Dialog ohk = null;
    private Dialog ohl = null;
    private RelativeLayout ohm;
    private TextView ohn;
    private ImageView oho;
    private TextView ohp;
    private int ohq = 1;
    private String ohr = C36391e.atr("CNY");
    private String ohs = null;
    private RealnameGuideHelper oht;
    private String ohu;
    private C26272ab ohv;
    private int ohw;
    private String ohx;
    private int ohy;
    private long ohz;

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$23 */
    class C342523 implements Runnable {
        C342523() {
        }

        public final void run() {
            AppMethodBeat.m2504i(42967);
            Intent intent = new Intent();
            intent.setClass(LuckyMoneyPrepareUI.this.mController.ylL, LuckyMoneyIndexUI.class);
            intent.addFlags(67108864);
            LuckyMoneyPrepareUI.this.mController.ylL.startActivity(intent);
            LuckyMoneyPrepareUI.this.finish();
            AppMethodBeat.m2505o(42967);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$17 */
    class C1245117 implements OnClickListener {
        C1245117() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(42957);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(42957);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$19 */
    class C1245219 implements C44424g {
        C1245219() {
        }

        /* renamed from: aQ */
        public final void mo24321aQ(int i, String str) {
            AppMethodBeat.m2504i(42962);
            C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() scene:NetScenePrepareLuckyMoney JumpRemind:onNext()");
            if (C5046bo.m7563gW(i, 2) && C5046bo.isEqual(str, "requestwxhb")) {
                LuckyMoneyPrepareUI.m77133x(LuckyMoneyPrepareUI.this);
                AppMethodBeat.m2505o(42962);
                return;
            }
            if (C5046bo.m7563gW(i, 1)) {
                C32921a.m53856b(LuckyMoneyPrepareUI.this, str, 0, true);
            }
            AppMethodBeat.m2505o(42962);
        }

        public final void onCancel() {
            AppMethodBeat.m2504i(42963);
            C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() scene:NetScenePrepareLuckyMoney JumpRemind:onCancel()");
            AppMethodBeat.m2505o(42963);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$21 */
    class C1245321 implements Runnable {
        C1245321() {
        }

        public final void run() {
            AppMethodBeat.m2504i(42965);
            LuckyMoneyPrepareUI.this.finish();
            AppMethodBeat.m2505o(42965);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$24 */
    class C1245424 implements OnClickListener {
        C1245424() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(42968);
            Intent intent = new Intent();
            intent.setClass(LuckyMoneyPrepareUI.this.mController.ylL, LuckyMoneyMyRecordUI.class);
            intent.putExtra("key_type", 1);
            LuckyMoneyPrepareUI.this.startActivity(intent);
            AppMethodBeat.m2505o(42968);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$37 */
    class C1246037 implements View.OnClickListener {
        C1246037() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42987);
            LuckyMoneyPrepareUI.this.aoB();
            AppMethodBeat.m2505o(42987);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$2 */
    class C212442 implements OnCancelListener {
        C212442() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(42942);
            C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "coperationTipDialogNoTransparent onCancel()");
            LuckyMoneyPrepareUI.this.ohF = false;
            LuckyMoneyPrepareUI.this.ohE = false;
            if (LuckyMoneyPrepareUI.this.ohl != null && LuckyMoneyPrepareUI.this.ohl.isShowing()) {
                LuckyMoneyPrepareUI.this.ohl.dismiss();
            }
            if (LuckyMoneyPrepareUI.this.mController.contentView.getVisibility() == 8 || LuckyMoneyPrepareUI.this.mController.contentView.getVisibility() == 4) {
                C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
                LuckyMoneyPrepareUI.this.finish();
            }
            LuckyMoneyPrepareUI.this.ocz.bLz();
            AppMethodBeat.m2505o(42942);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$3 */
    class C212453 implements OnCancelListener {
        C212453() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(42943);
            if (LuckyMoneyPrepareUI.this.gII != null && LuckyMoneyPrepareUI.this.gII.isShowing()) {
                LuckyMoneyPrepareUI.this.gII.dismiss();
            }
            if (LuckyMoneyPrepareUI.this.mController.contentView.getVisibility() == 8 || LuckyMoneyPrepareUI.this.mController.contentView.getVisibility() == 4) {
                C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
                LuckyMoneyPrepareUI.this.finish();
            }
            LuckyMoneyPrepareUI.this.ocz.bLz();
            AppMethodBeat.m2505o(42943);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$41 */
    class C2124641 implements C5015a {
        C2124641() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            double d;
            AppMethodBeat.m2504i(42991);
            if (LuckyMoneyPrepareUI.this.obC.bKW() == 3 || LuckyMoneyPrepareUI.this.nTd.bKW() == 3) {
                d = 0.0d;
            } else {
                int input = LuckyMoneyPrepareUI.this.nTd.getInput();
                d = LuckyMoneyPrepareUI.this.obC.getInput();
                if (LuckyMoneyPrepareUI.this.mType == 0) {
                    d *= (double) input;
                }
            }
            if (d == 0.0d || d > LuckyMoneyPrepareUI.this.nSs.nRR || LuckyMoneyPrepareUI.this.nTn.bMz()) {
                LuckyMoneyPrepareUI.this.nTg.setClickable(false);
                LuckyMoneyPrepareUI.this.nTg.setEnabled(false);
            } else {
                LuckyMoneyPrepareUI.this.nTg.setClickable(true);
                LuckyMoneyPrepareUI.this.nTg.setEnabled(true);
            }
            C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d + ", hasErr=" + LuckyMoneyPrepareUI.this.nTn.bMz());
            LuckyMoneyPrepareUI.this.gGo.doT();
            AppMethodBeat.m2505o(42991);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$42 */
    class C2124742 implements OnTouchListener {
        C2124742() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(42992);
            if (motionEvent.getAction() == 0) {
                LuckyMoneyPrepareUI.this.aoB();
                LuckyMoneyPrepareUI.this.aqX();
            }
            AppMethodBeat.m2505o(42992);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$4 */
    class C212484 implements OnMenuItemClickListener {
        C212484() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(42944);
            LuckyMoneyPrepareUI.m77130u(LuckyMoneyPrepareUI.this);
            AppMethodBeat.m2505o(42944);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$40 */
    class C2479140 extends C24019s {
        C2479140() {
        }

        public final void bgW() {
            AppMethodBeat.m2504i(42990);
            LuckyMoneyPrepareUI.this.oec = new C9499aa();
            LuckyMoneyPrepareUI.this.oec.cVT = 6;
            LuckyMoneyPrepareUI.this.oec.ajK();
            LuckyMoneyPrepareUI.m77117i(LuckyMoneyPrepareUI.this);
            AppMethodBeat.m2505o(42990);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$18 */
    class C2845018 extends C4884c<C42047qq> {

        /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$18$2 */
        class C212432 implements OnClickListener {
            C212432() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(42959);
                LuckyMoneyPrepareUI.this.ohG = false;
                AppMethodBeat.m2505o(42959);
            }
        }

        C2845018() {
            AppMethodBeat.m2504i(42960);
            this.xxI = C42047qq.class.getName().hashCode();
            AppMethodBeat.m2505o(42960);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(42961);
            final C29628a c29628a = ((C42047qq) c4883b).cMN.cMO;
            if (c29628a != null && c29628a.cPa()) {
                C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "show 261 alert item");
                LuckyMoneyPrepareUI.this.ohG = true;
                C30379h.m48466d(LuckyMoneyPrepareUI.this.mController.ylL, c29628a.cEh, "", c29628a.nZc, c29628a.nZb, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(42958);
                        C4990ab.m7417i("MicroMsg.LuckyMoneyPrepareUI", "goto h5: %s", c29628a.kCs);
                        C36391e.m60016n(LuckyMoneyPrepareUI.this.mController.ylL, c29628a.kCs, false);
                        LuckyMoneyPrepareUI.this.ohG = false;
                        AppMethodBeat.m2505o(42958);
                    }
                }, new C212432());
            }
            AppMethodBeat.m2505o(42961);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$22 */
    class C2845222 implements C34503a {
        C2845222() {
        }

        public final void bMl() {
            AppMethodBeat.m2504i(42966);
            LuckyMoneyPrepareUI.m77101a(LuckyMoneyPrepareUI.this);
            AppMethodBeat.m2505o(42966);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$5 */
    class C284565 implements OnMenuItemClickListener {
        C284565() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(42945);
            if (LuckyMoneyPrepareUI.this.nSs == null || C5046bo.isNullOrNil(LuckyMoneyPrepareUI.this.nSs.nWK)) {
                C36391e.m60016n(LuckyMoneyPrepareUI.this.mController.ylL, "https://hkwallet.moneydata.hk/hybrid/www/weixin/hongbao_hk_v2/zh_hk/faq.shtml", false);
            } else {
                C36391e.m60016n(LuckyMoneyPrepareUI.this.mController.ylL, LuckyMoneyPrepareUI.this.nSs.nWK, false);
            }
            AppMethodBeat.m2505o(42945);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$6 */
    class C284576 implements View.OnClickListener {
        C284576() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42947);
            C4990ab.m7410d("MicroMsg.LuckyMoneyPrepareUI", "click envelope layout");
            final Dialog er = C46063x.m85818er(LuckyMoneyPrepareUI.this.mController.ylL);
            C46061f bLp = C46061f.bLp();
            bLp.mo70317b(new C46059c(""));
            bLp.mo70316a(new C40926a<aoj>() {
                /* renamed from: bX */
                public final /* synthetic */ void mo9356bX(Object obj) {
                    AppMethodBeat.m2504i(42946);
                    aoj aoj = (aoj) obj;
                    if (er != null && er.isShowing()) {
                        er.dismiss();
                    }
                    C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "do get show source net callback");
                    if (aoj != null) {
                        C4990ab.m7417i("MicroMsg.LuckyMoneyPrepareUI", "retcode: %s", Integer.valueOf(aoj.kCl));
                        if (aoj.kCl == 0) {
                            Intent intent = new Intent(LuckyMoneyPrepareUI.this.mController.ylL, LuckyMoneyPickEnvelopeUI.class);
                            try {
                                intent.putExtra(C5499f.yfY, aoj.toByteArray());
                            } catch (Exception e) {
                                C4990ab.printErrStackTrace("MicroMsg.LuckyMoneyPrepareUI", e, "", new Object[0]);
                            }
                            LuckyMoneyPrepareUI.this.startActivityForResult(intent, 5);
                            LuckyMoneyPrepareUI.this.ohp.setVisibility(8);
                            C16112c.m24429PK().mo28554c(C5127a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_STRING_SYNC, C5127a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_HOME_STRING_SYNC);
                            AppMethodBeat.m2505o(42946);
                            return;
                        }
                        C36391e.atC(aoj.kCm);
                        AppMethodBeat.m2505o(42946);
                        return;
                    }
                    C36391e.m59994aj(LuckyMoneyPrepareUI.this.mController.ylL, "");
                    AppMethodBeat.m2505o(42946);
                }

                /* renamed from: bY */
                public final /* bridge */ /* synthetic */ void mo9357bY(Object obj) {
                }
            });
            C7060h.pYm.mo8381e(16822, Integer.valueOf(1));
            AppMethodBeat.m2505o(42947);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$12 */
    class C3449712 implements View.OnClickListener {
        C3449712() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42952);
            LuckyMoneyPrepareUI.m77101a(LuckyMoneyPrepareUI.this);
            AppMethodBeat.m2505o(42952);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$27 */
    class C3450127 implements Runnable {
        C3450127() {
        }

        public final void run() {
            AppMethodBeat.m2504i(42972);
            LuckyMoneyPrepareUI.this.nTf.setHintText(LuckyMoneyPrepareUI.this.ohs);
            AppMethodBeat.m2505o(42972);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$28 */
    class C3450228 implements View.OnClickListener {
        C3450228() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42973);
            C7060h.pYm.mo8381e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.m77115g(LuckyMoneyPrepareUI.this)), Integer.valueOf(9));
            Intent intent = new Intent();
            intent.setClass(LuckyMoneyPrepareUI.this.mController.ylL, LuckyMoneyCanShareListUI.class);
            LuckyMoneyPrepareUI.this.startActivity(intent);
            AppMethodBeat.m2505o(42973);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$25 */
    class C3933925 implements OnClickListener {
        C3933925() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$7 */
    class C393417 implements OnClickListener {
        C393417() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$30 */
    class C4327030 implements C17917a {
        C4327030() {
        }

        /* renamed from: a */
        public final void mo7169a(C8955k c8955k) {
            AppMethodBeat.m2504i(42975);
            C4990ab.m7417i("MicroMsg.LuckyMoneyPrepareUI", "[onSelectedEmoji] emojiInfo:%s", c8955k);
            LuckyMoneyPrepareUI.this.kZa = C42952j.getEmojiStorageMgr().xYn.aqi(c8955k.mo20410Aq());
            LuckyMoneyPrepareUI.m77106b(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.this.kZa);
            LuckyMoneyPrepareUI.m77101a(LuckyMoneyPrepareUI.this);
            AppMethodBeat.m2505o(42975);
        }

        public final void onHide() {
            AppMethodBeat.m2504i(138991);
            LuckyMoneyPrepareUI.m77101a(LuckyMoneyPrepareUI.this);
            AppMethodBeat.m2505o(138991);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$32 */
    class C4327232 implements View.OnClickListener {
        C4327232() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42979);
            LuckyMoneyPrepareUI.this.obD.setVisibility(8);
            LuckyMoneyPrepareUI.this.bMp();
            AppMethodBeat.m2505o(42979);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$9 */
    class C432739 implements C5279d {
        C432739() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(42949);
            if (i == 0) {
                Intent intent = new Intent();
                intent.setClass(LuckyMoneyPrepareUI.this.mController.ylL, LuckyMoneyMyRecordUI.class);
                intent.putExtra("key_type", 2);
                LuckyMoneyPrepareUI.this.startActivity(intent);
                AppMethodBeat.m2505o(42949);
                return;
            }
            if (i == 1) {
                C7060h.pYm.mo8381e(15511, Integer.valueOf(LuckyMoneyPrepareUI.this.ohq), Integer.valueOf(1));
                if (LuckyMoneyPrepareUI.this.ohq == 1) {
                    C36391e.m60016n(LuckyMoneyPrepareUI.this.mController.ylL, "https://kf.qq.com/touch/scene_product.html?scene_id=kf7", false);
                    AppMethodBeat.m2505o(42949);
                    return;
                }
                String str = "MicroMsg.LuckyMoneyPrepareUI";
                String str2 = "show qa foreign, config url: %s";
                Object[] objArr = new Object[1];
                objArr[0] = LuckyMoneyPrepareUI.this.nSs != null ? LuckyMoneyPrepareUI.this.nSs.nWK : "";
                C4990ab.m7417i(str, str2, objArr);
                if (LuckyMoneyPrepareUI.this.nSs == null || C5046bo.isNullOrNil(LuckyMoneyPrepareUI.this.nSs.nWK)) {
                    C36391e.m60016n(LuckyMoneyPrepareUI.this.mController.ylL, "https://hkwallet.moneydata.hk/hybrid/www/weixin/hongbao_hk_v2/zh_hk/faq.shtml", false);
                } else {
                    C36391e.m60016n(LuckyMoneyPrepareUI.this.mController.ylL, LuckyMoneyPrepareUI.this.nSs.nWK, false);
                    AppMethodBeat.m2505o(42949);
                    return;
                }
            }
            AppMethodBeat.m2505o(42949);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$1 */
    class C432751 implements OnMenuItemClickListener {
        C432751() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(42941);
            LuckyMoneyPrepareUI.this.finish();
            AppMethodBeat.m2505o(42941);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$31 */
    class C4327731 implements View.OnClickListener {

        /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$31$1 */
        class C432711 implements Runnable {
            C432711() {
            }

            public final void run() {
                AppMethodBeat.m2504i(42977);
                LuckyMoneyPrepareUI.this.obD.setVisibility(8);
                LuckyMoneyPrepareUI.this.bMp();
                AppMethodBeat.m2505o(42977);
            }
        }

        C4327731() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42978);
            C7060h.pYm.mo8381e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.m77115g(LuckyMoneyPrepareUI.this)), Integer.valueOf(6));
            C46063x.m85804a(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.this.mType, LuckyMoneyPrepareUI.this.obI, true);
            LuckyMoneyPrepareUI.this.obD.postDelayed(new C432711(), 100);
            AppMethodBeat.m2505o(42978);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$8 */
    class C432798 implements C36073c {
        C432798() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(42948);
            c44273l.add(0, 0, 0, LuckyMoneyPrepareUI.this.getString(C25738R.string.cqc));
            c44273l.add(0, 1, 0, LuckyMoneyPrepareUI.this.getString(C25738R.string.fg9));
            AppMethodBeat.m2505o(42948);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public LuckyMoneyPrepareUI() {
        AppMethodBeat.m2504i(42993);
        AppMethodBeat.m2505o(42993);
    }

    /* renamed from: g */
    static /* synthetic */ int m77115g(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        AppMethodBeat.m2504i(43022);
        int bMh = luckyMoneyPrepareUI.bMh();
        AppMethodBeat.m2505o(43022);
        return bMh;
    }

    /* renamed from: x */
    static /* synthetic */ void m77133x(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        AppMethodBeat.m2504i(43025);
        luckyMoneyPrepareUI.m77135yj(1);
        AppMethodBeat.m2505o(43025);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(42994);
        super.onCreate(bundle);
        mo17446xE(getResources().getColor(C25738R.color.f12150u4));
        mo17373Nc(WebView.NIGHT_MODE_COLOR);
        dyb();
        this.mType = getIntent().getIntExtra("key_type", 1);
        this.obG = getIntent().getIntExtra("key_way", 3);
        this.emC = getIntent().getIntExtra("key_from", 0);
        this.obJ = this.emC == 1;
        this.obL = getIntent().getIntExtra("pay_channel", -1);
        m77118iN(false);
        C6964a.bKN();
        this.nSs = C6964a.bKO().bLu();
        C6964a.bKN();
        this.nWN = C6964a.bKO().bLv();
        C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "mInWay:" + this.obG + "mChannel:" + this.obL);
        C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.obJ + ", config " + this.nSs);
        initView();
        C4879a.xxA.mo10051b(this.ohH);
        C7060h.pYm.mo8381e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bMh()), Integer.valueOf(1));
        AppMethodBeat.m2505o(42994);
    }

    public void onResume() {
        AppMethodBeat.m2504i(42995);
        super.onResume();
        mo24305nf(1970);
        AppMethodBeat.m2505o(42995);
    }

    public void onStop() {
        AppMethodBeat.m2504i(42996);
        super.onStop();
        mo24306ng(1970);
        AppMethodBeat.m2505o(42996);
    }

    public final void initView() {
        AppMethodBeat.m2504i(42997);
        setBackBtn(new C432751());
        this.obD = findViewById(2131825633);
        this.obE = findViewById(2131825638);
        this.leS = (Button) findViewById(2131825637);
        this.nTf = (LuckyMoneyTextInputView) findViewById(2131825621);
        this.nTf.setHintText(getString(C25738R.string.cqe));
        this.nTg = (Button) findViewById(2131825630);
        this.mKeyboard = (MyKeyboardWindow) findViewById(2131822357);
        this.nTi = findViewById(2131822356);
        this.kGq = (TextView) findViewById(2131825618);
        this.nTd = (LuckyMoneyNumInputView) findViewById(2131825619);
        this.obC = (LuckyMoneyMoneyInputView) findViewById(2131825617);
        this.kGm = (TextView) findViewById(2131825629);
        this.obF = (ViewGroup) findViewById(2131825632);
        this.nTk = (MMScrollView) findViewById(2131825615);
        this.nTl = (TextView) findViewById(2131825616);
        this.ohm = (RelativeLayout) findViewById(2131825622);
        this.ohn = (TextView) findViewById(2131825628);
        this.oho = (ImageView) findViewById(2131825624);
        this.ohp = (TextView) findViewById(2131825626);
        this.odS = new C46064a(this);
        this.odT = getLayoutInflater().inflate(2130969978, null);
        this.odS.setContentView(this.odT, new LayoutParams(-1, -1));
        this.odT.findViewById(2131825497).setOnClickListener(new C3449712());
        this.odS.obT = new C2845222();
        this.oea = (ViewGroup) this.odT.findViewById(2131825499);
        this.odY = C44081e.vom.mo35682dF(this.mController.ylL);
        C28459a.m45138a(this.odY);
        if (this.mType == 1) {
            setMMTitle((int) C25738R.string.cr6);
            this.obC.setTitle(getString(C25738R.string.cto));
            this.obC.setShowGroupIcon(true);
        } else {
            setMMTitle((int) C25738R.string.crz);
            this.obC.setTitle(getString(C25738R.string.ctp));
            this.obC.setShowGroupIcon(false);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, C1338a.m2856al(this, C25738R.dimen.a4p));
        if (this.mType == 1) {
            layoutParams.topMargin = C1338a.fromDPToPix(this.mController.ylL, 13);
            layoutParams2.topMargin = C1338a.fromDPToPix(this.mController.ylL, 13);
        } else {
            layoutParams.topMargin = C1338a.fromDPToPix(this.mController.ylL, 16);
            layoutParams2.topMargin = C1338a.fromDPToPix(this.mController.ylL, 16);
        }
        this.nTf.setLayoutParams(layoutParams);
        this.ohm.setLayoutParams(layoutParams2);
        this.obC.setOnInputValidChangerListener(this);
        this.obC.setHint(getString(C25738R.string.crl));
        this.nTd.setOnInputValidChangerListener(this);
        this.nTd.setHint(getString(C25738R.string.cs1));
        this.nTf.setOnInputValidChangerListener(this);
        final EditText editText = (EditText) this.obC.findViewById(2131825536);
        final EditText editText2 = (EditText) this.nTd.findViewById(2131825536);
        C36391e.setNoSystemInputOnEditText(editText);
        ((InputMethodManager) this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
        editText.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.m2504i(42950);
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 3) {
                    editable.delete(indexOf + 3, length);
                } else if (indexOf > 6) {
                    editable.delete(6, indexOf);
                } else if (indexOf == -1 && length > 6) {
                    editable.delete(6, length);
                }
                editText.setContentDescription(editable.toString());
                AppMethodBeat.m2505o(42950);
            }
        });
        editText2.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.m2504i(42951);
                editText2.setContentDescription(editable.toString());
                AppMethodBeat.m2505o(42951);
            }
        });
        editText.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(42953);
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                LuckyMoneyPrepareUI.this.mo68812V(LuckyMoneyPrepareUI.this.obC, 2);
                LuckyMoneyPrepareUI.this.mo68812V(LuckyMoneyPrepareUI.this.nTd, 0);
                LuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
                LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                LuckyMoneyPrepareUI.this.nTi.setVisibility(0);
                AppMethodBeat.m2505o(42953);
            }
        });
        editText.requestFocus();
        TextView textView = (TextView) this.obC.findViewById(2131825537);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(42954);
                    editText.setOnClickListener(null);
                    editText2.setOnClickListener(null);
                    LuckyMoneyPrepareUI.this.mo68812V(LuckyMoneyPrepareUI.this.obC, 2);
                    LuckyMoneyPrepareUI.this.mo68812V(LuckyMoneyPrepareUI.this.nTd, 0);
                    LuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
                    LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(editText);
                    LuckyMoneyPrepareUI.this.nTi.setVisibility(0);
                    AppMethodBeat.m2505o(42954);
                }
            });
        }
        C36391e.setNoSystemInputOnEditText(editText2);
        ((InputMethodManager) this.mController.ylL.getSystemService("input_method")).showSoftInput(editText2, 0);
        editText2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(42955);
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                LuckyMoneyPrepareUI.this.mo68812V(LuckyMoneyPrepareUI.this.obC, 2);
                LuckyMoneyPrepareUI.this.mo68812V(LuckyMoneyPrepareUI.this.nTd, 0);
                LuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
                LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                LuckyMoneyPrepareUI.this.nTi.setVisibility(0);
                AppMethodBeat.m2505o(42955);
            }
        });
        ((MMEditText) this.nTf.findViewById(2131825665)).setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.m2504i(42956);
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                LuckyMoneyPrepareUI.this.mo68812V(LuckyMoneyPrepareUI.this.obC, 2);
                LuckyMoneyPrepareUI.this.mo68812V(LuckyMoneyPrepareUI.this.nTd, 0);
                AppMethodBeat.m2505o(42956);
            }
        });
        if (this.nSs != null) {
            if (this.mType == 1) {
                this.obC.setMaxAmount(this.nSs.nRR);
            } else {
                this.obC.setMaxAmount(this.nSs.nRP);
            }
            this.obC.setMinAmount(this.nSs.nRQ);
            if (this.nSs.kCv != 1) {
                m77113eX(this.nSs.nRU, this.nSs.nRT);
            }
        }
        if (!this.obJ || getIntent().getIntExtra("key_chatroom_num", 0) > 1) {
            this.nTd.setNum("");
        } else {
            this.nTd.setNum("1");
        }
        this.nTd.setMaxNum(this.nSs.nRO);
        this.nTd.setMinNum(1);
        C4990ab.m7410d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.nTd.getInput());
        this.obC.setMaxLen(12);
        if (bML()) {
            this.nTg.setText(getString(C25738R.string.csl, new Object[]{this.nSs.nWL}));
        }
        if (this.obJ || this.emC == 2) {
            if (bML()) {
                setMMTitle(getString(C25738R.string.ctm, new Object[]{this.nSs.nWL}));
            } else {
                setMMTitle((int) C25738R.string.ctl);
            }
            int intExtra = getIntent().getIntExtra("key_chatroom_num", 0);
            if (this.obJ && intExtra == 0) {
                C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "single hb");
                this.nTd.setVisibility(8);
            } else {
                String str;
                String string = getString(C25738R.string.cqu);
                String string2 = getString(C25738R.string.cr9);
                String string3 = getString(C25738R.string.cqo);
                String string4 = getString(C25738R.string.cr_);
                if (!this.obJ || intExtra <= 0) {
                    if (this.emC == 2) {
                        C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "f2f hb");
                        this.nTf.setVisibility(8);
                    }
                    str = string;
                } else {
                    C4990ab.m7417i("MicroMsg.LuckyMoneyPrepareUI", "group hb,%d people", Integer.valueOf(intExtra));
                    str = getString(C25738R.string.crb);
                    string = getString(C25738R.string.cra);
                    TextView textView2 = (TextView) findViewById(2131825620);
                    textView2.setText(getString(C25738R.string.cs0, new Object[]{Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8))}));
                    textView2.setVisibility(0);
                    string3 = string;
                }
                final C46373j c46373j = new C46373j(this);
                c46373j.mColor = getResources().getColor(C25738R.color.f12160ue);
                final SpannableString spannableString = new SpannableString(str + string2);
                spannableString.setSpan(c46373j, str.length(), str.length() + string2.length(), 33);
                final SpannableString spannableString2 = new SpannableString(string3 + string4);
                final C46373j c46373j2 = new C46373j(this);
                c46373j2.mColor = getResources().getColor(C25738R.color.f12160ue);
                spannableString2.setSpan(c46373j2, string3.length(), string3.length() + string4.length(), 33);
                this.obC.setGroupIconIv(C25738R.drawable.b9t);
                c46373j.tHw = new C29672a() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(42980);
                        int input = LuckyMoneyPrepareUI.this.nTd.getInput();
                        double input2 = LuckyMoneyPrepareUI.this.obC.getInput();
                        LuckyMoneyPrepareUI.this.mType = 0;
                        LuckyMoneyPrepareUI.this.obC.setType(LuckyMoneyPrepareUI.this.mType);
                        LuckyMoneyPrepareUI.this.obC.setShowGroupIcon(false);
                        LuckyMoneyPrepareUI.this.obC.setTitle(LuckyMoneyPrepareUI.this.getString(C25738R.string.ctp));
                        if (input2 > 0.0d && input > 0) {
                            LuckyMoneyPrepareUI.this.obC.setAmount(C36391e.m59971F(input2 / ((double) input)));
                        }
                        LuckyMoneyPrepareUI.this.obC.setMaxAmount(LuckyMoneyPrepareUI.this.nSs.nRP);
                        LuckyMoneyPrepareUI.this.kGq.setText(spannableString2);
                        C7060h.pYm.mo8381e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.m77115g(LuckyMoneyPrepareUI.this)), Integer.valueOf(3));
                        AppMethodBeat.m2505o(42980);
                    }
                };
                c46373j2.tHw = new C29672a() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(42988);
                        int input = LuckyMoneyPrepareUI.this.nTd.getInput();
                        double input2 = LuckyMoneyPrepareUI.this.obC.getInput();
                        LuckyMoneyPrepareUI.this.mType = 1;
                        LuckyMoneyPrepareUI.this.obC.setType(LuckyMoneyPrepareUI.this.mType);
                        LuckyMoneyPrepareUI.this.obC.setMaxAmount(LuckyMoneyPrepareUI.this.nSs.nRR);
                        LuckyMoneyPrepareUI.this.obC.setTitle(LuckyMoneyPrepareUI.this.getString(C25738R.string.cto));
                        LuckyMoneyPrepareUI.this.obC.setShowGroupIcon(true);
                        if (input2 > 0.0d && input > 0) {
                            LuckyMoneyPrepareUI.this.obC.setAmount(C36391e.m59971F(input2 * ((double) input)));
                        }
                        LuckyMoneyPrepareUI.this.kGq.setText(spannableString);
                        C7060h.pYm.mo8381e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.m77115g(LuckyMoneyPrepareUI.this)), Integer.valueOf(2));
                        AppMethodBeat.m2505o(42988);
                    }
                };
                this.kGq.setMovementMethod(LinkMovementMethod.getInstance());
                if (C5215a.yqY.dzj()) {
                    this.kGq.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(42989);
                            if (!C5215a.yqY.dzj()) {
                                AppMethodBeat.m2505o(42989);
                            } else if (LuckyMoneyPrepareUI.this.kGq.getText().toString().equals(spannableString.toString())) {
                                c46373j.onClick(view);
                                AppMethodBeat.m2505o(42989);
                            } else {
                                c46373j2.onClick(view);
                                AppMethodBeat.m2505o(42989);
                            }
                        }
                    });
                }
                this.kGq.setTextColor(getResources().getColor(C25738R.color.f11785h7));
                this.kGq.setText(spannableString);
                this.kGq.setVisibility(0);
            }
        } else if (this.mType == 1) {
            this.kGq.setText(this.nSs.nWH);
            this.kGq.setVisibility(0);
        } else if (this.mType == 0) {
            this.kGq.setText(this.nSs.nWI);
            this.kGq.setVisibility(0);
        }
        this.nTg.setOnClickListener(new C2479140());
        this.nTn.mo68830a(this.nTd);
        this.nTn.mo68830a(this.obC);
        this.nTn.mo68830a(this.nTf);
        this.nTn.mo68834i((TextView) findViewById(2131825639));
        this.gGo = new C7564ap(new C2124641(), false);
        if (this.nTk != null) {
            this.nTk.setOnTouchListener(new C2124742());
        }
        this.obC.setType(this.mType);
        init();
        this.ohm.setOnClickListener(new C284576());
        if (C16112c.m24429PK().mo28546a(C5127a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_STRING_SYNC, C5127a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_HOME_STRING_SYNC)) {
            this.ohp.setVisibility(0);
        }
        if (this.nWN != null) {
            m77102a(this.nWN.nWu);
        }
        AppMethodBeat.m2505o(42997);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(42998);
        finish();
        AppMethodBeat.m2505o(42998);
    }

    /* renamed from: yj */
    private void m77135yj(int i) {
        AppMethodBeat.m2504i(42999);
        C4990ab.m7417i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick() userConfirmJump:%s", Integer.valueOf(i));
        C7060h.pYm.mo8381e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bMh()), Integer.valueOf(4));
        C7060h.pYm.mo8381e(15511, Integer.valueOf(this.ohq), Integer.valueOf(2));
        if (this.obC.bKW() != 0) {
            C23639t.makeText(this.mController.ylL, C25738R.string.f9y, 0).show();
            AppMethodBeat.m2505o(42999);
            return;
        }
        long H;
        int input = this.nTd.getInput();
        double input2 = this.obC.getInput();
        long j = 0;
        if (this.mType == 1) {
            H = C36391e.m59973H(input2);
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(356354, Integer.valueOf(input));
        } else {
            H = C36391e.m59973H(((double) input) * input2);
            j = C36391e.m59973H(input2);
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(356353, Integer.valueOf(input));
        }
        String replace = this.nTf.getInput().replace("\r", "").replace(IOUtils.LINE_SEPARATOR_UNIX, "");
        if (C5046bo.isNullOrNil(replace)) {
            replace = C5046bo.isNullOrNil(this.ohs) ? getString(C25738R.string.cqe) : this.ohs;
        }
        aoB();
        if (this.emC == 2) {
            mo24301b(new C21195d(input, (int) H, this.mType, (int) j), false);
        } else {
            String stringExtra = getIntent().getStringExtra("key_username");
            if (this.ohq == 1) {
                C4990ab.m7417i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick() ifGetConfig=%s mUniqueId=%s waitingGetConfig=%s ifAutoRMBPrePareBtn=%s", Boolean.valueOf(this.ohD), C5046bo.nullAsNil(this.ogi), Boolean.valueOf(this.ohE), Boolean.valueOf(this.ohF));
                if (this.ohD) {
                    m77100a(i, stringExtra, input, H, j, replace);
                    AppMethodBeat.m2505o(42999);
                    return;
                }
                this.ohF = true;
                this.ohw = i;
                this.ohx = stringExtra;
                this.ohy = input;
                this.ohz = H;
                this.ohA = j;
                this.ohB = replace;
                if (this.ohl != null) {
                    this.ohl.show();
                } else {
                    this.ohl = C30379h.m48426a((Context) this, 3, (int) C25738R.style.f10970kd, getString(C25738R.string.cn5), true, new C212442());
                }
                if (!this.ohE) {
                    m77118iN(false);
                }
                AppMethodBeat.m2505o(42999);
                return;
            }
            C1207m c3382ah;
            C4990ab.m7417i("MicroMsg.LuckyMoneyPrepareUI", "currency=%s userConfiremJump:%s", Integer.valueOf(this.ohq), Integer.valueOf(i));
            mo24305nf(1647);
            if (!this.obJ || C5046bo.isNullOrNil(stringExtra)) {
                c3382ah = new C3382ah(input, H, j, this.mType, replace, null, C46063x.bLC(), C1853r.m3846Yz(), this.ohq);
            } else {
                c3382ah = new C3382ah(input, H, j, this.mType, replace, stringExtra, C46063x.bLC(), C1853r.m3846Yz(), this.ohq);
            }
            mo24301b(c3382ah, false);
        }
        bMK();
        AppMethodBeat.m2505o(42999);
    }

    private void bMK() {
        AppMethodBeat.m2504i(43000);
        if (this.gII != null) {
            this.gII.show();
            AppMethodBeat.m2505o(43000);
            return;
        }
        this.gII = C30901g.m49317a(this.mController.ylL, true, new C212453());
        AppMethodBeat.m2505o(43000);
    }

    /* renamed from: a */
    private void m77100a(int i, String str, int i2, long j, long j2, String str2) {
        C1207m c12426ao;
        AppMethodBeat.m2504i(43001);
        String str3 = "";
        int i3 = 0;
        if (this.kZa != null) {
            str3 = this.kZa.mo20410Aq();
            i3 = this.kZa.field_type;
        }
        String str4 = "";
        if (this.nWN != null) {
            str4 = this.nWN.nWv;
        }
        C4990ab.m7417i("MicroMsg.LuckyMoneyPrepareUI", "currency is RMB. userConfirmJump:%s lastPayResult:%s mSendId:%s mUniqueId:%s", Integer.valueOf(i), Integer.valueOf(this.cKs), this.ocI, this.ogi);
        if (!this.obJ || C5046bo.isNullOrNil(str)) {
            c12426ao = new C12426ao(i2, j, j2, this.mType, str2, C46063x.bLC(), null, null, C1853r.m3846Yz(), C1853r.m3820YB(), this.obG, str4, this.ogi, i, this.cKs, this.ocI, str3, i3);
        } else {
            c12426ao = new C12426ao(i2, j, j2, this.mType, str2, C46063x.bLC(), str, C46063x.m85824mI(str), C1853r.m3846Yz(), C1853r.m3820YB(), this.obG, str4, this.ogi, i, this.cKs, this.ocI, str3, i3);
        }
        mo24301b(c12426ao, false);
        if (!C5046bo.isNullOrNil(str4)) {
            C7060h.pYm.mo15419k(991, 11, 1);
        }
        bMK();
        AppMethodBeat.m2505o(43001);
    }

    private void init() {
        AppMethodBeat.m2504i(43002);
        if (this.ohq == 1) {
            addIconOptionMenu(0, C25738R.drawable.f6899uu, new C212484());
            AppMethodBeat.m2505o(43002);
            return;
        }
        addIconOptionMenu(0, C25738R.drawable.f6835sc, new C284565());
        AppMethodBeat.m2505o(43002);
    }

    /* renamed from: a */
    private void m77102a(atb atb) {
        AppMethodBeat.m2504i(43003);
        C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "update envelope");
        if (this.nWN == null || atb == null || this.emC == 2) {
            this.ohm.setVisibility(8);
        } else {
            this.ohm.setVisibility(0);
            if (this.nWN.nWw && !C5046bo.isNullOrNil(this.nWN.nWx)) {
                List<String> hT = C5046bo.m7569hT((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LUCKY_MONEY_ENVELOPE_ILLEGAL_STRING_SYNC, (Object) ""), ",");
                for (String equals : hT) {
                    if (equals.equals(this.nWN.nWu.materialId)) {
                        C4990ab.m7411d("MicroMsg.LuckyMoneyPrepareUI", "has alert illegal: %s", (String) r2.next());
                        AppMethodBeat.m2505o(43003);
                        return;
                    }
                }
                hT.add(this.nWN.nWu.materialId);
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LUCKY_MONEY_ENVELOPE_ILLEGAL_STRING_SYNC, C5046bo.m7536c((List) hT, ","));
                C4990ab.m7417i("MicroMsg.LuckyMoneyPrepareUI", "show alert illegal: %s", this.nWN.nWu.materialId);
                C30379h.m48443a(this.mController.ylL, this.nWN.nWx, "", getString(C25738R.string.g0z), new C393417());
            }
        }
        if (atb == null || C5046bo.isNullOrNil(atb.wwP)) {
            this.oho.setImageBitmap(null);
            this.ohn.setText("");
            AppMethodBeat.m2505o(43003);
            return;
        }
        this.ohn.setText(atb.wwP);
        ((C12405a) C1720g.m3528K(C12405a.class)).mo24254a(this.oho, atb);
        AppMethodBeat.m2505o(43003);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(43004);
        super.onDestroy();
        this.nTn.clear();
        this.gGo.doT();
        if (this.gII != null && this.gII.isShowing()) {
            this.gII.dismiss();
        }
        if (this.odY != null) {
            C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "commentfooter release");
            this.odY.onPause();
            this.odY.mo11686AC();
            this.odY.destroy();
        }
        C4879a.xxA.mo10053d(this.ohH);
        AppMethodBeat.m2505o(43004);
    }

    /* renamed from: iN */
    private void m77118iN(boolean z) {
        AppMethodBeat.m2504i(43005);
        C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "do get config");
        if (z) {
            this.ohk = C46063x.m85818er(this.mController.ylL);
        }
        this.ohE = true;
        mo24301b(new C3381ag("v1.0", ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LUCKY_MONEY_ENVELOPE_HAS_SOURCE_INT_SYNC, Integer.valueOf(0))).intValue(), (byte) 0), false);
        AppMethodBeat.m2505o(43005);
    }

    public final int getLayoutId() {
        return 2130969994;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(43006);
        if (keyEvent.getKeyCode() == 4 && this.obD.getVisibility() == 0) {
            this.obD.setVisibility(8);
            bMp();
            AppMethodBeat.m2505o(43006);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(43006);
        return dispatchKeyEvent;
    }

    /* renamed from: c */
    public final boolean mo7808c(int i, int i2, String str, final C1207m c1207m) {
        AppMethodBeat.m2504i(43007);
        C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "errType:" + i + " errCode:" + i2 + " errMsg:" + str + " scenetype:" + c1207m.getType());
        if (c1207m instanceof C12426ao) {
            if (this.gII != null && this.gII.isShowing()) {
                this.gII.dismiss();
            }
            if (this.ohG) {
                C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "has show alert return");
                AppMethodBeat.m2505o(43007);
                return true;
            }
            C12426ao c12426ao = (C12426ao) c1207m;
            if (i == 0 && i2 == 0) {
                this.obI = c12426ao.kCd;
                this.obH = c12426ao.nSX;
                this.obK = c12426ao.nYY;
                this.ocI = c12426ao.nSX;
                this.ohu = c12426ao.nZe;
                if (((C12426ao) c1207m).bLD()) {
                    C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() NetScenePrepareLuckyMoney show JumpRemind Alert");
                    ((C12426ao) c1207m).nYe.mo39947a((Activity) this, new C1245219());
                    AppMethodBeat.m2505o(43007);
                    return true;
                }
                PayInfo payInfo = new PayInfo();
                payInfo.czZ = c12426ao.nYX;
                payInfo.cIf = 37;
                payInfo.cIb = this.obL;
                C35899h.m58853a(this, payInfo, 1);
                AppMethodBeat.m2505o(43007);
                return true;
            } else if (i2 == 401) {
                this.nTg.setEnabled(false);
                this.nTg.setClickable(false);
                this.gGo.mo16770ae(5000, 5000);
                C30379h.m48465bQ(this, str);
                AppMethodBeat.m2505o(43007);
                return true;
            } else if (i2 == 268502454) {
                C30379h.m48438a((Context) this, str, "", new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(42964);
                        if (C12426ao.m20346m(c1207m)) {
                            LuckyMoneyPrepareUI.this.finish();
                            AppMethodBeat.m2505o(42964);
                            return;
                        }
                        AppMethodBeat.m2505o(42964);
                    }
                });
                AppMethodBeat.m2505o(43007);
                return true;
            } else {
                this.cKs = 2;
                if (TextUtils.isEmpty(str)) {
                    str = getString(C25738R.string.fu2);
                }
                C30379h.m48448a((Context) this, str, null, false, new C1245117());
                AppMethodBeat.m2505o(43007);
                return true;
            }
        }
        if (c1207m instanceof C21198ar) {
            if (i == 0 && i2 == 0) {
                if (this.obJ) {
                    C5670b.m8523i(this, getString(C25738R.string.cbn));
                    C5004al.m7442n(new C1245321(), 1800);
                } else {
                    bMq();
                    this.obE.setVisibility(0);
                    this.obE.postDelayed(new C342523(), 1000);
                }
                AppMethodBeat.m2505o(43007);
                return true;
            } else if (i2 == 402) {
                C30379h.m48466d(this.mController.ylL, str, "", getString(C25738R.string.ct5), getString(C25738R.string.f9076or), new C1245424(), new C3933925());
                AppMethodBeat.m2505o(43007);
                return true;
            }
        } else if (c1207m instanceof C3381ag) {
            C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig resp,errType=" + i + ";errCode=" + i2 + ";errMsg=" + str);
            if (this.ohk != null && this.ohk.isShowing()) {
                this.ohk.dismiss();
            }
            if (this.ohl != null && this.ohl.isShowing()) {
                this.ohl.dismiss();
            }
            if (i == 0 && i2 == 0) {
                final C3381ag c3381ag = (C3381ag) c1207m;
                this.ohD = true;
                this.nYN = c3381ag.nYN;
                if (C5046bo.m7563gW(c3381ag.nYO, 1)) {
                    this.nTf.mo68823iO(false);
                    if (!(this.kZa == null || C5046bo.isNullOrNil(this.kZa.mo20410Aq()))) {
                        this.nTf.mo68828z(this.kZa);
                    }
                    this.nTf.setmOnEmojiSelectClickListener(new View.OnClickListener() {

                        /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$26$2 */
                        class C284532 implements C5279d {
                            C284532() {
                            }

                            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                AppMethodBeat.m2504i(42970);
                                C4990ab.m7417i("MicroMsg.LuckyMoneyPrepareUI", "showLuckyHbDlg() onMMMenuItemSelected menuItemId:%s", Integer.valueOf(menuItem.getItemId()));
                                switch (menuItem.getItemId()) {
                                    case 1:
                                        LuckyMoneyPrepareUI.this.oef = 1;
                                        C20423c.m31582h(LuckyMoneyPrepareUI.this, null, 4);
                                        LuckyMoneyPrepareUI.this.oec = new C9499aa();
                                        LuckyMoneyPrepareUI.this.oec.cVT = 4;
                                        LuckyMoneyPrepareUI.this.oec.ajK();
                                        AppMethodBeat.m2505o(42970);
                                        return;
                                    case 2:
                                        LuckyMoneyPrepareUI.this.oef = 2;
                                        LuckyMoneyPrepareUI.m77134y(LuckyMoneyPrepareUI.this);
                                        AppMethodBeat.m2505o(42970);
                                        return;
                                    case 3:
                                        LuckyMoneyPrepareUI.this.ogb = 1;
                                        LuckyMoneyTextInputView A = LuckyMoneyPrepareUI.this.nTf;
                                        A.ohX.setTag("");
                                        A.ohY.setVisibility(0);
                                        A.ohZ.setVisibility(8);
                                        LuckyMoneyPrepareUI.this.kZa = null;
                                        LuckyMoneyPrepareUI.this.oec = new C9499aa();
                                        LuckyMoneyPrepareUI.this.oec.cVT = 5;
                                        LuckyMoneyPrepareUI.this.oec.ajK();
                                        break;
                                }
                                AppMethodBeat.m2505o(42970);
                            }
                        }

                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(42971);
                            LuckyMoneyPrepareUI.this.oec = new C9499aa();
                            LuckyMoneyPrepareUI.this.oec.cVT = 2;
                            LuckyMoneyPrepareUI.this.oec.ajK();
                            final boolean C = C5046bo.m7500C(view.getTag(), "delete");
                            if (C || C5046bo.m7563gW(c3381ag.nYN, 1)) {
                                C16001d c16001d = new C16001d(LuckyMoneyPrepareUI.this.mController.ylL, 1, false);
                                c16001d.rBl = new C36073c() {
                                    /* renamed from: a */
                                    public final void mo5746a(C44273l c44273l) {
                                        AppMethodBeat.m2504i(42969);
                                        if (C) {
                                            c44273l.mo70048a(3, LuckyMoneyPrepareUI.this.getResources().getColor(C25738R.color.f12157ub), LuckyMoneyPrepareUI.this.mController.ylL.getString(C25738R.string.cqf));
                                            AppMethodBeat.m2505o(42969);
                                            return;
                                        }
                                        if (C5046bo.m7563gW(c3381ag.nYN, 1)) {
                                            c44273l.mo70072hi(1, C25738R.string.cry);
                                        }
                                        c44273l.mo70072hi(2, C25738R.string.csz);
                                        AppMethodBeat.m2505o(42969);
                                    }
                                };
                                c16001d.rBm = new C284532();
                                c16001d.cpD();
                                AppMethodBeat.m2505o(42971);
                                return;
                            }
                            LuckyMoneyPrepareUI.this.oef = 2;
                            LuckyMoneyPrepareUI.m77134y(LuckyMoneyPrepareUI.this);
                            AppMethodBeat.m2505o(42971);
                        }
                    });
                } else {
                    this.nTf.mo68823iO(true);
                }
                C6964a.bKN();
                this.nSs = C6964a.bKO().bLu();
                C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.nSs);
                if (this.mType == 1) {
                    this.obC.setMaxAmount(this.nSs.nRR);
                } else {
                    this.obC.setMaxAmount(this.nSs.nRP);
                }
                this.obC.setMinAmount(this.nSs.nRQ);
                this.nTd.setMaxNum(this.nSs.nRO);
                this.ohr = c3381ag.nRT;
                this.ohq = c3381ag.kCv;
                this.ohs = c3381ag.nSd;
                if (C5046bo.isNullOrNil(this.ogi)) {
                    this.ogi = c3381ag.few;
                }
                if (!(C5046bo.isNullOrNil(this.ohs) || this.nTf == null)) {
                    C5004al.m7441d(new C3450127());
                }
                if (c3381ag.nYE && this.obJ) {
                    TextView textView = (TextView) findViewById(2131825631);
                    textView.setOnClickListener(new C3450228());
                    C7060h.pYm.mo8381e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bMh()), Integer.valueOf(8));
                    textView.setVisibility(8);
                }
                if (C5046bo.isNullOrNil(c3381ag.kCx)) {
                    this.nTl.setVisibility(8);
                } else {
                    C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + c3381ag.kCx);
                    this.nTl.setText(c3381ag.kCx);
                    if (!C5046bo.isNullOrNil(c3381ag.nYG)) {
                        this.nTl.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(42974);
                                C36391e.m60016n(LuckyMoneyPrepareUI.this.mController.ylL, c3381ag.nYG, false);
                                AppMethodBeat.m2505o(42974);
                            }
                        });
                    }
                    this.nTl.setVisibility(0);
                }
                C21253c c21253c = new C21253c();
                if (c3381ag.nYI == null || C5046bo.isNullOrNil(c3381ag.nYI.content)) {
                    c21253c.textColor = getResources().getColor(C25738R.color.f12084rr);
                } else {
                    c21253c.textColor = getResources().getColor(C25738R.color.a4m);
                }
                this.obF.removeAllViews();
                C21249h.m32619a(this, this.obF, c3381ag.nYI, c21253c);
                m77113eX(c3381ag.nRU, c3381ag.nRT);
                m77108c(this.obC.getInput(), this.ohr);
                C6964a.bKN();
                this.nWN = C6964a.bKO().bLv();
                init();
                if (this.nWN != null) {
                    m77102a(this.nWN.nWu);
                    C7060h.pYm.mo15419k(991, 10, 1);
                } else {
                    m77102a(null);
                }
                if (this.ohF) {
                    C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "doRMBPrePareBtnClick()");
                    m77100a(this.ohw, this.ohx, this.ohy, this.ohz, this.ohA, this.ohB);
                }
            } else if (this.ohF) {
                CharSequence str2;
                if (C5046bo.isNullOrNil(str2)) {
                    str2 = getString(C25738R.string.f9111ps);
                }
                C23639t.makeText(this, str2, 0).show();
            }
            C4990ab.m7417i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig waitingGetConfig:%s ifAutoRMBPrePareBtn:%s", Boolean.valueOf(this.ohE), Boolean.valueOf(this.ohF));
            this.ohE = false;
            this.ohF = false;
            AppMethodBeat.m2505o(43007);
            return true;
        } else if (c1207m instanceof C3382ah) {
            mo24306ng(1647);
            if (this.gII != null && this.gII.isShowing()) {
                this.gII.hide();
            }
            if (i == 0 && i2 == 0) {
                String str3 = ((C3382ah) c1207m).kCI;
                if (C5046bo.isNullOrNil(str3)) {
                    C4990ab.m7412e("MicroMsg.LuckyMoneyPrepareUI", "payUrl is null");
                } else {
                    C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "payUrl is not null");
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str3);
                    intent.putExtra("showShare", false);
                    C25985d.m41468b((Context) this, "webview", ".ui.tools.WebViewUI", intent, 3);
                }
                AppMethodBeat.m2505o(43007);
                return true;
            }
        } else if (c1207m instanceof C21195d) {
            if (i == 0 && i2 == 0) {
                if (this.gII != null) {
                    this.gII.dismiss();
                }
                this.ocI = ((C21195d) c1207m).nSX;
                this.ohu = ((C21195d) c1207m).nUo;
                PayInfo payInfo2 = new PayInfo();
                payInfo2.czZ = ((C21195d) c1207m).czZ;
                payInfo2.cIf = 37;
                C44422ad.m80307o(37, payInfo2.czZ, i2);
                C35899h.m58853a(this, payInfo2, 4);
            } else {
                C44422ad.m80307o(37, "", i2);
                if (!C5046bo.isNullOrNil(str2)) {
                    C30379h.m48461b((Context) this, str2, getString(C25738R.string.cq5), true);
                }
                this.gII.dismiss();
            }
            AppMethodBeat.m2505o(43007);
            return true;
        } else if (c1207m instanceof C34443al) {
            AppMethodBeat.m2505o(43007);
            return true;
        }
        AppMethodBeat.m2505o(43007);
        return false;
    }

    /* renamed from: z */
    private void m77137z(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(43008);
        this.nTf.mo68828z(emojiInfo);
        if (this.oef == 0 || this.oef == 2) {
            if (C2933b.m5226x(emojiInfo)) {
                this.ogb = 2;
            } else if (C2933b.m5225w(emojiInfo)) {
                this.ogb = 4;
            } else {
                this.ogb = 3;
            }
        } else if (this.oef == 1) {
            this.ogb = 2;
        }
        this.oec = new C9499aa();
        this.oec.cVT = 1;
        this.oec.ajK();
        AppMethodBeat.m2505o(43008);
    }

    /* renamed from: eX */
    private void m77113eX(String str, String str2) {
        AppMethodBeat.m2504i(43009);
        C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "initH5LuckyMoneyView  currencyWording=".concat(String.valueOf(str)));
        TextView textView = (TextView) findViewById(2131825537);
        if (C5046bo.isNullOrNil(str)) {
            textView.setText(getString(C25738R.string.cq3));
        } else {
            textView.setText(str);
        }
        if (C5046bo.isNullOrNil(str2)) {
            m77108c(0.0d, C36391e.atr("CNY"));
            AppMethodBeat.m2505o(43009);
            return;
        }
        m77108c(0.0d, str2);
        AppMethodBeat.m2505o(43009);
    }

    /* renamed from: e */
    private void m77112e(int i, Intent intent) {
        C1207m c34443al;
        AppMethodBeat.m2504i(43010);
        String stringExtra = getIntent().getStringExtra("key_username");
        String Yz = C1853r.m3846Yz();
        if (i == -1) {
            C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult() resultCode == RESULT_OK");
            this.cKs = 1;
            this.ogm = "";
            c34443al = new C34443al(this.ocI, this.ogi, 1, Yz, C5046bo.nullAsNil(stringExtra));
        } else {
            if (intent != null) {
                this.cKs = intent.getIntExtra("key_pay_reslut_type", 3);
            } else {
                C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "doNetSceneLuckyMoneyReport() data == null");
                this.cKs = 3;
            }
            this.ogm = this.ocI;
            C4990ab.m7417i("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult() resultCode != RESULT_OK  payType:%s", Integer.valueOf(this.cKs));
            c34443al = new C34443al(this.ocI, this.ogi, this.cKs, Yz, C5046bo.nullAsNil(stringExtra));
        }
        C1720g.m3535RO().eJo.mo14541a(c34443al, 0);
        AppMethodBeat.m2505o(43010);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(43011);
        String str;
        switch (i) {
            case 1:
                if (intent != null && intent.hasExtra("key_realname_guide_helper")) {
                    this.oht = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
                }
                if (i2 != -1) {
                    if (!C46374c.m87176aw(intent)) {
                        if (!C46374c.m87177ax(intent)) {
                            m77112e(i2, intent);
                            break;
                        } else {
                            AppMethodBeat.m2505o(43011);
                            return;
                        }
                    }
                    finish();
                    AppMethodBeat.m2505o(43011);
                    return;
                }
                C7060h.pYm.mo8381e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bMh()), Integer.valueOf(5));
                String stringExtra = getIntent().getStringExtra("key_username");
                if (!this.obJ || C5046bo.isNullOrNil(stringExtra)) {
                    bMq();
                    View findViewById = findViewById(2131825634);
                    this.obD.setVisibility(0);
                    C46063x.m85801a(findViewById, null);
                    this.leS.setOnClickListener(new C4327731());
                    ((ImageView) findViewById(2131825636)).setOnClickListener(new C4327232());
                    m77112e(i2, intent);
                } else {
                    Map z = C5049br.m7595z(this.obK, "msg");
                    if (z == null) {
                        C4990ab.m7412e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
                        finish();
                        AppMethodBeat.m2505o(43011);
                        return;
                    }
                    str = (String) z.get(".msg.appmsg.wcpayinfo.paymsgid");
                    if (C6964a.bKN().bKQ().mo36579Qh(str)) {
                        C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
                        if (!C46063x.m85797E(this.obK, stringExtra, 1)) {
                            C4990ab.m7412e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
                            C6964a.bKN().bKQ().mo36580Qi(str);
                        }
                    } else {
                        C4990ab.m7412e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
                    }
                    m77112e(i2, intent);
                    this.ohv = new C26272ab();
                    this.ohv.cYk = (long) this.ogb;
                    C26272ab c26272ab = this.ohv;
                    if (this.kZa == null) {
                        str = "";
                    } else {
                        str = this.kZa.mo20410Aq();
                    }
                    c26272ab.mo43949eW(str);
                    this.ohv.ajK();
                    finish();
                }
                str = "";
                if (intent != null) {
                    str = intent.getStringExtra("key_trans_id");
                }
                m77096Qp(str);
                break;
                break;
            case 2:
                if (i2 != -1 || intent == null) {
                    if (i2 == 0) {
                        Intent intent2 = new Intent();
                        intent2.setClass(this.mController.ylL, LuckyMoneyMyRecordUI.class);
                        intent2.putExtra("key_type", 1);
                        startActivity(intent2);
                        break;
                    }
                }
                str = intent.getStringExtra("Select_Conv_User");
                C7060h.pYm.mo8381e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bMh()), Integer.valueOf(7), str);
                if (!C5046bo.isNullOrNil(str)) {
                    mo24304n(new C21198ar(str.replaceAll(",", "|"), this.obH, "v1.0"));
                    break;
                } else {
                    finish();
                    break;
                }
                break;
            case 3:
                if (intent != null && intent.hasExtra("result_data")) {
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra == null) {
                        C4990ab.m7412e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY bundle is null");
                        break;
                    }
                    int i3 = C5046bo.getInt(bundleExtra.getString("payState", "2"), 0);
                    C4990ab.m7412e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY payState is " + i3 + ";STATE_H5_PAY_SUCC=0");
                    if (i3 == 0) {
                        finish();
                        break;
                    }
                }
                break;
            case 4:
                if (i2 == -1) {
                    str = "";
                    if (intent != null) {
                        str = intent.getStringExtra("key_trans_id");
                    }
                    m77096Qp(str);
                }
                finish();
                break;
            case 5:
                if (i2 != -1) {
                    m77118iN(false);
                    C7060h.pYm.mo8381e(16822, Integer.valueOf(2));
                    break;
                }
                this.obF.removeAllViews();
                m77118iN(true);
                if (intent != null) {
                    byte[] byteArrayExtra = intent.getByteArrayExtra(C5499f.yfX);
                    if (byteArrayExtra != null) {
                        atb atb = new atb();
                        try {
                            atb.parseFrom(byteArrayExtra);
                            m77102a(atb);
                            break;
                        } catch (IOException e) {
                            C4990ab.printErrStackTrace("MicroMsg.LuckyMoneyPrepareUI", e, "", new Object[0]);
                            break;
                        }
                    }
                }
                break;
            case FaceManager.FACE_ACQUIRED_HACKER /*1111*/:
                if (i2 != -1) {
                    C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "go emoji capture failed!");
                    break;
                }
                str = "";
                if (intent != null) {
                    str = intent.getStringExtra("gif_md5");
                }
                if (!C5046bo.isNullOrNil(str)) {
                    this.kZa = C42952j.getEmojiStorageMgr().xYn.aqi(str);
                    m77137z(this.kZa);
                    break;
                }
                C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "md5 == null go emoji capture failed!");
                break;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(43011);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: V */
    public final void mo68812V(final View view, final int i) {
        AppMethodBeat.m2504i(43012);
        this.mKeyboard = (MyKeyboardWindow) findViewById(2131822357);
        this.nTi = findViewById(2131822356);
        View findViewById = findViewById(2131822358);
        final EditText editText = (EditText) view.findViewById(2131825536);
        if (this.mKeyboard == null || editText == null || this.nTi == null) {
            AppMethodBeat.m2505o(43012);
            return;
        }
        C36391e.setNoSystemInputOnEditText(editText);
        editText.setOnFocusChangeListener(new OnFocusChangeListener() {
            final /* synthetic */ boolean gnT = false;
            boolean ohP;

            /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$34$2 */
            class C124572 implements Runnable {
                C124572() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(42982);
                    LuckyMoneyPrepareUI.this.obF.setVisibility(0);
                    LuckyMoneyPrepareUI.this.aoB();
                    ((InputMethodManager) LuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
                    AppMethodBeat.m2505o(42982);
                }
            }

            public final void onFocusChange(final View view, boolean z) {
                AppMethodBeat.m2504i(42983);
                if (!view.isFocused() || this.gnT) {
                    new C7306ak().postDelayed(new C124572(), 200);
                    AppMethodBeat.m2505o(42983);
                    return;
                }
                ((InputMethodManager) LuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                new C7306ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(42981);
                        if (!LuckyMoneyPrepareUI.this.nTi.isShown() && view.isShown()) {
                            LuckyMoneyPrepareUI.this.nTi.setVisibility(0);
                            LuckyMoneyPrepareUI.this.obF.setVisibility(8);
                        }
                        LuckyMoneyPrepareUI.m77109c(LuckyMoneyPrepareUI.this, i);
                        LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                        ((InputMethodManager) LuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        AppMethodBeat.m2505o(42981);
                    }
                }, 300);
                AppMethodBeat.m2505o(42983);
            }
        });
        editText.setOnClickListener(new View.OnClickListener() {
            final /* synthetic */ boolean gnT = false;

            public final void onClick(View view) {
                AppMethodBeat.m2504i(42984);
                if (LuckyMoneyPrepareUI.this.nTi.isShown() || this.gnT) {
                    if (this.gnT) {
                        LuckyMoneyPrepareUI.this.nTi.setVisibility(8);
                        LuckyMoneyPrepareUI.this.obF.setVisibility(0);
                        ((InputMethodManager) LuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
                    }
                    AppMethodBeat.m2505o(42984);
                    return;
                }
                LuckyMoneyPrepareUI.this.nTi.setVisibility(0);
                LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                LuckyMoneyPrepareUI.m77109c(LuckyMoneyPrepareUI.this, i);
                AppMethodBeat.m2505o(42984);
            }
        });
        TextView textView = (TextView) view.findViewById(2131825537);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                final /* synthetic */ boolean gnT = false;

                /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI$36$1 */
                class C124591 implements Runnable {
                    C124591() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(42985);
                        LuckyMoneyPrepareUI.this.nTi.setVisibility(0);
                        view.requestFocus();
                        if (LuckyMoneyPrepareUI.this.mKeyboard != null) {
                            LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(editText);
                        }
                        LuckyMoneyPrepareUI.m77109c(LuckyMoneyPrepareUI.this, i);
                        AppMethodBeat.m2505o(42985);
                    }
                }

                public final void onClick(View view) {
                    AppMethodBeat.m2504i(42986);
                    if (!LuckyMoneyPrepareUI.this.nTi.isShown() || this.gnT) {
                        if (!LuckyMoneyPrepareUI.this.nTi.isShown() && !this.gnT) {
                            ((InputMethodManager) LuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                            new C7306ak().postDelayed(new C124591(), 200);
                            AppMethodBeat.m2505o(42986);
                            return;
                        } else if (this.gnT) {
                            LuckyMoneyPrepareUI.this.nTi.setVisibility(8);
                            ((InputMethodManager) LuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
                        }
                    } else if (LuckyMoneyPrepareUI.this.mKeyboard != null) {
                        LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(editText);
                        AppMethodBeat.m2505o(42986);
                        return;
                    }
                    AppMethodBeat.m2505o(42986);
                }
            });
        }
        findViewById.setOnClickListener(new C1246037());
        AppMethodBeat.m2505o(43012);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(43013);
        if (i == 4 && this.nTi != null && this.nTi.isShown()) {
            this.nTi.setVisibility(8);
            AppMethodBeat.m2505o(43013);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(43013);
        return onKeyUp;
    }

    /* Access modifiers changed, original: protected|final */
    public final void aoB() {
        AppMethodBeat.m2504i(43014);
        if (this.nTi != null && this.nTi.isShown()) {
            this.nTi.setVisibility(8);
        }
        AppMethodBeat.m2505o(43014);
    }

    public final void bLa() {
        double d;
        double d2;
        AppMethodBeat.m2504i(43015);
        C6964a.bKN();
        this.nSs = C6964a.bKO().bLu();
        if (this.obC.bKW() == 3 || this.nTd.bKW() == 3) {
            d = 0.0d;
            d2 = 0.0d;
        } else {
            int input = this.nTd.getInput();
            d2 = this.obC.getInput();
            if (this.mType == 0) {
                d2 *= (double) input;
                d = this.obC.getInput();
            } else {
                d = input > 0 ? this.obC.getInput() / ((double) input) : 0.0d;
            }
        }
        if (this.nTn.bMy()) {
            C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "has error");
            this.nTg.setClickable(false);
            this.nTg.setEnabled(false);
        } else {
            boolean z;
            if (d2 == 0.0d || d == 0.0d) {
                z = true;
            } else if (d2 > this.nSs.nRR && this.nSs.nRR > 0.0d) {
                this.nTn.mo68829Dv(getString(C25738R.string.ctn, new Object[]{Math.round(this.nSs.nRR), C5046bo.m7532bc(this.nSs.nRU, "")}));
                z = true;
            } else if (d > 0.0d) {
                C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "perAmount ".concat(String.valueOf(d)));
                if (this.mType == 0) {
                    if (d > this.nSs.nRP && this.nSs.nRP > 0.0d) {
                        if (bML()) {
                            this.nTn.mo68829Dv(getString(C25738R.string.csc, new Object[]{this.nSs.nWL, Math.round(this.nSs.nRP), C5046bo.m7532bc(this.nSs.nRU, "")}));
                        } else {
                            this.nTn.mo68829Dv(getString(C25738R.string.csb, new Object[]{Math.round(this.nSs.nRP), C5046bo.m7532bc(this.nSs.nRU, "")}));
                        }
                        z = true;
                    }
                    z = false;
                } else {
                    if (d > this.nSs.nRS && this.nSs.nRS > 0.0d) {
                        if (this.nSs == null || C5046bo.isNullOrNil(this.nSs.nWL)) {
                            this.nTn.mo68829Dv(getString(C25738R.string.csb, new Object[]{Math.round(this.nSs.nRS), C5046bo.m7532bc(this.nSs.nRU, "")}));
                        } else {
                            this.nTn.mo68829Dv(getString(C25738R.string.csc, new Object[]{this.nSs.nWL, Math.round(this.nSs.nRS), C5046bo.m7532bc(this.nSs.nRU, "")}));
                        }
                        this.nTd.onError();
                        this.obC.onError();
                        z = true;
                    }
                    z = false;
                }
                C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + z + " for max value");
                if (!z) {
                    if (this.mType == 0) {
                        if (d < this.nSs.nRQ) {
                            if (bML()) {
                                this.nTn.mo68829Dv(getString(C25738R.string.cse, new Object[]{this.nSs.nWL, C36391e.m59971F(this.nSs.nRQ), C5046bo.m7532bc(this.nSs.nRU, "")}));
                            } else {
                                this.nTn.mo68829Dv(getString(C25738R.string.csd, new Object[]{C36391e.m59971F(this.nSs.nRQ), C5046bo.m7532bc(this.nSs.nRU, "")}));
                            }
                            z = true;
                        }
                    } else if (d < 0.01d) {
                        if (bML()) {
                            this.nTn.mo68829Dv(getString(C25738R.string.cse, new Object[]{this.nSs.nWL, "0.01", C5046bo.m7532bc(this.nSs.nRU, "")}));
                        } else {
                            this.nTn.mo68829Dv(getString(C25738R.string.csd, new Object[]{"0.01", C5046bo.m7532bc(this.nSs.nRU, "")}));
                        }
                        this.nTd.onError();
                        this.obC.onError();
                        z = true;
                    }
                }
                C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + z + " for min value");
            } else {
                z = false;
            }
            if (z) {
                this.nTg.setClickable(false);
                this.nTg.setEnabled(false);
            } else {
                this.nTg.setClickable(true);
                this.nTg.setEnabled(true);
            }
        }
        m77108c(d2, this.ohr);
        AppMethodBeat.m2505o(43015);
    }

    private boolean bML() {
        AppMethodBeat.m2504i(43016);
        if (this.nSs == null || C5046bo.isNullOrNil(this.nSs.nWL)) {
            AppMethodBeat.m2505o(43016);
            return false;
        }
        AppMethodBeat.m2505o(43016);
        return true;
    }

    /* renamed from: c */
    private void m77108c(double d, String str) {
        AppMethodBeat.m2504i(43017);
        if (C5046bo.isNullOrNil(str)) {
            this.kGm.setText(C36391e.m59972G(d));
            AppMethodBeat.m2505o(43017);
            return;
        }
        this.kGm.setText(str + C36391e.m59971F(d));
        AppMethodBeat.m2505o(43017);
    }

    private int bMh() {
        AppMethodBeat.m2504i(43018);
        if (!this.obJ) {
            AppMethodBeat.m2505o(43018);
            return 3;
        } else if (getIntent().getIntExtra("key_chatroom_num", 0) > 0) {
            AppMethodBeat.m2505o(43018);
            return 2;
        } else {
            AppMethodBeat.m2505o(43018);
            return 1;
        }
    }

    public void finish() {
        AppMethodBeat.m2504i(43019);
        if (this.oht != null) {
            Intent intent = new Intent();
            intent.putExtra("key_realname_guide_helper", this.oht);
            C25985d.m41467b((Context) this, "wallet_core", ".id_verify.RealnameDialogActivity", intent);
        }
        super.finish();
        AppMethodBeat.m2505o(43019);
    }

    /* renamed from: Qp */
    private void m77096Qp(String str) {
        AppMethodBeat.m2504i(43020);
        C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "do business callback");
        mo24301b(new C34441ae(this.ocI, str, this.ohu), false);
        AppMethodBeat.m2505o(43020);
    }

    /* renamed from: i */
    static /* synthetic */ void m77117i(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        AppMethodBeat.m2504i(43023);
        C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick()");
        luckyMoneyPrepareUI.m77135yj(0);
        AppMethodBeat.m2505o(43023);
    }

    /* renamed from: u */
    static /* synthetic */ void m77130u(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        AppMethodBeat.m2504i(43024);
        luckyMoneyPrepareUI.ohC = new C16001d(luckyMoneyPrepareUI, 1, false);
        luckyMoneyPrepareUI.ohC.rBl = new C432798();
        luckyMoneyPrepareUI.ohC.rBm = new C432739();
        luckyMoneyPrepareUI.ohC.cpD();
        AppMethodBeat.m2505o(43024);
    }

    /* renamed from: y */
    static /* synthetic */ void m77134y(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        int i;
        AppMethodBeat.m2504i(43026);
        luckyMoneyPrepareUI.oec = new C9499aa();
        luckyMoneyPrepareUI.oec.cVT = 3;
        luckyMoneyPrepareUI.oec.ajK();
        luckyMoneyPrepareUI.aoB();
        luckyMoneyPrepareUI.aqX();
        luckyMoneyPrepareUI.odS.show();
        if (C5046bo.m7563gW(luckyMoneyPrepareUI.nYN, 1)) {
            i = ChatFooterPanel.vhr;
        } else {
            i = ChatFooterPanel.vho;
        }
        C28459a.m45137a(luckyMoneyPrepareUI.oea, luckyMoneyPrepareUI.odY, i, new C4327030());
        AppMethodBeat.m2505o(43026);
    }
}
