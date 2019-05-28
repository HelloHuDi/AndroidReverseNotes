package com.tencent.p177mm.plugin.location.p446ui;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.plugin.location.model.C39287l;
import com.tencent.p177mm.plugin.location.p446ui.C3341h.C3345c;
import com.tencent.p177mm.plugin.location.p446ui.C46054k.C34424a;
import com.tencent.p177mm.plugin.location.p446ui.impl.TrackPoint;
import com.tencent.p177mm.plugin.p443k.C28354d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.location.ui.i */
public final class C46048i implements C3345c, C34424a {
    private Context context;
    private String ejR = "";
    private ViewGroup nMI;
    private View nMJ;
    private C3341h nMK;
    private C43246j nML;
    private ArrayList<String> nMM;
    private String nMN = "";
    private boolean nMO = false;
    public C43244a nMP;
    private C28354d nMj;

    /* renamed from: com.tencent.mm.plugin.location.ui.i$a */
    public interface C43244a {
        /* renamed from: PX */
        void mo46358PX(String str);
    }

    public C46048i(Context context, ViewGroup viewGroup, View view, String str, C28354d c28354d) {
        AppMethodBeat.m2504i(113512);
        this.nMI = viewGroup;
        this.nMJ = view;
        this.context = context;
        this.nMM = new ArrayList();
        this.ejR = str;
        this.nMj = c28354d;
        init();
        AppMethodBeat.m2505o(113512);
    }

    private void init() {
        AppMethodBeat.m2504i(113513);
        C4990ab.m7411d("MicroMsg.ShareHeaderMgr", "init ShareHeaderMgr, roomname=%s", this.ejR);
        this.nMK = new C3341h(this.context, this.nMJ, this.ejR);
        this.nMK.nMA = this;
        this.nML = new C43246j(this.context, this.nMI, this.ejR);
        for (String add : C39287l.bJz().mo20564tP(this.ejR)) {
            this.nMM.add(add);
        }
        AppMethodBeat.m2505o(113513);
    }

    /* renamed from: H */
    public final void mo73942H(ArrayList<String> arrayList) {
        String str;
        AppMethodBeat.m2504i(113514);
        C4990ab.m7411d("MicroMsg.ShareHeaderMgr", "onRefreshMemberList, members.size=%d", Integer.valueOf(arrayList.size()));
        this.nMK.mo7738H(arrayList);
        C43246j c43246j = this.nML;
        C4990ab.m7411d("MicroMsg.ShareHeaderMsgMgr", "onRefreshMemberList, size=%d", Integer.valueOf(arrayList.size()));
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            if (c43246j.nMR.indexOf(str) == -1) {
                arrayList2.add(str);
            }
        }
        it = c43246j.nMR.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            if (arrayList.indexOf(str) == -1) {
                arrayList3.add(str);
            }
        }
        if (c43246j.nNd) {
            c43246j.nNd = false;
            if (arrayList2.size() > 0) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    c43246j.nMR.add((String) it2.next());
                }
            }
            c43246j.mo68769iC(false);
            AppMethodBeat.m2505o(113514);
            return;
        }
        Message obtain;
        if (arrayList2.size() > 0) {
            str = (String) arrayList2.get(0);
            c43246j.nMR.add(str);
            if (!C5046bo.isNullOrNil(C1854s.m3866mJ(str))) {
                c43246j.mHandler.removeMessages(3);
                obtain = Message.obtain();
                obtain.what = 3;
                obtain.obj = str;
                c43246j.mHandler.sendMessage(obtain);
                c43246j.mo68769iC(true);
            }
        }
        if (arrayList3.size() > 0) {
            str = (String) arrayList3.get(0);
            if (!(C5046bo.isNullOrNil(str) || c43246j.nMR.indexOf(str) == -1)) {
                c43246j.nMR.remove(c43246j.nMR.indexOf(str));
                if (!C5046bo.isNullOrNil(C1854s.m3866mJ(str))) {
                    obtain = Message.obtain();
                    obtain.what = 4;
                    obtain.obj = str;
                    c43246j.mHandler.sendMessage(obtain);
                    c43246j.mo68769iC(true);
                }
            }
        }
        AppMethodBeat.m2505o(113514);
    }

    /* renamed from: PX */
    public final void mo7750PX(String str) {
        AppMethodBeat.m2504i(113515);
        if (this.nMP != null) {
            this.nMP.mo46358PX(str);
        }
        AppMethodBeat.m2505o(113515);
    }

    public final void bJV() {
        AppMethodBeat.m2504i(113516);
        C4990ab.m7410d("MicroMsg.ShareHeaderMgr", "onMyselfTalking");
        this.nMO = true;
        String Yz = C1853r.m3846Yz();
        this.nMK.bJR();
        this.nMK.mo7739PU(Yz);
        C43246j c43246j = this.nML;
        C4990ab.m7410d("MicroMsg.ShareHeaderMsgMgr", "onMyselfTalking");
        c43246j.mHandler.removeMessages(6);
        c43246j.mHandler.removeMessages(5);
        Message obtain = Message.obtain();
        obtain.what = 6;
        c43246j.mHandler.sendMessageAtFrontOfQueue(obtain);
        Object viewByItag = this.nMj.getViewByItag(Yz);
        if (viewByItag instanceof TrackPoint) {
            ((TrackPoint) viewByItag).set2Top();
        }
        this.nMN = Yz;
        AppMethodBeat.m2505o(113516);
    }

    /* renamed from: PY */
    public final void mo54929PY(String str) {
        AppMethodBeat.m2504i(113517);
        C4990ab.m7411d("MicroMsg.ShareHeaderMgr", "onCurTalkerChange, username = %s", str);
        if (this.nMO) {
            AppMethodBeat.m2505o(113517);
            return;
        }
        this.nMN = str;
        C3341h c3341h = this.nMK;
        String str2 = this.nMN;
        C4990ab.m7417i("MicroMsg.ShareHeaderAvatarViewMgr", "onCurMemberChange, username=%s", str2);
        if (C5046bo.isNullOrNil(str2)) {
            c3341h.bJR();
        } else {
            c3341h.bJR();
            c3341h.mo7739PU(str2);
        }
        C43246j c43246j = this.nML;
        str2 = this.nMN;
        C4990ab.m7411d("MicroMsg.ShareHeaderMsgMgr", "onCurMemberChange, curMember=%s", str2);
        if (C5046bo.isNullOrNil(str2)) {
            c43246j.nNi = false;
            c43246j.mHandler.removeMessages(10);
            Message obtain = Message.obtain();
            obtain.what = 10;
            c43246j.mHandler.sendMessage(obtain);
            c43246j.mo68769iC(true);
        } else {
            if (!C5046bo.isNullOrNil(C1854s.m3866mJ(str2))) {
                c43246j.nNi = true;
                c43246j.mHandler.removeMessages(5);
                Message obtain2 = Message.obtain();
                obtain2.what = 5;
                obtain2.obj = str2;
                c43246j.mHandler.sendMessageAtFrontOfQueue(obtain2);
            }
            c43246j.mo68769iC(true);
        }
        Object viewByItag = this.nMj.getViewByItag(this.nMN);
        if (viewByItag instanceof TrackPoint) {
            ((TrackPoint) viewByItag).set2Top();
        }
        AppMethodBeat.m2505o(113517);
    }

    public final void bJW() {
        AppMethodBeat.m2504i(113518);
        C4990ab.m7416i("MicroMsg.ShareHeaderMgr", "onMyselfFinishTalking");
        C3341h c3341h = this.nMK;
        String Yz = C1853r.m3846Yz();
        C4990ab.m7411d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberFinishTalking, username=%s", Yz);
        if (c3341h.nMy.mo7742PW(Yz)) {
            c3341h.nMy.mo7741PV(Yz).bJU();
            c3341h.nMy.notifyDataSetChanged();
            c3341h.nMx.invalidate();
        }
        C43246j c43246j = this.nML;
        C4990ab.m7410d("MicroMsg.ShareHeaderMsgMgr", "onMyselfFinishTalking");
        c43246j.mHandler.removeMessages(9);
        c43246j.mHandler.removeMessages(10);
        Message obtain = Message.obtain();
        obtain.what = 9;
        c43246j.mHandler.sendMessage(obtain);
        this.nMN = "";
        this.nMO = false;
        AppMethodBeat.m2505o(113518);
    }

    public final void bJX() {
        AppMethodBeat.m2504i(113519);
        C43246j c43246j = this.nML;
        C4990ab.m7410d("MicroMsg.ShareHeaderMsgMgr", "onPrepareTalking");
        c43246j.mHandler.removeMessages(8);
        Message obtain = Message.obtain();
        obtain.what = 8;
        c43246j.mHandler.sendMessageAtFrontOfQueue(obtain);
        AppMethodBeat.m2505o(113519);
    }

    /* renamed from: PZ */
    public final void mo54930PZ(String str) {
        AppMethodBeat.m2504i(113520);
        C43246j c43246j = this.nML;
        C4990ab.m7411d("MicroMsg.ShareHeaderMsgMgr", "onTalkConflict, username=%s", str);
        if (!(C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(C1854s.m3866mJ(str)))) {
            c43246j.nNi = true;
            c43246j.mHandler.removeMessages(7);
            Message obtain = Message.obtain();
            obtain.what = 7;
            c43246j.mHandler.sendMessageAtFrontOfQueue(obtain);
        }
        AppMethodBeat.m2505o(113520);
    }
}
