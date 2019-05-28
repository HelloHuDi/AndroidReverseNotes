package com.tencent.p177mm.plugin.emojicapture.model.p1254c;

import android.util.Xml;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.FileInputStream;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0004J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0004J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0004J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0004R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/xml/BaseXmlContent;", "", "()V", "ns", "", "getNs", "()Ljava/lang/String;", "next", "", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "readInt", "", "readString", "skip", "Companion", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.model.c.a */
public class C45869a {
    private static final String TAG = TAG;
    public static final C20432a ljn = new C20432a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/xml/BaseXmlContent$Companion;", "", "()V", "TAG", "", "safeParse", "", "filePath", "xmlContent", "Lcom/tencent/mm/plugin/emojicapture/model/xml/BaseXmlContent;", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.c.a$a */
    public static final class C20432a {
        private C20432a() {
        }

        public /* synthetic */ C20432a(byte b) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x004f  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x005e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public static void m31586a(String str, C45869a c45869a) {
            Exception e;
            Throwable th;
            InputStream inputStream = null;
            AppMethodBeat.m2504i(2712);
            C25052j.m39376p(str, "filePath");
            C25052j.m39376p(c45869a, "xmlContent");
            try {
                InputStream fileInputStream = new FileInputStream(str);
                try {
                    XmlPullParser newPullParser = Xml.newPullParser();
                    C25052j.m39375o(newPullParser, "Xml.newPullParser()");
                    newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
                    newPullParser.setInput(fileInputStream, null);
                    newPullParser.nextTag();
                    c45869a.mo68505f(newPullParser);
                    fileInputStream.close();
                    AppMethodBeat.m2505o(2712);
                } catch (Exception e2) {
                    e = e2;
                    inputStream = fileInputStream;
                    try {
                        C4990ab.printErrStackTrace(C45869a.TAG, e, "safeParse error", new Object[0]);
                        if (inputStream == null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream != null) {
                        }
                        AppMethodBeat.m2505o(2712);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = fileInputStream;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    AppMethodBeat.m2505o(2712);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                C4990ab.printErrStackTrace(C45869a.TAG, e, "safeParse error", new Object[0]);
                if (inputStream == null) {
                    inputStream.close();
                    AppMethodBeat.m2505o(2712);
                    return;
                }
                AppMethodBeat.m2505o(2712);
            }
        }
    }

    static {
        AppMethodBeat.m2504i(2718);
        AppMethodBeat.m2505o(2718);
    }

    /* renamed from: d */
    protected static String m84979d(XmlPullParser xmlPullParser) {
        AppMethodBeat.m2504i(2713);
        C25052j.m39376p(xmlPullParser, "parser");
        String str = "";
        if (xmlPullParser.next() == 4) {
            str = xmlPullParser.getText();
            C25052j.m39375o(str, "parser.text");
            xmlPullParser.nextTag();
        }
        AppMethodBeat.m2505o(2713);
        return str;
    }

    /* renamed from: e */
    protected static int m84980e(XmlPullParser xmlPullParser) {
        Object obj;
        AppMethodBeat.m2504i(2714);
        C25052j.m39376p(xmlPullParser, "parser");
        String d = C45869a.m84979d(xmlPullParser);
        if (d.length() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            AppMethodBeat.m2505o(2714);
            return 0;
        }
        int parseInt = Integer.parseInt(d);
        AppMethodBeat.m2505o(2714);
        return parseInt;
    }

    /* renamed from: a */
    protected static void m84978a(XmlPullParser xmlPullParser) {
        AppMethodBeat.m2504i(2715);
        C25052j.m39376p(xmlPullParser, "parser");
        if (xmlPullParser.getEventType() != 2) {
            Throwable illegalStateException = new IllegalStateException();
            AppMethodBeat.m2505o(2715);
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
        AppMethodBeat.m2505o(2715);
    }

    /* renamed from: f */
    public void mo68505f(XmlPullParser xmlPullParser) {
        AppMethodBeat.m2504i(2716);
        C25052j.m39376p(xmlPullParser, "parser");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (name != null) {
                    mo35712a(name, xmlPullParser);
                }
            }
        }
        AppMethodBeat.m2505o(2716);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo35712a(String str, XmlPullParser xmlPullParser) {
        AppMethodBeat.m2504i(2717);
        C25052j.m39376p(str, "tag");
        C25052j.m39376p(xmlPullParser, "parser");
        AppMethodBeat.m2505o(2717);
    }
}
