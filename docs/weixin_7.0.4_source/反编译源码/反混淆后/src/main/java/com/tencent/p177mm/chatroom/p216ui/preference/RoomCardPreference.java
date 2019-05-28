package com.tencent.p177mm.chatroom.p216ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.chatroom.ui.preference.RoomCardPreference */
public class RoomCardPreference extends Preference {
    public boolean cui = false;
    private TextView eoi;
    public CharSequence eoj;
    public CharSequence eok;
    private LinearLayout eol;
    private View mView;

    public RoomCardPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoomCardPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(104468);
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(104468);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(104469);
        if (this.mView == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
            viewGroup2.removeAllViews();
            View.inflate(this.mContext, 2130970199, viewGroup2);
            this.mView = onCreateView;
        }
        View view = this.mView;
        AppMethodBeat.m2505o(104469);
        return view;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(104470);
        super.onBindView(view);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(2131821019).findViewById(2131820982);
        if (this.eol == null) {
            this.eol = (LinearLayout) viewGroup.getChildAt(1);
        }
        if (this.eoi == null) {
            this.eoi = (TextView) viewGroup.findViewById(2131826078);
        }
        if (this.cui) {
            this.eol.setVisibility(0);
            this.eoi.setVisibility(0);
        } else {
            this.eol.setVisibility(8);
            this.eoi.setVisibility(8);
        }
        if (this.eok != null) {
            this.eoi.setText(this.eok);
        }
        AppMethodBeat.m2505o(104470);
    }
}
