package android.support.p057v4.media.session;

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
import android.support.p057v4.app.C8377e;
import android.support.p057v4.media.MediaMetadataCompat;
import android.support.p057v4.media.session.C0426c.C0427a;
import android.support.p057v4.media.session.C0426c.C0428b;
import android.support.p057v4.media.session.C25360b.C0424a;
import android.support.p057v4.media.session.C37126a.C0422a;
import android.support.p057v4.media.session.MediaSessionCompat.QueueItem;
import android.support.p057v4.media.session.MediaSessionCompat.Token;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* renamed from: android.support.v4.media.session.MediaControllerCompat */
public final class MediaControllerCompat {
    /* renamed from: Jj */
    final C8405b f2379Jj;
    /* renamed from: Jk */
    private final Token f2380Jk;
    /* renamed from: Jl */
    private final HashSet<C8400a> f2381Jl = new HashSet();

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$a */
    public static abstract class C8400a implements DeathRecipient {
        /* renamed from: Jm */
        private final Object f2373Jm;
        /* renamed from: Jn */
        C8401a f2374Jn;
        /* renamed from: Jo */
        boolean f2375Jo;

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$a */
        class C8401a extends Handler {
            /* renamed from: Jp */
            boolean f2376Jp;

            public final void handleMessage(Message message) {
                if (this.f2376Jp) {
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

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$b */
        static class C8402b implements C0427a {
            /* renamed from: Jq */
            private final WeakReference<C8400a> f2377Jq;

            C8402b(C8400a c8400a) {
                this.f2377Jq = new WeakReference(c8400a);
            }

            public final void onSessionDestroyed() {
                this.f2377Jq.get();
            }

            /* renamed from: ea */
            public final void mo934ea() {
                C8400a c8400a = (C8400a) this.f2377Jq.get();
                if (c8400a != null && c8400a.f2375Jo) {
                    int i = VERSION.SDK_INT;
                }
            }

            /* renamed from: x */
            public final void mo939x(Object obj) {
                C8400a c8400a = (C8400a) this.f2377Jq.get();
                if (c8400a != null && !c8400a.f2375Jo) {
                    PlaybackStateCompat.m39994B(obj);
                }
            }

            /* renamed from: y */
            public final void mo940y(Object obj) {
                if (((C8400a) this.f2377Jq.get()) != null) {
                    MediaMetadataCompat.m27082w(obj);
                }
            }

            public final void onQueueChanged(List<?> list) {
                if (((C8400a) this.f2377Jq.get()) != null) {
                    QueueItem.m14828m(list);
                }
            }

            /* renamed from: eb */
            public final void mo935eb() {
                this.f2377Jq.get();
            }

            /* renamed from: ec */
            public final void mo936ec() {
                this.f2377Jq.get();
            }

            /* renamed from: c */
            public final void mo933c(int i, int i2, int i3, int i4, int i5) {
                if (((C8400a) this.f2377Jq.get()) != null) {
                    C8408f c8408f = new C8408f(i, i2, i3, i4, i5);
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$c */
        static class C8403c extends C0422a {
            /* renamed from: Jq */
            private final WeakReference<C8400a> f2378Jq;

            C8403c(C8400a c8400a) {
                this.f2378Jq = new WeakReference(c8400a);
            }

            /* renamed from: d */
            public final void mo876d(String str, Bundle bundle) {
                C8400a c8400a = (C8400a) this.f2378Jq.get();
                if (c8400a != null) {
                    c8400a.mo18351a(1, str, bundle);
                }
            }

            public void onSessionDestroyed() {
                C8400a c8400a = (C8400a) this.f2378Jq.get();
                if (c8400a != null) {
                    c8400a.mo18351a(8, null, null);
                }
            }

            /* renamed from: a */
            public final void mo872a(PlaybackStateCompat playbackStateCompat) {
                C8400a c8400a = (C8400a) this.f2378Jq.get();
                if (c8400a != null) {
                    c8400a.mo18351a(2, playbackStateCompat, null);
                }
            }

            /* renamed from: a */
            public void mo870a(MediaMetadataCompat mediaMetadataCompat) {
                C8400a c8400a = (C8400a) this.f2378Jq.get();
                if (c8400a != null) {
                    c8400a.mo18351a(3, mediaMetadataCompat, null);
                }
            }

            public void onQueueChanged(List<QueueItem> list) {
                C8400a c8400a = (C8400a) this.f2378Jq.get();
                if (c8400a != null) {
                    c8400a.mo18351a(5, list, null);
                }
            }

            public void onQueueTitleChanged(CharSequence charSequence) {
                C8400a c8400a = (C8400a) this.f2378Jq.get();
                if (c8400a != null) {
                    c8400a.mo18351a(6, charSequence, null);
                }
            }

            /* renamed from: B */
            public final void mo869B(boolean z) {
                C8400a c8400a = (C8400a) this.f2378Jq.get();
                if (c8400a != null) {
                    c8400a.mo18351a(11, Boolean.valueOf(z), null);
                }
            }

            /* renamed from: aw */
            public final void mo874aw(int i) {
                C8400a c8400a = (C8400a) this.f2378Jq.get();
                if (c8400a != null) {
                    c8400a.mo18351a(9, Integer.valueOf(i), null);
                }
            }

            /* renamed from: A */
            public final void mo868A(boolean z) {
            }

            /* renamed from: ax */
            public final void mo875ax(int i) {
                C8400a c8400a = (C8400a) this.f2378Jq.get();
                if (c8400a != null) {
                    c8400a.mo18351a(12, Integer.valueOf(i), null);
                }
            }

            public void onExtrasChanged(Bundle bundle) {
                C8400a c8400a = (C8400a) this.f2378Jq.get();
                if (c8400a != null) {
                    c8400a.mo18351a(7, bundle, null);
                }
            }

            /* renamed from: a */
            public void mo871a(ParcelableVolumeInfo parcelableVolumeInfo) {
                C8400a c8400a = (C8400a) this.f2378Jq.get();
                if (c8400a != null) {
                    Object c8408f;
                    if (parcelableVolumeInfo != null) {
                        c8408f = new C8408f(parcelableVolumeInfo.f16824JH, parcelableVolumeInfo.f16825JI, parcelableVolumeInfo.f16826JJ, parcelableVolumeInfo.f16827JK, parcelableVolumeInfo.f16828JL);
                    } else {
                        c8408f = null;
                    }
                    c8400a.mo18351a(4, c8408f, null);
                }
            }

            /* renamed from: dP */
            public final void mo877dP() {
                C8400a c8400a = (C8400a) this.f2378Jq.get();
                if (c8400a != null) {
                    c8400a.mo18351a(13, null, null);
                }
            }
        }

        public C8400a() {
            if (VERSION.SDK_INT >= 21) {
                this.f2373Jm = new C0428b(new C8402b(this));
            } else {
                this.f2373Jm = new C8403c(this);
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final void mo18351a(int i, Object obj, Bundle bundle) {
            if (this.f2374Jn != null) {
                Message obtainMessage = this.f2374Jn.obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$c */
    static class C8404c extends MediaControllerImplApi21 {
        public C8404c(Context context, Token token) {
            super(context, token);
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$b */
    interface C8405b {
        boolean dispatchMediaButtonEvent(KeyEvent keyEvent);
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21 */
    static class MediaControllerImplApi21 implements C8405b {
        /* renamed from: Jr */
        protected final Object f2382Jr;
        /* renamed from: Js */
        final List<C8400a> f2383Js = new ArrayList();
        /* renamed from: Jt */
        C25360b f2384Jt;
        /* renamed from: Ju */
        HashMap<C8400a, C8406a> f2385Ju = new HashMap();

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$a */
        static class C8406a extends C8403c {
            C8406a(C8400a c8400a) {
                super(c8400a);
            }

            public final void onSessionDestroyed() {
                throw new AssertionError();
            }

            /* renamed from: a */
            public final void mo870a(MediaMetadataCompat mediaMetadataCompat) {
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

            /* renamed from: a */
            public final void mo871a(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver */
        static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            /* renamed from: Jv */
            private WeakReference<MediaControllerImplApi21> f2386Jv;

            public ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21, Handler handler) {
                super(handler);
                this.f2386Jv = new WeakReference(mediaControllerImplApi21);
            }

            /* Access modifiers changed, original: protected */
            public void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.f2386Jv.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    mediaControllerImplApi21.f2384Jt = C0424a.m730d(C8377e.m14783c(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
                    if (mediaControllerImplApi21.f2384Jt != null) {
                        synchronized (mediaControllerImplApi21.f2383Js) {
                            for (C8400a c8400a : mediaControllerImplApi21.f2383Js) {
                                C37126a c8406a = new C8406a(c8400a);
                                mediaControllerImplApi21.f2385Ju.put(c8400a, c8406a);
                                c8400a.f2375Jo = true;
                                try {
                                    mediaControllerImplApi21.f2384Jt.mo890a(c8406a);
                                } catch (RemoteException e) {
                                }
                            }
                            mediaControllerImplApi21.f2383Js.clear();
                        }
                    }
                }
            }
        }

        public MediaControllerImplApi21(Context context, Token token) {
            this.f2382Jr = new MediaController(context, (MediaSession.Token) token.f3922JG);
            if (this.f2382Jr == null) {
                throw new RemoteException();
            }
            this.f2384Jt = token.f3923Jt;
            if (this.f2384Jt == null) {
                ExtraBinderRequestResultReceiver extraBinderRequestResultReceiver = new ExtraBinderRequestResultReceiver(this, new Handler());
                ((MediaController) this.f2382Jr).sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, extraBinderRequestResultReceiver);
            }
        }

        public final boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            return ((MediaController) this.f2382Jr).dispatchMediaButtonEvent(keyEvent);
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$e */
    static class C8407e implements C8405b {
        /* renamed from: Jw */
        private C25360b f2387Jw;

        public C8407e(Token token) {
            this.f2387Jw = C0424a.m730d((IBinder) token.f3922JG);
        }

        public final boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            if (keyEvent == null) {
                throw new IllegalArgumentException("event may not be null.");
            }
            try {
                this.f2387Jw.mo892a(keyEvent);
            } catch (RemoteException e) {
            }
            return false;
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$f */
    public static final class C8408f {
        /* renamed from: JA */
        private final int f2388JA;
        /* renamed from: JB */
        private final int f2389JB;
        /* renamed from: Jx */
        private final int f2390Jx;
        /* renamed from: Jy */
        private final int f2391Jy;
        /* renamed from: Jz */
        private final int f2392Jz;

        C8408f(int i, int i2, int i3, int i4, int i5) {
            this.f2390Jx = i;
            this.f2391Jy = i2;
            this.f2392Jz = i3;
            this.f2388JA = i4;
            this.f2389JB = i5;
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$d */
    static class C8409d extends C8404c {
        public C8409d(Context context, Token token) {
            super(context, token);
        }
    }

    public MediaControllerCompat(Context context, Token token) {
        if (token == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        this.f2380Jk = token;
        if (VERSION.SDK_INT >= 24) {
            this.f2379Jj = new C8409d(context, token);
        } else if (VERSION.SDK_INT >= 23) {
            this.f2379Jj = new C8404c(context, token);
        } else if (VERSION.SDK_INT >= 21) {
            this.f2379Jj = new MediaControllerImplApi21(context, token);
        } else {
            this.f2379Jj = new C8407e(this.f2380Jk);
        }
    }
}
