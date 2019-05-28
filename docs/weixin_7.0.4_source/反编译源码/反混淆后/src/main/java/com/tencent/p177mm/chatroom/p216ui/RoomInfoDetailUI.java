package com.tencent.p177mm.chatroom.p216ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.chatroom.p1596e.C41925b;
import com.tencent.p177mm.chatroom.p216ui.preference.SignaturePreference;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p612ui.C5510e.C5500g;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.wallet.C40492e;
import com.tencent.p177mm.protocal.protobuf.bbr;
import com.tencent.p177mm.protocal.protobuf.bbs;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;

@Deprecated
/* renamed from: com.tencent.mm.chatroom.ui.RoomInfoDetailUI */
public class RoomInfoDetailUI extends MMPreference implements C4931a {
    private boolean cEH;
    private C15541f ehK;
    private C7616ad ehM;
    private CheckBoxPreference ehT;
    private String ehq;
    private boolean eig = false;
    private String eis;
    private int ekw;
    private SignaturePreference ekx;
    private CheckBoxPreference eky;
    private CheckBoxPreference ekz;
    private boolean isDeleteCancel = false;

    /* renamed from: com.tencent.mm.chatroom.ui.RoomInfoDetailUI$1 */
    class C13791 implements OnMenuItemClickListener {
        C13791() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(104185);
            RoomInfoDetailUI.this.finish();
            AppMethodBeat.m2505o(104185);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.RoomInfoDetailUI$2 */
    class C92222 implements C30391c {

        /* renamed from: com.tencent.mm.chatroom.ui.RoomInfoDetailUI$2$1 */
        class C92191 implements OnCancelListener {
            C92191() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(104186);
                RoomInfoDetailUI.this.isDeleteCancel = true;
                AppMethodBeat.m2505o(104186);
            }
        }

        /* renamed from: com.tencent.mm.chatroom.ui.RoomInfoDetailUI$2$2 */
        class C92202 implements OnClickListener {
            C92202() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(104187);
                RoomInfoDetailUI.this.isDeleteCancel = true;
                Intent intent = new Intent();
                intent.putExtra("Chat_User", RoomInfoDetailUI.this.ehM.field_username);
                intent.addFlags(67108864);
                C25985d.m41473f(RoomInfoDetailUI.this, ".ui.chatting.ChattingUI", intent);
                AppMethodBeat.m2505o(104187);
            }
        }

        C92222() {
        }

        /* renamed from: iE */
        public final void mo7700iE(int i) {
            AppMethodBeat.m2504i(104189);
            switch (i) {
                case 0:
                    String str;
                    RoomInfoDetailUI.this.isDeleteCancel = false;
                    Context context = RoomInfoDetailUI.this;
                    RoomInfoDetailUI.this.getString(C25738R.string.f9238tz);
                    final ProgressDialog b = C30379h.m48458b(context, RoomInfoDetailUI.this.getString(C25738R.string.f9260un), true, new C92191());
                    if (RoomInfoDetailUI.this.isDeleteCancel) {
                        str = null;
                    } else {
                        str = C40492e.akq(RoomInfoDetailUI.this.ehM.field_username);
                    }
                    if (C5046bo.isNullOrNil(str)) {
                        RoomInfoDetailUI.m16747a(RoomInfoDetailUI.this, b);
                        break;
                    }
                    b.dismiss();
                    C30379h.m48454a(RoomInfoDetailUI.this, false, RoomInfoDetailUI.this.getString(C25738R.string.fdk, new Object[]{str}), null, RoomInfoDetailUI.this.getString(C25738R.string.c9y), RoomInfoDetailUI.this.getString(C25738R.string.ar1), new C92202(), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(104188);
                            b.show();
                            RoomInfoDetailUI.this.isDeleteCancel = false;
                            RoomInfoDetailUI.m16747a(RoomInfoDetailUI.this, b);
                            AppMethodBeat.m2505o(104188);
                        }
                    }, -1, C25738R.color.f11717ei);
                    AppMethodBeat.m2505o(104189);
                    return;
            }
            AppMethodBeat.m2505o(104189);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(104192);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(104192);
    }

    public void onResume() {
        AppMethodBeat.m2504i(104193);
        super.onResume();
        m16743JL();
        m16746Kd();
        if (!(this.ehM == null || this.eky == null)) {
            C7577u ob = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14886ob(this.ehq);
            SharedPreferences sharedPreferences = getSharedPreferences(this.eis, 0);
            if (ob.drX()) {
                this.eky.uOT = true;
                sharedPreferences.edit().putBoolean("room_msg_show_username", true).commit();
            } else {
                this.eky.uOT = false;
                sharedPreferences.edit().putBoolean("room_msg_show_username", false).commit();
            }
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(104193);
    }

    public final void initView() {
        AppMethodBeat.m2504i(104194);
        setMMTitle((int) C25738R.string.dvh);
        this.ehK = this.yCw;
        this.eis = getPackageName() + "_preferences";
        this.cEH = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.ehq = getIntent().getStringExtra("RoomInfo_Id");
        if (this.ehq == null) {
            this.ehq = getIntent().getStringExtra("Single_Chat_Talker");
        }
        this.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.ehq);
        if (this.cEH) {
            this.ekw = this.ehM.dua;
            m16744Kb();
        } else {
            this.ekw = 1;
        }
        setBackBtn(new C13791());
        AppMethodBeat.m2505o(104194);
    }

    /* renamed from: Kb */
    private void m16744Kb() {
        AppMethodBeat.m2504i(104195);
        this.ekx = (SignaturePreference) this.ehK.aqO("room_name");
        this.ehT = (CheckBoxPreference) this.ehK.aqO("room_msg_notify");
        this.ekz = (CheckBoxPreference) this.ehK.aqO("room_show_msg_count");
        this.eky = (CheckBoxPreference) this.ehK.aqO("room_msg_show_username");
        this.ekz.yDf = false;
        AppMethodBeat.m2505o(104195);
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8530be;
    }

    public void onPause() {
        AppMethodBeat.m2504i(104197);
        super.onPause();
        if (this.eig) {
            C7577u oa = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(this.ehq);
            ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo10103c(oa, new String[0]);
            String Yz = C1853r.m3846Yz();
            boolean drX = oa.drX();
            bbs bbs = new bbs();
            bbs.vEf = this.ehq;
            bbs.jBB = Yz;
            bbs.wGd = 1;
            bbs.pXD = drX ? 1 : 0;
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(49, bbs));
        }
        AppMethodBeat.m2505o(104197);
    }

    /* renamed from: Kc */
    private boolean m16745Kc() {
        AppMethodBeat.m2504i(104198);
        if ((((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(this.ehq).field_chatroomdataflag & 2) == 0) {
            AppMethodBeat.m2505o(104198);
            return true;
        }
        AppMethodBeat.m2505o(104198);
        return false;
    }

    /* renamed from: JD */
    private String m16742JD() {
        AppMethodBeat.m2504i(104199);
        C7577u oa = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(this.ehq);
        String str;
        if (oa == null) {
            str = "";
            AppMethodBeat.m2505o(104199);
            return str;
        }
        str = oa.field_selfDisplayName;
        AppMethodBeat.m2505o(104199);
        return str;
    }

    /* renamed from: Kd */
    private void m16746Kd() {
        AppMethodBeat.m2504i(104200);
        if (!(this.ehM == null || this.ekx == null)) {
            CharSequence JD = m16742JD();
            if (C5046bo.isNullOrNil(JD)) {
                JD = C1853r.m3820YB();
            }
            if (C5046bo.isNullOrNil(JD)) {
                this.ekx.setSummary((CharSequence) "");
            } else {
                SignaturePreference signaturePreference = this.ekx;
                if (JD.length() <= 0) {
                    JD = getString(C25738R.string.eal);
                }
                signaturePreference.setSummary((CharSequence) C44089j.m79292b((Context) this, JD));
                AppMethodBeat.m2505o(104200);
                return;
            }
        }
        AppMethodBeat.m2505o(104200);
    }

    /* renamed from: JL */
    private void m16743JL() {
        boolean z = true;
        AppMethodBeat.m2504i(104201);
        if (this.cEH) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.eis, 0);
            if (this.ekw == 0) {
                setTitleMuteIconVisibility(0);
                if (this.ehT != null) {
                    this.ehT.uOT = true;
                    sharedPreferences.edit().putBoolean("room_msg_notify", true).commit();
                }
                if (this.ekz != null) {
                    this.ekz.uOT = m16745Kc();
                }
            } else if (this.ekw == 1) {
                setTitleMuteIconVisibility(8);
                if (this.ehT != null) {
                    this.ehT.uOT = false;
                    sharedPreferences.edit().putBoolean("room_msg_notify", false).commit();
                }
            }
            C15541f c15541f = this.ehK;
            String str = "room_show_msg_count";
            if (this.ekw != 1) {
                z = false;
            }
            c15541f.mo27715ce(str, z);
            AppMethodBeat.m2505o(104201);
            return;
        }
        AppMethodBeat.m2505o(104201);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(104202);
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            AppMethodBeat.m2505o(104202);
            return;
        }
        switch (i) {
            case 1:
                if (i2 == -1) {
                    setResult(-1);
                    finish();
                    AppMethodBeat.m2505o(104202);
                    return;
                }
                break;
            case 2:
                if (intent != null) {
                    String bc = C5046bo.m7532bc(intent.getStringExtra("Contact_Nick"), "");
                    if (!C5046bo.isNullOrNil(bc)) {
                        C7577u c7577u;
                        String Yz = C1853r.m3846Yz();
                        C7577u oa = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(this.ehq);
                        if (oa == null) {
                            c7577u = new C7577u();
                        } else {
                            c7577u = oa;
                        }
                        c7577u.field_chatroomname = this.ehq;
                        c7577u.field_selfDisplayName = bc;
                        ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo10103c(c7577u, new String[0]);
                        bbr bbr = new bbr();
                        bbr.vEf = this.ehq;
                        bbr.jBB = Yz;
                        bbr.vXl = C5046bo.nullAsNil(bc);
                        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(48, bbr));
                        m16746Kd();
                        break;
                    }
                }
                AppMethodBeat.m2505o(104202);
                return;
                break;
        }
        AppMethodBeat.m2505o(104202);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        Intent intent;
        String string;
        boolean z = true;
        AppMethodBeat.m2504i(104196);
        String str = preference.mKey;
        C4990ab.m7411d("MicroMsg.RoomInfoDetailUI", "click key : %s", str);
        if (str.equals("room_name")) {
            intent = new Intent();
            intent.setClass(this, C5500g.class);
            intent.putExtra("Contact_mode_name_type", 4);
            String Yz = C1853r.m3846Yz();
            intent.putExtra("Contact_Nick", m16742JD());
            intent.putExtra("Contact_User", Yz);
            intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, C25738R.anim.f8332b5);
            intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, C25738R.anim.f8373ce);
            this.mController.ylL.startActivityForResult(intent, 2);
        }
        if (str.equals("room_msg_show_username")) {
            C7577u oa = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(this.ehq);
            oa.mo16808pq(!oa.drX());
            this.eig = true;
        }
        if (str.equals("room_msg_notify")) {
            this.ekw = this.ekw == 0 ? 1 : 0;
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C41925b(this.ehq, this.ekw));
            this.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.ehq);
            this.ehM.mo14689hE(this.ekw);
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15724b(this.ehq, this.ehM);
            m16743JL();
            this.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.ehq);
            this.ehK.notifyDataSetChanged();
        }
        if (str.equals("room_set_chatting_background")) {
            intent = new Intent();
            intent.putExtra("isApplyToAll", false);
            intent.putExtra("username", this.ehM.field_username);
            C25985d.m41468b((Context) this, "setting", ".ui.setting.SettingsChattingBackgroundUI", intent, 1);
        }
        if (str.equals("room_clear_chatting_history")) {
            if (this.cEH) {
                string = getString(C25738R.string.bx2);
            } else {
                string = getString(C25738R.string.bx1, new Object[]{this.ehM.mo16707Oj()});
            }
            C30379h.m48422a((Context) this, string, new String[]{getString(C25738R.string.drt)}, null, new C92222());
        }
        if (str.equals("room_placed_to_the_top")) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.eis, 0);
            if (this.ehM != null) {
                if (((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aph(this.ehM.field_username)) {
                    C1855t.m3969x(this.ehM.field_username, true);
                } else {
                    C1855t.m3967w(this.ehM.field_username, true);
                }
                sharedPreferences.edit().putBoolean("room_placed_to_the_top", ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aph(this.ehM.field_username)).commit();
            }
        }
        if ("room_show_msg_count".equals(str)) {
            boolean z2;
            int i;
            boolean Kc = m16745Kc();
            C4990ab.m7411d("MicroMsg.RoomInfoDetailUI", "old value undeliver[%B], now set show msg count[%B]", Boolean.valueOf(Kc), Boolean.valueOf(Kc));
            if (Kc) {
                z2 = false;
            } else {
                z2 = true;
            }
            C7577u oa2 = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(this.ehq);
            if (z2) {
                oa2.mo16806ji(0);
            } else {
                oa2.mo16806ji(2);
            }
            C4990ab.m7411d("MicroMsg.RoomInfoDetailUI", "update show msg count[%B]", Boolean.valueOf(z2));
            ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo10103c(oa2, new String[0]);
            string = C1853r.m3846Yz();
            bbs bbs = new bbs();
            bbs.vEf = this.ehq;
            bbs.jBB = string;
            bbs.wGd = 2;
            if (z2) {
                i = 2;
            } else {
                i = 1;
            }
            bbs.pXD = i;
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(49, bbs));
            if (this.ekz != null) {
                CheckBoxPreference checkBoxPreference = this.ekz;
                if (Kc) {
                    z = false;
                }
                checkBoxPreference.uOT = z;
            }
            this.ehK.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(104196);
        return false;
    }
}
