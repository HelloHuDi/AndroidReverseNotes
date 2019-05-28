package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.b.f;
import com.google.android.exoplayer2.b.g;
import com.google.android.exoplayer2.i.a;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.nio.ByteBuffer;

public abstract class b extends g<h, i, f> implements e {
    private final String name;

    public abstract d c(byte[] bArr, int i, boolean z);

    protected b(String str) {
        boolean z;
        int i = 0;
        super(new h[2], new i[2]);
        this.name = str;
        if (this.aSr == this.aSp.length) {
            z = true;
        } else {
            z = false;
        }
        a.checkState(z);
        e[] eVarArr = this.aSp;
        int length = eVarArr.length;
        while (i < length) {
            eVarArr[i].dD(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            i++;
        }
    }

    public final void ai(long j) {
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(i iVar) {
        super.a((f) iVar);
    }

    private f a(h hVar, i iVar, boolean z) {
        try {
            ByteBuffer byteBuffer = hVar.aEY;
            d c = c(byteBuffer.array(), byteBuffer.limit(), z);
            iVar.a(hVar.aSk, c, hVar.aOr);
            iVar.flags &= BaseClientBuilder.API_PRIORITY_OTHER;
            return null;
        } catch (f e) {
            return e;
        }
    }

    public final /* synthetic */ f qS() {
        return new c(this);
    }

    public final /* synthetic */ e qR() {
        return new h();
    }
}
