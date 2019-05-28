package com.tencent.mm.plugin.subapp.ui.friend;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bi.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.av;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.p.a;
import com.tencent.mm.ui.tools.j;

public class FMessageConversationUI extends MMActivity {
    private d jKa = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(25364);
            c.e(FMessageConversationUI.this.stQ, FMessageConversationUI.this.ptj);
            AppMethodBeat.o(25364);
        }
    };
    private String ptj;
    private ListView stL;
    private a stM;
    private View stN;
    private View stO;
    private TextView stP;
    private long stQ;
    private b stw;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FMessageConversationUI() {
        AppMethodBeat.i(25365);
        AppMethodBeat.o(25365);
    }

    static /* synthetic */ void a(FMessageConversationUI fMessageConversationUI) {
        AppMethodBeat.i(25373);
        fMessageConversationUI.aMk();
        AppMethodBeat.o(25373);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25366);
        super.onCreate(bundle);
        setMMTitle((int) R.string.bw5);
        try {
            aw.getNotification().IH();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.FMessageConversationUI", e, "try cancel notification fail", new Object[0]);
        }
        if (aw.RK()) {
            initView();
            AppMethodBeat.o(25366);
            return;
        }
        finish();
        AppMethodBeat.o(25366);
    }

    public void onPause() {
        AppMethodBeat.i(25367);
        super.onPause();
        aw.ZK();
        com.tencent.mm.model.c.Ry().set(143618, Integer.valueOf(0));
        AppMethodBeat.o(25367);
    }

    public void onResume() {
        AppMethodBeat.i(25368);
        super.onResume();
        if (aw.RK()) {
            if (this.stP != null && bo.gT(this)) {
                this.stP.setText(R.string.bwa);
            }
            AppMethodBeat.o(25368);
            return;
        }
        finish();
        AppMethodBeat.o(25368);
    }

    public void onDestroy() {
        AppMethodBeat.i(25369);
        super.onDestroy();
        if (this.stw != null) {
            com.tencent.mm.bi.d.akP().d(this.stw);
        }
        if (g.RN().QY()) {
            f.oU("1");
            com.tencent.mm.bi.d.akP().dtc();
            AppMethodBeat.o(25369);
            return;
        }
        ab.w("MicroMsg.FMessageConversationUI", "account not init.");
        AppMethodBeat.o(25369);
    }

    public final void initView() {
        AppMethodBeat.i(25370);
        if (com.tencent.mm.model.a.g.aaK().oP("1") != null) {
            String str = com.tencent.mm.model.a.g.aaK().oP("1").value;
            if (!str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                str.equals("1");
            }
            f.oT("1");
        }
        this.stw = new b(this.mController.ylL);
        com.tencent.mm.bi.d.akP().c(this.stw);
        this.stw.a((a) new a() {
            public final void apt() {
                AppMethodBeat.i(25358);
                FMessageConversationUI.a(FMessageConversationUI.this);
                AppMethodBeat.o(25358);
            }
        });
        this.stL = (ListView) findViewById(R.id.bv0);
        this.stN = LayoutInflater.from(this.mController.ylL).inflate(R.layout.a0d, null);
        this.stN.findViewById(R.id.b63).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(25359);
                Intent putExtra = new Intent().putExtra("Search_Scene", 2).putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, 0).putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, 0);
                Bundle bundle = null;
                if (VERSION.SDK_INT >= 21) {
                    bundle = ActivityOptions.makeSceneTransitionAnimation(FMessageConversationUI.this, new Pair[0]).toBundle();
                }
                com.tencent.mm.plugin.fts.a.d.b(FMessageConversationUI.this.mController.ylL, ".ui.FTSAddFriendUI", putExtra, bundle);
                AppMethodBeat.o(25359);
            }
        });
        this.stL.addHeaderView(this.stN);
        this.stO = LayoutInflater.from(this.mController.ylL).inflate(R.layout.a0_, null);
        this.stO.findViewById(R.id.bv4).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(25360);
                if (l.apS() != l.a.SUCC) {
                    Intent intent = new Intent(FMessageConversationUI.this.mController.ylL, BindMContactIntroUI.class);
                    intent.putExtra("key_upload_scene", 5);
                    MMWizardActivity.J(FMessageConversationUI.this.mController.ylL, intent);
                    AppMethodBeat.o(25360);
                    return;
                }
                FMessageConversationUI.this.startActivity(new Intent(FMessageConversationUI.this.mController.ylL, MobileFriendUI.class));
                AppMethodBeat.o(25360);
            }
        });
        this.stL.addHeaderView(this.stO);
        this.stL.setAdapter(this.stw);
        aMk();
        final j jVar = new j(this);
        this.stL.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(25361);
                if (i < FMessageConversationUI.this.stL.getHeaderViewsCount()) {
                    ab.w("MicroMsg.FMessageConversationUI", "on header view long click, ignore");
                    AppMethodBeat.o(25361);
                } else {
                    View view2 = view;
                    jVar.a(view2, i - FMessageConversationUI.this.stL.getHeaderViewsCount(), j, FMessageConversationUI.this, FMessageConversationUI.this.jKa);
                    AppMethodBeat.o(25361);
                }
                return true;
            }
        });
        this.stM = new a(this.mController.ylL, this.stw, this.stL.getHeaderViewsCount() > 0);
        this.stL.setOnItemClickListener(this.stM);
        addTextOptionMenu(0, getString(R.string.cze), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25362);
                Intent intent = new Intent(FMessageConversationUI.this, AddMoreFriendsUI.class);
                intent.putExtra("invite_friend_scene", 3);
                FMessageConversationUI.this.startActivity(intent);
                AppMethodBeat.o(25362);
                return true;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25363);
                FMessageConversationUI.this.finish();
                AppMethodBeat.o(25363);
                return true;
            }
        });
        AppMethodBeat.o(25370);
    }

    private void aMk() {
        AppMethodBeat.i(25371);
        if (this.stw.getCount() > 0) {
            this.stN.findViewById(R.id.b63).setVisibility(0);
            this.stO.findViewById(R.id.bv3).setVisibility(8);
            enableOptionMenu(0, true);
            AppMethodBeat.o(25371);
            return;
        }
        this.stN.findViewById(R.id.b63).setVisibility(8);
        this.stO.findViewById(R.id.bv3).setVisibility(0);
        enableOptionMenu(0, false);
        AppMethodBeat.o(25371);
    }

    public final int getLayoutId() {
        return R.layout.a09;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(25372);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        av avVar = (av) this.stw.getItem(adapterContextMenuInfo.position);
        if (avVar == null) {
            ab.e("MicroMsg.FMessageConversationUI", "onItemLongClick, item is null, pos = " + adapterContextMenuInfo.position);
            AppMethodBeat.o(25372);
            return;
        }
        if (!bo.isNullOrNil(avVar.field_displayName)) {
            contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, avVar.field_displayName));
        }
        contextMenu.add(0, 0, 0, R.string.p4);
        this.stQ = avVar.field_fmsgSysRowId;
        this.ptj = avVar.field_talker;
        AppMethodBeat.o(25372);
    }
}
