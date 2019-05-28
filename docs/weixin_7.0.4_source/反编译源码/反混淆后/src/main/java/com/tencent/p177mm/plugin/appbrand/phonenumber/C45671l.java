package com.tencent.p177mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Looper;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37932f;
import com.tencent.p177mm.modelappbrand.p873a.C42201f;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C10941l;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C10941l.C10942a;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C33589k;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C38571j;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.ArrayList;
import java.util.Iterator;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 F2\u00020\u0001:\u0002FGB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010.\u001a\u00020/H\u0016J\u000e\u00100\u001a\u00020/2\u0006\u00100\u001a\u000201J\b\u00102\u001a\u00020/H\u0016J\u000e\u00103\u001a\u00020/2\u0006\u00103\u001a\u000201J\u000e\u00104\u001a\u00020/2\u0006\u00104\u001a\u000201J\b\u00105\u001a\u00020\nH\u0016J\u0006\u00106\u001a\u000207J\b\u00108\u001a\u000207H\u0016J\u000e\u00109\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0005J\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020;H\u0016J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0005J\b\u0010=\u001a\u00020/H\u0016J\b\u0010>\u001a\u00020/H\u0016J\u0010\u0010?\u001a\u00020/2\u0006\u0010@\u001a\u000207H\u0016J\u0012\u0010A\u001a\u00020/2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u001e\u0010)\u001a\u00020\u00002\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020+0*j\b\u0012\u0004\u0012\u00020+`,J\u0006\u0010D\u001a\u00020/J\b\u0010E\u001a\u00020/H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u0012\u0012\u0004\u0012\u00020+0*j\b\u0012\u0004\u0012\u00020+`,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "appId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "buttonGroup", "Landroid/view/View;", "getContext", "()Landroid/content/Context;", "denyTv", "Landroid/widget/TextView;", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "getDismissListener", "()Landroid/content/DialogInterface$OnDismissListener;", "setDismissListener", "(Landroid/content/DialogInterface$OnDismissListener;)V", "explainIv", "Landroid/widget/ImageView;", "functionTv", "iconIv", "iconUrl", "itemAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "listRv", "Landroid/support/v7/widget/RecyclerView;", "loadingV", "Landroid/widget/ProgressBar;", "name", "nameTv", "okTv", "onPhoneItemSelect", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$OnPhoneItemSelect;", "getOnPhoneItemSelect", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$OnPhoneItemSelect;", "setOnPhoneItemSelect", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$OnPhoneItemSelect;)V", "phoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "rootView", "cancel", "", "denyListener", "Landroid/view/View$OnClickListener;", "dismiss", "explainListener", "functionListener", "getContentView", "getDialogHeight", "", "getPosition", "icon", "isCancelable", "", "isCanceledOnTouchOutside", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "updateDialog", "updateDialogInner", "Companion", "OnPhoneItemSelect", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.l */
public final class C45671l implements C38571j {
    public static final C27271a iyy = new C27271a();
    private final String appId;
    OnDismissListener cMR;
    private final Context context;
    private final TextView gtb;
    private String iconUrl = "";
    private ArrayList<PhoneItem> ixy = new ArrayList();
    final View iym;
    private final ImageView iyo;
    private final RecyclerView iyp;
    private final ProgressBar iyq;
    final TextView iyr;
    private final TextView iys;
    final TextView iyt;
    final ImageView iyu;
    private C44716i iyv;
    private View iyw;
    C2433b iyx;
    private String name = "";

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$OnPhoneItemSelect;", "", "onPhoneItemSelect", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.l$b */
    public interface C2433b {
        /* renamed from: c */
        void mo6347c(PhoneItem phoneItem);
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.l$c */
    static final class C10700c implements Runnable {
        final /* synthetic */ C45671l iyz;

        C10700c(C45671l c45671l) {
            this.iyz = c45671l;
        }

        public final void run() {
            AppMethodBeat.m2504i(134847);
            C45671l.m84363a(this.iyz);
            AppMethodBeat.m2505o(134847);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.l$1 */
    static final class C272701 implements OnClickListener {
        final /* synthetic */ C45671l iyz;

        C272701(C45671l c45671l) {
            this.iyz = c45671l;
        }

        public final void onClick(View view) {
            ArrayList arrayList;
            AppMethodBeat.m2504i(134846);
            C44716i b = this.iyz.iyv;
            if (b != null) {
                arrayList = b.ixy;
            } else {
                arrayList = null;
            }
            if (arrayList == null) {
                C25052j.dWJ();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                PhoneItem phoneItem = (PhoneItem) it.next();
                if (phoneItem.ixN) {
                    C2433b c2433b = this.iyz.iyx;
                    if (c2433b != null) {
                        C25052j.m39375o(phoneItem, "phoneItem");
                        c2433b.mo6347c(phoneItem);
                        AppMethodBeat.m2505o(134846);
                        return;
                    }
                    AppMethodBeat.m2505o(134846);
                    return;
                }
            }
            AppMethodBeat.m2505o(134846);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$Companion;", "", "()V", "MAX_COUNT", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.l$a */
    public static final class C27271a {
        private C27271a() {
        }

        public /* synthetic */ C27271a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(134857);
        AppMethodBeat.m2505o(134857);
    }

    public C45671l(Context context, String str) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(str, "appId");
        AppMethodBeat.m2504i(134856);
        this.context = context;
        this.appId = str;
        View inflate = View.inflate(this.context, 2130968702, null);
        C25052j.m39375o(inflate, "View.inflate(context, R.…ber_manager_dialog, null)");
        this.iym = inflate;
        inflate = this.iym.findViewById(2131821255);
        C25052j.m39375o(inflate, "rootView.findViewById(R.…mber_manager_dialog_icon)");
        this.iyo = (ImageView) inflate;
        inflate = this.iym.findViewById(2131821256);
        C25052j.m39375o(inflate, "rootView.findViewById(R.…mber_manager_dialog_name)");
        this.gtb = (TextView) inflate;
        inflate = this.iym.findViewById(2131821263);
        C25052j.m39375o(inflate, "rootView.findViewById(R.…_manager_dialog_function)");
        this.iyr = (TextView) inflate;
        inflate = this.iym.findViewById(2131821266);
        C25052j.m39375o(inflate, "rootView.findViewById(R.…number_manager_dialog_ok)");
        this.iys = (TextView) inflate;
        inflate = this.iym.findViewById(2131821265);
        C25052j.m39375o(inflate, "rootView.findViewById(R.…er_manager_dialog_cancel)");
        this.iyt = (TextView) inflate;
        inflate = this.iym.findViewById(2131821258);
        C25052j.m39375o(inflate, "rootView.findViewById(R.…r_manager_dialog_explain)");
        this.iyu = (ImageView) inflate;
        inflate = this.iym.findViewById(2131821019);
        C25052j.m39375o(inflate, "rootView.findViewById<View>(R.id.content)");
        inflate.setVisibility(0);
        inflate = this.iym.findViewById(2131821264);
        C25052j.m39375o(inflate, "rootView.findViewById(R.id.button_group)");
        this.iyw = inflate;
        inflate = this.iym.findViewById(2131821262);
        C25052j.m39375o(inflate, "rootView.findViewById(R.…r_manager_dialog_loading)");
        this.iyq = (ProgressBar) inflate;
        inflate = this.iym.findViewById(2131821261);
        C25052j.m39375o(inflate, "rootView.findViewById(R.…ager_dialog_recyclerview)");
        this.iyp = (RecyclerView) inflate;
        this.iyp.setLayoutManager(new LinearLayoutManager());
        this.iyv = new C44716i(this.appId, this.context, this.ixy);
        this.iyp.setAdapter(this.iyv);
        this.iys.setOnClickListener(new C272701(this));
        AppMethodBeat.m2505o(134856);
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(134848);
        OnDismissListener onDismissListener = this.cMR;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(null);
            AppMethodBeat.m2505o(134848);
            return;
        }
        AppMethodBeat.m2505o(134848);
    }

    public final void cancel() {
    }

    /* renamed from: Dt */
    public final C45671l mo73464Dt(String str) {
        AppMethodBeat.m2504i(134849);
        C25052j.m39376p(str, "iconUrl");
        this.iconUrl = str;
        AppMethodBeat.m2505o(134849);
        return this;
    }

    /* renamed from: Du */
    public final C45671l mo73465Du(String str) {
        AppMethodBeat.m2504i(134850);
        C25052j.m39376p(str, "name");
        this.name = str;
        AppMethodBeat.m2505o(134850);
        return this;
    }

    /* renamed from: p */
    public final C45671l mo73469p(ArrayList<PhoneItem> arrayList) {
        AppMethodBeat.m2504i(134851);
        C25052j.m39376p(arrayList, "phoneItems");
        this.ixy.clear();
        this.ixy.addAll(arrayList);
        AppMethodBeat.m2505o(134851);
        return this;
    }

    public final void aKQ() {
        AppMethodBeat.m2504i(134852);
        Looper mainLooper = Looper.getMainLooper();
        C25052j.m39375o(mainLooper, "Looper.getMainLooper()");
        if (C25052j.m39373j(mainLooper.getThread(), Thread.currentThread())) {
            aKR();
            AppMethodBeat.m2505o(134852);
            return;
        }
        C5004al.m7441d(new C10700c(this));
        AppMethodBeat.m2505o(134852);
    }

    private final void aKR() {
        AppMethodBeat.m2504i(134853);
        C37926b.abR().mo60683a(this.iyo, this.iconUrl, null, (C37932f) C42201f.fqH);
        this.gtb.setText(this.name);
        if (this.ixy.size() == 0) {
            this.iyq.setVisibility(0);
            this.iyp.setVisibility(8);
            this.iyr.setVisibility(8);
            AppMethodBeat.m2505o(134853);
        } else if (this.ixy.size() == 1) {
            this.iyq.setVisibility(8);
            this.iyp.setVisibility(0);
            this.iyr.setVisibility(0);
            this.iyp.getAdapter().notifyDataSetChanged();
            this.iyr.setText(this.context.getString(C25738R.string.f9309w9));
            AppMethodBeat.m2505o(134853);
        } else {
            this.iyq.setVisibility(8);
            this.iyp.setVisibility(0);
            this.iyr.setVisibility(0);
            this.iyp.getAdapter().notifyDataSetChanged();
            this.iyr.setText(this.context.getString(C25738R.string.f9308w7));
            AppMethodBeat.m2505o(134853);
        }
    }

    public final int getPosition() {
        return 2;
    }

    /* renamed from: a */
    public final void mo15058a(C33589k c33589k) {
        AppMethodBeat.m2504i(134854);
        aKR();
        AppMethodBeat.m2505o(134854);
    }

    public final void onCancel() {
    }

    public final boolean aKP() {
        return false;
    }

    public final boolean isCancelable() {
        return true;
    }

    public final View getContentView() {
        return this.iym;
    }

    /* renamed from: pF */
    public final void mo15063pF(int i) {
        AppMethodBeat.m2504i(134855);
        C10942a c10942a = C10941l.jcT;
        C10942a.m18668a(this.context, this.iym, this.iyw, i);
        AppMethodBeat.m2505o(134855);
    }
}
