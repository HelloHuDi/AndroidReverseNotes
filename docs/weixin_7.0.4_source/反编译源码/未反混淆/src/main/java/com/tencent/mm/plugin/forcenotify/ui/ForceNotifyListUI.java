package com.tencent.mm.plugin.forcenotify.ui;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0014J\u001c\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0018\u00010\u0007R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, dWq = {"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TAG", "", "adapter", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyListAdapter;", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "emptyTipView", "Landroid/view/View;", "loadingView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "touchLoc", "", "getLayoutId", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "ForceNotifyListAdapter", "ForceNotifyViewHolder", "plugin-force-notify_release"})
public final class ForceNotifyListUI extends MMActivity implements com.tencent.mm.sdk.e.k.a {
    private final String TAG = "MicroMsg.ForceNotifyListUI";
    private RecyclerView iJP;
    private View jcv;
    private a mtj;
    private View mtk;
    private final ArrayList<com.tencent.mm.plugin.forcenotify.c.b> mtl = new ArrayList();
    private final int[] mtm = new int[2];

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ ForceNotifyListUI mtn;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI$d$1 */
        static final class AnonymousClass1 implements Runnable {
            final /* synthetic */ d mtt;

            AnonymousClass1(d dVar) {
                this.mtt = dVar;
            }

            public final void run() {
                AppMethodBeat.i(51075);
                a b = this.mtt.mtn.mtj;
                if (b == null) {
                    j.dWJ();
                }
                b.notifyDataSetChanged();
                View g = this.mtt.mtn.jcv;
                if (g == null) {
                    j.dWJ();
                }
                g.setVisibility(8);
                RecyclerView c;
                if (this.mtt.mtn.mtl.isEmpty()) {
                    c = this.mtt.mtn.iJP;
                    if (c == null) {
                        j.dWJ();
                    }
                    c.setVisibility(8);
                    g = this.mtt.mtn.mtk;
                    if (g == null) {
                        j.dWJ();
                    }
                    g.setVisibility(0);
                    AppMethodBeat.o(51075);
                    return;
                }
                c = this.mtt.mtn.iJP;
                if (c == null) {
                    j.dWJ();
                }
                c.setVisibility(0);
                AppMethodBeat.o(51075);
            }
        }

        d(ForceNotifyListUI forceNotifyListUI) {
            this.mtn = forceNotifyListUI;
        }

        public final void run() {
            AppMethodBeat.i(51076);
            this.mtn.mtl.clear();
            ArrayList a = this.mtn.mtl;
            com.tencent.mm.plugin.forcenotify.b.c cVar = com.tencent.mm.plugin.forcenotify.b.c.mtf;
            a.addAll(com.tencent.mm.plugin.forcenotify.b.c.bxW());
            this.mtn.runOnUiThread(new AnonymousClass1(this));
            AppMethodBeat.o(51076);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class c implements OnMenuItemClickListener {
        final /* synthetic */ ForceNotifyListUI mtn;

        c(ForceNotifyListUI forceNotifyListUI) {
            this.mtn = forceNotifyListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(51074);
            this.mtn.onBackPressed();
            AppMethodBeat.o(51074);
            return true;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ ForceNotifyListUI mtn;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI$e$1 */
        static final class AnonymousClass1 implements Runnable {
            final /* synthetic */ e mtu;

            AnonymousClass1(e eVar) {
                this.mtu = eVar;
            }

            public final void run() {
                AppMethodBeat.i(51077);
                RecyclerView c;
                if (this.mtu.mtn.mtl.isEmpty()) {
                    c = this.mtu.mtn.iJP;
                    if (c == null) {
                        j.dWJ();
                    }
                    c.setVisibility(8);
                    View d = this.mtu.mtn.mtk;
                    if (d == null) {
                        j.dWJ();
                    }
                    d.setVisibility(0);
                    AppMethodBeat.o(51077);
                    return;
                }
                c = this.mtu.mtn.iJP;
                if (c == null) {
                    j.dWJ();
                }
                c.setVisibility(0);
                a b = this.mtu.mtn.mtj;
                if (b == null) {
                    j.dWJ();
                }
                b.notifyDataSetChanged();
                AppMethodBeat.o(51077);
            }
        }

        e(ForceNotifyListUI forceNotifyListUI) {
            this.mtn = forceNotifyListUI;
        }

        public final void run() {
            AppMethodBeat.i(51078);
            this.mtn.mtl.clear();
            ArrayList a = this.mtn.mtl;
            com.tencent.mm.plugin.forcenotify.b.c cVar = com.tencent.mm.plugin.forcenotify.b.c.mtf;
            a.addAll(com.tencent.mm.plugin.forcenotify.b.c.bxW());
            this.mtn.runOnUiThread(new AnonymousClass1(this));
            AppMethodBeat.o(51078);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u00052\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020\u001f2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006*"}, dWq = {"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnCreateContextMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "refreshView", "getRefreshView", "()Landroid/view/View;", "resetView", "Landroid/widget/LinearLayout;", "getResetView", "()Landroid/widget/LinearLayout;", "timeView", "Landroid/widget/TextView;", "getTimeView", "()Landroid/widget/TextView;", "titleView", "getTitleView", "username", "", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "", "plugin-force-notify_release"})
    public final class b extends v implements OnCreateContextMenuListener, com.tencent.mm.ui.base.n.d {
        final ImageView gvq;
        final /* synthetic */ ForceNotifyListUI mtn;
        final TextView mto;
        final LinearLayout mtp;
        final View mtq;
        final TextView titleView;
        String username;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "onTouch"})
        /* renamed from: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI$b$1 */
        static final class AnonymousClass1 implements OnTouchListener {
            final /* synthetic */ b mtr;

            AnonymousClass1(b bVar) {
                this.mtr = bVar;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(51067);
                j.p(view, "view");
                j.p(motionEvent, "event");
                switch (motionEvent.getAction()) {
                    case 0:
                        this.mtr.mtn.mtm[0] = (int) motionEvent.getRawX();
                        this.mtr.mtn.mtm[1] = (int) motionEvent.getRawY();
                        break;
                }
                AppMethodBeat.o(51067);
                return false;
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
        /* renamed from: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI$b$2 */
        static final class AnonymousClass2 implements OnLongClickListener {
            final /* synthetic */ b mtr;

            AnonymousClass2(b bVar) {
                this.mtr = bVar;
            }

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(51068);
                ab.i(this.mtr.mtn.TAG, "OnLongClick!");
                new com.tencent.mm.ui.widget.b.a(this.mtr.mtn.dxU()).a(view, 0, 0, this.mtr, this.mtr, this.mtr.mtn.mtm[0], this.mtr.mtn.mtm[1]);
                AppMethodBeat.o(51068);
                return true;
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI$b$3 */
        static final class AnonymousClass3 implements OnClickListener {
            final /* synthetic */ b mtr;

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI$b$3$1 */
            static final class AnonymousClass1 implements Runnable {
                final /* synthetic */ AnonymousClass3 mts;

                AnonymousClass1(AnonymousClass3 anonymousClass3) {
                    this.mts = anonymousClass3;
                }

                public final void run() {
                    AppMethodBeat.i(51069);
                    this.mts.mtr.mtq.animate().start();
                    AppMethodBeat.o(51069);
                }
            }

            AnonymousClass3(b bVar) {
                this.mtr = bVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(51070);
                ab.i(this.mtr.mtn.TAG, "resetView onClick! username:%s", this.mtr.username);
                com.tencent.mm.plugin.forcenotify.b.c.mtf.Mn(this.mtr.username);
                this.mtr.mtq.animate().rotation(360.0f).setDuration(300).withEndAction(new AnonymousClass1(this)).start();
                AppMethodBeat.o(51070);
            }
        }

        public b(ForceNotifyListUI forceNotifyListUI, View view) {
            j.p(view, "itemView");
            this.mtn = forceNotifyListUI;
            super(view);
            AppMethodBeat.i(51073);
            View findViewById = view.findViewById(R.id.qk);
            if (findViewById == null) {
                j.dWJ();
            }
            this.gvq = (ImageView) findViewById;
            findViewById = view.findViewById(R.id.qm);
            if (findViewById == null) {
                j.dWJ();
            }
            this.titleView = (TextView) findViewById;
            findViewById = view.findViewById(R.id.bvi);
            if (findViewById == null) {
                j.dWJ();
            }
            this.mto = (TextView) findViewById;
            findViewById = view.findViewById(R.id.bvj);
            if (findViewById == null) {
                j.dWJ();
            }
            this.mtp = (LinearLayout) findViewById;
            findViewById = view.findViewById(R.id.bvk);
            if (findViewById == null) {
                j.dWJ();
            }
            this.mtq = findViewById;
            View findViewById2 = view.findViewById(R.id.m5);
            findViewById2.setOnTouchListener(new AnonymousClass1(this));
            findViewById2.setOnLongClickListener(new AnonymousClass2(this));
            this.mtp.setOnClickListener(new AnonymousClass3(this));
            AppMethodBeat.o(51073);
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(51071);
            if (at.isNetworkConnected(ah.getContext())) {
                this.mtn.mtl.remove(kj());
                a b = this.mtn.mtj;
                if (b == null) {
                    j.dWJ();
                }
                b.ci(kj());
                com.tencent.mm.plugin.forcenotify.b.c.mtf.am(this.username, 4);
                if (this.mtn.mtl.isEmpty()) {
                    RecyclerView c = this.mtn.iJP;
                    if (c == null) {
                        j.dWJ();
                    }
                    c.setVisibility(8);
                    View d = this.mtn.mtk;
                    if (d == null) {
                        j.dWJ();
                    }
                    d.setVisibility(0);
                }
                AppMethodBeat.o(51071);
                return;
            }
            Toast.makeText(this.mtn.dxU(), this.mtn.getResources().getText(R.string.bx9), 1).show();
            AppMethodBeat.o(51071);
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(51072);
            j.p(contextMenu, "menu");
            Context baseContext = this.mtn.getBaseContext();
            j.o(baseContext, "baseContext");
            contextMenu.add(baseContext.getResources().getString(R.string.bzc));
            AppMethodBeat.o(51072);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u001c\u0010\u000b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI$ForceNotifyViewHolder;", "Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;", "(Lcom/tencent/mm/plugin/forcenotify/ui/ForceNotifyListUI;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-force-notify_release"})
    public final class a extends android.support.v7.widget.RecyclerView.a<b> {
        public final int getItemCount() {
            AppMethodBeat.i(51065);
            int size = ForceNotifyListUI.this.mtl.size();
            AppMethodBeat.o(51065);
            return size;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ForceNotifyListUI() {
        AppMethodBeat.i(51083);
        AppMethodBeat.o(51083);
    }

    public final int getLayoutId() {
        return R.layout.a0i;
    }

    public final void onBackPressed() {
        AppMethodBeat.i(51079);
        super.onBackPressed();
        finish();
        AppMethodBeat.o(51079);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(51080);
        super.onCreate(bundle);
        com.tencent.mm.plugin.forcenotify.d.a.mth.c(this);
        setMMTitle((int) R.string.bz_);
        setBackBtn(new c(this));
        this.jcv = findViewById(R.id.bvl);
        this.mtk = findViewById(R.id.ys);
        this.iJP = (RecyclerView) findViewById(R.id.l9);
        RecyclerView recyclerView = this.iJP;
        if (recyclerView == null) {
            j.dWJ();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager());
        this.mtj = new a();
        recyclerView = this.iJP;
        if (recyclerView == null) {
            j.dWJ();
        }
        recyclerView.setAdapter(this.mtj);
        com.tencent.mm.sdk.g.d.xDG.execute(new d(this));
        ((com.tencent.mm.plugin.forcenotify.a.a) g.K(com.tencent.mm.plugin.forcenotify.a.a.class)).e("", 1, cb.aaE() / 1000);
        AppMethodBeat.o(51080);
    }

    public final void onDestroy() {
        AppMethodBeat.i(51081);
        super.onDestroy();
        com.tencent.mm.plugin.forcenotify.d.a.mth.d(this);
        ((com.tencent.mm.plugin.forcenotify.a.a) g.K(com.tencent.mm.plugin.forcenotify.a.a.class)).e("", 2, cb.aaE() / 1000);
        AppMethodBeat.o(51081);
    }

    public final void a(String str, m mVar) {
        AppMethodBeat.i(51082);
        ab.i(this.TAG, "[onNotifyChange] event:%s", str);
        com.tencent.mm.sdk.g.d.xDG.execute(new e(this));
        AppMethodBeat.o(51082);
    }
}
