package com.bumptech.glide.c.b;

import android.util.Log;
import com.bumptech.glide.c.d.f.e;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.k;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class h<DataType, ResourceType, Transcode> {
    private final Class<DataType> aBd;
    private final List<? extends k<DataType, ResourceType>> aBe;
    final e<ResourceType, Transcode> aBf;
    private final android.support.v4.f.k.a<List<Throwable>> aBg;
    private final String aBh;

    interface a<ResourceType> {
        u<ResourceType> a(u<ResourceType> uVar);
    }

    public h(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends k<DataType, ResourceType>> list, e<ResourceType, Transcode> eVar, android.support.v4.f.k.a<List<Throwable>> aVar) {
        AppMethodBeat.i(91804);
        this.aBd = cls;
        this.aBe = list;
        this.aBf = eVar;
        this.aBg = aVar;
        this.aBh = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
        AppMethodBeat.o(91804);
    }

    /* Access modifiers changed, original: final */
    public final u<ResourceType> a(com.bumptech.glide.c.a.e<DataType> eVar, int i, int i2, j jVar) {
        AppMethodBeat.i(91805);
        List list = (List) i.d(this.aBg.aA(), "Argument must not be null");
        try {
            u<ResourceType> a = a(eVar, i, i2, jVar, list);
            return a;
        } finally {
            this.aBg.release(list);
            AppMethodBeat.o(91805);
        }
    }

    private u<ResourceType> a(com.bumptech.glide.c.a.e<DataType> eVar, int i, int i2, j jVar, List<Throwable> list) {
        AppMethodBeat.i(91806);
        u<ResourceType> uVar = null;
        int size = this.aBe.size();
        for (int i3 = 0; i3 < size; i3++) {
            k kVar = (k) this.aBe.get(i3);
            try {
                u<ResourceType> a;
                if (kVar.a(eVar.mj(), jVar)) {
                    a = kVar.a(eVar.mj(), i, i2, jVar);
                } else {
                    a = uVar;
                }
                uVar = a;
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    new StringBuilder("Failed to decode data for ").append(kVar);
                }
                list.add(e);
            }
            if (uVar != null) {
                break;
            }
        }
        if (uVar == null) {
            p pVar = new p(this.aBh, new ArrayList(list));
            AppMethodBeat.o(91806);
            throw pVar;
        }
        AppMethodBeat.o(91806);
        return uVar;
    }

    public final String toString() {
        AppMethodBeat.i(91807);
        String str = "DecodePath{ dataClass=" + this.aBd + ", decoders=" + this.aBe + ", transcoder=" + this.aBf + '}';
        AppMethodBeat.o(91807);
        return str;
    }
}
