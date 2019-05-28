package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.plugin.account.ui.a */
public final class C2034a extends BaseAdapter {
    private LayoutInflater ezi;
    private String[] gAe;
    private Drawable gAf = null;
    private OnTouchListener gAg = new C20351();

    /* renamed from: com.tencent.mm.plugin.account.ui.a$1 */
    class C20351 implements OnTouchListener {
        C20351() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(124712);
            if (motionEvent.getAction() == 0) {
                ((TextView) view.findViewById(2131821097)).setTextColor(-10395295);
                AppMethodBeat.m2505o(124712);
            } else if (motionEvent.getAction() == 1) {
                ((TextView) view.findViewById(2131821097)).setTextColor(-1);
                AppMethodBeat.m2505o(124712);
            } else {
                AppMethodBeat.m2505o(124712);
            }
            return false;
        }
    }

    public C2034a(Context context, String[] strArr) {
        AppMethodBeat.m2504i(124713);
        this.gAe = strArr;
        this.ezi = LayoutInflater.from(context);
        this.gAf = context.getResources().getDrawable(C25738R.drawable.aom);
        this.gAf.setBounds(0, 0, this.gAf.getIntrinsicWidth(), this.gAf.getIntrinsicHeight());
        AppMethodBeat.m2505o(124713);
    }

    public final int getCount() {
        return this.gAe.length;
    }

    public final Object getItem(int i) {
        return this.gAe[i];
    }

    /* renamed from: nc */
    private boolean m4205nc(int i) {
        if (i == this.gAe.length - 1) {
            return true;
        }
        return false;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        int i3 = 1;
        AppMethodBeat.m2504i(124714);
        if (view == null) {
            view = this.ezi.inflate(2130968646, null);
        }
        TextView textView = (TextView) view.findViewById(2131821097);
        view.setOnTouchListener(this.gAg);
        if (i == 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i2 == 0 || !m4205nc(i)) {
            if (i != 0) {
                i3 = 0;
            }
            if (i3 != 0) {
                textView.setPadding(25, 0, 10, 10);
                textView.setCompoundDrawablePadding(10);
                textView.setCompoundDrawables(null, null, this.gAf, null);
            } else if (m4205nc(i)) {
                textView.setPadding(0, 0, 25, 10);
                textView.setCompoundDrawablePadding(0);
                textView.setCompoundDrawables(null, null, null, null);
            } else {
                textView.setPadding(0, 0, 10, 10);
                textView.setCompoundDrawablePadding(10);
                textView.setCompoundDrawables(null, null, this.gAf, null);
            }
        } else {
            textView.setPadding(25, 0, 25, 10);
            textView.setCompoundDrawablePadding(0);
            textView.setCompoundDrawables(null, null, null, null);
        }
        textView.setText(this.gAe[i]);
        AppMethodBeat.m2505o(124714);
        return view;
    }
}
