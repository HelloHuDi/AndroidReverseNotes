package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i {
    public static final a aSR = new a() {
        public final boolean f(int i, int i2, int i3, int i4, int i5) {
            return i2 == 67 && i3 == 79 && i4 == 77 && (i5 == 77 || i == 2);
        }
    };
    private static final Pattern aSS = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int aOp = -1;
    public int aOq = -1;

    static {
        AppMethodBeat.i(94883);
        AppMethodBeat.o(94883);
    }

    private boolean l(String str, String str2) {
        AppMethodBeat.i(94882);
        if ("iTunSMPB".equals(str)) {
            Matcher matcher = aSS.matcher(str2);
            if (matcher.find()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1), 16);
                    int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                    if (parseInt > 0 || parseInt2 > 0) {
                        this.aOp = parseInt;
                        this.aOq = parseInt2;
                        AppMethodBeat.o(94882);
                        return true;
                    }
                } catch (NumberFormatException e) {
                }
            }
            AppMethodBeat.o(94882);
            return false;
        }
        AppMethodBeat.o(94882);
        return false;
    }

    public final boolean rc() {
        return (this.aOp == -1 || this.aOq == -1) ? false : true;
    }

    public final boolean c(Metadata metadata) {
        AppMethodBeat.i(94881);
        for (Entry entry : metadata.beW) {
            if (entry instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entry;
                if (l(commentFrame.description, commentFrame.text)) {
                    AppMethodBeat.o(94881);
                    return true;
                }
            }
        }
        AppMethodBeat.o(94881);
        return false;
    }
}
