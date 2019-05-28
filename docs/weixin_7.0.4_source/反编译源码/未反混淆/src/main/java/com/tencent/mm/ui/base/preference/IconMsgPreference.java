package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.sdk.platformtools.bo;

public class IconMsgPreference extends Preference {
    private Context context;
    private Drawable drawable;
    private int height;
    private String pnJ;
    private int qle;
    private int qlf;
    private int yBD;
    private int yBE;
    private int yBF;
    private ImageView yBG;
    private ViewGroup yBH;
    private TextView yBI;
    private String yBJ;

    public IconMsgPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconMsgPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107163);
        this.pnJ = "";
        this.qle = -1;
        this.qlf = 8;
        this.yBD = 8;
        this.yBE = 0;
        this.yBF = 8;
        this.yBG = null;
        this.yBH = null;
        this.height = -1;
        this.yBJ = "";
        this.context = context;
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(107163);
    }

    /* Access modifiers changed, original: protected|final */
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(107164);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.afi, viewGroup2);
        onCreateView.setMinimumHeight(onCreateView.getResources().getDimensionPixelSize(R.dimen.nb));
        AppMethodBeat.o(107164);
        return onCreateView;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBindView(View view) {
        AppMethodBeat.i(107165);
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.aga);
        if (imageView != null) {
            if (this.drawable != null) {
                imageView.setImageDrawable(this.drawable);
                imageView.setVisibility(0);
            } else if (this.ZV != 0) {
                imageView.setImageResource(this.ZV);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.akp);
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
        TextView textView = (TextView) view.findViewById(R.id.akq);
        if (textView != null) {
            textView.setVisibility(this.qlf);
            textView.setText(this.pnJ);
            if (this.qle != -1) {
                textView.setBackgroundDrawable(a.g(this.context, this.qle));
            }
        }
        this.yBG = (ImageView) view.findViewById(R.id.akr);
        this.yBG.setVisibility(this.yBD);
        this.yBH = (ViewGroup) view.findViewById(R.id.akt);
        this.yBH.setVisibility(this.yBE);
        this.yBI = (TextView) view.findViewById(16908310);
        textView = (TextView) view.findViewById(R.id.da6);
        if (bo.isNullOrNil(this.yBJ)) {
            textView.setVisibility(8);
            AppMethodBeat.o(107165);
            return;
        }
        textView.setVisibility(0);
        textView.setText(this.yBJ);
        AppMethodBeat.o(107165);
    }
}
