package com.tencent.p177mm.plugin.collect.p368ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn.C30795a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.collect.model.C20263a;
import com.tencent.p177mm.plugin.collect.model.C20265j;
import com.tencent.p177mm.plugin.collect.model.C27679r;
import com.tencent.p177mm.plugin.collect.model.C33861p;
import com.tencent.p177mm.plugin.collect.p1481a.C45815a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C23381dg;
import com.tencent.p177mm.protocal.protobuf.bci;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.collect.ui.CollectBillUI */
public class CollectBillUI extends WalletBaseUI {
    private boolean foa = false;
    private int fromScene;
    private String gmu;
    private C46696j icA;
    private long kCc;
    private C38822a kFK;
    private LinearLayout kFL;
    private CollectBillHeaderView kFM;
    private ImageView kFN;
    private MMSwitchBtn kFO;
    private ImageView kFP;
    private MMSwitchBtn kFQ;
    private TextView kFR;
    private boolean kFS = false;
    private boolean kFT = true;
    private long kFU;
    private C1202f kFV = new C247331();
    private C5279d kFW = new C247347();
    private ListView kFo;
    private boolean kFw = false;
    private View kmT;
    private int limit = 20;
    private int type;

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectBillUI$2 */
    class C114512 implements OnScrollListener {
        C114512() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AppMethodBeat.m2504i(41212);
            if (CollectBillUI.this.kFo.getLastVisiblePosition() == CollectBillUI.this.kFK.getCount() && CollectBillUI.this.kFK.getCount() > 0 && !CollectBillUI.this.foa && !CollectBillUI.this.kFw) {
                CollectBillUI.m38605f(CollectBillUI.this);
                CollectBillUI.m38606g(CollectBillUI.this);
            }
            AppMethodBeat.m2505o(41212);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectBillUI$3 */
    class C114523 implements OnItemClickListener {
        C114523() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(41213);
            if (i < 0 || i >= adapterView.getAdapter().getCount()) {
                C4990ab.m7417i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", Integer.valueOf(i), Integer.valueOf(adapterView.getAdapter().getCount()));
                AppMethodBeat.m2505o(41213);
                return;
            }
            C20263a c20263a = (C20263a) CollectBillUI.this.kFo.getItemAtPosition(i);
            if (c20263a == null) {
                C4990ab.m7421w("MicroMsg.CollectBillUI", "invalid position: %d", Integer.valueOf(i));
                AppMethodBeat.m2505o(41213);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("scene", 2);
            intent.putExtra("trans_id", c20263a.kBE);
            intent.putExtra("bill_id", c20263a.kBD);
            C25985d.m41467b(CollectBillUI.this.mController.ylL, "order", ".ui.MallOrderTransactionInfoUI", intent);
            AppMethodBeat.m2505o(41213);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectBillUI$5 */
    class C202795 implements OnMenuItemClickListener {
        C202795() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(41215);
            CollectBillUI.this.startActivity(new Intent(CollectBillUI.this.mController.ylL, CollectBillListUI.class));
            AppMethodBeat.m2505o(41215);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectBillUI$4 */
    class C247314 implements OnItemLongClickListener {
        C247314() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(41214);
            if (i < 0 || i >= adapterView.getAdapter().getCount()) {
                C4990ab.m7417i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", Integer.valueOf(i), Integer.valueOf(adapterView.getAdapter().getCount()));
                AppMethodBeat.m2505o(41214);
                return false;
            }
            CollectBillUI.this.icA.mo75004a(view, i, j, CollectBillUI.this, CollectBillUI.this.kFW);
            AppMethodBeat.m2505o(41214);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectBillUI$6 */
    class C247326 implements C30795a {
        C247326() {
        }

        /* renamed from: di */
        public final void mo6646di(boolean z) {
            int i;
            AppMethodBeat.m2504i(41216);
            C4990ab.m7417i("MicroMsg.CollectBillUI", "update switch: %B", Boolean.valueOf(z));
            CollectBillUI.this.kFO.setCheck(z);
            CollectBillUI.this.kFQ.setCheck(z);
            if (z) {
                CollectBillUI.this.kFU = CollectBillUI.this.kFU | 32768;
                CollectBillUI.this.kFN.setImageResource(C1318a.collect_sound_on);
                CollectBillUI.this.kFP.setImageResource(C1318a.collect_sound_on);
                Toast.makeText(CollectBillUI.this.mController.ylL, C25738R.string.as6, 1).show();
                C7060h.pYm.mo8381e(13944, Integer.valueOf(11));
                i = 1;
            } else {
                CollectBillUI.this.kFU = CollectBillUI.this.kFU & -32769;
                CollectBillUI.this.kFN.setImageResource(C1318a.collect_sound_off);
                CollectBillUI.this.kFP.setImageResource(C1318a.collect_sound_off);
                Toast.makeText(CollectBillUI.this.mController.ylL, C25738R.string.arw, 1).show();
                C7060h.pYm.mo8381e(13944, Integer.valueOf(12));
                i = 2;
            }
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(147457, Long.valueOf(CollectBillUI.this.kFU));
            bci bci = new bci();
            bci.pXD = i;
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(209, bci));
            if (i == 1) {
                C45815a.bgv().bgy();
                AppMethodBeat.m2505o(41216);
                return;
            }
            C45815a.bgv().bgz();
            AppMethodBeat.m2505o(41216);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectBillUI$1 */
    class C247331 implements C1202f {
        C247331() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(41211);
            if (c1207m instanceof C20265j) {
                C20265j c20265j = (C20265j) c1207m;
                if (i == 0 && i2 == 0) {
                    LinkedList<C23381dg> linkedList = c20265j.kCi.vVS;
                    if (linkedList == null || linkedList.isEmpty()) {
                        CollectBillUI.this.kFR.setVisibility(8);
                        AppMethodBeat.m2505o(41211);
                        return;
                    }
                    for (final C23381dg c23381dg : linkedList) {
                        if (c23381dg.type == 1 && !C5046bo.isNullOrNil(c23381dg.cEh)) {
                            C4990ab.m7416i("MicroMsg.CollectBillUI", "show notice");
                            CollectBillUI.this.kFR.setText(c23381dg.cEh);
                            CollectBillUI.this.kFR.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.m2504i(41210);
                                    if (!C5046bo.isNullOrNil(c23381dg.url)) {
                                        C36391e.m60016n(CollectBillUI.this.mController.ylL, c23381dg.url, true);
                                    }
                                    AppMethodBeat.m2505o(41210);
                                }
                            });
                            CollectBillUI.this.kFR.setVisibility(0);
                            AppMethodBeat.m2505o(41211);
                            return;
                        }
                    }
                    CollectBillUI.this.kFR.setVisibility(8);
                    AppMethodBeat.m2505o(41211);
                    return;
                }
                C4990ab.m7413e("MicroMsg.CollectBillUI", "net error: %s", c20265j);
                CollectBillUI.this.kFR.setVisibility(8);
            }
            AppMethodBeat.m2505o(41211);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.CollectBillUI$7 */
    class C247347 implements C5279d {
        C247347() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(41217);
            if (menuItem.getItemId() == 0) {
                C20263a c20263a = (C20263a) CollectBillUI.this.kFo.getItemAtPosition(((AdapterContextMenuInfo) menuItem.getMenuInfo()).position);
                if (c20263a != null) {
                    CollectBillUI.m38599a(CollectBillUI.this, c20263a.kBD, c20263a.timestamp);
                }
            }
            AppMethodBeat.m2505o(41217);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public CollectBillUI() {
        AppMethodBeat.m2504i(41218);
        AppMethodBeat.m2505o(41218);
    }

    /* renamed from: g */
    static /* synthetic */ void m38606g(CollectBillUI collectBillUI) {
        AppMethodBeat.m2504i(41228);
        collectBillUI.bhi();
        AppMethodBeat.m2505o(41228);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41219);
        super.onCreate(bundle);
        this.kFU = C1853r.m3823YE();
        this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
        this.type = getIntent().getIntExtra("key_type", 0);
        this.kCc = getIntent().getLongExtra("key_timestamp", System.currentTimeMillis() / 1000);
        bhi();
        initView();
        setMMTitle((int) C25738R.string.arl);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(1256, this.kFV);
        C1207m c20265j = new C20265j();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c20265j, 0);
        AppMethodBeat.m2505o(41219);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(41220);
        super.onDestroy();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(1256, this.kFV);
        AppMethodBeat.m2505o(41220);
    }

    public final void initView() {
        AppMethodBeat.m2504i(41221);
        this.kFo = (ListView) findViewById(2131822815);
        this.kFL = (LinearLayout) findViewById(2131822816);
        this.kFR = (TextView) findViewById(2131822814);
        this.kmT = C5616v.m8409hu(this).inflate(2130969157, this.kFo, false);
        this.kFM = new CollectBillHeaderView(this);
        this.kFo.addHeaderView(this.kFM, null, false);
        this.kFK = new C38822a(this);
        this.kFo.setAdapter(this.kFK);
        this.kFo.setOnScrollListener(new C114512());
        this.icA = new C46696j(this);
        this.kFo.setOnItemClickListener(new C114523());
        this.kFo.setOnItemLongClickListener(new C247314());
        if (this.fromScene != 2) {
            addTextOptionMenu(0, getString(C25738R.string.arh), new C202795());
        }
        if (this.fromScene == 2) {
            View findViewById = this.kFM.findViewById(2131822824);
            View findViewById2 = this.kFL.findViewById(2131822817);
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            AppMethodBeat.m2505o(41221);
            return;
        }
        this.kFN = (ImageView) this.kFM.findViewById(2131822890);
        this.kFO = (MMSwitchBtn) this.kFM.findViewById(2131822891);
        this.kFP = (ImageView) this.kFL.findViewById(2131822890);
        this.kFQ = (MMSwitchBtn) this.kFL.findViewById(2131822891);
        C45815a.bgv();
        if (C45815a.bgx()) {
            this.kFO.setCheck(true);
            this.kFQ.setCheck(true);
            this.kFN.setImageResource(C1318a.collect_sound_on);
            this.kFP.setImageResource(C1318a.collect_sound_on);
        } else {
            this.kFO.setCheck(false);
            this.kFQ.setCheck(false);
            this.kFN.setImageResource(C1318a.collect_sound_off);
            this.kFP.setImageResource(C1318a.collect_sound_off);
        }
        C247326 c247326 = new C247326();
        this.kFO.setSwitchListener(c247326);
        this.kFQ.setSwitchListener(c247326);
        AppMethodBeat.m2505o(41221);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(41222);
        contextMenu.add(0, 0, 0, C25738R.string.ari);
        AppMethodBeat.m2505o(41222);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(41223);
        if (c1207m instanceof C27679r) {
            C27679r c27679r = (C27679r) c1207m;
            if (this.kFS) {
                this.kFo.removeFooterView(this.kmT);
                this.kFS = false;
            }
            if (i == 0 && i2 == 0) {
                this.foa = c27679r.foa;
                this.type = c27679r.type;
                this.kCc = c27679r.kCc;
                m38603e(c27679r.kCd, c27679r.kCe, c27679r.kCc);
                if (c27679r.kCH.isEmpty()) {
                    this.foa = true;
                    if (C5046bo.isNullOrNil(this.gmu)) {
                        C4990ab.m7416i("MicroMsg.CollectBillUI", "no record, show empty view");
                        aEL();
                    }
                } else {
                    if (C5046bo.isNullOrNil(this.gmu)) {
                        C4990ab.m7410d("MicroMsg.CollectBillUI", "first query, hide block view");
                        this.kFo.setVisibility(0);
                        this.kFL.setVisibility(8);
                    }
                    C38822a c38822a = this.kFK;
                    c38822a.kFl.addAll(c27679r.kCH);
                    c38822a.notifyDataSetChanged();
                    this.gmu = ((C20263a) c27679r.kCH.get(c27679r.kCH.size() - 1)).kBD;
                }
                this.kFw = false;
                AppMethodBeat.m2505o(41223);
                return true;
            }
            C4990ab.m7416i("MicroMsg.CollectBillUI", "net error!");
            this.kFw = false;
            Toast.makeText(this, C25738R.string.are, 1).show();
            if (C5046bo.isNullOrNil(this.gmu)) {
                C4990ab.m7416i("MicroMsg.CollectBillUI", "first query failed, finish activity!");
            }
            AppMethodBeat.m2505o(41223);
            return true;
        } else if (c1207m instanceof C33861p) {
            C33861p c33861p = (C33861p) c1207m;
            if (i == 0 && i2 == 0) {
                C38822a c38822a2 = this.kFK;
                String str2 = c33861p.kBD;
                for (C20263a c20263a : c38822a2.kFl) {
                    if (c20263a.kBD.equals(str2)) {
                        c38822a2.kFl.remove(c20263a);
                        c38822a2.notifyDataSetChanged();
                        break;
                    }
                }
                if (this.kFK.getCount() <= 0) {
                    C4990ab.m7416i("MicroMsg.CollectBillUI", "delete all records");
                    aEL();
                } else {
                    m38603e(c33861p.kCd, c33861p.kCe, this.kCc);
                }
                AppMethodBeat.m2505o(41223);
                return false;
            }
            C4990ab.m7417i("MicroMsg.CollectBillUI", "net error, errType: %s, errCode: %s, errMsg: %s, billId: %s", Integer.valueOf(i), Integer.valueOf(i2), str, c33861p.kBD);
            Toast.makeText(this, C25738R.string.ard, 1).show();
            AppMethodBeat.m2505o(41223);
            return false;
        } else {
            AppMethodBeat.m2505o(41223);
            return false;
        }
    }

    public final int getLayoutId() {
        return 2130969150;
    }

    /* renamed from: e */
    private void m38603e(int i, int i2, long j) {
        AppMethodBeat.m2504i(41224);
        if (this.kFT) {
            this.kFM.mo54416a(i, i2, j, this.type);
            this.kFT = false;
        }
        AppMethodBeat.m2505o(41224);
    }

    private void bhi() {
        AppMethodBeat.m2504i(41225);
        if (!this.foa) {
            mo39970a(new C27679r(this.type, this.kCc, this.gmu, this.limit), true, false);
            this.kFw = true;
        }
        AppMethodBeat.m2505o(41225);
    }

    private void aEL() {
        AppMethodBeat.m2504i(41226);
        this.kFo.setVisibility(8);
        this.kFL.setVisibility(0);
        findViewById(2131822818).setVisibility(0);
        AppMethodBeat.m2505o(41226);
    }

    /* renamed from: f */
    static /* synthetic */ void m38605f(CollectBillUI collectBillUI) {
        AppMethodBeat.m2504i(41227);
        if (!collectBillUI.kFS) {
            C4990ab.m7410d("MicroMsg.CollectBillUI", "show loading");
            collectBillUI.kFo.addFooterView(collectBillUI.kmT, null, false);
            collectBillUI.kFS = true;
        }
        AppMethodBeat.m2505o(41227);
    }

    /* renamed from: a */
    static /* synthetic */ void m38599a(CollectBillUI collectBillUI, String str, long j) {
        AppMethodBeat.m2504i(41229);
        C4990ab.m7417i("MicroMsg.CollectBillUI", "do delete, billid: %s, timestamp: %s", str, Long.valueOf(j));
        C1207m c33861p = new C33861p(str, collectBillUI.type, j);
        collectBillUI.kFT = true;
        collectBillUI.mo39970a(c33861p, true, false);
        AppMethodBeat.m2505o(41229);
    }
}
