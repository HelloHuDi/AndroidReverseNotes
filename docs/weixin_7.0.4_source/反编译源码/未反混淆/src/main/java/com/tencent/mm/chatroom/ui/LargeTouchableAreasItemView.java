package com.tencent.mm.chatroom.ui;

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
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.Iterator;

public class LargeTouchableAreasItemView extends LinearLayout {
    private static final int ejr = Color.argb(0, 0, 0, 0);
    private final ArrayList<b> ejs = new ArrayList();
    private d ejt;
    private a eju;
    private int ejv;
    private boolean ejw;
    private int ejx = -1;
    private int ejy = -1;
    private ImageButton ejz;
    private final Paint mPaint = new Paint();

    public interface a {
    }

    static class b {
        public int color;
        public Rect rect;

        public b(Rect rect, int i) {
            this.rect = rect;
            this.color = i;
        }
    }

    static {
        AppMethodBeat.i(104110);
        AppMethodBeat.o(104110);
    }

    public LargeTouchableAreasItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(104105);
        setOrientation(0);
        setDescendantFocusability(393216);
        this.ejt = new d(this);
        this.mPaint.setStyle(Style.FILL);
        this.ejv = (int) ((context.getResources().getDisplayMetrics().density * 66.0f) + 0.5f);
        LayoutInflater.from(context).inflate(R.layout.o7, this);
        AppMethodBeat.o(104105);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(104106);
        super.onFinishInflate();
        this.ejz = (ImageButton) findViewById(R.id.av8);
        this.ejz.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(104104);
                LargeTouchableAreasItemView.this.setItemViewSelected(!LargeTouchableAreasItemView.this.ejw);
                if (LargeTouchableAreasItemView.this.eju != null) {
                    LargeTouchableAreasItemView.this.eju;
                    LargeTouchableAreasItemView.this.ejw;
                }
                AppMethodBeat.o(104104);
            }
        });
        AppMethodBeat.o(104106);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(104107);
        super.onLayout(z, i, i2, i3, i4);
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (!(i5 == this.ejx && i6 == this.ejy)) {
            this.ejx = i5;
            this.ejy = i6;
            d dVar = this.ejt;
            if (dVar.eod != null) {
                dVar.eod.clear();
            }
            dVar.eoe = null;
            Rect rect = new Rect((i5 - this.ejz.getWidth()) - this.ejv, 0, i5, i6);
            i5 = ejr;
            ImageButton imageButton = this.ejz;
            d dVar2 = this.ejt;
            TouchDelegate touchDelegate = new TouchDelegate(rect, imageButton);
            if (dVar2.eod == null) {
                dVar2.eod = new ArrayList();
            }
            dVar2.eod.add(touchDelegate);
            this.ejs.add(new b(rect, i5));
            setTouchDelegate(this.ejt);
        }
        AppMethodBeat.o(104107);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(104108);
        Iterator it = this.ejs.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            this.mPaint.setColor(bVar.color);
            canvas.drawRect(bVar.rect, this.mPaint);
        }
        super.dispatchDraw(canvas);
        AppMethodBeat.o(104108);
    }

    public void setItemViewSelected(boolean z) {
        AppMethodBeat.i(104109);
        if (this.ejw != z) {
            this.ejw = z;
            this.ejz.setImageResource(this.ejw ? R.raw.checkbox_selected : R.raw.checkbox_unselected);
        }
        AppMethodBeat.o(104109);
    }

    public boolean getSelected() {
        return this.ejw;
    }

    public void setOnLargeTouchableAreasListener(a aVar) {
        this.eju = aVar;
    }
}
