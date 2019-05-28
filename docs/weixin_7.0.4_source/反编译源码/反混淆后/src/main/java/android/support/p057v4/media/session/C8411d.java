package android.support.p057v4.media.session;

import android.media.session.MediaSession.Token;

/* renamed from: android.support.v4.media.session.d */
final class C8411d {
    /* renamed from: A */
    public static Object m14829A(Object obj) {
        if (obj instanceof Token) {
            return obj;
        }
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }
}
