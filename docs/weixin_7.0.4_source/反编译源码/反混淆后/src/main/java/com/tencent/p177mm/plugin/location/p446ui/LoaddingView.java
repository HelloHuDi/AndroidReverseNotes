package com.tencent.p177mm.plugin.location.p446ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.plugin.location.ui.LoaddingView */
public class LoaddingView extends LinearLayout implements C34411c {
    /* renamed from: De */
    private Animation f2912De;
    private TextView nLs;
    private ProgressBar nLt;
    private View nLu;
    private boolean nLv = false;
    private String nLw = "";

    @TargetApi(11)
    public LoaddingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(113425);
        init(context);
        AppMethodBeat.m2505o(113425);
    }

    public LoaddingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(113426);
        init(context);
        AppMethodBeat.m2505o(113426);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(113427);
        this.f2912De = AnimationUtils.loadAnimation(context, C25738R.anim.f8416dx);
        View inflate = LayoutInflater.from(context).inflate(2130969947, this, true);
        this.nLt = (ProgressBar) inflate.findViewById(2131825275);
        this.nLs = (TextView) inflate.findViewById(2131825276);
        this.nLu = inflate.findViewById(2131825273);
        this.nLs.setText("");
        this.nLs.setVisibility(0);
        this.nLt.setVisibility(0);
        AppMethodBeat.m2505o(113427);
    }

    public void setProgressAlwaysGone(boolean z) {
        AppMethodBeat.m2504i(113428);
        this.nLv = z;
        this.nLt.setVisibility(8);
        this.nLs.setVisibility(8);
        AppMethodBeat.m2505o(113428);
    }

    public void setText(String str) {
        AppMethodBeat.m2504i(113429);
        if (this.nLs == null || this.nLt == null || this.nLv) {
            AppMethodBeat.m2505o(113429);
        } else if (C5046bo.isNullOrNil(str)) {
            this.nLs.setText("");
            this.nLs.setVisibility(0);
            this.nLt.setVisibility(0);
            AppMethodBeat.m2505o(113429);
        } else {
            this.nLs.setText(String.valueOf(str));
            this.nLt.setVisibility(8);
            this.nLs.setVisibility(0);
            AppMethodBeat.m2505o(113429);
        }
    }

    public void setPreText(String str) {
        AppMethodBeat.m2504i(113430);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(113430);
            return;
        }
        this.nLw = str + IOUtils.LINE_SEPARATOR_UNIX;
        AppMethodBeat.m2505o(113430);
    }

    public String getPreText() {
        return this.nLw;
    }
}
