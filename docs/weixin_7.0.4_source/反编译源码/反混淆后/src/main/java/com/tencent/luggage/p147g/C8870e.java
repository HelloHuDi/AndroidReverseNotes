package com.tencent.luggage.p147g;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.p057v4.content.C0380b;
import android.util.SparseArray;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

/* renamed from: com.tencent.luggage.g.e */
public final class C8870e {
    private static final WeakHashMap<Activity, C8870e> bRG = new WeakHashMap();
    @SuppressLint({"StaticFieldLeak"})
    private static final C8870e bRH = new C8870e(null);
    private final SparseArray<C8872a> bRC = new SparseArray();
    public final SparseArray<C8871d> bRD = new SparseArray();
    public final Set<C6275b> bRE = Collections.newSetFromMap(new ConcurrentHashMap());
    private Random bRF;
    private Activity mActivity;

    /* renamed from: com.tencent.luggage.g.e$c */
    public interface C0990c {
    }

    /* renamed from: com.tencent.luggage.g.e$b */
    public interface C6275b extends C0990c {
        /* renamed from: b */
        boolean mo14504b(int i, int i2, Intent intent);
    }

    /* renamed from: com.tencent.luggage.g.e$d */
    public interface C8871d extends C0990c {
        /* renamed from: l */
        void mo20071l(int[] iArr);
    }

    /* renamed from: com.tencent.luggage.g.e$a */
    public interface C8872a extends C0990c {
        /* renamed from: b */
        void mo15055b(int i, Intent intent);
    }

    private C8870e(Activity activity) {
        AppMethodBeat.m2504i(90896);
        this.mActivity = activity;
        this.bRF = new Random();
        AppMethodBeat.m2505o(90896);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(90897);
        for (C6275b b : this.bRE) {
            if (b.mo14504b(i, i2, intent)) {
                AppMethodBeat.m2505o(90897);
                return;
            }
        }
        C0990c c0990c = (C0990c) this.bRC.get(i);
        this.bRC.delete(i);
        if (c0990c != null) {
            ((C8872a) c0990c).mo15055b(i2, intent);
        }
        AppMethodBeat.m2505o(90897);
    }

    /* renamed from: a */
    public final void mo20068a(Intent intent, C8872a c8872a) {
        AppMethodBeat.m2504i(90898);
        if (this.mActivity == null) {
            AppMethodBeat.m2505o(90898);
            return;
        }
        int b = m15841b(this.bRC);
        this.bRC.put(b, c8872a);
        this.mActivity.startActivityForResult(intent, b);
        AppMethodBeat.m2505o(90898);
    }

    /* renamed from: a */
    public final boolean mo20069a(String str, C8871d c8871d) {
        AppMethodBeat.m2504i(90899);
        if (VERSION.SDK_INT < 23 && !"MNC".equals(VERSION.CODENAME)) {
            AppMethodBeat.m2505o(90899);
            return true;
        } else if (this.mActivity == null) {
            AppMethodBeat.m2505o(90899);
            return false;
        } else {
            try {
                if (C0380b.checkSelfPermission(this.mActivity, str) == 0) {
                    AppMethodBeat.m2505o(90899);
                    return true;
                }
                String[] strArr = new String[]{str};
                if (this.mActivity != null) {
                    if (VERSION.SDK_INT < 23) {
                        int[] iArr = new int[1];
                        Arrays.fill(iArr, 0);
                        c8871d.mo20071l(iArr);
                    } else {
                        int b = m15841b(this.bRD);
                        this.bRD.put(b, c8871d);
                        this.mActivity.requestPermissions(strArr, b);
                    }
                }
                AppMethodBeat.m2505o(90899);
                return false;
            } catch (Exception e) {
                C4990ab.m7413e("Luggage.LuggageActivityHelper", "check mpermission exception:%s.", e);
                AppMethodBeat.m2505o(90899);
                return true;
            }
        }
    }

    /* renamed from: b */
    private int m15841b(SparseArray sparseArray) {
        int rand;
        AppMethodBeat.m2504i(90900);
        do {
            rand = rand();
        } while (sparseArray.get(rand) != null);
        AppMethodBeat.m2505o(90900);
        return rand;
    }

    private int rand() {
        AppMethodBeat.m2504i(90901);
        int nextInt = (this.bRF.nextInt(2147483646) + 1) & CdnLogic.kBizGeneric;
        AppMethodBeat.m2505o(90901);
        return nextInt;
    }

    static {
        AppMethodBeat.m2504i(90904);
        AppMethodBeat.m2505o(90904);
    }

    /* renamed from: ax */
    public static C8870e m15839ax(Context context) {
        AppMethodBeat.m2504i(90902);
        Assert.assertFalse("must implements ILuggageActivityHelper", false);
        C8870e c8870e;
        if (context instanceof Activity) {
            if (!bRG.containsKey(context)) {
                bRG.put((Activity) context, new C8870e((Activity) context));
            }
            c8870e = (C8870e) bRG.get(context);
            AppMethodBeat.m2505o(90902);
            return c8870e;
        }
        Assert.assertFalse(false);
        c8870e = bRH;
        AppMethodBeat.m2505o(90902);
        return c8870e;
    }

    /* renamed from: ay */
    public static void m15840ay(Context context) {
        AppMethodBeat.m2504i(90903);
        if (context instanceof Activity) {
            bRG.remove(context);
        }
        AppMethodBeat.m2505o(90903);
    }
}
