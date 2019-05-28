package com.tencent.matrix.trace.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class FloatFrameView extends LinearLayout {
    public TextView caB = ((TextView) findViewById(R.id.buc));

    public FloatFrameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayoutParams(new LayoutParams(-2, -2));
        LayoutInflater.from(context).inflate(R.layout.a01, this);
    }
}
