package com.tencent.luggage.bridge;

import android.text.TextUtils;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class q implements p {
    private static final Pattern bON = Pattern.compile("^<<//([a-z]{0,10})//>>");
    private o bOA;

    static {
        AppMethodBeat.i(90745);
        AppMethodBeat.o(90745);
    }

    q(o oVar) {
        this.bOA = oVar;
    }

    public final void wO() {
        AppMethodBeat.i(90742);
        f fVar = this.bOA.bOH;
        d.i("Java2JsMessageQueue", "reset");
        fVar.bOq = false;
        fVar.bOp.clear();
        AppMethodBeat.o(90742);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0084 A:{SYNTHETIC, Splitter:B:26:0x0084} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0048 A:{SYNTHETIC, Splitter:B:13:0x0048} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReady() {
        Exception e;
        Throwable th;
        AppMethodBeat.i(90743);
        o oVar = this.bOA;
        char[] cArr = new char[4096];
        StringWriter stringWriter = new StringWriter();
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(oVar.bOF.getContext().getAssets().open("LuggageBridge.js"));
            while (true) {
                try {
                    int read = inputStreamReader.read(cArr);
                    if (-1 != read) {
                        stringWriter.write(cArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (Exception e2) {
                            d.e("LuggageBridge", "injectJavascript: close error, %s", e2);
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        d.e("LuggageBridge", "injectJavascript: read error, %s", e);
                        if (inputStreamReader != null) {
                        }
                        AppMethodBeat.o(90743);
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStreamReader != null) {
                        }
                        AppMethodBeat.o(90743);
                        throw th;
                    }
                }
            }
            inputStreamReader.close();
            oVar.bOF.by(stringWriter.toString());
            AppMethodBeat.o(90743);
        } catch (Exception e4) {
            e = e4;
            inputStreamReader = null;
            d.e("LuggageBridge", "injectJavascript: read error, %s", e);
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (Exception e5) {
                    d.e("LuggageBridge", "injectJavascript: close error, %s", e5);
                    AppMethodBeat.o(90743);
                    return;
                }
            }
            AppMethodBeat.o(90743);
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (Exception e22) {
                    d.e("LuggageBridge", "injectJavascript: close error, %s", e22);
                }
            }
            AppMethodBeat.o(90743);
            throw th;
        }
    }

    public final String bx(String str) {
        AppMethodBeat.i(90744);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(90744);
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
            AppMethodBeat.o(90744);
            return null;
        }
        String h = this.bOA.bOG.h(str.replaceFirst("^<<//([a-z]{0,10})//>>", ""), group.equals("sync"));
        AppMethodBeat.o(90744);
        return h;
    }
}
