package com.tencent.p177mm.plugin.sns.p520ui;

import android.text.Layout;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kiss.widget.textview.PLSysTextView;
import com.tencent.p177mm.kiss.widget.textview.SysTextView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C23305e;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C24944o;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.sns.ui.aa */
public final class C46247aa implements OnTouchListener {
    private static C24944o rkp;
    private static TextView rkq;

    /* renamed from: com.tencent.mm.plugin.sns.ui.aa$1 */
    class C291711 implements Runnable {
        C291711() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38304);
            C46247aa.crX();
            AppMethodBeat.m2505o(38304);
        }
    }

    /* JADX WARNING: Missing block: B:32:0x0099, code skipped:
            if (r6 > (((com.tencent.p177mm.kiss.widget.textview.PLSysTextView) r11).getVerticalDrawOffset() + r2.getHeight())) goto L_0x009b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(38305);
        TextView textView = (TextView) view;
        textView.getTag();
        CharSequence text = textView.getText();
        Layout layout = textView.getLayout();
        if (layout == null && (textView instanceof SysTextView)) {
            layout = ((SysTextView) textView).getTvLayout();
        }
        if (!(text instanceof Spannable) || layout == null) {
            AppMethodBeat.m2505o(38305);
            return false;
        }
        Layout tvLayout;
        Spannable spannable = (Spannable) text;
        int action = motionEvent.getAction();
        Layout layout2 = textView.getLayout();
        if (layout2 == null && (textView instanceof SysTextView)) {
            tvLayout = ((SysTextView) textView).getTvLayout();
        } else {
            tvLayout = layout2;
        }
        textView.invalidate();
        if (textView == null || spannable == null || !C23305e.m35789a(textView, spannable)) {
            if (action == 1 || action == 0 || action == 2) {
                int verticalDrawOffset;
                boolean z;
                action = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (textView instanceof PLSysTextView) {
                    if (action >= ((PLSysTextView) textView).getHorizontalDrawOffset()) {
                        if (action <= ((PLSysTextView) textView).getHorizontalDrawOffset() + tvLayout.getWidth()) {
                            if (y >= ((PLSysTextView) textView).getVerticalDrawOffset()) {
                            }
                            AppMethodBeat.m2505o(38305);
                            return false;
                        }
                    }
                    AppMethodBeat.m2505o(38305);
                    return false;
                } else if (textView instanceof TextView) {
                    if (action < textView.getTotalPaddingLeft() || action > tvLayout.getWidth() + textView.getTotalPaddingLeft()) {
                        AppMethodBeat.m2505o(38305);
                        return false;
                    } else if (y < textView.getTotalPaddingTop() || y > tvLayout.getHeight() + textView.getTotalPaddingTop()) {
                        AppMethodBeat.m2505o(38305);
                        return false;
                    }
                }
                if (textView instanceof PLSysTextView) {
                    action -= ((PLSysTextView) textView).getHorizontalDrawOffset();
                    verticalDrawOffset = y - ((PLSysTextView) textView).getVerticalDrawOffset();
                } else if (textView instanceof TextView) {
                    action -= textView.getTotalPaddingLeft();
                    verticalDrawOffset = y - textView.getTotalPaddingTop();
                } else {
                    action -= textView.getPaddingLeft();
                    verticalDrawOffset = y - textView.getPaddingTop();
                }
                verticalDrawOffset = tvLayout.getOffsetForHorizontal(tvLayout.getLineForVertical(verticalDrawOffset + textView.getScrollY()), (float) (action + textView.getScrollX()));
                int action2 = motionEvent.getAction();
                C24944o[] c24944oArr = (C24944o[]) spannable.getSpans(verticalDrawOffset, verticalDrawOffset, C24944o.class);
                action = c24944oArr.length - 1;
                C4990ab.m7410d("MicroMsg.MMOnTouchListener", " action span Len: " + c24944oArr.length);
                if (textView.getLayout() == null && (textView instanceof SysTextView)) {
                    ((SysTextView) textView).getTvLayout();
                }
                if (c24944oArr.length == 0) {
                    C46247aa.crX();
                    z = false;
                } else if (action2 == 1) {
                    c24944oArr[action].onClick(textView);
                    new C7306ak().postDelayed(new C291711(), 300);
                    z = true;
                } else {
                    if (action2 == 0 || action2 == 2 || action2 == 3) {
                        C46247aa.crX();
                        rkp = c24944oArr[action];
                        rkq = textView;
                        c24944oArr[action].ozq = true;
                        textView.invalidate();
                        z = true;
                    }
                    z = false;
                }
                if (z) {
                    AppMethodBeat.m2505o(38305);
                    return true;
                }
            }
            C46247aa.crX();
            AppMethodBeat.m2505o(38305);
            return false;
        }
        AppMethodBeat.m2505o(38305);
        return false;
    }

    public static void crX() {
        AppMethodBeat.m2504i(38306);
        if (rkp != null) {
            rkp.ozq = false;
            rkq.invalidate();
            rkq = null;
            rkp = null;
        }
        AppMethodBeat.m2505o(38306);
    }
}
