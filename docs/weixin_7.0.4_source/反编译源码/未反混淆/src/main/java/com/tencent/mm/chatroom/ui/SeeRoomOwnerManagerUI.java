package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.t;

public class SeeRoomOwnerManagerUI extends MMPreference {
    private u eih;
    private String ejD;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(104368);
        super.onCreate(bundle);
        setMMTitle((int) R.string.dsx);
        setBackBtn(new t() {
            public final void Kp() {
                AppMethodBeat.i(104365);
                SeeRoomOwnerManagerUI.this.finish();
                AppMethodBeat.o(104365);
            }
        });
        this.ejD = getIntent().getStringExtra("RoomInfo_Id");
        this.eih = ((c) g.K(c.class)).XV().oa(bo.nullAsNil(this.ejD));
        if (this.eih != null) {
            PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(this.mController.ylL);
            preferenceTitleCategory.setTitle((int) R.string.dvc);
            this.yCw.b(preferenceTitleCategory);
            ab.i("MicroMsg.SeeRoomOwnerManagerUI", "[onCreate] owner:%s", this.eih.field_roomowner);
            final ad aoO = ((j) g.K(j.class)).XM().aoO(this.eih.field_roomowner);
            AnonymousClass2 anonymousClass2 = new NormalIconPreference(this.mController.ylL) {
                public final void onBindView(View view) {
                    AppMethodBeat.i(104366);
                    super.onBindView(view);
                    b.a(this.yBV, aoO.field_username, 0.15f, false);
                    this.yBV.setVisibility(0);
                    AppMethodBeat.o(104366);
                }
            };
            anonymousClass2.setKey(aoO.field_username);
            anonymousClass2.getExtras().putString("username", aoO.field_username);
            anonymousClass2.setTitle((CharSequence) com.tencent.mm.pluginsdk.ui.e.j.b(this.mController.ylL, aoO.Oj()));
            this.yCw.b(anonymousClass2);
            PreferenceTitleCategory preferenceTitleCategory2 = new PreferenceTitleCategory(this.mController.ylL);
            preferenceTitleCategory2.setTitle((int) R.string.dt2);
            int i = 0;
            for (String str : this.eih.afg()) {
                if (this.eih.aoo(str)) {
                    int i2;
                    ab.i("MicroMsg.SeeRoomOwnerManagerUI", "[resetData] Room Manager:%s", str);
                    if (i == 0) {
                        this.yCw.b(preferenceTitleCategory2);
                        i2 = 1;
                    } else {
                        i2 = i;
                    }
                    final ad aoO2 = ((j) g.K(j.class)).XM().aoO(str);
                    AnonymousClass3 anonymousClass3 = new NormalIconPreference(this.mController.ylL) {
                        public final void onBindView(View view) {
                            AppMethodBeat.i(104367);
                            super.onBindView(view);
                            b.a(this.yBV, aoO2.field_username, 0.15f, false);
                            this.yBV.setVisibility(0);
                            AppMethodBeat.o(104367);
                        }
                    };
                    anonymousClass3.setKey(str);
                    anonymousClass3.getExtras().putString("username", aoO2.field_username);
                    anonymousClass3.setTitle((CharSequence) com.tencent.mm.pluginsdk.ui.e.j.b(this.mController.ylL, aoO2.Oj()));
                    this.yCw.b(anonymousClass3);
                    i = i2;
                }
            }
            this.yCw.notifyDataSetChanged();
        }
        AppMethodBeat.o(104368);
    }

    public final int JC() {
        return R.xml.bj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(104369);
        if (preference instanceof NormalIconPreference) {
            String str;
            ad aoO = ((j) g.K(j.class)).XM().aoO(preference.getExtras().getString("username"));
            String str2 = aoO.field_username;
            String Oj = aoO.Oj();
            String str3 = aoO.field_nickname;
            if (bo.isNullOrNil(Oj)) {
                bv RB = ((j) g.K(j.class)).XN().RB(str2);
                if (!(RB == null || bo.isNullOrNil(RB.field_encryptUsername))) {
                    str = RB.field_conRemark;
                    if (!bo.isNullOrNil(str2)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", str2);
                        intent.putExtra("Contact_RemarkName", str);
                        if (this.eih != null) {
                            intent.putExtra("Contact_RoomNickname", this.eih.mJ(str2));
                        }
                        intent.putExtra("Contact_Nick", str3);
                        intent.putExtra("Contact_RoomMember", true);
                        intent.putExtra("room_name", this.ejD);
                        aoO = ((j) g.K(j.class)).XM().aoO(str2);
                        if (aoO != null && ((int) aoO.ewQ) > 0 && a.jh(aoO.field_type)) {
                            qh qhVar = new qh();
                            qhVar.cMw.intent = intent;
                            qhVar.cMw.username = str2;
                            com.tencent.mm.sdk.b.a.xxA.m(qhVar);
                        }
                        if (aoO != null && aoO.dsf()) {
                            h.pYm.X(10298, aoO.field_username + ",14");
                        }
                        intent.putExtra("Contact_Scene", 96);
                        intent.putExtra("Is_RoomOwner", true);
                        intent.putExtra("Contact_ChatRoomId", this.ejD);
                        d.b((Context) this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                    }
                }
            }
            str = Oj;
            if (bo.isNullOrNil(str2)) {
            }
        }
        AppMethodBeat.o(104369);
        return false;
    }
}
