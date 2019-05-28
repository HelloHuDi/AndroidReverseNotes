package com.tencent.mm.app.plugin;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.e.b;
import com.tencent.mm.pluginsdk.ui.e.g;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

public final class e implements b {
    private static e cgt = null;
    private URISpanHandlerSet cgu;
    private ArrayList<BaseUriSpanHandler> cgv = new ArrayList();
    private ArrayList<BaseUriSpanHandler> cgw = new ArrayList();
    private ArrayList<BaseUriSpanHandler> cgx = new ArrayList();
    private Context mContext = null;

    public static e Cl() {
        AppMethodBeat.i(15623);
        if (cgt == null) {
            cgt = new e();
        }
        e eVar = cgt;
        AppMethodBeat.o(15623);
        return eVar;
    }

    private e() {
        AppMethodBeat.i(15624);
        long anU = bo.anU();
        ab.d("MicroMsg.URISpanHandler", "init URISpanHandler");
        this.mContext = ah.getContext();
        this.cgu = new URISpanHandlerSet(this.mContext);
        for (Class cls : URISpanHandlerSet.class.getDeclaredClasses()) {
            if (cls != null && cls.getSuperclass() != null && cls.isAnnotationPresent(a.class) && cls.getSuperclass().getName().equals(BaseUriSpanHandler.class.getName())) {
                try {
                    a aVar = (a) cls.getAnnotation(a.class);
                    Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[]{URISpanHandlerSet.class});
                    if (declaredConstructor != null) {
                        BaseUriSpanHandler baseUriSpanHandler = (BaseUriSpanHandler) BaseUriSpanHandler.class.cast(declaredConstructor.newInstance(new Object[]{this.cgu}));
                        PRIORITY Cn = aVar.Cn();
                        if (Cn == PRIORITY.LOW) {
                            this.cgx.add(baseUriSpanHandler);
                        } else if (Cn == PRIORITY.NORMAL) {
                            this.cgw.add(baseUriSpanHandler);
                        } else if (Cn == PRIORITY.HIGH) {
                            this.cgv.add(baseUriSpanHandler);
                        }
                        ab.d("MicroMsg.URISpanHandler", "successfully add: %s", cls.getName());
                    } else {
                        ab.d("MicroMsg.URISpanHandler", "failed to add %s, constructor is null!!", cls.getName());
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.URISpanHandler", e, "", new Object[0]);
                    ab.d("MicroMsg.URISpanHandler", "add %s error: %s, errorType:%s", cls.getName(), e.getMessage(), e.getClass().getName());
                }
            }
        }
        ab.d("MicroMsg.URISpanHandler", "init URISpanHandler used :%d ms", Long.valueOf(bo.anU() - anU));
        AppMethodBeat.o(15624);
    }

    public final m y(Context context, String str) {
        AppMethodBeat.i(15625);
        ab.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url:%s, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size：%d", str, Integer.valueOf(this.cgv.size()), Integer.valueOf(this.cgw.size()), Integer.valueOf(this.cgx.size()));
        if (context == null) {
            ab.e("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl error, context is null!");
            this.cgu.mContext = null;
            AppMethodBeat.o(15625);
            return null;
        }
        this.mContext = context;
        this.cgu.mContext = this.mContext;
        if (bo.isNullOrNil(str)) {
            ab.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url is null");
            this.mContext = null;
            this.cgu.mContext = null;
            AppMethodBeat.o(15625);
            return null;
        }
        m dr;
        Iterator it = this.cgv.iterator();
        while (it.hasNext()) {
            dr = ((BaseUriSpanHandler) it.next()).dr(str);
            if (dr != null) {
                ab.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", Integer.valueOf(dr.type));
                this.mContext = null;
                this.cgu.mContext = null;
                AppMethodBeat.o(15625);
                return dr;
            }
        }
        it = this.cgw.iterator();
        while (it.hasNext()) {
            dr = ((BaseUriSpanHandler) it.next()).dr(str);
            if (dr != null) {
                ab.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", Integer.valueOf(dr.type));
                this.mContext = null;
                this.cgu.mContext = null;
                AppMethodBeat.o(15625);
                return dr;
            }
        }
        it = this.cgx.iterator();
        while (it.hasNext()) {
            dr = ((BaseUriSpanHandler) it.next()).dr(str);
            if (dr != null) {
                ab.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", Integer.valueOf(dr.type));
                this.mContext = null;
                this.cgu.mContext = null;
                AppMethodBeat.o(15625);
                return dr;
            }
        }
        this.mContext = null;
        this.cgu.mContext = null;
        ab.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, nothing match");
        AppMethodBeat.o(15625);
        return null;
    }

    public final boolean a(Context context, m mVar, g gVar) {
        AppMethodBeat.i(15626);
        if (mVar == null) {
            ab.d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo is null");
            AppMethodBeat.o(15626);
            return false;
        }
        String str = "MicroMsg.URISpanHandler";
        String str2 = "handleSpanClick, hrefInfo.getType:%d, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size:%d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(mVar.type);
        objArr[1] = Boolean.valueOf(gVar == null);
        objArr[2] = Integer.valueOf(this.cgv.size());
        objArr[3] = Integer.valueOf(this.cgw.size());
        objArr[4] = Integer.valueOf(this.cgx.size());
        ab.d(str, str2, objArr);
        if (context == null) {
            ab.e("MicroMsg.URISpanHandler", "handleSpanClick, context is null!");
            this.cgu.mContext = null;
            AppMethodBeat.o(15626);
            return false;
        }
        BaseUriSpanHandler baseUriSpanHandler;
        this.mContext = context;
        this.cgu.mContext = this.mContext;
        Iterator it = this.cgv.iterator();
        while (it.hasNext()) {
            baseUriSpanHandler = (BaseUriSpanHandler) it.next();
            if (contains(baseUriSpanHandler.Cm(), mVar.type) && baseUriSpanHandler.a(mVar, gVar)) {
                ab.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", baseUriSpanHandler.getClass().getName());
                this.mContext = null;
                this.cgu.mContext = null;
                AppMethodBeat.o(15626);
                return true;
            }
        }
        it = this.cgw.iterator();
        while (it.hasNext()) {
            baseUriSpanHandler = (BaseUriSpanHandler) it.next();
            if (contains(baseUriSpanHandler.Cm(), mVar.type) && baseUriSpanHandler.a(mVar, gVar)) {
                ab.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", baseUriSpanHandler.getClass().getName());
                this.mContext = null;
                this.cgu.mContext = null;
                AppMethodBeat.o(15626);
                return true;
            }
        }
        it = this.cgx.iterator();
        while (it.hasNext()) {
            baseUriSpanHandler = (BaseUriSpanHandler) it.next();
            if (contains(baseUriSpanHandler.Cm(), mVar.type) && baseUriSpanHandler.a(mVar, gVar)) {
                ab.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", baseUriSpanHandler.getClass().getName());
                this.mContext = null;
                this.cgu.mContext = null;
                AppMethodBeat.o(15626);
                return true;
            }
        }
        this.mContext = null;
        this.cgu.mContext = null;
        ab.d("MicroMsg.URISpanHandler", "handleSpanClick, nothing handle");
        AppMethodBeat.o(15626);
        return false;
    }

    public final boolean b(Context context, String str, boolean z, v vVar, Bundle bundle) {
        AppMethodBeat.i(15627);
        String str2 = "MicroMsg.URISpanHandler";
        String str3 = "handleUriJump, url:%s, isAllowScanQrCode:%b, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size: %d, mLowPriorityHandlerList.size: %d";
        Object[] objArr = new Object[6];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Boolean.valueOf(vVar == null);
        objArr[3] = Integer.valueOf(this.cgv.size());
        objArr[4] = Integer.valueOf(this.cgw.size());
        objArr[5] = Integer.valueOf(this.cgx.size());
        ab.d(str2, str3, objArr);
        if (context == null) {
            ab.e("MicroMsg.URISpanHandler", "handleUriJump, context is null!");
            this.cgu.mContext = null;
            AppMethodBeat.o(15627);
            return false;
        }
        this.mContext = context;
        this.cgu.mContext = this.mContext;
        if (bo.isNullOrNil(str)) {
            ab.d("MicroMsg.URISpanHandler", "handleUriJump, url is null");
            this.mContext = null;
            this.cgu.mContext = null;
            AppMethodBeat.o(15627);
            return false;
        }
        Iterator it = this.cgv.iterator();
        while (it.hasNext()) {
            if (((BaseUriSpanHandler) it.next()).a(str, z, vVar, bundle)) {
                ab.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", ((BaseUriSpanHandler) it.next()).getClass().getName());
                this.mContext = null;
                this.cgu.mContext = null;
                AppMethodBeat.o(15627);
                return true;
            }
        }
        it = this.cgw.iterator();
        while (it.hasNext()) {
            if (((BaseUriSpanHandler) it.next()).a(str, z, vVar, bundle)) {
                ab.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", ((BaseUriSpanHandler) it.next()).getClass().getName());
                this.mContext = null;
                this.cgu.mContext = null;
                AppMethodBeat.o(15627);
                return true;
            }
        }
        it = this.cgx.iterator();
        while (it.hasNext()) {
            if (((BaseUriSpanHandler) it.next()).a(str, z, vVar, bundle)) {
                ab.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", ((BaseUriSpanHandler) it.next()).getClass().getName());
                this.mContext = null;
                this.cgu.mContext = null;
                AppMethodBeat.o(15627);
                return true;
            }
        }
        this.mContext = null;
        this.cgu.mContext = null;
        ab.d("MicroMsg.URISpanHandler", "handleUriJump, nothing handle");
        AppMethodBeat.o(15627);
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
