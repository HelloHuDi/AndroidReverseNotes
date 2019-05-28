package com.tencent.p177mm.plugin.nearby.p469ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C32782bp;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p201az.C6335k;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p840bn.C9089a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.nearby.C39456a;
import com.tencent.p177mm.plugin.nearby.p1001a.C46109c;
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

/* renamed from: com.tencent.mm.plugin.nearby.ui.a */
public final class C43342a implements C1202f, C23233a, C4937b {
    private static boolean oPT = true;
    private Context context;
    private C15541f ehK;
    private C7616ad ehM;
    private C46109c oPQ;
    private View oPR;
    private CheckBox oPS;
    private C5653c oPU = null;
    private C44275p tipDialog;

    /* renamed from: com.tencent.mm.plugin.nearby.ui.a$1 */
    class C213711 implements OnClickListener {
        C213711() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(55411);
            C43342a.m77328u(C43342a.this.context, false);
            AppMethodBeat.m2505o(55411);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.a$2 */
    class C213722 implements OnClickListener {
        C213722() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(55412);
            C1720g.m3536RP().mo5239Ry().set(4104, Boolean.valueOf(!C43342a.this.oPS.isChecked()));
            C9089a.m16479fy(C43342a.this.context);
            ((Activity) C43342a.this.context).finish();
            AppMethodBeat.m2505o(55412);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.a$4 */
    class C213744 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.nearby.ui.a$4$1 */
        class C213731 implements OnCancelListener {
            C213731() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(55413);
                C1720g.m3540Rg().mo14547c(C43342a.this.oPQ);
                AppMethodBeat.m2505o(55413);
            }
        }

        C213744() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(55414);
            C43342a.this.oPQ = new C46109c(2, 0.0f, 0.0f, 0, 0, "", "");
            C1720g.m3540Rg().mo14541a(C43342a.this.oPQ, 0);
            C43342a c43342a = C43342a.this;
            Context a = C43342a.this.context;
            C43342a.this.context.getString(C25738R.string.f9238tz);
            c43342a.tipDialog = C30379h.m48458b(a, C43342a.this.context.getString(C25738R.string.d4m), true, new C213731());
            AppMethodBeat.m2505o(55414);
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.a$3 */
    class C346173 implements OnClickListener {
        C346173() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.a$5 */
    class C433385 implements OnClickListener {
        C433385() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.a$8 */
    class C433418 implements OnClickListener {
        C433418() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public C43342a(Context context) {
        AppMethodBeat.m2504i(55417);
        this.context = context;
        this.oPR = View.inflate(context, 2130969930, null);
        this.oPS = (CheckBox) this.oPR.findViewById(2131825250);
        this.oPS.setChecked(false);
        C1720g.m3540Rg().mo14539a(148, (C1202f) this);
        AppMethodBeat.m2505o(55417);
    }

    /* renamed from: IO */
    public final boolean mo7077IO(String str) {
        AppMethodBeat.m2504i(55418);
        C4990ab.m7410d("MicroMsg.ContactWidgetLBS", "handleEvent : key = ".concat(String.valueOf(str)));
        if (C5046bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.m2505o(55418);
            return false;
        } else if (str.equals("contact_info_lbs_go_lbs")) {
            Boolean bool = (Boolean) C1720g.m3536RP().mo5239Ry().get(4103, null);
            if (bool == null || !bool.booleanValue()) {
                C25985d.m41448H(this.context, "nearby", ".ui.NearbyFriendsIntroUI");
            } else {
                C32782bp aap = C32782bp.aap();
                if (aap == null) {
                    C25985d.m41448H(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
                } else {
                    String nullAsNil = C5046bo.nullAsNil(aap.getProvince());
                    String nullAsNil2 = C5046bo.nullAsNil(aap.getCity());
                    int i = aap.dtS;
                    if (nullAsNil.equals("") || nullAsNil2.equals("") || i == 0) {
                        C25985d.m41448H(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
                    } else {
                        bool = (Boolean) C1720g.m3536RP().mo5239Ry().get(4104, null);
                        if (bool == null || !bool.booleanValue()) {
                            C9089a.m16479fy(this.context);
                            ((Activity) this.context).finish();
                        } else if (this.oPU == null) {
                            this.oPU = C30379h.m48436a(this.context, this.context.getString(C25738R.string.f9238tz), this.oPR, new C213722(), new C346173());
                        } else {
                            this.oPU.show();
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(55418);
            return true;
        } else if (str.equals("contact_info_lbs_install")) {
            C43342a.m77328u(this.context, true);
            AppMethodBeat.m2505o(55418);
            return true;
        } else if (str.equals("contact_info_lbs_clear_info")) {
            C30379h.m48432a(this.context, (int) C25738R.string.d4j, (int) C25738R.string.d4i, new C213744(), new C433385());
            AppMethodBeat.m2505o(55418);
            return true;
        } else if (str.equals("contact_info_lbs_uninstall")) {
            C30379h.m48466d(this.context, this.context.getString(C25738R.string.e_g), "", this.context.getString(C25738R.string.f9078ou), this.context.getString(C25738R.string.f9076or), new C213711(), null);
            AppMethodBeat.m2505o(55418);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.ContactWidgetLBS", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(55418);
            return false;
        }
    }

    private static boolean isOpen() {
        AppMethodBeat.m2504i(55419);
        if ((C1853r.m3829YK() & 512) == 0) {
            AppMethodBeat.m2505o(55419);
            return true;
        }
        AppMethodBeat.m2505o(55419);
        return false;
    }

    /* renamed from: a */
    public final boolean mo7078a(C15541f c15541f, C7616ad c7616ad, boolean z, int i) {
        boolean z2 = false;
        AppMethodBeat.m2504i(55420);
        Assert.assertTrue(c15541f != null);
        if (c7616ad != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(C1855t.m3944nm(c7616ad.field_username));
        C1720g.m3536RP().mo5239Ry().mo10118a(this);
        C4990ab.m7418v("MicroMsg.ContactWidgetLBS", "listener added");
        this.ehM = c7616ad;
        this.ehK = c15541f;
        oPT = true;
        c15541f.addPreferencesFromResource(C25738R.xml.f8483z);
        biW();
        AppMethodBeat.m2505o(55420);
        return true;
    }

    private void biW() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(55421);
        boolean isOpen = C43342a.isOpen();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper");
        helperHeaderPreference.mo74731ay(this.ehM.field_username, this.ehM.mo16707Oj(), this.context.getString(C25738R.string.ax1));
        helperHeaderPreference.mo74732sd(isOpen ? 1 : 0);
        this.ehK.mo27715ce("contact_info_lbs_install", isOpen);
        C15541f c15541f = this.ehK;
        String str = "contact_info_lbs_go_lbs";
        if (isOpen) {
            z = false;
        } else {
            z = true;
        }
        c15541f.mo27715ce(str, z);
        c15541f = this.ehK;
        str = "contact_info_lbs_clear_info";
        if (isOpen) {
            z = false;
        } else {
            z = true;
        }
        c15541f.mo27715ce(str, z);
        C15541f c15541f2 = this.ehK;
        String str2 = "contact_info_lbs_uninstall";
        if (isOpen) {
            z2 = false;
        }
        c15541f2.mo27715ce(str2, z2);
        AppMethodBeat.m2505o(55421);
    }

    /* renamed from: u */
    public static void m77328u(Context context, final boolean z) {
        AppMethodBeat.m2504i(55422);
        String string = z ? context.getString(C25738R.string.e_c) : context.getString(C25738R.string.e_k);
        oPT = z;
        context.getString(C25738R.string.f9238tz);
        final C44275p b = C30379h.m48458b(context, string, true, null);
        final C433396 c433396 = new C7306ak() {
            final /* synthetic */ C46692p ooo = null;

            public final void handleMessage(Message message) {
                int i;
                AppMethodBeat.m2504i(55415);
                int YK = C1853r.m3829YK();
                if (z) {
                    i = YK & -513;
                } else {
                    i = YK | 512;
                }
                C1720g.m3536RP().mo5239Ry().set(34, Integer.valueOf(i));
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C6335k("", "", "", "", "", "", "", "", i, "", ""));
                if (!z) {
                    C1720g.m3534RN().mo5159QU();
                    ((C6982j) C1720g.m3528K(C6982j.class)).bOo().axQ();
                    C1720g.m3540Rg().mo14541a(new C46109c(2, 0.0f, 0.0f, 0, 0, "", ""), 0);
                }
                if (this.ooo != null) {
                    this.ooo.mo5248a(null, null);
                }
                AppMethodBeat.m2505o(55415);
            }
        };
        new Timer().schedule(new TimerTask() {
            public final void run() {
                AppMethodBeat.m2504i(55416);
                if (b != null) {
                    b.dismiss();
                    c433396.sendEmptyMessage(0);
                }
                AppMethodBeat.m2505o(55416);
            }
        }, 1500);
        AppMethodBeat.m2505o(55422);
    }

    public final boolean biV() {
        AppMethodBeat.m2504i(55423);
        C1720g.m3536RP().mo5239Ry().mo10121b(this);
        C1720g.m3540Rg().mo14546b(148, (C1202f) this);
        C39456a.gkF.mo38844BS();
        AppMethodBeat.m2505o(55423);
        return true;
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(55424);
        int g = C5046bo.m7550g(obj, 0);
        C4990ab.m7411d("MicroMsg.ContactWidgetLBS", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(g), c7298n);
        if (c7298n != C1720g.m3536RP().mo5239Ry() || g <= 0) {
            C4990ab.m7413e("MicroMsg.ContactWidgetLBS", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(g), c7298n);
            AppMethodBeat.m2505o(55424);
        } else if (g == 40 || g == 34 || g == 7) {
            biW();
            AppMethodBeat.m2505o(55424);
        } else {
            AppMethodBeat.m2505o(55424);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(55425);
        if (this.oPQ == null && ((C46109c) c1207m).mo74036Ah() == 2) {
            AppMethodBeat.m2505o(55425);
            return;
        }
        C4990ab.m7416i("MicroMsg.ContactWidgetLBS", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (c1207m.getType() != 148) {
            AppMethodBeat.m2505o(55425);
            return;
        }
        int i3;
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (i == 0 && i2 == 0) {
            i3 = C25738R.string.d4l;
        } else {
            i3 = C25738R.string.d4k;
        }
        if (((C46109c) c1207m).mo74036Ah() == 2 && oPT) {
            C30379h.m48431a(this.context, i3, (int) C25738R.string.f9238tz, new C433418());
            this.oPQ = null;
        }
        AppMethodBeat.m2505o(55425);
    }
}
