package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.ui.h.c;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;

public final class i implements c, com.tencent.mm.plugin.location.ui.k.a {
    private Context context;
    private String ejR = "";
    private ViewGroup nMI;
    private View nMJ;
    private h nMK;
    private j nML;
    private ArrayList<String> nMM;
    private String nMN = "";
    private boolean nMO = false;
    public a nMP;
    private d nMj;

    public interface a {
        void PX(String str);
    }

    public i(Context context, ViewGroup viewGroup, View view, String str, d dVar) {
        AppMethodBeat.i(113512);
        this.nMI = viewGroup;
        this.nMJ = view;
        this.context = context;
        this.nMM = new ArrayList();
        this.ejR = str;
        this.nMj = dVar;
        init();
        AppMethodBeat.o(113512);
    }

    private void init() {
        AppMethodBeat.i(113513);
        ab.d("MicroMsg.ShareHeaderMgr", "init ShareHeaderMgr, roomname=%s", this.ejR);
        this.nMK = new h(this.context, this.nMJ, this.ejR);
        this.nMK.nMA = this;
        this.nML = new j(this.context, this.nMI, this.ejR);
        for (String add : l.bJz().tP(this.ejR)) {
            this.nMM.add(add);
        }
        AppMethodBeat.o(113513);
    }

    public final void H(ArrayList<String> arrayList) {
        String str;
        AppMethodBeat.i(113514);
        ab.d("MicroMsg.ShareHeaderMgr", "onRefreshMemberList, members.size=%d", Integer.valueOf(arrayList.size()));
        this.nMK.H(arrayList);
        j jVar = this.nML;
        ab.d("MicroMsg.ShareHeaderMsgMgr", "onRefreshMemberList, size=%d", Integer.valueOf(arrayList.size()));
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            if (jVar.nMR.indexOf(str) == -1) {
                arrayList2.add(str);
            }
        }
        it = jVar.nMR.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            if (arrayList.indexOf(str) == -1) {
                arrayList3.add(str);
            }
        }
        if (jVar.nNd) {
            jVar.nNd = false;
            if (arrayList2.size() > 0) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    jVar.nMR.add((String) it2.next());
                }
            }
            jVar.iC(false);
            AppMethodBeat.o(113514);
            return;
        }
        Message obtain;
        if (arrayList2.size() > 0) {
            str = (String) arrayList2.get(0);
            jVar.nMR.add(str);
            if (!bo.isNullOrNil(s.mJ(str))) {
                jVar.mHandler.removeMessages(3);
                obtain = Message.obtain();
                obtain.what = 3;
                obtain.obj = str;
                jVar.mHandler.sendMessage(obtain);
                jVar.iC(true);
            }
        }
        if (arrayList3.size() > 0) {
            str = (String) arrayList3.get(0);
            if (!(bo.isNullOrNil(str) || jVar.nMR.indexOf(str) == -1)) {
                jVar.nMR.remove(jVar.nMR.indexOf(str));
                if (!bo.isNullOrNil(s.mJ(str))) {
                    obtain = Message.obtain();
                    obtain.what = 4;
                    obtain.obj = str;
                    jVar.mHandler.sendMessage(obtain);
                    jVar.iC(true);
                }
            }
        }
        AppMethodBeat.o(113514);
    }

    public final void PX(String str) {
        AppMethodBeat.i(113515);
        if (this.nMP != null) {
            this.nMP.PX(str);
        }
        AppMethodBeat.o(113515);
    }

    public final void bJV() {
        AppMethodBeat.i(113516);
        ab.d("MicroMsg.ShareHeaderMgr", "onMyselfTalking");
        this.nMO = true;
        String Yz = r.Yz();
        this.nMK.bJR();
        this.nMK.PU(Yz);
        j jVar = this.nML;
        ab.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfTalking");
        jVar.mHandler.removeMessages(6);
        jVar.mHandler.removeMessages(5);
        Message obtain = Message.obtain();
        obtain.what = 6;
        jVar.mHandler.sendMessageAtFrontOfQueue(obtain);
        Object viewByItag = this.nMj.getViewByItag(Yz);
        if (viewByItag instanceof TrackPoint) {
            ((TrackPoint) viewByItag).set2Top();
        }
        this.nMN = Yz;
        AppMethodBeat.o(113516);
    }

    public final void PY(String str) {
        AppMethodBeat.i(113517);
        ab.d("MicroMsg.ShareHeaderMgr", "onCurTalkerChange, username = %s", str);
        if (this.nMO) {
            AppMethodBeat.o(113517);
            return;
        }
        this.nMN = str;
        h hVar = this.nMK;
        String str2 = this.nMN;
        ab.i("MicroMsg.ShareHeaderAvatarViewMgr", "onCurMemberChange, username=%s", str2);
        if (bo.isNullOrNil(str2)) {
            hVar.bJR();
        } else {
            hVar.bJR();
            hVar.PU(str2);
        }
        j jVar = this.nML;
        str2 = this.nMN;
        ab.d("MicroMsg.ShareHeaderMsgMgr", "onCurMemberChange, curMember=%s", str2);
        if (bo.isNullOrNil(str2)) {
            jVar.nNi = false;
            jVar.mHandler.removeMessages(10);
            Message obtain = Message.obtain();
            obtain.what = 10;
            jVar.mHandler.sendMessage(obtain);
            jVar.iC(true);
        } else {
            if (!bo.isNullOrNil(s.mJ(str2))) {
                jVar.nNi = true;
                jVar.mHandler.removeMessages(5);
                Message obtain2 = Message.obtain();
                obtain2.what = 5;
                obtain2.obj = str2;
                jVar.mHandler.sendMessageAtFrontOfQueue(obtain2);
            }
            jVar.iC(true);
        }
        Object viewByItag = this.nMj.getViewByItag(this.nMN);
        if (viewByItag instanceof TrackPoint) {
            ((TrackPoint) viewByItag).set2Top();
        }
        AppMethodBeat.o(113517);
    }

    public final void bJW() {
        AppMethodBeat.i(113518);
        ab.i("MicroMsg.ShareHeaderMgr", "onMyselfFinishTalking");
        h hVar = this.nMK;
        String Yz = r.Yz();
        ab.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberFinishTalking, username=%s", Yz);
        if (hVar.nMy.PW(Yz)) {
            hVar.nMy.PV(Yz).bJU();
            hVar.nMy.notifyDataSetChanged();
            hVar.nMx.invalidate();
        }
        j jVar = this.nML;
        ab.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfFinishTalking");
        jVar.mHandler.removeMessages(9);
        jVar.mHandler.removeMessages(10);
        Message obtain = Message.obtain();
        obtain.what = 9;
        jVar.mHandler.sendMessage(obtain);
        this.nMN = "";
        this.nMO = false;
        AppMethodBeat.o(113518);
    }

    public final void bJX() {
        AppMethodBeat.i(113519);
        j jVar = this.nML;
        ab.d("MicroMsg.ShareHeaderMsgMgr", "onPrepareTalking");
        jVar.mHandler.removeMessages(8);
        Message obtain = Message.obtain();
        obtain.what = 8;
        jVar.mHandler.sendMessageAtFrontOfQueue(obtain);
        AppMethodBeat.o(113519);
    }

    public final void PZ(String str) {
        AppMethodBeat.i(113520);
        j jVar = this.nML;
        ab.d("MicroMsg.ShareHeaderMsgMgr", "onTalkConflict, username=%s", str);
        if (!(bo.isNullOrNil(str) || bo.isNullOrNil(s.mJ(str)))) {
            jVar.nNi = true;
            jVar.mHandler.removeMessages(7);
            Message obtain = Message.obtain();
            obtain.what = 7;
            jVar.mHandler.sendMessageAtFrontOfQueue(obtain);
        }
        AppMethodBeat.o(113520);
    }
}
