package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C17918t.C17917a;
import com.tencent.p177mm.api.C8955k;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.emoji.p228d.C26074a;
import com.tencent.p177mm.emoji.p228d.C37677d;
import com.tencent.p177mm.emoji.p228d.C41949b;
import com.tencent.p177mm.emoji.view.BaseEmojiView;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p232b.p233a.C32674m;
import com.tencent.p177mm.p230g.p232b.p233a.C37833l;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.plugin.account.p765a.p1216b.C32921a;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b.C29341;
import com.tencent.p177mm.plugin.emojicapture.api.C20423c;
import com.tencent.p177mm.plugin.gif.MMAnimateView;
import com.tencent.p177mm.plugin.luckymoney.model.C12426ao;
import com.tencent.p177mm.plugin.luckymoney.model.C12427ap;
import com.tencent.p177mm.plugin.luckymoney.model.C3381ag;
import com.tencent.p177mm.plugin.luckymoney.model.C34443al;
import com.tencent.p177mm.plugin.luckymoney.model.C43262u;
import com.tencent.p177mm.plugin.luckymoney.model.C46063x;
import com.tencent.p177mm.plugin.luckymoney.p449ui.C46064a.C34503a;
import com.tencent.p177mm.plugin.luckymoney.p449ui.LuckyMoneyAutoScrollView.C43266a;
import com.tencent.p177mm.plugin.luckymoney.p449ui.p1406a.C28459a;
import com.tencent.p177mm.plugin.luckymoney.p735b.C6964a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44081e;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C23505at;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo.C30302a;
import com.tencent.p177mm.wallet_core.p649c.C44424g;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.soter.core.biometric.FaceManager;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI */
public class LuckyMoneyNewYearSendUI extends LuckyMoneyBaseUI {
    public static int mState;
    public static int ogj = 0;
    private int cKs = 0;
    private Dialog gII = null;
    private OnClickListener gKK = new C432686();
    private EmojiInfo kZa;
    private Button leS;
    private C7306ak mHandler = new C7306ak();
    private String nYD;
    private int nYF;
    private int nYM = 0;
    private LinkedList<C43262u> nYP;
    private TextView nsq;
    private int obG;
    private String obK;
    private int obL;
    private String ocI = "";
    private C46064a odS;
    private View odT;
    private ChatFooterPanel odY;
    private ViewGroup oea;
    private int oef = 0;
    private View ofJ;
    private View ofK;
    private TextView ofL;
    private ImageView ofM;
    private TextView ofN;
    private ImageView ofO;
    private ImageView ofP;
    private TextView ofQ;
    private LinearLayout ofR;
    private MMAnimateView ofS;
    private LinearLayout ofT;
    private String ofU;
    private boolean ofV = true;
    private int ofW = 0;
    private int ofX = 0;
    private EmojiInfo ofY;
    private C37833l ofZ;
    private LuckyMoneyAutoScrollView ofi;
    private TextView ofj;
    private ImageView ofw;
    private View ofx;
    private BaseEmojiView ofy;
    private C32674m oga;
    private int ogb = 1;
    private int ogc = 0;
    private int ogd = 0;
    private int oge = 0;
    private int ogf = 0;
    private int ogg = 0;
    private long ogh = 0;
    private String ogi = "";
    private int ogk = 0;
    private C26074a ogl = new C393374();
    private String ogm = "";

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI$10 */
    class C342010 implements OnCancelListener {
        C342010() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(42818);
            if (LuckyMoneyNewYearSendUI.this.gII != null && LuckyMoneyNewYearSendUI.this.gII.isShowing()) {
                LuckyMoneyNewYearSendUI.this.gII.dismiss();
            }
            if (LuckyMoneyNewYearSendUI.this.mController.contentView.getVisibility() == 8 || LuckyMoneyNewYearSendUI.this.mController.contentView.getVisibility() == 4) {
                C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearSendUI", "usr cancel, & visibility not visiable, so finish");
                LuckyMoneyNewYearSendUI.this.finish();
            }
            LuckyMoneyNewYearSendUI.this.ocz.bLz();
            AppMethodBeat.m2505o(42818);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI$11 */
    class C342111 implements C43266a {

        /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI$11$1 */
        class C34221 implements AnimationListener {
            C34221() {
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.m2504i(42819);
                LuckyMoneyNewYearSendUI.this.nsq.setVisibility(0);
                AppMethodBeat.m2505o(42819);
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
            }
        }

        C342111() {
        }

        public final void bMo() {
            AppMethodBeat.m2504i(42820);
            if (LuckyMoneyNewYearSendUI.this.ofV) {
                LuckyMoneyNewYearSendUI.this.nsq.setVisibility(4);
                C46063x.m85800a(LuckyMoneyNewYearSendUI.this.mController.ylL, LuckyMoneyNewYearSendUI.this.nsq, LuckyMoneyNewYearSendUI.this.nYD);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(500);
                alphaAnimation.setAnimationListener(new C34221());
                LuckyMoneyNewYearSendUI.this.nsq.startAnimation(alphaAnimation);
                LuckyMoneyNewYearSendUI.this.ofV = false;
            } else {
                C46063x.m85800a(LuckyMoneyNewYearSendUI.this.mController.ylL, LuckyMoneyNewYearSendUI.this.nsq, LuckyMoneyNewYearSendUI.this.nYD);
                LuckyMoneyNewYearSendUI.this.nsq.invalidate();
            }
            LuckyMoneyNewYearSendUI.m77058a(LuckyMoneyNewYearSendUI.this, true);
            LuckyMoneyNewYearSendUI.this.ofi.setFocusable(true);
            LuckyMoneyNewYearSendUI.this.ofi.setContentDescription((((double) LuckyMoneyNewYearSendUI.this.nYF) / 100.0d));
            AppMethodBeat.m2505o(42820);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI$8 */
    class C212318 implements C36073c {
        C212318() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(42816);
            if (C5046bo.m7563gW(LuckyMoneyNewYearSendUI.this.ofW, 1)) {
                c44273l.mo70072hi(1, C25738R.string.cry);
            }
            c44273l.mo70072hi(2, C25738R.string.csz);
            AppMethodBeat.m2505o(42816);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI$9 */
    class C212329 implements C5279d {
        C212329() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(42817);
            C4990ab.m7417i("MicroMsg.LuckyMoneyNewYearSendUI", "showLuckyHbDlg() onMMMenuItemSelected menuItemId:%s", Integer.valueOf(menuItem.getItemId()));
            switch (menuItem.getItemId()) {
                case 1:
                    LuckyMoneyNewYearSendUI.this.ogk = 0;
                    C20423c.m31582h(LuckyMoneyNewYearSendUI.this, null, 3);
                    LuckyMoneyNewYearSendUI.this.oef = 1;
                    LuckyMoneyNewYearSendUI.this.ofZ = new C37833l();
                    LuckyMoneyNewYearSendUI.this.ofZ.cVT = 9;
                    LuckyMoneyNewYearSendUI.this.ofZ.ajK();
                    AppMethodBeat.m2505o(42817);
                    return;
                case 2:
                    LuckyMoneyNewYearSendUI.m77072n(LuckyMoneyNewYearSendUI.this);
                    break;
            }
            AppMethodBeat.m2505o(42817);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI$7 */
    class C247907 implements C17917a {
        C247907() {
        }

        /* renamed from: a */
        public final void mo7169a(C8955k c8955k) {
            AppMethodBeat.m2504i(42814);
            C4990ab.m7417i("MicroMsg.LuckyMoneyNewYearSendUI", "[onSelectedEmoji] emojiInfo:%s", c8955k);
            LuckyMoneyNewYearSendUI.m77056a(LuckyMoneyNewYearSendUI.this, c8955k);
            LuckyMoneyNewYearSendUI.m77054a(LuckyMoneyNewYearSendUI.this);
            AppMethodBeat.m2505o(42814);
        }

        public final void onHide() {
            AppMethodBeat.m2504i(138990);
            LuckyMoneyNewYearSendUI.m77054a(LuckyMoneyNewYearSendUI.this);
            AppMethodBeat.m2505o(138990);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI$1 */
    class C284391 implements OnClickListener {
        C284391() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42808);
            LuckyMoneyNewYearSendUI.m77054a(LuckyMoneyNewYearSendUI.this);
            AppMethodBeat.m2505o(42808);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI$12 */
    class C3448112 implements C44424g {
        C3448112() {
        }

        /* renamed from: aQ */
        public final void mo24321aQ(int i, String str) {
            AppMethodBeat.m2504i(42821);
            C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() scene:NetScenePrepareNewYearLuckyMoney JumpRemind:onNext()");
            if (C5046bo.m7563gW(i, 2) && C5046bo.isEqual(str, "requestwxhb")) {
                LuckyMoneyNewYearSendUI.m77081w(LuckyMoneyNewYearSendUI.this);
                AppMethodBeat.m2505o(42821);
                return;
            }
            if (C5046bo.m7563gW(i, 1)) {
                C32921a.m53856b(LuckyMoneyNewYearSendUI.this, str, 0, true);
            }
            AppMethodBeat.m2505o(42821);
        }

        public final void onCancel() {
            AppMethodBeat.m2504i(42822);
            C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() scene:NetScenePrepareNewYearLuckyMoney JumpRemind:onCancel()");
            AppMethodBeat.m2505o(42822);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI$4 */
    class C393374 implements C26074a {
        C393374() {
        }

        /* renamed from: a */
        public final void mo43943a(long j, boolean z, String str) {
            int i = 0;
            AppMethodBeat.m2504i(42811);
            C4990ab.m7417i("MicroMsg.LuckyMoneyNewYearSendUI", "onResult() mTimeEnter:%s  timeEnter:%s  success:%s  md5:%s", Long.valueOf(LuckyMoneyNewYearSendUI.this.ogh), Long.valueOf(j), Boolean.valueOf(z), str);
            if (C5046bo.m7521af(LuckyMoneyNewYearSendUI.this.ogh, j)) {
                if (z) {
                    LuckyMoneyNewYearSendUI.m77057a(LuckyMoneyNewYearSendUI.this, str);
                } else {
                    if (C5046bo.m7563gW(LuckyMoneyNewYearSendUI.this.ogk, 0)) {
                        EmojiInfo mU = C23505at.dsZ().xYn.mo48587mU(LuckyMoneyNewYearSendUI.this.ogh);
                        if (mU != null && mU.duZ() == C30302a.STATUS_UPLOAD_FAIL) {
                            switch (C29341.lgJ[mU.dvc().ordinal()]) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                    i = 1;
                                    break;
                            }
                        }
                        if (i != 0) {
                            LuckyMoneyNewYearSendUI.this.ogk = LuckyMoneyNewYearSendUI.this.ogk + 1;
                            LuckyMoneyNewYearSendUI.m77055a(LuckyMoneyNewYearSendUI.this, 3);
                            AppMethodBeat.m2505o(42811);
                            return;
                        }
                    }
                    LuckyMoneyNewYearSendUI.m77055a(LuckyMoneyNewYearSendUI.this, 5);
                }
                LuckyMoneyNewYearSendUI.m77058a(LuckyMoneyNewYearSendUI.this, true);
                C41949b c41949b = C41949b.ezV;
                C41949b.m74083b(LuckyMoneyNewYearSendUI.this.ogh, LuckyMoneyNewYearSendUI.this.ogl);
            }
            AppMethodBeat.m2505o(42811);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI$5 */
    class C432675 implements C34503a {
        C432675() {
        }

        public final void bMl() {
            AppMethodBeat.m2504i(42812);
            LuckyMoneyNewYearSendUI.m77054a(LuckyMoneyNewYearSendUI.this);
            AppMethodBeat.m2505o(42812);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI$6 */
    class C432686 implements OnClickListener {
        C432686() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42813);
            if (view.getId() == 2131825576) {
                C7060h.pYm.mo8381e(13079, Integer.valueOf(5), Integer.valueOf(1));
                C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearSendUI", "mSendBtn click!");
                LuckyMoneyNewYearSendUI.m77059b(LuckyMoneyNewYearSendUI.this);
                AppMethodBeat.m2505o(42813);
            } else if (view.getId() == 2131825577) {
                LuckyMoneyNewYearSendUI.this.finish();
                C7060h.pYm.mo8381e(13079, Integer.valueOf(6), Integer.valueOf(1));
                LuckyMoneyNewYearSendUI.this.ofZ = new C37833l();
                LuckyMoneyNewYearSendUI.this.ofZ.cVT = 11;
                LuckyMoneyNewYearSendUI.this.ofZ.ajK();
                LuckyMoneyNewYearSendUI.m77061d(LuckyMoneyNewYearSendUI.this);
                AppMethodBeat.m2505o(42813);
            } else if (view.getId() == 2131825563 || view.getId() == 2131825564) {
                LuckyMoneyNewYearSendUI.this.ofZ = new C37833l();
                LuckyMoneyNewYearSendUI.this.ofZ.cVT = 3;
                LuckyMoneyNewYearSendUI.this.ofZ.ajK();
                LuckyMoneyNewYearSendUI.m77062e(LuckyMoneyNewYearSendUI.this);
                AppMethodBeat.m2505o(42813);
            } else if (view.getId() == 2131825568) {
                LuckyMoneyNewYearSendUI.this.kZa = null;
                LuckyMoneyNewYearSendUI.this.ofY = null;
                LuckyMoneyNewYearSendUI.m77055a(LuckyMoneyNewYearSendUI.this, 0);
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_HONGBAO_NEW_YEAR_LAST_SEND_EMOJI_MD5_STRING, (Object) "");
                C7060h.pYm.mo8381e(13079, Integer.valueOf(3), Integer.valueOf(1));
                LuckyMoneyNewYearSendUI.this.ofZ = new C37833l();
                LuckyMoneyNewYearSendUI.this.ofZ.cVT = 5;
                LuckyMoneyNewYearSendUI.this.ofZ.ajK();
                AppMethodBeat.m2505o(42813);
            } else if (view.getId() == 2131825575) {
                LuckyMoneyAutoScrollView h = LuckyMoneyNewYearSendUI.this.ofi;
                h.ocw = false;
                h.ock.setVisibility(0);
                h.ocl.setVisibility(0);
                h.ocm.setVisibility(0);
                h.ocq.setVisibility(4);
                h.ocr.setVisibility(4);
                h.ocs.setVisibility(4);
                LuckyMoneyNewYearSendUI.m77066i(LuckyMoneyNewYearSendUI.this);
                C7060h.pYm.mo8381e(13079, Integer.valueOf(4), Integer.valueOf(1));
                LuckyMoneyNewYearSendUI.this.ofZ = new C37833l();
                LuckyMoneyNewYearSendUI.this.ofZ.cVT = 2;
                LuckyMoneyNewYearSendUI.this.ofZ.ajK();
                AppMethodBeat.m2505o(42813);
            } else if (view.getId() == 2131825569) {
                C37677d c37677d = C37677d.eAh;
                C37677d.m63710eY(LuckyMoneyNewYearSendUI.this.ogh);
                LuckyMoneyNewYearSendUI.m77058a(LuckyMoneyNewYearSendUI.this, false);
                LuckyMoneyNewYearSendUI.m77055a(LuckyMoneyNewYearSendUI.this, 4);
                AppMethodBeat.m2505o(42813);
            } else {
                if (view.getId() == 2131825567) {
                    LuckyMoneyNewYearSendUI.m77062e(LuckyMoneyNewYearSendUI.this);
                }
                AppMethodBeat.m2505o(42813);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI$3 */
    class C432693 implements DialogInterface.OnClickListener {
        C432693() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(42810);
            LuckyMoneyNewYearSendUI.this.finish();
            AppMethodBeat.m2505o(42810);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public LuckyMoneyNewYearSendUI() {
        AppMethodBeat.m2504i(42823);
        AppMethodBeat.m2505o(42823);
    }

    /* renamed from: d */
    static /* synthetic */ void m77061d(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        AppMethodBeat.m2504i(42839);
        luckyMoneyNewYearSendUI.m77084yd(2);
        AppMethodBeat.m2505o(42839);
    }

    /* renamed from: i */
    static /* synthetic */ void m77066i(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        AppMethodBeat.m2504i(42842);
        luckyMoneyNewYearSendUI.bMG();
        AppMethodBeat.m2505o(42842);
    }

    /* renamed from: n */
    static /* synthetic */ void m77072n(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        AppMethodBeat.m2504i(42845);
        luckyMoneyNewYearSendUI.bMF();
        AppMethodBeat.m2505o(42845);
    }

    /* renamed from: w */
    static /* synthetic */ void m77081w(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        AppMethodBeat.m2504i(42846);
        luckyMoneyNewYearSendUI.m77086yf(1);
        AppMethodBeat.m2505o(42846);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(42824);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearSendUI", "lucky send ui create");
        this.ofU = getIntent().getStringExtra("key_username");
        this.obG = getIntent().getIntExtra("key_way", 0);
        this.obL = getIntent().getIntExtra("pay_channel", -1);
        if (C5046bo.isNullOrNil(this.ofU)) {
            C4990ab.m7420w("MicroMsg.LuckyMoneyNewYearSendUI", "name null finish");
            finish();
        }
        initView();
        mo24304n(new C3381ag("v1.0", ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LUCKY_MONEY_ENVELOPE_HAS_SOURCE_INT_SYNC, Integer.valueOf(0))).intValue()));
        C7060h.pYm.mo8381e(13079, Integer.valueOf(1), Integer.valueOf(1));
        AppMethodBeat.m2505o(42824);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(42825);
        super.onDestroy();
        if (this.gII != null && this.gII.isShowing()) {
            this.gII.dismiss();
        }
        if (this.odY != null) {
            C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearSendUI", "commentfooter release");
            this.odY.onPause();
            this.odY.mo11686AC();
            this.odY.destroy();
        }
        C41949b c41949b = C41949b.ezV;
        C41949b.m74083b(this.ogh, this.ogl);
        AppMethodBeat.m2505o(42825);
    }

    public final void initView() {
        AppMethodBeat.m2504i(42826);
        mo17446xE(-839716110);
        mo9439AM(8);
        this.ofJ = findViewById(2131825560);
        this.ofj = (TextView) findViewById(2131825574);
        this.ofi = (LuckyMoneyAutoScrollView) findViewById(2131825573);
        this.nsq = (TextView) findViewById(2131825572);
        this.leS = (Button) findViewById(2131825576);
        this.leS.setOnClickListener(this.gKK);
        ((ImageView) findViewById(2131825577)).setOnClickListener(this.gKK);
        this.ofw = (ImageView) findViewById(2131825561);
        this.ofK = findViewById(2131825562);
        this.ofL = (TextView) findViewById(2131825564);
        this.ofM = (ImageView) findViewById(2131825563);
        this.ofM.setOnClickListener(this.gKK);
        this.ofN = (TextView) findViewById(2131825564);
        this.ofN.setOnClickListener(this.gKK);
        this.ofx = findViewById(2131825565);
        this.ofy = (BaseEmojiView) findViewById(2131825567);
        this.ofy.setOnClickListener(this.gKK);
        this.ofP = (ImageView) findViewById(2131825568);
        this.ofP.setOnClickListener(this.gKK);
        this.ofO = (ImageView) findViewById(2131825566);
        this.ofQ = (TextView) findViewById(2131825569);
        this.ofQ.setOnClickListener(this.gKK);
        this.ofR = (LinearLayout) findViewById(2131825570);
        this.ofS = (MMAnimateView) findViewById(2131825571);
        this.ofT = (LinearLayout) findViewById(2131825575);
        this.ofT.setOnClickListener(this.gKK);
        this.odS = new C46064a(this);
        this.odT = getLayoutInflater().inflate(2130969978, null);
        this.odS.setContentView(this.odT, new LayoutParams(-1, -1));
        this.odT.findViewById(2131825497).setOnClickListener(new C284391());
        this.odS.obT = new C432675();
        this.oea = (ViewGroup) this.odT.findViewById(2131825499);
        this.odY = C44081e.vom.mo35682dF(this.mController.ylL);
        C28459a.m45138a(this.odY);
        AppMethodBeat.m2505o(42826);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(42827);
        m77084yd(2);
        finish();
        AppMethodBeat.m2505o(42827);
    }

    /* renamed from: yd */
    private void m77084yd(int i) {
        AppMethodBeat.m2504i(42828);
        this.oga = new C32674m();
        this.oga.cVU = (long) i;
        this.oga.cVV = (long) this.ogb;
        this.oga.cVW = (long) this.ogc;
        this.oga.cVX = (long) this.ogd;
        this.oga.cVY = (long) this.oge;
        this.oga.cWb = (long) this.ogf;
        this.oga.cVZ = (long) this.ogg;
        this.oga.mo53206eE(this.kZa == null ? "" : this.kZa.mo20410Aq());
        this.oga.ajK();
        AppMethodBeat.m2505o(42828);
    }

    private void bMF() {
        int i;
        AppMethodBeat.m2504i(42829);
        this.ofZ = new C37833l();
        this.ofZ.cVT = 10;
        this.ofZ.ajK();
        this.oef = 2;
        this.odS.show();
        if (C5046bo.m7563gW(this.ofW, 1)) {
            i = ChatFooterPanel.vhq;
        } else {
            i = ChatFooterPanel.vhn;
        }
        C28459a.m45137a(this.oea, this.odY, i, new C247907());
        AppMethodBeat.m2505o(42829);
    }

    /* renamed from: Qo */
    private void m77052Qo(String str) {
        AppMethodBeat.m2504i(42830);
        this.kZa = C42952j.getEmojiStorageMgr().xYn.aqi(str);
        this.ofy.setEmojiInfo(this.kZa);
        m77085ye(2);
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_HONGBAO_NEW_YEAR_LAST_SEND_EMOJI_MD5_STRING, (Object) str);
        AppMethodBeat.m2505o(42830);
    }

    /* renamed from: ye */
    private void m77085ye(int i) {
        AppMethodBeat.m2504i(42831);
        if (ogj != 0) {
            i = mState;
        }
        if (C5046bo.m7563gW(this.nYM, 0)) {
            this.ofw.setVisibility(0);
            this.ofK.setVisibility(8);
            this.ofx.setVisibility(8);
            AppMethodBeat.m2505o(42831);
            return;
        }
        this.ofw.setVisibility(8);
        C4990ab.m7417i("MicroMsg.LuckyMoneyNewYearSendUI", "exchangeExpressionState() state:%s", Integer.valueOf(i));
        switch (i) {
            case 0:
                this.ofK.setVisibility(0);
                this.ofL.setText(C25738R.string.cpy);
                this.ofx.setVisibility(8);
                AppMethodBeat.m2505o(42831);
                return;
            case 1:
                this.ofK.setVisibility(8);
                this.ofx.setVisibility(0);
                this.ofO.setVisibility(0);
                this.ofy.setVisibility(8);
                this.ofP.setVisibility(8);
                this.ofQ.setVisibility(8);
                this.ofR.setVisibility(8);
                AppMethodBeat.m2505o(42831);
                return;
            case 2:
                if (this.ofY != null) {
                    this.ofZ = new C37833l();
                    this.ofZ.cVT = 4;
                    this.ofZ.ajK();
                }
                this.ofY = this.kZa;
                if (this.oef == 0) {
                    if (C2933b.m5226x(this.kZa)) {
                        this.ogb = 2;
                    } else if (C2933b.m5225w(this.kZa)) {
                        this.ogb = 4;
                    } else {
                        this.ogb = 3;
                    }
                } else if (this.oef == 1) {
                    this.ogb = 2;
                    this.ogd++;
                } else if (this.oef == 2) {
                    if (C2933b.m5226x(this.kZa)) {
                        this.ogb = 2;
                        this.ogg++;
                    } else if (C2933b.m5225w(this.kZa)) {
                        this.ogb = 4;
                        this.ogf++;
                    } else {
                        this.ogb = 3;
                        this.oge++;
                    }
                }
                this.ofK.setVisibility(8);
                this.ofx.setVisibility(0);
                this.ofO.setVisibility(8);
                this.ofy.setVisibility(0);
                this.ofP.setVisibility(0);
                this.ofQ.setVisibility(8);
                this.ofR.setVisibility(8);
                AppMethodBeat.m2505o(42831);
                return;
            case 3:
                this.ofK.setVisibility(8);
                this.ofx.setVisibility(0);
                this.ofO.setVisibility(8);
                this.ofy.setVisibility(8);
                this.ofP.setVisibility(8);
                this.ofQ.setVisibility(0);
                this.ofR.setVisibility(8);
                AppMethodBeat.m2505o(42831);
                return;
            case 4:
                this.ofK.setVisibility(8);
                this.ofx.setVisibility(0);
                this.ofO.setVisibility(8);
                this.ofy.setVisibility(8);
                this.ofP.setVisibility(8);
                this.ofQ.setVisibility(8);
                this.ofR.setVisibility(0);
                this.ofS.setImageResource(C1318a.lucky_money_newyear_creat_loading);
                AppMethodBeat.m2505o(42831);
                return;
            case 5:
                this.ofK.setVisibility(0);
                this.ofL.setText(C25738R.string.crt);
                this.ofx.setVisibility(8);
                break;
        }
        AppMethodBeat.m2505o(42831);
    }

    public final int getLayoutId() {
        return 2130969989;
    }

    /* renamed from: yf */
    private void m77086yf(int i) {
        AppMethodBeat.m2504i(42832);
        C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend()");
        C7060h.pYm.mo8381e(11701, Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1));
        if (this.gII == null) {
            this.gII = C30901g.m49317a(this.mController.ylL, true, new C342010());
        } else if (!this.gII.isShowing()) {
            this.gII.show();
        }
        String Yz = C1853r.m3846Yz();
        String str = "";
        int i2 = 0;
        if (this.kZa != null) {
            str = this.kZa.mo20410Aq();
            i2 = this.kZa.field_type;
        }
        C4990ab.m7417i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend() mUniqueId:%s userConfirmJump:%s lastPayResult:%s mSendId:%s", this.ogi, Integer.valueOf(i), Integer.valueOf(this.cKs), this.ocI);
        mo24301b(new C12427ap(this.nYF, this.nYD, C46063x.m85798Qj(Yz), this.ofU, Yz, C1853r.m3820YB(), this.obG, str, i2, this.ogi, i, this.cKs, this.ocI), false);
        AppMethodBeat.m2505o(42832);
    }

    private void bMG() {
        int i;
        AppMethodBeat.m2504i(42833);
        this.ogc++;
        if (this.nYP == null || this.nYP.size() <= 0) {
            C4990ab.m7412e("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex yearMessList is empty!");
            i = -1;
        } else {
            C1720g.m3537RQ();
            C1720g.m3534RN();
            i = C1668a.m3383QF();
            int size = this.nYP.size();
            i = (new Random((long) i).nextInt(size) + ((int) (System.currentTimeMillis() % ((long) size)))) % size;
            C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex retRand:".concat(String.valueOf(i)));
        }
        this.ofX = i;
        if (this.ofX >= 0 && this.ofX < this.nYP.size()) {
            this.nYF = ((C43262u) this.nYP.get(this.ofX)).nXX;
            this.nYD = ((C43262u) this.nYP.get(this.ofX)).nXY;
        }
        C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearSendUI", "mSelectIndex:" + this.ofX + " randomAmount:" + this.nYF + " randomWishing:" + this.nYD);
        this.ofi.setFinalText(C36391e.m59971F(((double) this.nYF) / 100.0d));
        m77067iM(false);
        this.ofi.setFocusable(false);
        this.ofi.setContentDescription("");
        this.ofi.mo68803a(new C342111());
        AppMethodBeat.m2505o(42833);
    }

    /* renamed from: iM */
    private void m77067iM(boolean z) {
        AppMethodBeat.m2504i(42834);
        this.leS.setClickable(z);
        if (z) {
            this.leS.getBackground().mutate().setAlpha(255);
            this.leS.setTextColor(getResources().getColor(C25738R.color.f12155u_));
            AppMethodBeat.m2505o(42834);
            return;
        }
        this.leS.getBackground().mutate().setAlpha(128);
        this.leS.setTextColor(getResources().getColor(C25738R.color.f12156ua));
        AppMethodBeat.m2505o(42834);
    }

    /* renamed from: c */
    public final boolean mo7808c(int i, int i2, String str, final C1207m c1207m) {
        AppMethodBeat.m2504i(42835);
        C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() errType:" + i + " errCode:" + i2 + " errMsg:" + str + " netsceneType:" + c1207m.getType());
        PayInfo payInfo;
        if (c1207m instanceof C3381ag) {
            if (i == 0 && i2 == 0) {
                C3381ag c3381ag = (C3381ag) c1207m;
                this.nYF = c3381ag.nYF;
                this.nYD = c3381ag.nYD;
                this.ofW = c3381ag.nYL;
                this.nYM = c3381ag.nYM;
                this.ogi = c3381ag.few;
                this.nYP = c3381ag.nYP;
                C4990ab.m7417i("MicroMsg.LuckyMoneyNewYearSendUI", "enableSelfIe is %s", Integer.valueOf(this.ofW));
                bMG();
                C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:updateView");
                if (this.nYP == null || this.nYP.size() <= 0) {
                    C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is not valid!");
                    this.ofT.setVisibility(8);
                } else {
                    C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is valid!");
                    this.ofT.setVisibility(0);
                }
                this.nsq.getLayoutParams();
                this.nsq.setTextSize(1, 21.0f);
                this.ofj.setTextSize(1, 15.0f);
                this.ofi.mo68805eu(getResources().getDimensionPixelOffset(C25738R.dimen.a58), getResources().getDimensionPixelOffset(C25738R.dimen.a54));
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ofi.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelOffset(C25738R.dimen.a4r);
                this.ofi.setLayoutParams(layoutParams);
                this.ofi.invalidate();
                layoutParams = (LinearLayout.LayoutParams) this.ofT.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelOffset(C25738R.dimen.a4u);
                this.ofT.setLayoutParams(layoutParams);
                this.ofT.invalidate();
                String str2 = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_HONGBAO_NEW_YEAR_LAST_SEND_EMOJI_MD5_STRING, (Object) "");
                if (C5046bo.isNullOrNil(str2)) {
                    m77085ye(0);
                } else {
                    m77052Qo(str2);
                }
                mo9439AM(0);
                C46063x.m85801a(this.ofJ, null);
                AppMethodBeat.m2505o(42835);
                return true;
            }
            finish();
        } else if (c1207m instanceof C12426ao) {
            if (this.gII != null && this.gII.isShowing()) {
                this.gII.dismiss();
            }
            if (i == 0 && i2 == 0) {
                C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
                C12426ao c12426ao = (C12426ao) c1207m;
                this.obK = c12426ao.nYY;
                payInfo = new PayInfo();
                payInfo.czZ = c12426ao.nYX;
                payInfo.cIf = 37;
                payInfo.cIb = this.obL;
                C35899h.m58853a(this, payInfo, 1);
                AppMethodBeat.m2505o(42835);
                return true;
            }
            C4990ab.m7412e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
        } else if (c1207m instanceof C12427ap) {
            if (this.gII != null && this.gII.isShowing()) {
                this.gII.dismiss();
            }
            if (i == 0 && i2 == 0) {
                C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
                C12427ap c12427ap = (C12427ap) c1207m;
                this.obK = c12427ap.nYY;
                this.ocI = c12427ap.nSX;
                if (c12427ap.bLD()) {
                    C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() NetScenePrepareNewYearLuckyMoney show JumpRemind Alert");
                    c12427ap.nYe.mo39947a((Activity) this, new C3448112());
                    AppMethodBeat.m2505o(42835);
                    return true;
                }
                payInfo = new PayInfo();
                payInfo.czZ = c12427ap.nYX;
                payInfo.cIf = 37;
                payInfo.cIb = this.obL;
                C35899h.m58853a(this, payInfo, 1);
                AppMethodBeat.m2505o(42835);
                return true;
            } else if (i2 == 268502454) {
                C30379h.m48438a((Context) this, str, "", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(42809);
                        if (C12426ao.m20346m(c1207m)) {
                            LuckyMoneyNewYearSendUI.this.finish();
                            AppMethodBeat.m2505o(42809);
                            return;
                        }
                        AppMethodBeat.m2505o(42809);
                    }
                });
                AppMethodBeat.m2505o(42835);
                return true;
            } else {
                C4990ab.m7412e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
            }
        } else if (c1207m instanceof C34443al) {
            AppMethodBeat.m2505o(42835);
            return true;
        }
        AppMethodBeat.m2505o(42835);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0098 A:{SYNTHETIC, Splitter:B:21:0x0098} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(42836);
        switch (i) {
            case 1:
                C1207m c34443al;
                if (i2 == -1) {
                    int i3;
                    Map z;
                    C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay success!");
                    C7060h.pYm.mo8381e(11701, Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2));
                    if (intent != null && intent.hasExtra("key_realname_guide_helper")) {
                        RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
                        if (realnameGuideHelper != null) {
                            int i4;
                            if (realnameGuideHelper.mo74574b(this, null, new C432693())) {
                                i4 = 0;
                            } else {
                                i4 = 1;
                            }
                            i3 = i4;
                            if (this.kZa != null) {
                                C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() mEmojiInfo == null");
                            } else {
                                try {
                                    i4 = this.obK.indexOf("<wcpayinfo>");
                                    if (i4 > 0 && i4 < this.obK.length()) {
                                        StringBuilder stringBuilder = new StringBuilder();
                                        C46063x.m85806a(stringBuilder, this.kZa);
                                        StringBuilder stringBuilder2 = new StringBuilder(this.obK.substring(0, i4));
                                        stringBuilder2.append(stringBuilder).append(this.obK.substring(i4).trim());
                                        this.obK = stringBuilder2.toString();
                                    }
                                    C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() success");
                                } catch (Exception e) {
                                    C4990ab.m7417i("MicroMsg.LuckyMoneyNewYearSendUI", "dealXmlAddEmojiInfo() Exception:%s", e.getMessage());
                                }
                            }
                            z = C5049br.m7595z(this.obK, "msg");
                            if (z != null) {
                                C4990ab.m7412e("MicroMsg.LuckyMoneyNewYearSendUI", "luckymoneyNewYearSendUI onActivityResult values is null");
                                finish();
                                AppMethodBeat.m2505o(42836);
                                return;
                            }
                            if (C6964a.bKN().bKQ().mo36579Qh((String) z.get(".msg.appmsg.wcpayinfo.paymsgid"))) {
                                C4990ab.m7417i("MicroMsg.LuckyMoneyNewYearSendUI", "sendLocalMsg() for hb! mMsgXml:%s", this.obK);
                                C46063x.m85797E(this.obK, this.ofU, 3);
                            } else {
                                C4990ab.m7412e("MicroMsg.LuckyMoneyNewYearSendUI", "it is a duplicate msg");
                            }
                            if (i3 == 0) {
                                finish();
                            }
                            this.ofZ = new C37833l();
                            if (this.ogb == 1) {
                                this.ofZ.cVT = 8;
                            } else if (this.ogb == 2) {
                                this.ofZ.cVT = 6;
                            } else if (this.ogb == 3) {
                                this.ofZ.cVT = 7;
                            } else if (this.ogb == 4) {
                                this.ofZ.cVT = 14;
                            }
                            this.ofZ.ajK();
                            m77084yd(1);
                        }
                    }
                    i3 = 0;
                    if (this.kZa != null) {
                    }
                    z = C5049br.m7595z(this.obK, "msg");
                    if (z != null) {
                    }
                } else {
                    C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay cancel or failed!");
                }
                String Yz = C1853r.m3846Yz();
                if (i2 == -1) {
                    C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() resultCode == RESULT_OK");
                    this.cKs = 1;
                    this.ogm = "";
                    c34443al = new C34443al(this.ocI, this.ogi, 1, Yz, C5046bo.nullAsNil(this.ofU));
                } else {
                    if (intent != null) {
                        this.cKs = intent.getIntExtra("key_pay_reslut_type", 3);
                    } else {
                        C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearSendUI", "doNetSceneLuckyMoneyReport() data == null");
                        this.cKs = 3;
                    }
                    this.ogm = this.ocI;
                    C4990ab.m7417i("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() resultCode != RESULT_OK  payType:%s", Integer.valueOf(this.cKs));
                    c34443al = new C34443al(this.ocI, this.ogi, this.cKs, Yz, C5046bo.nullAsNil(this.ofU));
                }
                C1720g.m3535RO().eJo.mo14541a(c34443al, 0);
                AppMethodBeat.m2505o(42836);
                return;
            case FaceManager.FACE_ACQUIRED_HACKER /*1111*/:
                if (i2 != -1) {
                    C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearSendUI", "go emoji capture failed!");
                    break;
                }
                if (intent != null) {
                    this.ogh = intent.getLongExtra("key_enter_time", 0);
                }
                if (C5046bo.m7521af(this.ogh, 0)) {
                    C4990ab.m7416i("MicroMsg.LuckyMoneyNewYearSendUI", "mTimeEnter == 0L go emoji capture failed!");
                    AppMethodBeat.m2505o(42836);
                    return;
                }
                m77085ye(4);
                m77067iM(false);
                C41949b c41949b = C41949b.ezV;
                C41949b.m74082a(this.ogh, this.ogl);
                AppMethodBeat.m2505o(42836);
                return;
        }
        AppMethodBeat.m2505o(42836);
    }

    /* renamed from: a */
    static /* synthetic */ void m77054a(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        AppMethodBeat.m2504i(42837);
        C28459a.m45139a(luckyMoneyNewYearSendUI, luckyMoneyNewYearSendUI.odY);
        luckyMoneyNewYearSendUI.odS.dismiss();
        AppMethodBeat.m2505o(42837);
    }

    /* renamed from: b */
    static /* synthetic */ void m77059b(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        AppMethodBeat.m2504i(42838);
        luckyMoneyNewYearSendUI.m77086yf(0);
        AppMethodBeat.m2505o(42838);
    }

    /* renamed from: e */
    static /* synthetic */ void m77062e(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        AppMethodBeat.m2504i(42840);
        if (C5046bo.m7563gW(luckyMoneyNewYearSendUI.nYM, 1)) {
            if (C5046bo.m7563gW(luckyMoneyNewYearSendUI.ofW, 1)) {
                C36356d c36356d = new C36356d(luckyMoneyNewYearSendUI.mController.ylL, 1, false);
                c36356d.rBl = new C212318();
                c36356d.rBm = new C212329();
                c36356d.cpD();
            } else {
                luckyMoneyNewYearSendUI.bMF();
                AppMethodBeat.m2505o(42840);
                return;
            }
        }
        AppMethodBeat.m2505o(42840);
    }
}
