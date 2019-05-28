package com.tencent.mm.plugin.appbrand.game.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.support.v7.widget.AppCompatTextView;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.MBRuntime.MBParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.a.e;
import com.tencent.mm.plugin.appbrand.report.quality.i;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

@SuppressLint({"ViewConstructor"})
public final class c extends AppCompatTextView {
    private MBRuntime bSv;
    StringBuilder bot = new StringBuilder(100);
    ap gyS = new ap(Looper.getMainLooper(), new a() {
        public final boolean BI() {
            AppMethodBeat.i(130171);
            if (c.this.bSv == null) {
                AppMethodBeat.o(130171);
            } else {
                com.tencent.magicbrush.a.a currentFps = c.this.bSv.getCurrentFps();
                c.this.hrF = Math.min(c.this.hrF, (double) currentFps.bSi);
                MBParams params = c.this.bSv.getParams();
                c cVar = c.this;
                double d = (double) currentFps.bSi;
                double b = c.this.hrF;
                double d2 = (double) currentFps.bSj;
                String str = "";
                boolean z = params.use_command_buffer;
                cVar.bot.setLength(0);
                cVar.bot.append("MinFPS[").append(Math.round(b)).append("] RT-FPS[").append(Math.round(d)).append("] EX-FPS[").append(Math.round(d2)).append("]");
                if (f.DEBUG && ((Boolean) e.Aq("showmemory").Uw()).booleanValue()) {
                    StringBuilder append = cVar.bot.append(" MEMORY[");
                    i iVar = i.iCT;
                    append.append(i.aLB().iCV).append("]");
                }
                if (f.DEBUG) {
                    cVar.bot.append(str).append(" ").append(z ? "CommandBuffer" : "");
                }
                cVar.setText(cVar.bot);
                AppMethodBeat.o(130171);
            }
            return true;
        }
    }, true);
    private double hrF = 60.0d;

    public c(Context context, MBRuntime mBRuntime) {
        super(context);
        AppMethodBeat.i(130172);
        setTextSize(12.0f);
        setTextColor(-65536);
        setFocusable(false);
        setClickable(false);
        setOnClickListener(null);
        this.bSv = mBRuntime;
        this.gyS.ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.o(130172);
    }
}
