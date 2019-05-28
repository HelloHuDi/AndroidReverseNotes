package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.qk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.plugin.appbrand.jsapi.k.w;
import com.tencent.mm.plugin.card.b.c.a;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.b.i;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.k;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.aa;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.e;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI;
import com.tencent.mm.plugin.card.ui.view.q;
import com.tencent.mm.plugin.card.ui.view.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.bzm;
import com.tencent.mm.protocal.protobuf.cdc;
import com.tencent.mm.protocal.protobuf.no;
import com.tencent.mm.protocal.protobuf.od;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CardDetailUI extends CardDetailBaseUI implements f, a, d.a, j.a, bc.a {
    private final String TAG = "MicroMsg.CardDetailUI";
    private float ecs = -85.0f;
    private float ect = -1000.0f;
    private b.a ecy = new b.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.i(88272);
            if (z) {
                if (CardDetailUI.this.ecs == -85.0f && CardDetailUI.this.ect == -1000.0f) {
                    CardDetailUI.this.ecs = f2;
                    CardDetailUI.this.ect = f;
                    am.bbc().O(CardDetailUI.this.ecs, CardDetailUI.this.ect);
                }
                i c = CardDetailUI.this.kja;
                float b = CardDetailUI.this.ect;
                float a = CardDetailUI.this.ecs;
                synchronized (c.kbe) {
                    try {
                        c.ecs = a;
                        c.ect = b;
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(88272);
                        }
                    }
                }
                if (CardDetailUI.this.kiY) {
                    CardDetailUI.e(CardDetailUI.this);
                    CardDetailUI.this.kiY = false;
                }
                CardDetailUI.g(CardDetailUI.this);
                AppMethodBeat.o(88272);
                return false;
            }
            AppMethodBeat.o(88272);
            return true;
        }
    };
    private p ejZ = null;
    private int emC = 3;
    private String fhu = "";
    private com.tencent.mm.modelgeo.d fwu;
    private String kaE = "";
    private com.tencent.mm.plugin.card.base.b kaS;
    private ArrayList<od> kaY;
    private String kbQ = "";
    private boolean kcf = false;
    private Vibrator kgA;
    private boolean kgB = false;
    private int kgn = -1;
    private boolean khx = false;
    e kiM;
    private String kiN = "";
    private String kiO = "";
    private String kiP = "";
    private boolean kiQ = false;
    private boolean kiR = false;
    private boolean kiS = false;
    private String kiT = "";
    private e.a kiU;
    private boolean kiV = false;
    private boolean kiW = true;
    private boolean kiX = false;
    private boolean kiY = false;
    private String kiZ = "";
    private int kiq = 0;
    private String kir = "";
    private String kis = "";
    private String kit = "";
    private i kja = new i();
    ak mHandler = new ak();
    private long mStartTime = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardDetailUI() {
        AppMethodBeat.i(88286);
        AppMethodBeat.o(88286);
    }

    static /* synthetic */ void c(CardDetailUI cardDetailUI, String str) {
        AppMethodBeat.i(88334);
        cardDetailUI.Gl(str);
        AppMethodBeat.o(88334);
    }

    static /* synthetic */ void e(CardDetailUI cardDetailUI) {
        AppMethodBeat.i(88324);
        cardDetailUI.bcn();
        AppMethodBeat.o(88324);
    }

    static /* synthetic */ void g(CardDetailUI cardDetailUI) {
        AppMethodBeat.i(88325);
        cardDetailUI.aZv();
        AppMethodBeat.o(88325);
    }

    static /* synthetic */ void o(CardDetailUI cardDetailUI) {
        AppMethodBeat.i(88332);
        cardDetailUI.bco();
        AppMethodBeat.o(88332);
    }

    static /* synthetic */ void q(CardDetailUI cardDetailUI) {
        AppMethodBeat.i(88333);
        cardDetailUI.fE(true);
        AppMethodBeat.o(88333);
    }

    public final int getLayoutId() {
        return R.layout.ig;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(88287);
        super.onCreate(bundle);
        this.mStartTime = System.currentTimeMillis();
        bci();
        com.tencent.mm.plugin.card.base.d bbh = am.bbh();
        AppCompatActivity appCompatActivity = this.mController.ylL;
        g.RO().eJo.a(910, (f) bbh);
        am.bbd().a(bbh);
        com.tencent.mm.plugin.card.b.b baV = am.baV();
        if (baV.kaD == null) {
            baV.kaD = new ArrayList();
        }
        baV.kaD.add(new WeakReference(bbh));
        bbh.atF = new WeakReference(appCompatActivity);
        am.bbh().a((d.a) this);
        am.bbi().a(this);
        f bbj = am.bbj();
        g.RO().eJo.a((int) w.CTRL_INDEX, bbj);
        bbj.kaF.clear();
        bbj.kaG = 0;
        am.bbj().a(this);
        initView();
        AppMethodBeat.o(88287);
    }

    public void onResume() {
        AppMethodBeat.i(88288);
        super.onResume();
        bci();
        if (this.fwu != null) {
            this.fwu.a(this.ecy, true);
        }
        this.kiM.cAY = false;
        bc.a(this, this);
        am.bbh().a(this, true);
        if ((this.kiQ || this.kiR) && this.kaS.aZC()) {
            if (this.kaS.aZP()) {
                boolean z;
                am.bbi().bM(this.kaE, 2);
                d bbh = am.bbh();
                Boolean bool = (Boolean) bbh.kaR.get(this.kaE);
                if (bool == null || !bool.booleanValue()) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z || TextUtils.isEmpty(am.bbh().kaU)) {
                    ab.i("MicroMsg.CardDetailUI", "onResume, not need launch succ ui or jsonRet is empty!");
                } else {
                    ab.i("MicroMsg.CardDetailUI", "onResume, do launch succ UI!");
                    Gm(am.bbh().kaU);
                }
                this.kiM.kjk.d(c.CARDCODEREFRESHACTION_DOREFRESH);
            } else {
                am.bbi().bM(this.kaE, 1);
                com.tencent.mm.plugin.card.ui.view.g gVar = this.kiM.kjk;
                if (gVar != null) {
                    gVar.d(c.CARDCODEREFRESHACTION_DOREFRESH);
                }
            }
        }
        if (this.kja.bZi) {
            this.kja.start();
        }
        AppMethodBeat.o(88288);
    }

    public void onPause() {
        AppMethodBeat.i(88289);
        bcj();
        super.onPause();
        this.kiM.cAY = true;
        am.bbh().a(this, false);
        bc.a(this, null);
        f fVar = this.kja;
        if (fVar.baF()) {
            ab.i("MicroMsg.CardLbsOrBluetooth", "stop");
            if (fVar.kbk != null) {
                fVar.kbk.baI();
            }
            fVar.baC();
            g.RO().eJo.b(2574, fVar);
        }
        AppMethodBeat.o(88289);
    }

    public final void aNW() {
        AppMethodBeat.i(88290);
        com.tencent.mm.plugin.card.ui.view.g gVar = this.kiM.kjk;
        if (gVar != null) {
            gVar.bew();
        }
        h.pYm.e(16827, this.kaE, Long.valueOf(System.currentTimeMillis() / 1000));
        AppMethodBeat.o(88290);
    }

    public void onDestroy() {
        AppMethodBeat.i(88291);
        am.bbh().c((d.a) this);
        bcj();
        am.bbh().b((d.a) this);
        am.bbh().release();
        am.bbi().b(this);
        am.bbj().b(this);
        am.bbj().release();
        e eVar = this.kiM;
        com.tencent.mm.plugin.card.b.f fVar = eVar.kjy;
        fVar.kaS = null;
        fVar.kaW.clear();
        eVar.kjy = null;
        j jVar = eVar.kjw;
        l.K(jVar.kno);
        for (int size = jVar.knv.size() - 1; size >= 0; size--) {
            l.K((Bitmap) jVar.knv.remove(size));
        }
        jVar.knv.clear();
        if (jVar.gKG.isShowing()) {
            jVar.gKG.dismiss();
        }
        jVar.gKG = null;
        jVar.bdq();
        jVar.knn = null;
        jVar.kaS = null;
        eVar.kjw = null;
        if (eVar.kjj != null) {
            eVar.kjj.release();
        }
        eVar.kjd.ifE = null;
        com.tencent.mm.sdk.b.a.xxA.d(eVar.kjH);
        eVar.kjf.destroy();
        eVar.kji.destroy();
        eVar.kjh.destroy();
        eVar.kju.destroy();
        if (eVar.kjv != null) {
            eVar.kjv.destroy();
        }
        if (eVar.kjn != null) {
            eVar.kjn.destroy();
        }
        if (eVar.kjm != null) {
            eVar.kjm.destroy();
        }
        if (eVar.kjo != null) {
            eVar.kjo.destroy();
        }
        if (eVar.kjp != null) {
            eVar.kjp.destroy();
        }
        if (eVar.kjq != null) {
            eVar.kjq.destroy();
        }
        if (eVar.kjr != null) {
            eVar.kjr.destroy();
        }
        if (eVar.kjs != null) {
            eVar.kjs.destroy();
        }
        if (eVar.kjt != null) {
            eVar.kjt.destroy();
        }
        if (eVar.kjk != null) {
            eVar.kjk.destroy();
        }
        eVar.kje = null;
        com.tencent.mm.plugin.card.b.g bbm = am.bbm();
        if (bbm.kaD != null) {
            for (int i = 0; i < bbm.kaD.size(); i++) {
                WeakReference weakReference = (WeakReference) bbm.kaD.get(i);
                if (weakReference != null) {
                    com.tencent.mm.plugin.card.b.g.a aVar = (com.tencent.mm.plugin.card.b.g.a) weakReference.get();
                    if (aVar != null && aVar.equals(eVar)) {
                        bbm.kaD.remove(weakReference);
                        break;
                    }
                }
            }
        }
        am.bbm().release();
        this.kgA.cancel();
        aZv();
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (this.kaS != null) {
            h.pYm.e(13219, "CardDetailView", Integer.valueOf(this.emC), this.kaS.baa(), this.kaS.aZZ(), Long.valueOf(currentTimeMillis));
        } else {
            h.pYm.e(13219, "CardDetailView", Integer.valueOf(this.emC), this.kaE, this.kaE, Long.valueOf(currentTimeMillis));
        }
        if ((this.kiQ || this.kiR) && this.kaS != null && this.kaS.aZC()) {
            if (this.kaS.aZP()) {
                am.bbi().bM(this.kaE, 2);
            } else {
                am.bbi().bM(this.kaE, 1);
            }
        }
        i iVar = this.kja;
        ab.i("MicroMsg.CardLbsOrBluetooth", "uninit");
        if (iVar.kbk != null) {
            i.a aVar2 = iVar.kbk;
            if (aVar2.hDr == null) {
                ab.e("MicroMsg.CardLbsOrBluetooth", "bluetoothStateListener null, return");
            } else {
                ah.getContext().unregisterReceiver(aVar2.hDr);
                aVar2.hDr = null;
            }
            iVar.kbk = null;
        }
        iVar.baC();
        iVar.kbp = null;
        iVar.kbc = null;
        super.onDestroy();
        AppMethodBeat.o(88291);
    }

    private void bci() {
        AppMethodBeat.i(88292);
        g.RO().eJo.a(645, (f) this);
        g.RO().eJo.a(651, (f) this);
        g.RO().eJo.a(563, (f) this);
        g.RO().eJo.a(652, (f) this);
        g.RO().eJo.a(560, (f) this);
        g.RO().eJo.a(699, (f) this);
        g.RO().eJo.a(902, (f) this);
        g.RO().eJo.a(904, (f) this);
        g.RO().eJo.a(1163, (f) this);
        AppMethodBeat.o(88292);
    }

    private void bcj() {
        AppMethodBeat.i(88293);
        g.RO().eJo.b(645, (f) this);
        g.RO().eJo.b(651, (f) this);
        g.RO().eJo.b(563, (f) this);
        g.RO().eJo.b(652, (f) this);
        g.RO().eJo.b(560, (f) this);
        g.RO().eJo.b(699, (f) this);
        g.RO().eJo.b(902, (f) this);
        g.RO().eJo.b(904, (f) this);
        g.RO().eJo.b(1163, (f) this);
        AppMethodBeat.o(88293);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0261  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initView() {
        boolean z;
        AppMethodBeat.i(88294);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(88273);
                CardDetailUI.h(CardDetailUI.this);
                AppMethodBeat.o(88273);
                return true;
            }
        });
        this.kgA = (Vibrator) getSystemService("vibrator");
        if (this.kiM == null) {
            this.kiM = new e(this, this.mController.contentView);
            e eVar = this.kiM;
            eVar.kjw = new j(eVar.kjd);
            j jVar = eVar.kjw;
            jVar.kgj = jVar.knn.getWindow().getAttributes().screenBrightness;
            if (jVar.gKG == null) {
                View inflate = View.inflate(jVar.knn, R.layout.jq, null);
                jVar.gKI = inflate.findViewById(R.id.ai9);
                jVar.gKH = (ImageView) inflate.findViewById(R.id.ai_);
                jVar.knp = (TextView) inflate.findViewById(R.id.aia);
                jVar.knq = (TextView) inflate.findViewById(R.id.aib);
                jVar.knr = inflate.findViewById(R.id.aic);
                jVar.kns = (ImageView) inflate.findViewById(R.id.aif);
                jVar.knt = (MMVerticalTextView) inflate.findViewById(R.id.aie);
                jVar.knu = (MMVerticalTextView) inflate.findViewById(R.id.aid);
                inflate.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(88622);
                        if (j.this.gKG != null && j.this.gKG.isShowing()) {
                            j.this.gKG.dismiss();
                        }
                        AppMethodBeat.o(88622);
                    }
                });
                jVar.gKG = new o(inflate, -1, -1, true);
                jVar.gKG.update();
                jVar.gKG.setBackgroundDrawable(new ColorDrawable(16777215));
                jVar.gKG.setOnDismissListener(new OnDismissListener() {
                    public final void onDismiss() {
                    }
                });
            }
            eVar.kjy = new com.tencent.mm.plugin.card.b.f(eVar.kjd);
            eVar.kjd.ifE = eVar;
            com.tencent.mm.sdk.b.a.xxA.c(eVar.kjH);
            eVar = this.kiM;
            if (eVar.kjf == null) {
                eVar.kjf = new x();
                eVar.kjf.a(eVar);
            }
            if (eVar.kjh == null) {
                eVar.kjh = new com.tencent.mm.plugin.card.ui.view.o();
                eVar.kjh.a(eVar);
            }
            if (eVar.kji == null) {
                eVar.kji = new com.tencent.mm.plugin.card.ui.view.a();
                eVar.kji.a(eVar);
            }
            eVar.mListView = (ListView) eVar.findViewById(R.id.aca);
            eVar.kjl = new m(eVar.kjd.mController.ylL);
            eVar.kjl.koa = eVar.gKK;
            eVar.mListView.setAdapter(eVar.kjl);
            eVar.kjl.notifyDataSetChanged();
            eVar.mListView.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(88335);
                    com.tencent.mm.plugin.card.model.b bVar = (com.tencent.mm.plugin.card.model.b) e.this.kaW.get(i);
                    if (bVar == null || TextUtils.isEmpty(bVar.url)) {
                        AppMethodBeat.o(88335);
                        return;
                    }
                    Intent intent = new Intent();
                    if (e.this.kaS instanceof CardInfo) {
                        intent.putExtra("key_card_info_data", (CardInfo) e.this.kaS);
                    } else if (e.this.kaS instanceof ShareCardInfo) {
                        intent.putExtra("key_card_info_data", (ShareCardInfo) e.this.kaS);
                    }
                    h hVar;
                    Object[] objArr;
                    if (bVar.url.equals("card://jump_detail")) {
                        int i2;
                        if (e.this.kaS.aZV().vUo == null || TextUtils.isEmpty(e.this.kaS.aZV().vUo.url)) {
                            intent.setClass(e.this.kjd, CardDetailPreference.class);
                            e.this.kjd.startActivity(intent);
                        } else {
                            com.tencent.mm.plugin.card.d.b.a(e.this.kjd, e.this.kaS.aZV().vUo.url, 1);
                        }
                        hVar = h.pYm;
                        objArr = new Object[9];
                        objArr[0] = "CardLeftRightIntroduceView";
                        objArr[1] = Integer.valueOf(e.this.kaS.aZV().iAd);
                        objArr[2] = e.this.kaS.baa();
                        objArr[3] = e.this.kaS.aZZ();
                        objArr[4] = Integer.valueOf(0);
                        objArr[5] = Integer.valueOf(e.this.kjF.kgn);
                        objArr[6] = e.this.kjF.kiN;
                        if (e.this.kaS.aZT()) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        objArr[7] = Integer.valueOf(i2);
                        objArr[8] = "";
                        hVar.e(11324, objArr);
                        AppMethodBeat.o(88335);
                    } else if (bVar.url.equals("card://jump_shop_list") && e.this.kaS.aZV().vUa > 0) {
                        e.a(e.this);
                        AppMethodBeat.o(88335);
                    } else if (!bVar.url.equals("card://jump_shop") || e.this.kaS.aZV().vUa <= 0) {
                        if (bVar.url.equals("card://jump_service")) {
                            if (!TextUtils.isEmpty(e.this.kaS.aZV().vTT)) {
                                com.tencent.mm.plugin.card.d.b.af(e.this.kjd, e.this.kaS.aZV().vTT);
                                am.bbc().s(e.this.kaS.aZZ(), e.this.kaS.baa(), 1);
                            }
                            h.pYm.e(11582, "OperService", Integer.valueOf(1), Integer.valueOf(e.this.kaS.aZV().iAd), e.this.kaS.baa(), e.this.kaS.aZZ(), e.this.kjF.kiN);
                            AppMethodBeat.o(88335);
                        } else if (bVar.url.equals("card://jump_gift")) {
                            e.b(e.this);
                            e eVar = e.this;
                            if (eVar.kaS.aZW().vSn == null) {
                                ab.i("MicroMsg.CardDetailUIContoller", "mCardInfo.getDataInfo().gifting_info_cell is null");
                                AppMethodBeat.o(88335);
                            } else if (eVar.kaS.aZW().vSn.waC == null) {
                                ab.e("MicroMsg.CardDetailUIContoller", "mCardInfo.getDataInfo().gifting_info_cell.gifting_info is null");
                                AppMethodBeat.o(88335);
                            } else {
                                h.pYm.e(13866, Integer.valueOf(6), eVar.kaS.aZW().vSn.waC.vBB, com.tencent.mm.a.p.getString(eVar.kaS.aZW().vSn.waC.vBA));
                                AppMethodBeat.o(88335);
                            }
                        } else if (bVar.url.equals("card://jump_card_gift")) {
                            if (e.this.kaS.aZW().vSn == null) {
                                ab.e("MicroMsg.CardDetailUIContoller", "jump_card_gift mCardInfo.getDataInfo().gifting_info_cell is null");
                                AppMethodBeat.o(88335);
                            } else if (e.this.kaS.aZW().vSn.waC == null) {
                                ab.e("MicroMsg.CardDetailUIContoller", "jump_card_gift mCardInfo.getDataInfo().gifting_info_cell.gifting_info is null");
                                AppMethodBeat.o(88335);
                            } else {
                                e eVar2 = e.this;
                                ab.d("MicroMsg.CardDetailUIContoller", "doJumpCardGift, order_id:%s, biz_uin:%d", e.this.kaS.aZW().vSn.waC.vBB, Integer.valueOf(e.this.kaS.aZW().vSn.waC.vBA));
                                Intent intent2 = new Intent(eVar2.kjd, CardGiftReceiveUI.class);
                                intent2.putExtra("key_biz_uin", r2);
                                intent2.putExtra("key_order_id", r0);
                                intent2.putExtra("key_gift_into", (CardGiftInfo) eVar2.kjd.getIntent().getParcelableExtra("key_card_git_info"));
                                eVar2.kjd.startActivity(intent2);
                                h.pYm.e(13866, Integer.valueOf(5), e.this.kaS.aZW().vSn.waC.vBB, com.tencent.mm.a.p.getString(e.this.kaS.aZW().vSn.waC.vBA));
                                AppMethodBeat.o(88335);
                            }
                        } else if ((bVar.vUW & 32) > 0) {
                            com.tencent.mm.ui.MMActivity.a aVar = e.this;
                            com.tencent.mm.plugin.card.d.b.a(aVar.kjd, 4, aVar);
                            aVar.kjd.ifE = aVar;
                            AppMethodBeat.o(88335);
                        } else if (com.tencent.mm.plugin.card.d.b.d(e.this.kaS.aZZ(), bVar.vTL, bVar.vTM, e.this.kjF.kgn, e.this.kjF.kjL)) {
                            h.pYm.e(11941, Integer.valueOf(21), e.this.kaS.aZZ(), e.this.kaS.baa(), "", bVar.title);
                            AppMethodBeat.o(88335);
                        } else {
                            com.tencent.mm.plugin.card.d.b.a(e.this.kjd, l.A(bVar.url, bVar.vUW), 1);
                            h.pYm.e(11492, Integer.valueOf(e.this.kjF.kgn), e.this.kjF.kiO, e.this.kaS.aZZ(), e.this.kaS.baa(), Integer.valueOf(e.this.kaS.aZW().status), r1, Integer.valueOf(e.this.kaS.aZV().iAd), e.this.kaS.aZV().vTT);
                            h.pYm.e(11941, Integer.valueOf(6), e.this.kaS.aZZ(), e.this.kaS.baa(), "", bVar.title);
                            if (l.a(bVar, e.this.kaS.aZZ())) {
                                l.Hs(e.this.kaS.aZZ());
                                com.tencent.mm.plugin.card.d.b.b(e.this.kjd, e.this.kaS.aZV().kdg);
                            }
                            AppMethodBeat.o(88335);
                        }
                    } else if (e.this.kaY == null || e.this.kaY.size() == 0) {
                        ab.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                        AppMethodBeat.o(88335);
                    } else {
                        od odVar = (od) e.this.kaY.get(0);
                        if (!(odVar == null || TextUtils.isEmpty(odVar.kdF))) {
                            com.tencent.mm.plugin.card.d.b.a(e.this.kjd, odVar.kdF, 1);
                            h.pYm.e(11941, Integer.valueOf(4), e.this.kaS.aZZ(), e.this.kaS.baa(), "", odVar.name);
                        }
                        hVar = h.pYm;
                        objArr = new Object[9];
                        objArr[0] = "UsedStoresView";
                        objArr[1] = Integer.valueOf(e.this.kaS.aZV().iAd);
                        objArr[2] = e.this.kaS.baa();
                        objArr[3] = e.this.kaS.aZZ();
                        objArr[4] = Integer.valueOf(0);
                        objArr[5] = Integer.valueOf(e.this.kjF.kgn);
                        objArr[6] = e.this.kjF.kiN;
                        objArr[7] = Integer.valueOf(e.this.kaS.aZT() ? 1 : 0);
                        objArr[8] = "";
                        hVar.e(11324, objArr);
                        AppMethodBeat.o(88335);
                    }
                }
            });
            ab.i("MicroMsg.CardDetailUIContoller", "initMenu");
            CardDetailBaseUI cardDetailBaseUI = eVar.kjd;
            cardDetailBaseUI.kiG.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(88342);
                    if (e.this.kaS == null) {
                        ab.e("MicroMsg.CardDetailUIContoller", "mCardInfo is null, err");
                        AppMethodBeat.o(88342);
                        return;
                    }
                    h.pYm.e(11582, "CardDetailUiMenu", Integer.valueOf(1), Integer.valueOf(e.this.kaS.aZV().iAd), e.this.kaS.baa(), e.this.kaS.aZZ(), e.this.kjF.kiN);
                    com.tencent.mm.ui.base.h.a(e.this.kjd.mController.ylL, null, (String[]) e.this.kjD.toArray(new String[e.this.kjD.size()]), null, false, new com.tencent.mm.ui.base.h.c() {
                        public final void iE(int i) {
                            AppMethodBeat.i(88341);
                            String str = (String) e.this.kjB.get(Integer.valueOf(i));
                            if (TextUtils.isEmpty(str)) {
                                AppMethodBeat.o(88341);
                            } else if (str.equals("menu_func_share_friend")) {
                                int i2;
                                com.tencent.mm.ui.MMActivity.a aVar = e.this;
                                com.tencent.mm.plugin.card.d.b.a(aVar.kjd, 1, aVar);
                                aVar.kjd.ifE = aVar;
                                h hVar = h.pYm;
                                Object[] objArr = new Object[9];
                                objArr[0] = "BrandContactView";
                                objArr[1] = Integer.valueOf(e.this.kaS.aZV().iAd);
                                objArr[2] = e.this.kaS.baa();
                                objArr[3] = e.this.kaS.aZZ();
                                objArr[4] = Integer.valueOf(0);
                                objArr[5] = Integer.valueOf(e.this.kjF.kgn);
                                objArr[6] = e.this.kjF.kiN;
                                if (e.this.kaS.aZT()) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                                objArr[7] = Integer.valueOf(i2);
                                objArr[8] = "";
                                hVar.e(11324, objArr);
                                h.pYm.e(11582, "OperShareFriend", Integer.valueOf(1), Integer.valueOf(e.this.kaS.aZV().iAd), e.this.kaS.baa(), e.this.kaS.aZZ(), e.this.kjz);
                                AppMethodBeat.o(88341);
                            } else if (str.equals("menu_func_gift")) {
                                e.b(e.this);
                                AppMethodBeat.o(88341);
                            } else if (str.equals("menu_func_delete")) {
                                str = "";
                                if (e.this.kaS.aZD()) {
                                    str = e.this.kjd.getString(R.string.adh);
                                }
                                com.tencent.mm.plugin.card.d.d.a(e.this.kjd, e.this.kjF.kaE, str, new com.tencent.mm.plugin.card.d.d.a() {
                                    public final void aZA() {
                                        AppMethodBeat.i(88339);
                                        if (e.this.kjE != null) {
                                            e.this.kjE.bcq();
                                        }
                                        AppMethodBeat.o(88339);
                                    }
                                });
                                h.pYm.e(11582, "OperDelete", Integer.valueOf(1), Integer.valueOf(e.this.kaS.aZV().iAd), e.this.kaS.baa(), e.this.kaS.aZZ(), "");
                                AppMethodBeat.o(88341);
                            } else if (str.equals("menu_func_service")) {
                                if (!TextUtils.isEmpty(e.this.kaS.aZV().vTT)) {
                                    com.tencent.mm.plugin.card.d.b.af(e.this.kjd, e.this.kaS.aZV().vTT);
                                    am.bbc().s(e.this.kaS.aZZ(), e.this.kaS.baa(), 1);
                                }
                                h.pYm.e(11582, "OperService", Integer.valueOf(1), Integer.valueOf(e.this.kaS.aZV().iAd), e.this.kaS.baa(), e.this.kaS.aZZ(), e.this.kjF.kiN);
                                AppMethodBeat.o(88341);
                            } else if (str.equals("menu_func_report")) {
                                if (!TextUtils.isEmpty(e.this.kaS.aZW().vSf)) {
                                    com.tencent.mm.plugin.card.d.b.a(e.this.kjd, e.this.kaS.aZW().vSf, e.this.getString(R.string.agm));
                                }
                                h.pYm.e(11582, "OperReport", Integer.valueOf(1), Integer.valueOf(e.this.kaS.aZV().iAd), e.this.kaS.baa(), e.this.kaS.aZZ(), "");
                                AppMethodBeat.o(88341);
                            } else if (str.equals("menu_func_share_timeline")) {
                                com.tencent.mm.platformtools.x.a(new m(e.this.kaS.aZV().kbV));
                                Context context = e.this.kjd;
                                com.tencent.mm.plugin.card.base.b bVar = e.this.kaS;
                                String str2 = e.this.kjF.kaE;
                                String str3 = e.this.kjF.kiP;
                                Intent intent = new Intent();
                                intent.putExtra("Ksnsupload_link", bVar.aZV().vUc);
                                intent.putExtra("KContentObjDesc", bVar.aZV().kdg);
                                intent.putExtra("Ksnsupload_title", bVar.aZV().title);
                                if (TextUtils.isEmpty(str3)) {
                                    intent.putExtra("KUploadProduct_UserData", str2 + "#");
                                } else {
                                    intent.putExtra("KUploadProduct_UserData", str2 + "#" + str3);
                                }
                                intent.putExtra("Ksnsupload_imgurl", bVar.aZV().kbV);
                                if (!TextUtils.isEmpty(bVar.aZV().kbV)) {
                                    intent.putExtra("KsnsUpload_imgPath", new m(bVar.aZV().kbV).anJ());
                                }
                                ab.d("MicroMsg.CardActivityHelper", "doShareTimeLine KSnsUploadImgPath:" + intent.getStringExtra("KsnsUpload_imgPath"));
                                intent.putExtra("src_username", r.Yz());
                                intent.putExtra("src_displayname", r.YB());
                                intent.putExtra("Ksnsupload_appid", bVar.aZV().csB);
                                intent.putExtra("Ksnsupload_appname", bVar.aZV().vTT);
                                intent.putExtra("Ksnsupload_type", 7);
                                String nW = v.nW("card_package");
                                v.Zp().y(nW, true).j("prePublishId", "card_package");
                                intent.putExtra("reportSessionId", nW);
                                com.tencent.mm.bp.d.c(context, "sns", ".ui.SnsUploadUI", intent);
                                h.pYm.e(11582, "OperShareTimeLine", Integer.valueOf(1), Integer.valueOf(e.this.kaS.aZV().iAd), e.this.kaS.baa(), e.this.kaS.aZZ(), e.this.kjF.kiN);
                                AppMethodBeat.o(88341);
                            } else if (str.equals("menu_func_delete_share_card")) {
                                com.tencent.mm.plugin.card.d.d.a(e.this.kjd, e.this.kjF.kaE, "", new com.tencent.mm.plugin.card.d.d.a() {
                                    public final void aZA() {
                                        AppMethodBeat.i(88340);
                                        if (e.this.kjE != null) {
                                            e.this.kjE.bct();
                                        }
                                        AppMethodBeat.o(88340);
                                    }
                                });
                                AppMethodBeat.o(88341);
                            } else {
                                str = (String) e.this.kjC.get(str);
                                if (!bo.isNullOrNil(str)) {
                                    com.tencent.mm.plugin.card.d.b.a(e.this.kjd, str, 0);
                                }
                                AppMethodBeat.o(88341);
                            }
                        }
                    });
                    AppMethodBeat.o(88342);
                }
            });
            eVar.lK = (LinearLayout) eVar.findViewById(R.id.abv);
            eVar.kju = new com.tencent.mm.plugin.card.ui.view.d();
            eVar.kju.a(eVar);
            eVar.kjw.kaS = eVar.kaS;
        }
        int intExtra = getIntent().getIntExtra("key_from_scene", -1);
        ab.i("MicroMsg.CardDetailUI", "scene:%d", Integer.valueOf(intExtra));
        String stringExtra;
        com.tencent.mm.plugin.card.model.d Hi;
        if (intExtra == 2 || intExtra == 6 || intExtra == 5) {
            this.emC = intExtra;
            stringExtra = getIntent().getStringExtra("key_card_app_msg");
            Hi = com.tencent.mm.plugin.card.d.g.Hi(stringExtra);
            if (Hi != null) {
                this.kaE = Hi.cMC;
                this.kiN = Hi.kde;
                this.kiP = Hi.cMD;
                int i = Hi.kdh;
                ab.i("MicroMsg.CardDetailUI", "scene is " + intExtra + ", isRecommend is " + i);
                if (i == 1 && intExtra == 2) {
                    this.emC = 23;
                }
                this.kiT = Hi.kdi;
                ab.i("MicroMsg.CardDetailUI", "recommend_card_id is " + this.kiT);
            }
            this.kiO = com.tencent.mm.plugin.card.d.g.Hj(stringExtra);
        } else if (l.tn(intExtra) || intExtra == 0 || intExtra == 1 || intExtra == 3 || intExtra == 4 || intExtra == 9 || intExtra == 12 || intExtra == 15 || intExtra == 17 || intExtra == 21) {
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
                this.kaE = com.tencent.mm.plugin.card.sharecard.a.b.dp(this.kaE, this.kbQ);
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
                com.tencent.mm.plugin.card.base.b bVar = (com.tencent.mm.plugin.card.base.b) getIntent().getParcelableExtra("key_card_info");
                if (bVar != null) {
                    this.kaS = bVar;
                    this.kaE = this.kaS.aZZ();
                    bck();
                    bcn();
                    if (this.kaS.aZQ()) {
                        am.bbj().Gk(this.kaS.aZZ());
                    }
                    bbB();
                }
                bcl();
                l.beB();
            } else {
                LinkedList bR = k.bR(getIntent().getStringExtra("card_list"), this.emC);
                if (bR == null || bR.size() == 0) {
                    ab.e("MicroMsg.CardDetailUI", "initData tempList size is empty");
                    n(true, -1);
                } else {
                    fE(true);
                    this.kaE = ((oj) bR.get(0)).kbU;
                    intExtra = getIntent().getIntExtra("key_previous_scene", 51);
                    cdc cdc = new cdc();
                    cdc.xcM = this.fhu;
                    ab.i("MicroMsg.CardDetailUI", "doBatchGetCardItemByTpInfo templateId:%s", this.fhu);
                    g.RO().eJo.a(new t(bR, cdc, intExtra, this.kaE), 0);
                }
                bck();
            }
            this.kiM.a(this.kaS, this.kiU, this.kaY);
            this.kiM.kjE = new e.d() {
                public final void bcp() {
                    AppMethodBeat.i(88274);
                    CardDetailUI.i(CardDetailUI.this);
                    AppMethodBeat.o(88274);
                }

                public final void GQ(String str) {
                    AppMethodBeat.i(88275);
                    CardDetailUI.a(CardDetailUI.this, str);
                    AppMethodBeat.o(88275);
                }

                public final void bcq() {
                    AppMethodBeat.i(88276);
                    CardDetailUI.j(CardDetailUI.this);
                    AppMethodBeat.o(88276);
                }

                public final void bcr() {
                    AppMethodBeat.i(88277);
                    CardDetailUI.k(CardDetailUI.this);
                    AppMethodBeat.o(88277);
                }

                public final void bcs() {
                    AppMethodBeat.i(88278);
                    CardDetailUI.h(CardDetailUI.this);
                    AppMethodBeat.o(88278);
                }

                public final void bct() {
                    AppMethodBeat.i(88279);
                    CardDetailUI.l(CardDetailUI.this);
                    AppMethodBeat.o(88279);
                }

                public final void b(com.tencent.mm.plugin.card.base.b bVar) {
                    AppMethodBeat.i(88280);
                    CardDetailUI.this.kaS = bVar;
                    CardDetailUI.this.kaE = bVar.aZZ();
                    CardDetailUI.this.kiU.kaE = CardDetailUI.this.kaE;
                    AppMethodBeat.o(88280);
                }

                public final void bco() {
                    AppMethodBeat.i(88281);
                    CardDetailUI.o(CardDetailUI.this);
                    AppMethodBeat.o(88281);
                }

                public final void bcu() {
                    AppMethodBeat.i(88282);
                    ab.i("MicroMsg.CardDetailUI", "onConsumeCodeUIResult()");
                    AppMethodBeat.o(88282);
                }

                public final void fJ(boolean z) {
                    AppMethodBeat.i(88283);
                    ab.i("MicroMsg.CardDetailUI", "doMark()");
                    CardDetailUI.this.kiR = true;
                    CardDetailUI.q(CardDetailUI.this);
                    CardDetailUI.this.kiS = z;
                    if (CardDetailUI.this.kaS.aZP()) {
                        am.bbi().M(CardDetailUI.this.kaE, l.Ht(CardDetailUI.this.kaS.bab()), 2);
                        AppMethodBeat.o(88283);
                        return;
                    }
                    am.bbi().M(CardDetailUI.this.kaE, l.Ht(CardDetailUI.this.kaS.bab()), 1);
                    AppMethodBeat.o(88283);
                }
            };
            ab.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null)));
            this.khx = z;
            if (this.khx) {
                this.fwu = com.tencent.mm.modelgeo.d.agz();
                aZt();
            }
            AppMethodBeat.o(88294);
        } else if (intExtra == 51) {
            if (getIntent().getIntExtra("key_previous_scene", 51) == 26) {
                this.emC = 26;
            } else {
                this.emC = 3;
            }
            this.kaE = getIntent().getStringExtra("key_card_id");
            this.kaS = am.bbb().kau;
            if (this.kaS == null) {
                this.kaS = am.baW().Gu(this.kaE);
            }
            bck();
            if (this.kaS == null) {
                ab.e("MicroMsg.CardDetailUI", "initData, mCardId is null from scene == ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_VIEW_UI");
                n(true, -1);
            } else {
                bcn();
                bbB();
                bcl();
                if (this.kaS.aZQ()) {
                    am.bbj().Gk(this.kaS.aZZ());
                }
            }
            this.kiM.a(this.kaS, this.kiU, this.kaY);
            this.kiM.kjE = /* anonymous class already generated */;
            ab.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null)));
            this.khx = z;
            if (this.khx) {
            }
            AppMethodBeat.o(88294);
        } else if (intExtra == 26) {
            this.emC = intExtra;
            this.kaE = getIntent().getStringExtra("key_card_id");
            this.kiP = getIntent().getStringExtra("key_card_ext");
        } else {
            this.emC = intExtra;
            stringExtra = getIntent().getStringExtra("key_card_app_msg");
            Hi = com.tencent.mm.plugin.card.d.g.Hi(stringExtra);
            if (Hi != null) {
                this.kaE = Hi.cMC;
                this.kiN = Hi.kde;
                this.kiP = Hi.cMD;
            }
            this.kiO = com.tencent.mm.plugin.card.d.g.Hj(stringExtra);
        }
        bck();
        if (TextUtils.isEmpty(this.kaE)) {
            ab.e("MicroMsg.CardDetailUI", "initData, mCardId is null");
            n(true, -1);
        } else {
            if (intExtra == 2 || intExtra == 6 || ((intExtra == 4 && !this.kcf) || intExtra == 5 || intExtra == 17 || intExtra == 21 || intExtra == 23)) {
                z = true;
            } else if (intExtra == 15) {
                Object value = am.bbb().getValue("key_accept_card_info");
                if (value == null || !(value instanceof CardInfo)) {
                    z = true;
                } else {
                    this.kaS = (CardInfo) value;
                    z = false;
                }
            } else if (this.kcf) {
                this.kaS = am.bbe().GK(this.kaE);
                z = false;
            } else {
                this.kaS = am.baW().Gu(this.kaE);
                z = false;
            }
            if (z || this.kaS == null) {
                ab.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene1 is true or no cardinfo with cardId = " + this.kaE + " isShareCard is " + this.kcf);
                fE(true);
                if (this.kcf) {
                    bco();
                } else {
                    bcm();
                }
            } else {
                ab.d("MicroMsg.CardDetailUI", "initData(), cardId = " + this.kaE);
                od aZY = this.kaS.aZY();
                if (aZY != null) {
                    this.kaY = new ArrayList();
                    this.kaY.add(aZY);
                }
                bbB();
                if (this.kaS.aZQ()) {
                    am.bbj().Gk(this.kaS.aZZ());
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
                    ab.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene2 is true or no cardinfo with cardId = " + this.kaE + " isShareCard is " + this.kcf);
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
        this.kiM.a(this.kaS, this.kiU, this.kaY);
        this.kiM.kjE = /* anonymous class already generated */;
        ab.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null)));
        this.khx = z;
        if (this.khx) {
        }
        AppMethodBeat.o(88294);
    }

    private void bck() {
        AppMethodBeat.i(88295);
        this.kgn = this.emC;
        this.kiU = new e.a();
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
        AppMethodBeat.o(88295);
    }

    private void bcl() {
        int i = 1;
        AppMethodBeat.i(88296);
        if (this.kiX || this.kaS == null) {
            AppMethodBeat.o(88296);
            return;
        }
        this.kiX = true;
        h hVar;
        Object[] objArr;
        if (this.kcf) {
            hVar = h.pYm;
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
            hVar.e(11324, objArr);
            AppMethodBeat.o(88296);
            return;
        }
        hVar = h.pYm;
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
        hVar.e(11324, objArr);
        AppMethodBeat.o(88296);
    }

    private void bbB() {
        AppMethodBeat.i(88297);
        this.kiU.emC = this.emC;
        this.kiU.kgn = this.kgn;
        this.kiU.kaE = this.kaE;
        this.kiM.a(this.kaS, this.kiU, this.kaY);
        this.kiM.bbB();
        am.bbh().kaS = this.kaS;
        AppMethodBeat.o(88297);
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0226  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(88298);
        ab.i("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + i + " errCode = " + i2);
        int i3;
        if (i == 0 && i2 == 0) {
            fE(false);
            com.tencent.mm.plugin.card.base.b bVar;
            CardInfo cardInfo;
            String str2;
            int i4;
            String str3;
            Integer num;
            Intent intent;
            ShareCardInfo GK;
            if (mVar instanceof aa) {
                String str4 = ((aa) mVar).kdS;
                if (TextUtils.isEmpty(str4)) {
                    ab.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetCardItemInfo return json is null");
                    AppMethodBeat.o(88298);
                    return;
                }
                bVar = this.kaS;
                cardInfo = new CardInfo();
                com.tencent.mm.plugin.card.d.f.a(cardInfo, str4);
                if (!TextUtils.isEmpty(cardInfo.aZZ())) {
                    this.kaE = cardInfo.aZZ();
                } else if (TextUtils.isEmpty(cardInfo.aZZ()) && !this.kaE.equals(cardInfo.baa())) {
                    ab.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", this.kaE, cardInfo.baa());
                    AppMethodBeat.o(88298);
                    return;
                }
                this.kaS = cardInfo;
                bcn();
                if (this.emC == 3) {
                    if (bVar != null) {
                        ((CardInfo) this.kaS).field_stickyAnnouncement = ((CardInfo) bVar).field_stickyAnnouncement;
                        ((CardInfo) this.kaS).field_stickyEndTime = ((CardInfo) bVar).field_stickyEndTime;
                        ((CardInfo) this.kaS).field_stickyIndex = ((CardInfo) bVar).field_stickyIndex;
                        ((CardInfo) this.kaS).field_label_wording = ((CardInfo) bVar).field_label_wording;
                        this.kaS.a(bVar.aZY());
                    }
                    if (this.kiW) {
                        l.h(this.kaS);
                    } else {
                        ab.e("MicroMsg.CardDetailUI", "onSceneEnd(), NetSceneGetCardItemInfo updateDataToDB is false");
                    }
                }
                bbB();
                bcl();
                if (this.kaS.aZQ()) {
                    am.bbj().Gk(this.kaS.aZZ());
                }
                this.kja.a(this, this.kaE, this.kaS, this.ecs, this.ect);
                AppMethodBeat.o(88298);
                return;
            } else if (mVar instanceof com.tencent.mm.plugin.card.model.o) {
                if (this.kgn == 26) {
                    fE(false);
                }
                str2 = ((com.tencent.mm.plugin.card.model.o) mVar).kdS;
                i4 = ((com.tencent.mm.plugin.card.model.o) mVar).kdT;
                str3 = ((com.tencent.mm.plugin.card.model.o) mVar).kdU;
                if (i4 != 0) {
                    c(i2, str, i4, str3);
                } else {
                    com.tencent.mm.ui.base.h.bQ(this, getResources().getString(R.string.act));
                }
                if (TextUtils.isEmpty(str2)) {
                    ab.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneAcceptCardItem return json is null");
                    AppMethodBeat.o(88298);
                    return;
                }
                this.emC = 3;
                if (this.kaS == null) {
                    this.kaS = new CardInfo();
                }
                com.tencent.mm.plugin.card.d.f.a((CardInfo) this.kaS, str2);
                if (!TextUtils.isEmpty(this.kaS.aZZ())) {
                    this.kaE = this.kaS.aZZ();
                }
                if (this.kiM.bcS() == 1) {
                    e eVar = this.kiM;
                    if (eVar.kjy != null) {
                        com.tencent.mm.plugin.card.b.f fVar = eVar.kjy;
                        if (fVar.kaX != null) {
                            fVar.kaX.kci = false;
                        }
                    }
                }
                if (this.kgn != 26) {
                    bcn();
                    bbB();
                }
                l.beB();
                com.tencent.mm.plugin.card.base.b bVar2 = this.kaS;
                if (bVar2.aZD()) {
                    num = (Integer) g.RP().Ry().get(ac.a.USERINFO_CARD_IS_SHOW_MEMBERSHIP_TIP_INT_SYNC, Integer.valueOf(0));
                    if (num == null || num.intValue() != 1) {
                        g.RP().Ry().set(ac.a.USERINFO_CARD_IS_SHOW_MEMBERSHIP_TIP_INT_SYNC, Integer.valueOf(1));
                    }
                    this.kiZ = this.kaS.baf();
                    if (this.kgn != 7 || this.kgn == 16) {
                        intent = new Intent();
                        intent.putExtra("key_code", this.kiZ);
                        setResult(-1, intent);
                        tb(-1);
                    } else if (!this.kiV && this.kgn == 8) {
                        n(true, -1);
                    } else if (this.kgn == 26 && i4 == 0) {
                        n(true, -1);
                    }
                    if (this.kaS.aZQ()) {
                        am.bbj().Gk(this.kaS.aZZ());
                    }
                    this.kja.a(this, this.kaE, this.kaS, this.ecs, this.ect);
                    AppMethodBeat.o(88298);
                    return;
                }
                num = (Integer) g.RP().Ry().get(282884, null);
                if (num == null || num.intValue() != 1) {
                    g.RP().Ry().set(282884, Integer.valueOf(1));
                }
                this.kiZ = this.kaS.baf();
                if (this.kgn != 7) {
                }
                intent = new Intent();
                intent.putExtra("key_code", this.kiZ);
                setResult(-1, intent);
                tb(-1);
                if (this.kaS.aZQ()) {
                }
                this.kja.a(this, this.kaE, this.kaS, this.ecs, this.ect);
                AppMethodBeat.o(88298);
                return;
                if (l.beE()) {
                    com.tencent.mm.plugin.card.d.d.c(this, R.layout.k_, R.string.acq, bVar2.aZV().kdf);
                } else {
                    com.tencent.mm.plugin.card.d.d.c(this, R.layout.k9, R.string.acp, bVar2.aZV().kdf);
                }
                this.kiZ = this.kaS.baf();
                if (this.kgn != 7) {
                }
                intent = new Intent();
                intent.putExtra("key_code", this.kiZ);
                setResult(-1, intent);
                tb(-1);
                if (this.kaS.aZQ()) {
                }
                this.kja.a(this, this.kaE, this.kaS, this.ecs, this.ect);
                AppMethodBeat.o(88298);
                return;
            } else if (mVar instanceof com.tencent.mm.plugin.card.model.v) {
                this.kaY = ((com.tencent.mm.plugin.card.model.v) mVar).keb;
                if (this.kaS == null || this.kaY == null || this.kaY.size() <= 0) {
                    if (this.kaS != null && this.kaY == null) {
                        this.kaS.a(null);
                        bbB();
                        if (this.kaS.aZC()) {
                            GK = am.bbe().GK(this.kaE);
                            if (GK != null) {
                                GK.a(null);
                                am.bbe().c(GK, this.kaE);
                            }
                            AppMethodBeat.o(88298);
                            return;
                        }
                        CardInfo Gu = am.baW().Gu(this.kaE);
                        if (Gu != null) {
                            Gu.a(null);
                            am.baW().c(Gu, this.kaE);
                        }
                    }
                    AppMethodBeat.o(88298);
                    return;
                }
                this.kaS.a((od) this.kaY.get(0));
                bbB();
                if (this.kaS.aZC()) {
                    ShareCardInfo GK2 = am.bbe().GK(this.kaE);
                    if (GK2 != null) {
                        GK2.a((od) this.kaY.get(0));
                        am.bbe().c(GK2, this.kaE);
                    }
                    AppMethodBeat.o(88298);
                    return;
                }
                cardInfo = am.baW().Gu(this.kaE);
                if (cardInfo != null) {
                    cardInfo.a((od) this.kaY.get(0));
                    am.baW().c(cardInfo, this.kaE);
                }
                AppMethodBeat.o(88298);
                return;
            } else if (mVar instanceof af) {
                i3 = ((af) mVar).kdT;
                str3 = ((af) mVar).kdU;
                if (i3 == Downloads.MIN_WAIT_FOR_NETWORK) {
                    if (TextUtils.isEmpty(str3)) {
                        str3 = getString(R.string.ae6);
                    }
                    com.tencent.mm.plugin.card.d.d.c(this, str3);
                    AppMethodBeat.o(88298);
                    return;
                }
                this.kiP = ((af) mVar).cMD;
                fI(true);
                no aZW = this.kaS.aZW();
                aZW.status = 3;
                this.kaS.a(aZW);
                l.h(this.kaS);
                bbB();
                if (this.kgn == 3) {
                    n(true, 2);
                    AppMethodBeat.o(88298);
                    return;
                }
                if (this.kgn == 15) {
                    com.tencent.mm.sdk.b.a.xxA.m(new qk());
                }
                AppMethodBeat.o(88298);
                return;
            } else if (mVar instanceof com.tencent.mm.plugin.card.model.r) {
                com.tencent.mm.ui.base.h.bQ(this, getResources().getString(R.string.adi));
                am.baV();
                com.tencent.mm.plugin.card.b.b.sO(4);
                n(true, 1);
                AppMethodBeat.o(88298);
                return;
            } else if (mVar instanceof t) {
                t tVar = (t) mVar;
                LinkedList linkedList = tVar.kdZ;
                if (linkedList != null && linkedList.size() > 0) {
                    com.tencent.mm.plugin.card.base.b bVar3 = (com.tencent.mm.plugin.card.base.b) linkedList.get(0);
                    if (bVar3 == null || this.kaE.equals(tVar.cardId)) {
                        this.kaS = bVar3;
                        if (this.kaS != null) {
                            this.kaE = this.kaS.aZZ();
                            bcn();
                            if (this.kaS.aZQ()) {
                                am.bbj().Gk(this.kaS.aZZ());
                            }
                        }
                        if (this.emC == 26) {
                            this.emC = 3;
                        }
                        bbB();
                    } else {
                        ab.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", this.kaE, tVar.cardId);
                        AppMethodBeat.o(88298);
                        return;
                    }
                }
                bcl();
                l.beB();
                AppMethodBeat.o(88298);
                return;
            } else if (mVar instanceof com.tencent.mm.plugin.card.sharecard.model.g) {
                str2 = ((com.tencent.mm.plugin.card.sharecard.model.g) mVar).kdS;
                i4 = ((com.tencent.mm.plugin.card.sharecard.model.g) mVar).kdT;
                str3 = ((com.tencent.mm.plugin.card.sharecard.model.g) mVar).kdU;
                if (i4 != 0) {
                    if (TextUtils.isEmpty(str3)) {
                        str3 = getString(R.string.ach);
                    }
                    com.tencent.mm.plugin.card.d.d.c(this, str3);
                    ab.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, accept card error, ret_msg:%s", str3);
                    AppMethodBeat.o(88298);
                    return;
                }
                com.tencent.mm.ui.base.h.bQ(this, getResources().getString(R.string.acl));
                if (TextUtils.isEmpty(str2)) {
                    ab.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, json is null");
                    AppMethodBeat.o(88298);
                    return;
                }
                this.emC = 3;
                if (this.kaS == null) {
                    this.kaS = new ShareCardInfo();
                } else if (this.kaS instanceof CardInfo) {
                    this.kaS = new ShareCardInfo();
                }
                com.tencent.mm.plugin.card.d.f.a((ShareCardInfo) this.kaS, str2);
                GK = (ShareCardInfo) this.kaS;
                if (TextUtils.isEmpty(str2)) {
                    ab.e("MicroMsg.CardInfoParser", "parserShareCardItemEncryptCodeForSingle jsonContent is null");
                } else {
                    try {
                        JSONArray optJSONArray = new JSONObject(str2).optJSONArray("card_list");
                        if (optJSONArray != null) {
                            GK.kbY = optJSONArray.optJSONObject(0).optString("encrypt_code");
                            ab.i("MicroMsg.CardInfoParser", "encrypt_code:" + GK.kbY);
                        }
                    } catch (JSONException e) {
                        ab.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
                        ab.e("MicroMsg.CardInfoParser", e.getMessage());
                    }
                }
                if (!TextUtils.isEmpty(this.kaS.aZZ())) {
                    this.kaE = this.kaS.aZZ();
                }
                if (TextUtils.isEmpty(this.kaS.bab())) {
                    ((ShareCardInfo) this.kaS).field_from_username = r.Yz();
                }
                l.a((ShareCardInfo) this.kaS);
                bcn();
                bbB();
                l.beD();
                am.bbd().aVU();
                this.kiZ = this.kaS.baf();
                if (this.kgn == 7 || this.kgn == 16) {
                    intent = new Intent();
                    intent.putExtra("key_code", this.kiZ);
                    setResult(-1, intent);
                    tb(-1);
                } else if (!this.kiV && this.kgn == 8) {
                    n(true, -1);
                }
                num = (Integer) g.RP().Ry().get(ac.a.USERINFO_CARD_IS_SHOW_SHARE_CARD_TIP_INT_SYNC, Integer.valueOf(0));
                if (num == null || num.intValue() != 1) {
                    g.RP().Ry().set(ac.a.USERINFO_CARD_IS_SHOW_SHARE_CARD_TIP_INT_SYNC, Integer.valueOf(1));
                    com.tencent.mm.plugin.card.d.d.c(this, R.layout.kb, R.string.ahe, "");
                }
                if (this.kaS.aZQ()) {
                    am.bbj().Gk(this.kaS.aZZ());
                }
                AppMethodBeat.o(88298);
                return;
            } else if (mVar instanceof com.tencent.mm.plugin.card.sharecard.model.c) {
                str2 = ((com.tencent.mm.plugin.card.sharecard.model.c) mVar).kdS;
                if (TextUtils.isEmpty(str2)) {
                    ab.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetShareCard json is null");
                    AppMethodBeat.o(88298);
                    return;
                }
                bVar = this.kaS;
                this.kaS = new ShareCardInfo();
                GK = (ShareCardInfo) this.kaS;
                if (TextUtils.isEmpty(str2)) {
                    ab.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
                } else {
                    try {
                        com.tencent.mm.plugin.card.d.f.a(GK, new JSONObject(str2));
                    } catch (JSONException e2) {
                        ab.printErrStackTrace("MicroMsg.CardInfoParser", e2, "", new Object[0]);
                    }
                }
                if (bVar != null) {
                    if (!TextUtils.isEmpty(bVar.bab())) {
                        ((ShareCardInfo) this.kaS).field_from_username = ((ShareCardInfo) bVar).field_from_username;
                    }
                    ((ShareCardInfo) this.kaS).field_app_id = ((ShareCardInfo) bVar).field_app_id;
                    ((ShareCardInfo) this.kaS).field_consumer = ((ShareCardInfo) bVar).field_consumer;
                    ((ShareCardInfo) this.kaS).field_share_time = ((ShareCardInfo) bVar).field_share_time;
                    ((ShareCardInfo) this.kaS).field_updateTime = ((ShareCardInfo) bVar).field_updateTime;
                    ((ShareCardInfo) this.kaS).field_begin_time = ((ShareCardInfo) bVar).field_begin_time;
                    ((ShareCardInfo) this.kaS).field_end_time = ((ShareCardInfo) bVar).field_end_time;
                    ((ShareCardInfo) this.kaS).field_block_mask = ((ShareCardInfo) bVar).field_block_mask;
                    this.kaS.a(bVar.aZY());
                    ((ShareCardInfo) this.kaS).field_categoryType = ((ShareCardInfo) bVar).field_categoryType;
                    ((ShareCardInfo) this.kaS).field_itemIndex = ((ShareCardInfo) bVar).field_itemIndex;
                    if (((ShareCardInfo) bVar).field_status != ((ShareCardInfo) this.kaS).field_status) {
                        ab.i("MicroMsg.CardDetailUI", "getsharecared return, the status is " + ((ShareCardInfo) this.kaS).field_status);
                        com.tencent.mm.plugin.card.sharecard.a.b.a((Context) this, this.kaS);
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
                        l.h(this.kaS);
                    } else {
                        ab.e("MicroMsg.CardDetailUI", "onSceneEnd() sharecard updateDataToDB is false");
                    }
                }
                if (this.kaS.aZQ()) {
                    am.bbj().Gk(this.kaS.aZZ());
                }
                AppMethodBeat.o(88298);
                return;
            } else if (mVar instanceof com.tencent.mm.plugin.card.sharecard.model.a) {
                if (((com.tencent.mm.plugin.card.sharecard.model.a) mVar).kdT != 0) {
                    com.tencent.mm.plugin.card.d.d.c(this, getString(R.string.adg));
                    AppMethodBeat.o(88298);
                    return;
                }
                ab.i("MicroMsg.CardDetailUI", "delete share card, card id is " + this.kaS.aZZ());
                com.tencent.mm.plugin.card.sharecard.a.b.a((Context) this, this.kaS);
                com.tencent.mm.ui.base.h.bQ(this, getResources().getString(R.string.adi));
                am.bbd().bbr();
                n(true, -1);
                AppMethodBeat.o(88298);
                return;
            }
        }
        CharSequence charSequence;
        ab.e("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + i + " errCode = " + i2 + " cmd:" + mVar.getType());
        fE(false);
        Object charSequence2;
        if (mVar instanceof af) {
            fI(false);
            i3 = ((af) mVar).kdT;
            charSequence2 = ((af) mVar).kdU;
            if (i3 == Downloads.MIN_WAIT_FOR_NETWORK) {
                if (TextUtils.isEmpty(charSequence2)) {
                    charSequence2 = getString(R.string.ae6);
                }
            }
            charSequence2 = str;
        } else if (mVar instanceof com.tencent.mm.plugin.card.model.o) {
            tb(0);
            c(i2, str, ((com.tencent.mm.plugin.card.model.o) mVar).kdT, ((com.tencent.mm.plugin.card.model.o) mVar).kdU);
            AppMethodBeat.o(88298);
            return;
        } else {
            if (mVar instanceof com.tencent.mm.plugin.card.model.v) {
                AppMethodBeat.o(88298);
                return;
            }
            charSequence2 = str;
        }
        if (TextUtils.isEmpty(charSequence2)) {
            charSequence2 = getString(R.string.aih);
        }
        Toast.makeText(this.mController.ylL, charSequence2, 0).show();
        AppMethodBeat.o(88298);
    }

    private void c(int i, String str, int i2, String str2) {
        AppMethodBeat.i(88299);
        ab.e("MicroMsg.CardDetailUI", "handleAcceptError, errCode = " + i + " errMsg = " + str + " ret_code:" + i2 + " ret_msg:" + str2);
        if (i2 == Downloads.MIN_WAIT_FOR_NETWORK) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.string.aci);
            }
            this.kaS.aZW().status = 4;
            bbB();
        } else if (i2 == 10001) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.string.acm);
            }
            this.kaS.aZW().status = 5;
            bbB();
        } else if (i2 == 10002) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.string.aga);
            }
        } else if (TextUtils.isEmpty(str2)) {
            str2 = getString(R.string.acg);
        }
        com.tencent.mm.plugin.card.d.d.c(this, str2);
        AppMethodBeat.o(88299);
    }

    private void fE(boolean z) {
        AppMethodBeat.i(88300);
        if (z) {
            this.ejZ = p.b(this, getString(R.string.cn5), true, null);
            AppMethodBeat.o(88300);
            return;
        }
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
            this.ejZ = null;
        }
        AppMethodBeat.o(88300);
    }

    private void fI(boolean z) {
        AppMethodBeat.i(88301);
        if (z) {
            l.dw(this.kiM.kjA, this.kiM.kjz);
        }
        AppMethodBeat.o(88301);
    }

    private void bcm() {
        AppMethodBeat.i(88302);
        cdc cdc = new cdc();
        cdc.xcM = this.fhu;
        cdc.kdi = this.kiT;
        ab.i("MicroMsg.CardDetailUI", "GetCardItemInfo templateId:%s", this.fhu);
        g.RO().eJo.a(new aa(this.kaE, this.emC, this.kiN, this.kiP, this.kir, this.kis, this.kiq, this.kit, cdc), 0);
        AppMethodBeat.o(88302);
    }

    private void bcn() {
        String baa;
        AppMethodBeat.i(88303);
        if (!TextUtils.isEmpty(this.kaS.baa())) {
            baa = this.kaS.baa();
        } else if (TextUtils.isEmpty(this.kaE)) {
            ab.e("MicroMsg.CardDetailUI", "doNetSceneCardShopLBS card id is null, return");
            AppMethodBeat.o(88303);
            return;
        } else {
            baa = this.kaE;
        }
        if (this.kaS == null || this.kaS.aZV().vUa != 1) {
            if (this.kaS == null || this.kaS.aZV().vUa <= 1) {
                if (this.kaS != null) {
                    this.kaS.a(null);
                    bbB();
                    if (this.kaS.aZC()) {
                        ShareCardInfo GK = am.bbe().GK(this.kaE);
                        if (GK != null) {
                            GK.a(null);
                            am.bbe().c(GK, this.kaE);
                        }
                        AppMethodBeat.o(88303);
                        return;
                    }
                    CardInfo Gu = am.baW().Gu(this.kaE);
                    if (Gu != null) {
                        Gu.a(null);
                        am.baW().c(Gu, this.kaE);
                    }
                }
            } else if (this.ecs != -85.0f && this.ect != -1000.0f) {
                this.kiY = false;
                g.RO().eJo.a(new com.tencent.mm.plugin.card.model.v(baa, this.ect, this.ecs, this.kaS.aZZ()), 0);
                AppMethodBeat.o(88303);
                return;
            } else if (!this.kiY) {
                this.kiY = true;
                if (this.khx) {
                    aZt();
                    AppMethodBeat.o(88303);
                    return;
                }
            }
            AppMethodBeat.o(88303);
            return;
        }
        float f = this.ecs;
        float f2 = this.ect;
        if (f == -85.0f || f2 == -1000.0f) {
            f = am.bbc().ecs;
            f2 = am.bbc().ect;
        }
        g.RO().eJo.a(new com.tencent.mm.plugin.card.model.v(baa, f2, f, this.kaS.aZZ()), 0);
        AppMethodBeat.o(88303);
    }

    private void bco() {
        AppMethodBeat.i(88304);
        g.RO().eJo.a(new com.tencent.mm.plugin.card.sharecard.model.c(this.kaE), 0);
        AppMethodBeat.o(88304);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(88305);
        if (i == 4) {
            ab.e("MicroMsg.CardDetailUI", "onKeyDown finishUI");
            n(false, -1);
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(88305);
        return onKeyDown;
    }

    private void n(boolean z, int i) {
        AppMethodBeat.i(88306);
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
            AppMethodBeat.o(88306);
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
            AppMethodBeat.o(88306);
        } else {
            if ((this.kgn == 7 && this.emC == 7) || ((this.kgn == 16 && this.emC == 16) || ((this.kgn == 8 && this.emC == 8) || (this.kgn == 26 && this.emC == 26)))) {
                setResult(0);
                if (z) {
                    finish();
                    AppMethodBeat.o(88306);
                    return;
                }
            } else if (z) {
                finish();
            }
            AppMethodBeat.o(88306);
        }
    }

    private void tb(int i) {
        AppMethodBeat.i(88307);
        if (this.kgn == 7 || this.kgn == 16) {
            LinkedList linkedList = new LinkedList();
            e eVar = new e();
            eVar.kbU = this.kaS.baa();
            eVar.cMD = this.kiP;
            eVar.code = this.kiZ;
            linkedList.add(eVar);
            com.tencent.mm.g.a.b bVar = new com.tencent.mm.g.a.b();
            bVar.crM.bFZ = i;
            if (i == -1) {
                bVar.crM.crN = com.tencent.mm.plugin.card.d.h.a(linkedList, true, this.kgn);
            } else {
                bVar.crM.crN = com.tencent.mm.plugin.card.d.h.a(linkedList, false, this.kgn);
            }
            com.tencent.mm.sdk.b.a.xxA.m(bVar);
            AppMethodBeat.o(88307);
            return;
        }
        ab.i("MicroMsg.CardDetailUI", "mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_JSAPI and mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_NEARBY_PEOPLE_JSAPI ,don't push accept event");
        AppMethodBeat.o(88307);
    }

    private void aZt() {
        AppMethodBeat.i(88308);
        if (this.fwu == null) {
            this.fwu = com.tencent.mm.modelgeo.d.agz();
        }
        this.fwu.a(this.ecy, true);
        AppMethodBeat.o(88308);
    }

    private void aZv() {
        AppMethodBeat.i(88309);
        if (this.fwu != null) {
            this.fwu.c(this.ecy);
        }
        AppMethodBeat.o(88309);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(88311);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.CardDetailUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(88311);
            return;
        }
        ab.i("MicroMsg.CardDetailUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 69:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dby), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.atb), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(88284);
                            CardDetailUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(88284);
                        }
                    }, null);
                    break;
                }
                ab.i("MicroMsg.CardDetailUI", "onMPermissionGranted LocationPermissionGranted " + this.khx);
                if (!this.khx) {
                    this.khx = true;
                    bbN();
                }
                AppMethodBeat.o(88311);
                return;
        }
        AppMethodBeat.o(88311);
    }

    private synchronized void Gl(String str) {
        AppMethodBeat.i(88312);
        if (this.kgB) {
            ab.e("MicroMsg.CardDetailUI", "has start CardConsumeSuccessUI!");
            AppMethodBeat.o(88312);
        } else {
            ab.i("MicroMsg.CardDetailUI", "startConsumedSuccUI() ");
            this.kgB = true;
            Intent intent = new Intent(this, CardConsumeSuccessUI.class);
            intent.putExtra("KEY_CARD_ID", this.kaS.aZZ());
            intent.putExtra("KEY_CARD_CONSUMED_JSON", str);
            intent.putExtra("KEY_CARD_COLOR", this.kaS.aZV().color);
            intent.putExtra("key_stastic_scene", this.emC);
            intent.putExtra("key_from_scene", 0);
            startActivity(intent);
            AppMethodBeat.o(88312);
        }
    }

    public final void d(com.tencent.mm.plugin.card.base.b bVar) {
        AppMethodBeat.i(88313);
        if (bVar == null) {
            ab.e("MicroMsg.CardDetailUI", "cardInfo is empty, not to do onDataChange");
            AppMethodBeat.o(88313);
        } else if (this.kaS == null || !this.kaS.aZZ().equals(bVar.aZZ())) {
            ab.e("MicroMsg.CardDetailUI", "is not the same card, not to do onDataChange");
            AppMethodBeat.o(88313);
        } else if (this.kiM.bcT()) {
            ab.i("MicroMsg.CardDetailUI", "onDataChange");
            this.kaS = bVar;
            this.kaE = this.kaS.aZZ();
            if (this.kaS.aZQ() && am.bbj().isEmpty()) {
                am.bbj().Gk(this.kaS.aZZ());
            }
            bbB();
            AppMethodBeat.o(88313);
        } else {
            ab.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onDataChange");
            AppMethodBeat.o(88313);
        }
    }

    public final void bau() {
        AppMethodBeat.i(88314);
        ab.i("MicroMsg.CardDetailUI", "onVibrate");
        this.kgA.vibrate(300);
        AppMethodBeat.o(88314);
    }

    public final void bav() {
        AppMethodBeat.i(88315);
        ab.i("MicroMsg.CardDetailUI", "onFinishUI");
        AppMethodBeat.o(88315);
    }

    public final void Gm(final String str) {
        AppMethodBeat.i(88316);
        if (this.kiM.bcT()) {
            ab.i("MicroMsg.CardDetailUI", "onStartConsumedSuccUI");
            this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(88285);
                    CardDetailUI.c(CardDetailUI.this, str);
                    AppMethodBeat.o(88285);
                }
            });
            AppMethodBeat.o(88316);
            return;
        }
        ab.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onStartConsumedSuccUI");
        AppMethodBeat.o(88316);
    }

    public final void b(String str, j.b bVar) {
        AppMethodBeat.i(88317);
        if (TextUtils.isEmpty(str) || str.equals(this.kaE)) {
            fE(false);
            ab.i("MicroMsg.CardDetailUI", "onMarkSuccess()");
            ab.i("MicroMsg.CardDetailUI", "markSucc:" + bVar.kbI + " markCardId: " + bVar.kbJ);
            this.kiR = false;
            if (bVar.kbI != 1) {
                this.kiQ = false;
                com.tencent.mm.plugin.card.d.d.c(this, getString(R.string.afs));
            } else if (TextUtils.isEmpty(bVar.kbJ) || this.kaS.aZZ().equals(bVar.kbJ)) {
                ab.i("MicroMsg.CardDetailUI", "markCardId is same as now id!");
                this.kiQ = true;
                a(bVar);
                AppMethodBeat.o(88317);
                return;
            } else {
                ab.i("MicroMsg.CardDetailUI", "markCardId is diff as now id!");
                if (this.kaS.aZC()) {
                    ShareCardInfo GK = am.bbe().GK(bVar.kbJ);
                    if (GK != null) {
                        this.kaS = GK;
                        this.kaE = bVar.kbJ;
                        bbB();
                        am.bbh().b(this.kaS);
                        ab.i("MicroMsg.CardDetailUI", "update the mCardInfo");
                        this.kiQ = true;
                        a(bVar);
                        AppMethodBeat.o(88317);
                        return;
                    }
                    ab.e("MicroMsg.CardDetailUI", "The mark card id not exist the card info in DB!， mark failed!");
                    com.tencent.mm.plugin.card.d.d.c(this, getString(R.string.afr));
                    this.kiQ = false;
                    AppMethodBeat.o(88317);
                    return;
                }
            }
            AppMethodBeat.o(88317);
            return;
        }
        ab.e("MicroMsg.CardDetailUI", "onMarkSuccess(), the mark card id is diff from current id!");
        AppMethodBeat.o(88317);
    }

    public final void dl(String str, String str2) {
        AppMethodBeat.i(88318);
        if (TextUtils.isEmpty(str) || str.equals(this.kaE)) {
            ab.i("MicroMsg.CardDetailUI", "onMarkFail()");
            this.kiQ = false;
            this.kiR = false;
            fE(false);
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.string.afr);
            }
            com.tencent.mm.plugin.card.d.d.c(this, str2);
            AppMethodBeat.o(88318);
            return;
        }
        ab.e("MicroMsg.CardDetailUI", "onMarkFail(), the mark card id is diff from current id!");
        AppMethodBeat.o(88318);
    }

    public final void Gp(String str) {
        AppMethodBeat.i(88319);
        if (TextUtils.isEmpty(str) || str.equals(this.kaE)) {
            this.kiQ = false;
            AppMethodBeat.o(88319);
            return;
        }
        ab.e("MicroMsg.CardDetailUI", "onUnmarkSuccess(), the mark card id is diff from current id!");
        AppMethodBeat.o(88319);
    }

    private void a(j.b bVar) {
        AppMethodBeat.i(88320);
        if (this.kiM.cAY) {
            ab.i("MicroMsg.CardDetailUI", "UI is pause, not to jumpMarkUI()");
            AppMethodBeat.o(88320);
            return;
        }
        ab.i("MicroMsg.CardDetailUI", "jumpMarkUI()");
        this.kiM.a(this.kiS, bVar, true);
        AppMethodBeat.o(88320);
    }

    public final void bap() {
        AppMethodBeat.i(88321);
        ab.i("MicroMsg.CardDetailUI", "code change");
        if (this.kiM.kjk instanceof q) {
            ((q) this.kiM.kjk).knw = am.bbj().getCode();
            this.kiM.bbB();
        }
        AppMethodBeat.o(88321);
    }

    public final void Gj(String str) {
        AppMethodBeat.i(88322);
        if (!TextUtils.isEmpty(str)) {
            com.tencent.mm.plugin.card.d.d.a(this, str, true);
        }
        AppMethodBeat.o(88322);
    }

    public final void onSuccess() {
        AppMethodBeat.i(88323);
        if (this.kiM.kjk instanceof q) {
            ((q) this.kiM.kjk).knw = am.bbj().getCode();
            this.kiM.bbB();
        }
        ab.i("MicroMsg.CardDetailUI", "code get success");
        AppMethodBeat.o(88323);
    }

    private void bbN() {
        AppMethodBeat.i(88310);
        this.fwu = com.tencent.mm.modelgeo.d.agz();
        aZt();
        AppMethodBeat.o(88310);
    }

    static /* synthetic */ void h(CardDetailUI cardDetailUI) {
        AppMethodBeat.i(88326);
        cardDetailUI.n(true, -1);
        AppMethodBeat.o(88326);
    }

    static /* synthetic */ void i(CardDetailUI cardDetailUI) {
        int i;
        AppMethodBeat.i(88327);
        cardDetailUI.fE(true);
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
        bzm a = l.a(cardDetailUI.kiM.kgP, cardDetailUI.kiM.kgS, cardDetailUI.kiM.kgT);
        cdc cdc = new cdc();
        cdc.xcM = cardDetailUI.fhu;
        cdc.kdi = cardDetailUI.kiT;
        ab.i("MicroMsg.CardDetailUI", "ShareCardItem upload templateId:%s", cardDetailUI.fhu);
        g.RO().eJo.a(new com.tencent.mm.plugin.card.sharecard.model.g(i, linkedList, cardDetailUI.kaS.aZV().vTT, cardDetailUI.kit, a, cardDetailUI.emC, cdc), 0);
        AppMethodBeat.o(88327);
    }

    static /* synthetic */ void j(CardDetailUI cardDetailUI) {
        AppMethodBeat.i(88329);
        LinkedList linkedList = new LinkedList();
        linkedList.add(cardDetailUI.kaE);
        cardDetailUI.fE(true);
        g.RO().eJo.a(new com.tencent.mm.plugin.card.model.r(linkedList), 0);
        AppMethodBeat.o(88329);
    }

    static /* synthetic */ void k(CardDetailUI cardDetailUI) {
        String str;
        AppMethodBeat.i(88330);
        cardDetailUI.fE(true);
        if (cardDetailUI.emC == 6 || TextUtils.isEmpty(cardDetailUI.kaS.baa())) {
            str = cardDetailUI.kaE;
        } else {
            str = cardDetailUI.kaS.baa();
        }
        int bcS = cardDetailUI.kiM.bcS();
        cdc cdc = new cdc();
        cdc.xcM = cardDetailUI.fhu;
        cdc.kdi = cardDetailUI.kiT;
        ab.i("MicroMsg.CardDetailUI", "AcceptItemInfo templateId:%s", cardDetailUI.fhu);
        g.RO().eJo.a(new com.tencent.mm.plugin.card.model.o(str, cardDetailUI.emC, cardDetailUI.kiN, cardDetailUI.kiP, cardDetailUI.kir, cardDetailUI.kis, cardDetailUI.kiq, bcS, cdc), 0);
        AppMethodBeat.o(88330);
    }

    static /* synthetic */ void l(CardDetailUI cardDetailUI) {
        AppMethodBeat.i(88331);
        g.RO().eJo.a(new com.tencent.mm.plugin.card.sharecard.model.a(cardDetailUI.kaE), 0);
        AppMethodBeat.o(88331);
    }
}
