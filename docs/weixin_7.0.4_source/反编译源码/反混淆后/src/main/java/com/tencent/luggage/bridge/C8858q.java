package com.tencent.luggage.bridge;

import android.text.TextUtils;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.luggage.bridge.q */
final class C8858q implements C32181p {
    private static final Pattern bON = Pattern.compile("^<<//([a-z]{0,10})//>>");
    private C37392o bOA;

    static {
        AppMethodBeat.m2504i(90745);
        AppMethodBeat.m2505o(90745);
    }

    C8858q(C37392o c37392o) {
        this.bOA = c37392o;
    }

    /* renamed from: wO */
    public final void mo20032wO() {
        AppMethodBeat.m2504i(90742);
        C32178f c32178f = this.bOA.bOH;
        C45124d.m82929i("Java2JsMessageQueue", "reset");
        c32178f.bOq = false;
        c32178f.bOp.clear();
        AppMethodBeat.m2505o(90742);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0084 A:{SYNTHETIC, Splitter:B:26:0x0084} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0048 A:{SYNTHETIC, Splitter:B:13:0x0048} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReady() {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(90743);
        C37392o c37392o = this.bOA;
        char[] cArr = new char[4096];
        StringWriter stringWriter = new StringWriter();
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(c37392o.bOF.getContext().getAssets().open("LuggageBridge.js"));
            while (true) {
                try {
                    int read = inputStreamReader.read(cArr);
                    if (-1 != read) {
                        stringWriter.write(cArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (Exception e2) {
                            C45124d.m82928e("LuggageBridge", "injectJavascript: close error, %s", e2);
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        C45124d.m82928e("LuggageBridge", "injectJavascript: read error, %s", e);
                        if (inputStreamReader != null) {
                        }
                        AppMethodBeat.m2505o(90743);
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStreamReader != null) {
                        }
                        AppMethodBeat.m2505o(90743);
                        throw th;
                    }
                }
            }
            inputStreamReader.close();
            c37392o.bOF.mo43469by(stringWriter.toString());
            AppMethodBeat.m2505o(90743);
        } catch (Exception e4) {
            e = e4;
            inputStreamReader = null;
            C45124d.m82928e("LuggageBridge", "injectJavascript: read error, %s", e);
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (Exception e5) {
                    C45124d.m82928e("LuggageBridge", "injectJavascript: close error, %s", e5);
                    AppMethodBeat.m2505o(90743);
                    return;
                }
            }
            AppMethodBeat.m2505o(90743);
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (Exception e22) {
                    C45124d.m82928e("LuggageBridge", "injectJavascript: close error, %s", e22);
                }
            }
            AppMethodBeat.m2505o(90743);
            throw th;
        }
    }

    /* renamed from: bx */
    public final String mo20030bx(String str) {
        AppMethodBeat.m2504i(90744);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(90744);
            return null;
        }
        String group;
        Matcher matcher = bON.matcher(str);
        if (matcher.find()) {
            group = matcher.group(1);
        } else {
            group = null;
        }
        if (group == null) {
            AppMethodBeat.m2505o(90744);
            return null;
        }
        String h = this.bOA.bOG.mo72930h(str.replaceFirst("^<<//([a-z]{0,10})//>>", ""), group.equals("sync"));
        AppMethodBeat.m2505o(90744);
        return h;
    }
}
