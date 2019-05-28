package com.tencent.p177mm.p612ui.chatting.p616c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.chatroom.p216ui.DelChatroomMemberUI;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C32794m;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.openim.room.p266a.C42249a;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p230g.p231a.C41965as;
import com.tencent.p177mm.p230g.p231a.C45322ez;
import com.tencent.p177mm.p230g.p231a.C9480tg;
import com.tencent.p177mm.p612ui.C30777u;
import com.tencent.p177mm.p612ui.C30777u.C30784a;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44299r;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C7335f;
import com.tencent.p177mm.p837bh.C25859d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.roomsdk.p1086a.C30262b;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C44204b;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C44206d;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C46609a;
import com.tencent.p177mm.roomsdk.p1086a.p1342c.C30267d;
import com.tencent.p177mm.roomsdk.p1086a.p1342c.C46610a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@C15590a(dFp = C7335f.class)
/* renamed from: com.tencent.mm.ui.chatting.c.e */
public class C23740e extends C44291a implements C1202f, C4937b, C7335f {
    protected boolean yOr = false;
    protected Map<String, String> yOs = new HashMap();
    private C4884c yOt = new C237411();
    private final C4931a yOu = new C237517();
    private C4884c yOv = new C237508();
    C30267d yOw;
    private boolean yOx = false;
    private boolean yoR = false;

    /* renamed from: com.tencent.mm.ui.chatting.c.e$9 */
    class C53139 implements OnClickListener {
        C53139() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.e$11 */
    class C2373611 implements OnClickListener {
        C2373611() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.e$13 */
    class C2373713 implements OnClickListener {
        C2373713() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.e$14 */
    class C2373814 implements C44204b {
        C2373814() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo11081a(int i, int i2, String str, C46609a c46609a) {
            AppMethodBeat.m2504i(31257);
            if (C5046bo.m7544cv(C23740e.this.cgL.yTx.getContext()) && !C23740e.m36607b(C23740e.this.cgL.yTx.getContext(), i, i2, str)) {
                C4990ab.m7411d("MicroMsg.ActionCallbackFunc", "scene type:%s errCode:%s, errType:%s, errMsg:%s", Integer.valueOf(610), Integer.valueOf(i2), Integer.valueOf(i), C5046bo.nullAsNil(str));
                C30379h.m48461b(C23740e.this.cgL.yTx.getContext(), C23740e.this.cgL.yTx.getMMResources().getString(C25738R.string.cen), C23740e.this.cgL.yTx.getMMResources().getString(C25738R.string.f9238tz), true);
            }
            AppMethodBeat.m2505o(31257);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.e$1 */
    class C237411 extends C4884c<C41965as> {
        C237411() {
            AppMethodBeat.m2504i(31242);
            this.xxI = C41965as.class.getName().hashCode();
            AppMethodBeat.m2505o(31242);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(31243);
            C41965as c41965as = (C41965as) c4883b;
            if ((c41965as instanceof C41965as) && C23740e.this.cgL.getTalkerUserName() != null && !C5046bo.isNullOrNil(c41965as.ctO.username) && c41965as.ctO.username.equals(C23740e.this.cgL.getTalkerUserName())) {
                C23740e.m36605a(C23740e.this);
            }
            AppMethodBeat.m2505o(31243);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.e$4 */
    class C237484 implements C44204b {

        /* renamed from: com.tencent.mm.ui.chatting.c.e$4$1 */
        class C237391 implements OnClickListener {
            C237391() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C237484() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo11081a(int i, int i2, String str, C46609a c46609a) {
            AppMethodBeat.m2504i(31246);
            C23740e.this.cgL.dismissDialog();
            C30379h.m48447a(C23740e.this.cgL.yTx.getContext(), C23740e.this.cgL.yTx.getMMResources().getString(C25738R.string.dsf), null, C23740e.this.cgL.yTx.getMMResources().getString(C25738R.string.f9187s6), false, new C237391());
            AppMethodBeat.m2505o(31246);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.e$5 */
    class C237495 implements C44204b {
        C237495() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo11081a(int i, int i2, String str, C46609a c46609a) {
            AppMethodBeat.m2504i(31247);
            C23740e.this.cgL.dismissDialog();
            C30379h.m48465bQ(C23740e.this.cgL.yTx.getContext(), C23740e.this.cgL.yTx.getMMResources().getString(C25738R.string.ds5));
            AppMethodBeat.m2505o(31247);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.e$8 */
    class C237508 extends C4884c<C9480tg> {
        C237508() {
            AppMethodBeat.m2504i(31251);
            this.xxI = C9480tg.class.getName().hashCode();
            AppMethodBeat.m2505o(31251);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(31252);
            C9480tg c9480tg = (C9480tg) c4883b;
            if ((!(c9480tg instanceof C9480tg) || C23740e.this.cgL.getTalkerUserName().equals(c9480tg.cPx.userName)) && C1855t.m3896kH(C23740e.this.cgL.getTalkerUserName())) {
                C30379h.m48461b(C23740e.this.cgL.yTx.getContext(), C23740e.this.cgL.yTx.getMMResources().getString(C25738R.string.exm), null, true);
            }
            AppMethodBeat.m2505o(31252);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.e$7 */
    class C237517 implements C4931a {
        C237517() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(31250);
            C4990ab.m7418v("MicroMsg.ChattingUI.ChatroomComponent", "roommember watcher notify ".concat(String.valueOf(str)));
            if (((C36135d) C23740e.this.cgL.mo74857aF(C36135d.class)).dDn()) {
                C23740e.this.yoR = C25754e.m40893c(((C36135d) C23740e.this.cgL.mo74857aF(C36135d.class)).dDk());
            } else {
                C23740e.this.yoR = C37921n.m64068ms(C23740e.this.cgL.getTalkerUserName());
            }
            if (C23740e.this.yOr) {
                C37921n.m64059f(C23740e.this.cgL.getTalkerUserName(), C23740e.this.yOs);
            } else {
                C23740e.this.yOs.clear();
            }
            if (!C5046bo.isNullOrNil(str)) {
                C23740e.this.cgL.aWv();
            }
            AppMethodBeat.m2505o(31250);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.e$10 */
    class C2375210 implements OnClickListener {
        C2375210() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.e$6 */
    class C237536 implements Runnable {

        /* renamed from: com.tencent.mm.ui.chatting.c.e$6$1 */
        class C237541 implements C44204b {
            C237541() {
            }

            /* renamed from: a */
            public final /* synthetic */ void mo11081a(int i, int i2, String str, C46609a c46609a) {
                AppMethodBeat.m2504i(31248);
                if (C5046bo.m7544cv(C23740e.this.cgL.yTx.getContext())) {
                    C4990ab.m7416i("MicroMsg.ActionCallbackFunc", "cpan[refresh top btn]");
                    C23740e.this.yoR = C37921n.m64068ms(C23740e.this.cgL.getTalkerUserName());
                    ((C44299r) C23740e.this.cgL.mo74857aF(C44299r.class)).dEp();
                }
                AppMethodBeat.m2505o(31248);
            }
        }

        C237536() {
        }

        public final void run() {
            AppMethodBeat.m2504i(31249);
            if (C23740e.this.cgL == null) {
                C4990ab.m7412e("MicroMsg.ChattingUI.ChatroomComponent", "[getChatroomMemberDetail] mChattingContext is null!");
                AppMethodBeat.m2505o(31249);
                return;
            }
            C9638aw.m17190ZK();
            C7577u oa = C18628c.m29087XV().mo14885oa(C23740e.this.cgL.getTalkerUserName());
            if (oa != null && oa.drU()) {
                C4990ab.m7410d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[doScene NetSceneGetChatroomMemberDetail]");
                C46610a D = C30262b.alY(C23740e.this.cgL.getTalkerUserName()).mo20626D(C23740e.this.cgL.getTalkerUserName(), oa.drT());
                D.mo74753b(new C237541());
                D.dmX();
            }
            AppMethodBeat.m2505o(31249);
        }
    }

    public C23740e() {
        AppMethodBeat.m2504i(31258);
        AppMethodBeat.m2505o(31258);
    }

    /* renamed from: a */
    static /* synthetic */ void m36605a(C23740e c23740e) {
        AppMethodBeat.m2504i(31275);
        c23740e.dDG();
        AppMethodBeat.m2505o(31275);
    }

    public final CharSequence arj(String str) {
        AppMethodBeat.m2504i(31259);
        C36135d c36135d = (C36135d) this.cgL.mo74857aF(C36135d.class);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        String mK = C1854s.m3867mK(str);
        CharSequence mJ;
        if (c36135d.dDm() || C5046bo.isNullOrNil(mK)) {
            if (this.yOs.containsKey(str)) {
                mK = (String) this.yOs.get(str);
                if (!C5046bo.isNullOrNil(mK)) {
                    AppMethodBeat.m2505o(31259);
                    return mK;
                }
            }
            if (c36135d.dDm()) {
                mJ = c36135d.dDk().mo73053mJ(str);
                AppMethodBeat.m2505o(31259);
                return mJ;
            }
            mJ = C42249a.m74596a(aoO, C1854s.m3866mJ(str));
            AppMethodBeat.m2505o(31259);
            return mJ;
        }
        mJ = C42249a.m74596a(aoO, mK);
        AppMethodBeat.m2505o(31259);
        return mJ;
    }

    public final boolean dDE() {
        return this.yOr;
    }

    public final boolean dDF() {
        AppMethodBeat.m2504i(31260);
        if (this.yoR || ((C36135d) this.cgL.mo74857aF(C36135d.class)).dDs()) {
            AppMethodBeat.m2505o(31260);
            return true;
        }
        AppMethodBeat.m2505o(31260);
        return false;
    }

    /* renamed from: aJ */
    public final void mo15841aJ(LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(31261);
        C9638aw.m17190ZK();
        C7577u oa = C18628c.m29087XV().mo14885oa(this.cgL.getTalkerUserName());
        if (oa == null) {
            C30379h.m48443a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.dsc), null, this.cgL.yTx.getMMResources().getString(C25738R.string.ds8), new C53139());
            AppMethodBeat.m2505o(31261);
            return;
        }
        String str;
        this.cgL.getTalkerUserName();
        final List linkedList2 = new LinkedList();
        List afg = oa.afg();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            if (afg != null && afg.contains(str)) {
                linkedList2.add(str);
            }
        }
        if (linkedList2.size() == 0) {
            if (linkedList.size() == 1) {
                C30379h.m48443a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.ds7), null, this.cgL.yTx.getMMResources().getString(C25738R.string.ds8), new C2375210());
                AppMethodBeat.m2505o(31261);
                return;
            }
            C30379h.m48443a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.ds2), null, this.cgL.yTx.getMMResources().getString(C25738R.string.ds8), new C2373611());
            AppMethodBeat.m2505o(31261);
        } else if (linkedList.size() == 1) {
            Resources mMResources = this.cgL.yTx.getMMResources();
            Object[] objArr = new Object[1];
            str = (String) linkedList.get(0);
            if (((C36135d) this.cgL.mo74857aF(C36135d.class)).dDn() || this.cgL.dFw()) {
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO(str);
                if (!(aoO == null || ((int) aoO.ewQ) == 0)) {
                    if (C5046bo.isNullOrNil(aoO.field_conRemark)) {
                        C9638aw.m17190ZK();
                        oa = C18628c.m29087XV().mo14885oa(this.cgL.getTalkerUserName());
                        if (oa == null) {
                            str = null;
                        } else {
                            str = oa.mo16807mJ(aoO.field_username);
                        }
                    } else {
                        str = aoO.field_conRemark;
                    }
                    if (C5046bo.isNullOrNil(str)) {
                        str = aoO.field_conRemark;
                    }
                    if (C5046bo.isNullOrNil(str)) {
                        str = aoO.mo16706Oi();
                    }
                }
            } else {
                str = null;
            }
            objArr[0] = str;
            C30379h.m48445a(this.cgL.yTx.getContext(), mMResources.getString(C25738R.string.ds1, objArr), null, this.cgL.yTx.getMMResources().getString(C25738R.string.ds9), this.cgL.yTx.getMMResources().getString(C25738R.string.f9076or), true, new OnClickListener() {
                final /* synthetic */ int fwD = 1;

                /* renamed from: com.tencent.mm.ui.chatting.c.e$12$1 */
                class C237441 implements C44204b {
                    C237441() {
                    }

                    /* renamed from: a */
                    public final /* synthetic */ void mo11081a(int i, int i2, String str, C46609a c46609a) {
                        AppMethodBeat.m2504i(31253);
                        C30379h.m48465bQ(C23740e.this.cgL.yTx.getContext(), C23740e.this.cgL.yTx.getMMResources().getString(C25738R.string.ds_));
                        AppMethodBeat.m2505o(31253);
                    }
                }

                /* renamed from: com.tencent.mm.ui.chatting.c.e$12$2 */
                class C237452 implements C44204b {

                    /* renamed from: com.tencent.mm.ui.chatting.c.e$12$2$1 */
                    class C237461 implements OnClickListener {
                        C237461() {
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }

                    /* renamed from: com.tencent.mm.ui.chatting.c.e$12$2$2 */
                    class C237472 implements OnClickListener {
                        C237472() {
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }

                    C237452() {
                    }

                    /* renamed from: a */
                    public final /* synthetic */ void mo11081a(int i, int i2, String str, C46609a c46609a) {
                        AppMethodBeat.m2504i(31254);
                        if (!(i == 0 && i2 == 0)) {
                            if (i2 == -2024) {
                                C42124a jY = C42124a.m74268jY(str);
                                if (jY != null) {
                                    jY.mo67668a(C23740e.this.cgL.yTx.getContext(), null, null);
                                    AppMethodBeat.m2505o(31254);
                                    return;
                                }
                                C30379h.m48447a(C23740e.this.cgL.yTx.getContext(), C23740e.this.cgL.yTx.getMMResources().getString(C25738R.string.ds7), null, C23740e.this.cgL.yTx.getMMResources().getString(C25738R.string.ds8), false, new C237461());
                                AppMethodBeat.m2505o(31254);
                                return;
                            }
                            C30379h.m48447a(C23740e.this.cgL.yTx.getContext(), C23740e.this.cgL.yTx.getMMResources().getString(C25738R.string.dsf), null, C23740e.this.cgL.yTx.getMMResources().getString(C25738R.string.f9187s6), false, new C237472());
                        }
                        AppMethodBeat.m2505o(31254);
                    }
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(31256);
                    final C46610a a = C30262b.alY(C23740e.this.cgL.getTalkerUserName()).mo20632a(C23740e.this.cgL.getTalkerUserName(), linkedList2, this.fwD);
                    a.mo74753b(new C237441());
                    a.mo74754c(new C237452());
                    Activity context = C23740e.this.cgL.yTx.getContext();
                    C23740e.this.cgL.yTx.getMMResources().getString(C25738R.string.f9238tz);
                    a.mo48450a(context, C23740e.this.cgL.yTx.getMMResources().getString(C25738R.string.drx), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.m2504i(31255);
                            a.cancel();
                            AppMethodBeat.m2505o(31255);
                        }
                    });
                    AppMethodBeat.m2505o(31256);
                }
            }, new C2373713());
            AppMethodBeat.m2505o(31261);
        } else {
            Intent intent = new Intent(this.cgL.yTx.getContext(), DelChatroomMemberUI.class);
            intent.putExtra("members", C5046bo.m7536c(linkedList2, ","));
            intent.putExtra("RoomInfo_Id", this.cgL.getTalkerUserName());
            intent.putExtra("scene", 1);
            this.cgL.startActivity(intent);
            AppMethodBeat.m2505o(31261);
        }
    }

    /* renamed from: a */
    public final void mo15840a(List<String> list, String str, C7620bi c7620bi) {
        AppMethodBeat.m2504i(31262);
        final C46610a a = C30262b.alY(this.cgL.getTalkerUserName()).mo20634a(this.cgL.dFw() ? this.cgL.getTalkerUserName() : "", list, str, c7620bi);
        a.mo74753b(new C44206d() {
            /* renamed from: a */
            public final /* synthetic */ void mo11081a(int i, int i2, String str, C46609a c46609a) {
                AppMethodBeat.m2504i(31244);
                C44206d c44206d = (C44206d) c46609a;
                if (C5046bo.m7544cv(C23740e.this.cgL.yTx.getContext()) && !C23740e.m36607b(C23740e.this.cgL.yTx.getContext(), i, i2, str)) {
                    C7620bi c7620bi = c44206d.xuW;
                    if (c7620bi == null) {
                        AppMethodBeat.m2505o(31244);
                        return;
                    }
                    c7620bi.dtQ();
                    C9638aw.m17190ZK();
                    C18628c.m29080XO().mo15302b(c7620bi.field_msgSvrId, c7620bi);
                    Toast.makeText(C23740e.this.cgL.yTx.getContext(), C23740e.this.cgL.yTx.getMMResources().getString(C25738R.string.cep), 0).show();
                    if (a.dmW()) {
                        C7060h.pYm.mo8378a(219, 24, (long) c44206d.ehB, true);
                    }
                }
                AppMethodBeat.m2505o(31244);
            }
        }).mo74754c(new C2373814());
        Activity context = this.cgL.yTx.getContext();
        this.cgL.yTx.getMMResources().getString(C25738R.string.f9238tz);
        a.mo48450a(context, this.cgL.yTx.getMMResources().getString(C25738R.string.dsq), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(31245);
                a.cancel();
                AppMethodBeat.m2505o(31245);
            }
        });
        AppMethodBeat.m2505o(31262);
    }

    private void dBr() {
        AppMethodBeat.m2504i(31263);
        C36135d c36135d = (C36135d) this.cgL.mo74857aF(C36135d.class);
        if (C1855t.m3896kH(this.cgL.getTalkerUserName())) {
            this.yOr = C37921n.m64066mq(this.cgL.getTalkerUserName());
            if (this.yOr) {
                C37921n.m64059f(this.cgL.getTalkerUserName(), this.yOs);
            } else {
                this.yOs.clear();
            }
            C4990ab.m7410d("MicroMsg.ChattingUI.ChatroomComponent", "chatroom display  " + (this.yOr ? "show " : "not show"));
            AppMethodBeat.m2505o(31263);
        } else if (c36135d.dDn()) {
            this.yOr = true;
            AppMethodBeat.m2505o(31263);
        } else {
            this.yOr = false;
            this.yOs.clear();
            AppMethodBeat.m2505o(31263);
        }
    }

    private void dDi() {
        AppMethodBeat.m2504i(31264);
        C9638aw.m17182Rg().mo14546b(610, (C1202f) this);
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10121b(this);
        C9638aw.m17182Rg().mo14546b(551, (C1202f) this);
        if (this.yOw != null) {
            this.yOw.dead();
        }
        if (C9638aw.m17179RK()) {
            C9638aw.m17190ZK();
            C18628c.m29087XV().mo10117d(this.yOu);
            C4879a.xxA.mo10053d(this.yOt);
            C4879a.xxA.mo10053d(this.yOv);
        }
        AppMethodBeat.m2505o(31264);
    }

    private void dDG() {
        AppMethodBeat.m2504i(31265);
        if (this.cgL.sRl == null) {
            C4990ab.m7412e("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomMemberDetail() talker == null");
            AppMethodBeat.m2505o(31265);
            return;
        }
        if (C1855t.m3901mN(this.cgL.getTalkerUserName())) {
            C4990ab.m7410d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[changeTalker]");
            new C7306ak().postDelayed(new C237536(), 1000);
        }
        AppMethodBeat.m2505o(31265);
    }

    public final void dxx() {
        AppMethodBeat.m2504i(31266);
        if (this.cgL.dFw()) {
            this.yoR = C37921n.m64068ms(this.cgL.getTalkerUserName());
        }
        AppMethodBeat.m2505o(31266);
    }

    public final void dxy() {
        AppMethodBeat.m2504i(31267);
        this.yOx = true;
        dBr();
        AppMethodBeat.m2505o(31267);
    }

    public final void dxA() {
        AppMethodBeat.m2504i(31269);
        if (!this.yOx) {
            dBr();
        }
        this.yOx = false;
        AppMethodBeat.m2505o(31269);
    }

    public final void dxB() {
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31270);
        super.dDh();
        dDi();
        AppMethodBeat.m2505o(31270);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31271);
        dDi();
        AppMethodBeat.m2505o(31271);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(31272);
        C4990ab.m7416i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " sceneType:" + c1207m.getType());
        this.cgL.dismissDialog();
        if (!this.cgL.caA) {
            C4990ab.m7416i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd fragment not foreground, return");
            AppMethodBeat.m2505o(31272);
        } else if (!C5046bo.m7544cv(this.cgL.yTx.getContext())) {
            AppMethodBeat.m2505o(31272);
        } else if (C23740e.m36607b(this.cgL.yTx.getContext(), i, i2, str)) {
            AppMethodBeat.m2505o(31272);
        } else {
            if (i == 0 && i2 == 0) {
                switch (c1207m.getType()) {
                    case 551:
                        C4990ab.m7416i("MicroMsg.ChattingUI.ChatroomComponent", "cpan[refresh top btn]");
                        this.yoR = C37921n.m64068ms(this.cgL.getTalkerUserName());
                        ((C44299r) this.cgL.mo74857aF(C44299r.class)).dEp();
                        break;
                }
            }
            AppMethodBeat.m2505o(31272);
        }
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(31273);
        if (this.cgL == null) {
            C4990ab.m7412e("MicroMsg.ChattingUI.ChatroomComponent", "[onNotifyChange] mChattingContext is null!");
            AppMethodBeat.m2505o(31273);
        } else if (((C36135d) this.cgL.mo74857aF(C36135d.class)).dDn()) {
            this.yoR = C25754e.m40893c(((C36135d) this.cgL.mo74857aF(C36135d.class)).dDk());
            AppMethodBeat.m2505o(31273);
        } else {
            this.yoR = C37921n.m64068ms(this.cgL.getTalkerUserName());
            AppMethodBeat.m2505o(31273);
        }
    }

    /* renamed from: b */
    protected static boolean m36607b(Activity activity, int i, int i2, String str) {
        AppMethodBeat.m2504i(31274);
        if (C30784a.m49123a(activity, i, i2, str, 7)) {
            AppMethodBeat.m2505o(31274);
            return true;
        } else if (C30777u.m49118a(activity, i, i2, new Intent().setClass(activity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
            AppMethodBeat.m2505o(31274);
            return true;
        } else {
            AppMethodBeat.m2505o(31274);
            return false;
        }
    }

    public final void dxz() {
        AppMethodBeat.m2504i(31268);
        if (!C1855t.m3923nI(this.cgL.getTalkerUserName()) && C1855t.m3896kH(this.cgL.getTalkerUserName())) {
            C9638aw.m17190ZK();
            C7617ak aoZ = C18628c.m29083XR().aoZ(this.cgL.getTalkerUserName());
            if (aoZ == null || (aoZ.field_showTips & 2) > 0) {
                C4990ab.m7410d("MicroMsg.ChattingUI.ChatroomComponent", "jacks ont need auto display name because : already tips");
            } else {
                C9638aw.m17190ZK();
                C7577u oa = C18628c.m29087XV().mo14885oa(this.cgL.getTalkerUserName());
                if (oa == null || oa.afg().size() < 20) {
                    C4990ab.m7410d("MicroMsg.ChattingUI.ChatroomComponent", "jacks ont need auto display name because : member nums too few");
                } else if (!(oa == null || oa.drX())) {
                    C37921n.m64048a(this.cgL.getTalkerUserName(), oa, true);
                    aoZ.field_showTips = 2;
                    aoZ.duQ = true;
                    C9638aw.m17190ZK();
                    C18628c.m29083XR().mo15767a(aoZ, this.cgL.getTalkerUserName());
                    C4990ab.m7416i("MicroMsg.ChattingUI.ChatroomComponent", "Jacks Show auto Display name tips");
                    C32794m.m53573a(this.cgL.getTalkerUserName(), null, this.cgL.yTx.getMMResources().getString(C25738R.string.aom), false, "", 0);
                }
            }
        }
        C9638aw.m17182Rg().mo14539a(610, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(551, (C1202f) this);
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10118a(this);
        C9638aw.m17190ZK();
        C18628c.m29087XV().mo10116c(this.yOu);
        if (this.yOw != null) {
            this.yOw.dead();
        }
        this.yOw = C30262b.alY(this.cgL.getTalkerUserName()).mo20628Ju().mo48456e(new C237495()).mo48457f(new C237484()).dmY();
        C4879a.xxA.mo10052c(this.yOt);
        C4879a.xxA.mo10052c(this.yOv);
        if (C1855t.m3901mN(this.cgL.getTalkerUserName()) && C37921n.m64069mt(this.cgL.getTalkerUserName())) {
            C4990ab.m7411d("MicroMsg.ChattingUI.ChatroomComponent", "chattingui find chatroom contact need update %s", this.cgL.getTalkerUserName());
            C26417a.flu.mo20967ai(this.cgL.getTalkerUserName(), "");
        }
        if (!(C25859d.fUv == null || this.cgL.getTalkerUserName().equals(C25859d.fUv.akN()))) {
            C4990ab.m7417i("MicroMsg.ChattingUI.ChatroomComponent", "chatting oncreate end track %s", C25859d.fUv.akN());
            C45322ez c45322ez = new C45322ez();
            c45322ez.cys.username = this.cgL.getTalkerUserName();
            C4879a.xxA.mo10055m(c45322ez);
        }
        dDG();
        AppMethodBeat.m2505o(31268);
    }
}
