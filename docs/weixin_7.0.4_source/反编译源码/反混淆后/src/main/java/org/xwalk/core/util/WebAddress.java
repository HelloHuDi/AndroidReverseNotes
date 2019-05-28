package org.xwalk.core.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebAddress {
    static final int MATCH_GROUP_AUTHORITY = 2;
    static final int MATCH_GROUP_HOST = 3;
    static final int MATCH_GROUP_PATH = 5;
    static final int MATCH_GROUP_PORT = 4;
    static final int MATCH_GROUP_SCHEME = 1;
    static Pattern sAddressPattern = Pattern.compile("(?:(http|https|file)\\:\\/\\/)?(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?([a-zA-Z0-9 -퟿豈-﷏ﷰ-￯%_-][a-zA-Z0-9 -퟿豈-﷏ﷰ-￯%_\\.-]*|\\[[0-9a-fA-F:\\.]+\\])?(?:\\:([0-9]*))?(\\/?[^#]*)?.*", 2);
    private String mAuthInfo;
    private String mHost;
    private String mPath;
    private int mPort;
    private String mScheme;

    public static class ParseException extends RuntimeException {
        public String response;

        ParseException(String str) {
            this.response = str;
        }
    }

    static {
        AppMethodBeat.m2504i(86234);
        AppMethodBeat.m2505o(86234);
    }

    public WebAddress(String str) {
        ParseException parseException;
        AppMethodBeat.m2504i(86232);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.m2505o(86232);
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
                this.mScheme = group.toLowerCase(Locale.ROOT);
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
                    this.mPort = Integer.parseInt(group);
                } catch (NumberFormatException e) {
                    parseException = new ParseException("Bad port");
                    AppMethodBeat.m2505o(86232);
                    throw parseException;
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
            AppMethodBeat.m2505o(86232);
            return;
        }
        parseException = new ParseException("Bad address");
        AppMethodBeat.m2505o(86232);
        throw parseException;
    }

    public String toString() {
        AppMethodBeat.m2504i(86233);
        String str = "";
        if ((this.mPort != JsApiPauseDownloadTask.CTRL_INDEX && this.mScheme.equals("https")) || (this.mPort != 80 && this.mScheme.equals("http"))) {
            str = new StringBuilder(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(Integer.toString(this.mPort)).toString();
        }
        String str2 = "";
        if (this.mAuthInfo.length() > 0) {
            str2 = this.mAuthInfo + "@";
        }
        str = this.mScheme + "://" + str2 + this.mHost + str + this.mPath;
        AppMethodBeat.m2505o(86233);
        return str;
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    public String getScheme() {
        return this.mScheme;
    }

    public void setHost(String str) {
        this.mHost = str;
    }

    public String getHost() {
        return this.mHost;
    }

    public void setPort(int i) {
        this.mPort = i;
    }

    public int getPort() {
        return this.mPort;
    }

    public void setPath(String str) {
        this.mPath = str;
    }

    public String getPath() {
        return this.mPath;
    }

    public void setAuthInfo(String str) {
        this.mAuthInfo = str;
    }

    public String getAuthInfo() {
        return this.mAuthInfo;
    }
}
