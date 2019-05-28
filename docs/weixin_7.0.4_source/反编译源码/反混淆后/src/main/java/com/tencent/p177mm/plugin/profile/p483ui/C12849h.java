package com.tencent.p177mm.plugin.profile.p483ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.PreferenceCategory;
import com.tencent.p177mm.p612ui.base.preference.PreferenceSmallCategory;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.ContactListExpandPreference;
import com.tencent.p177mm.pluginsdk.p597ui.applet.ContactListExpandPreference.C30100a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.profile.ui.h */
public final class C12849h implements C23233a {
    Context context;
    private C15541f ehK;
    private C7616ad ehM;
    private String ehq;
    C7577u eih;
    private int gwP;
    private boolean pli;
    private boolean plj;
    private int pmV;
    ContactListExpandPreference pmW;

    /* renamed from: com.tencent.mm.plugin.profile.ui.h$1 */
    class C128501 implements C30100a {
        C128501() {
        }

        /* renamed from: iA */
        public final void mo14654iA(int i) {
        }

        /* renamed from: iB */
        public final void mo14655iB(int i) {
            AppMethodBeat.m2504i(23532);
            if (C12849h.this.pmW.mo48350KW(i)) {
                String KX = C12849h.this.pmW.mo48351KX(i);
                if (C5046bo.isNullOrNil(KX)) {
                    AppMethodBeat.m2505o(23532);
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(C12849h.this.context, ContactInfoUI.class);
                intent.putExtra("Contact_User", KX);
                intent.putExtra("Contact_RoomNickname", C12849h.this.eih.mo16807mJ(KX));
                C12849h.this.context.startActivity(intent);
            }
            AppMethodBeat.m2505o(23532);
        }

        /* renamed from: JT */
        public final void mo14653JT() {
        }

        /* renamed from: iC */
        public final void mo14656iC(int i) {
        }
    }

    public C12849h(Context context) {
        AppMethodBeat.m2504i(23533);
        this.context = context;
        this.pmW = new ContactListExpandPreference(context, 0);
        AppMethodBeat.m2505o(23533);
    }

    /* renamed from: IO */
    public final boolean mo7077IO(String str) {
        AppMethodBeat.m2504i(23534);
        C4990ab.m7410d("MicroMsg.ContactWidgetGroupCard", "handleEvent ".concat(String.valueOf(str)));
        C9638aw.m17190ZK();
        C7616ad aoO = C18628c.m29078XM().aoO(str);
        if (aoO == null || ((int) aoO.ewQ) <= 0) {
            AppMethodBeat.m2505o(23534);
        } else {
            Intent intent = new Intent();
            intent.setClass(this.context, ContactInfoUI.class);
            intent.putExtra("Contact_User", aoO.field_username);
            this.context.startActivity(intent);
            AppMethodBeat.m2505o(23534);
        }
        return true;
    }

    /* renamed from: a */
    public final boolean mo7078a(C15541f c15541f, C7616ad c7616ad, boolean z, int i) {
        boolean z2;
        AppMethodBeat.m2504i(23535);
        if (c7616ad != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(C5046bo.nullAsNil(c7616ad.field_username).length() > 0);
        Assert.assertTrue(c15541f != null);
        this.ehK = c15541f;
        this.ehM = c7616ad;
        this.pli = z;
        this.gwP = i;
        this.plj = ((Activity) this.context).getIntent().getBooleanExtra("User_Verify", false);
        this.pmV = ((Activity) this.context).getIntent().getIntExtra("Kdel_from", -1);
        this.ehq = c7616ad.field_username;
        C9638aw.m17190ZK();
        this.eih = C18628c.m29087XV().mo14886ob(this.ehq);
        this.ehK.removeAll();
        this.ehK.mo27713b(new PreferenceSmallCategory(this.context));
        this.pmW.setKey("roominfo_contact_anchor");
        this.ehK.mo27713b(this.pmW);
        this.ehK.mo27713b(new PreferenceCategory(this.context));
        NormalUserFooterPreference normalUserFooterPreference = new NormalUserFooterPreference(this.context);
        normalUserFooterPreference.setLayoutResource(2130969206);
        normalUserFooterPreference.setKey("contact_info_footer_normal");
        if (normalUserFooterPreference.mo55318a(this.ehM, "", this.pli, this.plj, false, this.gwP, this.pmV, false, false, 0, "")) {
            this.ehK.mo27713b(normalUserFooterPreference);
        }
        this.pmW.mo48357a(this.ehK, this.pmW.mKey);
        List my = C37921n.m64074my(this.ehq);
        this.pmW.mo48368oD(false).mo48369oE(false);
        this.pmW.mo48371u(this.ehq, my);
        this.pmW.mo48354a(new C128501());
        AppMethodBeat.m2505o(23535);
        return true;
    }

    public final boolean biV() {
        AppMethodBeat.m2504i(23536);
        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.ehK.aqO("contact_info_footer_normal");
        if (normalUserFooterPreference != null) {
            normalUserFooterPreference.biV();
        }
        AppMethodBeat.m2505o(23536);
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
