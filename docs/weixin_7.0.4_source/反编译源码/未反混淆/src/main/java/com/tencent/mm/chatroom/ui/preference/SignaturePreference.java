package com.tencent.mm.chatroom.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class SignaturePreference extends Preference {
    public SignaturePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SignaturePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(104474);
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(104474);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(104475);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        viewGroup2.setPadding(0, 0, 0, 0);
        View.inflate(this.mContext, R.layout.af8, viewGroup2);
        AppMethodBeat.o(104475);
        return onCreateView;
    }
}
