package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class s {
    static Pattern sAddressPattern = Pattern.compile("(?:(http|https|file)\\:\\/\\/)?(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?([a-zA-Z0-9 -퟿豈-﷏ﷰ-￯%_-][a-zA-Z0-9 -퟿豈-﷏ﷰ-￯%_\\.-]*|\\[[0-9a-fA-F:\\.]+\\])?(?:\\:([0-9]*))?(\\/?[^#]*)?.*", 2);
    String mAuthInfo;
    String mHost;
    String mPath;
    int mPort;
    String mScheme;

    static {
        AppMethodBeat.i(80456);
        AppMethodBeat.o(80456);
    }

    public s(String str) {
        Exception exception;
        AppMethodBeat.i(80454);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(80454);
            throw nullPointerException;
        }
        this.mScheme = "";
        this.mHost = "";
        this.mPort = -1;
        this.mPath = "/";
        this.mAuthInfo = "";
        Matcher matcher = sAddressPattern.matcher(str);
        if (matcher.matches()) {
            String group = matcher.group(1);
            if (group != null) {
                this.mScheme = group.toLowerCase();
            }
            group = matcher.group(2);
            if (group != null) {
                this.mAuthInfo = group;
            }
            group = matcher.group(3);
            if (group != null) {
                this.mHost = group;
            }
            group = matcher.group(4);
            if (group != null && group.length() > 0) {
                try {
                    this.mPort = bo.getInt(group, this.mPort);
                } catch (NumberFormatException e) {
                    exception = new Exception("Bad port");
                    AppMethodBeat.o(80454);
                    throw exception;
                }
            }
            String group2 = matcher.group(5);
            if (group2 != null && group2.length() > 0) {
                if (group2.charAt(0) == IOUtils.DIR_SEPARATOR_UNIX) {
                    this.mPath = group2;
                } else {
                    this.mPath = "/".concat(String.valueOf(group2));
                }
            }
            if (this.mPort == JsApiPauseDownloadTask.CTRL_INDEX && this.mScheme.equals("")) {
                this.mScheme = "https";
            } else if (this.mPort == -1) {
                if (this.mScheme.equals("https")) {
                    this.mPort = JsApiPauseDownloadTask.CTRL_INDEX;
                } else {
                    this.mPort = 80;
                }
            }
            if (this.mScheme.equals("")) {
                this.mScheme = "http";
            }
            AppMethodBeat.o(80454);
            return;
        }
        exception = new Exception("Bad address");
        AppMethodBeat.o(80454);
        throw exception;
    }

    public final String toString() {
        AppMethodBeat.i(80455);
        String str = "";
        if ((this.mPort != JsApiPauseDownloadTask.CTRL_INDEX && this.mScheme.equals("https")) || (this.mPort != 80 && this.mScheme.equals("http"))) {
            str = new StringBuilder(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(Integer.toString(this.mPort)).toString();
        }
        String str2 = "";
        if (this.mAuthInfo.length() > 0) {
            str2 = this.mAuthInfo + "@";
        }
        str = this.mScheme + "://" + str2 + this.mHost + str + this.mPath;
        AppMethodBeat.o(80455);
        return str;
    }
}
