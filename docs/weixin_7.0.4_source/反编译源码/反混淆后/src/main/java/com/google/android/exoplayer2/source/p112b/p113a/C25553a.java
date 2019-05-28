package com.google.android.exoplayer2.source.p112b.p113a;

import com.google.android.exoplayer2.Format;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.source.b.a.a */
public final class C25553a extends C45047c {
    public final List<Format> bit;
    public final List<C25552a> bjF;
    public final List<C25552a> bjG;
    public final List<C25552a> bjH;
    public final Format bjp;

    /* renamed from: com.google.android.exoplayer2.source.b.a.a$a */
    public static final class C25552a {
        public final Format aOv;
        public final String url;

        public C25552a(String str, Format format) {
            this.url = str;
            this.aOv = format;
        }
    }

    public C25553a(String str, List<String> list, List<C25552a> list2, List<C25552a> list3, List<C25552a> list4, Format format, List<Format> list5) {
        super(str, list);
        AppMethodBeat.m2504i(125962);
        this.bjF = Collections.unmodifiableList(list2);
        this.bjG = Collections.unmodifiableList(list3);
        this.bjH = Collections.unmodifiableList(list4);
        this.bjp = format;
        this.bit = list5 != null ? Collections.unmodifiableList(list5) : null;
        AppMethodBeat.m2505o(125962);
    }
}
