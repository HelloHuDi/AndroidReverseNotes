package com.tencent.p177mm.p612ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.tools.ZoneSelectOtherCountryPreference */
public class ZoneSelectOtherCountryPreference extends Preference {
    String text;
    C15943a zIq;

    /* renamed from: com.tencent.mm.ui.tools.ZoneSelectOtherCountryPreference$a */
    public interface C15943a {
        void onClick();
    }

    /* renamed from: com.tencent.mm.ui.tools.ZoneSelectOtherCountryPreference$1 */
    class C408881 implements OnClickListener {
        C408881() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(35019);
            if (ZoneSelectOtherCountryPreference.this.zIq != null) {
                ZoneSelectOtherCountryPreference.this.zIq.onClick();
            }
            AppMethodBeat.m2505o(35019);
        }
    }

    public ZoneSelectOtherCountryPreference(Context context) {
        this(context, null);
    }

    public ZoneSelectOtherCountryPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZoneSelectOtherCountryPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(35020);
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(35020);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(35021);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130970170, viewGroup2);
        AppMethodBeat.m2505o(35021);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(35022);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(2131826048);
        if (!C5046bo.isNullOrNil(this.text)) {
            textView.setText(this.text);
        }
        view.setOnClickListener(new C408881());
        AppMethodBeat.m2505o(35022);
    }
}
