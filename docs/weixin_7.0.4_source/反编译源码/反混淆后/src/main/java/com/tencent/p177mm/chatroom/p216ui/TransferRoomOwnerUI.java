package com.tencent.p177mm.chatroom.p216ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.chatroom.p216ui.SelectMemberUI.C7658a;
import com.tencent.p177mm.chatroom.p710c.C32442p;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.openim.p716b.C45465p;
import com.tencent.p177mm.openim.room.p266a.C42249a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7575bv;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.chatroom.ui.TransferRoomOwnerUI */
public class TransferRoomOwnerUI extends SelectMemberUI implements C1202f {
    private C44275p ejZ;
    private boolean eog;

    /* renamed from: com.tencent.mm.chatroom.ui.TransferRoomOwnerUI$2 */
    class C419292 implements OnClickListener {
        C419292() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(104463);
        super.onCreate(bundle);
        if (C1855t.m3903mP(this.ejD)) {
            C1720g.m3535RO().eJo.mo14539a(811, (C1202f) this);
            AppMethodBeat.m2505o(104463);
            return;
        }
        C1720g.m3535RO().eJo.mo14539a(990, (C1202f) this);
        AppMethodBeat.m2505o(104463);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Kq */
    public final void mo17459Kq() {
        AppMethodBeat.m2504i(104464);
        super.mo17459Kq();
        this.eog = getIntent().getBooleanExtra("quit_room", false);
        AppMethodBeat.m2505o(104464);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(104465);
        super.onDestroy();
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
        }
        if (C1855t.m3903mP(this.ejD)) {
            C1720g.m3535RO().eJo.mo14546b(811, (C1202f) this);
            AppMethodBeat.m2505o(104465);
            return;
        }
        C1720g.m3535RO().eJo.mo14546b(990, (C1202f) this);
        AppMethodBeat.m2505o(104465);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(104466);
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
        }
        if (c1207m.getType() == 990 || c1207m.getType() == 811) {
            if (i == 0 && i2 == 0) {
                if (C1855t.m3903mP(this.ejD)) {
                    C4990ab.m7417i("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer successfully],owner_username:%s", ((C45465p) c1207m).username);
                } else {
                    C4990ab.m7417i("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer successfully],owner_username:%s", ((C32442p) c1207m).username);
                }
                C23639t.makeText(this, C25738R.string.duz, 1).show();
                Intent intent = new Intent(this.mController.ylL, ChatroomInfoUI.class);
                intent.putExtra("RoomInfo_Id", this.ejD);
                intent.putExtra("Chat_User", this.ejD);
                intent.putExtra("Is_Chatroom", true);
                intent.setFlags(67108864);
                this.mController.ylL.startActivity(intent);
                finish();
                AppMethodBeat.m2505o(104466);
                return;
            }
            C23639t.makeText(this, C25738R.string.duy, 1).show();
            C4990ab.m7421w("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer failed: %d %d %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        }
        AppMethodBeat.m2505o(104466);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo17467a(View view, int i, long j) {
        AppMethodBeat.m2504i(104467);
        super.mo17467a(view, i, j);
        C7658a iH = this.emB.mo17474iH(i);
        if (iH == null || iH.ehM == null) {
            C4990ab.m7412e("MicroMsg.TransferRoomOwnerUI", "null == item || null == item.contact");
            AppMethodBeat.m2505o(104467);
            return;
        }
        String a;
        String Oi;
        C7616ad c7616ad = iH.ehM;
        final String str = c7616ad.field_username;
        if (C5046bo.isNullOrNil(c7616ad.field_conRemark)) {
            a = SelectMemberUI.m13676a(this.eih, c7616ad.field_username);
        } else {
            a = c7616ad.field_conRemark;
        }
        if (C5046bo.isNullOrNil(a)) {
            Oi = c7616ad.mo16706Oi();
        } else {
            Oi = a;
        }
        if (!C7486a.m12942jh(c7616ad.field_type)) {
            C7575bv RB = ((C6982j) C1720g.m3528K(C6982j.class)).mo15370XN().mo15364RB(c7616ad.field_username);
            if (!(RB == null || C5046bo.isNullOrNil(RB.field_conRemark))) {
                Oi = RB.field_conRemark;
            }
        }
        a = C42249a.m74595A(c7616ad);
        if (!TextUtils.isEmpty(a)) {
            Oi = Oi + a;
        }
        if (this.eog) {
            a = getString(C25738R.string.du3, new Object[]{Oi});
        } else {
            a = getString(C25738R.string.dv1, new Object[]{Oi});
        }
        C30379h.m48440a((Context) this, a, "", new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                C1207m c45465p;
                AppMethodBeat.m2504i(104462);
                if (C1855t.m3903mP(TransferRoomOwnerUI.this.ejD)) {
                    c45465p = new C45465p(TransferRoomOwnerUI.this.ejD, str);
                } else {
                    c45465p = new C32442p(TransferRoomOwnerUI.this.ejD, str);
                }
                C1720g.m3535RO().eJo.mo14541a(c45465p, 0);
                TransferRoomOwnerUI transferRoomOwnerUI = TransferRoomOwnerUI.this;
                Context context = TransferRoomOwnerUI.this;
                TransferRoomOwnerUI.this.getString(C25738R.string.f9238tz);
                transferRoomOwnerUI.ejZ = C30379h.m48458b(context, TransferRoomOwnerUI.this.getString(C25738R.string.dv2), false, null);
                AppMethodBeat.m2505o(104462);
            }
        }, new C419292());
        AppMethodBeat.m2505o(104467);
    }
}
