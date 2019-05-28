package com.tencent.p177mm.kiss.widget.textview.p857b;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.Constructor;

/* renamed from: com.tencent.mm.kiss.widget.textview.b.a */
public class C26348a {
    private static boolean eIC;
    private static boolean eOh;
    private static Constructor<StaticLayout> eOi;
    private static Object eOj;

    @TargetApi(18)
    private static synchronized void ensureInitialized() {
        synchronized (C26348a.class) {
            AppMethodBeat.m2504i(105817);
            if (eIC) {
                AppMethodBeat.m2505o(105817);
            } else {
                try {
                    Class cls;
                    if (VERSION.SDK_INT >= 18) {
                        cls = TextDirectionHeuristic.class;
                        eOj = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                    } else {
                        ClassLoader classLoader = C26348a.class.getClassLoader();
                        cls = classLoader.loadClass("android.text.TextDirectionHeuristic");
                        Class loadClass = classLoader.loadClass("android.text.TextDirectionHeuristics");
                        eOj = loadClass.getField("FIRSTSTRONG_LTR").get(loadClass);
                    }
                    Constructor declaredConstructor = StaticLayout.class.getDeclaredConstructor(new Class[]{CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Alignment.class, cls, Float.TYPE, Float.TYPE, Boolean.TYPE, TruncateAt.class, Integer.TYPE, Integer.TYPE});
                    eOi = declaredConstructor;
                    declaredConstructor.setAccessible(true);
                    eIC = true;
                } catch (NoSuchMethodException e) {
                    C4990ab.m7413e("StaticTextView.StaticLayoutWithMaxLines", "StaticLayout constructor with max lines not found.", e);
                    eOh = true;
                    eIC = true;
                } catch (ClassNotFoundException e2) {
                    C4990ab.m7413e("StaticTextView.StaticLayoutWithMaxLines", "TextDirectionHeuristic class not found.", e2);
                    eOh = true;
                    eIC = true;
                } catch (NoSuchFieldException e3) {
                    C4990ab.m7413e("StaticTextView.StaticLayoutWithMaxLines", "TextDirectionHeuristics.FIRSTSTRONG_LTR not found.", e3);
                    eOh = true;
                    eIC = true;
                } catch (IllegalAccessException e4) {
                    C4990ab.m7413e("StaticTextView.StaticLayoutWithMaxLines", "TextDirectionHeuristics.FIRSTSTRONG_LTR not accessible.", e4);
                    eOh = true;
                    eIC = true;
                } catch (Exception e5) {
                    C4990ab.m7413e("StaticTextView.StaticLayoutWithMaxLines", "Other error.", e5);
                    eOh = true;
                    eIC = true;
                } catch (Throwable th) {
                    eIC = true;
                    AppMethodBeat.m2505o(105817);
                }
                C4990ab.m7416i("StaticTextView.StaticLayoutWithMaxLines", "ensureInitialized finish, sInitialError: " + eOh);
                AppMethodBeat.m2505o(105817);
            }
        }
        return;
    }

    /* renamed from: a */
    public static synchronized StaticLayout m41924a(CharSequence charSequence, int i, int i2, TextPaint textPaint, int i3, Alignment alignment, float f, float f2, boolean z, TruncateAt truncateAt, int i4, int i5) {
        StaticLayout staticLayout;
        synchronized (C26348a.class) {
            AppMethodBeat.m2504i(105818);
            C26348a.ensureInitialized();
            if (eOh) {
                IllegalStateException illegalStateException = new IllegalStateException("initialize error, cannot create StaticLayout");
                AppMethodBeat.m2505o(105818);
                throw illegalStateException;
            }
            try {
                staticLayout = (StaticLayout) eOi.newInstance(new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), textPaint, Integer.valueOf(i3), alignment, eOj, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z), truncateAt, Integer.valueOf(i4), Integer.valueOf(i5)});
                AppMethodBeat.m2505o(105818);
            } catch (Exception e) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Error creating StaticLayout with max lines: " + e.getCause());
                AppMethodBeat.m2505o(105818);
                throw illegalStateException2;
            }
        }
        return staticLayout;
    }

    /* renamed from: a */
    public static synchronized StaticLayout m41925a(CharSequence charSequence, int i, int i2, TextPaint textPaint, int i3, Alignment alignment, TextDirectionHeuristic textDirectionHeuristic, float f, float f2, boolean z, TruncateAt truncateAt, int i4, int i5) {
        StaticLayout staticLayout;
        synchronized (C26348a.class) {
            AppMethodBeat.m2504i(105819);
            C26348a.ensureInitialized();
            if (eOh) {
                IllegalStateException illegalStateException = new IllegalStateException("initialize error, cannot create StaticLayout");
                AppMethodBeat.m2505o(105819);
                throw illegalStateException;
            }
            try {
                staticLayout = (StaticLayout) eOi.newInstance(new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), textPaint, Integer.valueOf(i3), alignment, textDirectionHeuristic, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z), truncateAt, Integer.valueOf(i4), Integer.valueOf(i5)});
                AppMethodBeat.m2505o(105819);
            } catch (Exception e) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Error creating StaticLayout with max lines: " + e.getCause());
                AppMethodBeat.m2505o(105819);
                throw illegalStateException2;
            }
        }
        return staticLayout;
    }
}
