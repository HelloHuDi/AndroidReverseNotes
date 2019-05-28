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
import com.bumptech.glide.c.b.a.b;
import com.bumptech.glide.c.b.a.e;
import com.bumptech.glide.c.b.a.k;
import com.bumptech.glide.c.b.b.g;
import com.bumptech.glide.c.b.b.h;
import com.bumptech.glide.c.b.b.i;
import com.bumptech.glide.c.b.d.a;
import com.bumptech.glide.c.b.j;
import com.bumptech.glide.c.c.s;
import com.bumptech.glide.c.c.t;
import com.bumptech.glide.c.c.u;
import com.bumptech.glide.c.c.v;
import com.bumptech.glide.c.c.w;
import com.bumptech.glide.c.c.x;
import com.bumptech.glide.c.d.a.n;
import com.bumptech.glide.c.d.a.o;
import com.bumptech.glide.c.d.a.q;
import com.bumptech.glide.c.d.a.r;
import com.bumptech.glide.manager.d;
import com.bumptech.glide.manager.f;
import com.bumptech.glide.manager.l;
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

public class c implements ComponentCallbacks2 {
    private static volatile c awc;
    private static volatile boolean awd;
    private final j awe;
    public final e awf;
    private final h awg;
    private final a awh;
    public final e awi;
    public final h awj;
    public final b awk;
    public final l awl;
    final d awm;
    final List<j> awn = new ArrayList();
    private f awo = f.NORMAL;

    public static c ae(Context context) {
        AppMethodBeat.i(91603);
        if (awc == null) {
            synchronized (c.class) {
                try {
                    if (awc == null) {
                        if (awd) {
                            Object illegalStateException = new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
                            throw illegalStateException;
                        }
                        awd = true;
                        a(context, new d());
                        awd = false;
                    }
                } finally {
                    AppMethodBeat.o(91603);
                }
            }
        }
        c cVar = awc;
        AppMethodBeat.o(91603);
        return cVar;
    }

    private static void a(Context context, d dVar) {
        com.bumptech.glide.d.b bVar;
        AppMethodBeat.i(91604);
        Context applicationContext = context.getApplicationContext();
        a lE = lE();
        Collections.emptyList();
        List<com.bumptech.glide.d.b> nJ = new com.bumptech.glide.d.d(applicationContext).nJ();
        if (!(lE == null || lE.lD().isEmpty())) {
            Set lD = lE.lD();
            Iterator it = nJ.iterator();
            while (it.hasNext()) {
                bVar = (com.bumptech.glide.d.b) it.next();
                if (lD.contains(bVar.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        new StringBuilder("AppGlideModule excludes manifest GlideModule: ").append(bVar);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            for (com.bumptech.glide.d.b bVar2 : nJ) {
                new StringBuilder("Discovered GlideModule from manifest: ").append(bVar2.getClass());
            }
        }
        dVar.aww = null;
        Iterator it2 = nJ.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
        if (dVar.awq == null) {
            dVar.awq = com.bumptech.glide.c.b.c.a.nc();
        }
        if (dVar.awr == null) {
            dVar.awr = com.bumptech.glide.c.b.c.a.nb();
        }
        if (dVar.awx == null) {
            dVar.awx = com.bumptech.glide.c.b.c.a.ne();
        }
        if (dVar.awt == null) {
            dVar.awt = new i(new i.a(applicationContext));
        }
        if (dVar.awm == null) {
            dVar.awm = new f();
        }
        if (dVar.awf == null) {
            int i = dVar.awt.aDj;
            if (i > 0) {
                dVar.awf = new k((long) i);
            } else {
                dVar.awf = new com.bumptech.glide.c.b.a.f();
            }
        }
        if (dVar.awk == null) {
            dVar.awk = new com.bumptech.glide.c.b.a.j(dVar.awt.aDl);
        }
        if (dVar.awg == null) {
            dVar.awg = new g((long) dVar.awt.aDk);
        }
        if (dVar.aws == null) {
            dVar.aws = new com.bumptech.glide.c.b.b.f(applicationContext);
        }
        if (dVar.awe == null) {
            dVar.awe = new j(dVar.awg, dVar.aws, dVar.awr, dVar.awq, com.bumptech.glide.c.b.c.a.nd(), com.bumptech.glide.c.b.c.a.ne(), dVar.awy);
        }
        l lVar = new l(dVar.aww);
        j jVar = dVar.awe;
        h hVar = dVar.awg;
        e eVar = dVar.awf;
        b bVar3 = dVar.awk;
        d dVar2 = dVar.awm;
        int i2 = dVar.awu;
        com.bumptech.glide.f.e eVar2 = dVar.awv;
        eVar2.aCf = true;
        c cVar = new c(applicationContext, jVar, hVar, eVar, bVar3, lVar, dVar2, i2, eVar2, dVar.awp);
        Iterator it3 = nJ.iterator();
        while (it3.hasNext()) {
            it3.next();
        }
        applicationContext.registerComponentCallbacks(cVar);
        awc = cVar;
        AppMethodBeat.o(91604);
    }

    private static a lE() {
        a aVar;
        AppMethodBeat.i(91605);
        try {
            aVar = (a) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException e) {
            Log.isLoggable("Glide", 5);
            aVar = null;
        } catch (InstantiationException e2) {
            a(e2);
            aVar = null;
        } catch (IllegalAccessException e22) {
            a(e22);
            aVar = null;
        } catch (NoSuchMethodException e222) {
            a(e222);
            aVar = null;
        } catch (InvocationTargetException e2222) {
            a(e2222);
            aVar = null;
        }
        AppMethodBeat.o(91605);
        return aVar;
    }

    private static void a(Exception exception) {
        AppMethodBeat.i(91606);
        IllegalStateException illegalStateException = new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exception);
        AppMethodBeat.o(91606);
        throw illegalStateException;
    }

    private c(Context context, j jVar, h hVar, e eVar, b bVar, l lVar, d dVar, int i, com.bumptech.glide.f.e eVar2, Map<Class<?>, k<?, ?>> map) {
        AppMethodBeat.i(91607);
        this.awe = jVar;
        this.awf = eVar;
        this.awk = bVar;
        this.awg = hVar;
        this.awl = lVar;
        this.awm = dVar;
        this.awh = new a(hVar, eVar, (com.bumptech.glide.c.b) eVar2.aAd.a(com.bumptech.glide.c.d.a.h.aFl));
        Resources resources = context.getResources();
        this.awj = new h();
        h hVar2 = this.awj;
        hVar2.awS.a(new com.bumptech.glide.c.d.a.f());
        com.bumptech.glide.c.d.a.h hVar3 = new com.bumptech.glide.c.d.a.h(this.awj.lF(), resources.getDisplayMetrics(), eVar, bVar);
        com.bumptech.glide.c.d.e.a aVar = new com.bumptech.glide.c.d.e.a(context, this.awj.lF(), eVar, bVar);
        com.bumptech.glide.c.k b = r.b(eVar);
        com.bumptech.glide.c.d.a.e eVar3 = new com.bumptech.glide.c.d.a.e(hVar3);
        o oVar = new o(hVar3, bVar);
        com.bumptech.glide.c.k dVar2 = new com.bumptech.glide.c.d.c.d(context);
        com.bumptech.glide.c.c.o cVar = new com.bumptech.glide.c.c.s.c(resources);
        com.bumptech.glide.c.c.o dVar3 = new s.d(resources);
        com.bumptech.glide.c.c.o bVar2 = new s.b(resources);
        com.bumptech.glide.c.c.o aVar2 = new s.a(resources);
        com.bumptech.glide.c.l cVar2 = new com.bumptech.glide.c.d.a.c(bVar);
        com.bumptech.glide.c.d.f.e aVar3 = new com.bumptech.glide.c.d.f.a();
        com.bumptech.glide.c.d.f.d dVar4 = new com.bumptech.glide.c.d.f.d();
        ContentResolver contentResolver = context.getContentResolver();
        h a = this.awj.a(ByteBuffer.class, new com.bumptech.glide.c.c.c()).a(InputStream.class, new t(bVar)).a("Bitmap", ByteBuffer.class, Bitmap.class, eVar3).a("Bitmap", InputStream.class, Bitmap.class, oVar).a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, b).a("Bitmap", AssetFileDescriptor.class, Bitmap.class, r.a(eVar)).a(Bitmap.class, Bitmap.class, v.a.nl()).a("Bitmap", Bitmap.class, Bitmap.class, new q()).a(Bitmap.class, cVar2).a("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.c.d.a.a(resources, eVar3));
        com.bumptech.glide.c.d.a.a aVar4 = new com.bumptech.glide.c.d.a.a(resources, oVar);
        a.a("BitmapDrawable", InputStream.class, BitmapDrawable.class, aVar4).a("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.c.d.a.a(resources, b)).a(BitmapDrawable.class, new com.bumptech.glide.c.d.a.b(eVar, cVar2)).a("Gif", InputStream.class, com.bumptech.glide.c.d.e.c.class, new com.bumptech.glide.c.d.e.j(this.awj.lF(), aVar, bVar)).a("Gif", ByteBuffer.class, com.bumptech.glide.c.d.e.c.class, aVar).a(com.bumptech.glide.c.d.e.c.class, new com.bumptech.glide.c.d.e.d()).a(com.bumptech.glide.b.a.class, com.bumptech.glide.b.a.class, v.a.nl()).a("Bitmap", com.bumptech.glide.b.a.class, Bitmap.class, new com.bumptech.glide.c.d.e.h(eVar)).a(Uri.class, Drawable.class, dVar2).a(Uri.class, Bitmap.class, new n(dVar2, eVar)).a(new com.bumptech.glide.c.d.b.a.a()).a(File.class, ByteBuffer.class, new com.bumptech.glide.c.c.d.b()).a(File.class, InputStream.class, new com.bumptech.glide.c.c.f.e()).a(File.class, File.class, new com.bumptech.glide.c.d.d.a()).a(File.class, ParcelFileDescriptor.class, new com.bumptech.glide.c.c.f.b()).a(File.class, File.class, v.a.nl()).a(new com.bumptech.glide.c.a.k.a(bVar)).a(Integer.TYPE, InputStream.class, cVar).a(Integer.TYPE, ParcelFileDescriptor.class, bVar2).a(Integer.class, InputStream.class, cVar).a(Integer.class, ParcelFileDescriptor.class, bVar2).a(Integer.class, Uri.class, dVar3).a(Integer.TYPE, AssetFileDescriptor.class, aVar2).a(Integer.class, AssetFileDescriptor.class, aVar2).a(Integer.TYPE, Uri.class, dVar3).a(String.class, InputStream.class, new com.bumptech.glide.c.c.e.c()).a(Uri.class, InputStream.class, new com.bumptech.glide.c.c.e.c()).a(String.class, InputStream.class, new com.bumptech.glide.c.c.u.c()).a(String.class, ParcelFileDescriptor.class, new u.b()).a(String.class, AssetFileDescriptor.class, new u.a()).a(Uri.class, InputStream.class, new com.bumptech.glide.c.c.a.b.a()).a(Uri.class, InputStream.class, new com.bumptech.glide.c.c.a.c(context.getAssets())).a(Uri.class, ParcelFileDescriptor.class, new com.bumptech.glide.c.c.a.b(context.getAssets())).a(Uri.class, InputStream.class, new com.bumptech.glide.c.c.a.c.a(context)).a(Uri.class, InputStream.class, new com.bumptech.glide.c.c.a.d.a(context)).a(Uri.class, InputStream.class, new w.d(contentResolver)).a(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver)).a(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver)).a(Uri.class, InputStream.class, new x.a()).a(URL.class, InputStream.class, new com.bumptech.glide.c.c.a.e.a()).a(Uri.class, File.class, new com.bumptech.glide.c.c.k.a(context)).a(com.bumptech.glide.c.c.g.class, InputStream.class, new com.bumptech.glide.c.c.a.a.a()).a(byte[].class, ByteBuffer.class, new com.bumptech.glide.c.c.b.a()).a(byte[].class, InputStream.class, new com.bumptech.glide.c.c.b.d()).a(Uri.class, Uri.class, v.a.nl()).a(Drawable.class, Drawable.class, v.a.nl()).a(Drawable.class, Drawable.class, new com.bumptech.glide.c.d.c.e()).a(Bitmap.class, BitmapDrawable.class, new com.bumptech.glide.c.d.f.b(resources)).a(Bitmap.class, byte[].class, aVar3).a(Drawable.class, byte[].class, new com.bumptech.glide.c.d.f.c(eVar, aVar3, dVar4)).a(com.bumptech.glide.c.d.e.c.class, byte[].class, (com.bumptech.glide.c.d.f.e) dVar4);
        Context context2 = context;
        b bVar3 = bVar;
        this.awi = new e(context2, bVar3, this.awj, new com.bumptech.glide.f.a.b(), eVar2, map, jVar, i);
        AppMethodBeat.o(91607);
    }

    /* Access modifiers changed, original: final */
    public final boolean a(com.bumptech.glide.f.a.e<?> eVar) {
        AppMethodBeat.i(91609);
        synchronized (this.awn) {
            try {
                for (j e : this.awn) {
                    if (e.e(eVar)) {
                    }
                }
                AppMethodBeat.o(91609);
                return false;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(91609);
            }
        }
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public static j af(Context context) {
        AppMethodBeat.i(91608);
        com.bumptech.glide.h.i.d(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        j ah = ae(context).awl.ah(context);
        AppMethodBeat.o(91608);
        return ah;
    }

    public void onTrimMemory(int i) {
        AppMethodBeat.i(91610);
        com.bumptech.glide.h.j.om();
        this.awg.trimMemory(i);
        this.awf.trimMemory(i);
        this.awk.trimMemory(i);
        AppMethodBeat.o(91610);
    }

    public void onLowMemory() {
        AppMethodBeat.i(91611);
        com.bumptech.glide.h.j.om();
        this.awg.mO();
        this.awf.mO();
        this.awk.mO();
        AppMethodBeat.o(91611);
    }
}
