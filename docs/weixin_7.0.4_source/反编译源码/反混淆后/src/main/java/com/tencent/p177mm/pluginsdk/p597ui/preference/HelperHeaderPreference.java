package com.tencent.p177mm.pluginsdk.p597ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.tools.C24054q;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;

/* renamed from: com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference */
public class HelperHeaderPreference extends Preference {
    private C14953a vqE = new C14953a();

    /* renamed from: com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference$a */
    public static class C14953a {
        public String cIS;
        public String eoz;
        public String hint;
        public int status;
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(79801);
        AppMethodBeat.m2505o(79801);
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(79802);
        AppMethodBeat.m2505o(79802);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(79803);
        ImageView imageView = (ImageView) view.findViewById(2131821183);
        TextView textView = (TextView) view.findViewById(2131824202);
        TextView textView2 = (TextView) view.findViewById(2131823149);
        TextView textView3 = (TextView) view.findViewById(2131826545);
        ((TextView) view.findViewById(2131826544)).setText(C25738R.string.bsj);
        if (imageView != null) {
            C40460b.m69434b(imageView, this.vqE.cIS);
        }
        if (textView != null) {
            switch (this.vqE.status) {
                case 0:
                    textView.setVisibility(0);
                    textView.setTextColor(C24054q.m37014ij(this.mContext));
                    textView.setText(C25738R.string.e_i);
                    break;
                case 1:
                    textView.setVisibility(0);
                    textView.setTextColor(C24054q.m37013ii(this.mContext));
                    textView.setText(C25738R.string.e_a);
                    break;
                case 2:
                    textView.setVisibility(8);
                    break;
            }
        }
        if (textView2 != null) {
            textView2.setText(this.vqE.eoz);
        }
        if (textView3 != null) {
            textView3.setText(this.vqE.hint);
        }
        super.onBindView(view);
        AppMethodBeat.m2505o(79803);
    }

    /* renamed from: ay */
    public final void mo74731ay(String str, String str2, String str3) {
        AppMethodBeat.m2504i(79804);
        this.vqE.cIS = str;
        this.vqE.eoz = str2;
        this.vqE.hint = str3;
        super.callChangeListener(null);
        AppMethodBeat.m2505o(79804);
    }

    /* renamed from: sd */
    public final void mo74732sd(int i) {
        AppMethodBeat.m2504i(79805);
        this.vqE.status = i;
        super.callChangeListener(null);
        AppMethodBeat.m2505o(79805);
    }
}
