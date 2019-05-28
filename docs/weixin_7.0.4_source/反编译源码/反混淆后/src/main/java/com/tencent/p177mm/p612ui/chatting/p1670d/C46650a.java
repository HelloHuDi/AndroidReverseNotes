package com.tencent.p177mm.p612ui.chatting.p1670d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p612ui.chatting.BaseChattingUIFragment;
import com.tencent.p177mm.p612ui.chatting.C40709ae;
import com.tencent.p177mm.p612ui.chatting.C44285af;
import com.tencent.p177mm.p612ui.chatting.p1511g.C36167a;
import com.tencent.p177mm.p612ui.chatting.p1511g.C40753b;
import com.tencent.p177mm.p612ui.chatting.p616c.C5326v;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p842bp.C25985d.C25987a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.xweb.util.C6037d;

/* renamed from: com.tencent.mm.ui.chatting.d.a */
public final class C46650a {
    private static C7306ak yTt = new C7306ak();
    public boolean caA = false;
    public C7616ad sRl;
    public String yTA;
    public String yTB;
    public C36167a yTu = new C36167a(this);
    public C40753b yTv = new C40753b(this);
    public String yTw;
    public BaseChattingUIFragment yTx;
    public C40709ae yTy;
    public C44285af yTz;

    static {
        AppMethodBeat.m2504i(31947);
        AppMethodBeat.m2505o(31947);
    }

    public C46650a(BaseChattingUIFragment baseChattingUIFragment, C40709ae c40709ae, C44285af c44285af) {
        AppMethodBeat.m2504i(31911);
        this.yTx = baseChattingUIFragment;
        this.yTy = c40709ae;
        this.yTz = c44285af;
        AppMethodBeat.m2505o(31911);
    }

    public final String getTalkerUserName() {
        AppMethodBeat.m2504i(31912);
        String str;
        if (this.sRl == null) {
            str = "";
            AppMethodBeat.m2505o(31912);
            return str;
        }
        str = C5046bo.m7532bc(this.sRl.field_username, "");
        AppMethodBeat.m2505o(31912);
        return str;
    }

    /* renamed from: af */
    public final void mo74859af(C7616ad c7616ad) {
        AppMethodBeat.m2504i(31913);
        this.sRl = c7616ad;
        this.yTA = C6037d.m9506x((c7616ad.field_username + System.currentTimeMillis()).getBytes());
        AppMethodBeat.m2505o(31913);
    }

    public final String dFt() {
        return this.yTB != null ? this.yTB : "";
    }

    public final String dFu() {
        AppMethodBeat.m2504i(31914);
        if (this.yTw == null) {
            this.yTw = C1853r.m3846Yz();
            this.yTw = C7616ad.m13548mR(getTalkerUserName()) ? C7616ad.aoC(this.yTw) : this.yTw;
        }
        String str = this.yTw;
        AppMethodBeat.m2505o(31914);
        return str;
    }

    public final String dDw() {
        AppMethodBeat.m2504i(31915);
        String bc = C5046bo.m7532bc(((C36135d) mo74857aF(C36135d.class)).dDw(), this.sRl.field_nickname);
        AppMethodBeat.m2505o(31915);
        return bc;
    }

    public final View findViewById(int i) {
        AppMethodBeat.m2504i(31916);
        View findViewById = this.yTx.findViewById(i);
        AppMethodBeat.m2505o(31916);
        return findViewById;
    }

    public final Activity getContext() {
        AppMethodBeat.m2504i(139026);
        Activity context = this.yTx.getContext();
        AppMethodBeat.m2505o(139026);
        return context;
    }

    public final boolean dFv() {
        AppMethodBeat.m2504i(31918);
        String talkerUserName = getTalkerUserName();
        if (C7616ad.m13548mR(talkerUserName) || C7616ad.aow(talkerUserName) || C7616ad.aou(talkerUserName) || C1855t.m3946no(talkerUserName)) {
            AppMethodBeat.m2505o(31918);
            return true;
        }
        AppMethodBeat.m2505o(31918);
        return false;
    }

    public final boolean dFw() {
        AppMethodBeat.m2504i(31919);
        if (C1855t.m3896kH(getTalkerUserName()) || C1855t.m3903mP(getTalkerUserName())) {
            AppMethodBeat.m2505o(31919);
            return true;
        }
        AppMethodBeat.m2505o(31919);
        return false;
    }

    public final boolean dFx() {
        AppMethodBeat.m2504i(31920);
        if (C1855t.m3896kH(getTalkerUserName()) || C1855t.m3903mP(getTalkerUserName()) || ((C36135d) mo74857aF(C36135d.class)).dDn()) {
            AppMethodBeat.m2505o(31920);
            return true;
        }
        AppMethodBeat.m2505o(31920);
        return false;
    }

    public static C7306ak dFz() {
        return yTt;
    }

    /* renamed from: a */
    public final void mo74855a(Intent intent, int i, C25987a c25987a) {
        AppMethodBeat.m2504i(31923);
        this.yTv.mo43869a(intent, i, c25987a);
        AppMethodBeat.m2505o(31923);
    }

    @Deprecated
    public final ListView getListView() {
        AppMethodBeat.m2504i(31924);
        ListView listView = this.yTy.getListView();
        AppMethodBeat.m2505o(31924);
        return listView;
    }

    /* renamed from: Or */
    public final void mo74854Or(int i) {
        AppMethodBeat.m2504i(31925);
        this.yTy.mo56961Or(i);
        AppMethodBeat.m2505o(31925);
    }

    public final int getFirstVisiblePosition() {
        AppMethodBeat.m2504i(31926);
        int firstVisiblePosition = this.yTy.getFirstVisiblePosition();
        AppMethodBeat.m2505o(31926);
        return firstVisiblePosition;
    }

    public final int getLastVisiblePosition() {
        AppMethodBeat.m2504i(31927);
        int lastVisiblePosition = this.yTy.getLastVisiblePosition();
        AppMethodBeat.m2505o(31927);
        return lastVisiblePosition;
    }

    public final int getHeaderViewsCount() {
        AppMethodBeat.m2504i(31928);
        int headerViewsCount = this.yTy.getHeaderViewsCount();
        AppMethodBeat.m2505o(31928);
        return headerViewsCount;
    }

    public final View getChildAt(int i) {
        AppMethodBeat.m2504i(31929);
        View childAt = this.yTy.getChildAt(i);
        AppMethodBeat.m2505o(31929);
        return childAt;
    }

    /* renamed from: c */
    public final void mo74862c(Context context, String str, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(31930);
        C4990ab.m7416i("MicroMsg.ChattingContext", "[showDialog]");
        this.yTy.mo56967c(context, str, onCancelListener);
        AppMethodBeat.m2505o(31930);
    }

    public final void dismissDialog() {
        AppMethodBeat.m2504i(31931);
        C4990ab.m7416i("MicroMsg.ChattingContext", "[dismissDialog]");
        this.yTy.dismissDialog();
        AppMethodBeat.m2505o(31931);
    }

    public final void aqX() {
        AppMethodBeat.m2504i(31932);
        C4990ab.m7416i("MicroMsg.ChattingContext", "[hideVKB]");
        this.yTy.hideVKB();
        AppMethodBeat.m2505o(31932);
    }

    public final void showVKB() {
        AppMethodBeat.m2504i(31933);
        C4990ab.m7416i("MicroMsg.ChattingContext", "[showVKB]");
        this.yTy.showVKB();
        AppMethodBeat.m2505o(31933);
    }

    public final void aWv() {
        AppMethodBeat.m2504i(31934);
        C4990ab.m7416i("MicroMsg.ChattingContext", "[notifyDataSetChange]");
        this.yTy.aWv();
        AppMethodBeat.m2505o(31934);
    }

    /* renamed from: Oq */
    public final void mo74853Oq(int i) {
        AppMethodBeat.m2504i(31935);
        C4990ab.m7417i("MicroMsg.ChattingContext", "[setSelection] pos:%s isSmooth:%s", Integer.valueOf(i), Boolean.FALSE);
        this.yTy.mo56960Oq(i);
        AppMethodBeat.m2505o(31935);
    }

    /* renamed from: ho */
    public final void mo74881ho(int i, int i2) {
        AppMethodBeat.m2504i(31936);
        C4990ab.m7417i("MicroMsg.ChattingContext", "[setSelectionFromTop] pos:%s offset:%s isSmooth:%s", Integer.valueOf(i), Integer.valueOf(i2), Boolean.FALSE);
        this.yTy.mo56980ho(i, i2);
        AppMethodBeat.m2505o(31936);
    }

    public final void dCy() {
        AppMethodBeat.m2504i(31937);
        C4990ab.m7417i("MicroMsg.ChattingContext", "[smoothScrollBy] dis:%s duration:%s", Integer.valueOf(0), Integer.valueOf(0));
        this.yTy.dCy();
        AppMethodBeat.m2505o(31937);
    }

    /* renamed from: qp */
    public final void mo74882qp(boolean z) {
        AppMethodBeat.m2504i(31938);
        C4990ab.m7417i("MicroMsg.ChattingContext", "[scrollToLast] force:%b", Boolean.valueOf(z));
        this.yTy.mo56982qp(z);
        AppMethodBeat.m2505o(31938);
    }

    public final void dFA() {
        AppMethodBeat.m2504i(31939);
        C4990ab.m7417i("MicroMsg.ChattingContext", "[scrollToLast] force:%b", Boolean.TRUE);
        this.yTy.mo56963aj(true, true);
        AppMethodBeat.m2505o(31939);
    }

    /* renamed from: bY */
    public final void mo74861bY(int i) {
        AppMethodBeat.m2504i(31940);
        C4990ab.m7417i("MicroMsg.ChattingContext", "[scrollToLast] position:%d", Integer.valueOf(i));
        this.yTy.mo56966bY(i);
        AppMethodBeat.m2505o(31940);
    }

    public final void setKeepScreenOn(boolean z) {
        AppMethodBeat.m2504i(31941);
        C4990ab.m7417i("MicroMsg.ChattingContext", "[setKeepScreenOn] force:%b", Boolean.valueOf(z));
        this.yTy.setKeepScreenOn(z);
        AppMethodBeat.m2505o(31941);
    }

    /* renamed from: qv */
    public final void mo74883qv(boolean z) {
        AppMethodBeat.m2504i(31942);
        C4990ab.m7417i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d show:%s", Integer.valueOf(2), Boolean.valueOf(z));
        this.yTy.showOptionMenu(2, z);
        AppMethodBeat.m2505o(31942);
    }

    public final void showOptionMenu(boolean z) {
        AppMethodBeat.m2504i(31943);
        C4990ab.m7417i("MicroMsg.ChattingContext", "[showOptionMenu] show:%s", Boolean.valueOf(z));
        this.yTy.showOptionMenu(z);
        AppMethodBeat.m2505o(31943);
    }

    /* renamed from: Na */
    public final void mo74852Na(int i) {
        AppMethodBeat.m2504i(31944);
        C4990ab.m7417i("MicroMsg.ChattingContext", "[updateOptionMenuIcon] menuID:%d iconID:%s", Integer.valueOf(2), Integer.valueOf(i));
        this.yTy.updateOptionMenuIcon(2, i);
        AppMethodBeat.m2505o(31944);
    }

    /* renamed from: aF */
    public final <T extends C5326v, V extends Class<T>> T mo74857aF(V v) {
        AppMethodBeat.m2504i(31945);
        C5326v aF = this.yTu.mo57059aF(v);
        AppMethodBeat.m2505o(31945);
        return aF;
    }

    /* renamed from: a */
    public final void mo74856a(Class<? extends C5326v> cls, C5326v c5326v) {
        AppMethodBeat.m2504i(31946);
        this.yTu.mo57058a(cls, c5326v);
        AppMethodBeat.m2505o(31946);
    }

    public final boolean dFy() {
        AppMethodBeat.m2504i(31921);
        if (!this.sRl.dsf() && !C1855t.m3920nF(getTalkerUserName()) && !C7616ad.aou(getTalkerUserName())) {
            AppMethodBeat.m2505o(31921);
            return true;
        } else if (((C36135d) mo74857aF(C36135d.class)).dDm()) {
            AppMethodBeat.m2505o(31921);
            return true;
        } else {
            AppMethodBeat.m2505o(31921);
            return false;
        }
    }

    public final void startActivity(Intent intent) {
        AppMethodBeat.m2504i(31922);
        this.yTx.startActivity(intent);
        AppMethodBeat.m2505o(31922);
    }
}
