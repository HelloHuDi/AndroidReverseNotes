package com.tencent.p177mm.plugin.appbrand.p336ui.recommend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.appusage.p280a.C19095d;
import com.tencent.p177mm.plugin.appbrand.appusage.p280a.C26759c;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C31283e;
import com.tencent.p177mm.plugin.appbrand.config.WxaExposedParams.C19154a;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandProfileUI;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.pluginsdk.p1079f.C14832a;
import com.tencent.p177mm.protocal.protobuf.bqd;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.text.DecimalFormat;
import java.util.LinkedList;
import p000a.C0220l;
import p000a.C17344i;
import p000a.C37091y;
import p000a.C44856f;
import p000a.C44941v;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 G2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\nCDEFGHIJKLB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0014\u0010&\u001a\u00020\u00152\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00130!J\u000e\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0014J\b\u0010*\u001a\u00020\u0014H\u0016J\u0010\u0010+\u001a\u00020,2\u0006\u0010)\u001a\u00020\u0014H\u0016J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u0014H\u0016J \u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u0014J0\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u0002062\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00142\u0006\u00107\u001a\u00020\u000fJ\u001c\u00108\u001a\u00020\u00152\n\u00109\u001a\u00060\u0002R\u00020\u00002\u0006\u0010)\u001a\u00020\u0014H\u0017J\u001c\u0010:\u001a\u00060\u0002R\u00020\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0014H\u0016J\u001e\u0010>\u001a\u00020\u00152\u0006\u00105\u001a\u0002062\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u000fJ\u0014\u0010B\u001a\u00020\u00152\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00130!R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R,\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R,\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R,\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130!8BX\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#¨\u0006M"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "df", "Ljava/text/DecimalFormat;", "getDf", "()Ljava/text/DecimalFormat;", "setDf", "(Ljava/text/DecimalFormat;)V", "isEmptyList", "", "()Z", "onBindView", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "", "", "getOnBindView", "()Lkotlin/jvm/functions/Function2;", "setOnBindView", "(Lkotlin/jvm/functions/Function2;)V", "onClickContent", "getOnClickContent", "setOnClickContent", "onClickFooter", "getOnClickFooter", "setOnClickFooter", "wxaList", "Ljava/util/LinkedList;", "getWxaList", "()Ljava/util/LinkedList;", "wxaList$delegate", "Lkotlin/Lazy;", "appendData", "data", "getData", "position", "getItemCount", "getItemId", "", "getItemViewType", "getRecommendStatObj", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandRecommendStatObj;", "attr", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "itemData", "pos", "jumpProfile", "context", "Landroid/content/Context;", "fromFooter", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAppNameViewMargin", "view", "Landroid/view/View;", "alignTop", "setData", "AppRecommendViewHolder", "AudioRecommendViewHolder", "BaseRecommendViewHolder", "BigVideoRecommendViewHolder", "Companion", "GoodsAppRecommendViewHolder", "ImageTextRecommendViewHolder", "VideoRecommendViewHolder", "WithContentDescViewHolder", "WithFooterViewHolder", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.a */
public final class C38544a extends C41523a<C10921c> {
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C38544a.class), "wxaList", "getWxaList()Ljava/util/LinkedList;"))};
    public static final C19799e iPB = new C19799e();
    final Activity activity;
    /* renamed from: df */
    private DecimalFormat f16154df = new DecimalFormat("0.00");
    C31591m<? super bqd, ? super Integer, C37091y> iPA = C38547p.iPV;
    private final C44856f iPx = C17344i.m26854g(C38549r.iPX);
    C31591m<? super bqd, ? super Integer, C37091y> iPy = C19801k.iPQ;
    C31591m<? super bqd, ? super Integer, C37091y> iPz = C38548q.iPW;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "content", "Landroid/view/ViewGroup;", "getContent", "()Landroid/view/ViewGroup;", "contentIcon", "Landroid/widget/ImageView;", "getContentIcon", "()Landroid/widget/ImageView;", "recommendReasonTv", "Landroid/widget/TextView;", "getRecommendReasonTv", "()Landroid/widget/TextView;", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.a$c */
    public class C10921c extends C41531v {
        final /* synthetic */ C38544a iPE;
        final ImageView iPG;
        final TextView iPH;
        final ViewGroup iPI;

        public C10921c(C38544a c38544a, View view) {
            C25052j.m39376p(view, "itemView");
            this.iPE = c38544a;
            super(view);
            AppMethodBeat.m2504i(135153);
            View findViewById = view.findViewById(2131821338);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…d_recommend_content_icon)");
            this.iPG = (ImageView) findViewById;
            findViewById = view.findViewById(2131821348);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…p_brand_recommend_reason)");
            this.iPH = (TextView) findViewById;
            findViewById = view.findViewById(2131821336);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…_brand_recommend_content)");
            this.iPI = (ViewGroup) findViewById;
            AppMethodBeat.m2505o(135153);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AudioRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "audioIcon", "Landroid/widget/ImageView;", "getAudioIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.a$b */
    public class C19798b extends C38546i {
        final /* synthetic */ C38544a iPE;
        final ImageView iPF;

        public C19798b(C38544a c38544a, View view) {
            C25052j.m39376p(view, "itemView");
            this.iPE = c38544a;
            super(c38544a, view);
            AppMethodBeat.m2504i(135152);
            View findViewById = view.findViewById(2131821341);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…rand_recommend_play_icon)");
            this.iPF = (ImageView) findViewById;
            AppMethodBeat.m2505o(135152);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$Companion;", "", "()V", "CardType_App", "", "CardType_Audio", "CardType_BigVideo", "CardType_Goods", "CardType_ImageText", "CardType_Video", "TAG", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.a$e */
    public static final class C19799e {
        private C19799e() {
        }

        public /* synthetic */ C19799e(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "footer", "Landroid/view/ViewGroup;", "getFooter", "()Landroid/view/ViewGroup;", "footerAppName", "Landroid/widget/TextView;", "getFooterAppName", "()Landroid/widget/TextView;", "footerIcon", "Landroid/widget/ImageView;", "getFooterIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.a$j */
    public class C19800j extends C10921c {
        final /* synthetic */ C38544a iPE;
        final ImageView iPN;
        final TextView iPO;
        final ViewGroup iPP;

        public C19800j(C38544a c38544a, View view) {
            C25052j.m39376p(view, "itemView");
            this.iPE = c38544a;
            super(c38544a, view);
            AppMethodBeat.m2504i(135159);
            View findViewById = view.findViewById(2131821343);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…nd_recommend_footer_icon)");
            this.iPN = (ImageView) findViewById;
            findViewById = view.findViewById(2131821337);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…ecommend_footer_app_name)");
            this.iPO = (TextView) findViewById;
            findViewById = view.findViewById(2131821342);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…p_brand_recommend_footer)");
            this.iPP = (ViewGroup) findViewById;
            AppMethodBeat.m2505o(135159);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "<anonymous parameter 1>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.a$k */
    static final class C19801k extends C25053k implements C31591m<bqd, Integer, C37091y> {
        public static final C19801k iPQ = new C19801k();

        static {
            AppMethodBeat.m2504i(135161);
            AppMethodBeat.m2505o(135161);
        }

        C19801k() {
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(135160);
            bqd bqd = (bqd) obj;
            ((Number) obj2).intValue();
            C25052j.m39376p(bqd, "<anonymous parameter 0>");
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(135160);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$1"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.a$l */
    static final class C19802l implements OnClickListener {
        final /* synthetic */ Context fbw;
        final /* synthetic */ C38544a iPE;
        final /* synthetic */ C10921c iPR;
        final /* synthetic */ bqd iPS;
        final /* synthetic */ WxaAttributes iPT;
        final /* synthetic */ int iPU;

        C19802l(C10921c c10921c, C38544a c38544a, bqd bqd, WxaAttributes wxaAttributes, int i, Context context) {
            this.iPR = c10921c;
            this.iPE = c38544a;
            this.iPS = bqd;
            this.iPT = wxaAttributes;
            this.iPU = i;
            this.fbw = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(135162);
            C38544a c38544a = this.iPE;
            View view2 = this.iPR.apJ;
            C25052j.m39375o(view2, "baseViewHolder.itemView");
            Context context = view2.getContext();
            C25052j.m39375o(context, "baseViewHolder.itemView.context");
            c38544a.mo61274a(context, this.iPT, this.iPS, this.iPU, true);
            AppMethodBeat.m2505o(135162);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AppRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "appName", "Landroid/widget/TextView;", "getAppName", "()Landroid/widget/TextView;", "contentDesc", "getContentDesc", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.a$a */
    public final class C27343a extends C10921c {
        final TextView iPC;
        final TextView iPD;
        final /* synthetic */ C38544a iPE;

        public C27343a(C38544a c38544a, View view) {
            C25052j.m39376p(view, "itemView");
            this.iPE = c38544a;
            super(c38544a, view);
            AppMethodBeat.m2504i(135151);
            View findViewById = view.findViewById(2131821339);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…d_recommend_content_desc)");
            this.iPC = (TextView) findViewById;
            findViewById = view.findViewById(2131821337);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…ecommend_footer_app_name)");
            this.iPD = (TextView) findViewById;
            AppMethodBeat.m2505o(135151);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BigVideoRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AudioRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.a$d */
    public final class C27344d extends C19798b {
        final /* synthetic */ C38544a iPE;

        public C27344d(C38544a c38544a, View view) {
            C25052j.m39376p(view, "itemView");
            this.iPE = c38544a;
            super(c38544a, view);
            AppMethodBeat.m2504i(135154);
            AppMethodBeat.m2505o(135154);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$4"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.a$m */
    static final class C27345m implements OnClickListener {
        final /* synthetic */ Context fbw;
        final /* synthetic */ C38544a iPE;
        final /* synthetic */ bqd iPS;
        final /* synthetic */ WxaAttributes iPT;
        final /* synthetic */ int iPU;

        C27345m(C38544a c38544a, bqd bqd, WxaAttributes wxaAttributes, int i, Context context) {
            this.iPE = c38544a;
            this.iPS = bqd;
            this.iPT = wxaAttributes;
            this.iPU = i;
            this.fbw = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(135163);
            Intent intent = new Intent(this.iPE.activity, AppBrandRecommendVideoUI.class);
            intent.putExtra("1", this.iPS.wSr);
            this.iPE.activity.startActivity(intent);
            this.iPE.iPA.mo212m(this.iPS, Integer.valueOf(this.iPU));
            AppMethodBeat.m2505o(135163);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$5"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.a$n */
    static final class C38543n implements OnClickListener {
        final /* synthetic */ Context fbw;
        final /* synthetic */ C38544a iPE;
        final /* synthetic */ C10921c iPR;
        final /* synthetic */ bqd iPS;
        final /* synthetic */ WxaAttributes iPT;
        final /* synthetic */ int iPU;

        C38543n(C10921c c10921c, C38544a c38544a, bqd bqd, WxaAttributes wxaAttributes, int i, Context context) {
            this.iPR = c10921c;
            this.iPE = c38544a;
            this.iPS = bqd;
            this.iPT = wxaAttributes;
            this.iPU = i;
            this.fbw = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(135164);
            if (this.iPS.iAd == 4) {
                C38544a c38544a = this.iPE;
                View view2 = this.iPR.apJ;
                C25052j.m39375o(view2, "baseViewHolder.itemView");
                Context context = view2.getContext();
                C25052j.m39375o(context, "baseViewHolder.itemView.context");
                c38544a.mo61274a(context, this.iPT, this.iPS, this.iPU, false);
                AppMethodBeat.m2505o(135164);
                return;
            }
            String str = this.iPS.iAb;
            if (this.iPS.iAc != null) {
                String str2 = this.iPS.iAc;
                C25052j.m39375o(str2, "itemData.page_param");
                if (!C6163u.m9837ar(str2)) {
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
            appBrandStatObject.iAp = C38544a.m65289a(this.iPT, this.iPS, this.iPU);
            if (this.iPT != null) {
                WxaAttributes wxaAttributes = this.iPT;
                if (wxaAttributes != null) {
                    C31283e ayL = wxaAttributes.ayL();
                    if (ayL != null) {
                        ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(this.fbw, this.iPS.wSq, this.iPT.field_appId, 0, ayL.axy, str, appBrandStatObject);
                    }
                }
            }
            this.iPE.iPA.mo212m(this.iPS, Integer.valueOf(this.iPU));
            AppMethodBeat.m2505o(135164);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$GoodsAppRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "discountPrice", "Landroid/widget/TextView;", "getDiscountPrice", "()Landroid/widget/TextView;", "goodsName", "getGoodsName", "originPrice", "getOriginPrice", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.a$f */
    public final class C38545f extends C19800j {
        final /* synthetic */ C38544a iPE;
        final TextView iPJ;
        final TextView iPK;
        final TextView iPL;

        public C38545f(C38544a c38544a, View view) {
            C25052j.m39376p(view, "itemView");
            this.iPE = c38544a;
            super(c38544a, view);
            AppMethodBeat.m2504i(135155);
            View findViewById = view.findViewById(2131821345);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…and_recommend_goods_name)");
            this.iPJ = (TextView) findViewById;
            findViewById = view.findViewById(2131821346);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…recommend_discount_price)");
            this.iPK = (TextView) findViewById;
            findViewById = view.findViewById(2131821347);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…d_recommend_origin_price)");
            this.iPL = (TextView) findViewById;
            AppMethodBeat.m2505o(135155);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "contentDesc", "Landroid/widget/TextView;", "getContentDesc", "()Landroid/widget/TextView;", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.a$i */
    public class C38546i extends C19800j {
        final TextView iPC;
        final /* synthetic */ C38544a iPE;

        public C38546i(C38544a c38544a, View view) {
            C25052j.m39376p(view, "itemView");
            this.iPE = c38544a;
            super(c38544a, view);
            AppMethodBeat.m2504i(135158);
            View findViewById = view.findViewById(2131821339);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…d_recommend_content_desc)");
            this.iPC = (TextView) findViewById;
            AppMethodBeat.m2505o(135158);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "<anonymous parameter 1>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.a$p */
    static final class C38547p extends C25053k implements C31591m<bqd, Integer, C37091y> {
        public static final C38547p iPV = new C38547p();

        static {
            AppMethodBeat.m2504i(135167);
            AppMethodBeat.m2505o(135167);
        }

        C38547p() {
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(135166);
            bqd bqd = (bqd) obj;
            ((Number) obj2).intValue();
            C25052j.m39376p(bqd, "<anonymous parameter 0>");
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(135166);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "<anonymous parameter 1>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.a$q */
    static final class C38548q extends C25053k implements C31591m<bqd, Integer, C37091y> {
        public static final C38548q iPW = new C38548q();

        static {
            AppMethodBeat.m2504i(135169);
            AppMethodBeat.m2505o(135169);
        }

        C38548q() {
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(135168);
            bqd bqd = (bqd) obj;
            ((Number) obj2).intValue();
            C25052j.m39376p(bqd, "<anonymous parameter 0>");
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(135168);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.a$r */
    static final class C38549r extends C25053k implements C31214a<LinkedList<bqd>> {
        public static final C38549r iPX = new C38549r();

        static {
            AppMethodBeat.m2504i(135171);
            AppMethodBeat.m2505o(135171);
        }

        C38549r() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(135170);
            LinkedList linkedList = new LinkedList();
            AppMethodBeat.m2505o(135170);
            return linkedList;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$ImageTextRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.a$g */
    public final class C38550g extends C38546i {
        final /* synthetic */ C38544a iPE;

        public C38550g(C38544a c38544a, View view) {
            C25052j.m39376p(view, "itemView");
            this.iPE = c38544a;
            super(c38544a, view);
            AppMethodBeat.m2504i(135156);
            AppMethodBeat.m2505o(135156);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$VideoRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "videoIcon", "Landroid/widget/ImageView;", "getVideoIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.a$h */
    public class C38551h extends C38546i {
        final /* synthetic */ C38544a iPE;
        final ImageView iPM;

        public C38551h(C38544a c38544a, View view) {
            C25052j.m39376p(view, "itemView");
            this.iPE = c38544a;
            super(c38544a, view);
            AppMethodBeat.m2504i(135157);
            View findViewById = view.findViewById(2131821341);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.…rand_recommend_play_icon)");
            this.iPM = (ImageView) findViewById;
            AppMethodBeat.m2505o(135157);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$6"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.a$o */
    static final class C38552o implements OnLongClickListener {
        final /* synthetic */ Context fbw;
        final /* synthetic */ C38544a iPE;
        final /* synthetic */ bqd iPS;
        final /* synthetic */ WxaAttributes iPT;
        final /* synthetic */ int iPU;

        C38552o(C38544a c38544a, bqd bqd, WxaAttributes wxaAttributes, int i, Context context) {
            this.iPE = c38544a;
            this.iPS = bqd;
            this.iPT = wxaAttributes;
            this.iPU = i;
            this.fbw = context;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(135165);
            C14832a.m23084b("", this.iPS.izZ.toString() + "," + this.iPS.wSw + "," + this.iPS.wSq);
            AppMethodBeat.m2505o(135165);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(135172);
        AppMethodBeat.m2505o(135172);
    }

    /* Access modifiers changed, original: final */
    public final LinkedList<bqd> aND() {
        AppMethodBeat.m2504i(135173);
        LinkedList linkedList = (LinkedList) this.iPx.getValue();
        AppMethodBeat.m2505o(135173);
        return linkedList;
    }

    public C38544a(Activity activity) {
        C25052j.m39376p(activity, "activity");
        AppMethodBeat.m2504i(135181);
        this.activity = activity;
        AppMethodBeat.m2505o(135181);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(135175);
        int i2 = ((bqd) aND().get(i)).iAd;
        AppMethodBeat.m2505o(135175);
        return i2;
    }

    /* renamed from: a */
    private static void m65290a(Context context, View view, boolean z) {
        AppMethodBeat.m2504i(135177);
        C25052j.m39376p(context, "context");
        C25052j.m39376p(view, "view");
        if (view instanceof TextView) {
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
                AppMethodBeat.m2505o(135177);
                throw c44941v;
            }
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            if (layoutParams2 != null) {
                if (z) {
                    layoutParams2.topMargin = context.getResources().getDimensionPixelOffset(C25738R.dimen.f10169t0);
                } else {
                    layoutParams2.topMargin = context.getResources().getDimensionPixelOffset(C25738R.dimen.f10168sz);
                }
                view.setLayoutParams(layoutParams2);
            }
        }
        AppMethodBeat.m2505o(135177);
    }

    /* renamed from: a */
    public final void mo61274a(Context context, WxaAttributes wxaAttributes, bqd bqd, int i, boolean z) {
        AppMethodBeat.m2504i(138703);
        C25052j.m39376p(context, "context");
        C25052j.m39376p(bqd, "itemData");
        String str = bqd.izZ;
        if (!TextUtils.isEmpty(bqd.iAa)) {
            str = bqd.izZ + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + bqd.iAa.toString();
        }
        C19154a c19154a = new C19154a();
        if (wxaAttributes != null) {
            c19154a.mo34388zC(wxaAttributes.field_appId);
            c19154a.mo34390zE(wxaAttributes.field_nickname);
        }
        c19154a.mo34389zD(bqd.wSq);
        c19154a.mo34391zF(bqd.wSx);
        c19154a.mo34387nF(12);
        AppBrandRecommendStatObj a = C38544a.m65289a(wxaAttributes, bqd, i);
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_recommend_stat_obj", a);
        AppBrandProfileUI.m18458a(context, bqd.wSq, 7, str, c19154a.ayP(), bundle, null);
        if (z) {
            this.iPz.mo212m(bqd, Integer.valueOf(i));
            AppMethodBeat.m2505o(138703);
            return;
        }
        this.iPA.mo212m(bqd, Integer.valueOf(i));
        AppMethodBeat.m2505o(138703);
    }

    /* renamed from: a */
    public static AppBrandRecommendStatObj m65289a(WxaAttributes wxaAttributes, bqd bqd, int i) {
        AppMethodBeat.m2504i(135179);
        C25052j.m39376p(bqd, "itemData");
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
        appBrandRecommendStatObj.cGm = C26759c.getLongitude();
        appBrandRecommendStatObj.cEB = C26759c.getLongitude();
        appBrandRecommendStatObj.hbj = C19095d.hbu.aya().hbj;
        AppMethodBeat.m2505o(135179);
        return appBrandRecommendStatObj;
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(135180);
        int size = aND().size();
        AppMethodBeat.m2505o(135180);
        return size;
    }
}
