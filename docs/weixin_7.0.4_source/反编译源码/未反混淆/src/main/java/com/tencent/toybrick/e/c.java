package com.tencent.toybrick.e;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ai;
import com.tencent.toybrick.c.f;
import java.lang.ref.WeakReference;

public final class c {
    public static volatile c AHh = new c();
    private Handler mMainHandler = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(113234);
            super.handleMessage(message);
            if (message.what == 2) {
                c cVar = (c) message.obj;
                com.tencent.toybrick.f.a aVar = (com.tencent.toybrick.f.a) cVar.AHk.get();
                if (aVar == null || aVar.AHp.hashCode() != cVar.key) {
                    ai.w("WhenHandler", "[WhenHandler] has loaded! but not right,holder has changed!", new Object[0]);
                    AppMethodBeat.o(113234);
                    return;
                }
                cVar.AHm.H(aVar, cVar.object);
                AppMethodBeat.o(113234);
                return;
            }
            if (message.what == 3) {
                d dVar = (d) message.obj;
                dVar.AHo.d(dVar.AHn.get(), ((Boolean) dVar.object).booleanValue());
            }
            AppMethodBeat.o(113234);
        }
    };

    public interface a<H, T> {
        void H(H h, T t);
    }

    class c implements Runnable {
        private WeakReference<com.tencent.toybrick.f.a> AHk;
        private WeakReference<com.tencent.toybrick.g.b> AHl;
        private a AHm;
        private int key;
        private Object object;

        public c(com.tencent.toybrick.f.a aVar, com.tencent.toybrick.g.b bVar, a aVar2, int i) {
            AppMethodBeat.i(113236);
            this.AHk = new WeakReference(aVar);
            this.AHl = new WeakReference(bVar);
            this.AHm = aVar2;
            this.key = i;
            AppMethodBeat.o(113236);
        }

        public final void run() {
            AppMethodBeat.i(113237);
            com.tencent.toybrick.g.b bVar = (com.tencent.toybrick.g.b) this.AHl.get();
            if (!(((com.tencent.toybrick.f.a) this.AHk.get()) == null || bVar == null)) {
                this.object = bVar.dSA();
                Message message = new Message();
                message.what = 2;
                message.obj = this;
                c.this.mMainHandler.sendMessage(message);
            }
            AppMethodBeat.o(113237);
        }
    }

    public interface b<T> {
        void d(T t, boolean z);
    }

    public class d implements Runnable {
        private WeakReference<com.tencent.toybrick.g.b> AHl;
        private WeakReference<f> AHn;
        private b AHo;
        private Object object;

        public d(f fVar, com.tencent.toybrick.g.b bVar, b bVar2) {
            AppMethodBeat.i(113238);
            this.AHn = new WeakReference(fVar);
            this.AHl = new WeakReference(bVar);
            this.AHo = bVar2;
            AppMethodBeat.o(113238);
        }

        public final void run() {
            AppMethodBeat.i(113239);
            com.tencent.toybrick.g.b bVar = (com.tencent.toybrick.g.b) this.AHl.get();
            f fVar = (f) this.AHn.get();
            if (!(bVar == null || fVar == null)) {
                this.object = bVar.dSA();
                Message message = new Message();
                message.what = 3;
                message.obj = this;
                c.this.mMainHandler.sendMessage(message);
            }
            AppMethodBeat.o(113239);
        }
    }

    static {
        AppMethodBeat.i(113244);
        AppMethodBeat.o(113244);
    }

    private c() {
        AppMethodBeat.i(113240);
        AppMethodBeat.o(113240);
    }

    public final void a(com.tencent.toybrick.f.a aVar, com.tencent.toybrick.g.b bVar, a aVar2) {
        AppMethodBeat.i(113241);
        a.dSz().execute(new c(aVar, bVar, aVar2, aVar.AHp.hashCode()));
        AppMethodBeat.o(113241);
    }

    public final void a(com.tencent.toybrick.f.a aVar, com.tencent.toybrick.g.b bVar, ImageView imageView) {
        AppMethodBeat.i(113242);
        final WeakReference weakReference = new WeakReference(imageView);
        a.dSz().execute(new c(aVar, bVar, new a<com.tencent.toybrick.f.a, Drawable>() {
            public final /* synthetic */ void H(Object obj, Object obj2) {
                AppMethodBeat.i(113235);
                Drawable drawable = (Drawable) obj2;
                ImageView imageView;
                if (drawable != null) {
                    imageView = (ImageView) weakReference.get();
                    if (imageView != null) {
                        imageView.setVisibility(0);
                        imageView.setImageDrawable(drawable);
                    }
                    AppMethodBeat.o(113235);
                    return;
                }
                imageView = (ImageView) weakReference.get();
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                AppMethodBeat.o(113235);
            }
        }, aVar.AHp.hashCode()));
        AppMethodBeat.o(113242);
    }

    public static void execute(Runnable runnable) {
        AppMethodBeat.i(139031);
        a.dSz().execute(runnable);
        AppMethodBeat.o(139031);
    }
}
