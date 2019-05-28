package com.tencent.p177mm.plugin.card.p355ui.p356v2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.os.Bundle;
import android.support.p069v7.widget.C31899z;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.C11052a;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.MRecyclerView.C11053b;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.MRecyclerView.C2594a;
import com.tencent.p177mm.plugin.card.model.p353a.C33767i;
import com.tencent.p177mm.plugin.card.model.p353a.C42846b;
import com.tencent.p177mm.plugin.card.model.p353a.C45781a;
import com.tencent.p177mm.plugin.card.model.p353a.C45781a.C27578a;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C44127hr;
import com.tencent.p177mm.protocal.protobuf.C46596wm;
import com.tencent.p177mm.protocal.protobuf.aku;
import com.tencent.p177mm.protocal.protobuf.bih;
import com.tencent.p177mm.protocal.protobuf.bik;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C17355d;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 12\u00020\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\b\u0010 \u001a\u00020\u0018H\u0014J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001bH\u0014J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\tH\u0002J\b\u0010$\u001a\u00020\u001bH\u0002J\u0012\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u001bH\u0014J\u0018\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0004H\u0016J\b\u0010,\u001a\u00020\u001bH\u0002J\u0012\u0010-\u001a\u00020\u001b2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\b\u00100\u001a\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardInvalidTicketListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "firstLoad", "", "isAll", "isLoading", "isShowClearBtn", "mInvalidTicketList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "mTicketAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "getMTicketAdapter", "()Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "setMTicketAdapter", "(Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;)V", "mTicketRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "getMTicketRv", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "setMTicketRv", "(Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;)V", "offset", "", "reqNum", "doClearInvalidTicketList", "", "doDeleteInvalidTicket", "cardId", "", "doGetInvalidTicketHomePage", "getLayoutId", "gotoCardDetailUI", "initView", "invalidTicketIds", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "saveSnapshot", "updateModelList", "ticketList", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "updateOptionMenu", "Companion", "plugin-card_release"})
/* renamed from: com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI */
public final class CardInvalidTicketListUI extends CardNewBaseUI {
    public static final C20189a kpJ = new C20189a();
    private boolean exX = true;
    private boolean isLoading;
    private int koB = 10;
    private boolean koC;
    public LoadMoreRecyclerView kpF;
    public C38773c kpG;
    private ArrayList<C45798d> kpH = new ArrayList();
    private boolean kpI;
    private int offset;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI$h */
    static final class C2786h implements OnMenuItemClickListener {
        final /* synthetic */ CardInvalidTicketListUI kpK;

        C2786h(CardInvalidTicketListUI cardInvalidTicketListUI) {
            this.kpK = cardInvalidTicketListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(89259);
            this.kpK.finish();
            AppMethodBeat.m2505o(89259);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032&\u0010\u0005\u001a\"\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0006¨\u0006\u00010\u0006¨\u0006\u0001H\n¢\u0006\u0002\b\b"}, dWq = {"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI$e */
    static final class C11342e implements C11052a {
        final /* synthetic */ CardInvalidTicketListUI kpK;

        C11342e(CardInvalidTicketListUI cardInvalidTicketListUI) {
            this.kpK = cardInvalidTicketListUI;
        }

        public final void aMC() {
            AppMethodBeat.m2504i(89254);
            CardInvalidTicketListUI.m31219a(this.kpK);
            AppMethodBeat.m2505o(89254);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI$f */
    static final class C11343f implements C2594a {
        final /* synthetic */ CardInvalidTicketListUI kpK;

        C11343f(CardInvalidTicketListUI cardInvalidTicketListUI) {
            this.kpK = cardInvalidTicketListUI;
        }

        /* renamed from: I */
        public final void mo6645I(View view, int i) {
            AppMethodBeat.m2504i(89255);
            C4990ab.m7416i("MicroMsg.CardInvalidTicketListUI", "click item");
            C45798d tl = this.kpK.bem().mo61653tl(i);
            if (tl != null) {
                switch (tl.type) {
                    case 2:
                        bih bih = tl.kqe;
                        if (bih != null) {
                            CardInvalidTicketListUI cardInvalidTicketListUI = this.kpK;
                            String str = bih.vCb;
                            C25052j.m39375o(str, "user_card_id");
                            CardInvalidTicketListUI.m31222a(cardInvalidTicketListUI, str);
                            AppMethodBeat.m2505o(89255);
                            return;
                        }
                        break;
                }
                AppMethodBeat.m2505o(89255);
                return;
            }
            AppMethodBeat.m2505o(89255);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI$g */
    static final class C16724g implements C11053b {
        final /* synthetic */ CardInvalidTicketListUI kpK;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardInvalidTicketListUI$initView$3$1$2"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI$g$b */
        static final class C16725b implements C5279d {
            final /* synthetic */ C16724g kpM;
            final /* synthetic */ C45798d kpN;

            C16725b(C16724g c16724g, C45798d c45798d) {
                this.kpM = c16724g;
                this.kpN = c45798d;
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(89257);
                C25052j.m39375o(menuItem, "menuItem");
                switch (menuItem.getItemId()) {
                    case 1:
                        CardInvalidTicketListUI cardInvalidTicketListUI = this.kpM.kpK;
                        bih bih = this.kpN.kqe;
                        if (bih == null) {
                            C25052j.dWJ();
                        }
                        String str = bih.vCb;
                        C25052j.m39375o(str, "model.ticketElement!!.user_card_id");
                        CardInvalidTicketListUI.m31226b(cardInvalidTicketListUI, str);
                        break;
                }
                AppMethodBeat.m2505o(89257);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/card/ui/v2/CardInvalidTicketListUI$initView$3$1$1"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI$g$a */
        static final class C16726a implements C36073c {
            final /* synthetic */ C16724g kpM;
            final /* synthetic */ C45798d kpN;

            C16726a(C16724g c16724g, C45798d c45798d) {
                this.kpM = c16724g;
                this.kpN = c45798d;
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(89256);
                c44273l.mo70068e(1, this.kpM.kpK.getString(C25738R.string.f9088p4));
                AppMethodBeat.m2505o(89256);
            }
        }

        C16724g(CardInvalidTicketListUI cardInvalidTicketListUI) {
            this.kpK = cardInvalidTicketListUI;
        }

        /* renamed from: L */
        public final boolean mo7100L(View view, int i) {
            AppMethodBeat.m2504i(89258);
            C4990ab.m7416i("MicroMsg.CardInvalidTicketListUI", "long click item");
            C45798d tl = this.kpK.bem().mo61653tl(i);
            if (tl != null) {
                switch (tl.type) {
                    case 2:
                        C46696j c46696j = new C46696j(this.kpK.dxU());
                        c46696j.mo75007a((C36073c) new C16726a(this, tl));
                        c46696j.mo75008a((C5279d) new C16725b(this, tl));
                        c46696j.cuu();
                        break;
                }
            }
            AppMethodBeat.m2505o(89258);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI$i */
    static final class C20186i implements OnMenuItemClickListener {
        final /* synthetic */ CardInvalidTicketListUI kpK;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI$i$1 */
        static final class C201871 implements OnClickListener {
            final /* synthetic */ C20186i kpO;

            C201871(C20186i c20186i) {
                this.kpO = c20186i;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(89260);
                CardInvalidTicketListUI.m31233h(this.kpO.kpK);
                C7060h.pYm.mo8381e(16322, Integer.valueOf(11));
                AppMethodBeat.m2505o(89260);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI$i$2 */
        static final class C201882 implements OnClickListener {
            public static final C201882 kpP = new C201882();

            static {
                AppMethodBeat.m2504i(89262);
                AppMethodBeat.m2505o(89262);
            }

            C201882() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(89261);
                dialogInterface.dismiss();
                C7060h.pYm.mo8381e(16322, Integer.valueOf(12));
                AppMethodBeat.m2505o(89261);
            }
        }

        C20186i(CardInvalidTicketListUI cardInvalidTicketListUI) {
            this.kpK = cardInvalidTicketListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(89263);
            C30379h.m48453a((Context) this.kpK.dxU(), false, this.kpK.getString(C25738R.string.aez), "", this.kpK.getString(C25738R.string.atd), this.kpK.getString(C25738R.string.atb), (OnClickListener) new C201871(this), (OnClickListener) C201882.kpP);
            C7060h.pYm.mo8381e(16322, Integer.valueOf(10));
            AppMethodBeat.m2505o(89263);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardInvalidTicketListUI$Companion;", "", "()V", "TAG", "", "plugin-card_release"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI$a */
    public static final class C20189a {
        private C20189a() {
        }

        public /* synthetic */ C20189a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInInvalidListResponse;", "call"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI$c */
    static final class C20190c<_Ret, _Var> implements C5681a<_Ret, _Var> {
        final /* synthetic */ CardInvalidTicketListUI kpK;
        final /* synthetic */ String kpL;

        C20190c(CardInvalidTicketListUI cardInvalidTicketListUI, String str) {
            this.kpK = cardInvalidTicketListUI;
            this.kpL = str;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(89252);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.CardInvalidTicketListUI", "errtype: %s, errcode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                btd btd = c37441a.fsy;
                C46596wm c46596wm = (C46596wm) btd;
                C4990ab.m7417i("MicroMsg.CardInvalidTicketListUI", "retCode: %s", Integer.valueOf(c46596wm.kdT));
                if (c46596wm.kdT == 0) {
                    this.kpK.bem().mo61648GZ(this.kpL);
                } else {
                    C38736l.m65716ai(this.kpK, c46596wm.kdU);
                }
                AppMethodBeat.m2505o(89252);
                return btd;
            }
            C38736l.m65717aj(this.kpK, "");
            Object obj2 = C37091y.AUy;
            AppMethodBeat.m2505o(89252);
            return obj2;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/BatchDeleteCardInInvalidListResponse;", "call"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI$b */
    static final class C20191b<_Ret, _Var> implements C5681a<_Ret, _Var> {
        final /* synthetic */ CardInvalidTicketListUI kpK;

        C20191b(CardInvalidTicketListUI cardInvalidTicketListUI) {
            this.kpK = cardInvalidTicketListUI;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(89251);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.CardInvalidTicketListUI", "errtype: %s, errcode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                btd btd = c37441a.fsy;
                C44127hr c44127hr = (C44127hr) btd;
                C4990ab.m7417i("MicroMsg.CardInvalidTicketListUI", "retCode: %s", Integer.valueOf(c44127hr.kdT));
                if (c44127hr.kdT == 0) {
                    this.kpK.kpH.clear();
                    CardInvalidTicketListUI.m31229d(this.kpK);
                    this.kpK.bem().notifyDataSetChanged();
                } else {
                    C38736l.m65716ai(this.kpK, c44127hr.kdU);
                }
                AppMethodBeat.m2505o(89251);
                return btd;
            }
            C38736l.m65717aj(this.kpK, "");
            Object obj2 = C37091y.AUy;
            AppMethodBeat.m2505o(89251);
            return obj2;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktInvalidTicketHomePageResponse;", "call"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI$d */
    static final class C20192d<_Ret, _Var> implements C5681a<_Ret, _Var> {
        final /* synthetic */ CardInvalidTicketListUI kpK;

        C20192d(CardInvalidTicketListUI cardInvalidTicketListUI) {
            this.kpK = cardInvalidTicketListUI;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(89253);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.CardInvalidTicketListUI", "errtype: %s, errcode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
            this.kpK.isLoading = false;
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                btd btd = c37441a.fsy;
                aku aku = (aku) btd;
                C4990ab.m7417i("MicroMsg.CardInvalidTicketListUI", "retCode: %s", Integer.valueOf(aku.kdT));
                if (aku.kdT == 0) {
                    boolean z;
                    this.kpK.offset = aku.kKI;
                    CardInvalidTicketListUI cardInvalidTicketListUI = this.kpK;
                    if (aku.wqk == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    cardInvalidTicketListUI.koC = z;
                    cardInvalidTicketListUI = this.kpK;
                    if (aku.wqs == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    cardInvalidTicketListUI.kpI = z;
                    CardInvalidTicketListUI.m31229d(this.kpK);
                    if (this.kpK.koC) {
                        this.kpK.bel().mo22757fh(false);
                    } else {
                        this.kpK.bel().mo22757fh(true);
                    }
                    if (this.kpK.exX) {
                        this.kpK.kpH.clear();
                        this.kpK.exX = false;
                    }
                    CardInvalidTicketListUI.m31221a(this.kpK, aku.wqr);
                } else {
                    if (this.kpK.exX) {
                        this.kpK.exX = false;
                    }
                    C38736l.m65716ai(this.kpK, aku.kdU);
                }
                AppMethodBeat.m2505o(89253);
                return btd;
            }
            if (this.kpK.exX) {
                this.kpK.exX = false;
            }
            C38736l.m65717aj(this.kpK, "");
            Object obj2 = C37091y.AUy;
            AppMethodBeat.m2505o(89253);
            return obj2;
        }
    }

    static {
        AppMethodBeat.m2504i(89273);
        AppMethodBeat.m2505o(89273);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public CardInvalidTicketListUI() {
        AppMethodBeat.m2504i(89272);
        AppMethodBeat.m2505o(89272);
    }

    public final LoadMoreRecyclerView bel() {
        AppMethodBeat.m2504i(89264);
        LoadMoreRecyclerView loadMoreRecyclerView = this.kpF;
        if (loadMoreRecyclerView == null) {
            C25052j.avw("mTicketRv");
        }
        AppMethodBeat.m2505o(89264);
        return loadMoreRecyclerView;
    }

    public final C38773c bem() {
        AppMethodBeat.m2504i(89265);
        C38773c c38773c = this.kpG;
        if (c38773c == null) {
            C25052j.avw("mTicketAdapter");
        }
        AppMethodBeat.m2505o(89265);
        return c38773c;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(89266);
        dxR();
        super.onCreate(bundle);
        mo17446xE(Color.parseColor("#f3f3f3"));
        dyb();
        initView();
        bik bik = new bik();
        C27578a c27578a = C45781a.kfc;
        C25052j.m39376p(bik, "invalidTicketList");
        C4990ab.m7410d(C45781a.TAG, "load invalid ticket page snapshot");
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        String str = (String) RP.mo5239Ry().mo16822i(C5127a.USERINFO_CARD_INVALID_TICKET_STRING_SYNC);
        if (str != null) {
            Charset charset = C17355d.ISO_8859_1;
            if (str == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.m2505o(89266);
                throw c44941v;
            }
            byte[] bytes = str.getBytes(charset);
            C25052j.m39375o(bytes, "(this as java.lang.String).getBytes(charset)");
            bik.parseFrom(bytes);
        }
        m31224a(bik);
        setMMTitle((int) C25738R.string.evy);
        setBackBtn(new C2786h(this));
        C7060h.pYm.mo8381e(16322, Integer.valueOf(9));
        AppMethodBeat.m2505o(89266);
    }

    public final void initView() {
        AppMethodBeat.m2504i(89267);
        View findViewById = findViewById(2131822330);
        C25052j.m39375o(findViewById, "findViewById(R.id.ctlu_rv)");
        this.kpF = (LoadMoreRecyclerView) findViewById;
        this.kpG = new C38773c(true);
        LoadMoreRecyclerView loadMoreRecyclerView = this.kpF;
        if (loadMoreRecyclerView == null) {
            C25052j.avw("mTicketRv");
        }
        C38773c c38773c = this.kpG;
        if (c38773c == null) {
            C25052j.avw("mTicketAdapter");
        }
        loadMoreRecyclerView.setAdapter(c38773c);
        loadMoreRecyclerView = this.kpF;
        if (loadMoreRecyclerView == null) {
            C25052j.avw("mTicketRv");
        }
        loadMoreRecyclerView.setLayoutManager(new LinearLayoutManager());
        LoadMoreRecyclerView loadMoreRecyclerView2 = this.kpF;
        if (loadMoreRecyclerView2 == null) {
            C25052j.avw("mTicketRv");
        }
        loadMoreRecyclerView2.setEmptyView(findViewById(2131822163));
        loadMoreRecyclerView2 = this.kpF;
        if (loadMoreRecyclerView2 == null) {
            C25052j.avw("mTicketRv");
        }
        TextView textView = (TextView) loadMoreRecyclerView2.getEmptyView().findViewById(2131822164);
        C25052j.m39375o(textView, "emptyTv");
        textView.setText(getString(C25738R.string.agp));
        C31899z c31899z = new C31899z(this);
        c31899z.setDrawable(getResources().getDrawable(C25738R.drawable.f6513gn));
        LoadMoreRecyclerView loadMoreRecyclerView3 = this.kpF;
        if (loadMoreRecyclerView3 == null) {
            C25052j.avw("mTicketRv");
        }
        loadMoreRecyclerView3.mo66346b((C25373h) c31899z);
        loadMoreRecyclerView2 = this.kpF;
        if (loadMoreRecyclerView2 == null) {
            C25052j.avw("mTicketRv");
        }
        loadMoreRecyclerView2.setLoadingView(2130968937);
        loadMoreRecyclerView = this.kpF;
        if (loadMoreRecyclerView == null) {
            C25052j.avw("mTicketRv");
        }
        loadMoreRecyclerView.setOnLoadingStateChangedListener(new C11342e(this));
        loadMoreRecyclerView = this.kpF;
        if (loadMoreRecyclerView == null) {
            C25052j.avw("mTicketRv");
        }
        loadMoreRecyclerView.setOnItemClickListener(new C11343f(this));
        loadMoreRecyclerView = this.kpF;
        if (loadMoreRecyclerView == null) {
            C25052j.avw("mTicketRv");
        }
        loadMoreRecyclerView.setOnItemLongClickListener(new C16724g(this));
        AppMethodBeat.m2505o(89267);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(89268);
        super.onDestroy();
        bik bik = new bik();
        bik.wLN = new LinkedList();
        Iterator it = this.kpH.iterator();
        while (it.hasNext()) {
            bih bih = ((C45798d) it.next()).kqe;
            if (bih != null) {
                bik.wLN.add(bih);
            }
        }
        C27578a c27578a = C45781a.kfc;
        C25052j.m39376p(bik, "invalidTicketList");
        C4990ab.m7410d(C45781a.TAG, "save invalid ticket snapshot");
        byte[] toByteArray = bik.toByteArray();
        C25052j.m39375o(toByteArray, "invalidTicketList.toByteArray()");
        Object str = new String(toByteArray, C17355d.ISO_8859_1);
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        RP.mo5239Ry().set(C5127a.USERINFO_CARD_INVALID_TICKET_STRING_SYNC, str);
        AppMethodBeat.m2505o(89268);
    }

    public final int getLayoutId() {
        return 2130968995;
    }

    /* renamed from: P */
    public final void mo23051P(int i, boolean z) {
        AppMethodBeat.m2504i(89269);
        C4990ab.m7417i("MicroMsg.CardInvalidTicketListUI", "location finish: [%s, %s], ret: %s, isOk: %s", Float.valueOf(this.cEB), Float.valueOf(this.cGm), Integer.valueOf(i), Boolean.valueOf(z));
        if (this.exX) {
            ben();
            AppMethodBeat.m2505o(89269);
            return;
        }
        if (!z) {
            bep();
        }
        AppMethodBeat.m2505o(89269);
    }

    /* renamed from: a */
    private final void m31224a(bik bik) {
        AppMethodBeat.m2504i(89270);
        if (bik != null) {
            LinkedList linkedList = bik.wLN;
            C25052j.m39375o(linkedList, "page_ticket_element");
            if ((!((Collection) linkedList).isEmpty() ? 1 : null) != null) {
                Iterator it = bik.wLN.iterator();
                while (it.hasNext()) {
                    bih bih = (bih) it.next();
                    C45798d c45798d = new C45798d();
                    c45798d.kqe = bih;
                    c45798d.type = 2;
                    this.kpH.add(c45798d);
                }
            }
        }
        C38773c c38773c = this.kpG;
        if (c38773c == null) {
            C25052j.avw("mTicketAdapter");
        }
        c38773c.mo61651a(null, this.kpH, null);
        AppMethodBeat.m2505o(89270);
    }

    private final void ben() {
        AppMethodBeat.m2504i(89271);
        C4990ab.m7417i("MicroMsg.CardInvalidTicketListUI", "do get invalid ticket: %s, %s, %s, %s", Integer.valueOf(this.offset), Integer.valueOf(this.koB), Boolean.valueOf(this.koC), Boolean.valueOf(this.isLoading));
        if (!(this.koC || this.isLoading)) {
            this.isLoading = true;
            new C33767i(this.offset, this.koB, (double) this.cEB, (double) this.cGm).acy().mo60487b((C5681a) new C20192d(this));
        }
        AppMethodBeat.m2505o(89271);
    }

    /* renamed from: d */
    public static final /* synthetic */ void m31229d(CardInvalidTicketListUI cardInvalidTicketListUI) {
        AppMethodBeat.m2504i(89277);
        C4990ab.m7417i("MicroMsg.CardInvalidTicketListUI", "update clear btn: %s", Boolean.valueOf(cardInvalidTicketListUI.kpI));
        if (cardInvalidTicketListUI.kpI) {
            cardInvalidTicketListUI.addTextOptionMenu(0, cardInvalidTicketListUI.getString(C25738R.string.acz), new C20186i(cardInvalidTicketListUI));
            if (cardInvalidTicketListUI.kpH.isEmpty()) {
                cardInvalidTicketListUI.enableOptionMenu(0, false);
                AppMethodBeat.m2505o(89277);
                return;
            }
            cardInvalidTicketListUI.enableOptionMenu(0, true);
            AppMethodBeat.m2505o(89277);
            return;
        }
        cardInvalidTicketListUI.removeOptionMenu(0);
        AppMethodBeat.m2505o(89277);
    }

    /* renamed from: h */
    public static final /* synthetic */ void m31233h(CardInvalidTicketListUI cardInvalidTicketListUI) {
        AppMethodBeat.m2504i(89279);
        C4990ab.m7416i("MicroMsg.CardInvalidTicketListUI", "do clear invalid ticket list");
        ArrayList arrayList = new ArrayList();
        Iterator it = cardInvalidTicketListUI.kpH.iterator();
        while (it.hasNext()) {
            C45798d c45798d = (C45798d) it.next();
            if (c45798d.type == 2) {
                bih bih = c45798d.kqe;
                if (bih == null) {
                    C25052j.dWJ();
                }
                arrayList.add(bih.vCb);
            }
        }
        new C42846b(arrayList).acy().mo60487b((C5681a) new C20191b(cardInvalidTicketListUI));
        AppMethodBeat.m2505o(89279);
    }
}
