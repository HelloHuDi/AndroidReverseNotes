package com.tencent.mm.compatible.b;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public final class k extends MediaPlayer {
    public k() {
        AppMethodBeat.i(92899);
        g.iP(hashCode());
        AppMethodBeat.o(92899);
    }

    public static k d(Context context, Uri uri) {
        AppMethodBeat.i(92900);
        try {
            k kVar = new k();
            kVar.setDataSource(context, uri);
            kVar.prepare();
            AppMethodBeat.o(92900);
            return kVar;
        } catch (IOException e) {
            ab.d("MicroMsg.MediaPlayerWrapper", "create failed:", e);
            AppMethodBeat.o(92900);
            return null;
        } catch (IllegalArgumentException e2) {
            ab.d("MicroMsg.MediaPlayerWrapper", "create failed:", e2);
            AppMethodBeat.o(92900);
            return null;
        } catch (SecurityException e3) {
            ab.d("MicroMsg.MediaPlayerWrapper", "create failed:", e3);
            AppMethodBeat.o(92900);
            return null;
        }
    }

    public final void release() {
        AppMethodBeat.i(92901);
        super.release();
        g.iQ(hashCode());
        AppMethodBeat.o(92901);
    }
}
