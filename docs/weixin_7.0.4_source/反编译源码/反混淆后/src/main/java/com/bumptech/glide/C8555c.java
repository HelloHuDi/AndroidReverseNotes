package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.manager.C17563f;
import com.bumptech.glide.manager.C37198d;
import com.bumptech.glide.manager.C45005l;
import com.bumptech.glide.p085b.C25400a;
import com.bumptech.glide.p086c.C31968k;
import com.bumptech.glide.p086c.C31969l;
import com.bumptech.glide.p086c.C37171b;
import com.bumptech.glide.p086c.p087a.C37162k.C37161a;
import com.bumptech.glide.p086c.p088b.C31941j;
import com.bumptech.glide.p086c.p088b.p089a.C0748k;
import com.bumptech.glide.p086c.p088b.p089a.C31925e;
import com.bumptech.glide.p086c.p088b.p089a.C31927j;
import com.bumptech.glide.p086c.p088b.p089a.C36670f;
import com.bumptech.glide.p086c.p088b.p089a.C8515b;
import com.bumptech.glide.p086c.p088b.p1636d.C44986a;
import com.bumptech.glide.p086c.p088b.p785b.C25414h;
import com.bumptech.glide.p086c.p088b.p785b.C41546f;
import com.bumptech.glide.p086c.p088b.p785b.C8518g;
import com.bumptech.glide.p086c.p088b.p785b.C8519i;
import com.bumptech.glide.p086c.p088b.p785b.C8519i.C8520a;
import com.bumptech.glide.p086c.p088b.p786c.C44985a;
import com.bumptech.glide.p086c.p090c.C0764k.C0766a;
import com.bumptech.glide.p086c.p090c.C17530b.C17531a;
import com.bumptech.glide.p086c.p090c.C17530b.C17533d;
import com.bumptech.glide.p086c.p090c.C25427a.C17528b;
import com.bumptech.glide.p086c.p090c.C25427a.C25428c;
import com.bumptech.glide.p086c.p090c.C25429c;
import com.bumptech.glide.p086c.p090c.C25438s.C17538d;
import com.bumptech.glide.p086c.p090c.C25438s.C25437c;
import com.bumptech.glide.p086c.p090c.C25438s.C25439a;
import com.bumptech.glide.p086c.p090c.C25438s.C8540b;
import com.bumptech.glide.p086c.p090c.C31950g;
import com.bumptech.glide.p086c.p090c.C31953o;
import com.bumptech.glide.p086c.p090c.C41192d.C36674b;
import com.bumptech.glide.p086c.p090c.C41194f.C37173e;
import com.bumptech.glide.p086c.p090c.C41194f.C8535b;
import com.bumptech.glide.p086c.p090c.C41195v.C41196a;
import com.bumptech.glide.p086c.p090c.C41197w.C36676a;
import com.bumptech.glide.p086c.p090c.C41197w.C37178b;
import com.bumptech.glide.p086c.p090c.C41197w.C8542d;
import com.bumptech.glide.p086c.p090c.C44991e.C8533c;
import com.bumptech.glide.p086c.p090c.C44992u.C17539a;
import com.bumptech.glide.p086c.p090c.C44992u.C41552b;
import com.bumptech.glide.p086c.p090c.C44992u.C41553c;
import com.bumptech.glide.p086c.p090c.C44993x.C0768a;
import com.bumptech.glide.p086c.p090c.C8541t;
import com.bumptech.glide.p086c.p090c.p091a.C31946a.C31947a;
import com.bumptech.glide.p086c.p090c.p091a.C31948c.C25426a;
import com.bumptech.glide.p086c.p090c.p091a.C31949d.C17529a;
import com.bumptech.glide.p086c.p090c.p091a.C41191b.C0760a;
import com.bumptech.glide.p086c.p090c.p091a.C44989e.C41551a;
import com.bumptech.glide.p086c.p092d.p093a.C0769b;
import com.bumptech.glide.p086c.p092d.p093a.C0770c;
import com.bumptech.glide.p086c.p092d.p093a.C0772e;
import com.bumptech.glide.p086c.p092d.p093a.C25446n;
import com.bumptech.glide.p086c.p092d.p093a.C31961h;
import com.bumptech.glide.p086c.p092d.p093a.C36677a;
import com.bumptech.glide.p086c.p092d.p093a.C37181q;
import com.bumptech.glide.p086c.p092d.p093a.C41554o;
import com.bumptech.glide.p086c.p092d.p093a.C44997r;
import com.bumptech.glide.p086c.p092d.p093a.C8543f;
import com.bumptech.glide.p086c.p092d.p094f.C17544c;
import com.bumptech.glide.p086c.p092d.p094f.C25453b;
import com.bumptech.glide.p086c.p092d.p094f.C31965d;
import com.bumptech.glide.p086c.p092d.p094f.C37188a;
import com.bumptech.glide.p086c.p092d.p094f.C8553e;
import com.bumptech.glide.p086c.p092d.p1135b.C16506a.C16507a;
import com.bumptech.glide.p086c.p092d.p1584d.C41558a;
import com.bumptech.glide.p086c.p092d.p787c.C37184e;
import com.bumptech.glide.p086c.p092d.p787c.C41557d;
import com.bumptech.glide.p086c.p092d.p788e.C17541d;
import com.bumptech.glide.p086c.p092d.p788e.C37186c;
import com.bumptech.glide.p086c.p092d.p788e.C37187j;
import com.bumptech.glide.p086c.p092d.p788e.C41561a;
import com.bumptech.glide.p086c.p092d.p788e.C41562h;
import com.bumptech.glide.p095h.C45002j;
import com.bumptech.glide.p095h.C8561i;
import com.bumptech.glide.p789d.C41566b;
import com.bumptech.glide.p789d.C8556d;
import com.bumptech.glide.p791f.C41570e;
import com.bumptech.glide.p791f.p1156a.C17551e;
import com.bumptech.glide.p791f.p1156a.C41569b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.bumptech.glide.c */
public class C8555c implements ComponentCallbacks2 {
    private static volatile C8555c awc;
    private static volatile boolean awd;
    private final C31941j awe;
    public final C31925e awf;
    private final C25414h awg;
    private final C44986a awh;
    public final C37191e awi;
    public final C31976h awj;
    public final C8515b awk;
    public final C45005l awl;
    final C37198d awm;
    final List<C8565j> awn = new ArrayList();
    private C41573f awo = C41573f.NORMAL;

    /* renamed from: ae */
    public static C8555c m15204ae(Context context) {
        AppMethodBeat.m2504i(91603);
        if (awc == null) {
            synchronized (C8555c.class) {
                try {
                    if (awc == null) {
                        if (awd) {
                            Object illegalStateException = new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
                            throw illegalStateException;
                        }
                        awd = true;
                        C8555c.m15202a(context, new C25454d());
                        awd = false;
                    }
                } finally {
                    AppMethodBeat.m2505o(91603);
                }
            }
        }
        C8555c c8555c = awc;
        AppMethodBeat.m2505o(91603);
        return c8555c;
    }

    /* renamed from: a */
    private static void m15202a(Context context, C25454d c25454d) {
        C41566b c41566b;
        AppMethodBeat.m2504i(91604);
        Context applicationContext = context.getApplicationContext();
        C17511a lE = C8555c.m15206lE();
        Collections.emptyList();
        List<C41566b> nJ = new C8556d(applicationContext).mo18660nJ();
        if (!(lE == null || lE.mo31941lD().isEmpty())) {
            Set lD = lE.mo31941lD();
            Iterator it = nJ.iterator();
            while (it.hasNext()) {
                c41566b = (C41566b) it.next();
                if (lD.contains(c41566b.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        new StringBuilder("AppGlideModule excludes manifest GlideModule: ").append(c41566b);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            for (C41566b c41566b2 : nJ) {
                new StringBuilder("Discovered GlideModule from manifest: ").append(c41566b2.getClass());
            }
        }
        c25454d.aww = null;
        Iterator it2 = nJ.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
        if (c25454d.awq == null) {
            c25454d.awq = C44985a.m82375nc();
        }
        if (c25454d.awr == null) {
            c25454d.awr = C44985a.m82374nb();
        }
        if (c25454d.awx == null) {
            c25454d.awx = C44985a.m82377ne();
        }
        if (c25454d.awt == null) {
            c25454d.awt = new C8519i(new C8520a(applicationContext));
        }
        if (c25454d.awm == null) {
            c25454d.awm = new C17563f();
        }
        if (c25454d.awf == null) {
            int i = c25454d.awt.aDj;
            if (i > 0) {
                c25454d.awf = new C0748k((long) i);
            } else {
                c25454d.awf = new C36670f();
            }
        }
        if (c25454d.awk == null) {
            c25454d.awk = new C31927j(c25454d.awt.aDl);
        }
        if (c25454d.awg == null) {
            c25454d.awg = new C8518g((long) c25454d.awt.aDk);
        }
        if (c25454d.aws == null) {
            c25454d.aws = new C41546f(applicationContext);
        }
        if (c25454d.awe == null) {
            c25454d.awe = new C31941j(c25454d.awg, c25454d.aws, c25454d.awr, c25454d.awq, C44985a.m82376nd(), C44985a.m82377ne(), c25454d.awy);
        }
        C45005l c45005l = new C45005l(c25454d.aww);
        C31941j c31941j = c25454d.awe;
        C25414h c25414h = c25454d.awg;
        C31925e c31925e = c25454d.awf;
        C8515b c8515b = c25454d.awk;
        C37198d c37198d = c25454d.awm;
        int i2 = c25454d.awu;
        C41570e c41570e = c25454d.awv;
        c41570e.aCf = true;
        C8555c c8555c = new C8555c(applicationContext, c31941j, c25414h, c31925e, c8515b, c45005l, c37198d, i2, c41570e, c25454d.awp);
        Iterator it3 = nJ.iterator();
        while (it3.hasNext()) {
            it3.next();
        }
        applicationContext.registerComponentCallbacks(c8555c);
        awc = c8555c;
        AppMethodBeat.m2505o(91604);
    }

    /* renamed from: lE */
    private static C17511a m15206lE() {
        C17511a c17511a;
        AppMethodBeat.m2504i(91605);
        try {
            c17511a = (C17511a) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException e) {
            Log.isLoggable("Glide", 5);
            c17511a = null;
        } catch (InstantiationException e2) {
            C8555c.m15203a(e2);
            c17511a = null;
        } catch (IllegalAccessException e22) {
            C8555c.m15203a(e22);
            c17511a = null;
        } catch (NoSuchMethodException e222) {
            C8555c.m15203a(e222);
            c17511a = null;
        } catch (InvocationTargetException e2222) {
            C8555c.m15203a(e2222);
            c17511a = null;
        }
        AppMethodBeat.m2505o(91605);
        return c17511a;
    }

    /* renamed from: a */
    private static void m15203a(Exception exception) {
        AppMethodBeat.m2504i(91606);
        IllegalStateException illegalStateException = new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exception);
        AppMethodBeat.m2505o(91606);
        throw illegalStateException;
    }

    private C8555c(Context context, C31941j c31941j, C25414h c25414h, C31925e c31925e, C8515b c8515b, C45005l c45005l, C37198d c37198d, int i, C41570e c41570e, Map<Class<?>, C25465k<?, ?>> map) {
        AppMethodBeat.m2504i(91607);
        this.awe = c31941j;
        this.awf = c31925e;
        this.awk = c8515b;
        this.awg = c25414h;
        this.awl = c45005l;
        this.awm = c37198d;
        this.awh = new C44986a(c25414h, c31925e, (C37171b) c41570e.aAd.mo52069a(C31961h.aFl));
        Resources resources = context.getResources();
        this.awj = new C31976h();
        C31976h c31976h = this.awj;
        c31976h.awS.mo59283a(new C8543f());
        C31961h c31961h = new C31961h(this.awj.mo52082lF(), resources.getDisplayMetrics(), c31925e, c8515b);
        C41561a c41561a = new C41561a(context, this.awj.mo52082lF(), c31925e, c8515b);
        C31968k b = C44997r.m82402b(c31925e);
        C0772e c0772e = new C0772e(c31961h);
        C41554o c41554o = new C41554o(c31961h, c8515b);
        C31968k c41557d = new C41557d(context);
        C31953o c25437c = new C25437c(resources);
        C31953o c17538d = new C17538d(resources);
        C31953o c8540b = new C8540b(resources);
        C31953o c25439a = new C25439a(resources);
        C31969l c0770c = new C0770c(c8515b);
        C8553e c37188a = new C37188a();
        C31965d c31965d = new C31965d();
        ContentResolver contentResolver = context.getContentResolver();
        C31976h a = this.awj.mo52075a(ByteBuffer.class, new C25429c()).mo52075a(InputStream.class, new C8541t(c8515b)).mo52080a("Bitmap", ByteBuffer.class, Bitmap.class, c0772e).mo52080a("Bitmap", InputStream.class, Bitmap.class, c41554o).mo52080a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, b).mo52080a("Bitmap", AssetFileDescriptor.class, Bitmap.class, C44997r.m82401a(c31925e)).mo52077a(Bitmap.class, Bitmap.class, C41196a.m71695nl()).mo52080a("Bitmap", Bitmap.class, Bitmap.class, new C37181q()).mo52076a(Bitmap.class, c0770c).mo52080a("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new C36677a(resources, c0772e));
        C36677a c36677a = new C36677a(resources, c41554o);
        a.mo52080a("BitmapDrawable", InputStream.class, BitmapDrawable.class, c36677a).mo52080a("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new C36677a(resources, b)).mo52076a(BitmapDrawable.class, new C0769b(c31925e, c0770c)).mo52080a("Gif", InputStream.class, C37186c.class, new C37187j(this.awj.mo52082lF(), c41561a, c8515b)).mo52080a("Gif", ByteBuffer.class, C37186c.class, c41561a).mo52076a(C37186c.class, new C17541d()).mo52077a(C25400a.class, C25400a.class, C41196a.m71695nl()).mo52080a("Bitmap", C25400a.class, Bitmap.class, new C41562h(c31925e)).mo52079a(Uri.class, Drawable.class, c41557d).mo52079a(Uri.class, Bitmap.class, new C25446n(c41557d, c31925e)).mo52074a(new C16507a()).mo52077a(File.class, ByteBuffer.class, new C36674b()).mo52077a(File.class, InputStream.class, new C37173e()).mo52079a(File.class, File.class, new C41558a()).mo52077a(File.class, ParcelFileDescriptor.class, new C8535b()).mo52077a(File.class, File.class, C41196a.m71695nl()).mo52074a(new C37161a(c8515b)).mo52077a(Integer.TYPE, InputStream.class, c25437c).mo52077a(Integer.TYPE, ParcelFileDescriptor.class, c8540b).mo52077a(Integer.class, InputStream.class, c25437c).mo52077a(Integer.class, ParcelFileDescriptor.class, c8540b).mo52077a(Integer.class, Uri.class, c17538d).mo52077a(Integer.TYPE, AssetFileDescriptor.class, c25439a).mo52077a(Integer.class, AssetFileDescriptor.class, c25439a).mo52077a(Integer.TYPE, Uri.class, c17538d).mo52077a(String.class, InputStream.class, new C8533c()).mo52077a(Uri.class, InputStream.class, new C8533c()).mo52077a(String.class, InputStream.class, new C41553c()).mo52077a(String.class, ParcelFileDescriptor.class, new C41552b()).mo52077a(String.class, AssetFileDescriptor.class, new C17539a()).mo52077a(Uri.class, InputStream.class, new C0760a()).mo52077a(Uri.class, InputStream.class, new C25428c(context.getAssets())).mo52077a(Uri.class, ParcelFileDescriptor.class, new C17528b(context.getAssets())).mo52077a(Uri.class, InputStream.class, new C25426a(context)).mo52077a(Uri.class, InputStream.class, new C17529a(context)).mo52077a(Uri.class, InputStream.class, new C8542d(contentResolver)).mo52077a(Uri.class, ParcelFileDescriptor.class, new C37178b(contentResolver)).mo52077a(Uri.class, AssetFileDescriptor.class, new C36676a(contentResolver)).mo52077a(Uri.class, InputStream.class, new C0768a()).mo52077a(URL.class, InputStream.class, new C41551a()).mo52077a(Uri.class, File.class, new C0766a(context)).mo52077a(C31950g.class, InputStream.class, new C31947a()).mo52077a(byte[].class, ByteBuffer.class, new C17531a()).mo52077a(byte[].class, InputStream.class, new C17533d()).mo52077a(Uri.class, Uri.class, C41196a.m71695nl()).mo52077a(Drawable.class, Drawable.class, C41196a.m71695nl()).mo52079a(Drawable.class, Drawable.class, new C37184e()).mo52078a(Bitmap.class, BitmapDrawable.class, new C25453b(resources)).mo52078a(Bitmap.class, byte[].class, c37188a).mo52078a(Drawable.class, byte[].class, new C17544c(c31925e, c37188a, c31965d)).mo52078a(C37186c.class, byte[].class, (C8553e) c31965d);
        Context context2 = context;
        C8515b c8515b2 = c8515b;
        this.awi = new C37191e(context2, c8515b2, this.awj, new C41569b(), c41570e, map, c31941j, i);
        AppMethodBeat.m2505o(91607);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo18656a(C17551e<?> c17551e) {
        AppMethodBeat.m2504i(91609);
        synchronized (this.awn) {
            try {
                for (C8565j e : this.awn) {
                    if (e.mo18675e(c17551e)) {
                    }
                }
                AppMethodBeat.m2505o(91609);
                return false;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(91609);
            }
        }
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    /* renamed from: af */
    public static C8565j m15205af(Context context) {
        AppMethodBeat.m2504i(91608);
        C8561i.m15217d(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        C8565j ah = C8555c.m15204ae(context).awl.mo72290ah(context);
        AppMethodBeat.m2505o(91608);
        return ah;
    }

    public void onTrimMemory(int i) {
        AppMethodBeat.m2504i(91610);
        C45002j.m82426om();
        this.awg.trimMemory(i);
        this.awf.trimMemory(i);
        this.awk.trimMemory(i);
        AppMethodBeat.m2505o(91610);
    }

    public void onLowMemory() {
        AppMethodBeat.m2504i(91611);
        C45002j.m82426om();
        this.awg.mo42461mO();
        this.awf.mo2201mO();
        this.awk.mo18609mO();
        AppMethodBeat.m2505o(91611);
    }
}
