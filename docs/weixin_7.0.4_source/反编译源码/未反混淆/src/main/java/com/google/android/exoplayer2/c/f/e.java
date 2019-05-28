package com.google.android.exoplayer2.c.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f.v.b;
import com.google.android.exoplayer2.c.f.v.c;
import com.google.android.exoplayer2.i.l;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.d;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class e implements c {
    private final List<Format> bbD;
    private final int flags;

    public e() {
        this(0);
    }

    public e(int i) {
        this(i, Collections.emptyList());
        AppMethodBeat.i(95098);
        AppMethodBeat.o(95098);
    }

    public e(int i, List<Format> list) {
        List list2;
        AppMethodBeat.i(95099);
        this.flags = i;
        if (!isSet(32) && list2.isEmpty()) {
            list2 = Collections.singletonList(Format.as("application/cea-608"));
        }
        this.bbD = list2;
        AppMethodBeat.o(95099);
    }

    public final SparseArray<v> rv() {
        AppMethodBeat.i(95100);
        SparseArray sparseArray = new SparseArray();
        AppMethodBeat.o(95100);
        return sparseArray;
    }

    public final v a(int i, b bVar) {
        AppMethodBeat.i(95101);
        v oVar;
        switch (i) {
            case 2:
                oVar = new o(new i());
                AppMethodBeat.o(95101);
                return oVar;
            case 3:
            case 4:
                oVar = new o(new m(bVar.aOt));
                AppMethodBeat.o(95101);
                return oVar;
            case 15:
                if (isSet(2)) {
                    AppMethodBeat.o(95101);
                    return null;
                }
                oVar = new o(new d(false, bVar.aOt));
                AppMethodBeat.o(95101);
                return oVar;
            case 21:
                oVar = new o(new l());
                AppMethodBeat.o(95101);
                return oVar;
            case 27:
                if (isSet(4)) {
                    AppMethodBeat.o(95101);
                    return null;
                }
                oVar = new o(new j(a(bVar), isSet(1), isSet(8)));
                AppMethodBeat.o(95101);
                return oVar;
            case 36:
                oVar = new o(new k(a(bVar)));
                AppMethodBeat.o(95101);
                return oVar;
            case PlayerException.EXCEPTION_IN_CHECK_STATE /*89*/:
                oVar = new o(new g(bVar.bdJ));
                AppMethodBeat.o(95101);
                return oVar;
            case GmsClientSupervisor.DEFAULT_BIND_FLAGS /*129*/:
            case com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX /*135*/:
                oVar = new o(new b(bVar.aOt));
                AppMethodBeat.o(95101);
                return oVar;
            case 130:
            case 138:
                oVar = new o(new f(bVar.aOt));
                AppMethodBeat.o(95101);
                return oVar;
            case d.CTRL_INDEX /*134*/:
                if (isSet(16)) {
                    AppMethodBeat.o(95101);
                    return null;
                }
                oVar = new r(new t());
                AppMethodBeat.o(95101);
                return oVar;
            default:
                AppMethodBeat.o(95101);
                return null;
        }
    }

    private s a(b bVar) {
        AppMethodBeat.i(95102);
        if (isSet(32)) {
            s sVar = new s(this.bbD);
            AppMethodBeat.o(95102);
            return sVar;
        }
        l lVar = new l(bVar.bdK);
        List list = this.bbD;
        while (lVar.tB() > 0) {
            int readUnsignedByte = lVar.position + lVar.readUnsignedByte();
            if (lVar.readUnsignedByte() == d.CTRL_INDEX) {
                ArrayList arrayList = new ArrayList();
                int readUnsignedByte2 = lVar.readUnsignedByte() & 31;
                for (int i = 0; i < readUnsignedByte2; i++) {
                    int i2;
                    String str;
                    String readString = lVar.readString(3);
                    int readUnsignedByte3 = lVar.readUnsignedByte();
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
                    arrayList.add(Format.a(null, str, 0, readString, readUnsignedByte3));
                    lVar.eM(2);
                }
                list = arrayList;
            }
            lVar.setPosition(readUnsignedByte);
        }
        s sVar2 = new s(list);
        AppMethodBeat.o(95102);
        return sVar2;
    }

    private boolean isSet(int i) {
        return (this.flags & i) != 0;
    }
}
