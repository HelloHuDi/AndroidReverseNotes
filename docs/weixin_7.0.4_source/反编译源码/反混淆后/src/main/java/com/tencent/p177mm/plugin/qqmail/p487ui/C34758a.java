package com.tencent.p177mm.plugin.qqmail.p487ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p201az.C6335k;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.qqmail.p1618a.C43401a;
import com.tencent.p177mm.plugin.qqmail.p486b.C12884ac;
import com.tencent.p177mm.plugin.qqmail.p486b.C28744t;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.pluginsdk.p597ui.preference.HelperHeaderPreference;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.qqmail.ui.a */
public final class C34758a implements C1202f, C23233a, C4937b {
    private static boolean pxC = false;
    private Context context;
    private ProgressDialog ehJ;
    private C15541f ehK;
    private C7616ad ehM;
    private boolean enable;
    private ProgressDialog fsh;
    private boolean pli;
    private boolean pxB;

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.a$1 */
    class C347561 implements OnClickListener {
        C347561() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(68261);
            C12884ac.ccE();
            AppMethodBeat.m2505o(68261);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.a$2 */
    class C347572 implements OnClickListener {
        C347572() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(68262);
            C43401a.gkE.mo38921g(null, C34758a.this.context);
            AppMethodBeat.m2505o(68262);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.a$3 */
    class C347593 implements OnClickListener {
        C347593() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(68263);
            C34758a.m57093b(C34758a.this);
            AppMethodBeat.m2505o(68263);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m57093b(C34758a c34758a) {
        AppMethodBeat.m2504i(68276);
        c34758a.m57094jX(false);
        AppMethodBeat.m2505o(68276);
    }

    public C34758a(Context context) {
        AppMethodBeat.m2504i(68267);
        Assert.assertTrue(context != null);
        this.context = context;
        AppMethodBeat.m2505o(68267);
    }

    /* renamed from: IO */
    public final boolean mo7077IO(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(68268);
        C4990ab.m7410d("MicroMsg.ContactWidgetQQMail", "handleEvent : key = ".concat(String.valueOf(str)));
        Intent intent;
        if (C5046bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.m2505o(68268);
            return false;
        } else if (str.equals("contact_info_qqmailhelper_view")) {
            intent = new Intent();
            if (this.pli) {
                intent.putExtra("Chat_User", this.ehM.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                ((Activity) this.context).setResult(-1, intent);
            } else {
                intent.putExtra("Chat_User", this.ehM.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                C43401a.gkE.mo38915d(intent, this.context);
            }
            ((Activity) this.context).finish();
            AppMethodBeat.m2505o(68268);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_compose")) {
            intent = new Intent(this.context, ComposeUI.class);
            if (this.pli) {
                intent.putExtra("Chat_User", this.ehM.field_username);
                intent.addFlags(67108864);
                ((Activity) this.context).setResult(-1, intent);
            } else {
                intent.putExtra("Chat_User", this.ehM.field_username);
                intent.addFlags(67108864);
                this.context.startActivity(intent);
            }
            ((Activity) this.context).finish();
            AppMethodBeat.m2505o(68268);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_set_files_view")) {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(29, null))));
            intent2.putExtra("title", this.context.getString(C25738R.string.ayx));
            intent2.putExtra("zoom", false);
            intent2.putExtra("show_bottom", false);
            intent2.putExtra("showShare", false);
            intent2.putExtra("vertical_scroll", false);
            C43401a.gkE.mo38924i(intent2, this.context);
            AppMethodBeat.m2505o(68268);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_recv_remind")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO(str);
            boolean isChecked = checkBoxPreference.isChecked();
            m57095jY(isChecked);
            if (!isChecked) {
                z = true;
            }
            checkBoxPreference.uOT = z;
            AppMethodBeat.m2505o(68268);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_clear_data")) {
            C30379h.m48440a(this.context, this.context.getString(C25738R.string.ava), "", new C347561(), null);
            AppMethodBeat.m2505o(68268);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_install")) {
            if (C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(9, null)) == 0) {
                C30379h.m48459b(this.context, (int) C25738R.string.ed5, new C347572(), null);
                AppMethodBeat.m2505o(68268);
                return true;
            }
            m57094jX(true);
            AppMethodBeat.m2505o(68268);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_uninstall")) {
            C30379h.m48466d(this.context, this.context.getString(C25738R.string.e_g), "", this.context.getString(C25738R.string.f9078ou), this.context.getString(C25738R.string.f9076or), new C347593(), null);
            AppMethodBeat.m2505o(68268);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.ContactWidgetQQMail", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(68268);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo7078a(C15541f c15541f, C7616ad c7616ad, boolean z, int i) {
        boolean z2 = false;
        AppMethodBeat.m2504i(68269);
        Assert.assertTrue(c15541f != null);
        if (c7616ad != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(C1855t.m3934nc(c7616ad.field_username));
        C1720g.m3536RP().mo5239Ry().mo10118a(this);
        C1720g.m3535RO().eJo.mo14539a(24, (C1202f) this);
        this.pli = z;
        this.ehM = c7616ad;
        this.ehK = c15541f;
        c15541f.addPreferencesFromResource(C25738R.xml.f8491a8);
        biW();
        AppMethodBeat.m2505o(68269);
        return true;
    }

    private void biW() {
        boolean z;
        int i;
        boolean z2 = true;
        AppMethodBeat.m2504i(68270);
        this.enable = (C1853r.m3829YK() & 1) == 0;
        if (C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(17, null)) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.pxB = z;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper");
        helperHeaderPreference.mo74731ay(this.ehM.field_username, this.ehM.mo16707Oj(), this.context.getString(C25738R.string.ayy));
        if (this.enable) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.mo74732sd(i);
        this.ehK.mo27715ce("contact_info_qqmailhelper_install", this.enable);
        C15541f c15541f = this.ehK;
        String str = "contact_info_qqmailhelper_view";
        if (this.enable) {
            z = false;
        } else {
            z = true;
        }
        c15541f.mo27715ce(str, z);
        c15541f = this.ehK;
        str = "contact_info_qqmailhelper_compose";
        if (this.enable) {
            z = false;
        } else {
            z = true;
        }
        c15541f.mo27715ce(str, z);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_qqmailhelper_recv_remind");
        if (checkBoxPreference != null) {
            checkBoxPreference.uOT = this.pxB;
        }
        c15541f = this.ehK;
        str = "contact_info_qqmailhelper_recv_remind";
        if (this.enable) {
            z = false;
        } else {
            z = true;
        }
        c15541f.mo27715ce(str, z);
        c15541f = this.ehK;
        str = "contact_info_qqmailhelper_set_files_view";
        if ((this.enable & this.pxB) == 0) {
            z = true;
        } else {
            z = false;
        }
        c15541f.mo27715ce(str, z);
        this.ehK.mo27715ce("contact_info_qqmailhelper_download_mgr_view", true);
        c15541f = this.ehK;
        str = "contact_info_qqmailhelper_clear_data";
        if (this.enable) {
            z = false;
        } else {
            z = true;
        }
        c15541f.mo27715ce(str, z);
        C15541f c15541f2 = this.ehK;
        String str2 = "contact_info_qqmailhelper_uninstall";
        if (this.enable) {
            z2 = false;
        }
        c15541f2.mo27715ce(str2, z2);
        AppMethodBeat.m2505o(68270);
    }

    /* renamed from: jX */
    private void m57094jX(boolean z) {
        AppMethodBeat.m2504i(68271);
        String string = z ? this.context.getString(C25738R.string.e_c) : this.context.getString(C25738R.string.e_k);
        Context context = this.context;
        this.context.getString(C25738R.string.f9238tz);
        this.fsh = C30379h.m48458b(context, string, true, null);
        pxC = true;
        m57095jY(z);
        AppMethodBeat.m2505o(68271);
    }

    public final boolean biV() {
        AppMethodBeat.m2504i(68272);
        C1720g.m3536RP().mo5239Ry().mo10121b(this);
        C1720g.m3535RO().eJo.mo14546b(24, (C1202f) this);
        if (this.fsh != null) {
            this.fsh.dismiss();
            this.fsh = null;
        }
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        AppMethodBeat.m2505o(68272);
        return true;
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(68273);
        int g = C5046bo.m7550g(obj, 0);
        C4990ab.m7411d("MicroMsg.ContactWidgetQQMail", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(g), c7298n);
        if (c7298n != C1720g.m3536RP().mo5239Ry() || g <= 0) {
            C4990ab.m7413e("MicroMsg.ContactWidgetQQMail", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(g), c7298n);
            AppMethodBeat.m2505o(68273);
        } else if (g == 17 || g == 34 || g == 7) {
            biW();
            AppMethodBeat.m2505o(68273);
        } else {
            AppMethodBeat.m2505o(68273);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    /* renamed from: jY */
    private boolean m57095jY(boolean z) {
        AppMethodBeat.m2504i(68274);
        final C1207m c28744t = new C28744t(z, "");
        if (!pxC) {
            this.ehJ = C30379h.m48458b(this.context, this.context.getString(C25738R.string.f9260un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(68264);
                    C1720g.m3535RO().eJo.mo14547c(c28744t);
                    AppMethodBeat.m2505o(68264);
                }
            });
        }
        C1720g.m3535RO().eJo.mo14541a(c28744t, 0);
        AppMethodBeat.m2505o(68274);
        return false;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(68275);
        if (c1207m.getType() != 24) {
            C4990ab.m7420w("MicroMsg.ContactWidgetQQMail", "onSceneEnd : unExpected type = " + c1207m.getType());
            AppMethodBeat.m2505o(68275);
            return;
        }
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (this.fsh != null) {
            this.fsh.dismiss();
            this.fsh = null;
        }
        if (i == 0 && i2 == 0) {
            boolean z = ((C28744t) c1207m).cPT;
            C1720g.m3536RP().mo5239Ry().set(17, Integer.valueOf(z ? 1 : 2));
            if (pxC && C5046bo.m7544cv(this.context)) {
                int i3;
                if (z) {
                    C1720g.m3536RP().mo5239Ry().set(17, Integer.valueOf(1));
                }
                int YK = C1853r.m3829YK();
                if (z) {
                    i3 = YK & -2;
                } else {
                    i3 = YK | 1;
                }
                C1720g.m3536RP().mo5239Ry().set(34, Integer.valueOf(i3));
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C6335k("", "", "", "", "", "", "", "", i3, "", ""));
                C43401a.gkF.mo38844BS();
                if (!z) {
                    C12884ac.ccE();
                }
            }
            pxC = false;
            AppMethodBeat.m2505o(68275);
            return;
        }
        CharSequence string;
        final boolean z2 = ((C28744t) c1207m).cPT;
        C4990ab.m7412e("MicroMsg.ContactWidgetQQMail", "NetSceneSwitchPushMail fail : errType = " + i + ", errCode = " + i2);
        if (i == 4) {
            switch (i2) {
                case -31:
                    C4990ab.m7416i("MicroMsg.ContactWidgetQQMail", "need second pass");
                    View inflate = View.inflate(this.context, 2130970575, null);
                    final EditText editText = (EditText) inflate.findViewById(2131827286);
                    C30379h.m48435a(this.context, this.context.getString(C25738R.string.ayw), inflate, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(68266);
                            final C1207m c28744t = new C28744t(z2, C1178g.m2591x(editText.getText().toString().trim().getBytes()));
                            C1720g.m3535RO().eJo.mo14541a(c28744t, 0);
                            C34758a c34758a = C34758a.this;
                            Context a = C34758a.this.context;
                            C34758a.this.context.getString(C25738R.string.ayu);
                            c34758a.ehJ = C30379h.m48458b(a, C34758a.this.context.getString(C25738R.string.f9260un), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.m2504i(68265);
                                    C1720g.m3535RO().eJo.mo14547c(c28744t);
                                    AppMethodBeat.m2505o(68265);
                                }
                            });
                            AppMethodBeat.m2505o(68266);
                        }
                    });
                    AppMethodBeat.m2505o(68275);
                    return;
                case -1:
                    C4990ab.m7420w("MicroMsg.ContactWidgetQQMail", "onSceneEnd, sys err");
                    break;
                default:
                    AppMethodBeat.m2505o(68275);
                    return;
            }
        }
        if (pxC) {
            string = this.context.getString(z2 ? C25738R.string.e__ : C25738R.string.e_f);
        } else {
            string = this.context.getString(C25738R.string.f9110pr);
        }
        Toast.makeText(this.context, string, 1).show();
        pxC = false;
        AppMethodBeat.m2505o(68275);
    }
}
