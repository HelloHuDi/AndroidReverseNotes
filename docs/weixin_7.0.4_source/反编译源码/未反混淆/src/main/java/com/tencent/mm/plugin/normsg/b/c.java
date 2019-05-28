package com.tencent.mm.plugin.normsg.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.WeakHashMap;

public final class c {
    private static final Map<View, Class<? extends com.tencent.mm.sdk.b.b>> oUX = new WeakHashMap();
    private static final Map<View, Boolean> oUY = new WeakHashMap();

    static final class b implements OnTouchListener {
        private final OnTouchListener oVa;

        b(OnTouchListener onTouchListener) {
            this.oVa = onTouchListener;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int aje;
            boolean th;
            int i = 10433;
            AppMethodBeat.i(10433);
            synchronized (c.oUX) {
                try {
                    if (c.oUX.containsKey(view)) {
                        aje = c.oUY;
                        synchronized (aje) {
                            c.oUY.put(view, Boolean.TRUE);
                        }
                    }
                } catch (Throwable th2) {
                    while (true) {
                        th = th2;
                    }
                    aje = 10433;
                } finally {
                    AppMethodBeat.o(
/*
Method generation error in method: com.tencent.mm.plugin.normsg.b.c.b.onTouch(android.view.View, android.view.MotionEvent):boolean, dex: classes4.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0036: INVOKE  (wrap: int
  ?: MERGE  (r4_1 int) = (r4_0 'i' int), (r2_4 'aje' int)) com.tencent.matrix.trace.core.AppMethodBeat.o(int):void type: STATIC in method: com.tencent.mm.plugin.normsg.b.c.b.onTouch(android.view.View, android.view.MotionEvent):boolean, dex: classes4.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:205)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:102)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:52)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:300)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:230)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:321)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:259)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:221)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.addInnerClasses(ClassGen.java:234)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:220)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r4_1 int) = (r4_0 'i' int), (r2_4 'aje' int) in method: com.tencent.mm.plugin.normsg.b.c.b.onTouch(android.view.View, android.view.MotionEvent):boolean, dex: classes4.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:101)
	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:688)
	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:658)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:340)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 30 more
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:213)
	... 35 more

*/
    }

    static final class a implements OnClickListener {
        private final OnClickListener oUZ;

        a(OnClickListener onClickListener) {
            this.oUZ = onClickListener;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(10432);
            synchronized (c.oUX) {
                try {
                    if (c.oUX.containsKey(view)) {
                        synchronized (c.oUY) {
                            Class cls;
                            try {
                                if (c.oUY.containsKey(view)) {
                                    c.oUY.remove(view);
                                } else {
                                    cls = (Class) c.oUX.get(view);
                                    if (cls != null) {
                                        com.tencent.mm.sdk.b.a.xxA.m((com.tencent.mm.sdk.b.b) cls.newInstance());
                                    }
                                }
                            } catch (Throwable th) {
                                AppMethodBeat.o(10432);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    AppMethodBeat.o(10432);
                }
            }
            if (this.oUZ != null) {
                this.oUZ.onClick(view);
            }
            AppMethodBeat.o(10432);
        }
    }

    static {
        AppMethodBeat.i(10435);
        AppMethodBeat.o(10435);
    }

    public static void a(View view, Class<? extends com.tencent.mm.sdk.b.b> cls) {
        AppMethodBeat.i(10434);
        IllegalArgumentException illegalArgumentException;
        if (view == null) {
            illegalArgumentException = new IllegalArgumentException("target is null.");
            AppMethodBeat.o(10434);
            throw illegalArgumentException;
        } else if (cls == null) {
            illegalArgumentException = new IllegalArgumentException("reportEventClass is null.");
            AppMethodBeat.o(10434);
            throw illegalArgumentException;
        } else {
            OnTouchListener onTouchListener;
            OnClickListener onClickListener;
            Object b = h.b((Object) view, "getListenerInfo", null, new Object[0]);
            if (b != null) {
                onTouchListener = (OnTouchListener) h.f(b, "mOnTouchListener");
                onClickListener = (OnClickListener) h.f(b, "mOnClickListener");
            } else {
                onClickListener = null;
                onTouchListener = null;
            }
            if (onTouchListener == null) {
                view.setOnTouchListener(new b(null));
            } else if (!(onTouchListener instanceof b)) {
                view.setOnTouchListener(new b(onTouchListener));
            }
            if (onClickListener == null) {
                view.setOnClickListener(new a(null));
            } else if (!(onClickListener instanceof a)) {
                view.setOnClickListener(new a(onClickListener));
            }
            synchronized (oUX) {
                try {
                    oUX.put(view, cls);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(10434);
                }
            }
        }
    }
}
