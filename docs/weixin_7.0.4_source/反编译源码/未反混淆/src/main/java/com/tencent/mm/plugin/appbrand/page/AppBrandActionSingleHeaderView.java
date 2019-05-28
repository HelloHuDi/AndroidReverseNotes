package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class AppBrandActionSingleHeaderView extends LinearLayout {
    private ImageView cAw;
    private TextView exj;

    public AppBrandActionSingleHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(87015);
        init(context);
        AppMethodBeat.o(87015);
    }

    @TargetApi(11)
    public AppBrandActionSingleHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(87016);
        init(context);
        AppMethodBeat.o(87016);
    }

    private void init(Context context) {
        AppMethodBeat.i(87017);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.ea, this);
        this.cAw = (ImageView) findViewById(R.id.ye);
        this.exj = (TextView) findViewById(R.id.yf);
        AppMethodBeat.o(87017);
    }

    public ImageView getImageView() {
        return this.cAw;
    }

    public void setImageResource(int i) {
        AppMethodBeat.i(87018);
        this.cAw.setImageResource(i);
        AppMethodBeat.o(87018);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(87019);
        this.cAw.setImageDrawable(drawable);
        AppMethodBeat.o(87019);
    }

    public void setTextViewText(String str) {
        AppMethodBeat.i(87020);
        this.exj.setText(str);
        AppMethodBeat.o(87020);
    }

    public void setTextViewTextColor(int i) {
        AppMethodBeat.i(87021);
        this.exj.setTextColor(i);
        AppMethodBeat.o(87021);
    }
}
