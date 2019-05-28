package com.tencent.p177mm.plugin.forcenotify.p415ui;

import android.content.Context;
import android.os.Bundle;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.plugin.forcenotify.p1262a.C28062a;
import com.tencent.p177mm.plugin.forcenotify.p1263b.C43100c;
import com.tencent.p177mm.plugin.forcenotify.p1613c.C43101b;
import com.tencent.p177mm.plugin.forcenotify.p1648d.C45947a;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import java.util.ArrayList;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0014J\u001c\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0018\u00010\u0007R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, dWq = {"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TAG", "", "adapter", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyListAdapter;", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "emptyTipView", "Landroid/view/View;", "loadingView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "touchLoc", "", "getLayoutId", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "ForceNotifyListAdapter", "ForceNotifyViewHolder", "plugin-force-notify_release"})
/* renamed from: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI */
public final class ForceNotifyListUI extends MMActivity implements C4931a {
    private final String TAG = "MicroMsg.ForceNotifyListUI";
    private RecyclerView iJP;
    private View jcv;
    private C39098a mtj;
    private View mtk;
    private final ArrayList<C43101b> mtl = new ArrayList();
    private final int[] mtm = new int[2];

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI$d */
    static final class C20775d implements Runnable {
        final /* synthetic */ ForceNotifyListUI mtn;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI$d$1 */
        static final class C207761 implements Runnable {
            final /* synthetic */ C20775d mtt;

            C207761(C20775d c20775d) {
                this.mtt = c20775d;
            }

            public final void run() {
                AppMethodBeat.m2504i(51075);
                C39098a b = this.mtt.mtn.mtj;
                if (b == null) {
                    C25052j.dWJ();
                }
                b.notifyDataSetChanged();
                View g = this.mtt.mtn.jcv;
                if (g == null) {
                    C25052j.dWJ();
                }
                g.setVisibility(8);
                RecyclerView c;
                if (this.mtt.mtn.mtl.isEmpty()) {
                    c = this.mtt.mtn.iJP;
                    if (c == null) {
                        C25052j.dWJ();
                    }
                    c.setVisibility(8);
                    g = this.mtt.mtn.mtk;
                    if (g == null) {
                        C25052j.dWJ();
                    }
                    g.setVisibility(0);
                    AppMethodBeat.m2505o(51075);
                    return;
                }
                c = this.mtt.mtn.iJP;
                if (c == null) {
                    C25052j.dWJ();
                }
                c.setVisibility(0);
                AppMethodBeat.m2505o(51075);
            }
        }

        C20775d(ForceNotifyListUI forceNotifyListUI) {
            this.mtn = forceNotifyListUI;
        }

        public final void run() {
            AppMethodBeat.m2504i(51076);
            this.mtn.mtl.clear();
            ArrayList a = this.mtn.mtl;
            C43100c c43100c = C43100c.mtf;
            a.addAll(C43100c.bxW());
            this.mtn.runOnUiThread(new C207761(this));
            AppMethodBeat.m2505o(51076);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI$c */
    static final class C28065c implements OnMenuItemClickListener {
        final /* synthetic */ ForceNotifyListUI mtn;

        C28065c(ForceNotifyListUI forceNotifyListUI) {
            this.mtn = forceNotifyListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(51074);
            this.mtn.onBackPressed();
            AppMethodBeat.m2505o(51074);
            return true;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI$e */
    static final class C28066e implements Runnable {
        final /* synthetic */ ForceNotifyListUI mtn;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI$e$1 */
        static final class C31351 implements Runnable {
            final /* synthetic */ C28066e mtu;

            C31351(C28066e c28066e) {
                this.mtu = c28066e;
            }

            public final void run() {
                AppMethodBeat.m2504i(51077);
                RecyclerView c;
                if (this.mtu.mtn.mtl.isEmpty()) {
                    c = this.mtu.mtn.iJP;
                    if (c == null) {
                        C25052j.dWJ();
                    }
                    c.setVisibility(8);
                    View d = this.mtu.mtn.mtk;
                    if (d == null) {
                        C25052j.dWJ();
                    }
                    d.setVisibility(0);
                    AppMethodBeat.m2505o(51077);
                    return;
                }
                c = this.mtu.mtn.iJP;
                if (c == null) {
                    C25052j.dWJ();
                }
                c.setVisibility(0);
                C39098a b = this.mtu.mtn.mtj;
                if (b == null) {
                    C25052j.dWJ();
                }
                b.notifyDataSetChanged();
                AppMethodBeat.m2505o(51077);
            }
        }

        C28066e(ForceNotifyListUI forceNotifyListUI) {
            this.mtn = forceNotifyListUI;
        }

        public final void run() {
            AppMethodBeat.m2504i(51078);
            this.mtn.mtl.clear();
            ArrayList a = this.mtn.mtl;
            C43100c c43100c = C43100c.mtf;
            a.addAll(C43100c.bxW());
            this.mtn.runOnUiThread(new C31351(this));
            AppMethodBeat.m2505o(51078);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u00052\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020\u001f2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006*"}, dWq = {"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnCreateContextMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "refreshView", "getRefreshView", "()Landroid/view/View;", "resetView", "Landroid/widget/LinearLayout;", "getResetView", "()Landroid/widget/LinearLayout;", "timeView", "Landroid/widget/TextView;", "getTimeView", "()Landroid/widget/TextView;", "titleView", "getTitleView", "username", "", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "", "plugin-force-notify_release"})
    /* renamed from: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI$b */
    public final class C39093b extends C41531v implements OnCreateContextMenuListener, C5279d {
        final ImageView gvq;
        final /* synthetic */ ForceNotifyListUI mtn;
        final TextView mto;
        final LinearLayout mtp;
        final View mtq;
        final TextView titleView;
        String username;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "onTouch"})
        /* renamed from: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI$b$1 */
        static final class C390941 implements OnTouchListener {
            final /* synthetic */ C39093b mtr;

            C390941(C39093b c39093b) {
                this.mtr = c39093b;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.m2504i(51067);
                C25052j.m39376p(view, "view");
                C25052j.m39376p(motionEvent, "event");
                switch (motionEvent.getAction()) {
                    case 0:
                        this.mtr.mtn.mtm[0] = (int) motionEvent.getRawX();
                        this.mtr.mtn.mtm[1] = (int) motionEvent.getRawY();
                        break;
                }
                AppMethodBeat.m2505o(51067);
                return false;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
        /* renamed from: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI$b$2 */
        static final class C390952 implements OnLongClickListener {
            final /* synthetic */ C39093b mtr;

            C390952(C39093b c39093b) {
                this.mtr = c39093b;
            }

            public final boolean onLongClick(View view) {
                AppMethodBeat.m2504i(51068);
                C4990ab.m7416i(this.mtr.mtn.TAG, "OnLongClick!");
                new C24088a(this.mtr.mtn.dxU()).mo39885a(view, 0, 0, this.mtr, this.mtr, this.mtr.mtn.mtm[0], this.mtr.mtn.mtm[1]);
                AppMethodBeat.m2505o(51068);
                return true;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI$b$3 */
        static final class C390963 implements OnClickListener {
            final /* synthetic */ C39093b mtr;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI$b$3$1 */
            static final class C390971 implements Runnable {
                final /* synthetic */ C390963 mts;

                C390971(C390963 c390963) {
                    this.mts = c390963;
                }

                public final void run() {
                    AppMethodBeat.m2504i(51069);
                    this.mts.mtr.mtq.animate().start();
                    AppMethodBeat.m2505o(51069);
                }
            }

            C390963(C39093b c39093b) {
                this.mtr = c39093b;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(51070);
                C4990ab.m7417i(this.mtr.mtn.TAG, "resetView onClick! username:%s", this.mtr.username);
                C43100c.mtf.mo36066Mn(this.mtr.username);
                this.mtr.mtq.animate().rotation(360.0f).setDuration(300).withEndAction(new C390971(this)).start();
                AppMethodBeat.m2505o(51070);
            }
        }

        public C39093b(ForceNotifyListUI forceNotifyListUI, View view) {
            C25052j.m39376p(view, "itemView");
            this.mtn = forceNotifyListUI;
            super(view);
            AppMethodBeat.m2504i(51073);
            View findViewById = view.findViewById(2131821183);
            if (findViewById == null) {
                C25052j.dWJ();
            }
            this.gvq = (ImageView) findViewById;
            findViewById = view.findViewById(2131821185);
            if (findViewById == null) {
                C25052j.dWJ();
            }
            this.titleView = (TextView) findViewById;
            findViewById = view.findViewById(2131824115);
            if (findViewById == null) {
                C25052j.dWJ();
            }
            this.mto = (TextView) findViewById;
            findViewById = view.findViewById(2131824116);
            if (findViewById == null) {
                C25052j.dWJ();
            }
            this.mtp = (LinearLayout) findViewById;
            findViewById = view.findViewById(2131824117);
            if (findViewById == null) {
                C25052j.dWJ();
            }
            this.mtq = findViewById;
            View findViewById2 = view.findViewById(2131821019);
            findViewById2.setOnTouchListener(new C390941(this));
            findViewById2.setOnLongClickListener(new C390952(this));
            this.mtp.setOnClickListener(new C390963(this));
            AppMethodBeat.m2505o(51073);
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(51071);
            if (C5023at.isNetworkConnected(C4996ah.getContext())) {
                this.mtn.mtl.remove(mo66454kj());
                C39098a b = this.mtn.mtj;
                if (b == null) {
                    C25052j.dWJ();
                }
                b.mo66318ci(mo66454kj());
                C43100c.mtf.mo36069am(this.username, 4);
                if (this.mtn.mtl.isEmpty()) {
                    RecyclerView c = this.mtn.iJP;
                    if (c == null) {
                        C25052j.dWJ();
                    }
                    c.setVisibility(8);
                    View d = this.mtn.mtk;
                    if (d == null) {
                        C25052j.dWJ();
                    }
                    d.setVisibility(0);
                }
                AppMethodBeat.m2505o(51071);
                return;
            }
            Toast.makeText(this.mtn.dxU(), this.mtn.getResources().getText(C25738R.string.bx9), 1).show();
            AppMethodBeat.m2505o(51071);
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(51072);
            C25052j.m39376p(contextMenu, "menu");
            Context baseContext = this.mtn.getBaseContext();
            C25052j.m39375o(baseContext, "baseContext");
            contextMenu.add(baseContext.getResources().getString(C25738R.string.bzc));
            AppMethodBeat.m2505o(51072);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u001c\u0010\u000b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder;", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;", "(Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-force-notify_release"})
    /* renamed from: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI$a */
    public final class C39098a extends C41523a<C39093b> {
        public final int getItemCount() {
            AppMethodBeat.m2504i(51065);
            int size = ForceNotifyListUI.this.mtl.size();
            AppMethodBeat.m2505o(51065);
            return size;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ForceNotifyListUI() {
        AppMethodBeat.m2504i(51083);
        AppMethodBeat.m2505o(51083);
    }

    public final int getLayoutId() {
        return 2130969587;
    }

    public final void onBackPressed() {
        AppMethodBeat.m2504i(51079);
        super.onBackPressed();
        finish();
        AppMethodBeat.m2505o(51079);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(51080);
        super.onCreate(bundle);
        C45947a.mth.mo10116c(this);
        setMMTitle((int) C25738R.string.bz_);
        setBackBtn(new C28065c(this));
        this.jcv = findViewById(2131824118);
        this.mtk = findViewById(2131821499);
        this.iJP = (RecyclerView) findViewById(2131820986);
        RecyclerView recyclerView = this.iJP;
        if (recyclerView == null) {
            C25052j.dWJ();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager());
        this.mtj = new C39098a();
        recyclerView = this.iJP;
        if (recyclerView == null) {
            C25052j.dWJ();
        }
        recyclerView.setAdapter(this.mtj);
        C7305d.xDG.execute(new C20775d(this));
        ((C28062a) C1720g.m3528K(C28062a.class)).mo36078e("", 1, C1839cb.aaE() / 1000);
        AppMethodBeat.m2505o(51080);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(51081);
        super.onDestroy();
        C45947a.mth.mo10117d(this);
        ((C28062a) C1720g.m3528K(C28062a.class)).mo36078e("", 2, C1839cb.aaE() / 1000);
        AppMethodBeat.m2505o(51081);
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(51082);
        C4990ab.m7417i(this.TAG, "[onNotifyChange] event:%s", str);
        C7305d.xDG.execute(new C28066e(this));
        AppMethodBeat.m2505o(51082);
    }
}
