package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.b;

public class FavCapacityPanel extends LinearLayout {
    private OnClickListener mjE = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(74663);
            Intent intent = new Intent();
            if (FavCapacityPanel.this.mpw == 0) {
                intent.putExtra("key_enter_fav_cleanui_from", 1);
            } else {
                intent.putExtra("key_enter_fav_cleanui_from", 2);
            }
            b.b(FavCapacityPanel.this.getContext(), ".ui.FavCleanUI", intent);
            AppMethodBeat.o(74663);
        }
    };
    private LinearLayout mpt = this;
    public long mpu;
    public TextView mpv;
    public int mpw = 0;
    public long mpx;

    public FavCapacityPanel(Context context, AttributeSet attributeSet) {
        long j;
        super(context, attributeSet);
        AppMethodBeat.i(74664);
        View inflate = View.inflate(getContext(), R.layout.yz, null);
        inflate.measure(-2, -2);
        View findViewById = inflate.findViewById(R.id.brp);
        View findViewById2 = inflate.findViewById(R.id.brq);
        this.mpv = (TextView) inflate.findViewById(R.id.brr);
        LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
        layoutParams.width = inflate.getMeasuredWidth();
        findViewById.setLayoutParams(layoutParams);
        findViewById2.setOnClickListener(this.mjE);
        layoutParams = new LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.mpt.addView(inflate, layoutParams);
        this.mpu = b.buh() / 1048576;
        this.mpx = b.bui() / 1048576;
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
        textView.setText(context2.getString(R.string.bn3, objArr));
        AppMethodBeat.o(74664);
    }
}
