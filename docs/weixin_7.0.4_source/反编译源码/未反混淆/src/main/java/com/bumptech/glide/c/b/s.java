package com.bumptech.glide.c.b;

import android.support.v4.f.k.a;
import com.bumptech.glide.c.a.e;
import com.bumptech.glide.c.j;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class s<Data, ResourceType, Transcode> {
    private final Class<Data> aBd;
    private final a<List<Throwable>> aBg;
    private final String aBh;
    private final List<? extends h<Data, ResourceType, Transcode>> aCc;

    public s(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<h<Data, ResourceType, Transcode>> list, a<List<Throwable>> aVar) {
        AppMethodBeat.i(91864);
        this.aBd = cls;
        this.aBg = aVar;
        this.aCc = (List) i.c(list);
        this.aBh = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
        AppMethodBeat.o(91864);
    }

    public final u<Transcode> a(e<Data> eVar, j jVar, int i, int i2, a<ResourceType> aVar) {
        AppMethodBeat.i(91865);
        List list = (List) i.d(this.aBg.aA(), "Argument must not be null");
        try {
            u<Transcode> a = a(eVar, jVar, i, i2, aVar, list);
            return a;
        } finally {
            this.aBg.release(list);
            AppMethodBeat.o(91865);
        }
    }

    private u<Transcode> a(e<Data> eVar, j jVar, int i, int i2, a<ResourceType> aVar, List<Throwable> list) {
        u<Transcode> a;
        p e;
        AppMethodBeat.i(91866);
        u<Transcode> uVar = null;
        int size = this.aCc.size();
        int i3 = 0;
        while (i3 < size) {
            h hVar = (h) this.aCc.get(i3);
            try {
                a = hVar.aBf.a(aVar.a(hVar.a(eVar, i, i2, jVar)), jVar);
            } catch (p e2) {
                list.add(e2);
                a = uVar;
            }
            if (a != null) {
                break;
            }
            i3++;
            uVar = a;
        }
        a = uVar;
        if (a == null) {
            e2 = new p(this.aBh, new ArrayList(list));
            AppMethodBeat.o(91866);
            throw e2;
        }
        AppMethodBeat.o(91866);
        return a;
    }

    public final String toString() {
        AppMethodBeat.i(91867);
        String str = "LoadPath{decodePaths=" + Arrays.toString(this.aCc.toArray()) + '}';
        AppMethodBeat.o(91867);
        return str;
    }
}
