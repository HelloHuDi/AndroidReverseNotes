package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class i {
    private static HashMap<String, Constructor<?>> yCT = new HashMap();
    private static final Class<?>[] yCU = new Class[]{Context.class, AttributeSet.class};
    private final Object[] VX = new Object[2];
    private final Context mContext;

    static {
        AppMethodBeat.i(107248);
        AppMethodBeat.o(107248);
    }

    public i(Context context) {
        AppMethodBeat.i(107242);
        this.mContext = context;
        AppMethodBeat.o(107242);
    }

    public final void a(int i, f fVar) {
        AppMethodBeat.i(107243);
        XmlPullParser xml = this.mContext.getResources().getXml(i);
        try {
            a(xml, fVar);
        } finally {
            xml.close();
            AppMethodBeat.o(107243);
        }
    }

    private void a(XmlPullParser xmlPullParser, f fVar) {
        InflateException inflateException;
        AppMethodBeat.i(107244);
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
                    AppMethodBeat.o(107244);
                    throw inflateException2;
                }
                a(xmlPullParser.getName(), asAttributeSet);
                a(xmlPullParser, fVar, asAttributeSet);
            } catch (InflateException inflateException22) {
                AppMethodBeat.o(107244);
                throw inflateException22;
            } catch (XmlPullParserException e) {
                inflateException = new InflateException(e.getMessage());
                inflateException.initCause(e);
                AppMethodBeat.o(107244);
                throw inflateException;
            } catch (IOException e2) {
                inflateException = new InflateException(xmlPullParser.getPositionDescription() + ": " + e2.getMessage());
                inflateException.initCause(e2);
                AppMethodBeat.o(107244);
                throw inflateException;
            } catch (Throwable th) {
                AppMethodBeat.o(107244);
                throw th;
            }
        }
        AppMethodBeat.o(107244);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0062 A:{Splitter:B:2:0x0010, ExcHandler: NoSuchMethodException (r0_5 'e' java.lang.NoSuchMethodException)} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x009e A:{Splitter:B:2:0x0010, ExcHandler: ClassNotFoundException (r0_6 'e' java.lang.ClassNotFoundException)} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a9  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:13:0x0062, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:14:0x0063, code skipped:
            r2 = new java.lang.StringBuilder().append(r10.getPositionDescription()).append(": Error inflating class ");
     */
    /* JADX WARNING: Missing block: B:15:0x0079, code skipped:
            if (r9 != null) goto L_0x007b;
     */
    /* JADX WARNING: Missing block: B:16:0x007b, code skipped:
            r8 = r9 + r8;
     */
    /* JADX WARNING: Missing block: B:17:0x008c, code skipped:
            r1 = new android.view.InflateException(r2.append(r8).toString());
            r1.initCause(r0);
            com.tencent.matrix.trace.core.AppMethodBeat.o(107245);
     */
    /* JADX WARNING: Missing block: B:18:0x009d, code skipped:
            throw r1;
     */
    /* JADX WARNING: Missing block: B:19:0x009e, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:20:0x009f, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(107245);
     */
    /* JADX WARNING: Missing block: B:21:0x00a2, code skipped:
            throw r0;
     */
    /* JADX WARNING: Missing block: B:22:0x00a3, code skipped:
            r1 = e;
     */
    /* JADX WARNING: Missing block: B:23:0x00a4, code skipped:
            r2 = r0;
     */
    /* JADX WARNING: Missing block: B:26:0x00a9, code skipped:
            r0 = r10.getPositionDescription();
     */
    /* JADX WARNING: Missing block: B:30:0x00c2, code skipped:
            if ("(null): Error inflating class ".concat(java.lang.String.valueOf(r2)) != null) goto L_0x00c4;
     */
    /* JADX WARNING: Missing block: B:31:0x00c4, code skipped:
            r0 = r2.getClass().getName();
     */
    /* JADX WARNING: Missing block: B:32:0x00cd, code skipped:
            r0 = "(null)";
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Preference a(String str, String str2, AttributeSet attributeSet) {
        Constructor constructor;
        AppMethodBeat.i(107245);
        Constructor constructor2 = (Constructor) yCT.get(str);
        if (constructor2 == null) {
            try {
                ab.d("test", "fuck test mContext:%s", this.mContext.getResources().toString());
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
                AppMethodBeat.o(107245);
                throw inflateException;
            }
        }
        constructor = constructor2;
        Object[] objArr = this.VX;
        objArr[1] = attributeSet;
        Preference preference = (Preference) constructor.newInstance(objArr);
        AppMethodBeat.o(107245);
        return preference;
    }

    private Preference a(String str, AttributeSet attributeSet) {
        InflateException inflateException;
        AppMethodBeat.i(107246);
        try {
            Preference a;
            if (-1 == str.indexOf(46)) {
                a = a(str, "com.tencent.mm.ui.base.preference.", attributeSet);
            } else {
                a = a(str, null, attributeSet);
            }
            AppMethodBeat.o(107246);
            return a;
        } catch (InflateException e) {
            AppMethodBeat.o(107246);
            throw e;
        } catch (ClassNotFoundException e2) {
            inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e2);
            AppMethodBeat.o(107246);
            throw inflateException;
        } catch (Exception e3) {
            inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e3);
            AppMethodBeat.o(107246);
            throw inflateException;
        }
    }

    private void a(XmlPullParser xmlPullParser, f fVar, AttributeSet attributeSet) {
        AppMethodBeat.i(107247);
        int depth = xmlPullParser.getDepth();
        int next = xmlPullParser.next();
        while (true) {
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next != 2) {
                    next = xmlPullParser.next();
                } else {
                    fVar.a(a(xmlPullParser.getName(), attributeSet), -1);
                    next = xmlPullParser.next();
                }
            }
        }
        AppMethodBeat.o(107247);
    }
}
