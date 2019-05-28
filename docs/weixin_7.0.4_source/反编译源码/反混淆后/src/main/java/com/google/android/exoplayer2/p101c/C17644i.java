package com.google.android.exoplayer2.p101c;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.C41620a.C8699a;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.android.exoplayer2.c.i */
public final class C17644i {
    public static final C8699a aSR = new C176451();
    private static final Pattern aSS = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int aOp = -1;
    public int aOq = -1;

    /* renamed from: com.google.android.exoplayer2.c.i$1 */
    static class C176451 implements C8699a {
        C176451() {
        }

        /* renamed from: f */
        public final boolean mo19251f(int i, int i2, int i3, int i4, int i5) {
            return i2 == 67 && i3 == 79 && i4 == 77 && (i5 == 77 || i == 2);
        }
    }

    static {
        AppMethodBeat.m2504i(94883);
        AppMethodBeat.m2505o(94883);
    }

    /* renamed from: l */
    private boolean m27489l(String str, String str2) {
        AppMethodBeat.m2504i(94882);
        if ("iTunSMPB".equals(str)) {
            Matcher matcher = aSS.matcher(str2);
            if (matcher.find()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1), 16);
                    int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                    if (parseInt > 0 || parseInt2 > 0) {
                        this.aOp = parseInt;
                        this.aOq = parseInt2;
                        AppMethodBeat.m2505o(94882);
                        return true;
                    }
                } catch (NumberFormatException e) {
                }
            }
            AppMethodBeat.m2505o(94882);
            return false;
        }
        AppMethodBeat.m2505o(94882);
        return false;
    }

    /* renamed from: rc */
    public final boolean mo32329rc() {
        return (this.aOp == -1 || this.aOq == -1) ? false : true;
    }

    /* renamed from: c */
    public final boolean mo32328c(Metadata metadata) {
        AppMethodBeat.m2504i(94881);
        for (Entry entry : metadata.beW) {
            if (entry instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entry;
                if (m27489l(commentFrame.description, commentFrame.text)) {
                    AppMethodBeat.m2505o(94881);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(94881);
        return false;
    }
}
