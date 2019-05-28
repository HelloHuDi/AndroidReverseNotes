package com.tencent.p177mm.chatroom.p216ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C42041qh;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C24020t;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.NormalIconPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.PreferenceTitleCategory;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7575bv;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.chatroom.ui.SeeRoomOwnerManagerUI */
public class SeeRoomOwnerManagerUI extends MMPreference {
    private C7577u eih;
    private String ejD;

    /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomOwnerManagerUI$1 */
    class C419261 extends C24020t {
        C419261() {
        }

        /* renamed from: Kp */
        public final void mo39830Kp() {
            AppMethodBeat.m2504i(104365);
            SeeRoomOwnerManagerUI.this.finish();
            AppMethodBeat.m2505o(104365);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(104368);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.dsx);
        setBackBtn(new C419261());
        this.ejD = getIntent().getStringExtra("RoomInfo_Id");
        this.eih = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(C5046bo.nullAsNil(this.ejD));
        if (this.eih != null) {
            PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(this.mController.ylL);
            preferenceTitleCategory.setTitle((int) C25738R.string.dvc);
            this.yCw.mo27713b(preferenceTitleCategory);
            C4990ab.m7417i("MicroMsg.SeeRoomOwnerManagerUI", "[onCreate] owner:%s", this.eih.field_roomowner);
            final C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.eih.field_roomowner);
            C419272 c419272 = new NormalIconPreference(this.mController.ylL) {
                public final void onBindView(View view) {
                    AppMethodBeat.m2504i(104366);
                    super.onBindView(view);
                    C40460b.m69433a(this.yBV, aoO.field_username, 0.15f, false);
                    this.yBV.setVisibility(0);
                    AppMethodBeat.m2505o(104366);
                }
            };
            c419272.setKey(aoO.field_username);
            c419272.getExtras().putString("username", aoO.field_username);
            c419272.setTitle((CharSequence) C44089j.m79292b(this.mController.ylL, aoO.mo16707Oj()));
            this.yCw.mo27713b(c419272);
            PreferenceTitleCategory preferenceTitleCategory2 = new PreferenceTitleCategory(this.mController.ylL);
            preferenceTitleCategory2.setTitle((int) C25738R.string.dt2);
            int i = 0;
            for (String str : this.eih.afg()) {
                if (this.eih.aoo(str)) {
                    int i2;
                    C4990ab.m7417i("MicroMsg.SeeRoomOwnerManagerUI", "[resetData] Room Manager:%s", str);
                    if (i == 0) {
                        this.yCw.mo27713b(preferenceTitleCategory2);
                        i2 = 1;
                    } else {
                        i2 = i;
                    }
                    final C7616ad aoO2 = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
                    C181623 c181623 = new NormalIconPreference(this.mController.ylL) {
                        public final void onBindView(View view) {
                            AppMethodBeat.m2504i(104367);
                            super.onBindView(view);
                            C40460b.m69433a(this.yBV, aoO2.field_username, 0.15f, false);
                            this.yBV.setVisibility(0);
                            AppMethodBeat.m2505o(104367);
                        }
                    };
                    c181623.setKey(str);
                    c181623.getExtras().putString("username", aoO2.field_username);
                    c181623.setTitle((CharSequence) C44089j.m79292b(this.mController.ylL, aoO2.mo16707Oj()));
                    this.yCw.mo27713b(c181623);
                    i = i2;
                }
            }
            this.yCw.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(104368);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8535bj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(104369);
        if (preference instanceof NormalIconPreference) {
            String str;
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(preference.getExtras().getString("username"));
            String str2 = aoO.field_username;
            String Oj = aoO.mo16707Oj();
            String str3 = aoO.field_nickname;
            if (C5046bo.isNullOrNil(Oj)) {
                C7575bv RB = ((C6982j) C1720g.m3528K(C6982j.class)).mo15370XN().mo15364RB(str2);
                if (!(RB == null || C5046bo.isNullOrNil(RB.field_encryptUsername))) {
                    str = RB.field_conRemark;
                    if (!C5046bo.isNullOrNil(str2)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", str2);
                        intent.putExtra("Contact_RemarkName", str);
                        if (this.eih != null) {
                            intent.putExtra("Contact_RoomNickname", this.eih.mo16807mJ(str2));
                        }
                        intent.putExtra("Contact_Nick", str3);
                        intent.putExtra("Contact_RoomMember", true);
                        intent.putExtra("room_name", this.ejD);
                        aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str2);
                        if (aoO != null && ((int) aoO.ewQ) > 0 && C7486a.m12942jh(aoO.field_type)) {
                            C42041qh c42041qh = new C42041qh();
                            c42041qh.cMw.intent = intent;
                            c42041qh.cMw.username = str2;
                            C4879a.xxA.mo10055m(c42041qh);
                        }
                        if (aoO != null && aoO.dsf()) {
                            C7060h.pYm.mo8374X(10298, aoO.field_username + ",14");
                        }
                        intent.putExtra("Contact_Scene", 96);
                        intent.putExtra("Is_RoomOwner", true);
                        intent.putExtra("Contact_ChatRoomId", this.ejD);
                        C25985d.m41467b((Context) this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                    }
                }
            }
            str = Oj;
            if (C5046bo.isNullOrNil(str2)) {
            }
        }
        AppMethodBeat.m2505o(104369);
        return false;
    }
}
