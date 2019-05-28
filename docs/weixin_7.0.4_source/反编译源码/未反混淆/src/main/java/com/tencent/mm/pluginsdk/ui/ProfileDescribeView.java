package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bv;
import org.xwalk.core.Log;

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
        return R.layout.alj;
    }

    public final void init() {
        AppMethodBeat.i(27507);
        this.vik = (TextView) findViewById(R.id.dq2);
        this.vil = (TextView) findViewById(R.id.dq1);
        setClickable(true);
        AppMethodBeat.o(27507);
    }

    public final boolean cby() {
        AppMethodBeat.i(27508);
        if (this.vil != null) {
            LayoutParams layoutParams = this.vil.getLayoutParams();
            layoutParams.width = a.al(getContext(), R.dimen.i8);
            this.vil.setLayoutParams(layoutParams);
        }
        if (this.ldh == null) {
            setVisibility(8);
            AppMethodBeat.o(27508);
            return false;
        }
        String str = this.ldh.dul;
        if (bo.isNullOrNil(this.ldh.dum)) {
            boolean z = false;
        } else {
            int z2 = 1;
        }
        Drawable drawable;
        CharSequence spannableString;
        if (!com.tencent.mm.n.a.jh(this.ldh.field_type)) {
            bv bvVar = null;
            str = this.ldh.field_encryptUsername;
            if (!bo.isNullOrNil(str)) {
                aw.ZK();
                bvVar = c.XN().RB(str);
            }
            if (bvVar != null && bvVar.xDa < 0) {
                aw.ZK();
                bvVar = c.XN().RB(this.ldh.field_username);
            }
            if (bvVar == null || bo.isNullOrNil(bvVar.field_conDescription)) {
                Log.i("MicroMsg.ProfileDescribeView", "ProfileDescribeView gone");
                setVisibility(8);
                AppMethodBeat.o(27508);
                return false;
            }
            this.vik.setText(j.b(getContext(), bo.nullAsNil(bvVar.field_conDescription), this.vik.getTextSize()));
            AppMethodBeat.o(27508);
            return true;
        } else if (!bo.isNullOrNil(str) && z2 != 0) {
            drawable = getContext().getResources().getDrawable(R.raw.card_photoicon);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable);
            aVar.zLT = (int) ((((float) drawable.getIntrinsicHeight()) - this.vik.getTextSize()) / 2.0f);
            spannableString = new SpannableString("  ".concat(String.valueOf(str)));
            spannableString.setSpan(aVar, 0, 1, 33);
            this.vik.setText(j.b(getContext(), spannableString, this.vik.getTextSize()));
            AppMethodBeat.o(27508);
            return true;
        } else if (!bo.isNullOrNil(str) && z2 == 0) {
            this.vik.setText(j.b(getContext(), bo.nullAsNil(str), this.vik.getTextSize()));
            AppMethodBeat.o(27508);
            return true;
        } else if (bo.isNullOrNil(str) && z2 != 0) {
            drawable = getContext().getResources().getDrawable(R.raw.card_photoicon);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            com.tencent.mm.ui.widget.a aVar2 = new com.tencent.mm.ui.widget.a(drawable);
            aVar2.zLT = (int) ((((float) drawable.getIntrinsicHeight()) - this.vik.getTextSize()) / 2.0f);
            spannableString = new SpannableString("  " + getContext().getString(R.string.azi));
            spannableString.setSpan(aVar2, 0, 1, 33);
            this.vik.setText(j.b(getContext(), spannableString, this.vik.getTextSize()));
            AppMethodBeat.o(27508);
            return true;
        } else if (bo.isNullOrNil(str) && z2 == 0) {
            Log.i("MicroMsg.ProfileDescribeView", "ProfileDescribeView gone,isContact");
            setVisibility(8);
            AppMethodBeat.o(27508);
            return false;
        } else {
            Log.i("MicroMsg.ProfileDescribeView", "ProfileDescribeView gone,isContact");
            setVisibility(8);
            AppMethodBeat.o(27508);
            return false;
        }
    }
}
