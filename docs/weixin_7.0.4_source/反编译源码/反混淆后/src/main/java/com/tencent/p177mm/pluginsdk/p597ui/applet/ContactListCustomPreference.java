package com.tencent.p177mm.pluginsdk.p597ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.pluginsdk.ui.applet.ContactListCustomPreference */
public class ContactListCustomPreference extends Preference {
    int background = -1;
    OnClickListener pLd;
    private View uvN;
    private final OnTouchListener vla = new C358311();

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.ContactListCustomPreference$1 */
    class C358311 implements OnTouchListener {
        C358311() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public ContactListCustomPreference(Context context) {
        super(context);
        AppMethodBeat.m2504i(79759);
        setLayoutResource(2130970140);
        AppMethodBeat.m2505o(79759);
    }

    public ContactListCustomPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(79760);
        setLayoutResource(2130970140);
        AppMethodBeat.m2505o(79760);
    }

    public ContactListCustomPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(79761);
        setLayoutResource(2130970140);
        AppMethodBeat.m2505o(79761);
    }

    public final void setCustomView(View view) {
        if (view != null) {
            this.uvN = view;
        }
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(79762);
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
        AppMethodBeat.m2505o(79762);
    }
}
