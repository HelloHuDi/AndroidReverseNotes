package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.f.b.t;
import a.f.b.v;
import a.k.u;
import a.y;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.text.DecimalFormat;
import java.util.LinkedList;

@a.l(dWo = {1, 1, 13}, dWp = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 G2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\nCDEFGHIJKLB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0014\u0010&\u001a\u00020\u00152\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00130!J\u000e\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0014J\b\u0010*\u001a\u00020\u0014H\u0016J\u0010\u0010+\u001a\u00020,2\u0006\u0010)\u001a\u00020\u0014H\u0016J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u0014H\u0016J \u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u0014J0\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u0002062\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00142\u0006\u00107\u001a\u00020\u000fJ\u001c\u00108\u001a\u00020\u00152\n\u00109\u001a\u00060\u0002R\u00020\u00002\u0006\u0010)\u001a\u00020\u0014H\u0017J\u001c\u0010:\u001a\u00060\u0002R\u00020\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0014H\u0016J\u001e\u0010>\u001a\u00020\u00152\u0006\u00105\u001a\u0002062\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u000fJ\u0014\u0010B\u001a\u00020\u00152\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00130!R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R,\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R,\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R,\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130!8BX\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#¨\u0006M"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "df", "Ljava/text/DecimalFormat;", "getDf", "()Ljava/text/DecimalFormat;", "setDf", "(Ljava/text/DecimalFormat;)V", "isEmptyList", "", "()Z", "onBindView", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "", "", "getOnBindView", "()Lkotlin/jvm/functions/Function2;", "setOnBindView", "(Lkotlin/jvm/functions/Function2;)V", "onClickContent", "getOnClickContent", "setOnClickContent", "onClickFooter", "getOnClickFooter", "setOnClickFooter", "wxaList", "Ljava/util/LinkedList;", "getWxaList", "()Ljava/util/LinkedList;", "wxaList$delegate", "Lkotlin/Lazy;", "appendData", "data", "getData", "position", "getItemCount", "getItemId", "", "getItemViewType", "getRecommendStatObj", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandRecommendStatObj;", "attr", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "itemData", "pos", "jumpProfile", "context", "Landroid/content/Context;", "fromFooter", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAppNameViewMargin", "view", "Landroid/view/View;", "alignTop", "setData", "AppRecommendViewHolder", "AudioRecommendViewHolder", "BaseRecommendViewHolder", "BigVideoRecommendViewHolder", "Companion", "GoodsAppRecommendViewHolder", "ImageTextRecommendViewHolder", "VideoRecommendViewHolder", "WithContentDescViewHolder", "WithFooterViewHolder", "plugin-appbrand-integration_release"})
public final class a extends android.support.v7.widget.RecyclerView.a<c> {
    static final /* synthetic */ a.i.k[] eQB = new a.i.k[]{v.a(new t(v.aN(a.class), "wxaList", "getWxaList()Ljava/util/LinkedList;"))};
    public static final e iPB = new e();
    final Activity activity;
    private DecimalFormat df = new DecimalFormat("0.00");
    a.f.a.m<? super bqd, ? super Integer, y> iPA = p.iPV;
    private final a.f iPx = a.i.g(r.iPX);
    a.f.a.m<? super bqd, ? super Integer, y> iPy = k.iPQ;
    a.f.a.m<? super bqd, ? super Integer, y> iPz = q.iPW;

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "content", "Landroid/view/ViewGroup;", "getContent", "()Landroid/view/ViewGroup;", "contentIcon", "Landroid/widget/ImageView;", "getContentIcon", "()Landroid/widget/ImageView;", "recommendReasonTv", "Landroid/widget/TextView;", "getRecommendReasonTv", "()Landroid/widget/TextView;", "plugin-appbrand-integration_release"})
    public class c extends RecyclerView.v {
        final /* synthetic */ a iPE;
        final ImageView iPG;
        final TextView iPH;
        final ViewGroup iPI;

        public c(a aVar, View view) {
            a.f.b.j.p(view, "itemView");
            this.iPE = aVar;
            super(view);
            AppMethodBeat.i(135153);
            View findViewById = view.findViewById(R.id.ur);
            a.f.b.j.o(findViewById, "itemView.findViewById(R.…d_recommend_content_icon)");
            this.iPG = (ImageView) findViewById;
            findViewById = view.findViewById(R.id.v1);
            a.f.b.j.o(findViewById, "itemView.findViewById(R.…p_brand_recommend_reason)");
            this.iPH = (TextView) findViewById;
            findViewById = view.findViewById(R.id.up);
            a.f.b.j.o(findViewById, "itemView.findViewById(R.…_brand_recommend_content)");
            this.iPI = (ViewGroup) findViewById;
            AppMethodBeat.o(135153);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AudioRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "audioIcon", "Landroid/widget/ImageView;", "getAudioIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
    public class b extends i {
        final /* synthetic */ a iPE;
        final ImageView iPF;

        public b(a aVar, View view) {
            a.f.b.j.p(view, "itemView");
            this.iPE = aVar;
            super(aVar, view);
            AppMethodBeat.i(135152);
            View findViewById = view.findViewById(R.id.uu);
            a.f.b.j.o(findViewById, "itemView.findViewById(R.…rand_recommend_play_icon)");
            this.iPF = (ImageView) findViewById;
            AppMethodBeat.o(135152);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$Companion;", "", "()V", "CardType_App", "", "CardType_Audio", "CardType_BigVideo", "CardType_Goods", "CardType_ImageText", "CardType_Video", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class e {
        private e() {
        }

        public /* synthetic */ e(byte b) {
            this();
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "footer", "Landroid/view/ViewGroup;", "getFooter", "()Landroid/view/ViewGroup;", "footerAppName", "Landroid/widget/TextView;", "getFooterAppName", "()Landroid/widget/TextView;", "footerIcon", "Landroid/widget/ImageView;", "getFooterIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
    public class j extends c {
        final /* synthetic */ a iPE;
        final ImageView iPN;
        final TextView iPO;
        final ViewGroup iPP;

        public j(a aVar, View view) {
            a.f.b.j.p(view, "itemView");
            this.iPE = aVar;
            super(aVar, view);
            AppMethodBeat.i(135159);
            View findViewById = view.findViewById(R.id.uw);
            a.f.b.j.o(findViewById, "itemView.findViewById(R.…nd_recommend_footer_icon)");
            this.iPN = (ImageView) findViewById;
            findViewById = view.findViewById(R.id.uq);
            a.f.b.j.o(findViewById, "itemView.findViewById(R.…ecommend_footer_app_name)");
            this.iPO = (TextView) findViewById;
            findViewById = view.findViewById(R.id.uv);
            a.f.b.j.o(findViewById, "itemView.findViewById(R.…p_brand_recommend_footer)");
            this.iPP = (ViewGroup) findViewById;
            AppMethodBeat.o(135159);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "<anonymous parameter 1>", "", "invoke"})
    static final class k extends a.f.b.k implements a.f.a.m<bqd, Integer, y> {
        public static final k iPQ = new k();

        static {
            AppMethodBeat.i(135161);
            AppMethodBeat.o(135161);
        }

        k() {
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(135160);
            bqd bqd = (bqd) obj;
            ((Number) obj2).intValue();
            a.f.b.j.p(bqd, "<anonymous parameter 0>");
            y yVar = y.AUy;
            AppMethodBeat.o(135160);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$1"})
    static final class l implements OnClickListener {
        final /* synthetic */ Context fbw;
        final /* synthetic */ a iPE;
        final /* synthetic */ c iPR;
        final /* synthetic */ bqd iPS;
        final /* synthetic */ WxaAttributes iPT;
        final /* synthetic */ int iPU;

        l(c cVar, a aVar, bqd bqd, WxaAttributes wxaAttributes, int i, Context context) {
            this.iPR = cVar;
            this.iPE = aVar;
            this.iPS = bqd;
            this.iPT = wxaAttributes;
            this.iPU = i;
            this.fbw = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(135162);
            a aVar = this.iPE;
            View view2 = this.iPR.apJ;
            a.f.b.j.o(view2, "baseViewHolder.itemView");
            Context context = view2.getContext();
            a.f.b.j.o(context, "baseViewHolder.itemView.context");
            aVar.a(context, this.iPT, this.iPS, this.iPU, true);
            AppMethodBeat.o(135162);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AppRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "appName", "Landroid/widget/TextView;", "getAppName", "()Landroid/widget/TextView;", "contentDesc", "getContentDesc", "plugin-appbrand-integration_release"})
    public final class a extends c {
        final TextView iPC;
        final TextView iPD;
        final /* synthetic */ a iPE;

        public a(a aVar, View view) {
            a.f.b.j.p(view, "itemView");
            this.iPE = aVar;
            super(aVar, view);
            AppMethodBeat.i(135151);
            View findViewById = view.findViewById(R.id.us);
            a.f.b.j.o(findViewById, "itemView.findViewById(R.…d_recommend_content_desc)");
            this.iPC = (TextView) findViewById;
            findViewById = view.findViewById(R.id.uq);
            a.f.b.j.o(findViewById, "itemView.findViewById(R.…ecommend_footer_app_name)");
            this.iPD = (TextView) findViewById;
            AppMethodBeat.o(135151);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BigVideoRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AudioRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "plugin-appbrand-integration_release"})
    public final class d extends b {
        final /* synthetic */ a iPE;

        public d(a aVar, View view) {
            a.f.b.j.p(view, "itemView");
            this.iPE = aVar;
            super(aVar, view);
            AppMethodBeat.i(135154);
            AppMethodBeat.o(135154);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$4"})
    static final class m implements OnClickListener {
        final /* synthetic */ Context fbw;
        final /* synthetic */ a iPE;
        final /* synthetic */ bqd iPS;
        final /* synthetic */ WxaAttributes iPT;
        final /* synthetic */ int iPU;

        m(a aVar, bqd bqd, WxaAttributes wxaAttributes, int i, Context context) {
            this.iPE = aVar;
            this.iPS = bqd;
            this.iPT = wxaAttributes;
            this.iPU = i;
            this.fbw = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(135163);
            Intent intent = new Intent(this.iPE.activity, AppBrandRecommendVideoUI.class);
            intent.putExtra("1", this.iPS.wSr);
            this.iPE.activity.startActivity(intent);
            this.iPE.iPA.m(this.iPS, Integer.valueOf(this.iPU));
            AppMethodBeat.o(135163);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$5"})
    static final class n implements OnClickListener {
        final /* synthetic */ Context fbw;
        final /* synthetic */ a iPE;
        final /* synthetic */ c iPR;
        final /* synthetic */ bqd iPS;
        final /* synthetic */ WxaAttributes iPT;
        final /* synthetic */ int iPU;

        n(c cVar, a aVar, bqd bqd, WxaAttributes wxaAttributes, int i, Context context) {
            this.iPR = cVar;
            this.iPE = aVar;
            this.iPS = bqd;
            this.iPT = wxaAttributes;
            this.iPU = i;
            this.fbw = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(135164);
            if (this.iPS.iAd == 4) {
                a aVar = this.iPE;
                View view2 = this.iPR.apJ;
                a.f.b.j.o(view2, "baseViewHolder.itemView");
                Context context = view2.getContext();
                a.f.b.j.o(context, "baseViewHolder.itemView.context");
                aVar.a(context, this.iPT, this.iPS, this.iPU, false);
                AppMethodBeat.o(135164);
                return;
            }
            String str = this.iPS.iAb;
            if (this.iPS.iAc != null) {
                String str2 = this.iPS.iAc;
                a.f.b.j.o(str2, "itemData.page_param");
                if (!u.ar(str2)) {
                    str = str + "?" + this.iPS.iAc;
                }
            }
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = FaceManager.FACE_ACQUIRED_NO_FOCUS;
            appBrandStatObject.cOq = 14;
            if (TextUtils.isEmpty(this.iPS.iAa)) {
                appBrandStatObject.cst = this.iPS.izZ;
                appBrandStatObject.cOr = this.iPS.izZ;
            } else {
                appBrandStatObject.cst = this.iPS.izZ + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.iPS.iAa.toString();
                appBrandStatObject.cOr = this.iPS.izZ + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.iPS.iAa.toString();
            }
            appBrandStatObject.iAp = a.a(this.iPT, this.iPS, this.iPU);
            if (this.iPT != null) {
                WxaAttributes wxaAttributes = this.iPT;
                if (wxaAttributes != null) {
                    com.tencent.mm.plugin.appbrand.config.WxaAttributes.e ayL = wxaAttributes.ayL();
                    if (ayL != null) {
                        ((com.tencent.mm.plugin.appbrand.service.e) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.e.class)).a(this.fbw, this.iPS.wSq, this.iPT.field_appId, 0, ayL.axy, str, appBrandStatObject);
                    }
                }
            }
            this.iPE.iPA.m(this.iPS, Integer.valueOf(this.iPU));
            AppMethodBeat.o(135164);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$GoodsAppRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "discountPrice", "Landroid/widget/TextView;", "getDiscountPrice", "()Landroid/widget/TextView;", "goodsName", "getGoodsName", "originPrice", "getOriginPrice", "plugin-appbrand-integration_release"})
    public final class f extends j {
        final /* synthetic */ a iPE;
        final TextView iPJ;
        final TextView iPK;
        final TextView iPL;

        public f(a aVar, View view) {
            a.f.b.j.p(view, "itemView");
            this.iPE = aVar;
            super(aVar, view);
            AppMethodBeat.i(135155);
            View findViewById = view.findViewById(R.id.uy);
            a.f.b.j.o(findViewById, "itemView.findViewById(R.…and_recommend_goods_name)");
            this.iPJ = (TextView) findViewById;
            findViewById = view.findViewById(R.id.uz);
            a.f.b.j.o(findViewById, "itemView.findViewById(R.…recommend_discount_price)");
            this.iPK = (TextView) findViewById;
            findViewById = view.findViewById(R.id.v0);
            a.f.b.j.o(findViewById, "itemView.findViewById(R.…d_recommend_origin_price)");
            this.iPL = (TextView) findViewById;
            AppMethodBeat.o(135155);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "contentDesc", "Landroid/widget/TextView;", "getContentDesc", "()Landroid/widget/TextView;", "plugin-appbrand-integration_release"})
    public class i extends j {
        final TextView iPC;
        final /* synthetic */ a iPE;

        public i(a aVar, View view) {
            a.f.b.j.p(view, "itemView");
            this.iPE = aVar;
            super(aVar, view);
            AppMethodBeat.i(135158);
            View findViewById = view.findViewById(R.id.us);
            a.f.b.j.o(findViewById, "itemView.findViewById(R.…d_recommend_content_desc)");
            this.iPC = (TextView) findViewById;
            AppMethodBeat.o(135158);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "<anonymous parameter 1>", "", "invoke"})
    static final class p extends a.f.b.k implements a.f.a.m<bqd, Integer, y> {
        public static final p iPV = new p();

        static {
            AppMethodBeat.i(135167);
            AppMethodBeat.o(135167);
        }

        p() {
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(135166);
            bqd bqd = (bqd) obj;
            ((Number) obj2).intValue();
            a.f.b.j.p(bqd, "<anonymous parameter 0>");
            y yVar = y.AUy;
            AppMethodBeat.o(135166);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "<anonymous parameter 1>", "", "invoke"})
    static final class q extends a.f.b.k implements a.f.a.m<bqd, Integer, y> {
        public static final q iPW = new q();

        static {
            AppMethodBeat.i(135169);
            AppMethodBeat.o(135169);
        }

        q() {
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(135168);
            bqd bqd = (bqd) obj;
            ((Number) obj2).intValue();
            a.f.b.j.p(bqd, "<anonymous parameter 0>");
            y yVar = y.AUy;
            AppMethodBeat.o(135168);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "invoke"})
    static final class r extends a.f.b.k implements a.f.a.a<LinkedList<bqd>> {
        public static final r iPX = new r();

        static {
            AppMethodBeat.i(135171);
            AppMethodBeat.o(135171);
        }

        r() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(135170);
            LinkedList linkedList = new LinkedList();
            AppMethodBeat.o(135170);
            return linkedList;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$ImageTextRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "plugin-appbrand-integration_release"})
    public final class g extends i {
        final /* synthetic */ a iPE;

        public g(a aVar, View view) {
            a.f.b.j.p(view, "itemView");
            this.iPE = aVar;
            super(aVar, view);
            AppMethodBeat.i(135156);
            AppMethodBeat.o(135156);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$VideoRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "videoIcon", "Landroid/widget/ImageView;", "getVideoIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
    public class h extends i {
        final /* synthetic */ a iPE;
        final ImageView iPM;

        public h(a aVar, View view) {
            a.f.b.j.p(view, "itemView");
            this.iPE = aVar;
            super(aVar, view);
            AppMethodBeat.i(135157);
            View findViewById = view.findViewById(R.id.uu);
            a.f.b.j.o(findViewById, "itemView.findViewById(R.…rand_recommend_play_icon)");
            this.iPM = (ImageView) findViewById;
            AppMethodBeat.o(135157);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$6"})
    static final class o implements OnLongClickListener {
        final /* synthetic */ Context fbw;
        final /* synthetic */ a iPE;
        final /* synthetic */ bqd iPS;
        final /* synthetic */ WxaAttributes iPT;
        final /* synthetic */ int iPU;

        o(a aVar, bqd bqd, WxaAttributes wxaAttributes, int i, Context context) {
            this.iPE = aVar;
            this.iPS = bqd;
            this.iPT = wxaAttributes;
            this.iPU = i;
            this.fbw = context;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(135165);
            com.tencent.mm.pluginsdk.f.a.b("", this.iPS.izZ.toString() + "," + this.iPS.wSw + "," + this.iPS.wSq);
            AppMethodBeat.o(135165);
            return false;
        }
    }

    static {
        AppMethodBeat.i(135172);
        AppMethodBeat.o(135172);
    }

    /* Access modifiers changed, original: final */
    public final LinkedList<bqd> aND() {
        AppMethodBeat.i(135173);
        LinkedList linkedList = (LinkedList) this.iPx.getValue();
        AppMethodBeat.o(135173);
        return linkedList;
    }

    public a(Activity activity) {
        a.f.b.j.p(activity, "activity");
        AppMethodBeat.i(135181);
        this.activity = activity;
        AppMethodBeat.o(135181);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(135175);
        int i2 = ((bqd) aND().get(i)).iAd;
        AppMethodBeat.o(135175);
        return i2;
    }

    private static void a(Context context, View view, boolean z) {
        AppMethodBeat.i(135177);
        a.f.b.j.p(context, "context");
        a.f.b.j.p(view, "view");
        if (view instanceof TextView) {
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                a.v vVar = new a.v("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
                AppMethodBeat.o(135177);
                throw vVar;
            }
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            if (layoutParams2 != null) {
                if (z) {
                    layoutParams2.topMargin = context.getResources().getDimensionPixelOffset(R.dimen.t0);
                } else {
                    layoutParams2.topMargin = context.getResources().getDimensionPixelOffset(R.dimen.sz);
                }
                view.setLayoutParams(layoutParams2);
            }
        }
        AppMethodBeat.o(135177);
    }

    public final void a(Context context, WxaAttributes wxaAttributes, bqd bqd, int i, boolean z) {
        AppMethodBeat.i(138703);
        a.f.b.j.p(context, "context");
        a.f.b.j.p(bqd, "itemData");
        String str = bqd.izZ;
        if (!TextUtils.isEmpty(bqd.iAa)) {
            str = bqd.izZ + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + bqd.iAa.toString();
        }
        com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a aVar = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a();
        if (wxaAttributes != null) {
            aVar.zC(wxaAttributes.field_appId);
            aVar.zE(wxaAttributes.field_nickname);
        }
        aVar.zD(bqd.wSq);
        aVar.zF(bqd.wSx);
        aVar.nF(12);
        AppBrandRecommendStatObj a = a(wxaAttributes, bqd, i);
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_recommend_stat_obj", a);
        AppBrandProfileUI.a(context, bqd.wSq, 7, str, aVar.ayP(), bundle, null);
        if (z) {
            this.iPz.m(bqd, Integer.valueOf(i));
            AppMethodBeat.o(138703);
            return;
        }
        this.iPA.m(bqd, Integer.valueOf(i));
        AppMethodBeat.o(138703);
    }

    public static AppBrandRecommendStatObj a(WxaAttributes wxaAttributes, bqd bqd, int i) {
        AppMethodBeat.i(135179);
        a.f.b.j.p(bqd, "itemData");
        AppBrandRecommendStatObj appBrandRecommendStatObj = new AppBrandRecommendStatObj();
        appBrandRecommendStatObj.username = bqd.wSq;
        appBrandRecommendStatObj.izZ = bqd.izZ;
        appBrandRecommendStatObj.iAa = bqd.iAa;
        if (wxaAttributes != null) {
            appBrandRecommendStatObj.csB = wxaAttributes.field_appId;
        }
        appBrandRecommendStatObj.iAb = bqd.iAb;
        appBrandRecommendStatObj.iAc = bqd.iAc;
        appBrandRecommendStatObj.iAd = bqd.iAd;
        appBrandRecommendStatObj.iAe = bqd.iAe;
        appBrandRecommendStatObj.position = i + 1;
        appBrandRecommendStatObj.cGm = com.tencent.mm.plugin.appbrand.appusage.a.c.getLongitude();
        appBrandRecommendStatObj.cEB = com.tencent.mm.plugin.appbrand.appusage.a.c.getLongitude();
        appBrandRecommendStatObj.hbj = com.tencent.mm.plugin.appbrand.appusage.a.d.hbu.aya().hbj;
        AppMethodBeat.o(135179);
        return appBrandRecommendStatObj;
    }

    public final int getItemCount() {
        AppMethodBeat.i(135180);
        int size = aND().size();
        AppMethodBeat.o(135180);
        return size;
    }
}
