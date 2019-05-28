package com.tencent.p177mm.plugin.appbrand.game.p294d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.support.p069v7.widget.AppCompatTextView;
import com.tencent.magicbrush.C1000a.C1001a;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.MBRuntime.MBParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.game.p291a.C10229e;
import com.tencent.p177mm.plugin.appbrand.report.quality.C19704i;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.tencent.mm.plugin.appbrand.game.d.c */
public final class C38219c extends AppCompatTextView {
    private MBRuntime bSv;
    StringBuilder bot = new StringBuilder(100);
    C7564ap gyS = new C7564ap(Looper.getMainLooper(), new C268851(), true);
    private double hrF = 60.0d;

    /* renamed from: com.tencent.mm.plugin.appbrand.game.d.c$1 */
    class C268851 implements C5015a {
        C268851() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(130171);
            if (C38219c.this.bSv == null) {
                AppMethodBeat.m2505o(130171);
            } else {
                C1001a currentFps = C38219c.this.bSv.getCurrentFps();
                C38219c.this.hrF = Math.min(C38219c.this.hrF, (double) currentFps.bSi);
                MBParams params = C38219c.this.bSv.getParams();
                C38219c c38219c = C38219c.this;
                double d = (double) currentFps.bSi;
                double b = C38219c.this.hrF;
                double d2 = (double) currentFps.bSj;
                String str = "";
                boolean z = params.use_command_buffer;
                c38219c.bot.setLength(0);
                c38219c.bot.append("MinFPS[").append(Math.round(b)).append("] RT-FPS[").append(Math.round(d)).append("] EX-FPS[").append(Math.round(d2)).append("]");
                if (C5058f.DEBUG && ((Boolean) C10229e.m17879Aq("showmemory").mo21639Uw()).booleanValue()) {
                    StringBuilder append = c38219c.bot.append(" MEMORY[");
                    C19704i c19704i = C19704i.iCT;
                    append.append(C19704i.aLB().iCV).append("]");
                }
                if (C5058f.DEBUG) {
                    c38219c.bot.append(str).append(" ").append(z ? "CommandBuffer" : "");
                }
                c38219c.setText(c38219c.bot);
                AppMethodBeat.m2505o(130171);
            }
            return true;
        }
    }

    public C38219c(Context context, MBRuntime mBRuntime) {
        super(context);
        AppMethodBeat.m2504i(130172);
        setTextSize(12.0f);
        setTextColor(-65536);
        setFocusable(false);
        setClickable(false);
        setOnClickListener(null);
        this.bSv = mBRuntime;
        this.gyS.mo16770ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.m2505o(130172);
    }
}
