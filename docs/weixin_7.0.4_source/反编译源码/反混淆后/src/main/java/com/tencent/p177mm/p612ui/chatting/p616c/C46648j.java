package com.tencent.p177mm.p612ui.chatting.p616c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelstat.C45457b;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t.C9721a;
import com.tencent.p177mm.modelvideo.C9720t.C9721a.C9718a;
import com.tencent.p177mm.p181af.C1191k;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p190at.C17940d.C9017a;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C37478f;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.chatting.C23698ah;
import com.tencent.p177mm.p612ui.chatting.C23698ah.C23699a;
import com.tencent.p177mm.p612ui.chatting.C23808n;
import com.tencent.p177mm.p612ui.chatting.C30558m;
import com.tencent.p177mm.p612ui.chatting.C40707a;
import com.tencent.p177mm.p612ui.chatting.C40707a.C23688d;
import com.tencent.p177mm.p612ui.chatting.C40707a.C40706c;
import com.tencent.p177mm.p612ui.chatting.C40788j;
import com.tencent.p177mm.p612ui.chatting.C44289an;
import com.tencent.p177mm.p612ui.chatting.C44289an.C407111;
import com.tencent.p177mm.p612ui.chatting.C44289an.C407122;
import com.tencent.p177mm.p612ui.chatting.C44308i;
import com.tencent.p177mm.p612ui.chatting.C46660k;
import com.tencent.p177mm.p612ui.chatting.ChattingFooterMoreBtnBar;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15611aj;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15613i;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15614o;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C23733z;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44299r;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C46642l;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C46643s;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c;
import com.tencent.p177mm.p612ui.tools.C5601o;
import com.tencent.p177mm.p612ui.tools.C5601o.C5600b;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.snackbar.C24110a.C24112c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p1024b.C46210i;
import com.tencent.p177mm.pluginsdk.model.C40444g;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C23498az;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.wework.api.WWAPIFactory;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@C15590a(dFp = C15613i.class)
/* renamed from: com.tencent.mm.ui.chatting.c.j */
public class C46648j extends C44291a implements C23698ah, C15613i {
    public static C23498az yOM = new C23498az(5, "MicroMsg.ChattingMoreBtnBarHelper");
    private C7616ad cFn;
    private C5601o elS;
    private boolean hasInit = false;
    private Animation qzp;
    private boolean yFW;
    private String yLB = "";
    private boolean yNq = false;
    private ChattingFooterMoreBtnBar yON;
    private boolean yOO = true;

    /* renamed from: com.tencent.mm.ui.chatting.c.j$1 */
    class C53141 implements OnClickListener {
        C53141() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(31306);
            C15612h c15612h = (C15612h) C46648j.this.cgL.mo74857aF(C15612h.class);
            if (c15612h.mo27825nf(((Long) view.getTag()).longValue())) {
                int cdf = c15612h.cdf();
                ((C23733z) C46648j.this.cgL.mo74857aF(C23733z.class)).dEP();
                C46648j.this.elS.dJS();
                C46648j.this.yON.setVisibility(0);
                C46648j.this.yON.mo10921On(cdf);
            }
            AppMethodBeat.m2505o(31306);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.j$2 */
    class C53152 implements OnClickListener {
        C53152() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(31308);
            final C15612h c15612h = (C15612h) C46648j.this.cgL.mo74857aF(C15612h.class);
            if (c15612h.cdf() == 0) {
                C4990ab.m7420w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                AppMethodBeat.m2505o(31308);
                return;
            }
            final Context context = C46648j.this.cgL.yTx.getContext();
            C30379h.m48444a(context, context.getString(C25738R.string.at7), "", context.getString(C25738R.string.b59), context.getString(C25738R.string.f9076or), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(31307);
                    C4990ab.m7416i("MicroMsg.ChattingMoreBtnBarHelper", "delete message");
                    C44308i.m80089a(context, c15612h.dCQ(), C46648j.this);
                    C46648j.this.dDL();
                    AppMethodBeat.m2505o(31307);
                }
            }, null, (int) C25738R.color.f11717ei);
            AppMethodBeat.m2505o(31308);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.j$3 */
    class C53173 implements OnClickListener {
        C53173() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(31309);
            if (((C15612h) C46648j.this.cgL.mo74857aF(C15612h.class)).cdf() == 0) {
                C4990ab.m7420w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                AppMethodBeat.m2505o(31309);
                return;
            }
            C30558m.m48696a(C46648j.this.cgL, C46648j.m88292c(C46648j.this), C46648j.this.yFW, C46648j.this, C46648j.this.cFn);
            AppMethodBeat.m2505o(31309);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.j$8 */
    class C304778 implements C5600b {
        String mLR = null;

        C304778() {
        }

        /* renamed from: vO */
        public final void mo7460vO(String str) {
            AppMethodBeat.m2504i(31332);
            C4990ab.m7418v("MicroMsg.ChattingMoreBtnBarHelper", "on edit change");
            C23733z c23733z = (C23733z) C46648j.this.cgL.mo74857aF(C23733z.class);
            if (!C5046bo.isNullOrNil(str)) {
                C4990ab.m7418v("MicroMsg.ChattingMoreBtnBarHelper", "enter search mode");
                C46648j.this.yON.setVisibility(8);
                c23733z.dEO();
                if (c23733z.dER() != null) {
                    c23733z.dER().mo70200vM(str);
                }
            } else if (c23733z.dEW()) {
                if (c23733z.dER() != null) {
                    c23733z.dER().mo70200vM("");
                }
                c23733z.mo27764OD(-1);
            } else if (!C46648j.this.yNq) {
                c23733z.dEP();
                C46648j.this.yON.setVisibility(8);
            } else if (this.mLR != null) {
                c23733z.dEP();
                C46648j.this.yON.setVisibility(0);
                C46648j.this.yON.mo10921On(((C15612h) C46648j.this.cgL.mo74857aF(C15612h.class)).cdf());
            }
            this.mLR = str;
            AppMethodBeat.m2505o(31332);
        }

        public final void apo() {
            AppMethodBeat.m2504i(31333);
            C4990ab.m7418v("MicroMsg.ChattingMoreBtnBarHelper", "onQuitSearch");
            C15612h c15612h = (C15612h) C46648j.this.cgL.mo74857aF(C15612h.class);
            if (c15612h.isInEditMode()) {
                ((C23733z) C46648j.this.cgL.mo74857aF(C23733z.class)).dEP();
                C46648j.this.yON.setVisibility(0);
                C46648j.this.yON.mo10921On(c15612h.cdf());
            }
            AppMethodBeat.m2505o(31333);
        }

        public final void app() {
            AppMethodBeat.m2504i(31334);
            C4990ab.m7418v("MicroMsg.ChattingMoreBtnBarHelper", "onEnterSearch");
            C7060h.pYm.mo8378a(219, 21, 1, true);
            if (((C15612h) C46648j.this.cgL.mo74857aF(C15612h.class)).isInEditMode()) {
                ((C23733z) C46648j.this.cgL.mo74857aF(C23733z.class)).dEO();
                C46648j.this.yON.setVisibility(8);
            }
            AppMethodBeat.m2505o(31334);
        }

        /* renamed from: vN */
        public final boolean mo7459vN(String str) {
            return false;
        }

        public final void apq() {
        }

        public final void apr() {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.j$4 */
    class C407304 implements OnClickListener {

        /* renamed from: com.tencent.mm.ui.chatting.c.j$4$2 */
        class C156202 implements DialogInterface.OnClickListener {
            C156202() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* renamed from: com.tencent.mm.ui.chatting.c.j$4$1 */
        class C304761 implements DialogInterface.OnClickListener {
            C304761() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* renamed from: com.tencent.mm.ui.chatting.c.j$4$3 */
        class C361453 implements DialogInterface.OnClickListener {
            C361453() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C407304() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(31310);
            if (((C15612h) C46648j.this.cgL.mo74857aF(C15612h.class)).cdf() == 0) {
                C4990ab.m7420w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                AppMethodBeat.m2505o(31310);
                return;
            }
            List c = C46648j.m88292c(C46648j.this);
            if (C40788j.m70677eS(c)) {
                C30379h.m48443a(C46648j.this.cgL.yTx.getContext(), C46648j.this.cgL.yTx.getContext().getString(C25738R.string.b2y), "", C46648j.this.cgL.yTx.getContext().getString(C25738R.string.f8636aj), new C304761());
                AppMethodBeat.m2505o(31310);
            } else if (C40788j.m70678eT(c)) {
                C30379h.m48443a(C46648j.this.cgL.yTx.getContext(), C46648j.this.cgL.yTx.getContext().getString(C25738R.string.b2z), "", C46648j.this.cgL.yTx.getContext().getString(C25738R.string.f8636aj), new C156202());
                AppMethodBeat.m2505o(31310);
            } else if (C40788j.m70676eR(c)) {
                C30379h.m48440a(C46648j.this.cgL.yTx.getContext(), C46648j.this.cgL.yTx.getContext().getString(C25738R.string.b30), "", new C361453(), null);
                AppMethodBeat.m2505o(31310);
            } else {
                if (C23808n.m36640a(C46648j.this.cgL, c, C46648j.this.cFn)) {
                    C46648j.this.dDL();
                }
                AppMethodBeat.m2505o(31310);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.j$5 */
    class C407315 implements OnClickListener {

        /* renamed from: com.tencent.mm.ui.chatting.c.j$5$1 */
        class C53181 implements C36073c {
            C53181() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(31311);
                c44273l.mo70072hi(0, C25738R.string.d1y);
                c44273l.mo70072hi(1, C25738R.string.d1z);
                if (WWAPIFactory.m50230jv(C46648j.this.cgL.yTx.getContext()).dTK()) {
                    Activity context = C46648j.this.cgL.yTx.getContext();
                    Object[] objArr = new Object[1];
                    WWAPIFactory.m50230jv(C46648j.this.cgL.yTx.getContext());
                    objArr[0] = "企业微信";
                    c44273l.mo70068e(2, context.getString(C25738R.string.d20, objArr));
                }
                AppMethodBeat.m2505o(31311);
            }
        }

        /* renamed from: com.tencent.mm.ui.chatting.c.j$5$2 */
        class C73372 implements C5279d {
            C73372() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(31312);
                switch (menuItem.getItemId()) {
                    case 0:
                        C46648j.this.yOO = true;
                        C46660k.m88358a(C46648j.this.cgL.yTx.getContext(), C46648j.m88292c(C46648j.this), C46648j.this.yFW, C46648j.this.cFn.field_username, C46648j.this);
                        AppMethodBeat.m2505o(31312);
                        return;
                    case 1:
                        C46648j.this.yOO = false;
                        C46660k.m88358a(C46648j.this.cgL.yTx.getContext(), C46648j.m88292c(C46648j.this), C46648j.this.yFW, C46648j.this.cFn.field_username, C46648j.this);
                        AppMethodBeat.m2505o(31312);
                        return;
                    case 2:
                        Context context = C46648j.this.cgL.yTx.getContext();
                        C7616ad e = C46648j.this.cFn;
                        List c = C46648j.m88292c(C46648j.this);
                        boolean d = C46648j.this.yFW;
                        if (c.size() != 0) {
                            if (C40788j.m70676eR(c)) {
                                C4990ab.m7420w("MicroMsg.SendToWeWorkHelper", "isContainUndownloadFile");
                                C30379h.m48440a(context, context.getString(C25738R.string.b31), "", new C407111(), null);
                            } else if (C40788j.m70652a(true, c, null)) {
                                C44289an.m80043a(context, e, c, d);
                            } else {
                                C4990ab.m7420w("MicroMsg.SendToWeWorkHelper", "handleInvalidSendToFriendMsg");
                                C30379h.m48466d(context, context.getString(C25738R.string.ce3), "", context.getString(C25738R.string.dr1), context.getString(C25738R.string.f9076or), new C407122(context, e, c, d), null);
                            }
                        }
                        C46648j.this.dDL();
                        break;
                }
                AppMethodBeat.m2505o(31312);
            }
        }

        C407315() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(31313);
            if (((C15612h) C46648j.this.cgL.mo74857aF(C15612h.class)).cdf() == 0) {
                C4990ab.m7420w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
                AppMethodBeat.m2505o(31313);
            } else if ((!C1855t.m3913mZ(C46648j.this.cFn.field_username) || C17903f.m28103kq(C46648j.this.cFn.field_username)) && !C1855t.m3924nJ(C46648j.this.cFn.field_username)) {
                C36356d c36356d = new C36356d(C46648j.this.cgL.yTx.getContext(), 1, false);
                c36356d.rBl = new C53181();
                c36356d.rBm = new C73372();
                c36356d.cpD();
                AppMethodBeat.m2505o(31313);
            } else {
                C46648j.this.yOO = true;
                C46660k.m88358a(C46648j.this.cgL.yTx.getContext(), C46648j.m88292c(C46648j.this), C46648j.this.yFW, C46648j.this.cFn.field_username, C46648j.this);
                AppMethodBeat.m2505o(31313);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.j$7 */
    class C407347 implements Comparator<C7620bi> {
        C407347() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return (int) (((C7620bi) obj).field_createTime - ((C7620bi) obj2).field_createTime);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.j$6 */
    class C466476 implements OnClickListener {

        /* renamed from: com.tencent.mm.ui.chatting.c.j$6$6 */
        class C53196 implements DialogInterface.OnClickListener {
            C53196() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* renamed from: com.tencent.mm.ui.chatting.c.j$6$1 */
        class C314961 implements C24112c {
            C314961() {
            }

            public final void onShow() {
                AppMethodBeat.m2504i(31314);
                C46648j.this.dDL();
                C46648j.this.yON.setVisibility(4);
                AppMethodBeat.m2505o(31314);
            }

            public final void onHide() {
                AppMethodBeat.m2504i(31315);
                C46648j.this.dDL();
                AppMethodBeat.m2505o(31315);
            }

            public final void cLd() {
                AppMethodBeat.m2504i(31316);
                ((C15614o) C46648j.this.cgL.mo74857aF(C15614o.class)).dEf();
                AppMethodBeat.m2505o(31316);
            }
        }

        /* renamed from: com.tencent.mm.ui.chatting.c.j$6$5 */
        class C361465 implements Runnable {
            C361465() {
            }

            public final void run() {
                AppMethodBeat.m2504i(31321);
                C466476.this.dDP();
                AppMethodBeat.m2505o(31321);
            }
        }

        C466476() {
        }

        /* renamed from: eZ */
        static /* synthetic */ void m88286eZ(List list) {
            AppMethodBeat.m2504i(31331);
            C466476.m88285eY(list);
            AppMethodBeat.m2505o(31331);
        }

        /* renamed from: c */
        private void m88283c(C45316cl c45316cl) {
            int i;
            AppMethodBeat.m2504i(31323);
            c45316cl.cvA.fragment = C46648j.this.cgL.yTx;
            c45316cl.cvA.cvH = 41;
            c45316cl.cvA.cvJ = new C314961();
            C4879a.xxA.mo10055m(c45316cl);
            if (c45316cl.cvB.ret == 0) {
                i = 1;
            } else {
                i = 2;
            }
            List<C7620bi> c = C46648j.m88292c(C46648j.this);
            long anT = C5046bo.anT();
            for (C7620bi c7620bi : c) {
                if (c7620bi.bAA()) {
                    C8910b me = C8910b.m16064me(C5046bo.anj(c7620bi.field_content));
                    if (!(me == null || me.type != 5 || C5046bo.isNullOrNil(me.url))) {
                        int i2;
                        if (c7620bi.drC()) {
                            i2 = 1;
                        } else {
                            i2 = 2;
                        }
                        C4990ab.m7411d("MicroMsg.ChattingMoreBtnBarHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), me.url, Long.valueOf(anT), Integer.valueOf(i2), Integer.valueOf(2), Integer.valueOf(1));
                        String str = "";
                        try {
                            str = URLEncoder.encode(me.url, "UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            C4990ab.printErrStackTrace("MicroMsg.ChattingMoreBtnBarHelper", e, "", new Object[0]);
                        }
                        C7060h.pYm.mo8381e(13378, str, Long.valueOf(anT), Integer.valueOf(i2), Integer.valueOf(2), Integer.valueOf(i));
                    }
                }
            }
            if (c45316cl.cvB.ret == 0) {
                if (14 != c45316cl.cvA.type) {
                    C4990ab.m7410d("MicroMsg.ChattingMoreBtnBarHelper", "not record type, do not report");
                    AppMethodBeat.m2505o(31323);
                    return;
                } else if (c45316cl.cvA.cvD == null) {
                    C4990ab.m7412e("MicroMsg.ChattingMoreBtnBarHelper", "want to report record fav, but type count is null");
                    AppMethodBeat.m2505o(31323);
                    return;
                } else {
                    C7060h.pYm.mo8381e(11142, Integer.valueOf(c45316cl.cvA.cvD.wiK), Integer.valueOf(c45316cl.cvA.cvD.wiL), Integer.valueOf(c45316cl.cvA.cvD.wiM), Integer.valueOf(c45316cl.cvA.cvD.wiN), Integer.valueOf(c45316cl.cvA.cvD.wiO), Integer.valueOf(c45316cl.cvA.cvD.wiP), Integer.valueOf(c45316cl.cvA.cvD.wiQ), Integer.valueOf(c45316cl.cvA.cvD.fileCount), Integer.valueOf(c45316cl.cvA.cvD.wiR), Integer.valueOf(c45316cl.cvA.cvD.wiS), Integer.valueOf(c45316cl.cvA.cvD.wiT), Integer.valueOf(c45316cl.cvA.cvD.wiU), Integer.valueOf(c45316cl.cvA.cvD.wiV), Integer.valueOf(c45316cl.cvA.cvD.wiW), Integer.valueOf(c45316cl.cvA.cvD.wiX));
                }
            }
            AppMethodBeat.m2505o(31323);
        }

        /* renamed from: eX */
        private static String m88284eX(List<C7620bi> list) {
            AppMethodBeat.m2504i(31324);
            StringBuffer stringBuffer = new StringBuffer();
            for (C7620bi c7620bi : list) {
                stringBuffer.append(c7620bi.field_msgId);
            }
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.m2505o(31324);
            return stringBuffer2;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(31325);
            List<C7620bi> c = C46648j.m88292c(C46648j.this);
            final HashSet hashSet = new HashSet();
            String eX = C466476.m88284eX(c);
            if (eX.equals(C46648j.this.yLB)) {
                C23639t.makeText(C46648j.this.cgL.yTx.getContext(), C46648j.this.cgL.yTx.getContext().getString(C25738R.string.bna), 0).show();
                AppMethodBeat.m2505o(31325);
                return;
            }
            C46648j.this.yLB = eX;
            for (final C7620bi c7620bi : c) {
                int i;
                if (c7620bi.bAA()) {
                    C8910b me = C8910b.m16064me(c7620bi.field_content);
                    if (!(me == null || me.type != 6 || C5046bo.isNullOrNil(me.fgu))) {
                        final C30065b d = C4733l.m7101d(c7620bi, me.csD);
                        if (!(d == null || (C5730e.m8628ct(d.field_fileFullPath) && C5730e.asZ(d.field_fileFullPath) == d.field_totalLen))) {
                            C4990ab.m7417i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav startDownload msgID:%d", Long.valueOf(c7620bi.field_msgId));
                            hashSet.add(Long.valueOf(c7620bi.field_msgId));
                            C42130g c42130g = new C42130g();
                            c42130g.egl = new C1628a() {
                                /* renamed from: a */
                                public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                                    AppMethodBeat.m2504i(31320);
                                    if (i == 0 && c18496c != null) {
                                        d.field_offset = (long) c18496c.field_finishedLength;
                                        C14877am.aUq().mo48326a(d, new String[0]);
                                    }
                                    if (i == 0 && c9545d != null && c9545d.field_retCode == 0) {
                                        C4990ab.m7417i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav success msgID:%d", Long.valueOf(c7620bi.field_msgId));
                                        d.field_status = 199;
                                        d.field_offset = d.field_totalLen;
                                        C14877am.aUq().mo48326a(d, new String[0]);
                                        c7620bi.setStatus(3);
                                        C9638aw.m17190ZK();
                                        C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
                                        hashSet.remove(Long.valueOf(c7620bi.field_msgId));
                                        C466476.m88282a(C466476.this, hashSet);
                                    }
                                    if (!(i == 0 && (c9545d == null || c9545d.field_retCode == 0))) {
                                        String str2 = "MicroMsg.ChattingMoreBtnBarHelper";
                                        String str3 = "oreh downloadTpFileAndFav success msgID:%d, error(%d,%d)";
                                        Object[] objArr = new Object[3];
                                        objArr[0] = Long.valueOf(c7620bi.field_msgId);
                                        objArr[1] = Integer.valueOf(i);
                                        objArr[2] = Integer.valueOf(c9545d == null ? 0 : c9545d.field_retCode);
                                        C4990ab.m7417i(str2, str3, objArr);
                                        hashSet.remove(Long.valueOf(c7620bi.field_msgId));
                                        C466476.m88282a(C466476.this, hashSet);
                                    }
                                    AppMethodBeat.m2505o(31320);
                                    return 0;
                                }

                                /* renamed from: a */
                                public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                                }

                                /* renamed from: l */
                                public final byte[] mo5084l(String str, byte[] bArr) {
                                    return new byte[0];
                                }
                            };
                            c42130g.field_mediaId = C37458c.m63162a("checkExist", C5046bo.anU(), c7620bi.field_talker, c7620bi.field_msgId);
                            c42130g.field_aesKey = me.eyr;
                            c42130g.field_fileType = 19;
                            c42130g.field_authKey = me.fgA;
                            c42130g.egm = me.fgu;
                            if (d == null || C5046bo.isNullOrNil(d.field_fileFullPath)) {
                                C9638aw.m17190ZK();
                                c42130g.field_fullpath = C4733l.m7083X(C18628c.m29096Ye(), me.title, me.fgp);
                            } else {
                                c42130g.field_fullpath = d.field_fileFullPath;
                            }
                            if (!C37461f.afx().mo51222b(c42130g, -1)) {
                                C4990ab.m7412e("MicroMsg.ChattingMoreBtnBarHelper", "openim attach download failed before rescend");
                                hashSet.remove(Long.valueOf(c7620bi.field_msgId));
                            }
                        }
                    }
                }
                if (c7620bi.drE()) {
                    int i2;
                    C25822e fI = C32291o.ahl().mo73112fI(c7620bi.field_msgSvrId);
                    if (c7620bi.field_isSend == 1) {
                        if (fI.agQ()) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        i2 = i;
                    } else if (fI.agQ()) {
                        if (C5730e.m8628ct(C32291o.ahl().mo73118q(C37478f.m63225a(fI).fDz, "", ""))) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                    } else {
                        i2 = 0;
                    }
                    if (fI.offset < fI.frO || fI.frO == 0) {
                        C4990ab.m7417i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav start  msgID:%d", Long.valueOf(c7620bi.field_msgId));
                        hashSet.add(Long.valueOf(c7620bi.field_msgId));
                        if (!C32291o.ahm().mo33467a(fI.fDy, c7620bi.field_msgId, i2, c7620bi, C25738R.drawable.b0p, new C9017a() {
                            /* renamed from: a */
                            public final void mo20450a(long j, long j2, int i, int i2, Object obj, int i3, int i4, C1207m c1207m) {
                            }

                            /* renamed from: a */
                            public final void mo20451a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, C1207m c1207m) {
                                AppMethodBeat.m2504i(31318);
                                boolean z = i3 == 0 && i4 == 0;
                                C4990ab.m7417i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav taskEnd image succed: %s, msgID:%d, errType: %s, errCode:%s", Boolean.valueOf(z), Long.valueOf(c7620bi.field_msgId), Integer.valueOf(i3), Integer.valueOf(i4));
                                hashSet.remove(Long.valueOf(c7620bi.field_msgId));
                                C466476.m88282a(C466476.this, hashSet);
                                AppMethodBeat.m2505o(31318);
                            }

                            /* renamed from: a */
                            public final void mo20449a(long j, long j2, int i, int i2, Object obj) {
                                AppMethodBeat.m2504i(31319);
                                C4990ab.m7417i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav download image taskcancel: msgID:%d", Long.valueOf(c7620bi.field_msgId));
                                hashSet.remove(Long.valueOf(c7620bi.field_msgId));
                                C466476.m88282a(C466476.this, hashSet);
                                AppMethodBeat.m2505o(31319);
                            }
                        })) {
                            hashSet.remove(Long.valueOf(c7620bi.field_msgId));
                        }
                    }
                }
                if (c7620bi.bws() || c7620bi.bwt()) {
                    C26493s ut = C26494u.m42268ut(c7620bi.field_imgPath);
                    if (!(ut == null || ut.status == 199)) {
                        hashSet.add(Long.valueOf(c7620bi.field_msgId));
                        C37961o.all().mo21053a(new C9721a() {
                            /* renamed from: a */
                            public final void mo11381a(C9718a c9718a) {
                                AppMethodBeat.m2504i(31317);
                                if (c7620bi.field_imgPath.equals(c9718a.fileName)) {
                                    C26493s ut = C26494u.m42268ut(c9718a.fileName);
                                    if (ut == null || !ut.alz()) {
                                        C4990ab.m7417i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav fialed msgID:%d, fileName:%s", Long.valueOf(c7620bi.field_msgId), c9718a.fileName);
                                    } else {
                                        C4990ab.m7417i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav suc msgID:%d, fileName:%s", Long.valueOf(c7620bi.field_msgId), c9718a.fileName);
                                    }
                                    C37961o.all().mo21052a(this);
                                    hashSet.remove(Long.valueOf(c7620bi.field_msgId));
                                    C466476.m88282a(C466476.this, hashSet);
                                }
                                AppMethodBeat.m2505o(31317);
                            }
                        }, Looper.getMainLooper());
                        C4990ab.m7417i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", Long.valueOf(c7620bi.field_msgId), c7620bi.field_imgPath);
                        if (ut.aly()) {
                            C4990ab.m7416i("MicroMsg.ChattingMoreBtnBarHelper", "start complete online video");
                            i = C26494u.m42259uA(c7620bi.field_imgPath);
                        } else {
                            C4990ab.m7416i("MicroMsg.ChattingMoreBtnBarHelper", "start complete offline video");
                            i = C26494u.m42264up(c7620bi.field_imgPath);
                        }
                        if (i != 0) {
                            hashSet.remove(Long.valueOf(c7620bi.field_msgId));
                        }
                    }
                }
            }
            m88287g(hashSet);
            AppMethodBeat.m2505o(31325);
        }

        /* renamed from: g */
        private void m88287g(HashSet<Long> hashSet) {
            AppMethodBeat.m2504i(31326);
            if (hashSet.isEmpty()) {
                new C7306ak(Looper.getMainLooper()).post(new C361465());
            }
            AppMethodBeat.m2505o(31326);
        }

        public final void dDP() {
            AppMethodBeat.m2504i(31327);
            C46648j.this.yLB = "";
            final List<C7620bi> c = C46648j.m88292c(C46648j.this);
            if (C40788j.m70677eS(c)) {
                C30379h.m48443a(C46648j.this.cgL.yTx.getContext(), C46648j.this.cgL.yTx.getContext().getString(C25738R.string.bow), "", C46648j.this.cgL.yTx.getContext().getString(C25738R.string.f8636aj), new C53196());
                AppMethodBeat.m2505o(31327);
                return;
            }
            C7620bi c7620bi;
            String nW;
            final C45316cl c45316cl = new C45316cl();
            C4990ab.m7411d("MicroMsg.ChattingMoreBtnBarHelper", "want fav msgs from %s", C46648j.this.cFn.field_username);
            if (c.size() == 1) {
                c7620bi = (C7620bi) c.get(0);
                if (c7620bi != null && (c7620bi.bAA() || c7620bi.drC())) {
                    nW = C37922v.m64078nW(c7620bi.field_msgSvrId);
                    C32800b y = C37922v.m64076Zp().mo60676y(nW, true);
                    y.mo53356j("prePublishId", "msg_" + c7620bi.field_msgSvrId);
                    y.mo53356j("preUsername", C5378c.m8122a(c7620bi, C46648j.this.yFW, ((C36135d) C46648j.this.cgL.mo74857aF(C36135d.class)).dDm()));
                    y.mo53356j("preChatName", C46648j.this.cFn.field_username);
                    y.mo53356j("preMsgIndex", Integer.valueOf(0));
                    y.mo53356j("sendAppMsgScene", Integer.valueOf(1));
                    ((C46210i) C1720g.m3528K(C46210i.class)).mo55530a("adExtStr", y, c7620bi);
                    c45316cl.cvA.cvF = nW;
                }
            }
            if (C40444g.m69402a(C46648j.this.cgL.yTx.getContext(), c45316cl, C46648j.this.cFn.field_username, c, true)) {
                for (C7620bi c7620bi2 : c) {
                    if (c7620bi2.bAA()) {
                        C45457b.fRa.mo73261b(c7620bi2, C1191k.m2615k(c7620bi2));
                    } else {
                        C45457b.fRa.mo73248D(c7620bi2);
                    }
                }
                m88283c(c45316cl);
                C466476.m88285eY(C46648j.m88292c(C46648j.this));
                AppMethodBeat.m2505o(31327);
            } else if (C46648j.m88292c(C46648j.this).size() > 1) {
                String string;
                String string2;
                Activity context = C46648j.this.cgL.yTx.getContext();
                if (c45316cl.cvA.cvG >= 0) {
                    string = C46648j.this.cgL.yTx.getContext().getString(C25738R.string.bov);
                } else {
                    string = C46648j.this.cgL.yTx.getContext().getString(C25738R.string.bou);
                }
                nW = "";
                if (c45316cl.cvA.cvG >= 0) {
                    string2 = C46648j.this.cgL.yTx.getContext().getString(C25738R.string.atd);
                } else {
                    string2 = C46648j.this.cgL.yTx.getContext().getString(C25738R.string.dcq);
                }
                C30379h.m48466d(context, string, nW, string2, C46648j.this.cgL.yTx.getContext().getString(C25738R.string.atb), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(31322);
                        for (C7620bi c7620bi : c) {
                            if (!c7620bi.dty() && !c7620bi.dtx()) {
                                if (c45316cl.cvA.type == 14 && c45316cl.cvA.cvC.wiv.size() == 0) {
                                    C46648j.this.dDL();
                                    AppMethodBeat.m2505o(31322);
                                    return;
                                }
                                C466476.m88281a(C466476.this, c45316cl);
                                C466476.m88286eZ(C46648j.m88292c(C46648j.this));
                                AppMethodBeat.m2505o(31322);
                                return;
                            }
                        }
                        AppMethodBeat.m2505o(31322);
                    }
                }, null);
                AppMethodBeat.m2505o(31327);
            } else {
                C30379h.m48467g(C46648j.this.cgL.yTx.getContext(), c45316cl.cvA.cvG, 0);
                AppMethodBeat.m2505o(31327);
            }
        }

        /* renamed from: eY */
        private static void m88285eY(List<C7620bi> list) {
            AppMethodBeat.m2504i(31328);
            for (C7620bi a : list) {
                C40707a.m70380a(C40706c.Fav, C23688d.Samll, a, 0);
            }
            AppMethodBeat.m2505o(31328);
        }
    }

    static {
        AppMethodBeat.m2504i(31343);
        AppMethodBeat.m2505o(31343);
    }

    /* renamed from: bd */
    public final void mo27828bd(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31336);
        if (c7620bi == null) {
            C4990ab.m7420w("MicroMsg.ChattingMoreBtnBarHelper", "perform search mode click msg item fail, msg is null");
            AppMethodBeat.m2505o(31336);
            return;
        }
        C15612h c15612h = (C15612h) this.cgL.mo74857aF(C15612h.class);
        if (c15612h.mo27825nf(c7620bi.field_msgId)) {
            this.yON.mo10921On(c15612h.cdf());
            this.yON.setVisibility(0);
            this.elS.dJS();
        }
        AppMethodBeat.m2505o(31336);
    }

    /* renamed from: a */
    public final void mo27932a(C23699a c23699a) {
    }

    public final boolean dDN() {
        return this.yNq;
    }

    public final void dDO() {
        AppMethodBeat.m2504i(31339);
        if (this.elS != null) {
            this.elS.dJS();
            this.elS.zHa = null;
        }
        AppMethodBeat.m2505o(31339);
    }

    public final void dCI() {
        AppMethodBeat.m2504i(31340);
        dDL();
        AppMethodBeat.m2505o(31340);
    }

    /* renamed from: b */
    public final void mo27933b(C23699a c23699a) {
        AppMethodBeat.m2504i(31341);
        dDL();
        AppMethodBeat.m2505o(31341);
    }

    public final boolean dCJ() {
        return this.yOO;
    }

    /* renamed from: bc */
    public final void mo27827bc(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31335);
        if (this.hasInit) {
            C4990ab.m7412e("MicroMsg.ChattingMoreBtnBarHelper", "[init] hasInit!");
        } else {
            this.hasInit = true;
            if (this.yON == null) {
                ((ViewStub) this.cgL.findViewById(2131822393)).inflate();
                this.yON = (ChattingFooterMoreBtnBar) this.cgL.findViewById(2131822729);
            }
            if (((C23733z) this.cgL.mo74857aF(C23733z.class)).dEW()) {
                C4990ab.m7420w("MicroMsg.ChattingMoreBtnBarHelper", "is in show search chat result");
                if (this.elS != null) {
                    this.elS.zHa = null;
                }
            } else {
                this.elS = new C5601o((byte) 0);
                this.elS.zHa = new C304778();
            }
            this.yON.mo10922c(3, new C53152());
            this.yON.mo10922c(2, new C53173());
            this.yON.mo10922c(1, new C407304());
            this.yON.mo10922c(0, new C407315());
            this.yON.mo10922c(4, new C466476());
            this.qzp = AnimationUtils.loadAnimation(this.cgL.yTx.getContext(), C25738R.anim.f8375cg);
            ((C15612h) this.cgL.mo74857aF(C15612h.class)).mo27805c(new C53141());
        }
        this.cFn = this.cgL.sRl;
        boolean z = this.cgL.dFw() || ((C36135d) this.cgL.mo74857aF(C36135d.class)).dDn();
        this.yFW = z;
        this.yON.dCp();
        this.cgL.yTx.getController().addSearchMenu(true, this.elS);
        this.yON.startAnimation(this.qzp);
        this.yON.setVisibility(0);
        this.yNq = true;
        ((C23733z) this.cgL.mo74857aF(C23733z.class)).dEP();
        C15612h c15612h = (C15612h) this.cgL.mo74857aF(C15612h.class);
        c15612h.dCS();
        c15612h.dCR();
        c15612h.mo27825nf(c7620bi.field_msgId);
        this.yON.mo10921On(c15612h.cdf());
        ((C46642l) this.cgL.mo74857aF(C46642l.class)).dDV();
        this.cgL.aqX();
        dDM();
        ((C15614o) this.cgL.mo74857aF(C15614o.class)).dEg();
        C7060h.pYm.mo8381e(10811, Integer.valueOf(1));
        if (this.cFn.dsf()) {
            C46650a c46650a = this.cgL;
            C4990ab.m7417i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d", Integer.valueOf(2131820645));
            c46650a.yTy.removeOptionMenu(2131820645);
        }
        ((C46643s) this.cgL.mo74857aF(C46643s.class)).dEz();
        AppMethodBeat.m2505o(31335);
    }

    public final void dDL() {
        AppMethodBeat.m2504i(31337);
        this.cgL.yTx.getController().addSearchMenu(false, this.elS);
        this.yON.setVisibility(8);
        ((C15612h) this.cgL.mo74857aF(C15612h.class)).bvQ();
        ((C36135d) this.cgL.mo74857aF(C36135d.class)).dDA();
        ((C23733z) this.cgL.mo74857aF(C23733z.class)).dEP();
        this.yNq = false;
        dDM();
        ((C46642l) this.cgL.mo74857aF(C46642l.class)).cuB();
        ((C15614o) this.cgL.mo74857aF(C15614o.class)).dEg();
        this.cgL.aqX();
        C46660k.dCa();
        AppMethodBeat.m2505o(31337);
    }

    private void dDM() {
        AppMethodBeat.m2504i(31338);
        if (this.yNq) {
            this.cgL.showOptionMenu(false);
        } else {
            ((C44299r) this.cgL.mo74857aF(C44299r.class)).dEp();
        }
        ((C15611aj) this.cgL.mo74857aF(C15611aj.class)).dFn();
        AppMethodBeat.m2505o(31338);
    }

    /* renamed from: c */
    static /* synthetic */ List m88292c(C46648j c46648j) {
        AppMethodBeat.m2504i(31342);
        LinkedList linkedList = new LinkedList();
        for (Long longValue : ((C15612h) c46648j.cgL.mo74857aF(C15612h.class)).dCQ()) {
            C4990ab.m7419v("MicroMsg.ChattingMoreBtnBarHelper", "select msg id %d", Long.valueOf(longValue.longValue()));
            C9638aw.m17190ZK();
            linkedList.add(C18628c.m29080XO().mo15340jf(r4));
        }
        Collections.sort(linkedList, new C407347());
        AppMethodBeat.m2505o(31342);
        return linkedList;
    }
}
