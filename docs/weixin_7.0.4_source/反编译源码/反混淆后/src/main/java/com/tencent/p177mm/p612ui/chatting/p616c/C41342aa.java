package com.tencent.p177mm.p612ui.chatting.p616c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.view.MenuItem;
import android.widget.AbsListView;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.booter.notification.queue.C9203b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C37947g;
import com.tencent.p177mm.modelsimple.C37951y;
import com.tencent.p177mm.modelstat.C45457b;
import com.tencent.p177mm.p181af.C1191k;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p201az.C32325e;
import com.tencent.p177mm.p202bf.C25858d;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p230g.p231a.C6513ls;
import com.tencent.p177mm.p230g.p231a.C6541qc;
import com.tencent.p177mm.p230g.p231a.C6550tn;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMAppMgr;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.C23696ac;
import com.tencent.p177mm.p612ui.chatting.C44288am;
import com.tencent.p177mm.p612ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15613i;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C23731w;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C30471y;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40726v;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C46641ai;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c;
import com.tencent.p177mm.plugin.fav.p408b.p969c.C43061a;
import com.tencent.p177mm.plugin.fav.p408b.p969c.C43061a.C11859a;
import com.tencent.p177mm.pluginsdk.model.C30076j;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.wallet.C14991i;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4997aj;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.util.LinkedList;
import java.util.List;

@C15590a(dFp = C40726v.class)
@Deprecated
/* renamed from: com.tencent.mm.ui.chatting.c.aa */
public class C41342aa extends C44291a implements C40726v {
    private List<C7620bi> yQU;
    private int yQV;
    private boolean yQW = false;
    private Runnable yQX = null;
    private C23696ac yQY = null;

    /* renamed from: com.tencent.mm.ui.chatting.c.aa$4 */
    class C170164 implements C11859a {
        C170164() {
        }

        public final void bvs() {
            AppMethodBeat.m2504i(31582);
            C41342aa.this.cgL.aqX();
            AppMethodBeat.m2505o(31582);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.aa$1 */
    class C413431 implements Runnable {
        C413431() {
        }

        public final void run() {
            AppMethodBeat.m2504i(31580);
            if (C41342aa.this.cgL == null) {
                AppMethodBeat.m2505o(31580);
                return;
            }
            C4990ab.m7416i("MicroMsg.ChattingUI.MessBoxComponent", "now try to activity the tools process");
            C45287c.aNX();
            AppMethodBeat.m2505o(31580);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.aa$3 */
    class C413443 implements OnClickListener {
        C413443() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        Cursor cursor = null;
        AppMethodBeat.m2504i(31583);
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.ChattingUI.MessBoxComponent";
        String str2 = "onActivityResult requestCode:%d, data is null:%b  rawUserName:%s ";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(intent == null);
        objArr[2] = this.cgL.getTalkerUserName();
        C4990ab.m7417i(str, str2, objArr);
        switch (i) {
            case 211:
                if (i2 == -1) {
                    Uri data = intent.getData();
                    if (this.cgL != null) {
                        cursor = this.cgL.yTx.getContext().managedQuery(data, null, null, null, null);
                    }
                    if (cursor.moveToFirst()) {
                        this.cgL.yTx.startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/".concat(String.valueOf(cursor.getString(cursor.getColumnIndexOrThrow("_id")))))));
                    }
                    AppMethodBeat.m2505o(31583);
                    return;
                }
                break;
            case 213:
                if (intent != null && intent.getBooleanExtra("_delete_ok_", false)) {
                    this.cgL.yTx.dBP();
                    AppMethodBeat.m2505o(31583);
                    return;
                }
            default:
                C4990ab.m7412e("MicroMsg.ChattingUI.MessBoxComponent", "onActivityResult: not found this requestCode");
                break;
        }
        AppMethodBeat.m2505o(31583);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.m2504i(31584);
        super.onScrollStateChanged(absListView, i);
        if (i == 0) {
            C6550tn c6550tn = new C6550tn();
            c6550tn.cPI.type = 5;
            c6550tn.cPI.cPJ = this.cgL.getFirstVisiblePosition();
            c6550tn.cPI.cPK = this.cgL.getLastVisiblePosition();
            c6550tn.cPI.cPL = this.cgL.getHeaderViewsCount();
            C4879a.xxA.mo10055m(c6550tn);
        }
        AppMethodBeat.m2505o(31584);
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31585);
        super.dDh();
        C9638aw.m17190ZK();
        if (C18628c.m29074XI()) {
            C37951y.m64163ab(this.cgL.getTalkerUserName(), 5);
        }
        AppMethodBeat.m2505o(31585);
    }

    public final List<C7620bi> dEK() {
        return this.yQU;
    }

    public final void dxy() {
        AppMethodBeat.m2504i(31587);
        C9203b IP = C9203b.m16707IP();
        String talkerUserName = this.cgL.getTalkerUserName();
        if (!C5046bo.isNullOrNil(talkerUserName)) {
            IP.eei.remove(talkerUserName);
        }
        if (this.cgL.dFx()) {
            C25858d.chatType = 1;
        } else {
            C25858d.chatType = 0;
        }
        if (this.yQU != null) {
            this.yQU.clear();
        }
        C9638aw.m17190ZK();
        C7617ak aoZ = C18628c.m29083XR().aoZ(this.cgL.getTalkerUserName());
        if (((C36135d) this.cgL.mo74857aF(C36135d.class)).dDm()) {
            this.yQU = ((C36135d) this.cgL.mo74857aF(C36135d.class)).dDr();
        } else if (aoZ != null && aoZ.field_unReadCount > 0) {
            int i;
            if (aoZ.field_unReadCount > 100) {
                i = 100;
            } else {
                i = aoZ.field_unReadCount;
            }
            C9638aw.m17190ZK();
            this.yQU = C18628c.m29080XO().mo15321ct(this.cgL.getTalkerUserName(), i);
        }
        if (this.yQU == null) {
            this.yQU = new LinkedList();
        }
        this.yQV = this.yQU.size();
        AppMethodBeat.m2505o(31587);
    }

    public final void dxz() {
        AppMethodBeat.m2504i(31588);
        C6550tn c6550tn = new C6550tn();
        c6550tn.cPI.type = 4;
        C4879a.xxA.mo10055m(c6550tn);
        if (this.cgL != null) {
            C4990ab.m7416i("MicroMsg.ChattingUI.MessBoxComponent", "[addActiveToolsProcessIdleHandler]");
            C7306ak dFz = C46650a.dFz();
            C413431 c413431 = new C413431();
            this.yQX = c413431;
            dFz.postDelayed(c413431, 3000);
        }
        C6513ls c6513ls = new C6513ls();
        c6513ls.cHA.talker = this.cgL.getTalkerUserName();
        C4879a.xxA.mo10055m(c6513ls);
        C9638aw.m17190ZK();
        if (C18628c.m29074XI()) {
            C37951y.m64163ab(this.cgL.getTalkerUserName(), 2);
        }
        AppMethodBeat.m2505o(31588);
    }

    /* renamed from: Nr */
    public final int mo64242Nr() {
        return this.yQV;
    }

    public final void dxA() {
        AppMethodBeat.m2504i(31589);
        C14991i.m23324Lt(6);
        C6550tn c6550tn = new C6550tn();
        c6550tn.cPI.type = 0;
        if (this.cgL != null) {
            c6550tn.cPI.cPL = this.cgL.getHeaderViewsCount();
            c6550tn.cPI.cPJ = this.cgL.getFirstVisiblePosition();
            c6550tn.cPI.cPK = this.cgL.getLastVisiblePosition();
        }
        C4879a.xxA.mo10055m(c6550tn);
        C4997aj.amA("keep_chatting_silent" + this.cgL.getTalkerUserName());
        C9638aw.getNotification().mo41582jO(this.cgL.getTalkerUserName());
        MMAppMgr.m7891BV();
        AppMethodBeat.m2505o(31589);
    }

    public final void dxB() {
        AppMethodBeat.m2504i(31590);
        C6550tn c6550tn = new C6550tn();
        c6550tn.cPI.type = 1;
        C4879a.xxA.mo10055m(c6550tn);
        C9638aw.getNotification().mo41582jO("");
        C4997aj.amB("keep_app_silent");
        C4997aj.amB("keep_chatting_silent" + this.cgL.getTalkerUserName());
        AppMethodBeat.m2505o(31590);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31591);
        C4990ab.m7416i("MicroMsg.ChattingUI.MessBoxComponent", "[onChattingExitAnimStart]");
        C6550tn c6550tn = new C6550tn();
        c6550tn.cPI.type = 3;
        C4879a.xxA.mo10055m(c6550tn);
        C46650a.dFz().removeCallbacks(this.yQX);
        C9638aw.m17190ZK();
        C7617ak aoZ = C18628c.m29083XR().aoZ(this.cgL.getTalkerUserName());
        if (aoZ != null) {
            C9638aw.m17190ZK();
            C18628c.m29083XR().mo15777a(this.cgL.getTalkerUserName(), 33554432, false, aoZ.field_attrflag);
        }
        AppMethodBeat.m2505o(31591);
    }

    public final boolean dEL() {
        return this.yQW;
    }

    /* JADX WARNING: Missing block: B:26:0x0115, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(com.tencent.p177mm.p190at.C45160g.m83084y(r7)) == false) goto L_0x0117;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo64243a(MenuItem menuItem, C5378c c5378c) {
        boolean z = false;
        AppMethodBeat.m2504i(31592);
        final C7620bi Ou = ((C15612h) this.cgL.mo74857aF(C15612h.class)).mo27798Ou(menuItem.getGroupId());
        if (Ou == null) {
            C4990ab.m7412e("MicroMsg.ChattingUI.MessBoxComponent", "context item select failed, null msg");
            AppMethodBeat.m2505o(31592);
            return;
        }
        ((C23731w) this.cgL.mo74857aF(C23731w.class)).mo39573j(menuItem);
        Intent intent;
        switch (menuItem.getItemId()) {
            case 100:
                C30379h.m48444a(this.cgL.yTx.getContext(), this.cgL.yTx.getContext().getString(C25738R.string.at7), "", this.cgL.yTx.getContext().getString(C25738R.string.b59), this.cgL.yTx.getContext().getString(C25738R.string.f9076or), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(31581);
                        if (Ou.bws()) {
                            C30076j.aiC(Ou.field_imgPath);
                        }
                        C1829bf.m3748fm(Ou.field_msgId);
                        if (Ou.bAA()) {
                            C45457b.fRa.mo73262c(Ou, C1191k.m2615k(Ou));
                        } else {
                            C45457b.fRa.mo73249E(Ou);
                        }
                        C4990ab.m7417i("MicroMsg.ChattingUI.MessBoxComponent", "delete msg, id:%d", Long.valueOf(Ou.field_msgId));
                        if (!C41342aa.this.cgL.getTalkerUserName().equals("medianote")) {
                            C9638aw.m17190ZK();
                            C18628c.m29077XL().mo7920c(new C32325e(Ou.field_talker, Ou.field_msgSvrId));
                        }
                        if (Ou.field_status == 1 && Ou.field_isSend == 1) {
                            C4990ab.m7410d("MicroMsg.ChattingUI.MessBoxComponent", "delete a sending msg, publish SendMsgFailEvent");
                            C6541qc c6541qc = new C6541qc();
                            c6541qc.cMs.csG = Ou;
                            C4879a.xxA.mo10055m(c6541qc);
                        }
                        AppMethodBeat.m2505o(31581);
                    }
                }, null, (int) C25738R.color.f11717ei);
                AppMethodBeat.m2505o(31592);
                return;
            case 114:
                if (Ou.isText()) {
                    C44288am.m80035m(C1829bf.m3745b(this.cgL.dFx(), Ou.field_content, Ou.field_isSend), this.cgL.yTx.getContext());
                } else if (Ou.drD()) {
                    C44288am.m80029b(Ou, this.cgL.yTx.getContext());
                } else if (Ou.drE()) {
                    C44288am.m80025a(Ou, this.cgL.yTx.getContext(), c5378c.mo11017b(this.cgL, Ou), this.cgL.dFx());
                } else if (Ou.bws()) {
                    C44288am.m80031c(Ou, this.cgL.yTx.getContext());
                } else if (Ou.bAC()) {
                    C44288am.m80036n(Ou.field_content, this.cgL.yTx.getContext());
                } else if (Ou.dtw()) {
                    C44288am.m80037o(Ou.field_content, this.cgL.yTx.getContext());
                }
                C4990ab.m7417i("MicroMsg.ChattingUI.MessBoxComponent", "type is %d", Integer.valueOf(Ou.getType()));
                AppMethodBeat.m2505o(31592);
                return;
            case 116:
                C43061a c43061a = new C43061a(((C36135d) this.cgL.mo74857aF(C36135d.class)).dDm(), this.cgL.dFw(), this.cgL.getTalkerUserName(), Ou, new C170164());
                if (this.yQY == null) {
                    this.yQY = new C23696ac();
                }
                this.yQY.mo39529a(this.cgL.yTx, this.cgL.yTx.getContext(), c43061a);
                AppMethodBeat.m2505o(31592);
                return;
            case 122:
                ((C15613i) this.cgL.mo74857aF(C15613i.class)).mo27827bc(Ou);
                AppMethodBeat.m2505o(31592);
                return;
            case 123:
                C4990ab.m7411d("MicroMsg.ChattingUI.MessBoxComponent", "[oneliang][longclick_menu_revoke] type:%d,item.getGroupId:%d", Integer.valueOf(Ou.getType()), Integer.valueOf(menuItem.getGroupId()));
                ((C30471y) this.cgL.mo74857aF(C30471y.class)).mo48870bj(Ou);
                AppMethodBeat.m2505o(31592);
                return;
            case GmsClientSupervisor.DEFAULT_BIND_FLAGS /*129*/:
                C8910b me = C8910b.m16064me(C1829bf.m3745b(this.cgL.dFx(), Ou.field_content, Ou.field_isSend));
                if (me == null || !(me.type == 6 || me.type == 2)) {
                    if (Ou.drE()) {
                        C32291o.ahl();
                        break;
                    }
                    z = true;
                } else {
                    boolean z2;
                    C30065b aiE = C14877am.aUq().aiE(me.csD);
                    if (aiE == null || !C5730e.m8628ct(aiE.field_fileFullPath)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    z = z2;
                }
                if (((C46641ai) this.cgL.mo74857aF(C46641ai.class)).mo72008e(Ou, z)) {
                    intent = new Intent(this.cgL.yTx.getContext(), ChattingSendDataToDeviceUI.class);
                    intent.putExtra("exdevice_open_scene_type", 1);
                    intent.putExtra("Retr_Msg_Id", Ou.field_msgId);
                    this.cgL.yTx.startActivity(intent);
                    AppMethodBeat.m2505o(31592);
                    return;
                }
                C30379h.m48440a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.b31), "", new C413443(), null);
                AppMethodBeat.m2505o(31592);
                return;
            case 150:
                intent = new Intent();
                intent.setClassName(this.cgL.yTx.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                intent.putExtra("app_msg_id", Ou.field_msgId);
                intent.putExtra("choose_way", true);
                this.cgL.yTx.startActivity(intent);
                break;
        }
        AppMethodBeat.m2505o(31592);
    }

    public final boolean arp(String str) {
        boolean z = true;
        AppMethodBeat.m2504i(31593);
        C4990ab.m7417i("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] username:%s isTContact:%s thread name:%s", str, Boolean.valueOf(C7616ad.aou(str)), Thread.currentThread().getName());
        if (!C1720g.m3534RN().mo5161QY()) {
            C4990ab.m7420w("MicroMsg.ChattingUI.MessBoxComponent", "account not init.");
            AppMethodBeat.m2505o(31593);
            return false;
        } else if (C7616ad.aou(str) || this.cgL == null) {
            C9638aw.m17190ZK();
            Cursor Rk = C18628c.m29080XO().mo15257Rk(str);
            if (Rk.getCount() <= 0) {
                z = false;
            }
            Rk.close();
            if (z) {
                C9638aw.m17190ZK();
                C18628c.m29083XR().apb(str);
                C9638aw.m17190ZK();
                C18628c.m29080XO().mo15255Ri(str);
            }
            AppMethodBeat.m2505o(31593);
            return z;
        } else {
            C36135d c36135d = (C36135d) this.cgL.mo74857aF(C36135d.class);
            if (c36135d == null) {
                C4990ab.m7412e("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] ");
                AppMethodBeat.m2505o(31593);
                return false;
            }
            boolean dDy = c36135d.dDy();
            AppMethodBeat.m2505o(31593);
            return dDy;
        }
    }

    public final void dxx() {
        AppMethodBeat.m2504i(31586);
        this.yQW = this.cgL.yTx.getBooleanExtra("key_is_temp_session", false).booleanValue();
        if (this.yQW) {
            C9638aw.m17182Rg().mo14541a(new C37947g(this.cgL.getTalkerUserName(), this.cgL.yTx.getIntExtra("key_temp_session_scene", 5), this.cgL.yTx.getStringExtra("key_temp_session_from")), 0);
        }
        if (!this.cgL.sRl.dsf() || C7486a.m12942jh(this.cgL.sRl.field_type)) {
            this.yQW = false;
        } else {
            C9638aw.m17190ZK();
            C7617ak aoZ = C18628c.m29083XR().aoZ(this.cgL.getTalkerUserName());
            boolean a;
            if (aoZ == null) {
                if (this.yQW) {
                    aoZ = new C7617ak(this.cgL.getTalkerUserName());
                    aoZ.mo16712jj(4194304);
                    aoZ.dsI();
                    C9638aw.m17190ZK();
                    C18628c.m29083XR().mo15807d(aoZ);
                }
            } else if (aoZ.mo16714jl(4194304)) {
                this.yQW = true;
            } else if (aoZ.field_conversationTime < C41747z.aff()) {
                C9638aw.m17190ZK();
                a = C18628c.m29083XR().mo15777a(this.cgL.getTalkerUserName(), 4194304, true, aoZ.field_attrflag);
                C4990ab.m7417i("MicroMsg.ChattingUI.MessBoxComponent", "It is a old version temp session, Set attr flag(talker : %s), %s", this.cgL.getTalkerUserName(), Boolean.valueOf(a));
                this.yQW = true;
            } else if (this.yQW) {
                C9638aw.m17190ZK();
                a = C18628c.m29083XR().mo15777a(this.cgL.getTalkerUserName(), 4194304, true, aoZ.field_attrflag);
                C4990ab.m7417i("MicroMsg.ChattingUI.MessBoxComponent", "It is a temp session, Set attr flag(talker : %s), %s", this.cgL.getTalkerUserName(), Boolean.valueOf(a));
            }
        }
        C4990ab.m7411d("MicroMsg.ChattingUI.MessBoxComponent", "is temp session : %s.", Boolean.valueOf(this.yQW));
        AppMethodBeat.m2505o(31586);
    }
}
