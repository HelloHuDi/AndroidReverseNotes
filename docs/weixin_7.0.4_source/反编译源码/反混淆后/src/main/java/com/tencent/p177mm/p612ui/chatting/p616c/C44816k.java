package com.tencent.p177mm.p612ui.chatting.p616c;

import android.database.Cursor;
import android.text.TextUtils;
import android.widget.AbsListView;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.C41908x;
import com.tencent.p177mm.booter.C41908x.C32426a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C32798u;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.modelsns.C32831d;
import com.tencent.p177mm.modelstat.C42219a;
import com.tencent.p177mm.modelstat.C42219a.C32832a;
import com.tencent.p177mm.modelstat.C45457b;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p215cf.C37634d;
import com.tencent.p177mm.p230g.p231a.C41969av;
import com.tencent.p177mm.p230g.p232b.p233a.C32679v;
import com.tencent.p177mm.p612ui.chatting.C40707a;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.p612ui.chatting.p1345j.C23797b;
import com.tencent.p177mm.p612ui.chatting.p1345j.C36196a;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15611aj;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36137j;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C46643s;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.expt.roomexpt.C38991d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.p993a.C12514e;
import com.tencent.p177mm.plugin.messenger.p993a.C12514e.C12515c;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p1024b.C46210i;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.ArrayList;
import java.util.HashSet;

@C15590a(dFp = C36137j.class)
/* renamed from: com.tencent.mm.ui.chatting.c.k */
public class C44816k extends C44291a implements C36137j {
    private static String yPc = "100134";
    private long jEg = 0;
    private HashSet<Long> yOW = new HashSet();
    private int yOX;
    private HashSet<Long> yOY = new HashSet();
    private HashSet<Long> yOZ = new HashSet();
    private boolean yOx = false;
    private int yPa = 0;
    private boolean yPb = false;
    private C12515c yPd = new C361495();
    private long yPe = 0;
    private boolean yPf = false;
    private String yPg = null;
    private long yPh = 0;
    private int yPi = 0;

    /* renamed from: com.tencent.mm.ui.chatting.c.k$5 */
    class C361495 implements C12515c {
        C361495() {
        }

        public final void bOi() {
            AppMethodBeat.m2504i(31348);
            C32679v c32679v = new C32679v();
            c32679v.mo53210eQ(C44816k.this.cgL.yTA);
            c32679v.mo53211eR(C44816k.this.cgL.getTalkerUserName());
            c32679v.cXW = 1;
            c32679v.cXX = 1;
            c32679v.cYb = 1;
            c32679v.ajK();
            AppMethodBeat.m2505o(31348);
        }
    }

    public C44816k() {
        AppMethodBeat.m2504i(31351);
        AppMethodBeat.m2505o(31351);
    }

    /* renamed from: bf */
    public final void mo57029bf(final C7620bi c7620bi) {
        AppMethodBeat.m2504i(31353);
        if (this.yOY.contains(Long.valueOf(c7620bi.field_msgSvrId))) {
            AppMethodBeat.m2505o(31353);
            return;
        }
        this.yOY.add(Long.valueOf(c7620bi.field_msgSvrId));
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(31345);
                C42219a.m74510a(c7620bi, C32832a.Expose);
                AppMethodBeat.m2505o(31345);
            }
        }, "ChattingUI.expExposeReport");
        AppMethodBeat.m2505o(31353);
    }

    /* renamed from: Oz */
    public final void mo57027Oz(int i) {
        this.yOX = i;
    }

    private void dDQ() {
        AppMethodBeat.m2504i(31355);
        C41908x.ecN.mo67553jL(this.cgL.getTalkerUserName());
        C45457b.fRa.mo73253IF();
        C41969av c41969av = new C41969av();
        c41969av.ctX.ctY = false;
        C4879a.xxA.mo10055m(c41969av);
        ((C12514e) C1720g.m3528K(C12514e.class)).mo24441b("tmpl_type_succeed_contact", this.yPd);
        AppMethodBeat.m2505o(31355);
    }

    private void dDR() {
        int i = 0;
        AppMethodBeat.m2504i(31356);
        if (this.yPf) {
            long currentTimeMillis = System.currentTimeMillis() - this.yPe;
            this.yPe = 0;
            this.yPf = false;
            C7060h c7060h = C7060h.pYm;
            long[] jArr = new long[]{0, 200, 400, 600, 800, 1000, 1500, FaceGestureDetGLThread.BRIGHTNESS_DURATION};
            while (i < 8) {
                if (currentTimeMillis < jArr[i]) {
                    break;
                } else if (i == 7) {
                    i = 8;
                    break;
                } else {
                    i++;
                }
            }
            i = -1;
            c7060h.mo8378a(109, (long) i, 1, true);
        }
        AppMethodBeat.m2505o(31356);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.m2504i(31357);
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            C37634d.dvV().mo60468ev(ChattingUI.class.getName() + ".Listview", 4);
        }
        AppMethodBeat.m2505o(31357);
    }

    public final void dxx() {
        AppMethodBeat.m2504i(31358);
        if (C5046bo.isNullOrNil(this.cgL.getTalkerUserName())) {
            C7060h.pYm.mo8378a(110, 0, 1, true);
        }
        AppMethodBeat.m2505o(31358);
    }

    public final void dxz() {
    }

    public final void dxA() {
        AppMethodBeat.m2504i(31360);
        if (!this.yOx) {
            m81966IF();
        }
        this.yOx = false;
        AppMethodBeat.m2505o(31360);
    }

    /* renamed from: IF */
    private void m81966IF() {
        AppMethodBeat.m2504i(31361);
        this.yPg = null;
        if (!C1853r.m3846Yz().equals(this.cgL.getTalkerUserName()) && this.cgL.dFw()) {
            this.yPg = this.cgL.getTalkerUserName();
            this.jEg = (C1829bf.aaa() / 1000) * 1000;
            this.yPi = 0;
            final String str = this.yPg;
            C9638aw.m17180RS().mo10302aa(new Runnable() {
                public final void run() {
                    boolean z = false;
                    AppMethodBeat.m2504i(31349);
                    if (!C5046bo.isNullOrNil(str)) {
                        C44816k.this.yPi = C32798u.m53582ac(str, C1855t.fkP);
                        C4990ab.m7417i("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg:name:%s unRead:%s entryTime:%s(%s)", str, Integer.valueOf(C44816k.this.yPi), C5046bo.m7578mw(C44816k.this.jEg), Long.valueOf(C44816k.this.jEg));
                        if (C44816k.this.cgL.dFw() && C44816k.this.cgL.sRl.dua == 0) {
                            z = true;
                        }
                        ((C38991d) C1720g.m3528K(C38991d.class)).mo45798aE(str, z);
                    }
                    AppMethodBeat.m2505o(31349);
                }
            });
        }
        dDR();
        AppMethodBeat.m2505o(31361);
    }

    public final void dxB() {
        AppMethodBeat.m2504i(31362);
        if (!TextUtils.isEmpty(this.yPg) && this.cgL.dFw()) {
            this.yPh = C1829bf.aaa();
            final String str = this.yPg;
            this.yPg = "";
            final int dEC = ((C46643s) this.cgL.mo74857aF(C46643s.class)).dEC();
            if (dEC == 2) {
                ((C46643s) this.cgL.mo74857aF(C46643s.class)).dEB();
            }
            int i = 0;
            if (this.cgL.dFw() && this.cgL.sRl.dua == 0) {
                i = 1;
            }
            C9638aw.m17180RS().mo10302aa(new Runnable() {
                public final void run() {
                    boolean z = false;
                    AppMethodBeat.m2504i(31350);
                    if (!C5046bo.isNullOrNil(str)) {
                        int i;
                        int i2;
                        int mA = C37921n.m64060mA(str);
                        C9638aw.m17190ZK();
                        Cursor w = C18628c.m29080XO().mo15354w(str, C44816k.this.jEg, C44816k.this.yPh);
                        if (w == null || !w.moveToFirst()) {
                            i = 0;
                            i2 = 0;
                        } else {
                            C7620bi c7620bi = new C7620bi();
                            i = 0;
                            int i3 = 0;
                            do {
                                c7620bi.mo8995d(w);
                                if (c7620bi.field_isSend == 1) {
                                    i3++;
                                } else {
                                    i++;
                                }
                            } while (w.moveToNext());
                            i2 = i3;
                        }
                        if (w != null) {
                            w.close();
                        }
                        C4990ab.m7411d("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg MuteRoomKvStat, muteRoomName:%s, stayTime:%d, memberNum:%d, newMsg:%d, sendMsgNum:%d, unreadMsgNum:%d, backToHistoryState:%d, isMute:%d  ,session:%s", str, Long.valueOf(C44816k.this.yPh - C44816k.this.jEg), Integer.valueOf(mA), Integer.valueOf(C44816k.this.yPi + i), Integer.valueOf(i2), Integer.valueOf(C44816k.this.yPi), Integer.valueOf(dEC), Integer.valueOf(i), C44816k.this.cgL.dFt());
                        C7060h.pYm.mo8381e(12077, str, Long.valueOf(C44816k.this.yPh - C44816k.this.jEg), Integer.valueOf(mA), Integer.valueOf(i + C44816k.this.yPi), Integer.valueOf(i2), Integer.valueOf(C44816k.this.yPi), Integer.valueOf(dEC), Integer.valueOf(i), C44816k.this.cgL.dFt(), Integer.valueOf(C44816k.this.yOX));
                        String mJ = C1854s.m3866mJ(str);
                        C38991d c38991d = (C38991d) C1720g.m3528K(C38991d.class);
                        String str = str;
                        long c = C44816k.this.yPh - C44816k.this.jEg;
                        mA = C44816k.this.yPi;
                        if (i == 1) {
                            z = true;
                        }
                        c38991d.mo45797a(str, mJ, c, mA, i2, z);
                    }
                    AppMethodBeat.m2505o(31350);
                }
            });
        }
        AppMethodBeat.m2505o(31362);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31363);
        dDQ();
        boolean QL = ((C6982j) C1720g.m3528K(C6982j.class)).bOm().mo15216QL(this.cgL.getTalkerUserName());
        C36196a c36196a = C36196a.yZE;
        boolean dFx = this.cgL.dFx();
        ArrayList arrayList = new ArrayList();
        if (dFx && !QL) {
            if (c36196a.yZF[0] > 0) {
                arrayList.add(new IDKey(890, 0, c36196a.yZF[0]));
            }
            if (c36196a.yZF[1] > 0) {
                arrayList.add(new IDKey(890, 1, c36196a.yZF[1]));
            }
            if (c36196a.yZF[2] > 0) {
                arrayList.add(new IDKey(890, 2, c36196a.yZF[2]));
            }
            if (c36196a.yZF[3] > 0) {
                arrayList.add(new IDKey(890, 3, c36196a.yZF[3]));
            }
            if (c36196a.yZF[4] > 0) {
                arrayList.add(new IDKey(890, 4, c36196a.yZF[4]));
            }
            arrayList.add(new IDKey(890, 19, 1));
        } else if (dFx && QL) {
            if (c36196a.yZF[0] > 0) {
                arrayList.add(new IDKey(890, 40, c36196a.yZF[0]));
            }
            if (c36196a.yZF[1] > 0) {
                arrayList.add(new IDKey(890, 41, c36196a.yZF[1]));
            }
            if (c36196a.yZF[2] > 0) {
                arrayList.add(new IDKey(890, 42, c36196a.yZF[2]));
            }
            if (c36196a.yZF[3] > 0) {
                arrayList.add(new IDKey(890, 43, c36196a.yZF[3]));
            }
            if (c36196a.yZF[4] > 0) {
                arrayList.add(new IDKey(890, 44, c36196a.yZF[4]));
            }
            arrayList.add(new IDKey(890, 59, 1));
        } else {
            if (c36196a.yZF[0] > 0) {
                arrayList.add(new IDKey(890, 20, c36196a.yZF[0]));
            }
            if (c36196a.yZF[1] > 0) {
                arrayList.add(new IDKey(890, 21, c36196a.yZF[1]));
            }
            if (c36196a.yZF[2] > 0) {
                arrayList.add(new IDKey(890, 22, c36196a.yZF[2]));
            }
            if (c36196a.yZF[3] > 0) {
                arrayList.add(new IDKey(890, 23, c36196a.yZF[3]));
            }
            if (c36196a.yZF[4] > 0) {
                arrayList.add(new IDKey(890, 24, c36196a.yZF[4]));
            }
            arrayList.add(new IDKey(890, 39, 1));
        }
        C7053e.pXa.mo8379b(arrayList, true);
        C23797b c23797b = C23797b.yZH;
        C4990ab.m7417i("MicroMsg.GetChatroomReporter", "[report] chatroomId:%s mCount:%s mDownCount:%s mUpCount:%s mErrCount:%s mSuccessCount:%s mFetchCount:%s", this.cgL.getTalkerUserName(), Integer.valueOf(c23797b.mCount), Integer.valueOf(c23797b.yZI), Integer.valueOf(c23797b.yZJ), Integer.valueOf(c23797b.tVN), Integer.valueOf(c23797b.mSuccessCount), Integer.valueOf(c23797b.yZK));
        C7053e.pXa.mo8378a(403, 60, (long) c23797b.mCount, true);
        C7053e.pXa.mo8378a(403, 61, (long) c23797b.yZI, true);
        C7053e.pXa.mo8378a(403, 62, (long) c23797b.yZJ, true);
        C7053e.pXa.mo8378a(403, 63, (long) c23797b.tVN, true);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new IDKey(403, 64, c23797b.mSuccessCount));
        arrayList2.add(new IDKey(403, 65, c23797b.yZK));
        C7053e.pXa.mo8379b(arrayList2, true);
        AppMethodBeat.m2505o(31363);
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31364);
        super.dDh();
        dDQ();
        AppMethodBeat.m2505o(31364);
    }

    /* renamed from: be */
    public final void mo57028be(final C7620bi c7620bi) {
        AppMethodBeat.m2504i(31352);
        if (!this.yOW.contains(Long.valueOf(c7620bi.field_msgSvrId))) {
            this.yOW.add(Long.valueOf(c7620bi.field_msgSvrId));
            C7305d.post(new Runnable() {
                final /* synthetic */ boolean yPj = false;

                public final void run() {
                    AppMethodBeat.m2504i(31344);
                    ((C46210i) C1720g.m3528K(C46210i.class)).mo55531ai(c7620bi);
                    C7620bi c7620bi = c7620bi;
                    boolean z = this.yPj;
                    PString pString = new PString();
                    PString pString2 = new PString();
                    if (C40707a.m70381a(c7620bi, pString, pString2)) {
                        int i;
                        String str = pString.value;
                        String str2 = pString2.value;
                        String str3 = c7620bi.field_talker;
                        boolean mN = C1855t.m3901mN(str3);
                        String Yz = c7620bi.field_isSend == 1 ? C1853r.m3846Yz() : mN ? C1829bf.m3762oy(c7620bi.field_content) : str3;
                        C32831d c32831d = new C32831d();
                        c32831d.mo53400l("20source_publishid", str + ",");
                        c32831d.mo53400l("21uxinfo", str2 + ",");
                        c32831d.mo53400l("22clienttime", C5046bo.anU() + ",");
                        c32831d.mo53400l("23source_type", (c7620bi.getType() == 62 ? 1 : 2) + ",");
                        c32831d.mo53400l("24scene", (mN ? 4 : 3) + ",");
                        c32831d.mo53400l("25scene_chatname", str3 + ",");
                        c32831d.mo53400l("26scene_username", Yz + ",");
                        c32831d.mo53400l("27curr_publishid", ",");
                        c32831d.mo53400l("28curr_msgid", c7620bi.field_msgSvrId + ",");
                        c32831d.mo53400l("29curr_favid", "0,");
                        str = "30isdownload";
                        StringBuilder stringBuilder = new StringBuilder();
                        if (z) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        c32831d.mo53400l(str, stringBuilder.append(i).append(",").toString());
                        str = "31chatroom_membercount";
                        StringBuilder stringBuilder2 = new StringBuilder();
                        if (mN) {
                            i = C37921n.m64060mA(str3);
                        } else {
                            i = 0;
                        }
                        c32831d.mo53400l(str, stringBuilder2.append(i).append(",").toString());
                        ((C46210i) C1720g.m3528K(C46210i.class)).mo55532b(((C46210i) C1720g.m3528K(C46210i.class)).mo55528I(c7620bi), c32831d);
                        C4990ab.m7416i("MicroMsg.AdVideoStatistic", "report snsad_video_exposure: " + c32831d.mo53398Fk());
                        C7060h.pYm.mo8381e(12989, c32831d);
                    }
                    AppMethodBeat.m2505o(31344);
                }
            }, "ChattingUI.adVideoExposeReport");
        }
        AppMethodBeat.m2505o(31352);
    }

    /* renamed from: bg */
    public final void mo57030bg(final C7620bi c7620bi) {
        AppMethodBeat.m2504i(31354);
        if (!this.yPb) {
            this.yPb = true;
            C5141c ll = C18624c.abi().mo17131ll(yPc);
            if (ll.isValid()) {
                this.yPa = C42252ah.getInt((String) ll.dru().get("needUploadData"), 0);
            }
        }
        if (this.yPa == 0) {
            AppMethodBeat.m2505o(31354);
        } else if (this.yOZ.contains(Long.valueOf(c7620bi.field_msgSvrId))) {
            AppMethodBeat.m2505o(31354);
        } else {
            C7305d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(31346);
                    C44816k.m81969a(C44816k.this, c7620bi);
                    AppMethodBeat.m2505o(31346);
                }
            }, "ChattingUI.appExposeReport");
            AppMethodBeat.m2505o(31354);
        }
    }

    public final void dxy() {
        int i = 0;
        AppMethodBeat.m2504i(31359);
        this.yPe = System.currentTimeMillis();
        this.yPf = true;
        if (!(this.cgL.sRl == null || this.cgL.getTalkerUserName() == null)) {
            int i2;
            int i3;
            int i4;
            C45457b.fRa.mo73264cM(this.cgL.getTalkerUserName());
            if (!C1853r.m3846Yz().equals(this.cgL.getTalkerUserName())) {
                C41969av c41969av = new C41969av();
                c41969av.ctX.ctY = true;
                C4879a.xxA.mo10055m(c41969av);
            }
            boolean DX = ((C15611aj) this.cgL.mo74857aF(C15611aj.class)).mo27789DX();
            if ("notification_messages".equals(this.cgL.getTalkerUserName())) {
                i2 = 1;
                i3 = 8;
            } else {
                boolean i42;
                if (C1855t.m3913mZ(this.cgL.getTalkerUserName())) {
                    C36135d c36135d = (C36135d) this.cgL.mo74857aF(C36135d.class);
                    if (c36135d.dDm()) {
                        if (DX) {
                            i42 = 0;
                        } else {
                            i42 = true;
                        }
                        if (c36135d.dDn()) {
                            c36135d.dDk().afg().size();
                            i3 = 5;
                            i2 = i42;
                        } else {
                            i3 = 4;
                            i2 = i42;
                        }
                    } else if (C17903f.m28108rb(this.cgL.getTalkerUserName())) {
                        i2 = DX ? 0 : 1;
                        i3 = 3;
                    } else if (C17903f.m28109rc(this.cgL.getTalkerUserName())) {
                        i2 = 1;
                        i3 = 0;
                    } else if (C17903f.m28105qY(this.cgL.getTalkerUserName())) {
                        i42 = true;
                        i2 = 0;
                    } else {
                        i42 = true;
                        i2 = 0;
                    }
                } else if (this.cgL.dFw()) {
                    i2 = DX ? 0 : 1;
                    i3 = 2;
                } else if (DX) {
                    i2 = 0;
                    i42 = true;
                } else {
                    i2 = 1;
                    i42 = true;
                }
                DX = i42;
            }
            if (!this.cgL.dFv()) {
                i42 = i3;
                for (String equals : C1855t.fkY) {
                    if (equals.equals(this.cgL.getTalkerUserName())) {
                        i42 = 0;
                    }
                }
                i = i42;
            }
            if (i != 0) {
                C7305d.xDG.mo10151b(new Runnable() {
                    public final void run() {
                        int mA;
                        int i;
                        AppMethodBeat.m2504i(31347);
                        if (i == 2) {
                            mA = C37921n.m64060mA(C44816k.this.cgL.getTalkerUserName());
                        } else {
                            mA = 0;
                        }
                        C9638aw.m17190ZK();
                        C7617ak aoZ = C18628c.m29083XR().aoZ(C44816k.this.cgL.getTalkerUserName());
                        if (aoZ == null) {
                            i = 0;
                        } else {
                            i = aoZ.field_unReadCount;
                        }
                        C41908x c41908x = C41908x.ecN;
                        String talkerUserName = C44816k.this.cgL.getTalkerUserName();
                        int i2 = i;
                        int i3 = i2;
                        if (c41908x.ecX == null) {
                            c41908x.ecX = C1853r.m3846Yz();
                        }
                        if (!c41908x.ecX.equals(talkerUserName)) {
                            if (c41908x.ecR != null) {
                                C4990ab.m7417i("MicroMsg.StayTimeReport", "enterChattingUI, not close:%s", c41908x.ecR.ede);
                                c41908x.mo67553jL(c41908x.ecR.ede);
                            }
                            if (c41908x.ecO.mo10573Ml(6) == 0) {
                                c41908x.ecO.setLong(4, C42252ah.anT());
                            }
                            C4879a.xxA.mo10051b(c41908x.ecP);
                            C4879a.xxA.mo10051b(c41908x.ecQ);
                            c41908x.ecR = new C32426a();
                            c41908x.ecR.edj = c41908x.ecS;
                            c41908x.ecS = 0;
                            c41908x.ecR.ede = talkerUserName;
                            c41908x.ecV = C42252ah.m74632yz();
                            c41908x.ecR.type = i2;
                            c41908x.ecR.edf = i3;
                            c41908x.ecR.csm = i;
                            c41908x.ecR.edg = mA;
                            c41908x.ecR.edh = C42252ah.anT();
                            C4990ab.m7417i("MicroMsg.StayTimeReport", "enter chattingUI: chatUser:%s----type:%d, notifyOpen:%d, unreadCount:%d, membercount:%d", talkerUserName, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(mA));
                        }
                        AppMethodBeat.m2505o(31347);
                    }
                }, "MicroMsg.ChattingUI.ChattingReportComponent");
            }
            ((C12514e) C1720g.m3528K(C12514e.class)).mo24440a("tmpl_type_succeed_contact", this.yPd);
        }
        this.yOx = true;
        m81966IF();
        AppMethodBeat.m2505o(31359);
    }
}
