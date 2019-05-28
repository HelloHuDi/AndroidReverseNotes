package com.tencent.p177mm.plugin.setting.p505ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;

/* renamed from: com.tencent.mm.plugin.setting.ui.widget.HeadImgNewPreference */
public final class HeadImgNewPreference extends Preference {
    private int height;
    private ImageView iNr;
    private TextView qqS;
    private View qqT;
    private String qqU;
    public OnClickListener qqV;
    private boolean qqW;
    private boolean qqX;

    public HeadImgNewPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadImgNewPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(127698);
        this.height = -1;
        this.qqW = false;
        this.qqX = false;
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(127698);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(127699);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        if (this.qqX) {
            View.inflate(this.mContext, 2130970247, viewGroup2);
        } else {
            View.inflate(this.mContext, 2130970150, viewGroup2);
        }
        this.iNr = (ImageView) onCreateView.findViewById(2131826036);
        this.qqS = (TextView) onCreateView.findViewById(2131826038);
        this.qqT = onCreateView.findViewById(2131821044);
        AppMethodBeat.m2505o(127699);
        return onCreateView;
    }

    /* renamed from: WB */
    public final void mo25297WB(String str) {
        AppMethodBeat.m2504i(127700);
        this.qqU = null;
        if (this.iNr != null) {
            C40460b.m69434b(this.iNr, str);
        } else {
            this.qqU = str;
        }
        if (str == null) {
            this.qqW = false;
            AppMethodBeat.m2505o(127700);
            return;
        }
        this.qqW = true;
        AppMethodBeat.m2505o(127700);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(127701);
        super.onBindView(view);
        if (this.iNr == null) {
            this.iNr = (ImageView) view.findViewById(2131826036);
        }
        if (this.qqS == null) {
            this.qqS = (TextView) view.findViewById(2131826038);
        }
        if (this.qqT == null) {
            this.qqT = view.findViewById(2131821044);
        }
        if (this.qqV != null) {
            this.qqT.setOnClickListener(this.qqV);
        }
        if (this.qqU != null) {
            C40460b.m69434b(this.iNr, this.qqU);
            this.qqU = null;
        }
        if (this.qqW) {
            this.qqS.setVisibility(8);
            this.qqT.setVisibility(0);
        } else {
            this.qqT.setVisibility(8);
            this.qqS.setVisibility(0);
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(2131822347);
        if (this.height != -1) {
            relativeLayout.setMinimumHeight(this.height);
        }
        AppMethodBeat.m2505o(127701);
    }
}
