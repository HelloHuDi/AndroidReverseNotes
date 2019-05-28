package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.g.a.kv;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;

public final class s implements f {
    String IS;
    final Context context;
    int cvn;
    int cvo;
    public int jCq = 0;
    c mip = new c<nr>() {
        {
            AppMethodBeat.i(38260);
            this.xxI = nr.class.getName().hashCode();
            AppMethodBeat.o(38260);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(38261);
            nr nrVar = (nr) bVar;
            if (s.this.rjm == null || s.this.riz == null) {
                ab.e("MicroMsg.GalleryTitleManager", "not in recoging");
                AppMethodBeat.o(38261);
            } else if (nrVar == null || !(nrVar instanceof nr)) {
                ab.e("MicroMsg.GalleryTitleManager", "receive invalid callbak");
                AppMethodBeat.o(38261);
            } else if (nrVar.cJX.filePath.equals(s.this.riz)) {
                ab.i("MicroMsg.GalleryTitleManager", "recog result: " + nrVar.cJX.result);
                if (!bo.isNullOrNil(nrVar.cJX.result)) {
                    s.this.riC = nrVar.cJX.result;
                    s.this.cvn = nrVar.cJX.cvn;
                    s.this.cvo = nrVar.cJX.cvo;
                    if (!(s.this.riC == null || s.this.rjm == null)) {
                        s.this.riD = true;
                    }
                    s.this.a(s.this.rjn, s.this.qBY, s.this.rjo, false, 0);
                }
                s.this.riz = null;
                AppMethodBeat.o(38261);
            } else {
                ab.e("MicroMsg.GalleryTitleManager", "not same filepath");
                AppMethodBeat.o(38261);
            }
            return false;
        }
    };
    n qBY;
    String riC;
    boolean riD = false;
    c riJ = new c<kv>() {
        {
            AppMethodBeat.i(38249);
            this.xxI = kv.class.getName().hashCode();
            AppMethodBeat.o(38249);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(38250);
            kv kvVar = (kv) bVar;
            if (kvVar == null || !(kvVar instanceof kv)) {
                ab.e("MicroMsg.GalleryTitleManager", "event is null or not a instant of NotifyDealQBarStrResultEvent");
            } else {
                ab.i("MicroMsg.GalleryTitleManager", "notify Event: %d", Integer.valueOf(kvVar.cGM.cGK));
                if (!(kvVar.cGM.activity == ((Activity) s.this.context) && kvVar.cGM.ctB.equals(s.this.riC))) {
                    ab.e("MicroMsg.GalleryTitleManager", "not the same");
                }
            }
            AppMethodBeat.o(38250);
            return false;
        }
    };
    String riz;
    SnsCmdList rjk = new SnsCmdList();
    private final a rjl;
    d rjm = null;
    boolean rjn;
    bau rjo;
    private final String rjp;
    public p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.sns.ui.s$9 */
    class AnonymousClass9 implements OnCancelListener {
        final /* synthetic */ r rjx;

        AnonymousClass9(r rVar) {
            this.rjx = rVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(38259);
            g.RQ();
            g.RO().eJo.c(this.rjx);
            AppMethodBeat.o(38259);
        }
    }

    public interface a {
        void crM();

        void crN();

        void dg(String str, int i);

        void dh(String str, int i);

        void gt(String str, String str2);
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.s$8 */
    class AnonymousClass8 implements OnCancelListener {
        final /* synthetic */ r rjw;

        AnonymousClass8(r rVar) {
            this.rjw = rVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(38258);
            if (s.this.jCq != 0) {
                g.RQ();
                g.RO().eJo.c(this.rjw);
                s.this.jCq = 0;
            }
            AppMethodBeat.o(38258);
        }
    }

    public final void DN(int i) {
        AppMethodBeat.i(38262);
        if (i == 0) {
            AppMethodBeat.o(38262);
            return;
        }
        this.rjk.CK(i);
        AppMethodBeat.o(38262);
    }

    public s(Context context, a aVar) {
        AppMethodBeat.i(38263);
        this.context = context;
        this.rjl = aVar;
        this.rjp = ((Activity) context).getIntent().getStringExtra("sns_gallery_pre_title");
        AppMethodBeat.o(38263);
    }

    public final void crL() {
        AppMethodBeat.i(38264);
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", this.rjk);
        ((Activity) this.context).setResult(-1, intent);
        ((Activity) this.context).finish();
        AppMethodBeat.o(38264);
    }

    public final void a(boolean z, final n nVar, final bau bau, boolean z2, final int i) {
        AppMethodBeat.i(38265);
        this.rjn = z;
        this.qBY = nVar;
        this.rjo = bau;
        this.IS = bau.Id;
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        dq dqVar;
        if (!z) {
            nVar.cqu();
            arrayList.add(this.context.getString(R.string.ens));
            arrayList2.add(Integer.valueOf(3));
            if (com.tencent.mm.bp.d.afj("favorite")) {
                arrayList.add(this.context.getString(R.string.dcq));
                arrayList2.add(Integer.valueOf(6));
            }
            if (nVar.field_type == 15 || nVar.field_type == 5) {
                arrayList.add(this.context.getString(R.string.dx0));
                arrayList2.add(Integer.valueOf(2));
            } else if (nVar.field_type == 1) {
                arrayList.add(this.context.getString(R.string.dwx));
                arrayList2.add(Integer.valueOf(2));
            } else {
                arrayList.add(this.context.getString(R.string.enw));
                arrayList2.add(Integer.valueOf(2));
            }
            dqVar = new dq();
            dqVar.cxc.cwT = nVar.cqU();
            com.tencent.mm.sdk.b.a.xxA.m(dqVar);
            if (dqVar.cxd.cwB) {
                arrayList.add(this.context.getString(R.string.s7));
                arrayList2.add(Integer.valueOf(8));
            }
            if (this.riC != null) {
                if (com.tencent.mm.plugin.scanner.a.BR(this.cvn)) {
                    arrayList.add(this.context.getString(R.string.diy));
                } else if (com.tencent.mm.plugin.scanner.a.ba(this.cvn, this.riC)) {
                    arrayList.add(this.context.getString(R.string.diz));
                } else if (com.tencent.mm.plugin.scanner.a.BQ(this.cvn)) {
                    arrayList.add(this.context.getString(R.string.dix));
                }
                arrayList2.add(Integer.valueOf(7));
            }
            if (arrayList.size() != 0) {
                if (this.rjm == null || !this.riD) {
                    this.rjm = new d(this.context, 1, false);
                } else {
                    this.riD = false;
                }
                this.rjm.rBl = new com.tencent.mm.ui.base.n.c() {
                    public final void a(l lVar) {
                        AppMethodBeat.i(38255);
                        lVar.clear();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < arrayList.size()) {
                                lVar.e(((Integer) arrayList2.get(i2)).intValue(), (CharSequence) arrayList.get(i2));
                                i = i2 + 1;
                            } else {
                                AppMethodBeat.o(38255);
                                return;
                            }
                        }
                    }
                };
                this.rjm.rBm = new com.tencent.mm.ui.base.n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(38256);
                        int itemId = menuItem.getItemId();
                        ab.d("MicroMsg.GalleryTitleManager", "showAlert ".concat(String.valueOf(itemId)));
                        switch (itemId) {
                            case 2:
                                if (!(nVar == null || nVar.cqu().xfI == null)) {
                                    if (nVar.field_type != 15) {
                                        com.tencent.mm.pluginsdk.ui.tools.n.j(an.fZ(af.getAccSnsPath(), bau.Id) + i.l(bau), s.this.context);
                                        AppMethodBeat.o(38256);
                                        return;
                                    }
                                    s.Zx(nVar.cqU());
                                    AppMethodBeat.o(38256);
                                    return;
                                }
                            case 3:
                                if (!(nVar == null || nVar.cqu().xfI == null)) {
                                    if (nVar.cqu().xfI.wbJ == 1) {
                                        s.this.Zw(an.fZ(af.getAccSnsPath(), bau.Id) + i.l(bau));
                                        AppMethodBeat.o(38256);
                                        return;
                                    }
                                    s.Zy(nVar.cqU());
                                    AppMethodBeat.o(38256);
                                    return;
                                }
                            case 4:
                                s sVar = s.this;
                                long j = nVar.field_snsId;
                                n kD = af.cnF().kD(j);
                                if (j == 0 || kD == null) {
                                    AppMethodBeat.o(38256);
                                    return;
                                }
                                Intent intent = new Intent();
                                intent.putExtra("k_username", kD.field_userName);
                                intent.putExtra("k_expose_msg_id", j);
                                intent.putExtra("showShare", false);
                                intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                                com.tencent.mm.bp.d.b(sVar.context, "webview", ".ui.tools.WebViewUI", intent);
                                AppMethodBeat.o(38256);
                                return;
                            case 6:
                                if (!(nVar == null || nVar.cqu().xfI == null)) {
                                    s.a(s.this, nVar, bau);
                                    AppMethodBeat.o(38256);
                                    return;
                                }
                            case 7:
                                Bundle bundle = new Bundle();
                                bundle.putString("stat_msg_id", "sns_" + i.jV(nVar.field_snsId));
                                bundle.putString("stat_send_msg_user", nVar.field_userName);
                                bundle.putInt("stat_scene", 3);
                                s.a(s.this, bundle);
                                break;
                            case 8:
                                s.a(s.this, nVar, bau, i);
                                AppMethodBeat.o(38256);
                                return;
                        }
                        AppMethodBeat.o(38256);
                    }
                };
                this.rjm.cpD();
            }
        } else if (nVar == null) {
            AppMethodBeat.o(38265);
            return;
        } else {
            if (nVar.field_localPrivate > 0) {
                if (!bo.isNullOrNil(af.cnk()) && af.cnk().equals(nVar.field_userName)) {
                    arrayList.add(this.context.getString(R.string.eo_));
                    arrayList2.add(Integer.valueOf(5));
                }
                arrayList.add(this.context.getString(R.string.ens));
                arrayList2.add(Integer.valueOf(3));
            } else {
                arrayList.add(this.context.getString(R.string.eoa));
                arrayList2.add(Integer.valueOf(1));
                arrayList.add(this.context.getString(R.string.ens));
                arrayList2.add(Integer.valueOf(3));
            }
            if (com.tencent.mm.bp.d.afj("favorite")) {
                arrayList.add(this.context.getString(R.string.dcq));
                arrayList2.add(Integer.valueOf(6));
            }
            if (nVar.field_type == 15 || nVar.field_type == 5) {
                arrayList.add(this.context.getString(R.string.dx0));
                arrayList2.add(Integer.valueOf(2));
            } else if (nVar.field_type == 1) {
                arrayList.add(this.context.getString(R.string.dwx));
                arrayList2.add(Integer.valueOf(2));
            } else {
                arrayList.add(this.context.getString(R.string.enw));
                arrayList2.add(Integer.valueOf(2));
            }
            dqVar = new dq();
            dqVar.cxc.cwT = nVar.cqU();
            com.tencent.mm.sdk.b.a.xxA.m(dqVar);
            if (dqVar.cxd.cwB) {
                arrayList.add(this.context.getString(R.string.s7));
                arrayList2.add(Integer.valueOf(8));
            }
            if (this.riC != null) {
                if (com.tencent.mm.plugin.scanner.a.BR(this.cvn)) {
                    arrayList.add(this.context.getString(R.string.diy));
                } else if (com.tencent.mm.plugin.scanner.a.ba(this.cvn, this.riC)) {
                    arrayList.add(this.context.getString(R.string.diz));
                } else if (com.tencent.mm.plugin.scanner.a.BQ(this.cvn)) {
                    arrayList.add(this.context.getString(R.string.dix));
                } else {
                    arrayList.add(this.context.getString(R.string.diy));
                }
                arrayList2.add(Integer.valueOf(7));
            }
            if (this.rjm == null || !this.riD) {
                this.rjm = new d(this.context, 1, false);
            } else {
                this.riD = false;
            }
            this.rjm.rBl = new com.tencent.mm.ui.base.n.c() {
                public final void a(l lVar) {
                    AppMethodBeat.i(38248);
                    lVar.clear();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < arrayList.size()) {
                            lVar.e(((Integer) arrayList2.get(i2)).intValue(), (CharSequence) arrayList.get(i2));
                            i = i2 + 1;
                        } else {
                            lVar.e(-1, s.this.context.getString(R.string.ek5));
                            AppMethodBeat.o(38248);
                            return;
                        }
                    }
                }
            };
            this.rjm.rBm = new com.tencent.mm.ui.base.n.d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.i(38253);
                    int itemId = menuItem.getItemId();
                    ab.d("MicroMsg.GalleryTitleManager", "showAlertWithDel ".concat(String.valueOf(itemId)));
                    s sVar;
                    m rVar;
                    Context context;
                    switch (itemId) {
                        case -1:
                            if (nVar.cqu().xfI.wbK.size() <= 1) {
                                h.a(s.this.context, s.this.context.getString(R.string.eni), "", new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AppMethodBeat.i(38252);
                                        s.this.C(nVar);
                                        AppMethodBeat.o(38252);
                                    }
                                }, null);
                                break;
                            }
                            h.a(s.this.context, s.this.context.getString(R.string.enk), "", new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(38251);
                                    s.this.C(nVar);
                                    AppMethodBeat.o(38251);
                                }
                            }, null);
                            AppMethodBeat.o(38253);
                            return;
                        case 1:
                            sVar = s.this;
                            n nVar = nVar;
                            if (nVar.cqV() || nVar.cqW()) {
                                af.cnF().DL(nVar.reX);
                                AppMethodBeat.o(38253);
                                return;
                            }
                            rVar = new r(nVar.field_snsId, 2);
                            g.RQ();
                            g.RO().eJo.a(rVar, 0);
                            context = sVar.context;
                            sVar.context.getString(R.string.tz);
                            sVar.tipDialog = h.b(context, sVar.context.getString(R.string.eo7), true, new AnonymousClass8(rVar));
                            AppMethodBeat.o(38253);
                            return;
                        case 2:
                            if (!(nVar == null || nVar.cqu().xfI == null)) {
                                if (nVar.field_type != 15) {
                                    com.tencent.mm.pluginsdk.ui.tools.n.j(an.fZ(af.getAccSnsPath(), bau.Id) + i.l(bau), s.this.context);
                                    AppMethodBeat.o(38253);
                                    return;
                                }
                                s.Zx(nVar.cqU());
                                AppMethodBeat.o(38253);
                                return;
                            }
                        case 3:
                            if (!(nVar == null || nVar.cqu().xfI == null)) {
                                if (nVar.cqu().xfI.wbJ == 1) {
                                    s.this.Zw(an.fZ(af.getAccSnsPath(), bau.Id) + i.l(bau));
                                    AppMethodBeat.o(38253);
                                    return;
                                }
                                s.Zy(nVar.cqU());
                                AppMethodBeat.o(38253);
                                return;
                            }
                        case 5:
                            sVar = s.this;
                            rVar = new r(nVar.field_snsId, 3);
                            g.RQ();
                            g.RO().eJo.a(rVar, 0);
                            context = sVar.context;
                            sVar.context.getString(R.string.tz);
                            sVar.tipDialog = h.b(context, sVar.context.getString(R.string.eo7), true, new AnonymousClass9(rVar));
                            AppMethodBeat.o(38253);
                            return;
                        case 6:
                            if (!(nVar == null || nVar.cqu().xfI == null)) {
                                s.a(s.this, nVar, bau);
                                AppMethodBeat.o(38253);
                                return;
                            }
                        case 7:
                            Bundle bundle = new Bundle();
                            bundle.putString("stat_msg_id", "sns_" + i.jV(nVar.field_snsId));
                            bundle.putString("stat_send_msg_user", nVar.field_userName);
                            bundle.putInt("stat_scene", 3);
                            s.a(s.this, bundle);
                            AppMethodBeat.o(38253);
                            return;
                        case 8:
                            s.a(s.this, nVar, bau, i);
                            AppMethodBeat.o(38253);
                            return;
                    }
                    AppMethodBeat.o(38253);
                }
            };
            this.rjm.zQf = new com.tencent.mm.ui.widget.a.d.a() {
                public final void onDismiss() {
                    AppMethodBeat.i(38254);
                    com.tencent.mm.g.a.an anVar = new com.tencent.mm.g.a.an();
                    anVar.ctC.filePath = s.this.riz;
                    com.tencent.mm.sdk.b.a.xxA.m(anVar);
                    s.this.rjm = null;
                    s.this.riz = null;
                    s.this.qBY = null;
                    s.this.IS = null;
                    s.this.riC = null;
                    s sVar = s.this;
                    s.this.cvo = 0;
                    sVar.cvn = 0;
                    AppMethodBeat.o(38254);
                }
            };
            this.rjm.cpD();
        }
        if (true == z2) {
            g.RQ();
            if (g.RO().eJo.acS() != 0) {
                np npVar = new np();
                String str = an.fZ(af.getAccSnsPath(), this.IS) + i.l(bau);
                npVar.cJU.filePath = str;
                this.riz = str;
                com.tencent.mm.sdk.b.a.xxA.m(npVar);
            }
        }
        AppMethodBeat.o(38265);
    }

    /* Access modifiers changed, original: protected|final */
    public final void C(n nVar) {
        AppMethodBeat.i(38266);
        if (nVar.cqV() || nVar.cqW()) {
            af.cnF().DL(nVar.reX);
            this.rjk.CK(nVar.reX);
            AppMethodBeat.o(38266);
            return;
        }
        af.cnE().km(nVar.field_snsId);
        final m rVar = new r(nVar.field_snsId, 1);
        g.RQ();
        g.RO().eJo.a(rVar, 0);
        Context context = this.context;
        this.context.getString(R.string.tz);
        this.tipDialog = h.b(context, this.context.getString(R.string.ek6), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(38257);
                if (s.this.jCq != 0) {
                    g.RQ();
                    g.RO().eJo.c(rVar);
                    s.this.jCq = 0;
                }
                AppMethodBeat.o(38257);
            }
        });
        AppMethodBeat.o(38266);
    }

    /* Access modifiers changed, original: protected|final */
    public final void Zw(String str) {
        AppMethodBeat.i(38267);
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", str);
        intent.putExtra("Retr_Compress_Type", 0);
        intent.putExtra("Retr_Msg_Type", 0);
        com.tencent.mm.plugin.sns.c.a.gkE.k(intent, this.context);
        AppMethodBeat.o(38267);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(38268);
        if (i == 0 && i2 == 0 && mVar != null) {
            ab.i("MicroMsg.GalleryTitleManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + mVar.getType() + " @" + hashCode());
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            r rVar = (r) mVar;
            switch (rVar.type) {
                case -1:
                    this.rjl.dg("", rVar.type);
                    AppMethodBeat.o(38268);
                    return;
                case 1:
                    this.rjk.CK(rVar.cNE);
                    this.rjl.dg(v.ap("sns_table_", (long) rVar.cNE), rVar.type);
                    AppMethodBeat.o(38268);
                    return;
                case 2:
                    this.rjk.CL(rVar.cNE);
                    this.rjl.dg("", rVar.type);
                    AppMethodBeat.o(38268);
                    return;
                case 3:
                    this.rjk.CL(rVar.cNE);
                    this.rjl.dg(v.ap("sns_table_", (long) rVar.cNE), rVar.type);
                    break;
            }
            AppMethodBeat.o(38268);
            return;
        }
        AppMethodBeat.o(38268);
    }

    static /* synthetic */ void a(s sVar, n nVar, bau bau) {
        AppMethodBeat.i(38269);
        cl clVar;
        if (nVar == null) {
            ab.i("MicroMsg.GalleryTitleManager", "error beacause info null");
            AppMethodBeat.o(38269);
        } else if (nVar.field_type == 1) {
            clVar = new cl();
            com.tencent.mm.plugin.sns.j.a.a(clVar, nVar, bau.Id);
            clVar.cvA.activity = (Activity) sVar.context;
            clVar.cvA.cvH = 15;
            com.tencent.mm.sdk.b.a.xxA.m(clVar);
            AppMethodBeat.o(38269);
        } else {
            if (nVar != null) {
                if (nVar.DI(32)) {
                    clVar = new cl();
                    com.tencent.mm.plugin.sns.j.a.a(clVar, nVar);
                    clVar.cvA.activity = (Activity) sVar.context;
                    clVar.cvA.cvH = 16;
                    com.tencent.mm.sdk.b.a.xxA.m(clVar);
                } else {
                    String cqU = nVar.cqU();
                    sb sbVar = new sb();
                    sbVar.cNV.cAd = 2;
                    sbVar.cNV.cNW = 16;
                    sbVar.cNV.cNX = false;
                    sbVar.cNV.czD = cqU;
                    com.tencent.mm.sdk.b.a.xxA.m(sbVar);
                    AppMethodBeat.o(38269);
                    return;
                }
            }
            AppMethodBeat.o(38269);
        }
    }

    static /* synthetic */ void a(s sVar, n nVar, bau bau, int i) {
        AppMethodBeat.i(38270);
        if (nVar == null) {
            ab.e("MicroMsg.GalleryTitleManager", "error beacause info null");
            AppMethodBeat.o(38270);
            return;
        }
        Intent intent = new Intent();
        if (nVar.field_type == 1) {
            intent.putExtra("sns_send_data_ui_image_path", FlipView.g(an.fZ(af.getAccSnsPath(), bau.Id) + i.l(bau), sVar.context));
            intent.putExtra("sns_send_data_ui_image_position", i);
        }
        intent.putExtra("sns_send_data_ui_activity", true);
        intent.putExtra("sns_local_id", nVar.cqU());
        com.tencent.mm.bp.d.f(sVar.context, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
        AppMethodBeat.o(38270);
    }

    static /* synthetic */ void Zx(String str) {
        AppMethodBeat.i(38271);
        sb sbVar = new sb();
        sbVar.cNV.cAd = 3;
        sbVar.cNV.czD = str;
        com.tencent.mm.sdk.b.a.xxA.m(sbVar);
        AppMethodBeat.o(38271);
    }

    static /* synthetic */ void Zy(String str) {
        AppMethodBeat.i(38272);
        sb sbVar = new sb();
        sbVar.cNV.cAd = 1;
        sbVar.cNV.cNY = 2;
        sbVar.cNV.czD = str;
        com.tencent.mm.sdk.b.a.xxA.m(sbVar);
        AppMethodBeat.o(38272);
    }

    static /* synthetic */ void a(s sVar, Bundle bundle) {
        AppMethodBeat.i(38273);
        ab.i("MicroMsg.GalleryTitleManager", "request deal QBAR string");
        cf cfVar = new cf();
        cfVar.cvm.activity = (Activity) sVar.context;
        cfVar.cvm.ctB = sVar.riC;
        cfVar.cvm.cvn = sVar.cvn;
        cfVar.cvm.cvo = sVar.cvo;
        cfVar.cvm.cvs = bundle;
        com.tencent.mm.sdk.b.a.xxA.m(cfVar);
        AppMethodBeat.o(38273);
    }
}
