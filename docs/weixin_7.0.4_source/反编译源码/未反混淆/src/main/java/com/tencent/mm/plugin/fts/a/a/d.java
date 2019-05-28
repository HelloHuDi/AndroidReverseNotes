package com.tencent.mm.plugin.fts.a.a;

import android.graphics.Color;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.g.c;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class d {
    public TextPaint eNN;
    public boolean mDA;
    public boolean mDC;
    public a mDD = a.Foreground;
    public int mDE = Color.parseColor("#07C160");
    public float mDF;
    public CharSequence mDG = "";
    public CharSequence mDH = "";
    public String mDI = "";
    public String mDJ = "";
    public CharSequence mDy;
    public g mDz;

    public static class b implements Comparable<b> {
        public c mDO;
        public int mDP = -1;
        public int mDQ = -1;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.mDP - ((b) obj).mDP;
        }

        public final boolean isAvailable() {
            return (this.mDP == -1 || this.mDQ == -1) ? false : true;
        }

        public final String bAk() {
            AppMethodBeat.i(114241);
            if (this.mDO != null && this.mDO.mEg.size() > 0) {
                for (com.tencent.mm.plugin.fts.a.a.g.b bVar : this.mDO.mEg) {
                    if (bVar.mEe == com.tencent.mm.plugin.fts.a.a.g.d.OTHER) {
                        String str = bVar.content;
                        AppMethodBeat.o(114241);
                        return str;
                    }
                }
            }
            AppMethodBeat.o(114241);
            return null;
        }

        public final String toString() {
            AppMethodBeat.i(114242);
            String str = "FTSQueryHLRequest.Item %s %d %d";
            Object[] objArr = new Object[3];
            objArr[0] = this.mDO == null ? "" : this.mDO.bAn().replaceAll("​", ",");
            objArr[1] = Integer.valueOf(this.mDP);
            objArr[2] = Integer.valueOf(this.mDQ);
            String format = String.format(str, objArr);
            AppMethodBeat.o(114242);
            return format;
        }
    }

    public enum a {
        Foreground,
        Background,
        CustomTag;

        static {
            AppMethodBeat.o(114240);
        }
    }

    public d() {
        AppMethodBeat.i(114243);
        AppMethodBeat.o(114243);
    }

    public static final d a(CharSequence charSequence, List<String> list) {
        AppMethodBeat.i(114244);
        d b = b(charSequence, bo.c((List) list, " "));
        AppMethodBeat.o(114244);
        return b;
    }

    public static final d b(CharSequence charSequence, String str) {
        AppMethodBeat.i(114245);
        d dVar = new d();
        dVar.mDy = charSequence;
        dVar.mDz = g.aO(str, false);
        dVar.mDA = false;
        dVar.mDC = false;
        AppMethodBeat.o(114245);
        return dVar;
    }

    public static final d a(CharSequence charSequence, g gVar) {
        AppMethodBeat.i(114246);
        d dVar = new d();
        dVar.mDy = charSequence;
        dVar.mDz = gVar;
        AppMethodBeat.o(114246);
        return dVar;
    }

    public static final d a(CharSequence charSequence, g gVar, boolean z, boolean z2) {
        AppMethodBeat.i(114247);
        d a = a(charSequence, gVar, z, z2, 0.0f, null);
        AppMethodBeat.o(114247);
        return a;
    }

    public static final d a(CharSequence charSequence, g gVar, float f, TextPaint textPaint) {
        AppMethodBeat.i(114248);
        d a = a(charSequence, gVar, false, false, f, textPaint);
        AppMethodBeat.o(114248);
        return a;
    }

    public static final d a(CharSequence charSequence, g gVar, boolean z, boolean z2, float f, TextPaint textPaint) {
        AppMethodBeat.i(114249);
        d dVar = new d();
        dVar.mDy = charSequence;
        dVar.mDz = gVar;
        dVar.mDA = z;
        dVar.mDC = z2;
        dVar.mDF = f;
        dVar.eNN = textPaint;
        AppMethodBeat.o(114249);
        return dVar;
    }

    public static final d a(CharSequence charSequence, g gVar, boolean z, boolean z2, TextPaint textPaint, CharSequence charSequence2, CharSequence charSequence3) {
        AppMethodBeat.i(114250);
        d dVar = new d();
        dVar.mDy = charSequence;
        dVar.mDz = gVar;
        dVar.mDA = z;
        dVar.mDC = z2;
        dVar.mDF = 400.0f;
        dVar.eNN = textPaint;
        dVar.mDG = charSequence2;
        dVar.mDH = charSequence3;
        AppMethodBeat.o(114250);
        return dVar;
    }

    public static final d a(CharSequence charSequence, List<String> list, a aVar, int i) {
        AppMethodBeat.i(114251);
        d a = a(charSequence, (List) list);
        a.mDD = aVar;
        a.mDE = i;
        AppMethodBeat.o(114251);
        return a;
    }
}
