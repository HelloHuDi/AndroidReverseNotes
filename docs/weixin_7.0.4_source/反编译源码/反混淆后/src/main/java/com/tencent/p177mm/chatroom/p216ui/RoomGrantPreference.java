package com.tencent.p177mm.chatroom.p216ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.chatroom.ui.RoomGrantPreference */
public class RoomGrantPreference extends Preference {
    TextView eku = null;
    String ekv = "";

    public RoomGrantPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoomGrantPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(104182);
        setLayoutResource(2130970127);
        setWidgetLayoutResource(2130970202);
        AppMethodBeat.m2505o(104182);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(104183);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130970166, viewGroup2);
        AppMethodBeat.m2505o(104183);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(104184);
        if (this.eku == null) {
            this.eku = (TextView) view.findViewById(2131822953);
        }
        this.eku.setText(this.ekv);
        super.onBindView(view);
        AppMethodBeat.m2505o(104184);
    }
}
