package com.google.android.exoplayer2.source.b.a;

import com.google.android.exoplayer2.Format;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class a extends c {
    public final List<Format> bit;
    public final List<a> bjF;
    public final List<a> bjG;
    public final List<a> bjH;
    public final Format bjp;

    public static final class a {
        public final Format aOv;
        public final String url;

        public a(String str, Format format) {
            this.url = str;
            this.aOv = format;
        }
    }

    public a(String str, List<String> list, List<a> list2, List<a> list3, List<a> list4, Format format, List<Format> list5) {
        super(str, list);
        AppMethodBeat.i(125962);
        this.bjF = Collections.unmodifiableList(list2);
        this.bjG = Collections.unmodifiableList(list3);
        this.bjH = Collections.unmodifiableList(list4);
        this.bjp = format;
        this.bit = list5 != null ? Collections.unmodifiableList(list5) : null;
        AppMethodBeat.o(125962);
    }
}
