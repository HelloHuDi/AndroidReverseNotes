package com.tencent.p177mm.chatroom.p216ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.MaskLayout;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.chatroom.ui.RoomContributePreference */
public class RoomContributePreference extends Preference {
    private MaskLayout ekr;
    private ImageView eks;
    private String ekt;

    public RoomContributePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public RoomContributePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(104179);
        setLayoutResource(2130970127);
        setWidgetLayoutResource(2130970183);
        AppMethodBeat.m2505o(104179);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(104180);
        View onCreateView = super.onCreateView(viewGroup);
        this.ekr = (MaskLayout) onCreateView.findViewById(2131826063);
        this.eks = (ImageView) onCreateView.findViewById(2131820629);
        AppMethodBeat.m2505o(104180);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(104181);
        super.onBindView(view);
        if (!(this.eks == null || C5046bo.isNullOrNil(this.ekt))) {
            C40460b.m69434b(this.eks, this.ekt);
        }
        AppMethodBeat.m2505o(104181);
    }
}
