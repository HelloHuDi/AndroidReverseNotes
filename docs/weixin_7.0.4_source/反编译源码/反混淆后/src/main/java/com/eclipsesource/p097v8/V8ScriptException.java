package com.eclipsesource.p097v8;

import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.eclipsesource.v8.V8ScriptException */
public abstract class V8ScriptException extends V8RuntimeException {
    private final int contextTag;
    private final int endColumn;
    private final String fileName;
    private final String jsMessage;
    private final String jsStackTrace;
    private final int lineNumber;
    private final String sourceLine;
    private final int startColumn;

    V8ScriptException(int i, String str, int i2, String str2, String str3, int i3, int i4, String str4, Throwable th) {
        this.contextTag = i;
        this.fileName = str;
        this.lineNumber = i2;
        this.jsMessage = str2;
        this.sourceLine = str3;
        this.startColumn = i3;
        this.endColumn = i4;
        this.jsStackTrace = str4;
        if (th != null) {
            initCause(th);
        }
    }

    public String getJSStackTrace() {
        return this.jsStackTrace;
    }

    public int getContextTag() {
        return this.contextTag;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public int getStartColumn() {
        return this.startColumn;
    }

    public int getEndColumn() {
        return this.endColumn;
    }

    public String getSourceLine() {
        return this.sourceLine;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(createMessageLine());
        stringBuilder.append(createMessageDetails());
        stringBuilder.append(createJSStackDetails());
        stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append(getClass().getName());
        return stringBuilder.toString();
    }

    public String getMessage() {
        return createMessageLine();
    }

    public String getJSMessage() {
        return this.jsMessage;
    }

    private String createMessageLine() {
        return this.fileName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.lineNumber + ": " + this.jsMessage;
    }

    private String createJSStackDetails() {
        if (this.jsStackTrace != null) {
            return new StringBuilder(IOUtils.LINE_SEPARATOR_UNIX).append(this.jsStackTrace).toString();
        }
        return "";
    }

    private String createMessageDetails() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!(this.sourceLine == null || this.sourceLine.isEmpty())) {
            stringBuilder.append(10);
            stringBuilder.append(this.sourceLine);
            stringBuilder.append(10);
            if (this.startColumn >= 0) {
                stringBuilder.append(createCharSequence(this.startColumn, ' '));
                stringBuilder.append(createCharSequence(this.endColumn - this.startColumn, '^'));
            }
        }
        return stringBuilder.toString();
    }

    private char[] createCharSequence(int i, char c) {
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = c;
        }
        return cArr;
    }
}
