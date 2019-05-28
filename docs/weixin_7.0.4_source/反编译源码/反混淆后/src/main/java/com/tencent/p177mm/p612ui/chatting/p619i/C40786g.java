package com.tencent.p177mm.p612ui.chatting.p619i;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p181af.C17872c;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C37810vb;
import com.tencent.p177mm.p230g.p231a.C45378va;
import com.tencent.p177mm.p230g.p711c.C6575cy;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.C15642f;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.p612ui.chatting.p1089a.C30452c.C30451e;
import com.tencent.p177mm.p612ui.chatting.p1089a.C30452c.C30453a;
import com.tencent.p177mm.p612ui.chatting.p1089a.C30452c.C30454c;
import com.tencent.p177mm.p612ui.chatting.p1089a.C30452c.C30455b;
import com.tencent.p177mm.p612ui.gridviewheaders.C15894a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import java.util.Date;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.chatting.i.g */
public final class C40786g extends C24961b {
    int eot = -1;

    /* renamed from: com.tencent.mm.ui.chatting.i.g$a */
    class C23794a extends C30455b {
        public String appId;
        public String desc;
        public int iconRes;
        public int yZy;
        public int yZz = 0;

        public C23794a(long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
            super(j, i, str, j2, str2, str3, str4, str5);
        }

        public final boolean arg(String str) {
            AppMethodBeat.m2504i(32629);
            if (str != null) {
                boolean arg = super.arg(str);
                if (!arg) {
                    arg = this.title.contains(str);
                }
                AppMethodBeat.m2505o(32629);
                return arg;
            }
            AppMethodBeat.m2505o(32629);
            return false;
        }

        public final int getType() {
            return this.type;
        }

        public final String toString() {
            AppMethodBeat.m2504i(32630);
            String str = "PayMediaHistoryListItem{appId='" + this.appId + '\'' + ", desc='" + this.desc + '\'' + ", timestamp=" + this.timestamp + ", type=" + this.type + ", title='" + this.title + '\'' + ", msgId=" + this.cvx + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", remarkName='" + this.bCv + '\'' + ", nameInRoom='" + this.iQV + '\'' + '}';
            AppMethodBeat.m2505o(32630);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.i.g$b */
    class C36874b extends C30453a {
        TextView gnC;
        ImageView iqT;

        public C36874b(View view) {
            super(view);
            AppMethodBeat.m2504i(32631);
            this.iqT = (ImageView) view.findViewById(2131821479);
            this.gnB.setSingleLine(false);
            this.gnB.setMaxLines(2);
            this.gnC = (TextView) view.findViewById(2131820603);
            AppMethodBeat.m2505o(32631);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.i.g$1 */
    class C407851 implements Runnable {
        final /* synthetic */ boolean kve = true;

        /* renamed from: com.tencent.mm.ui.chatting.i.g$1$1 */
        class C305431 implements Runnable {
            C305431() {
            }

            public final void run() {
                AppMethodBeat.m2504i(32626);
                if (C40786g.this.yYY != null) {
                    C40786g.this.yYY.mo27870p(C407851.this.kve, C40786g.this.iPr.size());
                }
                AppMethodBeat.m2505o(32626);
            }
        }

        C407851() {
        }

        public final void run() {
            AppMethodBeat.m2504i(32627);
            LinkedList linkedList = new LinkedList();
            C9638aw.m17190ZK();
            Cursor cD = C18628c.m29080XO().mo15319cD(C40786g.this.emo, C40786g.this.eot);
            if (cD == null) {
                C4990ab.m7412e("MicroMsg.PayHistoryListPresenter", "[loadData] cursor is null!");
                AppMethodBeat.m2505o(32627);
                return;
            }
            C7577u oa;
            if (C1855t.m3896kH(C40786g.this.emo)) {
                C9638aw.m17190ZK();
                oa = C18628c.m29087XV().mo14885oa(C40786g.this.emo);
            } else {
                oa = null;
            }
            long j = 0;
            while (cD.moveToNext()) {
                try {
                    long b;
                    C6575cy c7620bi = new C7620bi();
                    c7620bi.mo8995d(cD);
                    String str = c7620bi.field_content;
                    if (str != null) {
                        C8910b X = C8910b.m16058X(str, c7620bi.field_reserved);
                        if (C40786g.m70642pY(C5046bo.ank(X.fhY)) || C40786g.m70642pY(c7620bi.getType())) {
                            Object obj;
                            String b2 = C24961b.m39082b(c7620bi, C1855t.m3896kH(C40786g.this.emo));
                            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(b2);
                            String str2 = "";
                            if (oa != null) {
                                str2 = oa.mo16807mJ(b2);
                            }
                            C23794a c23794a;
                            if (C40786g.m70642pY(c7620bi.getType())) {
                                c23794a = new C23794a(c7620bi.field_createTime, c7620bi.getType(), X.fhw, c7620bi.field_msgId, aoO.field_username, aoO.mo16706Oi(), aoO.field_conRemark, str2);
                                C37810vb c37810vb = new C37810vb();
                                c37810vb.cRW.cEa = X.fhy;
                                C4879a.xxA.mo10055m(c37810vb);
                                boolean z = c7620bi.field_isSend == 1 ? c37810vb.cRX.cRY : !c37810vb.cRX.cRY;
                                if (c37810vb.cRX.status == -2) {
                                    z = false;
                                }
                                if (z) {
                                    int i;
                                    int i2 = c37810vb.cRX.status;
                                    if (i2 <= 0) {
                                        i2 = X.fhv;
                                    }
                                    c23794a.nickname = C40786g.this.mContext.getResources().getString(C25738R.string.es0, new Object[]{c23794a.nickname});
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
                                    c23794a.yZz = i;
                                    c23794a.desc = C40786g.m70641a(C40786g.this, C40786g.this.mContext, c7620bi, X, z, i2);
                                    Context context = C40786g.this.mContext;
                                    if (X != null && context != null) {
                                        switch (i2) {
                                            case 1:
                                            case 7:
                                                i = C1318a.c2c_remittance_icon;
                                                break;
                                            case 3:
                                                i = C1318a.c2c_remittance_received_icon;
                                                break;
                                            case 4:
                                                i = C1318a.c2c_remittance_rejected_icon;
                                                break;
                                            case 5:
                                                i = C1318a.c2c_remittance_received_icon;
                                                break;
                                            case 6:
                                                i = C1318a.c2c_remittance_cancle_icon;
                                                break;
                                            default:
                                                i = C1318a.c2c_remittance_icon;
                                                break;
                                        }
                                    }
                                    i = C1318a.c2c_remittance_icon;
                                    c23794a.iconRes = i;
                                    obj = c23794a;
                                } else {
                                    C4990ab.m7417i("MicroMsg.PayHistoryListPresenter", "[loadData] it's not payer! isSend:%s, status:%s pass this msg:%s date:%s item:%s", Boolean.valueOf(c37810vb.cRX.cRY), Integer.valueOf(c37810vb.cRX.status), Long.valueOf(c7620bi.field_msgId), C40786g.this.yYZ.mo48857ha(c23794a.timestamp), c23794a.toString());
                                }
                            } else {
                                c23794a = new C23794a(c7620bi.field_createTime, c7620bi.getType(), X.fhT, c7620bi.field_msgId, aoO.field_username, aoO.mo16706Oi(), aoO.field_conRemark, str2);
                                c23794a.yZy = C5046bo.ank(X.fhY);
                                C23794a obj2;
                                if (c23794a.yZy == C5046bo.ank("1001")) {
                                    boolean z2;
                                    c23794a.nickname = C40786g.this.mContext.getResources().getString(C25738R.string.ery, new Object[]{c23794a.nickname});
                                    if (c7620bi.field_isSend == 1) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    c23794a.desc = C15642f.m23930b(X, z2);
                                    if (c7620bi.field_isSend == 1) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    c23794a.yZz = C15642f.m23932d(X, z2);
                                    c23794a.iconRes = C15642f.m23928a(X, c7620bi.field_isSend == 1);
                                    obj2 = c23794a;
                                } else {
                                    C45378va c45378va = new C45378va();
                                    c45378va.cRQ.cRS = X.fhZ;
                                    C4879a.xxA.mo10055m(c45378va);
                                    c23794a.nickname = C40786g.this.mContext.getResources().getString(C25738R.string.erz, new Object[]{c23794a.nickname});
                                    c23794a.desc = C15642f.m23929a(c45378va.cRR.cRT, c45378va.cRR.cRU, c45378va.cRR.cRV, c7620bi.field_isSend == 1, C1855t.m3896kH(C40786g.this.emo));
                                    int identifier = C40786g.this.mContext.getResources().getIdentifier(((C17872c) X.mo20333X(C17872c.class)).ffN, "drawable", C4996ah.getPackageName());
                                    c23794a.iconRes = C15642f.m23935w(c45378va.cRR.cRU, c45378va.cRR.cRV, c7620bi.field_isSend == 1);
                                    if (c23794a.iconRes <= 0) {
                                        c23794a.iconRes = identifier;
                                    }
                                    obj2 = c23794a;
                                }
                            }
                            b = C15894a.dJg().mo28138b(new Date(c7620bi.field_createTime));
                            if (j != b) {
                                linkedList.add(new C30454c(c7620bi.field_createTime));
                            }
                            linkedList.add(obj2);
                            j = b;
                        }
                    }
                    b = j;
                    j = b;
                } catch (Throwable th) {
                    cD.close();
                    AppMethodBeat.m2505o(32627);
                }
            }
            cD.close();
            C40786g.this.iPr.addAll(linkedList);
            C40786g.this.yZa = C40786g.this.iPr;
            linkedList.clear();
            C5004al.m7441d(new C305431());
            AppMethodBeat.m2505o(32627);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.i.g$2 */
    class C407872 implements C30451e {
        C407872() {
        }

        /* renamed from: a */
        public final void mo48855a(View view, int i, C30455b c30455b) {
            AppMethodBeat.m2504i(32628);
            Context context = C40786g.this.mContext;
            String str = C40786g.this.emo;
            long j = c30455b.cvx;
            if (str == null) {
                C4990ab.m7412e("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] username is null");
                AppMethodBeat.m2505o(32628);
                return;
            }
            C9638aw.m17190ZK();
            C4990ab.m7417i("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] msgLocalId:%s", Long.valueOf(C18628c.m29080XO().mo15340jf(j).field_msgId));
            if (C1855t.m3896kH(str)) {
                C9638aw.m17190ZK();
                if (C18628c.m29087XV().mo14885oa(str) == null) {
                    C4990ab.m7421w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] member is null! username:%s", str);
                    C30379h.m48438a(context, context.getString(C25738R.string.dnb), context.getString(C25738R.string.ewj), null);
                    AppMethodBeat.m2505o(32628);
                    return;
                }
            }
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(str);
            if (aoO == null || !C7486a.m12942jh(aoO.field_type)) {
                if (aoO == null) {
                    C4990ab.m7421w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] contact is null! username:%s", str);
                } else {
                    C4990ab.m7421w("MicroMsg.PayHistoryListPresenter", "[gotoChattingUIWithPosition] isContact not ! username:%s", str);
                }
                C30379h.m48438a(context, context.getString(C25738R.string.dnb), context.getString(C25738R.string.ewj), null);
                AppMethodBeat.m2505o(32628);
                return;
            }
            Intent putExtra = new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", j);
            putExtra.setClass(context, ChattingUI.class);
            context.startActivity(putExtra);
            AppMethodBeat.m2505o(32628);
        }

        /* renamed from: b */
        public final void mo48856b(View view, int i, C30455b c30455b) {
        }
    }

    public C40786g(Context context) {
        super(context);
    }

    public final int getType() {
        return 5;
    }

    /* renamed from: pY */
    public static boolean m70642pY(int i) {
        AppMethodBeat.m2504i(32632);
        if (C5046bo.ank("1001") == i || C5046bo.ank("1002") == i || 419430449 == i) {
            AppMethodBeat.m2505o(32632);
            return true;
        }
        AppMethodBeat.m2505o(32632);
        return false;
    }

    public final void dFH() {
        AppMethodBeat.m2504i(32633);
        this.yYY.dFL();
        C1720g.m3537RQ();
        C1720g.m3539RS().mo10302aa(new C407851());
        AppMethodBeat.m2505o(32633);
    }

    public final String aoy() {
        AppMethodBeat.m2504i(32634);
        String string = this.mContext.getString(C25738R.string.dzo);
        AppMethodBeat.m2505o(32634);
        return string;
    }

    public final String dFK() {
        AppMethodBeat.m2504i(32635);
        String string = this.mContext.getString(C25738R.string.dzo);
        AppMethodBeat.m2505o(32635);
        return string;
    }

    public final C30451e dFI() {
        AppMethodBeat.m2504i(32636);
        C407872 c407872 = new C407872();
        AppMethodBeat.m2505o(32636);
        return c407872;
    }

    /* renamed from: v */
    public final C41531v mo39525v(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(32637);
        C36874b c36874b = new C36874b(LayoutInflater.from(viewGroup.getContext()).inflate(2130969547, viewGroup, false));
        AppMethodBeat.m2505o(32637);
        return c36874b;
    }

    /* renamed from: a */
    public final void mo39523a(C30453a c30453a, int i) {
        AppMethodBeat.m2504i(32638);
        C36874b c36874b = (C36874b) c30453a;
        C23794a c23794a = (C23794a) mo39522Oy(i);
        if (C5046bo.isNullOrNil(c23794a.desc)) {
            c36874b.gnC.setVisibility(8);
        } else {
            c36874b.gnC.setVisibility(0);
            c36874b.gnC.setText(C5046bo.m7532bc(c23794a.desc, ""));
        }
        int fromDPToPix = C1338a.fromDPToPix(this.mContext, 6);
        c36874b.iqT.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        c36874b.iqT.setImageResource(c23794a.iconRes);
        c36874b.iqT.setBackgroundColor(c23794a.yZz);
        AppMethodBeat.m2505o(32638);
    }

    /* renamed from: a */
    static /* synthetic */ String m70641a(C40786g c40786g, Context context, C7620bi c7620bi, C8910b c8910b, boolean z, int i) {
        AppMethodBeat.m2504i(32639);
        String str;
        if (c8910b == null || context == null) {
            str = "";
            AppMethodBeat.m2505o(32639);
            return str;
        }
        switch (i) {
            case 1:
            case 7:
                C9638aw.m17190ZK();
                C7616ad aoN = C18628c.m29078XM().aoN(c7620bi.field_talker);
                if (aoN != null) {
                    str = aoN.mo16707Oj();
                } else {
                    str = c7620bi.field_talker;
                }
                if (z) {
                    if (C5046bo.isNullOrNil(c8910b.fiF)) {
                        if (c7620bi.field_isSend == 1) {
                            str = c40786g.mContext.getString(C25738R.string.alk, new Object[]{str});
                            break;
                        }
                        str = c40786g.mContext.getString(C25738R.string.all);
                        break;
                    }
                    str = c8910b.fiF;
                    break;
                }
                str = c40786g.mContext.getString(C25738R.string.alc);
                break;
            case 3:
                if (z) {
                    if (!C5046bo.isNullOrNil(c8910b.fiF)) {
                        str = C4996ah.getContext().getString(C25738R.string.alb) + "-" + c8910b.fiF;
                        break;
                    }
                    str = C4996ah.getContext().getString(C25738R.string.alb);
                    break;
                }
                str = C4996ah.getContext().getString(C25738R.string.alc);
                break;
            case 4:
                if (z) {
                    if (!C5046bo.isNullOrNil(c8910b.fiF)) {
                        str = C4996ah.getContext().getString(C25738R.string.alo) + "-" + c8910b.fiF;
                        break;
                    }
                    str = C4996ah.getContext().getString(C25738R.string.alo);
                    break;
                }
                str = C4996ah.getContext().getString(C25738R.string.aln);
                break;
            case 5:
                if (z) {
                    if (!C5046bo.isNullOrNil(c8910b.fiF)) {
                        str = C4996ah.getContext().getString(C25738R.string.ali) + "-" + c8910b.fiF;
                        break;
                    }
                    str = C4996ah.getContext().getString(C25738R.string.ali);
                    break;
                }
                str = C4996ah.getContext().getString(C25738R.string.alj);
                break;
            case 6:
                str = context.getResources().getString(C25738R.string.ald);
                break;
            default:
                str = c8910b.description;
                break;
        }
        AppMethodBeat.m2505o(32639);
        return str;
    }
}
