package p000a.p010i.p011b.p012a.p015c.p023d.p031b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C17154an;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C6143s;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.C0092b;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a.C41421g;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C25151f;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C31702c;
import p000a.p010i.p011b.p012a.p015c.p035g.C25155i.C25158c;
import p000a.p010i.p011b.p012a.p015c.p035g.C25155i.C8180f;
import p000a.p010i.p011b.p012a.p015c.p037i.p1366d.C41436b;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C0144o;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.p043a.C44640e;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;
import p000a.p051k.C31820v;

/* renamed from: a.i.b.a.c.d.b.i */
public final class C31679i implements C44640e {
    private final boolean BrA;
    final C8143n BrB;
    public final C41436b Brx;
    public final C41436b Bry;
    private final C0144o<C41421g> Brz;
    private final String gTy;

    /* JADX WARNING: Missing block: B:3:0x0041, code skipped:
            if (r0 == null) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private C31679i(C41436b c41436b, C41436b c41436b2, C6143s c6143s, C31702c c31702c, C0144o<C41421g> c0144o, boolean z, C8143n c8143n) {
        String string;
        C25052j.m39376p(c41436b, "className");
        C25052j.m39376p(c6143s, "packageProto");
        C25052j.m39376p(c31702c, "nameResolver");
        AppMethodBeat.m2504i(120271);
        this.Brx = c41436b;
        this.Bry = c41436b2;
        this.Brz = c0144o;
        this.BrA = z;
        this.BrB = c8143n;
        C25158c c25158c = c6143s;
        C8180f c8180f = C0092b.BxK;
        C25052j.m39375o(c8180f, "JvmProtoBuf.packageModuleName");
        Integer num = (Integer) C25151f.m39618a(c25158c, c8180f);
        if (num != null) {
            string = c31702c.getString(num.intValue());
        }
        string = "main";
        this.gTy = string;
        AppMethodBeat.m2505o(120271);
    }

    public C31679i(C8143n c8143n, C6143s c6143s, C31702c c31702c, C0144o<C41421g> c0144o, boolean z) {
        C41436b c41436b;
        C31679i c31679i;
        C41436b c41436b2 = null;
        C25052j.m39376p(c8143n, "kotlinClass");
        C25052j.m39376p(c6143s, "packageProto");
        C25052j.m39376p(c31702c, "nameResolver");
        C41436b h = C41436b.m72290h(c8143n.dWY());
        C25052j.m39375o(h, "JvmClassName.byClassId(kotlinClass.classId)");
        String ecv = c8143n.dXA().ecv();
        if (ecv != null) {
            if ((((CharSequence) ecv).length() > 0 ? 1 : null) != null) {
                c41436b2 = C41436b.awj(ecv);
            }
            c41436b = h;
            c31679i = this;
        } else {
            c41436b = h;
            c31679i = this;
        }
        c31679i = new C31679i(c41436b, c41436b2, c6143s, c31702c, c0144o, z, c8143n);
        AppMethodBeat.m2505o(120272);
    }

    public final C37022f ect() {
        AppMethodBeat.m2504i(120267);
        String str = this.Brx.BrD;
        C25052j.m39375o(str, "className.internalName");
        C37022f avX = C37022f.avX(C31820v.m51522a(str, (char) IOUtils.DIR_SEPARATOR_UNIX));
        C25052j.m39375o(avX, "Name.identifier(classNam….substringAfterLast('/'))");
        AppMethodBeat.m2505o(120267);
        return avX;
    }

    public final C8173a dWY() {
        AppMethodBeat.m2504i(120268);
        C8173a c8173a = new C8173a(this.Brx.ejz(), ect());
        AppMethodBeat.m2505o(120268);
        return c8173a;
    }

    public final String toString() {
        AppMethodBeat.m2504i(120269);
        String str = getClass().getSimpleName() + ": " + this.Brx;
        AppMethodBeat.m2505o(120269);
        return str;
    }

    public final C17154an dXz() {
        AppMethodBeat.m2504i(120270);
        C17154an c17154an = C17154an.BeS;
        C25052j.m39375o(c17154an, "SourceFile.NO_SOURCE_FILE");
        AppMethodBeat.m2505o(120270);
        return c17154an;
    }
}
