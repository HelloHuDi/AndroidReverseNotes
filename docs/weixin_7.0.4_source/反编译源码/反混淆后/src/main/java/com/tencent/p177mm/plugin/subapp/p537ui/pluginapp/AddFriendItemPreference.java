package com.tencent.p177mm.plugin.subapp.p537ui.pluginapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.AddFriendItemPreference */
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
        AppMethodBeat.m2504i(25490);
        this.pnJ = "";
        this.qle = -1;
        this.qlf = 8;
        this.height = -1;
        this.context = context;
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(25490);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(25491);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130970142, viewGroup2);
        viewGroup2.setPadding(0, viewGroup2.getPaddingTop(), viewGroup2.getPaddingRight(), viewGroup2.getPaddingBottom());
        AppMethodBeat.m2505o(25491);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(25492);
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(2131822184);
        if (imageView != null) {
            imageView.setVisibility(8);
            if (this.drawable != null) {
                imageView.setImageDrawable(this.drawable);
                imageView.setVisibility(0);
            } else if (this.f4434rP != null) {
                imageView.setImageDrawable(this.f4434rP);
                imageView.setVisibility(0);
            } else if (this.f4433ZV != 0) {
                imageView.setImageResource(this.f4433ZV);
                imageView.setVisibility(0);
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
        AppMethodBeat.m2505o(25492);
    }
}
