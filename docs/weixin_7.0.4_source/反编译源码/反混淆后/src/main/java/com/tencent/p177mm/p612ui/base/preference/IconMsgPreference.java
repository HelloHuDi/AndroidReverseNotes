package com.tencent.p177mm.p612ui.base.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.base.preference.IconMsgPreference */
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
        AppMethodBeat.m2504i(107163);
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
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(107163);
    }

    /* Access modifiers changed, original: protected|final */
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(107164);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130970179, viewGroup2);
        onCreateView.setMinimumHeight(onCreateView.getResources().getDimensionPixelSize(C25738R.dimen.f10010nb));
        AppMethodBeat.m2505o(107164);
        return onCreateView;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBindView(View view) {
        AppMethodBeat.m2504i(107165);
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(2131822184);
        if (imageView != null) {
            if (this.drawable != null) {
                imageView.setImageDrawable(this.drawable);
                imageView.setVisibility(0);
            } else if (this.f4433ZV != 0) {
                imageView.setImageResource(this.f4433ZV);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(2131822347);
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
        TextView textView = (TextView) view.findViewById(2131822348);
        if (textView != null) {
            textView.setVisibility(this.qlf);
            textView.setText(this.pnJ);
            if (this.qle != -1) {
                textView.setBackgroundDrawable(C1338a.m2864g(this.context, this.qle));
            }
        }
        this.yBG = (ImageView) view.findViewById(2131822349);
        this.yBG.setVisibility(this.yBD);
        this.yBH = (ViewGroup) view.findViewById(2131822351);
        this.yBH.setVisibility(this.yBE);
        this.yBI = (TextView) view.findViewById(16908310);
        textView = (TextView) view.findViewById(2131826062);
        if (C5046bo.isNullOrNil(this.yBJ)) {
            textView.setVisibility(8);
            AppMethodBeat.m2505o(107165);
            return;
        }
        textView.setVisibility(0);
        textView.setText(this.yBJ);
        AppMethodBeat.m2505o(107165);
    }
}
