package android.support.v4.media.session;

import android.media.session.MediaSession.Token;

final class d {
    public static Object A(Object obj) {
        if (obj instanceof Token) {
            return obj;
        }
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }
}
