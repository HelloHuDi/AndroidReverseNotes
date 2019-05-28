package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.widget.b.j;
import com.tencent.mm.plugin.appbrand.widget.b.k;
import com.tencent.mm.sdk.platformtools.al;
import java.util.ArrayList;
import java.util.Iterator;

@a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 F2\u00020\u0001:\u0002FGB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010.\u001a\u00020/H\u0016J\u000e\u00100\u001a\u00020/2\u0006\u00100\u001a\u000201J\b\u00102\u001a\u00020/H\u0016J\u000e\u00103\u001a\u00020/2\u0006\u00103\u001a\u000201J\u000e\u00104\u001a\u00020/2\u0006\u00104\u001a\u000201J\b\u00105\u001a\u00020\nH\u0016J\u0006\u00106\u001a\u000207J\b\u00108\u001a\u000207H\u0016J\u000e\u00109\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0005J\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020;H\u0016J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0005J\b\u0010=\u001a\u00020/H\u0016J\b\u0010>\u001a\u00020/H\u0016J\u0010\u0010?\u001a\u00020/2\u0006\u0010@\u001a\u000207H\u0016J\u0012\u0010A\u001a\u00020/2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u001e\u0010)\u001a\u00020\u00002\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020+0*j\b\u0012\u0004\u0012\u00020+`,J\u0006\u0010D\u001a\u00020/J\b\u0010E\u001a\u00020/H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u0012\u0012\u0004\u0012\u00020+0*j\b\u0012\u0004\u0012\u00020+`,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "appId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "buttonGroup", "Landroid/view/View;", "getContext", "()Landroid/content/Context;", "denyTv", "Landroid/widget/TextView;", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "getDismissListener", "()Landroid/content/DialogInterface$OnDismissListener;", "setDismissListener", "(Landroid/content/DialogInterface$OnDismissListener;)V", "explainIv", "Landroid/widget/ImageView;", "functionTv", "iconIv", "iconUrl", "itemAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "listRv", "Landroid/support/v7/widget/RecyclerView;", "loadingV", "Landroid/widget/ProgressBar;", "name", "nameTv", "okTv", "onPhoneItemSelect", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$OnPhoneItemSelect;", "getOnPhoneItemSelect", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$OnPhoneItemSelect;", "setOnPhoneItemSelect", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$OnPhoneItemSelect;)V", "phoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "rootView", "cancel", "", "denyListener", "Landroid/view/View$OnClickListener;", "dismiss", "explainListener", "functionListener", "getContentView", "getDialogHeight", "", "getPosition", "icon", "isCancelable", "", "isCanceledOnTouchOutside", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "updateDialog", "updateDialogInner", "Companion", "OnPhoneItemSelect", "plugin-appbrand-integration_release"})
public final class l implements j {
    public static final a iyy = new a();
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
    private i iyv;
    private View iyw;
    b iyx;
    private String name = "";

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$OnPhoneItemSelect;", "", "onPhoneItemSelect", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "plugin-appbrand-integration_release"})
    public interface b {
        void c(PhoneItem phoneItem);
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ l iyz;

        c(l lVar) {
            this.iyz = lVar;
        }

        public final void run() {
            AppMethodBeat.i(134847);
            l.a(this.iyz);
            AppMethodBeat.o(134847);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.l$1 */
    static final class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ l iyz;

        AnonymousClass1(l lVar) {
            this.iyz = lVar;
        }

        public final void onClick(View view) {
            ArrayList arrayList;
            AppMethodBeat.i(134846);
            i b = this.iyz.iyv;
            if (b != null) {
                arrayList = b.ixy;
            } else {
                arrayList = null;
            }
            if (arrayList == null) {
                a.f.b.j.dWJ();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                PhoneItem phoneItem = (PhoneItem) it.next();
                if (phoneItem.ixN) {
                    b bVar = this.iyz.iyx;
                    if (bVar != null) {
                        a.f.b.j.o(phoneItem, "phoneItem");
                        bVar.c(phoneItem);
                        AppMethodBeat.o(134846);
                        return;
                    }
                    AppMethodBeat.o(134846);
                    return;
                }
            }
            AppMethodBeat.o(134846);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$Companion;", "", "()V", "MAX_COUNT", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(134857);
        AppMethodBeat.o(134857);
    }

    public l(Context context, String str) {
        a.f.b.j.p(context, "context");
        a.f.b.j.p(str, "appId");
        AppMethodBeat.i(134856);
        this.context = context;
        this.appId = str;
        View inflate = View.inflate(this.context, R.layout.cp, null);
        a.f.b.j.o(inflate, "View.inflate(context, R.…ber_manager_dialog, null)");
        this.iym = inflate;
        inflate = this.iym.findViewById(R.id.si);
        a.f.b.j.o(inflate, "rootView.findViewById(R.…mber_manager_dialog_icon)");
        this.iyo = (ImageView) inflate;
        inflate = this.iym.findViewById(R.id.sj);
        a.f.b.j.o(inflate, "rootView.findViewById(R.…mber_manager_dialog_name)");
        this.gtb = (TextView) inflate;
        inflate = this.iym.findViewById(R.id.sq);
        a.f.b.j.o(inflate, "rootView.findViewById(R.…_manager_dialog_function)");
        this.iyr = (TextView) inflate;
        inflate = this.iym.findViewById(R.id.st);
        a.f.b.j.o(inflate, "rootView.findViewById(R.…number_manager_dialog_ok)");
        this.iys = (TextView) inflate;
        inflate = this.iym.findViewById(R.id.ss);
        a.f.b.j.o(inflate, "rootView.findViewById(R.…er_manager_dialog_cancel)");
        this.iyt = (TextView) inflate;
        inflate = this.iym.findViewById(R.id.sl);
        a.f.b.j.o(inflate, "rootView.findViewById(R.…r_manager_dialog_explain)");
        this.iyu = (ImageView) inflate;
        inflate = this.iym.findViewById(R.id.m5);
        a.f.b.j.o(inflate, "rootView.findViewById<View>(R.id.content)");
        inflate.setVisibility(0);
        inflate = this.iym.findViewById(R.id.sr);
        a.f.b.j.o(inflate, "rootView.findViewById(R.id.button_group)");
        this.iyw = inflate;
        inflate = this.iym.findViewById(R.id.sp);
        a.f.b.j.o(inflate, "rootView.findViewById(R.…r_manager_dialog_loading)");
        this.iyq = (ProgressBar) inflate;
        inflate = this.iym.findViewById(R.id.so);
        a.f.b.j.o(inflate, "rootView.findViewById(R.…ager_dialog_recyclerview)");
        this.iyp = (RecyclerView) inflate;
        this.iyp.setLayoutManager(new LinearLayoutManager());
        this.iyv = new i(this.appId, this.context, this.ixy);
        this.iyp.setAdapter(this.iyv);
        this.iys.setOnClickListener(new AnonymousClass1(this));
        AppMethodBeat.o(134856);
    }

    public final void dismiss() {
        AppMethodBeat.i(134848);
        OnDismissListener onDismissListener = this.cMR;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(null);
            AppMethodBeat.o(134848);
            return;
        }
        AppMethodBeat.o(134848);
    }

    public final void cancel() {
    }

    public final l Dt(String str) {
        AppMethodBeat.i(134849);
        a.f.b.j.p(str, "iconUrl");
        this.iconUrl = str;
        AppMethodBeat.o(134849);
        return this;
    }

    public final l Du(String str) {
        AppMethodBeat.i(134850);
        a.f.b.j.p(str, "name");
        this.name = str;
        AppMethodBeat.o(134850);
        return this;
    }

    public final l p(ArrayList<PhoneItem> arrayList) {
        AppMethodBeat.i(134851);
        a.f.b.j.p(arrayList, "phoneItems");
        this.ixy.clear();
        this.ixy.addAll(arrayList);
        AppMethodBeat.o(134851);
        return this;
    }

    public final void aKQ() {
        AppMethodBeat.i(134852);
        Looper mainLooper = Looper.getMainLooper();
        a.f.b.j.o(mainLooper, "Looper.getMainLooper()");
        if (a.f.b.j.j(mainLooper.getThread(), Thread.currentThread())) {
            aKR();
            AppMethodBeat.o(134852);
            return;
        }
        al.d(new c(this));
        AppMethodBeat.o(134852);
    }

    private final void aKR() {
        AppMethodBeat.i(134853);
        com.tencent.mm.modelappbrand.a.b.abR().a(this.iyo, this.iconUrl, null, (f) com.tencent.mm.modelappbrand.a.f.fqH);
        this.gtb.setText(this.name);
        if (this.ixy.size() == 0) {
            this.iyq.setVisibility(0);
            this.iyp.setVisibility(8);
            this.iyr.setVisibility(8);
            AppMethodBeat.o(134853);
        } else if (this.ixy.size() == 1) {
            this.iyq.setVisibility(8);
            this.iyp.setVisibility(0);
            this.iyr.setVisibility(0);
            this.iyp.getAdapter().notifyDataSetChanged();
            this.iyr.setText(this.context.getString(R.string.w9));
            AppMethodBeat.o(134853);
        } else {
            this.iyq.setVisibility(8);
            this.iyp.setVisibility(0);
            this.iyr.setVisibility(0);
            this.iyp.getAdapter().notifyDataSetChanged();
            this.iyr.setText(this.context.getString(R.string.w7));
            AppMethodBeat.o(134853);
        }
    }

    public final int getPosition() {
        return 2;
    }

    public final void a(k kVar) {
        AppMethodBeat.i(134854);
        aKR();
        AppMethodBeat.o(134854);
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

    public final void pF(int i) {
        AppMethodBeat.i(134855);
        com.tencent.mm.plugin.appbrand.widget.b.l.a aVar = com.tencent.mm.plugin.appbrand.widget.b.l.jcT;
        com.tencent.mm.plugin.appbrand.widget.b.l.a.a(this.context, this.iym, this.iyw, i);
        AppMethodBeat.o(134855);
    }
}
