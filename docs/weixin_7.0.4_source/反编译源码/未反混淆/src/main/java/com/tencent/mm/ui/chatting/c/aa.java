package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.view.MenuItem;
import android.widget.AbsListView;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.k;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.o;
import com.tencent.mm.az.e;
import com.tencent.mm.bf.d;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.tn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.ai;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.v;
import com.tencent.mm.ui.chatting.c.b.w;
import java.util.LinkedList;
import java.util.List;

@a(dFp = v.class)
@Deprecated
public class aa extends a implements v {
    private List<bi> yQU;
    private int yQV;
    private boolean yQW = false;
    private Runnable yQX = null;
    private ac yQY = null;

    public final void onActivityResult(int i, int i2, Intent intent) {
        Cursor cursor = null;
        AppMethodBeat.i(31583);
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.ChattingUI.MessBoxComponent";
        String str2 = "onActivityResult requestCode:%d, data is null:%b  rawUserName:%s ";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(intent == null);
        objArr[2] = this.cgL.getTalkerUserName();
        ab.i(str, str2, objArr);
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
                    AppMethodBeat.o(31583);
                    return;
                }
                break;
            case 213:
                if (intent != null && intent.getBooleanExtra("_delete_ok_", false)) {
                    this.cgL.yTx.dBP();
                    AppMethodBeat.o(31583);
                    return;
                }
            default:
                ab.e("MicroMsg.ChattingUI.MessBoxComponent", "onActivityResult: not found this requestCode");
                break;
        }
        AppMethodBeat.o(31583);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.i(31584);
        super.onScrollStateChanged(absListView, i);
        if (i == 0) {
            tn tnVar = new tn();
            tnVar.cPI.type = 5;
            tnVar.cPI.cPJ = this.cgL.getFirstVisiblePosition();
            tnVar.cPI.cPK = this.cgL.getLastVisiblePosition();
            tnVar.cPI.cPL = this.cgL.getHeaderViewsCount();
            com.tencent.mm.sdk.b.a.xxA.m(tnVar);
        }
        AppMethodBeat.o(31584);
    }

    public final void dDh() {
        AppMethodBeat.i(31585);
        super.dDh();
        aw.ZK();
        if (c.XI()) {
            y.ab(this.cgL.getTalkerUserName(), 5);
        }
        AppMethodBeat.o(31585);
    }

    public final List<bi> dEK() {
        return this.yQU;
    }

    public final void dxy() {
        AppMethodBeat.i(31587);
        b IP = b.IP();
        String talkerUserName = this.cgL.getTalkerUserName();
        if (!bo.isNullOrNil(talkerUserName)) {
            IP.eei.remove(talkerUserName);
        }
        if (this.cgL.dFx()) {
            d.chatType = 1;
        } else {
            d.chatType = 0;
        }
        if (this.yQU != null) {
            this.yQU.clear();
        }
        aw.ZK();
        ak aoZ = c.XR().aoZ(this.cgL.getTalkerUserName());
        if (((com.tencent.mm.ui.chatting.c.b.d) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDm()) {
            this.yQU = ((com.tencent.mm.ui.chatting.c.b.d) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDr();
        } else if (aoZ != null && aoZ.field_unReadCount > 0) {
            int i;
            if (aoZ.field_unReadCount > 100) {
                i = 100;
            } else {
                i = aoZ.field_unReadCount;
            }
            aw.ZK();
            this.yQU = c.XO().ct(this.cgL.getTalkerUserName(), i);
        }
        if (this.yQU == null) {
            this.yQU = new LinkedList();
        }
        this.yQV = this.yQU.size();
        AppMethodBeat.o(31587);
    }

    public final void dxz() {
        AppMethodBeat.i(31588);
        tn tnVar = new tn();
        tnVar.cPI.type = 4;
        com.tencent.mm.sdk.b.a.xxA.m(tnVar);
        if (this.cgL != null) {
            ab.i("MicroMsg.ChattingUI.MessBoxComponent", "[addActiveToolsProcessIdleHandler]");
            com.tencent.mm.sdk.platformtools.ak dFz = com.tencent.mm.ui.chatting.d.a.dFz();
            AnonymousClass1 anonymousClass1 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(31580);
                    if (aa.this.cgL == null) {
                        AppMethodBeat.o(31580);
                        return;
                    }
                    ab.i("MicroMsg.ChattingUI.MessBoxComponent", "now try to activity the tools process");
                    com.tencent.mm.cj.c.aNX();
                    AppMethodBeat.o(31580);
                }
            };
            this.yQX = anonymousClass1;
            dFz.postDelayed(anonymousClass1, 3000);
        }
        ls lsVar = new ls();
        lsVar.cHA.talker = this.cgL.getTalkerUserName();
        com.tencent.mm.sdk.b.a.xxA.m(lsVar);
        aw.ZK();
        if (c.XI()) {
            y.ab(this.cgL.getTalkerUserName(), 2);
        }
        AppMethodBeat.o(31588);
    }

    public final int Nr() {
        return this.yQV;
    }

    public final void dxA() {
        AppMethodBeat.i(31589);
        i.Lt(6);
        tn tnVar = new tn();
        tnVar.cPI.type = 0;
        if (this.cgL != null) {
            tnVar.cPI.cPL = this.cgL.getHeaderViewsCount();
            tnVar.cPI.cPJ = this.cgL.getFirstVisiblePosition();
            tnVar.cPI.cPK = this.cgL.getLastVisiblePosition();
        }
        com.tencent.mm.sdk.b.a.xxA.m(tnVar);
        aj.amA("keep_chatting_silent" + this.cgL.getTalkerUserName());
        aw.getNotification().jO(this.cgL.getTalkerUserName());
        MMAppMgr.BV();
        AppMethodBeat.o(31589);
    }

    public final void dxB() {
        AppMethodBeat.i(31590);
        tn tnVar = new tn();
        tnVar.cPI.type = 1;
        com.tencent.mm.sdk.b.a.xxA.m(tnVar);
        aw.getNotification().jO("");
        aj.amB("keep_app_silent");
        aj.amB("keep_chatting_silent" + this.cgL.getTalkerUserName());
        AppMethodBeat.o(31590);
    }

    public final void dxC() {
        AppMethodBeat.i(31591);
        ab.i("MicroMsg.ChattingUI.MessBoxComponent", "[onChattingExitAnimStart]");
        tn tnVar = new tn();
        tnVar.cPI.type = 3;
        com.tencent.mm.sdk.b.a.xxA.m(tnVar);
        com.tencent.mm.ui.chatting.d.a.dFz().removeCallbacks(this.yQX);
        aw.ZK();
        ak aoZ = c.XR().aoZ(this.cgL.getTalkerUserName());
        if (aoZ != null) {
            aw.ZK();
            c.XR().a(this.cgL.getTalkerUserName(), 33554432, false, aoZ.field_attrflag);
        }
        AppMethodBeat.o(31591);
    }

    public final boolean dEL() {
        return this.yQW;
    }

    /* JADX WARNING: Missing block: B:26:0x0115, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(com.tencent.mm.at.g.y(r7)) == false) goto L_0x0117;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(MenuItem menuItem, com.tencent.mm.ui.chatting.viewitems.c cVar) {
        boolean z = false;
        AppMethodBeat.i(31592);
        final bi Ou = ((h) this.cgL.aF(h.class)).Ou(menuItem.getGroupId());
        if (Ou == null) {
            ab.e("MicroMsg.ChattingUI.MessBoxComponent", "context item select failed, null msg");
            AppMethodBeat.o(31592);
            return;
        }
        ((w) this.cgL.aF(w.class)).j(menuItem);
        Intent intent;
        switch (menuItem.getItemId()) {
            case 100:
                com.tencent.mm.ui.base.h.a(this.cgL.yTx.getContext(), this.cgL.yTx.getContext().getString(R.string.at7), "", this.cgL.yTx.getContext().getString(R.string.b59), this.cgL.yTx.getContext().getString(R.string.or), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(31581);
                        if (Ou.bws()) {
                            j.aiC(Ou.field_imgPath);
                        }
                        bf.fm(Ou.field_msgId);
                        if (Ou.bAA()) {
                            com.tencent.mm.modelstat.b.fRa.c(Ou, k.k(Ou));
                        } else {
                            com.tencent.mm.modelstat.b.fRa.E(Ou);
                        }
                        ab.i("MicroMsg.ChattingUI.MessBoxComponent", "delete msg, id:%d", Long.valueOf(Ou.field_msgId));
                        if (!aa.this.cgL.getTalkerUserName().equals("medianote")) {
                            aw.ZK();
                            c.XL().c(new e(Ou.field_talker, Ou.field_msgSvrId));
                        }
                        if (Ou.field_status == 1 && Ou.field_isSend == 1) {
                            ab.d("MicroMsg.ChattingUI.MessBoxComponent", "delete a sending msg, publish SendMsgFailEvent");
                            qc qcVar = new qc();
                            qcVar.cMs.csG = Ou;
                            com.tencent.mm.sdk.b.a.xxA.m(qcVar);
                        }
                        AppMethodBeat.o(31581);
                    }
                }, null, (int) R.color.ei);
                AppMethodBeat.o(31592);
                return;
            case 114:
                if (Ou.isText()) {
                    am.m(bf.b(this.cgL.dFx(), Ou.field_content, Ou.field_isSend), this.cgL.yTx.getContext());
                } else if (Ou.drD()) {
                    am.b(Ou, this.cgL.yTx.getContext());
                } else if (Ou.drE()) {
                    am.a(Ou, this.cgL.yTx.getContext(), cVar.b(this.cgL, Ou), this.cgL.dFx());
                } else if (Ou.bws()) {
                    am.c(Ou, this.cgL.yTx.getContext());
                } else if (Ou.bAC()) {
                    am.n(Ou.field_content, this.cgL.yTx.getContext());
                } else if (Ou.dtw()) {
                    am.o(Ou.field_content, this.cgL.yTx.getContext());
                }
                ab.i("MicroMsg.ChattingUI.MessBoxComponent", "type is %d", Integer.valueOf(Ou.getType()));
                AppMethodBeat.o(31592);
                return;
            case 116:
                com.tencent.mm.plugin.fav.b.c.a aVar = new com.tencent.mm.plugin.fav.b.c.a(((com.tencent.mm.ui.chatting.c.b.d) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDm(), this.cgL.dFw(), this.cgL.getTalkerUserName(), Ou, new com.tencent.mm.plugin.fav.b.c.a.a() {
                    public final void bvs() {
                        AppMethodBeat.i(31582);
                        aa.this.cgL.aqX();
                        AppMethodBeat.o(31582);
                    }
                });
                if (this.yQY == null) {
                    this.yQY = new ac();
                }
                this.yQY.a(this.cgL.yTx, this.cgL.yTx.getContext(), aVar);
                AppMethodBeat.o(31592);
                return;
            case 122:
                ((com.tencent.mm.ui.chatting.c.b.i) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.i.class)).bc(Ou);
                AppMethodBeat.o(31592);
                return;
            case 123:
                ab.d("MicroMsg.ChattingUI.MessBoxComponent", "[oneliang][longclick_menu_revoke] type:%d,item.getGroupId:%d", Integer.valueOf(Ou.getType()), Integer.valueOf(menuItem.getGroupId()));
                ((com.tencent.mm.ui.chatting.c.b.y) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.y.class)).bj(Ou);
                AppMethodBeat.o(31592);
                return;
            case GmsClientSupervisor.DEFAULT_BIND_FLAGS /*129*/:
                com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(bf.b(this.cgL.dFx(), Ou.field_content, Ou.field_isSend));
                if (me == null || !(me.type == 6 || me.type == 2)) {
                    if (Ou.drE()) {
                        o.ahl();
                        break;
                    }
                    z = true;
                } else {
                    boolean z2;
                    com.tencent.mm.pluginsdk.model.app.b aiE = com.tencent.mm.pluginsdk.model.app.am.aUq().aiE(me.csD);
                    if (aiE == null || !com.tencent.mm.vfs.e.ct(aiE.field_fileFullPath)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    z = z2;
                }
                if (((ai) this.cgL.aF(ai.class)).e(Ou, z)) {
                    intent = new Intent(this.cgL.yTx.getContext(), ChattingSendDataToDeviceUI.class);
                    intent.putExtra("exdevice_open_scene_type", 1);
                    intent.putExtra("Retr_Msg_Id", Ou.field_msgId);
                    this.cgL.yTx.startActivity(intent);
                    AppMethodBeat.o(31592);
                    return;
                }
                com.tencent.mm.ui.base.h.a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.b31), "", new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }, null);
                AppMethodBeat.o(31592);
                return;
            case 150:
                intent = new Intent();
                intent.setClassName(this.cgL.yTx.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                intent.putExtra("app_msg_id", Ou.field_msgId);
                intent.putExtra("choose_way", true);
                this.cgL.yTx.startActivity(intent);
                break;
        }
        AppMethodBeat.o(31592);
    }

    public final boolean arp(String str) {
        boolean z = true;
        AppMethodBeat.i(31593);
        ab.i("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] username:%s isTContact:%s thread name:%s", str, Boolean.valueOf(ad.aou(str)), Thread.currentThread().getName());
        if (!g.RN().QY()) {
            ab.w("MicroMsg.ChattingUI.MessBoxComponent", "account not init.");
            AppMethodBeat.o(31593);
            return false;
        } else if (ad.aou(str) || this.cgL == null) {
            aw.ZK();
            Cursor Rk = c.XO().Rk(str);
            if (Rk.getCount() <= 0) {
                z = false;
            }
            Rk.close();
            if (z) {
                aw.ZK();
                c.XR().apb(str);
                aw.ZK();
                c.XO().Ri(str);
            }
            AppMethodBeat.o(31593);
            return z;
        } else {
            com.tencent.mm.ui.chatting.c.b.d dVar = (com.tencent.mm.ui.chatting.c.b.d) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class);
            if (dVar == null) {
                ab.e("MicroMsg.ChattingUI.MessBoxComponent", "[writeOpLogAndMarkRead] ");
                AppMethodBeat.o(31593);
                return false;
            }
            boolean dDy = dVar.dDy();
            AppMethodBeat.o(31593);
            return dDy;
        }
    }

    public final void dxx() {
        AppMethodBeat.i(31586);
        this.yQW = this.cgL.yTx.getBooleanExtra("key_is_temp_session", false).booleanValue();
        if (this.yQW) {
            aw.Rg().a(new com.tencent.mm.modelsimple.g(this.cgL.getTalkerUserName(), this.cgL.yTx.getIntExtra("key_temp_session_scene", 5), this.cgL.yTx.getStringExtra("key_temp_session_from")), 0);
        }
        if (!this.cgL.sRl.dsf() || com.tencent.mm.n.a.jh(this.cgL.sRl.field_type)) {
            this.yQW = false;
        } else {
            aw.ZK();
            ak aoZ = c.XR().aoZ(this.cgL.getTalkerUserName());
            boolean a;
            if (aoZ == null) {
                if (this.yQW) {
                    aoZ = new ak(this.cgL.getTalkerUserName());
                    aoZ.jj(4194304);
                    aoZ.dsI();
                    aw.ZK();
                    c.XR().d(aoZ);
                }
            } else if (aoZ.jl(4194304)) {
                this.yQW = true;
            } else if (aoZ.field_conversationTime < z.aff()) {
                aw.ZK();
                a = c.XR().a(this.cgL.getTalkerUserName(), 4194304, true, aoZ.field_attrflag);
                ab.i("MicroMsg.ChattingUI.MessBoxComponent", "It is a old version temp session, Set attr flag(talker : %s), %s", this.cgL.getTalkerUserName(), Boolean.valueOf(a));
                this.yQW = true;
            } else if (this.yQW) {
                aw.ZK();
                a = c.XR().a(this.cgL.getTalkerUserName(), 4194304, true, aoZ.field_attrflag);
                ab.i("MicroMsg.ChattingUI.MessBoxComponent", "It is a temp session, Set attr flag(talker : %s), %s", this.cgL.getTalkerUserName(), Boolean.valueOf(a));
            }
        }
        ab.d("MicroMsg.ChattingUI.MessBoxComponent", "is temp session : %s.", Boolean.valueOf(this.yQW));
        AppMethodBeat.o(31586);
    }
}
