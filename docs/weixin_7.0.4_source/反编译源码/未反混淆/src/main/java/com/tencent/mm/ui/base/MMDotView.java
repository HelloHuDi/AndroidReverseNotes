package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ad.a.a;
import com.tencent.mm.sdk.platformtools.ab;

public class MMDotView extends LinearLayout {
    private int ehD = 9;
    private int ytZ = R.drawable.wk;
    private int yua = R.drawable.wi;

    @TargetApi(11)
    public MMDotView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(106527);
        init(context, attributeSet);
        AppMethodBeat.o(106527);
    }

    public MMDotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(106528);
        init(context, attributeSet);
        AppMethodBeat.o(106528);
    }

    private void init(Context context, AttributeSet attributeSet) {
        AppMethodBeat.i(106529);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.MMDotView);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        setDotCount(resourceId);
        AppMethodBeat.o(106529);
    }

    public void setDarkStyle(boolean z) {
        if (z) {
            this.ytZ = R.drawable.wl;
            this.yua = R.drawable.wj;
            return;
        }
        this.ytZ = R.drawable.wk;
        this.yua = R.drawable.wi;
    }

    public void setInvertedStyle(boolean z) {
        if (z) {
            this.ytZ = R.drawable.wi;
            this.yua = R.drawable.wk;
            return;
        }
        this.ytZ = R.drawable.wk;
        this.yua = R.drawable.wi;
    }

    public void setMaxCount(int i) {
        AppMethodBeat.i(106530);
        ab.d("MicroMsg.MMDotView", "setMaxCount:%d", Integer.valueOf(i));
        this.ehD = i;
        AppMethodBeat.o(106530);
    }

    public void setDotCount(int i) {
        AppMethodBeat.i(106531);
        ab.v("MicroMsg.MMDotView", "setDotCount:%d", Integer.valueOf(i));
        if (i < 0) {
            AppMethodBeat.o(106531);
            return;
        }
        ImageView imageView;
        if (i > this.ehD) {
            ab.i("MicroMsg.MMDotView", "large than max count");
            i = this.ehD;
        }
        removeAllViews();
        for (i = 
/*
Method generation error in method: com.tencent.mm.ui.base.MMDotView.setDotCount(int):void, dex: classes4.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r7_2 'i' int) = (r7_0 'i' int), (r7_1 'i' int) binds: {(r7_0 'i' int)=B:4:0x0021, (r7_1 'i' int)=B:5:0x0023} in method: com.tencent.mm.ui.base.MMDotView.setDotCount(int):void, dex: classes4.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:185)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:321)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:259)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:221)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 18 more

*/

    public void setSelectedDot(int i) {
        int i2 = 0;
        AppMethodBeat.i(106532);
        ab.v("MicroMsg.MMDotView", "setSelectedDot:target index is %d", Integer.valueOf(i));
        if (i >= getChildCount()) {
            i = getChildCount() - 1;
        } else if (i < 0) {
            i = 0;
        }
        ab.v("MicroMsg.MMDotView", "setSelectedDot:after adjust index is %d", Integer.valueOf(i));
        while (true) {
            int i3 = i2;
            if (i3 >= getChildCount()) {
                break;
            }
            ((ImageView) getChildAt(i3)).setImageResource(this.ytZ);
            i2 = i3 + 1;
        }
        ImageView imageView = (ImageView) getChildAt(i);
        if (imageView != null) {
            imageView.setImageResource(this.yua);
        }
        AppMethodBeat.o(106532);
    }
}
