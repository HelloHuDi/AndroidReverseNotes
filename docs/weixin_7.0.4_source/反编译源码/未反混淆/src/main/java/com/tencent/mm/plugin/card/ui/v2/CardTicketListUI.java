package com.tencent.mm.plugin.card.ui.v2;

import a.l;
import a.v;
import a.y;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.z;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.akw;
import com.tencent.mm.protocal.protobuf.bih;
import com.tencent.mm.protocal.protobuf.bii;
import com.tencent.mm.protocal.protobuf.bij;
import com.tencent.mm.protocal.protobuf.bik;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.ny;
import com.tencent.mm.protocal.protobuf.wo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 22\u00020\u0001:\u00012B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0014J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u0019H\u0014J\b\u0010!\u001a\u00020\u0019H\u0002J\"\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\u0012\u0010'\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020\u0019H\u0014J\u0018\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u0004H\u0016J\b\u0010.\u001a\u00020\u0019H\u0002J&\u0010/\u001a\u00020\u00192\b\u0010\t\u001a\u0004\u0018\u0001002\b\u0010\u0017\u001a\u0004\u0018\u0001012\b\u0010\f\u001a\u0004\u0018\u000101H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000¨\u00063"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "firstLoad", "", "getMktTicketHomePage", "Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktTicketHomePage;", "isAll", "isLoading", "jumpList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "licenseList", "mEmptyView", "Landroid/view/ViewGroup;", "mFooterView", "mTicketAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "mTicketRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "offset", "", "reqNum", "ticketList", "adjustFooterView", "", "doDeleteTicket", "cardId", "", "doGetTicketHomePage", "getLayoutId", "gotoCardDetailUI", "initView", "loadSnapshot", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "saveSnapshot", "updateModelList", "Lcom/tencent/mm/protocal/protobuf/PageTicketJumpList;", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "Companion", "plugin-card_release"})
public final class CardTicketListUI extends CardNewBaseUI {
    public static final a kqg = new a();
    private boolean exX = true;
    private boolean isLoading;
    private int koB = 10;
    private boolean koC;
    private ViewGroup kox;
    private ViewGroup koy;
    private LoadMoreRecyclerView kpF;
    private c kpG;
    private final ArrayList<d> kpW = new ArrayList();
    private final ArrayList<d> kpX = new ArrayList();
    private final ArrayList<d> kpY = new ArrayList();
    private j kqf;
    private int offset;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktTicketHomePageResponse;", "call"})
    static final class d<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ CardTicketListUI kqh;

        d(CardTicketListUI cardTicketListUI) {
            this.kqh = cardTicketListUI;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(89300);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.CardTicketListUI", "errtype: %s, errcode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            this.kqh.isLoading = false;
            if (aVar.errType == 0 && aVar.errCode == 0) {
                btd btd = aVar.fsy;
                akw akw = (akw) btd;
                ab.i("MicroMsg.CardTicketListUI", "retCode: %s", Integer.valueOf(akw.kdT));
                if (akw.kdT == 0) {
                    boolean z;
                    this.kqh.offset = akw.kKI;
                    CardTicketListUI cardTicketListUI = this.kqh;
                    if (akw.wqk == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    cardTicketListUI.koC = z;
                    if (this.kqh.koC) {
                        CardTicketListUI.d(this.kqh).fh(false);
                        CardTicketListUI.e(this.kqh).setVisibility(0);
                        CardTicketListUI.c(this.kqh);
                    } else {
                        CardTicketListUI.d(this.kqh).fh(true);
                    }
                    if (this.kqh.exX) {
                        this.kqh.kpY.clear();
                        this.kqh.kpW.clear();
                        this.kqh.kpX.clear();
                        this.kqh.exX = false;
                    }
                    CardTicketListUI.a(this.kqh, akw.wqt, akw.wqu, akw.wqv);
                } else {
                    com.tencent.mm.plugin.card.d.l.ai(this.kqh, akw.kdU);
                    if (this.kqh.exX) {
                        this.kqh.exX = false;
                    }
                    CardTicketListUI.c(this.kqh);
                }
                AppMethodBeat.o(89300);
                return btd;
            }
            if (this.kqh.exX) {
                this.kqh.exX = false;
            }
            com.tencent.mm.plugin.card.d.l.aj(this.kqh, "");
            CardTicketListUI.c(this.kqh);
            Object obj2 = y.AUy;
            AppMethodBeat.o(89300);
            return obj2;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListUI$Companion;", "", "()V", "REQ_CARD_DETAIL", "", "TAG", "", "plugin-card_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ CardTicketListUI kqh;

        b(CardTicketListUI cardTicketListUI) {
            this.kqh = cardTicketListUI;
        }

        public final void run() {
            AppMethodBeat.i(89298);
            ViewGroup viewGroup = (ViewGroup) this.kqh.findViewById(R.id.ih);
            if (viewGroup == null) {
                AppMethodBeat.o(89298);
                return;
            }
            int height = viewGroup.getHeight();
            int computeVerticalScrollRange = CardTicketListUI.d(this.kqh).computeVerticalScrollRange();
            int computeVerticalScrollExtent = CardTicketListUI.d(this.kqh).computeVerticalScrollExtent();
            ab.d("MicroMsg.CardTicketListUI", "range: %s, extent: %s, contentHeight: %s", Integer.valueOf(computeVerticalScrollRange), Integer.valueOf(computeVerticalScrollExtent), Integer.valueOf(height));
            if (height > computeVerticalScrollRange) {
                height -= computeVerticalScrollRange;
                if (height >= 0) {
                    CardTicketListUI.e(this.kqh).setPadding(0, height + CardTicketListUI.e(this.kqh).getPaddingTop(), 0, CardTicketListUI.e(this.kqh).getPaddingBottom());
                }
            } else {
                CardTicketListUI.e(this.kqh).setPadding(0, com.tencent.mm.bz.a.fromDPToPix(this.kqh.dxU(), 48), 0, com.tencent.mm.bz.a.fromDPToPix(this.kqh.dxU(), 24));
            }
            TextView textView = (TextView) CardTicketListUI.e(this.kqh).findViewById(R.id.afs);
            a.f.b.j.o(textView, "faqTv");
            textView.setText(this.kqh.getString(R.string.evy));
            textView.setVisibility(0);
            AppMethodBeat.o(89298);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInTicketListResponse;", "call"})
    static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ String kpL;
        final /* synthetic */ CardTicketListUI kqh;

        c(CardTicketListUI cardTicketListUI, String str) {
            this.kqh = cardTicketListUI;
            this.kpL = str;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(89299);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.CardTicketListUI", "errtype: %s, errcode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                btd btd = aVar.fsy;
                wo woVar = (wo) btd;
                ab.i("MicroMsg.CardTicketListUI", "retCode: %s", Integer.valueOf(woVar.kdT));
                if (woVar.kdT == 0) {
                    CardTicketListUI.b(this.kqh).GZ(this.kpL);
                    CardTicketListUI.c(this.kqh);
                } else {
                    com.tencent.mm.plugin.card.d.l.ai(this.kqh, woVar.kdU);
                }
                AppMethodBeat.o(89299);
                return btd;
            }
            com.tencent.mm.plugin.card.d.l.aj(this.kqh, "");
            Object obj2 = y.AUy;
            AppMethodBeat.o(89299);
            return obj2;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements OnClickListener {
        final /* synthetic */ CardTicketListUI kqh;

        e(CardTicketListUI cardTicketListUI) {
            this.kqh = cardTicketListUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(89301);
            ab.i("MicroMsg.CardTicketListUI", "click history wording");
            this.kqh.startActivity(new Intent(this.kqh, CardInvalidTicketListUI.class));
            com.tencent.mm.plugin.report.service.h.pYm.e(16322, Integer.valueOf(8));
            AppMethodBeat.o(89301);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
    static final class g implements com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a {
        final /* synthetic */ CardTicketListUI kqh;

        g(CardTicketListUI cardTicketListUI) {
            this.kqh = cardTicketListUI;
        }

        public final void I(View view, int i) {
            AppMethodBeat.i(89303);
            ab.i("MicroMsg.CardTicketListUI", "click item");
            d tl = CardTicketListUI.b(this.kqh).tl(i);
            if (tl != null) {
                switch (tl.type) {
                    case 1:
                        bii bii = tl.kqd;
                        if (bii != null) {
                            switch (bii.wLI) {
                                case 1:
                                    com.tencent.mm.plugin.card.d.b.a((MMActivity) this.kqh, bii.wLJ);
                                    break;
                                case 2:
                                    ny nyVar = bii.wLK;
                                    if (nyVar != null) {
                                        com.tencent.mm.plugin.card.d.b.t(nyVar.tzW, nyVar.ttg, nyVar.tIE);
                                        break;
                                    }
                                    break;
                            }
                        }
                        com.tencent.mm.plugin.report.service.h.pYm.e(16322, Integer.valueOf(7));
                        AppMethodBeat.o(89303);
                        return;
                    case 2:
                        bih bih = tl.kqe;
                        if (bih != null) {
                            CardTicketListUI cardTicketListUI = this.kqh;
                            String str = bih.vCb;
                            a.f.b.j.o(str, "user_card_id");
                            CardTicketListUI.a(cardTicketListUI, str);
                            com.tencent.mm.plugin.report.service.h.pYm.e(16322, Integer.valueOf(10));
                            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                            Object[] objArr = new Object[4];
                            objArr[0] = Integer.valueOf(bih.wLB);
                            objArr[1] = bih.vCb;
                            c b = CardTicketListUI.b(this.kqh);
                            String str2 = bih.vCb;
                            a.f.b.j.o(str2, "user_card_id");
                            objArr[2] = Integer.valueOf(b.bO(str2, bih.wLB));
                            objArr[3] = Integer.valueOf(1);
                            hVar.e(16326, objArr);
                            AppMethodBeat.o(89303);
                            return;
                        }
                        break;
                }
                AppMethodBeat.o(89303);
                return;
            }
            AppMethodBeat.o(89303);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
    static final class h implements com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b {
        final /* synthetic */ CardTicketListUI kqh;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardTicketListUI$h$1 */
        static final class AnonymousClass1 implements com.tencent.mm.ui.base.n.c {
            final /* synthetic */ h kqi;

            AnonymousClass1(h hVar) {
                this.kqi = hVar;
            }

            public final void a(com.tencent.mm.ui.base.l lVar) {
                AppMethodBeat.i(89304);
                lVar.e(1, this.kqi.kqh.getString(R.string.p4));
                AppMethodBeat.o(89304);
            }
        }

        h(CardTicketListUI cardTicketListUI) {
            this.kqh = cardTicketListUI;
        }

        public final boolean L(View view, int i) {
            AppMethodBeat.i(89308);
            ab.i("MicroMsg.CardTicketListUI", "long click item");
            d tl = CardTicketListUI.b(this.kqh).tl(i);
            if (tl != null) {
                final bih bih = tl.kqe;
                switch (tl.type) {
                    case 2:
                        com.tencent.mm.ui.tools.j jVar = new com.tencent.mm.ui.tools.j(this.kqh.dxU());
                        jVar.a((com.tencent.mm.ui.base.n.c) new AnonymousClass1(this));
                        jVar.a((com.tencent.mm.ui.base.n.d) new com.tencent.mm.ui.base.n.d(this) {
                            final /* synthetic */ h kqi;

                            @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
                            /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardTicketListUI$h$2$1 */
                            static final class AnonymousClass1 implements DialogInterface.OnClickListener {
                                final /* synthetic */ AnonymousClass2 kqk;

                                AnonymousClass1(AnonymousClass2 anonymousClass2) {
                                    this.kqk = anonymousClass2;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(89305);
                                    CardTicketListUI cardTicketListUI = this.kqk.kqi.kqh;
                                    bih bih = bih;
                                    if (bih == null) {
                                        a.f.b.j.dWJ();
                                    }
                                    String str = bih.vCb;
                                    a.f.b.j.o(str, "ticketElement!!.user_card_id");
                                    CardTicketListUI.b(cardTicketListUI, str);
                                    dialogInterface.dismiss();
                                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                                    Object[] objArr = new Object[4];
                                    bih bih2 = bih;
                                    if (bih2 == null) {
                                        a.f.b.j.dWJ();
                                    }
                                    objArr[0] = Integer.valueOf(bih2.wLB);
                                    bih2 = bih;
                                    if (bih2 == null) {
                                        a.f.b.j.dWJ();
                                    }
                                    objArr[1] = bih2.vCb;
                                    c b = CardTicketListUI.b(this.kqk.kqi.kqh);
                                    bih bih3 = bih;
                                    if (bih3 == null) {
                                        a.f.b.j.dWJ();
                                    }
                                    String str2 = bih3.vCb;
                                    a.f.b.j.o(str2, "ticketElement!!.user_card_id");
                                    bih bih4 = bih;
                                    if (bih4 == null) {
                                        a.f.b.j.dWJ();
                                    }
                                    objArr[2] = Integer.valueOf(b.bO(str2, bih4.wLB));
                                    objArr[3] = Integer.valueOf(4);
                                    hVar.e(16326, objArr);
                                    AppMethodBeat.o(89305);
                                }
                            }

                            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                AppMethodBeat.i(89307);
                                a.f.b.j.o(menuItem, "menuItem");
                                switch (menuItem.getItemId()) {
                                    case 1:
                                        if (bih != null) {
                                            com.tencent.mm.ui.base.h.a((Context) this.kqi.kqh.dxU(), this.kqi.kqh.getString(R.string.af0), "", this.kqi.kqh.getString(R.string.s6), this.kqi.kqh.getString(R.string.or), false, (DialogInterface.OnClickListener) new AnonymousClass1(this), (DialogInterface.OnClickListener) AnonymousClass2.kql);
                                            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                                            Object[] objArr = new Object[4];
                                            bih bih = bih;
                                            if (bih == null) {
                                                a.f.b.j.dWJ();
                                            }
                                            objArr[0] = Integer.valueOf(bih.wLB);
                                            bih bih2 = bih;
                                            if (bih2 == null) {
                                                a.f.b.j.dWJ();
                                            }
                                            objArr[1] = bih2.vCb;
                                            c b = CardTicketListUI.b(this.kqi.kqh);
                                            bih bih3 = bih;
                                            if (bih3 == null) {
                                                a.f.b.j.dWJ();
                                            }
                                            String str = bih3.vCb;
                                            a.f.b.j.o(str, "ticketElement!!.user_card_id");
                                            bih bih4 = bih;
                                            if (bih4 == null) {
                                                a.f.b.j.dWJ();
                                            }
                                            objArr[2] = Integer.valueOf(b.bO(str, bih4.wLB));
                                            objArr[3] = Integer.valueOf(3);
                                            hVar.e(16326, objArr);
                                            break;
                                        }
                                        break;
                                }
                                AppMethodBeat.o(89307);
                            }
                        });
                        jVar.cuu();
                        if (bih != null) {
                            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                            Object[] objArr = new Object[4];
                            objArr[0] = Integer.valueOf(bih.wLB);
                            objArr[1] = bih.vCb;
                            c b = CardTicketListUI.b(this.kqh);
                            String str = bih.vCb;
                            a.f.b.j.o(str, "user_card_id");
                            objArr[2] = Integer.valueOf(b.bO(str, bih.wLB));
                            objArr[3] = Integer.valueOf(2);
                            hVar.e(16326, objArr);
                            break;
                        }
                        break;
                }
            }
            AppMethodBeat.o(89308);
            return false;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class i implements OnMenuItemClickListener {
        final /* synthetic */ CardTicketListUI kqh;

        i(CardTicketListUI cardTicketListUI) {
            this.kqh = cardTicketListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(89309);
            this.kqh.finish();
            AppMethodBeat.o(89309);
            return false;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032&\u0010\u0005\u001a\"\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0006¨\u0006\u00010\u0006¨\u0006\u0001H\n¢\u0006\u0002\b\b"}, dWq = {"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
    static final class f implements com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a {
        final /* synthetic */ CardTicketListUI kqh;

        f(CardTicketListUI cardTicketListUI) {
            this.kqh = cardTicketListUI;
        }

        public final void aMC() {
            AppMethodBeat.i(89302);
            CardTicketListUI.a(this.kqh);
            AppMethodBeat.o(89302);
        }
    }

    static {
        AppMethodBeat.i(89319);
        AppMethodBeat.o(89319);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardTicketListUI() {
        AppMethodBeat.i(89318);
        AppMethodBeat.o(89318);
    }

    public static final /* synthetic */ void a(CardTicketListUI cardTicketListUI) {
        AppMethodBeat.i(89320);
        cardTicketListUI.beq();
        AppMethodBeat.o(89320);
    }

    public static final /* synthetic */ void a(CardTicketListUI cardTicketListUI, bij bij, bik bik, bik bik2) {
        AppMethodBeat.i(89327);
        cardTicketListUI.a(bij, bik, bik2);
        AppMethodBeat.o(89327);
    }

    public static final /* synthetic */ c b(CardTicketListUI cardTicketListUI) {
        AppMethodBeat.i(89321);
        c cVar = cardTicketListUI.kpG;
        if (cVar == null) {
            a.f.b.j.avw("mTicketAdapter");
        }
        AppMethodBeat.o(89321);
        return cVar;
    }

    public static final /* synthetic */ void b(CardTicketListUI cardTicketListUI, String str) {
        AppMethodBeat.i(89323);
        cardTicketListUI.Hc(str);
        AppMethodBeat.o(89323);
    }

    public static final /* synthetic */ LoadMoreRecyclerView d(CardTicketListUI cardTicketListUI) {
        AppMethodBeat.i(89325);
        LoadMoreRecyclerView loadMoreRecyclerView = cardTicketListUI.kpF;
        if (loadMoreRecyclerView == null) {
            a.f.b.j.avw("mTicketRv");
        }
        AppMethodBeat.o(89325);
        return loadMoreRecyclerView;
    }

    public static final /* synthetic */ ViewGroup e(CardTicketListUI cardTicketListUI) {
        AppMethodBeat.i(89326);
        ViewGroup viewGroup = cardTicketListUI.kox;
        if (viewGroup == null) {
            a.f.b.j.avw("mFooterView");
        }
        AppMethodBeat.o(89326);
        return viewGroup;
    }

    public final void onCreate(Bundle bundle) {
        Charset charset;
        v vVar;
        byte[] bytes;
        AppMethodBeat.i(89310);
        dxR();
        super.onCreate(bundle);
        xE(Color.parseColor("#f3f3f3"));
        dyb();
        initView();
        bij bij = new bij();
        bik bik = new bik();
        bik bik2 = new bik();
        com.tencent.mm.plugin.card.model.a.a.a aVar = com.tencent.mm.plugin.card.model.a.a.kfc;
        a.f.b.j.p(bij, "jumpList");
        a.f.b.j.p(bik, "ticketList");
        a.f.b.j.p(bik2, "licenseList");
        ab.d(com.tencent.mm.plugin.card.model.a.a.TAG, "load ticket page snapshot");
        com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
        a.f.b.j.o(RP, "MMKernel.storage()");
        String str = (String) RP.Ry().i(com.tencent.mm.storage.ac.a.USERINFO_CARD_JUMP_LIST_STRING_SYNC);
        if (str != null) {
            charset = a.k.d.ISO_8859_1;
            if (str == null) {
                vVar = new v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(89310);
                throw vVar;
            }
            bytes = str.getBytes(charset);
            a.f.b.j.o(bytes, "(this as java.lang.String).getBytes(charset)");
            bij.parseFrom(bytes);
        }
        RP = com.tencent.mm.kernel.g.RP();
        a.f.b.j.o(RP, "MMKernel.storage()");
        str = (String) RP.Ry().i(com.tencent.mm.storage.ac.a.USERINFO_CARD_TICKET_LIST_STRING_SYNC);
        if (str != null) {
            charset = a.k.d.ISO_8859_1;
            if (str == null) {
                vVar = new v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(89310);
                throw vVar;
            }
            bytes = str.getBytes(charset);
            a.f.b.j.o(bytes, "(this as java.lang.String).getBytes(charset)");
            bik.parseFrom(bytes);
        }
        RP = com.tencent.mm.kernel.g.RP();
        a.f.b.j.o(RP, "MMKernel.storage()");
        str = (String) RP.Ry().i(com.tencent.mm.storage.ac.a.USERINFO_CARD_LICENSE_LIST_STRING_SYNC);
        if (str != null) {
            charset = a.k.d.ISO_8859_1;
            if (str == null) {
                vVar = new v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(89310);
                throw vVar;
            }
            bytes = str.getBytes(charset);
            a.f.b.j.o(bytes, "(this as java.lang.String).getBytes(charset)");
            bik2.parseFrom(bytes);
        }
        a(bij, bik, bik2);
        setMMTitle((int) R.string.evz);
        setBackBtn(new i(this));
        com.tencent.mm.plugin.report.service.h.pYm.e(16322, Integer.valueOf(6));
        AppMethodBeat.o(89310);
    }

    public final void initView() {
        AppMethodBeat.i(89311);
        View findViewById = findViewById(R.id.ak9);
        a.f.b.j.o(findViewById, "findViewById(R.id.ctlu_rv)");
        this.kpF = (LoadMoreRecyclerView) findViewById;
        this.kpG = new c();
        LoadMoreRecyclerView loadMoreRecyclerView = this.kpF;
        if (loadMoreRecyclerView == null) {
            a.f.b.j.avw("mTicketRv");
        }
        c cVar = this.kpG;
        if (cVar == null) {
            a.f.b.j.avw("mTicketAdapter");
        }
        loadMoreRecyclerView.setAdapter(cVar);
        loadMoreRecyclerView = this.kpF;
        if (loadMoreRecyclerView == null) {
            a.f.b.j.avw("mTicketRv");
        }
        loadMoreRecyclerView.setLayoutManager(new LinearLayoutManager());
        z zVar = new z(this);
        zVar.setDrawable(getResources().getDrawable(R.drawable.gn));
        LoadMoreRecyclerView loadMoreRecyclerView2 = this.kpF;
        if (loadMoreRecyclerView2 == null) {
            a.f.b.j.avw("mTicketRv");
        }
        loadMoreRecyclerView2.b((android.support.v7.widget.RecyclerView.h) zVar);
        LoadMoreRecyclerView loadMoreRecyclerView3 = this.kpF;
        if (loadMoreRecyclerView3 == null) {
            a.f.b.j.avw("mTicketRv");
        }
        loadMoreRecyclerView3.setLoadingView((int) R.layout.j2);
        LayoutInflater from = LayoutInflater.from(this);
        loadMoreRecyclerView3 = this.kpF;
        if (loadMoreRecyclerView3 == null) {
            a.f.b.j.avw("mTicketRv");
        }
        findViewById = from.inflate(R.layout.j0, loadMoreRecyclerView3, false);
        if (findViewById == null) {
            v vVar = new v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(89311);
            throw vVar;
        }
        this.kox = (ViewGroup) findViewById;
        ViewGroup viewGroup = this.kox;
        if (viewGroup == null) {
            a.f.b.j.avw("mFooterView");
        }
        ((TextView) viewGroup.findViewById(R.id.afs)).setOnClickListener(new e(this));
        loadMoreRecyclerView = this.kpF;
        if (loadMoreRecyclerView == null) {
            a.f.b.j.avw("mTicketRv");
        }
        viewGroup = this.kox;
        if (viewGroup == null) {
            a.f.b.j.avw("mFooterView");
        }
        loadMoreRecyclerView.addFooterView(viewGroup);
        viewGroup = this.kox;
        if (viewGroup == null) {
            a.f.b.j.avw("mFooterView");
        }
        viewGroup.setVisibility(8);
        findViewById = findViewById(R.id.afq);
        a.f.b.j.o(findViewById, "findViewById(R.id.chpe_root_layout)");
        this.koy = (ViewGroup) findViewById;
        loadMoreRecyclerView = this.kpF;
        if (loadMoreRecyclerView == null) {
            a.f.b.j.avw("mTicketRv");
        }
        viewGroup = this.koy;
        if (viewGroup == null) {
            a.f.b.j.avw("mEmptyView");
        }
        loadMoreRecyclerView.setEmptyView(viewGroup);
        loadMoreRecyclerView = this.kpF;
        if (loadMoreRecyclerView == null) {
            a.f.b.j.avw("mTicketRv");
        }
        loadMoreRecyclerView.setOnLoadingStateChangedListener(new f(this));
        loadMoreRecyclerView = this.kpF;
        if (loadMoreRecyclerView == null) {
            a.f.b.j.avw("mTicketRv");
        }
        loadMoreRecyclerView.setOnItemClickListener(new g(this));
        loadMoreRecyclerView = this.kpF;
        if (loadMoreRecyclerView == null) {
            a.f.b.j.avw("mTicketRv");
        }
        loadMoreRecyclerView.setOnItemLongClickListener(new h(this));
        AppMethodBeat.o(89311);
    }

    public final void onDestroy() {
        bih bih;
        AppMethodBeat.i(89312);
        super.onDestroy();
        j jVar = this.kqf;
        if (jVar != null) {
            jVar.cancel();
        }
        ab.i("MicroMsg.CardTicketListUI", "do save snapshot");
        bij bij = new bij();
        bij.wLM = new LinkedList();
        Iterator it = this.kpY.iterator();
        while (it.hasNext()) {
            bii bii = ((d) it.next()).kqd;
            if (bii != null) {
                bij.wLM.add(bii);
            }
        }
        bik bik = new bik();
        bik.wLN = new LinkedList();
        Iterator it2 = this.kpW.iterator();
        while (it2.hasNext()) {
            bih = ((d) it2.next()).kqe;
            if (bih != null) {
                bik.wLN.add(bih);
            }
        }
        bik bik2 = new bik();
        bik2.wLN = new LinkedList();
        Iterator it3 = this.kpX.iterator();
        while (it3.hasNext()) {
            bih = ((d) it3.next()).kqe;
            if (bih != null) {
                bik2.wLN.add(bih);
            }
        }
        com.tencent.mm.plugin.card.model.a.a.a aVar = com.tencent.mm.plugin.card.model.a.a.kfc;
        a.f.b.j.p(bij, "jumpList");
        a.f.b.j.p(bik, "ticketList");
        a.f.b.j.p(bik2, "licenseList");
        ab.d(com.tencent.mm.plugin.card.model.a.a.TAG, "save ticket page snapshot");
        byte[] toByteArray = bij.toByteArray();
        a.f.b.j.o(toByteArray, "jumpList.toByteArray()");
        Object str = new String(toByteArray, a.k.d.ISO_8859_1);
        com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
        a.f.b.j.o(RP, "MMKernel.storage()");
        RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CARD_JUMP_LIST_STRING_SYNC, str);
        toByteArray = bik.toByteArray();
        a.f.b.j.o(toByteArray, "ticketList.toByteArray()");
        Object str2 = new String(toByteArray, a.k.d.ISO_8859_1);
        RP = com.tencent.mm.kernel.g.RP();
        a.f.b.j.o(RP, "MMKernel.storage()");
        RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CARD_TICKET_LIST_STRING_SYNC, str2);
        toByteArray = bik2.toByteArray();
        a.f.b.j.o(toByteArray, "licenseList.toByteArray()");
        str2 = new String(toByteArray, a.k.d.ISO_8859_1);
        RP = com.tencent.mm.kernel.g.RP();
        a.f.b.j.o(RP, "MMKernel.storage()");
        RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CARD_LICENSE_LIST_STRING_SYNC, str2);
        AppMethodBeat.o(89312);
    }

    public final int getLayoutId() {
        return R.layout.km;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        Object obj = null;
        AppMethodBeat.i(89313);
        if (i == 256 && i2 == -1) {
            Integer valueOf = intent != null ? Integer.valueOf(intent.getIntExtra("key_finish_action", -1)) : null;
            if ((valueOf != null && valueOf.intValue() == 1) || (valueOf != null && valueOf.intValue() == 2)) {
                if (intent != null) {
                    obj = intent.getStringExtra("key_card_id");
                }
                a.f.b.j.o(obj, "cardId");
                Hc(obj);
            }
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(89313);
    }

    public final void P(int i, boolean z) {
        AppMethodBeat.i(89314);
        ab.i("MicroMsg.CardTicketListUI", "location finish: [%s, %s], ret: %s, isOk: %s", Float.valueOf(this.cEB), Float.valueOf(this.cGm), Integer.valueOf(i), Boolean.valueOf(z));
        if (this.exX) {
            beq();
            AppMethodBeat.o(89314);
            return;
        }
        if (!z) {
            bep();
        }
        AppMethodBeat.o(89314);
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0115  */
    /* JADX WARNING: Missing block: B:38:0x00ce, code skipped:
            if ((!((java.util.Collection) r7.kpW).isEmpty() ? 1 : 0) != 0) goto L_0x00d0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(bij bij, bik bik, bik bik2) {
        LinkedList linkedList;
        Iterator it;
        d dVar;
        bih bih;
        c cVar;
        AppMethodBeat.i(89315);
        if (bij != null) {
            this.kpY.clear();
            linkedList = bij.wLM;
            a.f.b.j.o(linkedList, "page_ticket_jump_element");
            if ((!((Collection) linkedList).isEmpty() ? 1 : 0) != 0) {
                it = bij.wLM.iterator();
                while (it.hasNext()) {
                    bii bii = (bii) it.next();
                    dVar = new d();
                    dVar.kqd = bii;
                    dVar.type = 1;
                    this.kpY.add(dVar);
                }
            }
        }
        if (bik != null) {
            linkedList = bik.wLN;
            a.f.b.j.o(linkedList, "page_ticket_element");
            if ((!((Collection) linkedList).isEmpty() ? 1 : 0) != 0) {
                it = bik.wLN.iterator();
                while (it.hasNext()) {
                    bih = (bih) it.next();
                    dVar = new d();
                    dVar.kqe = bih;
                    dVar.type = 2;
                    this.kpW.add(dVar);
                }
            }
        }
        if (bik2 != null) {
            linkedList = bik2.wLN;
            a.f.b.j.o(linkedList, "page_ticket_element");
            if ((!((Collection) linkedList).isEmpty() ? 1 : 0) != 0) {
                it = bik2.wLN.iterator();
                while (it.hasNext()) {
                    bih = (bih) it.next();
                    dVar = new d();
                    dVar.kqe = bih;
                    dVar.type = 2;
                    this.kpX.add(dVar);
                }
            }
        }
        if ((!((Collection) this.kpY).isEmpty() ? 1 : 0) == 0) {
        }
        if ((!((Collection) this.kpX).isEmpty() ? 1 : 0) != 0) {
            cVar = this.kpG;
            if (cVar == null) {
                a.f.b.j.avw("mTicketAdapter");
            }
            String string = getString(R.string.aia);
            a.f.b.j.o(string, "getString(R.string.card_ticket_section_title)");
            cVar.Ha(string);
            cVar = this.kpG;
            if (cVar == null) {
                a.f.b.j.avw("mTicketAdapter");
            }
            string = getString(R.string.afc);
            a.f.b.j.o(string, "getString(R.string.card_license_section_title)");
            cVar.Hb(string);
            cVar = this.kpG;
            if (cVar == null) {
                a.f.b.j.avw("mTicketAdapter");
            }
            cVar.a(this.kpY, this.kpW, this.kpX);
            AppMethodBeat.o(89315);
        }
        cVar = this.kpG;
        if (cVar == null) {
            a.f.b.j.avw("mTicketAdapter");
        }
        cVar.Ha("");
        cVar = this.kpG;
        if (cVar == null) {
            a.f.b.j.avw("mTicketAdapter");
        }
        cVar.Hb("");
        cVar = this.kpG;
        if (cVar == null) {
        }
        cVar.a(this.kpY, this.kpW, this.kpX);
        AppMethodBeat.o(89315);
    }

    private final void Hc(String str) {
        AppMethodBeat.i(89316);
        ab.i("MicroMsg.CardTicketListUI", "do delete ticket: %s", str);
        new com.tencent.mm.plugin.card.model.a.d(str).acy().b((com.tencent.mm.vending.c.a) new c(this, str));
        AppMethodBeat.o(89316);
    }

    private final void beq() {
        AppMethodBeat.i(89317);
        ab.i("MicroMsg.CardTicketListUI", "do get ticket: %s, %s, %s, %s", Integer.valueOf(this.offset), Integer.valueOf(this.koB), Boolean.valueOf(this.koC), Boolean.valueOf(this.isLoading));
        if (!(this.koC || this.isLoading)) {
            this.isLoading = true;
            this.kqf = new j(this.offset, this.koB, (double) this.cEB, (double) this.cGm);
            j jVar = this.kqf;
            if (jVar == null) {
                a.f.b.j.dWJ();
            }
            jVar.acy().b((com.tencent.mm.vending.c.a) new d(this));
        }
        AppMethodBeat.o(89317);
    }

    public static final /* synthetic */ void c(CardTicketListUI cardTicketListUI) {
        AppMethodBeat.i(89324);
        LoadMoreRecyclerView loadMoreRecyclerView = cardTicketListUI.kpF;
        if (loadMoreRecyclerView == null) {
            a.f.b.j.avw("mTicketRv");
        }
        loadMoreRecyclerView.post(new b(cardTicketListUI));
        AppMethodBeat.o(89324);
    }
}
