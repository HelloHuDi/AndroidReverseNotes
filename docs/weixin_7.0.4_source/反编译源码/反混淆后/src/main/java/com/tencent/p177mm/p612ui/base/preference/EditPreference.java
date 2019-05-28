package com.tencent.p177mm.p612ui.base.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.Preference.C23632a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;

/* renamed from: com.tencent.mm.ui.base.preference.EditPreference */
public class EditPreference extends Preference {
    private C5653c gud;
    private EditText mLL;
    String value;
    C40672a yBA;
    private C23632a yBv;

    /* renamed from: com.tencent.mm.ui.base.preference.EditPreference$2 */
    class C155362 implements OnClickListener {
        C155362() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(107161);
            if (EditPreference.this.gud != null) {
                EditPreference.this.gud.dismiss();
            }
            AppMethodBeat.m2505o(107161);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.preference.EditPreference$a */
    public interface C40672a {
        void dAx();
    }

    public EditPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    public final void mo27696a(C23632a c23632a) {
        this.yBv = c23632a;
    }

    public final void showDialog() {
        View view;
        AppMethodBeat.m2504i(107162);
        if (this.mLL != null) {
            view = this.mLL;
        } else {
            view = new EditText(this.mContext);
            view.setLayoutParams(new LayoutParams(-1, -2));
            view.setSingleLine(true);
            view.setText(this.value);
        }
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(C25738R.dimen.f9948l5);
            marginLayoutParams.leftMargin = dimensionPixelSize;
            marginLayoutParams.rightMargin = dimensionPixelSize;
            marginLayoutParams.topMargin = dimensionPixelSize;
            marginLayoutParams.bottomMargin = dimensionPixelSize;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.gud = C30379h.m48437a(this.mContext, getTitle().toString(), view, C1338a.m2858an(this.mContext, C25738R.string.f9187s6), C1338a.m2858an(this.mContext, C25738R.string.f9076or), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(107160);
                if (EditPreference.this.gud != null) {
                    EditPreference.this.gud.dismiss();
                }
                EditPreference.this.value = view.getText().toString();
                if (EditPreference.this.yBA != null) {
                    EditPreference.this.yBA.dAx();
                }
                if (EditPreference.this.yBv != null) {
                    EditPreference.this.yBv.mo39405a(EditPreference.this, EditPreference.this.value);
                }
                AppMethodBeat.m2505o(107160);
            }
        }, new C155362());
        AppMethodBeat.m2505o(107162);
    }
}
