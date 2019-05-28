package com.tencent.p177mm.memory.p259a.p260a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.p259a.p260a.p261a.C1792a;
import com.tencent.p177mm.memory.p259a.p260a.p261a.C1798c;
import com.tencent.p177mm.p178a.C1177f.C1175b;
import com.tencent.p177mm.p178a.C1177f.C1176c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.tencent.mm.memory.a.a.a */
public class C6662a implements C1798c<String> {
    String feb;
    WeakReference<C1175b> fec;
    WeakReference<C1176c> fed;
    public int fee = 0;
    long fef = 0;
    String feg;
    public String key;
    Object object;

    public C6662a(String str, String str2, Object obj, int i, C1175b c1175b, C1176c c1176c) {
        AppMethodBeat.m2504i(115444);
        this.key = str;
        this.feb = str2;
        this.object = obj;
        this.fee = i;
        this.fec = new WeakReference(c1175b);
        this.fed = new WeakReference(c1176c);
        this.fef = System.currentTimeMillis();
        this.feg = new SimpleDateFormat("HH:mm:ss").format(new Date(this.fef));
        if (C1792a.feq) {
            C4990ab.m7417i("MicroMsg.BusinessBitmap", "BusinessBitmap build key %s sizes: %s cacheTime %s object %s stack [%s]", str, C5046bo.m7565ga((long) i), this.feg, obj, C5046bo.dpG().toString());
        }
        AppMethodBeat.m2505o(115444);
    }

    public int hashCode() {
        AppMethodBeat.m2504i(115445);
        int hashCode;
        if (this.object != null) {
            hashCode = this.object.hashCode();
            AppMethodBeat.m2505o(115445);
            return hashCode;
        }
        hashCode = super.hashCode();
        AppMethodBeat.m2505o(115445);
        return hashCode;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(115446);
        boolean equals;
        if (obj == null || !(obj instanceof C6662a) || ((C6662a) obj).object == null) {
            equals = super.equals(obj);
            AppMethodBeat.m2505o(115446);
            return equals;
        }
        equals = ((C6662a) obj).object.equals(this.object);
        AppMethodBeat.m2505o(115446);
        return equals;
    }

    public String toString() {
        AppMethodBeat.m2504i(115447);
        String format = String.format("StructBitmap %s key:%s size %s realObj %s cacheTime %s now %s", new Object[]{Integer.valueOf(hashCode()), this.key, C5046bo.m7565ga((long) this.fee), this.object, this.feg, new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis()))});
        AppMethodBeat.m2505o(115447);
        return format;
    }

    /* renamed from: Xp */
    public final /* bridge */ /* synthetic */ Object mo5356Xp() {
        return this.feb;
    }

    /* renamed from: Xq */
    public final /* bridge */ /* synthetic */ Object mo5357Xq() {
        return this.key;
    }
}
