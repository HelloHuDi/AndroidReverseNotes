package com.tencent.p177mm.plugin.multitalk.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.multitalk.p459ui.widget.MultiTalkVideoView;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.multitalk.model.m */
public final class C3516m {
    public volatile Map<String, C3517a> oHq = Collections.synchronizedMap(new HashMap());

    /* renamed from: com.tencent.mm.plugin.multitalk.model.m$a */
    public class C3517a {
        public int angle;
        Bitmap gFP;
        public int oHb;
        Bitmap oHr;
        public Bitmap oHs;
        String username;

        private C3517a() {
        }

        /* synthetic */ C3517a(C3516m c3516m, byte b) {
            this();
        }
    }

    public C3516m() {
        AppMethodBeat.m2504i(54073);
        AppMethodBeat.m2505o(54073);
    }

    /* renamed from: a */
    public final synchronized boolean mo8003a(MultiTalkVideoView multiTalkVideoView, int[] iArr, int i, int i2, int i3) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(54074);
            if (iArr == null) {
                C4990ab.m7412e("MicroMsg.MT.MultiTalkViewManager", "renderVideoBitmap img is null");
                AppMethodBeat.m2505o(54074);
            } else if (iArr.length < i * i2) {
                C4990ab.m7413e("MicroMsg.MT.MultiTalkViewManager", "img length error %d %d", Integer.valueOf(iArr.length), Integer.valueOf(i * i2));
                AppMethodBeat.m2505o(54074);
            } else if (i != i2) {
                C4990ab.m7412e("MicroMsg.MT.MultiTalkViewManager", "imgW != imgH");
                AppMethodBeat.m2505o(54074);
            } else {
                C3517a c3517a;
                C3517a c3517a2 = (C3517a) this.oHq.get(multiTalkVideoView.getUsername());
                if (c3517a2 == null) {
                    c3517a2 = new C3517a(this, (byte) 0);
                    this.oHq.put(multiTalkVideoView.getUsername(), c3517a2);
                    c3517a = c3517a2;
                } else {
                    c3517a = c3517a2;
                }
                c3517a.oHb = 0;
                c3517a.angle = i3;
                if (c3517a.oHs == null || c3517a.oHs.getWidth() != i2) {
                    c3517a.oHs = Bitmap.createBitmap(i2, i2, Config.ARGB_8888);
                }
                c3517a.oHs.setPixels(iArr, 0, i2, 0, 0, i2, i2);
                multiTalkVideoView.mo41665d(c3517a.oHs, c3517a.angle, c3517a.oHb);
                AppMethodBeat.m2505o(54074);
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    public final boolean mo8002a(MultiTalkVideoView multiTalkVideoView, boolean z) {
        C3517a c3517a;
        AppMethodBeat.m2504i(54075);
        if (this.oHq.containsKey(multiTalkVideoView.getUsername())) {
            c3517a = (C3517a) this.oHq.get(multiTalkVideoView.getUsername());
        } else {
            c3517a = new C3517a(this, (byte) 0);
            c3517a.username = multiTalkVideoView.getUsername();
            this.oHq.put(multiTalkVideoView.getUsername(), c3517a);
        }
        Bitmap b;
        if (c3517a.gFP == null) {
            b = C40460b.diS().mo8231b(multiTalkVideoView.getUsername(), multiTalkVideoView.getMeasuredWidth(), multiTalkVideoView.getMeasuredHeight(), 1);
            if (b != null && b.getHeight() < b.getWidth()) {
                b = Bitmap.createBitmap(b, 0, 0, b.getHeight(), b.getHeight());
            }
            c3517a.gFP = b;
        } else if (z) {
            b = C40460b.diS().mo8231b(multiTalkVideoView.getUsername(), multiTalkVideoView.getMeasuredWidth(), multiTalkVideoView.getMeasuredHeight(), 1);
            if (b != null && b.getHeight() < b.getWidth()) {
                b = Bitmap.createBitmap(b, 0, 0, b.getHeight(), b.getHeight());
            }
            c3517a.gFP = b;
        }
        if (c3517a.gFP != null) {
            multiTalkVideoView.mo41665d(c3517a.gFP, 0, 0);
            AppMethodBeat.m2505o(54075);
        } else {
            if (c3517a.oHr == null) {
                c3517a.oHr = BitmapFactory.decodeResource(multiTalkVideoView.getResources(), C25738R.drawable.bch);
            }
            multiTalkVideoView.mo41665d(c3517a.oHr, 0, 0);
            AppMethodBeat.m2505o(54075);
        }
        return true;
    }

    public final void bRZ() {
        AppMethodBeat.m2504i(54076);
        this.oHq.clear();
        AppMethodBeat.m2505o(54076);
    }
}
