package com.tencent.mm.ui.chatting.i;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.va;
import com.tencent.mm.g.a.vb;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.f;
import java.util.Date;
import java.util.LinkedList;

public final class g extends b {
    int eot = -1;

    class a extends com.tencent.mm.ui.chatting.a.c.b {
        public String appId;
        public String desc;
        public int iconRes;
        public int yZy;
        public int yZz = 0;

        public a(long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
            super(j, i, str, j2, str2, str3, str4, str5);
        }

        public final boolean arg(String str) {
            AppMethodBeat.i(32629);
            if (str != null) {
                boolean arg = super.arg(str);
                if (!arg) {
                    arg = this.title.contains(str);
                }
                AppMethodBeat.o(32629);
                return arg;
            }
            AppMethodBeat.o(32629);
            return false;
        }

        public final int getType() {
            return this.type;
        }

        public final String toString() {
            AppMethodBeat.i(32630);
            String str = "PayMediaHistoryListItem{appId='" + this.appId + '\'' + ", desc='" + this.desc + '\'' + ", timestamp=" + this.timestamp + ", type=" + this.type + ", title='" + this.title + '\'' + ", msgId=" + this.cvx + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", remarkName='" + this.bCv + '\'' + ", nameInRoom='" + this.iQV + '\'' + '}';
            AppMethodBeat.o(32630);
            return str;
        }
    }

    class b extends com.tencent.mm.ui.chatting.a.c.a {
        TextView gnC;
        ImageView iqT;

        public b(View view) {
            super(view);
            AppMethodBeat.i(32631);
            this.iqT = (ImageView) view.findViewById(R.id.yk);
            this.gnB.setSingleLine(false);
            this.gnB.setMaxLines(2);
            this.gnC = (TextView) view.findViewById(R.id.aw);
            AppMethodBeat.o(32631);
        }
    }

    public g(Context context) {
        super(context);
    }

    public final int getType() {
        return 5;
    }

    public static boolean pY(int i) {
        AppMethodBeat.i(32632);
        if (bo.ank("1001") == i || bo.ank("1002") == i || 419430449 == i) {
            AppMethodBeat.o(32632);
            return true;
        }
        AppMethodBeat.o(32632);
        return false;
    }

    public final void dFH() {
        AppMethodBeat.i(32633);
        this.yYY.dFL();
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RS().aa(new Runnable() {
            final /* synthetic */ boolean kve = true;

            public final void run() {
                AppMethodBeat.i(32627);
                LinkedList linkedList = new LinkedList();
                aw.ZK();
                Cursor cD = c.XO().cD(g.this.emo, g.this.eot);
                if (cD == null) {
                    ab.e("MicroMsg.PayHistoryListPresenter", "[loadData] cursor is null!");
                    AppMethodBeat.o(32627);
                    return;
                }
                u oa;
                if (t.kH(g.this.emo)) {
                    aw.ZK();
                    oa = c.XV().oa(g.this.emo);
                } else {
                    oa = null;
                }
                long j = 0;
                while (cD.moveToNext()) {
                    try {
                        long b;
                        cy biVar = new bi();
                        biVar.d(cD);
                        String str = biVar.field_content;
                        if (str != null) {
                            com.tencent.mm.af.j.b X = com.tencent.mm.af.j.b.X(str, biVar.field_reserved);
                            if (g.pY(bo.ank(X.fhY)) || g.pY(biVar.getType())) {
                                Object obj;
                                String b2 = b.b(biVar, t.kH(g.this.emo));
                                ad aoO = ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoO(b2);
                                String str2 = "";
                                if (oa != null) {
                                    str2 = oa.mJ(b2);
                                }
                                a aVar;
                                if (g.pY(biVar.getType())) {
                                    aVar = new a(biVar.field_createTime, biVar.getType(), X.fhw, biVar.field_msgId, aoO.field_username, aoO.Oi(), aoO.field_conRemark, str2);
                                    vb vbVar = new vb();
                                    vbVar.cRW.cEa = X.fhy;
                                    com.tencent.mm.sdk.b.a.xxA.m(vbVar);
                                    boolean z = biVar.field_isSend == 1 ? vbVar.cRX.cRY : !vbVar.cRX.cRY;
                                    if (vbVar.cRX.status == -2) {
                                        z = false;
                                    }
                                    if (z) {
                                        int i;
                                        int i2 = vbVar.cRX.status;
                                        if (i2 <= 0) {
                                            i2 = X.fhv;
                                        }
                                        aVar.nickname = g.this.mContext.getResources().getString(R.string.es0, new Object[]{aVar.nickname});
                                        switch (i2) {
                                            case 1:
                                            case 7:
                                                i = -352966;
                                                break;
                                            case 3:
                                                i = -470621;
                                                break;
                                            case 4:
                                                i = -470621;
                                                break;
                                            case 5:
                                                i = -470621;
                                                break;
                                            case 6:
                                                i = -470621;
                                                break;
                                            default:
                                                i = -352966;
                                                break;
                                        }
                                        aVar.yZz = i;
                                        aVar.desc = g.a(g.this, g.this.mContext, biVar, X, z, i2);
                                        Context context = g.this.mContext;
                                        if (X != null && context != null) {
                                            switch (i2) {
                                                case 1:
                                                case 7:
                                                    i = R.raw.c2c_remittance_icon;
                                                    break;
                                                case 3:
                                                    i = R.raw.c2c_remittance_received_icon;
                                                    break;
                                                case 4:
                                                    i = R.raw.c2c_remittance_rejected_icon;
                                                    break;
                                                case 5:
                                                    i = R.raw.c2c_remittance_received_icon;
                                                    break;
                                                case 6:
                                                    i = R.raw.c2c_remittance_cancle_icon;
                                                    break;
                                                default:
                                                    i = R.raw.c2c_remittance_icon;
                                                    break;
                                            }
                                        }
                                        i = R.raw.c2c_remittance_icon;
                                        aVar.iconRes = i;
                                        obj = aVar;
                                    } else {
                                        ab.i("MicroMsg.PayHistoryListPresenter", "[loadData] it's not payer! isSend:%s, status:%s pass this msg:%s date:%s item:%s", Boolean.valueOf(vbVar.cRX.cRY), Integer.valueOf(vbVar.cRX.status), Long.valueOf(biVar.field_msgId), g.this.yYZ.ha(aVar.timestamp), aVar.toString());
                                    }
                                } else {
                                    aVar = new a(biVar.field_createTime, biVar.getType(), X.fhT, biVar.field_msgId, aoO.field_username, aoO.Oi(), aoO.field_conRemark, str2);
                                    aVar.yZy = bo.ank(X.fhY);
                                    a obj2;
                                    if (aVar.yZy == bo.ank("1001")) {
                                        boolean z2;
                                        aVar.nickname = g.this.mContext.getResources().getString(R.string.ery, new Object[]{aVar.nickname});
                                        if (biVar.field_isSend == 1) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        aVar.desc = f.b(X, z2);
                                        if (biVar.field_isSend == 1) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        aVar.yZz = f.d(X, z2);
                                        aVar.iconRes = f.a(X, biVar.field_isSend == 1);
                                        obj2 = aVar;
                                    } else {
                                        va vaVar = new va();
                                        vaVar.cRQ.cRS = X.fhZ;
                                        com.tencent.mm.sdk.b.a.xxA.m(vaVar);
                                        aVar.nickname = g.this.mContext.getResources().getString(R.string.erz, new Object[]{aVar.nickname});
                                        aVar.desc = f.a(vaVar.cRR.cRT, vaVar.cRR.cRU, vaVar.cRR.cRV, biVar.field_isSend == 1, t.kH(g.this.emo));
                                        int identifier = g.this.mContext.getResources().getIdentifier(((com.tencent.mm.af.c) X.X(com.tencent.mm.af.c.class)).ffN, "drawable", ah.getPackageName());
                                        aVar.iconRes = f.w(vaVar.cRR.cRU, vaVar.cRR.cRV, biVar.field_isSend == 1);
                                        if (aVar.iconRes <= 0) {
                                            aVar.iconRes = identifier;
                                        }
                                        obj2 = aVar;
                                    }
                                }
                                b = com.tencent.mm.ui.gridviewheaders.a.dJg().b(new Date(biVar.field_createTime));
                                if (j != b) {
                                    linkedList.add(new com.tencent.mm.ui.chatting.a.c.c(biVar.field_createTime));
                                }
                                linkedList.add(obj2);
                                j = b;
                            }
                        }
                        b = j;
                        j = b;
                    } catch (Throwable th) {
                        cD.close();
                        AppMethodBeat.o(32627);
                    }
                }
                cD.close();
                g.this.iPr.addAll(linkedList);
                g.this.yZa = g.this.iPr;
                linkedList.clear();
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(32626);
                        if (g.this.yYY != null) {
                            g.this.yYY.p(AnonymousClass1.this.kve, g.this.iPr.size());
                        }
                        AppMethodBeat.o(32626);
                    }
                });
                AppMethodBeat.o(32627);
            }
        });
        AppMethodBeat.o(32633);
    }

    public final String aoy() {
        AppMethodBeat.i(32634);
        String string = this.mContext.getString(R.string.dzo);
        AppMethodBeat.o(32634);
        return string;
    }

    public final String dFK() {
        AppMethodBeat.i(32635);
        String string = this.mContext.getString(R.string.dzo);
        AppMethodBeat.o(32635);
        return string;
    }

    public final e dFI() {
        AppMethodBeat.i(32636);
        AnonymousClass2 anonymousClass2 = new e() {
            public final void a(View view, int i, com.tencent.mm.ui.chatting.a.c.b bVar) {
                AppMethodBeat.i(32628);
                Context context = g.this.mContext;
                String str = g.this.emo;
                long j = bVar.cvx;
                if (str == null) {
                    ab.e("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] username is null");
                    AppMethodBeat.o(32628);
                    return;
                }
                aw.ZK();
                ab.i("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] msgLocalId:%s", Long.valueOf(c.XO().jf(j).field_msgId));
                if (t.kH(str)) {
                    aw.ZK();
                    if (c.XV().oa(str) == null) {
                        ab.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] member is null! username:%s", str);
                        h.a(context, context.getString(R.string.dnb), context.getString(R.string.ewj), null);
                        AppMethodBeat.o(32628);
                        return;
                    }
                }
                aw.ZK();
                ad aoO = c.XM().aoO(str);
                if (aoO == null || !com.tencent.mm.n.a.jh(aoO.field_type)) {
                    if (aoO == null) {
                        ab.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] contact is null! username:%s", str);
                    } else {
                        ab.w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] isContact not ! username:%s", str);
                    }
                    h.a(context, context.getString(R.string.dnb), context.getString(R.string.ewj), null);
                    AppMethodBeat.o(32628);
                    return;
                }
                Intent putExtra = new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", j);
                putExtra.setClass(context, ChattingUI.class);
                context.startActivity(putExtra);
                AppMethodBeat.o(32628);
            }

            public final void b(View view, int i, com.tencent.mm.ui.chatting.a.c.b bVar) {
            }
        };
        AppMethodBeat.o(32636);
        return anonymousClass2;
    }

    public final v v(ViewGroup viewGroup) {
        AppMethodBeat.i(32637);
        b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.zg, viewGroup, false));
        AppMethodBeat.o(32637);
        return bVar;
    }

    public final void a(com.tencent.mm.ui.chatting.a.c.a aVar, int i) {
        AppMethodBeat.i(32638);
        b bVar = (b) aVar;
        a aVar2 = (a) Oy(i);
        if (bo.isNullOrNil(aVar2.desc)) {
            bVar.gnC.setVisibility(8);
        } else {
            bVar.gnC.setVisibility(0);
            bVar.gnC.setText(bo.bc(aVar2.desc, ""));
        }
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(this.mContext, 6);
        bVar.iqT.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        bVar.iqT.setImageResource(aVar2.iconRes);
        bVar.iqT.setBackgroundColor(aVar2.yZz);
        AppMethodBeat.o(32638);
    }

    static /* synthetic */ String a(g gVar, Context context, bi biVar, com.tencent.mm.af.j.b bVar, boolean z, int i) {
        AppMethodBeat.i(32639);
        String str;
        if (bVar == null || context == null) {
            str = "";
            AppMethodBeat.o(32639);
            return str;
        }
        switch (i) {
            case 1:
            case 7:
                aw.ZK();
                ad aoN = c.XM().aoN(biVar.field_talker);
                if (aoN != null) {
                    str = aoN.Oj();
                } else {
                    str = biVar.field_talker;
                }
                if (z) {
                    if (bo.isNullOrNil(bVar.fiF)) {
                        if (biVar.field_isSend == 1) {
                            str = gVar.mContext.getString(R.string.alk, new Object[]{str});
                            break;
                        }
                        str = gVar.mContext.getString(R.string.all);
                        break;
                    }
                    str = bVar.fiF;
                    break;
                }
                str = gVar.mContext.getString(R.string.alc);
                break;
            case 3:
                if (z) {
                    if (!bo.isNullOrNil(bVar.fiF)) {
                        str = ah.getContext().getString(R.string.alb) + "-" + bVar.fiF;
                        break;
                    }
                    str = ah.getContext().getString(R.string.alb);
                    break;
                }
                str = ah.getContext().getString(R.string.alc);
                break;
            case 4:
                if (z) {
                    if (!bo.isNullOrNil(bVar.fiF)) {
                        str = ah.getContext().getString(R.string.alo) + "-" + bVar.fiF;
                        break;
                    }
                    str = ah.getContext().getString(R.string.alo);
                    break;
                }
                str = ah.getContext().getString(R.string.aln);
                break;
            case 5:
                if (z) {
                    if (!bo.isNullOrNil(bVar.fiF)) {
                        str = ah.getContext().getString(R.string.ali) + "-" + bVar.fiF;
                        break;
                    }
                    str = ah.getContext().getString(R.string.ali);
                    break;
                }
                str = ah.getContext().getString(R.string.alj);
                break;
            case 6:
                str = context.getResources().getString(R.string.ald);
                break;
            default:
                str = bVar.description;
                break;
        }
        AppMethodBeat.o(32639);
        return str;
    }
}
