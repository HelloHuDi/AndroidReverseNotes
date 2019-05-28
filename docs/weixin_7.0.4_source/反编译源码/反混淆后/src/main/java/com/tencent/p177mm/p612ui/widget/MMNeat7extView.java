package com.tencent.p177mm.p612ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.widget.MMNeat7extView */
public class MMNeat7extView extends NeatTextView {
    /* renamed from: RP */
    private static boolean f2104RP = true;
    public static boolean zMr = false;
    private static final String zMs = "^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$".substring(1, 149);
    private GestureDetector iay = new GestureDetector(getContext(), new C56231());
    private OnLongClickListener zMt;
    private C5625a zMu;
    private C5626b zMv;

    /* renamed from: com.tencent.mm.ui.widget.MMNeat7extView$1 */
    class C56231 extends SimpleOnGestureListener {
        C56231() {
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(107885);
            if (MMNeat7extView.this.getOnDoubleClickListener() == null) {
                AppMethodBeat.m2505o(107885);
                return false;
            }
            boolean fi = MMNeat7extView.this.getOnDoubleClickListener().mo11868fi(MMNeat7extView.this);
            AppMethodBeat.m2505o(107885);
            return fi;
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.MMNeat7extView$2 */
    class C56242 implements OnLongClickListener {
        C56242() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(107886);
            if (MMNeat7extView.zMr) {
                Toast.makeText(MMNeat7extView.this.getContext(), MMNeat7extView.asC(MMNeat7extView.this.dPr().toString()), 1).show();
            }
            if (MMNeat7extView.this.zMt != null) {
                boolean onLongClick = MMNeat7extView.this.zMt.onLongClick(view);
                AppMethodBeat.m2505o(107886);
                return onLongClick;
            }
            AppMethodBeat.m2505o(107886);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.MMNeat7extView$a */
    public interface C5625a {
        /* renamed from: ag */
        void mo11396ag(CharSequence charSequence);
    }

    /* renamed from: com.tencent.mm.ui.widget.MMNeat7extView$b */
    public interface C5626b {
        /* renamed from: a */
        void mo11397a(Exception exception, String str, String str2);
    }

    static {
        AppMethodBeat.m2504i(107897);
        AppMethodBeat.m2505o(107897);
    }

    public MMNeat7extView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(107887);
        AppMethodBeat.m2505o(107887);
    }

    public float getVerticalOffset() {
        AppMethodBeat.m2504i(107888);
        float verticalOffset;
        if (zMr) {
            verticalOffset = super.getVerticalOffset();
            getMeasuredHeight();
            AppMethodBeat.m2505o(107888);
            return verticalOffset;
        }
        verticalOffset = super.getVerticalOffset();
        AppMethodBeat.m2505o(107888);
        return verticalOffset;
    }

    @SuppressLint({"GetContentDescriptionOverride"})
    public CharSequence getContentDescription() {
        int i;
        AppMethodBeat.m2504i(107889);
        C4990ab.m7411d("MicroMsg.MMNeat7extView", "[isOpen] %s", Boolean.FALSE);
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        boolean isEnabled = accessibilityManager.isEnabled();
        boolean isTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
        if (isEnabled && isTouchExplorationEnabled) {
            i = 1;
        } else {
            i = 0;
        }
        CharSequence dPr;
        if (i != 0 || C4872b.dnO()) {
            dPr = super.dPr();
            AppMethodBeat.m2505o(107889);
            return dPr;
        }
        dPr = "";
        AppMethodBeat.m2505o(107889);
        return dPr;
    }

    public final boolean dKA() {
        return f2104RP;
    }

    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(107891);
        try {
            super.onDraw(canvas);
            AppMethodBeat.m2505o(107891);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMNeat7extView", "[onDraw] replaceContent:%s exception:%s", dPr().toString().replaceAll(zMs, "*"), e);
            if (this.zMv != null) {
                this.zMv.mo11397a(e, r1, "onDraw");
                AppMethodBeat.m2505o(107891);
                return;
            }
            AppMethodBeat.m2505o(107891);
            throw e;
        }
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(107892);
        try {
            super.onMeasure(i, i2);
            AppMethodBeat.m2505o(107892);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMNeat7extView", "[onMeasure] replaceContent:%s exception:%s", dPr().toString().replaceAll(zMs, "*"), e);
            if (this.zMv != null) {
                this.zMv.mo11397a(e, r1, "onMeasure");
                AppMethodBeat.m2505o(107892);
                return;
            }
            AppMethodBeat.m2505o(107892);
            throw e;
        }
    }

    /* renamed from: ah */
    public final void mo15921ah(CharSequence charSequence) {
        AppMethodBeat.m2504i(107893);
        try {
            super.mo15921ah(charSequence);
            if (this.AkW && this.zMv != null) {
                charSequence.toString();
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMNeat7extView", "[_setText] replaceContent:%s exception:%s", dPr().toString().replaceAll(zMs, "*"), e);
            if (this.zMv != null) {
                this.zMv.mo11397a(e, r1, "_setText");
            } else {
                AppMethodBeat.m2505o(107893);
                throw e;
            }
        }
        if (this.zMu != null) {
            C5625a c5625a = this.zMu;
            BufferType bufferType;
            if (charSequence instanceof Spannable) {
                bufferType = BufferType.SPANNABLE;
            } else {
                bufferType = BufferType.NORMAL;
            }
            c5625a.mo11396ag(charSequence);
        }
        AppMethodBeat.m2505o(107893);
    }

    /* renamed from: a */
    public final void mo15920a(CharSequence charSequence, BufferType bufferType) {
        AppMethodBeat.m2504i(107894);
        try {
            super.mo15920a(charSequence, bufferType);
            if (this.AkW && this.zMv != null) {
                charSequence.toString();
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMNeat7extView", "[_setText] replaceContent:%s exception:%s", dPr().toString().replaceAll(zMs, "*"), e);
            if (this.zMv != null) {
                this.zMv.mo11397a(e, r1, "_setText");
            } else {
                AppMethodBeat.m2505o(107894);
                throw e;
            }
        }
        if (this.zMu != null) {
            this.zMu.mo11396ag(charSequence);
        }
        AppMethodBeat.m2505o(107894);
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        AppMethodBeat.m2504i(107895);
        this.zMt = onLongClickListener;
        super.setOnLongClickListener(new C56242());
        AppMethodBeat.m2505o(107895);
    }

    public void setIsOpen(boolean z) {
        f2104RP = z;
    }

    public void setTextListener(C5625a c5625a) {
        this.zMu = c5625a;
    }

    public void setTextCrashListener(C5626b c5626b) {
        this.zMv = c5626b;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(107890);
        if (!f2104RP || (this.AkW && this.iay != null)) {
            this.iay.onTouchEvent(motionEvent);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(107890);
        return onTouchEvent;
    }

    static /* synthetic */ String asC(String str) {
        AppMethodBeat.m2504i(107896);
        String replaceAll = str.replaceAll(zMs, "*");
        StringBuilder stringBuilder = new StringBuilder(replaceAll);
        stringBuilder.append(10);
        stringBuilder.append('[');
        char[] toCharArray = replaceAll.toCharArray();
        for (char c : toCharArray) {
            if (c != '*') {
                stringBuilder.append("{\\u").append(String.format("%x", new Object[]{Integer.valueOf(toCharArray[r0])})).append("}");
            }
        }
        stringBuilder.append(']');
        replaceAll = stringBuilder.toString();
        AppMethodBeat.m2505o(107896);
        return replaceAll;
    }
}
