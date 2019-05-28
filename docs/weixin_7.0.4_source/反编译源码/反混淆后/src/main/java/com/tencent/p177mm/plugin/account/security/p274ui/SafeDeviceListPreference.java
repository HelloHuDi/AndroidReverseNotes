package com.tencent.p177mm.plugin.account.security.p274ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.account.security.p880a.C18848d;
import com.tencent.p177mm.plugin.account.security.p880a.C42288a;
import com.tencent.p177mm.plugin.account.security.p880a.C45501g;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference */
public class SafeDeviceListPreference extends Preference implements C1202f {
    private Context context;
    private ProgressDialog ehJ;
    C18848d gzG;
    private boolean gzH;
    private Button gzI;
    C9910a gzJ;
    C26608b gzK;
    int mode;

    /* renamed from: com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference$a */
    public interface C9910a {
        void onFailed(String str);
    }

    /* renamed from: com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference$b */
    public interface C26608b {
        /* renamed from: wq */
        void mo34130wq(String str);
    }

    /* renamed from: com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference$3 */
    class C380433 implements OnClickListener {
        C380433() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(69894);
            SafeDeviceListPreference.m74787d(SafeDeviceListPreference.this);
            AppMethodBeat.m2505o(69894);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference$1 */
    class C422891 implements DialogInterface.OnClickListener {
        C422891() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(69893);
            SafeDeviceListPreference.m74784a(SafeDeviceListPreference.this);
            final C1207m c42288a = new C42288a(SafeDeviceListPreference.this.gzG.field_uid);
            C1720g.m3540Rg().mo14541a(c42288a, 0);
            SafeDeviceListPreference.this.ehJ = C30379h.m48458b(SafeDeviceListPreference.this.context, C1338a.m2858an(SafeDeviceListPreference.this.context, C25738R.string.f9260un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(69892);
                    C1720g.m3540Rg().mo14547c(c42288a);
                    SafeDeviceListPreference.m74786c(SafeDeviceListPreference.this);
                    AppMethodBeat.m2505o(69892);
                }
            });
            AppMethodBeat.m2505o(69893);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference$2 */
    class C422902 implements DialogInterface.OnClickListener {
        C422902() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m74786c(SafeDeviceListPreference safeDeviceListPreference) {
        AppMethodBeat.m2504i(69901);
        safeDeviceListPreference.amq();
        AppMethodBeat.m2505o(69901);
    }

    public SafeDeviceListPreference(Context context) {
        this(context, null);
    }

    public SafeDeviceListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SafeDeviceListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mode = -2;
        this.gzH = false;
        this.context = context;
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(69895);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
            layoutInflater.inflate(2130970176, viewGroup2);
        }
        AppMethodBeat.m2505o(69895);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(69896);
        this.gzH = true;
        this.gzI = (Button) view.findViewById(2131823254);
        initView();
        super.onBindView(view);
        AppMethodBeat.m2505o(69896);
    }

    private void amq() {
        AppMethodBeat.m2504i(69897);
        C1720g.m3540Rg().mo14546b(362, (C1202f) this);
        AppMethodBeat.m2505o(69897);
    }

    /* Access modifiers changed, original: final */
    public final void initView() {
        AppMethodBeat.m2504i(69898);
        if (this.gzH) {
            switch (this.mode) {
                case -2:
                    setWidgetLayoutResource(0);
                    mo39406NW(0);
                    AppMethodBeat.m2505o(69898);
                    return;
                case 1:
                    setWidgetLayoutResource(2130969269);
                    if (this.gzI != null) {
                        this.gzI.setOnClickListener(new C380433());
                    }
                    mo39406NW(8);
                    AppMethodBeat.m2505o(69898);
                    return;
                default:
                    setWidgetLayoutResource(0);
                    mo39406NW(0);
                    AppMethodBeat.m2505o(69898);
                    return;
            }
        }
        C4990ab.m7410d("MicroMsg.SafeDeviceListPreference", "has not binded");
        AppMethodBeat.m2505o(69898);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(69899);
        amq();
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (i2 == 0 && i2 == 0) {
            C45501g.aqG().mo16760a((C4925c) this.gzG, new String[0]);
            if (this.gzK != null) {
                this.gzK.mo34130wq(this.mKey);
                AppMethodBeat.m2505o(69899);
                return;
            }
        } else if (C24679a.gkF.mo38859a(this.context, i, i2, str)) {
            AppMethodBeat.m2505o(69899);
            return;
        } else {
            Toast.makeText(this.context, this.context.getString(C25738R.string.dw9, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            if (this.gzJ != null) {
                this.gzJ.onFailed(this.gzG.field_uid);
            }
        }
        AppMethodBeat.m2505o(69899);
    }

    /* renamed from: a */
    static /* synthetic */ void m74784a(SafeDeviceListPreference safeDeviceListPreference) {
        AppMethodBeat.m2504i(69900);
        C1720g.m3540Rg().mo14539a(362, (C1202f) safeDeviceListPreference);
        AppMethodBeat.m2505o(69900);
    }

    /* renamed from: d */
    static /* synthetic */ void m74787d(SafeDeviceListPreference safeDeviceListPreference) {
        AppMethodBeat.m2504i(69902);
        C30379h.m48466d(safeDeviceListPreference.context, safeDeviceListPreference.context.getString(C25738R.string.dw7, new Object[]{safeDeviceListPreference.gzG.field_name}), "", C1338a.m2858an(safeDeviceListPreference.context, C25738R.string.dw8), C1338a.m2858an(safeDeviceListPreference.context, C25738R.string.f9076or), new C422891(), new C422902());
        AppMethodBeat.m2505o(69902);
    }
}
