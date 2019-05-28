package com.google.android.exoplayer2.p101c.p104f;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p101c.p104f.C37245v.C25530c;
import com.google.android.exoplayer2.p101c.p104f.C37245v.C8660b;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19392d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.c.f.e */
public final class C37239e implements C25530c {
    private final List<Format> bbD;
    private final int flags;

    public C37239e() {
        this(0);
    }

    public C37239e(int i) {
        this(i, Collections.emptyList());
        AppMethodBeat.m2504i(95098);
        AppMethodBeat.m2505o(95098);
    }

    public C37239e(int i, List<Format> list) {
        List list2;
        AppMethodBeat.m2504i(95099);
        this.flags = i;
        if (!isSet(32) && list2.isEmpty()) {
            list2 = Collections.singletonList(Format.m15285as("application/cea-608"));
        }
        this.bbD = list2;
        AppMethodBeat.m2505o(95099);
    }

    /* renamed from: rv */
    public final SparseArray<C37245v> mo42787rv() {
        AppMethodBeat.m2504i(95100);
        SparseArray sparseArray = new SparseArray();
        AppMethodBeat.m2505o(95100);
        return sparseArray;
    }

    /* renamed from: a */
    public final C37245v mo42786a(int i, C8660b c8660b) {
        AppMethodBeat.m2504i(95101);
        C37245v c32038o;
        switch (i) {
            case 2:
                c32038o = new C32038o(new C25526i());
                AppMethodBeat.m2505o(95101);
                return c32038o;
            case 3:
            case 4:
                c32038o = new C32038o(new C32037m(c8660b.aOt));
                AppMethodBeat.m2505o(95101);
                return c32038o;
            case 15:
                if (isSet(2)) {
                    AppMethodBeat.m2505o(95101);
                    return null;
                }
                c32038o = new C32038o(new C45024d(false, c8660b.aOt));
                AppMethodBeat.m2505o(95101);
                return c32038o;
            case 21:
                c32038o = new C32038o(new C32036l());
                AppMethodBeat.m2505o(95101);
                return c32038o;
            case 27:
                if (isSet(4)) {
                    AppMethodBeat.m2505o(95101);
                    return null;
                }
                c32038o = new C32038o(new C17641j(m62456a(c8660b), isSet(1), isSet(8)));
                AppMethodBeat.m2505o(95101);
                return c32038o;
            case 36:
                c32038o = new C32038o(new C6265k(m62456a(c8660b)));
                AppMethodBeat.m2505o(95101);
                return c32038o;
            case PlayerException.EXCEPTION_IN_CHECK_STATE /*89*/:
                c32038o = new C32038o(new C8659g(c8660b.bdJ));
                AppMethodBeat.m2505o(95101);
                return c32038o;
            case GmsClientSupervisor.DEFAULT_BIND_FLAGS /*129*/:
            case C44697b.CTRL_INDEX /*135*/:
                c32038o = new C32038o(new C32035b(c8660b.aOt));
                AppMethodBeat.m2505o(95101);
                return c32038o;
            case 130:
            case 138:
                c32038o = new C32038o(new C37240f(c8660b.aOt));
                AppMethodBeat.m2505o(95101);
                return c32038o;
            case C19392d.CTRL_INDEX /*134*/:
                if (isSet(16)) {
                    AppMethodBeat.m2505o(95101);
                    return null;
                }
                c32038o = new C25527r(new C45025t());
                AppMethodBeat.m2505o(95101);
                return c32038o;
            default:
                AppMethodBeat.m2505o(95101);
                return null;
        }
    }

    /* renamed from: a */
    private C17643s m62456a(C8660b c8660b) {
        AppMethodBeat.m2504i(95102);
        if (isSet(32)) {
            C17643s c17643s = new C17643s(this.bbD);
            AppMethodBeat.m2505o(95102);
            return c17643s;
        }
        C32065l c32065l = new C32065l(c8660b.bdK);
        List list = this.bbD;
        while (c32065l.mo52382tB() > 0) {
            int readUnsignedByte = c32065l.position + c32065l.readUnsignedByte();
            if (c32065l.readUnsignedByte() == C19392d.CTRL_INDEX) {
                ArrayList arrayList = new ArrayList();
                int readUnsignedByte2 = c32065l.readUnsignedByte() & 31;
                for (int i = 0; i < readUnsignedByte2; i++) {
                    int i2;
                    String str;
                    String readString = c32065l.readString(3);
                    int readUnsignedByte3 = c32065l.readUnsignedByte();
                    if ((readUnsignedByte3 & 128) != 0) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i2 != 0) {
                        str = "application/cea-708";
                        readUnsignedByte3 &= 63;
                    } else {
                        str = "application/cea-608";
                        readUnsignedByte3 = 1;
                    }
                    arrayList.add(Format.m15275a(null, str, 0, readString, readUnsignedByte3));
                    c32065l.mo52369eM(2);
                }
                list = arrayList;
            }
            c32065l.setPosition(readUnsignedByte);
        }
        C17643s c17643s2 = new C17643s(list);
        AppMethodBeat.m2505o(95102);
        return c17643s2;
    }

    private boolean isSet(int i) {
        return (this.flags & i) != 0;
    }
}
