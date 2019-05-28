package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import a.v;
import a.y;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.z;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.protocal.protobuf.aku;
import com.tencent.mm.protocal.protobuf.bih;
import com.tencent.mm.protocal.protobuf.bik;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.hr;
import com.tencent.mm.protocal.protobuf.wm;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 12\u00020\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\b\u0010 \u001a\u00020\u0018H\u0014J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001bH\u0014J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\tH\u0002J\b\u0010$\u001a\u00020\u001bH\u0002J\u0012\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u001bH\u0014J\u0018\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0004H\u0016J\b\u0010,\u001a\u00020\u001bH\u0002J\u0012\u0010-\u001a\u00020\u001b2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\b\u00100\u001a\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardInvalidTicketListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "firstLoad", "", "isAll", "isLoading", "isShowClearBtn", "mInvalidTicketList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "mTicketAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "getMTicketAdapter", "()Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "setMTicketAdapter", "(Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;)V", "mTicketRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "getMTicketRv", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "setMTicketRv", "(Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;)V", "offset", "", "reqNum", "doClearInvalidTicketList", "", "doDeleteInvalidTicket", "cardId", "", "doGetInvalidTicketHomePage", "getLayoutId", "gotoCardDetailUI", "initView", "invalidTicketIds", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "saveSnapshot", "updateModelList", "ticketList", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "updateOptionMenu", "Companion", "plugin-card_release"})
public final class CardInvalidTicketListUI extends CardNewBaseUI {
    public static final a kpJ = new a();
    private boolean exX = true;
    private boolean isLoading;
    private int koB = 10;
    private boolean koC;
    public LoadMoreRecyclerView kpF;
    public c kpG;
    private ArrayList<d> kpH = new ArrayList();
    private boolean kpI;
    private int offset;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class h implements OnMenuItemClickListener {
        final /* synthetic */ CardInvalidTicketListUI kpK;

        h(CardInvalidTicketListUI cardInvalidTicketListUI) {
            this.kpK = cardInvalidTicketListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(89259);
            this.kpK.finish();
            AppMethodBeat.o(89259);
            return false;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032&\u0010\u0005\u001a\"\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0006¨\u0006\u00010\u0006¨\u0006\u0001H\n¢\u0006\u0002\b\b"}, dWq = {"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
    static final class e implements com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a {
        final /* synthetic */ CardInvalidTicketListUI kpK;

        e(CardInvalidTicketListUI cardInvalidTicketListUI) {
            this.kpK = cardInvalidTicketListUI;
        }

        public final void aMC() {
            AppMethodBeat.i(89254);
            CardInvalidTicketListUI.a(this.kpK);
            AppMethodBeat.o(89254);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
    static final class f implements com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a {
        final /* synthetic */ CardInvalidTicketListUI kpK;

        f(CardInvalidTicketListUI cardInvalidTicketListUI) {
            this.kpK = cardInvalidTicketListUI;
        }

        public final void I(View view, int i) {
            AppMethodBeat.i(89255);
            ab.i("MicroMsg.CardInvalidTicketListUI", "click item");
            d tl = this.kpK.bem().tl(i);
            if (tl != null) {
                switch (tl.type) {
                    case 2:
                        bih bih = tl.kqe;
                        if (bih != null) {
                            CardInvalidTicketListUI cardInvalidTicketListUI = this.kpK;
                            String str = bih.vCb;
                            j.o(str, "user_card_id");
                            CardInvalidTicketListUI.a(cardInvalidTicketListUI, str);
                            AppMethodBeat.o(89255);
                            return;
                        }
                        break;
                }
                AppMethodBeat.o(89255);
                return;
            }
            AppMethodBeat.o(89255);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
    static final class g implements com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b {
        final /* synthetic */ CardInvalidTicketListUI kpK;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardInvalidTicketListUI$initView$3$1$2"})
        static final class b implements com.tencent.mm.ui.base.n.d {
            final /* synthetic */ g kpM;
            final /* synthetic */ d kpN;

            b(g gVar, d dVar) {
                this.kpM = gVar;
                this.kpN = dVar;
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(89257);
                j.o(menuItem, "menuItem");
                switch (menuItem.getItemId()) {
                    case 1:
                        CardInvalidTicketListUI cardInvalidTicketListUI = this.kpM.kpK;
                        bih bih = this.kpN.kqe;
                        if (bih == null) {
                            j.dWJ();
                        }
                        String str = bih.vCb;
                        j.o(str, "model.ticketElement!!.user_card_id");
                        CardInvalidTicketListUI.b(cardInvalidTicketListUI, str);
                        break;
                }
                AppMethodBeat.o(89257);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/card/ui/v2/CardInvalidTicketListUI$initView$3$1$1"})
        static final class a implements com.tencent.mm.ui.base.n.c {
            final /* synthetic */ g kpM;
            final /* synthetic */ d kpN;

            a(g gVar, d dVar) {
                this.kpM = gVar;
                this.kpN = dVar;
            }

            public final void a(com.tencent.mm.ui.base.l lVar) {
                AppMethodBeat.i(89256);
                lVar.e(1, this.kpM.kpK.getString(R.string.p4));
                AppMethodBeat.o(89256);
            }
        }

        g(CardInvalidTicketListUI cardInvalidTicketListUI) {
            this.kpK = cardInvalidTicketListUI;
        }

        public final boolean L(View view, int i) {
            AppMethodBeat.i(89258);
            ab.i("MicroMsg.CardInvalidTicketListUI", "long click item");
            d tl = this.kpK.bem().tl(i);
            if (tl != null) {
                switch (tl.type) {
                    case 2:
                        com.tencent.mm.ui.tools.j jVar = new com.tencent.mm.ui.tools.j(this.kpK.dxU());
                        jVar.a((com.tencent.mm.ui.base.n.c) new a(this, tl));
                        jVar.a((com.tencent.mm.ui.base.n.d) new b(this, tl));
                        jVar.cuu();
                        break;
                }
            }
            AppMethodBeat.o(89258);
            return false;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class i implements OnMenuItemClickListener {
        final /* synthetic */ CardInvalidTicketListUI kpK;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI$i$1 */
        static final class AnonymousClass1 implements OnClickListener {
            final /* synthetic */ i kpO;

            AnonymousClass1(i iVar) {
                this.kpO = iVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(89260);
                CardInvalidTicketListUI.h(this.kpO.kpK);
                com.tencent.mm.plugin.report.service.h.pYm.e(16322, Integer.valueOf(11));
                AppMethodBeat.o(89260);
            }
        }

        i(CardInvalidTicketListUI cardInvalidTicketListUI) {
            this.kpK = cardInvalidTicketListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(89263);
            com.tencent.mm.ui.base.h.a((Context) this.kpK.dxU(), false, this.kpK.getString(R.string.aez), "", this.kpK.getString(R.string.atd), this.kpK.getString(R.string.atb), (OnClickListener) new AnonymousClass1(this), (OnClickListener) AnonymousClass2.kpP);
            com.tencent.mm.plugin.report.service.h.pYm.e(16322, Integer.valueOf(10));
            AppMethodBeat.o(89263);
            return false;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardInvalidTicketListUI$Companion;", "", "()V", "TAG", "", "plugin-card_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInInvalidListResponse;", "call"})
    static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ CardInvalidTicketListUI kpK;
        final /* synthetic */ String kpL;

        c(CardInvalidTicketListUI cardInvalidTicketListUI, String str) {
            this.kpK = cardInvalidTicketListUI;
            this.kpL = str;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(89252);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.CardInvalidTicketListUI", "errtype: %s, errcode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                btd btd = aVar.fsy;
                wm wmVar = (wm) btd;
                ab.i("MicroMsg.CardInvalidTicketListUI", "retCode: %s", Integer.valueOf(wmVar.kdT));
                if (wmVar.kdT == 0) {
                    this.kpK.bem().GZ(this.kpL);
                } else {
                    com.tencent.mm.plugin.card.d.l.ai(this.kpK, wmVar.kdU);
                }
                AppMethodBeat.o(89252);
                return btd;
            }
            com.tencent.mm.plugin.card.d.l.aj(this.kpK, "");
            Object obj2 = y.AUy;
            AppMethodBeat.o(89252);
            return obj2;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/BatchDeleteCardInInvalidListResponse;", "call"})
    static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ CardInvalidTicketListUI kpK;

        b(CardInvalidTicketListUI cardInvalidTicketListUI) {
            this.kpK = cardInvalidTicketListUI;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(89251);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.CardInvalidTicketListUI", "errtype: %s, errcode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                btd btd = aVar.fsy;
                hr hrVar = (hr) btd;
                ab.i("MicroMsg.CardInvalidTicketListUI", "retCode: %s", Integer.valueOf(hrVar.kdT));
                if (hrVar.kdT == 0) {
                    this.kpK.kpH.clear();
                    CardInvalidTicketListUI.d(this.kpK);
                    this.kpK.bem().notifyDataSetChanged();
                } else {
                    com.tencent.mm.plugin.card.d.l.ai(this.kpK, hrVar.kdU);
                }
                AppMethodBeat.o(89251);
                return btd;
            }
            com.tencent.mm.plugin.card.d.l.aj(this.kpK, "");
            Object obj2 = y.AUy;
            AppMethodBeat.o(89251);
            return obj2;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktInvalidTicketHomePageResponse;", "call"})
    static final class d<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ CardInvalidTicketListUI kpK;

        d(CardInvalidTicketListUI cardInvalidTicketListUI) {
            this.kpK = cardInvalidTicketListUI;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(89253);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.CardInvalidTicketListUI", "errtype: %s, errcode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            this.kpK.isLoading = false;
            if (aVar.errType == 0 && aVar.errCode == 0) {
                btd btd = aVar.fsy;
                aku aku = (aku) btd;
                ab.i("MicroMsg.CardInvalidTicketListUI", "retCode: %s", Integer.valueOf(aku.kdT));
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
                    CardInvalidTicketListUI.d(this.kpK);
                    if (this.kpK.koC) {
                        this.kpK.bel().fh(false);
                    } else {
                        this.kpK.bel().fh(true);
                    }
                    if (this.kpK.exX) {
                        this.kpK.kpH.clear();
                        this.kpK.exX = false;
                    }
                    CardInvalidTicketListUI.a(this.kpK, aku.wqr);
                } else {
                    if (this.kpK.exX) {
                        this.kpK.exX = false;
                    }
                    com.tencent.mm.plugin.card.d.l.ai(this.kpK, aku.kdU);
                }
                AppMethodBeat.o(89253);
                return btd;
            }
            if (this.kpK.exX) {
                this.kpK.exX = false;
            }
            com.tencent.mm.plugin.card.d.l.aj(this.kpK, "");
            Object obj2 = y.AUy;
            AppMethodBeat.o(89253);
            return obj2;
        }
    }

    static {
        AppMethodBeat.i(89273);
        AppMethodBeat.o(89273);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardInvalidTicketListUI() {
        AppMethodBeat.i(89272);
        AppMethodBeat.o(89272);
    }

    public final LoadMoreRecyclerView bel() {
        AppMethodBeat.i(89264);
        LoadMoreRecyclerView loadMoreRecyclerView = this.kpF;
        if (loadMoreRecyclerView == null) {
            j.avw("mTicketRv");
        }
        AppMethodBeat.o(89264);
        return loadMoreRecyclerView;
    }

    public final c bem() {
        AppMethodBeat.i(89265);
        c cVar = this.kpG;
        if (cVar == null) {
            j.avw("mTicketAdapter");
        }
        AppMethodBeat.o(89265);
        return cVar;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(89266);
        dxR();
        super.onCreate(bundle);
        xE(Color.parseColor("#f3f3f3"));
        dyb();
        initView();
        bik bik = new bik();
        com.tencent.mm.plugin.card.model.a.a.a aVar = com.tencent.mm.plugin.card.model.a.a.kfc;
        j.p(bik, "invalidTicketList");
        ab.d(com.tencent.mm.plugin.card.model.a.a.TAG, "load invalid ticket page snapshot");
        com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
        j.o(RP, "MMKernel.storage()");
        String str = (String) RP.Ry().i(com.tencent.mm.storage.ac.a.USERINFO_CARD_INVALID_TICKET_STRING_SYNC);
        if (str != null) {
            Charset charset = a.k.d.ISO_8859_1;
            if (str == null) {
                v vVar = new v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(89266);
                throw vVar;
            }
            byte[] bytes = str.getBytes(charset);
            j.o(bytes, "(this as java.lang.String).getBytes(charset)");
            bik.parseFrom(bytes);
        }
        a(bik);
        setMMTitle((int) R.string.evy);
        setBackBtn(new h(this));
        com.tencent.mm.plugin.report.service.h.pYm.e(16322, Integer.valueOf(9));
        AppMethodBeat.o(89266);
    }

    public final void initView() {
        AppMethodBeat.i(89267);
        View findViewById = findViewById(R.id.ak9);
        j.o(findViewById, "findViewById(R.id.ctlu_rv)");
        this.kpF = (LoadMoreRecyclerView) findViewById;
        this.kpG = new c(true);
        LoadMoreRecyclerView loadMoreRecyclerView = this.kpF;
        if (loadMoreRecyclerView == null) {
            j.avw("mTicketRv");
        }
        c cVar = this.kpG;
        if (cVar == null) {
            j.avw("mTicketAdapter");
        }
        loadMoreRecyclerView.setAdapter(cVar);
        loadMoreRecyclerView = this.kpF;
        if (loadMoreRecyclerView == null) {
            j.avw("mTicketRv");
        }
        loadMoreRecyclerView.setLayoutManager(new LinearLayoutManager());
        LoadMoreRecyclerView loadMoreRecyclerView2 = this.kpF;
        if (loadMoreRecyclerView2 == null) {
            j.avw("mTicketRv");
        }
        loadMoreRecyclerView2.setEmptyView(findViewById(R.id.afq));
        loadMoreRecyclerView2 = this.kpF;
        if (loadMoreRecyclerView2 == null) {
            j.avw("mTicketRv");
        }
        TextView textView = (TextView) loadMoreRecyclerView2.getEmptyView().findViewById(R.id.afr);
        j.o(textView, "emptyTv");
        textView.setText(getString(R.string.agp));
        z zVar = new z(this);
        zVar.setDrawable(getResources().getDrawable(R.drawable.gn));
        LoadMoreRecyclerView loadMoreRecyclerView3 = this.kpF;
        if (loadMoreRecyclerView3 == null) {
            j.avw("mTicketRv");
        }
        loadMoreRecyclerView3.b((android.support.v7.widget.RecyclerView.h) zVar);
        loadMoreRecyclerView2 = this.kpF;
        if (loadMoreRecyclerView2 == null) {
            j.avw("mTicketRv");
        }
        loadMoreRecyclerView2.setLoadingView((int) R.layout.j2);
        loadMoreRecyclerView = this.kpF;
        if (loadMoreRecyclerView == null) {
            j.avw("mTicketRv");
        }
        loadMoreRecyclerView.setOnLoadingStateChangedListener(new e(this));
        loadMoreRecyclerView = this.kpF;
        if (loadMoreRecyclerView == null) {
            j.avw("mTicketRv");
        }
        loadMoreRecyclerView.setOnItemClickListener(new f(this));
        loadMoreRecyclerView = this.kpF;
        if (loadMoreRecyclerView == null) {
            j.avw("mTicketRv");
        }
        loadMoreRecyclerView.setOnItemLongClickListener(new g(this));
        AppMethodBeat.o(89267);
    }

    public final void onDestroy() {
        AppMethodBeat.i(89268);
        super.onDestroy();
        bik bik = new bik();
        bik.wLN = new LinkedList();
        Iterator it = this.kpH.iterator();
        while (it.hasNext()) {
            bih bih = ((d) it.next()).kqe;
            if (bih != null) {
                bik.wLN.add(bih);
            }
        }
        com.tencent.mm.plugin.card.model.a.a.a aVar = com.tencent.mm.plugin.card.model.a.a.kfc;
        j.p(bik, "invalidTicketList");
        ab.d(com.tencent.mm.plugin.card.model.a.a.TAG, "save invalid ticket snapshot");
        byte[] toByteArray = bik.toByteArray();
        j.o(toByteArray, "invalidTicketList.toByteArray()");
        Object str = new String(toByteArray, a.k.d.ISO_8859_1);
        com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
        j.o(RP, "MMKernel.storage()");
        RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CARD_INVALID_TICKET_STRING_SYNC, str);
        AppMethodBeat.o(89268);
    }

    public final int getLayoutId() {
        return R.layout.km;
    }

    public final void P(int i, boolean z) {
        AppMethodBeat.i(89269);
        ab.i("MicroMsg.CardInvalidTicketListUI", "location finish: [%s, %s], ret: %s, isOk: %s", Float.valueOf(this.cEB), Float.valueOf(this.cGm), Integer.valueOf(i), Boolean.valueOf(z));
        if (this.exX) {
            ben();
            AppMethodBeat.o(89269);
            return;
        }
        if (!z) {
            bep();
        }
        AppMethodBeat.o(89269);
    }

    private final void a(bik bik) {
        AppMethodBeat.i(89270);
        if (bik != null) {
            LinkedList linkedList = bik.wLN;
            j.o(linkedList, "page_ticket_element");
            if ((!((Collection) linkedList).isEmpty() ? 1 : null) != null) {
                Iterator it = bik.wLN.iterator();
                while (it.hasNext()) {
                    bih bih = (bih) it.next();
                    d dVar = new d();
                    dVar.kqe = bih;
                    dVar.type = 2;
                    this.kpH.add(dVar);
                }
            }
        }
        c cVar = this.kpG;
        if (cVar == null) {
            j.avw("mTicketAdapter");
        }
        cVar.a(null, this.kpH, null);
        AppMethodBeat.o(89270);
    }

    private final void ben() {
        AppMethodBeat.i(89271);
        ab.i("MicroMsg.CardInvalidTicketListUI", "do get invalid ticket: %s, %s, %s, %s", Integer.valueOf(this.offset), Integer.valueOf(this.koB), Boolean.valueOf(this.koC), Boolean.valueOf(this.isLoading));
        if (!(this.koC || this.isLoading)) {
            this.isLoading = true;
            new com.tencent.mm.plugin.card.model.a.i(this.offset, this.koB, (double) this.cEB, (double) this.cGm).acy().b((com.tencent.mm.vending.c.a) new d(this));
        }
        AppMethodBeat.o(89271);
    }

    public static final /* synthetic */ void d(CardInvalidTicketListUI cardInvalidTicketListUI) {
        AppMethodBeat.i(89277);
        ab.i("MicroMsg.CardInvalidTicketListUI", "update clear btn: %s", Boolean.valueOf(cardInvalidTicketListUI.kpI));
        if (cardInvalidTicketListUI.kpI) {
            cardInvalidTicketListUI.addTextOptionMenu(0, cardInvalidTicketListUI.getString(R.string.acz), new i(cardInvalidTicketListUI));
            if (cardInvalidTicketListUI.kpH.isEmpty()) {
                cardInvalidTicketListUI.enableOptionMenu(0, false);
                AppMethodBeat.o(89277);
                return;
            }
            cardInvalidTicketListUI.enableOptionMenu(0, true);
            AppMethodBeat.o(89277);
            return;
        }
        cardInvalidTicketListUI.removeOptionMenu(0);
        AppMethodBeat.o(89277);
    }

    public static final /* synthetic */ void h(CardInvalidTicketListUI cardInvalidTicketListUI) {
        AppMethodBeat.i(89279);
        ab.i("MicroMsg.CardInvalidTicketListUI", "do clear invalid ticket list");
        ArrayList arrayList = new ArrayList();
        Iterator it = cardInvalidTicketListUI.kpH.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.type == 2) {
                bih bih = dVar.kqe;
                if (bih == null) {
                    j.dWJ();
                }
                arrayList.add(bih.vCb);
            }
        }
        new com.tencent.mm.plugin.card.model.a.b(arrayList).acy().b((com.tencent.mm.vending.c.a) new b(cardInvalidTicketListUI));
        AppMethodBeat.o(89279);
    }
}
