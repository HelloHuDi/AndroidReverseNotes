package com.tencent.mm.plugin.account.security.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;

public class SafeDeviceListPreference extends Preference implements f {
    private Context context;
    private ProgressDialog ehJ;
    d gzG;
    private boolean gzH;
    private Button gzI;
    a gzJ;
    b gzK;
    int mode;

    public interface a {
        void onFailed(String str);
    }

    public interface b {
        void wq(String str);
    }

    static /* synthetic */ void c(SafeDeviceListPreference safeDeviceListPreference) {
        AppMethodBeat.i(69901);
        safeDeviceListPreference.amq();
        AppMethodBeat.o(69901);
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
        AppMethodBeat.i(69895);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
            layoutInflater.inflate(R.layout.aff, viewGroup2);
        }
        AppMethodBeat.o(69895);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(69896);
        this.gzH = true;
        this.gzI = (Button) view.findViewById(R.id.b99);
        initView();
        super.onBindView(view);
        AppMethodBeat.o(69896);
    }

    private void amq() {
        AppMethodBeat.i(69897);
        g.Rg().b(362, (f) this);
        AppMethodBeat.o(69897);
    }

    /* Access modifiers changed, original: final */
    public final void initView() {
        AppMethodBeat.i(69898);
        if (this.gzH) {
            switch (this.mode) {
                case -2:
                    setWidgetLayoutResource(0);
                    NW(0);
                    AppMethodBeat.o(69898);
                    return;
                case 1:
                    setWidgetLayoutResource(R.layout.rz);
                    if (this.gzI != null) {
                        this.gzI.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(69894);
                                SafeDeviceListPreference.d(SafeDeviceListPreference.this);
                                AppMethodBeat.o(69894);
                            }
                        });
                    }
                    NW(8);
                    AppMethodBeat.o(69898);
                    return;
                default:
                    setWidgetLayoutResource(0);
                    NW(0);
                    AppMethodBeat.o(69898);
                    return;
            }
        }
        ab.d("MicroMsg.SafeDeviceListPreference", "has not binded");
        AppMethodBeat.o(69898);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(69899);
        amq();
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (i2 == 0 && i2 == 0) {
            com.tencent.mm.plugin.account.security.a.g.aqG().a((c) this.gzG, new String[0]);
            if (this.gzK != null) {
                this.gzK.wq(this.mKey);
                AppMethodBeat.o(69899);
                return;
            }
        } else if (com.tencent.mm.plugin.account.a.a.gkF.a(this.context, i, i2, str)) {
            AppMethodBeat.o(69899);
            return;
        } else {
            Toast.makeText(this.context, this.context.getString(R.string.dw9, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            if (this.gzJ != null) {
                this.gzJ.onFailed(this.gzG.field_uid);
            }
        }
        AppMethodBeat.o(69899);
    }

    static /* synthetic */ void a(SafeDeviceListPreference safeDeviceListPreference) {
        AppMethodBeat.i(69900);
        g.Rg().a(362, (f) safeDeviceListPreference);
        AppMethodBeat.o(69900);
    }

    static /* synthetic */ void d(SafeDeviceListPreference safeDeviceListPreference) {
        AppMethodBeat.i(69902);
        h.d(safeDeviceListPreference.context, safeDeviceListPreference.context.getString(R.string.dw7, new Object[]{safeDeviceListPreference.gzG.field_name}), "", com.tencent.mm.bz.a.an(safeDeviceListPreference.context, R.string.dw8), com.tencent.mm.bz.a.an(safeDeviceListPreference.context, R.string.or), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(69893);
                SafeDeviceListPreference.a(SafeDeviceListPreference.this);
                final m aVar = new com.tencent.mm.plugin.account.security.a.a(SafeDeviceListPreference.this.gzG.field_uid);
                g.Rg().a(aVar, 0);
                SafeDeviceListPreference.this.ehJ = h.b(SafeDeviceListPreference.this.context, com.tencent.mm.bz.a.an(SafeDeviceListPreference.this.context, R.string.un), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(69892);
                        g.Rg().c(aVar);
                        SafeDeviceListPreference.c(SafeDeviceListPreference.this);
                        AppMethodBeat.o(69892);
                    }
                });
                AppMethodBeat.o(69893);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(69902);
    }
}
