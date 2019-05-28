package com.tencent.mm.memory.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.a.f.b;
import com.tencent.mm.memory.a.a.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;

public class a implements c<String> {
    String feb;
    WeakReference<b> fec;
    WeakReference<f.c> fed;
    public int fee = 0;
    long fef = 0;
    String feg;
    public String key;
    Object object;

    public a(String str, String str2, Object obj, int i, b bVar, f.c cVar) {
        AppMethodBeat.i(115444);
        this.key = str;
        this.feb = str2;
        this.object = obj;
        this.fee = i;
        this.fec = new WeakReference(bVar);
        this.fed = new WeakReference(cVar);
        this.fef = System.currentTimeMillis();
        this.feg = new SimpleDateFormat("HH:mm:ss").format(new Date(this.fef));
        if (com.tencent.mm.memory.a.a.a.a.feq) {
            ab.i("MicroMsg.BusinessBitmap", "BusinessBitmap build key %s sizes: %s cacheTime %s object %s stack [%s]", str, bo.ga((long) i), this.feg, obj, bo.dpG().toString());
        }
        AppMethodBeat.o(115444);
    }

    public int hashCode() {
        AppMethodBeat.i(115445);
        int hashCode;
        if (this.object != null) {
            hashCode = this.object.hashCode();
            AppMethodBeat.o(115445);
            return hashCode;
        }
        hashCode = super.hashCode();
        AppMethodBeat.o(115445);
        return hashCode;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(115446);
        boolean equals;
        if (obj == null || !(obj instanceof a) || ((a) obj).object == null) {
            equals = super.equals(obj);
            AppMethodBeat.o(115446);
            return equals;
        }
        equals = ((a) obj).object.equals(this.object);
        AppMethodBeat.o(115446);
        return equals;
    }

    public String toString() {
        AppMethodBeat.i(115447);
        String format = String.format("StructBitmap %s key:%s size %s realObj %s cacheTime %s now %s", new Object[]{Integer.valueOf(hashCode()), this.key, bo.ga((long) this.fee), this.object, this.feg, new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis()))});
        AppMethodBeat.o(115447);
        return format;
    }

    public final /* bridge */ /* synthetic */ Object Xp() {
        return this.feb;
    }

    public final /* bridge */ /* synthetic */ Object Xq() {
        return this.key;
    }
}
