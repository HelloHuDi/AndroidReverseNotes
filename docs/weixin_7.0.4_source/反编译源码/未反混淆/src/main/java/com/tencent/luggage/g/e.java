package com.tencent.luggage.g;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class e {
    private static final WeakHashMap<Activity, e> bRG = new WeakHashMap();
    @SuppressLint({"StaticFieldLeak"})
    private static final e bRH = new e(null);
    private final SparseArray<a> bRC = new SparseArray();
    public final SparseArray<d> bRD = new SparseArray();
    public final Set<b> bRE = Collections.newSetFromMap(new ConcurrentHashMap());
    private Random bRF;
    private Activity mActivity;

    public interface c {
    }

    public interface b extends c {
        boolean b(int i, int i2, Intent intent);
    }

    public interface d extends c {
        void l(int[] iArr);
    }

    public interface a extends c {
        void b(int i, Intent intent);
    }

    private e(Activity activity) {
        AppMethodBeat.i(90896);
        this.mActivity = activity;
        this.bRF = new Random();
        AppMethodBeat.o(90896);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(90897);
        for (b b : this.bRE) {
            if (b.b(i, i2, intent)) {
                AppMethodBeat.o(90897);
                return;
            }
        }
        c cVar = (c) this.bRC.get(i);
        this.bRC.delete(i);
        if (cVar != null) {
            ((a) cVar).b(i2, intent);
        }
        AppMethodBeat.o(90897);
    }

    public final void a(Intent intent, a aVar) {
        AppMethodBeat.i(90898);
        if (this.mActivity == null) {
            AppMethodBeat.o(90898);
            return;
        }
        int b = b(this.bRC);
        this.bRC.put(b, aVar);
        this.mActivity.startActivityForResult(intent, b);
        AppMethodBeat.o(90898);
    }

    public final boolean a(String str, d dVar) {
        AppMethodBeat.i(90899);
        if (VERSION.SDK_INT < 23 && !"MNC".equals(VERSION.CODENAME)) {
            AppMethodBeat.o(90899);
            return true;
        } else if (this.mActivity == null) {
            AppMethodBeat.o(90899);
            return false;
        } else {
            try {
                if (android.support.v4.content.b.checkSelfPermission(this.mActivity, str) == 0) {
                    AppMethodBeat.o(90899);
                    return true;
                }
                String[] strArr = new String[]{str};
                if (this.mActivity != null) {
                    if (VERSION.SDK_INT < 23) {
                        int[] iArr = new int[1];
                        Arrays.fill(iArr, 0);
                        dVar.l(iArr);
                    } else {
                        int b = b(this.bRD);
                        this.bRD.put(b, dVar);
                        this.mActivity.requestPermissions(strArr, b);
                    }
                }
                AppMethodBeat.o(90899);
                return false;
            } catch (Exception e) {
                ab.e("Luggage.LuggageActivityHelper", "check mpermission exception:%s.", e);
                AppMethodBeat.o(90899);
                return true;
            }
        }
    }

    private int b(SparseArray sparseArray) {
        int rand;
        AppMethodBeat.i(90900);
        do {
            rand = rand();
        } while (sparseArray.get(rand) != null);
        AppMethodBeat.o(90900);
        return rand;
    }

    private int rand() {
        AppMethodBeat.i(90901);
        int nextInt = (this.bRF.nextInt(2147483646) + 1) & CdnLogic.kBizGeneric;
        AppMethodBeat.o(90901);
        return nextInt;
    }

    static {
        AppMethodBeat.i(90904);
        AppMethodBeat.o(90904);
    }

    public static e ax(Context context) {
        AppMethodBeat.i(90902);
        Assert.assertFalse("must implements ILuggageActivityHelper", false);
        e eVar;
        if (context instanceof Activity) {
            if (!bRG.containsKey(context)) {
                bRG.put((Activity) context, new e((Activity) context));
            }
            eVar = (e) bRG.get(context);
            AppMethodBeat.o(90902);
            return eVar;
        }
        Assert.assertFalse(false);
        eVar = bRH;
        AppMethodBeat.o(90902);
        return eVar;
    }

    public static void ay(Context context) {
        AppMethodBeat.i(90903);
        if (context instanceof Activity) {
            bRG.remove(context);
        }
        AppMethodBeat.o(90903);
    }
}
