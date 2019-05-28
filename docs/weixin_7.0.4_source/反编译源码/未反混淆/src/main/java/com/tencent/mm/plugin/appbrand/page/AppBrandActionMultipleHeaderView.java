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

public class AppBrandActionMultipleHeaderView extends LinearLayout {
    private ImageView cAw;
    private TextView exj;
    private String iqz;
    private String path;
    private int type;
    private String username;

    public AppBrandActionMultipleHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(87008);
        init(context);
        AppMethodBeat.o(87008);
    }

    @TargetApi(11)
    public AppBrandActionMultipleHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(87009);
        init(context);
        AppMethodBeat.o(87009);
    }

    private void init(Context context) {
        AppMethodBeat.i(87010);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.e_, this);
        this.cAw = (ImageView) findViewById(R.id.yc);
        this.exj = (TextView) findViewById(R.id.yd);
        AppMethodBeat.o(87010);
    }

    public int getType() {
        return this.type;
    }

    public String getH5Url() {
        return this.iqz;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPath() {
        return this.path;
    }

    public ImageView getImageView() {
        return this.cAw;
    }

    public void setImageResource(int i) {
        AppMethodBeat.i(87011);
        this.cAw.setImageResource(i);
        AppMethodBeat.o(87011);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(87012);
        this.cAw.setImageDrawable(drawable);
        AppMethodBeat.o(87012);
    }

    public void setTextViewText(String str) {
        AppMethodBeat.i(87013);
        this.exj.setText(str);
        AppMethodBeat.o(87013);
    }

    public void setTextViewTextColor(int i) {
        AppMethodBeat.i(87014);
        this.exj.setTextColor(i);
        AppMethodBeat.o(87014);
    }
}
