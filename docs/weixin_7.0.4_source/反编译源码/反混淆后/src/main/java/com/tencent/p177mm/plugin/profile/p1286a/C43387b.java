package com.tencent.p177mm.plugin.profile.p1286a;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1827a;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.openim.p1210a.C37974a;
import com.tencent.p177mm.p1374bi.C25860a;
import com.tencent.p177mm.p1374bi.C37512c;
import com.tencent.p177mm.p201az.C37498c;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C26529w;
import com.tencent.p177mm.plugin.account.C32923a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2206au;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42464aa;
import com.tencent.p177mm.plugin.base.model.C42781b;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.plugin.profile.C39503b;
import com.tencent.p177mm.plugin.profile.p483ui.ContactMoreInfoUI;
import com.tencent.p177mm.plugin.profile.p483ui.PermissionSettingUI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.wallet.C40492e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.profile.a.b */
public final class C43387b implements OnMenuItemClickListener, C36073c, C5279d {
    private int gwP = this.knn.getIntent().getIntExtra("Contact_Scene", 9);
    private C36356d iHZ;
    private boolean isDeleteCancel;
    public MMActivity knn;
    private C7616ad ldh;
    private boolean pkC = this.knn.getIntent().getBooleanExtra("Contact_FMessageCard", false);

    /* renamed from: com.tencent.mm.plugin.profile.a.b$6 */
    class C214526 implements C1827a {
        C214526() {
        }

        /* renamed from: JU */
        public final boolean mo5405JU() {
            AppMethodBeat.m2504i(23262);
            boolean f = C43387b.this.isDeleteCancel;
            AppMethodBeat.m2505o(23262);
            return f;
        }

        /* renamed from: JV */
        public final void mo5406JV() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.a.b$7 */
    class C286817 implements C5186a {
        C286817() {
        }

        /* renamed from: c */
        public final void mo6069c(int i, int i2, Intent intent) {
            AppMethodBeat.m2504i(23263);
            if (i2 == -1 && intent != null) {
                String stringExtra = intent.getStringExtra("be_send_card_name");
                String stringExtra2 = intent.getStringExtra("received_card_name");
                boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                String stringExtra3 = intent.getStringExtra("custom_send_text");
                C12519g.bOk().mo46462q(stringExtra, stringExtra2, booleanExtra);
                C12519g.bOk().mo46461eZ(stringExtra3, stringExtra2);
                C5670b.m8523i(C43387b.this.knn, C43387b.this.knn.getString(C25738R.string.bvk));
            }
            AppMethodBeat.m2505o(23263);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.a.b$3 */
    class C433843 implements OnCancelListener {
        C433843() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(23259);
            C43387b.this.isDeleteCancel = true;
            AppMethodBeat.m2505o(23259);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.a.b$4 */
    class C433854 implements OnClickListener {
        C433854() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(23260);
            C7060h.pYm.mo8381e(14553, Integer.valueOf(2), Integer.valueOf(4), C43387b.this.ldh.field_username);
            C43387b.this.isDeleteCancel = true;
            Intent intent = new Intent();
            intent.putExtra("Chat_User", C43387b.this.ldh.field_username);
            intent.addFlags(67108864);
            C25985d.m41473f(C43387b.this.knn, ".ui.chatting.ChattingUI", intent);
            AppMethodBeat.m2505o(23260);
        }
    }

    public C43387b(MMActivity mMActivity, C7616ad c7616ad) {
        AppMethodBeat.m2504i(23264);
        this.knn = mMActivity;
        this.ldh = c7616ad;
        AppMethodBeat.m2505o(23264);
    }

    public final void bKH() {
        AppMethodBeat.m2504i(23265);
        this.knn.addIconOptionMenu(0, C25738R.drawable.f6899uu, this);
        AppMethodBeat.m2505o(23265);
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        AppMethodBeat.m2504i(23266);
        this.iHZ = new C36356d(this.knn, 1, false);
        this.iHZ.rBm = this;
        this.iHZ.rBl = this;
        this.iHZ.cpD();
        AppMethodBeat.m2505o(23266);
        return true;
    }

    /* renamed from: a */
    public final void mo5746a(C44273l c44273l) {
        int i;
        CharSequence string;
        AppMethodBeat.m2504i(23267);
        if (!C1855t.m3916nB(this.ldh.field_username)) {
            if (C7616ad.aox(this.ldh.field_username)) {
                c44273l.mo70063ax(1, C25738R.string.b2o, C1318a.bottomsheet_icon_remarks);
            } else {
                c44273l.mo70063ax(1, C25738R.string.axw, C1318a.bottomsheet_icon_remarks);
            }
        }
        if (C7486a.m12942jh(this.ldh.field_type) && !C1855t.m3916nB(this.ldh.field_username)) {
            i = C25738R.string.b01;
            if (this.ldh.dtS == 1) {
                i = C25738R.string.azz;
            } else if (this.ldh.dtS == 2) {
                i = C25738R.string.b00;
            }
            c44273l.mo70063ax(4, i, C1318a.bottomsheet_icon_transmit);
        }
        if (this.ldh.mo16700Oc()) {
            string = this.knn.getResources().getString(C25738R.string.b1z);
        } else {
            string = this.knn.getResources().getString(C25738R.string.aw5);
        }
        if (C7486a.m12942jh(this.ldh.field_type) && !C1855t.m3916nB(this.ldh.field_username)) {
            c44273l.mo70049a(2, string, (int) C1318a.bottomsheet_icon_star);
        }
        if (C7486a.m12942jh(this.ldh.field_type) || !this.knn.getIntent().getBooleanExtra("User_Verify", false)) {
            boolean z = false;
        } else {
            i = 1;
        }
        if (!(i == 0 && (C7616ad.aox(this.ldh.field_username) || C1855t.m3916nB(this.ldh.field_username) || !C7486a.m12942jh(this.ldh.field_type)))) {
            c44273l.mo70063ax(3, C25738R.string.aya, C1318a.bottomsheet_icon_moment);
        }
        if (this.ldh.mo16698Oa()) {
            string = this.knn.getString(C25738R.string.ay6);
        } else {
            string = this.knn.getString(C25738R.string.ay1);
        }
        if (!C1855t.m3916nB(this.ldh.field_username)) {
            c44273l.mo70049a(5, string, (int) C1318a.bottomsheet_icon_blacklist);
        }
        if (!C1855t.m3916nB(this.ldh.field_username) && C7486a.m12942jh(this.ldh.field_type)) {
            c44273l.mo70063ax(9, C25738R.string.a9n, C1318a.bottomsheet_icon_complain);
        }
        if (C7486a.m12942jh(this.ldh.field_type)) {
            c44273l.mo70063ax(7, C25738R.string.atv, C1318a.bottomsheet_icon_desktop);
        }
        if (C7486a.m12942jh(this.ldh.field_type) && !C1855t.m3916nB(this.ldh.field_username)) {
            c44273l.mo70063ax(6, C25738R.string.a6f, C1318a.bottomsheet_icon_del);
        }
        AppMethodBeat.m2505o(23267);
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        AppMethodBeat.m2504i(23268);
        switch (menuItem.getItemId()) {
            case 1:
                if (C7486a.m12942jh(this.ldh.field_type)) {
                    Intent intent = new Intent();
                    intent.putExtra("Contact_Scene", this.gwP);
                    intent.putExtra("Contact_User", this.ldh.field_username);
                    intent.putExtra("Contact_RoomNickname", this.knn.getIntent().getStringExtra("Contact_RoomNickname"));
                    intent.putExtra("contact_phone_number_list", this.ldh.dur);
                    String str = "";
                    if (!this.ldh.mo16703Of()) {
                        C18817a c18817a = null;
                        String stringExtra = this.knn.getIntent().getStringExtra("Contact_Mobile_MD5");
                        String stringExtra2 = this.knn.getIntent().getStringExtra("Contact_full_Mobile_MD5");
                        if (C5046bo.isNullOrNil(stringExtra) && C5046bo.isNullOrNil(stringExtra2)) {
                            if (!C5046bo.isNullOrNil(this.ldh.field_username)) {
                                c18817a = C32923a.getAddrUploadStg().mo34089vT(this.ldh.field_username);
                            }
                        } else if (!(C5046bo.isNullOrNil(stringExtra) && C5046bo.isNullOrNil(stringExtra2))) {
                            c18817a = C32923a.getAddrUploadStg().mo34092vW(stringExtra);
                            if (c18817a == null || C5046bo.isNullOrNil(c18817a.mo34067Aq())) {
                                c18817a = C32923a.getAddrUploadStg().mo34092vW(stringExtra2);
                            }
                        }
                        if (!(c18817a == null || C5046bo.isNullOrNil(c18817a.mo34067Aq()))) {
                            str = C5046bo.nullAsNil(c18817a.apG()).replace(" ", "");
                        }
                    }
                    intent.putExtra("contact_phone_number_by_md5", str);
                    C39503b.gkE.mo38928m(intent, this.knn);
                    AppMethodBeat.m2505o(23268);
                    return;
                } else if (C5046bo.isNullOrNil(this.ldh.field_username)) {
                    C4990ab.m7420w("MicroMsg.ProfileMenuManager", "mod stranger remark, username is null");
                    AppMethodBeat.m2505o(23268);
                    return;
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_Scene", this.gwP);
                    intent2.putExtra("Contact_mode_name_type", 0);
                    intent2.putExtra("Contact_ModStrangerRemark", true);
                    intent2.putExtra("Contact_User", this.ldh.field_username);
                    intent2.putExtra("Contact_Nick", this.ldh.field_nickname);
                    intent2.putExtra("Contact_RemarkName", this.ldh.field_conRemark);
                    C39503b.gkE.mo38929n(intent2, this.knn);
                    AppMethodBeat.m2505o(23268);
                    return;
                }
            case 2:
                if (this.ldh.mo16700Oc()) {
                    C1855t.m3914n(this.ldh);
                    C30379h.m48465bQ(this.knn, this.knn.getString(C25738R.string.b20));
                } else {
                    C1855t.m3899m(this.ldh);
                    C30379h.m48465bQ(this.knn, this.knn.getString(C25738R.string.aw6));
                }
                C9638aw.m17190ZK();
                this.ldh = C18628c.m29078XM().aoO(this.ldh.field_username);
                AppMethodBeat.m2505o(23268);
                return;
            case 3:
                cas();
                AppMethodBeat.m2505o(23268);
                return;
            case 4:
                caw();
                AppMethodBeat.m2505o(23268);
                return;
            case 5:
                mo68929jL(true);
                AppMethodBeat.m2505o(23268);
                return;
            case 6:
                cav();
                AppMethodBeat.m2505o(23268);
                return;
            case 7:
                C4990ab.m7410d("MicroMsg.ProfileMenuManager", "dealAddShortcut, username = " + this.ldh.field_username);
                C42781b.m75863aa(this.knn, this.ldh.field_username);
                C42781b.m75859Z(this.knn, this.ldh.field_username);
                AppMethodBeat.m2505o(23268);
                return;
            case 9:
                cax();
                break;
        }
        AppMethodBeat.m2505o(23268);
    }

    public final void cas() {
        AppMethodBeat.m2504i(23269);
        Intent intent = new Intent(this.knn, PermissionSettingUI.class);
        intent.putExtra("sns_permission_userName", this.ldh.field_username);
        intent.putExtra("sns_permission_anim", true);
        intent.putExtra("sns_permission_block_scene", 1);
        this.knn.startActivity(intent);
        AppMethodBeat.m2505o(23269);
    }

    /* renamed from: jL */
    public final void mo68929jL(boolean z) {
        AppMethodBeat.m2504i(23270);
        if (this.ldh.mo16698Oa()) {
            cau();
            AppMethodBeat.m2505o(23270);
            return;
        }
        View inflate = View.inflate(this.knn, 2130970090, null);
        inflate.setPadding(0, 0, 0, 0);
        TextView textView = (TextView) inflate.findViewById(2131825969);
        textView.setPadding(0, 0, 0, 0);
        textView.setText(C7616ad.aox(this.ldh.field_username) ? C25738R.string.ay3 : C25738R.string.ay2);
        final CheckBox checkBox = (CheckBox) inflate.findViewById(2131825970);
        checkBox.setChecked(false);
        textView = (TextView) inflate.findViewById(2131825971);
        textView.setText(C25738R.string.ay4);
        if (this.ldh.getSource() == 18) {
            checkBox.setVisibility(0);
            textView.setVisibility(0);
        } else {
            checkBox.setVisibility(8);
            textView.setVisibility(8);
        }
        if (z) {
            C30379h.m48451a(this.knn, true, this.knn.getString(C25738R.string.ay1), inflate, this.knn.getString(C25738R.string.f9187s6), this.knn.getString(C25738R.string.f9076or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(23257);
                    C43387b.m77409a(C43387b.this);
                    if (C43387b.this.ldh.getSource() == 18) {
                        C43387b.this.gwP = 9;
                        if (checkBox.isChecked()) {
                            C43387b.this.cax();
                        }
                    }
                    AppMethodBeat.m2505o(23257);
                }
            }, null);
            AppMethodBeat.m2505o(23270);
            return;
        }
        cat();
        AppMethodBeat.m2505o(23270);
    }

    private void cat() {
        AppMethodBeat.m2504i(23271);
        C1855t.m3893i(this.ldh);
        this.ldh.mo16678ND();
        AppMethodBeat.m2505o(23271);
    }

    private void cau() {
        AppMethodBeat.m2504i(23272);
        C1855t.m3894j(this.ldh);
        this.ldh.mo16679NE();
        AppMethodBeat.m2505o(23272);
    }

    public final void cav() {
        CharSequence string;
        AppMethodBeat.m2504i(23273);
        View inflate = View.inflate(this.knn, 2130970090, null);
        inflate.setPadding(0, 0, 0, 0);
        TextView textView = (TextView) inflate.findViewById(2131825969);
        textView.setPadding(0, 0, 0, 0);
        if (C1855t.m3910mW(this.ldh.field_username)) {
            string = this.knn.getString(C25738R.string.b4w, new Object[]{this.ldh.mo16707Oj()});
        } else {
            string = this.knn.getString(C25738R.string.b4u, new Object[]{this.ldh.mo16707Oj()});
        }
        textView.setText(string);
        final CheckBox checkBox = (CheckBox) inflate.findViewById(2131825970);
        checkBox.setChecked(false);
        textView = (TextView) inflate.findViewById(2131825971);
        textView.setText(C25738R.string.ay4);
        if (this.ldh.getSource() == 18) {
            checkBox.setVisibility(0);
            textView.setVisibility(0);
        } else {
            checkBox.setVisibility(8);
            textView.setVisibility(8);
        }
        C30379h.m48452a(this.knn, true, this.knn.getString(C25738R.string.avj), inflate, this.knn.getString(C25738R.string.f9088p4), this.knn.getString(C25738R.string.f9076or), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(23258);
                C43387b.m77414d(C43387b.this);
                if (C43387b.this.ldh.getSource() == 18) {
                    C43387b.this.gwP = 9;
                    if (checkBox.isChecked()) {
                        C43387b.this.cax();
                    }
                }
                AppMethodBeat.m2505o(23258);
            }
        }, null, (int) C25738R.color.f11717ei);
        AppMethodBeat.m2505o(23273);
    }

    /* renamed from: zq */
    private void m77417zq(String str) {
        AppMethodBeat.m2504i(23274);
        int intExtra = this.knn.getIntent().getIntExtra("Kdel_from", -1);
        this.ldh.mo16677NC();
        this.ldh.setSource(0);
        if (C7616ad.aox(str)) {
            ((C37974a) C1720g.m3528K(C37974a.class)).mo60749ve(str);
        } else {
            C9638aw.m17190ZK();
            C18628c.m29077XL().mo7920c(new C37498c(str));
        }
        C1829bf.m3741a(str, new C214526());
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo15724b(str, this.ldh);
        C9638aw.m17190ZK();
        C18628c.m29083XR().aoX(str);
        C37512c.m63302e(0, str);
        C37512c.m63302e(0, this.ldh.field_encryptUsername);
        switch (this.gwP) {
            case 10:
                C26529w.m42351J(this.knn, str);
                break;
            case 13:
                C18817a vT = C32923a.getAddrUploadStg().mo34089vT(str);
                if (!(vT == null || C5046bo.isNullOrNil(vT.guM))) {
                    vT.status = 1;
                    C32923a.getAddrUploadStg().mo34084a(vT.mo34067Aq(), vT);
                }
                C26529w.m42351J(this.knn, str);
                break;
        }
        if (this.gwP == 9) {
            C4990ab.m7416i("MicroMsg.ProfileMenuManager", "add scene unkown, check the contact getsource: " + this.ldh.getSource());
            switch (this.ldh.getSource()) {
                case 10:
                case 13:
                    C4990ab.m7416i("MicroMsg.ProfileMenuManager", "delete the system contact info added by wechat");
                    C26529w.m42351J(this.knn, str);
                    break;
            }
        }
        if (intExtra == 0) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            C39503b.gkE.mo38931p(intent, this.knn);
            AppMethodBeat.m2505o(23274);
            return;
        }
        this.knn.setResult(-1, this.knn.getIntent().putExtra("_delete_ok_", true));
        this.knn.finish();
        AppMethodBeat.m2505o(23274);
    }

    public final void caw() {
        AppMethodBeat.m2504i(23275);
        Intent intent = new Intent();
        intent.putExtra("Select_Talker_Name", this.ldh.field_username);
        intent.putExtra("Select_block_List", this.ldh.field_username);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("Select_Send_Card", true);
        intent.putExtra("mutil_select_is_ret", true);
        C39503b.gkE.mo38898a(intent, new C286817(), this.knn);
        AppMethodBeat.m2505o(23275);
    }

    public final void cax() {
        int i = 7;
        AppMethodBeat.m2504i(23276);
        Intent intent = new Intent();
        switch (this.gwP) {
            case 1:
            case 2:
            case 3:
            case 12:
            case 13:
            case C42464aa.CTRL_INDEX /*58*/:
            case C2206au.CTRL_INDEX /*59*/:
            case 60:
                intent.putExtra("k_outside_expose_proof_item_list", C25860a.m41170z(45, this.ldh.field_username));
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
                intent.putStringArrayListExtra("k_outside_expose_proof_item_list", C25860a.m41167tS(this.ldh.field_username));
                break;
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
            case 29:
                i = this.pkC ? 4 : 3;
                intent.putStringArrayListExtra("k_outside_expose_proof_item_list", C25860a.m41168tT(this.ldh.field_username));
                break;
            case 25:
                i = this.pkC ? 6 : 5;
                if (!this.pkC) {
                    String str;
                    String str2 = "k_outside_expose_proof_item_list";
                    if (C5046bo.isNullOrNil(this.ldh.xXc)) {
                        str = this.ldh.field_username;
                    } else {
                        str = this.ldh.xXc;
                    }
                    intent.putExtra(str2, C25860a.m41169tU(str));
                    break;
                }
                intent.putExtra("k_outside_expose_proof_item_list", C25860a.m41170z(i, this.ldh.field_username));
                break;
            case 30:
                intent.putStringArrayListExtra("k_outside_expose_proof_item_list", C25860a.m41170z(7, this.ldh.field_username));
                break;
            default:
                i = 999;
                break;
        }
        intent.putExtra("k_username", this.ldh.field_username);
        intent.putExtra("showShare", false);
        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(i)}));
        C25985d.m41467b(this.knn, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(23276);
    }

    /* renamed from: a */
    public static void m77408a(Activity activity, C7616ad c7616ad) {
        AppMethodBeat.m2504i(23277);
        Intent intent = new Intent();
        intent.setClass(activity, ContactMoreInfoUI.class);
        intent.putExtra("Is_RoomOwner", activity.getIntent().getBooleanExtra("Is_RoomOwner", false));
        intent.putExtra("Contact_User", c7616ad.field_username);
        String stringExtra = activity.getIntent().getStringExtra("room_name");
        if (stringExtra == null) {
            stringExtra = activity.getIntent().getStringExtra("Contact_ChatRoomId");
        }
        intent.putExtra("Contact_ChatRoomId", stringExtra);
        stringExtra = C5046bo.m7532bc(activity.getIntent().getStringExtra("verify_gmail"), "");
        String bc = C5046bo.m7532bc(activity.getIntent().getStringExtra("profileName"), C5046bo.anu(stringExtra));
        intent.putExtra("verify_gmail", stringExtra);
        intent.putExtra("profileName", bc);
        long longExtra = activity.getIntent().getLongExtra("Contact_Uin", 0);
        stringExtra = activity.getIntent().getStringExtra("Contact_QQNick");
        intent.putExtra("Contact_Uin", longExtra);
        intent.putExtra("Contact_QQNick", stringExtra);
        activity.startActivity(intent);
        AppMethodBeat.m2505o(23277);
    }

    /* renamed from: d */
    static /* synthetic */ void m77414d(C43387b c43387b) {
        AppMethodBeat.m2504i(23279);
        C7060h.pYm.mo8381e(14553, Integer.valueOf(2), Integer.valueOf(2), c43387b.ldh.field_username);
        final String str = c43387b.ldh.field_username;
        if (C1855t.m3910mW(str)) {
            c43387b.ldh.mo16677NC();
            C9638aw.m17190ZK();
            C18628c.m29077XL().mo7920c(new C37498c(str));
            C9638aw.m17190ZK();
            C18628c.m29078XM().aoU(str);
            C9638aw.m17190ZK();
            C18628c.m29087XV().mo14891og(str);
            AppMethodBeat.m2505o(23279);
            return;
        }
        String str2;
        c43387b.isDeleteCancel = false;
        Context context = c43387b.knn;
        c43387b.knn.getString(C25738R.string.f9238tz);
        final C44275p b = C30379h.m48458b(context, c43387b.knn.getString(C25738R.string.f9260un), true, new C433843());
        if (c43387b.isDeleteCancel) {
            str2 = null;
        } else {
            str2 = C40492e.akq(c43387b.ldh.field_username);
        }
        if (C5046bo.isNullOrNil(str2)) {
            c43387b.m77417zq(str);
            AppMethodBeat.m2505o(23279);
            return;
        }
        b.dismiss();
        C30379h.m48454a(c43387b.knn, false, c43387b.knn.getString(C25738R.string.fe9, new Object[]{str2}), null, c43387b.knn.getString(C25738R.string.c9y), c43387b.knn.getString(C25738R.string.b57), new C433854(), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(23261);
                C7060h.pYm.mo8381e(14553, Integer.valueOf(2), Integer.valueOf(3), C43387b.this.ldh.field_username);
                b.show();
                C43387b.this.isDeleteCancel = false;
                C43387b.m77410a(C43387b.this, str);
                AppMethodBeat.m2505o(23261);
            }
        }, -1, C25738R.color.f11717ei);
        AppMethodBeat.m2505o(23279);
    }
}
