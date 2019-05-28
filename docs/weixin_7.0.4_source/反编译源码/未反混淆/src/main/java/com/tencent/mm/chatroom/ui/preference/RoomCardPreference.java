package com.tencent.mm.chatroom.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

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
        AppMethodBeat.i(104468);
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(104468);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(104469);
        if (this.mView == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
            viewGroup2.removeAllViews();
            View.inflate(this.mContext, R.layout.ag2, viewGroup2);
            this.mView = onCreateView;
        }
        View view = this.mView;
        AppMethodBeat.o(104469);
        return view;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(104470);
        super.onBindView(view);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.m5).findViewById(R.id.l5);
        if (this.eol == null) {
            this.eol = (LinearLayout) viewGroup.getChildAt(1);
        }
        if (this.eoi == null) {
            this.eoi = (TextView) viewGroup.findViewById(R.id.dal);
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
        AppMethodBeat.o(104470);
    }
}
