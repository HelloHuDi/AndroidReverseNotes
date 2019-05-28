package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.PluginPreference */
public final class PluginPreference extends Preference implements C8915a {
    private MMActivity crP;
    private ImageView gvq;
    int lXY;
    private String pnJ;
    String qlc;
    String qld;
    private int qle;
    private int qlf;
    boolean qlg;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.PluginPreference$1 */
    class C217461 implements Runnable {
        C217461() {
        }

        public final void run() {
            AppMethodBeat.m2504i(126979);
            PluginPreference.m38787a(PluginPreference.this);
            AppMethodBeat.m2505o(126979);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m38787a(PluginPreference pluginPreference) {
        AppMethodBeat.m2504i(126986);
        pluginPreference.cfI();
        AppMethodBeat.m2505o(126986);
    }

    public PluginPreference(Context context) {
        this(context, null);
    }

    public PluginPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(126980);
        this.pnJ = "";
        this.qle = -1;
        this.qlf = 8;
        this.qlg = false;
        this.gvq = null;
        this.lXY = 255;
        this.crP = (MMActivity) context;
        setLayoutResource(2130970127);
        C17884o.acd().mo67498a((C8915a) this);
        AppMethodBeat.m2505o(126980);
    }

    /* renamed from: Ww */
    public final boolean mo41693Ww(String str) {
        AppMethodBeat.m2504i(126981);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        if (aoO == null || ((int) aoO.ewQ) == 0) {
            C4990ab.m7412e("MicroMsg.PluginPreference", "plugin do not exist");
            AppMethodBeat.m2505o(126981);
            return false;
        }
        this.qlc = aoO.field_username;
        this.qld = aoO.mo16706Oi();
        setKey("settings_plugins_list_#" + this.qlc);
        AppMethodBeat.m2505o(126981);
        return true;
    }

    private void cfI() {
        AppMethodBeat.m2504i(126982);
        if (this.gvq != null) {
            C40460b.m69434b(this.gvq, this.qlc);
        }
        AppMethodBeat.m2505o(126982);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(126983);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130970160, viewGroup2);
        AppMethodBeat.m2505o(126983);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(126984);
        super.onBindView(view);
        this.gvq = (ImageView) view.findViewById(2131822184);
        this.gvq.setAlpha(this.lXY);
        TextView textView = (TextView) view.findViewById(2131822348);
        if (textView != null) {
            textView.setVisibility(this.qlf);
            textView.setText(this.pnJ);
            if (this.qle != -1) {
                textView.setBackgroundDrawable(C1338a.m2864g(this.crP, this.qle));
            }
        }
        textView = (TextView) view.findViewById(2131825070);
        if (textView != null) {
            textView.setVisibility(this.qlg ? 0 : 8);
        }
        cfI();
        AppMethodBeat.m2505o(126984);
    }

    /* renamed from: qj */
    public final void mo20342qj(String str) {
        AppMethodBeat.m2504i(126985);
        if (this.qlc != null && this.qlc.equals(str)) {
            new C7306ak(Looper.getMainLooper()).post(new C217461());
        }
        AppMethodBeat.m2505o(126985);
    }
}
