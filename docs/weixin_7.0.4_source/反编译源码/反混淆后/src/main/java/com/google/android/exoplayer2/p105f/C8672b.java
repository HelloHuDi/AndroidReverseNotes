package com.google.android.exoplayer2.p105f;

import com.google.android.exoplayer2.p100b.C32022e;
import com.google.android.exoplayer2.p100b.C32023f;
import com.google.android.exoplayer2.p100b.C32024g;
import com.google.android.exoplayer2.p111i.C45039a;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.nio.ByteBuffer;

/* renamed from: com.google.android.exoplayer2.f.b */
public abstract class C8672b extends C32024g<C41610h, C41611i, C41607f> implements C41606e {
    private final String name;

    /* renamed from: c */
    public abstract C17659d mo2574c(byte[] bArr, int i, boolean z);

    protected C8672b(String str) {
        boolean z;
        int i = 0;
        super(new C41610h[2], new C41611i[2]);
        this.name = str;
        if (this.aSr == this.aSp.length) {
            z = true;
        } else {
            z = false;
        }
        C45039a.checkState(z);
        C32022e[] c32022eArr = this.aSp;
        int length = c32022eArr.length;
        while (i < length) {
            c32022eArr[i].mo52315dD(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            i++;
        }
    }

    /* renamed from: ai */
    public final void mo19179ai(long j) {
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo19188a(C41611i c41611i) {
        super.mo19187a((C32023f) c41611i);
    }

    /* renamed from: a */
    private C41607f m15388a(C41610h c41610h, C41611i c41611i, boolean z) {
        try {
            ByteBuffer byteBuffer = c41610h.aEY;
            C17659d c = mo2574c(byteBuffer.array(), byteBuffer.limit(), z);
            c41611i.mo66740a(c41610h.aSk, c, c41610h.aOr);
            c41611i.flags &= BaseClientBuilder.API_PRIORITY_OTHER;
            return null;
        } catch (C41607f e) {
            return e;
        }
    }

    /* renamed from: qS */
    public final /* synthetic */ C32023f mo19190qS() {
        return new C17658c(this);
    }

    /* renamed from: qR */
    public final /* synthetic */ C32022e mo19189qR() {
        return new C41610h();
    }
}
