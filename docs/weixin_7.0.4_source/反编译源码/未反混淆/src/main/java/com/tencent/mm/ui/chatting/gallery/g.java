package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.az;
import java.util.HashMap;
import java.util.LinkedList;

public final class g {
    private az fwL = new az(1, "chatting-image-gallery-preload-loader");
    protected f<String, Bitmap> mQK = new b(4, new f.b<String, Bitmap>() {
        public final /* synthetic */ void c(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.i(32161);
            g.this.yVB.remove((String) obj);
            AppMethodBeat.o(32161);
        }
    }, getClass());
    public LinkedList<String> mQM = new LinkedList();
    private boolean mQO = false;
    private int mScrollState = 0;
    protected HashMap<String, Long> yVB = new HashMap();

    public static final class a {
        public static g yVD = new g();

        static {
            AppMethodBeat.i(32162);
            AppMethodBeat.o(32162);
        }
    }

    public g() {
        AppMethodBeat.i(32163);
        AppMethodBeat.o(32163);
    }

    public final void bCH() {
        AppMethodBeat.i(32164);
        this.mQK.a(new com.tencent.mm.a.f.a<String, Bitmap>() {
        });
        AppMethodBeat.o(32164);
    }
}
