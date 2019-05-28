package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.n;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;
import junit.framework.Assert;

public final class h implements a {
    Context context;
    private f ehK;
    private ad ehM;
    private String ehq;
    u eih;
    private int gwP;
    private boolean pli;
    private boolean plj;
    private int pmV;
    ContactListExpandPreference pmW;

    public h(Context context) {
        AppMethodBeat.i(23533);
        this.context = context;
        this.pmW = new ContactListExpandPreference(context, 0);
        AppMethodBeat.o(23533);
    }

    public final boolean IO(String str) {
        AppMethodBeat.i(23534);
        ab.d("MicroMsg.ContactWidgetGroupCard", "handleEvent ".concat(String.valueOf(str)));
        aw.ZK();
        ad aoO = c.XM().aoO(str);
        if (aoO == null || ((int) aoO.ewQ) <= 0) {
            AppMethodBeat.o(23534);
        } else {
            Intent intent = new Intent();
            intent.setClass(this.context, ContactInfoUI.class);
            intent.putExtra("Contact_User", aoO.field_username);
            this.context.startActivity(intent);
            AppMethodBeat.o(23534);
        }
        return true;
    }

    public final boolean a(f fVar, ad adVar, boolean z, int i) {
        boolean z2;
        AppMethodBeat.i(23535);
        if (adVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(bo.nullAsNil(adVar.field_username).length() > 0);
        Assert.assertTrue(fVar != null);
        this.ehK = fVar;
        this.ehM = adVar;
        this.pli = z;
        this.gwP = i;
        this.plj = ((Activity) this.context).getIntent().getBooleanExtra("User_Verify", false);
        this.pmV = ((Activity) this.context).getIntent().getIntExtra("Kdel_from", -1);
        this.ehq = adVar.field_username;
        aw.ZK();
        this.eih = c.XV().ob(this.ehq);
        this.ehK.removeAll();
        this.ehK.b(new PreferenceSmallCategory(this.context));
        this.pmW.setKey("roominfo_contact_anchor");
        this.ehK.b(this.pmW);
        this.ehK.b(new PreferenceCategory(this.context));
        NormalUserFooterPreference normalUserFooterPreference = new NormalUserFooterPreference(this.context);
        normalUserFooterPreference.setLayoutResource(R.layout.q_);
        normalUserFooterPreference.setKey("contact_info_footer_normal");
        if (normalUserFooterPreference.a(this.ehM, "", this.pli, this.plj, false, this.gwP, this.pmV, false, false, 0, "")) {
            this.ehK.b(normalUserFooterPreference);
        }
        this.pmW.a(this.ehK, this.pmW.mKey);
        List my = n.my(this.ehq);
        this.pmW.oD(false).oE(false);
        this.pmW.u(this.ehq, my);
        this.pmW.a(new ContactListExpandPreference.a() {
            public final void iA(int i) {
            }

            public final void iB(int i) {
                AppMethodBeat.i(23532);
                if (h.this.pmW.KW(i)) {
                    String KX = h.this.pmW.KX(i);
                    if (bo.isNullOrNil(KX)) {
                        AppMethodBeat.o(23532);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.setClass(h.this.context, ContactInfoUI.class);
                    intent.putExtra("Contact_User", KX);
                    intent.putExtra("Contact_RoomNickname", h.this.eih.mJ(KX));
                    h.this.context.startActivity(intent);
                }
                AppMethodBeat.o(23532);
            }

            public final void JT() {
            }

            public final void iC(int i) {
            }
        });
        AppMethodBeat.o(23535);
        return true;
    }

    public final boolean biV() {
        AppMethodBeat.i(23536);
        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.ehK.aqO("contact_info_footer_normal");
        if (normalUserFooterPreference != null) {
            normalUserFooterPreference.biV();
        }
        AppMethodBeat.o(23536);
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
