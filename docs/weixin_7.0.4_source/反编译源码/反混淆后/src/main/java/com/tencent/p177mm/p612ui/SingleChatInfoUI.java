package com.tencent.p177mm.p612ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1827a;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelmulti.C18668n;
import com.tencent.p177mm.p203bg.C32335a;
import com.tencent.p177mm.p203bg.C32337g;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.C40675h;
import com.tencent.p177mm.p612ui.base.preference.C41341a;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.p612ui.contact.C36249e;
import com.tencent.p177mm.p612ui.contact.SelectContactUI;
import com.tencent.p177mm.p612ui.p1347g.C40871a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.forcenotify.p1262a.C20772b;
import com.tencent.p177mm.plugin.forcenotify.p1262a.C28062a;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.C14943d;
import com.tencent.p177mm.pluginsdk.p597ui.applet.ContactListExpandPreference;
import com.tencent.p177mm.pluginsdk.p597ui.applet.ContactListExpandPreference.C30100a;
import com.tencent.p177mm.pluginsdk.wallet.C40492e;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7575bv;
import com.tencent.p177mm.storage.C7616ad;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

@C18524i
/* renamed from: com.tencent.mm.ui.SingleChatInfoUI */
public class SingleChatInfoUI extends MMPreference implements C32335a {
    private static boolean isDeleteCancel = false;
    private C15541f ehK;
    private C7616ad ehM;
    private ContactListExpandPreference ehS;
    private CheckBoxPreference ehT;
    private CheckBoxPreference ehV;
    private SharedPreferences ehZ = null;
    private boolean eif;
    private int eii = -1;
    private boolean eik = false;
    private C14943d ein = new C14943d(new C406561());
    boolean eio = false;
    private String eis = "";
    private C7306ak handler = new C7306ak(Looper.getMainLooper());
    private String talker;
    private CheckBoxPreference yqk;
    private C4931a yql = new C406543();

    /* renamed from: com.tencent.mm.ui.SingleChatInfoUI$7 */
    class C154807 implements OnClickListener {
        C154807() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(29874);
            C7060h.pYm.mo8381e(14553, Integer.valueOf(6), Integer.valueOf(4), SingleChatInfoUI.this.talker);
            SingleChatInfoUI.isDeleteCancel = true;
            if (SingleChatInfoUI.this.eik) {
                SingleChatInfoUI.this.finish();
                AppMethodBeat.m2505o(29874);
                return;
            }
            LauncherUI instance = LauncherUI.getInstance();
            if (instance != null) {
                instance.startChatting(SingleChatInfoUI.this.ehM.field_username, null, true);
            }
            AppMethodBeat.m2505o(29874);
        }
    }

    /* renamed from: com.tencent.mm.ui.SingleChatInfoUI$5 */
    class C303525 implements C30100a {
        C303525() {
        }

        /* renamed from: iA */
        public final void mo14654iA(int i) {
        }

        /* renamed from: iB */
        public final void mo14655iB(int i) {
            AppMethodBeat.m2504i(29870);
            String KX = SingleChatInfoUI.this.ehS.mo48351KX(i);
            String nullAsNil = C42252ah.nullAsNil(SingleChatInfoUI.this.ehS.mo48353KZ(i));
            if (C42252ah.isNullOrNil(nullAsNil)) {
                C9638aw.m17190ZK();
                C7575bv RB = C18628c.m29079XN().mo15364RB(KX);
                if (!(RB == null || C42252ah.isNullOrNil(RB.field_encryptUsername))) {
                    nullAsNil = RB.field_conRemark;
                }
            }
            if (C42252ah.isNullOrNil(KX)) {
                AppMethodBeat.m2505o(29870);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_User", KX);
            intent.putExtra("Contact_RemarkName", nullAsNil);
            intent.putExtra("Contact_Nick", C42252ah.nullAsNil(SingleChatInfoUI.this.ehS.mo48352KY(i)));
            intent.putExtra("Contact_RoomMember", true);
            intent.putExtra("CONTACT_INFO_UI_SOURCE", 2);
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(KX);
            if (aoO != null && ((int) aoO.ewQ) > 0 && C7486a.m12942jh(aoO.field_type)) {
                C36249e.m59677a(intent, KX);
            }
            intent.putExtra("Kdel_from", 0);
            intent.putExtra("CONTACT_INFO_UI_SOURCE", 2);
            C25985d.m41468b(SingleChatInfoUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent, 0);
            AppMethodBeat.m2505o(29870);
        }

        /* renamed from: JT */
        public final void mo14653JT() {
            AppMethodBeat.m2504i(29871);
            if (SingleChatInfoUI.this.ehS != null) {
                SingleChatInfoUI.this.ehS.djD();
            }
            AppMethodBeat.m2505o(29871);
        }

        /* renamed from: iC */
        public final void mo14656iC(int i) {
            AppMethodBeat.m2504i(29872);
            SingleChatInfoUI.m70216d(SingleChatInfoUI.this);
            AppMethodBeat.m2505o(29872);
        }
    }

    /* renamed from: com.tencent.mm.ui.SingleChatInfoUI$6 */
    class C303536 implements OnMenuItemClickListener {
        C303536() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(29873);
            SingleChatInfoUI.this.finish();
            AppMethodBeat.m2505o(29873);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.SingleChatInfoUI$a */
    static class C36035a implements OnCancelListener {
        private C36035a() {
        }

        /* synthetic */ C36035a(byte b) {
            this();
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(29879);
            SingleChatInfoUI.isDeleteCancel = true;
            AppMethodBeat.m2505o(29879);
        }
    }

    /* renamed from: com.tencent.mm.ui.SingleChatInfoUI$2 */
    class C406512 implements Runnable {
        C406512() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29867);
            C18668n.ahW().mo44216lN(7);
            AppMethodBeat.m2505o(29867);
        }
    }

    /* renamed from: com.tencent.mm.ui.SingleChatInfoUI$10 */
    class C4065310 implements OnClickListener {
        C4065310() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(29878);
            SingleChatInfoUI.m70220h(SingleChatInfoUI.this);
            AppMethodBeat.m2505o(29878);
        }
    }

    /* renamed from: com.tencent.mm.ui.SingleChatInfoUI$3 */
    class C406543 implements C4931a {
        C406543() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(29868);
            SingleChatInfoUI.m70211a(SingleChatInfoUI.this);
            AppMethodBeat.m2505o(29868);
        }
    }

    /* renamed from: com.tencent.mm.ui.SingleChatInfoUI$1 */
    class C406561 implements OnScrollListener {
        C406561() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SingleChatInfoUI() {
        AppMethodBeat.m2504i(29880);
        AppMethodBeat.m2505o(29880);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(29881);
        super.onCreate(bundle);
        ((C20772b) C1720g.m3528K(C20772b.class)).bxV().mo10116c(this.yql);
        if (C32337g.fUs != null) {
            C32337g.fUs.mo4620a(this);
        }
        this.talker = getIntent().getStringExtra("Single_Chat_Talker");
        this.eik = getIntent().getBooleanExtra("fromChatting", false);
        this.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.talker);
        if (this.ehM == null) {
            C4990ab.m7413e("MicroMsg.SingleChatInfoUI", "contact is null! talker:%s", this.talker);
            finish();
            AppMethodBeat.m2505o(29881);
            return;
        }
        this.eis = getPackageName() + "_preferences";
        initView();
        ((C28062a) C1720g.m3528K(C28062a.class)).mo36078e(this.ehM.field_username, 3, C1839cb.aaE() / 1000);
        AppMethodBeat.m2505o(29881);
    }

    public void onResume() {
        AppMethodBeat.m2504i(29882);
        m70210JL();
        if (this.ehS != null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.talker);
            this.ehS.mo48371u(this.talker, linkedList);
        }
        dzc();
        this.ehK.notifyDataSetChanged();
        super.onResume();
        if (!this.eio) {
            String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
            if (!C42252ah.isNullOrNil(stringExtra)) {
                final int aqQ = this.ehK.aqQ(stringExtra);
                setSelection(aqQ - 3);
                new C7306ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(29869);
                        View a = ((C41341a) SingleChatInfoUI.this.ehK).mo65995a(aqQ, SingleChatInfoUI.this.nDp);
                        if (a != null) {
                            C40871a.m70821a(SingleChatInfoUI.this.mController.ylL, a);
                        }
                        AppMethodBeat.m2505o(29869);
                    }
                }, 10);
            }
            this.eio = true;
        }
        AppMethodBeat.m2505o(29882);
    }

    public void onPause() {
        AppMethodBeat.m2504i(29883);
        super.onPause();
        AppMethodBeat.m2505o(29883);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(29884);
        ((C20772b) C1720g.m3528K(C20772b.class)).bxV().mo10117d(this.yql);
        C40871a.dismiss();
        if (C32337g.fUs != null) {
            C32337g.fUs.mo4623b(this);
        }
        super.onDestroy();
        AppMethodBeat.m2505o(29884);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(29885);
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            AppMethodBeat.m2505o(29885);
            return;
        }
        switch (i) {
            case 2:
                if (i2 == -1) {
                    finish();
                    AppMethodBeat.m2505o(29885);
                    return;
                }
                AppMethodBeat.m2505o(29885);
                return;
            default:
                AppMethodBeat.m2505o(29885);
                return;
        }
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8532bg;
    }

    /* Access modifiers changed, original: protected|final */
    public final void initView() {
        AppMethodBeat.m2504i(29886);
        if (this.ehM == null) {
            C4990ab.m7412e("MicroMsg.SingleChatInfoUI", "[initView] contact is null!");
            finish();
        }
        this.ehK = this.yCw;
        setMMTitle(getString(C25738R.string.dvi));
        this.ehS = (ContactListExpandPreference) this.ehK.aqO("roominfo_contact_anchor");
        this.ehS.mo48357a(this.ehK, this.ehS.mKey);
        this.ehS.mo48368oD(true).mo48369oE(false);
        if (this.ehM != null && this.ehM.field_deleteFlag == 1) {
            this.ehS.mo48368oD(false);
        }
        if (!(C15830s.dIh() || this.ehM == null || !C7616ad.aox(this.ehM.field_username))) {
            this.ehS.mo48368oD(false);
        }
        this.ehT = (CheckBoxPreference) this.ehK.aqO("room_notify_new_msg");
        this.ehV = (CheckBoxPreference) this.ehK.aqO("room_placed_to_the_top");
        this.ehK.mo27715ce("force_notify", !C7486a.m12942jh(this.ehM.field_type));
        if (this.ehZ == null) {
            this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.ehM != null) {
            C9638aw.m17190ZK();
            this.ehZ.edit().putBoolean("room_placed_to_the_top", C18628c.m29083XR().aph(this.ehM.field_username)).commit();
            this.eif = this.ehM.mo16673DX();
            this.ehZ.edit().putBoolean("room_notify_new_msg", this.eif).commit();
        } else {
            this.ehZ.edit().putBoolean("room_notify_new_msg", false).commit();
            this.eif = false;
        }
        C9638aw.m17190ZK();
        this.eii = C18628c.m29080XO().mo15263Rq(this.talker);
        this.ehK.notifyDataSetChanged();
        if (this.ehS != null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.talker);
            this.ehS.mo48371u(this.talker, linkedList);
            this.nDp.setOnScrollListener(this.ein);
            this.ehS.mo48356a(this.ein);
            this.ehS.mo48354a(new C303525());
        }
        setBackBtn(new C303536());
        AppMethodBeat.m2505o(29886);
    }

    private void dzc() {
        int i = 0;
        AppMethodBeat.m2504i(29887);
        this.yqk = (CheckBoxPreference) this.ehK.aqO("force_notify");
        if (C7616ad.aox(this.ehM.field_username) || C1853r.m3858mG(this.ehM.field_username)) {
            this.ehK.mo27715ce("force_notify", true);
            AppMethodBeat.m2505o(29887);
            return;
        }
        long Mo = ((C20772b) C1720g.m3528K(C20772b.class)).mo36067Mo(this.ehM.field_username);
        boolean Mp = ((C20772b) C1720g.m3528K(C20772b.class)).mo36068Mp(this.ehM.field_username);
        this.yqk.uOT = Mp;
        this.yqk.mo74839qg(Mp);
        if (this.yqk.isChecked()) {
            this.yqk.setSummary((CharSequence) getResources().getString(C25738R.string.bzd, new Object[]{new SimpleDateFormat("HH:mm").format(new Date(Mo))}));
        } else {
            this.yqk.setSummary(null);
            setTitleMuteIconVisibility(this.ehM.mo16673DX() ? 0 : 8);
        }
        if (this.ehZ == null) {
            this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        this.ehZ.edit().putBoolean("force_notify", this.yqk.isChecked()).commit();
        if (!this.yqk.isChecked()) {
            i = 8;
        }
        mo17374Nd(i);
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(29887);
    }

    /* renamed from: b */
    private void m70214b(final ProgressDialog progressDialog) {
        AppMethodBeat.m2504i(29889);
        C1829bf.m3741a(this.ehM.field_username, new C1827a() {
            /* renamed from: JU */
            public final boolean mo5405JU() {
                AppMethodBeat.m2504i(29876);
                boolean cXE = SingleChatInfoUI.isDeleteCancel;
                AppMethodBeat.m2505o(29876);
                return cXE;
            }

            /* renamed from: JV */
            public final void mo5406JV() {
                AppMethodBeat.m2504i(29877);
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                AppMethodBeat.m2505o(29877);
            }
        });
        this.handler.post(new C406512());
        AppMethodBeat.m2505o(29889);
    }

    /* renamed from: JL */
    private void m70210JL() {
        AppMethodBeat.m2504i(29890);
        if (this.ehZ == null) {
            this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        this.eif = this.ehM.mo16673DX();
        if (this.eif) {
            setTitleMuteIconVisibility(0);
            if (this.ehT != null) {
                this.ehZ.edit().putBoolean("room_notify_new_msg", true).commit();
            }
        } else {
            setTitleMuteIconVisibility(8);
            if (this.ehT != null) {
                this.ehZ.edit().putBoolean("room_notify_new_msg", false).commit();
            }
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(29890);
    }

    /* renamed from: k */
    public final void mo14628k(String str, String str2, String str3) {
        AppMethodBeat.m2504i(29891);
        if (str.equals(this.talker) && this.ehS != null) {
            this.ehS.notifyChanged();
        }
        AppMethodBeat.m2505o(29891);
    }

    /* renamed from: a */
    public final C40675h mo14627a(SharedPreferences sharedPreferences) {
        AppMethodBeat.m2504i(29892);
        C41341a c41341a = new C41341a(this, this.nDp, sharedPreferences);
        AppMethodBeat.m2505o(29892);
        return c41341a;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        boolean z = true;
        AppMethodBeat.m2504i(29888);
        String str = preference.mKey;
        Intent intent;
        if (str.equals("room_notify_new_msg")) {
            if (this.eif) {
                z = false;
            }
            this.eif = z;
            if (this.eif) {
                C1855t.m3958o(this.ehM);
            } else {
                C1855t.m3959p(this.ehM);
            }
            this.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.talker);
            if (this.ehZ == null) {
                this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            this.ehZ.edit().putBoolean("room_notify_new_msg", this.eif).commit();
            m70210JL();
        } else if (str.equals("room_placed_to_the_top")) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.eis, 0);
            if (this.ehM != null) {
                C9638aw.m17190ZK();
                if (C18628c.m29083XR().aph(this.ehM.field_username)) {
                    C1855t.m3969x(this.ehM.field_username, true);
                } else {
                    C1855t.m3967w(this.ehM.field_username, true);
                }
                C9638aw.m17190ZK();
                sharedPreferences.edit().putBoolean("room_placed_to_the_top", C18628c.m29083XR().aph(this.ehM.field_username)).commit();
            }
        } else if (str.equals("force_notify")) {
            if (this.yqk.isChecked()) {
                ((C20772b) C1720g.m3528K(C20772b.class)).mo36066Mn(this.ehM.field_username);
                long Mo = ((C20772b) C1720g.m3528K(C20772b.class)).mo36067Mo(this.ehM.field_username);
                this.yqk.setSummary((CharSequence) getResources().getString(C25738R.string.bzd, new Object[]{new SimpleDateFormat("HH:mm").format(new Date(Mo))}));
            } else {
                ((C20772b) C1720g.m3528K(C20772b.class)).mo36069am(this.ehM.field_username, 3);
                this.yqk.setSummary(null);
            }
        } else if (str.equals("room_set_chatting_background")) {
            intent = new Intent();
            intent.putExtra("isApplyToAll", false);
            intent.putExtra("username", this.ehM.field_username);
            C25985d.m41468b((Context) this, "setting", ".ui.setting.SettingsChattingBackgroundUI", intent, 2);
        } else if (str.equals("room_search_chatting_content")) {
            intent = new Intent();
            intent.putExtra("detail_username", this.talker);
            C3161d.m5413c(this, ".ui.FTSChattingConvUI", intent);
            C7060h.pYm.mo8381e(14569, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        } else if (str.equals("room_clear_chatting_history")) {
            C30379h.m48444a(this.mController.ylL, getString(C25738R.string.bx1, new Object[]{this.ehM.mo16707Oj()}), "", getString(C25738R.string.f9078ou), getString(C25738R.string.f9076or), new C4065310(), null, (int) C25738R.color.f11717ei);
        } else if (str.equals("room_expose")) {
            intent = new Intent();
            intent.putExtra("k_username", this.talker);
            intent.putExtra("showShare", false);
            intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(39)}));
            C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
        } else if (str.equals("chat_app_brand")) {
            intent = new Intent();
            intent.putExtra("Chat_User", this.talker);
            C25985d.m41473f(this, ".ui.chatting.gallery.AppBrandHistoryListUI", intent);
            C7060h.pYm.mo8378a(219, 25, 1, true);
        }
        AppMethodBeat.m2505o(29888);
        return false;
    }

    /* renamed from: d */
    static /* synthetic */ void m70216d(SingleChatInfoUI singleChatInfoUI) {
        AppMethodBeat.m2504i(29894);
        C7060h.pYm.mo8374X(10170, "1");
        LinkedList linkedList = new LinkedList();
        linkedList.add(singleChatInfoUI.talker);
        linkedList.add(C1853r.m3846Yz());
        String c = C42252ah.m74611c(linkedList, ",");
        Intent intent = new Intent();
        intent.setClass(singleChatInfoUI, SelectContactUI.class);
        intent.putExtra("titile", singleChatInfoUI.getString(C25738R.string.f8781es));
        intent.putExtra("list_type", 0);
        intent.putExtra("list_attr", C15830s.znG);
        intent.putExtra("always_select_contact", c);
        intent.putExtra("scene", 2);
        singleChatInfoUI.startActivity(intent);
        AppMethodBeat.m2505o(29894);
    }

    /* renamed from: h */
    static /* synthetic */ void m70220h(SingleChatInfoUI singleChatInfoUI) {
        String str;
        AppMethodBeat.m2504i(29896);
        C7060h.pYm.mo8381e(14553, Integer.valueOf(6), Integer.valueOf(2), singleChatInfoUI.talker);
        isDeleteCancel = false;
        singleChatInfoUI.getString(C25738R.string.f9238tz);
        final ProgressDialog b = C30379h.m48458b((Context) singleChatInfoUI, singleChatInfoUI.getString(C25738R.string.f9260un), true, new C36035a());
        if (isDeleteCancel) {
            str = null;
        } else {
            str = C40492e.akq(singleChatInfoUI.ehM.field_username);
        }
        if (C42252ah.isNullOrNil(str)) {
            singleChatInfoUI.m70214b(b);
            AppMethodBeat.m2505o(29896);
            return;
        }
        b.dismiss();
        Object[] objArr = new Object[]{str};
        C30379h.m48454a(singleChatInfoUI, false, singleChatInfoUI.getString(C25738R.string.fdk, objArr), null, singleChatInfoUI.getString(C25738R.string.c9y), singleChatInfoUI.getString(C25738R.string.ar1), new C154807(), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(29875);
                C7060h.pYm.mo8381e(14553, Integer.valueOf(6), Integer.valueOf(3), SingleChatInfoUI.this.talker);
                b.show();
                SingleChatInfoUI.isDeleteCancel = false;
                SingleChatInfoUI.m70212a(SingleChatInfoUI.this, b);
                AppMethodBeat.m2505o(29875);
            }
        }, -1, C25738R.color.f11717ei);
        AppMethodBeat.m2505o(29896);
    }
}
