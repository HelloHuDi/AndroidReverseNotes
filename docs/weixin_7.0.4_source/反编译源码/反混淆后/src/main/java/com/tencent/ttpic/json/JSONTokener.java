package com.tencent.ttpic.json;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.view.C31128d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

public class JSONTokener {
    private long character;
    private boolean eof;
    private long index;
    private long line;
    private char previous;
    private Reader reader;
    private boolean usePrevious;

    public JSONTokener(Reader reader) {
        AppMethodBeat.m2504i(50183);
        if (!reader.markSupported()) {
            reader = new BufferedReader(reader);
        }
        this.reader = reader;
        this.eof = false;
        this.usePrevious = false;
        this.previous = 0;
        this.index = 0;
        this.character = 1;
        this.line = 1;
        AppMethodBeat.m2505o(50183);
    }

    public JSONTokener(InputStream inputStream) {
        this(new InputStreamReader(inputStream));
        AppMethodBeat.m2504i(50184);
        AppMethodBeat.m2505o(50184);
    }

    public JSONTokener(String str) {
        this(new StringReader(str));
        AppMethodBeat.m2504i(50185);
        AppMethodBeat.m2505o(50185);
    }

    public void back() {
        AppMethodBeat.m2504i(50186);
        if (this.usePrevious || this.index <= 0) {
            JSONException jSONException = new JSONException("Stepping back two steps is not supported");
            AppMethodBeat.m2505o(50186);
            throw jSONException;
        }
        this.index--;
        this.character--;
        this.usePrevious = true;
        this.eof = false;
        AppMethodBeat.m2505o(50186);
    }

    public static int dehexchar(char c) {
        if (c >= '0' && c <= '9') {
            return c - 48;
        }
        if (c >= 'A' && c <= 'F') {
            return c - 55;
        }
        if (c < 'a' || c > 'f') {
            return -1;
        }
        return c - 87;
    }

    public boolean end() {
        return this.eof && !this.usePrevious;
    }

    public boolean more() {
        AppMethodBeat.m2504i(50187);
        next();
        if (end()) {
            AppMethodBeat.m2505o(50187);
            return false;
        }
        back();
        AppMethodBeat.m2505o(50187);
        return true;
    }

    public char next() {
        long j = 0;
        int i = 0;
        AppMethodBeat.m2504i(50188);
        if (this.usePrevious) {
            this.usePrevious = false;
            i = this.previous;
        } else {
            try {
                int read = this.reader.read();
                if (read <= 0) {
                    this.eof = true;
                } else {
                    i = read;
                }
            } catch (IOException e) {
                JSONException jSONException = new JSONException(e);
                AppMethodBeat.m2505o(50188);
                throw jSONException;
            }
        }
        this.index++;
        if (this.previous == 13) {
            this.line++;
            if (i != 10) {
                j = 1;
            }
            this.character = j;
        } else if (i == 10) {
            this.line = 1 + this.line;
            this.character = 0;
        } else {
            this.character++;
        }
        this.previous = (char) i;
        char c = this.previous;
        AppMethodBeat.m2505o(50188);
        return c;
    }

    public char next(char c) {
        AppMethodBeat.m2504i(50189);
        char next = next();
        if (next != c) {
            JSONException syntaxError = syntaxError("Expected '" + c + "' and instead saw '" + next + "'");
            AppMethodBeat.m2505o(50189);
            throw syntaxError;
        }
        AppMethodBeat.m2505o(50189);
        return next;
    }

    public String next(int i) {
        AppMethodBeat.m2504i(50190);
        String str;
        if (i == 0) {
            str = "";
            AppMethodBeat.m2505o(50190);
            return str;
        }
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = next();
            if (end()) {
                JSONException syntaxError = syntaxError("Substring bounds error");
                AppMethodBeat.m2505o(50190);
                throw syntaxError;
            }
        }
        str = new String(cArr);
        AppMethodBeat.m2505o(50190);
        return str;
    }

    public char nextClean() {
        char next;
        AppMethodBeat.m2504i(50191);
        do {
            next = next();
            if (next == 0) {
                break;
            }
        } while (next <= ' ');
        AppMethodBeat.m2505o(50191);
        return next;
    }

    public String nextString(char c) {
        AppMethodBeat.m2504i(50192);
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            char next = next();
            JSONException syntaxError;
            switch (next) {
                case 0:
                case 10:
                case 13:
                    syntaxError = syntaxError("Unterminated string");
                    AppMethodBeat.m2505o(50192);
                    throw syntaxError;
                case '\\':
                    next = next();
                    switch (next) {
                        case '\"':
                        case '\'':
                        case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                        case '\\':
                            stringBuffer.append(next);
                            break;
                        case 'b':
                            stringBuffer.append(8);
                            break;
                        case 'f':
                            stringBuffer.append(12);
                            break;
                        case 'n':
                            stringBuffer.append(10);
                            break;
                        case 'r':
                            stringBuffer.append(13);
                            break;
                        case 't':
                            stringBuffer.append(9);
                            break;
                        case C31128d.MIC_ALPHA_ADJUST_REAL /*117*/:
                            stringBuffer.append((char) Integer.parseInt(next(4), 16));
                            break;
                        default:
                            syntaxError = syntaxError("Illegal escape.");
                            AppMethodBeat.m2505o(50192);
                            throw syntaxError;
                    }
                default:
                    if (next != c) {
                        stringBuffer.append(next);
                        break;
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    AppMethodBeat.m2505o(50192);
                    return stringBuffer2;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x001d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public String nextTo(char c) {
        char next;
        AppMethodBeat.m2504i(50193);
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            next = next();
            if (next != c && next != 0 && next != 10 && next != 13) {
                stringBuffer.append(next);
            } else if (next != 0) {
                back();
            }
        }
        if (next != 0) {
        }
        String trim = stringBuffer.toString().trim();
        AppMethodBeat.m2505o(50193);
        return trim;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public String nextTo(String str) {
        char next;
        AppMethodBeat.m2504i(50194);
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            next = next();
            if (str.indexOf(next) < 0 && next != 0 && next != 10 && next != 13) {
                stringBuffer.append(next);
            } else if (next != 0) {
                back();
            }
        }
        if (next != 0) {
        }
        String trim = stringBuffer.toString().trim();
        AppMethodBeat.m2505o(50194);
        return trim;
    }

    public Object nextValue() {
        AppMethodBeat.m2504i(50195);
        int nextClean = nextClean();
        String nextString;
        Object jSONArray;
        switch (nextClean) {
            case 34:
            case 39:
                nextString = nextString(nextClean);
                AppMethodBeat.m2505o(50195);
                return nextString;
            case PlayerException.EXCEPTION_IN_PREPARE /*91*/:
                back();
                jSONArray = new JSONArray(this);
                AppMethodBeat.m2505o(50195);
                return jSONArray;
            case 123:
                back();
                jSONArray = new JSONObject(this);
                AppMethodBeat.m2505o(50195);
                return jSONArray;
            default:
                StringBuffer stringBuffer = new StringBuffer();
                while (nextClean >= 32 && ",:]}/\\\"[{;=#".indexOf(nextClean) < 0) {
                    stringBuffer.append(nextClean);
                    nextClean = next();
                }
                back();
                nextString = stringBuffer.toString().trim();
                if ("".equals(nextString)) {
                    JSONException syntaxError = syntaxError("Missing value");
                    AppMethodBeat.m2505o(50195);
                    throw syntaxError;
                }
                jSONArray = JSONObject.stringToValue(nextString);
                AppMethodBeat.m2505o(50195);
                return jSONArray;
        }
    }

    public char skipTo(char c) {
        AppMethodBeat.m2504i(50196);
        try {
            char next;
            long j = this.index;
            long j2 = this.character;
            long j3 = this.line;
            this.reader.mark(1000000);
            do {
                next = next();
                if (next == 0) {
                    this.reader.reset();
                    this.index = j;
                    this.character = j2;
                    this.line = j3;
                    AppMethodBeat.m2505o(50196);
                    break;
                }
            } while (next != c);
            back();
            AppMethodBeat.m2505o(50196);
            return next;
        } catch (IOException e) {
            JSONException jSONException = new JSONException(e);
            AppMethodBeat.m2505o(50196);
            throw jSONException;
        }
    }

    public JSONException syntaxError(String str) {
        AppMethodBeat.m2504i(50197);
        JSONException jSONException = new JSONException(str + toString());
        AppMethodBeat.m2505o(50197);
        return jSONException;
    }

    public String toString() {
        AppMethodBeat.m2504i(50198);
        String str = " at " + this.index + " [character " + this.character + " line " + this.line + "]";
        AppMethodBeat.m2505o(50198);
        return str;
    }
}
