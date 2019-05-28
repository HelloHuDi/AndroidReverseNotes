package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.c.v;
import com.tencent.mm.ui.chatting.g.b;
import com.tencent.xweb.util.d;

public final class a {
    private static ak yTt = new ak();
    public boolean caA = false;
    public ad sRl;
    public String yTA;
    public String yTB;
    public com.tencent.mm.ui.chatting.g.a yTu = new com.tencent.mm.ui.chatting.g.a(this);
    public b yTv = new b(this);
    public String yTw;
    public BaseChattingUIFragment yTx;
    public ae yTy;
    public af yTz;

    static {
        AppMethodBeat.i(31947);
        AppMethodBeat.o(31947);
    }

    public a(BaseChattingUIFragment baseChattingUIFragment, ae aeVar, af afVar) {
        AppMethodBeat.i(31911);
        this.yTx = baseChattingUIFragment;
        this.yTy = aeVar;
        this.yTz = afVar;
        AppMethodBeat.o(31911);
    }

    public final String getTalkerUserName() {
        AppMethodBeat.i(31912);
        String str;
        if (this.sRl == null) {
            str = "";
            AppMethodBeat.o(31912);
            return str;
        }
        str = bo.bc(this.sRl.field_username, "");
        AppMethodBeat.o(31912);
        return str;
    }

    public final void af(ad adVar) {
        AppMethodBeat.i(31913);
        this.sRl = adVar;
        this.yTA = d.x((adVar.field_username + System.currentTimeMillis()).getBytes());
        AppMethodBeat.o(31913);
    }

    public final String dFt() {
        return this.yTB != null ? this.yTB : "";
    }

    public final String dFu() {
        AppMethodBeat.i(31914);
        if (this.yTw == null) {
            this.yTw = r.Yz();
            this.yTw = ad.mR(getTalkerUserName()) ? ad.aoC(this.yTw) : this.yTw;
        }
        String str = this.yTw;
        AppMethodBeat.o(31914);
        return str;
    }

    public final String dDw() {
        AppMethodBeat.i(31915);
        String bc = bo.bc(((com.tencent.mm.ui.chatting.c.b.d) aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDw(), this.sRl.field_nickname);
        AppMethodBeat.o(31915);
        return bc;
    }

    public final View findViewById(int i) {
        AppMethodBeat.i(31916);
        View findViewById = this.yTx.findViewById(i);
        AppMethodBeat.o(31916);
        return findViewById;
    }

    public final Activity getContext() {
        AppMethodBeat.i(139026);
        Activity context = this.yTx.getContext();
        AppMethodBeat.o(139026);
        return context;
    }

    public final boolean dFv() {
        AppMethodBeat.i(31918);
        String talkerUserName = getTalkerUserName();
        if (ad.mR(talkerUserName) || ad.aow(talkerUserName) || ad.aou(talkerUserName) || t.no(talkerUserName)) {
            AppMethodBeat.o(31918);
            return true;
        }
        AppMethodBeat.o(31918);
        return false;
    }

    public final boolean dFw() {
        AppMethodBeat.i(31919);
        if (t.kH(getTalkerUserName()) || t.mP(getTalkerUserName())) {
            AppMethodBeat.o(31919);
            return true;
        }
        AppMethodBeat.o(31919);
        return false;
    }

    public final boolean dFx() {
        AppMethodBeat.i(31920);
        if (t.kH(getTalkerUserName()) || t.mP(getTalkerUserName()) || ((com.tencent.mm.ui.chatting.c.b.d) aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDn()) {
            AppMethodBeat.o(31920);
            return true;
        }
        AppMethodBeat.o(31920);
        return false;
    }

    public static ak dFz() {
        return yTt;
    }

    public final void a(Intent intent, int i, com.tencent.mm.bp.d.a aVar) {
        AppMethodBeat.i(31923);
        this.yTv.a(intent, i, aVar);
        AppMethodBeat.o(31923);
    }

    @Deprecated
    public final ListView getListView() {
        AppMethodBeat.i(31924);
        ListView listView = this.yTy.getListView();
        AppMethodBeat.o(31924);
        return listView;
    }

    public final void Or(int i) {
        AppMethodBeat.i(31925);
        this.yTy.Or(i);
        AppMethodBeat.o(31925);
    }

    public final int getFirstVisiblePosition() {
        AppMethodBeat.i(31926);
        int firstVisiblePosition = this.yTy.getFirstVisiblePosition();
        AppMethodBeat.o(31926);
        return firstVisiblePosition;
    }

    public final int getLastVisiblePosition() {
        AppMethodBeat.i(31927);
        int lastVisiblePosition = this.yTy.getLastVisiblePosition();
        AppMethodBeat.o(31927);
        return lastVisiblePosition;
    }

    public final int getHeaderViewsCount() {
        AppMethodBeat.i(31928);
        int headerViewsCount = this.yTy.getHeaderViewsCount();
        AppMethodBeat.o(31928);
        return headerViewsCount;
    }

    public final View getChildAt(int i) {
        AppMethodBeat.i(31929);
        View childAt = this.yTy.getChildAt(i);
        AppMethodBeat.o(31929);
        return childAt;
    }

    public final void c(Context context, String str, OnCancelListener onCancelListener) {
        AppMethodBeat.i(31930);
        ab.i("MicroMsg.ChattingContext", "[showDialog]");
        this.yTy.c(context, str, onCancelListener);
        AppMethodBeat.o(31930);
    }

    public final void dismissDialog() {
        AppMethodBeat.i(31931);
        ab.i("MicroMsg.ChattingContext", "[dismissDialog]");
        this.yTy.dismissDialog();
        AppMethodBeat.o(31931);
    }

    public final void aqX() {
        AppMethodBeat.i(31932);
        ab.i("MicroMsg.ChattingContext", "[hideVKB]");
        this.yTy.hideVKB();
        AppMethodBeat.o(31932);
    }

    public final void showVKB() {
        AppMethodBeat.i(31933);
        ab.i("MicroMsg.ChattingContext", "[showVKB]");
        this.yTy.showVKB();
        AppMethodBeat.o(31933);
    }

    public final void aWv() {
        AppMethodBeat.i(31934);
        ab.i("MicroMsg.ChattingContext", "[notifyDataSetChange]");
        this.yTy.aWv();
        AppMethodBeat.o(31934);
    }

    public final void Oq(int i) {
        AppMethodBeat.i(31935);
        ab.i("MicroMsg.ChattingContext", "[setSelection] pos:%s isSmooth:%s", Integer.valueOf(i), Boolean.FALSE);
        this.yTy.Oq(i);
        AppMethodBeat.o(31935);
    }

    public final void ho(int i, int i2) {
        AppMethodBeat.i(31936);
        ab.i("MicroMsg.ChattingContext", "[setSelectionFromTop] pos:%s offset:%s isSmooth:%s", Integer.valueOf(i), Integer.valueOf(i2), Boolean.FALSE);
        this.yTy.ho(i, i2);
        AppMethodBeat.o(31936);
    }

    public final void dCy() {
        AppMethodBeat.i(31937);
        ab.i("MicroMsg.ChattingContext", "[smoothScrollBy] dis:%s duration:%s", Integer.valueOf(0), Integer.valueOf(0));
        this.yTy.dCy();
        AppMethodBeat.o(31937);
    }

    public final void qp(boolean z) {
        AppMethodBeat.i(31938);
        ab.i("MicroMsg.ChattingContext", "[scrollToLast] force:%b", Boolean.valueOf(z));
        this.yTy.qp(z);
        AppMethodBeat.o(31938);
    }

    public final void dFA() {
        AppMethodBeat.i(31939);
        ab.i("MicroMsg.ChattingContext", "[scrollToLast] force:%b", Boolean.TRUE);
        this.yTy.aj(true, true);
        AppMethodBeat.o(31939);
    }

    public final void bY(int i) {
        AppMethodBeat.i(31940);
        ab.i("MicroMsg.ChattingContext", "[scrollToLast] position:%d", Integer.valueOf(i));
        this.yTy.bY(i);
        AppMethodBeat.o(31940);
    }

    public final void setKeepScreenOn(boolean z) {
        AppMethodBeat.i(31941);
        ab.i("MicroMsg.ChattingContext", "[setKeepScreenOn] force:%b", Boolean.valueOf(z));
        this.yTy.setKeepScreenOn(z);
        AppMethodBeat.o(31941);
    }

    public final void qv(boolean z) {
        AppMethodBeat.i(31942);
        ab.i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d show:%s", Integer.valueOf(2), Boolean.valueOf(z));
        this.yTy.showOptionMenu(2, z);
        AppMethodBeat.o(31942);
    }

    public final void showOptionMenu(boolean z) {
        AppMethodBeat.i(31943);
        ab.i("MicroMsg.ChattingContext", "[showOptionMenu] show:%s", Boolean.valueOf(z));
        this.yTy.showOptionMenu(z);
        AppMethodBeat.o(31943);
    }

    public final void Na(int i) {
        AppMethodBeat.i(31944);
        ab.i("MicroMsg.ChattingContext", "[updateOptionMenuIcon] menuID:%d iconID:%s", Integer.valueOf(2), Integer.valueOf(i));
        this.yTy.updateOptionMenuIcon(2, i);
        AppMethodBeat.o(31944);
    }

    public final <T extends v, V extends Class<T>> T aF(V v) {
        AppMethodBeat.i(31945);
        v aF = this.yTu.aF(v);
        AppMethodBeat.o(31945);
        return aF;
    }

    public final void a(Class<? extends v> cls, v vVar) {
        AppMethodBeat.i(31946);
        this.yTu.a(cls, vVar);
        AppMethodBeat.o(31946);
    }

    public final boolean dFy() {
        AppMethodBeat.i(31921);
        if (!this.sRl.dsf() && !t.nF(getTalkerUserName()) && !ad.aou(getTalkerUserName())) {
            AppMethodBeat.o(31921);
            return true;
        } else if (((com.tencent.mm.ui.chatting.c.b.d) aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDm()) {
            AppMethodBeat.o(31921);
            return true;
        } else {
            AppMethodBeat.o(31921);
            return false;
        }
    }

    public final void startActivity(Intent intent) {
        AppMethodBeat.i(31922);
        this.yTx.startActivity(intent);
        AppMethodBeat.o(31922);
    }
}
