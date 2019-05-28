package com.tencent.ttpic.json;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.Writer;

public class JSONWriter {
    private static final int maxdepth = 200;
    private boolean comma = false;
    protected char mode = 'i';
    private final JSONObject[] stack = new JSONObject[200];
    private int top = 0;
    protected Writer writer;

    public JSONWriter(Writer writer) {
        AppMethodBeat.m2504i(50199);
        this.writer = writer;
        AppMethodBeat.m2505o(50199);
    }

    private JSONWriter append(String str) {
        AppMethodBeat.m2504i(50200);
        JSONException jSONException;
        if (str == null) {
            jSONException = new JSONException("Null pointer");
            AppMethodBeat.m2505o(50200);
            throw jSONException;
        } else if (this.mode == 'o' || this.mode == 'a') {
            try {
                if (this.comma && this.mode == 'a') {
                    this.writer.write(44);
                }
                this.writer.write(str);
                if (this.mode == 'o') {
                    this.mode = 'k';
                }
                this.comma = true;
                AppMethodBeat.m2505o(50200);
                return this;
            } catch (IOException e) {
                JSONException jSONException2 = new JSONException(e);
                AppMethodBeat.m2505o(50200);
                throw jSONException2;
            }
        } else {
            jSONException = new JSONException("Value out of sequence.");
            AppMethodBeat.m2505o(50200);
            throw jSONException;
        }
    }

    public JSONWriter array() {
        AppMethodBeat.m2504i(50201);
        if (this.mode == 'i' || this.mode == 'o' || this.mode == 'a') {
            push(null);
            append("[");
            this.comma = false;
            AppMethodBeat.m2505o(50201);
            return this;
        }
        JSONException jSONException = new JSONException("Misplaced array.");
        AppMethodBeat.m2505o(50201);
        throw jSONException;
    }

    private JSONWriter end(char c, char c2) {
        AppMethodBeat.m2504i(50202);
        JSONException jSONException;
        if (this.mode != c) {
            jSONException = new JSONException(c == 'a' ? "Misplaced endArray." : "Misplaced endObject.");
            AppMethodBeat.m2505o(50202);
            throw jSONException;
        }
        pop(c);
        try {
            this.writer.write(c2);
            this.comma = true;
            AppMethodBeat.m2505o(50202);
            return this;
        } catch (IOException e) {
            jSONException = new JSONException(e);
            AppMethodBeat.m2505o(50202);
            throw jSONException;
        }
    }

    public JSONWriter endArray() {
        AppMethodBeat.m2504i(50203);
        JSONWriter end = end('a', ']');
        AppMethodBeat.m2505o(50203);
        return end;
    }

    public JSONWriter endObject() {
        AppMethodBeat.m2504i(50204);
        JSONWriter end = end('k', '}');
        AppMethodBeat.m2505o(50204);
        return end;
    }

    public JSONWriter key(String str) {
        AppMethodBeat.m2504i(50205);
        JSONException jSONException;
        if (str == null) {
            jSONException = new JSONException("Null key.");
            AppMethodBeat.m2505o(50205);
            throw jSONException;
        } else if (this.mode == 'k') {
            try {
                this.stack[this.top - 1].putOnce(str, Boolean.TRUE);
                if (this.comma) {
                    this.writer.write(44);
                }
                this.writer.write(JSONObject.quote(str));
                this.writer.write(58);
                this.comma = false;
                this.mode = 'o';
                AppMethodBeat.m2505o(50205);
                return this;
            } catch (IOException e) {
                JSONException jSONException2 = new JSONException(e);
                AppMethodBeat.m2505o(50205);
                throw jSONException2;
            }
        } else {
            jSONException = new JSONException("Misplaced key.");
            AppMethodBeat.m2505o(50205);
            throw jSONException;
        }
    }

    public JSONWriter object() {
        AppMethodBeat.m2504i(50206);
        if (this.mode == 'i') {
            this.mode = 'o';
        }
        if (this.mode == 'o' || this.mode == 'a') {
            append("{");
            push(new JSONObject());
            this.comma = false;
            AppMethodBeat.m2505o(50206);
            return this;
        }
        JSONException jSONException = new JSONException("Misplaced object.");
        AppMethodBeat.m2505o(50206);
        throw jSONException;
    }

    private void pop(char c) {
        char c2 = 'a';
        AppMethodBeat.m2504i(50207);
        JSONException jSONException;
        if (this.top <= 0) {
            jSONException = new JSONException("Nesting error.");
            AppMethodBeat.m2505o(50207);
            throw jSONException;
        }
        char c3;
        if (this.stack[this.top - 1] == null) {
            c3 = 'a';
        } else {
            c3 = 'k';
        }
        if (c3 != c) {
            jSONException = new JSONException("Nesting error.");
            AppMethodBeat.m2505o(50207);
            throw jSONException;
        }
        this.top--;
        if (this.top == 0) {
            c2 = 'd';
        } else if (this.stack[this.top - 1] != null) {
            c2 = 'k';
        }
        this.mode = c2;
        AppMethodBeat.m2505o(50207);
    }

    private void push(JSONObject jSONObject) {
        AppMethodBeat.m2504i(50208);
        if (this.top >= 200) {
            JSONException jSONException = new JSONException("Nesting too deep.");
            AppMethodBeat.m2505o(50208);
            throw jSONException;
        }
        this.stack[this.top] = jSONObject;
        this.mode = jSONObject == null ? 'a' : 'k';
        this.top++;
        AppMethodBeat.m2505o(50208);
    }

    public JSONWriter value(boolean z) {
        AppMethodBeat.m2504i(50209);
        JSONWriter append = append(z ? "true" : "false");
        AppMethodBeat.m2505o(50209);
        return append;
    }

    public JSONWriter value(double d) {
        AppMethodBeat.m2504i(50210);
        JSONWriter value = value(Double.valueOf(d));
        AppMethodBeat.m2505o(50210);
        return value;
    }

    public JSONWriter value(long j) {
        AppMethodBeat.m2504i(50211);
        JSONWriter append = append(Long.toString(j));
        AppMethodBeat.m2505o(50211);
        return append;
    }

    public JSONWriter value(Object obj) {
        AppMethodBeat.m2504i(50212);
        JSONWriter append = append(JSONObject.valueToString(obj));
        AppMethodBeat.m2505o(50212);
        return append;
    }
}
