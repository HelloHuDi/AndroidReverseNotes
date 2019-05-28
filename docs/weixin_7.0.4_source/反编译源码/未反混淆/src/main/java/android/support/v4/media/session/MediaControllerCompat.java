package android.support.v4.media.session;

import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class MediaControllerCompat {
    final b Jj;
    private final Token Jk;
    private final HashSet<a> Jl = new HashSet();

    public static abstract class a implements DeathRecipient {
        private final Object Jm;
        a Jn;
        boolean Jo;

        class a extends Handler {
            boolean Jp;

            public final void handleMessage(Message message) {
                if (this.Jp) {
                    Object obj;
                    switch (message.what) {
                        case 1:
                            obj = message.obj;
                            message.getData();
                            return;
                        case 2:
                            obj = message.obj;
                            return;
                        case 3:
                            obj = message.obj;
                            return;
                        case 4:
                            obj = message.obj;
                            return;
                        case 5:
                            obj = message.obj;
                            return;
                        case 6:
                            obj = message.obj;
                            return;
                        case 7:
                            obj = message.obj;
                            return;
                        case 9:
                            ((Integer) message.obj).intValue();
                            return;
                        case 11:
                            ((Boolean) message.obj).booleanValue();
                            return;
                        case 12:
                            ((Integer) message.obj).intValue();
                            return;
                        default:
                            return;
                    }
                }
            }
        }

        static class b implements android.support.v4.media.session.c.a {
            private final WeakReference<a> Jq;

            b(a aVar) {
                this.Jq = new WeakReference(aVar);
            }

            public final void onSessionDestroyed() {
                this.Jq.get();
            }

            public final void ea() {
                a aVar = (a) this.Jq.get();
                if (aVar != null && aVar.Jo) {
                    int i = VERSION.SDK_INT;
                }
            }

            public final void x(Object obj) {
                a aVar = (a) this.Jq.get();
                if (aVar != null && !aVar.Jo) {
                    PlaybackStateCompat.B(obj);
                }
            }

            public final void y(Object obj) {
                if (((a) this.Jq.get()) != null) {
                    MediaMetadataCompat.w(obj);
                }
            }

            public final void onQueueChanged(List<?> list) {
                if (((a) this.Jq.get()) != null) {
                    QueueItem.m(list);
                }
            }

            public final void eb() {
                this.Jq.get();
            }

            public final void ec() {
                this.Jq.get();
            }

            public final void c(int i, int i2, int i3, int i4, int i5) {
                if (((a) this.Jq.get()) != null) {
                    f fVar = new f(i, i2, i3, i4, i5);
                }
            }
        }

        static class c extends android.support.v4.media.session.a.a {
            private final WeakReference<a> Jq;

            c(a aVar) {
                this.Jq = new WeakReference(aVar);
            }

            public final void d(String str, Bundle bundle) {
                a aVar = (a) this.Jq.get();
                if (aVar != null) {
                    aVar.a(1, str, bundle);
                }
            }

            public void onSessionDestroyed() {
                a aVar = (a) this.Jq.get();
                if (aVar != null) {
                    aVar.a(8, null, null);
                }
            }

            public final void a(PlaybackStateCompat playbackStateCompat) {
                a aVar = (a) this.Jq.get();
                if (aVar != null) {
                    aVar.a(2, playbackStateCompat, null);
                }
            }

            public void a(MediaMetadataCompat mediaMetadataCompat) {
                a aVar = (a) this.Jq.get();
                if (aVar != null) {
                    aVar.a(3, mediaMetadataCompat, null);
                }
            }

            public void onQueueChanged(List<QueueItem> list) {
                a aVar = (a) this.Jq.get();
                if (aVar != null) {
                    aVar.a(5, list, null);
                }
            }

            public void onQueueTitleChanged(CharSequence charSequence) {
                a aVar = (a) this.Jq.get();
                if (aVar != null) {
                    aVar.a(6, charSequence, null);
                }
            }

            public final void B(boolean z) {
                a aVar = (a) this.Jq.get();
                if (aVar != null) {
                    aVar.a(11, Boolean.valueOf(z), null);
                }
            }

            public final void aw(int i) {
                a aVar = (a) this.Jq.get();
                if (aVar != null) {
                    aVar.a(9, Integer.valueOf(i), null);
                }
            }

            public final void A(boolean z) {
            }

            public final void ax(int i) {
                a aVar = (a) this.Jq.get();
                if (aVar != null) {
                    aVar.a(12, Integer.valueOf(i), null);
                }
            }

            public void onExtrasChanged(Bundle bundle) {
                a aVar = (a) this.Jq.get();
                if (aVar != null) {
                    aVar.a(7, bundle, null);
                }
            }

            public void a(ParcelableVolumeInfo parcelableVolumeInfo) {
                a aVar = (a) this.Jq.get();
                if (aVar != null) {
                    Object fVar;
                    if (parcelableVolumeInfo != null) {
                        fVar = new f(parcelableVolumeInfo.JH, parcelableVolumeInfo.JI, parcelableVolumeInfo.JJ, parcelableVolumeInfo.JK, parcelableVolumeInfo.JL);
                    } else {
                        fVar = null;
                    }
                    aVar.a(4, fVar, null);
                }
            }

            public final void dP() {
                a aVar = (a) this.Jq.get();
                if (aVar != null) {
                    aVar.a(13, null, null);
                }
            }
        }

        public a() {
            if (VERSION.SDK_INT >= 21) {
                this.Jm = new b(new b(this));
            } else {
                this.Jm = new c(this);
            }
        }

        /* Access modifiers changed, original: final */
        public final void a(int i, Object obj, Bundle bundle) {
            if (this.Jn != null) {
                Message obtainMessage = this.Jn.obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }
    }

    static class c extends MediaControllerImplApi21 {
        public c(Context context, Token token) {
            super(context, token);
        }
    }

    interface b {
        boolean dispatchMediaButtonEvent(KeyEvent keyEvent);
    }

    static class MediaControllerImplApi21 implements b {
        protected final Object Jr;
        final List<a> Js = new ArrayList();
        b Jt;
        HashMap<a, a> Ju = new HashMap();

        static class a extends c {
            a(a aVar) {
                super(aVar);
            }

            public final void onSessionDestroyed() {
                throw new AssertionError();
            }

            public final void a(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }

            public final void onQueueChanged(List<QueueItem> list) {
                throw new AssertionError();
            }

            public final void onQueueTitleChanged(CharSequence charSequence) {
                throw new AssertionError();
            }

            public final void onExtrasChanged(Bundle bundle) {
                throw new AssertionError();
            }

            public final void a(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }
        }

        static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            private WeakReference<MediaControllerImplApi21> Jv;

            public ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21, Handler handler) {
                super(handler);
                this.Jv = new WeakReference(mediaControllerImplApi21);
            }

            /* Access modifiers changed, original: protected */
            public void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.Jv.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    mediaControllerImplApi21.Jt = android.support.v4.media.session.b.a.d(android.support.v4.app.e.c(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
                    if (mediaControllerImplApi21.Jt != null) {
                        synchronized (mediaControllerImplApi21.Js) {
                            for (a aVar : mediaControllerImplApi21.Js) {
                                a aVar2 = new a(aVar);
                                mediaControllerImplApi21.Ju.put(aVar, aVar2);
                                aVar.Jo = true;
                                try {
                                    mediaControllerImplApi21.Jt.a(aVar2);
                                } catch (RemoteException e) {
                                }
                            }
                            mediaControllerImplApi21.Js.clear();
                        }
                    }
                }
            }
        }

        public MediaControllerImplApi21(Context context, Token token) {
            this.Jr = new MediaController(context, (MediaSession.Token) token.JG);
            if (this.Jr == null) {
                throw new RemoteException();
            }
            this.Jt = token.Jt;
            if (this.Jt == null) {
                ExtraBinderRequestResultReceiver extraBinderRequestResultReceiver = new ExtraBinderRequestResultReceiver(this, new Handler());
                ((MediaController) this.Jr).sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, extraBinderRequestResultReceiver);
            }
        }

        public final boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            return ((MediaController) this.Jr).dispatchMediaButtonEvent(keyEvent);
        }
    }

    static class e implements b {
        private b Jw;

        public e(Token token) {
            this.Jw = android.support.v4.media.session.b.a.d((IBinder) token.JG);
        }

        public final boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            if (keyEvent == null) {
                throw new IllegalArgumentException("event may not be null.");
            }
            try {
                this.Jw.a(keyEvent);
            } catch (RemoteException e) {
            }
            return false;
        }
    }

    public static final class f {
        private final int JA;
        private final int JB;
        private final int Jx;
        private final int Jy;
        private final int Jz;

        f(int i, int i2, int i3, int i4, int i5) {
            this.Jx = i;
            this.Jy = i2;
            this.Jz = i3;
            this.JA = i4;
            this.JB = i5;
        }
    }

    static class d extends c {
        public d(Context context, Token token) {
            super(context, token);
        }
    }

    public MediaControllerCompat(Context context, Token token) {
        if (token == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        this.Jk = token;
        if (VERSION.SDK_INT >= 24) {
            this.Jj = new d(context, token);
        } else if (VERSION.SDK_INT >= 23) {
            this.Jj = new c(context, token);
        } else if (VERSION.SDK_INT >= 21) {
            this.Jj = new MediaControllerImplApi21(context, token);
        } else {
            this.Jj = new e(this.Jk);
        }
    }
}
