package com.tencent.p177mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C33589k;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C38571j;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u001cH\u0016J\u0012\u0010$\u001a\u00020\u00172\b\u0010%\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010&\u001a\u00020\u00172\b\b\u0002\u0010'\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006("}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberExplainDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "appId", "", "pageUrl", "context", "Landroid/content/Context;", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V", "getAppId", "()Ljava/lang/String;", "backIv", "Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContext", "()Landroid/content/Context;", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "getPageUrl", "rootView", "Landroid/view/View;", "titleTv", "cancel", "", "content", "dismiss", "getContentView", "getPosition", "", "isCancelable", "", "isCanceledOnTouchOutside", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "tryshow", "height", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.k */
public final class C41251k implements C38571j {
    private final String appId;
    final Context context;
    final TextView gKl;
    private final TextView gne;
    private final String hzj;
    C33589k iyk;
    final ImageView iyl;
    final View iym;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.k$a */
    static final class C41252a implements OnClickListener {
        final /* synthetic */ C41251k iyn;

        C41252a(C41251k c41251k) {
            this.iyn = c41251k;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(134844);
            C33589k a = this.iyn.iyk;
            if (a != null) {
                a.mo6469c(this.iyn);
                AppMethodBeat.m2505o(134844);
                return;
            }
            AppMethodBeat.m2505o(134844);
        }
    }

    public C41251k(String str, String str2, Context context) {
        C25052j.m39376p(str, "appId");
        C25052j.m39376p(str2, "pageUrl");
        C25052j.m39376p(context, "context");
        AppMethodBeat.m2504i(134845);
        this.appId = str;
        this.hzj = str2;
        this.context = context;
        View inflate = View.inflate(this.context, 2130968701, null);
        C25052j.m39375o(inflate, "View.inflate(context, R.…ber_explain_dialog, null)");
        this.iym = inflate;
        inflate = this.iym.findViewById(2131821252);
        C25052j.m39375o(inflate, "rootView.findViewById(R.…mber_explain_dialog_back)");
        this.iyl = (ImageView) inflate;
        inflate = this.iym.findViewById(2131821253);
        C25052j.m39375o(inflate, "rootView.findViewById(R.…ber_explain_dialog_title)");
        this.gne = (TextView) inflate;
        inflate = this.iym.findViewById(2131821254);
        C25052j.m39375o(inflate, "rootView.findViewById(R.…r_explain_dialog_content)");
        this.gKl = (TextView) inflate;
        AppMethodBeat.m2505o(134845);
    }

    public final void dismiss() {
    }

    public final int getPosition() {
        return 2;
    }

    public final void cancel() {
    }

    /* renamed from: a */
    public final void mo15058a(C33589k c33589k) {
    }

    public final void onCancel() {
    }

    public final View getContentView() {
        return this.iym;
    }

    /* renamed from: pF */
    public final void mo15063pF(int i) {
    }

    public final boolean aKP() {
        return true;
    }

    public final boolean isCancelable() {
        return true;
    }
}
