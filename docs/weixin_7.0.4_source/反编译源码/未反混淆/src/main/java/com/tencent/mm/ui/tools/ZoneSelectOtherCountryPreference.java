package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;

public class ZoneSelectOtherCountryPreference extends Preference {
    String text;
    a zIq;

    public interface a {
        void onClick();
    }

    public ZoneSelectOtherCountryPreference(Context context) {
        this(context, null);
    }

    public ZoneSelectOtherCountryPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZoneSelectOtherCountryPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(35020);
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(35020);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(35021);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.layout.af_, viewGroup2);
        AppMethodBeat.o(35021);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(35022);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.id.d_s);
        if (!bo.isNullOrNil(this.text)) {
            textView.setText(this.text);
        }
        view.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(35019);
                if (ZoneSelectOtherCountryPreference.this.zIq != null) {
                    ZoneSelectOtherCountryPreference.this.zIq.onClick();
                }
                AppMethodBeat.o(35019);
            }
        });
        AppMethodBeat.o(35022);
    }
}
