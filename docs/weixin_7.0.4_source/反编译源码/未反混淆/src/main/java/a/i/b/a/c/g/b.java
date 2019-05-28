package a.i.b.a.c.g;

import com.tencent.view.d;
import java.io.IOException;
import java.io.InputStream;

public abstract class b<MessageType extends q> implements s<MessageType> {
    private static final g Bzm = g.eif();

    public final /* synthetic */ Object j(InputStream inputStream, g gVar) {
        return g(inputStream, gVar);
    }

    private static MessageType a(MessageType messageType) {
        if (messageType == null || messageType.isInitialized()) {
            return messageType;
        }
        w wVar;
        if (messageType instanceof a) {
            wVar = new w();
        } else {
            wVar = new w();
        }
        k kVar = new k(wVar.getMessage());
        kVar.BzY = messageType;
        throw kVar;
    }

    private MessageType a(d dVar, g gVar) {
        q qVar;
        try {
            e ehR = dVar.ehR();
            qVar = (q) a(ehR, gVar);
            ehR.fm(0);
            return qVar;
        } catch (k e) {
            e.BzY = qVar;
            throw e;
        } catch (k e2) {
            throw e2;
        }
    }

    private MessageType f(InputStream inputStream, g gVar) {
        e S = e.S(inputStream);
        q qVar = (q) a(S, gVar);
        try {
            S.fm(0);
            return qVar;
        } catch (k e) {
            e.BzY = qVar;
            throw e;
        }
    }

    private MessageType g(InputStream inputStream, g gVar) {
        return a(f(inputStream, gVar));
    }

    private MessageType h(InputStream inputStream, g gVar) {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            if ((read & 128) != 0) {
                int read2;
                read &= d.MIC_SketchMark;
                int i = 7;
                while (i < 32) {
                    read2 = inputStream.read();
                    if (read2 != -1) {
                        read |= (read2 & d.MIC_SketchMark) << i;
                        if ((read2 & 128) == 0) {
                            break;
                        }
                        i += 7;
                    } else {
                        throw k.eiq();
                    }
                }
                while (i < 64) {
                    read2 = inputStream.read();
                    if (read2 == -1) {
                        throw k.eiq();
                    } else if ((read2 & 128) != 0) {
                        i += 7;
                    }
                }
                throw k.eis();
            }
            return f(new a(inputStream, read), gVar);
        } catch (IOException e) {
            throw new k(e.getMessage());
        }
    }

    public final /* synthetic */ Object i(InputStream inputStream, g gVar) {
        return a(h(inputStream, gVar));
    }

    public final /* synthetic */ Object R(InputStream inputStream) {
        return g(inputStream, Bzm);
    }

    public final /* synthetic */ Object b(d dVar, g gVar) {
        return a(a(dVar, gVar));
    }
}
