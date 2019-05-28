package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.chatroom.ui.SelectMemberUI.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public class TransferRoomOwnerUI extends SelectMemberUI implements f {
    private p ejZ;
    private boolean eog;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(104463);
        super.onCreate(bundle);
        if (t.mP(this.ejD)) {
            g.RO().eJo.a(811, (f) this);
            AppMethodBeat.o(104463);
            return;
        }
        g.RO().eJo.a(990, (f) this);
        AppMethodBeat.o(104463);
    }

    /* Access modifiers changed, original: protected|final */
    public final void Kq() {
        AppMethodBeat.i(104464);
        super.Kq();
        this.eog = getIntent().getBooleanExtra("quit_room", false);
        AppMethodBeat.o(104464);
    }

    public void onDestroy() {
        AppMethodBeat.i(104465);
        super.onDestroy();
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
        }
        if (t.mP(this.ejD)) {
            g.RO().eJo.b(811, (f) this);
            AppMethodBeat.o(104465);
            return;
        }
        g.RO().eJo.b(990, (f) this);
        AppMethodBeat.o(104465);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(104466);
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
        }
        if (mVar.getType() == 990 || mVar.getType() == 811) {
            if (i == 0 && i2 == 0) {
                if (t.mP(this.ejD)) {
                    ab.i("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer successfully],owner_username:%s", ((com.tencent.mm.openim.b.p) mVar).username);
                } else {
                    ab.i("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer successfully],owner_username:%s", ((com.tencent.mm.chatroom.c.p) mVar).username);
                }
                com.tencent.mm.ui.base.t.makeText(this, R.string.duz, 1).show();
                Intent intent = new Intent(this.mController.ylL, ChatroomInfoUI.class);
                intent.putExtra("RoomInfo_Id", this.ejD);
                intent.putExtra("Chat_User", this.ejD);
                intent.putExtra("Is_Chatroom", true);
                intent.setFlags(67108864);
                this.mController.ylL.startActivity(intent);
                finish();
                AppMethodBeat.o(104466);
                return;
            }
            com.tencent.mm.ui.base.t.makeText(this, R.string.duy, 1).show();
            ab.w("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer failed: %d %d %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        }
        AppMethodBeat.o(104466);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(View view, int i, long j) {
        AppMethodBeat.i(104467);
        super.a(view, i, j);
        a iH = this.emB.iH(i);
        if (iH == null || iH.ehM == null) {
            ab.e("MicroMsg.TransferRoomOwnerUI", "null == item || null == item.contact");
            AppMethodBeat.o(104467);
            return;
        }
        String a;
        String Oi;
        ad adVar = iH.ehM;
        final String str = adVar.field_username;
        if (bo.isNullOrNil(adVar.field_conRemark)) {
            a = SelectMemberUI.a(this.eih, adVar.field_username);
        } else {
            a = adVar.field_conRemark;
        }
        if (bo.isNullOrNil(a)) {
            Oi = adVar.Oi();
        } else {
            Oi = a;
        }
        if (!com.tencent.mm.n.a.jh(adVar.field_type)) {
            bv RB = ((j) g.K(j.class)).XN().RB(adVar.field_username);
            if (!(RB == null || bo.isNullOrNil(RB.field_conRemark))) {
                Oi = RB.field_conRemark;
            }
        }
        a = com.tencent.mm.openim.room.a.a.A(adVar);
        if (!TextUtils.isEmpty(a)) {
            Oi = Oi + a;
        }
        if (this.eog) {
            a = getString(R.string.du3, new Object[]{Oi});
        } else {
            a = getString(R.string.dv1, new Object[]{Oi});
        }
        h.a((Context) this, a, "", new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                m pVar;
                AppMethodBeat.i(104462);
                if (t.mP(TransferRoomOwnerUI.this.ejD)) {
                    pVar = new com.tencent.mm.openim.b.p(TransferRoomOwnerUI.this.ejD, str);
                } else {
                    pVar = new com.tencent.mm.chatroom.c.p(TransferRoomOwnerUI.this.ejD, str);
                }
                g.RO().eJo.a(pVar, 0);
                TransferRoomOwnerUI transferRoomOwnerUI = TransferRoomOwnerUI.this;
                Context context = TransferRoomOwnerUI.this;
                TransferRoomOwnerUI.this.getString(R.string.tz);
                transferRoomOwnerUI.ejZ = h.b(context, TransferRoomOwnerUI.this.getString(R.string.dv2), false, null);
                AppMethodBeat.o(104462);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(104467);
    }
}
