package com.tencent.p177mm.chatroom.p216ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.chatroom.p216ui.preference.RoomManagerPreference;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.openim.p876d.C18740q;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3462i;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.bbp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7577u;

/* renamed from: com.tencent.mm.chatroom.ui.ManageChatroomUI */
public class ManageChatroomUI extends MMPreference {
    private C15541f ehK;
    private SharedPreferences ehZ = null;
    CheckBoxPreference ejB;
    RoomManagerPreference ejC;
    private String ejD;
    private String ejE;

    /* renamed from: com.tencent.mm.chatroom.ui.ManageChatroomUI$1 */
    class C181381 implements OnMenuItemClickListener {
        C181381() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(104111);
            ManageChatroomUI.this.finish();
            AppMethodBeat.m2505o(104111);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(104112);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.ManageChatroomUI", "[onCreate]");
        this.ejD = getIntent().getStringExtra("RoomInfo_Id");
        this.ejE = getIntent().getStringExtra("room_owner_name");
        AppMethodBeat.m2505o(104112);
    }

    public void onResume() {
        boolean z = true;
        AppMethodBeat.m2504i(104113);
        C7577u oa = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(this.ejD);
        if (oa != null && this.ehZ == null) {
            this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
            this.ehZ.edit().putBoolean("allow_by_identity", oa.drV() == 2).commit();
        }
        super.onResume();
        this.ehK = this.yCw;
        if (this.ehK != null) {
            setMMTitle((int) C25738R.string.cyp);
            this.ejB = (CheckBoxPreference) this.ehK.aqO("allow_by_identity");
            this.ejC = (RoomManagerPreference) this.ehK.aqO("room_manager");
            this.ehK.mo27715ce("room_manager", !((C6822c) C1720g.m3528K(C6822c.class)).mo15089HH(this.ejD));
            this.ehK.mo27715ce("select_enable_qrcode", true);
            this.ehK.mo27715ce("select_into_room_type", true);
            if (!C1853r.m3846Yz().equals(this.ejE)) {
                this.ehK.mo27715ce("room_transfer_room_ower", true);
            }
            C7577u oa2 = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(this.ejD);
            if (oa2 != null) {
                CheckBoxPreference checkBoxPreference;
                if (C1855t.m3903mP(this.ejD)) {
                    String str = "MicroMsg.ManageChatroomUI";
                    String str2 = "isChecked = %s";
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(oa2.drV() == 1);
                    C4990ab.m7417i(str, str2, objArr);
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
            setBackBtn(new C181381());
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(104113);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(104114);
        super.onDestroy();
        AppMethodBeat.m2505o(104114);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8517b2;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(104116);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent == null) {
                    AppMethodBeat.m2505o(104116);
                    return;
                }
                C4990ab.m7417i("MicroMsg.ManageChatroomUI", "[openVerify] roomId:%s, type:%s", this.ejD, Integer.valueOf(intent.getIntExtra("into_room_type", -1)));
                bbp bbp = new bbp();
                bbp.vEf = C5046bo.nullAsNil(this.ejD);
                bbp.pXD = r0;
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(66, bbp));
                AppMethodBeat.m2505o(104116);
                return;
            case 2:
                C4990ab.m7417i("MicroMsg.ManageChatroomUI", "[onActivityResult] requestCode:%s", Integer.valueOf(2));
                break;
        }
        AppMethodBeat.m2505o(104116);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        int i = 2;
        int i2 = 1;
        AppMethodBeat.m2504i(104115);
        String str = preference.mKey;
        C4990ab.m7411d("MicroMsg.ManageChatroomUI", "[onPreferenceTreeClick] key:%s", str);
        if (str.equals("room_transfer_room_ower")) {
            C4990ab.m7417i("MicroMsg.ManageChatroomUI", "[selectNewRoomOwner] roomId:%s", this.ejD);
            str = C5046bo.m7536c(C37921n.m64074my(this.ejD), ",");
            Intent intent = new Intent();
            intent.putExtra("Block_list", C1853r.m3846Yz());
            intent.putExtra("Chatroom_member_list", str);
            intent.putExtra("from_scene", 2);
            intent.putExtra("RoomInfo_Id", this.ejD);
            intent.putExtra("is_show_owner", false);
            intent.putExtra("title", getString(C25738R.string.duq));
            intent.setClass(this, TransferRoomOwnerUI.class);
            startActivity(intent);
        } else if (str.equals("allow_by_identity")) {
            boolean isChecked = this.ejB.isChecked();
            C7060h.pYm.mo8378a(219, 22, 1, true);
            C4990ab.m7417i("MicroMsg.ManageChatroomUI", "[selectAllowByIdentity] roomId:%s isOpen:%s", this.ejD, Boolean.valueOf(isChecked));
            if (C1855t.m3903mP(this.ejD)) {
                C3462i XL = ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL();
                String nullAsNil = C5046bo.nullAsNil(this.ejD);
                if (!isChecked) {
                    i2 = 0;
                }
                XL.mo7920c(new C18740q(nullAsNil, i2));
            } else {
                bbp bbp = new bbp();
                bbp.vEf = C5046bo.nullAsNil(this.ejD);
                if (!isChecked) {
                    i = 0;
                }
                bbp.pXD = i;
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(66, bbp));
            }
            this.ejB.yDf = false;
        } else if (str.equals("room_manager")) {
            C4990ab.m7417i("MicroMsg.ManageChatroomUI", "[selectRoomManager] roomId:%s", this.ejD);
            C7577u oa = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(this.ejD);
            Intent intent2 = new Intent();
            if (oa.aoo(C1853r.m3846Yz())) {
                intent2.setClass(this, SeeRoomOwnerManagerUI.class);
            } else {
                intent2.setClass(this, SeeRoomManagerUI.class);
            }
            intent2.putExtra("RoomInfo_Id", this.ejD);
            startActivity(intent2);
        }
        AppMethodBeat.m2505o(104115);
        return false;
    }
}
