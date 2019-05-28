package com.tencent.p177mm.compatible.p219b;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;

/* renamed from: com.tencent.mm.compatible.b.k */
public final class C45289k extends MediaPlayer {
    public C45289k() {
        AppMethodBeat.m2504i(92899);
        C1407g.m2966iP(hashCode());
        AppMethodBeat.m2505o(92899);
    }

    /* renamed from: d */
    public static C45289k m83508d(Context context, Uri uri) {
        AppMethodBeat.m2504i(92900);
        try {
            C45289k c45289k = new C45289k();
            c45289k.setDataSource(context, uri);
            c45289k.prepare();
            AppMethodBeat.m2505o(92900);
            return c45289k;
        } catch (IOException e) {
            C4990ab.m7411d("MicroMsg.MediaPlayerWrapper", "create failed:", e);
            AppMethodBeat.m2505o(92900);
            return null;
        } catch (IllegalArgumentException e2) {
            C4990ab.m7411d("MicroMsg.MediaPlayerWrapper", "create failed:", e2);
            AppMethodBeat.m2505o(92900);
            return null;
        } catch (SecurityException e3) {
            C4990ab.m7411d("MicroMsg.MediaPlayerWrapper", "create failed:", e3);
            AppMethodBeat.m2505o(92900);
            return null;
        }
    }

    public final void release() {
        AppMethodBeat.m2504i(92901);
        super.release();
        C1407g.m2967iQ(hashCode());
        AppMethodBeat.m2505o(92901);
    }
}
