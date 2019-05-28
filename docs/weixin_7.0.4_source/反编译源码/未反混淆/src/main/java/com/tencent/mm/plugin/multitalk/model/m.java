package com.tencent.mm.plugin.multitalk.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class m {
    public volatile Map<String, a> oHq = Collections.synchronizedMap(new HashMap());

    public class a {
        public int angle;
        Bitmap gFP;
        public int oHb;
        Bitmap oHr;
        public Bitmap oHs;
        String username;

        private a() {
        }

        /* synthetic */ a(m mVar, byte b) {
            this();
        }
    }

    public m() {
        AppMethodBeat.i(54073);
        AppMethodBeat.o(54073);
    }

    public final synchronized boolean a(MultiTalkVideoView multiTalkVideoView, int[] iArr, int i, int i2, int i3) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(54074);
            if (iArr == null) {
                ab.e("MicroMsg.MT.MultiTalkViewManager", "renderVideoBitmap img is null");
                AppMethodBeat.o(54074);
            } else if (iArr.length < i * i2) {
                ab.e("MicroMsg.MT.MultiTalkViewManager", "img length error %d %d", Integer.valueOf(iArr.length), Integer.valueOf(i * i2));
                AppMethodBeat.o(54074);
            } else if (i != i2) {
                ab.e("MicroMsg.MT.MultiTalkViewManager", "imgW != imgH");
                AppMethodBeat.o(54074);
            } else {
                a aVar;
                a aVar2 = (a) this.oHq.get(multiTalkVideoView.getUsername());
                if (aVar2 == null) {
                    aVar2 = new a(this, (byte) 0);
                    this.oHq.put(multiTalkVideoView.getUsername(), aVar2);
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
                aVar.oHb = 0;
                aVar.angle = i3;
                if (aVar.oHs == null || aVar.oHs.getWidth() != i2) {
                    aVar.oHs = Bitmap.createBitmap(i2, i2, Config.ARGB_8888);
                }
                aVar.oHs.setPixels(iArr, 0, i2, 0, 0, i2, i2);
                multiTalkVideoView.d(aVar.oHs, aVar.angle, aVar.oHb);
                AppMethodBeat.o(54074);
                z = true;
            }
        }
        return z;
    }

    public final boolean a(MultiTalkVideoView multiTalkVideoView, boolean z) {
        a aVar;
        AppMethodBeat.i(54075);
        if (this.oHq.containsKey(multiTalkVideoView.getUsername())) {
            aVar = (a) this.oHq.get(multiTalkVideoView.getUsername());
        } else {
            aVar = new a(this, (byte) 0);
            aVar.username = multiTalkVideoView.getUsername();
            this.oHq.put(multiTalkVideoView.getUsername(), aVar);
        }
        Bitmap b;
        if (aVar.gFP == null) {
            b = b.diS().b(multiTalkVideoView.getUsername(), multiTalkVideoView.getMeasuredWidth(), multiTalkVideoView.getMeasuredHeight(), 1);
            if (b != null && b.getHeight() < b.getWidth()) {
                b = Bitmap.createBitmap(b, 0, 0, b.getHeight(), b.getHeight());
            }
            aVar.gFP = b;
        } else if (z) {
            b = b.diS().b(multiTalkVideoView.getUsername(), multiTalkVideoView.getMeasuredWidth(), multiTalkVideoView.getMeasuredHeight(), 1);
            if (b != null && b.getHeight() < b.getWidth()) {
                b = Bitmap.createBitmap(b, 0, 0, b.getHeight(), b.getHeight());
            }
            aVar.gFP = b;
        }
        if (aVar.gFP != null) {
            multiTalkVideoView.d(aVar.gFP, 0, 0);
            AppMethodBeat.o(54075);
        } else {
            if (aVar.oHr == null) {
                aVar.oHr = BitmapFactory.decodeResource(multiTalkVideoView.getResources(), R.drawable.bch);
            }
            multiTalkVideoView.d(aVar.oHr, 0, 0);
            AppMethodBeat.o(54075);
        }
        return true;
    }

    public final void bRZ() {
        AppMethodBeat.i(54076);
        this.oHq.clear();
        AppMethodBeat.o(54076);
    }
}
