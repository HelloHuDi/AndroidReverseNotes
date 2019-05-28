package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.q;

public class HelperHeaderPreference extends Preference {
    private a vqE = new a();

    public static class a {
        public String cIS;
        public String eoz;
        public String hint;
        public int status;
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(79801);
        AppMethodBeat.o(79801);
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(79802);
        AppMethodBeat.o(79802);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(79803);
        ImageView imageView = (ImageView) view.findViewById(R.id.qk);
        TextView textView = (TextView) view.findViewById(R.id.bxv);
        TextView textView2 = (TextView) view.findViewById(R.id.b6e);
        TextView textView3 = (TextView) view.findViewById(R.id.dn8);
        ((TextView) view.findViewById(R.id.dn7)).setText(R.string.bsj);
        if (imageView != null) {
            b.b(imageView, this.vqE.cIS);
        }
        if (textView != null) {
            switch (this.vqE.status) {
                case 0:
                    textView.setVisibility(0);
                    textView.setTextColor(q.ij(this.mContext));
                    textView.setText(R.string.e_i);
                    break;
                case 1:
                    textView.setVisibility(0);
                    textView.setTextColor(q.ii(this.mContext));
                    textView.setText(R.string.e_a);
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
        AppMethodBeat.o(79803);
    }

    public final void ay(String str, String str2, String str3) {
        AppMethodBeat.i(79804);
        this.vqE.cIS = str;
        this.vqE.eoz = str2;
        this.vqE.hint = str3;
        super.callChangeListener(null);
        AppMethodBeat.o(79804);
    }

    public final void sd(int i) {
        AppMethodBeat.i(79805);
        this.vqE.status = i;
        super.callChangeListener(null);
        AppMethodBeat.o(79805);
    }
}
