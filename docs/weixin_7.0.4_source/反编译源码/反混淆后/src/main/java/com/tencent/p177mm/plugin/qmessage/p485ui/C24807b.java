package com.tencent.p177mm.plugin.qmessage.p485ui;

import android.app.Activity;
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
import com.tencent.p177mm.p201az.C6335k;
import com.tencent.p177mm.p201az.C9064g;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.qmessage.C46143a;
import com.tencent.p177mm.plugin.qmessage.p739a.C46142g;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.pluginsdk.p597ui.preference.HelperHeaderPreference;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.qmessage.ui.b */
public final class C24807b implements C23233a, C4937b {
    Context context;
    private C15541f ehK;
    private C7616ad ehM;
    private boolean pli;

    /* renamed from: com.tencent.mm.plugin.qmessage.ui.b$1 */
    class C36441 implements OnClickListener {
        C36441() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(24103);
            C24807b.m38751f(Utility.DEFAULT_STREAM_BUFFER_SIZE, false, 12);
            C24807b.m38751f(64, false, 5);
            AppMethodBeat.m2505o(24103);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qmessage.ui.b$3 */
    class C36453 implements OnClickListener {
        C36453() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(24105);
            C46142g.ccc();
            AppMethodBeat.m2505o(24105);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qmessage.ui.b$4 */
    class C248094 implements OnClickListener {
        C248094() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(24106);
            C25985d.m41452a(C24807b.this.context, "account", "com.tencent.mm.plugin.account.bind.ui.BindQQUI", null);
            AppMethodBeat.m2505o(24106);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qmessage.ui.b$5 */
    class C248105 implements OnClickListener {
        C248105() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.qmessage.ui.b$6 */
    class C248126 implements OnClickListener {
        C248126() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(24107);
            C24807b.m38752u(C24807b.this.context, false);
            AppMethodBeat.m2505o(24107);
        }
    }

    public C24807b(Context context) {
        this.context = context;
    }

    /* renamed from: IO */
    public final boolean mo7077IO(String str) {
        AppMethodBeat.m2504i(24110);
        C4990ab.m7410d("MicroMsg.ContactWidgetQMessage", "handleEvent : key = ".concat(String.valueOf(str)));
        if (C5046bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.m2505o(24110);
            return false;
        } else if (str.equals("contact_info_view_message")) {
            Intent intent = new Intent(this.context, QConversationUI.class);
            if (this.pli) {
                ((Activity) this.context).setResult(-1, intent);
            } else {
                this.context.startActivity(intent);
            }
            ((Activity) this.context).finish();
            AppMethodBeat.m2505o(24110);
            return true;
        } else if (str.equals("contact_info_qmessage_recv_offline_msg")) {
            final CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO(str);
            if (checkBoxPreference.isChecked()) {
                C24807b.m38751f(64, true, 5);
            } else if (C24807b.m38750Bn(Utility.DEFAULT_STREAM_BUFFER_SIZE)) {
                C30379h.m48432a(this.context, (int) C25738R.string.ayj, (int) C25738R.string.f9238tz, new C36441(), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(24104);
                        checkBoxPreference.uOT = true;
                        C24807b.this.biW();
                        AppMethodBeat.m2505o(24104);
                    }
                });
            } else {
                C24807b.m38751f(64, false, 5);
                AppMethodBeat.m2505o(24110);
                return true;
            }
            AppMethodBeat.m2505o(24110);
            return true;
        } else if (str.equals("contact_info_qmessage_display_weixin_online")) {
            C24807b.m38751f(Utility.DEFAULT_STREAM_BUFFER_SIZE, ((CheckBoxPreference) this.ehK.aqO(str)).isChecked(), 12);
            AppMethodBeat.m2505o(24110);
            return true;
        } else if (str.equals("contact_info_qmessage_clear_data")) {
            C30379h.m48466d(this.context, this.context.getString(C25738R.string.av9), "", this.context.getString(C25738R.string.f9078ou), this.context.getString(C25738R.string.f9076or), new C36453(), null);
            AppMethodBeat.m2505o(24110);
            return true;
        } else if (str.equals("contact_info_qmessage_install")) {
            C9638aw.m17190ZK();
            if (C5046bo.m7567h((Integer) C18628c.m29072Ry().get(9, null)) == 0) {
                C30379h.m48459b(this.context, (int) C25738R.string.ed5, new C248094(), new C248105());
                AppMethodBeat.m2505o(24110);
                return true;
            }
            C24807b.m38752u(this.context, true);
            AppMethodBeat.m2505o(24110);
            return true;
        } else if (str.equals("contact_info_qmessage_uninstall")) {
            C30379h.m48466d(this.context, this.context.getString(C25738R.string.e_g), "", this.context.getString(C25738R.string.f9078ou), this.context.getString(C25738R.string.f9076or), new C248126(), null);
            AppMethodBeat.m2505o(24110);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.ContactWidgetQMessage", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(24110);
            return false;
        }
    }

    /* renamed from: u */
    public static void m38752u(Context context, final boolean z) {
        AppMethodBeat.m2504i(24111);
        String string = z ? context.getString(C25738R.string.e_c) : context.getString(C25738R.string.e_k);
        context.getString(C25738R.string.f9238tz);
        final C44275p b = C30379h.m48458b(context, string, true, null);
        final C248117 c248117 = new C7306ak() {
            final /* synthetic */ C46692p ooo = null;

            public final void handleMessage(Message message) {
                int i;
                AppMethodBeat.m2504i(24108);
                C24807b.m38751f(64, z, 5);
                C24807b.m38751f(Utility.DEFAULT_STREAM_BUFFER_SIZE, z, 12);
                int YK = C1853r.m3829YK();
                if (z) {
                    i = YK & -33;
                } else {
                    i = YK | 32;
                }
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(34, Integer.valueOf(i));
                C9638aw.m17190ZK();
                C18628c.m29077XL().mo7920c(new C6335k("", "", "", "", "", "", "", "", i, "", ""));
                if (!z) {
                    C46142g.ccc();
                }
                if (this.ooo != null) {
                    this.ooo.mo5248a(null, null);
                }
                AppMethodBeat.m2505o(24108);
            }
        };
        new Timer().schedule(new TimerTask() {
            public final void run() {
                AppMethodBeat.m2504i(24109);
                if (b != null) {
                    b.dismiss();
                    c248117.sendEmptyMessage(0);
                }
                AppMethodBeat.m2505o(24109);
            }
        }, 5000);
        AppMethodBeat.m2505o(24111);
    }

    private static boolean isOpen() {
        AppMethodBeat.m2504i(24112);
        if ((C1853r.m3829YK() & 32) == 0) {
            AppMethodBeat.m2505o(24112);
            return true;
        }
        AppMethodBeat.m2505o(24112);
        return false;
    }

    /* renamed from: Bn */
    private static boolean m38750Bn(int i) {
        AppMethodBeat.m2504i(24113);
        if ((C1853r.m3822YD() & i) != 0) {
            AppMethodBeat.m2505o(24113);
            return true;
        }
        AppMethodBeat.m2505o(24113);
        return false;
    }

    /* renamed from: a */
    public final boolean mo7078a(C15541f c15541f, C7616ad c7616ad, boolean z, int i) {
        boolean z2;
        boolean z3 = false;
        AppMethodBeat.m2504i(24114);
        if (c7616ad != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(C1855t.m3938ng(c7616ad.field_username));
        if (c15541f != null) {
            z3 = true;
        }
        Assert.assertTrue(z3);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().mo10118a(this);
        this.ehM = c7616ad;
        this.pli = z;
        this.ehK = c15541f;
        biW();
        AppMethodBeat.m2505o(24114);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void biW() {
        AppMethodBeat.m2504i(24115);
        boolean isOpen = C24807b.isOpen();
        boolean Bn = C24807b.m38750Bn(64);
        C24807b.m38750Bn(Utility.DEFAULT_STREAM_BUFFER_SIZE);
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(C25738R.xml.f8490a6);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper");
        helperHeaderPreference.mo74731ay(this.ehM.field_username, this.ehM.mo16707Oj(), this.context.getString(C25738R.string.aym));
        helperHeaderPreference.mo74732sd(isOpen ? 1 : 0);
        if (isOpen) {
            this.ehK.aqP("contact_info_qmessage_install");
            ((CheckBoxPreference) this.ehK.aqO("contact_info_qmessage_recv_offline_msg")).uOT = Bn;
            AppMethodBeat.m2505o(24115);
            return;
        }
        this.ehK.aqP("contact_info_view_message");
        this.ehK.aqP("contact_info_qmessage_recv_offline_msg");
        this.ehK.aqP("contact_info_qmessage_uninstall");
        this.ehK.aqP("contact_info_qmessage_clear_data");
        AppMethodBeat.m2505o(24115);
    }

    /* renamed from: f */
    static void m38751f(int i, boolean z, int i2) {
        AppMethodBeat.m2504i(24116);
        int YD = C1853r.m3822YD();
        if (z) {
            YD |= i;
        } else {
            YD &= i ^ -1;
        }
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(7, Integer.valueOf(YD));
        YD = z ? 1 : 2;
        C9638aw.m17190ZK();
        C18628c.m29077XL().mo7920c(new C9064g(i2, YD));
        AppMethodBeat.m2505o(24116);
    }

    public final boolean biV() {
        AppMethodBeat.m2504i(24117);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().mo10121b(this);
        C46143a.psH.mo38844BS();
        AppMethodBeat.m2505o(24117);
        return true;
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(24118);
        C9638aw.m17190ZK();
        if (c7298n != C18628c.m29072Ry()) {
            AppMethodBeat.m2505o(24118);
            return;
        }
        biW();
        AppMethodBeat.m2505o(24118);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
