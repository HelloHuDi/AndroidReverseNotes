package com.tencent.p177mm.plugin.card.p355ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.base.C42838d;
import com.tencent.p177mm.plugin.card.base.CardBaseUI;
import com.tencent.p177mm.plugin.card.model.C33771n.C11290a;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.model.C45783ad;
import com.tencent.p177mm.plugin.card.p352b.C2752k;
import com.tencent.p177mm.plugin.card.p352b.C27567b;
import com.tencent.p177mm.plugin.card.p355ui.C2774i.C27752;
import com.tencent.p177mm.plugin.card.p355ui.C2774i.C27761;
import com.tencent.p177mm.plugin.card.p931d.C11280q;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C45774b;
import com.tencent.p177mm.plugin.card.sharecard.model.C20152b;
import com.tencent.p177mm.plugin.card.sharecard.p354ui.ShareCardListUI;
import com.tencent.p177mm.plugin.card.sharecard.p932a.C42856b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.pluginsdk.wallet.C30158b;
import com.tencent.p177mm.protocal.protobuf.C30209ol;
import com.tencent.p177mm.protocal.protobuf.C44148oa;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.view.C31128d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

@C18524i
/* renamed from: com.tencent.mm.plugin.card.ui.CardHomePageUI */
public class CardHomePageUI extends CardBaseUI implements C42838d, C4931a {
    private int fromScene = 0;
    private C42856b kha;
    private boolean khn = false;
    private boolean khp = true;
    private boolean khr = false;
    private String khs = "";
    private boolean kht = false;
    private boolean khu = false;
    private long khy = 0;
    boolean khz = false;
    private C2774i klI;
    private C45795f klJ;
    private C45795f klK;
    private boolean klL = true;
    private boolean klM = false;
    private TextView klN;
    private LinearLayout klO;
    private long mStartTime = 0;

    /* renamed from: com.tencent.mm.plugin.card.ui.CardHomePageUI$9 */
    class C27719 implements IdleHandler {
        C27719() {
        }

        public final boolean queueIdle() {
            AppMethodBeat.m2504i(88491);
            if (CardHomePageUI.this.kha != null) {
                CardHomePageUI.this.kha;
                if (C42856b.bbA()) {
                    C4990ab.m7416i("MicroMsg.CardHomePageUI", "try2UpdateCardType");
                    CardHomePageUI.m43884h(CardHomePageUI.this);
                }
            }
            AppMethodBeat.m2505o(88491);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardHomePageUI$1 */
    class C113151 implements Runnable {
        C113151() {
        }

        public final void run() {
            AppMethodBeat.m2504i(88483);
            C42852am.bbm().mo54286a(C11280q.EN_DYNAMIC_CODE_SCENE_ENTER_WXCARD);
            AppMethodBeat.m2505o(88483);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardHomePageUI$7 */
    class C113167 implements OnClickListener {
        C113167() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(88489);
            Intent intent = new Intent(CardHomePageUI.this, CardIndexUI.class);
            intent.putExtra("key_card_type", 3);
            CardHomePageUI.this.startActivity(intent);
            C7060h.pYm.mo8381e(11324, "ClickTicketCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0));
            AppMethodBeat.m2505o(88489);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardHomePageUI$2 */
    class C276102 implements OnMenuItemClickListener {
        C276102() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(88484);
            C45774b.m84628a(CardHomePageUI.this, true);
            C7060h.pYm.mo8381e(11582, "CardListMsgMenu", Integer.valueOf(2), Integer.valueOf(0), "", "");
            AppMethodBeat.m2505o(88484);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardHomePageUI$6 */
    class C276116 implements OnClickListener {
        C276116() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(88488);
            Intent intent = new Intent(CardHomePageUI.this, CardIndexUI.class);
            intent.putExtra("key_card_type", 1);
            CardHomePageUI.this.startActivity(intent);
            C7060h.pYm.mo8381e(11324, "GotoMemberCardUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0));
            AppMethodBeat.m2505o(88488);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardHomePageUI$3 */
    class C276123 implements OnMenuItemClickListener {
        C276123() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(88485);
            if (CardHomePageUI.this.fromScene == 1 || CardHomePageUI.this.fromScene == 2) {
                CardHomePageUI.m43877b(CardHomePageUI.this);
            } else {
                CardHomePageUI.this.finish();
            }
            AppMethodBeat.m2505o(88485);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardHomePageUI$5 */
    class C276135 implements OnClickListener {
        C276135() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(88487);
            Intent intent = new Intent(CardHomePageUI.this, CardIndexUI.class);
            intent.putExtra("key_card_type", 1);
            CardHomePageUI.this.startActivity(intent);
            C7060h.pYm.mo8381e(11324, "GotoMemberCardUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0));
            AppMethodBeat.m2505o(88487);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardHomePageUI$4 */
    class C276144 implements Runnable {
        C276144() {
        }

        public final void run() {
            AppMethodBeat.m2504i(88486);
            CardHomePageUI.m43878c(CardHomePageUI.this);
            CardHomePageUI.m43880d(CardHomePageUI.this);
            CardHomePageUI.this.khz = true;
            C4990ab.m7410d("MicroMsg.CardHomePageUI", "initLocation end");
            AppMethodBeat.m2505o(88486);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: b */
    static /* synthetic */ void m43877b(CardHomePageUI cardHomePageUI) {
        AppMethodBeat.m2504i(88517);
        cardHomePageUI.bdh();
        AppMethodBeat.m2505o(88517);
    }

    /* renamed from: d */
    static /* synthetic */ void m43880d(CardHomePageUI cardHomePageUI) {
        AppMethodBeat.m2504i(88519);
        cardHomePageUI.aZt();
        AppMethodBeat.m2505o(88519);
    }

    /* renamed from: h */
    static /* synthetic */ void m43884h(CardHomePageUI cardHomePageUI) {
        AppMethodBeat.m2504i(88520);
        cardHomePageUI.bdf();
        AppMethodBeat.m2505o(88520);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(88492);
        super.onCreate(bundle);
        this.fromScene = getIntent().getIntExtra("key_home_page_from_scene", 0);
        long currentTimeMillis = System.currentTimeMillis();
        this.mStartTime = currentTimeMillis;
        this.khy = currentTimeMillis;
        initView();
        C42852am.bba().mo6829a(this.klI);
        C1720g.m3535RO().eJo.mo14539a(1164, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(984, (C1202f) this);
        C42852am.bbd().bbr();
        C42852am.baV();
        C27567b.m43779sO(1);
        bbW();
        Looper.myQueue().addIdleHandler(new C27719());
        C42852am.bbd().mo68358a((C42838d) this);
        C42852am.baW().mo10116c(this);
        ((C30158b) C1720g.m3528K(C30158b.class)).mo48437eA(8, 2);
        AppMethodBeat.m2505o(88492);
    }

    public final int getLayoutId() {
        return 2130968941;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(88493);
        if (this.klM) {
            aZv();
        }
        C42852am.bba().mo6832b(this.klI);
        this.kha.kfs = null;
        C1720g.m3535RO().eJo.mo14546b(1164, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(984, (C1202f) this);
        C42852am.bbd().mo68361b(this);
        C42852am.baW().mo10117d(this);
        C2752k.baK();
        C42856b.bbx();
        long currentTimeMillis = System.currentTimeMillis() - this.khy;
        C7060h.pYm.mo8381e(13219, "CardHomePageUI", Integer.valueOf(this.fromScene), "", "", Long.valueOf(currentTimeMillis));
        super.onDestroy();
        AppMethodBeat.m2505o(88493);
    }

    public void onResume() {
        AppMethodBeat.m2504i(88494);
        C4990ab.m7417i("MicroMsg.CardHomePageUI", "onResume locationPermissionGranted %s, hasInitLocation %s, shouldGetLayout %s", Boolean.valueOf(this.klM), Boolean.valueOf(this.khz), Boolean.valueOf(this.khn));
        if (this.klM) {
            if (this.khz && this.khn) {
                this.khs = "";
                this.kht = false;
                aZu();
            }
        } else if (this.khn) {
            this.khs = "";
            bbT();
        }
        this.khn = false;
        m43879cu();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mStartTime != 0) {
            int i = (int) (currentTimeMillis - this.mStartTime);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
            iDKey.SetKey(0);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
            iDKey2.SetKey(1);
            iDKey2.SetValue((long) i);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            C7060h.pYm.mo8379b(arrayList, true);
            this.mStartTime = 0;
        }
        C1720g.m3539RS().mo10302aa(new C113151());
        super.onResume();
        AppMethodBeat.m2505o(88494);
    }

    public void onPause() {
        AppMethodBeat.m2504i(88495);
        super.onPause();
        AppMethodBeat.m2505o(88495);
    }

    public final void initView() {
        AppMethodBeat.m2504i(88496);
        C4990ab.m7417i("MicroMsg.CardHomePageUI", "checkPermission checkLocation[%b]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null)));
        this.klM = r0;
        if (this.klM) {
            bbN();
        } else {
            C4990ab.m7412e("MicroMsg.CardHomePageUI", "location permission is denied, doGetLayout");
            bbT();
        }
        super.initView();
        AppMethodBeat.m2505o(88496);
    }

    public final void aZp() {
        AppMethodBeat.m2504i(88497);
        setMMTitle((int) C25738R.string.aev);
        addTextOptionMenu(0, getString(C25738R.string.ag6), new C276102());
        this.kha = new C42856b(this);
        this.kha.init();
        if (this.klI == null) {
            this.klI = new C2774i(this, this.mController.contentView);
            C2774i c2774i = this.klI;
            c2774i.kmK = View.inflate(c2774i.jiE, 2130968957, null);
            c2774i.kmK.setVisibility(8);
            c2774i.kmL = (TextView) c2774i.kmK.findViewById(2131822243);
            c2774i.kmM = (ImageView) c2774i.kmK.findViewById(2131822242);
            c2774i.kmK.setOnClickListener(new C27761());
            c2774i.bdm();
            if (c2774i.kmN == null) {
                c2774i.kmN = ((ViewStub) c2774i.jcl.findViewById(2131822177)).inflate();
                c2774i.kmN.setVisibility(8);
                c2774i.kmO = (TextView) c2774i.kmN.findViewById(2131822243);
                c2774i.kmP = (ImageView) c2774i.kmN.findViewById(2131822242);
                c2774i.kmN.setOnClickListener(new C27752());
            }
            this.klI.khF = true;
        }
        if (this.klJ == null) {
            this.klJ = new C45795f(this, findViewById(2131822181), 1, this.kha);
        }
        if (this.klK == null) {
            this.klK = new C45795f(this, findViewById(2131822182), 3, this.kha);
        }
        if (this.klJ != null) {
            this.klJ.setOnClickListener(new C276116());
        }
        if (this.klK != null) {
            this.klK.setOnClickListener(new C113167());
        }
        this.klO = (LinearLayout) findViewById(2131822183);
        C30209ol bdg = CardHomePageUI.bdg();
        if (bdg != null) {
            m43876a(bdg);
        }
        setBackBtn(new C276123());
        AppMethodBeat.m2505o(88497);
    }

    public final C11290a aZq() {
        return C11290a.HOME_MEMBER_CARD_TYPE;
    }

    private void bbN() {
        AppMethodBeat.m2504i(88498);
        C4990ab.m7410d("MicroMsg.CardHomePageUI", "initLocation");
        C1720g.m3539RS().mo10302aa(new C276144());
        AppMethodBeat.m2505o(88498);
    }

    public final void aZy() {
        AppMethodBeat.m2504i(88499);
        C4990ab.m7416i("MicroMsg.CardHomePageUI", "onMPermissionGranted locationPermissionGranted " + this.klM);
        if (!this.klM) {
            this.klM = true;
            bbN();
        }
        AppMethodBeat.m2505o(88499);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(88500);
        super.onNewIntent(intent);
        setIntent(intent);
        bbW();
        this.khn = true;
        this.klL = true;
        AppMethodBeat.m2505o(88500);
    }

    /* renamed from: cu */
    private void m43879cu() {
        AppMethodBeat.m2504i(88501);
        C4990ab.m7416i("MicroMsg.CardHomePageUI", "updateView()");
        this.klI.bdm();
        bdf();
        this.klK.mo73594cu();
        AppMethodBeat.m2505o(88501);
    }

    private void bdf() {
        AppMethodBeat.m2504i(88502);
        C4990ab.m7416i("MicroMsg.CardHomePageUI", "updateMemberCardItem()");
        C11334c c11334c = (C11334c) this.kan;
        if (this.klN == null) {
            this.klN = (TextView) findViewById(2131822180);
            this.klN.setOnClickListener(new C276135());
        }
        if (c11334c.getCount() > 0) {
            this.klN.setVisibility(0);
            this.klN.setText(getString(C25738R.string.ahp, new Object[]{Integer.valueOf(C42856b.bbs())}));
        } else {
            this.klN.setVisibility(0);
            this.klN.setText(getString(C25738R.string.ahp, new Object[]{Integer.valueOf(C42856b.bbs())}));
            LinearLayout linearLayout = (LinearLayout) findViewById(2131822179);
            if (linearLayout != null) {
                LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
                layoutParams.topMargin = C1338a.fromDPToPix(this, 29);
                layoutParams.bottomMargin = C1338a.fromDPToPix(this, 29);
                linearLayout.setLayoutParams(layoutParams);
            }
        }
        this.klJ.bde();
        AppMethodBeat.m2505o(88502);
    }

    public final void aZz() {
        AppMethodBeat.m2504i(88503);
        bdf();
        AppMethodBeat.m2505o(88503);
    }

    public final void aZw() {
        AppMethodBeat.m2504i(88504);
        if (this.kht) {
            C4990ab.m7412e("MicroMsg.CardHomePageUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
            if (this.klM) {
                aZv();
            }
            AppMethodBeat.m2505o(88504);
            return;
        }
        C4990ab.m7410d("MicroMsg.CardHomePageUI", "onLocationFinish()");
        this.kht = true;
        bbT();
        aZv();
        AppMethodBeat.m2505o(88504);
    }

    public final void aZx() {
        AppMethodBeat.m2504i(88505);
        if (this.khu || this.kht) {
            aZv();
            AppMethodBeat.m2505o(88505);
            return;
        }
        this.khu = true;
        C4990ab.m7416i("MicroMsg.CardHomePageUI", "onLocationFail()");
        bbT();
        AppMethodBeat.m2505o(88505);
    }

    private void bbT() {
        AppMethodBeat.m2504i(88506);
        C4990ab.m7410d("MicroMsg.CardHomePageUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
        bbU();
        if (C38736l.beC()) {
            C27567b.baj();
        } else {
            C4990ab.m7416i("MicroMsg.CardHomePageUI", "the card entrance is not open, don't do doNetSceneGetCardsLayout!");
        }
        C42852am.bbc().mo15082s("", "", 4);
        AppMethodBeat.m2505o(88506);
    }

    private void bbU() {
        AppMethodBeat.m2504i(88507);
        if (!this.klL) {
            C4990ab.m7416i("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, shouldGetHomePage is false");
            AppMethodBeat.m2505o(88507);
        } else if (this.khr) {
            C4990ab.m7412e("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
            AppMethodBeat.m2505o(88507);
        } else {
            if (this.khp && !C5046bo.isNullOrNil(this.khs)) {
                this.khs = "";
            }
            this.khr = true;
            this.klL = false;
            C1720g.m3535RO().eJo.mo14541a(new C20152b((double) C42852am.bbc().ecs, (double) C42852am.bbc().ect, this.khs), 0);
            AppMethodBeat.m2505o(88507);
        }
    }

    public final boolean aZr() {
        AppMethodBeat.m2504i(88508);
        boolean aZr = super.aZr();
        AppMethodBeat.m2505o(88508);
        return aZr;
    }

    public final boolean aZs() {
        return true;
    }

    /* renamed from: b */
    public final void mo45440b(C42837b c42837b, int i) {
        AppMethodBeat.m2504i(88509);
        super.mo45440b(c42837b, i);
        AppMethodBeat.m2505o(88509);
    }

    /* renamed from: a */
    public final void mo45433a(C42837b c42837b) {
        AppMethodBeat.m2504i(88510);
        super.mo45433a(c42837b);
        AppMethodBeat.m2505o(88510);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(88511);
        super.onSceneEnd(i, i2, str, c1207m);
        if (i != 0 || i2 != 0) {
            if (c1207m instanceof C20152b) {
                this.khr = false;
            }
            C4990ab.m7417i("MicroMsg.CardHomePageUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        } else if (c1207m instanceof C45783ad) {
            bdf();
            this.kat.mo35378ZZ();
            this.klK.mo73594cu();
            m43876a(((C45783ad) c1207m).kej);
            AppMethodBeat.m2505o(88511);
            return;
        } else if (c1207m instanceof C20152b) {
            C20152b c20152b = (C20152b) c1207m;
            this.khr = false;
            this.khs = c20152b.kfA;
            this.kha.mo68364at(c20152b.kdS, this.khp);
            if (!(C42856b.bby() && C42856b.bbz())) {
                this.khp = false;
            }
            C4990ab.m7416i("MicroMsg.CardHomePageUI", "NetSceneGetShareCardsLayout() >> updateView()");
            m43879cu();
            AppMethodBeat.m2505o(88511);
            return;
        }
        AppMethodBeat.m2505o(88511);
    }

    private static C30209ol bdg() {
        AppMethodBeat.m2504i(88512);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_HOME_PAGE_LIST_STRING_SYNC, null);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(88512);
            return null;
        }
        C30209ol c30209ol = new C30209ol();
        try {
            c30209ol.parseFrom(str.getBytes("ISO-8859-1"));
            AppMethodBeat.m2505o(88512);
            return c30209ol;
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.CardHomePageUI", e, "", new Object[0]);
            AppMethodBeat.m2505o(88512);
            return null;
        }
    }

    /* renamed from: a */
    private void m43876a(C30209ol c30209ol) {
        AppMethodBeat.m2504i(88513);
        this.klO.removeAllViews();
        if (!(c30209ol == null || c30209ol.vUN == null || c30209ol.vUN.isEmpty())) {
            Iterator it = c30209ol.vUN.iterator();
            while (it.hasNext()) {
                final C44148oa c44148oa = (C44148oa) it.next();
                View inflate = LayoutInflater.from(this.mController.ylL).inflate(2130968928, this.klO, false);
                new C45795f(this, inflate, 4, this.kha, c44148oa).setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(88490);
                        if (c44148oa.vTw == 1) {
                            C45774b.m84626a(CardHomePageUI.this, c44148oa.vTx, 0);
                            AppMethodBeat.m2505o(88490);
                            return;
                        }
                        if (c44148oa.vTw == 2) {
                            if (c44148oa.vTy != null) {
                                C32628se c32628se = new C32628se();
                                c32628se.cOf.userName = c44148oa.vTy.tzW;
                                c32628se.cOf.cOh = C5046bo.m7532bc(c44148oa.vTy.ttg, "");
                                c32628se.cOf.scene = 1028;
                                C4879a.xxA.mo10055m(c32628se);
                                AppMethodBeat.m2505o(88490);
                                return;
                            }
                        } else if (c44148oa.vTw != 3) {
                            C4990ab.m7421w("MicroMsg.CardHomePageUI", "unknown op action: %s", Integer.valueOf(c44148oa.vTw));
                        } else if ("weixin://wccard/sharecarddetail".equals(c44148oa.vTz)) {
                            C4990ab.m7410d("MicroMsg.CardHomePageUI", "go to share card ui");
                            Intent intent = new Intent(CardHomePageUI.this, ShareCardListUI.class);
                            intent.putExtra("key_layout_buff", CardHomePageUI.this.khs);
                            CardHomePageUI.this.klL = true;
                            CardHomePageUI.this.startActivity(intent);
                            C7060h.pYm.mo8381e(11324, "ClickShareCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0));
                            AppMethodBeat.m2505o(88490);
                            return;
                        }
                        AppMethodBeat.m2505o(88490);
                    }
                });
                this.klO.addView(inflate);
            }
        }
        AppMethodBeat.m2505o(88513);
    }

    private void bbW() {
        AppMethodBeat.m2504i(88514);
        int intExtra = getIntent().getIntExtra("key_from_scene", 22);
        boolean bX = C16112c.m24429PK().mo28551bX(262152, 266256);
        boolean bY = C16112c.m24429PK().mo28552bY(262152, 266256);
        boolean a = C16112c.m24429PK().mo28546a(C5127a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_REDDOT_WORDING_STRING_SYNC);
        boolean a2 = C16112c.m24429PK().mo28546a(C5127a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_ICON_STRING_SYNC);
        String nullAsNil = C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, null));
        if (bX) {
            C7060h.pYm.mo8381e(11324, "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(intExtra), "", Integer.valueOf(0), nullAsNil);
            AppMethodBeat.m2505o(88514);
        } else if (bY) {
            C7060h.pYm.mo8381e(11324, "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(intExtra), "", Integer.valueOf(0), nullAsNil);
            AppMethodBeat.m2505o(88514);
        } else if (a && !a2) {
            C7060h.pYm.mo8381e(11324, "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(intExtra), "", Integer.valueOf(0), nullAsNil);
            AppMethodBeat.m2505o(88514);
        } else if (a && a2) {
            C7060h.pYm.mo8381e(11324, "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(intExtra), "", Integer.valueOf(0), nullAsNil);
            AppMethodBeat.m2505o(88514);
        } else if (a2) {
            C7060h.pYm.mo8381e(11324, "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(intExtra), "", Integer.valueOf(0), nullAsNil);
            AppMethodBeat.m2505o(88514);
        } else {
            C7060h.pYm.mo8381e(11324, "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(intExtra), "", Integer.valueOf(0), nullAsNil);
            AppMethodBeat.m2505o(88514);
        }
    }

    public final void bag() {
        this.khn = true;
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        this.khn = true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(88515);
        if (i == 4) {
            if (this.fromScene == 1 || this.fromScene == 2) {
                bdh();
            } else {
                finish();
            }
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(88515);
        return onKeyUp;
    }

    private void bdh() {
        AppMethodBeat.m2504i(88516);
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("preferred_tab", 3);
        C25985d.m41473f(this, "com.tencent.mm.ui.LauncherUI", intent);
        finish();
        AppMethodBeat.m2505o(88516);
    }

    /* renamed from: c */
    static /* synthetic */ void m43878c(CardHomePageUI cardHomePageUI) {
        AppMethodBeat.m2504i(88518);
        cardHomePageUI.fwu = C26443d.agz();
        AppMethodBeat.m2505o(88518);
    }
}
