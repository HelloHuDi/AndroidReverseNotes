package com.tencent.p177mm.plugin.card.sharecard.p354ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p230g.p231a.C41973cb;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.card.model.C33770m;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.p931d.C27575f;
import com.tencent.p177mm.plugin.card.p931d.C33764r;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C42840d;
import com.tencent.p177mm.plugin.card.sharecard.model.C20153d;
import com.tencent.p177mm.plugin.card.sharecard.model.C20154j;
import com.tencent.p177mm.plugin.card.sharecard.model.C42858g;
import com.tencent.p177mm.plugin.card.sharecard.model.C42860q;
import com.tencent.p177mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C44151oi;
import com.tencent.p177mm.protocal.protobuf.byx;
import com.tencent.p177mm.protocal.protobuf.bzm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI */
public class CardConsumeSuccessUI extends MMActivity implements C1202f {
    private final String TAG = "MicroMsg.CardConsumeSuccessUI";
    /* renamed from: WL */
    private View f4372WL;
    private C44275p ejZ = null;
    private OnClickListener gKK = new C201582();
    C7306ak ilv = new C7306ak(Looper.getMainLooper());
    private String kaE = "";
    private String kbQ = "";
    private TextView kgD;
    private TextView kgE;
    private TextView kgF;
    private TextView kgG;
    private ImageView kgH;
    private Button kgI;
    private CheckBox kgJ;
    private C20154j kgK;
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

    /* renamed from: com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI$1 */
    class C201571 implements OnMenuItemClickListener {
        C201571() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(88117);
            CardConsumeSuccessUI.this.finish();
            CardConsumeSuccessUI.bbG();
            AppMethodBeat.m2505o(88117);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI$2 */
    class C201582 implements OnClickListener {
        C201582() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(88118);
            if (view.getId() == 2131821997) {
                CardConsumeSuccessUI.m31186a(CardConsumeSuccessUI.this);
                AppMethodBeat.m2505o(88118);
                return;
            }
            if (view.getId() == 2131821999) {
                Intent intent = new Intent();
                intent.putExtra("KLabel_range_index", CardConsumeSuccessUI.this.kgP);
                intent.putExtra("Klabel_name_list", CardConsumeSuccessUI.this.kgQ);
                intent.putExtra("Kother_user_name_list", CardConsumeSuccessUI.this.kgR);
                intent.putExtra("k_sns_label_ui_title", CardConsumeSuccessUI.this.getString(C25738R.string.aha));
                intent.putExtra("k_sns_label_ui_style", 0);
                intent.putExtra("KLabel_is_filter_private", true);
                C25985d.m41468b(CardConsumeSuccessUI.this, "sns", ".ui.SnsLabelUI", intent, 1);
            }
            AppMethodBeat.m2505o(88118);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI$3 */
    class C201593 implements Runnable {
        C201593() {
        }

        public final void run() {
            AppMethodBeat.m2504i(88119);
            CardConsumeSuccessUI.m31190d(CardConsumeSuccessUI.this);
            AppMethodBeat.m2505o(88119);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI$4 */
    class C201604 implements DialogInterface.OnClickListener {
        C201604() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(88120);
            dialogInterface.dismiss();
            CardConsumeSuccessUI.bbG();
            CardConsumeSuccessUI.this.finish();
            AppMethodBeat.m2505o(88120);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public CardConsumeSuccessUI() {
        AppMethodBeat.m2504i(88121);
        AppMethodBeat.m2505o(88121);
    }

    static /* synthetic */ void bbG() {
        AppMethodBeat.m2504i(88137);
        CardConsumeSuccessUI.m31192sW(0);
        AppMethodBeat.m2505o(88137);
    }

    /* renamed from: d */
    static /* synthetic */ void m31190d(CardConsumeSuccessUI cardConsumeSuccessUI) {
        AppMethodBeat.m2504i(88139);
        cardConsumeSuccessUI.m31189cu();
        AppMethodBeat.m2505o(88139);
    }

    /* renamed from: fE */
    private void m31191fE(boolean z) {
        AppMethodBeat.m2504i(88122);
        if (z) {
            this.ejZ = C44275p.m79966b(this, getString(C25738R.string.cn5), true, null);
            AppMethodBeat.m2505o(88122);
            return;
        }
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
            this.ejZ = null;
        }
        AppMethodBeat.m2505o(88122);
    }

    public final int getLayoutId() {
        return 2130968908;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x01e5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(88123);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.CardConsumeSuccessUI", "onCreate()");
        this.mStartTime = System.currentTimeMillis();
        setMMTitle("");
        setResult(0);
        C1720g.m3535RO().eJo.mo14539a(902, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(910, (C1202f) this);
        CharSequence charSequence = "";
        this.kgN = getIntent().getIntExtra("key_from_scene", 0);
        if (this.kgN == 1) {
            C4990ab.m7416i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_JS");
            this.kgL = getIntent().getStringExtra("key_consumed_card_id");
            this.kgM = getIntent().getStringExtra("key_consumed_Code");
            if (TextUtils.isEmpty(this.kgL)) {
                C4990ab.m7412e("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCardId is empty!");
                CardConsumeSuccessUI.m31192sW(0);
                finish();
                AppMethodBeat.m2505o(88123);
                return;
            }
            C4990ab.m7416i("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCode is " + this.kgM);
            m31191fE(true);
            C1720g.m3535RO().eJo.mo14541a(new C20153d("", this.kgL, this.kgM), 0);
            bbE();
            this.kgO = 7;
        } else if (this.kgN == 2) {
            C4990ab.m7416i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_MSG_UI");
            this.kaE = getIntent().getStringExtra("key_card_id");
            if (TextUtils.isEmpty(this.kaE)) {
                C4990ab.m7412e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
                CardConsumeSuccessUI.m31192sW(0);
                finish();
                AppMethodBeat.m2505o(88123);
                return;
            }
            C4990ab.m7416i("MicroMsg.CardConsumeSuccessUI", "the mCardId is " + this.kaE);
            m31191fE(true);
            C1720g.m3535RO().eJo.mo14541a(new C20153d(this.kaE, "", ""), 0);
            bbE();
            this.kgO = 4;
        } else {
            C4990ab.m7416i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_CONSUMED_CODE");
            this.kaE = getIntent().getStringExtra("KEY_CARD_ID");
            if (m31183GM(getIntent().getStringExtra("KEY_CARD_CONSUMED_JSON"))) {
                String str;
                Object charSequence2;
                if (!(this.kgK == null || C5046bo.m7548ek(this.kgK.ckx))) {
                    C44151oi c44151oi = ((C42860q) this.kgK.ckx.get(0)).kcY;
                    if (c44151oi != null) {
                        str = c44151oi.color;
                        if (C5046bo.isNullOrNil(str)) {
                            str = getIntent().getStringExtra("KEY_CARD_COLOR");
                        }
                        this.kgO = getIntent().getIntExtra("key_stastic_scene", 0);
                        charSequence2 = str;
                    }
                }
                CharSequence str2 = charSequence2;
                if (C5046bo.isNullOrNil(str2)) {
                }
                this.kgO = getIntent().getIntExtra("key_stastic_scene", 0);
                charSequence2 = str2;
            } else {
                C4990ab.m7412e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
                CardConsumeSuccessUI.m31192sW(0);
                finish();
                AppMethodBeat.m2505o(88123);
                return;
            }
        }
        C7060h.pYm.mo8381e(11324, "CardConsumeSuccessUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.kgO), "", Integer.valueOf(0), "");
        initView();
        if (!TextUtils.isEmpty(charSequence2)) {
            m31184GN(charSequence2);
        }
        AppMethodBeat.m2505o(88123);
    }

    /* renamed from: GM */
    private boolean m31183GM(String str) {
        AppMethodBeat.m2504i(88124);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the consumed json is empty!");
            AppMethodBeat.m2505o(88124);
            return false;
        }
        this.kgK = C33764r.m55182Hv(str);
        if (this.kgK == null) {
            C4990ab.m7412e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the mConsumedInfo is null! json is ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(88124);
            return false;
        }
        AppMethodBeat.m2505o(88124);
        return true;
    }

    public void onResume() {
        AppMethodBeat.m2504i(88125);
        super.onResume();
        AppMethodBeat.m2505o(88125);
    }

    public final void initView() {
        AppMethodBeat.m2504i(88127);
        setBackBtn(new C201571());
        this.f4372WL = this.mController.contentView;
        this.kgq = (TextView) findViewById(2131821915);
        this.kgr = (TextView) findViewById(2131821917);
        this.kgD = (TextView) findViewById(2131821918);
        this.kgE = (TextView) findViewById(2131821996);
        this.kgF = (TextView) findViewById(2131821999);
        this.kgG = (TextView) findViewById(2131822000);
        this.kgH = (ImageView) findViewById(2131821914);
        this.kgI = (Button) findViewById(2131821997);
        this.kgJ = (CheckBox) findViewById(2131821998);
        this.kgI.setOnClickListener(this.gKK);
        this.kgJ.setOnClickListener(this.gKK);
        this.kgF.setOnClickListener(this.gKK);
        if (this.kgK != null) {
            m31189cu();
        }
        AppMethodBeat.m2505o(88127);
    }

    /* renamed from: cu */
    private void m31189cu() {
        AppMethodBeat.m2504i(88128);
        if (this.kgK == null) {
            C4990ab.m7412e("MicroMsg.CardConsumeSuccessUI", "don't updateView() , mConsumedInfo is null");
            AppMethodBeat.m2505o(88128);
            return;
        }
        findViewById(2131821993).setVisibility(0);
        if (TextUtils.isEmpty(this.kgK.kfE) || TextUtils.isEmpty(this.kgK.kfF)) {
            this.kgJ.setVisibility(8);
            C4990ab.m7412e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.subscribe_wording is empty or subscribe_app_username is empty!");
        } else {
            this.kgJ.setText(this.kgK.kfE);
            this.kgJ.setVisibility(0);
        }
        if (this.kgK.ckx == null || this.kgK.ckx.size() <= 0) {
            this.kgI.setEnabled(false);
            C4990ab.m7412e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list is null!");
            AppMethodBeat.m2505o(88128);
            return;
        }
        this.kgE.setText(getString(C25738R.string.adb, new Object[]{Integer.valueOf(this.kgK.ckx.size())}));
        C44151oi c44151oi = ((C42860q) this.kgK.ckx.get(0)).kcY;
        if (c44151oi != null) {
            m31184GN(c44151oi.color);
            this.kgq.setText(c44151oi.kdg);
            this.kgr.setText(c44151oi.title);
            int dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f10255vx);
            if (TextUtils.isEmpty(c44151oi.kbV)) {
                C4990ab.m7412e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo.logo_url is empty!");
                this.kgH.setImageResource(C25738R.drawable.bcm);
            } else {
                C17927a c17927a = new C17927a();
                c17927a.ePK = C6457e.eSn;
                C32291o.ahq();
                c17927a.ePY = null;
                c17927a.ePJ = C33770m.m55183Gz(c44151oi.kbV);
                c17927a.ePH = true;
                c17927a.eQf = true;
                c17927a.ePF = true;
                c17927a.ePO = dimensionPixelSize;
                c17927a.ePN = dimensionPixelSize;
                c17927a.ePT = C25738R.drawable.bcm;
                C32291o.ahp().mo43766a(c44151oi.kbV, this.kgH, c17927a.ahG());
            }
            if (TextUtils.isEmpty(c44151oi.vUf)) {
                this.kgI.setText(C25738R.string.ad9);
                AppMethodBeat.m2505o(88128);
                return;
            }
            C4990ab.m7412e("MicroMsg.CardConsumeSuccessUI", "accept_wording is empty!");
            this.kgI.setText(c44151oi.vUf);
            AppMethodBeat.m2505o(88128);
            return;
        }
        C4990ab.m7412e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo is null!");
        AppMethodBeat.m2505o(88128);
    }

    @TargetApi(16)
    /* renamed from: GN */
    private void m31184GN(String str) {
        AppMethodBeat.m2504i(88130);
        int Hn = C38736l.m65701Hn(str);
        this.f4372WL.setBackgroundColor(Hn);
        mo17446xE(Hn);
        if (C1443d.m3068iW(16)) {
            this.kgI.setBackground(C38736l.m65725dI(Hn, getResources().getDimensionPixelSize(C25738R.dimen.f10233v9) / 2));
        } else {
            this.kgI.setBackgroundDrawable(C38736l.m65725dI(Hn, getResources().getDimensionPixelSize(C25738R.dimen.f10233v9) / 2));
        }
        this.f4372WL.invalidate();
        AppMethodBeat.m2505o(88130);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(88131);
        C4990ab.m7416i("MicroMsg.CardConsumeSuccessUI", "onSceneEnd, errType = " + i + " errCode = " + i2 + " scene cmd is " + c1207m.getType());
        m31191fE(false);
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C42858g) {
                C42858g c42858g = (C42858g) c1207m;
                if (c42858g.kdT == 0) {
                    C30379h.m48465bQ(this, getString(C25738R.string.acl));
                    setResult(-1);
                    this.kgI.setEnabled(false);
                    C38736l.beD();
                    C4990ab.m7416i("MicroMsg.CardConsumeSuccessUI", "finish UI!");
                    CardConsumeSuccessUI.m31192sW(-1);
                    String str2 = ((C42858g) c1207m).kdS;
                    ShareCardInfo shareCardInfo = new ShareCardInfo();
                    C27575f.m43804a(shareCardInfo, str2);
                    C38736l.m65713a(shareCardInfo);
                    C42852am.bbd().aVU();
                    finish();
                    AppMethodBeat.m2505o(88131);
                    return;
                }
                C4990ab.m7412e("MicroMsg.CardConsumeSuccessUI", "shareNetscene.getRetCode() is " + c42858g.kdT);
                C42840d.m76040c(this, c42858g.kdU);
                C30379h.m48465bQ(this, getString(C25738R.string.ach));
                AppMethodBeat.m2505o(88131);
                return;
            } else if (c1207m instanceof C20153d) {
                C20153d c20153d = (C20153d) c1207m;
                if (c20153d.kdT == 0) {
                    if (TextUtils.isEmpty(c20153d.kdS) || !m31183GM(c20153d.kdS)) {
                        C4990ab.m7412e("MicroMsg.CardConsumeSuccessUI", "consumed return json is empty, finish ui!");
                        if (this.kgN == 1) {
                            CardConsumeSuccessUI.m31192sW(0);
                            finish();
                            AppMethodBeat.m2505o(88131);
                            return;
                        }
                        bbE();
                        m31185GO(c20153d.kdU);
                        if (C5046bo.isNullOrNil(c20153d.kdU)) {
                            C30379h.m48465bQ(this, getString(C25738R.string.acj));
                            AppMethodBeat.m2505o(88131);
                            return;
                        }
                        C30379h.m48465bQ(this, c20153d.kdU);
                        AppMethodBeat.m2505o(88131);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.CardConsumeSuccessUI", "consumed return json is valid, update ui");
                    this.ilv.post(new C201593());
                    AppMethodBeat.m2505o(88131);
                    return;
                } else if (this.kgN == 1) {
                    CardConsumeSuccessUI.m31192sW(0);
                    finish();
                    AppMethodBeat.m2505o(88131);
                    return;
                } else {
                    C4990ab.m7412e("MicroMsg.CardConsumeSuccessUI", "succScene.getRetCode() is " + c20153d.kdT);
                    bbE();
                    m31185GO(c20153d.kdU);
                    AppMethodBeat.m2505o(88131);
                    return;
                }
            }
        } else if ((c1207m instanceof C20153d) && this.kgN == 1) {
            CardConsumeSuccessUI.m31192sW(0);
            finish();
            AppMethodBeat.m2505o(88131);
            return;
        } else {
            C42840d.m76040c(this, str);
        }
        AppMethodBeat.m2505o(88131);
    }

    /* renamed from: GO */
    private void m31185GO(String str) {
        AppMethodBeat.m2504i(88132);
        if (TextUtils.isEmpty(str)) {
            str = getString(C25738R.string.acj);
        }
        C30379h.m48448a((Context) this, str, "", false, new C201604());
        AppMethodBeat.m2505o(88132);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(88133);
        if (i == 4) {
            C4990ab.m7412e("MicroMsg.CardConsumeSuccessUI", "onKeyDown finishUI");
            CardConsumeSuccessUI.m31192sW(0);
            finish();
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(88133);
        return onKeyDown;
    }

    /* renamed from: sW */
    private static void m31192sW(int i) {
        AppMethodBeat.m2504i(88134);
        C4990ab.m7416i("MicroMsg.CardConsumeSuccessUI", "pushConsumedEvent resultCode is ".concat(String.valueOf(i)));
        C41973cb c41973cb = new C41973cb();
        c41973cb.cvk.bFZ = i;
        C4879a.xxA.mo10055m(c41973cb);
        AppMethodBeat.m2505o(88134);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(88135);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.kgP = intent.getIntExtra("Ktag_range_index", 0);
                    C4990ab.m7417i("MicroMsg.CardConsumeSuccessUI", "mPrivateSelelct : %d", Integer.valueOf(this.kgP));
                    if (this.kgP < 2) {
                        this.kgG.setVisibility(8);
                        break;
                    }
                    this.kgQ = intent.getStringExtra("Klabel_name_list");
                    this.kgR = intent.getStringExtra("Kother_user_name_list");
                    C4990ab.m7411d("MicroMsg.CardConsumeSuccessUI", "mPrivateSelect : %d, names : %s", Integer.valueOf(this.kgP), this.kgQ);
                    if (TextUtils.isEmpty(this.kgQ) && TextUtils.isEmpty(this.kgR)) {
                        C4990ab.m7412e("MicroMsg.CardConsumeSuccessUI", "mLabelNameList and mPrivateTmpUsers by getIntent is empty");
                        AppMethodBeat.m2505o(88135);
                        return;
                    }
                    List asList = Arrays.asList(this.kgQ.split(","));
                    this.kgT = C38736l.m65724bl(asList);
                    this.kgS = C38736l.m65723bk(asList);
                    if (this.kgR != null && this.kgR.length() > 0) {
                        this.kgS.addAll(Arrays.asList(this.kgR.split(",")));
                    }
                    if (this.kgT != null) {
                        C4990ab.m7416i("MicroMsg.CardConsumeSuccessUI", "mPrivateIdsList size is " + this.kgT.size());
                    }
                    if (this.kgS != null) {
                        C4990ab.m7416i("MicroMsg.CardConsumeSuccessUI", "mPrivateNamesList size is " + this.kgS.size());
                        Iterator it = this.kgS.iterator();
                        while (it.hasNext()) {
                            C4990ab.m7411d("MicroMsg.CardConsumeSuccessUI", "username : %s", (String) it.next());
                        }
                    }
                    if (this.kgP == 2) {
                        this.kgG.setVisibility(0);
                        this.kgG.setText(getString(C25738R.string.ah_, new Object[]{bbF()}));
                        AppMethodBeat.m2505o(88135);
                        return;
                    } else if (this.kgP == 3) {
                        this.kgG.setVisibility(0);
                        this.kgG.setText(getString(C25738R.string.ah9, new Object[]{bbF()}));
                        AppMethodBeat.m2505o(88135);
                        return;
                    } else {
                        this.kgG.setVisibility(8);
                        AppMethodBeat.m2505o(88135);
                        return;
                    }
                }
                AppMethodBeat.m2505o(88135);
                return;
        }
        AppMethodBeat.m2505o(88135);
    }

    private String bbF() {
        AppMethodBeat.m2504i(88136);
        String str;
        if (!TextUtils.isEmpty(this.kgQ) && !TextUtils.isEmpty(this.kgR)) {
            str = this.kgQ + "," + C38736l.m65704Hq(this.kgR);
            AppMethodBeat.m2505o(88136);
            return str;
        } else if (!TextUtils.isEmpty(this.kgQ)) {
            str = this.kgQ;
            AppMethodBeat.m2505o(88136);
            return str;
        } else if (TextUtils.isEmpty(this.kgR)) {
            str = "";
            AppMethodBeat.m2505o(88136);
            return str;
        } else {
            str = C38736l.m65704Hq(this.kgR);
            AppMethodBeat.m2505o(88136);
            return str;
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(88126);
        C1720g.m3535RO().eJo.mo14546b(902, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(910, (C1202f) this);
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (TextUtils.isEmpty(this.kaE)) {
            C7060h.pYm.mo8381e(13219, "CardConsumeSuccessUI", Integer.valueOf(this.kgN), this.kbQ, this.kgL, Long.valueOf(currentTimeMillis));
        } else {
            C7060h.pYm.mo8381e(13219, "CardConsumeSuccessUI", Integer.valueOf(this.kgN), this.kbQ, this.kaE, Long.valueOf(currentTimeMillis));
        }
        super.onDestroy();
        AppMethodBeat.m2505o(88126);
    }

    private void bbE() {
        AppMethodBeat.m2504i(88129);
        this.mController.contentView.setBackgroundColor(getResources().getColor(C25738R.color.f11834ir));
        findViewById(2131821993).setVisibility(4);
        AppMethodBeat.m2505o(88129);
    }

    /* renamed from: a */
    static /* synthetic */ void m31186a(CardConsumeSuccessUI cardConsumeSuccessUI) {
        AppMethodBeat.m2504i(88138);
        if (cardConsumeSuccessUI.kgK == null || cardConsumeSuccessUI.kgK.ckx == null || cardConsumeSuccessUI.kgK.ckx.isEmpty()) {
            C4990ab.m7412e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list == null || mConsumedInfo.list.isEmpty()!");
            AppMethodBeat.m2505o(88138);
            return;
        }
        String str;
        C1207m c42858g;
        cardConsumeSuccessUI.m31191fE(true);
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < cardConsumeSuccessUI.kgK.ckx.size(); i++) {
            C44151oi c44151oi = ((C42860q) cardConsumeSuccessUI.kgK.ckx.get(i)).kcY;
            byx byx = new byx();
            if (c44151oi != null) {
                byx.kbU = c44151oi.kbU;
                cardConsumeSuccessUI.kbQ = c44151oi.kbU;
            }
            byx.cMD = ((C42860q) cardConsumeSuccessUI.kgK.ckx.get(i)).cMD;
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
        bzm a = C38736l.m65710a(cardConsumeSuccessUI.kgP, cardConsumeSuccessUI.kgS, cardConsumeSuccessUI.kgT);
        if (cardConsumeSuccessUI.kgJ.isChecked()) {
            c42858g = new C42858g(0, linkedList, cardConsumeSuccessUI.kgK.kfF, str, a, 20, null);
        } else {
            c42858g = new C42858g(0, linkedList, "", str, a, 20, null);
        }
        if (cardConsumeSuccessUI.kgJ != null && cardConsumeSuccessUI.kgJ.getVisibility() == 0) {
            if (cardConsumeSuccessUI.kgJ.isChecked()) {
                C7060h.pYm.mo8381e(11324, "CardConsumeSuccessFollowServices", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "");
            } else {
                C7060h.pYm.mo8381e(11324, "CardConsumeSuccessView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "");
            }
        }
        C1720g.m3535RO().eJo.mo14541a(c42858g, 0);
        AppMethodBeat.m2505o(88138);
    }
}
