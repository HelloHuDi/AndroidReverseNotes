package com.tencent.p177mm.plugin.radar.p489ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TableLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J.\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\tJ0\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0014R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialTableLayout;", "Landroid/widget/TableLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "specialLayoutFlag", "", "layout", "", "l", "", "t", "r", "b", "flag", "onLayout", "changed", "plugin-radar_release"})
/* renamed from: com.tencent.mm.plugin.radar.ui.RadarSpecialTableLayout */
public final class RadarSpecialTableLayout extends TableLayout {
    private boolean pCR;

    public RadarSpecialTableLayout(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.m2504i(103014);
        AppMethodBeat.m2505o(103014);
    }

    public RadarSpecialTableLayout(Context context) {
        C25052j.m39376p(context, "context");
        super(context);
        AppMethodBeat.m2504i(103015);
        AppMethodBeat.m2505o(103015);
    }

    /* renamed from: D */
    public final void mo74105D(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(103012);
        this.pCR = true;
        super.layout(i, i2, i3, i4);
        AppMethodBeat.m2505o(103012);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        int i5;
        AppMethodBeat.m2504i(103013);
        if (this.pCR || i2 >= 0) {
            z2 = false;
            i5 = 0;
        } else {
            i5 = i4 - i2;
            z2 = true;
        }
        this.pCR = false;
        if (z2) {
            layout(i, 0, i3, i5);
            AppMethodBeat.m2505o(103013);
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.m2505o(103013);
    }
}
