package com.tencent.mm.plugin.sport.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.contact.s;
import java.util.ArrayList;
import java.util.List;

public class SportBlackListUI extends MMPreference {
    private ContactListExpandPreference ehS;
    private List<String> rPT;
    private a rPU = new a() {
        public final void iA(int i) {
            AppMethodBeat.i(25137);
            String KX = SportBlackListUI.this.ehS.KX(i);
            SportBlackListUI.this.rPT.remove(KX);
            SportBlackListUI.this.ehS.u(null, SportBlackListUI.this.rPT);
            SportBlackListUI.this.ehS.refresh();
            aw.ZK();
            t.h(c.XM().aoO(KX));
            d.kT(40);
            AppMethodBeat.o(25137);
        }

        public final void iC(int i) {
            AppMethodBeat.i(25138);
            SportBlackListUI.c(SportBlackListUI.this);
            AppMethodBeat.o(25138);
        }

        public final void iB(int i) {
            AppMethodBeat.i(25139);
            String KX = SportBlackListUI.this.ehS.KX(i);
            Intent intent = new Intent();
            intent.putExtra("Contact_User", KX);
            com.tencent.mm.bp.d.b(SportBlackListUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            AppMethodBeat.o(25139);
        }

        public final void JT() {
            AppMethodBeat.i(25140);
            SportBlackListUI.this.ehS.djD();
            AppMethodBeat.o(25140);
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SportBlackListUI() {
        AppMethodBeat.i(25141);
        AppMethodBeat.o(25141);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25142);
        super.onCreate(bundle);
        d.kT(39);
        if (this.rPT == null) {
            this.rPT = new ArrayList();
        }
        aw.ZK();
        Cursor d = c.XM().d("@werun.black.android", "", null);
        while (d.moveToNext()) {
            this.rPT.add(d.getString(0));
        }
        d.close();
        this.ehS = (ContactListExpandPreference) this.yCw.aqO("black_contact_list_pref");
        this.ehS.a(this.yCw, this.ehS.mKey);
        this.ehS.oD(true).oE(true);
        this.ehS.u(null, this.rPT);
        this.ehS.a(this.rPU);
        this.ehS.setSummary((int) R.string.bii);
        setMMTitle(getString(R.string.bh7));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25136);
                SportBlackListUI.this.finish();
                AppMethodBeat.o(25136);
                return false;
            }
        });
        AppMethodBeat.o(25142);
    }

    public final int JC() {
        return R.xml.cg;
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(25143);
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            if (intent == null) {
                AppMethodBeat.o(25143);
                return;
            }
            String stringExtra = intent.getStringExtra("Select_Contact");
            if (bo.isNullOrNil(stringExtra)) {
                AppMethodBeat.o(25143);
                return;
            }
            ArrayList<String> P = bo.P(stringExtra.split(","));
            if (P == null) {
                AppMethodBeat.o(25143);
                return;
            }
            this.rPT.addAll(P);
            this.ehS.u(null, this.rPT);
            this.ehS.refresh();
            for (String stringExtra2 : P) {
                aw.ZK();
                t.g(c.XM().aoO(stringExtra2));
            }
        }
        AppMethodBeat.o(25143);
    }

    static /* synthetic */ void c(SportBlackListUI sportBlackListUI) {
        AppMethodBeat.i(25144);
        String c = bo.c(sportBlackListUI.rPT, ",");
        Intent intent = new Intent();
        intent.putExtra("titile", sportBlackListUI.getString(R.string.eu));
        intent.putExtra("list_type", 1);
        intent.putExtra("list_attr", s.C(s.znF, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
        intent.putExtra("always_select_contact", c);
        com.tencent.mm.bp.d.b((Context) sportBlackListUI, ".ui.contact.SelectContactUI", intent, 0);
        AppMethodBeat.o(25144);
    }
}
