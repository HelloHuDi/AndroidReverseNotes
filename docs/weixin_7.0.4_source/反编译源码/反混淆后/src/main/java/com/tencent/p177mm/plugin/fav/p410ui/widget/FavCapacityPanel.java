package com.tencent.p177mm.plugin.fav.p410ui.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;

/* renamed from: com.tencent.mm.plugin.fav.ui.widget.FavCapacityPanel */
public class FavCapacityPanel extends LinearLayout {
    private OnClickListener mjE = new C280331();
    private LinearLayout mpt = this;
    public long mpu;
    public TextView mpv;
    public int mpw = 0;
    public long mpx;

    /* renamed from: com.tencent.mm.plugin.fav.ui.widget.FavCapacityPanel$1 */
    class C280331 implements OnClickListener {
        C280331() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(74663);
            Intent intent = new Intent();
            if (FavCapacityPanel.this.mpw == 0) {
                intent.putExtra("key_enter_fav_cleanui_from", 1);
            } else {
                intent.putExtra("key_enter_fav_cleanui_from", 2);
            }
            C39037b.m66371b(FavCapacityPanel.this.getContext(), ".ui.FavCleanUI", intent);
            AppMethodBeat.m2505o(74663);
        }
    }

    public FavCapacityPanel(Context context, AttributeSet attributeSet) {
        long j;
        super(context, attributeSet);
        AppMethodBeat.m2504i(74664);
        View inflate = View.inflate(getContext(), 2130969528, null);
        inflate.measure(-2, -2);
        View findViewById = inflate.findViewById(2131823974);
        View findViewById2 = inflate.findViewById(2131823975);
        this.mpv = (TextView) inflate.findViewById(2131823976);
        LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
        layoutParams.width = inflate.getMeasuredWidth();
        findViewById.setLayoutParams(layoutParams);
        findViewById2.setOnClickListener(this.mjE);
        layoutParams = new LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.mpt.addView(inflate, layoutParams);
        this.mpu = C39037b.buh() / 1048576;
        this.mpx = C39037b.bui() / 1048576;
        TextView textView = this.mpv;
        Context context2 = this.mpv.getContext();
        Object[] objArr = new Object[2];
        if (this.mpx - this.mpu > 0) {
            j = this.mpx - this.mpu;
        } else {
            j = 0;
        }
        objArr[0] = Long.valueOf(j);
        objArr[1] = Long.valueOf(this.mpu);
        textView.setText(context2.getString(C25738R.string.bn3, objArr));
        AppMethodBeat.m2505o(74664);
    }
}
