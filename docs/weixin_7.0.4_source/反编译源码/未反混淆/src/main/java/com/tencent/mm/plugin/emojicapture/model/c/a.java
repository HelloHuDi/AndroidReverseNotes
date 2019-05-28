package com.tencent.mm.plugin.emojicapture.model.c;

import a.f.b.j;
import a.l;
import android.util.Xml;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.FileInputStream;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0004J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0004J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0004J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0004R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/xml/BaseXmlContent;", "", "()V", "ns", "", "getNs", "()Ljava/lang/String;", "next", "", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "readInt", "", "readString", "skip", "Companion", "plugin-emojicapture_release"})
public class a {
    private static final String TAG = TAG;
    public static final a ljn = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/xml/BaseXmlContent$Companion;", "", "()V", "TAG", "", "safeParse", "", "filePath", "xmlContent", "Lcom/tencent/mm/plugin/emojicapture/model/xml/BaseXmlContent;", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x004f  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x005e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void a(String str, a aVar) {
            Exception e;
            Throwable th;
            InputStream inputStream = null;
            AppMethodBeat.i(2712);
            j.p(str, "filePath");
            j.p(aVar, "xmlContent");
            try {
                InputStream fileInputStream = new FileInputStream(str);
                try {
                    XmlPullParser newPullParser = Xml.newPullParser();
                    j.o(newPullParser, "Xml.newPullParser()");
                    newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
                    newPullParser.setInput(fileInputStream, null);
                    newPullParser.nextTag();
                    aVar.f(newPullParser);
                    fileInputStream.close();
                    AppMethodBeat.o(2712);
                } catch (Exception e2) {
                    e = e2;
                    inputStream = fileInputStream;
                    try {
                        ab.printErrStackTrace(a.TAG, e, "safeParse error", new Object[0]);
                        if (inputStream == null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream != null) {
                        }
                        AppMethodBeat.o(2712);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = fileInputStream;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    AppMethodBeat.o(2712);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                ab.printErrStackTrace(a.TAG, e, "safeParse error", new Object[0]);
                if (inputStream == null) {
                    inputStream.close();
                    AppMethodBeat.o(2712);
                    return;
                }
                AppMethodBeat.o(2712);
            }
        }
    }

    static {
        AppMethodBeat.i(2718);
        AppMethodBeat.o(2718);
    }

    protected static String d(XmlPullParser xmlPullParser) {
        AppMethodBeat.i(2713);
        j.p(xmlPullParser, "parser");
        String str = "";
        if (xmlPullParser.next() == 4) {
            str = xmlPullParser.getText();
            j.o(str, "parser.text");
            xmlPullParser.nextTag();
        }
        AppMethodBeat.o(2713);
        return str;
    }

    protected static int e(XmlPullParser xmlPullParser) {
        Object obj;
        AppMethodBeat.i(2714);
        j.p(xmlPullParser, "parser");
        String d = d(xmlPullParser);
        if (d.length() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            AppMethodBeat.o(2714);
            return 0;
        }
        int parseInt = Integer.parseInt(d);
        AppMethodBeat.o(2714);
        return parseInt;
    }

    protected static void a(XmlPullParser xmlPullParser) {
        AppMethodBeat.i(2715);
        j.p(xmlPullParser, "parser");
        if (xmlPullParser.getEventType() != 2) {
            Throwable illegalStateException = new IllegalStateException();
            AppMethodBeat.o(2715);
            throw illegalStateException;
        }
        int i = 1;
        while (i != 0) {
            switch (xmlPullParser.next()) {
                case 2:
                    i++;
                    break;
                case 3:
                    i--;
                    break;
                default:
                    break;
            }
        }
        AppMethodBeat.o(2715);
    }

    public void f(XmlPullParser xmlPullParser) {
        AppMethodBeat.i(2716);
        j.p(xmlPullParser, "parser");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null) {
                    a(name, xmlPullParser);
                }
            }
        }
        AppMethodBeat.o(2716);
    }

    /* Access modifiers changed, original: protected */
    public void a(String str, XmlPullParser xmlPullParser) {
        AppMethodBeat.i(2717);
        j.p(str, "tag");
        j.p(xmlPullParser, "parser");
        AppMethodBeat.o(2717);
    }
}
