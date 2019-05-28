package com.tencent.p177mm.plugin.wenote.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.spans.q */
public enum C44012q {
    NONE("", "", "", "", false),
    NOTEUL("<wx-ul>", "</wx-ul>", "<wx-li>", "</wx-li>", true),
    NOTEOL("<wx-ol>", "</wx-ol>", "<wx-li>", "</wx-li>", true),
    NOTETODO("", "", "<wn-todo checked=\"1\" >", "</wn-todo>", true);
    
    public String uSn;
    public String uSo;
    public boolean uSp;
    public String uSq;
    public String uSr;
    public boolean uSs;
    public boolean uSt;

    static {
        AppMethodBeat.m2505o(26968);
    }

    /* renamed from: a */
    public static C44012q m79005a(ParagraphStyle paragraphStyle) {
        if (paragraphStyle instanceof C17002d) {
            return NOTEUL;
        }
        if (paragraphStyle instanceof C17003m) {
            return NOTEOL;
        }
        return paragraphStyle instanceof C40387k ? NOTETODO : null;
    }

    private C44012q(String str, String str2, String str3, String str4, boolean z) {
        this.uSt = false;
        this.uSn = str;
        this.uSo = str2;
        this.uSq = str3;
        this.uSr = str4;
        this.uSp = false;
        this.uSs = z;
    }

    public final boolean dfG() {
        return this == NOTEUL;
    }

    public final boolean dfH() {
        return this == NOTEOL;
    }

    public final boolean dfI() {
        return this == NOTETODO;
    }
}
