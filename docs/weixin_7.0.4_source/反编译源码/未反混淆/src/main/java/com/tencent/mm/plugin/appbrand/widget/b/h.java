package com.tencent.mm.plugin.appbrand.widget.b;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.b.f;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0004[\\]^B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020\u0013H\u0016J\b\u0010B\u001a\u00020CH\u0016J \u0010D\u001a\u0012\u0012\u0004\u0012\u00020\t0Ej\b\u0012\u0004\u0012\u00020\t`F2\u0006\u0010G\u001a\u00020HH\u0002J\b\u0010I\u001a\u00020HH\u0016J\b\u0010J\u001a\u00020HH\u0016J\b\u0010K\u001a\u00020@H\u0016J\b\u0010L\u001a\u00020@H\u0016J\u0010\u0010M\u001a\u00020@2\u0006\u0010N\u001a\u00020CH\u0016J\u0012\u0010O\u001a\u00020@2\b\u0010P\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010Q\u001a\u00020@2\b\u0010R\u001a\u0004\u0018\u00010\tJ\u0010\u0010S\u001a\u00020@2\b\u0010T\u001a\u0004\u0018\u00010\tJ\u000e\u0010U\u001a\u00020@2\u0006\u0010V\u001a\u00020\tJ\u0016\u0010W\u001a\u00020@2\u000e\u0010X\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010YR(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\b\u001a\u0004\u0018\u00010\u0016@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\u001c\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u000e\u0010\u001f\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u000e¢\u0006\u0002\n\u0000R(\u00109\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\f\"\u0004\b;\u0010\u000eR(\u0010<\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\f\"\u0004\b>\u0010\u000e¨\u0006_"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "listener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;)V", "value", "", "appBrandName", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "applyWording", "getApplyWording", "setApplyWording", "buttonGroup", "Landroid/view/View;", "funcTv", "Landroid/widget/TextView;", "Landroid/graphics/Bitmap;", "icon", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "iconUrl", "getIconUrl", "setIconUrl", "loadingView", "mAdapter", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$ItemAdapter;", "mApplyWordingTv", "mBtnAccept", "Landroid/widget/Button;", "mBtnReject", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "mExplainIv", "Landroid/widget/ImageView;", "mIconIv", "mListener", "mNameTv", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mOnShowListener", "Landroid/content/DialogInterface$OnShowListener;", "mRequestDescTv", "mRootView", "mScope", "mSelectListLayout", "Landroid/widget/LinearLayout;", "mSimpleDetailDescTv", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "requestDesc", "getRequestDesc", "setRequestDesc", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "dismiss", "", "getContentView", "getPosition", "", "getScope", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "check", "", "isCancelable", "isCanceledOnTouchOutside", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "setNegativeButtonText", "cancelWording", "setPositiveButtonText", "allowWording", "setScope", "scope", "setSelectListItem", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Item;", "Companion", "Item", "ItemAdapter", "Listener", "luggage-wechat-full-sdk_release"})
public final class h extends Dialog implements j {
    public static final a jcD = new a();
    private OnDismissListener Uf;
    private String hCq = "";
    public RecyclerView iJP;
    private ImageView iUn;
    private String iconUrl;
    private k iyk;
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
    private d jcx;
    public c jcy;
    private String jcz;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Companion;", "", "()V", "ALERT_RESULT_CODE_ACCEPT", "", "ALERT_RESULT_CODE_CANCEL", "ALERT_RESULT_CODE_REJECT", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B/\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB5\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Item;", "", "subTitle", "", "title", "scope", "icon", "Landroid/graphics/Bitmap;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;)V", "check", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Z)V", "getCheck", "()Z", "setCheck", "(Z)V", "getIcon", "()Landroid/graphics/Bitmap;", "setIcon", "(Landroid/graphics/Bitmap;)V", "getScope", "()Ljava/lang/String;", "getSubTitle", "getTitle", "luggage-wechat-full-sdk_release"})
    public static final class b {
        final String jcF;
        Bitmap jcG;
        boolean jcH;
        final String scope;
        final String title;

        private b(String str, String str2, String str3, Bitmap bitmap) {
            this.title = str;
            this.jcF = str2;
            this.scope = str3;
            this.jcG = bitmap;
            this.jcH = false;
        }

        public b(String str, String str2, String str3, Bitmap bitmap, byte b) {
            this(str2, str, str3, bitmap);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\"\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$ItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$ItemAdapter$ViewHolder;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Item;", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "setItems", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "luggage-wechat-full-sdk_release"})
    public static final class c extends android.support.v7.widget.RecyclerView.a<a> {
        List<b> items;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007JI\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c21\u0010\u001d\u001a-\u0012#\u0012!\u0012\u0004\u0012\u00020\u001c0\u001fj\b\u0012\u0004\u0012\u00020\u001c` ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00190\u001eJ\u0010\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&H\u0002R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006'"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$ItemAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Item;", "(Landroid/view/View;Ljava/util/List;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "getItems", "()Ljava/util/List;", "selected", "subTitle", "Landroid/widget/TextView;", "title", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "applyData", "", "item", "position", "", "checkStateChange", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "posChanged", "refreshCheckView", "check", "", "luggage-wechat-full-sdk_release"})
        public static final class a extends v {
            final TextView gsf;
            ImageView iNr;
            final List<b> items;
            final TextView jcI;
            private final ImageView jcJ;
            View view;

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
            static final class a implements OnClickListener {
                final /* synthetic */ int exi;
                final /* synthetic */ a jcK;
                final /* synthetic */ b jcL;
                final /* synthetic */ a.f.a.b jcM;

                a(a aVar, b bVar, int i, a.f.a.b bVar2) {
                    this.jcK = aVar;
                    this.jcL = bVar;
                    this.exi = i;
                    this.jcM = bVar2;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(102483);
                    b bVar = this.jcL;
                    boolean z = this.jcL.jcH;
                    a.a(this.jcK, z);
                    if (z) {
                        z = false;
                    } else {
                        z = true;
                    }
                    bVar.jcH = z;
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    for (Object next : this.jcK.items) {
                        int i2 = i + 1;
                        if (i < 0) {
                            a.a.l.dWs();
                        }
                        b bVar2 = (b) next;
                        arrayList.add(Integer.valueOf(i));
                        if (this.exi != i) {
                            if (bVar2 == null) {
                                i = i2;
                            } else if (bVar2.jcH) {
                                bVar2.jcH = false;
                                arrayList.add(Integer.valueOf(this.exi));
                            }
                        }
                        i = i2;
                    }
                    this.jcM.am(arrayList);
                    AppMethodBeat.o(102483);
                }
            }

            public a(View view, List<b> list) {
                j.p(view, "view");
                j.p(list, "items");
                super(view);
                AppMethodBeat.i(102485);
                this.view = view;
                this.items = list;
                View findViewById = this.view.findViewById(R.id.jb);
                j.o(findViewById, "view.findViewById(R.id.icon)");
                this.iNr = (ImageView) findViewById;
                findViewById = this.view.findViewById(R.id.cx);
                j.o(findViewById, "view.findViewById(R.id.title)");
                this.gsf = (TextView) findViewById;
                findViewById = this.view.findViewById(R.id.s9);
                j.o(findViewById, "view.findViewById(R.id.sub_title)");
                this.jcI = (TextView) findViewById;
                findViewById = this.view.findViewById(R.id.s_);
                j.o(findViewById, "view.findViewById(R.id.selected)");
                this.jcJ = (ImageView) findViewById;
                AppMethodBeat.o(102485);
            }

            public static final /* synthetic */ void a(a aVar, boolean z) {
                AppMethodBeat.i(102486);
                aVar.eZ(z);
                AppMethodBeat.o(102486);
            }

            /* Access modifiers changed, original: final */
            public final void eZ(boolean z) {
                AppMethodBeat.i(102484);
                if (this.items.size() == 1) {
                    this.jcJ.setVisibility(0);
                    AppMethodBeat.o(102484);
                } else if (z) {
                    this.jcJ.setVisibility(0);
                    AppMethodBeat.o(102484);
                } else {
                    this.jcJ.setVisibility(8);
                    AppMethodBeat.o(102484);
                }
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, dWq = {"<anonymous>", "", "changed", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "invoke", "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$ItemAdapter$onBindViewHolder$1$1"})
        static final class b extends k implements a.f.a.b<ArrayList<Integer>, y> {
            final /* synthetic */ int iPU;
            final /* synthetic */ c jcN;
            final /* synthetic */ a jcO;

            b(c cVar, a aVar, int i) {
                this.jcN = cVar;
                this.jcO = aVar;
                this.iPU = i;
                super(1);
            }

            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(102487);
                ArrayList<Number> arrayList = (ArrayList) obj;
                j.p(arrayList, "changed");
                for (Number intValue : arrayList) {
                    this.jcN.cg(intValue.intValue());
                }
                y yVar = y.AUy;
                AppMethodBeat.o(102487);
                return yVar;
            }
        }

        public c(List<b> list) {
            j.p(list, "items");
            AppMethodBeat.i(102491);
            this.items = list;
            AppMethodBeat.o(102491);
        }

        public final int getItemCount() {
            AppMethodBeat.i(102489);
            int size = this.items.size();
            AppMethodBeat.o(102489);
            return size;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH&¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "", "onMsg", "", "resultCode", "", "resultData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "luggage-wechat-full-sdk_release"})
    public interface d {
        void a(int i, ArrayList<String> arrayList);
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.h$2 */
    static final class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ h jcE;

        AnonymousClass2(h hVar) {
            this.jcE = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(102482);
            this.jcE.jcx.a(2, h.a(this.jcE, false));
            k b = this.jcE.iyk;
            if (b != null) {
                b.c(this.jcE);
                AppMethodBeat.o(102482);
                return;
            }
            AppMethodBeat.o(102482);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.h$1 */
    static final class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ h jcE;

        AnonymousClass1(h hVar) {
            this.jcE = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(102481);
            this.jcE.jcx.a(1, h.a(this.jcE, true));
            k b = this.jcE.iyk;
            if (b != null) {
                b.c(this.jcE);
                AppMethodBeat.o(102481);
                return;
            }
            AppMethodBeat.o(102481);
        }
    }

    static {
        AppMethodBeat.i(102505);
        AppMethodBeat.o(102505);
    }

    public h(Context context, d dVar) {
        j.p(context, "context");
        j.p(dVar, CastExtraArgs.LISTENER);
        super(context);
        AppMethodBeat.i(102504);
        View inflate = View.inflate(context, R.layout.cp, null);
        j.o(inflate, "View.inflate(context, R.…ber_manager_dialog, null)");
        this.jcl = inflate;
        this.jcx = dVar;
        inflate = this.jcl.findViewById(R.id.si);
        j.o(inflate, "mRootView.findViewById(R…mber_manager_dialog_icon)");
        this.iUn = (ImageView) inflate;
        inflate = this.jcl.findViewById(R.id.sj);
        j.o(inflate, "mRootView.findViewById(R…mber_manager_dialog_name)");
        this.jcm = (TextView) inflate;
        inflate = this.jcl.findViewById(R.id.ss);
        j.o(inflate, "mRootView.findViewById(R…er_manager_dialog_cancel)");
        this.jco = (Button) inflate;
        inflate = this.jcl.findViewById(R.id.st);
        j.o(inflate, "mRootView.findViewById(R…number_manager_dialog_ok)");
        this.jcn = (Button) inflate;
        inflate = this.jcl.findViewById(R.id.sm);
        j.o(inflate, "mRootView.findViewById(R.id.request_desc)");
        this.jcp = (TextView) inflate;
        inflate = this.jcl.findViewById(R.id.sn);
        j.o(inflate, "mRootView.findViewById(R.id.simple_detail_desc)");
        this.jcq = (TextView) inflate;
        inflate = this.jcl.findViewById(R.id.m5);
        j.o(inflate, "mRootView.findViewById(R.id.content)");
        this.jct = (LinearLayout) inflate;
        inflate = this.jcl.findViewById(R.id.sl);
        j.o(inflate, "mRootView.findViewById(R…r_manager_dialog_explain)");
        this.jcr = (ImageView) inflate;
        inflate = this.jcl.findViewById(R.id.sk);
        j.o(inflate, "mRootView.findViewById(R.id.action)");
        this.jcs = (TextView) inflate;
        inflate = this.jcl.findViewById(R.id.so);
        j.o(inflate, "mRootView.findViewById(R…ager_dialog_recyclerview)");
        this.iJP = (RecyclerView) inflate;
        this.iJP.setLayoutManager(new LinearLayoutManager());
        inflate = this.jcl.findViewById(R.id.sp);
        j.o(inflate, "mRootView.findViewById(R…r_manager_dialog_loading)");
        this.jcv = inflate;
        inflate = this.jcl.findViewById(R.id.sr);
        j.o(inflate, "mRootView.findViewById(R.id.button_group)");
        this.iyw = inflate;
        inflate = this.jcl.findViewById(R.id.sq);
        j.o(inflate, "mRootView.findViewById(R…_manager_dialog_function)");
        this.jcu = (TextView) inflate;
        this.jcn.setOnClickListener(new AnonymousClass1(this));
        this.jco.setOnClickListener(new AnonymousClass2(this));
        this.iJP.setItemAnimator(null);
        AppMethodBeat.o(102504);
    }

    public final void Ez(String str) {
        AppMethodBeat.i(102492);
        this.jcz = str;
        this.jcm.setText(str != null ? str : "");
        AppMethodBeat.o(102492);
    }

    public final void EA(String str) {
        AppMethodBeat.i(102493);
        this.jcA = str;
        this.jcp.setText(str);
        AppMethodBeat.o(102493);
    }

    public final void EB(String str) {
        AppMethodBeat.i(102494);
        this.jcB = str;
        if (str != null) {
            this.jcq.setVisibility(0);
            this.jcq.setText(str);
        }
        AppMethodBeat.o(102494);
    }

    public final void EC(String str) {
        AppMethodBeat.i(102495);
        this.jcC = str;
        this.jcs.setText(str);
        AppMethodBeat.o(102495);
    }

    public final void jl(String str) {
        AppMethodBeat.i(102496);
        this.iconUrl = str;
        com.tencent.mm.modelappbrand.a.b.abR().a(this.iUn, this.iconUrl, (int) R.drawable.bbn, (f) com.tencent.mm.modelappbrand.a.f.fqH);
        AppMethodBeat.o(102496);
    }

    public final void a(k kVar) {
        AppMethodBeat.i(102497);
        OnShowListener onShowListener = this.jcw;
        if (onShowListener != null) {
            onShowListener.onShow(this);
        }
        this.iyk = kVar;
        Object systemService = getContext().getSystemService("window");
        if (!(systemService instanceof WindowManager)) {
            systemService = null;
        }
        WindowManager windowManager = (WindowManager) systemService;
        if (windowManager != null) {
            com.tencent.mm.plugin.appbrand.widget.b.l.a aVar = l.jcT;
            Context context = getContext();
            j.o(context, "context");
            View view = this.jcl;
            View view2 = this.iyw;
            Display defaultDisplay = windowManager.getDefaultDisplay();
            j.o(defaultDisplay, "it.defaultDisplay");
            com.tencent.mm.plugin.appbrand.widget.b.l.a.a(context, view, view2, defaultDisplay.getRotation());
            AppMethodBeat.o(102497);
            return;
        }
        AppMethodBeat.o(102497);
    }

    public final void pF(int i) {
        AppMethodBeat.i(102498);
        com.tencent.mm.plugin.appbrand.widget.b.l.a aVar = l.jcT;
        Context context = getContext();
        j.o(context, "context");
        com.tencent.mm.plugin.appbrand.widget.b.l.a.a(context, this.jcl, this.iyw, i);
        AppMethodBeat.o(102498);
    }

    public final void dismiss() {
        AppMethodBeat.i(102499);
        super.dismiss();
        OnDismissListener onDismissListener = this.Uf;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
            AppMethodBeat.o(102499);
            return;
        }
        AppMethodBeat.o(102499);
    }

    public final void onCancel() {
        AppMethodBeat.i(102500);
        this.jcx.a(3, new ArrayList());
        AppMethodBeat.o(102500);
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

    public final void ED(String str) {
        AppMethodBeat.i(102501);
        if (str != null) {
            this.jco.setText(str);
            AppMethodBeat.o(102501);
            return;
        }
        AppMethodBeat.o(102501);
    }

    public final void EE(String str) {
        AppMethodBeat.i(102502);
        if (str != null) {
            this.jcn.setText(str);
            AppMethodBeat.o(102502);
            return;
        }
        AppMethodBeat.o(102502);
    }

    public final int getPosition() {
        return 2;
    }

    public final void EF(String str) {
        AppMethodBeat.i(102503);
        j.p(str, "scope");
        this.hCq = str;
        AppMethodBeat.o(102503);
    }

    public static final /* synthetic */ ArrayList a(h hVar, boolean z) {
        AppMethodBeat.i(102506);
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(hVar.hCq)) {
            int size;
            c cVar = hVar.jcy;
            List list;
            if (cVar != null) {
                list = cVar.items;
            } else {
                list = null;
            }
            if (list != null) {
                size = list.size();
            } else {
                size = 0;
            }
            b bVar;
            if (size == 1) {
                if (list != null) {
                    bVar = (b) list.get(0);
                    if (bVar != null) {
                        String str = bVar.scope;
                        if (str != null) {
                            arrayList.add(str);
                        }
                    }
                }
                AppMethodBeat.o(102506);
                return arrayList;
            }
            if (list != null) {
                for (b bVar2 : list) {
                    if (!(bVar2 == null || bVar2.jcH != z || bVar2.scope == null)) {
                        arrayList.add(bVar2.scope);
                    }
                }
            }
            AppMethodBeat.o(102506);
            return arrayList;
        }
        arrayList.add(hVar.hCq);
        AppMethodBeat.o(102506);
        return arrayList;
    }
}
