package com.tencent.p177mm.plugin.appbrand.widget.p337b;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.graphics.Bitmap;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37932f;
import com.tencent.p177mm.modelappbrand.p873a.C42201f;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C10941l.C10942a;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p001a.C7987l;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0004[\\]^B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020\u0013H\u0016J\b\u0010B\u001a\u00020CH\u0016J \u0010D\u001a\u0012\u0012\u0004\u0012\u00020\t0Ej\b\u0012\u0004\u0012\u00020\t`F2\u0006\u0010G\u001a\u00020HH\u0002J\b\u0010I\u001a\u00020HH\u0016J\b\u0010J\u001a\u00020HH\u0016J\b\u0010K\u001a\u00020@H\u0016J\b\u0010L\u001a\u00020@H\u0016J\u0010\u0010M\u001a\u00020@2\u0006\u0010N\u001a\u00020CH\u0016J\u0012\u0010O\u001a\u00020@2\b\u0010P\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010Q\u001a\u00020@2\b\u0010R\u001a\u0004\u0018\u00010\tJ\u0010\u0010S\u001a\u00020@2\b\u0010T\u001a\u0004\u0018\u00010\tJ\u000e\u0010U\u001a\u00020@2\u0006\u0010V\u001a\u00020\tJ\u0016\u0010W\u001a\u00020@2\u000e\u0010X\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010YR(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\b\u001a\u0004\u0018\u00010\u0016@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\u001c\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u000e\u0010\u001f\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u000e¢\u0006\u0002\n\u0000R(\u00109\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\f\"\u0004\b;\u0010\u000eR(\u0010<\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\f\"\u0004\b>\u0010\u000e¨\u0006_"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "listener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;)V", "value", "", "appBrandName", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "applyWording", "getApplyWording", "setApplyWording", "buttonGroup", "Landroid/view/View;", "funcTv", "Landroid/widget/TextView;", "Landroid/graphics/Bitmap;", "icon", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "iconUrl", "getIconUrl", "setIconUrl", "loadingView", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$ItemAdapter;", "mApplyWordingTv", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mExplainIv", "Landroid/widget/ImageView;", "mIconIv", "mListener", "mNameTv", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mOnShowListener", "Landroid/content/DialogInterface$OnShowListener;", "mRequestDescTv", "mRootView", "mScope", "mSelectListLayout", "Landroid/widget/LinearLayout;", "mSimpleDetailDescTv", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "requestDesc", "getRequestDesc", "setRequestDesc", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "dismiss", "", "getContentView", "getPosition", "", "getScope", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "check", "", "isCancelable", "isCanceledOnTouchOutside", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "setNegativeButtonText", "cancelWording", "setPositiveButtonText", "allowWording", "setScope", "scope", "setSelectListItem", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Item;", "Companion", "Item", "ItemAdapter", "Listener", "luggage-wechat-full-sdk_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.widget.b.h */
public final class C33586h extends Dialog implements C38571j {
    public static final C2534a jcD = new C2534a();
    /* renamed from: Uf */
    private OnDismissListener f15041Uf;
    private String hCq = "";
    public RecyclerView iJP;
    private ImageView iUn;
    private String iconUrl;
    private C33589k iyk;
    private View iyw;
    private String jcA;
    private String jcB;
    private String jcC;
    private View jcl;
    private TextView jcm;
    private Button jcn;
    private Button jco;
    private TextView jcp;
    public TextView jcq;
    private ImageView jcr;
    private TextView jcs;
    public LinearLayout jct;
    public TextView jcu;
    public View jcv;
    private OnShowListener jcw;
    private C33585d jcx;
    public C2536c jcy;
    private String jcz;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Companion;", "", "()V", "ALERT_RESULT_CODE_ACCEPT", "", "ALERT_RESULT_CODE_CANCEL", "ALERT_RESULT_CODE_REJECT", "luggage-wechat-full-sdk_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.h$a */
    public static final class C2534a {
        private C2534a() {
        }

        public /* synthetic */ C2534a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B/\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB5\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Item;", "", "subTitle", "", "title", "scope", "icon", "Landroid/graphics/Bitmap;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;)V", "check", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Z)V", "getCheck", "()Z", "setCheck", "(Z)V", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "getScope", "()Ljava/lang/String;", "getSubTitle", "getTitle", "luggage-wechat-full-sdk_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.h$b */
    public static final class C2535b {
        final String jcF;
        Bitmap jcG;
        boolean jcH;
        final String scope;
        final String title;

        private C2535b(String str, String str2, String str3, Bitmap bitmap) {
            this.title = str;
            this.jcF = str2;
            this.scope = str3;
            this.jcG = bitmap;
            this.jcH = false;
        }

        public C2535b(String str, String str2, String str3, Bitmap bitmap, byte b) {
            this(str2, str, str3, bitmap);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\"\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$ItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$ItemAdapter$ViewHolder;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Item;", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "setItems", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "luggage-wechat-full-sdk_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.h$c */
    public static final class C2536c extends C41523a<C2537a> {
        List<C2535b> items;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007JI\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c21\u0010\u001d\u001a-\u0012#\u0012!\u0012\u0004\u0012\u00020\u001c0\u001fj\b\u0012\u0004\u0012\u00020\u001c` ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00190\u001eJ\u0010\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&H\u0002R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006'"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$ItemAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Item;", "(Landroid/view/View;Ljava/util/List;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "getItems", "()Ljava/util/List;", "selected", "subTitle", "Landroid/widget/TextView;", "title", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "applyData", "", "item", "position", "", "checkStateChange", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "posChanged", "refreshCheckView", "check", "", "luggage-wechat-full-sdk_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.h$c$a */
        public static final class C2537a extends C41531v {
            final TextView gsf;
            ImageView iNr;
            final List<C2535b> items;
            final TextView jcI;
            private final ImageView jcJ;
            View view;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
            /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.h$c$a$a */
            static final class C2538a implements OnClickListener {
                final /* synthetic */ int exi;
                final /* synthetic */ C2537a jcK;
                final /* synthetic */ C2535b jcL;
                final /* synthetic */ C17126b jcM;

                C2538a(C2537a c2537a, C2535b c2535b, int i, C17126b c17126b) {
                    this.jcK = c2537a;
                    this.jcL = c2535b;
                    this.exi = i;
                    this.jcM = c17126b;
                }

                public final void onClick(View view) {
                    AppMethodBeat.m2504i(102483);
                    C2535b c2535b = this.jcL;
                    boolean z = this.jcL.jcH;
                    C2537a.m4778a(this.jcK, z);
                    if (z) {
                        z = false;
                    } else {
                        z = true;
                    }
                    c2535b.jcH = z;
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    for (Object next : this.jcK.items) {
                        int i2 = i + 1;
                        if (i < 0) {
                            C7987l.dWs();
                        }
                        C2535b c2535b2 = (C2535b) next;
                        arrayList.add(Integer.valueOf(i));
                        if (this.exi != i) {
                            if (c2535b2 == null) {
                                i = i2;
                            } else if (c2535b2.jcH) {
                                c2535b2.jcH = false;
                                arrayList.add(Integer.valueOf(this.exi));
                            }
                        }
                        i = i2;
                    }
                    this.jcM.mo50am(arrayList);
                    AppMethodBeat.m2505o(102483);
                }
            }

            public C2537a(View view, List<C2535b> list) {
                C25052j.m39376p(view, "view");
                C25052j.m39376p(list, "items");
                super(view);
                AppMethodBeat.m2504i(102485);
                this.view = view;
                this.items = list;
                View findViewById = this.view.findViewById(2131820915);
                C25052j.m39375o(findViewById, "view.findViewById(R.id.icon)");
                this.iNr = (ImageView) findViewById;
                findViewById = this.view.findViewById(2131820678);
                C25052j.m39375o(findViewById, "view.findViewById(R.id.title)");
                this.gsf = (TextView) findViewById;
                findViewById = this.view.findViewById(2131821245);
                C25052j.m39375o(findViewById, "view.findViewById(R.id.sub_title)");
                this.jcI = (TextView) findViewById;
                findViewById = this.view.findViewById(2131821246);
                C25052j.m39375o(findViewById, "view.findViewById(R.id.selected)");
                this.jcJ = (ImageView) findViewById;
                AppMethodBeat.m2505o(102485);
            }

            /* renamed from: a */
            public static final /* synthetic */ void m4778a(C2537a c2537a, boolean z) {
                AppMethodBeat.m2504i(102486);
                c2537a.mo6495eZ(z);
                AppMethodBeat.m2505o(102486);
            }

            /* Access modifiers changed, original: final */
            /* renamed from: eZ */
            public final void mo6495eZ(boolean z) {
                AppMethodBeat.m2504i(102484);
                if (this.items.size() == 1) {
                    this.jcJ.setVisibility(0);
                    AppMethodBeat.m2505o(102484);
                } else if (z) {
                    this.jcJ.setVisibility(0);
                    AppMethodBeat.m2505o(102484);
                } else {
                    this.jcJ.setVisibility(8);
                    AppMethodBeat.m2505o(102484);
                }
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, dWq = {"<anonymous>", "", "changed", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "invoke", "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$ItemAdapter$onBindViewHolder$1$1"})
        /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.h$c$b */
        static final class C2539b extends C25053k implements C17126b<ArrayList<Integer>, C37091y> {
            final /* synthetic */ int iPU;
            final /* synthetic */ C2536c jcN;
            final /* synthetic */ C2537a jcO;

            C2539b(C2536c c2536c, C2537a c2537a, int i) {
                this.jcN = c2536c;
                this.jcO = c2537a;
                this.iPU = i;
                super(1);
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                AppMethodBeat.m2504i(102487);
                ArrayList<Number> arrayList = (ArrayList) obj;
                C25052j.m39376p(arrayList, "changed");
                for (Number intValue : arrayList) {
                    this.jcN.mo66316cg(intValue.intValue());
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(102487);
                return c37091y;
            }
        }

        public C2536c(List<C2535b> list) {
            C25052j.m39376p(list, "items");
            AppMethodBeat.m2504i(102491);
            this.items = list;
            AppMethodBeat.m2505o(102491);
        }

        public final int getItemCount() {
            AppMethodBeat.m2504i(102489);
            int size = this.items.size();
            AppMethodBeat.m2505o(102489);
            return size;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH&¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "", "onMsg", "", "resultCode", "", "resultData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "luggage-wechat-full-sdk_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.h$d */
    public interface C33585d {
        /* renamed from: a */
        void mo21761a(int i, ArrayList<String> arrayList);
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.h$2 */
    static final class C335872 implements OnClickListener {
        final /* synthetic */ C33586h jcE;

        C335872(C33586h c33586h) {
            this.jcE = c33586h;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(102482);
            this.jcE.jcx.mo21761a(2, C33586h.m54836a(this.jcE, false));
            C33589k b = this.jcE.iyk;
            if (b != null) {
                b.mo6469c(this.jcE);
                AppMethodBeat.m2505o(102482);
                return;
            }
            AppMethodBeat.m2505o(102482);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.h$1 */
    static final class C335881 implements OnClickListener {
        final /* synthetic */ C33586h jcE;

        C335881(C33586h c33586h) {
            this.jcE = c33586h;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(102481);
            this.jcE.jcx.mo21761a(1, C33586h.m54836a(this.jcE, true));
            C33589k b = this.jcE.iyk;
            if (b != null) {
                b.mo6469c(this.jcE);
                AppMethodBeat.m2505o(102481);
                return;
            }
            AppMethodBeat.m2505o(102481);
        }
    }

    static {
        AppMethodBeat.m2504i(102505);
        AppMethodBeat.m2505o(102505);
    }

    public C33586h(Context context, C33585d c33585d) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(c33585d, CastExtraArgs.LISTENER);
        super(context);
        AppMethodBeat.m2504i(102504);
        View inflate = View.inflate(context, 2130968702, null);
        C25052j.m39375o(inflate, "View.inflate(context, R.…ber_manager_dialog, null)");
        this.jcl = inflate;
        this.jcx = c33585d;
        inflate = this.jcl.findViewById(2131821255);
        C25052j.m39375o(inflate, "mRootView.findViewById(R…mber_manager_dialog_icon)");
        this.iUn = (ImageView) inflate;
        inflate = this.jcl.findViewById(2131821256);
        C25052j.m39375o(inflate, "mRootView.findViewById(R…mber_manager_dialog_name)");
        this.jcm = (TextView) inflate;
        inflate = this.jcl.findViewById(2131821265);
        C25052j.m39375o(inflate, "mRootView.findViewById(R…er_manager_dialog_cancel)");
        this.jco = (Button) inflate;
        inflate = this.jcl.findViewById(2131821266);
        C25052j.m39375o(inflate, "mRootView.findViewById(R…number_manager_dialog_ok)");
        this.jcn = (Button) inflate;
        inflate = this.jcl.findViewById(2131821259);
        C25052j.m39375o(inflate, "mRootView.findViewById(R.id.request_desc)");
        this.jcp = (TextView) inflate;
        inflate = this.jcl.findViewById(2131821260);
        C25052j.m39375o(inflate, "mRootView.findViewById(R.id.simple_detail_desc)");
        this.jcq = (TextView) inflate;
        inflate = this.jcl.findViewById(2131821019);
        C25052j.m39375o(inflate, "mRootView.findViewById(R.id.content)");
        this.jct = (LinearLayout) inflate;
        inflate = this.jcl.findViewById(2131821258);
        C25052j.m39375o(inflate, "mRootView.findViewById(R…r_manager_dialog_explain)");
        this.jcr = (ImageView) inflate;
        inflate = this.jcl.findViewById(2131821257);
        C25052j.m39375o(inflate, "mRootView.findViewById(R.id.action)");
        this.jcs = (TextView) inflate;
        inflate = this.jcl.findViewById(2131821261);
        C25052j.m39375o(inflate, "mRootView.findViewById(R…ager_dialog_recyclerview)");
        this.iJP = (RecyclerView) inflate;
        this.iJP.setLayoutManager(new LinearLayoutManager());
        inflate = this.jcl.findViewById(2131821262);
        C25052j.m39375o(inflate, "mRootView.findViewById(R…r_manager_dialog_loading)");
        this.jcv = inflate;
        inflate = this.jcl.findViewById(2131821264);
        C25052j.m39375o(inflate, "mRootView.findViewById(R.id.button_group)");
        this.iyw = inflate;
        inflate = this.jcl.findViewById(2131821263);
        C25052j.m39375o(inflate, "mRootView.findViewById(R…_manager_dialog_function)");
        this.jcu = (TextView) inflate;
        this.jcn.setOnClickListener(new C335881(this));
        this.jco.setOnClickListener(new C335872(this));
        this.iJP.setItemAnimator(null);
        AppMethodBeat.m2505o(102504);
    }

    /* renamed from: Ez */
    public final void mo54099Ez(String str) {
        AppMethodBeat.m2504i(102492);
        this.jcz = str;
        this.jcm.setText(str != null ? str : "");
        AppMethodBeat.m2505o(102492);
    }

    /* renamed from: EA */
    public final void mo54093EA(String str) {
        AppMethodBeat.m2504i(102493);
        this.jcA = str;
        this.jcp.setText(str);
        AppMethodBeat.m2505o(102493);
    }

    /* renamed from: EB */
    public final void mo54094EB(String str) {
        AppMethodBeat.m2504i(102494);
        this.jcB = str;
        if (str != null) {
            this.jcq.setVisibility(0);
            this.jcq.setText(str);
        }
        AppMethodBeat.m2505o(102494);
    }

    /* renamed from: EC */
    public final void mo54095EC(String str) {
        AppMethodBeat.m2504i(102495);
        this.jcC = str;
        this.jcs.setText(str);
        AppMethodBeat.m2505o(102495);
    }

    /* renamed from: jl */
    public final void mo54101jl(String str) {
        AppMethodBeat.m2504i(102496);
        this.iconUrl = str;
        C37926b.abR().mo60682a(this.iUn, this.iconUrl, (int) C25738R.drawable.bbn, (C37932f) C42201f.fqH);
        AppMethodBeat.m2505o(102496);
    }

    /* renamed from: a */
    public final void mo15058a(C33589k c33589k) {
        AppMethodBeat.m2504i(102497);
        OnShowListener onShowListener = this.jcw;
        if (onShowListener != null) {
            onShowListener.onShow(this);
        }
        this.iyk = c33589k;
        Object systemService = getContext().getSystemService("window");
        if (!(systemService instanceof WindowManager)) {
            systemService = null;
        }
        WindowManager windowManager = (WindowManager) systemService;
        if (windowManager != null) {
            C10942a c10942a = C10941l.jcT;
            Context context = getContext();
            C25052j.m39375o(context, "context");
            View view = this.jcl;
            View view2 = this.iyw;
            Display defaultDisplay = windowManager.getDefaultDisplay();
            C25052j.m39375o(defaultDisplay, "it.defaultDisplay");
            C10942a.m18668a(context, view, view2, defaultDisplay.getRotation());
            AppMethodBeat.m2505o(102497);
            return;
        }
        AppMethodBeat.m2505o(102497);
    }

    /* renamed from: pF */
    public final void mo15063pF(int i) {
        AppMethodBeat.m2504i(102498);
        C10942a c10942a = C10941l.jcT;
        Context context = getContext();
        C25052j.m39375o(context, "context");
        C10942a.m18668a(context, this.jcl, this.iyw, i);
        AppMethodBeat.m2505o(102498);
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(102499);
        super.dismiss();
        OnDismissListener onDismissListener = this.f15041Uf;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
            AppMethodBeat.m2505o(102499);
            return;
        }
        AppMethodBeat.m2505o(102499);
    }

    public final void onCancel() {
        AppMethodBeat.m2504i(102500);
        this.jcx.mo21761a(3, new ArrayList());
        AppMethodBeat.m2505o(102500);
    }

    public final boolean aKP() {
        return false;
    }

    public final boolean isCancelable() {
        return true;
    }

    public final View getContentView() {
        return this.jcl;
    }

    /* renamed from: ED */
    public final void mo54096ED(String str) {
        AppMethodBeat.m2504i(102501);
        if (str != null) {
            this.jco.setText(str);
            AppMethodBeat.m2505o(102501);
            return;
        }
        AppMethodBeat.m2505o(102501);
    }

    /* renamed from: EE */
    public final void mo54097EE(String str) {
        AppMethodBeat.m2504i(102502);
        if (str != null) {
            this.jcn.setText(str);
            AppMethodBeat.m2505o(102502);
            return;
        }
        AppMethodBeat.m2505o(102502);
    }

    public final int getPosition() {
        return 2;
    }

    /* renamed from: EF */
    public final void mo54098EF(String str) {
        AppMethodBeat.m2504i(102503);
        C25052j.m39376p(str, "scope");
        this.hCq = str;
        AppMethodBeat.m2505o(102503);
    }

    /* renamed from: a */
    public static final /* synthetic */ ArrayList m54836a(C33586h c33586h, boolean z) {
        AppMethodBeat.m2504i(102506);
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(c33586h.hCq)) {
            int size;
            C2536c c2536c = c33586h.jcy;
            List list;
            if (c2536c != null) {
                list = c2536c.items;
            } else {
                list = null;
            }
            if (list != null) {
                size = list.size();
            } else {
                size = 0;
            }
            C2535b c2535b;
            if (size == 1) {
                if (list != null) {
                    c2535b = (C2535b) list.get(0);
                    if (c2535b != null) {
                        String str = c2535b.scope;
                        if (str != null) {
                            arrayList.add(str);
                        }
                    }
                }
                AppMethodBeat.m2505o(102506);
                return arrayList;
            }
            if (list != null) {
                for (C2535b c2535b2 : list) {
                    if (!(c2535b2 == null || c2535b2.jcH != z || c2535b2.scope == null)) {
                        arrayList.add(c2535b2.scope);
                    }
                }
            }
            AppMethodBeat.m2505o(102506);
            return arrayList;
        }
        arrayList.add(c33586h.hCq);
        AppMethodBeat.m2505o(102506);
        return arrayList;
    }
}
