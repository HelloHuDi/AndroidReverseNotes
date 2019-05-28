package com.tencent.mm.ui.voicesearch;

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
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.p.a;
import java.util.LinkedList;

public class SearchConversationResultUI extends MMActivity {
    private TextView kxK;
    private String username;
    private ListView zLr;
    private a zLs;
    private String zLt = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(SearchConversationResultUI searchConversationResultUI, Class cls, Intent intent) {
        AppMethodBeat.i(35324);
        searchConversationResultUI.a(cls, intent);
        AppMethodBeat.o(35324);
    }

    static /* synthetic */ void b(SearchConversationResultUI searchConversationResultUI, Class cls, Intent intent) {
        AppMethodBeat.i(35325);
        searchConversationResultUI.a(cls, intent);
        AppMethodBeat.o(35325);
    }

    static /* synthetic */ void c(SearchConversationResultUI searchConversationResultUI, Class cls, Intent intent) {
        AppMethodBeat.i(35326);
        searchConversationResultUI.a(cls, intent);
        AppMethodBeat.o(35326);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(35318);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(35318);
    }

    public final void initView() {
        AppMethodBeat.i(35319);
        this.zLr = (ListView) findViewById(R.id.f2b);
        this.kxK = (TextView) findViewById(R.id.n4);
        this.zLs = new a(getApplicationContext(), new a() {
            public final void apt() {
            }
        });
        dHz();
        this.zLr.setAdapter(this.zLs);
        this.kxK.setVisibility(8);
        this.username = getIntent().getStringExtra("SearchConversationResult_User");
        this.zLt = getIntent().getStringExtra("SearchConversationResult_Error");
        setMMTitle(getString(R.string.f37));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(35316);
                SearchConversationResultUI.this.finish();
                AppMethodBeat.o(35316);
                return true;
            }
        });
        this.zLr.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(35317);
                if (i < SearchConversationResultUI.this.zLr.getHeaderViewsCount()) {
                    AppMethodBeat.o(35317);
                    return;
                }
                int headerViewsCount = i - SearchConversationResultUI.this.zLr.getHeaderViewsCount();
                ak akVar = (ak) SearchConversationResultUI.this.zLs.getItem(headerViewsCount);
                if (akVar == null) {
                    ab.e("MicroMsg.VoiceSearchResultUI", "null user at position = ".concat(String.valueOf(headerViewsCount)));
                    AppMethodBeat.o(35317);
                    return;
                }
                ab.d("MicroMsg.VoiceSearchResultUI", "username " + akVar.field_username);
                Intent intent;
                if (t.ne(akVar.field_username)) {
                    if (r.YS()) {
                        d.b(SearchConversationResultUI.this.mController.ylL, "tmessage", ".ui.TConversationUI", new Intent().putExtra("finish_direct", true));
                        AppMethodBeat.o(35317);
                        return;
                    }
                    d.b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", akVar.field_username));
                    AppMethodBeat.o(35317);
                } else if (t.ng(akVar.field_username)) {
                    if (r.YP()) {
                        d.b(SearchConversationResultUI.this.mController.ylL, "qmessage", ".ui.QConversationUI", new Intent().putExtra("finish_direct", true));
                        AppMethodBeat.o(35317);
                        return;
                    }
                    d.b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", akVar.field_username));
                    AppMethodBeat.o(35317);
                } else if (t.nf(akVar.field_username)) {
                    d.b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", akVar.field_username));
                    AppMethodBeat.o(35317);
                } else if (t.nk(akVar.field_username)) {
                    MMAppMgr.cancelNotification(akVar.field_username);
                    d.b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", akVar.field_username));
                    AppMethodBeat.o(35317);
                } else if (t.nc(akVar.field_username)) {
                    if (r.Zb()) {
                        SearchConversationResultUI.a(SearchConversationResultUI.this, ChattingUI.class, new Intent().putExtra("Chat_User", akVar.field_username).putExtra("finish_direct", true));
                        AppMethodBeat.o(35317);
                        return;
                    }
                    d.b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", akVar.field_username));
                    AppMethodBeat.o(35317);
                } else if (t.np(akVar.field_username)) {
                    if (r.YV()) {
                        intent = new Intent();
                        intent.putExtra("type", 20);
                        d.b(SearchConversationResultUI.this, "readerapp", ".ui.ReaderAppUI", intent);
                        AppMethodBeat.o(35317);
                        return;
                    }
                    d.b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", akVar.field_username));
                    AppMethodBeat.o(35317);
                } else if (t.nx(akVar.field_username)) {
                    if (r.YW()) {
                        intent = new Intent();
                        intent.putExtra("type", 11);
                        d.b(SearchConversationResultUI.this, "readerapp", ".ui.ReaderAppUI", intent);
                        AppMethodBeat.o(35317);
                        return;
                    }
                    d.b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", akVar.field_username));
                    AppMethodBeat.o(35317);
                } else if (t.nh(akVar.field_username)) {
                    d.b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", akVar.field_username));
                    AppMethodBeat.o(35317);
                } else if (t.ni(akVar.field_username)) {
                    if (r.YY()) {
                        d.b(SearchConversationResultUI.this, "masssend", ".ui.MassSendHistoryUI", new Intent().putExtra("finish_direct", true));
                        AppMethodBeat.o(35317);
                        return;
                    }
                    d.b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", akVar.field_username));
                    AppMethodBeat.o(35317);
                } else if (t.no(akVar.field_username)) {
                    if (r.YT()) {
                        SearchConversationResultUI.b(SearchConversationResultUI.this, ChattingUI.class, new Intent().putExtra("Chat_User", akVar.field_username).putExtra("finish_direct", true));
                        AppMethodBeat.o(35317);
                        return;
                    }
                    d.b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", akVar.field_username));
                    AppMethodBeat.o(35317);
                } else if (t.nm(SearchConversationResultUI.this.username) || t.nn(SearchConversationResultUI.this.username) || t.nj(SearchConversationResultUI.this.username) || t.nr(SearchConversationResultUI.this.username) || t.ns(SearchConversationResultUI.this.username) || t.nd(SearchConversationResultUI.this.username) || t.nA(SearchConversationResultUI.this.username)) {
                    d.b(SearchConversationResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", akVar.field_username));
                    AppMethodBeat.o(35317);
                } else {
                    SearchConversationResultUI.c(SearchConversationResultUI.this, ChattingUI.class, new Intent().putExtra("Chat_User", akVar.field_username).putExtra("finish_direct", true));
                    AppMethodBeat.o(35317);
                }
            }
        });
        asw(this.username);
        AppMethodBeat.o(35319);
    }

    public void onDestroy() {
        AppMethodBeat.i(35320);
        super.onDestroy();
        this.zLs.bIf();
        AppMethodBeat.o(35320);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(35321);
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(35321);
        return onKeyDown;
    }

    private void asw(String str) {
        AppMethodBeat.i(35322);
        this.kxK.setVisibility(8);
        if (this.zLs != null) {
            this.zLs.vM(str);
        }
        AppMethodBeat.o(35322);
    }

    public final int getLayoutId() {
        return R.layout.b29;
    }

    private void dHz() {
        AppMethodBeat.i(35323);
        if (this.zLs != null) {
            this.zLs.fl(new LinkedList());
        }
        AppMethodBeat.o(35323);
    }
}
