package com.tencent.mm.plugin.profile.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.n.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;

public final class b implements OnMenuItemClickListener, c, d {
    private int gwP = this.knn.getIntent().getIntExtra("Contact_Scene", 9);
    private com.tencent.mm.ui.widget.a.d iHZ;
    private boolean isDeleteCancel;
    public MMActivity knn;
    private ad ldh;
    private boolean pkC = this.knn.getIntent().getBooleanExtra("Contact_FMessageCard", false);

    public b(MMActivity mMActivity, ad adVar) {
        AppMethodBeat.i(23264);
        this.knn = mMActivity;
        this.ldh = adVar;
        AppMethodBeat.o(23264);
    }

    public final void bKH() {
        AppMethodBeat.i(23265);
        this.knn.addIconOptionMenu(0, R.drawable.uu, this);
        AppMethodBeat.o(23265);
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        AppMethodBeat.i(23266);
        this.iHZ = new com.tencent.mm.ui.widget.a.d(this.knn, 1, false);
        this.iHZ.rBm = this;
        this.iHZ.rBl = this;
        this.iHZ.cpD();
        AppMethodBeat.o(23266);
        return true;
    }

    public final void a(l lVar) {
        int i;
        CharSequence string;
        AppMethodBeat.i(23267);
        if (!t.nB(this.ldh.field_username)) {
            if (ad.aox(this.ldh.field_username)) {
                lVar.ax(1, R.string.b2o, R.raw.bottomsheet_icon_remarks);
            } else {
                lVar.ax(1, R.string.axw, R.raw.bottomsheet_icon_remarks);
            }
        }
        if (a.jh(this.ldh.field_type) && !t.nB(this.ldh.field_username)) {
            i = R.string.b01;
            if (this.ldh.dtS == 1) {
                i = R.string.azz;
            } else if (this.ldh.dtS == 2) {
                i = R.string.b00;
            }
            lVar.ax(4, i, R.raw.bottomsheet_icon_transmit);
        }
        if (this.ldh.Oc()) {
            string = this.knn.getResources().getString(R.string.b1z);
        } else {
            string = this.knn.getResources().getString(R.string.aw5);
        }
        if (a.jh(this.ldh.field_type) && !t.nB(this.ldh.field_username)) {
            lVar.a(2, string, (int) R.raw.bottomsheet_icon_star);
        }
        if (a.jh(this.ldh.field_type) || !this.knn.getIntent().getBooleanExtra("User_Verify", false)) {
            boolean z = false;
        } else {
            i = 1;
        }
        if (!(i == 0 && (ad.aox(this.ldh.field_username) || t.nB(this.ldh.field_username) || !a.jh(this.ldh.field_type)))) {
            lVar.ax(3, R.string.aya, R.raw.bottomsheet_icon_moment);
        }
        if (this.ldh.Oa()) {
            string = this.knn.getString(R.string.ay6);
        } else {
            string = this.knn.getString(R.string.ay1);
        }
        if (!t.nB(this.ldh.field_username)) {
            lVar.a(5, string, (int) R.raw.bottomsheet_icon_blacklist);
        }
        if (!t.nB(this.ldh.field_username) && a.jh(this.ldh.field_type)) {
            lVar.ax(9, R.string.a9n, R.raw.bottomsheet_icon_complain);
        }
        if (a.jh(this.ldh.field_type)) {
            lVar.ax(7, R.string.atv, R.raw.bottomsheet_icon_desktop);
        }
        if (a.jh(this.ldh.field_type) && !t.nB(this.ldh.field_username)) {
            lVar.ax(6, R.string.a6f, R.raw.bottomsheet_icon_del);
        }
        AppMethodBeat.o(23267);
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        AppMethodBeat.i(23268);
        switch (menuItem.getItemId()) {
            case 1:
                if (a.jh(this.ldh.field_type)) {
                    Intent intent = new Intent();
                    intent.putExtra("Contact_Scene", this.gwP);
                    intent.putExtra("Contact_User", this.ldh.field_username);
                    intent.putExtra("Contact_RoomNickname", this.knn.getIntent().getStringExtra("Contact_RoomNickname"));
                    intent.putExtra("contact_phone_number_list", this.ldh.dur);
                    String str = "";
                    if (!this.ldh.Of()) {
                        com.tencent.mm.plugin.account.friend.a.a aVar = null;
                        String stringExtra = this.knn.getIntent().getStringExtra("Contact_Mobile_MD5");
                        String stringExtra2 = this.knn.getIntent().getStringExtra("Contact_full_Mobile_MD5");
                        if (bo.isNullOrNil(stringExtra) && bo.isNullOrNil(stringExtra2)) {
                            if (!bo.isNullOrNil(this.ldh.field_username)) {
                                aVar = com.tencent.mm.plugin.account.a.getAddrUploadStg().vT(this.ldh.field_username);
                            }
                        } else if (!(bo.isNullOrNil(stringExtra) && bo.isNullOrNil(stringExtra2))) {
                            aVar = com.tencent.mm.plugin.account.a.getAddrUploadStg().vW(stringExtra);
                            if (aVar == null || bo.isNullOrNil(aVar.Aq())) {
                                aVar = com.tencent.mm.plugin.account.a.getAddrUploadStg().vW(stringExtra2);
                            }
                        }
                        if (!(aVar == null || bo.isNullOrNil(aVar.Aq()))) {
                            str = bo.nullAsNil(aVar.apG()).replace(" ", "");
                        }
                    }
                    intent.putExtra("contact_phone_number_by_md5", str);
                    com.tencent.mm.plugin.profile.b.gkE.m(intent, this.knn);
                    AppMethodBeat.o(23268);
                    return;
                } else if (bo.isNullOrNil(this.ldh.field_username)) {
                    ab.w("MicroMsg.ProfileMenuManager", "mod stranger remark, username is null");
                    AppMethodBeat.o(23268);
                    return;
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_Scene", this.gwP);
                    intent2.putExtra("Contact_mode_name_type", 0);
                    intent2.putExtra("Contact_ModStrangerRemark", true);
                    intent2.putExtra("Contact_User", this.ldh.field_username);
                    intent2.putExtra("Contact_Nick", this.ldh.field_nickname);
                    intent2.putExtra("Contact_RemarkName", this.ldh.field_conRemark);
                    com.tencent.mm.plugin.profile.b.gkE.n(intent2, this.knn);
                    AppMethodBeat.o(23268);
                    return;
                }
            case 2:
                if (this.ldh.Oc()) {
                    t.n(this.ldh);
                    h.bQ(this.knn, this.knn.getString(R.string.b20));
                } else {
                    t.m(this.ldh);
                    h.bQ(this.knn, this.knn.getString(R.string.aw6));
                }
                aw.ZK();
                this.ldh = com.tencent.mm.model.c.XM().aoO(this.ldh.field_username);
                AppMethodBeat.o(23268);
                return;
            case 3:
                cas();
                AppMethodBeat.o(23268);
                return;
            case 4:
                caw();
                AppMethodBeat.o(23268);
                return;
            case 5:
                jL(true);
                AppMethodBeat.o(23268);
                return;
            case 6:
                cav();
                AppMethodBeat.o(23268);
                return;
            case 7:
                ab.d("MicroMsg.ProfileMenuManager", "dealAddShortcut, username = " + this.ldh.field_username);
                com.tencent.mm.plugin.base.model.b.aa(this.knn, this.ldh.field_username);
                com.tencent.mm.plugin.base.model.b.Z(this.knn, this.ldh.field_username);
                AppMethodBeat.o(23268);
                return;
            case 9:
                cax();
                break;
        }
        AppMethodBeat.o(23268);
    }

    public final void cas() {
        AppMethodBeat.i(23269);
        Intent intent = new Intent(this.knn, PermissionSettingUI.class);
        intent.putExtra("sns_permission_userName", this.ldh.field_username);
        intent.putExtra("sns_permission_anim", true);
        intent.putExtra("sns_permission_block_scene", 1);
        this.knn.startActivity(intent);
        AppMethodBeat.o(23269);
    }

    public final void jL(boolean z) {
        AppMethodBeat.i(23270);
        if (this.ldh.Oa()) {
            cau();
            AppMethodBeat.o(23270);
            return;
        }
        View inflate = View.inflate(this.knn, R.layout.ad4, null);
        inflate.setPadding(0, 0, 0, 0);
        TextView textView = (TextView) inflate.findViewById(R.id.d8n);
        textView.setPadding(0, 0, 0, 0);
        textView.setText(ad.aox(this.ldh.field_username) ? R.string.ay3 : R.string.ay2);
        final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.d8o);
        checkBox.setChecked(false);
        textView = (TextView) inflate.findViewById(R.id.d8p);
        textView.setText(R.string.ay4);
        if (this.ldh.getSource() == 18) {
            checkBox.setVisibility(0);
            textView.setVisibility(0);
        } else {
            checkBox.setVisibility(8);
            textView.setVisibility(8);
        }
        if (z) {
            h.a(this.knn, true, this.knn.getString(R.string.ay1), inflate, this.knn.getString(R.string.s6), this.knn.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(23257);
                    b.a(b.this);
                    if (b.this.ldh.getSource() == 18) {
                        b.this.gwP = 9;
                        if (checkBox.isChecked()) {
                            b.this.cax();
                        }
                    }
                    AppMethodBeat.o(23257);
                }
            }, null);
            AppMethodBeat.o(23270);
            return;
        }
        cat();
        AppMethodBeat.o(23270);
    }

    private void cat() {
        AppMethodBeat.i(23271);
        t.i(this.ldh);
        this.ldh.ND();
        AppMethodBeat.o(23271);
    }

    private void cau() {
        AppMethodBeat.i(23272);
        t.j(this.ldh);
        this.ldh.NE();
        AppMethodBeat.o(23272);
    }

    public final void cav() {
        CharSequence string;
        AppMethodBeat.i(23273);
        View inflate = View.inflate(this.knn, R.layout.ad4, null);
        inflate.setPadding(0, 0, 0, 0);
        TextView textView = (TextView) inflate.findViewById(R.id.d8n);
        textView.setPadding(0, 0, 0, 0);
        if (t.mW(this.ldh.field_username)) {
            string = this.knn.getString(R.string.b4w, new Object[]{this.ldh.Oj()});
        } else {
            string = this.knn.getString(R.string.b4u, new Object[]{this.ldh.Oj()});
        }
        textView.setText(string);
        final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.d8o);
        checkBox.setChecked(false);
        textView = (TextView) inflate.findViewById(R.id.d8p);
        textView.setText(R.string.ay4);
        if (this.ldh.getSource() == 18) {
            checkBox.setVisibility(0);
            textView.setVisibility(0);
        } else {
            checkBox.setVisibility(8);
            textView.setVisibility(8);
        }
        h.a(this.knn, true, this.knn.getString(R.string.avj), inflate, this.knn.getString(R.string.p4), this.knn.getString(R.string.or), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(23258);
                b.d(b.this);
                if (b.this.ldh.getSource() == 18) {
                    b.this.gwP = 9;
                    if (checkBox.isChecked()) {
                        b.this.cax();
                    }
                }
                AppMethodBeat.o(23258);
            }
        }, null, (int) R.color.ei);
        AppMethodBeat.o(23273);
    }

    private void zq(String str) {
        AppMethodBeat.i(23274);
        int intExtra = this.knn.getIntent().getIntExtra("Kdel_from", -1);
        this.ldh.NC();
        this.ldh.setSource(0);
        if (ad.aox(str)) {
            ((com.tencent.mm.openim.a.a) g.K(com.tencent.mm.openim.a.a.class)).ve(str);
        } else {
            aw.ZK();
            com.tencent.mm.model.c.XL().c(new com.tencent.mm.az.c(str));
        }
        bf.a(str, new bf.a() {
            public final boolean JU() {
                AppMethodBeat.i(23262);
                boolean f = b.this.isDeleteCancel;
                AppMethodBeat.o(23262);
                return f;
            }

            public final void JV() {
            }
        });
        aw.ZK();
        com.tencent.mm.model.c.XM().b(str, this.ldh);
        aw.ZK();
        com.tencent.mm.model.c.XR().aoX(str);
        com.tencent.mm.bi.c.e(0, str);
        com.tencent.mm.bi.c.e(0, this.ldh.field_encryptUsername);
        switch (this.gwP) {
            case 10:
                w.J(this.knn, str);
                break;
            case 13:
                com.tencent.mm.plugin.account.friend.a.a vT = com.tencent.mm.plugin.account.a.getAddrUploadStg().vT(str);
                if (!(vT == null || bo.isNullOrNil(vT.guM))) {
                    vT.status = 1;
                    com.tencent.mm.plugin.account.a.getAddrUploadStg().a(vT.Aq(), vT);
                }
                w.J(this.knn, str);
                break;
        }
        if (this.gwP == 9) {
            ab.i("MicroMsg.ProfileMenuManager", "add scene unkown, check the contact getsource: " + this.ldh.getSource());
            switch (this.ldh.getSource()) {
                case 10:
                case 13:
                    ab.i("MicroMsg.ProfileMenuManager", "delete the system contact info added by wechat");
                    w.J(this.knn, str);
                    break;
            }
        }
        if (intExtra == 0) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            com.tencent.mm.plugin.profile.b.gkE.p(intent, this.knn);
            AppMethodBeat.o(23274);
            return;
        }
        this.knn.setResult(-1, this.knn.getIntent().putExtra("_delete_ok_", true));
        this.knn.finish();
        AppMethodBeat.o(23274);
    }

    public final void caw() {
        AppMethodBeat.i(23275);
        Intent intent = new Intent();
        intent.putExtra("Select_Talker_Name", this.ldh.field_username);
        intent.putExtra("Select_block_List", this.ldh.field_username);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("Select_Send_Card", true);
        intent.putExtra("mutil_select_is_ret", true);
        com.tencent.mm.plugin.profile.b.gkE.a(intent, new MMActivity.a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(23263);
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("be_send_card_name");
                    String stringExtra2 = intent.getStringExtra("received_card_name");
                    boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    String stringExtra3 = intent.getStringExtra("custom_send_text");
                    com.tencent.mm.plugin.messenger.a.g.bOk().q(stringExtra, stringExtra2, booleanExtra);
                    com.tencent.mm.plugin.messenger.a.g.bOk().eZ(stringExtra3, stringExtra2);
                    com.tencent.mm.ui.widget.snackbar.b.i(b.this.knn, b.this.knn.getString(R.string.bvk));
                }
                AppMethodBeat.o(23263);
            }
        }, this.knn);
        AppMethodBeat.o(23275);
    }

    public final void cax() {
        int i = 7;
        AppMethodBeat.i(23276);
        Intent intent = new Intent();
        switch (this.gwP) {
            case 1:
            case 2:
            case 3:
            case 12:
            case 13:
            case aa.CTRL_INDEX /*58*/:
            case au.CTRL_INDEX /*59*/:
            case 60:
                intent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bi.a.z(45, this.ldh.field_username));
                i = 45;
                break;
            case 9:
            case 14:
                i = 35;
                break;
            case 18:
                if (this.pkC) {
                    i = 2;
                } else {
                    i = 1;
                }
                intent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bi.a.tS(this.ldh.field_username));
                break;
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case com.tencent.view.d.MIC_BASE_CHANNELSHARPEN /*28*/:
            case 29:
                i = this.pkC ? 4 : 3;
                intent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bi.a.tT(this.ldh.field_username));
                break;
            case 25:
                i = this.pkC ? 6 : 5;
                if (!this.pkC) {
                    String str;
                    String str2 = "k_outside_expose_proof_item_list";
                    if (bo.isNullOrNil(this.ldh.xXc)) {
                        str = this.ldh.field_username;
                    } else {
                        str = this.ldh.xXc;
                    }
                    intent.putExtra(str2, com.tencent.mm.bi.a.tU(str));
                    break;
                }
                intent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bi.a.z(i, this.ldh.field_username));
                break;
            case 30:
                intent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bi.a.z(7, this.ldh.field_username));
                break;
            default:
                i = 999;
                break;
        }
        intent.putExtra("k_username", this.ldh.field_username);
        intent.putExtra("showShare", false);
        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(i)}));
        com.tencent.mm.bp.d.b(this.knn, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(23276);
    }

    public static void a(Activity activity, ad adVar) {
        AppMethodBeat.i(23277);
        Intent intent = new Intent();
        intent.setClass(activity, ContactMoreInfoUI.class);
        intent.putExtra("Is_RoomOwner", activity.getIntent().getBooleanExtra("Is_RoomOwner", false));
        intent.putExtra("Contact_User", adVar.field_username);
        String stringExtra = activity.getIntent().getStringExtra("room_name");
        if (stringExtra == null) {
            stringExtra = activity.getIntent().getStringExtra("Contact_ChatRoomId");
        }
        intent.putExtra("Contact_ChatRoomId", stringExtra);
        stringExtra = bo.bc(activity.getIntent().getStringExtra("verify_gmail"), "");
        String bc = bo.bc(activity.getIntent().getStringExtra("profileName"), bo.anu(stringExtra));
        intent.putExtra("verify_gmail", stringExtra);
        intent.putExtra("profileName", bc);
        long longExtra = activity.getIntent().getLongExtra("Contact_Uin", 0);
        stringExtra = activity.getIntent().getStringExtra("Contact_QQNick");
        intent.putExtra("Contact_Uin", longExtra);
        intent.putExtra("Contact_QQNick", stringExtra);
        activity.startActivity(intent);
        AppMethodBeat.o(23277);
    }

    static /* synthetic */ void d(b bVar) {
        AppMethodBeat.i(23279);
        com.tencent.mm.plugin.report.service.h.pYm.e(14553, Integer.valueOf(2), Integer.valueOf(2), bVar.ldh.field_username);
        final String str = bVar.ldh.field_username;
        if (t.mW(str)) {
            bVar.ldh.NC();
            aw.ZK();
            com.tencent.mm.model.c.XL().c(new com.tencent.mm.az.c(str));
            aw.ZK();
            com.tencent.mm.model.c.XM().aoU(str);
            aw.ZK();
            com.tencent.mm.model.c.XV().og(str);
            AppMethodBeat.o(23279);
            return;
        }
        String str2;
        bVar.isDeleteCancel = false;
        Context context = bVar.knn;
        bVar.knn.getString(R.string.tz);
        final p b = h.b(context, bVar.knn.getString(R.string.un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(23259);
                b.this.isDeleteCancel = true;
                AppMethodBeat.o(23259);
            }
        });
        if (bVar.isDeleteCancel) {
            str2 = null;
        } else {
            str2 = e.akq(bVar.ldh.field_username);
        }
        if (bo.isNullOrNil(str2)) {
            bVar.zq(str);
            AppMethodBeat.o(23279);
            return;
        }
        b.dismiss();
        h.a(bVar.knn, false, bVar.knn.getString(R.string.fe9, new Object[]{str2}), null, bVar.knn.getString(R.string.c9y), bVar.knn.getString(R.string.b57), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(23260);
                com.tencent.mm.plugin.report.service.h.pYm.e(14553, Integer.valueOf(2), Integer.valueOf(4), b.this.ldh.field_username);
                b.this.isDeleteCancel = true;
                Intent intent = new Intent();
                intent.putExtra("Chat_User", b.this.ldh.field_username);
                intent.addFlags(67108864);
                com.tencent.mm.bp.d.f(b.this.knn, ".ui.chatting.ChattingUI", intent);
                AppMethodBeat.o(23260);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(23261);
                com.tencent.mm.plugin.report.service.h.pYm.e(14553, Integer.valueOf(2), Integer.valueOf(3), b.this.ldh.field_username);
                b.show();
                b.this.isDeleteCancel = false;
                b.a(b.this, str);
                AppMethodBeat.o(23261);
            }
        }, -1, R.color.ei);
        AppMethodBeat.o(23279);
    }
}
