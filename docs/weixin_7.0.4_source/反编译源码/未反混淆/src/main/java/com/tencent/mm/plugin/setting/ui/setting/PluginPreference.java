package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class PluginPreference extends Preference implements a {
    private MMActivity crP;
    private ImageView gvq;
    int lXY;
    private String pnJ;
    String qlc;
    String qld;
    private int qle;
    private int qlf;
    boolean qlg;

    static /* synthetic */ void a(PluginPreference pluginPreference) {
        AppMethodBeat.i(126986);
        pluginPreference.cfI();
        AppMethodBeat.o(126986);
    }

    public PluginPreference(Context context) {
        this(context, null);
    }

    public PluginPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(126980);
        this.pnJ = "";
        this.qle = -1;
        this.qlf = 8;
        this.qlg = false;
        this.gvq = null;
        this.lXY = 255;
        this.crP = (MMActivity) context;
        setLayoutResource(R.layout.ae4);
        o.acd().a((a) this);
        AppMethodBeat.o(126980);
    }

    public final boolean Ww(String str) {
        AppMethodBeat.i(126981);
        ad aoO = ((j) g.K(j.class)).XM().aoO(str);
        if (aoO == null || ((int) aoO.ewQ) == 0) {
            ab.e("MicroMsg.PluginPreference", "plugin do not exist");
            AppMethodBeat.o(126981);
            return false;
        }
        this.qlc = aoO.field_username;
        this.qld = aoO.Oi();
        setKey("settings_plugins_list_#" + this.qlc);
        AppMethodBeat.o(126981);
        return true;
    }

    private void cfI() {
        AppMethodBeat.i(126982);
        if (this.gvq != null) {
            b.b(this.gvq, this.qlc);
        }
        AppMethodBeat.o(126982);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(126983);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.layout.af0, viewGroup2);
        AppMethodBeat.o(126983);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(126984);
        super.onBindView(view);
        this.gvq = (ImageView) view.findViewById(R.id.aga);
        this.gvq.setAlpha(this.lXY);
        TextView textView = (TextView) view.findViewById(R.id.akq);
        if (textView != null) {
            textView.setVisibility(this.qlf);
            textView.setText(this.pnJ);
            if (this.qle != -1) {
                textView.setBackgroundDrawable(com.tencent.mm.bz.a.g(this.crP, this.qle));
            }
        }
        textView = (TextView) view.findViewById(R.id.ckb);
        if (textView != null) {
            textView.setVisibility(this.qlg ? 0 : 8);
        }
        cfI();
        AppMethodBeat.o(126984);
    }

    public final void qj(String str) {
        AppMethodBeat.i(126985);
        if (this.qlc != null && this.qlc.equals(str)) {
            new ak(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(126979);
                    PluginPreference.a(PluginPreference.this);
                    AppMethodBeat.o(126979);
                }
            });
        }
        AppMethodBeat.o(126985);
    }
}
