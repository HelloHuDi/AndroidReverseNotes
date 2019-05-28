package com.tencent.mm.plugin.card.ui.v2;

import a.y;
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
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.np;
import com.tencent.mm.protocal.protobuf.nq;
import com.tencent.mm.protocal.protobuf.nr;
import com.tencent.mm.protocal.protobuf.ns;
import com.tencent.mm.protocal.protobuf.nt;
import com.tencent.mm.protocal.protobuf.nv;
import com.tencent.mm.protocal.protobuf.nw;
import com.tencent.mm.protocal.protobuf.ny;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 I2\u00020\u0001:\u0005GHIJKB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020)J\b\u00100\u001a\u00020\u0005H\u0002J\u0018\u00101\u001a\u00020\u00052\u0006\u0010/\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020\tH\u0014J\b\u00105\u001a\u00020\u0005H\u0002J\b\u00106\u001a\u00020\u0005H\u0014J\u0006\u00107\u001a\u00020\rJ\u0012\u00108\u001a\u00020\u00052\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020\u0005H\u0014J\u0018\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\rH\u0016J\b\u0010?\u001a\u00020\u0005H\u0014J\u0006\u0010@\u001a\u00020\u0005J\b\u0010A\u001a\u00020\u0005H\u0002J\u001a\u0010B\u001a\u00020\u00052\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010FR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0018\u00010\u0007R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00060\u0019R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010%\u001a\f\u0012\b\u0012\u00060\u0007R\u00020\u00000&X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0018\u00010\u0007R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0018\u00010\u0007R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010-\u001a\f\u0012\b\u0012\u00060\u0007R\u00020\u00000&X\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "adjustFooterTask", "Lkotlin/Function0;", "", "cardTitleModel", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "clickArea", "", "clickedCardHomePageElement", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "firstLoad", "", "getCardHomePageScene", "Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktCardHomePage;", "isAll", "isGotoItem", "isLoading", "mDivider", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "mEmptyView", "Landroid/view/ViewGroup;", "mFooterView", "mHomePageAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageAdapter;", "mLoadingView", "mLoadingView2", "mRecyclerView", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "markReloadHomePage", "offset", "reqNum", "scene", "shouldShowTicket", "showSort", "sortType", "storeModelList", "Ljava/util/ArrayList;", "ticketModel", "ticketNum", "", "tipsDialog", "Landroid/app/Dialog;", "titleSectionModel", "underModelList", "doDeleteMchInList", "merchantId", "doGetCardHomePage", "doGetMchInfo", "lastReceiveTime", "", "getLayoutId", "initFirstScreen", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "showSortSheet", "updateModelList", "storePageList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageStoreList;", "underPageList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageUnderList;", "CardListModel", "CardSpan", "Companion", "HomePageAdapter", "HomePageVH", "plugin-card_release"})
@com.tencent.mm.kernel.i
public final class CardHomePageNewUI extends CardNewBaseUI {
    private static final int cjn = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 40);
    private static final int koR = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 1);
    private static final int koS = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 16);
    public static final c koT = new c();
    private boolean exX = true;
    private Dialog gnn;
    private boolean isLoading;
    private int kfk;
    private ViewGroup koA;
    private int koB = 10;
    private boolean koC;
    private String koD = "";
    private final ArrayList<a> koE = new ArrayList();
    private final ArrayList<a> koF = new ArrayList();
    private a koG;
    private a koH;
    private a koI;
    private boolean koJ;
    private int koK = -1;
    private boolean koL = true;
    private int koM;
    private ns koN;
    private boolean koO;
    private final a.f.a.a<y> koP = new f(this);
    private com.tencent.mm.plugin.card.model.a.h koQ;
    private LoadMoreRecyclerView kou;
    private d kov;
    private ViewGroup kow;
    private ViewGroup kox;
    private ViewGroup koy;
    private android.support.v7.widget.RecyclerView.h koz;
    private int offset;
    private int scene;

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class p implements com.tencent.mm.ui.base.n.c {
        final /* synthetic */ CardHomePageNewUI koY;

        p(CardHomePageNewUI cardHomePageNewUI) {
            this.koY = cardHomePageNewUI;
        }

        public final void a(com.tencent.mm.ui.base.l lVar) {
            AppMethodBeat.i(89231);
            lVar.add(0, 0, 1, (CharSequence) this.koY.getString(R.string.g68));
            lVar.add(0, 1, 1, (CharSequence) this.koY.getString(R.string.g6_));
            AppMethodBeat.o(89231);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
    static final class q implements com.tencent.mm.ui.base.n.d {
        final /* synthetic */ CardHomePageNewUI koY;

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
        /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$q$1 */
        static final class AnonymousClass1 implements OnClickListener {
            final /* synthetic */ q kpE;

            AnonymousClass1(q qVar) {
                this.kpE = qVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(89232);
                this.kpE.koY.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
                AppMethodBeat.o(89232);
            }
        }

        q(CardHomePageNewUI cardHomePageNewUI) {
            this.koY = cardHomePageNewUI;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(89233);
            a.f.b.j.o(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            ab.i("MicroMsg.CardHomePageNewUI", "click item: %s, sortType: %s", Integer.valueOf(itemId), Integer.valueOf(this.koY.kfk));
            if (itemId != 0 || this.koY.kfk != 2) {
                if (itemId == 1 && this.koY.kfk == 1) {
                    this.koY.koO = true;
                    this.koY.offset = 0;
                    this.koY.kfk = 2;
                    CardHomePageNewUI.p(this.koY);
                    com.tencent.mm.plugin.report.service.h.pYm.e(16322, Integer.valueOf(16));
                }
                AppMethodBeat.o(89233);
            } else if (this.koY.kpR) {
                this.koY.koO = true;
                this.koY.offset = 0;
                this.koY.kfk = 1;
                CardHomePageNewUI.p(this.koY);
                com.tencent.mm.plugin.report.service.h.pYm.e(16322, Integer.valueOf(15));
                AppMethodBeat.o(89233);
            } else {
                com.tencent.mm.ui.base.h.a((Context) this.koY, this.koY.getString(R.string.g6b), this.koY.getString(R.string.dc8), this.koY.getString(R.string.ckr), this.koY.getString(R.string.atb), false, (OnClickListener) new AnonymousClass1(this), null);
                AppMethodBeat.o(89233);
            }
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteMchInListResponse;", "call"})
    static final class g<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ CardHomePageNewUI koY;
        final /* synthetic */ String kpy;

        g(CardHomePageNewUI cardHomePageNewUI, String str) {
            this.koY = cardHomePageNewUI;
            this.kpy = str;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(89214);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.CardHomePageNewUI", "errtype: %s, errcode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                btd btd = aVar.fsy;
                ws wsVar = (ws) btd;
                ab.i("MicroMsg.CardHomePageNewUI", "retCode: %s", Integer.valueOf(wsVar.kdT));
                if (wsVar.kdT == 0) {
                    CardHomePageNewUI.o(this.koY).GW(this.kpy);
                } else {
                    com.tencent.mm.plugin.card.d.l.ai(this.koY, wsVar.kdU);
                }
                AppMethodBeat.o(89214);
                return btd;
            }
            com.tencent.mm.plugin.card.d.l.aj(this.koY, "");
            Object obj2 = y.AUy;
            AppMethodBeat.o(89214);
            return obj2;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class n implements OnMenuItemClickListener {
        final /* synthetic */ CardHomePageNewUI koY;

        n(CardHomePageNewUI cardHomePageNewUI) {
            this.koY = cardHomePageNewUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(89227);
            this.koY.finish();
            AppMethodBeat.o(89227);
            return false;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0003J \u0010M\u001a\u00020K2\u0006\u0010N\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u0005H\u0002J\u0010\u0010Q\u001a\u00020K2\u0006\u0010P\u001a\u00020\u0005H\u0002J\u0010\u0010R\u001a\u00020K2\u0006\u0010P\u001a\u00020\u0005H\u0002J\u000e\u0010S\u001a\u00020K2\u0006\u0010T\u001a\u00020UJ\u001e\u0010V\u001a\u00020K2\u0006\u0010W\u001a\u00020\u00142\u0006\u0010X\u001a\u00020U2\u0006\u0010Y\u001a\u00020ZJ$\u0010E\u001a\u00020K2\n\u0010@\u001a\u00060AR\u00020B2\u0006\u0010P\u001a\u00020\u00052\b\b\u0002\u0010[\u001a\u00020\\J\u0010\u0010]\u001a\u00020K2\u0006\u0010P\u001a\u00020\u0005H\u0002J\u0010\u0010^\u001a\u00020K2\u0006\u0010P\u001a\u00020\u0005H\u0002J\u0010\u0010_\u001a\u00020K2\u0006\u0010P\u001a\u00020\u0005H\u0002J\u001c\u0010`\u001a\u00020K2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020c0b2\u0006\u0010d\u001a\u00020\bJ\u0014\u0010`\u001a\u00020K2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020f0bJ\u0018\u0010g\u001a\u00020K2\u0006\u0010h\u001a\u00020\\2\u0006\u0010P\u001a\u00020\u0005H\u0002R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001a\u0010\u001c\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\fR\u001a\u0010\"\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\fR\u001a\u0010%\u001a\u00020&X.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0010\"\u0004\b3\u0010\u0012R\u001a\u00104\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0010\"\u0004\b6\u0010\u0012R\u001a\u00107\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0016\"\u0004\b9\u0010\u0018R\u001a\u0010:\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0016\"\u0004\b<\u0010\u0018R\u001a\u0010=\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0010\"\u0004\b?\u0010\u0012R \u0010@\u001a\b\u0018\u00010AR\u00020BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0010\"\u0004\bI\u0010\u0012¨\u0006i"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;Landroid/view/View;I)V", "chpiCouponLayout", "Landroid/widget/LinearLayout;", "getChpiCouponLayout", "()Landroid/widget/LinearLayout;", "setChpiCouponLayout", "(Landroid/widget/LinearLayout;)V", "chpiDescTv", "Landroid/widget/TextView;", "getChpiDescTv", "()Landroid/widget/TextView;", "setChpiDescTv", "(Landroid/widget/TextView;)V", "chpiExpandIv", "Landroid/widget/ImageView;", "getChpiExpandIv", "()Landroid/widget/ImageView;", "setChpiExpandIv", "(Landroid/widget/ImageView;)V", "chpiExpandLayout", "getChpiExpandLayout", "setChpiExpandLayout", "chpiExpandTv", "getChpiExpandTv", "setChpiExpandTv", "chpiHeaderLayout", "getChpiHeaderLayout", "setChpiHeaderLayout", "chpiLabelLayout", "getChpiLabelLayout", "setChpiLabelLayout", "chpiLogoIv", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "getChpiLogoIv", "()Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "setChpiLogoIv", "(Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;)V", "chpiMchLabelTv", "Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;", "getChpiMchLabelTv", "()Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;", "setChpiMchLabelTv", "(Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;)V", "chpiNameTv", "getChpiNameTv", "setChpiNameTv", "chtiDescTv", "getChtiDescTv", "setChtiDescTv", "chtiIconIv", "getChtiIconIv", "setChtiIconIv", "chtiRightIv", "getChtiRightIv", "setChtiRightIv", "chtiTitleTv", "getChtiTitleTv", "setChtiTitleTv", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "getModel", "()Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "setModel", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;)V", "sectionTitleTv", "getSectionTitleTv", "setSectionTitleTv", "addCouponView", "", "view", "appendCouponView", "offset", "len", "position", "collapseCouponLayout", "expandCouponLayout", "gotoCardDetailUI", "cardId", "", "setCardBg", "imageView", "url", "radius", "", "useBackendExpandState", "", "showCollapseLayout", "showExpandLayout", "showMiniAppLayout", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "labelList", "Lcom/tencent/mm/protocal/protobuf/CardElementMchLabel;", "updateExpandLayout", "isExpended", "plugin-card_release"})
    public final class e extends v {
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
        a kpo;

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class e implements View.OnClickListener {
            final /* synthetic */ e kpp;

            e(e eVar) {
                this.kpp = eVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(89195);
                CardHomePageNewUI.n(this.kpp.koY);
                AppMethodBeat.o(89195);
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$1$span$1", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;", "onClick", "", "widget", "Landroid/view/View;", "hrefInfo", "Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;", "plugin-card_release"})
        public static final class d extends com.tencent.mm.pluginsdk.ui.e.h {
            final /* synthetic */ View.OnClickListener kpx;

            d(View.OnClickListener onClickListener) {
                this.kpx = onClickListener;
            }

            public final void a(View view, com.tencent.mm.pluginsdk.ui.applet.m mVar) {
                AppMethodBeat.i(89194);
                this.kpx.onClick(view);
                AppMethodBeat.o(89194);
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class g implements View.OnClickListener {
            final /* synthetic */ int exi;
            final /* synthetic */ e kpp;
            final /* synthetic */ ns kpq;

            g(e eVar, int i, ns nsVar) {
                this.kpp = eVar;
                this.exi = i;
                this.kpq = nsVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(89197);
                ab.d("MicroMsg.CardHomePageNewUI", "do expand coupon layout");
                e.a(this.kpp, this.exi);
                a aVar = this.kpp.kpo;
                if (aVar != null) {
                    aVar.koX = true;
                }
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(1);
                ns nsVar = this.kpq;
                if (nsVar == null) {
                    a.f.b.j.dWJ();
                }
                objArr[1] = nsVar.vSR;
                objArr[2] = Integer.valueOf(0);
                objArr[3] = Integer.valueOf(0);
                objArr[4] = Integer.valueOf(4);
                objArr[5] = Integer.valueOf(this.exi);
                objArr[6] = Integer.valueOf(this.kpp.koY.kfk);
                hVar.e(16324, objArr);
                AppMethodBeat.o(89197);
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class f implements View.OnClickListener {
            final /* synthetic */ int exi;
            final /* synthetic */ e kpp;
            final /* synthetic */ ns kpq;

            f(e eVar, int i, ns nsVar) {
                this.kpp = eVar;
                this.exi = i;
                this.kpq = nsVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(89196);
                ab.d("MicroMsg.CardHomePageNewUI", "do collapse coupon layout");
                e.b(this.kpp, this.exi);
                a aVar = this.kpp.kpo;
                if (aVar != null) {
                    aVar.koX = false;
                }
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(1);
                ns nsVar = this.kpq;
                if (nsVar == null) {
                    a.f.b.j.dWJ();
                }
                objArr[1] = nsVar.vSR;
                objArr[2] = Integer.valueOf(0);
                objArr[3] = Integer.valueOf(0);
                objArr[4] = Integer.valueOf(5);
                objArr[5] = Integer.valueOf(this.exi);
                objArr[6] = Integer.valueOf(this.kpp.koY.kfk);
                hVar.e(16324, objArr);
                AppMethodBeat.o(89196);
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ int exi;
            final /* synthetic */ e kpp;
            final /* synthetic */ ns kpq;
            final /* synthetic */ nq kpr;
            final /* synthetic */ int kps;

            a(e eVar, ns nsVar, nq nqVar, int i, int i2) {
                this.kpp = eVar;
                this.kpq = nsVar;
                this.kpr = nqVar;
                this.kps = i;
                this.exi = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(89191);
                this.kpp.koY.koJ = true;
                this.kpp.koY.koK = 0;
                this.kpp.koY.koN = this.kpq;
                e eVar = this.kpp;
                String str = this.kpr.vCb;
                a.f.b.j.o(str, "coupon.user_card_id");
                eVar.GY(str);
                com.tencent.mm.plugin.report.service.h.pYm.e(16324, Integer.valueOf(1), this.kpq.vSR, Integer.valueOf(this.kps), this.kpr.vCb, Integer.valueOf(2), Integer.valueOf(this.exi), Integer.valueOf(this.kpp.koY.kfk));
                AppMethodBeat.o(89191);
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class b implements View.OnClickListener {
            final /* synthetic */ int exi;
            final /* synthetic */ e kpp;
            final /* synthetic */ ns kpq;
            final /* synthetic */ nq kpr;
            final /* synthetic */ int kps;

            b(e eVar, ns nsVar, nq nqVar, int i, int i2) {
                this.kpp = eVar;
                this.kpq = nsVar;
                this.kpr = nqVar;
                this.kps = i;
                this.exi = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(89192);
                this.kpp.koY.koJ = true;
                this.kpp.koY.koK = 0;
                this.kpp.koY.koN = this.kpq;
                e eVar = this.kpp;
                String str = this.kpr.vCb;
                a.f.b.j.o(str, "coupon.user_card_id");
                eVar.GY(str);
                com.tencent.mm.plugin.report.service.h.pYm.e(16324, Integer.valueOf(1), this.kpq.vSR, Integer.valueOf(this.kps), this.kpr.vCb, Integer.valueOf(2), Integer.valueOf(this.exi), Integer.valueOf(this.kpp.koY.kfk));
                AppMethodBeat.o(89192);
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$1$headerClickListener$1"})
        static final class c implements View.OnClickListener {
            final /* synthetic */ int iPU;
            final /* synthetic */ e kpp;
            final /* synthetic */ ns kpt;
            final /* synthetic */ ns kpu;
            final /* synthetic */ boolean kpv = false;
            final /* synthetic */ a kpw;

            c(ns nsVar, e eVar, ns nsVar2, int i, a aVar) {
                this.kpt = nsVar;
                this.kpp = eVar;
                this.kpu = nsVar2;
                this.iPU = i;
                this.kpw = aVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(89193);
                ab.i("MicroMsg.CardHomePageNewUI", "click header");
                this.kpp.koY.koJ = true;
                this.kpp.koY.koK = 0;
                this.kpp.koY.koN = this.kpu;
                switch (this.kpt.vSW) {
                    case 1:
                        View view2 = this.kpp.apJ;
                        a.f.b.j.o(view2, "itemView");
                        Context context = view2.getContext();
                        if (context != null) {
                            com.tencent.mm.plugin.card.d.b.a((MMActivity) context, this.kpt.vSX);
                            break;
                        }
                        a.v vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                        AppMethodBeat.o(89193);
                        throw vVar;
                    case 2:
                        ny nyVar = this.kpt.vSY;
                        com.tencent.mm.plugin.card.d.b.t(nyVar.tzW, nyVar.ttg, nyVar.tIE);
                        break;
                }
                com.tencent.mm.plugin.report.service.h.pYm.e(16324, Integer.valueOf(1), this.kpt.vSR, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(this.iPU), Integer.valueOf(this.kpp.koY.kfk));
                AppMethodBeat.o(89193);
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showMiniAppLayout$1$1"})
        static final class h implements View.OnClickListener {
            final /* synthetic */ int iPU;
            final /* synthetic */ e kpp;
            final /* synthetic */ ns kpt;

            h(ns nsVar, e eVar, int i) {
                this.kpt = nsVar;
                this.kpp = eVar;
                this.iPU = i;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(89198);
                if (this.kpt.vTd != null) {
                    String str = "MicroMsg.CardHomePageNewUI";
                    String str2 = "detail goto mini app %s";
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(this.kpt.vTd != null);
                    ab.i(str, str2, objArr);
                    this.kpp.koY.koJ = true;
                    this.kpp.koY.koK = 0;
                    this.kpp.koY.koN = this.kpt;
                    com.tencent.mm.plugin.card.d.b.t(this.kpt.vTd.tzW, this.kpt.vTd.ttg, this.kpt.vTd.tIE);
                }
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                Object[] objArr2 = new Object[7];
                objArr2[0] = Integer.valueOf(1);
                a aVar = this.kpp.kpo;
                if (aVar == null) {
                    a.f.b.j.dWJ();
                }
                ns nsVar = aVar.koU;
                if (nsVar == null) {
                    a.f.b.j.dWJ();
                }
                objArr2[1] = nsVar.vSR;
                objArr2[2] = Integer.valueOf(0);
                objArr2[3] = Integer.valueOf(0);
                objArr2[4] = Integer.valueOf(6);
                objArr2[5] = Integer.valueOf(this.iPU);
                objArr2[6] = Integer.valueOf(this.kpp.koY.kfk);
                hVar.e(16324, objArr2);
                AppMethodBeat.o(89198);
            }
        }

        public e(CardHomePageNewUI cardHomePageNewUI, View view, int i) {
            a.f.b.j.p(view, "itemView");
            this.koY = cardHomePageNewUI;
            super(view);
            AppMethodBeat.i(89210);
            View findViewById;
            CdnImageView cdnImageView;
            switch (i) {
                case 0:
                    findViewById = view.findViewById(R.id.afb);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chpi_logo_iv)");
                    this.kpa = (CdnImageView) findViewById;
                    findViewById = view.findViewById(R.id.afd);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chpi_username_tv)");
                    this.kpb = (TextView) findViewById;
                    findViewById = view.findViewById(R.id.aff);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chpi_desc_tv)");
                    this.kpc = (TextView) findViewById;
                    findViewById = view.findViewById(R.id.afu);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chpi_label_layout)");
                    this.kpe = (LinearLayout) findViewById;
                    findViewById = view.findViewById(R.id.afv);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chpi_coupon_layout)");
                    this.kpf = (LinearLayout) findViewById;
                    findViewById = view.findViewById(R.id.afw);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chpi_expand_layout)");
                    this.kpg = (LinearLayout) findViewById;
                    findViewById = view.findViewById(R.id.afy);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chpi_expand_iv)");
                    this.kpi = (ImageView) findViewById;
                    findViewById = view.findViewById(R.id.afx);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chpi_expand_tv)");
                    this.kph = (TextView) findViewById;
                    findViewById = view.findViewById(R.id.afe);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chpi_mch_label_tv)");
                    this.kpj = (CardLabelTextView) findViewById;
                    findViewById = view.findViewById(R.id.aft);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chpi_header_layout)");
                    this.kpd = (LinearLayout) findViewById;
                    cdnImageView = this.kpa;
                    if (cdnImageView == null) {
                        a.f.b.j.avw("chpiLogoIv");
                    }
                    cdnImageView.setUseSdcardCache(true);
                    AppMethodBeat.o(89210);
                    return;
                case 1:
                    findViewById = view.findViewById(R.id.ag0);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chpi_section_title)");
                    this.koZ = (TextView) findViewById;
                    AppMethodBeat.o(89210);
                    return;
                case 2:
                    findViewById = view.findViewById(R.id.afb);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chpi_logo_iv)");
                    this.kpa = (CdnImageView) findViewById;
                    findViewById = view.findViewById(R.id.afd);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chpi_username_tv)");
                    this.kpb = (TextView) findViewById;
                    findViewById = view.findViewById(R.id.aff);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chpi_desc_tv)");
                    this.kpc = (TextView) findViewById;
                    findViewById = view.findViewById(R.id.afe);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chpi_mch_label_tv)");
                    this.kpj = (CardLabelTextView) findViewById;
                    cdnImageView = this.kpa;
                    if (cdnImageView == null) {
                        a.f.b.j.avw("chpiLogoIv");
                    }
                    cdnImageView.setUseSdcardCache(true);
                    AppMethodBeat.o(89210);
                    return;
                case 3:
                    findViewById = view.findViewById(R.id.afb);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chpi_logo_iv)");
                    this.kpa = (CdnImageView) findViewById;
                    findViewById = view.findViewById(R.id.afd);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chpi_username_tv)");
                    this.kpb = (TextView) findViewById;
                    findViewById = view.findViewById(R.id.aff);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chpi_desc_tv)");
                    this.kpc = (TextView) findViewById;
                    cdnImageView = this.kpa;
                    if (cdnImageView == null) {
                        a.f.b.j.avw("chpiLogoIv");
                    }
                    cdnImageView.setUseSdcardCache(true);
                    AppMethodBeat.o(89210);
                    return;
                case 4:
                    findViewById = view.findViewById(R.id.afg);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chti_icon_iv)");
                    this.kpk = (ImageView) findViewById;
                    findViewById = view.findViewById(R.id.afh);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chti_title_tv)");
                    this.kpl = (TextView) findViewById;
                    findViewById = view.findViewById(R.id.afi);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chti_desc_tv)");
                    this.kpm = (TextView) findViewById;
                    findViewById = view.findViewById(R.id.afj);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chti_right_iv)");
                    this.kpn = (ImageView) findViewById;
                    AppMethodBeat.o(89210);
                    return;
                case 5:
                    findViewById = view.findViewById(R.id.afg);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chti_icon_iv)");
                    this.kpk = (ImageView) findViewById;
                    findViewById = view.findViewById(R.id.afh);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chti_title_tv)");
                    this.kpl = (TextView) findViewById;
                    findViewById = view.findViewById(R.id.afi);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chti_desc_tv)");
                    this.kpm = (TextView) findViewById;
                    findViewById = view.findViewById(R.id.afj);
                    a.f.b.j.o(findViewById, "itemView.findViewById(R.id.chti_right_iv)");
                    this.kpn = (ImageView) findViewById;
                    break;
            }
            AppMethodBeat.o(89210);
        }

        public static /* synthetic */ void a(e eVar, a aVar, int i) {
            AppMethodBeat.i(89200);
            eVar.a(aVar, i);
            AppMethodBeat.o(89200);
        }

        public final void a(a aVar, int i) {
            AppMethodBeat.i(89199);
            a.f.b.j.p(aVar, "model");
            this.kpo = aVar;
            ns nsVar = aVar.koU;
            CdnImageView cdnImageView;
            TextView textView;
            TextView textView2;
            CardLabelTextView cardLabelTextView;
            CardLabelTextView cardLabelTextView2;
            y yVar;
            TextView textView3;
            switch (aVar.type) {
                case 0:
                    boolean z;
                    LinkedList linkedList;
                    if (nsVar == null) {
                        a.f.b.j.dWJ();
                    }
                    cdnImageView = this.kpa;
                    if (cdnImageView == null) {
                        a.f.b.j.avw("chpiLogoIv");
                    }
                    cdnImageView.setRoundCorner(true);
                    if (bo.isNullOrNil(nsVar.vSS)) {
                        cdnImageView = this.kpa;
                        if (cdnImageView == null) {
                            a.f.b.j.avw("chpiLogoIv");
                        }
                        cdnImageView.setImageResource(R.raw.card_default_merchant_icon);
                    } else {
                        cdnImageView = this.kpa;
                        if (cdnImageView == null) {
                            a.f.b.j.avw("chpiLogoIv");
                        }
                        cdnImageView.eb(nsVar.vSS, R.raw.card_default_merchant_icon);
                    }
                    View.OnClickListener cVar = new c(nsVar, this, nsVar, i, aVar);
                    CdnImageView cdnImageView2 = this.kpa;
                    if (cdnImageView2 == null) {
                        a.f.b.j.avw("chpiLogoIv");
                    }
                    cdnImageView2.setOnClickListener(cVar);
                    CardHomePageNewUI cardHomePageNewUI = this.koY;
                    AppCompatActivity dxU = this.koY.dxU();
                    a.f.b.j.o(dxU, "context");
                    b bVar = new b(cardHomePageNewUI, dxU.getResources().getColor(R.color.a0j), new d(cVar));
                    SpannableString spannableString = new SpannableString(nsVar.vST);
                    spannableString.setSpan(bVar, 0, spannableString.length(), 18);
                    textView = this.kpb;
                    if (textView == null) {
                        a.f.b.j.avw("chpiNameTv");
                    }
                    textView.setClickable(true);
                    TextView textView4 = this.kpb;
                    if (textView4 == null) {
                        a.f.b.j.avw("chpiNameTv");
                    }
                    textView4.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m(this.koY));
                    TextView textView5 = this.kpb;
                    if (textView5 == null) {
                        a.f.b.j.avw("chpiNameTv");
                    }
                    textView5.setText(spannableString);
                    if (bo.isNullOrNil(nsVar.vSU)) {
                        textView2 = this.kpc;
                        if (textView2 == null) {
                            a.f.b.j.avw("chpiDescTv");
                        }
                        textView2.setVisibility(8);
                    } else {
                        textView5 = this.kpc;
                        if (textView5 == null) {
                            a.f.b.j.avw("chpiDescTv");
                        }
                        textView5.setText(nsVar.vSU);
                        textView = this.kpc;
                        if (textView == null) {
                            a.f.b.j.avw("chpiDescTv");
                        }
                        textView.setVisibility(0);
                        textView = this.kpc;
                        if (textView == null) {
                            a.f.b.j.avw("chpiDescTv");
                        }
                        textView.setOnClickListener(cVar);
                    }
                    if (nsVar.vTe == null) {
                        cardLabelTextView = this.kpj;
                        if (cardLabelTextView == null) {
                            a.f.b.j.avw("chpiMchLabelTv");
                        }
                        cardLabelTextView.setText("");
                        cardLabelTextView2 = this.kpj;
                        if (cardLabelTextView2 == null) {
                            a.f.b.j.avw("chpiMchLabelTv");
                        }
                        cardLabelTextView2.setVisibility(8);
                    } else if (bo.isNullOrNil(nsVar.vTe.vSL)) {
                        cardLabelTextView2 = this.kpj;
                        if (cardLabelTextView2 == null) {
                            a.f.b.j.avw("chpiMchLabelTv");
                        }
                        cardLabelTextView2.setVisibility(8);
                    } else {
                        cardLabelTextView = this.kpj;
                        if (cardLabelTextView == null) {
                            a.f.b.j.avw("chpiMchLabelTv");
                        }
                        cardLabelTextView.setText(nsVar.vTe.vSL);
                        if (bo.isNullOrNil(nsVar.vTe.vSM)) {
                            cardLabelTextView2 = this.kpj;
                            if (cardLabelTextView2 == null) {
                                a.f.b.j.avw("chpiMchLabelTv");
                            }
                            cardLabelTextView2.setTextColor(-1);
                        } else {
                            cardLabelTextView2 = this.kpj;
                            if (cardLabelTextView2 == null) {
                                a.f.b.j.avw("chpiMchLabelTv");
                            }
                            cardLabelTextView2.setTextColor(Color.parseColor(nsVar.vTe.vSM));
                        }
                        if (bo.isNullOrNil(nsVar.vTe.vSN)) {
                            cardLabelTextView2 = this.kpj;
                            if (cardLabelTextView2 == null) {
                                a.f.b.j.avw("chpiMchLabelTv");
                            }
                            cardLabelTextView2.setFillColor(0);
                        } else {
                            cardLabelTextView2 = this.kpj;
                            if (cardLabelTextView2 == null) {
                                a.f.b.j.avw("chpiMchLabelTv");
                            }
                            cardLabelTextView2.setFillColor(com.tencent.mm.plugin.card.d.l.bT(nsVar.vTe.vSN, nsVar.vTe.vSQ));
                        }
                        cardLabelTextView2 = this.kpj;
                        if (cardLabelTextView2 == null) {
                            a.f.b.j.avw("chpiMchLabelTv");
                        }
                        cardLabelTextView2.setVisibility(0);
                    }
                    LinearLayout linearLayout = this.kpf;
                    if (linearLayout == null) {
                        a.f.b.j.avw("chpiCouponLayout");
                    }
                    linearLayout.removeAllViews();
                    if (aVar.koW) {
                        z = aVar.koX;
                    } else if (nsVar.vTf == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        linkedList = nsVar.vTa;
                        a.f.b.j.o(linkedList, "card_element_coupon_list");
                        if (!((Collection) linkedList).isEmpty()) {
                            P(-1, nsVar.vTa.size(), i);
                            linearLayout = this.kpf;
                            if (linearLayout == null) {
                                a.f.b.j.avw("chpiCouponLayout");
                            }
                            linearLayout.setVisibility(0);
                            aVar.koX = true;
                        } else {
                            linearLayout = this.kpf;
                            if (linearLayout == null) {
                                a.f.b.j.avw("chpiCouponLayout");
                            }
                            linearLayout.setVisibility(8);
                        }
                        if (!bo.isNullOrNil(nsVar.vTb)) {
                            ti(i);
                            linearLayout = this.kpg;
                            if (linearLayout == null) {
                                a.f.b.j.avw("chpiExpandLayout");
                            }
                            linearLayout.setVisibility(0);
                        } else if (nsVar.vTh < nsVar.vTa.size()) {
                            tk(i);
                        } else {
                            linearLayout = this.kpg;
                            if (linearLayout == null) {
                                a.f.b.j.avw("chpiExpandLayout");
                            }
                            linearLayout.setVisibility(8);
                        }
                    } else {
                        linkedList = nsVar.vTa;
                        a.f.b.j.o(linkedList, "card_element_coupon_list");
                        if (!((Collection) linkedList).isEmpty()) {
                            P(-1, nsVar.vTh, i);
                            linearLayout = this.kpf;
                            if (linearLayout == null) {
                                a.f.b.j.avw("chpiCouponLayout");
                            }
                            linearLayout.setVisibility(0);
                            aVar.koX = false;
                        } else {
                            linearLayout = this.kpf;
                            if (linearLayout == null) {
                                a.f.b.j.avw("chpiCouponLayout");
                            }
                            linearLayout.setVisibility(8);
                        }
                        if (nsVar.vTh < nsVar.vTa.size()) {
                            tj(i);
                            linearLayout = this.kpg;
                            if (linearLayout == null) {
                                a.f.b.j.avw("chpiExpandLayout");
                            }
                            linearLayout.setVisibility(0);
                        } else if (bo.isNullOrNil(nsVar.vTb)) {
                            linearLayout = this.kpg;
                            if (linearLayout == null) {
                                a.f.b.j.avw("chpiExpandLayout");
                            }
                            linearLayout.setVisibility(8);
                        } else {
                            ti(i);
                            linearLayout = this.kpg;
                            if (linearLayout == null) {
                                a.f.b.j.avw("chpiExpandLayout");
                            }
                            linearLayout.setVisibility(0);
                        }
                    }
                    linkedList = nsVar.vSV;
                    a.f.b.j.o(linkedList, "card_element_mch_label");
                    bi(linkedList);
                    yVar = y.AUy;
                    break;
                case 1:
                    textView3 = this.koZ;
                    if (textView3 == null) {
                        a.f.b.j.avw("sectionTitleTv");
                    }
                    textView3.setText(aVar.bek());
                    break;
                case 2:
                    if (nsVar == null) {
                        a.f.b.j.dWJ();
                    }
                    cdnImageView = this.kpa;
                    if (cdnImageView == null) {
                        a.f.b.j.avw("chpiLogoIv");
                    }
                    cdnImageView.setRoundCorner(true);
                    cdnImageView = this.kpa;
                    if (cdnImageView == null) {
                        a.f.b.j.avw("chpiLogoIv");
                    }
                    cdnImageView.setUrl(nsVar.vSS);
                    textView = this.kpb;
                    if (textView == null) {
                        a.f.b.j.avw("chpiNameTv");
                    }
                    textView.setText(nsVar.vST);
                    if (bo.isNullOrNil(nsVar.vSU)) {
                        textView2 = this.kpc;
                        if (textView2 == null) {
                            a.f.b.j.avw("chpiDescTv");
                        }
                        textView2.setVisibility(8);
                    } else {
                        textView = this.kpc;
                        if (textView == null) {
                            a.f.b.j.avw("chpiDescTv");
                        }
                        textView.setText(nsVar.vSU);
                        textView2 = this.kpc;
                        if (textView2 == null) {
                            a.f.b.j.avw("chpiDescTv");
                        }
                        textView2.setVisibility(0);
                    }
                    if (nsVar.vTe == null) {
                        CardLabelTextView cardLabelTextView3 = this.kpj;
                        if (cardLabelTextView3 == null) {
                            a.f.b.j.avw("chpiMchLabelTv");
                        }
                        cardLabelTextView3.setText("");
                        cardLabelTextView2 = this.kpj;
                        if (cardLabelTextView2 == null) {
                            a.f.b.j.avw("chpiMchLabelTv");
                        }
                        cardLabelTextView2.setVisibility(8);
                    } else if (bo.isNullOrNil(nsVar.vTe.vSL)) {
                        cardLabelTextView2 = this.kpj;
                        if (cardLabelTextView2 == null) {
                            a.f.b.j.avw("chpiMchLabelTv");
                        }
                        cardLabelTextView2.setVisibility(8);
                    } else {
                        cardLabelTextView = this.kpj;
                        if (cardLabelTextView == null) {
                            a.f.b.j.avw("chpiMchLabelTv");
                        }
                        cardLabelTextView.setText(nsVar.vTe.vSL);
                        if (bo.isNullOrNil(nsVar.vTe.vSM)) {
                            cardLabelTextView2 = this.kpj;
                            if (cardLabelTextView2 == null) {
                                a.f.b.j.avw("chpiMchLabelTv");
                            }
                            cardLabelTextView2.setTextColor(-1);
                        } else {
                            cardLabelTextView2 = this.kpj;
                            if (cardLabelTextView2 == null) {
                                a.f.b.j.avw("chpiMchLabelTv");
                            }
                            cardLabelTextView2.setTextColor(Color.parseColor(nsVar.vTe.vSM));
                        }
                        if (bo.isNullOrNil(nsVar.vTe.vSN)) {
                            cardLabelTextView2 = this.kpj;
                            if (cardLabelTextView2 == null) {
                                a.f.b.j.avw("chpiMchLabelTv");
                            }
                            cardLabelTextView2.setFillColor(0);
                        } else {
                            cardLabelTextView2 = this.kpj;
                            if (cardLabelTextView2 == null) {
                                a.f.b.j.avw("chpiMchLabelTv");
                            }
                            cardLabelTextView2.setFillColor(com.tencent.mm.plugin.card.d.l.bT(nsVar.vTe.vSN, nsVar.vTe.vSQ));
                        }
                        cardLabelTextView2 = this.kpj;
                        if (cardLabelTextView2 == null) {
                            a.f.b.j.avw("chpiMchLabelTv");
                        }
                        cardLabelTextView2.setVisibility(0);
                    }
                    yVar = y.AUy;
                    break;
                case 3:
                    cdnImageView = this.kpa;
                    if (cdnImageView == null) {
                        a.f.b.j.avw("chpiLogoIv");
                    }
                    cdnImageView.setRoundCorner(true);
                    cdnImageView = this.kpa;
                    if (cdnImageView == null) {
                        a.f.b.j.avw("chpiLogoIv");
                    }
                    cdnImageView.setImageResource(R.raw.card_default_merchant_icon);
                    textView3 = this.kpb;
                    if (textView3 == null) {
                        a.f.b.j.avw("chpiNameTv");
                    }
                    textView3.setText(ah.getResources().getString(R.string.aeu));
                    textView2 = this.kpc;
                    if (textView2 == null) {
                        a.f.b.j.avw("chpiDescTv");
                    }
                    textView2.setVisibility(8);
                    break;
                case 4:
                    textView2 = this.kpl;
                    if (textView2 == null) {
                        a.f.b.j.avw("chtiTitleTv");
                    }
                    textView2.setText(R.string.evz);
                    if (this.koY.koD != null) {
                        textView3 = this.kpm;
                        if (textView3 == null) {
                            a.f.b.j.avw("chtiDescTv");
                        }
                        textView3.setText(this.koY.koD);
                        yVar = y.AUy;
                        break;
                    }
                    break;
                case 5:
                    textView2 = this.kpl;
                    if (textView2 == null) {
                        a.f.b.j.avw("chtiTitleTv");
                    }
                    textView2.setText(R.string.agc);
                    ImageView imageView;
                    if (this.koY.koM == 1 && this.koY.kfk != 0) {
                        textView2 = this.kpm;
                        if (textView2 == null) {
                            a.f.b.j.avw("chtiDescTv");
                        }
                        textView2.setVisibility(0);
                        imageView = this.kpn;
                        if (imageView == null) {
                            a.f.b.j.avw("chtiRightIv");
                        }
                        imageView.setVisibility(0);
                        if (this.koY.kfk == 1) {
                            textView2 = this.kpm;
                            if (textView2 == null) {
                                a.f.b.j.avw("chtiDescTv");
                            }
                            textView2.setText(R.string.g68);
                        } else if (this.koY.kfk == 2) {
                            textView2 = this.kpm;
                            if (textView2 == null) {
                                a.f.b.j.avw("chtiDescTv");
                            }
                            textView2.setText(R.string.g6_);
                        }
                        textView3 = this.kpm;
                        if (textView3 == null) {
                            a.f.b.j.avw("chtiDescTv");
                        }
                        textView3.setOnClickListener(new e(this));
                        break;
                    }
                    textView2 = this.kpm;
                    if (textView2 == null) {
                        a.f.b.j.avw("chtiDescTv");
                    }
                    textView2.setVisibility(8);
                    imageView = this.kpn;
                    if (imageView == null) {
                        a.f.b.j.avw("chtiRightIv");
                    }
                    imageView.setVisibility(8);
                    break;
                    break;
            }
            aVar.koW = true;
            AppMethodBeat.o(89199);
        }

        private final void P(int i, int i2, int i3) {
            AppMethodBeat.i(89201);
            a aVar = this.kpo;
            if (aVar == null) {
                a.f.b.j.dWJ();
            }
            ns nsVar = aVar.koU;
            if (nsVar == null) {
                a.f.b.j.dWJ();
            }
            LinkedList<nq> linkedList = nsVar.vTa;
            a.f.b.j.o(linkedList, "el!!.card_element_coupon_list");
            int i4 = 0;
            int i5 = 0;
            for (nq nqVar : linkedList) {
                if (i4 >= i) {
                    LinearLayout linearLayout;
                    LayoutInflater from;
                    View inflate;
                    a.v vVar;
                    ViewGroup viewGroup;
                    TextView textView;
                    LinkedList linkedList2;
                    List list;
                    if (nqVar.vSE == 1) {
                        linearLayout = this.kpf;
                        if (linearLayout == null) {
                            a.f.b.j.avw("chpiCouponLayout");
                        }
                        from = LayoutInflater.from(linearLayout.getContext());
                        linearLayout = this.kpf;
                        if (linearLayout == null) {
                            a.f.b.j.avw("chpiCouponLayout");
                        }
                        inflate = from.inflate(R.layout.ix, linearLayout, false);
                        if (inflate == null) {
                            vVar = new a.v("null cannot be cast to non-null type android.view.ViewGroup");
                            AppMethodBeat.o(89201);
                            throw vVar;
                        }
                        viewGroup = (ViewGroup) inflate;
                        textView = (TextView) viewGroup.findViewById(R.id.afm);
                        CdnImageView cdnImageView = (CdnImageView) viewGroup.findViewById(R.id.afp);
                        TextView textView2 = (TextView) viewGroup.findViewById(R.id.afn);
                        LinearLayout linearLayout2 = (LinearLayout) viewGroup.findViewById(R.id.afo);
                        if (!bo.isNullOrNil(nqVar.vSH)) {
                            textView.setTextColor(com.tencent.mm.plugin.card.d.l.bT(nqVar.vSH, nqVar.vSI));
                        }
                        a.f.b.j.o(textView, "titleTv");
                        textView.setText(nqVar.vSy);
                        cdnImageView.setUrl(nqVar.vSF);
                        if (!bo.isNullOrNil(nqVar.vSJ)) {
                            textView2.setTextColor(com.tencent.mm.plugin.card.d.l.bT(nqVar.vSJ, nqVar.vSK));
                        }
                        a.f.b.j.o(textView2, "descTv");
                        textView2.setText(nqVar.vSz);
                        linkedList2 = nqVar.vSD;
                        a.f.b.j.o(linkedList2, "coupon.coupon_label");
                        list = linkedList2;
                        a.f.b.j.o(linearLayout2, "labelLayout");
                        a(list, linearLayout2);
                        linearLayout = this.kpf;
                        if (linearLayout == null) {
                            a.f.b.j.avw("chpiCouponLayout");
                        }
                        viewGroup.setOnClickListener(new a(this, nsVar, nqVar, linearLayout.getChildCount(), i3));
                        db(viewGroup);
                    } else if (nqVar.vSE == 2) {
                        linearLayout = this.kpf;
                        if (linearLayout == null) {
                            a.f.b.j.avw("chpiCouponLayout");
                        }
                        from = LayoutInflater.from(linearLayout.getContext());
                        linearLayout = this.kpf;
                        if (linearLayout == null) {
                            a.f.b.j.avw("chpiCouponLayout");
                        }
                        inflate = from.inflate(R.layout.iw, linearLayout, false);
                        if (inflate == null) {
                            vVar = new a.v("null cannot be cast to non-null type android.view.ViewGroup");
                            AppMethodBeat.o(89201);
                            throw vVar;
                        }
                        viewGroup = (ViewGroup) inflate;
                        textView = (TextView) viewGroup.findViewById(R.id.afm);
                        TextView textView3 = (TextView) viewGroup.findViewById(R.id.afn);
                        LinearLayout linearLayout3 = (LinearLayout) viewGroup.findViewById(R.id.afo);
                        MemberCardTopCropImageView memberCardTopCropImageView = (MemberCardTopCropImageView) viewGroup.findViewById(R.id.afk);
                        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.afl);
                        if (!bo.isNullOrNil(nqVar.vSH)) {
                            textView.setTextColor(com.tencent.mm.plugin.card.d.l.bT(nqVar.vSH, nqVar.vSI));
                        }
                        a.f.b.j.o(textView, "titleTv");
                        textView.setText(nqVar.vSy);
                        a.f.b.j.o(textView3, "descTv");
                        textView3.setText(nqVar.vSz);
                        a.f.b.j.o(memberCardTopCropImageView, "bgIv");
                        memberCardTopCropImageView.setRadius((float) com.tencent.mm.bz.a.fromDPToPix(memberCardTopCropImageView.getContext(), 2));
                        if (!bo.isNullOrNil(nqVar.vSC)) {
                            ImageView imageView2 = memberCardTopCropImageView;
                            String str = nqVar.vSC;
                            a.f.b.j.o(str, "coupon.coupon_back_url");
                            a.f.b.j.p(imageView2, "imageView");
                            a.f.b.j.p(str, "url");
                            com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
                            aVar2.sD(com.tencent.mm.compatible.util.e.eSn);
                            aVar2.a(com.tencent.mm.at.o.ahq());
                            aVar2.sC(com.tencent.mm.plugin.card.model.m.Gz(str));
                            aVar2.ahD();
                            aVar2.ahF();
                            aVar2.ahC();
                            aVar2.lK(R.drawable.gp);
                            aVar2.lJ(com.tencent.mm.bz.a.fromDPToPix(imageView2.getContext(), 84));
                            aVar2.lI(com.tencent.mm.bz.a.gd(imageView2.getContext()));
                            com.tencent.mm.at.o.ahp().a(str, imageView2, aVar2.ahG());
                            imageView2.setImageMatrix(new Matrix());
                            a.f.b.j.o(imageView, "shadowBgIv");
                            imageView.setVisibility(0);
                        } else if (!bo.isNullOrNil(nqVar.vSB)) {
                            memberCardTopCropImageView.setImageDrawable(new ColorDrawable(Color.parseColor(nqVar.vSB)));
                            a.f.b.j.o(imageView, "shadowBgIv");
                            imageView.setVisibility(0);
                        }
                        linkedList2 = nqVar.vSD;
                        a.f.b.j.o(linkedList2, "coupon.coupon_label");
                        list = linkedList2;
                        a.f.b.j.o(linearLayout3, "labelLayout");
                        a(list, linearLayout3);
                        linearLayout = this.kpf;
                        if (linearLayout == null) {
                            a.f.b.j.avw("chpiCouponLayout");
                        }
                        viewGroup.setOnClickListener(new b(this, nsVar, nqVar, linearLayout.getChildCount(), i3));
                        db(viewGroup);
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
            AppMethodBeat.o(89201);
        }

        public final void GY(String str) {
            AppMethodBeat.i(89202);
            a.f.b.j.p(str, "cardId");
            ab.i("MicroMsg.CardHomePageNewUI", "go to card detail: %s", str);
            View view = this.apJ;
            a.f.b.j.o(view, "itemView");
            Intent intent = new Intent(view.getContext(), CardDetailUI.class);
            intent.putExtra("key_card_id", str);
            intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            intent.putExtra("key_from_scene", 3);
            view = this.apJ;
            a.f.b.j.o(view, "itemView");
            view.getContext().startActivity(intent);
            AppMethodBeat.o(89202);
        }

        private void db(View view) {
            AppMethodBeat.i(89203);
            a.f.b.j.p(view, "view");
            LinearLayout linearLayout = this.kpf;
            if (linearLayout == null) {
                a.f.b.j.avw("chpiCouponLayout");
            }
            if (linearLayout.getChildCount() == 0) {
                linearLayout = this.kpf;
                if (linearLayout == null) {
                    a.f.b.j.avw("chpiCouponLayout");
                }
                linearLayout.addView(view);
                AppMethodBeat.o(89203);
                return;
            }
            LinearLayout linearLayout2 = this.kpf;
            if (linearLayout2 == null) {
                a.f.b.j.avw("chpiCouponLayout");
            }
            MarginLayoutParams marginLayoutParams = new MarginLayoutParams(-1, com.tencent.mm.bz.a.fromDPToPix(linearLayout2.getContext(), 84));
            linearLayout = this.kpf;
            if (linearLayout == null) {
                a.f.b.j.avw("chpiCouponLayout");
            }
            marginLayoutParams.topMargin = com.tencent.mm.bz.a.fromDPToPix(linearLayout.getContext(), 8);
            MarginLayoutParams layoutParams = new LayoutParams(marginLayoutParams);
            LinearLayout linearLayout3 = this.kpf;
            if (linearLayout3 == null) {
                a.f.b.j.avw("chpiCouponLayout");
            }
            linearLayout3.addView(view, layoutParams);
            AppMethodBeat.o(89203);
        }

        private void bi(List<? extends nr> list) {
            AppMethodBeat.i(89204);
            a.f.b.j.p(list, "labelList");
            LinearLayout linearLayout = this.kpe;
            if (linearLayout == null) {
                a.f.b.j.avw("chpiLabelLayout");
            }
            linearLayout.removeAllViews();
            if (list.isEmpty()) {
                linearLayout = this.kpe;
                if (linearLayout == null) {
                    a.f.b.j.avw("chpiLabelLayout");
                }
                linearLayout.setVisibility(8);
                AppMethodBeat.o(89204);
                return;
            }
            int i = 0;
            for (nr nrVar : list) {
                linearLayout = this.kpe;
                if (linearLayout == null) {
                    a.f.b.j.avw("chpiLabelLayout");
                }
                Context context = linearLayout.getContext();
                a.f.b.j.o(context, "chpiLabelLayout.context");
                CardLabelTextView cardLabelTextView = new CardLabelTextView(context);
                linearLayout = this.kpe;
                if (linearLayout == null) {
                    a.f.b.j.avw("chpiLabelLayout");
                }
                Context context2 = linearLayout.getContext();
                cardLabelTextView.setTextSize(1, 12.0f);
                cardLabelTextView.setText(nrVar.vSL);
                int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(context2, 4);
                cardLabelTextView.setPadding(fromDPToPix, 0, fromDPToPix, 0);
                cardLabelTextView.setGravity(16);
                if (bo.isNullOrNil(nrVar.vSM)) {
                    cardLabelTextView.setTextColor(-1);
                } else {
                    cardLabelTextView.setTextColor(Color.parseColor(nrVar.vSM));
                }
                if (bo.isNullOrNil(nrVar.vSN)) {
                    cardLabelTextView.setFillColor(0);
                } else {
                    cardLabelTextView.setFillColor(com.tencent.mm.plugin.card.d.l.bT(nrVar.vSN, nrVar.vSQ));
                }
                if (i > 0) {
                    MarginLayoutParams marginLayoutParams = new MarginLayoutParams(-2, -2);
                    marginLayoutParams.leftMargin = com.tencent.mm.bz.a.fromDPToPix(context2, 4);
                    MarginLayoutParams layoutParams = new LayoutParams(marginLayoutParams);
                    LinearLayout linearLayout2 = this.kpe;
                    if (linearLayout2 == null) {
                        a.f.b.j.avw("chpiLabelLayout");
                    }
                    linearLayout2.addView(cardLabelTextView, layoutParams);
                } else {
                    linearLayout = this.kpe;
                    if (linearLayout == null) {
                        a.f.b.j.avw("chpiLabelLayout");
                    }
                    linearLayout.addView(cardLabelTextView);
                }
                i++;
            }
            linearLayout = this.kpe;
            if (linearLayout == null) {
                a.f.b.j.avw("chpiLabelLayout");
            }
            linearLayout.setVisibility(0);
            AppMethodBeat.o(89204);
        }

        private void a(List<? extends np> list, LinearLayout linearLayout) {
            AppMethodBeat.i(89205);
            a.f.b.j.p(list, "couponLabelList");
            a.f.b.j.p(linearLayout, "labelLayout");
            for (np npVar : list) {
                LinearLayout linearLayout2 = this.kpf;
                if (linearLayout2 == null) {
                    a.f.b.j.avw("chpiCouponLayout");
                }
                CardTagTextView cardTagTextView = new CardTagTextView(linearLayout2.getContext());
                linearLayout2 = this.kpf;
                if (linearLayout2 == null) {
                    a.f.b.j.avw("chpiCouponLayout");
                }
                Context context = linearLayout2.getContext();
                cardTagTextView.setMinHeight(com.tencent.mm.bz.a.fromDPToPix(context, 18));
                cardTagTextView.setMinWidth(com.tencent.mm.bz.a.fromDPToPix(context, 56));
                int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(context, 8);
                int fromDPToPix2 = com.tencent.mm.bz.a.fromDPToPix(context, 4);
                cardTagTextView.setPadding(fromDPToPix, fromDPToPix2, fromDPToPix, fromDPToPix2);
                cardTagTextView.setText(npVar.vSs);
                cardTagTextView.setTextSize(1, 10.0f);
                if (bo.isNullOrNil(npVar.vSt)) {
                    cardTagTextView.setTextColor(-1);
                } else {
                    cardTagTextView.setTextColor(Color.parseColor(npVar.vSt));
                }
                if (bo.isNullOrNil(npVar.vSu)) {
                    cardTagTextView.setFillColor(com.tencent.mm.plugin.card.d.l.dJ(WebView.NIGHT_MODE_COLOR, 26));
                } else {
                    cardTagTextView.setFillColor(com.tencent.mm.plugin.card.d.l.bT(npVar.vSu, npVar.vSx));
                }
                linearLayout.addView(cardTagTextView);
            }
            AppMethodBeat.o(89205);
        }

        private final void ti(int i) {
            AppMethodBeat.i(89206);
            a aVar = this.kpo;
            if (aVar == null) {
                a.f.b.j.dWJ();
            }
            ns nsVar = aVar.koU;
            if (nsVar == null) {
                a.f.b.j.dWJ();
            }
            if (!bo.isNullOrNil(nsVar.vTb)) {
                if (!bo.isNullOrNil(nsVar.vTc)) {
                    TextView textView = this.kph;
                    if (textView == null) {
                        a.f.b.j.avw("chpiExpandTv");
                    }
                    textView.setTextColor(Color.parseColor(nsVar.vTc));
                }
                TextView textView2 = this.kph;
                if (textView2 == null) {
                    a.f.b.j.avw("chpiExpandTv");
                }
                textView2.setText(nsVar.vTb);
                ImageView imageView = this.kpi;
                if (imageView == null) {
                    a.f.b.j.avw("chpiExpandIv");
                }
                imageView.setImageResource(R.drawable.ayr);
                LinearLayout linearLayout = this.kpg;
                if (linearLayout == null) {
                    a.f.b.j.avw("chpiExpandLayout");
                }
                linearLayout.setOnClickListener(new h(nsVar, this, i));
            }
            AppMethodBeat.o(89206);
        }

        private final void tj(int i) {
            AppMethodBeat.i(89207);
            a aVar = this.kpo;
            if (aVar == null) {
                a.f.b.j.dWJ();
            }
            ns nsVar = aVar.koU;
            TextView textView = this.kph;
            if (textView == null) {
                a.f.b.j.avw("chpiExpandTv");
            }
            Resources resources = ah.getResources();
            Object[] objArr = new Object[1];
            if (nsVar == null) {
                a.f.b.j.dWJ();
            }
            objArr[0] = Integer.valueOf(nsVar.vTg - nsVar.vTh);
            textView.setText(resources.getString(R.string.aet, objArr));
            LinearLayout linearLayout = this.kpg;
            if (linearLayout == null) {
                a.f.b.j.avw("chpiExpandLayout");
            }
            linearLayout.setOnClickListener(new g(this, i, nsVar));
            ImageView imageView = this.kpi;
            if (imageView == null) {
                a.f.b.j.avw("chpiExpandIv");
            }
            imageView.setImageResource(R.drawable.azj);
            imageView = this.kpi;
            if (imageView == null) {
                a.f.b.j.avw("chpiExpandIv");
            }
            imageView.setVisibility(0);
            AppMethodBeat.o(89207);
        }

        private final void tk(int i) {
            AppMethodBeat.i(89208);
            a aVar = this.kpo;
            if (aVar == null) {
                a.f.b.j.dWJ();
            }
            ns nsVar = aVar.koU;
            TextView textView = this.kph;
            if (textView == null) {
                a.f.b.j.avw("chpiExpandTv");
            }
            textView.setText(ah.getResources().getString(R.string.aer));
            LinearLayout linearLayout = this.kpg;
            if (linearLayout == null) {
                a.f.b.j.avw("chpiExpandLayout");
            }
            linearLayout.setOnClickListener(new f(this, i, nsVar));
            ImageView imageView = this.kpi;
            if (imageView == null) {
                a.f.b.j.avw("chpiExpandIv");
            }
            imageView.setImageResource(R.drawable.azk);
            imageView = this.kpi;
            if (imageView == null) {
                a.f.b.j.avw("chpiExpandIv");
            }
            imageView.setVisibility(0);
            AppMethodBeat.o(89208);
        }

        private final void o(boolean z, int i) {
            AppMethodBeat.i(89209);
            a aVar = this.kpo;
            if (aVar == null) {
                a.f.b.j.dWJ();
            }
            ns nsVar = aVar.koU;
            if (z) {
                if (bo.isNullOrNil(nsVar != null ? nsVar.vTb : null)) {
                    tk(i);
                    AppMethodBeat.o(89209);
                    return;
                }
                ti(i);
                AppMethodBeat.o(89209);
                return;
            }
            tj(i);
            AppMethodBeat.o(89209);
        }

        public static final /* synthetic */ void b(e eVar, int i) {
            AppMethodBeat.i(89212);
            a aVar = eVar.kpo;
            if (aVar == null) {
                a.f.b.j.dWJ();
            }
            ns nsVar = aVar.koU;
            LinearLayout linearLayout = eVar.kpf;
            if (linearLayout == null) {
                a.f.b.j.avw("chpiCouponLayout");
            }
            int childCount = linearLayout.getChildCount();
            if (nsVar == null) {
                a.f.b.j.dWJ();
            }
            if (childCount > nsVar.vTh) {
                String str = "MicroMsg.CardHomePageNewUI";
                String str2 = "collapse count: %s, limit: %s";
                Object[] objArr = new Object[2];
                LinearLayout linearLayout2 = eVar.kpf;
                if (linearLayout2 == null) {
                    a.f.b.j.avw("chpiCouponLayout");
                }
                objArr[0] = Integer.valueOf(linearLayout2.getChildCount());
                objArr[1] = Integer.valueOf(nsVar.vTh);
                ab.d(str, str2, objArr);
                linearLayout = eVar.kpf;
                if (linearLayout == null) {
                    a.f.b.j.avw("chpiCouponLayout");
                }
                childCount = linearLayout.getChildCount() - 1;
                int i2 = nsVar.vTh;
                if (childCount >= i2) {
                    while (true) {
                        LinearLayout linearLayout3 = eVar.kpf;
                        if (linearLayout3 == null) {
                            a.f.b.j.avw("chpiCouponLayout");
                        }
                        linearLayout3.removeViewAt(childCount);
                        if (childCount == i2) {
                            break;
                        }
                        childCount--;
                    }
                }
            }
            eVar.o(false, i);
            AppMethodBeat.o(89212);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageResponse;", "call"})
    static final class h<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ CardHomePageNewUI koY;

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$doGetCardHomePage$2$1$1$1", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$doGetCardHomePage$2$$special$$inlined$apply$lambda$1"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ h kpA;
            final /* synthetic */ nt kpz;

            a(nt ntVar, h hVar) {
                this.kpz = ntVar;
                this.kpA = hVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(89215);
                switch (this.kpz.vTk) {
                    case 1:
                        com.tencent.mm.plugin.card.d.b.a((MMActivity) this.kpA.koY, this.kpz.vTl);
                        AppMethodBeat.o(89215);
                        return;
                    case 2:
                        ny nyVar = this.kpz.vTm;
                        com.tencent.mm.plugin.card.d.b.t(nyVar.tzW, nyVar.ttg, nyVar.tIE);
                        break;
                }
                AppMethodBeat.o(89215);
            }
        }

        h(CardHomePageNewUI cardHomePageNewUI) {
            this.koY = cardHomePageNewUI;
        }

        public final /* synthetic */ Object call(Object obj) {
            int i = 2;
            int i2 = 1;
            AppMethodBeat.i(89216);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.CardHomePageNewUI", "errtype: %s, errcode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (this.koY.gnn != null) {
                Dialog r = this.koY.gnn;
                if (r == null) {
                    a.f.b.j.dWJ();
                }
                r.dismiss();
            }
            this.koY.koQ = null;
            CardHomePageNewUI.t(this.koY).setVisibility(8);
            this.koY.isLoading = false;
            if (aVar.errType == 0 && aVar.errCode == 0) {
                btd btd = aVar.fsy;
                aks aks = (aks) btd;
                ab.i("MicroMsg.CardHomePageNewUI", "retCode: %s", Integer.valueOf(aks.kdT));
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
                    if (!bo.isNullOrNil(aks.wqp)) {
                        this.koY.koD = aks.wqp;
                    }
                    if (this.koY.koC) {
                        CardHomePageNewUI.h(this.koY).fh(false);
                        nt ntVar = aks.wqn;
                        if (!(ntVar == null || bo.isNullOrNil(ntVar.vTj))) {
                            a aVar2;
                            TextView textView = (TextView) CardHomePageNewUI.v(this.koY).findViewById(R.id.afs);
                            a.f.b.j.o(textView, "faqTv");
                            textView.setText(ntVar.vTj);
                            textView.setOnClickListener(new a(ntVar, this));
                            CardHomePageNewUI.h(this.koY).fh(false);
                            CardHomePageNewUI.v(this.koY).setVisibility(0);
                            CardHomePageNewUI.h(this.koY).getAdapter().notifyDataSetChanged();
                            LoadMoreRecyclerView h = CardHomePageNewUI.h(this.koY);
                            a.f.a.a w = this.koY.koP;
                            if (w != null) {
                                aVar2 = new a(w);
                            } else {
                                Object aVar22 = w;
                            }
                            h.post(aVar22);
                        }
                    } else {
                        CardHomePageNewUI.h(this.koY).fh(true);
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
                    this.koY.b(aks.wql, aks.wqm);
                    CardHomePageNewUI.h(this.koY).getAdapter().notifyDataSetChanged();
                } else {
                    if (this.koY.exX) {
                        this.koY.exX = false;
                    }
                    com.tencent.mm.plugin.card.d.l.ai(this.koY, aks.kdU);
                }
                if (aks.wqq == 1) {
                    this.koY.koO = true;
                    this.koY.offset = 0;
                    CardHomePageNewUI cardHomePageNewUI2 = this.koY;
                    if (this.koY.kfk == 1) {
                        i2 = 2;
                    }
                    cardHomePageNewUI2.kfk = i2;
                    CardHomePageNewUI.p(this.koY);
                }
                AppMethodBeat.o(89216);
                return btd;
            }
            CardHomePageNewUI cardHomePageNewUI3 = this.koY;
            com.tencent.mm.ai.a aVar3 = aVar.fsz;
            if (aVar3 == null) {
                a.v vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.plugin.card.model.v2.CgiGetMktCardHomePage");
                AppMethodBeat.o(89216);
                throw vVar;
            }
            if (((com.tencent.mm.plugin.card.model.a.h) aVar3).kfk != 1) {
                i = 1;
            }
            cardHomePageNewUI3.kfk = i;
            if (this.koY.exX) {
                this.koY.exX = false;
            }
            com.tencent.mm.plugin.card.d.l.aj(this.koY, "");
            Object obj2 = y.AUy;
            AppMethodBeat.o(89216);
            return obj2;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class o implements OnMenuItemClickListener {
        final /* synthetic */ CardHomePageNewUI koY;

        o(CardHomePageNewUI cardHomePageNewUI) {
            this.koY = cardHomePageNewUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(89228);
            ab.i("MicroMsg.CardHomePageNewUI", "click sort menu");
            CardHomePageNewUI.n(this.koY);
            AppMethodBeat.o(89228);
            return false;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class f extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ CardHomePageNewUI koY;

        f(CardHomePageNewUI cardHomePageNewUI) {
            this.koY = cardHomePageNewUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(89213);
            ViewGroup viewGroup = (ViewGroup) this.koY.findViewById(R.id.ih);
            TextView textView = (TextView) CardHomePageNewUI.v(this.koY).findViewById(R.id.afs);
            if (viewGroup != null) {
                int height = viewGroup.getHeight();
                int computeVerticalScrollRange = CardHomePageNewUI.h(this.koY).computeVerticalScrollRange();
                int computeVerticalScrollExtent = CardHomePageNewUI.h(this.koY).computeVerticalScrollExtent();
                ab.d("MicroMsg.CardHomePageNewUI", "range: %s, extent: %s, contentHeight", Integer.valueOf(computeVerticalScrollRange), Integer.valueOf(computeVerticalScrollExtent), Integer.valueOf(height));
                if (height > computeVerticalScrollRange) {
                    height -= computeVerticalScrollRange;
                    if (height >= 0) {
                        CardHomePageNewUI.v(this.koY).setPadding(0, height + CardHomePageNewUI.v(this.koY).getPaddingTop(), 0, CardHomePageNewUI.v(this.koY).getPaddingBottom());
                    }
                }
            }
            a.f.b.j.o(textView, "faqTv");
            textView.setVisibility(0);
            y yVar = y.AUy;
            AppMethodBeat.o(89213);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class i<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ CardHomePageNewUI koY;
        final /* synthetic */ String kpy;

        i(CardHomePageNewUI cardHomePageNewUI, String str) {
            this.koY = cardHomePageNewUI;
            this.kpy = str;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(89217);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.CardHomePageNewUI", "errtype: %s, errcode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                agq agq = (agq) aVar.fsy;
                ab.i("MicroMsg.CardHomePageNewUI", "retCode: %s, refresh: %s", Integer.valueOf(agq.kdT), Integer.valueOf(agq.wnl));
                d o;
                String str;
                ns nsVar;
                if (agq.kdT != 0) {
                    com.tencent.mm.plugin.card.d.l.ai(this.koY, agq.kdU);
                } else if (agq.wnl == 1) {
                    this.koY.koO = true;
                    this.koY.offset = 0;
                    CardHomePageNewUI.p(this.koY);
                } else if (this.koY.koK != 0) {
                    o = CardHomePageNewUI.o(this.koY);
                    str = this.kpy;
                    nsVar = agq.wnk;
                    a.f.b.j.o(nsVar, "card_pkg_mch_info");
                    o.a(str, nsVar);
                } else if (agq.wnk.vTa.size() == 0) {
                    CardHomePageNewUI.o(this.koY).GW(this.kpy);
                } else {
                    o = CardHomePageNewUI.o(this.koY);
                    str = this.kpy;
                    nsVar = agq.wnk;
                    a.f.b.j.o(nsVar, "card_pkg_mch_info");
                    o.a(str, nsVar);
                }
            } else {
                com.tencent.mm.plugin.card.d.l.aj(this.koY, "");
            }
            this.koY.koK = -1;
            y yVar = y.AUy;
            AppMethodBeat.o(89217);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0013"}, dWq = {"com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "plugin-card_release"})
    public static final class j extends android.support.v7.widget.RecyclerView.h {
        private final Paint aFY = new Paint();
        final /* synthetic */ CardHomePageNewUI koY;

        j(CardHomePageNewUI cardHomePageNewUI) {
            this.koY = cardHomePageNewUI;
            AppMethodBeat.i(89220);
            this.aFY.setColor(Color.parseColor("#19000000"));
            this.aFY.setStyle(Style.FILL);
            this.aFY.setFlags(1);
            AppMethodBeat.o(89220);
        }

        public final void a(Rect rect, View view, RecyclerView recyclerView, s sVar) {
            AppMethodBeat.i(89218);
            super.a(rect, view, recyclerView, sVar);
            Integer valueOf = recyclerView != null ? Integer.valueOf(RecyclerView.bo(view)) : null;
            int itemCount = CardHomePageNewUI.o(this.koY).getItemCount() - 1;
            if (valueOf != null && valueOf.intValue() == itemCount) {
                ab.d("MicroMsg.CardHomePageNewUI", "is last");
                if (rect != null) {
                    c cVar = CardHomePageNewUI.koT;
                    rect.bottom = CardHomePageNewUI.cjn;
                    AppMethodBeat.o(89218);
                    return;
                }
                AppMethodBeat.o(89218);
            } else if (rect != null) {
                rect.bottom = 1;
                AppMethodBeat.o(89218);
            } else {
                AppMethodBeat.o(89218);
            }
        }

        public final void a(Canvas canvas, RecyclerView recyclerView, s sVar) {
            AppMethodBeat.i(89219);
            super.a(canvas, recyclerView, sVar);
            LoadMoreRecyclerView h = CardHomePageNewUI.h(this.koY);
            if (h != null) {
                int paddingLeft = h.getPaddingLeft();
                c cVar = CardHomePageNewUI.koT;
                int bej = paddingLeft + CardHomePageNewUI.koS;
                int width = h.getWidth() - h.getPaddingRight();
                int childCount = h.getChildCount();
                paddingLeft = 0;
                while (true) {
                    int i = paddingLeft;
                    if (i < childCount - 1) {
                        View childAt = h.getChildAt(i);
                        a.f.b.j.o(childAt, "child");
                        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                        if (layoutParams == null) {
                            a.v vVar = new a.v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
                            AppMethodBeat.o(89219);
                            throw vVar;
                        }
                        int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) layoutParams).bottomMargin;
                        if (i == childCount - 1) {
                            c cVar2 = CardHomePageNewUI.koT;
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
                        AppMethodBeat.o(89219);
                        return;
                    }
                }
            }
            AppMethodBeat.o(89219);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
    static final class l implements com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a {
        final /* synthetic */ CardHomePageNewUI koY;

        l(CardHomePageNewUI cardHomePageNewUI) {
            this.koY = cardHomePageNewUI;
        }

        public final void I(View view, int i) {
            AppMethodBeat.i(89222);
            a th = CardHomePageNewUI.o(this.koY).th(i);
            if (th != null) {
                ab.i("MicroMsg.CardHomePageNewUI", "click type: %s", Integer.valueOf(th.type));
                switch (th.type) {
                    case 2:
                        this.koY.koJ = true;
                        this.koY.koK = 1;
                        this.koY.koN = th.koU;
                        ns nsVar = th.koU;
                        if (nsVar == null) {
                            a.f.b.j.dWJ();
                        }
                        switch (nsVar.vSW) {
                            case 1:
                                MMActivity mMActivity = this.koY;
                                ns nsVar2 = th.koU;
                                if (nsVar2 == null) {
                                    a.f.b.j.dWJ();
                                }
                                com.tencent.mm.plugin.card.d.b.a(mMActivity, nsVar2.vSX);
                                break;
                            case 2:
                                nsVar = th.koU;
                                if (nsVar == null) {
                                    a.f.b.j.dWJ();
                                }
                                ny nyVar = nsVar.vSY;
                                com.tencent.mm.plugin.card.d.b.t(nyVar.tzW, nyVar.ttg, nyVar.tIE);
                                break;
                        }
                        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                        Object[] objArr = new Object[7];
                        objArr[0] = Integer.valueOf(2);
                        ns nsVar3 = th.koU;
                        if (nsVar3 == null) {
                            a.f.b.j.dWJ();
                        }
                        objArr[1] = nsVar3.vSR;
                        objArr[2] = Integer.valueOf(0);
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = Integer.valueOf(1);
                        objArr[5] = Integer.valueOf(i);
                        objArr[6] = Integer.valueOf(this.koY.kfk);
                        hVar.e(16324, objArr);
                        AppMethodBeat.o(89222);
                        return;
                    case 4:
                        ab.i("MicroMsg.CardHomePageNewUI", "click ticket item");
                        this.koY.startActivity(new Intent(this.koY, CardTicketListUI.class));
                        com.tencent.mm.plugin.report.service.h.pYm.e(16322, Integer.valueOf(5));
                        AppMethodBeat.o(89222);
                        return;
                    case 5:
                        com.tencent.mm.plugin.report.service.h.pYm.e(16322, Integer.valueOf(13));
                        AppMethodBeat.o(89222);
                        return;
                    default:
                        AppMethodBeat.o(89222);
                        return;
                }
            }
            AppMethodBeat.o(89222);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;)V", "element", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "getElement", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "setElement", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;)V", "expandState", "", "getExpandState", "()Z", "setExpandState", "(Z)V", "hasRender", "getHasRender", "setHasRender", "sectionTitle", "", "getSectionTitle", "()Ljava/lang/String;", "setSectionTitle", "(Ljava/lang/String;)V", "type", "", "getType", "()I", "setType", "(I)V", "plugin-card_release"})
    public final class a {
        ns koU;
        public String koV;
        boolean koW;
        boolean koX;
        int type;

        public final void GV(String str) {
            AppMethodBeat.i(89179);
            a.f.b.j.p(str, "<set-?>");
            this.koV = str;
            AppMethodBeat.o(89179);
        }

        public final String bek() {
            AppMethodBeat.i(89178);
            String str = this.koV;
            if (str == null) {
                a.f.b.j.avw("sectionTitle");
            }
            AppMethodBeat.o(89178);
            return str;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardSpan;", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "linkColor", "", "bgColor", "listener", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;IILcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;)V", "onClick", "", "widget", "Landroid/view/View;", "plugin-card_release"})
    public final class b extends com.tencent.mm.pluginsdk.ui.e.n {
        final /* synthetic */ CardHomePageNewUI koY;

        public b(CardHomePageNewUI cardHomePageNewUI, int i, com.tencent.mm.pluginsdk.ui.e.h hVar) {
            a.f.b.j.p(hVar, CastExtraArgs.LISTENER);
            this.koY = cardHomePageNewUI;
            super((int) WebView.NIGHT_MODE_COLOR, i);
            AppMethodBeat.i(89181);
            this.vsv = hVar;
            AppMethodBeat.o(89181);
        }

        public final void onClick(View view) {
            AppMethodBeat.i(89180);
            a.f.b.j.p(view, "widget");
            if (this.vsv != null) {
                this.vsv.a(view, null);
            }
            AppMethodBeat.o(89180);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$Companion;", "", "()V", "DP_1", "", "getDP_1", "()I", "DP_16", "getDP_16", "FOOTER_HEIGHT", "getFOOTER_HEIGHT", "LIST_ITEM_TYPE_CARD_TITLE", "LIST_ITEM_TYPE_FIRST", "LIST_ITEM_TYPE_STORE", "LIST_ITEM_TYPE_TICKET", "LIST_ITEM_TYPE_TITLE", "LIST_ITEM_TYPE_UNDER", "SORT_TYPE_DISTANCE", "SORT_TYPE_TIME", "TAG", "", "plugin-card_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b) {
            this();
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\bR\u00020\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0014\u0010\r\u001a\b\u0018\u00010\bR\u00020\u00032\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\u001c\u0010\u0015\u001a\u00020\u00062\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\u0015\u001a\u00020\u00062\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\f\u001a\u00020\n2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u001c\u0010\u001a\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u001f\u001a\u00020\u0006J\u0016\u0010 \u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0014¨\u0006\""}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;)V", "appendUnderList", "", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "getItemCount", "", "getItemViewType", "position", "getModelByPos", "getPosByMerchantId", "merchantId", "", "moveStoreToUnderList", "", "element", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "onBindViewHolder", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeModelByMId", "removeTitleSection", "replaceModelByMId", "mchInfo", "plugin-card_release"})
    public final class d extends android.support.v7.widget.RecyclerView.a<e> {
        public final /* synthetic */ void a(v vVar, int i, List list) {
            int i2;
            AppMethodBeat.i(89186);
            e eVar = (e) vVar;
            a.f.b.j.p(eVar, "holder");
            a.f.b.j.p(list, "payloads");
            if (list.isEmpty()) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (i2 == 0 || !a.f.b.j.j(list.get(0), Boolean.TRUE)) {
                super.a(eVar, i, list);
                AppMethodBeat.o(89186);
                return;
            }
            a th = th(i);
            if (th != null) {
                eVar.a(th, i);
                AppMethodBeat.o(89186);
                return;
            }
            AppMethodBeat.o(89186);
        }

        public final int getItemCount() {
            int size;
            int size2;
            int i;
            int i2;
            int i3 = 1;
            AppMethodBeat.i(89183);
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
            AppMethodBeat.o(89183);
            return size;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(89184);
            a th = th(i);
            if (th != null) {
                int i2 = th.type;
                AppMethodBeat.o(89184);
                return i2;
            }
            AppMethodBeat.o(89184);
            return 3;
        }

        public final a th(int i) {
            int i2 = 1;
            AppMethodBeat.i(89187);
            String str = "MicroMsg.CardHomePageNewUI";
            String str2 = "pos: %s, sSize: %s, uSize: %s, title: %s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(i);
            ArrayList a = CardHomePageNewUI.this.koE;
            objArr[1] = a != null ? Integer.valueOf(a.size()) : null;
            a = CardHomePageNewUI.this.koE;
            objArr[2] = a != null ? Integer.valueOf(a.size()) : null;
            objArr[3] = Boolean.valueOf(CardHomePageNewUI.this.koG != null);
            ab.d(str, str2, objArr);
            a e = CardHomePageNewUI.this.koH;
            if (e == null) {
                i2 = 0;
            } else if (i == 0) {
                AppMethodBeat.o(89187);
                return e;
            }
            e = CardHomePageNewUI.this.koI;
            if (e != null) {
                if (i == i2) {
                    AppMethodBeat.o(89187);
                    return e;
                }
                i2++;
            }
            a = CardHomePageNewUI.this.koE;
            if (a != null) {
                if (i - i2 < a.size()) {
                    e = (a) a.get(i - i2);
                    AppMethodBeat.o(89187);
                    return e;
                }
                i2 = a.size() - 1;
            }
            if (CardHomePageNewUI.this.koG != null) {
                i2++;
                if (i == i2) {
                    e = CardHomePageNewUI.this.koG;
                    AppMethodBeat.o(89187);
                    return e;
                }
            }
            a = CardHomePageNewUI.this.koF;
            if (a == null || i <= i2 || i > a.size() + i2) {
                AppMethodBeat.o(89187);
                return null;
            }
            e = (a) a.get((i - i2) - 1);
            AppMethodBeat.o(89187);
            return e;
        }

        public final void GW(String str) {
            a aVar;
            ns nsVar;
            AppMethodBeat.i(89188);
            a.f.b.j.p(str, "merchantId");
            Iterator it = CardHomePageNewUI.this.koE.iterator();
            while (it.hasNext()) {
                aVar = (a) it.next();
                nsVar = aVar.koU;
                if (a.f.b.j.j(nsVar != null ? nsVar.vSR : null, str)) {
                    CardHomePageNewUI.this.koE.remove(aVar);
                    CardHomePageNewUI.h(CardHomePageNewUI.this).getAdapter().notifyDataSetChanged();
                    AppMethodBeat.o(89188);
                    return;
                }
            }
            it = CardHomePageNewUI.this.koF.iterator();
            while (it.hasNext()) {
                aVar = (a) it.next();
                nsVar = aVar.koU;
                if (a.f.b.j.j(nsVar != null ? nsVar.vSR : null, str)) {
                    CardHomePageNewUI.this.koF.remove(aVar);
                    if (CardHomePageNewUI.this.koF.size() == 0) {
                        CardHomePageNewUI.this.koG = null;
                        CardHomePageNewUI.h(CardHomePageNewUI.this).getAdapter().notifyDataSetChanged();
                    }
                    AppMethodBeat.o(89188);
                    return;
                }
            }
            AppMethodBeat.o(89188);
        }

        private int GX(String str) {
            int i;
            int i2;
            ns nsVar;
            int i3 = 0;
            AppMethodBeat.i(89189);
            a.f.b.j.p(str, "merchantId");
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
            for (a aVar : CardHomePageNewUI.this.koE) {
                nsVar = aVar.koU;
                if (a.f.b.j.j(nsVar != null ? nsVar.vSR : null, str)) {
                    i = i2 + i4;
                    AppMethodBeat.o(89189);
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
            for (a aVar2 : CardHomePageNewUI.this.koF) {
                Object obj;
                nsVar = aVar2.koU;
                if (nsVar != null) {
                    obj = nsVar.vSR;
                } else {
                    obj = null;
                }
                if (a.f.b.j.j(obj, str)) {
                    i = (i2 + i3) + 1;
                    AppMethodBeat.o(89189);
                    return i;
                }
                i3++;
            }
            AppMethodBeat.o(89189);
            return -1;
        }

        public final void a(String str, ns nsVar) {
            a aVar;
            ns nsVar2;
            Object obj;
            int GX;
            AppMethodBeat.i(89190);
            a.f.b.j.p(str, "merchantId");
            a.f.b.j.p(nsVar, "mchInfo");
            Iterator it = CardHomePageNewUI.this.koE.iterator();
            while (it.hasNext()) {
                aVar = (a) it.next();
                nsVar2 = aVar.koU;
                if (nsVar2 != null) {
                    obj = nsVar2.vSR;
                } else {
                    obj = null;
                }
                if (a.f.b.j.j(obj, str)) {
                    aVar.koU = nsVar;
                    GX = GX(str);
                    if (GX >= 0) {
                        CardHomePageNewUI.h(CardHomePageNewUI.this).getAdapter().b(GX, Boolean.TRUE);
                    }
                    AppMethodBeat.o(89190);
                    return;
                }
            }
            it = CardHomePageNewUI.this.koF.iterator();
            while (it.hasNext()) {
                aVar = (a) it.next();
                nsVar2 = aVar.koU;
                if (nsVar2 != null) {
                    obj = nsVar2.vSR;
                } else {
                    obj = null;
                }
                if (a.f.b.j.j(obj, str)) {
                    aVar.koU = nsVar;
                    GX = GX(str);
                    if (GX >= 0) {
                        CardHomePageNewUI.h(CardHomePageNewUI.this).getAdapter().b(GX, Boolean.TRUE);
                    }
                    AppMethodBeat.o(89190);
                    return;
                }
            }
            AppMethodBeat.o(89190);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032&\u0010\u0005\u001a\"\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0006¨\u0006\u00010\u0006¨\u0006\u0001H\n¢\u0006\u0002\b\b"}, dWq = {"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
    static final class k implements com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a {
        final /* synthetic */ CardHomePageNewUI koY;

        k(CardHomePageNewUI cardHomePageNewUI) {
            this.koY = cardHomePageNewUI;
        }

        public final void aMC() {
            AppMethodBeat.i(89221);
            CardHomePageNewUI.p(this.koY);
            AppMethodBeat.o(89221);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
    static final class m implements com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b {
        final /* synthetic */ CardHomePageNewUI koY;

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$4$1$1"})
        static final class a implements com.tencent.mm.ui.base.n.c {
            final /* synthetic */ int iPU;
            final /* synthetic */ m kpB;

            a(m mVar, int i) {
                this.kpB = mVar;
                this.iPU = i;
            }

            public final void a(com.tencent.mm.ui.base.l lVar) {
                AppMethodBeat.i(89223);
                lVar.e(1, this.kpB.koY.getString(R.string.p4));
                AppMethodBeat.o(89223);
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$4$1$2"})
        static final class b implements com.tencent.mm.ui.base.n.d {
            final /* synthetic */ int iPU;
            final /* synthetic */ m kpB;
            final /* synthetic */ a kpC;

            @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$4$1$2$1"})
            /* renamed from: com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI$m$b$1 */
            static final class AnonymousClass1 implements OnClickListener {
                final /* synthetic */ b kpD;

                AnonymousClass1(b bVar) {
                    this.kpD = bVar;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(89224);
                    CardHomePageNewUI cardHomePageNewUI = this.kpD.kpB.koY;
                    ns nsVar = this.kpD.kpC.koU;
                    if (nsVar == null) {
                        a.f.b.j.dWJ();
                    }
                    String str = nsVar.vSR;
                    a.f.b.j.o(str, "element!!.card_pack_merchant_id");
                    a.f.b.j.p(str, "merchantId");
                    ab.i("MicroMsg.CardHomePageNewUI", "do delete merchant: %s", str);
                    new com.tencent.mm.plugin.card.model.a.e(str).acy().b((com.tencent.mm.vending.c.a) new g(cardHomePageNewUI, str));
                    dialogInterface.dismiss();
                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                    Object[] objArr = new Object[7];
                    objArr[0] = Integer.valueOf(2);
                    ns nsVar2 = this.kpD.kpC.koU;
                    if (nsVar2 == null) {
                        a.f.b.j.dWJ();
                    }
                    objArr[1] = nsVar2.vSR;
                    objArr[2] = Integer.valueOf(0);
                    objArr[3] = Integer.valueOf(0);
                    objArr[4] = Integer.valueOf(9);
                    objArr[5] = Integer.valueOf(this.kpD.iPU);
                    objArr[6] = Integer.valueOf(this.kpD.kpB.koY.kfk);
                    hVar.e(16324, objArr);
                    AppMethodBeat.o(89224);
                }
            }

            b(a aVar, m mVar, int i) {
                this.kpC = aVar;
                this.kpB = mVar;
                this.iPU = i;
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(89225);
                a.f.b.j.o(menuItem, "menuItem");
                switch (menuItem.getItemId()) {
                    case 1:
                        com.tencent.mm.ui.base.h.a((Context) this.kpB.koY.dxU(), this.kpB.koY.getString(R.string.af0), "", false, (OnClickListener) new AnonymousClass1(this));
                        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                        Object[] objArr = new Object[7];
                        objArr[0] = Integer.valueOf(2);
                        ns nsVar = this.kpC.koU;
                        if (nsVar == null) {
                            a.f.b.j.dWJ();
                        }
                        objArr[1] = nsVar.vSR;
                        objArr[2] = Integer.valueOf(0);
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = Integer.valueOf(8);
                        objArr[5] = Integer.valueOf(this.iPU);
                        objArr[6] = Integer.valueOf(this.kpB.koY.kfk);
                        hVar.e(16324, objArr);
                        break;
                }
                AppMethodBeat.o(89225);
            }
        }

        m(CardHomePageNewUI cardHomePageNewUI) {
            this.koY = cardHomePageNewUI;
        }

        public final boolean L(View view, int i) {
            AppMethodBeat.i(89226);
            a th = CardHomePageNewUI.o(this.koY).th(i);
            if (th != null) {
                ab.i("MicroMsg.CardHomePageNewUI", "long click type: %s", Integer.valueOf(th.type));
                switch (th.type) {
                    case 2:
                        com.tencent.mm.ui.tools.j jVar = new com.tencent.mm.ui.tools.j(this.koY.dxU());
                        jVar.a((com.tencent.mm.ui.base.n.c) new a(this, i));
                        jVar.a((com.tencent.mm.ui.base.n.d) new b(th, this, i));
                        jVar.cuu();
                        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                        Object[] objArr = new Object[7];
                        objArr[0] = Integer.valueOf(2);
                        ns nsVar = th.koU;
                        if (nsVar == null) {
                            a.f.b.j.dWJ();
                        }
                        objArr[1] = nsVar.vSR;
                        objArr[2] = Integer.valueOf(0);
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = Integer.valueOf(7);
                        objArr[5] = Integer.valueOf(i);
                        objArr[6] = Integer.valueOf(this.koY.kfk);
                        hVar.e(16324, objArr);
                        break;
                }
            }
            AppMethodBeat.o(89226);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardHomePageNewUI() {
        AppMethodBeat.i(89243);
        AppMethodBeat.o(89243);
    }

    public static final /* synthetic */ LoadMoreRecyclerView h(CardHomePageNewUI cardHomePageNewUI) {
        AppMethodBeat.i(89245);
        LoadMoreRecyclerView loadMoreRecyclerView = cardHomePageNewUI.kou;
        if (loadMoreRecyclerView == null) {
            a.f.b.j.avw("mRecyclerView");
        }
        AppMethodBeat.o(89245);
        return loadMoreRecyclerView;
    }

    public static final /* synthetic */ d o(CardHomePageNewUI cardHomePageNewUI) {
        AppMethodBeat.i(89247);
        d dVar = cardHomePageNewUI.kov;
        if (dVar == null) {
            a.f.b.j.avw("mHomePageAdapter");
        }
        AppMethodBeat.o(89247);
        return dVar;
    }

    public static final /* synthetic */ void p(CardHomePageNewUI cardHomePageNewUI) {
        AppMethodBeat.i(89248);
        cardHomePageNewUI.beh();
        AppMethodBeat.o(89248);
    }

    public static final /* synthetic */ ViewGroup t(CardHomePageNewUI cardHomePageNewUI) {
        AppMethodBeat.i(89249);
        ViewGroup viewGroup = cardHomePageNewUI.koA;
        if (viewGroup == null) {
            a.f.b.j.avw("mLoadingView2");
        }
        AppMethodBeat.o(89249);
        return viewGroup;
    }

    public static final /* synthetic */ ViewGroup v(CardHomePageNewUI cardHomePageNewUI) {
        AppMethodBeat.i(89250);
        ViewGroup viewGroup = cardHomePageNewUI.kox;
        if (viewGroup == null) {
            a.f.b.j.avw("mFooterView");
        }
        AppMethodBeat.o(89250);
        return viewGroup;
    }

    static {
        AppMethodBeat.i(89244);
        AppMethodBeat.o(89244);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(89234);
        dxR();
        super.onCreate(bundle);
        xE(Color.parseColor("#ededed"));
        dyb();
        setMMTitle((int) R.string.aev);
        this.scene = getIntent().getIntExtra("key_home_page_from_scene", 0);
        initView();
        com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
        a.f.b.j.o(RP, "MMKernel.storage()");
        this.koM = RP.Ry().getInt(com.tencent.mm.storage.ac.a.USERINFO_CARD_ENTRANCE_SHOW_SORT_INT_SYNC, 0);
        RP = com.tencent.mm.kernel.g.RP();
        a.f.b.j.o(RP, "MMKernel.storage()");
        this.kfk = RP.Ry().getInt(com.tencent.mm.storage.ac.a.USERINFO_CARD_ENTRANCE_SORT_TYPE_INT_SYNC, 0);
        if (this.koM == 1) {
            com.tencent.mm.plugin.report.service.h.pYm.e(16322, Integer.valueOf(14));
        }
        ab.i("MicroMsg.CardHomePageNewUI", "on create, scene: %s", Integer.valueOf(this.scene));
        setBackBtn(new n(this));
        if (this.scene == 1 && this.koM == 1) {
            addTextOptionMenu(0, getString(R.string.g69), new o(this));
        }
        com.tencent.mm.plugin.report.service.h.pYm.e(16322, Integer.valueOf(4));
        ((com.tencent.mm.pluginsdk.wallet.b) com.tencent.mm.kernel.g.K(com.tencent.mm.pluginsdk.wallet.b.class)).eA(8, 2);
        AppMethodBeat.o(89234);
    }

    public final void onDestroy() {
        b bVar;
        ns nsVar;
        String bek;
        AppMethodBeat.i(89235);
        super.onDestroy();
        com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
        a.f.b.j.o(RP, "MMKernel.storage()");
        RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CARD_ENTRANCE_SORT_TYPE_INT_SYNC, Integer.valueOf(this.kfk));
        if (this.koQ != null) {
            com.tencent.mm.plugin.card.model.a.h hVar = this.koQ;
            if (hVar == null) {
                a.f.b.j.dWJ();
            }
            hVar.cancel();
            this.koQ = null;
        }
        LoadMoreRecyclerView loadMoreRecyclerView = this.kou;
        if (loadMoreRecyclerView == null) {
            a.f.b.j.avw("mRecyclerView");
        }
        a.f.a.a aVar = this.koP;
        if (aVar != null) {
            bVar = new b(aVar);
        } else {
            Object bVar2 = aVar;
        }
        loadMoreRecyclerView.removeCallbacks(bVar2);
        com.tencent.mm.plugin.card.b.k.baK();
        ab.i("MicroMsg.CardHomePageNewUI", "do save snap shot");
        nv nvVar = new nv();
        nvVar.vTp = new LinkedList();
        Iterator it = this.koE.iterator();
        while (it.hasNext()) {
            nsVar = ((a) it.next()).koU;
            if (nsVar != null) {
                nvVar.vTp.add(nsVar);
            }
        }
        nw nwVar = new nw();
        a aVar2 = this.koG;
        if (aVar2 != null) {
            bek = aVar2.bek();
        } else {
            bek = null;
        }
        nwVar.vTq = bek;
        nwVar.vTp = new LinkedList();
        Iterator it2 = this.koF.iterator();
        while (it2.hasNext()) {
            nsVar = ((a) it2.next()).koU;
            if (nsVar != null) {
                nwVar.vTp.add(nsVar);
            }
        }
        com.tencent.mm.plugin.card.model.a.a.a aVar3 = com.tencent.mm.plugin.card.model.a.a.kfc;
        a.f.b.j.p(nvVar, "storeList");
        a.f.b.j.p(nwVar, "underList");
        ab.i(com.tencent.mm.plugin.card.model.a.a.TAG, "save home page snapshot");
        byte[] toByteArray = nvVar.toByteArray();
        a.f.b.j.o(toByteArray, "storeList.toByteArray()");
        Object str = new String(toByteArray, a.k.d.ISO_8859_1);
        RP = com.tencent.mm.kernel.g.RP();
        a.f.b.j.o(RP, "MMKernel.storage()");
        RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CARD_STORE_LIST_STRING_SYNC, str);
        toByteArray = nwVar.toByteArray();
        a.f.b.j.o(toByteArray, "underList.toByteArray()");
        str = new String(toByteArray, a.k.d.ISO_8859_1);
        RP = com.tencent.mm.kernel.g.RP();
        a.f.b.j.o(RP, "MMKernel.storage()");
        RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CARD_UNDER_LIST_STRING_SYNC, str);
        AppMethodBeat.o(89235);
    }

    public final void onResume() {
        AppMethodBeat.i(89236);
        super.onResume();
        if (!(!this.koJ || this.koN == null || this.koK == -1)) {
            ns nsVar = this.koN;
            if (nsVar == null) {
                a.f.b.j.dWJ();
            }
            String str = nsVar.vSR;
            a.f.b.j.o(str, "clickedCardHomePageElement!!.card_pack_merchant_id");
            nsVar = this.koN;
            if (nsVar == null) {
                a.f.b.j.dWJ();
            }
            long j = nsVar.vTi;
            ab.i("MicroMsg.CardHomePageNewUI", "do get mch infoset: %s", str);
            new com.tencent.mm.plugin.card.model.a.g(str, j, (double) this.cEB, (double) this.cGm, this.kfk).acy().b((com.tencent.mm.vending.c.a) new i(this, str));
            this.koJ = false;
            this.koN = null;
        }
        AppMethodBeat.o(89236);
    }

    public final int getLayoutId() {
        return R.layout.j5;
    }

    public final void initView() {
        AppMethodBeat.i(89237);
        View findViewById = findViewById(R.id.ag1);
        a.f.b.j.o(findViewById, "findViewById(R.id.chpu_rv)");
        this.kou = (LoadMoreRecyclerView) findViewById;
        LoadMoreRecyclerView loadMoreRecyclerView = this.kou;
        if (loadMoreRecyclerView == null) {
            a.f.b.j.avw("mRecyclerView");
        }
        loadMoreRecyclerView.setLayoutManager(new LinearLayoutManager());
        this.kov = new d();
        loadMoreRecyclerView = this.kou;
        if (loadMoreRecyclerView == null) {
            a.f.b.j.avw("mRecyclerView");
        }
        d dVar = this.kov;
        if (dVar == null) {
            a.f.b.j.avw("mHomePageAdapter");
        }
        loadMoreRecyclerView.setAdapter(dVar);
        findViewById = findViewById(R.id.afq);
        a.f.b.j.o(findViewById, "findViewById(R.id.chpe_root_layout)");
        this.koy = (ViewGroup) findViewById;
        LayoutInflater from = LayoutInflater.from(this);
        LoadMoreRecyclerView loadMoreRecyclerView2 = this.kou;
        if (loadMoreRecyclerView2 == null) {
            a.f.b.j.avw("mRecyclerView");
        }
        findViewById = from.inflate(R.layout.j2, loadMoreRecyclerView2, false);
        a.v vVar;
        if (findViewById == null) {
            vVar = new a.v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(89237);
            throw vVar;
        }
        this.kow = (ViewGroup) findViewById;
        from = LayoutInflater.from(this);
        loadMoreRecyclerView2 = this.kou;
        if (loadMoreRecyclerView2 == null) {
            a.f.b.j.avw("mRecyclerView");
        }
        findViewById = from.inflate(R.layout.j0, loadMoreRecyclerView2, false);
        if (findViewById == null) {
            vVar = new a.v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(89237);
            throw vVar;
        }
        this.kox = (ViewGroup) findViewById;
        findViewById = findViewById(R.id.ag2);
        a.f.b.j.o(findViewById, "findViewById(R.id.chpu_loading_layout)");
        this.koA = (ViewGroup) findViewById;
        loadMoreRecyclerView = this.kou;
        if (loadMoreRecyclerView == null) {
            a.f.b.j.avw("mRecyclerView");
        }
        ViewGroup viewGroup = this.kow;
        if (viewGroup == null) {
            a.f.b.j.avw("mLoadingView");
        }
        loadMoreRecyclerView.setLoadingView((View) viewGroup);
        loadMoreRecyclerView = this.kou;
        if (loadMoreRecyclerView == null) {
            a.f.b.j.avw("mRecyclerView");
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
        this.koz = new j(this);
        loadMoreRecyclerView2 = this.kou;
        if (loadMoreRecyclerView2 == null) {
            a.f.b.j.avw("mRecyclerView");
        }
        android.support.v7.widget.RecyclerView.h hVar = this.koz;
        if (hVar == null) {
            a.f.b.j.avw("mDivider");
        }
        loadMoreRecyclerView2.b(hVar);
        loadMoreRecyclerView = this.kou;
        if (loadMoreRecyclerView == null) {
            a.f.b.j.avw("mRecyclerView");
        }
        loadMoreRecyclerView.setOnLoadingStateChangedListener(new k(this));
        loadMoreRecyclerView = this.kou;
        if (loadMoreRecyclerView == null) {
            a.f.b.j.avw("mRecyclerView");
        }
        loadMoreRecyclerView.setOnItemClickListener(new l(this));
        loadMoreRecyclerView = this.kou;
        if (loadMoreRecyclerView == null) {
            a.f.b.j.avw("mRecyclerView");
        }
        loadMoreRecyclerView.setOnItemLongClickListener(new m(this));
        bef();
        AppMethodBeat.o(89237);
    }

    public final void P(int i, boolean z) {
        AppMethodBeat.i(89238);
        ab.i("MicroMsg.CardHomePageNewUI", "location finish: [%s, %s], ret: %s, isOk: %s", Float.valueOf(this.cEB), Float.valueOf(this.cGm), Integer.valueOf(i), Boolean.valueOf(z));
        if (this.exX) {
            if (i == -2) {
                this.kfk = 2;
            }
            beh();
            AppMethodBeat.o(89238);
            return;
        }
        if (!z) {
            bep();
        }
        AppMethodBeat.o(89238);
    }

    private final void bef() {
        AppMethodBeat.i(89239);
        if (!beg() && this.koE.isEmpty() && this.koF.isEmpty()) {
            ab.i("MicroMsg.CardHomePageNewUI", "show init view");
            a aVar = new a();
            aVar.type = 3;
            a aVar2 = new a();
            aVar2.type = 3;
            this.koE.add(aVar);
            this.koE.add(aVar2);
        }
        LoadMoreRecyclerView loadMoreRecyclerView = this.kou;
        if (loadMoreRecyclerView == null) {
            a.f.b.j.avw("mRecyclerView");
        }
        loadMoreRecyclerView.getAdapter().notifyDataSetChanged();
        AppMethodBeat.o(89239);
    }

    private boolean beg() {
        AppMethodBeat.i(89240);
        nv nvVar = new nv();
        nw nwVar = new nw();
        com.tencent.mm.plugin.card.model.a.a.a aVar = com.tencent.mm.plugin.card.model.a.a.kfc;
        boolean a = com.tencent.mm.plugin.card.model.a.a.a.a(nvVar, nwVar);
        b(nvVar, nwVar);
        AppMethodBeat.o(89240);
        return a;
    }

    public final void b(nv nvVar, nw nwVar) {
        LinkedList linkedList;
        Iterator it;
        ns nsVar;
        a aVar;
        a aVar2;
        AppMethodBeat.i(89241);
        if (nvVar != null) {
            linkedList = nvVar.vTp;
            a.f.b.j.o(linkedList, "card_home_page_element");
            if ((!((Collection) linkedList).isEmpty() ? 1 : 0) != 0) {
                it = nvVar.vTp.iterator();
                while (it.hasNext()) {
                    nsVar = (ns) it.next();
                    aVar = new a();
                    aVar.koU = nsVar;
                    aVar.type = 0;
                    this.koE.add(aVar);
                }
            }
        }
        if (nwVar != null) {
            linkedList = nwVar.vTp;
            a.f.b.j.o(linkedList, "card_home_page_element");
            if ((!((Collection) linkedList).isEmpty() ? 1 : 0) != 0) {
                if (bo.isNullOrNil(nwVar.vTq)) {
                    nwVar.vTq = getString(R.string.aes);
                }
                if (this.koG == null) {
                    this.koG = new a();
                    aVar2 = this.koG;
                    if (aVar2 == null) {
                        a.f.b.j.dWJ();
                    }
                    aVar2.type = 1;
                }
                aVar2 = this.koG;
                if (aVar2 == null) {
                    a.f.b.j.dWJ();
                }
                String str = nwVar.vTq;
                a.f.b.j.o(str, "section_title");
                aVar2.GV(str);
                it = nwVar.vTp.iterator();
                while (it.hasNext()) {
                    nsVar = (ns) it.next();
                    aVar = new a();
                    aVar.koU = nsVar;
                    aVar.type = 2;
                    this.koF.add(aVar);
                }
            }
        }
        if (this.scene == 0) {
            this.koH = new a();
            aVar2 = this.koH;
            if (aVar2 == null) {
                a.f.b.j.dWJ();
            }
            aVar2.type = 4;
        }
        if (this.scene == 0) {
            if ((!((Collection) this.koE).isEmpty() ? 1 : 0) != 0) {
                this.koI = new a();
                aVar2 = this.koI;
                if (aVar2 == null) {
                    a.f.b.j.dWJ();
                }
                aVar2.type = 5;
            }
        }
        ViewGroup viewGroup;
        if (this.koE.isEmpty() && this.koF.isEmpty()) {
            if (this.koH != null) {
                viewGroup = this.koy;
                if (viewGroup == null) {
                    a.f.b.j.avw("mEmptyView");
                }
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                if (layoutParams == null) {
                    a.v vVar = new a.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    AppMethodBeat.o(89241);
                    throw vVar;
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = com.tencent.mm.bz.a.fromDPToPix(dxU(), 80);
                ViewGroup viewGroup2 = this.koy;
                if (viewGroup2 == null) {
                    a.f.b.j.avw("mEmptyView");
                }
                viewGroup2.setLayoutParams(layoutParams2);
            }
            viewGroup = this.koy;
            if (viewGroup == null) {
                a.f.b.j.avw("mEmptyView");
            }
            viewGroup.setVisibility(0);
            AppMethodBeat.o(89241);
            return;
        }
        viewGroup = this.koy;
        if (viewGroup == null) {
            a.f.b.j.avw("mEmptyView");
        }
        viewGroup.setVisibility(8);
        AppMethodBeat.o(89241);
    }

    private final void beh() {
        AppMethodBeat.i(89242);
        ab.i("MicroMsg.CardHomePageNewUI", "do get card Home page: %s, %s", Boolean.valueOf(this.koC), Boolean.valueOf(this.isLoading));
        if (this.koO || !(this.koC || this.isLoading)) {
            int i;
            this.isLoading = true;
            if (this.koO) {
                ViewGroup viewGroup = this.koA;
                if (viewGroup == null) {
                    a.f.b.j.avw("mLoadingView2");
                }
                viewGroup.setVisibility(0);
                if (this.koH != null) {
                    viewGroup = this.koA;
                    if (viewGroup == null) {
                        a.f.b.j.avw("mLoadingView2");
                    }
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    if (layoutParams == null) {
                        a.v vVar = new a.v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        AppMethodBeat.o(89242);
                        throw vVar;
                    }
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.topMargin = com.tencent.mm.bz.a.fromDPToPix(dxU(), 80);
                    ViewGroup viewGroup2 = this.koA;
                    if (viewGroup2 == null) {
                        a.f.b.j.avw("mLoadingView2");
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
                    a.f.b.j.dWJ();
                }
                dialog.dismiss();
            }
            if (this.koE.isEmpty()) {
                Context dxU = dxU();
                dxU().getString(R.string.pl);
                this.gnn = com.tencent.mm.ui.base.h.b(dxU, dxU().getString(R.string.cn5), true, null);
            }
            this.koQ = new com.tencent.mm.plugin.card.model.a.h(this.offset, this.koB, (double) this.cEB, (double) this.cGm, this.kfk);
            com.tencent.mm.plugin.card.model.a.h hVar = this.koQ;
            if (hVar == null) {
                a.f.b.j.dWJ();
            }
            hVar.acy().b((com.tencent.mm.vending.c.a) new h(this));
        }
        AppMethodBeat.o(89242);
    }

    public static final /* synthetic */ void n(CardHomePageNewUI cardHomePageNewUI) {
        AppMethodBeat.i(89246);
        com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(cardHomePageNewUI.dxU(), 1, false);
        dVar.a((com.tencent.mm.ui.base.n.c) new p(cardHomePageNewUI));
        dVar.a((com.tencent.mm.ui.base.n.d) new q(cardHomePageNewUI));
        dVar.cpD();
        AppMethodBeat.o(89246);
    }
}
