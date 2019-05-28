package com.tencent.mm.plugin.card.sharecard.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.bp.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.cb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.r;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.j;
import com.tencent.mm.plugin.card.sharecard.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.bzm;
import com.tencent.mm.protocal.protobuf.oi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CardConsumeSuccessUI extends MMActivity implements f {
    private final String TAG = "MicroMsg.CardConsumeSuccessUI";
    private View WL;
    private p ejZ = null;
    private OnClickListener gKK = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(88118);
            if (view.getId() == R.id.ab9) {
                CardConsumeSuccessUI.a(CardConsumeSuccessUI.this);
                AppMethodBeat.o(88118);
                return;
            }
            if (view.getId() == R.id.aba) {
                Intent intent = new Intent();
                intent.putExtra("KLabel_range_index", CardConsumeSuccessUI.this.kgP);
                intent.putExtra("Klabel_name_list", CardConsumeSuccessUI.this.kgQ);
                intent.putExtra("Kother_user_name_list", CardConsumeSuccessUI.this.kgR);
                intent.putExtra("k_sns_label_ui_title", CardConsumeSuccessUI.this.getString(R.string.aha));
                intent.putExtra("k_sns_label_ui_style", 0);
                intent.putExtra("KLabel_is_filter_private", true);
                d.b(CardConsumeSuccessUI.this, "sns", ".ui.SnsLabelUI", intent, 1);
            }
            AppMethodBeat.o(88118);
        }
    };
    ak ilv = new ak(Looper.getMainLooper());
    private String kaE = "";
    private String kbQ = "";
    private TextView kgD;
    private TextView kgE;
    private TextView kgF;
    private TextView kgG;
    private ImageView kgH;
    private Button kgI;
    private CheckBox kgJ;
    private j kgK;
    private String kgL = "";
    private String kgM = "";
    int kgN = 0;
    int kgO = 0;
    public int kgP = 0;
    private String kgQ = "";
    private String kgR = "";
    public ArrayList<String> kgS = new ArrayList();
    public ArrayList<String> kgT = new ArrayList();
    private TextView kgq;
    private TextView kgr;
    private long mStartTime = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardConsumeSuccessUI() {
        AppMethodBeat.i(88121);
        AppMethodBeat.o(88121);
    }

    static /* synthetic */ void bbG() {
        AppMethodBeat.i(88137);
        sW(0);
        AppMethodBeat.o(88137);
    }

    static /* synthetic */ void d(CardConsumeSuccessUI cardConsumeSuccessUI) {
        AppMethodBeat.i(88139);
        cardConsumeSuccessUI.cu();
        AppMethodBeat.o(88139);
    }

    private void fE(boolean z) {
        AppMethodBeat.i(88122);
        if (z) {
            this.ejZ = p.b(this, getString(R.string.cn5), true, null);
            AppMethodBeat.o(88122);
            return;
        }
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
            this.ejZ = null;
        }
        AppMethodBeat.o(88122);
    }

    public final int getLayoutId() {
        return R.layout.i_;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x01e5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(88123);
        super.onCreate(bundle);
        ab.i("MicroMsg.CardConsumeSuccessUI", "onCreate()");
        this.mStartTime = System.currentTimeMillis();
        setMMTitle("");
        setResult(0);
        g.RO().eJo.a(902, (f) this);
        g.RO().eJo.a(910, (f) this);
        CharSequence charSequence = "";
        this.kgN = getIntent().getIntExtra("key_from_scene", 0);
        if (this.kgN == 1) {
            ab.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_JS");
            this.kgL = getIntent().getStringExtra("key_consumed_card_id");
            this.kgM = getIntent().getStringExtra("key_consumed_Code");
            if (TextUtils.isEmpty(this.kgL)) {
                ab.e("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCardId is empty!");
                sW(0);
                finish();
                AppMethodBeat.o(88123);
                return;
            }
            ab.i("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCode is " + this.kgM);
            fE(true);
            g.RO().eJo.a(new com.tencent.mm.plugin.card.sharecard.model.d("", this.kgL, this.kgM), 0);
            bbE();
            this.kgO = 7;
        } else if (this.kgN == 2) {
            ab.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_MSG_UI");
            this.kaE = getIntent().getStringExtra("key_card_id");
            if (TextUtils.isEmpty(this.kaE)) {
                ab.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
                sW(0);
                finish();
                AppMethodBeat.o(88123);
                return;
            }
            ab.i("MicroMsg.CardConsumeSuccessUI", "the mCardId is " + this.kaE);
            fE(true);
            g.RO().eJo.a(new com.tencent.mm.plugin.card.sharecard.model.d(this.kaE, "", ""), 0);
            bbE();
            this.kgO = 4;
        } else {
            ab.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_CONSUMED_CODE");
            this.kaE = getIntent().getStringExtra("KEY_CARD_ID");
            if (GM(getIntent().getStringExtra("KEY_CARD_CONSUMED_JSON"))) {
                String str;
                Object charSequence2;
                if (!(this.kgK == null || bo.ek(this.kgK.ckx))) {
                    oi oiVar = ((q) this.kgK.ckx.get(0)).kcY;
                    if (oiVar != null) {
                        str = oiVar.color;
                        if (bo.isNullOrNil(str)) {
                            str = getIntent().getStringExtra("KEY_CARD_COLOR");
                        }
                        this.kgO = getIntent().getIntExtra("key_stastic_scene", 0);
                        charSequence2 = str;
                    }
                }
                CharSequence str2 = charSequence2;
                if (bo.isNullOrNil(str2)) {
                }
                this.kgO = getIntent().getIntExtra("key_stastic_scene", 0);
                charSequence2 = str2;
            } else {
                ab.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
                sW(0);
                finish();
                AppMethodBeat.o(88123);
                return;
            }
        }
        h.pYm.e(11324, "CardConsumeSuccessUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.kgO), "", Integer.valueOf(0), "");
        initView();
        if (!TextUtils.isEmpty(charSequence2)) {
            GN(charSequence2);
        }
        AppMethodBeat.o(88123);
    }

    private boolean GM(String str) {
        AppMethodBeat.i(88124);
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the consumed json is empty!");
            AppMethodBeat.o(88124);
            return false;
        }
        this.kgK = r.Hv(str);
        if (this.kgK == null) {
            ab.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the mConsumedInfo is null! json is ".concat(String.valueOf(str)));
            AppMethodBeat.o(88124);
            return false;
        }
        AppMethodBeat.o(88124);
        return true;
    }

    public void onResume() {
        AppMethodBeat.i(88125);
        super.onResume();
        AppMethodBeat.o(88125);
    }

    public final void initView() {
        AppMethodBeat.i(88127);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(88117);
                CardConsumeSuccessUI.this.finish();
                CardConsumeSuccessUI.bbG();
                AppMethodBeat.o(88117);
                return true;
            }
        });
        this.WL = this.mController.contentView;
        this.kgq = (TextView) findViewById(R.id.a_1);
        this.kgr = (TextView) findViewById(R.id.a_3);
        this.kgD = (TextView) findViewById(R.id.a_4);
        this.kgE = (TextView) findViewById(R.id.ab8);
        this.kgF = (TextView) findViewById(R.id.aba);
        this.kgG = (TextView) findViewById(R.id.abb);
        this.kgH = (ImageView) findViewById(R.id.a_0);
        this.kgI = (Button) findViewById(R.id.ab9);
        this.kgJ = (CheckBox) findViewById(R.id.ab_);
        this.kgI.setOnClickListener(this.gKK);
        this.kgJ.setOnClickListener(this.gKK);
        this.kgF.setOnClickListener(this.gKK);
        if (this.kgK != null) {
            cu();
        }
        AppMethodBeat.o(88127);
    }

    private void cu() {
        AppMethodBeat.i(88128);
        if (this.kgK == null) {
            ab.e("MicroMsg.CardConsumeSuccessUI", "don't updateView() , mConsumedInfo is null");
            AppMethodBeat.o(88128);
            return;
        }
        findViewById(R.id.ab5).setVisibility(0);
        if (TextUtils.isEmpty(this.kgK.kfE) || TextUtils.isEmpty(this.kgK.kfF)) {
            this.kgJ.setVisibility(8);
            ab.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.subscribe_wording is empty or subscribe_app_username is empty!");
        } else {
            this.kgJ.setText(this.kgK.kfE);
            this.kgJ.setVisibility(0);
        }
        if (this.kgK.ckx == null || this.kgK.ckx.size() <= 0) {
            this.kgI.setEnabled(false);
            ab.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list is null!");
            AppMethodBeat.o(88128);
            return;
        }
        this.kgE.setText(getString(R.string.adb, new Object[]{Integer.valueOf(this.kgK.ckx.size())}));
        oi oiVar = ((q) this.kgK.ckx.get(0)).kcY;
        if (oiVar != null) {
            GN(oiVar.color);
            this.kgq.setText(oiVar.kdg);
            this.kgr.setText(oiVar.title);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.vx);
            if (TextUtils.isEmpty(oiVar.kbV)) {
                ab.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo.logo_url is empty!");
                this.kgH.setImageResource(R.drawable.bcm);
            } else {
                a aVar = new a();
                aVar.ePK = e.eSn;
                o.ahq();
                aVar.ePY = null;
                aVar.ePJ = m.Gz(oiVar.kbV);
                aVar.ePH = true;
                aVar.eQf = true;
                aVar.ePF = true;
                aVar.ePO = dimensionPixelSize;
                aVar.ePN = dimensionPixelSize;
                aVar.ePT = R.drawable.bcm;
                o.ahp().a(oiVar.kbV, this.kgH, aVar.ahG());
            }
            if (TextUtils.isEmpty(oiVar.vUf)) {
                this.kgI.setText(R.string.ad9);
                AppMethodBeat.o(88128);
                return;
            }
            ab.e("MicroMsg.CardConsumeSuccessUI", "accept_wording is empty!");
            this.kgI.setText(oiVar.vUf);
            AppMethodBeat.o(88128);
            return;
        }
        ab.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo is null!");
        AppMethodBeat.o(88128);
    }

    @TargetApi(16)
    private void GN(String str) {
        AppMethodBeat.i(88130);
        int Hn = l.Hn(str);
        this.WL.setBackgroundColor(Hn);
        xE(Hn);
        if (com.tencent.mm.compatible.util.d.iW(16)) {
            this.kgI.setBackground(l.dI(Hn, getResources().getDimensionPixelSize(R.dimen.v9) / 2));
        } else {
            this.kgI.setBackgroundDrawable(l.dI(Hn, getResources().getDimensionPixelSize(R.dimen.v9) / 2));
        }
        this.WL.invalidate();
        AppMethodBeat.o(88130);
    }

    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(88131);
        ab.i("MicroMsg.CardConsumeSuccessUI", "onSceneEnd, errType = " + i + " errCode = " + i2 + " scene cmd is " + mVar.getType());
        fE(false);
        if (i == 0 && i2 == 0) {
            if (mVar instanceof com.tencent.mm.plugin.card.sharecard.model.g) {
                com.tencent.mm.plugin.card.sharecard.model.g gVar = (com.tencent.mm.plugin.card.sharecard.model.g) mVar;
                if (gVar.kdT == 0) {
                    com.tencent.mm.ui.base.h.bQ(this, getString(R.string.acl));
                    setResult(-1);
                    this.kgI.setEnabled(false);
                    l.beD();
                    ab.i("MicroMsg.CardConsumeSuccessUI", "finish UI!");
                    sW(-1);
                    String str2 = ((com.tencent.mm.plugin.card.sharecard.model.g) mVar).kdS;
                    ShareCardInfo shareCardInfo = new ShareCardInfo();
                    com.tencent.mm.plugin.card.d.f.a(shareCardInfo, str2);
                    l.a(shareCardInfo);
                    am.bbd().aVU();
                    finish();
                    AppMethodBeat.o(88131);
                    return;
                }
                ab.e("MicroMsg.CardConsumeSuccessUI", "shareNetscene.getRetCode() is " + gVar.kdT);
                com.tencent.mm.plugin.card.d.d.c(this, gVar.kdU);
                com.tencent.mm.ui.base.h.bQ(this, getString(R.string.ach));
                AppMethodBeat.o(88131);
                return;
            } else if (mVar instanceof com.tencent.mm.plugin.card.sharecard.model.d) {
                com.tencent.mm.plugin.card.sharecard.model.d dVar = (com.tencent.mm.plugin.card.sharecard.model.d) mVar;
                if (dVar.kdT == 0) {
                    if (TextUtils.isEmpty(dVar.kdS) || !GM(dVar.kdS)) {
                        ab.e("MicroMsg.CardConsumeSuccessUI", "consumed return json is empty, finish ui!");
                        if (this.kgN == 1) {
                            sW(0);
                            finish();
                            AppMethodBeat.o(88131);
                            return;
                        }
                        bbE();
                        GO(dVar.kdU);
                        if (bo.isNullOrNil(dVar.kdU)) {
                            com.tencent.mm.ui.base.h.bQ(this, getString(R.string.acj));
                            AppMethodBeat.o(88131);
                            return;
                        }
                        com.tencent.mm.ui.base.h.bQ(this, dVar.kdU);
                        AppMethodBeat.o(88131);
                        return;
                    }
                    ab.i("MicroMsg.CardConsumeSuccessUI", "consumed return json is valid, update ui");
                    this.ilv.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(88119);
                            CardConsumeSuccessUI.d(CardConsumeSuccessUI.this);
                            AppMethodBeat.o(88119);
                        }
                    });
                    AppMethodBeat.o(88131);
                    return;
                } else if (this.kgN == 1) {
                    sW(0);
                    finish();
                    AppMethodBeat.o(88131);
                    return;
                } else {
                    ab.e("MicroMsg.CardConsumeSuccessUI", "succScene.getRetCode() is " + dVar.kdT);
                    bbE();
                    GO(dVar.kdU);
                    AppMethodBeat.o(88131);
                    return;
                }
            }
        } else if ((mVar instanceof com.tencent.mm.plugin.card.sharecard.model.d) && this.kgN == 1) {
            sW(0);
            finish();
            AppMethodBeat.o(88131);
            return;
        } else {
            com.tencent.mm.plugin.card.d.d.c(this, str);
        }
        AppMethodBeat.o(88131);
    }

    private void GO(String str) {
        AppMethodBeat.i(88132);
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.acj);
        }
        com.tencent.mm.ui.base.h.a((Context) this, str, "", false, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(88120);
                dialogInterface.dismiss();
                CardConsumeSuccessUI.bbG();
                CardConsumeSuccessUI.this.finish();
                AppMethodBeat.o(88120);
            }
        });
        AppMethodBeat.o(88132);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(88133);
        if (i == 4) {
            ab.e("MicroMsg.CardConsumeSuccessUI", "onKeyDown finishUI");
            sW(0);
            finish();
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(88133);
        return onKeyDown;
    }

    private static void sW(int i) {
        AppMethodBeat.i(88134);
        ab.i("MicroMsg.CardConsumeSuccessUI", "pushConsumedEvent resultCode is ".concat(String.valueOf(i)));
        cb cbVar = new cb();
        cbVar.cvk.bFZ = i;
        com.tencent.mm.sdk.b.a.xxA.m(cbVar);
        AppMethodBeat.o(88134);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(88135);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.kgP = intent.getIntExtra("Ktag_range_index", 0);
                    ab.i("MicroMsg.CardConsumeSuccessUI", "mPrivateSelelct : %d", Integer.valueOf(this.kgP));
                    if (this.kgP < 2) {
                        this.kgG.setVisibility(8);
                        break;
                    }
                    this.kgQ = intent.getStringExtra("Klabel_name_list");
                    this.kgR = intent.getStringExtra("Kother_user_name_list");
                    ab.d("MicroMsg.CardConsumeSuccessUI", "mPrivateSelect : %d, names : %s", Integer.valueOf(this.kgP), this.kgQ);
                    if (TextUtils.isEmpty(this.kgQ) && TextUtils.isEmpty(this.kgR)) {
                        ab.e("MicroMsg.CardConsumeSuccessUI", "mLabelNameList and mPrivateTmpUsers by getIntent is empty");
                        AppMethodBeat.o(88135);
                        return;
                    }
                    List asList = Arrays.asList(this.kgQ.split(","));
                    this.kgT = l.bl(asList);
                    this.kgS = l.bk(asList);
                    if (this.kgR != null && this.kgR.length() > 0) {
                        this.kgS.addAll(Arrays.asList(this.kgR.split(",")));
                    }
                    if (this.kgT != null) {
                        ab.i("MicroMsg.CardConsumeSuccessUI", "mPrivateIdsList size is " + this.kgT.size());
                    }
                    if (this.kgS != null) {
                        ab.i("MicroMsg.CardConsumeSuccessUI", "mPrivateNamesList size is " + this.kgS.size());
                        Iterator it = this.kgS.iterator();
                        while (it.hasNext()) {
                            ab.d("MicroMsg.CardConsumeSuccessUI", "username : %s", (String) it.next());
                        }
                    }
                    if (this.kgP == 2) {
                        this.kgG.setVisibility(0);
                        this.kgG.setText(getString(R.string.ah_, new Object[]{bbF()}));
                        AppMethodBeat.o(88135);
                        return;
                    } else if (this.kgP == 3) {
                        this.kgG.setVisibility(0);
                        this.kgG.setText(getString(R.string.ah9, new Object[]{bbF()}));
                        AppMethodBeat.o(88135);
                        return;
                    } else {
                        this.kgG.setVisibility(8);
                        AppMethodBeat.o(88135);
                        return;
                    }
                }
                AppMethodBeat.o(88135);
                return;
        }
        AppMethodBeat.o(88135);
    }

    private String bbF() {
        AppMethodBeat.i(88136);
        String str;
        if (!TextUtils.isEmpty(this.kgQ) && !TextUtils.isEmpty(this.kgR)) {
            str = this.kgQ + "," + l.Hq(this.kgR);
            AppMethodBeat.o(88136);
            return str;
        } else if (!TextUtils.isEmpty(this.kgQ)) {
            str = this.kgQ;
            AppMethodBeat.o(88136);
            return str;
        } else if (TextUtils.isEmpty(this.kgR)) {
            str = "";
            AppMethodBeat.o(88136);
            return str;
        } else {
            str = l.Hq(this.kgR);
            AppMethodBeat.o(88136);
            return str;
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(88126);
        g.RO().eJo.b(902, (f) this);
        g.RO().eJo.b(910, (f) this);
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (TextUtils.isEmpty(this.kaE)) {
            h.pYm.e(13219, "CardConsumeSuccessUI", Integer.valueOf(this.kgN), this.kbQ, this.kgL, Long.valueOf(currentTimeMillis));
        } else {
            h.pYm.e(13219, "CardConsumeSuccessUI", Integer.valueOf(this.kgN), this.kbQ, this.kaE, Long.valueOf(currentTimeMillis));
        }
        super.onDestroy();
        AppMethodBeat.o(88126);
    }

    private void bbE() {
        AppMethodBeat.i(88129);
        this.mController.contentView.setBackgroundColor(getResources().getColor(R.color.ir));
        findViewById(R.id.ab5).setVisibility(4);
        AppMethodBeat.o(88129);
    }

    static /* synthetic */ void a(CardConsumeSuccessUI cardConsumeSuccessUI) {
        AppMethodBeat.i(88138);
        if (cardConsumeSuccessUI.kgK == null || cardConsumeSuccessUI.kgK.ckx == null || cardConsumeSuccessUI.kgK.ckx.isEmpty()) {
            ab.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list == null || mConsumedInfo.list.isEmpty()!");
            AppMethodBeat.o(88138);
            return;
        }
        String str;
        com.tencent.mm.ai.m gVar;
        cardConsumeSuccessUI.fE(true);
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < cardConsumeSuccessUI.kgK.ckx.size(); i++) {
            oi oiVar = ((q) cardConsumeSuccessUI.kgK.ckx.get(i)).kcY;
            byx byx = new byx();
            if (oiVar != null) {
                byx.kbU = oiVar.kbU;
                cardConsumeSuccessUI.kbQ = oiVar.kbU;
            }
            byx.cMD = ((q) cardConsumeSuccessUI.kgK.ckx.get(i)).cMD;
            byx.vBv = "";
            byx.vBu = "";
            byx.vBw = cardConsumeSuccessUI.kgO;
            linkedList.add(byx);
        }
        if (cardConsumeSuccessUI.kgN == 1) {
            str = cardConsumeSuccessUI.kgK.kfD;
        } else {
            str = cardConsumeSuccessUI.kaE;
        }
        bzm a = l.a(cardConsumeSuccessUI.kgP, cardConsumeSuccessUI.kgS, cardConsumeSuccessUI.kgT);
        if (cardConsumeSuccessUI.kgJ.isChecked()) {
            gVar = new com.tencent.mm.plugin.card.sharecard.model.g(0, linkedList, cardConsumeSuccessUI.kgK.kfF, str, a, 20, null);
        } else {
            gVar = new com.tencent.mm.plugin.card.sharecard.model.g(0, linkedList, "", str, a, 20, null);
        }
        if (cardConsumeSuccessUI.kgJ != null && cardConsumeSuccessUI.kgJ.getVisibility() == 0) {
            if (cardConsumeSuccessUI.kgJ.isChecked()) {
                h.pYm.e(11324, "CardConsumeSuccessFollowServices", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "");
            } else {
                h.pYm.e(11324, "CardConsumeSuccessView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "");
            }
        }
        g.RO().eJo.a(gVar, 0);
        AppMethodBeat.o(88138);
    }
}
