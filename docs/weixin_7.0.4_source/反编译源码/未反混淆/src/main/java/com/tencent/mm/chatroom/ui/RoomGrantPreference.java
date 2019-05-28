package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomGrantPreference extends Preference {
    TextView eku = null;
    String ekv = "";

    public RoomGrantPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoomGrantPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(104182);
        setLayoutResource(R.layout.ae4);
        setWidgetLayoutResource(R.layout.ag5);
        AppMethodBeat.o(104182);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(104183);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.af6, viewGroup2);
        AppMethodBeat.o(104183);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(104184);
        if (this.eku == null) {
            this.eku = (TextView) view.findViewById(R.id.b14);
        }
        this.eku.setText(this.ekv);
        super.onBindView(view);
        AppMethodBeat.o(104184);
    }
}
