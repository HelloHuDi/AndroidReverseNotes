package com.tencent.toybrick.p682e;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5227ai;
import com.tencent.toybrick.p1113g.C46821b;
import com.tencent.toybrick.p1578f.C41100a;
import com.tencent.toybrick.p680c.C44559f;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.toybrick.e.c */
public final class C41097c {
    public static volatile C41097c AHh = new C41097c();
    private Handler mMainHandler = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(113234);
            super.handleMessage(message);
            if (message.what == 2) {
                C41096c c41096c = (C41096c) message.obj;
                C41100a c41100a = (C41100a) c41096c.AHk.get();
                if (c41100a == null || c41100a.AHp.hashCode() != c41096c.key) {
                    C5227ai.m7975w("WhenHandler", "[WhenHandler] has loaded! but not right,holder has changed!", new Object[0]);
                    AppMethodBeat.m2505o(113234);
                    return;
                }
                c41096c.AHm.mo40855H(c41100a, c41096c.object);
                AppMethodBeat.m2505o(113234);
                return;
            }
            if (message.what == 3) {
                C41099d c41099d = (C41099d) message.obj;
                c41099d.AHo.mo40854d(c41099d.AHn.get(), ((Boolean) c41099d.object).booleanValue());
            }
            AppMethodBeat.m2505o(113234);
        }
    };

    /* renamed from: com.tencent.toybrick.e.c$a */
    public interface C41095a<H, T> {
        /* renamed from: H */
        void mo40855H(H h, T t);
    }

    /* renamed from: com.tencent.toybrick.e.c$c */
    class C41096c implements Runnable {
        private WeakReference<C41100a> AHk;
        private WeakReference<C46821b> AHl;
        private C41095a AHm;
        private int key;
        private Object object;

        public C41096c(C41100a c41100a, C46821b c46821b, C41095a c41095a, int i) {
            AppMethodBeat.m2504i(113236);
            this.AHk = new WeakReference(c41100a);
            this.AHl = new WeakReference(c46821b);
            this.AHm = c41095a;
            this.key = i;
            AppMethodBeat.m2505o(113236);
        }

        public final void run() {
            AppMethodBeat.m2504i(113237);
            C46821b c46821b = (C46821b) this.AHl.get();
            if (!(((C41100a) this.AHk.get()) == null || c46821b == null)) {
                this.object = c46821b.dSA();
                Message message = new Message();
                message.what = 2;
                message.obj = this;
                C41097c.this.mMainHandler.sendMessage(message);
            }
            AppMethodBeat.m2505o(113237);
        }
    }

    /* renamed from: com.tencent.toybrick.e.c$b */
    public interface C41098b<T> {
        /* renamed from: d */
        void mo40854d(T t, boolean z);
    }

    /* renamed from: com.tencent.toybrick.e.c$d */
    public class C41099d implements Runnable {
        private WeakReference<C46821b> AHl;
        private WeakReference<C44559f> AHn;
        private C41098b AHo;
        private Object object;

        public C41099d(C44559f c44559f, C46821b c46821b, C41098b c41098b) {
            AppMethodBeat.m2504i(113238);
            this.AHn = new WeakReference(c44559f);
            this.AHl = new WeakReference(c46821b);
            this.AHo = c41098b;
            AppMethodBeat.m2505o(113238);
        }

        public final void run() {
            AppMethodBeat.m2504i(113239);
            C46821b c46821b = (C46821b) this.AHl.get();
            C44559f c44559f = (C44559f) this.AHn.get();
            if (!(c46821b == null || c44559f == null)) {
                this.object = c46821b.dSA();
                Message message = new Message();
                message.what = 3;
                message.obj = this;
                C41097c.this.mMainHandler.sendMessage(message);
            }
            AppMethodBeat.m2505o(113239);
        }
    }

    static {
        AppMethodBeat.m2504i(113244);
        AppMethodBeat.m2505o(113244);
    }

    private C41097c() {
        AppMethodBeat.m2504i(113240);
        AppMethodBeat.m2505o(113240);
    }

    /* renamed from: a */
    public final void mo65241a(C41100a c41100a, C46821b c46821b, C41095a c41095a) {
        AppMethodBeat.m2504i(113241);
        C5972a.dSz().execute(new C41096c(c41100a, c46821b, c41095a, c41100a.AHp.hashCode()));
        AppMethodBeat.m2505o(113241);
    }

    /* renamed from: a */
    public final void mo65240a(C41100a c41100a, C46821b c46821b, ImageView imageView) {
        AppMethodBeat.m2504i(113242);
        final WeakReference weakReference = new WeakReference(imageView);
        C5972a.dSz().execute(new C41096c(c41100a, c46821b, new C41095a<C41100a, Drawable>() {
            /* renamed from: H */
            public final /* synthetic */ void mo40855H(Object obj, Object obj2) {
                AppMethodBeat.m2504i(113235);
                Drawable drawable = (Drawable) obj2;
                ImageView imageView;
                if (drawable != null) {
                    imageView = (ImageView) weakReference.get();
                    if (imageView != null) {
                        imageView.setVisibility(0);
                        imageView.setImageDrawable(drawable);
                    }
                    AppMethodBeat.m2505o(113235);
                    return;
                }
                imageView = (ImageView) weakReference.get();
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                AppMethodBeat.m2505o(113235);
            }
        }, c41100a.AHp.hashCode()));
        AppMethodBeat.m2505o(113242);
    }

    public static void execute(Runnable runnable) {
        AppMethodBeat.m2504i(139031);
        C5972a.dSz().execute(runnable);
        AppMethodBeat.m2505o(139031);
    }
}
