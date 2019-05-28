package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p201az.C6335k;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.PreferenceCategory;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.C32923a;
import com.tencent.p177mm.plugin.account.p275ui.FacebookFriendUI;
import com.tencent.p177mm.plugin.profile.C39503b;
import com.tencent.p177mm.plugin.profile.p483ui.HelperHeaderPreference.C39507a;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.profile.ui.f */
public final class C39522f implements C23233a, C4937b {
    Context context;
    private C15541f ehK;
    private C7616ad ehM;
    private Map<String, Preference> gAX = new HashMap();
    private C39507a pmS;

    /* renamed from: com.tencent.mm.plugin.profile.ui.f$1 */
    class C395231 implements OnClickListener {
        C395231() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(23509);
            C39522f.m67538u(C39522f.this.context, false);
            AppMethodBeat.m2505o(23509);
        }
    }

    public C39522f(Context context) {
        AppMethodBeat.m2504i(23512);
        this.context = context;
        this.pmS = new C21502q(context);
        C9638aw.m17190ZK();
        C18628c.m29083XR().apb("facebookapp");
        AppMethodBeat.m2505o(23512);
    }

    /* renamed from: IO */
    public final boolean mo7077IO(String str) {
        AppMethodBeat.m2504i(23513);
        C4990ab.m7410d("MicroMsg.ContactWidgetFacebookapp", "handleEvent : key = ".concat(String.valueOf(str)));
        if (C5046bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.m2505o(23513);
            return false;
        } else if (str.equals("contact_info_facebookapp_install")) {
            C39522f.m67538u(this.context, true);
            AppMethodBeat.m2505o(23513);
            return true;
        } else if (str.equals("contact_info_facebookapp_uninstall")) {
            C30379h.m48466d(this.context, this.context.getString(C25738R.string.e_g), "", this.context.getString(C25738R.string.f9078ou), this.context.getString(C25738R.string.f9076or), new C395231(), null);
            AppMethodBeat.m2505o(23513);
            return true;
        } else if (str.equals("contact_info_facebookapp_listfriend")) {
            this.context.startActivity(new Intent(this.context, FacebookFriendUI.class));
            AppMethodBeat.m2505o(23513);
            return true;
        } else if (str.equals("contact_info_facebookapp_connect")) {
            C25985d.m41467b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
            AppMethodBeat.m2505o(23513);
            return true;
        } else if (str.equals("contact_info_facebookapp_addr")) {
            C25985d.m41467b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
            AppMethodBeat.m2505o(23513);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.ContactWidgetFacebookapp", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(23513);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo7078a(C15541f c15541f, C7616ad c7616ad, boolean z, int i) {
        boolean z2 = false;
        AppMethodBeat.m2504i(23514);
        Assert.assertTrue(c15541f != null);
        if (c7616ad != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(C1855t.m3939nh(c7616ad.field_username));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().mo10118a(this);
        this.ehM = c7616ad;
        this.ehK = c15541f;
        c15541f.addPreferencesFromResource(C25738R.xml.f8480v);
        Preference aqO = c15541f.aqO("contact_info_header_helper");
        if (aqO != null) {
            this.gAX.put("contact_info_header_helper", aqO);
        }
        aqO = c15541f.aqO("contact_info_facebookapp_listfriend");
        if (aqO != null) {
            this.gAX.put("contact_info_facebookapp_listfriend", aqO);
        }
        aqO = c15541f.aqO("contact_info_facebookapp_connect");
        if (aqO != null) {
            this.gAX.put("contact_info_facebookapp_connect", aqO);
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) c15541f.aqO("contact_info_facebookapp_cat");
        if (preferenceCategory != null) {
            this.gAX.put("contact_info_facebookapp_cat", preferenceCategory);
        }
        aqO = c15541f.aqO("contact_info_facebookapp_addr");
        if (aqO != null) {
            this.gAX.put("contact_info_facebookapp_addr", aqO);
        }
        preferenceCategory = (PreferenceCategory) c15541f.aqO("contact_info_facebookapp_cat2");
        if (preferenceCategory != null) {
            this.gAX.put("contact_info_facebookapp_cat2", preferenceCategory);
        }
        aqO = c15541f.aqO("contact_info_facebookapp_install");
        if (aqO != null) {
            this.gAX.put("contact_info_facebookapp_install", aqO);
        }
        aqO = c15541f.aqO("contact_info_facebookapp_uninstall");
        if (aqO != null) {
            this.gAX.put("contact_info_facebookapp_uninstall", aqO);
        }
        biW();
        AppMethodBeat.m2505o(23514);
        return true;
    }

    private static boolean isOpen() {
        AppMethodBeat.m2504i(23515);
        if ((C1853r.m3829YK() & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
            AppMethodBeat.m2505o(23515);
            return true;
        }
        AppMethodBeat.m2505o(23515);
        return false;
    }

    private void biW() {
        AppMethodBeat.m2504i(23516);
        this.ehK.removeAll();
        if (this.gAX.containsKey("contact_info_header_helper")) {
            HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.gAX.get("contact_info_header_helper");
            helperHeaderPreference.mo62462a(this.ehM, this.pmS);
            this.ehK.mo27713b(helperHeaderPreference);
        }
        if (this.gAX.containsKey("contact_info_facebookapp_cat")) {
            this.ehK.mo27713b((Preference) this.gAX.get("contact_info_facebookapp_cat"));
        }
        if (C39522f.isOpen()) {
            if (C1853r.m3847Za()) {
                C17950b.ahN();
                if (this.gAX.containsKey("contact_info_facebookapp_addr")) {
                    this.ehK.mo27713b((Preference) this.gAX.get("contact_info_facebookapp_addr"));
                    Preference preference = (Preference) this.gAX.get("contact_info_facebookapp_addr");
                    C9638aw.m17190ZK();
                    preference.setSummary((String) C18628c.m29072Ry().get(65826, null));
                }
            } else if (this.gAX.containsKey("contact_info_facebookapp_connect")) {
                this.ehK.mo27713b((Preference) this.gAX.get("contact_info_facebookapp_connect"));
            }
            if (this.gAX.containsKey("contact_info_facebookapp_cat2")) {
                this.ehK.mo27713b((Preference) this.gAX.get("contact_info_facebookapp_cat2"));
            }
            if (this.gAX.containsKey("contact_info_facebookapp_uninstall")) {
                this.ehK.mo27713b((Preference) this.gAX.get("contact_info_facebookapp_uninstall"));
            }
            AppMethodBeat.m2505o(23516);
            return;
        }
        if (this.gAX.containsKey("contact_info_facebookapp_install")) {
            this.ehK.mo27713b((Preference) this.gAX.get("contact_info_facebookapp_install"));
        }
        AppMethodBeat.m2505o(23516);
    }

    /* renamed from: u */
    public static void m67538u(Context context, final boolean z) {
        AppMethodBeat.m2504i(23517);
        String string = z ? context.getString(C25738R.string.e_c) : context.getString(C25738R.string.e_k);
        context.getString(C25738R.string.f9238tz);
        final C44275p b = C30379h.m48458b(context, string, true, null);
        final C395242 c395242 = new C7306ak() {
            final /* synthetic */ C46692p ooo = null;

            public final void handleMessage(Message message) {
                int i;
                AppMethodBeat.m2504i(23510);
                int YK = C1853r.m3829YK();
                if (z) {
                    i = YK & -8193;
                } else {
                    i = YK | Utility.DEFAULT_STREAM_BUFFER_SIZE;
                }
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(34, Integer.valueOf(i));
                C9638aw.m17190ZK();
                C18628c.m29077XL().mo7920c(new C6335k("", "", "", "", "", "", "", "", i, "", ""));
                if (!z) {
                    C32923a.getFacebookFrdStg().apM();
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(65828, (Object) "");
                    C9638aw.m17190ZK();
                    C18628c.m29083XR().aoX("facebookapp");
                    C9638aw.m17190ZK();
                    C18628c.m29080XO().mo15254Rh("facebookapp");
                }
                if (this.ooo != null) {
                    this.ooo.mo5248a(null, null);
                }
                AppMethodBeat.m2505o(23510);
            }
        };
        new Timer().schedule(new TimerTask() {
            public final void run() {
                AppMethodBeat.m2504i(23511);
                if (b != null) {
                    b.dismiss();
                    c395242.sendEmptyMessage(0);
                }
                AppMethodBeat.m2505o(23511);
            }
        }, 1500);
        AppMethodBeat.m2505o(23517);
    }

    public final boolean biV() {
        AppMethodBeat.m2504i(23518);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().mo10121b(this);
        this.gAX.get("contact_info_header_helper");
        C39503b.gkF.mo38844BS();
        AppMethodBeat.m2505o(23518);
        return true;
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(23519);
        int g = C5046bo.m7550g(obj, 0);
        C4990ab.m7411d("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(g), c7298n);
        C9638aw.m17190ZK();
        if (c7298n != C18628c.m29072Ry() || g <= 0) {
            C4990ab.m7413e("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(g), c7298n);
            AppMethodBeat.m2505o(23519);
        } else if (g == 40 || g == 34 || g == 65825) {
            biW();
            AppMethodBeat.m2505o(23519);
        } else {
            AppMethodBeat.m2505o(23519);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
