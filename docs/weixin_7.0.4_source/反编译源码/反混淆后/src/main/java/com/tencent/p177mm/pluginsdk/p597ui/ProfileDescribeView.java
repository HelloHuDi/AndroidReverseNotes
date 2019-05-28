package com.tencent.p177mm.pluginsdk.p597ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.widget.C5664a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7575bv;
import org.xwalk.core.Log;

/* renamed from: com.tencent.mm.pluginsdk.ui.ProfileDescribeView */
public class ProfileDescribeView extends ProfileItemView {
    public TextView vik;
    public TextView vil;

    public ProfileDescribeView(Context context) {
        super(context);
    }

    public ProfileDescribeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProfileDescribeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public int getLayout() {
        return 2130970403;
    }

    public final void init() {
        AppMethodBeat.m2504i(27507);
        this.vik = (TextView) findViewById(2131826650);
        this.vil = (TextView) findViewById(2131826649);
        setClickable(true);
        AppMethodBeat.m2505o(27507);
    }

    public final boolean cby() {
        AppMethodBeat.m2504i(27508);
        if (this.vil != null) {
            LayoutParams layoutParams = this.vil.getLayoutParams();
            layoutParams.width = C1338a.m2856al(getContext(), C25738R.dimen.f9862i8);
            this.vil.setLayoutParams(layoutParams);
        }
        if (this.ldh == null) {
            setVisibility(8);
            AppMethodBeat.m2505o(27508);
            return false;
        }
        String str = this.ldh.dul;
        if (C5046bo.isNullOrNil(this.ldh.dum)) {
            boolean z = false;
        } else {
            int z2 = 1;
        }
        Drawable drawable;
        CharSequence spannableString;
        if (!C7486a.m12942jh(this.ldh.field_type)) {
            C7575bv c7575bv = null;
            str = this.ldh.field_encryptUsername;
            if (!C5046bo.isNullOrNil(str)) {
                C9638aw.m17190ZK();
                c7575bv = C18628c.m29079XN().mo15364RB(str);
            }
            if (c7575bv != null && c7575bv.xDa < 0) {
                C9638aw.m17190ZK();
                c7575bv = C18628c.m29079XN().mo15364RB(this.ldh.field_username);
            }
            if (c7575bv == null || C5046bo.isNullOrNil(c7575bv.field_conDescription)) {
                Log.m81049i("MicroMsg.ProfileDescribeView", "ProfileDescribeView gone");
                setVisibility(8);
                AppMethodBeat.m2505o(27508);
                return false;
            }
            this.vik.setText(C44089j.m79293b(getContext(), C5046bo.nullAsNil(c7575bv.field_conDescription), this.vik.getTextSize()));
            AppMethodBeat.m2505o(27508);
            return true;
        } else if (!C5046bo.isNullOrNil(str) && z2 != 0) {
            drawable = getContext().getResources().getDrawable(C1318a.card_photoicon);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            C5664a c5664a = new C5664a(drawable);
            c5664a.zLT = (int) ((((float) drawable.getIntrinsicHeight()) - this.vik.getTextSize()) / 2.0f);
            spannableString = new SpannableString("  ".concat(String.valueOf(str)));
            spannableString.setSpan(c5664a, 0, 1, 33);
            this.vik.setText(C44089j.m79293b(getContext(), spannableString, this.vik.getTextSize()));
            AppMethodBeat.m2505o(27508);
            return true;
        } else if (!C5046bo.isNullOrNil(str) && z2 == 0) {
            this.vik.setText(C44089j.m79293b(getContext(), C5046bo.nullAsNil(str), this.vik.getTextSize()));
            AppMethodBeat.m2505o(27508);
            return true;
        } else if (C5046bo.isNullOrNil(str) && z2 != 0) {
            drawable = getContext().getResources().getDrawable(C1318a.card_photoicon);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            C5664a c5664a2 = new C5664a(drawable);
            c5664a2.zLT = (int) ((((float) drawable.getIntrinsicHeight()) - this.vik.getTextSize()) / 2.0f);
            spannableString = new SpannableString("  " + getContext().getString(C25738R.string.azi));
            spannableString.setSpan(c5664a2, 0, 1, 33);
            this.vik.setText(C44089j.m79293b(getContext(), spannableString, this.vik.getTextSize()));
            AppMethodBeat.m2505o(27508);
            return true;
        } else if (C5046bo.isNullOrNil(str) && z2 == 0) {
            Log.m81049i("MicroMsg.ProfileDescribeView", "ProfileDescribeView gone,isContact");
            setVisibility(8);
            AppMethodBeat.m2505o(27508);
            return false;
        } else {
            Log.m81049i("MicroMsg.ProfileDescribeView", "ProfileDescribeView gone,isContact");
            setVisibility(8);
            AppMethodBeat.m2505o(27508);
            return false;
        }
    }
}
