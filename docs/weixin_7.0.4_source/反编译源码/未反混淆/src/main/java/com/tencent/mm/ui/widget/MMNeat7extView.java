package com.tencent.mm.ui.widget;

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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.neattextview.textview.view.NeatTextView;

public class MMNeat7extView extends NeatTextView {
    private static boolean RP = true;
    public static boolean zMr = false;
    private static final String zMs = "^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$".substring(1, 149);
    private GestureDetector iay = new GestureDetector(getContext(), new SimpleOnGestureListener() {
        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.i(107885);
            if (MMNeat7extView.this.getOnDoubleClickListener() == null) {
                AppMethodBeat.o(107885);
                return false;
            }
            boolean fi = MMNeat7extView.this.getOnDoubleClickListener().fi(MMNeat7extView.this);
            AppMethodBeat.o(107885);
            return fi;
        }
    });
    private OnLongClickListener zMt;
    private a zMu;
    private b zMv;

    public interface a {
        void ag(CharSequence charSequence);
    }

    public interface b {
        void a(Exception exception, String str, String str2);
    }

    static {
        AppMethodBeat.i(107897);
        AppMethodBeat.o(107897);
    }

    public MMNeat7extView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(107887);
        AppMethodBeat.o(107887);
    }

    public float getVerticalOffset() {
        AppMethodBeat.i(107888);
        float verticalOffset;
        if (zMr) {
            verticalOffset = super.getVerticalOffset();
            getMeasuredHeight();
            AppMethodBeat.o(107888);
            return verticalOffset;
        }
        verticalOffset = super.getVerticalOffset();
        AppMethodBeat.o(107888);
        return verticalOffset;
    }

    @SuppressLint({"GetContentDescriptionOverride"})
    public CharSequence getContentDescription() {
        int i;
        AppMethodBeat.i(107889);
        ab.d("MicroMsg.MMNeat7extView", "[isOpen] %s", Boolean.FALSE);
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        boolean isEnabled = accessibilityManager.isEnabled();
        boolean isTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
        if (isEnabled && isTouchExplorationEnabled) {
            i = 1;
        } else {
            i = 0;
        }
        CharSequence dPr;
        if (i != 0 || com.tencent.mm.sdk.a.b.dnO()) {
            dPr = super.dPr();
            AppMethodBeat.o(107889);
            return dPr;
        }
        dPr = "";
        AppMethodBeat.o(107889);
        return dPr;
    }

    public final boolean dKA() {
        return RP;
    }

    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(107891);
        try {
            super.onDraw(canvas);
            AppMethodBeat.o(107891);
        } catch (Exception e) {
            ab.e("MicroMsg.MMNeat7extView", "[onDraw] replaceContent:%s exception:%s", dPr().toString().replaceAll(zMs, "*"), e);
            if (this.zMv != null) {
                this.zMv.a(e, r1, "onDraw");
                AppMethodBeat.o(107891);
                return;
            }
            AppMethodBeat.o(107891);
            throw e;
        }
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(107892);
        try {
            super.onMeasure(i, i2);
            AppMethodBeat.o(107892);
        } catch (Exception e) {
            ab.e("MicroMsg.MMNeat7extView", "[onMeasure] replaceContent:%s exception:%s", dPr().toString().replaceAll(zMs, "*"), e);
            if (this.zMv != null) {
                this.zMv.a(e, r1, "onMeasure");
                AppMethodBeat.o(107892);
                return;
            }
            AppMethodBeat.o(107892);
            throw e;
        }
    }

    public final void ah(CharSequence charSequence) {
        AppMethodBeat.i(107893);
        try {
            super.ah(charSequence);
            if (this.AkW && this.zMv != null) {
                charSequence.toString();
            }
        } catch (Exception e) {
            ab.e("MicroMsg.MMNeat7extView", "[_setText] replaceContent:%s exception:%s", dPr().toString().replaceAll(zMs, "*"), e);
            if (this.zMv != null) {
                this.zMv.a(e, r1, "_setText");
            } else {
                AppMethodBeat.o(107893);
                throw e;
            }
        }
        if (this.zMu != null) {
            a aVar = this.zMu;
            BufferType bufferType;
            if (charSequence instanceof Spannable) {
                bufferType = BufferType.SPANNABLE;
            } else {
                bufferType = BufferType.NORMAL;
            }
            aVar.ag(charSequence);
        }
        AppMethodBeat.o(107893);
    }

    public final void a(CharSequence charSequence, BufferType bufferType) {
        AppMethodBeat.i(107894);
        try {
            super.a(charSequence, bufferType);
            if (this.AkW && this.zMv != null) {
                charSequence.toString();
            }
        } catch (Exception e) {
            ab.e("MicroMsg.MMNeat7extView", "[_setText] replaceContent:%s exception:%s", dPr().toString().replaceAll(zMs, "*"), e);
            if (this.zMv != null) {
                this.zMv.a(e, r1, "_setText");
            } else {
                AppMethodBeat.o(107894);
                throw e;
            }
        }
        if (this.zMu != null) {
            this.zMu.ag(charSequence);
        }
        AppMethodBeat.o(107894);
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        AppMethodBeat.i(107895);
        this.zMt = onLongClickListener;
        super.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                AppMethodBeat.i(107886);
                if (MMNeat7extView.zMr) {
                    Toast.makeText(MMNeat7extView.this.getContext(), MMNeat7extView.asC(MMNeat7extView.this.dPr().toString()), 1).show();
                }
                if (MMNeat7extView.this.zMt != null) {
                    boolean onLongClick = MMNeat7extView.this.zMt.onLongClick(view);
                    AppMethodBeat.o(107886);
                    return onLongClick;
                }
                AppMethodBeat.o(107886);
                return false;
            }
        });
        AppMethodBeat.o(107895);
    }

    public void setIsOpen(boolean z) {
        RP = z;
    }

    public void setTextListener(a aVar) {
        this.zMu = aVar;
    }

    public void setTextCrashListener(b bVar) {
        this.zMv = bVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(107890);
        if (!RP || (this.AkW && this.iay != null)) {
            this.iay.onTouchEvent(motionEvent);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(107890);
        return onTouchEvent;
    }

    static /* synthetic */ String asC(String str) {
        AppMethodBeat.i(107896);
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
        AppMethodBeat.o(107896);
        return replaceAll;
    }
}
