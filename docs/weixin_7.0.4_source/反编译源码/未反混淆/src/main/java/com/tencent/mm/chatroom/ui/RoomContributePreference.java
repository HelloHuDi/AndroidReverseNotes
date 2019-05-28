package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomContributePreference extends Preference {
    private MaskLayout ekr;
    private ImageView eks;
    private String ekt;

    public RoomContributePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public RoomContributePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(104179);
        setLayoutResource(R.layout.ae4);
        setWidgetLayoutResource(R.layout.afm);
        AppMethodBeat.o(104179);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(104180);
        View onCreateView = super.onCreateView(viewGroup);
        this.ekr = (MaskLayout) onCreateView.findViewById(R.id.da7);
        this.eks = (ImageView) onCreateView.findViewById(R.id.bl);
        AppMethodBeat.o(104180);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(104181);
        super.onBindView(view);
        if (!(this.eks == null || bo.isNullOrNil(this.ekt))) {
            b.b(this.eks, this.ekt);
        }
        AppMethodBeat.o(104181);
    }
}
