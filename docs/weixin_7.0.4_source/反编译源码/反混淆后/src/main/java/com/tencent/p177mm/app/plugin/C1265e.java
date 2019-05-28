package com.tencent.p177mm.app.plugin;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.p177mm.app.plugin.URISpanHandlerSet.C1262a;
import com.tencent.p177mm.app.plugin.URISpanHandlerSet.PRIORITY;
import com.tencent.p177mm.pluginsdk.C30156v;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14932m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C40487b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44086g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.app.plugin.e */
public final class C1265e implements C40487b {
    private static C1265e cgt = null;
    private URISpanHandlerSet cgu;
    private ArrayList<BaseUriSpanHandler> cgv = new ArrayList();
    private ArrayList<BaseUriSpanHandler> cgw = new ArrayList();
    private ArrayList<BaseUriSpanHandler> cgx = new ArrayList();
    private Context mContext = null;

    /* renamed from: Cl */
    public static C1265e m2715Cl() {
        AppMethodBeat.m2504i(15623);
        if (cgt == null) {
            cgt = new C1265e();
        }
        C1265e c1265e = cgt;
        AppMethodBeat.m2505o(15623);
        return c1265e;
    }

    private C1265e() {
        AppMethodBeat.m2504i(15624);
        long anU = C5046bo.anU();
        C4990ab.m7410d("MicroMsg.URISpanHandler", "init URISpanHandler");
        this.mContext = C4996ah.getContext();
        this.cgu = new URISpanHandlerSet(this.mContext);
        for (Class cls : URISpanHandlerSet.class.getDeclaredClasses()) {
            if (cls != null && cls.getSuperclass() != null && cls.isAnnotationPresent(C1262a.class) && cls.getSuperclass().getName().equals(BaseUriSpanHandler.class.getName())) {
                try {
                    C1262a c1262a = (C1262a) cls.getAnnotation(C1262a.class);
                    Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[]{URISpanHandlerSet.class});
                    if (declaredConstructor != null) {
                        BaseUriSpanHandler baseUriSpanHandler = (BaseUriSpanHandler) BaseUriSpanHandler.class.cast(declaredConstructor.newInstance(new Object[]{this.cgu}));
                        PRIORITY Cn = c1262a.mo4547Cn();
                        if (Cn == PRIORITY.LOW) {
                            this.cgx.add(baseUriSpanHandler);
                        } else if (Cn == PRIORITY.NORMAL) {
                            this.cgw.add(baseUriSpanHandler);
                        } else if (Cn == PRIORITY.HIGH) {
                            this.cgv.add(baseUriSpanHandler);
                        }
                        C4990ab.m7411d("MicroMsg.URISpanHandler", "successfully add: %s", cls.getName());
                    } else {
                        C4990ab.m7411d("MicroMsg.URISpanHandler", "failed to add %s, constructor is null!!", cls.getName());
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.URISpanHandler", e, "", new Object[0]);
                    C4990ab.m7411d("MicroMsg.URISpanHandler", "add %s error: %s, errorType:%s", cls.getName(), e.getMessage(), e.getClass().getName());
                }
            }
        }
        C4990ab.m7411d("MicroMsg.URISpanHandler", "init URISpanHandler used :%d ms", Long.valueOf(C5046bo.anU() - anU));
        AppMethodBeat.m2505o(15624);
    }

    /* renamed from: y */
    public final C14932m mo4554y(Context context, String str) {
        AppMethodBeat.m2504i(15625);
        C4990ab.m7411d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url:%s, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size：%d", str, Integer.valueOf(this.cgv.size()), Integer.valueOf(this.cgw.size()), Integer.valueOf(this.cgx.size()));
        if (context == null) {
            C4990ab.m7412e("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl error, context is null!");
            this.cgu.mContext = null;
            AppMethodBeat.m2505o(15625);
            return null;
        }
        this.mContext = context;
        this.cgu.mContext = this.mContext;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7410d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url is null");
            this.mContext = null;
            this.cgu.mContext = null;
            AppMethodBeat.m2505o(15625);
            return null;
        }
        C14932m dr;
        Iterator it = this.cgv.iterator();
        while (it.hasNext()) {
            dr = ((BaseUriSpanHandler) it.next()).mo4546dr(str);
            if (dr != null) {
                C4990ab.m7411d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", Integer.valueOf(dr.type));
                this.mContext = null;
                this.cgu.mContext = null;
                AppMethodBeat.m2505o(15625);
                return dr;
            }
        }
        it = this.cgw.iterator();
        while (it.hasNext()) {
            dr = ((BaseUriSpanHandler) it.next()).mo4546dr(str);
            if (dr != null) {
                C4990ab.m7411d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", Integer.valueOf(dr.type));
                this.mContext = null;
                this.cgu.mContext = null;
                AppMethodBeat.m2505o(15625);
                return dr;
            }
        }
        it = this.cgx.iterator();
        while (it.hasNext()) {
            dr = ((BaseUriSpanHandler) it.next()).mo4546dr(str);
            if (dr != null) {
                C4990ab.m7411d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", Integer.valueOf(dr.type));
                this.mContext = null;
                this.cgu.mContext = null;
                AppMethodBeat.m2505o(15625);
                return dr;
            }
        }
        this.mContext = null;
        this.cgu.mContext = null;
        C4990ab.m7410d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, nothing match");
        AppMethodBeat.m2505o(15625);
        return null;
    }

    /* renamed from: a */
    public final boolean mo4552a(Context context, C14932m c14932m, C44086g c44086g) {
        AppMethodBeat.m2504i(15626);
        if (c14932m == null) {
            C4990ab.m7410d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo is null");
            AppMethodBeat.m2505o(15626);
            return false;
        }
        String str = "MicroMsg.URISpanHandler";
        String str2 = "handleSpanClick, hrefInfo.getType:%d, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size:%d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(c14932m.type);
        objArr[1] = Boolean.valueOf(c44086g == null);
        objArr[2] = Integer.valueOf(this.cgv.size());
        objArr[3] = Integer.valueOf(this.cgw.size());
        objArr[4] = Integer.valueOf(this.cgx.size());
        C4990ab.m7411d(str, str2, objArr);
        if (context == null) {
            C4990ab.m7412e("MicroMsg.URISpanHandler", "handleSpanClick, context is null!");
            this.cgu.mContext = null;
            AppMethodBeat.m2505o(15626);
            return false;
        }
        BaseUriSpanHandler baseUriSpanHandler;
        this.mContext = context;
        this.cgu.mContext = this.mContext;
        Iterator it = this.cgv.iterator();
        while (it.hasNext()) {
            baseUriSpanHandler = (BaseUriSpanHandler) it.next();
            if (C1265e.contains(baseUriSpanHandler.mo4543Cm(), c14932m.type) && baseUriSpanHandler.mo4544a(c14932m, c44086g)) {
                C4990ab.m7411d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", baseUriSpanHandler.getClass().getName());
                this.mContext = null;
                this.cgu.mContext = null;
                AppMethodBeat.m2505o(15626);
                return true;
            }
        }
        it = this.cgw.iterator();
        while (it.hasNext()) {
            baseUriSpanHandler = (BaseUriSpanHandler) it.next();
            if (C1265e.contains(baseUriSpanHandler.mo4543Cm(), c14932m.type) && baseUriSpanHandler.mo4544a(c14932m, c44086g)) {
                C4990ab.m7411d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", baseUriSpanHandler.getClass().getName());
                this.mContext = null;
                this.cgu.mContext = null;
                AppMethodBeat.m2505o(15626);
                return true;
            }
        }
        it = this.cgx.iterator();
        while (it.hasNext()) {
            baseUriSpanHandler = (BaseUriSpanHandler) it.next();
            if (C1265e.contains(baseUriSpanHandler.mo4543Cm(), c14932m.type) && baseUriSpanHandler.mo4544a(c14932m, c44086g)) {
                C4990ab.m7411d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", baseUriSpanHandler.getClass().getName());
                this.mContext = null;
                this.cgu.mContext = null;
                AppMethodBeat.m2505o(15626);
                return true;
            }
        }
        this.mContext = null;
        this.cgu.mContext = null;
        C4990ab.m7410d("MicroMsg.URISpanHandler", "handleSpanClick, nothing handle");
        AppMethodBeat.m2505o(15626);
        return false;
    }

    /* renamed from: b */
    public final boolean mo4553b(Context context, String str, boolean z, C30156v c30156v, Bundle bundle) {
        AppMethodBeat.m2504i(15627);
        String str2 = "MicroMsg.URISpanHandler";
        String str3 = "handleUriJump, url:%s, isAllowScanQrCode:%b, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size: %d, mLowPriorityHandlerList.size: %d";
        Object[] objArr = new Object[6];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Boolean.valueOf(c30156v == null);
        objArr[3] = Integer.valueOf(this.cgv.size());
        objArr[4] = Integer.valueOf(this.cgw.size());
        objArr[5] = Integer.valueOf(this.cgx.size());
        C4990ab.m7411d(str2, str3, objArr);
        if (context == null) {
            C4990ab.m7412e("MicroMsg.URISpanHandler", "handleUriJump, context is null!");
            this.cgu.mContext = null;
            AppMethodBeat.m2505o(15627);
            return false;
        }
        this.mContext = context;
        this.cgu.mContext = this.mContext;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7410d("MicroMsg.URISpanHandler", "handleUriJump, url is null");
            this.mContext = null;
            this.cgu.mContext = null;
            AppMethodBeat.m2505o(15627);
            return false;
        }
        Iterator it = this.cgv.iterator();
        while (it.hasNext()) {
            if (((BaseUriSpanHandler) it.next()).mo4545a(str, z, c30156v, bundle)) {
                C4990ab.m7411d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", ((BaseUriSpanHandler) it.next()).getClass().getName());
                this.mContext = null;
                this.cgu.mContext = null;
                AppMethodBeat.m2505o(15627);
                return true;
            }
        }
        it = this.cgw.iterator();
        while (it.hasNext()) {
            if (((BaseUriSpanHandler) it.next()).mo4545a(str, z, c30156v, bundle)) {
                C4990ab.m7411d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", ((BaseUriSpanHandler) it.next()).getClass().getName());
                this.mContext = null;
                this.cgu.mContext = null;
                AppMethodBeat.m2505o(15627);
                return true;
            }
        }
        it = this.cgx.iterator();
        while (it.hasNext()) {
            if (((BaseUriSpanHandler) it.next()).mo4545a(str, z, c30156v, bundle)) {
                C4990ab.m7411d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", ((BaseUriSpanHandler) it.next()).getClass().getName());
                this.mContext = null;
                this.cgu.mContext = null;
                AppMethodBeat.m2505o(15627);
                return true;
            }
        }
        this.mContext = null;
        this.cgu.mContext = null;
        C4990ab.m7410d("MicroMsg.URISpanHandler", "handleUriJump, nothing handle");
        AppMethodBeat.m2505o(15627);
        return false;
    }

    private static boolean contains(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
