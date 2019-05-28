package com.tencent.mm.plugin.collect.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.collect.model.a;
import com.tencent.mm.plugin.collect.model.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bci;
import com.tencent.mm.protocal.protobuf.dg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;

public class CollectBillUI extends WalletBaseUI {
    private boolean foa = false;
    private int fromScene;
    private String gmu;
    private j icA;
    private long kCc;
    private a kFK;
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
    private f kFV = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(41211);
            if (mVar instanceof com.tencent.mm.plugin.collect.model.j) {
                com.tencent.mm.plugin.collect.model.j jVar = (com.tencent.mm.plugin.collect.model.j) mVar;
                if (i == 0 && i2 == 0) {
                    LinkedList<dg> linkedList = jVar.kCi.vVS;
                    if (linkedList == null || linkedList.isEmpty()) {
                        CollectBillUI.this.kFR.setVisibility(8);
                        AppMethodBeat.o(41211);
                        return;
                    }
                    for (final dg dgVar : linkedList) {
                        if (dgVar.type == 1 && !bo.isNullOrNil(dgVar.cEh)) {
                            ab.i("MicroMsg.CollectBillUI", "show notice");
                            CollectBillUI.this.kFR.setText(dgVar.cEh);
                            CollectBillUI.this.kFR.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.i(41210);
                                    if (!bo.isNullOrNil(dgVar.url)) {
                                        e.n(CollectBillUI.this.mController.ylL, dgVar.url, true);
                                    }
                                    AppMethodBeat.o(41210);
                                }
                            });
                            CollectBillUI.this.kFR.setVisibility(0);
                            AppMethodBeat.o(41211);
                            return;
                        }
                    }
                    CollectBillUI.this.kFR.setVisibility(8);
                    AppMethodBeat.o(41211);
                    return;
                }
                ab.e("MicroMsg.CollectBillUI", "net error: %s", jVar);
                CollectBillUI.this.kFR.setVisibility(8);
            }
            AppMethodBeat.o(41211);
        }
    };
    private d kFW = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(41217);
            if (menuItem.getItemId() == 0) {
                a aVar = (a) CollectBillUI.this.kFo.getItemAtPosition(((AdapterContextMenuInfo) menuItem.getMenuInfo()).position);
                if (aVar != null) {
                    CollectBillUI.a(CollectBillUI.this, aVar.kBD, aVar.timestamp);
                }
            }
            AppMethodBeat.o(41217);
        }
    };
    private ListView kFo;
    private boolean kFw = false;
    private View kmT;
    private int limit = 20;
    private int type;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CollectBillUI() {
        AppMethodBeat.i(41218);
        AppMethodBeat.o(41218);
    }

    static /* synthetic */ void g(CollectBillUI collectBillUI) {
        AppMethodBeat.i(41228);
        collectBillUI.bhi();
        AppMethodBeat.o(41228);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41219);
        super.onCreate(bundle);
        this.kFU = r.YE();
        this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
        this.type = getIntent().getIntExtra("key_type", 0);
        this.kCc = getIntent().getLongExtra("key_timestamp", System.currentTimeMillis() / 1000);
        bhi();
        initView();
        setMMTitle((int) R.string.arl);
        g.RQ();
        g.RO().eJo.a(1256, this.kFV);
        m jVar = new com.tencent.mm.plugin.collect.model.j();
        g.RQ();
        g.RO().eJo.a(jVar, 0);
        AppMethodBeat.o(41219);
    }

    public void onDestroy() {
        AppMethodBeat.i(41220);
        super.onDestroy();
        g.RQ();
        g.RO().eJo.b(1256, this.kFV);
        AppMethodBeat.o(41220);
    }

    public final void initView() {
        AppMethodBeat.i(41221);
        this.kFo = (ListView) findViewById(R.id.axd);
        this.kFL = (LinearLayout) findViewById(R.id.axe);
        this.kFR = (TextView) findViewById(R.id.axc);
        this.kmT = v.hu(this).inflate(R.layout.oy, this.kFo, false);
        this.kFM = new CollectBillHeaderView(this);
        this.kFo.addHeaderView(this.kFM, null, false);
        this.kFK = new a(this);
        this.kFo.setAdapter(this.kFK);
        this.kFo.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AppMethodBeat.i(41212);
                if (CollectBillUI.this.kFo.getLastVisiblePosition() == CollectBillUI.this.kFK.getCount() && CollectBillUI.this.kFK.getCount() > 0 && !CollectBillUI.this.foa && !CollectBillUI.this.kFw) {
                    CollectBillUI.f(CollectBillUI.this);
                    CollectBillUI.g(CollectBillUI.this);
                }
                AppMethodBeat.o(41212);
            }
        });
        this.icA = new j(this);
        this.kFo.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(41213);
                if (i < 0 || i >= adapterView.getAdapter().getCount()) {
                    ab.i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", Integer.valueOf(i), Integer.valueOf(adapterView.getAdapter().getCount()));
                    AppMethodBeat.o(41213);
                    return;
                }
                a aVar = (a) CollectBillUI.this.kFo.getItemAtPosition(i);
                if (aVar == null) {
                    ab.w("MicroMsg.CollectBillUI", "invalid position: %d", Integer.valueOf(i));
                    AppMethodBeat.o(41213);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("scene", 2);
                intent.putExtra("trans_id", aVar.kBE);
                intent.putExtra("bill_id", aVar.kBD);
                com.tencent.mm.bp.d.b(CollectBillUI.this.mController.ylL, "order", ".ui.MallOrderTransactionInfoUI", intent);
                AppMethodBeat.o(41213);
            }
        });
        this.kFo.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(41214);
                if (i < 0 || i >= adapterView.getAdapter().getCount()) {
                    ab.i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", Integer.valueOf(i), Integer.valueOf(adapterView.getAdapter().getCount()));
                    AppMethodBeat.o(41214);
                    return false;
                }
                CollectBillUI.this.icA.a(view, i, j, CollectBillUI.this, CollectBillUI.this.kFW);
                AppMethodBeat.o(41214);
                return true;
            }
        });
        if (this.fromScene != 2) {
            addTextOptionMenu(0, getString(R.string.arh), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(41215);
                    CollectBillUI.this.startActivity(new Intent(CollectBillUI.this.mController.ylL, CollectBillListUI.class));
                    AppMethodBeat.o(41215);
                    return false;
                }
            });
        }
        if (this.fromScene == 2) {
            View findViewById = this.kFM.findViewById(R.id.axm);
            View findViewById2 = this.kFL.findViewById(R.id.axf);
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            AppMethodBeat.o(41221);
            return;
        }
        this.kFN = (ImageView) this.kFM.findViewById(R.id.aze);
        this.kFO = (MMSwitchBtn) this.kFM.findViewById(R.id.azf);
        this.kFP = (ImageView) this.kFL.findViewById(R.id.aze);
        this.kFQ = (MMSwitchBtn) this.kFL.findViewById(R.id.azf);
        com.tencent.mm.plugin.collect.a.a.bgv();
        if (com.tencent.mm.plugin.collect.a.a.bgx()) {
            this.kFO.setCheck(true);
            this.kFQ.setCheck(true);
            this.kFN.setImageResource(R.raw.collect_sound_on);
            this.kFP.setImageResource(R.raw.collect_sound_on);
        } else {
            this.kFO.setCheck(false);
            this.kFQ.setCheck(false);
            this.kFN.setImageResource(R.raw.collect_sound_off);
            this.kFP.setImageResource(R.raw.collect_sound_off);
        }
        AnonymousClass6 anonymousClass6 = new MMSwitchBtn.a() {
            public final void di(boolean z) {
                int i;
                AppMethodBeat.i(41216);
                ab.i("MicroMsg.CollectBillUI", "update switch: %B", Boolean.valueOf(z));
                CollectBillUI.this.kFO.setCheck(z);
                CollectBillUI.this.kFQ.setCheck(z);
                if (z) {
                    CollectBillUI.this.kFU = CollectBillUI.this.kFU | 32768;
                    CollectBillUI.this.kFN.setImageResource(R.raw.collect_sound_on);
                    CollectBillUI.this.kFP.setImageResource(R.raw.collect_sound_on);
                    Toast.makeText(CollectBillUI.this.mController.ylL, R.string.as6, 1).show();
                    h.pYm.e(13944, Integer.valueOf(11));
                    i = 1;
                } else {
                    CollectBillUI.this.kFU = CollectBillUI.this.kFU & -32769;
                    CollectBillUI.this.kFN.setImageResource(R.raw.collect_sound_off);
                    CollectBillUI.this.kFP.setImageResource(R.raw.collect_sound_off);
                    Toast.makeText(CollectBillUI.this.mController.ylL, R.string.arw, 1).show();
                    h.pYm.e(13944, Integer.valueOf(12));
                    i = 2;
                }
                g.RQ();
                g.RP().Ry().set(147457, Long.valueOf(CollectBillUI.this.kFU));
                bci bci = new bci();
                bci.pXD = i;
                ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(209, bci));
                if (i == 1) {
                    com.tencent.mm.plugin.collect.a.a.bgv().bgy();
                    AppMethodBeat.o(41216);
                    return;
                }
                com.tencent.mm.plugin.collect.a.a.bgv().bgz();
                AppMethodBeat.o(41216);
            }
        };
        this.kFO.setSwitchListener(anonymousClass6);
        this.kFQ.setSwitchListener(anonymousClass6);
        AppMethodBeat.o(41221);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(41222);
        contextMenu.add(0, 0, 0, R.string.ari);
        AppMethodBeat.o(41222);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(41223);
        if (mVar instanceof com.tencent.mm.plugin.collect.model.r) {
            com.tencent.mm.plugin.collect.model.r rVar = (com.tencent.mm.plugin.collect.model.r) mVar;
            if (this.kFS) {
                this.kFo.removeFooterView(this.kmT);
                this.kFS = false;
            }
            if (i == 0 && i2 == 0) {
                this.foa = rVar.foa;
                this.type = rVar.type;
                this.kCc = rVar.kCc;
                e(rVar.kCd, rVar.kCe, rVar.kCc);
                if (rVar.kCH.isEmpty()) {
                    this.foa = true;
                    if (bo.isNullOrNil(this.gmu)) {
                        ab.i("MicroMsg.CollectBillUI", "no record, show empty view");
                        aEL();
                    }
                } else {
                    if (bo.isNullOrNil(this.gmu)) {
                        ab.d("MicroMsg.CollectBillUI", "first query, hide block view");
                        this.kFo.setVisibility(0);
                        this.kFL.setVisibility(8);
                    }
                    a aVar = this.kFK;
                    aVar.kFl.addAll(rVar.kCH);
                    aVar.notifyDataSetChanged();
                    this.gmu = ((a) rVar.kCH.get(rVar.kCH.size() - 1)).kBD;
                }
                this.kFw = false;
                AppMethodBeat.o(41223);
                return true;
            }
            ab.i("MicroMsg.CollectBillUI", "net error!");
            this.kFw = false;
            Toast.makeText(this, R.string.are, 1).show();
            if (bo.isNullOrNil(this.gmu)) {
                ab.i("MicroMsg.CollectBillUI", "first query failed, finish activity!");
            }
            AppMethodBeat.o(41223);
            return true;
        } else if (mVar instanceof p) {
            p pVar = (p) mVar;
            if (i == 0 && i2 == 0) {
                a aVar2 = this.kFK;
                String str2 = pVar.kBD;
                for (a aVar3 : aVar2.kFl) {
                    if (aVar3.kBD.equals(str2)) {
                        aVar2.kFl.remove(aVar3);
                        aVar2.notifyDataSetChanged();
                        break;
                    }
                }
                if (this.kFK.getCount() <= 0) {
                    ab.i("MicroMsg.CollectBillUI", "delete all records");
                    aEL();
                } else {
                    e(pVar.kCd, pVar.kCe, this.kCc);
                }
                AppMethodBeat.o(41223);
                return false;
            }
            ab.i("MicroMsg.CollectBillUI", "net error, errType: %s, errCode: %s, errMsg: %s, billId: %s", Integer.valueOf(i), Integer.valueOf(i2), str, pVar.kBD);
            Toast.makeText(this, R.string.ard, 1).show();
            AppMethodBeat.o(41223);
            return false;
        } else {
            AppMethodBeat.o(41223);
            return false;
        }
    }

    public final int getLayoutId() {
        return R.layout.or;
    }

    private void e(int i, int i2, long j) {
        AppMethodBeat.i(41224);
        if (this.kFT) {
            this.kFM.a(i, i2, j, this.type);
            this.kFT = false;
        }
        AppMethodBeat.o(41224);
    }

    private void bhi() {
        AppMethodBeat.i(41225);
        if (!this.foa) {
            a(new com.tencent.mm.plugin.collect.model.r(this.type, this.kCc, this.gmu, this.limit), true, false);
            this.kFw = true;
        }
        AppMethodBeat.o(41225);
    }

    private void aEL() {
        AppMethodBeat.i(41226);
        this.kFo.setVisibility(8);
        this.kFL.setVisibility(0);
        findViewById(R.id.axg).setVisibility(0);
        AppMethodBeat.o(41226);
    }

    static /* synthetic */ void f(CollectBillUI collectBillUI) {
        AppMethodBeat.i(41227);
        if (!collectBillUI.kFS) {
            ab.d("MicroMsg.CollectBillUI", "show loading");
            collectBillUI.kFo.addFooterView(collectBillUI.kmT, null, false);
            collectBillUI.kFS = true;
        }
        AppMethodBeat.o(41227);
    }

    static /* synthetic */ void a(CollectBillUI collectBillUI, String str, long j) {
        AppMethodBeat.i(41229);
        ab.i("MicroMsg.CollectBillUI", "do delete, billid: %s, timestamp: %s", str, Long.valueOf(j));
        m pVar = new p(str, collectBillUI.type, j);
        collectBillUI.kFT = true;
        collectBillUI.a(pVar, true, false);
        AppMethodBeat.o(41229);
    }
}
