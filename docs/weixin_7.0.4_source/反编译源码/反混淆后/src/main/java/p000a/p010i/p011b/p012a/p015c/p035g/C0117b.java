package p000a.p010i.p011b.p012a.p015c.p035g;

import com.tencent.view.C31128d;
import java.io.IOException;
import java.io.InputStream;
import p000a.p010i.p011b.p012a.p015c.p035g.C0114a.C0115a.C0116a;

/* renamed from: a.i.b.a.c.g.b */
public abstract class C0117b<MessageType extends C8185q> implements C25163s<MessageType> {
    private static final C31715g Bzm = C31715g.eif();

    /* renamed from: j */
    public final /* synthetic */ Object mo190j(InputStream inputStream, C31715g c31715g) {
        return m228g(inputStream, c31715g);
    }

    /* renamed from: a */
    private static MessageType m226a(MessageType messageType) {
        if (messageType == null || messageType.isInitialized()) {
            return messageType;
        }
        C44904w c44904w;
        if (messageType instanceof C0114a) {
            c44904w = new C44904w();
        } else {
            c44904w = new C44904w();
        }
        C41425k c41425k = new C41425k(c44904w.getMessage());
        c41425k.BzY = messageType;
        throw c41425k;
    }

    /* renamed from: a */
    private MessageType m225a(C31710d c31710d, C31715g c31715g) {
        C8185q c8185q;
        try {
            C31713e ehR = c31710d.ehR();
            c8185q = (C8185q) mo157a(ehR, c31715g);
            ehR.mo51689fm(0);
            return c8185q;
        } catch (C41425k e) {
            e.BzY = c8185q;
            throw e;
        } catch (C41425k e2) {
            throw e2;
        }
    }

    /* renamed from: f */
    private MessageType m227f(InputStream inputStream, C31715g c31715g) {
        C31713e S = C31713e.m51322S(inputStream);
        C8185q c8185q = (C8185q) mo157a(S, c31715g);
        try {
            S.mo51689fm(0);
            return c8185q;
        } catch (C41425k e) {
            e.BzY = c8185q;
            throw e;
        }
    }

    /* renamed from: g */
    private MessageType m228g(InputStream inputStream, C31715g c31715g) {
        return C0117b.m226a(m227f(inputStream, c31715g));
    }

    /* renamed from: h */
    private MessageType m229h(InputStream inputStream, C31715g c31715g) {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            if ((read & 128) != 0) {
                int read2;
                read &= C31128d.MIC_SketchMark;
                int i = 7;
                while (i < 32) {
                    read2 = inputStream.read();
                    if (read2 != -1) {
                        read |= (read2 & C31128d.MIC_SketchMark) << i;
                        if ((read2 & 128) == 0) {
                            break;
                        }
                        i += 7;
                    } else {
                        throw C41425k.eiq();
                    }
                }
                while (i < 64) {
                    read2 = inputStream.read();
                    if (read2 == -1) {
                        throw C41425k.eiq();
                    } else if ((read2 & 128) != 0) {
                        i += 7;
                    }
                }
                throw C41425k.eis();
            }
            return m227f(new C0116a(inputStream, read), c31715g);
        } catch (IOException e) {
            throw new C41425k(e.getMessage());
        }
    }

    /* renamed from: i */
    public final /* synthetic */ Object mo189i(InputStream inputStream, C31715g c31715g) {
        return C0117b.m226a(m229h(inputStream, c31715g));
    }

    /* renamed from: R */
    public final /* synthetic */ Object mo187R(InputStream inputStream) {
        return m228g(inputStream, Bzm);
    }

    /* renamed from: b */
    public final /* synthetic */ Object mo188b(C31710d c31710d, C31715g c31715g) {
        return C0117b.m226a(m225a(c31710d, c31715g));
    }
}
