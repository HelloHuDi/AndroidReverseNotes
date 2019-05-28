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

public final class c {
    private static HashMap<String, Constructor<?>> yCT = new HashMap();
    private static final Class<?>[] yCU = new Class[]{Context.class, AttributeSet.class};
    private final Object[] VX = new Object[2];
    final Context mContext;

    static {
        AppMethodBeat.i(113281);
        AppMethodBeat.o(113281);
    }

    public c(Context context) {
        AppMethodBeat.i(113276);
        this.mContext = context;
        AppMethodBeat.o(113276);
    }

    /* Access modifiers changed, original: final */
    public final void a(XmlPullParser xmlPullParser, a aVar) {
        InflateException inflateException;
        AppMethodBeat.i(113277);
        synchronized (this.VX) {
            InflateException inflateException2;
            try {
                AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
                this.VX[0] = this.mContext;
                int next = xmlPullParser.next();
                while (next != 2 && next != 1) {
                    next = xmlPullParser.next();
                }
                if (next != 2) {
                    inflateException2 = new InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
                    AppMethodBeat.o(113277);
                    throw inflateException2;
                }
                b(xmlPullParser.getName(), asAttributeSet);
                a(xmlPullParser, aVar, asAttributeSet);
            } catch (InflateException inflateException22) {
                AppMethodBeat.o(113277);
                throw inflateException22;
            } catch (XmlPullParserException e) {
                inflateException = new InflateException(e.getMessage());
                inflateException.initCause(e);
                AppMethodBeat.o(113277);
                throw inflateException;
            } catch (IOException e2) {
                inflateException = new InflateException(xmlPullParser.getPositionDescription() + ": " + e2.getMessage());
                inflateException.initCause(e2);
                AppMethodBeat.o(113277);
                throw inflateException;
            } catch (Throwable th) {
                AppMethodBeat.o(113277);
                throw th;
            }
        }
        AppMethodBeat.o(113277);
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
            com.tencent.matrix.trace.core.AppMethodBeat.o(113278);
     */
    /* JADX WARNING: Missing block: B:18:0x0084, code skipped:
            throw r1;
     */
    /* JADX WARNING: Missing block: B:19:0x0085, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:20:0x0086, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(113278);
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
    private Preference b(String str, String str2, AttributeSet attributeSet) {
        Constructor constructor;
        AppMethodBeat.i(113278);
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
                AppMethodBeat.o(113278);
                throw inflateException;
            }
        }
        constructor = constructor2;
        Object[] objArr = this.VX;
        objArr[1] = attributeSet;
        Preference preference = (Preference) constructor.newInstance(objArr);
        AppMethodBeat.o(113278);
        return preference;
    }

    private Preference b(String str, AttributeSet attributeSet) {
        InflateException inflateException;
        AppMethodBeat.i(113279);
        try {
            Preference b;
            if (-1 == str.indexOf(46)) {
                b = b(str, "android.preference.", attributeSet);
            } else {
                b = b(str, null, attributeSet);
            }
            AppMethodBeat.o(113279);
            return b;
        } catch (InflateException e) {
            AppMethodBeat.o(113279);
            throw e;
        } catch (ClassNotFoundException e2) {
            inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e2);
            AppMethodBeat.o(113279);
            throw inflateException;
        } catch (Exception e3) {
            inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e3);
            AppMethodBeat.o(113279);
            throw inflateException;
        }
    }

    private void a(XmlPullParser xmlPullParser, a aVar, AttributeSet attributeSet) {
        AppMethodBeat.i(113280);
        int depth = xmlPullParser.getDepth();
        int next = xmlPullParser.next();
        while (true) {
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next != 2) {
                    next = xmlPullParser.next();
                } else {
                    aVar.a(b(xmlPullParser.getName(), attributeSet));
                    next = xmlPullParser.next();
                }
            }
        }
        AppMethodBeat.o(113280);
    }
}
