package android.support.p057v4.app;

import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioAttributes.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.widget.RemoteViews;
import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.app.v */
public final class C0363v {

    /* renamed from: android.support.v4.app.v$a */
    public static class C0357a {
        /* renamed from: EB */
        final C0320aa[] f356EB;
        /* renamed from: EC */
        final C0320aa[] f357EC;
        /* renamed from: ED */
        boolean f358ED;
        public PendingIntent actionIntent;
        public int icon;
        final Bundle mExtras;
        public CharSequence title;

        public C0357a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i, charSequence, pendingIntent, new Bundle());
        }

        private C0357a(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
            this.icon = i;
            this.title = C0358c.m587h(charSequence);
            this.actionIntent = pendingIntent;
            this.mExtras = bundle;
            this.f356EB = null;
            this.f357EC = null;
            this.f358ED = true;
        }
    }

    /* renamed from: android.support.v4.app.v$c */
    public static class C0358c {
        /* renamed from: EF */
        public ArrayList<C0357a> f359EF;
        /* renamed from: EG */
        CharSequence f360EG;
        /* renamed from: EH */
        CharSequence f361EH;
        /* renamed from: EI */
        public PendingIntent f362EI;
        /* renamed from: EJ */
        PendingIntent f363EJ;
        /* renamed from: EK */
        RemoteViews f364EK;
        /* renamed from: EL */
        public Bitmap f365EL;
        /* renamed from: EM */
        CharSequence f366EM;
        /* renamed from: EN */
        int f367EN;
        /* renamed from: EO */
        boolean f368EO;
        /* renamed from: EP */
        boolean f369EP;
        /* renamed from: ER */
        C0362f f370ER;
        /* renamed from: ES */
        CharSequence f371ES;
        /* renamed from: ET */
        CharSequence[] f372ET;
        /* renamed from: EU */
        int f373EU;
        /* renamed from: EV */
        int f374EV;
        /* renamed from: EW */
        boolean f375EW;
        /* renamed from: EX */
        String f376EX;
        /* renamed from: EY */
        boolean f377EY;
        /* renamed from: EZ */
        String f378EZ;
        /* renamed from: Fa */
        public boolean f379Fa;
        /* renamed from: Fb */
        boolean f380Fb;
        /* renamed from: Fc */
        boolean f381Fc;
        /* renamed from: Fd */
        public String f382Fd;
        /* renamed from: Fe */
        Notification f383Fe;
        /* renamed from: Ff */
        RemoteViews f384Ff;
        /* renamed from: Fg */
        RemoteViews f385Fg;
        /* renamed from: Fh */
        RemoteViews f386Fh;
        /* renamed from: Fi */
        int f387Fi;
        /* renamed from: Fj */
        String f388Fj;
        /* renamed from: Fk */
        int f389Fk;
        /* renamed from: Fl */
        Notification f390Fl;
        @Deprecated
        /* renamed from: Fm */
        public ArrayList<String> f391Fm;
        /* renamed from: iZ */
        int f392iZ;
        public String mChannelId;
        public int mColor;
        public Context mContext;
        Bundle mExtras;
        int mPriority;
        long mTimeout;

        public C0358c(Context context, String str) {
            this.f359EF = new ArrayList();
            this.f368EO = true;
            this.f379Fa = false;
            this.mColor = 0;
            this.f392iZ = 0;
            this.f387Fi = 0;
            this.f389Fk = 0;
            this.f390Fl = new Notification();
            this.mContext = context;
            this.mChannelId = str;
            this.f390Fl.when = System.currentTimeMillis();
            this.f390Fl.audioStreamType = -1;
            this.mPriority = 0;
            this.f391Fm = new ArrayList();
        }

        @Deprecated
        public C0358c(Context context) {
            this(context, null);
        }

        /* renamed from: j */
        public final C0358c mo626j(long j) {
            this.f390Fl.when = j;
            return this;
        }

        /* renamed from: as */
        public final C0358c mo616as(int i) {
            this.f390Fl.icon = i;
            return this;
        }

        /* renamed from: d */
        public final C0358c mo621d(CharSequence charSequence) {
            this.f360EG = C0358c.m587h(charSequence);
            return this;
        }

        /* renamed from: e */
        public final C0358c mo623e(CharSequence charSequence) {
            this.f361EH = C0358c.m587h(charSequence);
            return this;
        }

        /* renamed from: f */
        public final C0358c mo624f(CharSequence charSequence) {
            this.f371ES = C0358c.m587h(charSequence);
            return this;
        }

        /* renamed from: b */
        public final C0358c mo618b(int i, int i2, boolean z) {
            this.f373EU = i;
            this.f374EV = i2;
            this.f375EW = z;
            return this;
        }

        /* renamed from: a */
        public final C0358c mo614a(RemoteViews remoteViews) {
            this.f390Fl.contentView = remoteViews;
            return this;
        }

        /* renamed from: a */
        public final C0358c mo611a(PendingIntent pendingIntent) {
            this.f390Fl.deleteIntent = pendingIntent;
            return this;
        }

        /* renamed from: g */
        public final C0358c mo625g(CharSequence charSequence) {
            this.f390Fl.tickerText = C0358c.m587h(charSequence);
            return this;
        }

        /* renamed from: b */
        public final C0358c mo619b(Uri uri) {
            this.f390Fl.sound = uri;
            this.f390Fl.audioStreamType = -1;
            if (VERSION.SDK_INT >= 21) {
                this.f390Fl.audioAttributes = new Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        /* renamed from: a */
        public final C0358c mo615a(long[] jArr) {
            this.f390Fl.vibrate = jArr;
            return this;
        }

        /* renamed from: dt */
        public final C0358c mo622dt() {
            int i;
            int i2 = 1;
            this.f390Fl.ledARGB = -16711936;
            this.f390Fl.ledOnMS = 300;
            this.f390Fl.ledOffMS = 1000;
            if (this.f390Fl.ledOnMS == 0 || this.f390Fl.ledOffMS == 0) {
                i = 0;
            } else {
                i = 1;
            }
            Notification notification = this.f390Fl;
            int i3 = this.f390Fl.flags & -2;
            if (i == 0) {
                i2 = 0;
            }
            notification.flags = i3 | i2;
            return this;
        }

        /* renamed from: z */
        public final C0358c mo628z(boolean z) {
            mo627k(16, z);
            return this;
        }

        /* renamed from: at */
        public final C0358c mo617at(int i) {
            this.f390Fl.defaults = i;
            if ((i & 4) != 0) {
                Notification notification = this.f390Fl;
                notification.flags |= 1;
            }
            return this;
        }

        /* renamed from: k */
        public final void mo627k(int i, boolean z) {
            Notification notification;
            if (z) {
                notification = this.f390Fl;
                notification.flags |= i;
                return;
            }
            notification = this.f390Fl;
            notification.flags &= i ^ -1;
        }

        /* renamed from: a */
        public final C0358c mo610a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f359EF.add(new C0357a(i, charSequence, pendingIntent));
            return this;
        }

        /* renamed from: a */
        public final C0358c mo613a(C0362f c0362f) {
            if (this.f370ER != c0362f) {
                this.f370ER = c0362f;
                if (this.f370ER != null) {
                    this.f370ER.mo631b(this);
                }
            }
            return this;
        }

        /* renamed from: a */
        public final C0358c mo612a(C0361e c0361e) {
            c0361e.mo629a(this);
            return this;
        }

        public final Notification build() {
            Notification build;
            C6193w c6193w = new C6193w(this);
            C0362f c0362f = c6193w.f1782FA.f370ER;
            if (c0362f != null) {
                c0362f.mo630a(c6193w);
            }
            SparseArray i;
            if (VERSION.SDK_INT >= 26) {
                build = c6193w.mBuilder.build();
            } else if (VERSION.SDK_INT >= 24) {
                build = c6193w.mBuilder.build();
                if (c6193w.f1787Fk != 0) {
                    if (!(build.getGroup() == null || (build.flags & 512) == 0 || c6193w.f1787Fk != 2)) {
                        C6193w.m9949b(build);
                    }
                    if (build.getGroup() != null && (build.flags & 512) == 0 && c6193w.f1787Fk == 1) {
                        C6193w.m9949b(build);
                    }
                }
            } else if (VERSION.SDK_INT >= 21) {
                c6193w.mBuilder.setExtras(c6193w.mExtras);
                build = c6193w.mBuilder.build();
                if (c6193w.f1784Ff != null) {
                    build.contentView = c6193w.f1784Ff;
                }
                if (c6193w.f1785Fg != null) {
                    build.bigContentView = c6193w.f1785Fg;
                }
                if (c6193w.f1786Fh != null) {
                    build.headsUpContentView = c6193w.f1786Fh;
                }
                if (c6193w.f1787Fk != 0) {
                    if (!(build.getGroup() == null || (build.flags & 512) == 0 || c6193w.f1787Fk != 2)) {
                        C6193w.m9949b(build);
                    }
                    if (build.getGroup() != null && (build.flags & 512) == 0 && c6193w.f1787Fk == 1) {
                        C6193w.m9949b(build);
                    }
                }
            } else if (VERSION.SDK_INT >= 20) {
                c6193w.mBuilder.setExtras(c6193w.mExtras);
                build = c6193w.mBuilder.build();
                if (c6193w.f1784Ff != null) {
                    build.contentView = c6193w.f1784Ff;
                }
                if (c6193w.f1785Fg != null) {
                    build.bigContentView = c6193w.f1785Fg;
                }
                if (c6193w.f1787Fk != 0) {
                    if (!(build.getGroup() == null || (build.flags & 512) == 0 || c6193w.f1787Fk != 2)) {
                        C6193w.m9949b(build);
                    }
                    if (build.getGroup() != null && (build.flags & 512) == 0 && c6193w.f1787Fk == 1) {
                        C6193w.m9949b(build);
                    }
                }
            } else if (VERSION.SDK_INT >= 19) {
                i = C0366x.m617i(c6193w.f1783FB);
                if (i != null) {
                    c6193w.mExtras.putSparseParcelableArray("android.support.actionExtras", i);
                }
                c6193w.mBuilder.setExtras(c6193w.mExtras);
                build = c6193w.mBuilder.build();
                if (c6193w.f1784Ff != null) {
                    build.contentView = c6193w.f1784Ff;
                }
                if (c6193w.f1785Fg != null) {
                    build.bigContentView = c6193w.f1785Fg;
                }
            } else if (VERSION.SDK_INT >= 16) {
                Notification build2 = c6193w.mBuilder.build();
                Bundle a = C0363v.m609a(build2);
                Bundle bundle = new Bundle(c6193w.mExtras);
                for (String str : c6193w.mExtras.keySet()) {
                    if (a.containsKey(str)) {
                        bundle.remove(str);
                    }
                }
                a.putAll(bundle);
                i = C0366x.m617i(c6193w.f1783FB);
                if (i != null) {
                    C0363v.m609a(build2).putSparseParcelableArray("android.support.actionExtras", i);
                }
                if (c6193w.f1784Ff != null) {
                    build2.contentView = c6193w.f1784Ff;
                }
                if (c6193w.f1785Fg != null) {
                    build2.bigContentView = c6193w.f1785Fg;
                }
                build = build2;
            } else {
                build = c6193w.mBuilder.getNotification();
            }
            if (c6193w.f1782FA.f384Ff != null) {
                build.contentView = c6193w.f1782FA.f384Ff;
            }
            int i2 = VERSION.SDK_INT;
            i2 = VERSION.SDK_INT;
            if (VERSION.SDK_INT >= 16 && c0362f != null) {
                C0363v.m609a(build);
            }
            return build;
        }

        /* renamed from: h */
        protected static CharSequence m587h(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }
    }

    /* renamed from: android.support.v4.app.v$e */
    public interface C0361e {
        /* renamed from: a */
        C0358c mo629a(C0358c c0358c);
    }

    /* renamed from: android.support.v4.app.v$f */
    public static abstract class C0362f {
        /* renamed from: Fw */
        protected C0358c f405Fw;
        /* renamed from: Fx */
        CharSequence f406Fx;
        /* renamed from: Fy */
        CharSequence f407Fy;
        /* renamed from: Fz */
        boolean f408Fz = false;

        /* renamed from: b */
        public final void mo631b(C0358c c0358c) {
            if (this.f405Fw != c0358c) {
                this.f405Fw = c0358c;
                if (this.f405Fw != null) {
                    this.f405Fw.mo613a(this);
                }
            }
        }

        public final Notification build() {
            if (this.f405Fw != null) {
                return this.f405Fw.build();
            }
            return null;
        }

        /* renamed from: a */
        public void mo630a(C0356u c0356u) {
        }
    }

    /* renamed from: android.support.v4.app.v$b */
    public static class C0364b extends C0362f {
        /* renamed from: EE */
        private CharSequence f409EE;

        public C0364b(C0358c c0358c) {
            mo631b(c0358c);
        }

        /* renamed from: c */
        public final C0364b mo633c(CharSequence charSequence) {
            this.f409EE = C0358c.m587h(charSequence);
            return this;
        }

        /* renamed from: a */
        public final void mo630a(C0356u c0356u) {
            if (VERSION.SDK_INT >= 16) {
                BigTextStyle bigText = new BigTextStyle(c0356u.mo609ds()).setBigContentTitle(this.f406Fx).bigText(this.f409EE);
                if (this.f408Fz) {
                    bigText.setSummaryText(this.f407Fy);
                }
            }
        }
    }

    /* renamed from: android.support.v4.app.v$d */
    public static final class C0365d implements C0361e {
        /* renamed from: EL */
        private Bitmap f410EL;
        /* renamed from: Fn */
        public C0360a f411Fn;
        private int mColor = 0;

        /* renamed from: android.support.v4.app.v$d$a */
        public static class C0360a {
            /* renamed from: Fo */
            final String[] f399Fo;
            /* renamed from: Fp */
            final C0320aa f400Fp;
            /* renamed from: Fq */
            final PendingIntent f401Fq;
            /* renamed from: Fr */
            final PendingIntent f402Fr;
            /* renamed from: Fs */
            final String[] f403Fs;
            /* renamed from: Ft */
            final long f404Ft;

            /* renamed from: android.support.v4.app.v$d$a$a */
            public static class C0359a {
                /* renamed from: Fp */
                public C0320aa f393Fp;
                /* renamed from: Fq */
                public PendingIntent f394Fq;
                /* renamed from: Fr */
                public PendingIntent f395Fr;
                /* renamed from: Ft */
                public long f396Ft;
                /* renamed from: Fu */
                public final List<String> f397Fu = new ArrayList();
                /* renamed from: Fv */
                public final String f398Fv;

                public C0359a(String str) {
                    this.f398Fv = str;
                }
            }

            public C0360a(String[] strArr, C0320aa c0320aa, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j) {
                this.f399Fo = strArr;
                this.f400Fp = c0320aa;
                this.f402Fr = pendingIntent2;
                this.f401Fq = pendingIntent;
                this.f403Fs = strArr2;
                this.f404Ft = j;
            }
        }

        /* renamed from: a */
        private static Bundle m612a(C0360a c0360a) {
            int i = 0;
            Bundle bundle = new Bundle();
            String str = null;
            if (c0360a.f403Fs != null && c0360a.f403Fs.length > 1) {
                str = c0360a.f403Fs[0];
            }
            Parcelable[] parcelableArr = new Parcelable[c0360a.f399Fo.length];
            while (i < parcelableArr.length) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("text", c0360a.f399Fo[i]);
                bundle2.putString("author", str);
                parcelableArr[i] = bundle2;
                i++;
            }
            bundle.putParcelableArray("messages", parcelableArr);
            C0320aa c0320aa = c0360a.f400Fp;
            if (c0320aa != null) {
                bundle.putParcelable("remote_input", new RemoteInput.Builder(c0320aa.f271FU).setLabel(c0320aa.f272FV).setChoices(c0320aa.f273FW).setAllowFreeFormInput(c0320aa.f274FX).addExtras(c0320aa.mExtras).build());
            }
            bundle.putParcelable("on_reply", c0360a.f401Fq);
            bundle.putParcelable("on_read", c0360a.f402Fr);
            bundle.putStringArray("participants", c0360a.f403Fs);
            bundle.putLong(Param.TIMESTAMP, c0360a.f404Ft);
            return bundle;
        }

        /* renamed from: a */
        public final C0358c mo629a(C0358c c0358c) {
            if (VERSION.SDK_INT >= 21) {
                Bundle bundle = new Bundle();
                if (this.f410EL != null) {
                    bundle.putParcelable("large_icon", this.f410EL);
                }
                if (this.mColor != 0) {
                    bundle.putInt("app_color", this.mColor);
                }
                if (this.f411Fn != null) {
                    bundle.putBundle("car_conversation", C0365d.m612a(this.f411Fn));
                }
                if (c0358c.mExtras == null) {
                    c0358c.mExtras = new Bundle();
                }
                c0358c.mExtras.putBundle("android.car.EXTENSIONS", bundle);
            }
            return c0358c;
        }
    }

    /* renamed from: a */
    public static Bundle m609a(Notification notification) {
        if (VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (VERSION.SDK_INT >= 16) {
            return C0366x.m615a(notification);
        }
        return null;
    }
}
