package com.tencent.mm.plugin.subapp.ui.pluginapp;

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
import com.tencent.mm.ui.base.preference.Preference;

public class AddFriendItemPreference extends Preference {
    private Context context;
    private Drawable drawable;
    private int height;
    private String pnJ;
    private int qle;
    int qlf;

    public AddFriendItemPreference(Context context) {
        this(context, null);
    }

    public AddFriendItemPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AddFriendItemPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(25490);
        this.pnJ = "";
        this.qle = -1;
        this.qlf = 8;
        this.height = -1;
        this.context = context;
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(25490);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(25491);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.aei, viewGroup2);
        viewGroup2.setPadding(0, viewGroup2.getPaddingTop(), viewGroup2.getPaddingRight(), viewGroup2.getPaddingBottom());
        AppMethodBeat.o(25491);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(25492);
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.aga);
        if (imageView != null) {
            imageView.setVisibility(8);
            if (this.drawable != null) {
                imageView.setImageDrawable(this.drawable);
                imageView.setVisibility(0);
            } else if (this.rP != null) {
                imageView.setImageDrawable(this.rP);
                imageView.setVisibility(0);
            } else if (this.ZV != 0) {
                imageView.setImageResource(this.ZV);
                imageView.setVisibility(0);
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
        AppMethodBeat.o(25492);
    }
}
