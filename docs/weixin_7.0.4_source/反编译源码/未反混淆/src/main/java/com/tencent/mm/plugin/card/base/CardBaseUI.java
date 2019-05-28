package com.tencent.mm.plugin.card.base;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.plugin.card.model.x;
import com.tencent.mm.plugin.card.sharecard.ui.h;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.card.ui.c;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.pluginsdk.ui.applet.t;
import com.tencent.mm.protocal.protobuf.no;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.p;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class CardBaseUI extends MMActivity implements f, a {
    private float ecs = -85.0f;
    private float ect = -1000.0f;
    private b.a ecy = new b.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.i(87623);
            if (z) {
                if (!(f2 == -85.0f || f == -1000.0f)) {
                    CardBaseUI.this.ecs = f2;
                    CardBaseUI.this.ect = f;
                    am.bbc().O(CardBaseUI.this.ecs, CardBaseUI.this.ect);
                    CardBaseUI.this.aZw();
                }
                if (!CardBaseUI.this.fwx) {
                    CardBaseUI.this.fwx = true;
                    o.a(2010, f, f2, (int) d2);
                }
                AppMethodBeat.o(87623);
                return false;
            }
            CardBaseUI.this.aZx();
            AppMethodBeat.o(87623);
            return true;
        }
    };
    private p ejZ = null;
    public d fwu;
    private boolean fwx = false;
    protected ListView kam = null;
    public BaseAdapter kan = null;
    protected RelativeLayout kao = null;
    protected LinearLayout kap;
    protected LinearLayout kaq;
    public boolean kar = false;
    protected boolean kas = true;
    public a kat = null;
    protected CardInfo kau;

    public abstract void aZp();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onResume() {
        super.onResume();
        this.kas = true;
        g.RO().eJo.a(652, (f) this);
    }

    public void onPause() {
        super.onPause();
        this.kas = false;
        g.RO().eJo.b(652, (f) this);
    }

    public void initView() {
        a dVar;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(87617);
                CardBaseUI.this.finish();
                AppMethodBeat.o(87617);
                return true;
            }
        });
        this.kam = (ListView) findViewById(16908298);
        this.kao = (RelativeLayout) findViewById(R.id.a_b);
        if (this.kao != null) {
            this.kam.setEmptyView(this.kao);
        }
        this.kap = (LinearLayout) View.inflate(getBaseContext(), R.layout.jf, null);
        this.kaq = (LinearLayout) View.inflate(getBaseContext(), R.layout.jc, null);
        this.kam.addHeaderView(this.kap);
        this.kam.addFooterView(this.kaq);
        this.kan = Kw();
        this.kam.setAdapter(this.kan);
        this.kam.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(87618);
                if (i == 0) {
                    ab.i("MicroMsg.CardBaseUI", "onItemClick pos is 0, onListHeaderItemClick()");
                    AppMethodBeat.o(87618);
                    return;
                }
                if (i > 0) {
                    i--;
                }
                if (i >= CardBaseUI.this.kan.getCount()) {
                    AppMethodBeat.o(87618);
                    return;
                }
                CardBaseUI.this.b(CardBaseUI.this.kat.sM(i), i);
                AppMethodBeat.o(87618);
            }
        });
        this.kam.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(87619);
                if (i == 0) {
                    ab.i("MicroMsg.CardBaseUI", "onItemLongClick pos is 0");
                    AppMethodBeat.o(87619);
                } else {
                    if (i > 0) {
                        i--;
                    }
                    if (i >= CardBaseUI.this.kan.getCount()) {
                        AppMethodBeat.o(87619);
                    } else {
                        CardBaseUI.this.a(CardBaseUI.this.kat.sM(i));
                        AppMethodBeat.o(87619);
                    }
                }
                return true;
            }
        });
        g.RO().eJo.a(560, (f) this);
        g.RO().eJo.a(692, (f) this);
        BaseAdapter baseAdapter = this.kan;
        Object dVar2;
        if (baseAdapter instanceof c) {
            dVar2 = new com.tencent.mm.plugin.card.ui.d((c) baseAdapter);
        } else if (baseAdapter instanceof com.tencent.mm.plugin.card.sharecard.ui.c) {
            dVar2 = new com.tencent.mm.plugin.card.sharecard.ui.d((com.tencent.mm.plugin.card.sharecard.ui.c) baseAdapter);
        } else if (baseAdapter instanceof com.tencent.mm.plugin.card.sharecard.ui.g) {
            dVar2 = new h((com.tencent.mm.plugin.card.sharecard.ui.g) baseAdapter);
        } else {
            dVar2 = new com.tencent.mm.plugin.card.ui.h((com.tencent.mm.plugin.card.ui.g) baseAdapter);
        }
        this.kat = dVar2;
        this.kat.onCreate();
        aZp();
    }

    public int getLayoutId() {
        return R.layout.j8;
    }

    public void onDestroy() {
        ab.d("MicroMsg.CardBaseUI", "destroy card");
        g.RO().eJo.b(560, (f) this);
        g.RO().eJo.b(692, (f) this);
        if (this.kat != null) {
            this.kat.onDestroy();
        }
        super.onDestroy();
    }

    /* Access modifiers changed, original: protected */
    public void a(b bVar, int i) {
        Intent intent = new Intent(this, CardDetailUI.class);
        intent.putExtra("key_card_id", bVar.aZZ());
        intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        intent.putExtra("key_from_scene", 3);
        startActivity(intent);
        if (aZq() == n.a.HOME_MEMBER_CARD_TYPE) {
            com.tencent.mm.plugin.report.service.h.pYm.e(11324, "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0));
            int intValue = ((Integer) g.RP().Ry().get(ac.a.USERINFO_CARD_HOME_PAGE_CARD_NUM_INT_SYNC, Integer.valueOf(3))).intValue();
            com.tencent.mm.plugin.report.service.h.pYm.e(15767, Integer.valueOf(intValue), Integer.valueOf(i + 1));
        } else if (aZq() == n.a.MEMBER_CARD_TYPE) {
            com.tencent.mm.plugin.report.service.h.pYm.e(11324, "ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0));
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void fE(boolean z) {
        if (z) {
            this.ejZ = p.b(this, getString(R.string.un), true, null);
        } else if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
            this.ejZ = null;
        }
    }

    public final void H(LinkedList<String> linkedList) {
        fE(true);
        g.RO().eJo.a(new r(linkedList), 0);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        int i3;
        String str2;
        if (i != 0 || i2 != 0) {
            fE(false);
            if (mVar instanceof af) {
                i3 = ((af) mVar).kdT;
                str2 = ((af) mVar).kdU;
                if (i3 == Downloads.MIN_WAIT_FOR_NETWORK) {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = getString(R.string.ae6);
                    }
                    str = str2;
                }
            }
            if (!(mVar instanceof x) && !(mVar instanceof ad) && !(mVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) && this.kas) {
                com.tencent.mm.plugin.card.d.d.b(this, str, i2);
            }
        } else if (mVar instanceof r) {
            fE(false);
            com.tencent.mm.ui.base.h.bQ(this, getResources().getString(R.string.adi));
            am.baV();
            com.tencent.mm.plugin.card.b.b.sO(4);
            this.kat.ZZ();
            aZz();
        } else if (mVar instanceof af) {
            fE(false);
            i3 = ((af) mVar).kdT;
            str2 = ((af) mVar).kdU;
            if (i3 == Downloads.MIN_WAIT_FOR_NETWORK) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = getString(R.string.ae6);
                }
                com.tencent.mm.plugin.card.d.d.b(this, str2, i3);
                return;
            }
            if (this.kau != null) {
                no aZW = this.kau.aZW();
                aZW.status = 3;
                this.kau.a(aZW);
                if (!am.baW().c(this.kau, new String[0])) {
                    ab.e("MicroMsg.CardBaseUI", "update newSerial fail, cardId = %s", this.kau.field_card_id);
                }
            }
            this.kat.ZZ();
            aZz();
        }
    }

    /* Access modifiers changed, original: protected */
    public n.a aZq() {
        return n.a.NORMAL_TYPE;
    }

    /* Access modifiers changed, original: protected */
    public BaseAdapter Kw() {
        return new c(this, aZq());
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
    public void b(b bVar, int i) {
        if (!aZr()) {
            ab.e("MicroMsg.CardBaseUI", "isItemClickable return false");
        } else if (bVar == null) {
            ab.e("MicroMsg.CardBaseUI", "onListItemClick  item == null");
        } else if (!bVar.aZZ().equals("PRIVATE_TICKET_TITLE") && !bVar.aZZ().equals("PRIVATE_INVOICE_TITLE")) {
            if (bVar.aZI()) {
                a(bVar, i);
            } else if (!TextUtils.isEmpty(bVar.aZV().vUc)) {
                com.tencent.mm.plugin.card.d.b.a((MMActivity) this, bVar.aZV().vUc, 0);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void a(final b bVar) {
        if (!aZs()) {
            ab.e("MicroMsg.CardBaseUI", "isItemClickable return false");
        } else if (bVar == null) {
            ab.e("MicroMsg.CardBaseUI", "onListItemLongClick  item == null");
        } else {
            ArrayList arrayList = new ArrayList();
            if (bVar.aZJ()) {
                if (!bo.isNullOrNil(bVar.aZV().vUI)) {
                    arrayList.add(bVar.aZV().vUI);
                } else if (bVar.aZH()) {
                    arrayList.add(getResources().getString(R.string.ag2));
                } else {
                    arrayList.add(getResources().getString(R.string.ag1));
                }
            }
            arrayList.add(getResources().getString(R.string.p4));
            final String aZZ = bVar.aZZ();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(bVar.aZV().kdf);
            com.tencent.mm.ui.base.h.a((Context) this, stringBuilder.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), null, new com.tencent.mm.ui.base.h.c() {
                public final void iE(int i) {
                    AppMethodBeat.i(87621);
                    if (bVar.aZJ()) {
                        switch (i) {
                            case 0:
                                CardBaseUI.this.a((CardInfo) bVar);
                                AppMethodBeat.o(87621);
                                return;
                            case 1:
                                com.tencent.mm.plugin.card.d.d.a(CardBaseUI.this, aZZ, "", new com.tencent.mm.plugin.card.d.d.a(aZZ) {
                                    public final void aZA() {
                                        AppMethodBeat.i(87620);
                                        CardBaseUI.a(CardBaseUI.this, r3);
                                        AppMethodBeat.o(87620);
                                    }
                                });
                                AppMethodBeat.o(87621);
                                return;
                            default:
                                AppMethodBeat.o(87621);
                                return;
                        }
                    }
                    switch (i) {
                        case 0:
                            com.tencent.mm.plugin.card.d.d.a(CardBaseUI.this, aZZ, "", /* anonymous class already generated */);
                            break;
                    }
                    AppMethodBeat.o(87621);
                }
            });
        }
    }

    public final void c(int i, int i2, Intent intent) {
        if (i == 0 && i2 == -1) {
            l(intent.getStringExtra("Select_Conv_User"), 0, false);
        }
    }

    /* Access modifiers changed, original: protected */
    public void a(CardInfo cardInfo) {
        this.kau = cardInfo;
        com.tencent.mm.plugin.card.d.b.a((MMActivity) this, 0, (a) this);
    }

    /* Access modifiers changed, original: protected|final */
    public final void l(final String str, int i, final boolean z) {
        if (this.kau == null) {
            ab.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo == null");
        } else if (this.kau.aZV() == null) {
            ab.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            if (i == 0) {
                if (TextUtils.isEmpty(this.kau.aZX().wYl) || this.kau.aZH()) {
                    stringBuilder.append(getString(R.string.ens));
                } else {
                    stringBuilder.append(this.kau.aZX().wYl);
                }
                com.tencent.mm.plugin.report.service.h.pYm.e(11582, "OperGift", Integer.valueOf(2), Integer.valueOf(this.kau.aZV().iAd), this.kau.field_card_tp_id, this.kau.field_card_id, str);
            } else if (i == 1) {
                stringBuilder.append(getString(R.string.ae5, new Object[]{this.kau.aZV().kdf}));
                com.tencent.mm.plugin.report.service.h.pYm.e(11582, "OperGift", Integer.valueOf(3), Integer.valueOf(this.kau.aZV().iAd), this.kau.field_card_tp_id, this.kau.field_card_id, str);
            }
            t.a.vlq.a(this.mController, stringBuilder.toString(), this.kau.aZV().kbV, this.kau.aZV().title + IOUtils.LINE_SEPARATOR_UNIX + this.kau.aZV().kdg, false, getResources().getString(R.string.tf), new q.a() {
                public final void a(boolean z, String str, int i) {
                    AppMethodBeat.i(87622);
                    if (z) {
                        CardBaseUI.c(CardBaseUI.this, str);
                        com.tencent.mm.ui.base.h.bQ(CardBaseUI.this, CardBaseUI.this.getResources().getString(R.string.aeq));
                        if (z) {
                            CardBaseUI.this.finish();
                        }
                    }
                    AppMethodBeat.o(87622);
                }
            });
        }
    }

    public final void aZt() {
        if (this.fwu == null) {
            this.fwu = d.agz();
        }
        if (this.fwu != null) {
            this.fwu.a(this.ecy, true);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void aZu() {
        if (this.fwu != null) {
            this.fwu.a(this.ecy, true);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void aZv() {
        if (this.fwu != null) {
            this.fwu.c(this.ecy);
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
            ab.i("MicroMsg.CardBaseUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            return;
        }
        ab.i("MicroMsg.CardBaseUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 69:
                if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dby), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.atb), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(87624);
                            CardBaseUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(87624);
                        }
                    }, null);
                    return;
                }
                aZy();
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void c(CardBaseUI cardBaseUI, String str) {
        cardBaseUI.fE(true);
        g.RO().eJo.a(new af(cardBaseUI.kau.field_card_id, str, 17), 0);
    }
}
