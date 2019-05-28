package com.tencent.p177mm.p612ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.plugin.label.p1276a.C21156a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashSet;

/* renamed from: com.tencent.mm.ui.contact.SelectLabelContactUI */
public class SelectLabelContactUI extends MMBaseSelectContactUI {
    private HashSet<String> gnG;
    private String label;
    private HashSet<String> zol;
    private int zon;

    /* renamed from: com.tencent.mm.ui.contact.SelectLabelContactUI$2 */
    class C158062 implements OnClickListener {
        C158062() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.SelectLabelContactUI$1 */
    class C408391 implements OnMenuItemClickListener {
        C408391() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(33906);
            C4990ab.m7417i("MicroMsg.SelectLabelContactUI", "SelectUser: %s", new ArrayList(SelectLabelContactUI.this.gnG).toString());
            SelectLabelContactUI.m88392a(SelectLabelContactUI.this, C5046bo.m7536c(r0, ","));
            AppMethodBeat.m2505o(33906);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m88392a(SelectLabelContactUI selectLabelContactUI, String str) {
        AppMethodBeat.m2504i(33915);
        selectLabelContactUI.arS(str);
        AppMethodBeat.m2505o(33915);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Kh */
    public final void mo7850Kh() {
        AppMethodBeat.m2504i(33907);
        super.mo7850Kh();
        this.label = getIntent().getStringExtra("label");
        this.zon = getIntent().getIntExtra("list_attr", 0);
        this.gnG = new HashSet();
        this.zol = new HashSet();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            this.zol.addAll(C5046bo.m7508P(stringExtra.split(",")));
        }
        stringExtra = getIntent().getStringExtra("already_select_contact");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            this.gnG.addAll(C5046bo.m7508P(stringExtra.split(",")));
        }
        AppMethodBeat.m2505o(33907);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(33908);
        super.onCreate(bundle);
        if (C15830s.m24192hr(this.zon, 64)) {
            mo17379a(1, getString(C25738R.string.f9187s6), (OnMenuItemClickListener) new C408391(), C5535b.GREEN);
        }
        m88390Kt();
        AppMethodBeat.m2505o(33908);
    }

    /* renamed from: mO */
    public final void mo7859mO(int i) {
        AppMethodBeat.m2504i(33909);
        int headerViewsCount = i - getContentLV().getHeaderViewsCount();
        C36252n dHV = dHV();
        C5445a Pn = dHV.getItem(headerViewsCount);
        if (Pn == null) {
            AppMethodBeat.m2505o(33909);
        } else if (Pn.ehM == null) {
            AppMethodBeat.m2505o(33909);
        } else {
            String str = Pn.ehM.field_username;
            C4990ab.m7417i("MicroMsg.SelectLabelContactUI", "ClickUser=%s", str);
            if (!C15830s.m24192hr(this.zon, 64)) {
                arS(str);
                AppMethodBeat.m2505o(33909);
            } else if (this.zol.contains(str) || this.gnG.contains(str) || !C15830s.m24192hr(this.zon, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) || this.zol.size() + this.gnG.size() < getIntent().getIntExtra("max_limit_num", BaseClientBuilder.API_PRIORITY_OTHER)) {
                if (!this.zol.contains(str)) {
                    if (this.gnG.contains(str)) {
                        this.gnG.remove(str);
                    } else {
                        this.gnG.add(str);
                    }
                }
                m88390Kt();
                dHV.notifyDataSetChanged();
                AppMethodBeat.m2505o(33909);
            } else {
                C30379h.m48438a(this.mController.ylL, getString(C25738R.string.e1m, new Object[]{Integer.valueOf(getIntent().getIntExtra("max_limit_num", BaseClientBuilder.API_PRIORITY_OTHER))}), getString(C25738R.string.f9213t6), new C158062());
                AppMethodBeat.m2505o(33909);
            }
        }
    }

    /* renamed from: Kt */
    private void m88390Kt() {
        AppMethodBeat.m2504i(33910);
        if (!C15830s.m24192hr(this.zon, 64) || this.gnG.size() <= 0) {
            updateOptionMenuText(1, getString(C25738R.string.f9187s6));
            enableOptionMenu(1, false);
            AppMethodBeat.m2505o(33910);
            return;
        }
        updateOptionMenuText(1, getString(C25738R.string.f9187s6) + "(" + this.gnG.size() + ")");
        enableOptionMenu(1, true);
        AppMethodBeat.m2505o(33910);
    }

    private void arS(String str) {
        AppMethodBeat.m2504i(33911);
        Intent intent;
        if (C15830s.m24192hr(this.zon, 16384)) {
            intent = new Intent();
            intent.putExtra("Select_Contact", str);
            setResult(-1, intent);
            finish();
            AppMethodBeat.m2505o(33911);
            return;
        }
        intent = new Intent();
        intent.setClass(this, ChattingUI.class);
        intent.putExtra("Chat_User", str);
        intent.putExtra("finish_direct", true);
        startActivity(intent);
        finish();
        AppMethodBeat.m2505o(33911);
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
        return this.label;
    }

    /* Access modifiers changed, original: protected|final */
    public final C36877m aoA() {
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final C40845o aoz() {
        AppMethodBeat.m2504i(33912);
        C23922h c23922h = new C23922h(this, C15830s.m24192hr(this.zon, 64), C21156a.bJa().mo41635PH(C21156a.bJa().mo41632PE(this.label)));
        AppMethodBeat.m2505o(33912);
        return c23922h;
    }

    /* renamed from: a */
    public final boolean mo7897a(C5445a c5445a) {
        AppMethodBeat.m2504i(33913);
        if (!c5445a.zmW || c5445a.ehM == null) {
            AppMethodBeat.m2505o(33913);
            return false;
        }
        boolean contains = this.gnG.contains(c5445a.ehM.field_username);
        AppMethodBeat.m2505o(33913);
        return contains;
    }

    /* renamed from: b */
    public final boolean mo39661b(C5445a c5445a) {
        AppMethodBeat.m2504i(33914);
        if (!c5445a.zmW || c5445a.ehM == null) {
            AppMethodBeat.m2505o(33914);
            return false;
        }
        boolean contains = this.zol.contains(c5445a.ehM.field_username);
        AppMethodBeat.m2505o(33914);
        return contains;
    }
}
