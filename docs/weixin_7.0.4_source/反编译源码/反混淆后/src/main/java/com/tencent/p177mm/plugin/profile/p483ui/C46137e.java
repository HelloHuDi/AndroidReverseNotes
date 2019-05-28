package com.tencent.p177mm.plugin.profile.p483ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1827a;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p201az.C9064g;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l.C38034a;
import com.tencent.p177mm.plugin.profile.C39503b;
import com.tencent.p177mm.plugin.profile.p483ui.HelperHeaderPreference.C39507a;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.profile.ui.e */
public final class C46137e implements C23233a {
    Context context;
    private C15541f ehK;
    private C7616ad ehM;
    boolean isDeleteCancel = false;
    private boolean pli;
    private C39507a pmQ;
    private int status;
    C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.profile.ui.e$1 */
    class C286951 implements OnClickListener {
        C286951() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(23502);
            C46137e c46137e = C46137e.this;
            c46137e.isDeleteCancel = false;
            Context context = c46137e.context;
            c46137e.context.getString(C25738R.string.f9238tz);
            c46137e.tipDialog = C30379h.m48458b(context, c46137e.context.getString(C25738R.string.f9260un), true, new C395202());
            C1829bf.m3741a("fmessage", new C395213());
            C9638aw.m17190ZK();
            C18628c.m29083XR().aoX("fmessage");
            AppMethodBeat.m2505o(23502);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.e$2 */
    class C395202 implements OnCancelListener {
        C395202() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            C46137e.this.isDeleteCancel = true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.e$3 */
    class C395213 implements C1827a {
        C395213() {
        }

        /* renamed from: JU */
        public final boolean mo5405JU() {
            return C46137e.this.isDeleteCancel;
        }

        /* renamed from: JV */
        public final void mo5406JV() {
            AppMethodBeat.m2504i(23503);
            if (C46137e.this.tipDialog != null) {
                C46137e.this.tipDialog.dismiss();
                C46137e.this.tipDialog = null;
            }
            AppMethodBeat.m2505o(23503);
        }
    }

    public C46137e(Context context) {
        AppMethodBeat.m2504i(23504);
        this.context = context;
        this.pmQ = new C39531o(context);
        this.status = -1;
        AppMethodBeat.m2505o(23504);
    }

    /* renamed from: IO */
    public final boolean mo7077IO(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(23505);
        C4990ab.m7410d("MicroMsg.ContactWidgetFMessage", "handlerEvent : key = ".concat(String.valueOf(str)));
        if (C5046bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.m2505o(23505);
            return false;
        } else if (str.equals("contact_info_recommend_qqfriends_to_me")) {
            boolean z2;
            if (((CheckBoxPreference) this.ehK.aqO("contact_info_recommend_qqfriends_to_me")).isChecked()) {
                z2 = false;
            } else {
                z2 = true;
            }
            m86106e(z2, 128, 6);
            AppMethodBeat.m2505o(23505);
            return true;
        } else if (str.equals("contact_info_recommend_mobilefriends_to_me")) {
            if (!((CheckBoxPreference) this.ehK.aqO("contact_info_recommend_mobilefriends_to_me")).isChecked()) {
                z = true;
            }
            m86106e(z, 256, 7);
            AppMethodBeat.m2505o(23505);
            return true;
        } else if (str.equals("contact_info_recommend_fbfriends_to_me")) {
            z = ((CheckBoxPreference) this.ehK.aqO("contact_info_recommend_fbfriends_to_me")).isChecked();
            C4990ab.m7410d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + z + " item value = 4 functionId = 18");
            int YF = C1853r.m3824YF();
            if (z) {
                YF |= 4;
            } else {
                YF &= -5;
            }
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(40, Integer.valueOf(YF));
            YF = z ? 1 : 2;
            C9638aw.m17190ZK();
            C18628c.m29077XL().mo7920c(new C9064g(18, YF));
            AppMethodBeat.m2505o(23505);
            return true;
        } else if (str.equals("contact_info_view_message")) {
            Intent intent = new Intent();
            if (this.pli) {
                intent.putExtra("Chat_User", this.ehM.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                ((Activity) this.context).setResult(-1, intent);
                ((Activity) this.context).finish();
            } else {
                intent.putExtra("Chat_User", this.ehM.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                C39503b.gkE.mo38915d(intent, this.context);
                ((Activity) this.context).finish();
            }
            AppMethodBeat.m2505o(23505);
            return true;
        } else if (str.equals("contact_info_bind_mobile_entry")) {
            C39503b.gkE.mo38919f(new Intent(), this.context);
            AppMethodBeat.m2505o(23505);
            return true;
        } else if (str.equals("contact_info_bind_qq_entry")) {
            C39503b.gkE.mo38921g(new Intent(), this.context);
            AppMethodBeat.m2505o(23505);
            return true;
        } else if (str.equals("contact_info_bind_fb_entry")) {
            C25985d.m41467b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
            AppMethodBeat.m2505o(23505);
            return true;
        } else if (str.equals("contact_info_fmessage_clear_data")) {
            C30379h.m48466d(this.context, this.context.getString(C25738R.string.av9), "", this.context.getString(C25738R.string.f9078ou), this.context.getString(C25738R.string.f9076or), new C286951(), null);
            AppMethodBeat.m2505o(23505);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.ContactWidgetFMessage", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(23505);
            return false;
        }
    }

    /* renamed from: e */
    private void m86106e(boolean z, int i, int i2) {
        AppMethodBeat.m2504i(23506);
        C4990ab.m7410d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(7, Integer.valueOf(this.status));
        int i3 = z ? 1 : 2;
        C9638aw.m17190ZK();
        C18628c.m29077XL().mo7920c(new C9064g(i2, i3));
        AppMethodBeat.m2505o(23506);
    }

    /* renamed from: a */
    public final boolean mo7078a(C15541f c15541f, C7616ad c7616ad, boolean z, int i) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        AppMethodBeat.m2504i(23507);
        Assert.assertTrue(c15541f != null);
        if (c7616ad != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(C1855t.m3935nd(c7616ad.field_username));
        this.ehK = c15541f;
        this.pli = z;
        this.ehM = c7616ad;
        if (this.status == -1) {
            this.status = C1853r.m3822YD();
        }
        c15541f.addPreferencesFromResource(C25738R.xml.f8482x);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) c15541f.aqO("contact_info_recommend_qqfriends_to_me");
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) c15541f.aqO("contact_info_recommend_mobilefriends_to_me");
        CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) c15541f.aqO("contact_info_recommend_fbfriends_to_me");
        if (m86105Be(256)) {
            z3 = false;
        } else {
            z3 = true;
        }
        checkBoxPreference2.uOT = z3;
        if (m86105Be(128)) {
            z3 = false;
        } else {
            z3 = true;
        }
        checkBoxPreference.uOT = z3;
        if ((C1853r.m3824YF() & 4) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        checkBoxPreference3.uOT = z3;
        ((HelperHeaderPreference) c15541f.aqO("contact_info_header_helper")).mo62462a(c7616ad, this.pmQ);
        C9638aw.m17190ZK();
        if (C5046bo.m7567h((Integer) C18628c.m29072Ry().get(9, null)) != 0) {
            c15541f.mo27716d(c15541f.aqO("contact_info_bind_qq_entry"));
            c15541f.mo27716d(c15541f.aqO("contact_info_bind_qq_entry_tip"));
        } else {
            c15541f.mo27716d(checkBoxPreference);
            if (!C17950b.ahM()) {
                c15541f.mo27716d(c15541f.aqO("contact_info_bind_qq_entry"));
                c15541f.mo27716d(c15541f.aqO("contact_info_bind_qq_entry_tip"));
            }
        }
        if (C38033l.apS() == C38034a.SUCC) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            c15541f.mo27716d(c15541f.aqO("contact_info_bind_mobile_entry"));
            c15541f.mo27716d(c15541f.aqO("contact_info_bind_mobile_entry_tip"));
        } else {
            c15541f.mo27716d(checkBoxPreference2);
            c15541f.aqO("contact_info_bind_mobile_entry").setSummary((int) C25738R.string.e61);
        }
        if ((C1853r.m3829YK() & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
            z4 = true;
        }
        if (z4) {
            z2 = C1853r.m3847Za();
            C17950b.ahN();
            c15541f.mo27716d(checkBoxPreference3);
            if (z2) {
                c15541f.aqO("contact_info_bind_fb_entry").setSummary((int) C25738R.string.avz);
            } else {
                c15541f.aqO("contact_info_bind_fb_entry").setSummary((int) C25738R.string.e61);
            }
        } else {
            c15541f.mo27716d(c15541f.aqO("contact_info_bind_fb_entry"));
            c15541f.mo27716d(c15541f.aqO("contact_info_bind_fb_entry_tip"));
            c15541f.mo27716d(checkBoxPreference3);
        }
        AppMethodBeat.m2505o(23507);
        return true;
    }

    /* renamed from: Be */
    private boolean m86105Be(int i) {
        return (this.status & i) != 0;
    }

    public final boolean biV() {
        AppMethodBeat.m2504i(23508);
        C39503b.gkF.mo38844BS();
        this.ehK.aqO("contact_info_header_helper");
        AppMethodBeat.m2505o(23508);
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
