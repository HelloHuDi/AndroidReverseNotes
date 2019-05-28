package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.game.model.C20993e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.GameRegionPreference */
public class GameRegionPreference extends Preference {
    C3265a nlP;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameRegionPreference$a */
    public static class C3265a {
        public String dui;
        public boolean gBF;
        public boolean isDefault;
        public String nlQ;
        public String nlR;
        public String nlS;
    }

    public GameRegionPreference(Context context) {
        this(context, null);
    }

    public GameRegionPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GameRegionPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(112154);
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(112154);
    }

    /* renamed from: b */
    public final void mo7606b(C3265a c3265a) {
        AppMethodBeat.m2504i(112155);
        if (c3265a == null || C5046bo.isNullOrNil(c3265a.dui)) {
            C4990ab.m7412e("MicroMsg.GameRegionPreference", "setData region error");
            AppMethodBeat.m2505o(112155);
            return;
        }
        this.nlP = c3265a;
        setKey(c3265a.dui);
        AppMethodBeat.m2505o(112155);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(112156);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130969772, viewGroup2);
        AppMethodBeat.m2505o(112156);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(112157);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(2131824617);
        CheckBox checkBox = (CheckBox) view.findViewById(2131824618);
        if (!(textView == null || checkBox == null || this.nlP == null)) {
            textView.setText(C20993e.m32261a(this.nlP));
            checkBox.setChecked(this.nlP.gBF);
        }
        AppMethodBeat.m2505o(112157);
    }
}
