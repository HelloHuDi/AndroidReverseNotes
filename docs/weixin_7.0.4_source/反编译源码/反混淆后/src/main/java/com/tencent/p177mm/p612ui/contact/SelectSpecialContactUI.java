package com.tencent.p177mm.p612ui.contact;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.contact.SelectSpecialContactUI */
public class SelectSpecialContactUI extends MMBaseSelectContactUI {
    private String title;
    private int zon;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Kh */
    public final void mo7850Kh() {
        AppMethodBeat.m2504i(33916);
        super.mo7850Kh();
        this.title = getIntent().getStringExtra("titile");
        this.zon = getIntent().getIntExtra("list_attr", 0);
        AppMethodBeat.m2505o(33916);
    }

    /* renamed from: mO */
    public final void mo7859mO(int i) {
        AppMethodBeat.m2504i(33917);
        C5445a Pn = dHV().getItem(i);
        if (Pn == null) {
            AppMethodBeat.m2505o(33917);
        } else if (Pn.ehM == null) {
            AppMethodBeat.m2505o(33917);
        } else {
            String str = Pn.ehM.field_username;
            C4990ab.m7417i("MicroMsg.SelectSpecialContactUI", "ClickUser=%s", str);
            Intent intent = new Intent();
            if (C15830s.m24192hr(this.zon, 16384)) {
                intent.putExtra("Select_Contact", str);
                setResult(-1, intent);
                finish();
                AppMethodBeat.m2505o(33917);
            } else if (C15830s.m24192hr(this.zon, 32768)) {
                intent.putExtra("Contact_User", str);
                C25985d.m41467b((Context) this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                finish();
                AppMethodBeat.m2505o(33917);
            } else {
                intent.setClass(this, ChattingUI.class);
                intent.putExtra("Chat_User", str);
                intent.putExtra("finish_direct", true);
                startActivity(intent);
                finish();
                AppMethodBeat.m2505o(33917);
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
    public final C40845o aoz() {
        AppMethodBeat.m2504i(33918);
        C30660aa c30660aa = new C30660aa(this, getIntent().getStringExtra("filter_type"));
        AppMethodBeat.m2505o(33918);
        return c30660aa;
    }

    /* Access modifiers changed, original: protected|final */
    public final C36877m aoA() {
        return null;
    }
}
