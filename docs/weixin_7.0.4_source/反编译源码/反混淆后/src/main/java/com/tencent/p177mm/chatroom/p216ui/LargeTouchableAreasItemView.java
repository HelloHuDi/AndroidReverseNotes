package com.tencent.p177mm.chatroom.p216ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.chatroom.ui.LargeTouchableAreasItemView */
public class LargeTouchableAreasItemView extends LinearLayout {
    private static final int ejr = Color.argb(0, 0, 0, 0);
    private final ArrayList<C32449b> ejs = new ArrayList();
    private C37653d ejt;
    private C32448a eju;
    private int ejv;
    private boolean ejw;
    private int ejx = -1;
    private int ejy = -1;
    private ImageButton ejz;
    private final Paint mPaint = new Paint();

    /* renamed from: com.tencent.mm.chatroom.ui.LargeTouchableAreasItemView$1 */
    class C92161 implements OnClickListener {
        C92161() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(104104);
            LargeTouchableAreasItemView.this.setItemViewSelected(!LargeTouchableAreasItemView.this.ejw);
            if (LargeTouchableAreasItemView.this.eju != null) {
                LargeTouchableAreasItemView.this.eju;
                LargeTouchableAreasItemView.this.ejw;
            }
            AppMethodBeat.m2505o(104104);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.LargeTouchableAreasItemView$a */
    public interface C32448a {
    }

    /* renamed from: com.tencent.mm.chatroom.ui.LargeTouchableAreasItemView$b */
    static class C32449b {
        public int color;
        public Rect rect;

        public C32449b(Rect rect, int i) {
            this.rect = rect;
            this.color = i;
        }
    }

    static {
        AppMethodBeat.m2504i(104110);
        AppMethodBeat.m2505o(104110);
    }

    public LargeTouchableAreasItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(104105);
        setOrientation(0);
        setDescendantFocusability(393216);
        this.ejt = new C37653d(this);
        this.mPaint.setStyle(Style.FILL);
        this.ejv = (int) ((context.getResources().getDisplayMetrics().density * 66.0f) + 0.5f);
        LayoutInflater.from(context).inflate(2130969129, this);
        AppMethodBeat.m2505o(104105);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(104106);
        super.onFinishInflate();
        this.ejz = (ImageButton) findViewById(2131822735);
        this.ejz.setOnClickListener(new C92161());
        AppMethodBeat.m2505o(104106);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(104107);
        super.onLayout(z, i, i2, i3, i4);
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (!(i5 == this.ejx && i6 == this.ejy)) {
            this.ejx = i5;
            this.ejy = i6;
            C37653d c37653d = this.ejt;
            if (c37653d.eod != null) {
                c37653d.eod.clear();
            }
            c37653d.eoe = null;
            Rect rect = new Rect((i5 - this.ejz.getWidth()) - this.ejv, 0, i5, i6);
            i5 = ejr;
            ImageButton imageButton = this.ejz;
            C37653d c37653d2 = this.ejt;
            TouchDelegate touchDelegate = new TouchDelegate(rect, imageButton);
            if (c37653d2.eod == null) {
                c37653d2.eod = new ArrayList();
            }
            c37653d2.eod.add(touchDelegate);
            this.ejs.add(new C32449b(rect, i5));
            setTouchDelegate(this.ejt);
        }
        AppMethodBeat.m2505o(104107);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.m2504i(104108);
        Iterator it = this.ejs.iterator();
        while (it.hasNext()) {
            C32449b c32449b = (C32449b) it.next();
            this.mPaint.setColor(c32449b.color);
            canvas.drawRect(c32449b.rect, this.mPaint);
        }
        super.dispatchDraw(canvas);
        AppMethodBeat.m2505o(104108);
    }

    public void setItemViewSelected(boolean z) {
        AppMethodBeat.m2504i(104109);
        if (this.ejw != z) {
            this.ejw = z;
            this.ejz.setImageResource(this.ejw ? C1318a.checkbox_selected : C1318a.checkbox_unselected);
        }
        AppMethodBeat.m2505o(104109);
    }

    public boolean getSelected() {
        return this.ejw;
    }

    public void setOnLargeTouchableAreasListener(C32448a c32448a) {
        this.eju = c32448a;
    }
}
