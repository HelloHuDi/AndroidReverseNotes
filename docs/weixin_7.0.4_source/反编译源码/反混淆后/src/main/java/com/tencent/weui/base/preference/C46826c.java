package com.tencent.weui.base.preference;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.tencent.weui.base.preference.c */
public final class C46826c {
    private static HashMap<String, Constructor<?>> yCT = new HashMap();
    private static final Class<?>[] yCU = new Class[]{Context.class, AttributeSet.class};
    /* renamed from: VX */
    private final Object[] f18275VX = new Object[2];
    final Context mContext;

    static {
        AppMethodBeat.m2504i(113281);
        AppMethodBeat.m2505o(113281);
    }

    public C46826c(Context context) {
        AppMethodBeat.m2504i(113276);
        this.mContext = context;
        AppMethodBeat.m2505o(113276);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo75869a(XmlPullParser xmlPullParser, C36582a c36582a) {
        InflateException inflateException;
        AppMethodBeat.m2504i(113277);
        synchronized (this.f18275VX) {
            InflateException inflateException2;
            try {
                AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
                this.f18275VX[0] = this.mContext;
                int next = xmlPullParser.next();
                while (next != 2 && next != 1) {
                    next = xmlPullParser.next();
                }
                if (next != 2) {
                    inflateException2 = new InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
                    AppMethodBeat.m2505o(113277);
                    throw inflateException2;
                }
                m89059b(xmlPullParser.getName(), asAttributeSet);
                m89058a(xmlPullParser, c36582a, asAttributeSet);
            } catch (InflateException inflateException22) {
                AppMethodBeat.m2505o(113277);
                throw inflateException22;
            } catch (XmlPullParserException e) {
                inflateException = new InflateException(e.getMessage());
                inflateException.initCause(e);
                AppMethodBeat.m2505o(113277);
                throw inflateException;
            } catch (IOException e2) {
                inflateException = new InflateException(xmlPullParser.getPositionDescription() + ": " + e2.getMessage());
                inflateException.initCause(e2);
                AppMethodBeat.m2505o(113277);
                throw inflateException;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(113277);
                throw th;
            }
        }
        AppMethodBeat.m2505o(113277);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0049 A:{Splitter:B:2:0x0010, ExcHandler: NoSuchMethodException (r0_5 'e' java.lang.NoSuchMethodException)} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0085 A:{Splitter:B:2:0x0010, ExcHandler: ClassNotFoundException (r0_6 'e' java.lang.ClassNotFoundException)} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:13:0x0049, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:14:0x004a, code skipped:
            r2 = new java.lang.StringBuilder().append(r9.getPositionDescription()).append(": Error inflating class ");
     */
    /* JADX WARNING: Missing block: B:15:0x0060, code skipped:
            if (r8 != null) goto L_0x0062;
     */
    /* JADX WARNING: Missing block: B:16:0x0062, code skipped:
            r7 = r8 + r7;
     */
    /* JADX WARNING: Missing block: B:17:0x0073, code skipped:
            r1 = new android.view.InflateException(r2.append(r7).toString());
            r1.initCause(r0);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(113278);
     */
    /* JADX WARNING: Missing block: B:18:0x0084, code skipped:
            throw r1;
     */
    /* JADX WARNING: Missing block: B:19:0x0085, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:20:0x0086, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(113278);
     */
    /* JADX WARNING: Missing block: B:21:0x0089, code skipped:
            throw r0;
     */
    /* JADX WARNING: Missing block: B:22:0x008a, code skipped:
            r1 = e;
     */
    /* JADX WARNING: Missing block: B:23:0x008b, code skipped:
            r2 = r0;
     */
    /* JADX WARNING: Missing block: B:26:0x0090, code skipped:
            r0 = r9.getPositionDescription();
     */
    /* JADX WARNING: Missing block: B:30:0x00a9, code skipped:
            if ("(null): Error inflating class ".concat(java.lang.String.valueOf(r2)) != null) goto L_0x00ab;
     */
    /* JADX WARNING: Missing block: B:31:0x00ab, code skipped:
            r0 = r2.getClass().getName();
     */
    /* JADX WARNING: Missing block: B:32:0x00b4, code skipped:
            r0 = "(null)";
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private Preference m89060b(String str, String str2, AttributeSet attributeSet) {
        Constructor constructor;
        AppMethodBeat.m2504i(113278);
        Constructor constructor2 = (Constructor) yCT.get(str);
        if (constructor2 == null) {
            try {
                Object constructor3 = this.mContext.getClassLoader().loadClass(str2 != null ? str2 + str : str).getConstructor(yCU);
                yCT.put(str, constructor3);
            } catch (NoSuchMethodException e) {
            } catch (ClassNotFoundException e2) {
            } catch (Exception e3) {
                Throwable e4 = e3;
                if (attributeSet == null) {
                }
                InflateException inflateException = new InflateException(r0);
                inflateException.initCause(e4);
                AppMethodBeat.m2505o(113278);
                throw inflateException;
            }
        }
        constructor = constructor2;
        Object[] objArr = this.f18275VX;
        objArr[1] = attributeSet;
        Preference preference = (Preference) constructor.newInstance(objArr);
        AppMethodBeat.m2505o(113278);
        return preference;
    }

    /* renamed from: b */
    private Preference m89059b(String str, AttributeSet attributeSet) {
        InflateException inflateException;
        AppMethodBeat.m2504i(113279);
        try {
            Preference b;
            if (-1 == str.indexOf(46)) {
                b = m89060b(str, "android.preference.", attributeSet);
            } else {
                b = m89060b(str, null, attributeSet);
            }
            AppMethodBeat.m2505o(113279);
            return b;
        } catch (InflateException e) {
            AppMethodBeat.m2505o(113279);
            throw e;
        } catch (ClassNotFoundException e2) {
            inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e2);
            AppMethodBeat.m2505o(113279);
            throw inflateException;
        } catch (Exception e3) {
            inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e3);
            AppMethodBeat.m2505o(113279);
            throw inflateException;
        }
    }

    /* renamed from: a */
    private void m89058a(XmlPullParser xmlPullParser, C36582a c36582a, AttributeSet attributeSet) {
        AppMethodBeat.m2504i(113280);
        int depth = xmlPullParser.getDepth();
        int next = xmlPullParser.next();
        while (true) {
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next != 2) {
                    next = xmlPullParser.next();
                } else {
                    c36582a.mo58388a(m89059b(xmlPullParser.getName(), attributeSet));
                    next = xmlPullParser.next();
                }
            }
        }
        AppMethodBeat.m2505o(113280);
    }
}
