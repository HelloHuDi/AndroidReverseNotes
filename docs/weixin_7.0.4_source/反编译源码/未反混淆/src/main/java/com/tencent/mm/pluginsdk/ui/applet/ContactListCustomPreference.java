package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactListCustomPreference extends Preference {
    int background = -1;
    OnClickListener pLd;
    private View uvN;
    private final OnTouchListener vla = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };

    public ContactListCustomPreference(Context context) {
        super(context);
        AppMethodBeat.i(79759);
        setLayoutResource(R.layout.aeg);
        AppMethodBeat.o(79759);
    }

    public ContactListCustomPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(79760);
        setLayoutResource(R.layout.aeg);
        AppMethodBeat.o(79760);
    }

    public ContactListCustomPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(79761);
        setLayoutResource(R.layout.aeg);
        AppMethodBeat.o(79761);
    }

    public final void setCustomView(View view) {
        if (view != null) {
            this.uvN = view;
        }
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(79762);
        ViewGroup viewGroup = (ViewGroup) view;
        if (!(this.uvN == null || this.uvN == null)) {
            viewGroup.removeAllViews();
            if (this.uvN.getParent() != null) {
                ((ViewGroup) this.uvN.getParent()).removeAllViews();
            }
            viewGroup.addView(this.uvN);
            if (this.pLd != null) {
                viewGroup.setOnClickListener(this.pLd);
            } else {
                viewGroup.setOnTouchListener(this.vla);
            }
        }
        if (this.background >= 0) {
            view.setBackgroundResource(this.background);
        }
        AppMethodBeat.o(79762);
    }
}
