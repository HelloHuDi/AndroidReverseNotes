package com.tencent.p177mm.p612ui.voicesearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMAppMgr;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7617ak;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.voicesearch.SearchConversationResultUI */
public class SearchConversationResultUI extends MMActivity {
    private TextView kxK;
    private String username;
    private ListView zLr;
    private C40896a zLs;
    private String zLt = null;

    /* renamed from: com.tencent.mm.ui.voicesearch.SearchConversationResultUI$2 */
    class C240762 implements OnMenuItemClickListener {
        C240762() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(35316);
            SearchConversationResultUI.this.finish();
            AppMethodBeat.m2505o(35316);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.voicesearch.SearchConversationResultUI$3 */
    class C307863 implements OnItemClickListener {
        C307863() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(35317);
            if (i < SearchConversationResultUI.this.zLr.getHeaderViewsCount()) {
                AppMethodBeat.m2505o(35317);
                return;
            }
            int headerViewsCount = i - SearchConversationResultUI.this.zLr.getHeaderViewsCount();
            C7617ak c7617ak = (C7617ak) SearchConversationResultUI.this.zLs.getItem(headerViewsCount);
            if (c7617ak == null) {
                C4990ab.m7412e("MicroMsg.VoiceSearchResultUI", "null user at position = ".concat(String.valueOf(headerViewsCount)));
                AppMethodBeat.m2505o(35317);
                return;
            }
            C4990ab.m7410d("MicroMsg.VoiceSearchResultUI", "username " + c7617ak.field_username);
            Intent intent;
            if (C1855t.m3936ne(c7617ak.field_username)) {
                if (C1853r.m3837YS()) {
                    C25985d.m41467b(SearchConversationResultUI.this.mController.ylL, "tmessage", ".ui.TConversationUI", new Intent().putExtra("finish_direct", true));
                    AppMethodBeat.m2505o(35317);
                    return;
                }
                C25985d.m41467b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", c7617ak.field_username));
                AppMethodBeat.m2505o(35317);
            } else if (C1855t.m3938ng(c7617ak.field_username)) {
                if (C1853r.m3834YP()) {
                    C25985d.m41467b(SearchConversationResultUI.this.mController.ylL, "qmessage", ".ui.QConversationUI", new Intent().putExtra("finish_direct", true));
                    AppMethodBeat.m2505o(35317);
                    return;
                }
                C25985d.m41467b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", c7617ak.field_username));
                AppMethodBeat.m2505o(35317);
            } else if (C1855t.m3937nf(c7617ak.field_username)) {
                C25985d.m41467b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", c7617ak.field_username));
                AppMethodBeat.m2505o(35317);
            } else if (C1855t.m3942nk(c7617ak.field_username)) {
                MMAppMgr.cancelNotification(c7617ak.field_username);
                C25985d.m41467b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", c7617ak.field_username));
                AppMethodBeat.m2505o(35317);
            } else if (C1855t.m3934nc(c7617ak.field_username)) {
                if (C1853r.m3848Zb()) {
                    SearchConversationResultUI.m88470a(SearchConversationResultUI.this, ChattingUI.class, new Intent().putExtra("Chat_User", c7617ak.field_username).putExtra("finish_direct", true));
                    AppMethodBeat.m2505o(35317);
                    return;
                }
                C25985d.m41467b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", c7617ak.field_username));
                AppMethodBeat.m2505o(35317);
            } else if (C1855t.m3947np(c7617ak.field_username)) {
                if (C1853r.m3840YV()) {
                    intent = new Intent();
                    intent.putExtra("type", 20);
                    C25985d.m41467b(SearchConversationResultUI.this, "readerapp", ".ui.ReaderAppUI", intent);
                    AppMethodBeat.m2505o(35317);
                    return;
                }
                C25985d.m41467b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", c7617ak.field_username));
                AppMethodBeat.m2505o(35317);
            } else if (C1855t.m3955nx(c7617ak.field_username)) {
                if (C1853r.m3841YW()) {
                    intent = new Intent();
                    intent.putExtra("type", 11);
                    C25985d.m41467b(SearchConversationResultUI.this, "readerapp", ".ui.ReaderAppUI", intent);
                    AppMethodBeat.m2505o(35317);
                    return;
                }
                C25985d.m41467b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", c7617ak.field_username));
                AppMethodBeat.m2505o(35317);
            } else if (C1855t.m3939nh(c7617ak.field_username)) {
                C25985d.m41467b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", c7617ak.field_username));
                AppMethodBeat.m2505o(35317);
            } else if (C1855t.m3940ni(c7617ak.field_username)) {
                if (C1853r.m3843YY()) {
                    C25985d.m41467b(SearchConversationResultUI.this, "masssend", ".ui.MassSendHistoryUI", new Intent().putExtra("finish_direct", true));
                    AppMethodBeat.m2505o(35317);
                    return;
                }
                C25985d.m41467b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", c7617ak.field_username));
                AppMethodBeat.m2505o(35317);
            } else if (C1855t.m3946no(c7617ak.field_username)) {
                if (C1853r.m3838YT()) {
                    SearchConversationResultUI.m88472b(SearchConversationResultUI.this, ChattingUI.class, new Intent().putExtra("Chat_User", c7617ak.field_username).putExtra("finish_direct", true));
                    AppMethodBeat.m2505o(35317);
                    return;
                }
                C25985d.m41467b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", c7617ak.field_username));
                AppMethodBeat.m2505o(35317);
            } else if (C1855t.m3944nm(SearchConversationResultUI.this.username) || C1855t.m3945nn(SearchConversationResultUI.this.username) || C1855t.m3941nj(SearchConversationResultUI.this.username) || C1855t.m3949nr(SearchConversationResultUI.this.username) || C1855t.m3950ns(SearchConversationResultUI.this.username) || C1855t.m3935nd(SearchConversationResultUI.this.username) || C1855t.m3915nA(SearchConversationResultUI.this.username)) {
                C25985d.m41467b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", c7617ak.field_username));
                AppMethodBeat.m2505o(35317);
            } else {
                SearchConversationResultUI.m88474c(SearchConversationResultUI.this, ChattingUI.class, new Intent().putExtra("Chat_User", c7617ak.field_username).putExtra("finish_direct", true));
                AppMethodBeat.m2505o(35317);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.voicesearch.SearchConversationResultUI$1 */
    class C315051 implements C30723a {
        C315051() {
        }

        public final void apt() {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m88470a(SearchConversationResultUI searchConversationResultUI, Class cls, Intent intent) {
        AppMethodBeat.m2504i(35324);
        searchConversationResultUI.mo17381a(cls, intent);
        AppMethodBeat.m2505o(35324);
    }

    /* renamed from: b */
    static /* synthetic */ void m88472b(SearchConversationResultUI searchConversationResultUI, Class cls, Intent intent) {
        AppMethodBeat.m2504i(35325);
        searchConversationResultUI.mo17381a(cls, intent);
        AppMethodBeat.m2505o(35325);
    }

    /* renamed from: c */
    static /* synthetic */ void m88474c(SearchConversationResultUI searchConversationResultUI, Class cls, Intent intent) {
        AppMethodBeat.m2504i(35326);
        searchConversationResultUI.mo17381a(cls, intent);
        AppMethodBeat.m2505o(35326);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(35318);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(35318);
    }

    public final void initView() {
        AppMethodBeat.m2504i(35319);
        this.zLr = (ListView) findViewById(2131828473);
        this.kxK = (TextView) findViewById(2131821055);
        this.zLs = new C40896a(getApplicationContext(), new C315051());
        dHz();
        this.zLr.setAdapter(this.zLs);
        this.kxK.setVisibility(8);
        this.username = getIntent().getStringExtra("SearchConversationResult_User");
        this.zLt = getIntent().getStringExtra("SearchConversationResult_Error");
        setMMTitle(getString(C25738R.string.f37));
        setBackBtn(new C240762());
        this.zLr.setOnItemClickListener(new C307863());
        asw(this.username);
        AppMethodBeat.m2505o(35319);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(35320);
        super.onDestroy();
        this.zLs.bIf();
        AppMethodBeat.m2505o(35320);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(35321);
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(35321);
        return onKeyDown;
    }

    private void asw(String str) {
        AppMethodBeat.m2504i(35322);
        this.kxK.setVisibility(8);
        if (this.zLs != null) {
            this.zLs.mo64501vM(str);
        }
        AppMethodBeat.m2505o(35322);
    }

    public final int getLayoutId() {
        return 2130971023;
    }

    private void dHz() {
        AppMethodBeat.m2504i(35323);
        if (this.zLs != null) {
            this.zLs.mo64499fl(new LinkedList());
        }
        AppMethodBeat.m2505o(35323);
    }
}
