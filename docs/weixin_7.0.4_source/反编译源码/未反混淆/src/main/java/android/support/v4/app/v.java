package android.support.v4.app;

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

public final class v {

    public static class a {
        final aa[] EB;
        final aa[] EC;
        boolean ED;
        public PendingIntent actionIntent;
        public int icon;
        final Bundle mExtras;
        public CharSequence title;

        public a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i, charSequence, pendingIntent, new Bundle());
        }

        private a(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
            this.icon = i;
            this.title = c.h(charSequence);
            this.actionIntent = pendingIntent;
            this.mExtras = bundle;
            this.EB = null;
            this.EC = null;
            this.ED = true;
        }
    }

    public static class c {
        public ArrayList<a> EF;
        CharSequence EG;
        CharSequence EH;
        public PendingIntent EI;
        PendingIntent EJ;
        RemoteViews EK;
        public Bitmap EL;
        CharSequence EM;
        int EN;
        boolean EO;
        boolean EP;
        f ER;
        CharSequence ES;
        CharSequence[] ET;
        int EU;
        int EV;
        boolean EW;
        String EX;
        boolean EY;
        String EZ;
        public boolean Fa;
        boolean Fb;
        boolean Fc;
        public String Fd;
        Notification Fe;
        RemoteViews Ff;
        RemoteViews Fg;
        RemoteViews Fh;
        int Fi;
        String Fj;
        int Fk;
        Notification Fl;
        @Deprecated
        public ArrayList<String> Fm;
        int iZ;
        public String mChannelId;
        public int mColor;
        public Context mContext;
        Bundle mExtras;
        int mPriority;
        long mTimeout;

        public c(Context context, String str) {
            this.EF = new ArrayList();
            this.EO = true;
            this.Fa = false;
            this.mColor = 0;
            this.iZ = 0;
            this.Fi = 0;
            this.Fk = 0;
            this.Fl = new Notification();
            this.mContext = context;
            this.mChannelId = str;
            this.Fl.when = System.currentTimeMillis();
            this.Fl.audioStreamType = -1;
            this.mPriority = 0;
            this.Fm = new ArrayList();
        }

        @Deprecated
        public c(Context context) {
            this(context, null);
        }

        public final c j(long j) {
            this.Fl.when = j;
            return this;
        }

        public final c as(int i) {
            this.Fl.icon = i;
            return this;
        }

        public final c d(CharSequence charSequence) {
            this.EG = h(charSequence);
            return this;
        }

        public final c e(CharSequence charSequence) {
            this.EH = h(charSequence);
            return this;
        }

        public final c f(CharSequence charSequence) {
            this.ES = h(charSequence);
            return this;
        }

        public final c b(int i, int i2, boolean z) {
            this.EU = i;
            this.EV = i2;
            this.EW = z;
            return this;
        }

        public final c a(RemoteViews remoteViews) {
            this.Fl.contentView = remoteViews;
            return this;
        }

        public final c a(PendingIntent pendingIntent) {
            this.Fl.deleteIntent = pendingIntent;
            return this;
        }

        public final c g(CharSequence charSequence) {
            this.Fl.tickerText = h(charSequence);
            return this;
        }

        public final c b(Uri uri) {
            this.Fl.sound = uri;
            this.Fl.audioStreamType = -1;
            if (VERSION.SDK_INT >= 21) {
                this.Fl.audioAttributes = new Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        public final c a(long[] jArr) {
            this.Fl.vibrate = jArr;
            return this;
        }

        public final c dt() {
            int i;
            int i2 = 1;
            this.Fl.ledARGB = -16711936;
            this.Fl.ledOnMS = 300;
            this.Fl.ledOffMS = 1000;
            if (this.Fl.ledOnMS == 0 || this.Fl.ledOffMS == 0) {
                i = 0;
            } else {
                i = 1;
            }
            Notification notification = this.Fl;
            int i3 = this.Fl.flags & -2;
            if (i == 0) {
                i2 = 0;
            }
            notification.flags = i3 | i2;
            return this;
        }

        public final c z(boolean z) {
            k(16, z);
            return this;
        }

        public final c at(int i) {
            this.Fl.defaults = i;
            if ((i & 4) != 0) {
                Notification notification = this.Fl;
                notification.flags |= 1;
            }
            return this;
        }

        public final void k(int i, boolean z) {
            Notification notification;
            if (z) {
                notification = this.Fl;
                notification.flags |= i;
                return;
            }
            notification = this.Fl;
            notification.flags &= i ^ -1;
        }

        public final c a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.EF.add(new a(i, charSequence, pendingIntent));
            return this;
        }

        public final c a(f fVar) {
            if (this.ER != fVar) {
                this.ER = fVar;
                if (this.ER != null) {
                    this.ER.b(this);
                }
            }
            return this;
        }

        public final c a(e eVar) {
            eVar.a(this);
            return this;
        }

        public final Notification build() {
            Notification build;
            w wVar = new w(this);
            f fVar = wVar.FA.ER;
            if (fVar != null) {
                fVar.a(wVar);
            }
            SparseArray i;
            if (VERSION.SDK_INT >= 26) {
                build = wVar.mBuilder.build();
            } else if (VERSION.SDK_INT >= 24) {
                build = wVar.mBuilder.build();
                if (wVar.Fk != 0) {
                    if (!(build.getGroup() == null || (build.flags & 512) == 0 || wVar.Fk != 2)) {
                        w.b(build);
                    }
                    if (build.getGroup() != null && (build.flags & 512) == 0 && wVar.Fk == 1) {
                        w.b(build);
                    }
                }
            } else if (VERSION.SDK_INT >= 21) {
                wVar.mBuilder.setExtras(wVar.mExtras);
                build = wVar.mBuilder.build();
                if (wVar.Ff != null) {
                    build.contentView = wVar.Ff;
                }
                if (wVar.Fg != null) {
                    build.bigContentView = wVar.Fg;
                }
                if (wVar.Fh != null) {
                    build.headsUpContentView = wVar.Fh;
                }
                if (wVar.Fk != 0) {
                    if (!(build.getGroup() == null || (build.flags & 512) == 0 || wVar.Fk != 2)) {
                        w.b(build);
                    }
                    if (build.getGroup() != null && (build.flags & 512) == 0 && wVar.Fk == 1) {
                        w.b(build);
                    }
                }
            } else if (VERSION.SDK_INT >= 20) {
                wVar.mBuilder.setExtras(wVar.mExtras);
                build = wVar.mBuilder.build();
                if (wVar.Ff != null) {
                    build.contentView = wVar.Ff;
                }
                if (wVar.Fg != null) {
                    build.bigContentView = wVar.Fg;
                }
                if (wVar.Fk != 0) {
                    if (!(build.getGroup() == null || (build.flags & 512) == 0 || wVar.Fk != 2)) {
                        w.b(build);
                    }
                    if (build.getGroup() != null && (build.flags & 512) == 0 && wVar.Fk == 1) {
                        w.b(build);
                    }
                }
            } else if (VERSION.SDK_INT >= 19) {
                i = x.i(wVar.FB);
                if (i != null) {
                    wVar.mExtras.putSparseParcelableArray("android.support.actionExtras", i);
                }
                wVar.mBuilder.setExtras(wVar.mExtras);
                build = wVar.mBuilder.build();
                if (wVar.Ff != null) {
                    build.contentView = wVar.Ff;
                }
                if (wVar.Fg != null) {
                    build.bigContentView = wVar.Fg;
                }
            } else if (VERSION.SDK_INT >= 16) {
                Notification build2 = wVar.mBuilder.build();
                Bundle a = v.a(build2);
                Bundle bundle = new Bundle(wVar.mExtras);
                for (String str : wVar.mExtras.keySet()) {
                    if (a.containsKey(str)) {
                        bundle.remove(str);
                    }
                }
                a.putAll(bundle);
                i = x.i(wVar.FB);
                if (i != null) {
                    v.a(build2).putSparseParcelableArray("android.support.actionExtras", i);
                }
                if (wVar.Ff != null) {
                    build2.contentView = wVar.Ff;
                }
                if (wVar.Fg != null) {
                    build2.bigContentView = wVar.Fg;
                }
                build = build2;
            } else {
                build = wVar.mBuilder.getNotification();
            }
            if (wVar.FA.Ff != null) {
                build.contentView = wVar.FA.Ff;
            }
            int i2 = VERSION.SDK_INT;
            i2 = VERSION.SDK_INT;
            if (VERSION.SDK_INT >= 16 && fVar != null) {
                v.a(build);
            }
            return build;
        }

        protected static CharSequence h(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }
    }

    public interface e {
        c a(c cVar);
    }

    public static abstract class f {
        protected c Fw;
        CharSequence Fx;
        CharSequence Fy;
        boolean Fz = false;

        public final void b(c cVar) {
            if (this.Fw != cVar) {
                this.Fw = cVar;
                if (this.Fw != null) {
                    this.Fw.a(this);
                }
            }
        }

        public final Notification build() {
            if (this.Fw != null) {
                return this.Fw.build();
            }
            return null;
        }

        public void a(u uVar) {
        }
    }

    public static class b extends f {
        private CharSequence EE;

        public b(c cVar) {
            b(cVar);
        }

        public final b c(CharSequence charSequence) {
            this.EE = c.h(charSequence);
            return this;
        }

        public final void a(u uVar) {
            if (VERSION.SDK_INT >= 16) {
                BigTextStyle bigText = new BigTextStyle(uVar.ds()).setBigContentTitle(this.Fx).bigText(this.EE);
                if (this.Fz) {
                    bigText.setSummaryText(this.Fy);
                }
            }
        }
    }

    public static final class d implements e {
        private Bitmap EL;
        public a Fn;
        private int mColor = 0;

        public static class a {
            final String[] Fo;
            final aa Fp;
            final PendingIntent Fq;
            final PendingIntent Fr;
            final String[] Fs;
            final long Ft;

            public static class a {
                public aa Fp;
                public PendingIntent Fq;
                public PendingIntent Fr;
                public long Ft;
                public final List<String> Fu = new ArrayList();
                public final String Fv;

                public a(String str) {
                    this.Fv = str;
                }
            }

            public a(String[] strArr, aa aaVar, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j) {
                this.Fo = strArr;
                this.Fp = aaVar;
                this.Fr = pendingIntent2;
                this.Fq = pendingIntent;
                this.Fs = strArr2;
                this.Ft = j;
            }
        }

        private static Bundle a(a aVar) {
            int i = 0;
            Bundle bundle = new Bundle();
            String str = null;
            if (aVar.Fs != null && aVar.Fs.length > 1) {
                str = aVar.Fs[0];
            }
            Parcelable[] parcelableArr = new Parcelable[aVar.Fo.length];
            while (i < parcelableArr.length) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("text", aVar.Fo[i]);
                bundle2.putString("author", str);
                parcelableArr[i] = bundle2;
                i++;
            }
            bundle.putParcelableArray("messages", parcelableArr);
            aa aaVar = aVar.Fp;
            if (aaVar != null) {
                bundle.putParcelable("remote_input", new RemoteInput.Builder(aaVar.FU).setLabel(aaVar.FV).setChoices(aaVar.FW).setAllowFreeFormInput(aaVar.FX).addExtras(aaVar.mExtras).build());
            }
            bundle.putParcelable("on_reply", aVar.Fq);
            bundle.putParcelable("on_read", aVar.Fr);
            bundle.putStringArray("participants", aVar.Fs);
            bundle.putLong(Param.TIMESTAMP, aVar.Ft);
            return bundle;
        }

        public final c a(c cVar) {
            if (VERSION.SDK_INT >= 21) {
                Bundle bundle = new Bundle();
                if (this.EL != null) {
                    bundle.putParcelable("large_icon", this.EL);
                }
                if (this.mColor != 0) {
                    bundle.putInt("app_color", this.mColor);
                }
                if (this.Fn != null) {
                    bundle.putBundle("car_conversation", a(this.Fn));
                }
                if (cVar.mExtras == null) {
                    cVar.mExtras = new Bundle();
                }
                cVar.mExtras.putBundle("android.car.EXTENSIONS", bundle);
            }
            return cVar;
        }
    }

    public static Bundle a(Notification notification) {
        if (VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (VERSION.SDK_INT >= 16) {
            return x.a(notification);
        }
        return null;
    }
}
