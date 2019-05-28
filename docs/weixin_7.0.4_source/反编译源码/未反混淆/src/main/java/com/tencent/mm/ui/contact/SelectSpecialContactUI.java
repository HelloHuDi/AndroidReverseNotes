package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.a.a;

public class SelectSpecialContactUI extends MMBaseSelectContactUI {
    private String title;
    private int zon;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final void Kh() {
        AppMethodBeat.i(33916);
        super.Kh();
        this.title = getIntent().getStringExtra("titile");
        this.zon = getIntent().getIntExtra("list_attr", 0);
        AppMethodBeat.o(33916);
    }

    public final void mO(int i) {
        AppMethodBeat.i(33917);
        a Pn = dHV().getItem(i);
        if (Pn == null) {
            AppMethodBeat.o(33917);
        } else if (Pn.ehM == null) {
            AppMethodBeat.o(33917);
        } else {
            String str = Pn.ehM.field_username;
            ab.i("MicroMsg.SelectSpecialContactUI", "ClickUser=%s", str);
            Intent intent = new Intent();
            if (s.hr(this.zon, 16384)) {
                intent.putExtra("Select_Contact", str);
                setResult(-1, intent);
                finish();
                AppMethodBeat.o(33917);
            } else if (s.hr(this.zon, 32768)) {
                intent.putExtra("Contact_User", str);
                d.b((Context) this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                finish();
                AppMethodBeat.o(33917);
            } else {
                intent.setClass(this, ChattingUI.class);
                intent.putExtra("Chat_User", str);
                intent.putExtra("finish_direct", true);
                startActivity(intent);
                finish();
                AppMethodBeat.o(33917);
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aow() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aox() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aoy() {
        return this.title;
    }

    /* Access modifiers changed, original: protected|final */
    public final o aoz() {
        AppMethodBeat.i(33918);
        aa aaVar = new aa(this, getIntent().getStringExtra("filter_type"));
        AppMethodBeat.o(33918);
        return aaVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final m aoA() {
        return null;
    }
}
