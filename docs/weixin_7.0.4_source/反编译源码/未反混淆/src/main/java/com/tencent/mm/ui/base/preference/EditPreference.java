package com.tencent.mm.ui.base.preference;

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
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

public class EditPreference extends Preference {
    private c gud;
    private EditText mLL;
    String value;
    a yBA;
    private com.tencent.mm.ui.base.preference.Preference.a yBv;

    public interface a {
        void dAx();
    }

    public EditPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a(com.tencent.mm.ui.base.preference.Preference.a aVar) {
        this.yBv = aVar;
    }

    public final void showDialog() {
        View view;
        AppMethodBeat.i(107162);
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
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(R.dimen.l5);
            marginLayoutParams.leftMargin = dimensionPixelSize;
            marginLayoutParams.rightMargin = dimensionPixelSize;
            marginLayoutParams.topMargin = dimensionPixelSize;
            marginLayoutParams.bottomMargin = dimensionPixelSize;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.gud = h.a(this.mContext, getTitle().toString(), view, com.tencent.mm.bz.a.an(this.mContext, R.string.s6), com.tencent.mm.bz.a.an(this.mContext, R.string.or), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(107160);
                if (EditPreference.this.gud != null) {
                    EditPreference.this.gud.dismiss();
                }
                EditPreference.this.value = view.getText().toString();
                if (EditPreference.this.yBA != null) {
                    EditPreference.this.yBA.dAx();
                }
                if (EditPreference.this.yBv != null) {
                    EditPreference.this.yBv.a(EditPreference.this, EditPreference.this.value);
                }
                AppMethodBeat.o(107160);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(107161);
                if (EditPreference.this.gud != null) {
                    EditPreference.this.gud.dismiss();
                }
                AppMethodBeat.o(107161);
            }
        });
        AppMethodBeat.o(107162);
    }
}
