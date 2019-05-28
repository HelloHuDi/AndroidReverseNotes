package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C17918t.C17917a;
import com.tencent.p177mm.api.C8955k;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C18175j;
import com.tencent.p177mm.emoji.view.BaseEmojiView;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelstat.C26483d;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18372qb;
import com.tencent.p177mm.p230g.p231a.C26157hq;
import com.tencent.p177mm.p230g.p232b.p233a.C26296y;
import com.tencent.p177mm.p230g.p232b.p233a.C9499aa;
import com.tencent.p177mm.p230g.p232b.p233a.C9516z;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p612ui.KeyboardLinearLayout.C44246a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30396s;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.MMEditText.C5620a;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.plugin.emoji.model.C20378d.C11556a;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.emoji.p726f.C27737e;
import com.tencent.p177mm.plugin.emojicapture.api.C20423c;
import com.tencent.p177mm.plugin.gif.MMAnimateView;
import com.tencent.p177mm.plugin.luckymoney.model.C12425af;
import com.tencent.p177mm.plugin.luckymoney.model.C12428k;
import com.tencent.p177mm.plugin.luckymoney.model.C21198ar;
import com.tencent.p177mm.plugin.luckymoney.model.C36785am;
import com.tencent.p177mm.plugin.luckymoney.model.C39318at;
import com.tencent.p177mm.plugin.luckymoney.model.C39323w;
import com.tencent.p177mm.plugin.luckymoney.model.C43255as;
import com.tencent.p177mm.plugin.luckymoney.model.C46063x;
import com.tencent.p177mm.plugin.luckymoney.model.LuckyMoneyEmojiSwitch;
import com.tencent.p177mm.plugin.luckymoney.p449ui.C21249h.C21253c;
import com.tencent.p177mm.plugin.luckymoney.p449ui.C43285k.C28461a;
import com.tencent.p177mm.plugin.luckymoney.p449ui.C46064a.C34503a;
import com.tencent.p177mm.plugin.luckymoney.p449ui.LuckyMoneyWishFooter.C12468b;
import com.tencent.p177mm.plugin.luckymoney.p449ui.p1406a.C28459a;
import com.tencent.p177mm.plugin.luckymoney.p987a.C12405a;
import com.tencent.p177mm.plugin.luckymoney.particles.C12433e;
import com.tencent.p177mm.plugin.luckymoney.particles.C28431d;
import com.tencent.p177mm.plugin.luckymoney.particles.C34448b;
import com.tencent.p177mm.plugin.luckymoney.particles.C34449c;
import com.tencent.p177mm.plugin.luckymoney.particles.C39324a;
import com.tencent.p177mm.plugin.luckymoney.particles.p1280a.C21210a;
import com.tencent.p177mm.plugin.luckymoney.particles.p1280a.C28430b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22583ab;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.pluginsdk.C40437i;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44081e;
import com.tencent.p177mm.protocal.protobuf.C23399hv;
import com.tencent.p177mm.protocal.protobuf.C40588xx;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.soter.core.biometric.FaceManager;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@C5271a(1)
/* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI */
public class LuckyMoneyDetailUI extends LuckyMoneyBaseUI {
    /* renamed from: Lp */
    private int f16174Lp = 0;
    private View abB;
    private String emo;
    private Dialog gII;
    private boolean hZu = false;
    private TextView kEq;
    private TextView kGq;
    private C11556a kVj = new C3447422();
    private String kWO;
    private EmojiInfo kZa;
    private View kZq;
    private ImageView lBT;
    private TextView nSD;
    private ListView nSL;
    private ImageView nSM;
    private TextView nSN;
    private ImageView nSO;
    private View nSP;
    private View nSQ;
    OnScrollListener nSS = new C284361();
    private List<C39323w> nSx = new LinkedList();
    private SoundPool nTR;
    private C34448b nVt = new C1243912();
    private int nXi = -1;
    private TextView nsq;
    private LuckyMoneyWishFooter ocC;
    private View ocE;
    private boolean ocG = true;
    private int ocH;
    private String ocI;
    private String ocJ;
    private String ocK;
    private String ocL;
    private Map<String, Integer> ocN = new HashMap();
    private C21256i ocO;
    private String ocP = "";
    private boolean ocQ = false;
    private TextView odA;
    private TextView odB;
    private ViewGroup odC;
    private RelativeLayout odD;
    private int[] odE;
    private ViewGroup odF;
    private RelativeLayout odG;
    private BaseEmojiView odH;
    private TextView odI;
    private LinearLayout odJ;
    private MMAnimateView odK;
    private LinearLayout odL;
    private LinearLayout odM;
    private RelativeLayout odN;
    private LinearLayout odO;
    private BaseEmojiView odP;
    private RelativeLayout odQ;
    private ImageView odR;
    private C46064a odS;
    private View odT;
    private ImageView odU;
    private FrameLayout odV;
    private boolean odW = false;
    private int odX;
    private ChatFooterPanel odY;
    private EmojiInfo odZ;
    private CdnImageView odq;
    private ImageView odr;
    private View ods;
    private ImageView odt;
    private TextView odu;
    private ViewGroup odv;
    private ViewGroup odw;
    private View odx;
    private View ody;
    private View odz;
    private ViewGroup oea;
    public LuckyMoneyEmojiSwitch oeb;
    private C9499aa oec;
    private C26296y oed;
    private C9516z oee;
    private int oef = 0;
    private boolean oeg = false;
    private Bitmap oeh;
    private Bitmap oei;
    private Bitmap oej;
    private Bitmap oek;
    private Bitmap oel;
    private Bitmap oem;
    private Bitmap oen;
    private Bitmap oeo;
    private boolean oep = false;
    private int oeq;
    private View oer;
    private long oes = 0;
    private OnClickListener oet = new C3933413();
    private int oeu = 3;
    private C1202f oev = new C3933215();
    private int oew = 0;
    private int oex = 0;
    private final int oey = 750;
    private final int oez = 240;

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$8 */
    class C34058 implements OnClickListener {
        C34058() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42653);
            LuckyMoneyDetailUI.this.ocC.setVisibility(0);
            AppMethodBeat.m2505o(42653);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$9 */
    class C34069 implements C30111a {

        /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$9$1 */
        class C34071 implements Runnable {
            C34071() {
            }

            public final void run() {
                AppMethodBeat.m2504i(42654);
                LuckyMoneyDetailUI.this.finish();
                AppMethodBeat.m2505o(42654);
            }
        }

        C34069() {
        }

        /* renamed from: a */
        public final void mo6399a(boolean z, String str, int i) {
            int i2 = 1;
            AppMethodBeat.m2504i(42655);
            LuckyMoneyDetailUI.this.aqX();
            LuckyMoneyDetailUI.this.oed = new C26296y();
            if (z) {
                LuckyMoneyDetailUI.this.oed.cVT = 5;
                LuckyMoneyDetailUI.this.oee = new C9516z();
                if (LuckyMoneyDetailUI.this.oef == 0 || LuckyMoneyDetailUI.this.oef == 2) {
                    if (!C2933b.m5226x(LuckyMoneyDetailUI.this.odZ)) {
                        i2 = C2933b.m5225w(LuckyMoneyDetailUI.this.odZ) ? 3 : 2;
                    }
                } else if (LuckyMoneyDetailUI.this.oef != 1) {
                    i2 = 0;
                }
                LuckyMoneyDetailUI.this.oee.cYk = (long) i2;
                LuckyMoneyDetailUI.this.oee.mo20805eV(LuckyMoneyDetailUI.this.odZ.mo20410Aq());
                if (C5046bo.isNullOrNil(str)) {
                    LuckyMoneyDetailUI.this.oee.cYm = 1;
                } else {
                    LuckyMoneyDetailUI.this.oee.cYm = 2;
                }
                LuckyMoneyDetailUI.this.oee.ajK();
                LuckyMoneyDetailUI.m67039a(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.this.emo, str, LuckyMoneyDetailUI.this.odZ.mo20410Aq());
                LuckyMoneyDetailUI.m67044b(LuckyMoneyDetailUI.this, 3);
                C30396s.m48490a(LuckyMoneyDetailUI.this.mController.ylL.getResources().getString(C25738R.string.cbn), LuckyMoneyDetailUI.this.mController.ylL);
                C5004al.m7442n(new C34071(), 500);
            } else {
                LuckyMoneyDetailUI.this.oed.cVT = 6;
            }
            LuckyMoneyDetailUI.this.oed.ajK();
            AppMethodBeat.m2505o(42655);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$10 */
    class C1243810 implements OnClickListener {
        C1243810() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42656);
            LuckyMoneyDetailUI.this.oed = new C26296y();
            LuckyMoneyDetailUI.this.oed.cVT = 7;
            LuckyMoneyDetailUI.this.oed.ajK();
            LuckyMoneyDetailUI.m67010B(LuckyMoneyDetailUI.this);
            AppMethodBeat.m2505o(42656);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$12 */
    class C1243912 implements C34448b {
        C1243912() {
        }

        /* renamed from: b */
        public final C28430b mo24309b(Random random) {
            AppMethodBeat.m2504i(42659);
            C28430b c21210a;
            switch (random.nextInt(8)) {
                case 0:
                    if (LuckyMoneyDetailUI.this.oem == null) {
                        LuckyMoneyDetailUI.this.oem = LuckyMoneyDetailUI.m67031a(LuckyMoneyDetailUI.this, (int) C25738R.drawable.b9_);
                    }
                    c21210a = new C21210a(LuckyMoneyDetailUI.this.oem);
                    AppMethodBeat.m2505o(42659);
                    return c21210a;
                case 1:
                    if (LuckyMoneyDetailUI.this.oen == null) {
                        LuckyMoneyDetailUI.this.oen = LuckyMoneyDetailUI.m67031a(LuckyMoneyDetailUI.this, (int) C25738R.drawable.b9a);
                    }
                    c21210a = new C21210a(LuckyMoneyDetailUI.this.oen);
                    AppMethodBeat.m2505o(42659);
                    return c21210a;
                case 2:
                    if (LuckyMoneyDetailUI.this.oeo == null) {
                        LuckyMoneyDetailUI.this.oeo = LuckyMoneyDetailUI.m67031a(LuckyMoneyDetailUI.this, (int) C25738R.drawable.b9b);
                    }
                    c21210a = new C21210a(LuckyMoneyDetailUI.this.oeo);
                    AppMethodBeat.m2505o(42659);
                    return c21210a;
                case 3:
                    if (LuckyMoneyDetailUI.this.oeh == null) {
                        LuckyMoneyDetailUI.this.oeh = LuckyMoneyDetailUI.m67031a(LuckyMoneyDetailUI.this, (int) C25738R.drawable.b95);
                    }
                    c21210a = new C21210a(LuckyMoneyDetailUI.this.oeh);
                    AppMethodBeat.m2505o(42659);
                    return c21210a;
                case 4:
                    if (LuckyMoneyDetailUI.this.oei == null) {
                        LuckyMoneyDetailUI.this.oei = LuckyMoneyDetailUI.m67031a(LuckyMoneyDetailUI.this, (int) C25738R.drawable.b96);
                    }
                    c21210a = new C21210a(LuckyMoneyDetailUI.this.oei);
                    AppMethodBeat.m2505o(42659);
                    return c21210a;
                case 5:
                    if (LuckyMoneyDetailUI.this.oej == null) {
                        LuckyMoneyDetailUI.this.oej = LuckyMoneyDetailUI.m67031a(LuckyMoneyDetailUI.this, (int) C25738R.drawable.b97);
                    }
                    c21210a = new C21210a(LuckyMoneyDetailUI.this.oej);
                    AppMethodBeat.m2505o(42659);
                    return c21210a;
                case 6:
                    if (LuckyMoneyDetailUI.this.oek == null) {
                        LuckyMoneyDetailUI.this.oek = LuckyMoneyDetailUI.m67031a(LuckyMoneyDetailUI.this, (int) C25738R.drawable.b98);
                    }
                    c21210a = new C21210a(LuckyMoneyDetailUI.this.oek);
                    AppMethodBeat.m2505o(42659);
                    return c21210a;
                case 7:
                    if (LuckyMoneyDetailUI.this.oel == null) {
                        LuckyMoneyDetailUI.this.oel = LuckyMoneyDetailUI.m67031a(LuckyMoneyDetailUI.this, (int) C25738R.drawable.b99);
                    }
                    c21210a = new C21210a(LuckyMoneyDetailUI.this.oel);
                    AppMethodBeat.m2505o(42659);
                    return c21210a;
                default:
                    AppMethodBeat.m2505o(42659);
                    return null;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$25 */
    class C1244025 implements Runnable {
        C1244025() {
        }

        public final void run() {
            AppMethodBeat.m2504i(42675);
            LuckyMoneyDetailUI.this.oeq = LuckyMoneyDetailUI.this.kZq.getHeight();
            C4990ab.m7411d("MicroMsg.LuckyMoneyDetailUI", "get footer height: %s", Integer.valueOf(LuckyMoneyDetailUI.this.oeq));
            AppMethodBeat.m2505o(42675);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$26 */
    class C1244126 implements Runnable {
        C1244126() {
        }

        public final void run() {
            AppMethodBeat.m2504i(42676);
            if (LuckyMoneyDetailUI.this.odC.getVisibility() == 8 && LuckyMoneyDetailUI.this.odB.getVisibility() == 8 && LuckyMoneyDetailUI.this.odA.getVisibility() == 8) {
                LuckyMoneyDetailUI.this.nSL.removeFooterView(LuckyMoneyDetailUI.this.kZq);
                AppMethodBeat.m2505o(42676);
                return;
            }
            int ge = (C1338a.m2869ge(LuckyMoneyDetailUI.this.mController.ylL) - C5230ak.m7989hF(LuckyMoneyDetailUI.this)) - C30036f.m47542de(LuckyMoneyDetailUI.this);
            int measuredHeight = LuckyMoneyDetailUI.this.nSL.getMeasuredHeight();
            int fromDPToPix = C1338a.fromDPToPix(LuckyMoneyDetailUI.this.mController.ylL, 29);
            int fromDPToPix2 = C1338a.fromDPToPix(LuckyMoneyDetailUI.this.mController.ylL, 16);
            if (measuredHeight < ge) {
                LuckyMoneyDetailUI.this.kZq.setPadding(0, fromDPToPix + (ge - LuckyMoneyDetailUI.this.nSL.getMeasuredHeight()), 0, fromDPToPix2);
            } else {
                LuckyMoneyDetailUI.this.kZq.setPadding(0, fromDPToPix, 0, fromDPToPix2);
            }
            C4990ab.m7411d("MicroMsg.LuckyMoneyDetailUI", "winHeight:%s showHeight:%s recordHeight:%s", Integer.valueOf(r0), Integer.valueOf(ge), Integer.valueOf(measuredHeight));
            AppMethodBeat.m2505o(42676);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$2 */
    class C124422 implements C34503a {
        C124422() {
        }

        public final void bMl() {
            AppMethodBeat.m2504i(42647);
            LuckyMoneyDetailUI.m67073s(LuckyMoneyDetailUI.this);
            AppMethodBeat.m2505o(42647);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$30 */
    class C1244330 implements OnItemClickListener {
        C1244330() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(42680);
            LuckyMoneyDetailUI.m67072r(LuckyMoneyDetailUI.this);
            AppMethodBeat.m2505o(42680);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$19 */
    class C2122119 implements Runnable {
        C2122119() {
        }

        public final void run() {
            AppMethodBeat.m2504i(42668);
            C4990ab.m7411d("MicroMsg.LuckyMoneyDetailUI", "header height: %s", Integer.valueOf(C4977b.m7371b(LuckyMoneyDetailUI.this.mController.ylL, 526.0f) + LuckyMoneyDetailUI.this.oew));
            LayoutParams layoutParams = LuckyMoneyDetailUI.this.oer.getLayoutParams();
            layoutParams.height = r0;
            LuckyMoneyDetailUI.this.oer.setLayoutParams(layoutParams);
            AppMethodBeat.m2505o(42668);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$11 */
    class C2843311 implements C17917a {
        C2843311() {
        }

        /* renamed from: a */
        public final void mo7169a(C8955k c8955k) {
            AppMethodBeat.m2504i(42657);
            C4990ab.m7417i("MicroMsg.LuckyMoneyDetailUI", "[onSelectedEmoji] emojiInfo:%s", c8955k);
            LuckyMoneyDetailUI.m67038a(LuckyMoneyDetailUI.this, c8955k.mo20410Aq());
            LuckyMoneyDetailUI.m67010B(LuckyMoneyDetailUI.this);
            LuckyMoneyDetailUI.m67073s(LuckyMoneyDetailUI.this);
            AppMethodBeat.m2505o(42657);
        }

        public final void onHide() {
            AppMethodBeat.m2504i(138989);
            LuckyMoneyDetailUI.m67073s(LuckyMoneyDetailUI.this);
            AppMethodBeat.m2505o(138989);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$18 */
    class C2843518 implements Runnable {
        C2843518() {
        }

        public final void run() {
            AppMethodBeat.m2504i(42667);
            ViewGroup J = LuckyMoneyDetailUI.this.odF;
            C34448b K = LuckyMoneyDetailUI.this.nVt;
            C39324a c39324a = new C39324a(J);
            C34449c aH = new C34449c(J.getContext(), K, new C28431d(-100, J.getHeight() / 2), J).mo54982R(600.0f, 150.0f).mo54983S(-1000.0f, 250.0f).mo54985aG(-200.0f).mo54986aH(1500.0f);
            aH.oal = 600.0f;
            aH.oam = 300.0f;
            aH = aH.bLH();
            aH.nZO = C12433e.bLQ();
            c39324a.nZD = aH.bLI().bLJ();
            c39324a.mo62213P(100, 400);
            J = LuckyMoneyDetailUI.this.odF;
            K = LuckyMoneyDetailUI.this.nVt;
            c39324a = new C39324a(J);
            aH = new C34449c(J.getContext(), K, new C28431d(J.getWidth() + 100, J.getHeight() / 2), J).mo54982R(-600.0f, 150.0f).mo54983S(-1000.0f, 250.0f).mo54985aG(200.0f).mo54986aH(1500.0f);
            aH.oal = 600.0f;
            aH.oam = 300.0f;
            aH = aH.bLH();
            aH.nZO = C12433e.bLQ();
            c39324a.nZD = aH.bLI().bLJ();
            c39324a.mo62213P(100, 400);
            AppMethodBeat.m2505o(42667);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$1 */
    class C284361 implements OnScrollListener {
        private boolean nST = false;
        private boolean nSU;

        C284361() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(42645);
            if (absListView.getCount() == 0) {
                AppMethodBeat.m2505o(42645);
                return;
            }
            switch (i) {
                case 0:
                    if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                        if (!LuckyMoneyDetailUI.this.ocz.bLA()) {
                            LuckyMoneyDetailUI.this.hZu = false;
                        }
                        if (LuckyMoneyDetailUI.this.ocG && !LuckyMoneyDetailUI.this.hZu) {
                            LuckyMoneyDetailUI.m67051d(LuckyMoneyDetailUI.this);
                        }
                    }
                    this.nST = false;
                    AppMethodBeat.m2505o(42645);
                    return;
                case 1:
                    this.nST = true;
                    break;
            }
            AppMethodBeat.m2505o(42645);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            boolean z = true;
            AppMethodBeat.m2504i(42646);
            if (i3 == 0 || !this.nST) {
                AppMethodBeat.m2505o(42646);
                return;
            }
            if (i <= 0) {
                int top;
                View childAt = absListView.getChildAt(i);
                if (childAt != null) {
                    top = 0 - childAt.getTop();
                } else {
                    top = 0;
                }
                if (top <= 100) {
                    z = false;
                }
            }
            if (this.nSU != z) {
                if (z) {
                    LuckyMoneyDetailUI.this.getResources().getDrawable(C25738R.drawable.b8e);
                }
                this.nSU = z;
            }
            AppMethodBeat.m2505o(42646);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$31 */
    class C2843731 implements OnClickListener {
        C2843731() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42681);
            LuckyMoneyDetailUI.m67040a(LuckyMoneyDetailUI.this, true);
            AppMethodBeat.m2505o(42681);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$3 */
    class C284383 implements C5620a {
        C284383() {
        }

        public final void bMu() {
            AppMethodBeat.m2504i(42648);
            if (LuckyMoneyDetailUI.this.ocC.getVisibility() == 0) {
                LuckyMoneyDetailUI.this.ocC.setVisibility(8);
                AppMethodBeat.m2505o(42648);
                return;
            }
            LuckyMoneyDetailUI.this.mController.ylL.finish();
            AppMethodBeat.m2505o(42648);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$21 */
    class C3447321 implements Runnable {
        C3447321() {
        }

        public final void run() {
            AppMethodBeat.m2504i(42670);
            LuckyMoneyDetailUI.m67023O(LuckyMoneyDetailUI.this);
            LuckyMoneyDetailUI.this.odD.setVisibility(0);
            AppMethodBeat.m2505o(42670);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$22 */
    class C3447422 implements C11556a {
        C3447422() {
        }

        /* renamed from: a */
        public final void mo23264a(final boolean z, final EmojiInfo emojiInfo) {
            AppMethodBeat.m2504i(42672);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(42671);
                    if (!(emojiInfo == null || LuckyMoneyDetailUI.this.kZa == null || !LuckyMoneyDetailUI.this.kZa.mo20410Aq().equals(emojiInfo.mo20410Aq()))) {
                        if (z) {
                            C4990ab.m7416i("MicroMsg.LuckyMoneyDetailUI", "somethings success.");
                            LuckyMoneyDetailUI.this.kZa = C42952j.getEmojiStorageMgr().xYn.aqi(LuckyMoneyDetailUI.this.kZa.mo20410Aq());
                            LuckyMoneyDetailUI.this.odJ.setVisibility(8);
                            LuckyMoneyDetailUI.this.odH.setVisibility(0);
                            LuckyMoneyDetailUI.m67045b(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.this.kZa);
                            AppMethodBeat.m2505o(42671);
                            return;
                        }
                        C4990ab.m7416i("MicroMsg.LuckyMoneyDetailUI", "somethings error.");
                        LuckyMoneyDetailUI.this.odJ.setVisibility(8);
                        LuckyMoneyDetailUI.this.odI.setVisibility(0);
                    }
                    AppMethodBeat.m2505o(42671);
                }
            });
            AppMethodBeat.m2505o(42672);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$27 */
    class C3447627 implements OnMenuItemClickListener {
        C3447627() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(42677);
            C7060h.pYm.mo8381e(11701, Integer.valueOf(LuckyMoneyDetailUI.m67083ya(LuckyMoneyDetailUI.this.nXi)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4));
            Intent intent = new Intent();
            intent.setClass(LuckyMoneyDetailUI.this.mController.ylL, LuckyMoneyMyRecordUI.class);
            intent.putExtra("key_type", 2);
            LuckyMoneyDetailUI.this.startActivity(intent);
            AppMethodBeat.m2505o(42677);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$6 */
    class C344776 implements C44246a {
        C344776() {
        }

        /* renamed from: sD */
        public final void mo7486sD(int i) {
            AppMethodBeat.m2504i(42651);
            if (i == -2) {
                if (LuckyMoneyDetailUI.this.ocC.oil) {
                    LuckyMoneyDetailUI.this.ocC.setModeClick(false);
                    AppMethodBeat.m2505o(42651);
                    return;
                }
                LuckyMoneyDetailUI.this.ocC.setVisibility(8);
            }
            AppMethodBeat.m2505o(42651);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$28 */
    class C3932728 implements OnMenuItemClickListener {
        C3932728() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(42678);
            LuckyMoneyDetailUI.this.finish();
            AppMethodBeat.m2505o(42678);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$32 */
    class C3932832 implements OnClickListener {
        C3932832() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42682);
            LuckyMoneyDetailUI.m67073s(LuckyMoneyDetailUI.this);
            AppMethodBeat.m2505o(42682);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$7 */
    class C393297 implements OnClickListener {
        C393297() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42652);
            LuckyMoneyDetailUI.this.ocC.setVisibility(0);
            AppMethodBeat.m2505o(42652);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$4 */
    class C393304 implements C12468b {
        C393304() {
        }

        /* renamed from: Qm */
        public final void mo24307Qm(String str) {
            AppMethodBeat.m2504i(42649);
            if (!(C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(LuckyMoneyDetailUI.this.ocJ))) {
                LuckyMoneyDetailUI.this.mo24301b(new C36785am(LuckyMoneyDetailUI.this.ocI, str, LuckyMoneyDetailUI.this.ocJ, "v1.0"), false);
                LuckyMoneyDetailUI.m67072r(LuckyMoneyDetailUI.this);
            }
            AppMethodBeat.m2505o(42649);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$14 */
    class C3933114 implements DialogInterface.OnClickListener {
        C3933114() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(42663);
            C4990ab.m7416i("MicroMsg.LuckyMoneyDetailUI", "RealnameGuideHelper dialog click cancel");
            LuckyMoneyDetailUI.m67013E(LuckyMoneyDetailUI.this);
            AppMethodBeat.m2505o(42663);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$15 */
    class C3933215 implements C1202f {
        C3933215() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(42664);
            if (C5046bo.m7563gW(c1207m.getType(), 697) && (c1207m instanceof C27737e)) {
                C27737e c27737e = (C27737e) c1207m;
                if (i == 0 && i2 == 0) {
                    C23399hv bku = c27737e.bku();
                    if (bku != null && bku.vKl != null && bku.vKl.size() > 0 && C5046bo.isEqual(((C40588xx) bku.vKl.get(0)).Md5, LuckyMoneyDetailUI.this.kZa.mo20410Aq())) {
                        LuckyMoneyDetailUI.m67040a(LuckyMoneyDetailUI.this, false);
                    }
                }
            }
            AppMethodBeat.m2505o(42664);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$16 */
    class C3933316 implements OnCancelListener {
        C3933316() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(42665);
            if (LuckyMoneyDetailUI.this.gII != null && LuckyMoneyDetailUI.this.gII.isShowing()) {
                LuckyMoneyDetailUI.this.gII.dismiss();
            }
            LuckyMoneyDetailUI.this.ocz.bLz();
            if (LuckyMoneyDetailUI.this.mController.contentView.getVisibility() == 8 || LuckyMoneyDetailUI.this.mController.contentView.getVisibility() == 4) {
                C4990ab.m7416i("MicroMsg.LuckyMoneyDetailUI", "user cancel & finish");
                LuckyMoneyDetailUI.this.finish();
            }
            AppMethodBeat.m2505o(42665);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$13 */
    class C3933413 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$13$2 */
        class C212202 implements C5279d {
            C212202() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(42661);
                C4990ab.m7417i("MicroMsg.LuckyMoneyDetailUI", "showLuckyHbDlg() onMMMenuItemSelected menuItemId:%s", Integer.valueOf(menuItem.getItemId()));
                switch (menuItem.getItemId()) {
                    case 1:
                        C20423c.m31582h(LuckyMoneyDetailUI.this, null, 5);
                        LuckyMoneyDetailUI.this.oed = new C26296y();
                        LuckyMoneyDetailUI.this.oed.cVT = 4;
                        LuckyMoneyDetailUI.this.oed.ajK();
                        LuckyMoneyDetailUI.this.oef = 1;
                        AppMethodBeat.m2505o(42661);
                        return;
                    case 2:
                        LuckyMoneyDetailUI.m67011C(LuckyMoneyDetailUI.this);
                        AppMethodBeat.m2505o(42661);
                        return;
                    case 3:
                        LuckyMoneyDetailUI.this.kZa = null;
                        LuckyMoneyDetailUI.this.oed = new C26296y();
                        LuckyMoneyDetailUI.this.oed.cVT = 8;
                        LuckyMoneyDetailUI.this.oed.ajK();
                        LuckyMoneyDetailUI.m67044b(LuckyMoneyDetailUI.this, 1);
                        break;
                }
                AppMethodBeat.m2505o(42661);
            }
        }

        C3933413() {
        }

        public final void onClick(final View view) {
            AppMethodBeat.m2504i(42662);
            LuckyMoneyDetailUI.this.oed = new C26296y();
            if (C5046bo.m7563gW(view.getId(), 2131825476)) {
                LuckyMoneyDetailUI.this.oed.cVT = 1;
                LuckyMoneyDetailUI.this.oed.ajK();
            }
            if (C5046bo.m7563gW(LuckyMoneyDetailUI.this.oeb.nXs, 0) && C5046bo.m7500C(view.getTag(), "nodelete")) {
                LuckyMoneyDetailUI.m67011C(LuckyMoneyDetailUI.this);
                AppMethodBeat.m2505o(42662);
                return;
            }
            C36356d c36356d = new C36356d(LuckyMoneyDetailUI.this.mController.ylL, 1, false);
            c36356d.rBl = new C36073c() {
                /* renamed from: a */
                public final void mo5746a(C44273l c44273l) {
                    AppMethodBeat.m2504i(42660);
                    CharSequence string = LuckyMoneyDetailUI.this.getString(C25738R.string.csz);
                    if (C5046bo.m7563gW(LuckyMoneyDetailUI.this.oeb.nXs, 0)) {
                        string = LuckyMoneyDetailUI.this.getString(C25738R.string.cql);
                    } else {
                        c44273l.mo70072hi(1, C25738R.string.cry);
                    }
                    c44273l.mo70068e(2, string);
                    if (!C5046bo.m7500C(view.getTag(), "nodelete")) {
                        c44273l.mo70048a(3, LuckyMoneyDetailUI.this.getResources().getColor(C25738R.color.f12157ub), LuckyMoneyDetailUI.this.mController.ylL.getString(C25738R.string.cqf));
                    }
                    AppMethodBeat.m2505o(42660);
                }
            };
            c36356d.rBm = new C212202();
            LuckyMoneyDetailUI.this.oed.cVT = 2;
            LuckyMoneyDetailUI.this.oed.ajK();
            c36356d.cpD();
            AppMethodBeat.m2505o(42662);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$29 */
    class C3933529 implements OnClickListener {
        C3933529() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42679);
            LuckyMoneyDetailUI.m67072r(LuckyMoneyDetailUI.this);
            AppMethodBeat.m2505o(42679);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI$5 */
    class C393365 implements Runnable {
        C393365() {
        }

        public final void run() {
            AppMethodBeat.m2504i(42650);
            C18175j.m28619r(LuckyMoneyDetailUI.this);
            AppMethodBeat.m2505o(42650);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public LuckyMoneyDetailUI() {
        AppMethodBeat.m2504i(42683);
        AppMethodBeat.m2505o(42683);
    }

    /* renamed from: B */
    static /* synthetic */ void m67010B(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        AppMethodBeat.m2504i(42714);
        luckyMoneyDetailUI.bMv();
        AppMethodBeat.m2505o(42714);
    }

    /* renamed from: E */
    static /* synthetic */ void m67013E(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        AppMethodBeat.m2504i(42717);
        super.finish();
        AppMethodBeat.m2505o(42717);
    }

    /* renamed from: r */
    static /* synthetic */ void m67072r(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        AppMethodBeat.m2504i(42709);
        luckyMoneyDetailUI.bMt();
        AppMethodBeat.m2505o(42709);
    }

    /* renamed from: ya */
    static /* synthetic */ int m67083ya(int i) {
        AppMethodBeat.m2504i(42708);
        int xW = LuckyMoneyDetailUI.m67079xW(i);
        AppMethodBeat.m2505o(42708);
        return xW;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(42684);
        super.onCreate(bundle);
        getWindow().setBackgroundDrawableResource(C25738R.color.a69);
        overridePendingTransition(getIntent().getBooleanExtra("key_anim_slide", false) ? C25738R.anim.f8403df : C25738R.anim.f8362c4, 0);
        mo17446xE(getResources().getColor(C25738R.color.f12154u9));
        dyb();
        initView();
        this.oeg = getIntent().getBooleanExtra("key_lucky_money_can_received", false);
        this.emo = getIntent().getStringExtra("key_username");
        this.ocI = getIntent().getStringExtra("key_sendid");
        this.ocK = getIntent().getStringExtra("key_native_url");
        this.ocH = getIntent().getIntExtra("key_jump_from", 2);
        this.ocP = getIntent().getStringExtra("key_process_content");
        C4990ab.m7416i("MicroMsg.LuckyMoneyDetailUI", "sendid=" + C5046bo.nullAsNil(this.ocI) + ", nativeurl=" + C5046bo.nullAsNil(this.ocK) + ", jumpFrom=" + this.ocH);
        if (C5046bo.isNullOrNil(this.ocI) && !C5046bo.isNullOrNil(this.ocK)) {
            try {
                this.ocI = Uri.parse(this.ocK).getQueryParameter("sendid");
            } catch (Exception e) {
            }
        }
        try {
            byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_detail_info");
            this.kWO = getIntent().getStringExtra("key_detail_emoji_md5");
            this.odX = getIntent().getIntExtra("key_detail_emoji_type", 0);
            if (!C5046bo.isNullOrNil(this.kWO)) {
                this.oec = new C9499aa();
                this.oec.cVT = 10;
                this.oec.ajK();
            }
            this.oeb = (LuckyMoneyEmojiSwitch) getIntent().getParcelableExtra("key_emoji_switch");
            if (this.oeb == null) {
                this.oeb = new LuckyMoneyEmojiSwitch();
            }
            if (byteArrayExtra != null) {
                C12428k c12428k = (C12428k) new C12428k().parseFrom(byteArrayExtra);
                if (c12428k != null) {
                    m67036a(c12428k);
                } else {
                    finish();
                }
            }
        } catch (Exception e2) {
            C4990ab.m7420w("MicroMsg.LuckyMoneyDetailUI", "Parse LuckyMoneyDetail fail!" + e2.getLocalizedMessage());
            finish();
        }
        if (getIntent().getBooleanExtra("play_sound", false)) {
            C43285k.m77151a(this, C28461a.NOTSET);
        }
        addTextOptionMenu(0, getString(C25738R.string.cqc), new C3447627());
        mo17373Nc(getResources().getColor(C25738R.color.f12144tx));
        AppMethodBeat.m2505o(42684);
    }

    public boolean enableActivityAnimation() {
        return false;
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        AppMethodBeat.m2504i(42685);
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu);
        TextView textView = (TextView) findViewById(2131820958);
        if (textView != null) {
            textView.setTextColor(getResources().getColor(C25738R.color.f12140tt));
        }
        AppMethodBeat.m2505o(42685);
        return onCreatePanelMenu;
    }

    public void onResume() {
        AppMethodBeat.m2504i(42686);
        super.onResume();
        this.oes = C5046bo.anT();
        AppMethodBeat.m2505o(42686);
    }

    public void onPause() {
        AppMethodBeat.m2504i(42687);
        super.onPause();
        C26483d.m42198h("LuckyMoneyDetailUI", this.oes, C5046bo.anT());
        AppMethodBeat.m2505o(42687);
    }

    public final void initView() {
        AppMethodBeat.m2504i(42688);
        setMMTitle("");
        setBackBtn(new C3932728());
        this.nSL = (ListView) findViewById(2131825494);
        this.ocO = new C21256i(this.mController.ylL);
        this.abB = LayoutInflater.from(this).inflate(2130969975, null);
        this.nSL.addHeaderView(this.abB);
        this.nSL.setAdapter(this.ocO);
        this.abB.setOnClickListener(new C3933529());
        this.nSL.setOnScrollListener(this.nSS);
        this.nSL.setOnItemClickListener(new C1244330());
        this.kZq = LayoutInflater.from(this).inflate(2130969973, null);
        this.nSM = (ImageView) this.abB.findViewById(2131825442);
        this.nSN = (TextView) this.abB.findViewById(2131825444);
        this.nSO = (ImageView) this.abB.findViewById(2131825445);
        this.nsq = (TextView) this.abB.findViewById(2131825446);
        this.odG = (RelativeLayout) findViewById(2131825469);
        this.odH = (BaseEmojiView) findViewById(2131825470);
        this.odI = (TextView) findViewById(2131825471);
        this.odJ = (LinearLayout) findViewById(2131825472);
        this.odK = (MMAnimateView) findViewById(2131825473);
        this.nSP = this.abB.findViewById(2131825447);
        this.nSD = (TextView) this.abB.findViewById(2131825448);
        this.nSQ = this.abB.findViewById(2131825450);
        this.kGq = (TextView) this.abB.findViewById(2131825452);
        this.odq = (CdnImageView) this.abB.findViewById(2131825451);
        this.kEq = (TextView) this.abB.findViewById(2131825464);
        this.odr = (ImageView) this.abB.findViewById(2131825441);
        this.ocE = this.abB.findViewById(2131825455);
        this.ods = this.abB.findViewById(2131825453);
        this.odt = (ImageView) this.abB.findViewById(2131825454);
        this.odL = (LinearLayout) findViewById(2131825475);
        this.odM = (LinearLayout) findViewById(2131825476);
        this.odN = (RelativeLayout) findViewById(2131825479);
        this.odO = (LinearLayout) findViewById(2131825484);
        this.odP = (BaseEmojiView) findViewById(2131825480);
        this.odQ = (RelativeLayout) findViewById(2131825483);
        this.odR = (ImageView) findViewById(2131825482);
        this.odu = (TextView) this.abB.findViewById(2131825466);
        this.odv = (ViewGroup) this.abB.findViewById(2131825489);
        this.odw = (ViewGroup) this.abB.findViewById(2131825485);
        this.odx = findViewById(2131825487);
        this.ody = findViewById(2131825486);
        this.odz = findViewById(2131825488);
        this.odD = (RelativeLayout) this.abB.findViewById(2131825453);
        this.lBT = (ImageView) this.abB.findViewById(2131825454);
        this.ocC = (LuckyMoneyWishFooter) findViewById(2131825495);
        this.oer = findViewById(2131825491);
        this.odF = (ViewGroup) findViewById(2131825496);
        this.odU = (ImageView) findViewById(2131825481);
        this.odV = (FrameLayout) findViewById(2131825490);
        this.odI.setOnClickListener(new C2843731());
        this.odS = new C46064a(this);
        this.odT = getLayoutInflater().inflate(2130969978, null);
        this.odS.setContentView(this.odT, new LayoutParams(-1, -1));
        this.odT.findViewById(2131825497).setOnClickListener(new C3932832());
        this.odS.obT = new C124422();
        this.oea = (ViewGroup) this.odT.findViewById(2131825499);
        this.odY = C44081e.vom.mo35682dF(this.mController.ylL);
        C28459a.m45138a(this.odY);
        this.odq.setUseSdcardCache(true);
        this.ocC.mo24331a(new C284383());
        this.ocC.setOnWishSendImp(new C393304());
        this.ocC.post(new C393365());
        this.ocC.setOnkbdStateListener(new C344776());
        this.ocO.ohU = new C393297();
        this.ocC.setMaxLength(25);
        this.odu.setOnClickListener(new C34058());
        C4990ab.m7410d("MicroMsg.LuckyMoneyDetailUI", "after initview");
        AppMethodBeat.m2505o(42688);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(42689);
        super.onBackPressed();
        AppMethodBeat.m2505o(42689);
    }

    private void bMv() {
        AppMethodBeat.m2504i(42690);
        ((C40437i) C1720g.m3528K(C40437i.class)).mo56645a((Context) this, this.emo, this.odZ.mo20410Aq(), getString(C25738R.string.ct3), new C34069());
        AppMethodBeat.m2505o(42690);
    }

    public final void onKeyboardStateChanged() {
        AppMethodBeat.m2504i(42691);
        super.onKeyboardStateChanged();
        C4990ab.m7411d("MicroMsg.LuckyMoneyDetailUI", "keyboard changed: %s", Integer.valueOf(this.mController.ymc));
        AppMethodBeat.m2505o(42691);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(42692);
        if (keyEvent.getKeyCode() == 4 && this.ocC.getVisibility() == 0) {
            this.ocC.setVisibility(8);
            AppMethodBeat.m2505o(42692);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(42692);
        return dispatchKeyEvent;
    }

    /* renamed from: c */
    public final boolean mo7808c(int i, int i2, String str, C1207m c1207m) {
        boolean z = false;
        AppMethodBeat.m2504i(42693);
        C4990ab.m7416i("MicroMsg.LuckyMoneyDetailUI", "onSceneEnd() errType:" + i + " errCode:" + i2 + " errMsg:" + str + " netsceneType:" + c1207m.getType());
        if (c1207m instanceof C12425af) {
            if (i == 0 && i2 == 0) {
                C12425af c12425af = (C12425af) c1207m;
                C12428k c12428k = c12425af.nYn;
                this.ocP = c12425af.nYz;
                this.kWO = c12425af.nYA;
                this.odX = c12425af.nYB;
                this.oeb = c12425af.nYC;
                m67036a(c12428k);
                AppMethodBeat.m2505o(42693);
                return true;
            }
            C30379h.m48465bQ(this, str);
            AppMethodBeat.m2505o(42693);
            return true;
        } else if (c1207m instanceof C36785am) {
            if (i == 0 && i2 == 0) {
                this.ocO.nSz = false;
                bMt();
                C36785am c36785am = (C36785am) c1207m;
                if (this.nSx != null) {
                    while (true) {
                        boolean z2 = z;
                        if (z2 >= this.nSx.size()) {
                            break;
                        }
                        C39323w c39323w = (C39323w) this.nSx.get(z2);
                        if (c39323w.nWX.equalsIgnoreCase(c36785am.nWX)) {
                            c39323w.nYb = c36785am.nSd;
                            this.ocO.notifyDataSetChanged();
                            break;
                        }
                        z = z2 + 1;
                    }
                    if (this.odv.getVisibility() == 0) {
                        this.odv.setVisibility(8);
                    }
                    this.ocO.mo36628ck(this.nSx);
                }
                AppMethodBeat.m2505o(42693);
                return true;
            }
            C30379h.m48465bQ(this, str);
            AppMethodBeat.m2505o(42693);
            return true;
        } else if (!(c1207m instanceof C21198ar)) {
            AppMethodBeat.m2505o(42693);
            return false;
        } else if (i == 0 && i2 == 0) {
            C5670b.m8523i(this, getString(C25738R.string.cbn));
            AppMethodBeat.m2505o(42693);
            return true;
        } else {
            C30379h.m48465bQ(this, str);
            AppMethodBeat.m2505o(42693);
            return true;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(42694);
        String stringExtra;
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        if (this.ocL != null && this.ocL.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao")) {
                            C4990ab.m7416i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
                            break;
                        } else {
                            mo24304n(new C21198ar(stringExtra.replaceAll(",", "|"), this.ocI, "v1.0"));
                            break;
                        }
                    }
                }
                break;
            case FaceManager.FACE_ACQUIRED_HACKER /*1111*/:
                if (i2 != -1) {
                    C4990ab.m7416i("MicroMsg.LuckyMoneyDetailUI", "go emoji capture failed!");
                    break;
                }
                stringExtra = "";
                if (intent != null) {
                    stringExtra = intent.getStringExtra("gif_md5");
                }
                if (!C5046bo.isNullOrNil(stringExtra)) {
                    m67042aP(2, stringExtra);
                    bMv();
                    break;
                }
                C4990ab.m7416i("MicroMsg.LuckyMoneyDetailUI", "md5 == null go emoji capture failed!");
                break;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(42694);
    }

    public void finish() {
        AppMethodBeat.m2504i(42695);
        if (getIntent().hasExtra("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) getIntent().getParcelableExtra("key_realname_guide_helper");
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyDetailUI");
            bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
            boolean b = realnameGuideHelper.mo74574b(this, bundle, new C3933114());
            getIntent().removeExtra("key_realname_guide_helper");
            if (!b) {
                super.finish();
            }
        } else {
            super.finish();
        }
        overridePendingTransition(C25738R.anim.f8401db, C25738R.anim.f8404dg);
        AppMethodBeat.m2505o(42695);
    }

    public final int getLayoutId() {
        return 2130969976;
    }

    /* renamed from: iK */
    private void m67063iK(boolean z) {
        AppMethodBeat.m2504i(42696);
        C4990ab.m7417i("MicroMsg.LuckyMoneyDetailUI", "showEmoji() circle:%s", Boolean.TRUE);
        this.odI.setVisibility(8);
        this.oex = 1;
        if (z) {
            this.oeu = 3;
        } else {
            this.oeu--;
            if (this.oeu == 0) {
                C4990ab.m7416i("MicroMsg.LuckyMoneyDetailUI", "showEmoji() circle fail!");
                this.odJ.setVisibility(8);
                this.odI.setVisibility(0);
                this.oex = 2;
                AppMethodBeat.m2505o(42696);
                return;
            }
        }
        this.kZa = C42952j.getEmojiStorageMgr().xYn.aqi(this.kWO);
        if (this.kZa == null) {
            this.kZa = new EmojiInfo();
            this.kZa.field_md5 = this.kWO;
            this.kZa.field_type = this.odX;
        } else if (C5730e.asZ(this.kZa.dve()) > 0 || this.kZa.mo48552xy() || this.kZa.duS()) {
            this.odH.setVisibility(0);
            m67085z(this.kZa);
            AppMethodBeat.m2505o(42696);
            return;
        }
        if (z) {
            this.odH.setVisibility(8);
            this.odJ.setVisibility(0);
            this.odK.setImageResource(C1318a.lucky_money_newyear_creat_loading);
            C42952j.bkh().kVj = this.kVj;
        }
        C42952j.bkh().mo35676s(this.kZa);
        C1720g.m3535RO().eJo.mo14539a(697, this.oev);
        AppMethodBeat.m2505o(42696);
    }

    /* renamed from: z */
    private void m67085z(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(42697);
        this.oex = 3;
        this.odH.setEmojiInfo(emojiInfo);
        this.oec = new C9499aa();
        this.oec.cVT = 11;
        this.oec.ajK();
        AppMethodBeat.m2505o(42697);
    }

    /* renamed from: xY */
    private void m67080xY(int i) {
        AppMethodBeat.m2504i(42698);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.odr.getLayoutParams();
        switch (i) {
            case 1:
                layoutParams.topMargin = -C4977b.m7371b(this.mController.ylL, 80.0f);
                break;
            case 2:
                layoutParams.topMargin = -C4977b.m7371b(this.mController.ylL, 238.0f);
                break;
            case 3:
                layoutParams.topMargin = -C4977b.m7371b(this.mController.ylL, 204.0f);
                break;
            case 4:
                layoutParams.topMargin = -C4977b.m7371b(this.mController.ylL, 363.0f);
                break;
        }
        this.oew = layoutParams.topMargin;
        this.odr.setLayoutParams(layoutParams);
        this.odr.requestLayout();
        AppMethodBeat.m2505o(42698);
    }

    private boolean bMw() {
        AppMethodBeat.m2504i(42699);
        if (C5046bo.isNullOrNil(this.kWO) || !(C5046bo.m7563gW(this.oeb.nXp, 1) || C5046bo.m7563gW(this.oeb.nXq, 1))) {
            AppMethodBeat.m2505o(42699);
            return false;
        }
        AppMethodBeat.m2505o(42699);
        return true;
    }

    /* renamed from: a */
    private void m67036a(final C12428k c12428k) {
        AppMethodBeat.m2504i(42700);
        if (c12428k == null) {
            AppMethodBeat.m2505o(42700);
            return;
        }
        String str;
        String str2;
        boolean e = m67054e(c12428k);
        if (LuckyMoneyDetailUI.m67057f(c12428k)) {
            if (bMw()) {
                if (e) {
                    m67080xY(1);
                } else {
                    m67080xY(3);
                }
            } else if (e) {
                m67080xY(2);
            } else {
                m67080xY(4);
            }
        } else if (e) {
            if (bMw()) {
                m67080xY(1);
            } else {
                m67080xY(2);
            }
        } else if (bMw()) {
            m67080xY(3);
        } else {
            m67080xY(4);
        }
        if (bMw()) {
            this.odG.setVisibility(0);
            m67063iK(true);
        } else {
            this.odG.setVisibility(8);
        }
        if (!C5046bo.m7563gW(this.oeb.nXr, 0) && m67054e(c12428k) && this.oeg) {
            this.odM.setOnClickListener(this.oet);
            this.odM.setTag("nodelete");
            this.odR.setOnClickListener(this.oet);
            this.odU.setOnClickListener(this.oet);
            this.odQ.setOnClickListener(new C1243810());
            this.odP.setOnClickListener(this.oet);
            str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_HONGBAO_LAST_THX_SEND_EMOJI_MD5_STRING, (Object) "");
            m67081xZ(1);
            if (!C5046bo.isNullOrNil(str)) {
                m67042aP(2, str);
            }
        } else {
            m67081xZ(0);
        }
        if (c12428k.nXa == 1) {
            e = true;
        } else {
            e = false;
        }
        this.ocG = e;
        if (c12428k != null) {
            Object obj;
            Object obj2 = ((c12428k.cRU == 3 || c12428k.cRU == 2) && c12428k.nWZ == 1 && !this.ocG && c12428k.nXc == 1) ? 1 : null;
            if (c12428k.nXd == null || c12428k.nXd.erD != 1 || C5046bo.isNullOrNil(c12428k.nXd.nWy)) {
                obj = null;
            } else {
                obj = 1;
            }
            this.odA = (TextView) this.kZq.findViewById(2131825438);
            if (obj2 == null && obj == null) {
                this.odA.setVisibility(8);
            } else {
                this.odA.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(42674);
                        C7060h.pYm.mo8381e(11701, Integer.valueOf(LuckyMoneyDetailUI.m67083ya(c12428k.nXi)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3));
                        C46063x.m85805a(LuckyMoneyDetailUI.this, 1, false);
                        AppMethodBeat.m2505o(42674);
                    }
                });
                if (obj != null) {
                    this.ocL = c12428k.nXd.nWy;
                    this.odA.setText(c12428k.nXd.nWz);
                }
                C7060h.pYm.mo8381e(11701, Integer.valueOf(LuckyMoneyDetailUI.m67079xW(c12428k.nXi)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
                this.odA.setVisibility(0);
            }
            this.nXi = c12428k.nXi;
            this.odB = (TextView) this.kZq.findViewById(2131825439);
            this.odB.setVisibility(8);
            if (!this.ocQ) {
                this.nSL.addFooterView(this.kZq);
                this.ocQ = true;
            }
        }
        if (this.f16174Lp == 0) {
            Object obj3;
            this.ocJ = c12428k.nWX;
            str2 = this.ocJ;
            if (c12428k == null || c12428k.cRT != 0 || c12428k.nXj == null || c12428k.nXj.size() <= 0 || !((C39323w) c12428k.nXj.get(0)).nWX.equals(str2) || c12428k.nWY == 1) {
                obj3 = null;
            } else {
                obj3 = 1;
            }
            if (obj3 != null) {
                this.ocO.nSz = false;
                this.odv.setVisibility(0);
                this.odw.setVisibility(8);
            } else {
                this.odv.setVisibility(8);
                this.odw.setVisibility(0);
                if (LuckyMoneyDetailUI.m67057f(c12428k) && !m67054e(c12428k)) {
                    this.odx.setVisibility(8);
                    this.ody.setVisibility(8);
                    this.odz.setVisibility(8);
                }
                this.ocO.nSy = this.ocJ;
            }
            this.ocO.nSA = c12428k.nXi;
            if (c12428k != null) {
                Context context = this.mController.ylL;
                if (c12428k.nXi == 2) {
                    this.nSM.setImageResource(C25738R.drawable.b8q);
                    if (c12428k.resourceId != 0) {
                        C4990ab.m7416i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + c12428k.resourceId);
                        final C4883b c26157hq = new C26157hq();
                        c26157hq.cCx.cCz = c12428k.resourceId;
                        c26157hq.callback = new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(42669);
                                if (c26157hq.cCy.cCA) {
                                    C4990ab.m7416i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + c26157hq.cCy.cCB);
                                    C46063x.m85823m(LuckyMoneyDetailUI.this.nSM, c26157hq.cCy.cCB);
                                    AppMethodBeat.m2505o(42669);
                                    return;
                                }
                                C4990ab.m7416i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
                                C46063x.m85811b(LuckyMoneyDetailUI.this.nSM, c12428k.nWR, c12428k.nXl);
                                AppMethodBeat.m2505o(42669);
                            }
                        };
                        C4879a.xxA.mo10048a(c26157hq, Looper.myLooper());
                    } else {
                        C46063x.m85811b(this.nSM, c12428k.nWR, c12428k.nXl);
                    }
                } else {
                    C46063x.m85811b(this.nSM, c12428k.nWR, c12428k.nXl);
                }
                String string = getString(C25738R.string.cts, new Object[]{c12428k.nWQ});
                this.nSN.setMaxWidth(((WindowManager) getSystemService("window")).getDefaultDisplay().getWidth() - C4977b.m7371b(this.mController.ylL, 92.0f));
                C46063x.m85800a(context, this.nSN, string);
                C46063x.m85800a(context, this.nsq, c12428k.nSd);
                if (c12428k.cRT == 1) {
                    this.nSO.setVisibility(0);
                    this.nSO.setImageResource(C25738R.drawable.b9s);
                } else if (c12428k.cRT == 2) {
                    if (!C1855t.m3912mY(c12428k.nXl)) {
                        C17880h c17880h = new C17880h();
                        c17880h.username = c12428k.nXl;
                        C17884o.act().mo33391b(c17880h);
                    }
                    this.nSO.setVisibility(0);
                    this.nSO.setImageResource(C25738R.drawable.b9j);
                } else {
                    this.nSO.setVisibility(8);
                }
                if (!C5046bo.isNullOrNil(c12428k.nXg)) {
                    C46063x.m85822l(this.odr, c12428k.nXg);
                    this.odr.setScaleType(ScaleType.FIT_XY);
                }
                if (C5046bo.isNullOrNil(c12428k.nXh)) {
                    C4990ab.m7416i("MicroMsg.LuckyMoneyDetailUI", "hy: no bg. set bg area to gone");
                    this.odD.setVisibility(8);
                } else {
                    C4990ab.m7417i("MicroMsg.LuckyMoneyDetailUI", "hy: has url : %s", c12428k.nXh);
                    this.odD.setVisibility(4);
                    C46063x.m85819h(this.lBT, c12428k.nXh);
                    C5004al.m7442n(new C3447321(), 500);
                }
                if (c12428k.cRV != 2 || this.ocH == 3) {
                    this.nSP.setVisibility(8);
                } else {
                    this.nSD.setText(C36391e.m59971F(((double) c12428k.cSh) / 100.0d));
                    this.ocO.nSz = false;
                    this.nSP.setVisibility(0);
                }
                if (C5046bo.isNullOrNil(c12428k.nUj)) {
                    C4990ab.m7412e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
                    this.nSQ.setVisibility(8);
                } else {
                    this.nSQ.setVisibility(0);
                    this.kGq.setText(c12428k.nUj);
                    if (c12428k.nUh == 1) {
                        C4990ab.m7417i("MicroMsg.LuckyMoneyDetailUI", "changeIconUrl: %s", c12428k.nXn);
                        if (C5046bo.isNullOrNil(c12428k.nXn)) {
                            this.odq.setVisibility(8);
                        } else {
                            this.odq.setUrl(c12428k.nXn);
                            this.odq.setVisibility(0);
                        }
                        this.kGq.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(42673);
                                LuckyMoneyDetailUI.m67037a(LuckyMoneyDetailUI.this, c12428k);
                                AppMethodBeat.m2505o(42673);
                            }
                        });
                    } else {
                        C4990ab.m7412e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
                        this.kGq.setTextColor(getResources().getColor(C25738R.color.f12141tu));
                    }
                }
                if (C5046bo.isNullOrNil(c12428k.nXb)) {
                    this.kEq.setText(null);
                    this.odw.setVisibility(8);
                } else {
                    this.kEq.setText(c12428k.nXb);
                    this.odw.setVisibility(0);
                    if (LuckyMoneyDetailUI.m67057f(c12428k) && !m67054e(c12428k)) {
                        this.odx.setVisibility(8);
                        this.ody.setVisibility(8);
                        this.odz.setVisibility(8);
                    }
                }
            }
            if (c12428k != null) {
                LinkedList linkedList = c12428k.nXe;
                if (linkedList != null && linkedList.size() > 0) {
                    View findViewById = this.abB.findViewById(2131825456);
                    View findViewById2 = this.abB.findViewById(2131825459);
                    View findViewById3 = this.abB.findViewById(2131825462);
                    ViewGroup viewGroup = (ViewGroup) this.abB.findViewById(2131825457);
                    ViewGroup viewGroup2 = (ViewGroup) this.abB.findViewById(2131825460);
                    ViewGroup viewGroup3 = (ViewGroup) this.abB.findViewById(2131825463);
                    View findViewById4 = this.abB.findViewById(2131825458);
                    View findViewById5 = this.abB.findViewById(2131825461);
                    C21253c c21253c = new C21253c();
                    c21253c.textColor = getResources().getColor(C25738R.color.f12143tw);
                    if (linkedList.size() > 0) {
                        C21249h.m32619a(this, viewGroup, (C43255as) linkedList.get(0), c21253c);
                        findViewById.setVisibility(0);
                    }
                    if (linkedList.size() > 1) {
                        C21249h.m32619a(this, viewGroup2, (C43255as) linkedList.get(1), c21253c);
                        findViewById2.setVisibility(0);
                    }
                    if (linkedList.size() > 2) {
                        C21249h.m32619a(this, viewGroup3, (C43255as) linkedList.get(2), c21253c);
                        findViewById3.setVisibility(0);
                    }
                    if (findViewById.getVisibility() == 0 && (findViewById2.getVisibility() == 0 || findViewById3.getVisibility() == 0)) {
                        findViewById4.setVisibility(0);
                    }
                    if (findViewById2.getVisibility() == 0 && findViewById3.getVisibility() == 0) {
                        findViewById5.setVisibility(0);
                    }
                    if (findViewById.getVisibility() == 0 || findViewById2.getVisibility() == 0 || findViewById3.getVisibility() == 0) {
                        this.ocE.requestLayout();
                        this.ocE.setVisibility(0);
                    }
                }
                this.odC = (ViewGroup) this.kZq.findViewById(2131825440);
                C21253c c21253c2 = new C21253c();
                c21253c2.textColor = getResources().getColor(C25738R.color.f12084rr);
                c21253c2.textSize = getResources().getDimensionPixelSize(C25738R.dimen.f9936kr);
                C21249h.m32619a(this, this.odC, c12428k.nXf, c21253c2);
                c21253c2 = new C21253c();
                c21253c2.textColor = Color.parseColor("#0C4F8E");
                c21253c2.textSize = getResources().getDimensionPixelSize(C25738R.dimen.f9936kr);
                if (c12428k.nXo != null) {
                    C39318at Ql = C39318at.m66994Ql(c12428k.nXo);
                    if (!(Ql == null || Ql.nZp == null)) {
                        c21253c2.ogN = Ql.nWu;
                        C21249h.m32619a(this, this.odC, Ql.nZp, c21253c2);
                        C7060h c7060h = C7060h.pYm;
                        Object[] objArr = new Object[3];
                        objArr[0] = Integer.valueOf(1);
                        objArr[1] = Ql.nZp.content;
                        objArr[2] = Ql.nWu != null ? Ql.nWu.wwP : "";
                        c7060h.mo8381e(16589, objArr);
                    }
                }
                if (!this.oep) {
                    this.oep = true;
                    this.kZq.post(new C1244025());
                }
                C4990ab.m7410d("MicroMsg.LuckyMoneyDetailUI", "adjust footer");
                this.kZq.post(new C1244126());
            }
            C7060h.pYm.mo8381e(11701, Integer.valueOf(LuckyMoneyDetailUI.m67079xW(c12428k.nXi)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
        }
        LinkedList linkedList2 = c12428k.nXj;
        if (linkedList2 != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= linkedList2.size()) {
                    break;
                }
                C39323w c39323w = (C39323w) linkedList2.get(i2);
                if (!this.ocN.containsKey(c39323w.nWX)) {
                    this.nSx.add(linkedList2.get(i2));
                    this.ocN.put(c39323w.nWX, Integer.valueOf(1));
                }
                i = i2 + 1;
            }
            this.f16174Lp += linkedList2.size();
            this.hZu = false;
            if (this.odv.getVisibility() != 0) {
                this.ocO.mo36628ck(this.nSx);
            }
        }
        if (c12428k.cRT == 2 && !C5046bo.isNullOrNil(c12428k.nWP)) {
            this.nTR = new SoundPool(2, 3, 0);
            this.odE = new int[2];
            try {
                this.odE[0] = this.nTR.load(getResources().getAssets().openFd("most_lucky.m4a"), 0);
                this.odE[1] = this.nTR.load(getResources().getAssets().openFd("whistle.m4a"), 0);
            } catch (IOException e2) {
                C4990ab.m7412e("MicroMsg.LuckyMoneyDetailUI", "load lucky money voice fail " + e2.getMessage());
            }
            this.nTR.setOnLoadCompleteListener(new OnLoadCompleteListener() {
                public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
                    AppMethodBeat.m2504i(42666);
                    if (i2 == 0) {
                        if (i == LuckyMoneyDetailUI.this.odE[0]) {
                            soundPool.play(i, 1.0f, 1.0f, 0, 0, 1.0f);
                            AppMethodBeat.m2505o(42666);
                            return;
                        } else if (i == LuckyMoneyDetailUI.this.odE[1] && c12428k.cSh >= 19000) {
                            soundPool.play(i, 1.0f, 1.0f, 0, 0, 1.0f);
                        }
                    }
                    AppMethodBeat.m2505o(42666);
                }
            });
            this.abB.postDelayed(new C2843518(), 300);
        }
        C22583ab c22583ab = new C22583ab();
        c22583ab.field_mNativeUrl = this.ocK;
        c22583ab.field_hbType = c12428k.cRT;
        c22583ab.field_receiveAmount = c12428k.cSh;
        c22583ab.field_receiveTime = System.currentTimeMillis();
        c22583ab.field_hbStatus = c12428k.cRU;
        c22583ab.field_receiveStatus = c12428k.cRV;
        if (c22583ab.field_receiveAmount > 0) {
            C14241r.cPF().mo38091a(c22583ab);
        }
        if (c12428k.nXo != null) {
            C39318at Ql2 = C39318at.m66994Ql(c12428k.nXo);
            if (!(Ql2 == null || Ql2.nWu == null)) {
                ImageView imageView = (ImageView) findViewById(2131825492);
                ImageView imageView2 = (ImageView) findViewById(2131825493);
                this.abB.post(new C2122119());
                ((C12405a) C1720g.m3528K(C12405a.class)).mo24257b(imageView, Ql2.nWu);
                imageView.setVisibility(0);
                imageView2.setVisibility(0);
                if (!this.odW) {
                    this.odW = true;
                    str = Ql2.nWu.wwQ != null ? Ql2.nWu.wwQ.wwX : "";
                    str2 = c12428k.nXl;
                    C7060h.pYm.mo8381e(16598, Integer.valueOf(3), Ql2.nWu.wwP, str, str2);
                }
            }
        }
        if (this.gII != null && this.gII.isShowing()) {
            this.gII.hide();
        }
        AppMethodBeat.m2505o(42700);
    }

    /* renamed from: xZ */
    private void m67081xZ(int i) {
        AppMethodBeat.m2504i(42701);
        m67042aP(i, "");
        AppMethodBeat.m2505o(42701);
    }

    /* renamed from: aP */
    private void m67042aP(int i, String str) {
        AppMethodBeat.m2504i(42702);
        switch (i) {
            case 0:
                this.odL.setVisibility(8);
                AppMethodBeat.m2505o(42702);
                return;
            case 1:
                this.odL.setVisibility(0);
                this.odM.setVisibility(0);
                this.odN.setVisibility(8);
                this.odO.setVisibility(8);
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_HONGBAO_LAST_THX_SEND_EMOJI_MD5_STRING, (Object) "");
                AppMethodBeat.m2505o(42702);
                return;
            case 2:
                if (!C5046bo.isNullOrNil(str)) {
                    EmojiInfo aqi = C42952j.getEmojiStorageMgr().xYn.aqi(str);
                    if (aqi != null) {
                        this.odZ = aqi;
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_HONGBAO_LAST_THX_SEND_EMOJI_MD5_STRING, this.odZ.mo20410Aq());
                        this.odP.setEmojiInfo(this.odZ);
                        this.odL.setVisibility(0);
                        this.odM.setVisibility(8);
                        this.odN.setVisibility(0);
                        this.odO.setVisibility(8);
                        break;
                    }
                    C4990ab.m7416i("MicroMsg.LuckyMoneyDetailUI", "exchangeThxEmojiState() temp == null");
                    AppMethodBeat.m2505o(42702);
                    return;
                }
                break;
        }
        AppMethodBeat.m2505o(42702);
    }

    /* renamed from: e */
    private boolean m67054e(C12428k c12428k) {
        if (c12428k.cRV != 2 || this.ocH == 3) {
            return false;
        }
        return true;
    }

    /* renamed from: f */
    private static boolean m67057f(C12428k c12428k) {
        if (c12428k.nWZ == 1) {
            return true;
        }
        return false;
    }

    private void bMt() {
        AppMethodBeat.m2504i(42703);
        if (!(this.ocC == null || this.ocC.getVisibility() == 8)) {
            this.ocC.setVisibility(8);
        }
        AppMethodBeat.m2505o(42703);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(42704);
        super.onDestroy();
        if (this.oex == 1 || this.oex == 2) {
            this.oec = new C9499aa();
            this.oec.cVT = 12;
            this.oec.ajK();
        }
        if (this.ocC != null) {
            this.ocC.bMO();
        }
        if (this.nTR != null) {
            this.nTR.release();
            for (int unload : this.odE) {
                this.nTR.unload(unload);
            }
        }
        if (this.odY != null) {
            C4990ab.m7416i("MicroMsg.LuckyMoneyDetailUI", "commentfooter release");
            this.odY.onPause();
            this.odY.mo11686AC();
            this.odY.destroy();
        }
        C42952j.bkh().kVj = null;
        C1720g.m3535RO().eJo.mo14546b(697, this.oev);
        AppMethodBeat.m2505o(42704);
    }

    /* renamed from: xW */
    private static int m67079xW(int i) {
        if (i == 2) {
            return 13;
        }
        return 7;
    }

    /* renamed from: d */
    static /* synthetic */ void m67051d(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        AppMethodBeat.m2504i(42705);
        luckyMoneyDetailUI.hZu = true;
        luckyMoneyDetailUI.gII = C30379h.m48427a(luckyMoneyDetailUI.mController.ylL, 3, luckyMoneyDetailUI.getString(C25738R.string.cn5), true, new C3933316());
        if (luckyMoneyDetailUI.f16174Lp <= 0 || luckyMoneyDetailUI.nSx.size() <= 0 || luckyMoneyDetailUI.nSx.get(luckyMoneyDetailUI.nSx.size() - 1) == null) {
            luckyMoneyDetailUI.ocP = "";
            luckyMoneyDetailUI.mo24301b(new C12425af(luckyMoneyDetailUI.ocI, 11, luckyMoneyDetailUI.f16174Lp, luckyMoneyDetailUI.ocK, "v1.0", luckyMoneyDetailUI.ocP), false);
            AppMethodBeat.m2505o(42705);
            return;
        }
        luckyMoneyDetailUI.mo24301b(new C12425af(luckyMoneyDetailUI.ocI, luckyMoneyDetailUI.f16174Lp, luckyMoneyDetailUI.ocK, C5046bo.getLong(((C39323w) luckyMoneyDetailUI.nSx.get(luckyMoneyDetailUI.nSx.size() - 1)).nXN, 0), "v1.0", luckyMoneyDetailUI.ocP), false);
        AppMethodBeat.m2505o(42705);
    }

    /* renamed from: s */
    static /* synthetic */ void m67073s(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        AppMethodBeat.m2504i(42711);
        C28459a.m45139a(luckyMoneyDetailUI, luckyMoneyDetailUI.odY);
        luckyMoneyDetailUI.odS.dismiss();
        AppMethodBeat.m2505o(42711);
    }

    /* renamed from: a */
    static /* synthetic */ void m67039a(LuckyMoneyDetailUI luckyMoneyDetailUI, String str, String str2, String str3) {
        AppMethodBeat.m2504i(42712);
        String str4 = "MicroMsg.LuckyMoneyDetailUI";
        String str5 = "doTransmitEmojiToFriend() toUser:%s customTex:%s emojiMd5:%s";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(str2 == null);
        objArr[2] = str3;
        C4990ab.m7417i(str4, str5, objArr);
        if (((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35663r(luckyMoneyDetailUI, str, str3)) {
            C4990ab.m7416i("MicroMsg.LuckyMoneyDetailUI", "doTransmitEmojiToFriend() success!");
            if (!TextUtils.isEmpty(str2)) {
                C18372qb c18372qb = new C18372qb();
                c18372qb.cMq.cMr = str;
                c18372qb.cMq.content = str2;
                c18372qb.cMq.type = C1855t.m3925nK(str);
                c18372qb.cMq.flags = 0;
                C4879a.xxA.mo10055m(c18372qb);
                AppMethodBeat.m2505o(42712);
                return;
            }
        }
        C4990ab.m7412e("MicroMsg.LuckyMoneyDetailUI", "doTransmitEmojiToFriend() failed!");
        AppMethodBeat.m2505o(42712);
    }

    /* renamed from: C */
    static /* synthetic */ void m67011C(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        int i;
        AppMethodBeat.m2504i(42716);
        luckyMoneyDetailUI.oef = 2;
        luckyMoneyDetailUI.oed = new C26296y();
        luckyMoneyDetailUI.oed.cVT = 3;
        luckyMoneyDetailUI.oed.ajK();
        luckyMoneyDetailUI.odS.show();
        if (C5046bo.m7563gW(luckyMoneyDetailUI.oeb.nXs, 0)) {
            i = ChatFooterPanel.vhp;
        } else {
            i = ChatFooterPanel.vhs;
        }
        C28459a.m45137a(luckyMoneyDetailUI.oea, luckyMoneyDetailUI.odY, i, new C2843311());
        AppMethodBeat.m2505o(42716);
    }

    /* renamed from: O */
    static /* synthetic */ void m67023O(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        AppMethodBeat.m2504i(42718);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics = luckyMoneyDetailUI.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            C4990ab.m7417i("MicroMsg.LuckyMoneyDetailUI", "hy: screen  width: %d, scale : %f, fixedHeight: %d", Integer.valueOf(displayMetrics.widthPixels), Double.valueOf(((double) displayMetrics.widthPixels) / 750.0d), Integer.valueOf((int) (240.0d * (((double) displayMetrics.widthPixels) / 750.0d))));
            luckyMoneyDetailUI.odD.setLayoutParams(new LinearLayout.LayoutParams(luckyMoneyDetailUI.odD.getLayoutParams().width, r1));
        }
        AppMethodBeat.m2505o(42718);
    }
}
