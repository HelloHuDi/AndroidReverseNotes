package com.tencent.p177mm.booter.notification.queue;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* renamed from: com.tencent.mm.booter.notification.queue.c */
public final class C25980c {
    /* renamed from: a */
    public static String m41443a(Serializable serializable) {
        AppMethodBeat.m2504i(16002);
        long currentTimeMillis = System.currentTimeMillis();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(serializable);
        String encode = URLEncoder.encode(byteArrayOutputStream.toString("ISO-8859-1"), "UTF-8");
        objectOutputStream.close();
        byteArrayOutputStream.close();
        C4990ab.m7411d("MicroMsg.NotificationQueueTool", "serialize consume: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(16002);
        return encode;
    }

    /* renamed from: jQ */
    public static Serializable m41444jQ(String str) {
        AppMethodBeat.m2504i(16003);
        if (C42252ah.isNullOrNil(str)) {
            AppMethodBeat.m2505o(16003);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(URLDecoder.decode(str, "UTF-8").getBytes("ISO-8859-1"));
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Serializable serializable = (Serializable) objectInputStream.readObject();
        objectInputStream.close();
        byteArrayInputStream.close();
        C4990ab.m7411d("MicroMsg.NotificationQueueTool", "de serialize consume: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(16003);
        return serializable;
    }
}
