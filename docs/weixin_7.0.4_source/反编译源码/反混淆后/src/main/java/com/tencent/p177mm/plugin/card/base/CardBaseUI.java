package com.tencent.p177mm.plugin.card.base;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.modelstat.C18698o;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.card.model.C33771n.C11290a;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.model.C45783ad;
import com.tencent.p177mm.plugin.card.model.C45784af;
import com.tencent.p177mm.plugin.card.model.C45788x;
import com.tencent.p177mm.plugin.card.model.C6817r;
import com.tencent.p177mm.plugin.card.model.CardInfo;
import com.tencent.p177mm.plugin.card.p352b.C27567b;
import com.tencent.p177mm.plugin.card.p355ui.C11334c;
import com.tencent.p177mm.plugin.card.p355ui.C33786d;
import com.tencent.p177mm.plugin.card.p355ui.C38771g;
import com.tencent.p177mm.plugin.card.p355ui.C45796h;
import com.tencent.p177mm.plugin.card.p355ui.CardDetailUI;
import com.tencent.p177mm.plugin.card.p931d.C42840d;
import com.tencent.p177mm.plugin.card.p931d.C42840d.C27574a;
import com.tencent.p177mm.plugin.card.p931d.C45774b;
import com.tencent.p177mm.plugin.card.sharecard.model.C20152b;
import com.tencent.p177mm.plugin.card.sharecard.p354ui.C20161c;
import com.tencent.p177mm.plugin.card.sharecard.p354ui.C33779d;
import com.tencent.p177mm.plugin.card.sharecard.p354ui.C38754g;
import com.tencent.p177mm.plugin.card.sharecard.p354ui.C38755h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C23282t.C23281a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.protocal.protobuf.C35938no;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.card.base.CardBaseUI */
public abstract class CardBaseUI extends MMActivity implements C1202f, C5186a {
    private float ecs = -85.0f;
    private float ect = -1000.0f;
    private C42206a ecy = new C337617();
    private C44275p ejZ = null;
    public C26443d fwu;
    private boolean fwx = false;
    protected ListView kam = null;
    public BaseAdapter kan = null;
    protected RelativeLayout kao = null;
    protected LinearLayout kap;
    protected LinearLayout kaq;
    public boolean kar = false;
    protected boolean kas = true;
    public C20128a kat = null;
    protected CardInfo kau;

    /* renamed from: com.tencent.mm.plugin.card.base.CardBaseUI$2 */
    class C201262 implements OnItemClickListener {
        C201262() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(87618);
            if (i == 0) {
                C4990ab.m7416i("MicroMsg.CardBaseUI", "onItemClick pos is 0, onListHeaderItemClick()");
                AppMethodBeat.m2505o(87618);
                return;
            }
            if (i > 0) {
                i--;
            }
            if (i >= CardBaseUI.this.kan.getCount()) {
                AppMethodBeat.m2505o(87618);
                return;
            }
            CardBaseUI.this.mo45440b(CardBaseUI.this.kat.mo35381sM(i), i);
            AppMethodBeat.m2505o(87618);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.base.CardBaseUI$3 */
    class C275703 implements OnItemLongClickListener {
        C275703() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(87619);
            if (i == 0) {
                C4990ab.m7416i("MicroMsg.CardBaseUI", "onItemLongClick pos is 0");
                AppMethodBeat.m2505o(87619);
            } else {
                if (i > 0) {
                    i--;
                }
                if (i >= CardBaseUI.this.kan.getCount()) {
                    AppMethodBeat.m2505o(87619);
                } else {
                    CardBaseUI.this.mo45433a(CardBaseUI.this.kat.mo35381sM(i));
                    AppMethodBeat.m2505o(87619);
                }
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.base.CardBaseUI$1 */
    class C337571 implements OnMenuItemClickListener {
        C337571() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(87617);
            CardBaseUI.this.finish();
            AppMethodBeat.m2505o(87617);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.base.CardBaseUI$8 */
    class C337608 implements OnClickListener {
        C337608() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(87624);
            CardBaseUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(87624);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.base.CardBaseUI$7 */
    class C337617 implements C42206a {
        C337617() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(87623);
            if (z) {
                if (!(f2 == -85.0f || f == -1000.0f)) {
                    CardBaseUI.this.ecs = f2;
                    CardBaseUI.this.ect = f;
                    C42852am.bbc().mo15081O(CardBaseUI.this.ecs, CardBaseUI.this.ect);
                    CardBaseUI.this.aZw();
                }
                if (!CardBaseUI.this.fwx) {
                    CardBaseUI.this.fwx = true;
                    C18698o.m29222a(2010, f, f2, (int) d2);
                }
                AppMethodBeat.m2505o(87623);
                return false;
            }
            CardBaseUI.this.aZx();
            AppMethodBeat.m2505o(87623);
            return true;
        }
    }

    public abstract void aZp();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onResume() {
        super.onResume();
        this.kas = true;
        C1720g.m3535RO().eJo.mo14539a(652, (C1202f) this);
    }

    public void onPause() {
        super.onPause();
        this.kas = false;
        C1720g.m3535RO().eJo.mo14546b(652, (C1202f) this);
    }

    public void initView() {
        C20128a c33786d;
        setBackBtn(new C337571());
        this.kam = (ListView) findViewById(16908298);
        this.kao = (RelativeLayout) findViewById(2131821926);
        if (this.kao != null) {
            this.kam.setEmptyView(this.kao);
        }
        this.kap = (LinearLayout) View.inflate(getBaseContext(), 2130968951, null);
        this.kaq = (LinearLayout) View.inflate(getBaseContext(), 2130968948, null);
        this.kam.addHeaderView(this.kap);
        this.kam.addFooterView(this.kaq);
        this.kan = mo35412Kw();
        this.kam.setAdapter(this.kan);
        this.kam.setOnItemClickListener(new C201262());
        this.kam.setOnItemLongClickListener(new C275703());
        C1720g.m3535RO().eJo.mo14539a(560, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(692, (C1202f) this);
        BaseAdapter baseAdapter = this.kan;
        Object c33786d2;
        if (baseAdapter instanceof C11334c) {
            c33786d2 = new C33786d((C11334c) baseAdapter);
        } else if (baseAdapter instanceof C20161c) {
            c33786d2 = new C33779d((C20161c) baseAdapter);
        } else if (baseAdapter instanceof C38754g) {
            c33786d2 = new C38755h((C38754g) baseAdapter);
        } else {
            c33786d2 = new C45796h((C38771g) baseAdapter);
        }
        this.kat = c33786d2;
        this.kat.onCreate();
        aZp();
    }

    public int getLayoutId() {
        return 2130968943;
    }

    public void onDestroy() {
        C4990ab.m7410d("MicroMsg.CardBaseUI", "destroy card");
        C1720g.m3535RO().eJo.mo14546b(560, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(692, (C1202f) this);
        if (this.kat != null) {
            this.kat.onDestroy();
        }
        super.onDestroy();
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo45434a(C42837b c42837b, int i) {
        Intent intent = new Intent(this, CardDetailUI.class);
        intent.putExtra("key_card_id", c42837b.aZZ());
        intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        intent.putExtra("key_from_scene", 3);
        startActivity(intent);
        if (aZq() == C11290a.HOME_MEMBER_CARD_TYPE) {
            C7060h.pYm.mo8381e(11324, "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0));
            int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_HOME_PAGE_CARD_NUM_INT_SYNC, Integer.valueOf(3))).intValue();
            C7060h.pYm.mo8381e(15767, Integer.valueOf(intValue), Integer.valueOf(i + 1));
        } else if (aZq() == C11290a.MEMBER_CARD_TYPE) {
            C7060h.pYm.mo8381e(11324, "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0));
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: fE */
    public final void mo54298fE(boolean z) {
        if (z) {
            this.ejZ = C44275p.m79966b(this, getString(C25738R.string.f9260un), true, null);
        } else if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
            this.ejZ = null;
        }
    }

    /* renamed from: H */
    public final void mo54293H(LinkedList<String> linkedList) {
        mo54298fE(true);
        C1720g.m3535RO().eJo.mo14541a(new C6817r(linkedList), 0);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        int i3;
        String str2;
        if (i != 0 || i2 != 0) {
            mo54298fE(false);
            if (c1207m instanceof C45784af) {
                i3 = ((C45784af) c1207m).kdT;
                str2 = ((C45784af) c1207m).kdU;
                if (i3 == Downloads.MIN_WAIT_FOR_NETWORK) {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = getString(C25738R.string.ae6);
                    }
                    str = str2;
                }
            }
            if (!(c1207m instanceof C45788x) && !(c1207m instanceof C45783ad) && !(c1207m instanceof C20152b) && this.kas) {
                C42840d.m76037b(this, str, i2);
            }
        } else if (c1207m instanceof C6817r) {
            mo54298fE(false);
            C30379h.m48465bQ(this, getResources().getString(C25738R.string.adi));
            C42852am.baV();
            C27567b.m43779sO(4);
            this.kat.mo35378ZZ();
            aZz();
        } else if (c1207m instanceof C45784af) {
            mo54298fE(false);
            i3 = ((C45784af) c1207m).kdT;
            str2 = ((C45784af) c1207m).kdU;
            if (i3 == Downloads.MIN_WAIT_FOR_NETWORK) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = getString(C25738R.string.ae6);
                }
                C42840d.m76037b(this, str2, i3);
                return;
            }
            if (this.kau != null) {
                C35938no aZW = this.kau.aZW();
                aZW.status = 3;
                this.kau.mo45388a(aZW);
                if (!C42852am.baW().mo10103c(this.kau, new String[0])) {
                    C4990ab.m7413e("MicroMsg.CardBaseUI", "update newSerial fail, cardId = %s", this.kau.field_card_id);
                }
            }
            this.kat.mo35378ZZ();
            aZz();
        }
    }

    /* Access modifiers changed, original: protected */
    public C11290a aZq() {
        return C11290a.NORMAL_TYPE;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: Kw */
    public BaseAdapter mo35412Kw() {
        return new C11334c(this, aZq());
    }

    /* Access modifiers changed, original: protected */
    public boolean aZr() {
        return true;
    }

    /* Access modifiers changed, original: protected */
    public boolean aZs() {
        return true;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo45440b(C42837b c42837b, int i) {
        if (!aZr()) {
            C4990ab.m7412e("MicroMsg.CardBaseUI", "isItemClickable return false");
        } else if (c42837b == null) {
            C4990ab.m7412e("MicroMsg.CardBaseUI", "onListItemClick  item == null");
        } else if (!c42837b.aZZ().equals("PRIVATE_TICKET_TITLE") && !c42837b.aZZ().equals("PRIVATE_INVOICE_TITLE")) {
            if (c42837b.aZI()) {
                mo45434a(c42837b, i);
            } else if (!TextUtils.isEmpty(c42837b.aZV().vUc)) {
                C45774b.m84626a((MMActivity) this, c42837b.aZV().vUc, 0);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo45433a(final C42837b c42837b) {
        if (!aZs()) {
            C4990ab.m7412e("MicroMsg.CardBaseUI", "isItemClickable return false");
        } else if (c42837b == null) {
            C4990ab.m7412e("MicroMsg.CardBaseUI", "onListItemLongClick  item == null");
        } else {
            ArrayList arrayList = new ArrayList();
            if (c42837b.aZJ()) {
                if (!C5046bo.isNullOrNil(c42837b.aZV().vUI)) {
                    arrayList.add(c42837b.aZV().vUI);
                } else if (c42837b.aZH()) {
                    arrayList.add(getResources().getString(C25738R.string.ag2));
                } else {
                    arrayList.add(getResources().getString(C25738R.string.ag1));
                }
            }
            arrayList.add(getResources().getString(C25738R.string.f9088p4));
            final String aZZ = c42837b.aZZ();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(c42837b.aZV().kdf);
            C30379h.m48422a((Context) this, stringBuilder.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), null, new C30391c() {
                /* renamed from: iE */
                public final void mo7700iE(int i) {
                    AppMethodBeat.m2504i(87621);
                    if (c42837b.aZJ()) {
                        switch (i) {
                            case 0:
                                CardBaseUI.this.mo54294a((CardInfo) c42837b);
                                AppMethodBeat.m2505o(87621);
                                return;
                            case 1:
                                C42840d.m76035a(CardBaseUI.this, aZZ, "", new C27574a(aZZ) {
                                    public final void aZA() {
                                        AppMethodBeat.m2504i(87620);
                                        CardBaseUI.m55162a(CardBaseUI.this, r3);
                                        AppMethodBeat.m2505o(87620);
                                    }
                                });
                                AppMethodBeat.m2505o(87621);
                                return;
                            default:
                                AppMethodBeat.m2505o(87621);
                                return;
                        }
                    }
                    switch (i) {
                        case 0:
                            C42840d.m76035a(CardBaseUI.this, aZZ, "", /* anonymous class already generated */);
                            break;
                    }
                    AppMethodBeat.m2505o(87621);
                }
            });
        }
    }

    /* renamed from: c */
    public final void mo6069c(int i, int i2, Intent intent) {
        if (i == 0 && i2 == -1) {
            mo54299l(intent.getStringExtra("Select_Conv_User"), 0, false);
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo54294a(CardInfo cardInfo) {
        this.kau = cardInfo;
        C45774b.m84623a((MMActivity) this, 0, (C5186a) this);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: l */
    public final void mo54299l(final String str, int i, final boolean z) {
        if (this.kau == null) {
            C4990ab.m7412e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo == null");
        } else if (this.kau.aZV() == null) {
            C4990ab.m7412e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            if (i == 0) {
                if (TextUtils.isEmpty(this.kau.aZX().wYl) || this.kau.aZH()) {
                    stringBuilder.append(getString(C25738R.string.ens));
                } else {
                    stringBuilder.append(this.kau.aZX().wYl);
                }
                C7060h.pYm.mo8381e(11582, "OperGift", Integer.valueOf(2), Integer.valueOf(this.kau.aZV().iAd), this.kau.field_card_tp_id, this.kau.field_card_id, str);
            } else if (i == 1) {
                stringBuilder.append(getString(C25738R.string.ae5, new Object[]{this.kau.aZV().kdf}));
                C7060h.pYm.mo8381e(11582, "OperGift", Integer.valueOf(3), Integer.valueOf(this.kau.aZV().iAd), this.kau.field_card_tp_id, this.kau.field_card_id, str);
            }
            C23281a.vlq.mo30687a(this.mController, stringBuilder.toString(), this.kau.aZV().kbV, this.kau.aZV().title + IOUtils.LINE_SEPARATOR_UNIX + this.kau.aZV().kdg, false, getResources().getString(C25738R.string.f9221tf), new C30111a() {
                /* renamed from: a */
                public final void mo6399a(boolean z, String str, int i) {
                    AppMethodBeat.m2504i(87622);
                    if (z) {
                        CardBaseUI.m55166c(CardBaseUI.this, str);
                        C30379h.m48465bQ(CardBaseUI.this, CardBaseUI.this.getResources().getString(C25738R.string.aeq));
                        if (z) {
                            CardBaseUI.this.finish();
                        }
                    }
                    AppMethodBeat.m2505o(87622);
                }
            });
        }
    }

    public final void aZt() {
        if (this.fwu == null) {
            this.fwu = C26443d.agz();
        }
        if (this.fwu != null) {
            this.fwu.mo44204a(this.ecy, true);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void aZu() {
        if (this.fwu != null) {
            this.fwu.mo44204a(this.ecy, true);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void aZv() {
        if (this.fwu != null) {
            this.fwu.mo44208c(this.ecy);
        }
    }

    /* Access modifiers changed, original: protected */
    public void aZw() {
    }

    /* Access modifiers changed, original: protected */
    public void aZx() {
    }

    /* Access modifiers changed, original: protected */
    public void aZy() {
    }

    /* Access modifiers changed, original: protected */
    public void aZz() {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.CardBaseUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            return;
        }
        C4990ab.m7417i("MicroMsg.CardBaseUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 69:
                if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dby), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.atb), false, new C337608(), null);
                    return;
                }
                aZy();
                return;
            default:
                return;
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m55166c(CardBaseUI cardBaseUI, String str) {
        cardBaseUI.mo54298fE(true);
        C1720g.m3535RO().eJo.mo14541a(new C45784af(cardBaseUI.kau.field_card_id, str, 17), 0);
    }
}
