package com.tencent.p177mm.p188an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.InputStream;
import java.io.ObjectInputStream;

/* renamed from: com.tencent.mm.an.b */
public final class C41754b {
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0075 A:{SYNTHETIC, Splitter:B:23:0x0075} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: x */
    public static Object m73609x(InputStream inputStream) {
        Object readObject;
        Exception e;
        Throwable th;
        ObjectInputStream readObject2 = null;
        AppMethodBeat.m2504i(58337);
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
            try {
                readObject2 = objectInputStream.readObject();
                try {
                    objectInputStream.close();
                } catch (Exception e2) {
                    C4990ab.m7420w("MicroMsg.ObjectUtil", "Read close exception:" + e2.getMessage());
                }
            } catch (Exception e3) {
                e2 = e3;
            }
        } catch (Exception e4) {
            e2 = e4;
            objectInputStream = readObject2;
            try {
                C4990ab.m7420w("MicroMsg.ObjectUtil", "Read exception:" + e2.getMessage());
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Exception e22) {
                        C4990ab.m7420w("MicroMsg.ObjectUtil", "Read close exception:" + e22.getMessage());
                    }
                }
                AppMethodBeat.m2505o(58337);
                return readObject2;
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Exception e5) {
                        C4990ab.m7420w("MicroMsg.ObjectUtil", "Read close exception:" + e5.getMessage());
                    }
                }
                AppMethodBeat.m2505o(58337);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            objectInputStream = readObject2;
            if (objectInputStream != null) {
            }
            AppMethodBeat.m2505o(58337);
            throw th;
        }
        AppMethodBeat.m2505o(58337);
        return readObject2;
    }
}
