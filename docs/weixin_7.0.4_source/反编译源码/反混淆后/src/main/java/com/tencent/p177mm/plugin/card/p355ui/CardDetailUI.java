package com.tencent.p177mm.plugin.card.p355ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.p069v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18376qk;
import com.tencent.p177mm.p230g.p231a.C32517b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C46633o;
import com.tencent.p177mm.p612ui.base.MMVerticalTextView;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C24699w;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.base.C42838d;
import com.tencent.p177mm.plugin.card.model.C11284aa;
import com.tencent.p177mm.plugin.card.model.C11292t;
import com.tencent.p177mm.plugin.card.model.C33772o;
import com.tencent.p177mm.plugin.card.model.C38743d;
import com.tencent.p177mm.plugin.card.model.C38744e;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.model.C45784af;
import com.tencent.p177mm.plugin.card.model.C45787v;
import com.tencent.p177mm.plugin.card.model.C6817r;
import com.tencent.p177mm.plugin.card.model.CardInfo;
import com.tencent.p177mm.plugin.card.p352b.C11268c.C11269a;
import com.tencent.p177mm.plugin.card.p352b.C20123j.C20124a;
import com.tencent.p177mm.plugin.card.p352b.C20123j.C20125b;
import com.tencent.p177mm.plugin.card.p352b.C27567b;
import com.tencent.p177mm.plugin.card.p352b.C27568d;
import com.tencent.p177mm.plugin.card.p352b.C27568d.C27569a;
import com.tencent.p177mm.plugin.card.p352b.C33753g;
import com.tencent.p177mm.plugin.card.p352b.C33753g.C20120a;
import com.tencent.p177mm.plugin.card.p352b.C38728f;
import com.tencent.p177mm.plugin.card.p352b.C45772i;
import com.tencent.p177mm.plugin.card.p352b.C45772i.C38730a;
import com.tencent.p177mm.plugin.card.p355ui.C2777j.C27783;
import com.tencent.p177mm.plugin.card.p355ui.C2777j.C27802;
import com.tencent.p177mm.plugin.card.p355ui.C38766e.C113355;
import com.tencent.p177mm.plugin.card.p355ui.C38766e.C20176a;
import com.tencent.p177mm.plugin.card.p355ui.C38766e.C387671;
import com.tencent.p177mm.plugin.card.p355ui.C38766e.C38770d;
import com.tencent.p177mm.plugin.card.p355ui.view.C11358g;
import com.tencent.p177mm.plugin.card.p355ui.view.C20198o;
import com.tencent.p177mm.plugin.card.p355ui.view.C20201x;
import com.tencent.p177mm.plugin.card.p355ui.view.C33804a;
import com.tencent.p177mm.plugin.card.p355ui.view.C33805d;
import com.tencent.p177mm.plugin.card.p355ui.view.C42869q;
import com.tencent.p177mm.plugin.card.p931d.C20134g;
import com.tencent.p177mm.plugin.card.p931d.C20135h;
import com.tencent.p177mm.plugin.card.p931d.C27575f;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C42839c;
import com.tencent.p177mm.plugin.card.p931d.C42840d;
import com.tencent.p177mm.plugin.card.p931d.C45775k;
import com.tencent.p177mm.plugin.card.sharecard.model.C20151a;
import com.tencent.p177mm.plugin.card.sharecard.model.C27591c;
import com.tencent.p177mm.plugin.card.sharecard.model.C42858g;
import com.tencent.p177mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.p177mm.plugin.card.sharecard.p354ui.CardConsumeSuccessUI;
import com.tencent.p177mm.plugin.card.sharecard.p932a.C42856b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.protocal.protobuf.C23422od;
import com.tencent.p177mm.protocal.protobuf.C35938no;
import com.tencent.p177mm.protocal.protobuf.C44152oj;
import com.tencent.p177mm.protocal.protobuf.byx;
import com.tencent.p177mm.protocal.protobuf.bzm;
import com.tencent.p177mm.protocal.protobuf.cdc;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C30292bc;
import com.tencent.p177mm.sdk.platformtools.C30292bc.C23502a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.card.ui.CardDetailUI */
public class CardDetailUI extends CardDetailBaseUI implements C1202f, C11269a, C27569a, C20124a, C23502a {
    private final String TAG = "MicroMsg.CardDetailUI";
    private float ecs = -85.0f;
    private float ect = -1000.0f;
    private C42206a ecy = new C337811();
    private C44275p ejZ = null;
    private int emC = 3;
    private String fhu = "";
    private C26443d fwu;
    private String kaE = "";
    private C42837b kaS;
    private ArrayList<C23422od> kaY;
    private String kbQ = "";
    private boolean kcf = false;
    private Vibrator kgA;
    private boolean kgB = false;
    private int kgn = -1;
    private boolean khx = false;
    C38766e kiM;
    private String kiN = "";
    private String kiO = "";
    private String kiP = "";
    private boolean kiQ = false;
    private boolean kiR = false;
    private boolean kiS = false;
    private String kiT = "";
    private C20176a kiU;
    private boolean kiV = false;
    private boolean kiW = true;
    private boolean kiX = false;
    private boolean kiY = false;
    private String kiZ = "";
    private int kiq = 0;
    private String kir = "";
    private String kis = "";
    private String kit = "";
    private C45772i kja = new C45772i();
    C7306ak mHandler = new C7306ak();
    private long mStartTime = 0;

    /* renamed from: com.tencent.mm.plugin.card.ui.CardDetailUI$4 */
    class C337804 implements OnClickListener {
        C337804() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(88284);
            CardDetailUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(88284);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardDetailUI$1 */
    class C337811 implements C42206a {
        C337811() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(88272);
            if (z) {
                if (CardDetailUI.this.ecs == -85.0f && CardDetailUI.this.ect == -1000.0f) {
                    CardDetailUI.this.ecs = f2;
                    CardDetailUI.this.ect = f;
                    C42852am.bbc().mo15081O(CardDetailUI.this.ecs, CardDetailUI.this.ect);
                }
                C45772i c = CardDetailUI.this.kja;
                float b = CardDetailUI.this.ect;
                float a = CardDetailUI.this.ecs;
                synchronized (c.kbe) {
                    try {
                        c.ecs = a;
                        c.ect = b;
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(88272);
                        }
                    }
                }
                if (CardDetailUI.this.kiY) {
                    CardDetailUI.m55205e(CardDetailUI.this);
                    CardDetailUI.this.kiY = false;
                }
                CardDetailUI.m55209g(CardDetailUI.this);
                AppMethodBeat.m2505o(88272);
                return false;
            }
            AppMethodBeat.m2505o(88272);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardDetailUI$3 */
    class C337823 implements C38770d {
        C337823() {
        }

        public final void bcp() {
            AppMethodBeat.m2504i(88274);
            CardDetailUI.m55211i(CardDetailUI.this);
            AppMethodBeat.m2505o(88274);
        }

        /* renamed from: GQ */
        public final void mo54310GQ(String str) {
            AppMethodBeat.m2504i(88275);
            CardDetailUI.m55196a(CardDetailUI.this, str);
            AppMethodBeat.m2505o(88275);
        }

        public final void bcq() {
            AppMethodBeat.m2504i(88276);
            CardDetailUI.m55212j(CardDetailUI.this);
            AppMethodBeat.m2505o(88276);
        }

        public final void bcr() {
            AppMethodBeat.m2504i(88277);
            CardDetailUI.m55213k(CardDetailUI.this);
            AppMethodBeat.m2505o(88277);
        }

        public final void bcs() {
            AppMethodBeat.m2504i(88278);
            CardDetailUI.m55210h(CardDetailUI.this);
            AppMethodBeat.m2505o(88278);
        }

        public final void bct() {
            AppMethodBeat.m2504i(88279);
            CardDetailUI.m55214l(CardDetailUI.this);
            AppMethodBeat.m2505o(88279);
        }

        /* renamed from: b */
        public final void mo54311b(C42837b c42837b) {
            AppMethodBeat.m2504i(88280);
            CardDetailUI.this.kaS = c42837b;
            CardDetailUI.this.kaE = c42837b.aZZ();
            CardDetailUI.this.kiU.kaE = CardDetailUI.this.kaE;
            AppMethodBeat.m2505o(88280);
        }

        public final void bco() {
            AppMethodBeat.m2504i(88281);
            CardDetailUI.m55218o(CardDetailUI.this);
            AppMethodBeat.m2505o(88281);
        }

        public final void bcu() {
            AppMethodBeat.m2504i(88282);
            C4990ab.m7416i("MicroMsg.CardDetailUI", "onConsumeCodeUIResult()");
            AppMethodBeat.m2505o(88282);
        }

        /* renamed from: fJ */
        public final void mo54319fJ(boolean z) {
            AppMethodBeat.m2504i(88283);
            C4990ab.m7416i("MicroMsg.CardDetailUI", "doMark()");
            CardDetailUI.this.kiR = true;
            CardDetailUI.m55220q(CardDetailUI.this);
            CardDetailUI.this.kiS = z;
            if (CardDetailUI.this.kaS.aZP()) {
                C42852am.bbi().mo35370M(CardDetailUI.this.kaE, C38736l.m65707Ht(CardDetailUI.this.kaS.bab()), 2);
                AppMethodBeat.m2505o(88283);
                return;
            }
            C42852am.bbi().mo35370M(CardDetailUI.this.kaE, C38736l.m65707Ht(CardDetailUI.this.kaS.bab()), 1);
            AppMethodBeat.m2505o(88283);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardDetailUI$2 */
    class C337832 implements OnMenuItemClickListener {
        C337832() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(88273);
            CardDetailUI.m55210h(CardDetailUI.this);
            AppMethodBeat.m2505o(88273);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public CardDetailUI() {
        AppMethodBeat.m2504i(88286);
        AppMethodBeat.m2505o(88286);
    }

    /* renamed from: c */
    static /* synthetic */ void m55203c(CardDetailUI cardDetailUI, String str) {
        AppMethodBeat.m2504i(88334);
        cardDetailUI.m55191Gl(str);
        AppMethodBeat.m2505o(88334);
    }

    /* renamed from: e */
    static /* synthetic */ void m55205e(CardDetailUI cardDetailUI) {
        AppMethodBeat.m2504i(88324);
        cardDetailUI.bcn();
        AppMethodBeat.m2505o(88324);
    }

    /* renamed from: g */
    static /* synthetic */ void m55209g(CardDetailUI cardDetailUI) {
        AppMethodBeat.m2504i(88325);
        cardDetailUI.aZv();
        AppMethodBeat.m2505o(88325);
    }

    /* renamed from: o */
    static /* synthetic */ void m55218o(CardDetailUI cardDetailUI) {
        AppMethodBeat.m2504i(88332);
        cardDetailUI.bco();
        AppMethodBeat.m2505o(88332);
    }

    /* renamed from: q */
    static /* synthetic */ void m55220q(CardDetailUI cardDetailUI) {
        AppMethodBeat.m2504i(88333);
        cardDetailUI.m55207fE(true);
        AppMethodBeat.m2505o(88333);
    }

    public final int getLayoutId() {
        return 2130968915;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(88287);
        super.onCreate(bundle);
        this.mStartTime = System.currentTimeMillis();
        bci();
        C42838d bbh = C42852am.bbh();
        AppCompatActivity appCompatActivity = this.mController.ylL;
        C1720g.m3535RO().eJo.mo14539a(910, (C1202f) bbh);
        C42852am.bbd().mo68358a(bbh);
        C27567b baV = C42852am.baV();
        if (baV.kaD == null) {
            baV.kaD = new ArrayList();
        }
        baV.kaD.add(new WeakReference(bbh));
        bbh.atF = new WeakReference(appCompatActivity);
        C42852am.bbh().mo45372a((C27569a) this);
        C42852am.bbi().mo35371a(this);
        C1202f bbj = C42852am.bbj();
        C1720g.m3535RO().eJo.mo14539a((int) C24699w.CTRL_INDEX, bbj);
        bbj.kaF.clear();
        bbj.kaG = 0;
        C42852am.bbj().mo22960a(this);
        initView();
        AppMethodBeat.m2505o(88287);
    }

    public void onResume() {
        AppMethodBeat.m2504i(88288);
        super.onResume();
        bci();
        if (this.fwu != null) {
            this.fwu.mo44204a(this.ecy, true);
        }
        this.kiM.cAY = false;
        C30292bc.m48192a(this, this);
        C42852am.bbh().mo45373a(this, true);
        if ((this.kiQ || this.kiR) && this.kaS.aZC()) {
            if (this.kaS.aZP()) {
                boolean z;
                C42852am.bbi().mo35373bM(this.kaE, 2);
                C27568d bbh = C42852am.bbh();
                Boolean bool = (Boolean) bbh.kaR.get(this.kaE);
                if (bool == null || !bool.booleanValue()) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z || TextUtils.isEmpty(C42852am.bbh().kaU)) {
                    C4990ab.m7416i("MicroMsg.CardDetailUI", "onResume, not need launch succ ui or jsonRet is empty!");
                } else {
                    C4990ab.m7416i("MicroMsg.CardDetailUI", "onResume, do launch succ UI!");
                    mo41610Gm(C42852am.bbh().kaU);
                }
                this.kiM.kjk.mo23067d(C42839c.CARDCODEREFRESHACTION_DOREFRESH);
            } else {
                C42852am.bbi().mo35373bM(this.kaE, 1);
                C11358g c11358g = this.kiM.kjk;
                if (c11358g != null) {
                    c11358g.mo23067d(C42839c.CARDCODEREFRESHACTION_DOREFRESH);
                }
            }
        }
        if (this.kja.bZi) {
            this.kja.start();
        }
        AppMethodBeat.m2505o(88288);
    }

    public void onPause() {
        AppMethodBeat.m2504i(88289);
        bcj();
        super.onPause();
        this.kiM.cAY = true;
        C42852am.bbh().mo45373a(this, false);
        C30292bc.m48192a(this, null);
        C1202f c1202f = this.kja;
        if (c1202f.baF()) {
            C4990ab.m7416i("MicroMsg.CardLbsOrBluetooth", "stop");
            if (c1202f.kbk != null) {
                c1202f.kbk.baI();
            }
            c1202f.baC();
            C1720g.m3535RO().eJo.mo14546b(2574, c1202f);
        }
        AppMethodBeat.m2505o(88289);
    }

    public final void aNW() {
        AppMethodBeat.m2504i(88290);
        C11358g c11358g = this.kiM.kjk;
        if (c11358g != null) {
            c11358g.bew();
        }
        C7060h.pYm.mo8381e(16827, this.kaE, Long.valueOf(System.currentTimeMillis() / 1000));
        AppMethodBeat.m2505o(88290);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(88291);
        C42852am.bbh().mo45377c((C27569a) this);
        bcj();
        C42852am.bbh().mo45374b((C27569a) this);
        C42852am.bbh().release();
        C42852am.bbi().mo35372b(this);
        C42852am.bbj().mo22961b(this);
        C42852am.bbj().release();
        C38766e c38766e = this.kiM;
        C38728f c38728f = c38766e.kjy;
        c38728f.kaS = null;
        c38728f.kaW.clear();
        c38766e.kjy = null;
        C2777j c2777j = c38766e.kjw;
        C38736l.m65709K(c2777j.kno);
        for (int size = c2777j.knv.size() - 1; size >= 0; size--) {
            C38736l.m65709K((Bitmap) c2777j.knv.remove(size));
        }
        c2777j.knv.clear();
        if (c2777j.gKG.isShowing()) {
            c2777j.gKG.dismiss();
        }
        c2777j.gKG = null;
        c2777j.bdq();
        c2777j.knn = null;
        c2777j.kaS = null;
        c38766e.kjw = null;
        if (c38766e.kjj != null) {
            c38766e.kjj.release();
        }
        c38766e.kjd.ifE = null;
        C4879a.xxA.mo10053d(c38766e.kjH);
        c38766e.kjf.destroy();
        c38766e.kji.destroy();
        c38766e.kjh.destroy();
        c38766e.kju.destroy();
        if (c38766e.kjv != null) {
            c38766e.kjv.destroy();
        }
        if (c38766e.kjn != null) {
            c38766e.kjn.destroy();
        }
        if (c38766e.kjm != null) {
            c38766e.kjm.destroy();
        }
        if (c38766e.kjo != null) {
            c38766e.kjo.destroy();
        }
        if (c38766e.kjp != null) {
            c38766e.kjp.destroy();
        }
        if (c38766e.kjq != null) {
            c38766e.kjq.destroy();
        }
        if (c38766e.kjr != null) {
            c38766e.kjr.destroy();
        }
        if (c38766e.kjs != null) {
            c38766e.kjs.destroy();
        }
        if (c38766e.kjt != null) {
            c38766e.kjt.destroy();
        }
        if (c38766e.kjk != null) {
            c38766e.kjk.destroy();
        }
        c38766e.kje = null;
        C33753g bbm = C42852am.bbm();
        if (bbm.kaD != null) {
            for (int i = 0; i < bbm.kaD.size(); i++) {
                WeakReference weakReference = (WeakReference) bbm.kaD.get(i);
                if (weakReference != null) {
                    C20120a c20120a = (C20120a) weakReference.get();
                    if (c20120a != null && c20120a.equals(c38766e)) {
                        bbm.kaD.remove(weakReference);
                        break;
                    }
                }
            }
        }
        C42852am.bbm().release();
        this.kgA.cancel();
        aZv();
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (this.kaS != null) {
            C7060h.pYm.mo8381e(13219, "CardDetailView", Integer.valueOf(this.emC), this.kaS.baa(), this.kaS.aZZ(), Long.valueOf(currentTimeMillis));
        } else {
            C7060h.pYm.mo8381e(13219, "CardDetailView", Integer.valueOf(this.emC), this.kaE, this.kaE, Long.valueOf(currentTimeMillis));
        }
        if ((this.kiQ || this.kiR) && this.kaS != null && this.kaS.aZC()) {
            if (this.kaS.aZP()) {
                C42852am.bbi().mo35373bM(this.kaE, 2);
            } else {
                C42852am.bbi().mo35373bM(this.kaE, 1);
            }
        }
        C45772i c45772i = this.kja;
        C4990ab.m7416i("MicroMsg.CardLbsOrBluetooth", "uninit");
        if (c45772i.kbk != null) {
            C38730a c38730a = c45772i.kbk;
            if (c38730a.hDr == null) {
                C4990ab.m7412e("MicroMsg.CardLbsOrBluetooth", "bluetoothStateListener null, return");
            } else {
                C4996ah.getContext().unregisterReceiver(c38730a.hDr);
                c38730a.hDr = null;
            }
            c45772i.kbk = null;
        }
        c45772i.baC();
        c45772i.kbp = null;
        c45772i.kbc = null;
        super.onDestroy();
        AppMethodBeat.m2505o(88291);
    }

    private void bci() {
        AppMethodBeat.m2504i(88292);
        C1720g.m3535RO().eJo.mo14539a(645, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(651, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(563, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(652, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(560, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(699, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(902, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(904, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(1163, (C1202f) this);
        AppMethodBeat.m2505o(88292);
    }

    private void bcj() {
        AppMethodBeat.m2504i(88293);
        C1720g.m3535RO().eJo.mo14546b(645, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(651, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(563, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(652, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(560, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(699, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(902, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(904, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(1163, (C1202f) this);
        AppMethodBeat.m2505o(88293);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0261  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initView() {
        boolean z;
        AppMethodBeat.m2504i(88294);
        setBackBtn(new C337832());
        this.kgA = (Vibrator) getSystemService("vibrator");
        if (this.kiM == null) {
            this.kiM = new C38766e(this, this.mController.contentView);
            C38766e c38766e = this.kiM;
            c38766e.kjw = new C2777j(c38766e.kjd);
            C2777j c2777j = c38766e.kjw;
            c2777j.kgj = c2777j.knn.getWindow().getAttributes().screenBrightness;
            if (c2777j.gKG == null) {
                View inflate = View.inflate(c2777j.knn, 2130968962, null);
                c2777j.gKI = inflate.findViewById(2131822256);
                c2777j.gKH = (ImageView) inflate.findViewById(2131822257);
                c2777j.knp = (TextView) inflate.findViewById(2131822258);
                c2777j.knq = (TextView) inflate.findViewById(2131822259);
                c2777j.knr = inflate.findViewById(2131822260);
                c2777j.kns = (ImageView) inflate.findViewById(2131822263);
                c2777j.knt = (MMVerticalTextView) inflate.findViewById(2131822262);
                c2777j.knu = (MMVerticalTextView) inflate.findViewById(2131822261);
                inflate.setOnClickListener(new C27802());
                c2777j.gKG = new C46633o(inflate, -1, -1, true);
                c2777j.gKG.update();
                c2777j.gKG.setBackgroundDrawable(new ColorDrawable(16777215));
                c2777j.gKG.setOnDismissListener(new C27783());
            }
            c38766e.kjy = new C38728f(c38766e.kjd);
            c38766e.kjd.ifE = c38766e;
            C4879a.xxA.mo10052c(c38766e.kjH);
            c38766e = this.kiM;
            if (c38766e.kjf == null) {
                c38766e.kjf = new C20201x();
                c38766e.kjf.mo73598a(c38766e);
            }
            if (c38766e.kjh == null) {
                c38766e.kjh = new C20198o();
                c38766e.kjh.mo73598a(c38766e);
            }
            if (c38766e.kji == null) {
                c38766e.kji = new C33804a();
                c38766e.kji.mo73598a(c38766e);
            }
            c38766e.mListView = (ListView) c38766e.findViewById(2131822036);
            c38766e.kjl = new C33788m(c38766e.kjd.mController.ylL);
            c38766e.kjl.koa = c38766e.gKK;
            c38766e.mListView.setAdapter(c38766e.kjl);
            c38766e.kjl.notifyDataSetChanged();
            c38766e.mListView.setOnItemClickListener(new C387671());
            C4990ab.m7416i("MicroMsg.CardDetailUIContoller", "initMenu");
            CardDetailBaseUI cardDetailBaseUI = c38766e.kjd;
            cardDetailBaseUI.kiG.setOnClickListener(new C113355());
            c38766e.f16163lK = (LinearLayout) c38766e.findViewById(2131822020);
            c38766e.kju = new C33805d();
            c38766e.kju.mo73598a(c38766e);
            c38766e.kjw.kaS = c38766e.kaS;
        }
        int intExtra = getIntent().getIntExtra("key_from_scene", -1);
        C4990ab.m7417i("MicroMsg.CardDetailUI", "scene:%d", Integer.valueOf(intExtra));
        String stringExtra;
        C38743d Hi;
        if (intExtra == 2 || intExtra == 6 || intExtra == 5) {
            this.emC = intExtra;
            stringExtra = getIntent().getStringExtra("key_card_app_msg");
            Hi = C20134g.m31147Hi(stringExtra);
            if (Hi != null) {
                this.kaE = Hi.cMC;
                this.kiN = Hi.kde;
                this.kiP = Hi.cMD;
                int i = Hi.kdh;
                C4990ab.m7416i("MicroMsg.CardDetailUI", "scene is " + intExtra + ", isRecommend is " + i);
                if (i == 1 && intExtra == 2) {
                    this.emC = 23;
                }
                this.kiT = Hi.kdi;
                C4990ab.m7416i("MicroMsg.CardDetailUI", "recommend_card_id is " + this.kiT);
            }
            this.kiO = C20134g.m31148Hj(stringExtra);
        } else if (C38736l.m65735tn(intExtra) || intExtra == 0 || intExtra == 1 || intExtra == 3 || intExtra == 4 || intExtra == 9 || intExtra == 12 || intExtra == 15 || intExtra == 17 || intExtra == 21) {
            this.emC = intExtra;
            this.kaE = getIntent().getStringExtra("key_card_id");
            this.kiP = getIntent().getStringExtra("key_card_ext");
            this.kcf = getIntent().getBooleanExtra("key_is_share_card", false);
            this.kiq = getIntent().getIntExtra("key_stastic_scene", 0);
            this.kit = getIntent().getStringExtra("key_consumed_card_id");
            if (intExtra == 7 || intExtra == 16) {
                this.kir = getIntent().getStringExtra("src_username");
                this.kis = getIntent().getStringExtra("js_url");
                this.fhu = getIntent().getStringExtra("key_template_id");
            } else if (this.kcf && intExtra == 3) {
                this.kbQ = getIntent().getStringExtra("key_card_tp_id");
                this.kaE = C42856b.m76085dp(this.kaE, this.kbQ);
            } else if (intExtra == 8) {
                this.kiV = getIntent().getBooleanExtra("key_is_sms_add_card", false);
            }
        } else if (intExtra == 50 || intExtra == 27) {
            this.emC = getIntent().getIntExtra("key_previous_scene", 50);
            if (!(this.emC == 26 || this.emC == 27)) {
                this.emC = 3;
            }
            this.fhu = getIntent().getStringExtra("key_template_id");
            if (this.emC == 27) {
                C42837b c42837b = (C42837b) getIntent().getParcelableExtra("key_card_info");
                if (c42837b != null) {
                    this.kaS = c42837b;
                    this.kaE = this.kaS.aZZ();
                    bck();
                    bcn();
                    if (this.kaS.aZQ()) {
                        C42852am.bbj().mo22959Gk(this.kaS.aZZ());
                    }
                    bbB();
                }
                bcl();
                C38736l.beB();
            } else {
                LinkedList bR = C45775k.m84636bR(getIntent().getStringExtra("card_list"), this.emC);
                if (bR == null || bR.size() == 0) {
                    C4990ab.m7412e("MicroMsg.CardDetailUI", "initData tempList size is empty");
                    m55217n(true, -1);
                } else {
                    m55207fE(true);
                    this.kaE = ((C44152oj) bR.get(0)).kbU;
                    intExtra = getIntent().getIntExtra("key_previous_scene", 51);
                    cdc cdc = new cdc();
                    cdc.xcM = this.fhu;
                    C4990ab.m7417i("MicroMsg.CardDetailUI", "doBatchGetCardItemByTpInfo templateId:%s", this.fhu);
                    C1720g.m3535RO().eJo.mo14541a(new C11292t(bR, cdc, intExtra, this.kaE), 0);
                }
                bck();
            }
            this.kiM.mo61637a(this.kaS, this.kiU, this.kaY);
            this.kiM.kjE = new C337823();
            C4990ab.m7417i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null)));
            this.khx = z;
            if (this.khx) {
                this.fwu = C26443d.agz();
                aZt();
            }
            AppMethodBeat.m2505o(88294);
        } else if (intExtra == 51) {
            if (getIntent().getIntExtra("key_previous_scene", 51) == 26) {
                this.emC = 26;
            } else {
                this.emC = 3;
            }
            this.kaE = getIntent().getStringExtra("key_card_id");
            this.kaS = C42852am.bbb().kau;
            if (this.kaS == null) {
                this.kaS = C42852am.baW().mo45383Gu(this.kaE);
            }
            bck();
            if (this.kaS == null) {
                C4990ab.m7412e("MicroMsg.CardDetailUI", "initData, mCardId is null from scene == ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_VIEW_UI");
                m55217n(true, -1);
            } else {
                bcn();
                bbB();
                bcl();
                if (this.kaS.aZQ()) {
                    C42852am.bbj().mo22959Gk(this.kaS.aZZ());
                }
            }
            this.kiM.mo61637a(this.kaS, this.kiU, this.kaY);
            this.kiM.kjE = new C337823();
            C4990ab.m7417i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null)));
            this.khx = z;
            if (this.khx) {
            }
            AppMethodBeat.m2505o(88294);
        } else if (intExtra == 26) {
            this.emC = intExtra;
            this.kaE = getIntent().getStringExtra("key_card_id");
            this.kiP = getIntent().getStringExtra("key_card_ext");
        } else {
            this.emC = intExtra;
            stringExtra = getIntent().getStringExtra("key_card_app_msg");
            Hi = C20134g.m31147Hi(stringExtra);
            if (Hi != null) {
                this.kaE = Hi.cMC;
                this.kiN = Hi.kde;
                this.kiP = Hi.cMD;
            }
            this.kiO = C20134g.m31148Hj(stringExtra);
        }
        bck();
        if (TextUtils.isEmpty(this.kaE)) {
            C4990ab.m7412e("MicroMsg.CardDetailUI", "initData, mCardId is null");
            m55217n(true, -1);
        } else {
            if (intExtra == 2 || intExtra == 6 || ((intExtra == 4 && !this.kcf) || intExtra == 5 || intExtra == 17 || intExtra == 21 || intExtra == 23)) {
                z = true;
            } else if (intExtra == 15) {
                Object value = C42852am.bbb().getValue("key_accept_card_info");
                if (value == null || !(value instanceof CardInfo)) {
                    z = true;
                } else {
                    this.kaS = (CardInfo) value;
                    z = false;
                }
            } else if (this.kcf) {
                this.kaS = C42852am.bbe().mo35397GK(this.kaE);
                z = false;
            } else {
                this.kaS = C42852am.baW().mo45383Gu(this.kaE);
                z = false;
            }
            if (z || this.kaS == null) {
                C4990ab.m7416i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene1 is true or no cardinfo with cardId = " + this.kaE + " isShareCard is " + this.kcf);
                m55207fE(true);
                if (this.kcf) {
                    bco();
                } else {
                    bcm();
                }
            } else {
                C4990ab.m7410d("MicroMsg.CardDetailUI", "initData(), cardId = " + this.kaE);
                C23422od aZY = this.kaS.aZY();
                if (aZY != null) {
                    this.kaY = new ArrayList();
                    this.kaY.add(aZY);
                }
                bbB();
                if (this.kaS.aZQ()) {
                    C42852am.bbj().mo22959Gk(this.kaS.aZZ());
                }
                if (this.kcf) {
                    this.kiW = true;
                    z = true;
                } else {
                    boolean z2;
                    if (((long) ((int) (System.currentTimeMillis() / 1000))) - this.kaS.bac() >= TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        this.kiW = true;
                        z = true;
                    } else if (this.kaS.aZN()) {
                        this.kiW = true;
                        z = true;
                    }
                }
                if (z) {
                    C4990ab.m7416i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene2 is true or no cardinfo with cardId = " + this.kaE + " isShareCard is " + this.kcf);
                    if (this.kcf) {
                        bco();
                    } else {
                        bcm();
                    }
                } else {
                    bcn();
                }
                bcl();
            }
        }
        this.kiM.mo61637a(this.kaS, this.kiU, this.kaY);
        this.kiM.kjE = new C337823();
        C4990ab.m7417i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null)));
        this.khx = z;
        if (this.khx) {
        }
        AppMethodBeat.m2505o(88294);
    }

    private void bck() {
        AppMethodBeat.m2504i(88295);
        this.kgn = this.emC;
        this.kiU = new C20176a();
        this.kiU.emC = this.emC;
        this.kiU.kgn = this.kgn;
        this.kiU.kaE = this.kaE;
        this.kiU.kiN = this.kiN;
        this.kiU.kiP = this.kiP;
        this.kiU.kiO = this.kiO;
        this.kiU.kir = this.kir;
        this.kiU.kis = this.kis;
        this.kiU.kcf = this.kcf;
        this.kiU.kjL = getIntent().getIntExtra("key_from_appbrand_type", 0);
        AppMethodBeat.m2505o(88295);
    }

    private void bcl() {
        int i = 1;
        AppMethodBeat.m2504i(88296);
        if (this.kiX || this.kaS == null) {
            AppMethodBeat.m2505o(88296);
            return;
        }
        this.kiX = true;
        C7060h c7060h;
        Object[] objArr;
        if (this.kcf) {
            c7060h = C7060h.pYm;
            objArr = new Object[9];
            objArr[0] = "ShareCardDetailUI";
            objArr[1] = Integer.valueOf(this.kaS.aZV().iAd);
            objArr[2] = this.kaS.baa();
            objArr[3] = this.kaS.aZZ();
            objArr[4] = Integer.valueOf(0);
            objArr[5] = Integer.valueOf(this.kgn);
            objArr[6] = this.kiN;
            if (!this.kaS.aZT()) {
                i = 0;
            }
            objArr[7] = Integer.valueOf(i);
            objArr[8] = "";
            c7060h.mo8381e(11324, objArr);
            AppMethodBeat.m2505o(88296);
            return;
        }
        c7060h = C7060h.pYm;
        objArr = new Object[9];
        objArr[0] = "CardDetailView";
        objArr[1] = Integer.valueOf(this.kaS.aZV().iAd);
        objArr[2] = this.kaS.baa();
        objArr[3] = this.kaS.aZZ();
        objArr[4] = Integer.valueOf(0);
        objArr[5] = Integer.valueOf(this.kgn);
        objArr[6] = this.kiN;
        if (!this.kaS.aZT()) {
            i = 0;
        }
        objArr[7] = Integer.valueOf(i);
        objArr[8] = "";
        c7060h.mo8381e(11324, objArr);
        AppMethodBeat.m2505o(88296);
    }

    private void bbB() {
        AppMethodBeat.m2504i(88297);
        this.kiU.emC = this.emC;
        this.kiU.kgn = this.kgn;
        this.kiU.kaE = this.kaE;
        this.kiM.mo61637a(this.kaS, this.kiU, this.kaY);
        this.kiM.bbB();
        C42852am.bbh().kaS = this.kaS;
        AppMethodBeat.m2505o(88297);
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0226  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(88298);
        C4990ab.m7416i("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + i + " errCode = " + i2);
        int i3;
        if (i == 0 && i2 == 0) {
            m55207fE(false);
            C42837b c42837b;
            CardInfo cardInfo;
            String str2;
            int i4;
            String str3;
            Integer num;
            Intent intent;
            ShareCardInfo GK;
            if (c1207m instanceof C11284aa) {
                String str4 = ((C11284aa) c1207m).kdS;
                if (TextUtils.isEmpty(str4)) {
                    C4990ab.m7412e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetCardItemInfo return json is null");
                    AppMethodBeat.m2505o(88298);
                    return;
                }
                c42837b = this.kaS;
                cardInfo = new CardInfo();
                C27575f.m43802a(cardInfo, str4);
                if (!TextUtils.isEmpty(cardInfo.aZZ())) {
                    this.kaE = cardInfo.aZZ();
                } else if (TextUtils.isEmpty(cardInfo.aZZ()) && !this.kaE.equals(cardInfo.baa())) {
                    C4990ab.m7413e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", this.kaE, cardInfo.baa());
                    AppMethodBeat.m2505o(88298);
                    return;
                }
                this.kaS = cardInfo;
                bcn();
                if (this.emC == 3) {
                    if (c42837b != null) {
                        ((CardInfo) this.kaS).field_stickyAnnouncement = ((CardInfo) c42837b).field_stickyAnnouncement;
                        ((CardInfo) this.kaS).field_stickyEndTime = ((CardInfo) c42837b).field_stickyEndTime;
                        ((CardInfo) this.kaS).field_stickyIndex = ((CardInfo) c42837b).field_stickyIndex;
                        ((CardInfo) this.kaS).field_label_wording = ((CardInfo) c42837b).field_label_wording;
                        this.kaS.mo45389a(c42837b.aZY());
                    }
                    if (this.kiW) {
                        C38736l.m65732h(this.kaS);
                    } else {
                        C4990ab.m7412e("MicroMsg.CardDetailUI", "onSceneEnd(), NetSceneGetCardItemInfo updateDataToDB is false");
                    }
                }
                bbB();
                bcl();
                if (this.kaS.aZQ()) {
                    C42852am.bbj().mo22959Gk(this.kaS.aZZ());
                }
                this.kja.mo73567a(this, this.kaE, this.kaS, this.ecs, this.ect);
                AppMethodBeat.m2505o(88298);
                return;
            } else if (c1207m instanceof C33772o) {
                if (this.kgn == 26) {
                    m55207fE(false);
                }
                str2 = ((C33772o) c1207m).kdS;
                i4 = ((C33772o) c1207m).kdT;
                str3 = ((C33772o) c1207m).kdU;
                if (i4 != 0) {
                    m55202c(i2, str, i4, str3);
                } else {
                    C30379h.m48465bQ(this, getResources().getString(C25738R.string.act));
                }
                if (TextUtils.isEmpty(str2)) {
                    C4990ab.m7412e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneAcceptCardItem return json is null");
                    AppMethodBeat.m2505o(88298);
                    return;
                }
                this.emC = 3;
                if (this.kaS == null) {
                    this.kaS = new CardInfo();
                }
                C27575f.m43802a((CardInfo) this.kaS, str2);
                if (!TextUtils.isEmpty(this.kaS.aZZ())) {
                    this.kaE = this.kaS.aZZ();
                }
                if (this.kiM.bcS() == 1) {
                    C38766e c38766e = this.kiM;
                    if (c38766e.kjy != null) {
                        C38728f c38728f = c38766e.kjy;
                        if (c38728f.kaX != null) {
                            c38728f.kaX.kci = false;
                        }
                    }
                }
                if (this.kgn != 26) {
                    bcn();
                    bbB();
                }
                C38736l.beB();
                C42837b c42837b2 = this.kaS;
                if (c42837b2.aZD()) {
                    num = (Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_IS_SHOW_MEMBERSHIP_TIP_INT_SYNC, Integer.valueOf(0));
                    if (num == null || num.intValue() != 1) {
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_IS_SHOW_MEMBERSHIP_TIP_INT_SYNC, Integer.valueOf(1));
                    }
                    this.kiZ = this.kaS.baf();
                    if (this.kgn != 7 || this.kgn == 16) {
                        intent = new Intent();
                        intent.putExtra("key_code", this.kiZ);
                        setResult(-1, intent);
                        m55222tb(-1);
                    } else if (!this.kiV && this.kgn == 8) {
                        m55217n(true, -1);
                    } else if (this.kgn == 26 && i4 == 0) {
                        m55217n(true, -1);
                    }
                    if (this.kaS.aZQ()) {
                        C42852am.bbj().mo22959Gk(this.kaS.aZZ());
                    }
                    this.kja.mo73567a(this, this.kaE, this.kaS, this.ecs, this.ect);
                    AppMethodBeat.m2505o(88298);
                    return;
                }
                num = (Integer) C1720g.m3536RP().mo5239Ry().get(282884, null);
                if (num == null || num.intValue() != 1) {
                    C1720g.m3536RP().mo5239Ry().set(282884, Integer.valueOf(1));
                }
                this.kiZ = this.kaS.baf();
                if (this.kgn != 7) {
                }
                intent = new Intent();
                intent.putExtra("key_code", this.kiZ);
                setResult(-1, intent);
                m55222tb(-1);
                if (this.kaS.aZQ()) {
                }
                this.kja.mo73567a(this, this.kaE, this.kaS, this.ecs, this.ect);
                AppMethodBeat.m2505o(88298);
                return;
                if (C38736l.beE()) {
                    C42840d.m76038c(this, 2130968982, C25738R.string.acq, c42837b2.aZV().kdf);
                } else {
                    C42840d.m76038c(this, 2130968981, C25738R.string.acp, c42837b2.aZV().kdf);
                }
                this.kiZ = this.kaS.baf();
                if (this.kgn != 7) {
                }
                intent = new Intent();
                intent.putExtra("key_code", this.kiZ);
                setResult(-1, intent);
                m55222tb(-1);
                if (this.kaS.aZQ()) {
                }
                this.kja.mo73567a(this, this.kaE, this.kaS, this.ecs, this.ect);
                AppMethodBeat.m2505o(88298);
                return;
            } else if (c1207m instanceof C45787v) {
                this.kaY = ((C45787v) c1207m).keb;
                if (this.kaS == null || this.kaY == null || this.kaY.size() <= 0) {
                    if (this.kaS != null && this.kaY == null) {
                        this.kaS.mo45389a(null);
                        bbB();
                        if (this.kaS.aZC()) {
                            GK = C42852am.bbe().mo35397GK(this.kaE);
                            if (GK != null) {
                                GK.mo45389a(null);
                                C42852am.bbe().mo10103c(GK, this.kaE);
                            }
                            AppMethodBeat.m2505o(88298);
                            return;
                        }
                        CardInfo Gu = C42852am.baW().mo45383Gu(this.kaE);
                        if (Gu != null) {
                            Gu.mo45389a(null);
                            C42852am.baW().mo10103c(Gu, this.kaE);
                        }
                    }
                    AppMethodBeat.m2505o(88298);
                    return;
                }
                this.kaS.mo45389a((C23422od) this.kaY.get(0));
                bbB();
                if (this.kaS.aZC()) {
                    ShareCardInfo GK2 = C42852am.bbe().mo35397GK(this.kaE);
                    if (GK2 != null) {
                        GK2.mo45389a((C23422od) this.kaY.get(0));
                        C42852am.bbe().mo10103c(GK2, this.kaE);
                    }
                    AppMethodBeat.m2505o(88298);
                    return;
                }
                cardInfo = C42852am.baW().mo45383Gu(this.kaE);
                if (cardInfo != null) {
                    cardInfo.mo45389a((C23422od) this.kaY.get(0));
                    C42852am.baW().mo10103c(cardInfo, this.kaE);
                }
                AppMethodBeat.m2505o(88298);
                return;
            } else if (c1207m instanceof C45784af) {
                i3 = ((C45784af) c1207m).kdT;
                str3 = ((C45784af) c1207m).kdU;
                if (i3 == Downloads.MIN_WAIT_FOR_NETWORK) {
                    if (TextUtils.isEmpty(str3)) {
                        str3 = getString(C25738R.string.ae6);
                    }
                    C42840d.m76040c(this, str3);
                    AppMethodBeat.m2505o(88298);
                    return;
                }
                this.kiP = ((C45784af) c1207m).cMD;
                m55208fI(true);
                C35938no aZW = this.kaS.aZW();
                aZW.status = 3;
                this.kaS.mo45388a(aZW);
                C38736l.m65732h(this.kaS);
                bbB();
                if (this.kgn == 3) {
                    m55217n(true, 2);
                    AppMethodBeat.m2505o(88298);
                    return;
                }
                if (this.kgn == 15) {
                    C4879a.xxA.mo10055m(new C18376qk());
                }
                AppMethodBeat.m2505o(88298);
                return;
            } else if (c1207m instanceof C6817r) {
                C30379h.m48465bQ(this, getResources().getString(C25738R.string.adi));
                C42852am.baV();
                C27567b.m43779sO(4);
                m55217n(true, 1);
                AppMethodBeat.m2505o(88298);
                return;
            } else if (c1207m instanceof C11292t) {
                C11292t c11292t = (C11292t) c1207m;
                LinkedList linkedList = c11292t.kdZ;
                if (linkedList != null && linkedList.size() > 0) {
                    C42837b c42837b3 = (C42837b) linkedList.get(0);
                    if (c42837b3 == null || this.kaE.equals(c11292t.cardId)) {
                        this.kaS = c42837b3;
                        if (this.kaS != null) {
                            this.kaE = this.kaS.aZZ();
                            bcn();
                            if (this.kaS.aZQ()) {
                                C42852am.bbj().mo22959Gk(this.kaS.aZZ());
                            }
                        }
                        if (this.emC == 26) {
                            this.emC = 3;
                        }
                        bbB();
                    } else {
                        C4990ab.m7413e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", this.kaE, c11292t.cardId);
                        AppMethodBeat.m2505o(88298);
                        return;
                    }
                }
                bcl();
                C38736l.beB();
                AppMethodBeat.m2505o(88298);
                return;
            } else if (c1207m instanceof C42858g) {
                str2 = ((C42858g) c1207m).kdS;
                i4 = ((C42858g) c1207m).kdT;
                str3 = ((C42858g) c1207m).kdU;
                if (i4 != 0) {
                    if (TextUtils.isEmpty(str3)) {
                        str3 = getString(C25738R.string.ach);
                    }
                    C42840d.m76040c(this, str3);
                    C4990ab.m7413e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, accept card error, ret_msg:%s", str3);
                    AppMethodBeat.m2505o(88298);
                    return;
                }
                C30379h.m48465bQ(this, getResources().getString(C25738R.string.acl));
                if (TextUtils.isEmpty(str2)) {
                    C4990ab.m7412e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, json is null");
                    AppMethodBeat.m2505o(88298);
                    return;
                }
                this.emC = 3;
                if (this.kaS == null) {
                    this.kaS = new ShareCardInfo();
                } else if (this.kaS instanceof CardInfo) {
                    this.kaS = new ShareCardInfo();
                }
                C27575f.m43804a((ShareCardInfo) this.kaS, str2);
                GK = (ShareCardInfo) this.kaS;
                if (TextUtils.isEmpty(str2)) {
                    C4990ab.m7412e("MicroMsg.CardInfoParser", "parserShareCardItemEncryptCodeForSingle jsonContent is null");
                } else {
                    try {
                        JSONArray optJSONArray = new JSONObject(str2).optJSONArray("card_list");
                        if (optJSONArray != null) {
                            GK.kbY = optJSONArray.optJSONObject(0).optString("encrypt_code");
                            C4990ab.m7416i("MicroMsg.CardInfoParser", "encrypt_code:" + GK.kbY);
                        }
                    } catch (JSONException e) {
                        C4990ab.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
                        C4990ab.m7412e("MicroMsg.CardInfoParser", e.getMessage());
                    }
                }
                if (!TextUtils.isEmpty(this.kaS.aZZ())) {
                    this.kaE = this.kaS.aZZ();
                }
                if (TextUtils.isEmpty(this.kaS.bab())) {
                    ((ShareCardInfo) this.kaS).field_from_username = C1853r.m3846Yz();
                }
                C38736l.m65713a((ShareCardInfo) this.kaS);
                bcn();
                bbB();
                C38736l.beD();
                C42852am.bbd().aVU();
                this.kiZ = this.kaS.baf();
                if (this.kgn == 7 || this.kgn == 16) {
                    intent = new Intent();
                    intent.putExtra("key_code", this.kiZ);
                    setResult(-1, intent);
                    m55222tb(-1);
                } else if (!this.kiV && this.kgn == 8) {
                    m55217n(true, -1);
                }
                num = (Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_IS_SHOW_SHARE_CARD_TIP_INT_SYNC, Integer.valueOf(0));
                if (num == null || num.intValue() != 1) {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_IS_SHOW_SHARE_CARD_TIP_INT_SYNC, Integer.valueOf(1));
                    C42840d.m76038c(this, 2130968984, C25738R.string.ahe, "");
                }
                if (this.kaS.aZQ()) {
                    C42852am.bbj().mo22959Gk(this.kaS.aZZ());
                }
                AppMethodBeat.m2505o(88298);
                return;
            } else if (c1207m instanceof C27591c) {
                str2 = ((C27591c) c1207m).kdS;
                if (TextUtils.isEmpty(str2)) {
                    C4990ab.m7412e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetShareCard json is null");
                    AppMethodBeat.m2505o(88298);
                    return;
                }
                c42837b = this.kaS;
                this.kaS = new ShareCardInfo();
                GK = (ShareCardInfo) this.kaS;
                if (TextUtils.isEmpty(str2)) {
                    C4990ab.m7412e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
                } else {
                    try {
                        C27575f.m43805a(GK, new JSONObject(str2));
                    } catch (JSONException e2) {
                        C4990ab.printErrStackTrace("MicroMsg.CardInfoParser", e2, "", new Object[0]);
                    }
                }
                if (c42837b != null) {
                    if (!TextUtils.isEmpty(c42837b.bab())) {
                        ((ShareCardInfo) this.kaS).field_from_username = ((ShareCardInfo) c42837b).field_from_username;
                    }
                    ((ShareCardInfo) this.kaS).field_app_id = ((ShareCardInfo) c42837b).field_app_id;
                    ((ShareCardInfo) this.kaS).field_consumer = ((ShareCardInfo) c42837b).field_consumer;
                    ((ShareCardInfo) this.kaS).field_share_time = ((ShareCardInfo) c42837b).field_share_time;
                    ((ShareCardInfo) this.kaS).field_updateTime = ((ShareCardInfo) c42837b).field_updateTime;
                    ((ShareCardInfo) this.kaS).field_begin_time = ((ShareCardInfo) c42837b).field_begin_time;
                    ((ShareCardInfo) this.kaS).field_end_time = ((ShareCardInfo) c42837b).field_end_time;
                    ((ShareCardInfo) this.kaS).field_block_mask = ((ShareCardInfo) c42837b).field_block_mask;
                    this.kaS.mo45389a(c42837b.aZY());
                    ((ShareCardInfo) this.kaS).field_categoryType = ((ShareCardInfo) c42837b).field_categoryType;
                    ((ShareCardInfo) this.kaS).field_itemIndex = ((ShareCardInfo) c42837b).field_itemIndex;
                    if (((ShareCardInfo) c42837b).field_status != ((ShareCardInfo) this.kaS).field_status) {
                        C4990ab.m7416i("MicroMsg.CardDetailUI", "getsharecared return, the status is " + ((ShareCardInfo) this.kaS).field_status);
                        C42856b.m76079a((Context) this, this.kaS);
                    }
                }
                if (!TextUtils.isEmpty(this.kaS.aZZ())) {
                    this.kaE = this.kaS.aZZ();
                }
                bbB();
                bcn();
                bcl();
                if (this.emC == 3) {
                    if (this.kiW) {
                        C38736l.m65732h(this.kaS);
                    } else {
                        C4990ab.m7412e("MicroMsg.CardDetailUI", "onSceneEnd() sharecard updateDataToDB is false");
                    }
                }
                if (this.kaS.aZQ()) {
                    C42852am.bbj().mo22959Gk(this.kaS.aZZ());
                }
                AppMethodBeat.m2505o(88298);
                return;
            } else if (c1207m instanceof C20151a) {
                if (((C20151a) c1207m).kdT != 0) {
                    C42840d.m76040c(this, getString(C25738R.string.adg));
                    AppMethodBeat.m2505o(88298);
                    return;
                }
                C4990ab.m7416i("MicroMsg.CardDetailUI", "delete share card, card id is " + this.kaS.aZZ());
                C42856b.m76079a((Context) this, this.kaS);
                C30379h.m48465bQ(this, getResources().getString(C25738R.string.adi));
                C42852am.bbd().bbr();
                m55217n(true, -1);
                AppMethodBeat.m2505o(88298);
                return;
            }
        }
        CharSequence charSequence;
        C4990ab.m7412e("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + i + " errCode = " + i2 + " cmd:" + c1207m.getType());
        m55207fE(false);
        Object charSequence2;
        if (c1207m instanceof C45784af) {
            m55208fI(false);
            i3 = ((C45784af) c1207m).kdT;
            charSequence2 = ((C45784af) c1207m).kdU;
            if (i3 == Downloads.MIN_WAIT_FOR_NETWORK) {
                if (TextUtils.isEmpty(charSequence2)) {
                    charSequence2 = getString(C25738R.string.ae6);
                }
            }
            charSequence2 = str;
        } else if (c1207m instanceof C33772o) {
            m55222tb(0);
            m55202c(i2, str, ((C33772o) c1207m).kdT, ((C33772o) c1207m).kdU);
            AppMethodBeat.m2505o(88298);
            return;
        } else {
            if (c1207m instanceof C45787v) {
                AppMethodBeat.m2505o(88298);
                return;
            }
            charSequence2 = str;
        }
        if (TextUtils.isEmpty(charSequence2)) {
            charSequence2 = getString(C25738R.string.aih);
        }
        Toast.makeText(this.mController.ylL, charSequence2, 0).show();
        AppMethodBeat.m2505o(88298);
    }

    /* renamed from: c */
    private void m55202c(int i, String str, int i2, String str2) {
        AppMethodBeat.m2504i(88299);
        C4990ab.m7412e("MicroMsg.CardDetailUI", "handleAcceptError, errCode = " + i + " errMsg = " + str + " ret_code:" + i2 + " ret_msg:" + str2);
        if (i2 == Downloads.MIN_WAIT_FOR_NETWORK) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(C25738R.string.aci);
            }
            this.kaS.aZW().status = 4;
            bbB();
        } else if (i2 == 10001) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(C25738R.string.acm);
            }
            this.kaS.aZW().status = 5;
            bbB();
        } else if (i2 == 10002) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(C25738R.string.aga);
            }
        } else if (TextUtils.isEmpty(str2)) {
            str2 = getString(C25738R.string.acg);
        }
        C42840d.m76040c(this, str2);
        AppMethodBeat.m2505o(88299);
    }

    /* renamed from: fE */
    private void m55207fE(boolean z) {
        AppMethodBeat.m2504i(88300);
        if (z) {
            this.ejZ = C44275p.m79966b(this, getString(C25738R.string.cn5), true, null);
            AppMethodBeat.m2505o(88300);
            return;
        }
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
            this.ejZ = null;
        }
        AppMethodBeat.m2505o(88300);
    }

    /* renamed from: fI */
    private void m55208fI(boolean z) {
        AppMethodBeat.m2504i(88301);
        if (z) {
            C38736l.m65727dw(this.kiM.kjA, this.kiM.kjz);
        }
        AppMethodBeat.m2505o(88301);
    }

    private void bcm() {
        AppMethodBeat.m2504i(88302);
        cdc cdc = new cdc();
        cdc.xcM = this.fhu;
        cdc.kdi = this.kiT;
        C4990ab.m7417i("MicroMsg.CardDetailUI", "GetCardItemInfo templateId:%s", this.fhu);
        C1720g.m3535RO().eJo.mo14541a(new C11284aa(this.kaE, this.emC, this.kiN, this.kiP, this.kir, this.kis, this.kiq, this.kit, cdc), 0);
        AppMethodBeat.m2505o(88302);
    }

    private void bcn() {
        String baa;
        AppMethodBeat.m2504i(88303);
        if (!TextUtils.isEmpty(this.kaS.baa())) {
            baa = this.kaS.baa();
        } else if (TextUtils.isEmpty(this.kaE)) {
            C4990ab.m7412e("MicroMsg.CardDetailUI", "doNetSceneCardShopLBS card id is null, return");
            AppMethodBeat.m2505o(88303);
            return;
        } else {
            baa = this.kaE;
        }
        if (this.kaS == null || this.kaS.aZV().vUa != 1) {
            if (this.kaS == null || this.kaS.aZV().vUa <= 1) {
                if (this.kaS != null) {
                    this.kaS.mo45389a(null);
                    bbB();
                    if (this.kaS.aZC()) {
                        ShareCardInfo GK = C42852am.bbe().mo35397GK(this.kaE);
                        if (GK != null) {
                            GK.mo45389a(null);
                            C42852am.bbe().mo10103c(GK, this.kaE);
                        }
                        AppMethodBeat.m2505o(88303);
                        return;
                    }
                    CardInfo Gu = C42852am.baW().mo45383Gu(this.kaE);
                    if (Gu != null) {
                        Gu.mo45389a(null);
                        C42852am.baW().mo10103c(Gu, this.kaE);
                    }
                }
            } else if (this.ecs != -85.0f && this.ect != -1000.0f) {
                this.kiY = false;
                C1720g.m3535RO().eJo.mo14541a(new C45787v(baa, this.ect, this.ecs, this.kaS.aZZ()), 0);
                AppMethodBeat.m2505o(88303);
                return;
            } else if (!this.kiY) {
                this.kiY = true;
                if (this.khx) {
                    aZt();
                    AppMethodBeat.m2505o(88303);
                    return;
                }
            }
            AppMethodBeat.m2505o(88303);
            return;
        }
        float f = this.ecs;
        float f2 = this.ect;
        if (f == -85.0f || f2 == -1000.0f) {
            f = C42852am.bbc().ecs;
            f2 = C42852am.bbc().ect;
        }
        C1720g.m3535RO().eJo.mo14541a(new C45787v(baa, f2, f, this.kaS.aZZ()), 0);
        AppMethodBeat.m2505o(88303);
    }

    private void bco() {
        AppMethodBeat.m2504i(88304);
        C1720g.m3535RO().eJo.mo14541a(new C27591c(this.kaE), 0);
        AppMethodBeat.m2505o(88304);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(88305);
        if (i == 4) {
            C4990ab.m7412e("MicroMsg.CardDetailUI", "onKeyDown finishUI");
            m55217n(false, -1);
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(88305);
        return onKeyDown;
    }

    /* renamed from: n */
    private void m55217n(boolean z, int i) {
        AppMethodBeat.m2504i(88306);
        Intent intent;
        if (i == 1) {
            intent = new Intent();
            intent.putExtra("key_code", this.kiZ);
            intent.putExtra("key_card_id", this.kaE);
            intent.putExtra("key_finish_action", i);
            setResult(-1, intent);
            if (z) {
                finish();
            }
            AppMethodBeat.m2505o(88306);
        } else if ((this.kgn == 7 || this.kgn == 8 || this.kgn == 16 || this.kgn == 26) && this.emC == 3) {
            intent = new Intent();
            intent.putExtra("key_code", this.kiZ);
            if (i > 0) {
                intent.putExtra("key_card_id", this.kaE);
                intent.putExtra("key_finish_action", i);
            }
            setResult(-1, intent);
            if (z) {
                finish();
            }
            AppMethodBeat.m2505o(88306);
        } else {
            if ((this.kgn == 7 && this.emC == 7) || ((this.kgn == 16 && this.emC == 16) || ((this.kgn == 8 && this.emC == 8) || (this.kgn == 26 && this.emC == 26)))) {
                setResult(0);
                if (z) {
                    finish();
                    AppMethodBeat.m2505o(88306);
                    return;
                }
            } else if (z) {
                finish();
            }
            AppMethodBeat.m2505o(88306);
        }
    }

    /* renamed from: tb */
    private void m55222tb(int i) {
        AppMethodBeat.m2504i(88307);
        if (this.kgn == 7 || this.kgn == 16) {
            LinkedList linkedList = new LinkedList();
            C38744e c38744e = new C38744e();
            c38744e.kbU = this.kaS.baa();
            c38744e.cMD = this.kiP;
            c38744e.code = this.kiZ;
            linkedList.add(c38744e);
            C32517b c32517b = new C32517b();
            c32517b.crM.bFZ = i;
            if (i == -1) {
                c32517b.crM.crN = C20135h.m31151a(linkedList, true, this.kgn);
            } else {
                c32517b.crM.crN = C20135h.m31151a(linkedList, false, this.kgn);
            }
            C4879a.xxA.mo10055m(c32517b);
            AppMethodBeat.m2505o(88307);
            return;
        }
        C4990ab.m7416i("MicroMsg.CardDetailUI", "mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_JSAPI and mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_NEARBY_PEOPLE_JSAPI ,don't push accept event");
        AppMethodBeat.m2505o(88307);
    }

    private void aZt() {
        AppMethodBeat.m2504i(88308);
        if (this.fwu == null) {
            this.fwu = C26443d.agz();
        }
        this.fwu.mo44204a(this.ecy, true);
        AppMethodBeat.m2505o(88308);
    }

    private void aZv() {
        AppMethodBeat.m2504i(88309);
        if (this.fwu != null) {
            this.fwu.mo44208c(this.ecy);
        }
        AppMethodBeat.m2505o(88309);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(88311);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.CardDetailUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(88311);
            return;
        }
        C4990ab.m7417i("MicroMsg.CardDetailUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 69:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dby), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.atb), false, new C337804(), null);
                    break;
                }
                C4990ab.m7416i("MicroMsg.CardDetailUI", "onMPermissionGranted LocationPermissionGranted " + this.khx);
                if (!this.khx) {
                    this.khx = true;
                    bbN();
                }
                AppMethodBeat.m2505o(88311);
                return;
        }
        AppMethodBeat.m2505o(88311);
    }

    /* renamed from: Gl */
    private synchronized void m55191Gl(String str) {
        AppMethodBeat.m2504i(88312);
        if (this.kgB) {
            C4990ab.m7412e("MicroMsg.CardDetailUI", "has start CardConsumeSuccessUI!");
            AppMethodBeat.m2505o(88312);
        } else {
            C4990ab.m7416i("MicroMsg.CardDetailUI", "startConsumedSuccUI() ");
            this.kgB = true;
            Intent intent = new Intent(this, CardConsumeSuccessUI.class);
            intent.putExtra("KEY_CARD_ID", this.kaS.aZZ());
            intent.putExtra("KEY_CARD_CONSUMED_JSON", str);
            intent.putExtra("KEY_CARD_COLOR", this.kaS.aZV().color);
            intent.putExtra("key_stastic_scene", this.emC);
            intent.putExtra("key_from_scene", 0);
            startActivity(intent);
            AppMethodBeat.m2505o(88312);
        }
    }

    /* renamed from: d */
    public final void mo41613d(C42837b c42837b) {
        AppMethodBeat.m2504i(88313);
        if (c42837b == null) {
            C4990ab.m7412e("MicroMsg.CardDetailUI", "cardInfo is empty, not to do onDataChange");
            AppMethodBeat.m2505o(88313);
        } else if (this.kaS == null || !this.kaS.aZZ().equals(c42837b.aZZ())) {
            C4990ab.m7412e("MicroMsg.CardDetailUI", "is not the same card, not to do onDataChange");
            AppMethodBeat.m2505o(88313);
        } else if (this.kiM.bcT()) {
            C4990ab.m7416i("MicroMsg.CardDetailUI", "onDataChange");
            this.kaS = c42837b;
            this.kaE = this.kaS.aZZ();
            if (this.kaS.aZQ() && C42852am.bbj().isEmpty()) {
                C42852am.bbj().mo22959Gk(this.kaS.aZZ());
            }
            bbB();
            AppMethodBeat.m2505o(88313);
        } else {
            C4990ab.m7412e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onDataChange");
            AppMethodBeat.m2505o(88313);
        }
    }

    public final void bau() {
        AppMethodBeat.m2504i(88314);
        C4990ab.m7416i("MicroMsg.CardDetailUI", "onVibrate");
        this.kgA.vibrate(300);
        AppMethodBeat.m2505o(88314);
    }

    public final void bav() {
        AppMethodBeat.m2504i(88315);
        C4990ab.m7416i("MicroMsg.CardDetailUI", "onFinishUI");
        AppMethodBeat.m2505o(88315);
    }

    /* renamed from: Gm */
    public final void mo41610Gm(final String str) {
        AppMethodBeat.m2504i(88316);
        if (this.kiM.bcT()) {
            C4990ab.m7416i("MicroMsg.CardDetailUI", "onStartConsumedSuccUI");
            this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(88285);
                    CardDetailUI.m55203c(CardDetailUI.this, str);
                    AppMethodBeat.m2505o(88285);
                }
            });
            AppMethodBeat.m2505o(88316);
            return;
        }
        C4990ab.m7412e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onStartConsumedSuccUI");
        AppMethodBeat.m2505o(88316);
    }

    /* renamed from: b */
    public final void mo35375b(String str, C20125b c20125b) {
        AppMethodBeat.m2504i(88317);
        if (TextUtils.isEmpty(str) || str.equals(this.kaE)) {
            m55207fE(false);
            C4990ab.m7416i("MicroMsg.CardDetailUI", "onMarkSuccess()");
            C4990ab.m7416i("MicroMsg.CardDetailUI", "markSucc:" + c20125b.kbI + " markCardId: " + c20125b.kbJ);
            this.kiR = false;
            if (c20125b.kbI != 1) {
                this.kiQ = false;
                C42840d.m76040c(this, getString(C25738R.string.afs));
            } else if (TextUtils.isEmpty(c20125b.kbJ) || this.kaS.aZZ().equals(c20125b.kbJ)) {
                C4990ab.m7416i("MicroMsg.CardDetailUI", "markCardId is same as now id!");
                this.kiQ = true;
                m55195a(c20125b);
                AppMethodBeat.m2505o(88317);
                return;
            } else {
                C4990ab.m7416i("MicroMsg.CardDetailUI", "markCardId is diff as now id!");
                if (this.kaS.aZC()) {
                    ShareCardInfo GK = C42852am.bbe().mo35397GK(c20125b.kbJ);
                    if (GK != null) {
                        this.kaS = GK;
                        this.kaE = c20125b.kbJ;
                        bbB();
                        C42852am.bbh().mo45375b(this.kaS);
                        C4990ab.m7416i("MicroMsg.CardDetailUI", "update the mCardInfo");
                        this.kiQ = true;
                        m55195a(c20125b);
                        AppMethodBeat.m2505o(88317);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.CardDetailUI", "The mark card id not exist the card info in DB!， mark failed!");
                    C42840d.m76040c(this, getString(C25738R.string.afr));
                    this.kiQ = false;
                    AppMethodBeat.m2505o(88317);
                    return;
                }
            }
            AppMethodBeat.m2505o(88317);
            return;
        }
        C4990ab.m7412e("MicroMsg.CardDetailUI", "onMarkSuccess(), the mark card id is diff from current id!");
        AppMethodBeat.m2505o(88317);
    }

    /* renamed from: dl */
    public final void mo35376dl(String str, String str2) {
        AppMethodBeat.m2504i(88318);
        if (TextUtils.isEmpty(str) || str.equals(this.kaE)) {
            C4990ab.m7416i("MicroMsg.CardDetailUI", "onMarkFail()");
            this.kiQ = false;
            this.kiR = false;
            m55207fE(false);
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(C25738R.string.afr);
            }
            C42840d.m76040c(this, str2);
            AppMethodBeat.m2505o(88318);
            return;
        }
        C4990ab.m7412e("MicroMsg.CardDetailUI", "onMarkFail(), the mark card id is diff from current id!");
        AppMethodBeat.m2505o(88318);
    }

    /* renamed from: Gp */
    public final void mo35374Gp(String str) {
        AppMethodBeat.m2504i(88319);
        if (TextUtils.isEmpty(str) || str.equals(this.kaE)) {
            this.kiQ = false;
            AppMethodBeat.m2505o(88319);
            return;
        }
        C4990ab.m7412e("MicroMsg.CardDetailUI", "onUnmarkSuccess(), the mark card id is diff from current id!");
        AppMethodBeat.m2505o(88319);
    }

    /* renamed from: a */
    private void m55195a(C20125b c20125b) {
        AppMethodBeat.m2504i(88320);
        if (this.kiM.cAY) {
            C4990ab.m7416i("MicroMsg.CardDetailUI", "UI is pause, not to jumpMarkUI()");
            AppMethodBeat.m2505o(88320);
            return;
        }
        C4990ab.m7416i("MicroMsg.CardDetailUI", "jumpMarkUI()");
        this.kiM.mo61638a(this.kiS, c20125b, true);
        AppMethodBeat.m2505o(88320);
    }

    public final void bap() {
        AppMethodBeat.m2504i(88321);
        C4990ab.m7416i("MicroMsg.CardDetailUI", "code change");
        if (this.kiM.kjk instanceof C42869q) {
            ((C42869q) this.kiM.kjk).knw = C42852am.bbj().getCode();
            this.kiM.bbB();
        }
        AppMethodBeat.m2505o(88321);
    }

    /* renamed from: Gj */
    public final void mo22968Gj(String str) {
        AppMethodBeat.m2504i(88322);
        if (!TextUtils.isEmpty(str)) {
            C42840d.m76036a(this, str, true);
        }
        AppMethodBeat.m2505o(88322);
    }

    public final void onSuccess() {
        AppMethodBeat.m2504i(88323);
        if (this.kiM.kjk instanceof C42869q) {
            ((C42869q) this.kiM.kjk).knw = C42852am.bbj().getCode();
            this.kiM.bbB();
        }
        C4990ab.m7416i("MicroMsg.CardDetailUI", "code get success");
        AppMethodBeat.m2505o(88323);
    }

    private void bbN() {
        AppMethodBeat.m2504i(88310);
        this.fwu = C26443d.agz();
        aZt();
        AppMethodBeat.m2505o(88310);
    }

    /* renamed from: h */
    static /* synthetic */ void m55210h(CardDetailUI cardDetailUI) {
        AppMethodBeat.m2504i(88326);
        cardDetailUI.m55217n(true, -1);
        AppMethodBeat.m2505o(88326);
    }

    /* renamed from: i */
    static /* synthetic */ void m55211i(CardDetailUI cardDetailUI) {
        int i;
        AppMethodBeat.m2504i(88327);
        cardDetailUI.m55207fE(true);
        byx byx = new byx();
        if (cardDetailUI.emC == 3) {
            byx.cMC = cardDetailUI.kaE;
            i = 1;
        } else {
            byx.kbU = cardDetailUI.kaE;
            i = 0;
        }
        byx.cMD = cardDetailUI.kiP;
        byx.vBv = cardDetailUI.kir;
        byx.vBu = cardDetailUI.kis;
        byx.vBw = cardDetailUI.kiq;
        LinkedList linkedList = new LinkedList();
        linkedList.add(byx);
        bzm a = C38736l.m65710a(cardDetailUI.kiM.kgP, cardDetailUI.kiM.kgS, cardDetailUI.kiM.kgT);
        cdc cdc = new cdc();
        cdc.xcM = cardDetailUI.fhu;
        cdc.kdi = cardDetailUI.kiT;
        C4990ab.m7417i("MicroMsg.CardDetailUI", "ShareCardItem upload templateId:%s", cardDetailUI.fhu);
        C1720g.m3535RO().eJo.mo14541a(new C42858g(i, linkedList, cardDetailUI.kaS.aZV().vTT, cardDetailUI.kit, a, cardDetailUI.emC, cdc), 0);
        AppMethodBeat.m2505o(88327);
    }

    /* renamed from: j */
    static /* synthetic */ void m55212j(CardDetailUI cardDetailUI) {
        AppMethodBeat.m2504i(88329);
        LinkedList linkedList = new LinkedList();
        linkedList.add(cardDetailUI.kaE);
        cardDetailUI.m55207fE(true);
        C1720g.m3535RO().eJo.mo14541a(new C6817r(linkedList), 0);
        AppMethodBeat.m2505o(88329);
    }

    /* renamed from: k */
    static /* synthetic */ void m55213k(CardDetailUI cardDetailUI) {
        String str;
        AppMethodBeat.m2504i(88330);
        cardDetailUI.m55207fE(true);
        if (cardDetailUI.emC == 6 || TextUtils.isEmpty(cardDetailUI.kaS.baa())) {
            str = cardDetailUI.kaE;
        } else {
            str = cardDetailUI.kaS.baa();
        }
        int bcS = cardDetailUI.kiM.bcS();
        cdc cdc = new cdc();
        cdc.xcM = cardDetailUI.fhu;
        cdc.kdi = cardDetailUI.kiT;
        C4990ab.m7417i("MicroMsg.CardDetailUI", "AcceptItemInfo templateId:%s", cardDetailUI.fhu);
        C1720g.m3535RO().eJo.mo14541a(new C33772o(str, cardDetailUI.emC, cardDetailUI.kiN, cardDetailUI.kiP, cardDetailUI.kir, cardDetailUI.kis, cardDetailUI.kiq, bcS, cdc), 0);
        AppMethodBeat.m2505o(88330);
    }

    /* renamed from: l */
    static /* synthetic */ void m55214l(CardDetailUI cardDetailUI) {
        AppMethodBeat.m2504i(88331);
        C1720g.m3535RO().eJo.mo14541a(new C20151a(cardDetailUI.kaE), 0);
        AppMethodBeat.m2505o(88331);
    }
}
