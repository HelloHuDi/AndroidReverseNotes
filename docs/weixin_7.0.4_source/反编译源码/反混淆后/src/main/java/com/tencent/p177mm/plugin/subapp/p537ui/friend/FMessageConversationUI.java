package com.tencent.p177mm.plugin.subapp.p537ui.friend;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.model.p1207a.C18608f;
import com.tencent.p177mm.model.p1207a.C26407g;
import com.tencent.p177mm.p1374bi.C37512c;
import com.tencent.p177mm.p1374bi.C41789d;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.plugin.account.bind.p271ui.BindMContactIntroUI;
import com.tencent.p177mm.plugin.account.bind.p271ui.MobileFriendUI;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l.C38034a;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.subapp.p537ui.pluginapp.AddMoreFriendsUI;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7568av;

/* renamed from: com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI */
public class FMessageConversationUI extends MMActivity {
    private C5279d jKa = new C436697();
    private String ptj;
    private ListView stL;
    private C39940a stM;
    private View stN;
    private View stO;
    private TextView stP;
    private long stQ;
    private C29396b stw;

    /* renamed from: com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI$3 */
    class C223423 implements OnClickListener {
        C223423() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(25360);
            if (C38033l.apS() != C38034a.SUCC) {
                Intent intent = new Intent(FMessageConversationUI.this.mController.ylL, BindMContactIntroUI.class);
                intent.putExtra("key_upload_scene", 5);
                MMWizardActivity.m23791J(FMessageConversationUI.this.mController.ylL, intent);
                AppMethodBeat.m2505o(25360);
                return;
            }
            FMessageConversationUI.this.startActivity(new Intent(FMessageConversationUI.this.mController.ylL, MobileFriendUI.class));
            AppMethodBeat.m2505o(25360);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI$5 */
    class C223445 implements OnMenuItemClickListener {
        C223445() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(25362);
            Intent intent = new Intent(FMessageConversationUI.this, AddMoreFriendsUI.class);
            intent.putExtra("invite_friend_scene", 3);
            FMessageConversationUI.this.startActivity(intent);
            AppMethodBeat.m2505o(25362);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI$2 */
    class C293922 implements OnClickListener {
        C293922() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(25359);
            Intent putExtra = new Intent().putExtra("Search_Scene", 2).putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, 0).putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, 0);
            Bundle bundle = null;
            if (VERSION.SDK_INT >= 21) {
                bundle = ActivityOptions.makeSceneTransitionAnimation(FMessageConversationUI.this, new Pair[0]).toBundle();
            }
            C3161d.m5411b(FMessageConversationUI.this.mController.ylL, ".ui.FTSAddFriendUI", putExtra, bundle);
            AppMethodBeat.m2505o(25359);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI$6 */
    class C399396 implements OnMenuItemClickListener {
        C399396() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(25363);
            FMessageConversationUI.this.finish();
            AppMethodBeat.m2505o(25363);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI$1 */
    class C436681 implements C30723a {
        C436681() {
        }

        public final void apt() {
            AppMethodBeat.m2504i(25358);
            FMessageConversationUI.m78202a(FMessageConversationUI.this);
            AppMethodBeat.m2505o(25358);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI$7 */
    class C436697 implements C5279d {
        C436697() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(25364);
            C37512c.m63302e(FMessageConversationUI.this.stQ, FMessageConversationUI.this.ptj);
            AppMethodBeat.m2505o(25364);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FMessageConversationUI() {
        AppMethodBeat.m2504i(25365);
        AppMethodBeat.m2505o(25365);
    }

    /* renamed from: a */
    static /* synthetic */ void m78202a(FMessageConversationUI fMessageConversationUI) {
        AppMethodBeat.m2504i(25373);
        fMessageConversationUI.aMk();
        AppMethodBeat.m2505o(25373);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(25366);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.bw5);
        try {
            C9638aw.getNotification().mo41568IH();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.FMessageConversationUI", e, "try cancel notification fail", new Object[0]);
        }
        if (C9638aw.m17179RK()) {
            initView();
            AppMethodBeat.m2505o(25366);
            return;
        }
        finish();
        AppMethodBeat.m2505o(25366);
    }

    public void onPause() {
        AppMethodBeat.m2504i(25367);
        super.onPause();
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(143618, Integer.valueOf(0));
        AppMethodBeat.m2505o(25367);
    }

    public void onResume() {
        AppMethodBeat.m2504i(25368);
        super.onResume();
        if (C9638aw.m17179RK()) {
            if (this.stP != null && C5046bo.m7558gT(this)) {
                this.stP.setText(C25738R.string.bwa);
            }
            AppMethodBeat.m2505o(25368);
            return;
        }
        finish();
        AppMethodBeat.m2505o(25368);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(25369);
        super.onDestroy();
        if (this.stw != null) {
            C41789d.akP().mo10117d(this.stw);
        }
        if (C1720g.m3534RN().mo5161QY()) {
            C18608f.m29045oU("1");
            C41789d.akP().dtc();
            AppMethodBeat.m2505o(25369);
            return;
        }
        C4990ab.m7420w("MicroMsg.FMessageConversationUI", "account not init.");
        AppMethodBeat.m2505o(25369);
    }

    public final void initView() {
        AppMethodBeat.m2504i(25370);
        if (C26407g.aaK().mo60654oP("1") != null) {
            String str = C26407g.aaK().mo60654oP("1").value;
            if (!str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                str.equals("1");
            }
            C18608f.m29044oT("1");
        }
        this.stw = new C29396b(this.mController.ylL);
        C41789d.akP().mo10116c(this.stw);
        this.stw.mo74992a((C30723a) new C436681());
        this.stL = (ListView) findViewById(2131824096);
        this.stN = LayoutInflater.from(this.mController.ylL).inflate(2130969582, null);
        this.stN.findViewById(2131823137).setOnClickListener(new C293922());
        this.stL.addHeaderView(this.stN);
        this.stO = LayoutInflater.from(this.mController.ylL).inflate(2130969578, null);
        this.stO.findViewById(2131824100).setOnClickListener(new C223423());
        this.stL.addHeaderView(this.stO);
        this.stL.setAdapter(this.stw);
        aMk();
        final C46696j c46696j = new C46696j(this);
        this.stL.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(25361);
                if (i < FMessageConversationUI.this.stL.getHeaderViewsCount()) {
                    C4990ab.m7420w("MicroMsg.FMessageConversationUI", "on header view long click, ignore");
                    AppMethodBeat.m2505o(25361);
                } else {
                    View view2 = view;
                    c46696j.mo75004a(view2, i - FMessageConversationUI.this.stL.getHeaderViewsCount(), j, FMessageConversationUI.this, FMessageConversationUI.this.jKa);
                    AppMethodBeat.m2505o(25361);
                }
                return true;
            }
        });
        this.stM = new C39940a(this.mController.ylL, this.stw, this.stL.getHeaderViewsCount() > 0);
        this.stL.setOnItemClickListener(this.stM);
        addTextOptionMenu(0, getString(C25738R.string.cze), new C223445());
        setBackBtn(new C399396());
        AppMethodBeat.m2505o(25370);
    }

    private void aMk() {
        AppMethodBeat.m2504i(25371);
        if (this.stw.getCount() > 0) {
            this.stN.findViewById(2131823137).setVisibility(0);
            this.stO.findViewById(2131824099).setVisibility(8);
            enableOptionMenu(0, true);
            AppMethodBeat.m2505o(25371);
            return;
        }
        this.stN.findViewById(2131823137).setVisibility(8);
        this.stO.findViewById(2131824099).setVisibility(0);
        enableOptionMenu(0, false);
        AppMethodBeat.m2505o(25371);
    }

    public final int getLayoutId() {
        return 2130969577;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(25372);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        C7568av c7568av = (C7568av) this.stw.getItem(adapterContextMenuInfo.position);
        if (c7568av == null) {
            C4990ab.m7412e("MicroMsg.FMessageConversationUI", "onItemLongClick, item is null, pos = " + adapterContextMenuInfo.position);
            AppMethodBeat.m2505o(25372);
            return;
        }
        if (!C5046bo.isNullOrNil(c7568av.field_displayName)) {
            contextMenu.setHeaderTitle(C44089j.m79292b((Context) this, c7568av.field_displayName));
        }
        contextMenu.add(0, 0, 0, C25738R.string.f9088p4);
        this.stQ = c7568av.field_fmsgSysRowId;
        this.ptj = c7568av.field_talker;
        AppMethodBeat.m2505o(25372);
    }
}
