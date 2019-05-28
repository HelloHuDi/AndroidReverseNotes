package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.chatroom.ui.preference.RoomManagerPreference;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.openim.d.q;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bbp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ManageChatroomUI extends MMPreference {
    private f ehK;
    private SharedPreferences ehZ = null;
    CheckBoxPreference ejB;
    RoomManagerPreference ejC;
    private String ejD;
    private String ejE;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(104112);
        super.onCreate(bundle);
        ab.i("MicroMsg.ManageChatroomUI", "[onCreate]");
        this.ejD = getIntent().getStringExtra("RoomInfo_Id");
        this.ejE = getIntent().getStringExtra("room_owner_name");
        AppMethodBeat.o(104112);
    }

    public void onResume() {
        boolean z = true;
        AppMethodBeat.i(104113);
        u oa = ((c) g.K(c.class)).XV().oa(this.ejD);
        if (oa != null && this.ehZ == null) {
            this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
            this.ehZ.edit().putBoolean("allow_by_identity", oa.drV() == 2).commit();
        }
        super.onResume();
        this.ehK = this.yCw;
        if (this.ehK != null) {
            setMMTitle((int) R.string.cyp);
            this.ejB = (CheckBoxPreference) this.ehK.aqO("allow_by_identity");
            this.ejC = (RoomManagerPreference) this.ehK.aqO("room_manager");
            this.ehK.ce("room_manager", !((c) g.K(c.class)).HH(this.ejD));
            this.ehK.ce("select_enable_qrcode", true);
            this.ehK.ce("select_into_room_type", true);
            if (!r.Yz().equals(this.ejE)) {
                this.ehK.ce("room_transfer_room_ower", true);
            }
            u oa2 = ((c) g.K(c.class)).XV().oa(this.ejD);
            if (oa2 != null) {
                CheckBoxPreference checkBoxPreference;
                if (t.mP(this.ejD)) {
                    String str = "MicroMsg.ManageChatroomUI";
                    String str2 = "isChecked = %s";
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(oa2.drV() == 1);
                    ab.i(str, str2, objArr);
                    checkBoxPreference = this.ejB;
                    if (oa2.drV() != 1) {
                        z = false;
                    }
                    checkBoxPreference.uOT = z;
                } else {
                    checkBoxPreference = this.ejB;
                    if (oa2.drV() != 2) {
                        z = false;
                    }
                    checkBoxPreference.uOT = z;
                }
            }
            this.ejB.yDf = false;
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(104111);
                    ManageChatroomUI.this.finish();
                    AppMethodBeat.o(104111);
                    return true;
                }
            });
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(104113);
    }

    public void onDestroy() {
        AppMethodBeat.i(104114);
        super.onDestroy();
        AppMethodBeat.o(104114);
    }

    public final int JC() {
        return R.xml.b2;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(104116);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent == null) {
                    AppMethodBeat.o(104116);
                    return;
                }
                ab.i("MicroMsg.ManageChatroomUI", "[openVerify] roomId:%s, type:%s", this.ejD, Integer.valueOf(intent.getIntExtra("into_room_type", -1)));
                bbp bbp = new bbp();
                bbp.vEf = bo.nullAsNil(this.ejD);
                bbp.pXD = r0;
                ((j) g.K(j.class)).XL().c(new a(66, bbp));
                AppMethodBeat.o(104116);
                return;
            case 2:
                ab.i("MicroMsg.ManageChatroomUI", "[onActivityResult] requestCode:%s", Integer.valueOf(2));
                break;
        }
        AppMethodBeat.o(104116);
    }

    public final boolean a(f fVar, Preference preference) {
        int i = 2;
        int i2 = 1;
        AppMethodBeat.i(104115);
        String str = preference.mKey;
        ab.d("MicroMsg.ManageChatroomUI", "[onPreferenceTreeClick] key:%s", str);
        if (str.equals("room_transfer_room_ower")) {
            ab.i("MicroMsg.ManageChatroomUI", "[selectNewRoomOwner] roomId:%s", this.ejD);
            str = bo.c(n.my(this.ejD), ",");
            Intent intent = new Intent();
            intent.putExtra("Block_list", r.Yz());
            intent.putExtra("Chatroom_member_list", str);
            intent.putExtra("from_scene", 2);
            intent.putExtra("RoomInfo_Id", this.ejD);
            intent.putExtra("is_show_owner", false);
            intent.putExtra("title", getString(R.string.duq));
            intent.setClass(this, TransferRoomOwnerUI.class);
            startActivity(intent);
        } else if (str.equals("allow_by_identity")) {
            boolean isChecked = this.ejB.isChecked();
            h.pYm.a(219, 22, 1, true);
            ab.i("MicroMsg.ManageChatroomUI", "[selectAllowByIdentity] roomId:%s isOpen:%s", this.ejD, Boolean.valueOf(isChecked));
            if (t.mP(this.ejD)) {
                i XL = ((j) g.K(j.class)).XL();
                String nullAsNil = bo.nullAsNil(this.ejD);
                if (!isChecked) {
                    i2 = 0;
                }
                XL.c(new q(nullAsNil, i2));
            } else {
                bbp bbp = new bbp();
                bbp.vEf = bo.nullAsNil(this.ejD);
                if (!isChecked) {
                    i = 0;
                }
                bbp.pXD = i;
                ((j) g.K(j.class)).XL().c(new a(66, bbp));
            }
            this.ejB.yDf = false;
        } else if (str.equals("room_manager")) {
            ab.i("MicroMsg.ManageChatroomUI", "[selectRoomManager] roomId:%s", this.ejD);
            u oa = ((c) g.K(c.class)).XV().oa(this.ejD);
            Intent intent2 = new Intent();
            if (oa.aoo(r.Yz())) {
                intent2.setClass(this, SeeRoomOwnerManagerUI.class);
            } else {
                intent2.setClass(this, SeeRoomManagerUI.class);
            }
            intent2.putExtra("RoomInfo_Id", this.ejD);
            startActivity(intent2);
        }
        AppMethodBeat.o(104115);
        return false;
    }
}
