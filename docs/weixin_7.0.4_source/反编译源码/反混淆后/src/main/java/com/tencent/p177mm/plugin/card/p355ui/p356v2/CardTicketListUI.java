package com.tencent.p177mm.plugin.card.p355ui.p356v2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.p069v7.widget.C31899z;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.C11052a;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.MRecyclerView.C11053b;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.MRecyclerView.C2594a;
import com.tencent.p177mm.plugin.card.model.p353a.C27582d;
import com.tencent.p177mm.plugin.card.model.p353a.C33769j;
import com.tencent.p177mm.plugin.card.model.p353a.C45781a;
import com.tencent.p177mm.plugin.card.model.p353a.C45781a.C27578a;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C45774b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C30208ny;
import com.tencent.p177mm.protocal.protobuf.C30239wo;
import com.tencent.p177mm.protocal.protobuf.akw;
import com.tencent.p177mm.protocal.protobuf.bih;
import com.tencent.p177mm.protocal.protobuf.bii;
import com.tencent.p177mm.protocal.protobuf.bij;
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

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 22\u00020\u0001:\u00012B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0014J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u0019H\u0014J\b\u0010!\u001a\u00020\u0019H\u0002J\"\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\u0012\u0010'\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020\u0019H\u0014J\u0018\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u0004H\u0016J\b\u0010.\u001a\u00020\u0019H\u0002J&\u0010/\u001a\u00020\u00192\b\u0010\t\u001a\u0004\u0018\u0001002\b\u0010\u0017\u001a\u0004\u0018\u0001012\b\u0010\f\u001a\u0004\u0018\u000101H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000¨\u00063"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "firstLoad", "", "getMktTicketHomePage", "Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktTicketHomePage;", "isAll", "isLoading", "jumpList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "licenseList", "mEmptyView", "Landroid/view/ViewGroup;", "mFooterView", "mTicketAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "mTicketRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "offset", "", "reqNum", "ticketList", "adjustFooterView", "", "doDeleteTicket", "cardId", "", "doGetTicketHomePage", "getLayoutId", "gotoCardDetailUI", "initView", "loadSnapshot", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "saveSnapshot", "updateModelList", "Lcom/tencent/mm/protocal/protobuf/PageTicketJumpList;", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "Companion", "plugin-card_release"})
/* renamed from: com.tencent.mm.plugin.card.ui.v2.CardTicketListUI */
public final class CardTicketListUI extends CardNewBaseUI {
    public static final C11344a kqg = new C11344a();
    private boolean exX = true;
    private boolean isLoading;
    private int koB = 10;
    private boolean koC;
    private ViewGroup kox;
    private ViewGroup koy;
    private LoadMoreRecyclerView kpF;
    private C38773c kpG;
    private final ArrayList<C45798d> kpW = new ArrayList();
    private final ArrayList<C45798d> kpX = new ArrayList();
    private final ArrayList<C45798d> kpY = new ArrayList();
    private C33769j kqf;
    private int offset;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktTicketHomePageResponse;", "call"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardTicketListUI$d */
    static final class C6820d<_Ret, _Var> implements C5681a<_Ret, _Var> {
        final /* synthetic */ CardTicketListUI kqh;

        C6820d(CardTicketListUI cardTicketListUI) {
            this.kqh = cardTicketListUI;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(89300);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.CardTicketListUI", "errtype: %s, errcode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
            this.kqh.isLoading = false;
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                btd btd = c37441a.fsy;
                akw akw = (akw) btd;
                C4990ab.m7417i("MicroMsg.CardTicketListUI", "retCode: %s", Integer.valueOf(akw.kdT));
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
                        CardTicketListUI.m19074d(this.kqh).mo22757fh(false);
                        CardTicketListUI.m19075e(this.kqh).setVisibility(0);
                        CardTicketListUI.m19073c(this.kqh);
                    } else {
                        CardTicketListUI.m19074d(this.kqh).mo22757fh(true);
                    }
                    if (this.kqh.exX) {
                        this.kqh.kpY.clear();
                        this.kqh.kpW.clear();
                        this.kqh.kpX.clear();
                        this.kqh.exX = false;
                    }
                    CardTicketListUI.m19067a(this.kqh, akw.wqt, akw.wqu, akw.wqv);
                } else {
                    C38736l.m65716ai(this.kqh, akw.kdU);
                    if (this.kqh.exX) {
                        this.kqh.exX = false;
                    }
                    CardTicketListUI.m19073c(this.kqh);
                }
                AppMethodBeat.m2505o(89300);
                return btd;
            }
            if (this.kqh.exX) {
                this.kqh.exX = false;
            }
            C38736l.m65717aj(this.kqh, "");
            CardTicketListUI.m19073c(this.kqh);
            Object obj2 = C37091y.AUy;
            AppMethodBeat.m2505o(89300);
            return obj2;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListUI$Companion;", "", "()V", "REQ_CARD_DETAIL", "", "TAG", "", "plugin-card_release"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardTicketListUI$a */
    public static final class C11344a {
        private C11344a() {
        }

        public /* synthetic */ C11344a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardTicketListUI$b */
    static final class C11345b implements Runnable {
        final /* synthetic */ CardTicketListUI kqh;

        C11345b(CardTicketListUI cardTicketListUI) {
            this.kqh = cardTicketListUI;
        }

        public final void run() {
            AppMethodBeat.m2504i(89298);
            ViewGroup viewGroup = (ViewGroup) this.kqh.findViewById(2131820884);
            if (viewGroup == null) {
                AppMethodBeat.m2505o(89298);
                return;
            }
            int height = viewGroup.getHeight();
            int computeVerticalScrollRange = CardTicketListUI.m19074d(this.kqh).computeVerticalScrollRange();
            int computeVerticalScrollExtent = CardTicketListUI.m19074d(this.kqh).computeVerticalScrollExtent();
            C4990ab.m7411d("MicroMsg.CardTicketListUI", "range: %s, extent: %s, contentHeight: %s", Integer.valueOf(computeVerticalScrollRange), Integer.valueOf(computeVerticalScrollExtent), Integer.valueOf(height));
            if (height > computeVerticalScrollRange) {
                height -= computeVerticalScrollRange;
                if (height >= 0) {
                    CardTicketListUI.m19075e(this.kqh).setPadding(0, height + CardTicketListUI.m19075e(this.kqh).getPaddingTop(), 0, CardTicketListUI.m19075e(this.kqh).getPaddingBottom());
                }
            } else {
                CardTicketListUI.m19075e(this.kqh).setPadding(0, C1338a.fromDPToPix(this.kqh.dxU(), 48), 0, C1338a.fromDPToPix(this.kqh.dxU(), 24));
            }
            TextView textView = (TextView) CardTicketListUI.m19075e(this.kqh).findViewById(2131822165);
            C25052j.m39375o(textView, "faqTv");
            textView.setText(this.kqh.getString(C25738R.string.evy));
            textView.setVisibility(0);
            AppMethodBeat.m2505o(89298);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInTicketListResponse;", "call"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardTicketListUI$c */
    static final class C11346c<_Ret, _Var> implements C5681a<_Ret, _Var> {
        final /* synthetic */ String kpL;
        final /* synthetic */ CardTicketListUI kqh;

        C11346c(CardTicketListUI cardTicketListUI, String str) {
            this.kqh = cardTicketListUI;
            this.kpL = str;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(89299);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.CardTicketListUI", "errtype: %s, errcode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                btd btd = c37441a.fsy;
                C30239wo c30239wo = (C30239wo) btd;
                C4990ab.m7417i("MicroMsg.CardTicketListUI", "retCode: %s", Integer.valueOf(c30239wo.kdT));
                if (c30239wo.kdT == 0) {
                    CardTicketListUI.m19071b(this.kqh).mo61648GZ(this.kpL);
                    CardTicketListUI.m19073c(this.kqh);
                } else {
                    C38736l.m65716ai(this.kqh, c30239wo.kdU);
                }
                AppMethodBeat.m2505o(89299);
                return btd;
            }
            C38736l.m65717aj(this.kqh, "");
            Object obj2 = C37091y.AUy;
            AppMethodBeat.m2505o(89299);
            return obj2;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardTicketListUI$e */
    static final class C11347e implements OnClickListener {
        final /* synthetic */ CardTicketListUI kqh;

        C11347e(CardTicketListUI cardTicketListUI) {
            this.kqh = cardTicketListUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(89301);
            C4990ab.m7416i("MicroMsg.CardTicketListUI", "click history wording");
            this.kqh.startActivity(new Intent(this.kqh, CardInvalidTicketListUI.class));
            C7060h.pYm.mo8381e(16322, Integer.valueOf(8));
            AppMethodBeat.m2505o(89301);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardTicketListUI$g */
    static final class C11348g implements C2594a {
        final /* synthetic */ CardTicketListUI kqh;

        C11348g(CardTicketListUI cardTicketListUI) {
            this.kqh = cardTicketListUI;
        }

        /* renamed from: I */
        public final void mo6645I(View view, int i) {
            AppMethodBeat.m2504i(89303);
            C4990ab.m7416i("MicroMsg.CardTicketListUI", "click item");
            C45798d tl = CardTicketListUI.m19071b(this.kqh).mo61653tl(i);
            if (tl != null) {
                switch (tl.type) {
                    case 1:
                        bii bii = tl.kqd;
                        if (bii != null) {
                            switch (bii.wLI) {
                                case 1:
                                    C45774b.m84625a((MMActivity) this.kqh, bii.wLJ);
                                    break;
                                case 2:
                                    C30208ny c30208ny = bii.wLK;
                                    if (c30208ny != null) {
                                        C45774b.m84635t(c30208ny.tzW, c30208ny.ttg, c30208ny.tIE);
                                        break;
                                    }
                                    break;
                            }
                        }
                        C7060h.pYm.mo8381e(16322, Integer.valueOf(7));
                        AppMethodBeat.m2505o(89303);
                        return;
                    case 2:
                        bih bih = tl.kqe;
                        if (bih != null) {
                            CardTicketListUI cardTicketListUI = this.kqh;
                            String str = bih.vCb;
                            C25052j.m39375o(str, "user_card_id");
                            CardTicketListUI.m19068a(cardTicketListUI, str);
                            C7060h.pYm.mo8381e(16322, Integer.valueOf(10));
                            C7060h c7060h = C7060h.pYm;
                            Object[] objArr = new Object[4];
                            objArr[0] = Integer.valueOf(bih.wLB);
                            objArr[1] = bih.vCb;
                            C38773c b = CardTicketListUI.m19071b(this.kqh);
                            String str2 = bih.vCb;
                            C25052j.m39375o(str2, "user_card_id");
                            objArr[2] = Integer.valueOf(b.mo61652bO(str2, bih.wLB));
                            objArr[3] = Integer.valueOf(1);
                            c7060h.mo8381e(16326, objArr);
                            AppMethodBeat.m2505o(89303);
                            return;
                        }
                        break;
                }
                AppMethodBeat.m2505o(89303);
                return;
            }
            AppMethodBeat.m2505o(89303);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardTicketListUI$h */
    static final class C11349h implements C11053b {
        final /* synthetic */ CardTicketListUI kqh;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardTicketListUI$h$1 */
        static final class C113501 implements C36073c {
            final /* synthetic */ C11349h kqi;

            C113501(C11349h c11349h) {
                this.kqi = c11349h;
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(89304);
                c44273l.mo70068e(1, this.kqi.kqh.getString(C25738R.string.f9088p4));
                AppMethodBeat.m2505o(89304);
            }
        }

        C11349h(CardTicketListUI cardTicketListUI) {
            this.kqh = cardTicketListUI;
        }

        /* renamed from: L */
        public final boolean mo7100L(View view, int i) {
            AppMethodBeat.m2504i(89308);
            C4990ab.m7416i("MicroMsg.CardTicketListUI", "long click item");
            C45798d tl = CardTicketListUI.m19071b(this.kqh).mo61653tl(i);
            if (tl != null) {
                final bih bih = tl.kqe;
                switch (tl.type) {
                    case 2:
                        C46696j c46696j = new C46696j(this.kqh.dxU());
                        c46696j.mo75007a((C36073c) new C113501(this));
                        c46696j.mo75008a((C5279d) new C5279d(this) {
                            final /* synthetic */ C11349h kqi;

                            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
                            /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardTicketListUI$h$2$1 */
                            static final class C113521 implements DialogInterface.OnClickListener {
                                final /* synthetic */ C113512 kqk;

                                C113521(C113512 c113512) {
                                    this.kqk = c113512;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(89305);
                                    CardTicketListUI cardTicketListUI = this.kqk.kqi.kqh;
                                    bih bih = bih;
                                    if (bih == null) {
                                        C25052j.dWJ();
                                    }
                                    String str = bih.vCb;
                                    C25052j.m39375o(str, "ticketElement!!.user_card_id");
                                    CardTicketListUI.m19072b(cardTicketListUI, str);
                                    dialogInterface.dismiss();
                                    C7060h c7060h = C7060h.pYm;
                                    Object[] objArr = new Object[4];
                                    bih bih2 = bih;
                                    if (bih2 == null) {
                                        C25052j.dWJ();
                                    }
                                    objArr[0] = Integer.valueOf(bih2.wLB);
                                    bih2 = bih;
                                    if (bih2 == null) {
                                        C25052j.dWJ();
                                    }
                                    objArr[1] = bih2.vCb;
                                    C38773c b = CardTicketListUI.m19071b(this.kqk.kqi.kqh);
                                    bih bih3 = bih;
                                    if (bih3 == null) {
                                        C25052j.dWJ();
                                    }
                                    String str2 = bih3.vCb;
                                    C25052j.m39375o(str2, "ticketElement!!.user_card_id");
                                    bih bih4 = bih;
                                    if (bih4 == null) {
                                        C25052j.dWJ();
                                    }
                                    objArr[2] = Integer.valueOf(b.mo61652bO(str2, bih4.wLB));
                                    objArr[3] = Integer.valueOf(4);
                                    c7060h.mo8381e(16326, objArr);
                                    AppMethodBeat.m2505o(89305);
                                }
                            }

                            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
                            /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardTicketListUI$h$2$2 */
                            static final class C113532 implements DialogInterface.OnClickListener {
                                public static final C113532 kql = new C113532();

                                static {
                                    AppMethodBeat.m2504i(89306);
                                    AppMethodBeat.m2505o(89306);
                                }

                                C113532() {
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            }

                            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                AppMethodBeat.m2504i(89307);
                                C25052j.m39375o(menuItem, "menuItem");
                                switch (menuItem.getItemId()) {
                                    case 1:
                                        if (bih != null) {
                                            C30379h.m48445a((Context) this.kqi.kqh.dxU(), this.kqi.kqh.getString(C25738R.string.af0), "", this.kqi.kqh.getString(C25738R.string.f9187s6), this.kqi.kqh.getString(C25738R.string.f9076or), false, (DialogInterface.OnClickListener) new C113521(this), (DialogInterface.OnClickListener) C113532.kql);
                                            C7060h c7060h = C7060h.pYm;
                                            Object[] objArr = new Object[4];
                                            bih bih = bih;
                                            if (bih == null) {
                                                C25052j.dWJ();
                                            }
                                            objArr[0] = Integer.valueOf(bih.wLB);
                                            bih bih2 = bih;
                                            if (bih2 == null) {
                                                C25052j.dWJ();
                                            }
                                            objArr[1] = bih2.vCb;
                                            C38773c b = CardTicketListUI.m19071b(this.kqi.kqh);
                                            bih bih3 = bih;
                                            if (bih3 == null) {
                                                C25052j.dWJ();
                                            }
                                            String str = bih3.vCb;
                                            C25052j.m39375o(str, "ticketElement!!.user_card_id");
                                            bih bih4 = bih;
                                            if (bih4 == null) {
                                                C25052j.dWJ();
                                            }
                                            objArr[2] = Integer.valueOf(b.mo61652bO(str, bih4.wLB));
                                            objArr[3] = Integer.valueOf(3);
                                            c7060h.mo8381e(16326, objArr);
                                            break;
                                        }
                                        break;
                                }
                                AppMethodBeat.m2505o(89307);
                            }
                        });
                        c46696j.cuu();
                        if (bih != null) {
                            C7060h c7060h = C7060h.pYm;
                            Object[] objArr = new Object[4];
                            objArr[0] = Integer.valueOf(bih.wLB);
                            objArr[1] = bih.vCb;
                            C38773c b = CardTicketListUI.m19071b(this.kqh);
                            String str = bih.vCb;
                            C25052j.m39375o(str, "user_card_id");
                            objArr[2] = Integer.valueOf(b.mo61652bO(str, bih.wLB));
                            objArr[3] = Integer.valueOf(2);
                            c7060h.mo8381e(16326, objArr);
                            break;
                        }
                        break;
                }
            }
            AppMethodBeat.m2505o(89308);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardTicketListUI$i */
    static final class C11354i implements OnMenuItemClickListener {
        final /* synthetic */ CardTicketListUI kqh;

        C11354i(CardTicketListUI cardTicketListUI) {
            this.kqh = cardTicketListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(89309);
            this.kqh.finish();
            AppMethodBeat.m2505o(89309);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032&\u0010\u0005\u001a\"\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0006¨\u0006\u00010\u0006¨\u0006\u0001H\n¢\u0006\u0002\b\b"}, dWq = {"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardTicketListUI$f */
    static final class C11355f implements C11052a {
        final /* synthetic */ CardTicketListUI kqh;

        C11355f(CardTicketListUI cardTicketListUI) {
            this.kqh = cardTicketListUI;
        }

        public final void aMC() {
            AppMethodBeat.m2504i(89302);
            CardTicketListUI.m19065a(this.kqh);
            AppMethodBeat.m2505o(89302);
        }
    }

    static {
        AppMethodBeat.m2504i(89319);
        AppMethodBeat.m2505o(89319);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public CardTicketListUI() {
        AppMethodBeat.m2504i(89318);
        AppMethodBeat.m2505o(89318);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m19065a(CardTicketListUI cardTicketListUI) {
        AppMethodBeat.m2504i(89320);
        cardTicketListUI.beq();
        AppMethodBeat.m2505o(89320);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m19067a(CardTicketListUI cardTicketListUI, bij bij, bik bik, bik bik2) {
        AppMethodBeat.m2504i(89327);
        cardTicketListUI.m19070a(bij, bik, bik2);
        AppMethodBeat.m2505o(89327);
    }

    /* renamed from: b */
    public static final /* synthetic */ C38773c m19071b(CardTicketListUI cardTicketListUI) {
        AppMethodBeat.m2504i(89321);
        C38773c c38773c = cardTicketListUI.kpG;
        if (c38773c == null) {
            C25052j.avw("mTicketAdapter");
        }
        AppMethodBeat.m2505o(89321);
        return c38773c;
    }

    /* renamed from: b */
    public static final /* synthetic */ void m19072b(CardTicketListUI cardTicketListUI, String str) {
        AppMethodBeat.m2504i(89323);
        cardTicketListUI.m19064Hc(str);
        AppMethodBeat.m2505o(89323);
    }

    /* renamed from: d */
    public static final /* synthetic */ LoadMoreRecyclerView m19074d(CardTicketListUI cardTicketListUI) {
        AppMethodBeat.m2504i(89325);
        LoadMoreRecyclerView loadMoreRecyclerView = cardTicketListUI.kpF;
        if (loadMoreRecyclerView == null) {
            C25052j.avw("mTicketRv");
        }
        AppMethodBeat.m2505o(89325);
        return loadMoreRecyclerView;
    }

    /* renamed from: e */
    public static final /* synthetic */ ViewGroup m19075e(CardTicketListUI cardTicketListUI) {
        AppMethodBeat.m2504i(89326);
        ViewGroup viewGroup = cardTicketListUI.kox;
        if (viewGroup == null) {
            C25052j.avw("mFooterView");
        }
        AppMethodBeat.m2505o(89326);
        return viewGroup;
    }

    public final void onCreate(Bundle bundle) {
        Charset charset;
        C44941v c44941v;
        byte[] bytes;
        AppMethodBeat.m2504i(89310);
        dxR();
        super.onCreate(bundle);
        mo17446xE(Color.parseColor("#f3f3f3"));
        dyb();
        initView();
        bij bij = new bij();
        bik bik = new bik();
        bik bik2 = new bik();
        C27578a c27578a = C45781a.kfc;
        C25052j.m39376p(bij, "jumpList");
        C25052j.m39376p(bik, "ticketList");
        C25052j.m39376p(bik2, "licenseList");
        C4990ab.m7410d(C45781a.TAG, "load ticket page snapshot");
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        String str = (String) RP.mo5239Ry().mo16822i(C5127a.USERINFO_CARD_JUMP_LIST_STRING_SYNC);
        if (str != null) {
            charset = C17355d.ISO_8859_1;
            if (str == null) {
                c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.m2505o(89310);
                throw c44941v;
            }
            bytes = str.getBytes(charset);
            C25052j.m39375o(bytes, "(this as java.lang.String).getBytes(charset)");
            bij.parseFrom(bytes);
        }
        RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        str = (String) RP.mo5239Ry().mo16822i(C5127a.USERINFO_CARD_TICKET_LIST_STRING_SYNC);
        if (str != null) {
            charset = C17355d.ISO_8859_1;
            if (str == null) {
                c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.m2505o(89310);
                throw c44941v;
            }
            bytes = str.getBytes(charset);
            C25052j.m39375o(bytes, "(this as java.lang.String).getBytes(charset)");
            bik.parseFrom(bytes);
        }
        RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        str = (String) RP.mo5239Ry().mo16822i(C5127a.USERINFO_CARD_LICENSE_LIST_STRING_SYNC);
        if (str != null) {
            charset = C17355d.ISO_8859_1;
            if (str == null) {
                c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.m2505o(89310);
                throw c44941v;
            }
            bytes = str.getBytes(charset);
            C25052j.m39375o(bytes, "(this as java.lang.String).getBytes(charset)");
            bik2.parseFrom(bytes);
        }
        m19070a(bij, bik, bik2);
        setMMTitle((int) C25738R.string.evz);
        setBackBtn(new C11354i(this));
        C7060h.pYm.mo8381e(16322, Integer.valueOf(6));
        AppMethodBeat.m2505o(89310);
    }

    public final void initView() {
        AppMethodBeat.m2504i(89311);
        View findViewById = findViewById(2131822330);
        C25052j.m39375o(findViewById, "findViewById(R.id.ctlu_rv)");
        this.kpF = (LoadMoreRecyclerView) findViewById;
        this.kpG = new C38773c();
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
        C31899z c31899z = new C31899z(this);
        c31899z.setDrawable(getResources().getDrawable(C25738R.drawable.f6513gn));
        LoadMoreRecyclerView loadMoreRecyclerView2 = this.kpF;
        if (loadMoreRecyclerView2 == null) {
            C25052j.avw("mTicketRv");
        }
        loadMoreRecyclerView2.mo66346b((C25373h) c31899z);
        LoadMoreRecyclerView loadMoreRecyclerView3 = this.kpF;
        if (loadMoreRecyclerView3 == null) {
            C25052j.avw("mTicketRv");
        }
        loadMoreRecyclerView3.setLoadingView(2130968937);
        LayoutInflater from = LayoutInflater.from(this);
        loadMoreRecyclerView3 = this.kpF;
        if (loadMoreRecyclerView3 == null) {
            C25052j.avw("mTicketRv");
        }
        findViewById = from.inflate(2130968935, loadMoreRecyclerView3, false);
        if (findViewById == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.m2505o(89311);
            throw c44941v;
        }
        this.kox = (ViewGroup) findViewById;
        ViewGroup viewGroup = this.kox;
        if (viewGroup == null) {
            C25052j.avw("mFooterView");
        }
        ((TextView) viewGroup.findViewById(2131822165)).setOnClickListener(new C11347e(this));
        loadMoreRecyclerView = this.kpF;
        if (loadMoreRecyclerView == null) {
            C25052j.avw("mTicketRv");
        }
        viewGroup = this.kox;
        if (viewGroup == null) {
            C25052j.avw("mFooterView");
        }
        loadMoreRecyclerView.addFooterView(viewGroup);
        viewGroup = this.kox;
        if (viewGroup == null) {
            C25052j.avw("mFooterView");
        }
        viewGroup.setVisibility(8);
        findViewById = findViewById(2131822163);
        C25052j.m39375o(findViewById, "findViewById(R.id.chpe_root_layout)");
        this.koy = (ViewGroup) findViewById;
        loadMoreRecyclerView = this.kpF;
        if (loadMoreRecyclerView == null) {
            C25052j.avw("mTicketRv");
        }
        viewGroup = this.koy;
        if (viewGroup == null) {
            C25052j.avw("mEmptyView");
        }
        loadMoreRecyclerView.setEmptyView(viewGroup);
        loadMoreRecyclerView = this.kpF;
        if (loadMoreRecyclerView == null) {
            C25052j.avw("mTicketRv");
        }
        loadMoreRecyclerView.setOnLoadingStateChangedListener(new C11355f(this));
        loadMoreRecyclerView = this.kpF;
        if (loadMoreRecyclerView == null) {
            C25052j.avw("mTicketRv");
        }
        loadMoreRecyclerView.setOnItemClickListener(new C11348g(this));
        loadMoreRecyclerView = this.kpF;
        if (loadMoreRecyclerView == null) {
            C25052j.avw("mTicketRv");
        }
        loadMoreRecyclerView.setOnItemLongClickListener(new C11349h(this));
        AppMethodBeat.m2505o(89311);
    }

    public final void onDestroy() {
        bih bih;
        AppMethodBeat.m2504i(89312);
        super.onDestroy();
        C33769j c33769j = this.kqf;
        if (c33769j != null) {
            c33769j.cancel();
        }
        C4990ab.m7416i("MicroMsg.CardTicketListUI", "do save snapshot");
        bij bij = new bij();
        bij.wLM = new LinkedList();
        Iterator it = this.kpY.iterator();
        while (it.hasNext()) {
            bii bii = ((C45798d) it.next()).kqd;
            if (bii != null) {
                bij.wLM.add(bii);
            }
        }
        bik bik = new bik();
        bik.wLN = new LinkedList();
        Iterator it2 = this.kpW.iterator();
        while (it2.hasNext()) {
            bih = ((C45798d) it2.next()).kqe;
            if (bih != null) {
                bik.wLN.add(bih);
            }
        }
        bik bik2 = new bik();
        bik2.wLN = new LinkedList();
        Iterator it3 = this.kpX.iterator();
        while (it3.hasNext()) {
            bih = ((C45798d) it3.next()).kqe;
            if (bih != null) {
                bik2.wLN.add(bih);
            }
        }
        C27578a c27578a = C45781a.kfc;
        C25052j.m39376p(bij, "jumpList");
        C25052j.m39376p(bik, "ticketList");
        C25052j.m39376p(bik2, "licenseList");
        C4990ab.m7410d(C45781a.TAG, "save ticket page snapshot");
        byte[] toByteArray = bij.toByteArray();
        C25052j.m39375o(toByteArray, "jumpList.toByteArray()");
        Object str = new String(toByteArray, C17355d.ISO_8859_1);
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        RP.mo5239Ry().set(C5127a.USERINFO_CARD_JUMP_LIST_STRING_SYNC, str);
        toByteArray = bik.toByteArray();
        C25052j.m39375o(toByteArray, "ticketList.toByteArray()");
        Object str2 = new String(toByteArray, C17355d.ISO_8859_1);
        RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        RP.mo5239Ry().set(C5127a.USERINFO_CARD_TICKET_LIST_STRING_SYNC, str2);
        toByteArray = bik2.toByteArray();
        C25052j.m39375o(toByteArray, "licenseList.toByteArray()");
        str2 = new String(toByteArray, C17355d.ISO_8859_1);
        RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        RP.mo5239Ry().set(C5127a.USERINFO_CARD_LICENSE_LIST_STRING_SYNC, str2);
        AppMethodBeat.m2505o(89312);
    }

    public final int getLayoutId() {
        return 2130968995;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        Object obj = null;
        AppMethodBeat.m2504i(89313);
        if (i == 256 && i2 == -1) {
            Integer valueOf = intent != null ? Integer.valueOf(intent.getIntExtra("key_finish_action", -1)) : null;
            if ((valueOf != null && valueOf.intValue() == 1) || (valueOf != null && valueOf.intValue() == 2)) {
                if (intent != null) {
                    obj = intent.getStringExtra("key_card_id");
                }
                C25052j.m39375o(obj, "cardId");
                m19064Hc(obj);
            }
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(89313);
    }

    /* renamed from: P */
    public final void mo23051P(int i, boolean z) {
        AppMethodBeat.m2504i(89314);
        C4990ab.m7417i("MicroMsg.CardTicketListUI", "location finish: [%s, %s], ret: %s, isOk: %s", Float.valueOf(this.cEB), Float.valueOf(this.cGm), Integer.valueOf(i), Boolean.valueOf(z));
        if (this.exX) {
            beq();
            AppMethodBeat.m2505o(89314);
            return;
        }
        if (!z) {
            bep();
        }
        AppMethodBeat.m2505o(89314);
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0115  */
    /* JADX WARNING: Missing block: B:38:0x00ce, code skipped:
            if ((!((java.util.Collection) r7.kpW).isEmpty() ? 1 : 0) != 0) goto L_0x00d0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private final void m19070a(bij bij, bik bik, bik bik2) {
        LinkedList linkedList;
        Iterator it;
        C45798d c45798d;
        bih bih;
        C38773c c38773c;
        AppMethodBeat.m2504i(89315);
        if (bij != null) {
            this.kpY.clear();
            linkedList = bij.wLM;
            C25052j.m39375o(linkedList, "page_ticket_jump_element");
            if ((!((Collection) linkedList).isEmpty() ? 1 : 0) != 0) {
                it = bij.wLM.iterator();
                while (it.hasNext()) {
                    bii bii = (bii) it.next();
                    c45798d = new C45798d();
                    c45798d.kqd = bii;
                    c45798d.type = 1;
                    this.kpY.add(c45798d);
                }
            }
        }
        if (bik != null) {
            linkedList = bik.wLN;
            C25052j.m39375o(linkedList, "page_ticket_element");
            if ((!((Collection) linkedList).isEmpty() ? 1 : 0) != 0) {
                it = bik.wLN.iterator();
                while (it.hasNext()) {
                    bih = (bih) it.next();
                    c45798d = new C45798d();
                    c45798d.kqe = bih;
                    c45798d.type = 2;
                    this.kpW.add(c45798d);
                }
            }
        }
        if (bik2 != null) {
            linkedList = bik2.wLN;
            C25052j.m39375o(linkedList, "page_ticket_element");
            if ((!((Collection) linkedList).isEmpty() ? 1 : 0) != 0) {
                it = bik2.wLN.iterator();
                while (it.hasNext()) {
                    bih = (bih) it.next();
                    c45798d = new C45798d();
                    c45798d.kqe = bih;
                    c45798d.type = 2;
                    this.kpX.add(c45798d);
                }
            }
        }
        if ((!((Collection) this.kpY).isEmpty() ? 1 : 0) == 0) {
        }
        if ((!((Collection) this.kpX).isEmpty() ? 1 : 0) != 0) {
            c38773c = this.kpG;
            if (c38773c == null) {
                C25052j.avw("mTicketAdapter");
            }
            String string = getString(C25738R.string.aia);
            C25052j.m39375o(string, "getString(R.string.card_ticket_section_title)");
            c38773c.mo61649Ha(string);
            c38773c = this.kpG;
            if (c38773c == null) {
                C25052j.avw("mTicketAdapter");
            }
            string = getString(C25738R.string.afc);
            C25052j.m39375o(string, "getString(R.string.card_license_section_title)");
            c38773c.mo61650Hb(string);
            c38773c = this.kpG;
            if (c38773c == null) {
                C25052j.avw("mTicketAdapter");
            }
            c38773c.mo61651a(this.kpY, this.kpW, this.kpX);
            AppMethodBeat.m2505o(89315);
        }
        c38773c = this.kpG;
        if (c38773c == null) {
            C25052j.avw("mTicketAdapter");
        }
        c38773c.mo61649Ha("");
        c38773c = this.kpG;
        if (c38773c == null) {
            C25052j.avw("mTicketAdapter");
        }
        c38773c.mo61650Hb("");
        c38773c = this.kpG;
        if (c38773c == null) {
        }
        c38773c.mo61651a(this.kpY, this.kpW, this.kpX);
        AppMethodBeat.m2505o(89315);
    }

    /* renamed from: Hc */
    private final void m19064Hc(String str) {
        AppMethodBeat.m2504i(89316);
        C4990ab.m7417i("MicroMsg.CardTicketListUI", "do delete ticket: %s", str);
        new C27582d(str).acy().mo60487b((C5681a) new C11346c(this, str));
        AppMethodBeat.m2505o(89316);
    }

    private final void beq() {
        AppMethodBeat.m2504i(89317);
        C4990ab.m7417i("MicroMsg.CardTicketListUI", "do get ticket: %s, %s, %s, %s", Integer.valueOf(this.offset), Integer.valueOf(this.koB), Boolean.valueOf(this.koC), Boolean.valueOf(this.isLoading));
        if (!(this.koC || this.isLoading)) {
            this.isLoading = true;
            this.kqf = new C33769j(this.offset, this.koB, (double) this.cEB, (double) this.cGm);
            C33769j c33769j = this.kqf;
            if (c33769j == null) {
                C25052j.dWJ();
            }
            c33769j.acy().mo60487b((C5681a) new C6820d(this));
        }
        AppMethodBeat.m2505o(89317);
    }

    /* renamed from: c */
    public static final /* synthetic */ void m19073c(CardTicketListUI cardTicketListUI) {
        AppMethodBeat.m2504i(89324);
        LoadMoreRecyclerView loadMoreRecyclerView = cardTicketListUI.kpF;
        if (loadMoreRecyclerView == null) {
            C25052j.avw("mTicketRv");
        }
        loadMoreRecyclerView.post(new C11345b(cardTicketListUI));
        AppMethodBeat.m2505o(89324);
    }
}
