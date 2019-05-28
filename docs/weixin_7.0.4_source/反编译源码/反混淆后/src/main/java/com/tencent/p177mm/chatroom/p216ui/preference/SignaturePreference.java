package com.tencent.p177mm.chatroom.p216ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.chatroom.ui.preference.SignaturePreference */
public class SignaturePreference extends Preference {
    public SignaturePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SignaturePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(104474);
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(104474);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(104475);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        viewGroup2.setPadding(0, 0, 0, 0);
        View.inflate(this.mContext, 2130970168, viewGroup2);
        AppMethodBeat.m2505o(104475);
        return onCreateView;
    }
}
