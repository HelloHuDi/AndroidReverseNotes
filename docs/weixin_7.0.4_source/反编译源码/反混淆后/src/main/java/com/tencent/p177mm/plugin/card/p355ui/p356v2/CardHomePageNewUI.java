package com.tencent.p177mm.plugin.card.p355ui.p356v2;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.p069v7.app.AppCompatActivity;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.C11052a;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.MRecyclerView.C11053b;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.MRecyclerView.C2594a;
import com.tencent.p177mm.plugin.card.model.C33770m;
import com.tencent.p177mm.plugin.card.model.p353a.C16723e;
import com.tencent.p177mm.plugin.card.model.p353a.C38739g;
import com.tencent.p177mm.plugin.card.model.p353a.C45781a;
import com.tencent.p177mm.plugin.card.model.p353a.C45781a.C27578a;
import com.tencent.p177mm.plugin.card.model.p353a.C45782h;
import com.tencent.p177mm.plugin.card.p352b.C2752k;
import com.tencent.p177mm.plugin.card.p355ui.CardDetailUI;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C45774b;
import com.tencent.p177mm.plugin.card.widget.CardTagTextView;
import com.tencent.p177mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14932m;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C23322n;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44087h;
import com.tencent.p177mm.pluginsdk.wallet.C30158b;
import com.tencent.p177mm.protocal.protobuf.C23419ns;
import com.tencent.p177mm.protocal.protobuf.C30208ny;
import com.tencent.p177mm.protocal.protobuf.C35939nv;
import com.tencent.p177mm.protocal.protobuf.C35940nw;
import com.tencent.p177mm.protocal.protobuf.C40585ws;
import com.tencent.p177mm.protocal.protobuf.C46571nt;
import com.tencent.p177mm.protocal.protobuf.C7275np;
import com.tencent.p177mm.protocal.protobuf.C7276nq;
import com.tencent.p177mm.protocal.protobuf.C7277nr;
import com.tencent.p177mm.protocal.protobuf.agq;
import com.tencent.p177mm.protocal.protobuf.aks;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p051k.C17355d;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 I2\u00020\u0001:\u0005GHIJKB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020)J\b\u00100\u001a\u00020\u0005H\u0002J\u0018\u00101\u001a\u00020\u00052\u0006\u0010/\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020\tH\u0014J\b\u00105\u001a\u00020\u0005H\u0002J\b\u00106\u001a\u00020\u0005H\u0014J\u0006\u00107\u001a\u00020\rJ\u0012\u00108\u001a\u00020\u00052\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020\u0005H\u0014J\u0018\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\rH\u0016J\b\u0010?\u001a\u00020\u0005H\u0014J\u0006\u0010@\u001a\u00020\u0005J\b\u0010A\u001a\u00020\u0005H\u0002J\u001a\u0010B\u001a\u00020\u00052\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010FR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0018\u00010\u0007R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00060\u0019R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010%\u001a\f\u0012\b\u0012\u00060\u0007R\u00020\u00000&X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0018\u00010\u0007R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0018\u00010\u0007R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010-\u001a\f\u0012\b\u0012\u00060\u0007R\u00020\u00000&X\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "adjustFooterTask", "Lkotlin/Function0;", "", "cardTitleModel", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "clickArea", "", "clickedCardHomePageElement", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "firstLoad", "", "getCardHomePageScene", "Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktCardHomePage;", "isAll", "isGotoItem", "isLoading", "mDivider", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "mEmptyView", "Landroid/view/ViewGroup;", "mFooterView", "mHomePageAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageAdapter;", "mLoadingView", "mLoadingView2", "mRecyclerView", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "markReloadHomePage", "offset", "reqNum", "scene", "shouldShowTicket", "showSort", "sortType", "storeModelList", "Ljava/util/ArrayList;", "ticketModel", "ticketNum", "", "tipsDialog", "Landroid/app/Dialog;", "titleSectionModel", "underModelList", "doDeleteMchInList", "merchantId", "doGetCardHomePage", "doGetMchInfo", "lastReceiveTime", "", "getLayoutId", "initFirstScreen", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "showSortSheet", "updateModelList", "storePageList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageStoreList;", "underPageList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageUnderList;", "CardListModel", "CardSpan", "Companion", "HomePageAdapter", "HomePageVH", "plugin-card_release"})
@C18524i
/* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI */
public final class CardHomePageNewUI extends CardNewBaseUI {
    private static final int cjn = C1338a.fromDPToPix(C4996ah.getContext(), 40);
    private static final int koR = C1338a.fromDPToPix(C4996ah.getContext(), 1);
    private static final int koS = C1338a.fromDPToPix(C4996ah.getContext(), 16);
    public static final C33798c koT = new C33798c();
    private boolean exX = true;
    private Dialog gnn;
    private boolean isLoading;
    private int kfk;
    private ViewGroup koA;
    private int koB = 10;
    private boolean koC;
    private String koD = "";
    private final ArrayList<C33796a> koE = new ArrayList();
    private final ArrayList<C33796a> koF = new ArrayList();
    private C33796a koG;
    private C33796a koH;
    private C33796a koI;
    private boolean koJ;
    private int koK = -1;
    private boolean koL = true;
    private int koM;
    private C23419ns koN;
    private boolean koO;
    private final C31214a<C37091y> koP = new C33792f(this);
    private C45782h koQ;
    private LoadMoreRecyclerView kou;
    private C33799d kov;
    private ViewGroup kow;
    private ViewGroup kox;
    private ViewGroup koy;
    private C25373h koz;
    private int offset;
    private int scene;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$p */
    static final class C2785p implements C36073c {
        final /* synthetic */ CardHomePageNewUI koY;

        C2785p(CardHomePageNewUI cardHomePageNewUI) {
            this.koY = cardHomePageNewUI;
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(89231);
            c44273l.add(0, 0, 1, (CharSequence) this.koY.getString(C25738R.string.g68));
            c44273l.add(0, 1, 1, (CharSequence) this.koY.getString(C25738R.string.g6_));
            AppMethodBeat.m2505o(89231);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$q */
    static final class C6818q implements C5279d {
        final /* synthetic */ CardHomePageNewUI koY;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$q$1 */
        static final class C68191 implements OnClickListener {
            final /* synthetic */ C6818q kpE;

            C68191(C6818q c6818q) {
                this.kpE = c6818q;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(89232);
                this.kpE.koY.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
                AppMethodBeat.m2505o(89232);
            }
        }

        C6818q(CardHomePageNewUI cardHomePageNewUI) {
            this.koY = cardHomePageNewUI;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(89233);
            C25052j.m39375o(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            C4990ab.m7417i("MicroMsg.CardHomePageNewUI", "click item: %s, sortType: %s", Integer.valueOf(itemId), Integer.valueOf(this.koY.kfk));
            if (itemId != 0 || this.koY.kfk != 2) {
                if (itemId == 1 && this.koY.kfk == 1) {
                    this.koY.koO = true;
                    this.koY.offset = 0;
                    this.koY.kfk = 2;
                    CardHomePageNewUI.m55263p(this.koY);
                    C7060h.pYm.mo8381e(16322, Integer.valueOf(16));
                }
                AppMethodBeat.m2505o(89233);
            } else if (this.koY.kpR) {
                this.koY.koO = true;
                this.koY.offset = 0;
                this.koY.kfk = 1;
                CardHomePageNewUI.m55263p(this.koY);
                C7060h.pYm.mo8381e(16322, Integer.valueOf(15));
                AppMethodBeat.m2505o(89233);
            } else {
                C30379h.m48445a((Context) this.koY, this.koY.getString(C25738R.string.g6b), this.koY.getString(C25738R.string.dc8), this.koY.getString(C25738R.string.ckr), this.koY.getString(C25738R.string.atb), false, (OnClickListener) new C68191(this), null);
                AppMethodBeat.m2505o(89233);
            }
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteMchInListResponse;", "call"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$g */
    static final class C11340g<_Ret, _Var> implements C5681a<_Ret, _Var> {
        final /* synthetic */ CardHomePageNewUI koY;
        final /* synthetic */ String kpy;

        C11340g(CardHomePageNewUI cardHomePageNewUI, String str) {
            this.koY = cardHomePageNewUI;
            this.kpy = str;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(89214);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.CardHomePageNewUI", "errtype: %s, errcode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                btd btd = c37441a.fsy;
                C40585ws c40585ws = (C40585ws) btd;
                C4990ab.m7417i("MicroMsg.CardHomePageNewUI", "retCode: %s", Integer.valueOf(c40585ws.kdT));
                if (c40585ws.kdT == 0) {
                    CardHomePageNewUI.m55262o(this.koY).mo54350GW(this.kpy);
                } else {
                    C38736l.m65716ai(this.koY, c40585ws.kdU);
                }
                AppMethodBeat.m2505o(89214);
                return btd;
            }
            C38736l.m65717aj(this.koY, "");
            Object obj2 = C37091y.AUy;
            AppMethodBeat.m2505o(89214);
            return obj2;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$n */
    static final class C11341n implements OnMenuItemClickListener {
        final /* synthetic */ CardHomePageNewUI koY;

        C11341n(CardHomePageNewUI cardHomePageNewUI) {
            this.koY = cardHomePageNewUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(89227);
            this.koY.finish();
            AppMethodBeat.m2505o(89227);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0003J \u0010M\u001a\u00020K2\u0006\u0010N\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u0005H\u0002J\u0010\u0010Q\u001a\u00020K2\u0006\u0010P\u001a\u00020\u0005H\u0002J\u0010\u0010R\u001a\u00020K2\u0006\u0010P\u001a\u00020\u0005H\u0002J\u000e\u0010S\u001a\u00020K2\u0006\u0010T\u001a\u00020UJ\u001e\u0010V\u001a\u00020K2\u0006\u0010W\u001a\u00020\u00142\u0006\u0010X\u001a\u00020U2\u0006\u0010Y\u001a\u00020ZJ$\u0010E\u001a\u00020K2\n\u0010@\u001a\u00060AR\u00020B2\u0006\u0010P\u001a\u00020\u00052\b\b\u0002\u0010[\u001a\u00020\\J\u0010\u0010]\u001a\u00020K2\u0006\u0010P\u001a\u00020\u0005H\u0002J\u0010\u0010^\u001a\u00020K2\u0006\u0010P\u001a\u00020\u0005H\u0002J\u0010\u0010_\u001a\u00020K2\u0006\u0010P\u001a\u00020\u0005H\u0002J\u001c\u0010`\u001a\u00020K2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020c0b2\u0006\u0010d\u001a\u00020\bJ\u0014\u0010`\u001a\u00020K2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020f0bJ\u0018\u0010g\u001a\u00020K2\u0006\u0010h\u001a\u00020\\2\u0006\u0010P\u001a\u00020\u0005H\u0002R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001a\u0010\u001c\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\fR\u001a\u0010\"\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\fR\u001a\u0010%\u001a\u00020&X.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0010\"\u0004\b3\u0010\u0012R\u001a\u00104\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0010\"\u0004\b6\u0010\u0012R\u001a\u00107\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0016\"\u0004\b9\u0010\u0018R\u001a\u0010:\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0016\"\u0004\b<\u0010\u0018R\u001a\u0010=\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0010\"\u0004\b?\u0010\u0012R \u0010@\u001a\b\u0018\u00010AR\u00020BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0010\"\u0004\bI\u0010\u0012¨\u0006i"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;Landroid/view/View;I)V", "chpiCouponLayout", "Landroid/widget/LinearLayout;", "getChpiCouponLayout", "()Landroid/widget/LinearLayout;", "setChpiCouponLayout", "(Landroid/widget/LinearLayout;)V", "chpiDescTv", "Landroid/widget/TextView;", "getChpiDescTv", "()Landroid/widget/TextView;", "setChpiDescTv", "(Landroid/widget/TextView;)V", "chpiExpandIv", "Landroid/widget/ImageView;", "getChpiExpandIv", "()Landroid/widget/ImageView;", "setChpiExpandIv", "(Landroid/widget/ImageView;)V", "chpiExpandLayout", "getChpiExpandLayout", "setChpiExpandLayout", "chpiExpandTv", "getChpiExpandTv", "setChpiExpandTv", "chpiHeaderLayout", "getChpiHeaderLayout", "setChpiHeaderLayout", "chpiLabelLayout", "getChpiLabelLayout", "setChpiLabelLayout", "chpiLogoIv", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "getChpiLogoIv", "()Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "setChpiLogoIv", "(Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;)V", "chpiMchLabelTv", "Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;", "getChpiMchLabelTv", "()Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;", "setChpiMchLabelTv", "(Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;)V", "chpiNameTv", "getChpiNameTv", "setChpiNameTv", "chtiDescTv", "getChtiDescTv", "setChtiDescTv", "chtiIconIv", "getChtiIconIv", "setChtiIconIv", "chtiRightIv", "getChtiRightIv", "setChtiRightIv", "chtiTitleTv", "getChtiTitleTv", "setChtiTitleTv", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "getModel", "()Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "setModel", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;)V", "sectionTitleTv", "getSectionTitleTv", "setSectionTitleTv", "addCouponView", "", "view", "appendCouponView", "offset", "len", "position", "collapseCouponLayout", "expandCouponLayout", "gotoCardDetailUI", "cardId", "", "setCardBg", "imageView", "url", "radius", "", "useBackendExpandState", "", "showCollapseLayout", "showExpandLayout", "showMiniAppLayout", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "labelList", "Lcom/tencent/mm/protocal/protobuf/CardElementMchLabel;", "updateExpandLayout", "isExpended", "plugin-card_release"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$e */
    public final class C20179e extends C41531v {
        final /* synthetic */ CardHomePageNewUI koY;
        public TextView koZ;
        public CdnImageView kpa;
        public TextView kpb;
        public TextView kpc;
        public LinearLayout kpd;
        public LinearLayout kpe;
        public LinearLayout kpf;
        public LinearLayout kpg;
        public TextView kph;
        public ImageView kpi;
        public CardLabelTextView kpj;
        public ImageView kpk;
        public TextView kpl;
        public TextView kpm;
        public ImageView kpn;
        C33796a kpo;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$e$e */
        static final class C2784e implements View.OnClickListener {
            final /* synthetic */ C20179e kpp;

            C2784e(C20179e c20179e) {
                this.kpp = c20179e;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(89195);
                CardHomePageNewUI.m55261n(this.kpp.koY);
                AppMethodBeat.m2505o(89195);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$1$span$1", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;", "onClick", "", "widget", "Landroid/view/View;", "hrefInfo", "Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;", "plugin-card_release"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$e$d */
        public static final class C11339d extends C44087h {
            final /* synthetic */ View.OnClickListener kpx;

            C11339d(View.OnClickListener onClickListener) {
                this.kpx = onClickListener;
            }

            /* renamed from: a */
            public final void mo23045a(View view, C14932m c14932m) {
                AppMethodBeat.m2504i(89194);
                this.kpx.onClick(view);
                AppMethodBeat.m2505o(89194);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$e$g */
        static final class C20178g implements View.OnClickListener {
            final /* synthetic */ int exi;
            final /* synthetic */ C20179e kpp;
            final /* synthetic */ C23419ns kpq;

            C20178g(C20179e c20179e, int i, C23419ns c23419ns) {
                this.kpp = c20179e;
                this.exi = i;
                this.kpq = c23419ns;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(89197);
                C4990ab.m7410d("MicroMsg.CardHomePageNewUI", "do expand coupon layout");
                C20179e.m31207a(this.kpp, this.exi);
                C33796a c33796a = this.kpp.kpo;
                if (c33796a != null) {
                    c33796a.koX = true;
                }
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(1);
                C23419ns c23419ns = this.kpq;
                if (c23419ns == null) {
                    C25052j.dWJ();
                }
                objArr[1] = c23419ns.vSR;
                objArr[2] = Integer.valueOf(0);
                objArr[3] = Integer.valueOf(0);
                objArr[4] = Integer.valueOf(4);
                objArr[5] = Integer.valueOf(this.exi);
                objArr[6] = Integer.valueOf(this.kpp.koY.kfk);
                c7060h.mo8381e(16324, objArr);
                AppMethodBeat.m2505o(89197);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$e$f */
        static final class C20180f implements View.OnClickListener {
            final /* synthetic */ int exi;
            final /* synthetic */ C20179e kpp;
            final /* synthetic */ C23419ns kpq;

            C20180f(C20179e c20179e, int i, C23419ns c23419ns) {
                this.kpp = c20179e;
                this.exi = i;
                this.kpq = c23419ns;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(89196);
                C4990ab.m7410d("MicroMsg.CardHomePageNewUI", "do collapse coupon layout");
                C20179e.m31210b(this.kpp, this.exi);
                C33796a c33796a = this.kpp.kpo;
                if (c33796a != null) {
                    c33796a.koX = false;
                }
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(1);
                C23419ns c23419ns = this.kpq;
                if (c23419ns == null) {
                    C25052j.dWJ();
                }
                objArr[1] = c23419ns.vSR;
                objArr[2] = Integer.valueOf(0);
                objArr[3] = Integer.valueOf(0);
                objArr[4] = Integer.valueOf(5);
                objArr[5] = Integer.valueOf(this.exi);
                objArr[6] = Integer.valueOf(this.kpp.koY.kfk);
                c7060h.mo8381e(16324, objArr);
                AppMethodBeat.m2505o(89196);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$e$a */
        static final class C20181a implements View.OnClickListener {
            final /* synthetic */ int exi;
            final /* synthetic */ C20179e kpp;
            final /* synthetic */ C23419ns kpq;
            final /* synthetic */ C7276nq kpr;
            final /* synthetic */ int kps;

            C20181a(C20179e c20179e, C23419ns c23419ns, C7276nq c7276nq, int i, int i2) {
                this.kpp = c20179e;
                this.kpq = c23419ns;
                this.kpr = c7276nq;
                this.kps = i;
                this.exi = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(89191);
                this.kpp.koY.koJ = true;
                this.kpp.koY.koK = 0;
                this.kpp.koY.koN = this.kpq;
                C20179e c20179e = this.kpp;
                String str = this.kpr.vCb;
                C25052j.m39375o(str, "coupon.user_card_id");
                c20179e.mo35429GY(str);
                C7060h.pYm.mo8381e(16324, Integer.valueOf(1), this.kpq.vSR, Integer.valueOf(this.kps), this.kpr.vCb, Integer.valueOf(2), Integer.valueOf(this.exi), Integer.valueOf(this.kpp.koY.kfk));
                AppMethodBeat.m2505o(89191);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$e$b */
        static final class C20182b implements View.OnClickListener {
            final /* synthetic */ int exi;
            final /* synthetic */ C20179e kpp;
            final /* synthetic */ C23419ns kpq;
            final /* synthetic */ C7276nq kpr;
            final /* synthetic */ int kps;

            C20182b(C20179e c20179e, C23419ns c23419ns, C7276nq c7276nq, int i, int i2) {
                this.kpp = c20179e;
                this.kpq = c23419ns;
                this.kpr = c7276nq;
                this.kps = i;
                this.exi = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(89192);
                this.kpp.koY.koJ = true;
                this.kpp.koY.koK = 0;
                this.kpp.koY.koN = this.kpq;
                C20179e c20179e = this.kpp;
                String str = this.kpr.vCb;
                C25052j.m39375o(str, "coupon.user_card_id");
                c20179e.mo35429GY(str);
                C7060h.pYm.mo8381e(16324, Integer.valueOf(1), this.kpq.vSR, Integer.valueOf(this.kps), this.kpr.vCb, Integer.valueOf(2), Integer.valueOf(this.exi), Integer.valueOf(this.kpp.koY.kfk));
                AppMethodBeat.m2505o(89192);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$1$headerClickListener$1"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$e$c */
        static final class C20183c implements View.OnClickListener {
            final /* synthetic */ int iPU;
            final /* synthetic */ C20179e kpp;
            final /* synthetic */ C23419ns kpt;
            final /* synthetic */ C23419ns kpu;
            final /* synthetic */ boolean kpv = false;
            final /* synthetic */ C33796a kpw;

            C20183c(C23419ns c23419ns, C20179e c20179e, C23419ns c23419ns2, int i, C33796a c33796a) {
                this.kpt = c23419ns;
                this.kpp = c20179e;
                this.kpu = c23419ns2;
                this.iPU = i;
                this.kpw = c33796a;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(89193);
                C4990ab.m7416i("MicroMsg.CardHomePageNewUI", "click header");
                this.kpp.koY.koJ = true;
                this.kpp.koY.koK = 0;
                this.kpp.koY.koN = this.kpu;
                switch (this.kpt.vSW) {
                    case 1:
                        View view2 = this.kpp.apJ;
                        C25052j.m39375o(view2, "itemView");
                        Context context = view2.getContext();
                        if (context != null) {
                            C45774b.m84625a((MMActivity) context, this.kpt.vSX);
                            break;
                        }
                        C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                        AppMethodBeat.m2505o(89193);
                        throw c44941v;
                    case 2:
                        C30208ny c30208ny = this.kpt.vSY;
                        C45774b.m84635t(c30208ny.tzW, c30208ny.ttg, c30208ny.tIE);
                        break;
                }
                C7060h.pYm.mo8381e(16324, Integer.valueOf(1), this.kpt.vSR, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(this.iPU), Integer.valueOf(this.kpp.koY.kfk));
                AppMethodBeat.m2505o(89193);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showMiniAppLayout$1$1"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$e$h */
        static final class C20184h implements View.OnClickListener {
            final /* synthetic */ int iPU;
            final /* synthetic */ C20179e kpp;
            final /* synthetic */ C23419ns kpt;

            C20184h(C23419ns c23419ns, C20179e c20179e, int i) {
                this.kpt = c23419ns;
                this.kpp = c20179e;
                this.iPU = i;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(89198);
                if (this.kpt.vTd != null) {
                    String str = "MicroMsg.CardHomePageNewUI";
                    String str2 = "detail goto mini app %s";
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(this.kpt.vTd != null);
                    C4990ab.m7417i(str, str2, objArr);
                    this.kpp.koY.koJ = true;
                    this.kpp.koY.koK = 0;
                    this.kpp.koY.koN = this.kpt;
                    C45774b.m84635t(this.kpt.vTd.tzW, this.kpt.vTd.ttg, this.kpt.vTd.tIE);
                }
                C7060h c7060h = C7060h.pYm;
                Object[] objArr2 = new Object[7];
                objArr2[0] = Integer.valueOf(1);
                C33796a c33796a = this.kpp.kpo;
                if (c33796a == null) {
                    C25052j.dWJ();
                }
                C23419ns c23419ns = c33796a.koU;
                if (c23419ns == null) {
                    C25052j.dWJ();
                }
                objArr2[1] = c23419ns.vSR;
                objArr2[2] = Integer.valueOf(0);
                objArr2[3] = Integer.valueOf(0);
                objArr2[4] = Integer.valueOf(6);
                objArr2[5] = Integer.valueOf(this.iPU);
                objArr2[6] = Integer.valueOf(this.kpp.koY.kfk);
                c7060h.mo8381e(16324, objArr2);
                AppMethodBeat.m2505o(89198);
            }
        }

        public C20179e(CardHomePageNewUI cardHomePageNewUI, View view, int i) {
            C25052j.m39376p(view, "itemView");
            this.koY = cardHomePageNewUI;
            super(view);
            AppMethodBeat.m2504i(89210);
            View findViewById;
            CdnImageView cdnImageView;
            switch (i) {
                case 0:
                    findViewById = view.findViewById(2131822148);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chpi_logo_iv)");
                    this.kpa = (CdnImageView) findViewById;
                    findViewById = view.findViewById(2131822150);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chpi_username_tv)");
                    this.kpb = (TextView) findViewById;
                    findViewById = view.findViewById(2131822152);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chpi_desc_tv)");
                    this.kpc = (TextView) findViewById;
                    findViewById = view.findViewById(2131822167);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chpi_label_layout)");
                    this.kpe = (LinearLayout) findViewById;
                    findViewById = view.findViewById(2131822168);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chpi_coupon_layout)");
                    this.kpf = (LinearLayout) findViewById;
                    findViewById = view.findViewById(2131822169);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chpi_expand_layout)");
                    this.kpg = (LinearLayout) findViewById;
                    findViewById = view.findViewById(2131822171);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chpi_expand_iv)");
                    this.kpi = (ImageView) findViewById;
                    findViewById = view.findViewById(2131822170);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chpi_expand_tv)");
                    this.kph = (TextView) findViewById;
                    findViewById = view.findViewById(2131822151);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chpi_mch_label_tv)");
                    this.kpj = (CardLabelTextView) findViewById;
                    findViewById = view.findViewById(2131822166);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chpi_header_layout)");
                    this.kpd = (LinearLayout) findViewById;
                    cdnImageView = this.kpa;
                    if (cdnImageView == null) {
                        C25052j.avw("chpiLogoIv");
                    }
                    cdnImageView.setUseSdcardCache(true);
                    AppMethodBeat.m2505o(89210);
                    return;
                case 1:
                    findViewById = view.findViewById(2131822173);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chpi_section_title)");
                    this.koZ = (TextView) findViewById;
                    AppMethodBeat.m2505o(89210);
                    return;
                case 2:
                    findViewById = view.findViewById(2131822148);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chpi_logo_iv)");
                    this.kpa = (CdnImageView) findViewById;
                    findViewById = view.findViewById(2131822150);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chpi_username_tv)");
                    this.kpb = (TextView) findViewById;
                    findViewById = view.findViewById(2131822152);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chpi_desc_tv)");
                    this.kpc = (TextView) findViewById;
                    findViewById = view.findViewById(2131822151);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chpi_mch_label_tv)");
                    this.kpj = (CardLabelTextView) findViewById;
                    cdnImageView = this.kpa;
                    if (cdnImageView == null) {
                        C25052j.avw("chpiLogoIv");
                    }
                    cdnImageView.setUseSdcardCache(true);
                    AppMethodBeat.m2505o(89210);
                    return;
                case 3:
                    findViewById = view.findViewById(2131822148);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chpi_logo_iv)");
                    this.kpa = (CdnImageView) findViewById;
                    findViewById = view.findViewById(2131822150);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chpi_username_tv)");
                    this.kpb = (TextView) findViewById;
                    findViewById = view.findViewById(2131822152);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chpi_desc_tv)");
                    this.kpc = (TextView) findViewById;
                    cdnImageView = this.kpa;
                    if (cdnImageView == null) {
                        C25052j.avw("chpiLogoIv");
                    }
                    cdnImageView.setUseSdcardCache(true);
                    AppMethodBeat.m2505o(89210);
                    return;
                case 4:
                    findViewById = view.findViewById(2131822153);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chti_icon_iv)");
                    this.kpk = (ImageView) findViewById;
                    findViewById = view.findViewById(2131822154);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chti_title_tv)");
                    this.kpl = (TextView) findViewById;
                    findViewById = view.findViewById(2131822155);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chti_desc_tv)");
                    this.kpm = (TextView) findViewById;
                    findViewById = view.findViewById(2131822156);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chti_right_iv)");
                    this.kpn = (ImageView) findViewById;
                    AppMethodBeat.m2505o(89210);
                    return;
                case 5:
                    findViewById = view.findViewById(2131822153);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chti_icon_iv)");
                    this.kpk = (ImageView) findViewById;
                    findViewById = view.findViewById(2131822154);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chti_title_tv)");
                    this.kpl = (TextView) findViewById;
                    findViewById = view.findViewById(2131822155);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chti_desc_tv)");
                    this.kpm = (TextView) findViewById;
                    findViewById = view.findViewById(2131822156);
                    C25052j.m39375o(findViewById, "itemView.findViewById(R.id.chti_right_iv)");
                    this.kpn = (ImageView) findViewById;
                    break;
            }
            AppMethodBeat.m2505o(89210);
        }

        /* renamed from: a */
        public static /* synthetic */ void m31208a(C20179e c20179e, C33796a c33796a, int i) {
            AppMethodBeat.m2504i(89200);
            c20179e.mo35430a(c33796a, i);
            AppMethodBeat.m2505o(89200);
        }

        /* renamed from: a */
        public final void mo35430a(C33796a c33796a, int i) {
            AppMethodBeat.m2504i(89199);
            C25052j.m39376p(c33796a, "model");
            this.kpo = c33796a;
            C23419ns c23419ns = c33796a.koU;
            CdnImageView cdnImageView;
            TextView textView;
            TextView textView2;
            CardLabelTextView cardLabelTextView;
            CardLabelTextView cardLabelTextView2;
            C37091y c37091y;
            TextView textView3;
            switch (c33796a.type) {
                case 0:
                    boolean z;
                    LinkedList linkedList;
                    if (c23419ns == null) {
                        C25052j.dWJ();
                    }
                    cdnImageView = this.kpa;
                    if (cdnImageView == null) {
                        C25052j.avw("chpiLogoIv");
                    }
                    cdnImageView.setRoundCorner(true);
                    if (C5046bo.isNullOrNil(c23419ns.vSS)) {
                        cdnImageView = this.kpa;
                        if (cdnImageView == null) {
                            C25052j.avw("chpiLogoIv");
                        }
                        cdnImageView.setImageResource(C1318a.card_default_merchant_icon);
                    } else {
                        cdnImageView = this.kpa;
                        if (cdnImageView == null) {
                            C25052j.avw("chpiLogoIv");
                        }
                        cdnImageView.mo38952eb(c23419ns.vSS, C1318a.card_default_merchant_icon);
                    }
                    View.OnClickListener c20183c = new C20183c(c23419ns, this, c23419ns, i, c33796a);
                    CdnImageView cdnImageView2 = this.kpa;
                    if (cdnImageView2 == null) {
                        C25052j.avw("chpiLogoIv");
                    }
                    cdnImageView2.setOnClickListener(c20183c);
                    CardHomePageNewUI cardHomePageNewUI = this.koY;
                    AppCompatActivity dxU = this.koY.dxU();
                    C25052j.m39375o(dxU, "context");
                    C33797b c33797b = new C33797b(cardHomePageNewUI, dxU.getResources().getColor(C25738R.color.a0j), new C11339d(c20183c));
                    SpannableString spannableString = new SpannableString(c23419ns.vST);
                    spannableString.setSpan(c33797b, 0, spannableString.length(), 18);
                    textView = this.kpb;
                    if (textView == null) {
                        C25052j.avw("chpiNameTv");
                    }
                    textView.setClickable(true);
                    TextView textView4 = this.kpb;
                    if (textView4 == null) {
                        C25052j.avw("chpiNameTv");
                    }
                    textView4.setOnTouchListener(new C30132m(this.koY));
                    TextView textView5 = this.kpb;
                    if (textView5 == null) {
                        C25052j.avw("chpiNameTv");
                    }
                    textView5.setText(spannableString);
                    if (C5046bo.isNullOrNil(c23419ns.vSU)) {
                        textView2 = this.kpc;
                        if (textView2 == null) {
                            C25052j.avw("chpiDescTv");
                        }
                        textView2.setVisibility(8);
                    } else {
                        textView5 = this.kpc;
                        if (textView5 == null) {
                            C25052j.avw("chpiDescTv");
                        }
                        textView5.setText(c23419ns.vSU);
                        textView = this.kpc;
                        if (textView == null) {
                            C25052j.avw("chpiDescTv");
                        }
                        textView.setVisibility(0);
                        textView = this.kpc;
                        if (textView == null) {
                            C25052j.avw("chpiDescTv");
                        }
                        textView.setOnClickListener(c20183c);
                    }
                    if (c23419ns.vTe == null) {
                        cardLabelTextView = this.kpj;
                        if (cardLabelTextView == null) {
                            C25052j.avw("chpiMchLabelTv");
                        }
                        cardLabelTextView.setText("");
                        cardLabelTextView2 = this.kpj;
                        if (cardLabelTextView2 == null) {
                            C25052j.avw("chpiMchLabelTv");
                        }
                        cardLabelTextView2.setVisibility(8);
                    } else if (C5046bo.isNullOrNil(c23419ns.vTe.vSL)) {
                        cardLabelTextView2 = this.kpj;
                        if (cardLabelTextView2 == null) {
                            C25052j.avw("chpiMchLabelTv");
                        }
                        cardLabelTextView2.setVisibility(8);
                    } else {
                        cardLabelTextView = this.kpj;
                        if (cardLabelTextView == null) {
                            C25052j.avw("chpiMchLabelTv");
                        }
                        cardLabelTextView.setText(c23419ns.vTe.vSL);
                        if (C5046bo.isNullOrNil(c23419ns.vTe.vSM)) {
                            cardLabelTextView2 = this.kpj;
                            if (cardLabelTextView2 == null) {
                                C25052j.avw("chpiMchLabelTv");
                            }
                            cardLabelTextView2.setTextColor(-1);
                        } else {
                            cardLabelTextView2 = this.kpj;
                            if (cardLabelTextView2 == null) {
                                C25052j.avw("chpiMchLabelTv");
                            }
                            cardLabelTextView2.setTextColor(Color.parseColor(c23419ns.vTe.vSM));
                        }
                        if (C5046bo.isNullOrNil(c23419ns.vTe.vSN)) {
                            cardLabelTextView2 = this.kpj;
                            if (cardLabelTextView2 == null) {
                                C25052j.avw("chpiMchLabelTv");
                            }
                            cardLabelTextView2.setFillColor(0);
                        } else {
                            cardLabelTextView2 = this.kpj;
                            if (cardLabelTextView2 == null) {
                                C25052j.avw("chpiMchLabelTv");
                            }
                            cardLabelTextView2.setFillColor(C38736l.m65721bT(c23419ns.vTe.vSN, c23419ns.vTe.vSQ));
                        }
                        cardLabelTextView2 = this.kpj;
                        if (cardLabelTextView2 == null) {
                            C25052j.avw("chpiMchLabelTv");
                        }
                        cardLabelTextView2.setVisibility(0);
                    }
                    LinearLayout linearLayout = this.kpf;
                    if (linearLayout == null) {
                        C25052j.avw("chpiCouponLayout");
                    }
                    linearLayout.removeAllViews();
                    if (c33796a.koW) {
                        z = c33796a.koX;
                    } else if (c23419ns.vTf == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        linkedList = c23419ns.vTa;
                        C25052j.m39375o(linkedList, "card_element_coupon_list");
                        if (!((Collection) linkedList).isEmpty()) {
                            m31206P(-1, c23419ns.vTa.size(), i);
                            linearLayout = this.kpf;
                            if (linearLayout == null) {
                                C25052j.avw("chpiCouponLayout");
                            }
                            linearLayout.setVisibility(0);
                            c33796a.koX = true;
                        } else {
                            linearLayout = this.kpf;
                            if (linearLayout == null) {
                                C25052j.avw("chpiCouponLayout");
                            }
                            linearLayout.setVisibility(8);
                        }
                        if (!C5046bo.isNullOrNil(c23419ns.vTb)) {
                            m31214ti(i);
                            linearLayout = this.kpg;
                            if (linearLayout == null) {
                                C25052j.avw("chpiExpandLayout");
                            }
                            linearLayout.setVisibility(0);
                        } else if (c23419ns.vTh < c23419ns.vTa.size()) {
                            m31216tk(i);
                        } else {
                            linearLayout = this.kpg;
                            if (linearLayout == null) {
                                C25052j.avw("chpiExpandLayout");
                            }
                            linearLayout.setVisibility(8);
                        }
                    } else {
                        linkedList = c23419ns.vTa;
                        C25052j.m39375o(linkedList, "card_element_coupon_list");
                        if (!((Collection) linkedList).isEmpty()) {
                            m31206P(-1, c23419ns.vTh, i);
                            linearLayout = this.kpf;
                            if (linearLayout == null) {
                                C25052j.avw("chpiCouponLayout");
                            }
                            linearLayout.setVisibility(0);
                            c33796a.koX = false;
                        } else {
                            linearLayout = this.kpf;
                            if (linearLayout == null) {
                                C25052j.avw("chpiCouponLayout");
                            }
                            linearLayout.setVisibility(8);
                        }
                        if (c23419ns.vTh < c23419ns.vTa.size()) {
                            m31215tj(i);
                            linearLayout = this.kpg;
                            if (linearLayout == null) {
                                C25052j.avw("chpiExpandLayout");
                            }
                            linearLayout.setVisibility(0);
                        } else if (C5046bo.isNullOrNil(c23419ns.vTb)) {
                            linearLayout = this.kpg;
                            if (linearLayout == null) {
                                C25052j.avw("chpiExpandLayout");
                            }
                            linearLayout.setVisibility(8);
                        } else {
                            m31214ti(i);
                            linearLayout = this.kpg;
                            if (linearLayout == null) {
                                C25052j.avw("chpiExpandLayout");
                            }
                            linearLayout.setVisibility(0);
                        }
                    }
                    linkedList = c23419ns.vSV;
                    C25052j.m39375o(linkedList, "card_element_mch_label");
                    m31211bi(linkedList);
                    c37091y = C37091y.AUy;
                    break;
                case 1:
                    textView3 = this.koZ;
                    if (textView3 == null) {
                        C25052j.avw("sectionTitleTv");
                    }
                    textView3.setText(c33796a.bek());
                    break;
                case 2:
                    if (c23419ns == null) {
                        C25052j.dWJ();
                    }
                    cdnImageView = this.kpa;
                    if (cdnImageView == null) {
                        C25052j.avw("chpiLogoIv");
                    }
                    cdnImageView.setRoundCorner(true);
                    cdnImageView = this.kpa;
                    if (cdnImageView == null) {
                        C25052j.avw("chpiLogoIv");
                    }
                    cdnImageView.setUrl(c23419ns.vSS);
                    textView = this.kpb;
                    if (textView == null) {
                        C25052j.avw("chpiNameTv");
                    }
                    textView.setText(c23419ns.vST);
                    if (C5046bo.isNullOrNil(c23419ns.vSU)) {
                        textView2 = this.kpc;
                        if (textView2 == null) {
                            C25052j.avw("chpiDescTv");
                        }
                        textView2.setVisibility(8);
                    } else {
                        textView = this.kpc;
                        if (textView == null) {
                            C25052j.avw("chpiDescTv");
                        }
                        textView.setText(c23419ns.vSU);
                        textView2 = this.kpc;
                        if (textView2 == null) {
                            C25052j.avw("chpiDescTv");
                        }
                        textView2.setVisibility(0);
                    }
                    if (c23419ns.vTe == null) {
                        CardLabelTextView cardLabelTextView3 = this.kpj;
                        if (cardLabelTextView3 == null) {
                            C25052j.avw("chpiMchLabelTv");
                        }
                        cardLabelTextView3.setText("");
                        cardLabelTextView2 = this.kpj;
                        if (cardLabelTextView2 == null) {
                            C25052j.avw("chpiMchLabelTv");
                        }
                        cardLabelTextView2.setVisibility(8);
                    } else if (C5046bo.isNullOrNil(c23419ns.vTe.vSL)) {
                        cardLabelTextView2 = this.kpj;
                        if (cardLabelTextView2 == null) {
                            C25052j.avw("chpiMchLabelTv");
                        }
                        cardLabelTextView2.setVisibility(8);
                    } else {
                        cardLabelTextView = this.kpj;
                        if (cardLabelTextView == null) {
                            C25052j.avw("chpiMchLabelTv");
                        }
                        cardLabelTextView.setText(c23419ns.vTe.vSL);
                        if (C5046bo.isNullOrNil(c23419ns.vTe.vSM)) {
                            cardLabelTextView2 = this.kpj;
                            if (cardLabelTextView2 == null) {
                                C25052j.avw("chpiMchLabelTv");
                            }
                            cardLabelTextView2.setTextColor(-1);
                        } else {
                            cardLabelTextView2 = this.kpj;
                            if (cardLabelTextView2 == null) {
                                C25052j.avw("chpiMchLabelTv");
                            }
                            cardLabelTextView2.setTextColor(Color.parseColor(c23419ns.vTe.vSM));
                        }
                        if (C5046bo.isNullOrNil(c23419ns.vTe.vSN)) {
                            cardLabelTextView2 = this.kpj;
                            if (cardLabelTextView2 == null) {
                                C25052j.avw("chpiMchLabelTv");
                            }
                            cardLabelTextView2.setFillColor(0);
                        } else {
                            cardLabelTextView2 = this.kpj;
                            if (cardLabelTextView2 == null) {
                                C25052j.avw("chpiMchLabelTv");
                            }
                            cardLabelTextView2.setFillColor(C38736l.m65721bT(c23419ns.vTe.vSN, c23419ns.vTe.vSQ));
                        }
                        cardLabelTextView2 = this.kpj;
                        if (cardLabelTextView2 == null) {
                            C25052j.avw("chpiMchLabelTv");
                        }
                        cardLabelTextView2.setVisibility(0);
                    }
                    c37091y = C37091y.AUy;
                    break;
                case 3:
                    cdnImageView = this.kpa;
                    if (cdnImageView == null) {
                        C25052j.avw("chpiLogoIv");
                    }
                    cdnImageView.setRoundCorner(true);
                    cdnImageView = this.kpa;
                    if (cdnImageView == null) {
                        C25052j.avw("chpiLogoIv");
                    }
                    cdnImageView.setImageResource(C1318a.card_default_merchant_icon);
                    textView3 = this.kpb;
                    if (textView3 == null) {
                        C25052j.avw("chpiNameTv");
                    }
                    textView3.setText(C4996ah.getResources().getString(C25738R.string.aeu));
                    textView2 = this.kpc;
                    if (textView2 == null) {
                        C25052j.avw("chpiDescTv");
                    }
                    textView2.setVisibility(8);
                    break;
                case 4:
                    textView2 = this.kpl;
                    if (textView2 == null) {
                        C25052j.avw("chtiTitleTv");
                    }
                    textView2.setText(C25738R.string.evz);
                    if (this.koY.koD != null) {
                        textView3 = this.kpm;
                        if (textView3 == null) {
                            C25052j.avw("chtiDescTv");
                        }
                        textView3.setText(this.koY.koD);
                        c37091y = C37091y.AUy;
                        break;
                    }
                    break;
                case 5:
                    textView2 = this.kpl;
                    if (textView2 == null) {
                        C25052j.avw("chtiTitleTv");
                    }
                    textView2.setText(C25738R.string.agc);
                    ImageView imageView;
                    if (this.koY.koM == 1 && this.koY.kfk != 0) {
                        textView2 = this.kpm;
                        if (textView2 == null) {
                            C25052j.avw("chtiDescTv");
                        }
                        textView2.setVisibility(0);
                        imageView = this.kpn;
                        if (imageView == null) {
                            C25052j.avw("chtiRightIv");
                        }
                        imageView.setVisibility(0);
                        if (this.koY.kfk == 1) {
                            textView2 = this.kpm;
                            if (textView2 == null) {
                                C25052j.avw("chtiDescTv");
                            }
                            textView2.setText(C25738R.string.g68);
                        } else if (this.koY.kfk == 2) {
                            textView2 = this.kpm;
                            if (textView2 == null) {
                                C25052j.avw("chtiDescTv");
                            }
                            textView2.setText(C25738R.string.g6_);
                        }
                        textView3 = this.kpm;
                        if (textView3 == null) {
                            C25052j.avw("chtiDescTv");
                        }
                        textView3.setOnClickListener(new C2784e(this));
                        break;
                    }
                    textView2 = this.kpm;
                    if (textView2 == null) {
                        C25052j.avw("chtiDescTv");
                    }
                    textView2.setVisibility(8);
                    imageView = this.kpn;
                    if (imageView == null) {
                        C25052j.avw("chtiRightIv");
                    }
                    imageView.setVisibility(8);
                    break;
                    break;
            }
            c33796a.koW = true;
            AppMethodBeat.m2505o(89199);
        }

        /* renamed from: P */
        private final void m31206P(int i, int i2, int i3) {
            AppMethodBeat.m2504i(89201);
            C33796a c33796a = this.kpo;
            if (c33796a == null) {
                C25052j.dWJ();
            }
            C23419ns c23419ns = c33796a.koU;
            if (c23419ns == null) {
                C25052j.dWJ();
            }
            LinkedList<C7276nq> linkedList = c23419ns.vTa;
            C25052j.m39375o(linkedList, "el!!.card_element_coupon_list");
            int i4 = 0;
            int i5 = 0;
            for (C7276nq c7276nq : linkedList) {
                if (i4 >= i) {
                    LinearLayout linearLayout;
                    LayoutInflater from;
                    View inflate;
                    C44941v c44941v;
                    ViewGroup viewGroup;
                    TextView textView;
                    LinkedList linkedList2;
                    List list;
                    if (c7276nq.vSE == 1) {
                        linearLayout = this.kpf;
                        if (linearLayout == null) {
                            C25052j.avw("chpiCouponLayout");
                        }
                        from = LayoutInflater.from(linearLayout.getContext());
                        linearLayout = this.kpf;
                        if (linearLayout == null) {
                            C25052j.avw("chpiCouponLayout");
                        }
                        inflate = from.inflate(2130968932, linearLayout, false);
                        if (inflate == null) {
                            c44941v = new C44941v("null cannot be cast to non-null type android.view.ViewGroup");
                            AppMethodBeat.m2505o(89201);
                            throw c44941v;
                        }
                        viewGroup = (ViewGroup) inflate;
                        textView = (TextView) viewGroup.findViewById(2131822159);
                        CdnImageView cdnImageView = (CdnImageView) viewGroup.findViewById(2131822162);
                        TextView textView2 = (TextView) viewGroup.findViewById(2131822160);
                        LinearLayout linearLayout2 = (LinearLayout) viewGroup.findViewById(2131822161);
                        if (!C5046bo.isNullOrNil(c7276nq.vSH)) {
                            textView.setTextColor(C38736l.m65721bT(c7276nq.vSH, c7276nq.vSI));
                        }
                        C25052j.m39375o(textView, "titleTv");
                        textView.setText(c7276nq.vSy);
                        cdnImageView.setUrl(c7276nq.vSF);
                        if (!C5046bo.isNullOrNil(c7276nq.vSJ)) {
                            textView2.setTextColor(C38736l.m65721bT(c7276nq.vSJ, c7276nq.vSK));
                        }
                        C25052j.m39375o(textView2, "descTv");
                        textView2.setText(c7276nq.vSz);
                        linkedList2 = c7276nq.vSD;
                        C25052j.m39375o(linkedList2, "coupon.coupon_label");
                        list = linkedList2;
                        C25052j.m39375o(linearLayout2, "labelLayout");
                        m31209a(list, linearLayout2);
                        linearLayout = this.kpf;
                        if (linearLayout == null) {
                            C25052j.avw("chpiCouponLayout");
                        }
                        viewGroup.setOnClickListener(new C20181a(this, c23419ns, c7276nq, linearLayout.getChildCount(), i3));
                        m31212db(viewGroup);
                    } else if (c7276nq.vSE == 2) {
                        linearLayout = this.kpf;
                        if (linearLayout == null) {
                            C25052j.avw("chpiCouponLayout");
                        }
                        from = LayoutInflater.from(linearLayout.getContext());
                        linearLayout = this.kpf;
                        if (linearLayout == null) {
                            C25052j.avw("chpiCouponLayout");
                        }
                        inflate = from.inflate(2130968931, linearLayout, false);
                        if (inflate == null) {
                            c44941v = new C44941v("null cannot be cast to non-null type android.view.ViewGroup");
                            AppMethodBeat.m2505o(89201);
                            throw c44941v;
                        }
                        viewGroup = (ViewGroup) inflate;
                        textView = (TextView) viewGroup.findViewById(2131822159);
                        TextView textView3 = (TextView) viewGroup.findViewById(2131822160);
                        LinearLayout linearLayout3 = (LinearLayout) viewGroup.findViewById(2131822161);
                        MemberCardTopCropImageView memberCardTopCropImageView = (MemberCardTopCropImageView) viewGroup.findViewById(2131822157);
                        ImageView imageView = (ImageView) viewGroup.findViewById(2131822158);
                        if (!C5046bo.isNullOrNil(c7276nq.vSH)) {
                            textView.setTextColor(C38736l.m65721bT(c7276nq.vSH, c7276nq.vSI));
                        }
                        C25052j.m39375o(textView, "titleTv");
                        textView.setText(c7276nq.vSy);
                        C25052j.m39375o(textView3, "descTv");
                        textView3.setText(c7276nq.vSz);
                        C25052j.m39375o(memberCardTopCropImageView, "bgIv");
                        memberCardTopCropImageView.setRadius((float) C1338a.fromDPToPix(memberCardTopCropImageView.getContext(), 2));
                        if (!C5046bo.isNullOrNil(c7276nq.vSC)) {
                            ImageView imageView2 = memberCardTopCropImageView;
                            String str = c7276nq.vSC;
                            C25052j.m39375o(str, "coupon.coupon_back_url");
                            C25052j.m39376p(imageView2, "imageView");
                            C25052j.m39376p(str, "url");
                            C17927a c17927a = new C17927a();
                            c17927a.mo33453sD(C6457e.eSn);
                            c17927a.mo33442a(C32291o.ahq());
                            c17927a.mo33452sC(C33770m.m55183Gz(str));
                            c17927a.ahD();
                            c17927a.ahF();
                            c17927a.ahC();
                            c17927a.mo33451lK(C25738R.drawable.f6514gp);
                            c17927a.mo33450lJ(C1338a.fromDPToPix(imageView2.getContext(), 84));
                            c17927a.mo33449lI(C1338a.m2868gd(imageView2.getContext()));
                            C32291o.ahp().mo43766a(str, imageView2, c17927a.ahG());
                            imageView2.setImageMatrix(new Matrix());
                            C25052j.m39375o(imageView, "shadowBgIv");
                            imageView.setVisibility(0);
                        } else if (!C5046bo.isNullOrNil(c7276nq.vSB)) {
                            memberCardTopCropImageView.setImageDrawable(new ColorDrawable(Color.parseColor(c7276nq.vSB)));
                            C25052j.m39375o(imageView, "shadowBgIv");
                            imageView.setVisibility(0);
                        }
                        linkedList2 = c7276nq.vSD;
                        C25052j.m39375o(linkedList2, "coupon.coupon_label");
                        list = linkedList2;
                        C25052j.m39375o(linearLayout3, "labelLayout");
                        m31209a(list, linearLayout3);
                        linearLayout = this.kpf;
                        if (linearLayout == null) {
                            C25052j.avw("chpiCouponLayout");
                        }
                        viewGroup.setOnClickListener(new C20182b(this, c23419ns, c7276nq, linearLayout.getChildCount(), i3));
                        m31212db(viewGroup);
                    }
                    if (i2 > 0) {
                        i5++;
                        if (i5 >= i2) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
                i4++;
                i5 = i5;
            }
            AppMethodBeat.m2505o(89201);
        }

        /* renamed from: GY */
        public final void mo35429GY(String str) {
            AppMethodBeat.m2504i(89202);
            C25052j.m39376p(str, "cardId");
            C4990ab.m7417i("MicroMsg.CardHomePageNewUI", "go to card detail: %s", str);
            View view = this.apJ;
            C25052j.m39375o(view, "itemView");
            Intent intent = new Intent(view.getContext(), CardDetailUI.class);
            intent.putExtra("key_card_id", str);
            intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            intent.putExtra("key_from_scene", 3);
            view = this.apJ;
            C25052j.m39375o(view, "itemView");
            view.getContext().startActivity(intent);
            AppMethodBeat.m2505o(89202);
        }

        /* renamed from: db */
        private void m31212db(View view) {
            AppMethodBeat.m2504i(89203);
            C25052j.m39376p(view, "view");
            LinearLayout linearLayout = this.kpf;
            if (linearLayout == null) {
                C25052j.avw("chpiCouponLayout");
            }
            if (linearLayout.getChildCount() == 0) {
                linearLayout = this.kpf;
                if (linearLayout == null) {
                    C25052j.avw("chpiCouponLayout");
                }
                linearLayout.addView(view);
                AppMethodBeat.m2505o(89203);
                return;
            }
            LinearLayout linearLayout2 = this.kpf;
            if (linearLayout2 == null) {
                C25052j.avw("chpiCouponLayout");
            }
            MarginLayoutParams marginLayoutParams = new MarginLayoutParams(-1, C1338a.fromDPToPix(linearLayout2.getContext(), 84));
            linearLayout = this.kpf;
            if (linearLayout == null) {
                C25052j.avw("chpiCouponLayout");
            }
            marginLayoutParams.topMargin = C1338a.fromDPToPix(linearLayout.getContext(), 8);
            MarginLayoutParams layoutParams = new LayoutParams(marginLayoutParams);
            LinearLayout linearLayout3 = this.kpf;
            if (linearLayout3 == null) {
                C25052j.avw("chpiCouponLayout");
            }
            linearLayout3.addView(view, layoutParams);
            AppMethodBeat.m2505o(89203);
        }

        /* renamed from: bi */
        private void m31211bi(List<? extends C7277nr> list) {
            AppMethodBeat.m2504i(89204);
            C25052j.m39376p(list, "labelList");
            LinearLayout linearLayout = this.kpe;
            if (linearLayout == null) {
                C25052j.avw("chpiLabelLayout");
            }
            linearLayout.removeAllViews();
            if (list.isEmpty()) {
                linearLayout = this.kpe;
                if (linearLayout == null) {
                    C25052j.avw("chpiLabelLayout");
                }
                linearLayout.setVisibility(8);
                AppMethodBeat.m2505o(89204);
                return;
            }
            int i = 0;
            for (C7277nr c7277nr : list) {
                linearLayout = this.kpe;
                if (linearLayout == null) {
                    C25052j.avw("chpiLabelLayout");
                }
                Context context = linearLayout.getContext();
                C25052j.m39375o(context, "chpiLabelLayout.context");
                CardLabelTextView cardLabelTextView = new CardLabelTextView(context);
                linearLayout = this.kpe;
                if (linearLayout == null) {
                    C25052j.avw("chpiLabelLayout");
                }
                Context context2 = linearLayout.getContext();
                cardLabelTextView.setTextSize(1, 12.0f);
                cardLabelTextView.setText(c7277nr.vSL);
                int fromDPToPix = C1338a.fromDPToPix(context2, 4);
                cardLabelTextView.setPadding(fromDPToPix, 0, fromDPToPix, 0);
                cardLabelTextView.setGravity(16);
                if (C5046bo.isNullOrNil(c7277nr.vSM)) {
                    cardLabelTextView.setTextColor(-1);
                } else {
                    cardLabelTextView.setTextColor(Color.parseColor(c7277nr.vSM));
                }
                if (C5046bo.isNullOrNil(c7277nr.vSN)) {
                    cardLabelTextView.setFillColor(0);
                } else {
                    cardLabelTextView.setFillColor(C38736l.m65721bT(c7277nr.vSN, c7277nr.vSQ));
                }
                if (i > 0) {
                    MarginLayoutParams marginLayoutParams = new MarginLayoutParams(-2, -2);
                    marginLayoutParams.leftMargin = C1338a.fromDPToPix(context2, 4);
                    MarginLayoutParams layoutParams = new LayoutParams(marginLayoutParams);
                    LinearLayout linearLayout2 = this.kpe;
                    if (linearLayout2 == null) {
                        C25052j.avw("chpiLabelLayout");
                    }
                    linearLayout2.addView(cardLabelTextView, layoutParams);
                } else {
                    linearLayout = this.kpe;
                    if (linearLayout == null) {
                        C25052j.avw("chpiLabelLayout");
                    }
                    linearLayout.addView(cardLabelTextView);
                }
                i++;
            }
            linearLayout = this.kpe;
            if (linearLayout == null) {
                C25052j.avw("chpiLabelLayout");
            }
            linearLayout.setVisibility(0);
            AppMethodBeat.m2505o(89204);
        }

        /* renamed from: a */
        private void m31209a(List<? extends C7275np> list, LinearLayout linearLayout) {
            AppMethodBeat.m2504i(89205);
            C25052j.m39376p(list, "couponLabelList");
            C25052j.m39376p(linearLayout, "labelLayout");
            for (C7275np c7275np : list) {
                LinearLayout linearLayout2 = this.kpf;
                if (linearLayout2 == null) {
                    C25052j.avw("chpiCouponLayout");
                }
                CardTagTextView cardTagTextView = new CardTagTextView(linearLayout2.getContext());
                linearLayout2 = this.kpf;
                if (linearLayout2 == null) {
                    C25052j.avw("chpiCouponLayout");
                }
                Context context = linearLayout2.getContext();
                cardTagTextView.setMinHeight(C1338a.fromDPToPix(context, 18));
                cardTagTextView.setMinWidth(C1338a.fromDPToPix(context, 56));
                int fromDPToPix = C1338a.fromDPToPix(context, 8);
                int fromDPToPix2 = C1338a.fromDPToPix(context, 4);
                cardTagTextView.setPadding(fromDPToPix, fromDPToPix2, fromDPToPix, fromDPToPix2);
                cardTagTextView.setText(c7275np.vSs);
                cardTagTextView.setTextSize(1, 10.0f);
                if (C5046bo.isNullOrNil(c7275np.vSt)) {
                    cardTagTextView.setTextColor(-1);
                } else {
                    cardTagTextView.setTextColor(Color.parseColor(c7275np.vSt));
                }
                if (C5046bo.isNullOrNil(c7275np.vSu)) {
                    cardTagTextView.setFillColor(C38736l.m65726dJ(WebView.NIGHT_MODE_COLOR, 26));
                } else {
                    cardTagTextView.setFillColor(C38736l.m65721bT(c7275np.vSu, c7275np.vSx));
                }
                linearLayout.addView(cardTagTextView);
            }
            AppMethodBeat.m2505o(89205);
        }

        /* renamed from: ti */
        private final void m31214ti(int i) {
            AppMethodBeat.m2504i(89206);
            C33796a c33796a = this.kpo;
            if (c33796a == null) {
                C25052j.dWJ();
            }
            C23419ns c23419ns = c33796a.koU;
            if (c23419ns == null) {
                C25052j.dWJ();
            }
            if (!C5046bo.isNullOrNil(c23419ns.vTb)) {
                if (!C5046bo.isNullOrNil(c23419ns.vTc)) {
                    TextView textView = this.kph;
                    if (textView == null) {
                        C25052j.avw("chpiExpandTv");
                    }
                    textView.setTextColor(Color.parseColor(c23419ns.vTc));
                }
                TextView textView2 = this.kph;
                if (textView2 == null) {
                    C25052j.avw("chpiExpandTv");
                }
                textView2.setText(c23419ns.vTb);
                ImageView imageView = this.kpi;
                if (imageView == null) {
                    C25052j.avw("chpiExpandIv");
                }
                imageView.setImageResource(C25738R.drawable.ayr);
                LinearLayout linearLayout = this.kpg;
                if (linearLayout == null) {
                    C25052j.avw("chpiExpandLayout");
                }
                linearLayout.setOnClickListener(new C20184h(c23419ns, this, i));
            }
            AppMethodBeat.m2505o(89206);
        }

        /* renamed from: tj */
        private final void m31215tj(int i) {
            AppMethodBeat.m2504i(89207);
            C33796a c33796a = this.kpo;
            if (c33796a == null) {
                C25052j.dWJ();
            }
            C23419ns c23419ns = c33796a.koU;
            TextView textView = this.kph;
            if (textView == null) {
                C25052j.avw("chpiExpandTv");
            }
            Resources resources = C4996ah.getResources();
            Object[] objArr = new Object[1];
            if (c23419ns == null) {
                C25052j.dWJ();
            }
            objArr[0] = Integer.valueOf(c23419ns.vTg - c23419ns.vTh);
            textView.setText(resources.getString(C25738R.string.aet, objArr));
            LinearLayout linearLayout = this.kpg;
            if (linearLayout == null) {
                C25052j.avw("chpiExpandLayout");
            }
            linearLayout.setOnClickListener(new C20178g(this, i, c23419ns));
            ImageView imageView = this.kpi;
            if (imageView == null) {
                C25052j.avw("chpiExpandIv");
            }
            imageView.setImageResource(C25738R.drawable.azj);
            imageView = this.kpi;
            if (imageView == null) {
                C25052j.avw("chpiExpandIv");
            }
            imageView.setVisibility(0);
            AppMethodBeat.m2505o(89207);
        }

        /* renamed from: tk */
        private final void m31216tk(int i) {
            AppMethodBeat.m2504i(89208);
            C33796a c33796a = this.kpo;
            if (c33796a == null) {
                C25052j.dWJ();
            }
            C23419ns c23419ns = c33796a.koU;
            TextView textView = this.kph;
            if (textView == null) {
                C25052j.avw("chpiExpandTv");
            }
            textView.setText(C4996ah.getResources().getString(C25738R.string.aer));
            LinearLayout linearLayout = this.kpg;
            if (linearLayout == null) {
                C25052j.avw("chpiExpandLayout");
            }
            linearLayout.setOnClickListener(new C20180f(this, i, c23419ns));
            ImageView imageView = this.kpi;
            if (imageView == null) {
                C25052j.avw("chpiExpandIv");
            }
            imageView.setImageResource(C25738R.drawable.azk);
            imageView = this.kpi;
            if (imageView == null) {
                C25052j.avw("chpiExpandIv");
            }
            imageView.setVisibility(0);
            AppMethodBeat.m2505o(89208);
        }

        /* renamed from: o */
        private final void m31213o(boolean z, int i) {
            AppMethodBeat.m2504i(89209);
            C33796a c33796a = this.kpo;
            if (c33796a == null) {
                C25052j.dWJ();
            }
            C23419ns c23419ns = c33796a.koU;
            if (z) {
                if (C5046bo.isNullOrNil(c23419ns != null ? c23419ns.vTb : null)) {
                    m31216tk(i);
                    AppMethodBeat.m2505o(89209);
                    return;
                }
                m31214ti(i);
                AppMethodBeat.m2505o(89209);
                return;
            }
            m31215tj(i);
            AppMethodBeat.m2505o(89209);
        }

        /* renamed from: b */
        public static final /* synthetic */ void m31210b(C20179e c20179e, int i) {
            AppMethodBeat.m2504i(89212);
            C33796a c33796a = c20179e.kpo;
            if (c33796a == null) {
                C25052j.dWJ();
            }
            C23419ns c23419ns = c33796a.koU;
            LinearLayout linearLayout = c20179e.kpf;
            if (linearLayout == null) {
                C25052j.avw("chpiCouponLayout");
            }
            int childCount = linearLayout.getChildCount();
            if (c23419ns == null) {
                C25052j.dWJ();
            }
            if (childCount > c23419ns.vTh) {
                String str = "MicroMsg.CardHomePageNewUI";
                String str2 = "collapse count: %s, limit: %s";
                Object[] objArr = new Object[2];
                LinearLayout linearLayout2 = c20179e.kpf;
                if (linearLayout2 == null) {
                    C25052j.avw("chpiCouponLayout");
                }
                objArr[0] = Integer.valueOf(linearLayout2.getChildCount());
                objArr[1] = Integer.valueOf(c23419ns.vTh);
                C4990ab.m7411d(str, str2, objArr);
                linearLayout = c20179e.kpf;
                if (linearLayout == null) {
                    C25052j.avw("chpiCouponLayout");
                }
                childCount = linearLayout.getChildCount() - 1;
                int i2 = c23419ns.vTh;
                if (childCount >= i2) {
                    while (true) {
                        LinearLayout linearLayout3 = c20179e.kpf;
                        if (linearLayout3 == null) {
                            C25052j.avw("chpiCouponLayout");
                        }
                        linearLayout3.removeViewAt(childCount);
                        if (childCount == i2) {
                            break;
                        }
                        childCount--;
                    }
                }
            }
            c20179e.m31213o(false, i);
            AppMethodBeat.m2505o(89212);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageResponse;", "call"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$h */
    static final class C27622h<_Ret, _Var> implements C5681a<_Ret, _Var> {
        final /* synthetic */ CardHomePageNewUI koY;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$doGetCardHomePage$2$1$1$1", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$doGetCardHomePage$2$$special$$inlined$apply$lambda$1"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$h$a */
        static final class C20185a implements View.OnClickListener {
            final /* synthetic */ C27622h kpA;
            final /* synthetic */ C46571nt kpz;

            C20185a(C46571nt c46571nt, C27622h c27622h) {
                this.kpz = c46571nt;
                this.kpA = c27622h;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(89215);
                switch (this.kpz.vTk) {
                    case 1:
                        C45774b.m84625a((MMActivity) this.kpA.koY, this.kpz.vTl);
                        AppMethodBeat.m2505o(89215);
                        return;
                    case 2:
                        C30208ny c30208ny = this.kpz.vTm;
                        C45774b.m84635t(c30208ny.tzW, c30208ny.ttg, c30208ny.tIE);
                        break;
                }
                AppMethodBeat.m2505o(89215);
            }
        }

        C27622h(CardHomePageNewUI cardHomePageNewUI) {
            this.koY = cardHomePageNewUI;
        }

        public final /* synthetic */ Object call(Object obj) {
            int i = 2;
            int i2 = 1;
            AppMethodBeat.m2504i(89216);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.CardHomePageNewUI", "errtype: %s, errcode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
            if (this.koY.gnn != null) {
                Dialog r = this.koY.gnn;
                if (r == null) {
                    C25052j.dWJ();
                }
                r.dismiss();
            }
            this.koY.koQ = null;
            CardHomePageNewUI.m55267t(this.koY).setVisibility(8);
            this.koY.isLoading = false;
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                btd btd = c37441a.fsy;
                aks aks = (aks) btd;
                C4990ab.m7417i("MicroMsg.CardHomePageNewUI", "retCode: %s", Integer.valueOf(aks.kdT));
                if (aks.kdT == 0) {
                    boolean z;
                    this.koY.offset = aks.kKI;
                    CardHomePageNewUI cardHomePageNewUI = this.koY;
                    if (aks.wqk == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    cardHomePageNewUI.koC = z;
                    if (!C5046bo.isNullOrNil(aks.wqp)) {
                        this.koY.koD = aks.wqp;
                    }
                    if (this.koY.koC) {
                        CardHomePageNewUI.m55255h(this.koY).mo22757fh(false);
                        C46571nt c46571nt = aks.wqn;
                        if (!(c46571nt == null || C5046bo.isNullOrNil(c46571nt.vTj))) {
                            C11356a c11356a;
                            TextView textView = (TextView) CardHomePageNewUI.m55269v(this.koY).findViewById(2131822165);
                            C25052j.m39375o(textView, "faqTv");
                            textView.setText(c46571nt.vTj);
                            textView.setOnClickListener(new C20185a(c46571nt, this));
                            CardHomePageNewUI.m55255h(this.koY).mo22757fh(false);
                            CardHomePageNewUI.m55269v(this.koY).setVisibility(0);
                            CardHomePageNewUI.m55255h(this.koY).getAdapter().notifyDataSetChanged();
                            LoadMoreRecyclerView h = CardHomePageNewUI.m55255h(this.koY);
                            C31214a w = this.koY.koP;
                            if (w != null) {
                                c11356a = new C11356a(w);
                            } else {
                                Object c11356a2 = w;
                            }
                            h.post(c11356a2);
                        }
                    } else {
                        CardHomePageNewUI.m55255h(this.koY).mo22757fh(true);
                    }
                    if (this.koY.exX || this.koY.koO) {
                        this.koY.koE.clear();
                        this.koY.koF.clear();
                        this.koY.koG = null;
                        if (this.koY.exX) {
                            this.koY.exX = false;
                        }
                        this.koY.koO = false;
                    }
                    this.koY.mo54347b(aks.wql, aks.wqm);
                    CardHomePageNewUI.m55255h(this.koY).getAdapter().notifyDataSetChanged();
                } else {
                    if (this.koY.exX) {
                        this.koY.exX = false;
                    }
                    C38736l.m65716ai(this.koY, aks.kdU);
                }
                if (aks.wqq == 1) {
                    this.koY.koO = true;
                    this.koY.offset = 0;
                    CardHomePageNewUI cardHomePageNewUI2 = this.koY;
                    if (this.koY.kfk == 1) {
                        i2 = 2;
                    }
                    cardHomePageNewUI2.kfk = i2;
                    CardHomePageNewUI.m55263p(this.koY);
                }
                AppMethodBeat.m2505o(89216);
                return btd;
            }
            CardHomePageNewUI cardHomePageNewUI3 = this.koY;
            C37440a c37440a = c37441a.fsz;
            if (c37440a == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.card.model.v2.CgiGetMktCardHomePage");
                AppMethodBeat.m2505o(89216);
                throw c44941v;
            }
            if (((C45782h) c37440a).kfk != 1) {
                i = 1;
            }
            cardHomePageNewUI3.kfk = i;
            if (this.koY.exX) {
                this.koY.exX = false;
            }
            C38736l.m65717aj(this.koY, "");
            Object obj2 = C37091y.AUy;
            AppMethodBeat.m2505o(89216);
            return obj2;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$o */
    static final class C27624o implements OnMenuItemClickListener {
        final /* synthetic */ CardHomePageNewUI koY;

        C27624o(CardHomePageNewUI cardHomePageNewUI) {
            this.koY = cardHomePageNewUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(89228);
            C4990ab.m7416i("MicroMsg.CardHomePageNewUI", "click sort menu");
            CardHomePageNewUI.m55261n(this.koY);
            AppMethodBeat.m2505o(89228);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$f */
    static final class C33792f extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ CardHomePageNewUI koY;

        C33792f(CardHomePageNewUI cardHomePageNewUI) {
            this.koY = cardHomePageNewUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(89213);
            ViewGroup viewGroup = (ViewGroup) this.koY.findViewById(2131820884);
            TextView textView = (TextView) CardHomePageNewUI.m55269v(this.koY).findViewById(2131822165);
            if (viewGroup != null) {
                int height = viewGroup.getHeight();
                int computeVerticalScrollRange = CardHomePageNewUI.m55255h(this.koY).computeVerticalScrollRange();
                int computeVerticalScrollExtent = CardHomePageNewUI.m55255h(this.koY).computeVerticalScrollExtent();
                C4990ab.m7411d("MicroMsg.CardHomePageNewUI", "range: %s, extent: %s, contentHeight", Integer.valueOf(computeVerticalScrollRange), Integer.valueOf(computeVerticalScrollExtent), Integer.valueOf(height));
                if (height > computeVerticalScrollRange) {
                    height -= computeVerticalScrollRange;
                    if (height >= 0) {
                        CardHomePageNewUI.m55269v(this.koY).setPadding(0, height + CardHomePageNewUI.m55269v(this.koY).getPaddingTop(), 0, CardHomePageNewUI.m55269v(this.koY).getPaddingBottom());
                    }
                }
            }
            C25052j.m39375o(textView, "faqTv");
            textView.setVisibility(0);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(89213);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "kotlin.jvm.PlatformType", "call"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$i */
    static final class C33793i<_Ret, _Var> implements C5681a<_Ret, _Var> {
        final /* synthetic */ CardHomePageNewUI koY;
        final /* synthetic */ String kpy;

        C33793i(CardHomePageNewUI cardHomePageNewUI, String str) {
            this.koY = cardHomePageNewUI;
            this.kpy = str;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(89217);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.CardHomePageNewUI", "errtype: %s, errcode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                agq agq = (agq) c37441a.fsy;
                C4990ab.m7417i("MicroMsg.CardHomePageNewUI", "retCode: %s, refresh: %s", Integer.valueOf(agq.kdT), Integer.valueOf(agq.wnl));
                C33799d o;
                String str;
                C23419ns c23419ns;
                if (agq.kdT != 0) {
                    C38736l.m65716ai(this.koY, agq.kdU);
                } else if (agq.wnl == 1) {
                    this.koY.koO = true;
                    this.koY.offset = 0;
                    CardHomePageNewUI.m55263p(this.koY);
                } else if (this.koY.koK != 0) {
                    o = CardHomePageNewUI.m55262o(this.koY);
                    str = this.kpy;
                    c23419ns = agq.wnk;
                    C25052j.m39375o(c23419ns, "card_pkg_mch_info");
                    o.mo54351a(str, c23419ns);
                } else if (agq.wnk.vTa.size() == 0) {
                    CardHomePageNewUI.m55262o(this.koY).mo54350GW(this.kpy);
                } else {
                    o = CardHomePageNewUI.m55262o(this.koY);
                    str = this.kpy;
                    c23419ns = agq.wnk;
                    C25052j.m39375o(c23419ns, "card_pkg_mch_info");
                    o.mo54351a(str, c23419ns);
                }
            } else {
                C38736l.m65717aj(this.koY, "");
            }
            this.koY.koK = -1;
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(89217);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0013"}, dWq = {"com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "plugin-card_release"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$j */
    public static final class C33794j extends C25373h {
        private final Paint aFY = new Paint();
        final /* synthetic */ CardHomePageNewUI koY;

        C33794j(CardHomePageNewUI cardHomePageNewUI) {
            this.koY = cardHomePageNewUI;
            AppMethodBeat.m2504i(89220);
            this.aFY.setColor(Color.parseColor("#19000000"));
            this.aFY.setStyle(Style.FILL);
            this.aFY.setFlags(1);
            AppMethodBeat.m2505o(89220);
        }

        /* renamed from: a */
        public final void mo18495a(Rect rect, View view, RecyclerView recyclerView, C31880s c31880s) {
            AppMethodBeat.m2504i(89218);
            super.mo18495a(rect, view, recyclerView, c31880s);
            Integer valueOf = recyclerView != null ? Integer.valueOf(RecyclerView.m72547bo(view)) : null;
            int itemCount = CardHomePageNewUI.m55262o(this.koY).getItemCount() - 1;
            if (valueOf != null && valueOf.intValue() == itemCount) {
                C4990ab.m7410d("MicroMsg.CardHomePageNewUI", "is last");
                if (rect != null) {
                    C33798c c33798c = CardHomePageNewUI.koT;
                    rect.bottom = CardHomePageNewUI.cjn;
                    AppMethodBeat.m2505o(89218);
                    return;
                }
                AppMethodBeat.m2505o(89218);
            } else if (rect != null) {
                rect.bottom = 1;
                AppMethodBeat.m2505o(89218);
            } else {
                AppMethodBeat.m2505o(89218);
            }
        }

        /* renamed from: a */
        public final void mo6920a(Canvas canvas, RecyclerView recyclerView, C31880s c31880s) {
            AppMethodBeat.m2504i(89219);
            super.mo6920a(canvas, recyclerView, c31880s);
            LoadMoreRecyclerView h = CardHomePageNewUI.m55255h(this.koY);
            if (h != null) {
                int paddingLeft = h.getPaddingLeft();
                C33798c c33798c = CardHomePageNewUI.koT;
                int bej = paddingLeft + CardHomePageNewUI.koS;
                int width = h.getWidth() - h.getPaddingRight();
                int childCount = h.getChildCount();
                paddingLeft = 0;
                while (true) {
                    int i = paddingLeft;
                    if (i < childCount - 1) {
                        View childAt = h.getChildAt(i);
                        C25052j.m39375o(childAt, "child");
                        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                        if (layoutParams == null) {
                            C44941v c44941v = new C44941v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
                            AppMethodBeat.m2505o(89219);
                            throw c44941v;
                        }
                        int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) layoutParams).bottomMargin;
                        if (i == childCount - 1) {
                            C33798c c33798c2 = CardHomePageNewUI.koT;
                            paddingLeft = CardHomePageNewUI.cjn;
                        } else {
                            paddingLeft = 1;
                        }
                        paddingLeft += bottom;
                        if (canvas != null) {
                            canvas.drawRect((float) bej, (float) bottom, (float) width, (float) paddingLeft, this.aFY);
                        }
                        paddingLeft = i + 1;
                    } else {
                        AppMethodBeat.m2505o(89219);
                        return;
                    }
                }
            }
            AppMethodBeat.m2505o(89219);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$l */
    static final class C33795l implements C2594a {
        final /* synthetic */ CardHomePageNewUI koY;

        C33795l(CardHomePageNewUI cardHomePageNewUI) {
            this.koY = cardHomePageNewUI;
        }

        /* renamed from: I */
        public final void mo6645I(View view, int i) {
            AppMethodBeat.m2504i(89222);
            C33796a th = CardHomePageNewUI.m55262o(this.koY).mo54352th(i);
            if (th != null) {
                C4990ab.m7417i("MicroMsg.CardHomePageNewUI", "click type: %s", Integer.valueOf(th.type));
                switch (th.type) {
                    case 2:
                        this.koY.koJ = true;
                        this.koY.koK = 1;
                        this.koY.koN = th.koU;
                        C23419ns c23419ns = th.koU;
                        if (c23419ns == null) {
                            C25052j.dWJ();
                        }
                        switch (c23419ns.vSW) {
                            case 1:
                                MMActivity mMActivity = this.koY;
                                C23419ns c23419ns2 = th.koU;
                                if (c23419ns2 == null) {
                                    C25052j.dWJ();
                                }
                                C45774b.m84625a(mMActivity, c23419ns2.vSX);
                                break;
                            case 2:
                                c23419ns = th.koU;
                                if (c23419ns == null) {
                                    C25052j.dWJ();
                                }
                                C30208ny c30208ny = c23419ns.vSY;
                                C45774b.m84635t(c30208ny.tzW, c30208ny.ttg, c30208ny.tIE);
                                break;
                        }
                        C7060h c7060h = C7060h.pYm;
                        Object[] objArr = new Object[7];
                        objArr[0] = Integer.valueOf(2);
                        C23419ns c23419ns3 = th.koU;
                        if (c23419ns3 == null) {
                            C25052j.dWJ();
                        }
                        objArr[1] = c23419ns3.vSR;
                        objArr[2] = Integer.valueOf(0);
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = Integer.valueOf(1);
                        objArr[5] = Integer.valueOf(i);
                        objArr[6] = Integer.valueOf(this.koY.kfk);
                        c7060h.mo8381e(16324, objArr);
                        AppMethodBeat.m2505o(89222);
                        return;
                    case 4:
                        C4990ab.m7416i("MicroMsg.CardHomePageNewUI", "click ticket item");
                        this.koY.startActivity(new Intent(this.koY, CardTicketListUI.class));
                        C7060h.pYm.mo8381e(16322, Integer.valueOf(5));
                        AppMethodBeat.m2505o(89222);
                        return;
                    case 5:
                        C7060h.pYm.mo8381e(16322, Integer.valueOf(13));
                        AppMethodBeat.m2505o(89222);
                        return;
                    default:
                        AppMethodBeat.m2505o(89222);
                        return;
                }
            }
            AppMethodBeat.m2505o(89222);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;)V", "element", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "getElement", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "setElement", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;)V", "expandState", "", "getExpandState", "()Z", "setExpandState", "(Z)V", "hasRender", "getHasRender", "setHasRender", "sectionTitle", "", "getSectionTitle", "()Ljava/lang/String;", "setSectionTitle", "(Ljava/lang/String;)V", "type", "", "getType", "()I", "setType", "(I)V", "plugin-card_release"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$a */
    public final class C33796a {
        C23419ns koU;
        public String koV;
        boolean koW;
        boolean koX;
        int type;

        /* renamed from: GV */
        public final void mo54348GV(String str) {
            AppMethodBeat.m2504i(89179);
            C25052j.m39376p(str, "<set-?>");
            this.koV = str;
            AppMethodBeat.m2505o(89179);
        }

        public final String bek() {
            AppMethodBeat.m2504i(89178);
            String str = this.koV;
            if (str == null) {
                C25052j.avw("sectionTitle");
            }
            AppMethodBeat.m2505o(89178);
            return str;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardSpan;", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "linkColor", "", "bgColor", "listener", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;IILcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;)V", "onClick", "", "widget", "Landroid/view/View;", "plugin-card_release"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$b */
    public final class C33797b extends C23322n {
        final /* synthetic */ CardHomePageNewUI koY;

        public C33797b(CardHomePageNewUI cardHomePageNewUI, int i, C44087h c44087h) {
            C25052j.m39376p(c44087h, CastExtraArgs.LISTENER);
            this.koY = cardHomePageNewUI;
            super((int) WebView.NIGHT_MODE_COLOR, i);
            AppMethodBeat.m2504i(89181);
            this.vsv = c44087h;
            AppMethodBeat.m2505o(89181);
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(89180);
            C25052j.m39376p(view, "widget");
            if (this.vsv != null) {
                this.vsv.mo23045a(view, null);
            }
            AppMethodBeat.m2505o(89180);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$Companion;", "", "()V", "DP_1", "", "getDP_1", "()I", "DP_16", "getDP_16", "FOOTER_HEIGHT", "getFOOTER_HEIGHT", "LIST_ITEM_TYPE_CARD_TITLE", "LIST_ITEM_TYPE_FIRST", "LIST_ITEM_TYPE_STORE", "LIST_ITEM_TYPE_TICKET", "LIST_ITEM_TYPE_TITLE", "LIST_ITEM_TYPE_UNDER", "SORT_TYPE_DISTANCE", "SORT_TYPE_TIME", "TAG", "", "plugin-card_release"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$c */
    public static final class C33798c {
        private C33798c() {
        }

        public /* synthetic */ C33798c(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\bR\u00020\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0014\u0010\r\u001a\b\u0018\u00010\bR\u00020\u00032\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\u001c\u0010\u0015\u001a\u00020\u00062\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\u0015\u001a\u00020\u00062\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\f\u001a\u00020\n2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u001c\u0010\u001a\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u001f\u001a\u00020\u0006J\u0016\u0010 \u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0014¨\u0006\""}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;)V", "appendUnderList", "", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "getItemCount", "", "getItemViewType", "position", "getModelByPos", "getPosByMerchantId", "merchantId", "", "moveStoreToUnderList", "", "element", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "onBindViewHolder", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeModelByMId", "removeTitleSection", "replaceModelByMId", "mchInfo", "plugin-card_release"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$d */
    public final class C33799d extends C41523a<C20179e> {
        /* renamed from: a */
        public final /* synthetic */ void mo27742a(C41531v c41531v, int i, List list) {
            int i2;
            AppMethodBeat.m2504i(89186);
            C20179e c20179e = (C20179e) c41531v;
            C25052j.m39376p(c20179e, "holder");
            C25052j.m39376p(list, "payloads");
            if (list.isEmpty()) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (i2 == 0 || !C25052j.m39373j(list.get(0), Boolean.TRUE)) {
                super.mo27742a(c20179e, i, list);
                AppMethodBeat.m2505o(89186);
                return;
            }
            C33796a th = mo54352th(i);
            if (th != null) {
                c20179e.mo35430a(th, i);
                AppMethodBeat.m2505o(89186);
                return;
            }
            AppMethodBeat.m2505o(89186);
        }

        public final int getItemCount() {
            int size;
            int size2;
            int i;
            int i2;
            int i3 = 1;
            AppMethodBeat.m2504i(89183);
            ArrayList a = CardHomePageNewUI.this.koE;
            if (a != null) {
                size = a.size();
            } else {
                size = 0;
            }
            ArrayList b = CardHomePageNewUI.this.koF;
            if (b != null) {
                size2 = b.size();
            } else {
                size2 = 0;
            }
            if (CardHomePageNewUI.this.koG != null) {
                i = 1;
            } else {
                i = 0;
            }
            if (CardHomePageNewUI.this.koH != null) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (CardHomePageNewUI.this.koI == null) {
                i3 = 0;
            }
            size = (((size + size2) + i) + i2) + i3;
            AppMethodBeat.m2505o(89183);
            return size;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(89184);
            C33796a th = mo54352th(i);
            if (th != null) {
                int i2 = th.type;
                AppMethodBeat.m2505o(89184);
                return i2;
            }
            AppMethodBeat.m2505o(89184);
            return 3;
        }

        /* renamed from: th */
        public final C33796a mo54352th(int i) {
            int i2 = 1;
            AppMethodBeat.m2504i(89187);
            String str = "MicroMsg.CardHomePageNewUI";
            String str2 = "pos: %s, sSize: %s, uSize: %s, title: %s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(i);
            ArrayList a = CardHomePageNewUI.this.koE;
            objArr[1] = a != null ? Integer.valueOf(a.size()) : null;
            a = CardHomePageNewUI.this.koE;
            objArr[2] = a != null ? Integer.valueOf(a.size()) : null;
            objArr[3] = Boolean.valueOf(CardHomePageNewUI.this.koG != null);
            C4990ab.m7411d(str, str2, objArr);
            C33796a e = CardHomePageNewUI.this.koH;
            if (e == null) {
                i2 = 0;
            } else if (i == 0) {
                AppMethodBeat.m2505o(89187);
                return e;
            }
            e = CardHomePageNewUI.this.koI;
            if (e != null) {
                if (i == i2) {
                    AppMethodBeat.m2505o(89187);
                    return e;
                }
                i2++;
            }
            a = CardHomePageNewUI.this.koE;
            if (a != null) {
                if (i - i2 < a.size()) {
                    e = (C33796a) a.get(i - i2);
                    AppMethodBeat.m2505o(89187);
                    return e;
                }
                i2 = a.size() - 1;
            }
            if (CardHomePageNewUI.this.koG != null) {
                i2++;
                if (i == i2) {
                    e = CardHomePageNewUI.this.koG;
                    AppMethodBeat.m2505o(89187);
                    return e;
                }
            }
            a = CardHomePageNewUI.this.koF;
            if (a == null || i <= i2 || i > a.size() + i2) {
                AppMethodBeat.m2505o(89187);
                return null;
            }
            e = (C33796a) a.get((i - i2) - 1);
            AppMethodBeat.m2505o(89187);
            return e;
        }

        /* renamed from: GW */
        public final void mo54350GW(String str) {
            C33796a c33796a;
            C23419ns c23419ns;
            AppMethodBeat.m2504i(89188);
            C25052j.m39376p(str, "merchantId");
            Iterator it = CardHomePageNewUI.this.koE.iterator();
            while (it.hasNext()) {
                c33796a = (C33796a) it.next();
                c23419ns = c33796a.koU;
                if (C25052j.m39373j(c23419ns != null ? c23419ns.vSR : null, str)) {
                    CardHomePageNewUI.this.koE.remove(c33796a);
                    CardHomePageNewUI.m55255h(CardHomePageNewUI.this).getAdapter().notifyDataSetChanged();
                    AppMethodBeat.m2505o(89188);
                    return;
                }
            }
            it = CardHomePageNewUI.this.koF.iterator();
            while (it.hasNext()) {
                c33796a = (C33796a) it.next();
                c23419ns = c33796a.koU;
                if (C25052j.m39373j(c23419ns != null ? c23419ns.vSR : null, str)) {
                    CardHomePageNewUI.this.koF.remove(c33796a);
                    if (CardHomePageNewUI.this.koF.size() == 0) {
                        CardHomePageNewUI.this.koG = null;
                        CardHomePageNewUI.m55255h(CardHomePageNewUI.this).getAdapter().notifyDataSetChanged();
                    }
                    AppMethodBeat.m2505o(89188);
                    return;
                }
            }
            AppMethodBeat.m2505o(89188);
        }

        /* renamed from: GX */
        private int m55279GX(String str) {
            int i;
            int i2;
            C23419ns c23419ns;
            int i3 = 0;
            AppMethodBeat.m2504i(89189);
            C25052j.m39376p(str, "merchantId");
            if (CardHomePageNewUI.this.koH != null) {
                i = 1;
            } else {
                i = 0;
            }
            if (CardHomePageNewUI.this.koI != null) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            int i4 = 0;
            for (C33796a c33796a : CardHomePageNewUI.this.koE) {
                c23419ns = c33796a.koU;
                if (C25052j.m39373j(c23419ns != null ? c23419ns.vSR : null, str)) {
                    i = i2 + i4;
                    AppMethodBeat.m2505o(89189);
                    return i;
                }
                i4++;
            }
            i = (CardHomePageNewUI.this.koE.size() + i2) - 1;
            if (CardHomePageNewUI.this.koG != null) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            for (C33796a c33796a2 : CardHomePageNewUI.this.koF) {
                Object obj;
                c23419ns = c33796a2.koU;
                if (c23419ns != null) {
                    obj = c23419ns.vSR;
                } else {
                    obj = null;
                }
                if (C25052j.m39373j(obj, str)) {
                    i = (i2 + i3) + 1;
                    AppMethodBeat.m2505o(89189);
                    return i;
                }
                i3++;
            }
            AppMethodBeat.m2505o(89189);
            return -1;
        }

        /* renamed from: a */
        public final void mo54351a(String str, C23419ns c23419ns) {
            C33796a c33796a;
            C23419ns c23419ns2;
            Object obj;
            int GX;
            AppMethodBeat.m2504i(89190);
            C25052j.m39376p(str, "merchantId");
            C25052j.m39376p(c23419ns, "mchInfo");
            Iterator it = CardHomePageNewUI.this.koE.iterator();
            while (it.hasNext()) {
                c33796a = (C33796a) it.next();
                c23419ns2 = c33796a.koU;
                if (c23419ns2 != null) {
                    obj = c23419ns2.vSR;
                } else {
                    obj = null;
                }
                if (C25052j.m39373j(obj, str)) {
                    c33796a.koU = c23419ns;
                    GX = m55279GX(str);
                    if (GX >= 0) {
                        CardHomePageNewUI.m55255h(CardHomePageNewUI.this).getAdapter().mo66312b(GX, Boolean.TRUE);
                    }
                    AppMethodBeat.m2505o(89190);
                    return;
                }
            }
            it = CardHomePageNewUI.this.koF.iterator();
            while (it.hasNext()) {
                c33796a = (C33796a) it.next();
                c23419ns2 = c33796a.koU;
                if (c23419ns2 != null) {
                    obj = c23419ns2.vSR;
                } else {
                    obj = null;
                }
                if (C25052j.m39373j(obj, str)) {
                    c33796a.koU = c23419ns;
                    GX = m55279GX(str);
                    if (GX >= 0) {
                        CardHomePageNewUI.m55255h(CardHomePageNewUI.this).getAdapter().mo66312b(GX, Boolean.TRUE);
                    }
                    AppMethodBeat.m2505o(89190);
                    return;
                }
            }
            AppMethodBeat.m2505o(89190);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032&\u0010\u0005\u001a\"\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0006¨\u0006\u00010\u0006¨\u0006\u0001H\n¢\u0006\u0002\b\b"}, dWq = {"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$k */
    static final class C33800k implements C11052a {
        final /* synthetic */ CardHomePageNewUI koY;

        C33800k(CardHomePageNewUI cardHomePageNewUI) {
            this.koY = cardHomePageNewUI;
        }

        public final void aMC() {
            AppMethodBeat.m2504i(89221);
            CardHomePageNewUI.m55263p(this.koY);
            AppMethodBeat.m2505o(89221);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
    /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$m */
    static final class C33801m implements C11053b {
        final /* synthetic */ CardHomePageNewUI koY;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$4$1$1"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$m$a */
        static final class C27623a implements C36073c {
            final /* synthetic */ int iPU;
            final /* synthetic */ C33801m kpB;

            C27623a(C33801m c33801m, int i) {
                this.kpB = c33801m;
                this.iPU = i;
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(89223);
                c44273l.mo70068e(1, this.kpB.koY.getString(C25738R.string.f9088p4));
                AppMethodBeat.m2505o(89223);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$4$1$2"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$m$b */
        static final class C33802b implements C5279d {
            final /* synthetic */ int iPU;
            final /* synthetic */ C33801m kpB;
            final /* synthetic */ C33796a kpC;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$4$1$2$1"})
            /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$m$b$1 */
            static final class C338031 implements OnClickListener {
                final /* synthetic */ C33802b kpD;

                C338031(C33802b c33802b) {
                    this.kpD = c33802b;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(89224);
                    CardHomePageNewUI cardHomePageNewUI = this.kpD.kpB.koY;
                    C23419ns c23419ns = this.kpD.kpC.koU;
                    if (c23419ns == null) {
                        C25052j.dWJ();
                    }
                    String str = c23419ns.vSR;
                    C25052j.m39375o(str, "element!!.card_pack_merchant_id");
                    C25052j.m39376p(str, "merchantId");
                    C4990ab.m7417i("MicroMsg.CardHomePageNewUI", "do delete merchant: %s", str);
                    new C16723e(str).acy().mo60487b((C5681a) new C11340g(cardHomePageNewUI, str));
                    dialogInterface.dismiss();
                    C7060h c7060h = C7060h.pYm;
                    Object[] objArr = new Object[7];
                    objArr[0] = Integer.valueOf(2);
                    C23419ns c23419ns2 = this.kpD.kpC.koU;
                    if (c23419ns2 == null) {
                        C25052j.dWJ();
                    }
                    objArr[1] = c23419ns2.vSR;
                    objArr[2] = Integer.valueOf(0);
                    objArr[3] = Integer.valueOf(0);
                    objArr[4] = Integer.valueOf(9);
                    objArr[5] = Integer.valueOf(this.kpD.iPU);
                    objArr[6] = Integer.valueOf(this.kpD.kpB.koY.kfk);
                    c7060h.mo8381e(16324, objArr);
                    AppMethodBeat.m2505o(89224);
                }
            }

            C33802b(C33796a c33796a, C33801m c33801m, int i) {
                this.kpC = c33796a;
                this.kpB = c33801m;
                this.iPU = i;
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(89225);
                C25052j.m39375o(menuItem, "menuItem");
                switch (menuItem.getItemId()) {
                    case 1:
                        C30379h.m48448a((Context) this.kpB.koY.dxU(), this.kpB.koY.getString(C25738R.string.af0), "", false, (OnClickListener) new C338031(this));
                        C7060h c7060h = C7060h.pYm;
                        Object[] objArr = new Object[7];
                        objArr[0] = Integer.valueOf(2);
                        C23419ns c23419ns = this.kpC.koU;
                        if (c23419ns == null) {
                            C25052j.dWJ();
                        }
                        objArr[1] = c23419ns.vSR;
                        objArr[2] = Integer.valueOf(0);
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = Integer.valueOf(8);
                        objArr[5] = Integer.valueOf(this.iPU);
                        objArr[6] = Integer.valueOf(this.kpB.koY.kfk);
                        c7060h.mo8381e(16324, objArr);
                        break;
                }
                AppMethodBeat.m2505o(89225);
            }
        }

        C33801m(CardHomePageNewUI cardHomePageNewUI) {
            this.koY = cardHomePageNewUI;
        }

        /* renamed from: L */
        public final boolean mo7100L(View view, int i) {
            AppMethodBeat.m2504i(89226);
            C33796a th = CardHomePageNewUI.m55262o(this.koY).mo54352th(i);
            if (th != null) {
                C4990ab.m7417i("MicroMsg.CardHomePageNewUI", "long click type: %s", Integer.valueOf(th.type));
                switch (th.type) {
                    case 2:
                        C46696j c46696j = new C46696j(this.koY.dxU());
                        c46696j.mo75007a((C36073c) new C27623a(this, i));
                        c46696j.mo75008a((C5279d) new C33802b(th, this, i));
                        c46696j.cuu();
                        C7060h c7060h = C7060h.pYm;
                        Object[] objArr = new Object[7];
                        objArr[0] = Integer.valueOf(2);
                        C23419ns c23419ns = th.koU;
                        if (c23419ns == null) {
                            C25052j.dWJ();
                        }
                        objArr[1] = c23419ns.vSR;
                        objArr[2] = Integer.valueOf(0);
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = Integer.valueOf(7);
                        objArr[5] = Integer.valueOf(i);
                        objArr[6] = Integer.valueOf(this.koY.kfk);
                        c7060h.mo8381e(16324, objArr);
                        break;
                }
            }
            AppMethodBeat.m2505o(89226);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public CardHomePageNewUI() {
        AppMethodBeat.m2504i(89243);
        AppMethodBeat.m2505o(89243);
    }

    /* renamed from: h */
    public static final /* synthetic */ LoadMoreRecyclerView m55255h(CardHomePageNewUI cardHomePageNewUI) {
        AppMethodBeat.m2504i(89245);
        LoadMoreRecyclerView loadMoreRecyclerView = cardHomePageNewUI.kou;
        if (loadMoreRecyclerView == null) {
            C25052j.avw("mRecyclerView");
        }
        AppMethodBeat.m2505o(89245);
        return loadMoreRecyclerView;
    }

    /* renamed from: o */
    public static final /* synthetic */ C33799d m55262o(CardHomePageNewUI cardHomePageNewUI) {
        AppMethodBeat.m2504i(89247);
        C33799d c33799d = cardHomePageNewUI.kov;
        if (c33799d == null) {
            C25052j.avw("mHomePageAdapter");
        }
        AppMethodBeat.m2505o(89247);
        return c33799d;
    }

    /* renamed from: p */
    public static final /* synthetic */ void m55263p(CardHomePageNewUI cardHomePageNewUI) {
        AppMethodBeat.m2504i(89248);
        cardHomePageNewUI.beh();
        AppMethodBeat.m2505o(89248);
    }

    /* renamed from: t */
    public static final /* synthetic */ ViewGroup m55267t(CardHomePageNewUI cardHomePageNewUI) {
        AppMethodBeat.m2504i(89249);
        ViewGroup viewGroup = cardHomePageNewUI.koA;
        if (viewGroup == null) {
            C25052j.avw("mLoadingView2");
        }
        AppMethodBeat.m2505o(89249);
        return viewGroup;
    }

    /* renamed from: v */
    public static final /* synthetic */ ViewGroup m55269v(CardHomePageNewUI cardHomePageNewUI) {
        AppMethodBeat.m2504i(89250);
        ViewGroup viewGroup = cardHomePageNewUI.kox;
        if (viewGroup == null) {
            C25052j.avw("mFooterView");
        }
        AppMethodBeat.m2505o(89250);
        return viewGroup;
    }

    static {
        AppMethodBeat.m2504i(89244);
        AppMethodBeat.m2505o(89244);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(89234);
        dxR();
        super.onCreate(bundle);
        mo17446xE(Color.parseColor("#ededed"));
        dyb();
        setMMTitle((int) C25738R.string.aev);
        this.scene = getIntent().getIntExtra("key_home_page_from_scene", 0);
        initView();
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        this.koM = RP.mo5239Ry().getInt(C5127a.USERINFO_CARD_ENTRANCE_SHOW_SORT_INT_SYNC, 0);
        RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        this.kfk = RP.mo5239Ry().getInt(C5127a.USERINFO_CARD_ENTRANCE_SORT_TYPE_INT_SYNC, 0);
        if (this.koM == 1) {
            C7060h.pYm.mo8381e(16322, Integer.valueOf(14));
        }
        C4990ab.m7417i("MicroMsg.CardHomePageNewUI", "on create, scene: %s", Integer.valueOf(this.scene));
        setBackBtn(new C11341n(this));
        if (this.scene == 1 && this.koM == 1) {
            addTextOptionMenu(0, getString(C25738R.string.g69), new C27624o(this));
        }
        C7060h.pYm.mo8381e(16322, Integer.valueOf(4));
        ((C30158b) C1720g.m3528K(C30158b.class)).mo48437eA(8, 2);
        AppMethodBeat.m2505o(89234);
    }

    public final void onDestroy() {
        C45797b c45797b;
        C23419ns c23419ns;
        String bek;
        AppMethodBeat.m2504i(89235);
        super.onDestroy();
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        RP.mo5239Ry().set(C5127a.USERINFO_CARD_ENTRANCE_SORT_TYPE_INT_SYNC, Integer.valueOf(this.kfk));
        if (this.koQ != null) {
            C45782h c45782h = this.koQ;
            if (c45782h == null) {
                C25052j.dWJ();
            }
            c45782h.cancel();
            this.koQ = null;
        }
        LoadMoreRecyclerView loadMoreRecyclerView = this.kou;
        if (loadMoreRecyclerView == null) {
            C25052j.avw("mRecyclerView");
        }
        C31214a c31214a = this.koP;
        if (c31214a != null) {
            c45797b = new C45797b(c31214a);
        } else {
            Object c45797b2 = c31214a;
        }
        loadMoreRecyclerView.removeCallbacks(c45797b2);
        C2752k.baK();
        C4990ab.m7416i("MicroMsg.CardHomePageNewUI", "do save snap shot");
        C35939nv c35939nv = new C35939nv();
        c35939nv.vTp = new LinkedList();
        Iterator it = this.koE.iterator();
        while (it.hasNext()) {
            c23419ns = ((C33796a) it.next()).koU;
            if (c23419ns != null) {
                c35939nv.vTp.add(c23419ns);
            }
        }
        C35940nw c35940nw = new C35940nw();
        C33796a c33796a = this.koG;
        if (c33796a != null) {
            bek = c33796a.bek();
        } else {
            bek = null;
        }
        c35940nw.vTq = bek;
        c35940nw.vTp = new LinkedList();
        Iterator it2 = this.koF.iterator();
        while (it2.hasNext()) {
            c23419ns = ((C33796a) it2.next()).koU;
            if (c23419ns != null) {
                c35940nw.vTp.add(c23419ns);
            }
        }
        C27578a c27578a = C45781a.kfc;
        C25052j.m39376p(c35939nv, "storeList");
        C25052j.m39376p(c35940nw, "underList");
        C4990ab.m7416i(C45781a.TAG, "save home page snapshot");
        byte[] toByteArray = c35939nv.toByteArray();
        C25052j.m39375o(toByteArray, "storeList.toByteArray()");
        Object str = new String(toByteArray, C17355d.ISO_8859_1);
        RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        RP.mo5239Ry().set(C5127a.USERINFO_CARD_STORE_LIST_STRING_SYNC, str);
        toByteArray = c35940nw.toByteArray();
        C25052j.m39375o(toByteArray, "underList.toByteArray()");
        str = new String(toByteArray, C17355d.ISO_8859_1);
        RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        RP.mo5239Ry().set(C5127a.USERINFO_CARD_UNDER_LIST_STRING_SYNC, str);
        AppMethodBeat.m2505o(89235);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(89236);
        super.onResume();
        if (!(!this.koJ || this.koN == null || this.koK == -1)) {
            C23419ns c23419ns = this.koN;
            if (c23419ns == null) {
                C25052j.dWJ();
            }
            String str = c23419ns.vSR;
            C25052j.m39375o(str, "clickedCardHomePageElement!!.card_pack_merchant_id");
            c23419ns = this.koN;
            if (c23419ns == null) {
                C25052j.dWJ();
            }
            long j = c23419ns.vTi;
            C4990ab.m7417i("MicroMsg.CardHomePageNewUI", "do get mch infoset: %s", str);
            new C38739g(str, j, (double) this.cEB, (double) this.cGm, this.kfk).acy().mo60487b((C5681a) new C33793i(this, str));
            this.koJ = false;
            this.koN = null;
        }
        AppMethodBeat.m2505o(89236);
    }

    public final int getLayoutId() {
        return 2130968940;
    }

    public final void initView() {
        AppMethodBeat.m2504i(89237);
        View findViewById = findViewById(2131822174);
        C25052j.m39375o(findViewById, "findViewById(R.id.chpu_rv)");
        this.kou = (LoadMoreRecyclerView) findViewById;
        LoadMoreRecyclerView loadMoreRecyclerView = this.kou;
        if (loadMoreRecyclerView == null) {
            C25052j.avw("mRecyclerView");
        }
        loadMoreRecyclerView.setLayoutManager(new LinearLayoutManager());
        this.kov = new C33799d();
        loadMoreRecyclerView = this.kou;
        if (loadMoreRecyclerView == null) {
            C25052j.avw("mRecyclerView");
        }
        C33799d c33799d = this.kov;
        if (c33799d == null) {
            C25052j.avw("mHomePageAdapter");
        }
        loadMoreRecyclerView.setAdapter(c33799d);
        findViewById = findViewById(2131822163);
        C25052j.m39375o(findViewById, "findViewById(R.id.chpe_root_layout)");
        this.koy = (ViewGroup) findViewById;
        LayoutInflater from = LayoutInflater.from(this);
        LoadMoreRecyclerView loadMoreRecyclerView2 = this.kou;
        if (loadMoreRecyclerView2 == null) {
            C25052j.avw("mRecyclerView");
        }
        findViewById = from.inflate(2130968937, loadMoreRecyclerView2, false);
        C44941v c44941v;
        if (findViewById == null) {
            c44941v = new C44941v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.m2505o(89237);
            throw c44941v;
        }
        this.kow = (ViewGroup) findViewById;
        from = LayoutInflater.from(this);
        loadMoreRecyclerView2 = this.kou;
        if (loadMoreRecyclerView2 == null) {
            C25052j.avw("mRecyclerView");
        }
        findViewById = from.inflate(2130968935, loadMoreRecyclerView2, false);
        if (findViewById == null) {
            c44941v = new C44941v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.m2505o(89237);
            throw c44941v;
        }
        this.kox = (ViewGroup) findViewById;
        findViewById = findViewById(2131822175);
        C25052j.m39375o(findViewById, "findViewById(R.id.chpu_loading_layout)");
        this.koA = (ViewGroup) findViewById;
        loadMoreRecyclerView = this.kou;
        if (loadMoreRecyclerView == null) {
            C25052j.avw("mRecyclerView");
        }
        ViewGroup viewGroup = this.kow;
        if (viewGroup == null) {
            C25052j.avw("mLoadingView");
        }
        loadMoreRecyclerView.setLoadingView((View) viewGroup);
        loadMoreRecyclerView = this.kou;
        if (loadMoreRecyclerView == null) {
            C25052j.avw("mRecyclerView");
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
        this.koz = new C33794j(this);
        loadMoreRecyclerView2 = this.kou;
        if (loadMoreRecyclerView2 == null) {
            C25052j.avw("mRecyclerView");
        }
        C25373h c25373h = this.koz;
        if (c25373h == null) {
            C25052j.avw("mDivider");
        }
        loadMoreRecyclerView2.mo66346b(c25373h);
        loadMoreRecyclerView = this.kou;
        if (loadMoreRecyclerView == null) {
            C25052j.avw("mRecyclerView");
        }
        loadMoreRecyclerView.setOnLoadingStateChangedListener(new C33800k(this));
        loadMoreRecyclerView = this.kou;
        if (loadMoreRecyclerView == null) {
            C25052j.avw("mRecyclerView");
        }
        loadMoreRecyclerView.setOnItemClickListener(new C33795l(this));
        loadMoreRecyclerView = this.kou;
        if (loadMoreRecyclerView == null) {
            C25052j.avw("mRecyclerView");
        }
        loadMoreRecyclerView.setOnItemLongClickListener(new C33801m(this));
        bef();
        AppMethodBeat.m2505o(89237);
    }

    /* renamed from: P */
    public final void mo23051P(int i, boolean z) {
        AppMethodBeat.m2504i(89238);
        C4990ab.m7417i("MicroMsg.CardHomePageNewUI", "location finish: [%s, %s], ret: %s, isOk: %s", Float.valueOf(this.cEB), Float.valueOf(this.cGm), Integer.valueOf(i), Boolean.valueOf(z));
        if (this.exX) {
            if (i == -2) {
                this.kfk = 2;
            }
            beh();
            AppMethodBeat.m2505o(89238);
            return;
        }
        if (!z) {
            bep();
        }
        AppMethodBeat.m2505o(89238);
    }

    private final void bef() {
        AppMethodBeat.m2504i(89239);
        if (!beg() && this.koE.isEmpty() && this.koF.isEmpty()) {
            C4990ab.m7416i("MicroMsg.CardHomePageNewUI", "show init view");
            C33796a c33796a = new C33796a();
            c33796a.type = 3;
            C33796a c33796a2 = new C33796a();
            c33796a2.type = 3;
            this.koE.add(c33796a);
            this.koE.add(c33796a2);
        }
        LoadMoreRecyclerView loadMoreRecyclerView = this.kou;
        if (loadMoreRecyclerView == null) {
            C25052j.avw("mRecyclerView");
        }
        loadMoreRecyclerView.getAdapter().notifyDataSetChanged();
        AppMethodBeat.m2505o(89239);
    }

    private boolean beg() {
        AppMethodBeat.m2504i(89240);
        C35939nv c35939nv = new C35939nv();
        C35940nw c35940nw = new C35940nw();
        C27578a c27578a = C45781a.kfc;
        boolean a = C27578a.m43811a(c35939nv, c35940nw);
        mo54347b(c35939nv, c35940nw);
        AppMethodBeat.m2505o(89240);
        return a;
    }

    /* renamed from: b */
    public final void mo54347b(C35939nv c35939nv, C35940nw c35940nw) {
        LinkedList linkedList;
        Iterator it;
        C23419ns c23419ns;
        C33796a c33796a;
        C33796a c33796a2;
        AppMethodBeat.m2504i(89241);
        if (c35939nv != null) {
            linkedList = c35939nv.vTp;
            C25052j.m39375o(linkedList, "card_home_page_element");
            if ((!((Collection) linkedList).isEmpty() ? 1 : 0) != 0) {
                it = c35939nv.vTp.iterator();
                while (it.hasNext()) {
                    c23419ns = (C23419ns) it.next();
                    c33796a = new C33796a();
                    c33796a.koU = c23419ns;
                    c33796a.type = 0;
                    this.koE.add(c33796a);
                }
            }
        }
        if (c35940nw != null) {
            linkedList = c35940nw.vTp;
            C25052j.m39375o(linkedList, "card_home_page_element");
            if ((!((Collection) linkedList).isEmpty() ? 1 : 0) != 0) {
                if (C5046bo.isNullOrNil(c35940nw.vTq)) {
                    c35940nw.vTq = getString(C25738R.string.aes);
                }
                if (this.koG == null) {
                    this.koG = new C33796a();
                    c33796a2 = this.koG;
                    if (c33796a2 == null) {
                        C25052j.dWJ();
                    }
                    c33796a2.type = 1;
                }
                c33796a2 = this.koG;
                if (c33796a2 == null) {
                    C25052j.dWJ();
                }
                String str = c35940nw.vTq;
                C25052j.m39375o(str, "section_title");
                c33796a2.mo54348GV(str);
                it = c35940nw.vTp.iterator();
                while (it.hasNext()) {
                    c23419ns = (C23419ns) it.next();
                    c33796a = new C33796a();
                    c33796a.koU = c23419ns;
                    c33796a.type = 2;
                    this.koF.add(c33796a);
                }
            }
        }
        if (this.scene == 0) {
            this.koH = new C33796a();
            c33796a2 = this.koH;
            if (c33796a2 == null) {
                C25052j.dWJ();
            }
            c33796a2.type = 4;
        }
        if (this.scene == 0) {
            if ((!((Collection) this.koE).isEmpty() ? 1 : 0) != 0) {
                this.koI = new C33796a();
                c33796a2 = this.koI;
                if (c33796a2 == null) {
                    C25052j.dWJ();
                }
                c33796a2.type = 5;
            }
        }
        ViewGroup viewGroup;
        if (this.koE.isEmpty() && this.koF.isEmpty()) {
            if (this.koH != null) {
                viewGroup = this.koy;
                if (viewGroup == null) {
                    C25052j.avw("mEmptyView");
                }
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                if (layoutParams == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    AppMethodBeat.m2505o(89241);
                    throw c44941v;
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = C1338a.fromDPToPix(dxU(), 80);
                ViewGroup viewGroup2 = this.koy;
                if (viewGroup2 == null) {
                    C25052j.avw("mEmptyView");
                }
                viewGroup2.setLayoutParams(layoutParams2);
            }
            viewGroup = this.koy;
            if (viewGroup == null) {
                C25052j.avw("mEmptyView");
            }
            viewGroup.setVisibility(0);
            AppMethodBeat.m2505o(89241);
            return;
        }
        viewGroup = this.koy;
        if (viewGroup == null) {
            C25052j.avw("mEmptyView");
        }
        viewGroup.setVisibility(8);
        AppMethodBeat.m2505o(89241);
    }

    private final void beh() {
        AppMethodBeat.m2504i(89242);
        C4990ab.m7417i("MicroMsg.CardHomePageNewUI", "do get card Home page: %s, %s", Boolean.valueOf(this.koC), Boolean.valueOf(this.isLoading));
        if (this.koO || !(this.koC || this.isLoading)) {
            int i;
            this.isLoading = true;
            if (this.koO) {
                ViewGroup viewGroup = this.koA;
                if (viewGroup == null) {
                    C25052j.avw("mLoadingView2");
                }
                viewGroup.setVisibility(0);
                if (this.koH != null) {
                    viewGroup = this.koA;
                    if (viewGroup == null) {
                        C25052j.avw("mLoadingView2");
                    }
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    if (layoutParams == null) {
                        C44941v c44941v = new C44941v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        AppMethodBeat.m2505o(89242);
                        throw c44941v;
                    }
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.topMargin = C1338a.fromDPToPix(dxU(), 80);
                    ViewGroup viewGroup2 = this.koA;
                    if (viewGroup2 == null) {
                        C25052j.avw("mLoadingView2");
                    }
                    viewGroup2.setLayoutParams(layoutParams2);
                }
            }
            if (this.kfk == 1) {
                i = 100;
            } else {
                i = 10;
            }
            this.koB = i;
            if (this.gnn != null) {
                Dialog dialog = this.gnn;
                if (dialog == null) {
                    C25052j.dWJ();
                }
                dialog.dismiss();
            }
            if (this.koE.isEmpty()) {
                Context dxU = dxU();
                dxU().getString(C25738R.string.f9104pl);
                this.gnn = C30379h.m48458b(dxU, dxU().getString(C25738R.string.cn5), true, null);
            }
            this.koQ = new C45782h(this.offset, this.koB, (double) this.cEB, (double) this.cGm, this.kfk);
            C45782h c45782h = this.koQ;
            if (c45782h == null) {
                C25052j.dWJ();
            }
            c45782h.acy().mo60487b((C5681a) new C27622h(this));
        }
        AppMethodBeat.m2505o(89242);
    }

    /* renamed from: n */
    public static final /* synthetic */ void m55261n(CardHomePageNewUI cardHomePageNewUI) {
        AppMethodBeat.m2504i(89246);
        C36356d c36356d = new C36356d(cardHomePageNewUI.dxU(), 1, false);
        c36356d.mo57235a((C36073c) new C2785p(cardHomePageNewUI));
        c36356d.mo57236a((C5279d) new C6818q(cardHomePageNewUI));
        c36356d.cpD();
        AppMethodBeat.m2505o(89246);
    }
}
