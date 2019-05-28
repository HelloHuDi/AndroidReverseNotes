package com.tencent.mm.plugin.appbrand.permission;

import android.support.v4.widget.j;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i.f;
import com.tencent.mm.plugin.appbrand.jsapi.i.g;
import com.tencent.mm.plugin.appbrand.jsapi.k.p;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import junit.framework.Assert;

public class e {
    private static final HashMap<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b>, Integer> iwJ = new HashMap();
    private static final HashMap<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b>, String> iwK = new HashMap();
    private static final String[] iwR = new String[]{f.NAME, "createDownloadTask", com.tencent.mm.plugin.appbrand.jsapi.i.e.NAME, g.NAME};
    private final i gPI;
    private final int iwL;
    private final boolean iwM;
    private final LinkedList<b> iwN = new LinkedList();
    public final Object iwO;
    private AppRuntimeApiPermissionBundle iwP;
    public List<c> iwQ = new ArrayList();

    public interface c {
        void f(byte[] bArr, byte[] bArr2);
    }

    public static final class a {
        private static final a iwU = new a(-1, "fail:auth canceled");
        private static final a iwV = new a(-1, "fail:auth denied");
        private static final a iwW = new a(-2, "");
        private static final a iwX = new a(-1, "fail:access denied");
        private static final a iwY = new a(0, "");
        public final String bzH;
        public final int ret;

        public a(int i, String str) {
            this.ret = i;
            this.bzH = str;
        }

        static {
            AppMethodBeat.i(102284);
            AppMethodBeat.o(102284);
        }
    }

    public interface b {
        void a(a aVar);
    }

    private int a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, com.tencent.mm.plugin.appbrand.jsapi.b bVar, String str) {
        AppMethodBeat.i(102285);
        int a = a(cVar, bVar, str, true);
        AppMethodBeat.o(102285);
        return a;
    }

    public final int a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, com.tencent.mm.plugin.appbrand.jsapi.b bVar, String str, boolean z) {
        AppMethodBeat.i(102286);
        int a = a(cVar, bVar.getClass(), str, ai(bVar.getClass()), z);
        AppMethodBeat.o(102286);
        return a;
    }

    private int a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> cls) {
        AppMethodBeat.i(102287);
        int a = a(cVar, cls, null, ai(cls), true);
        AppMethodBeat.o(102287);
        return a;
    }

    private int a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> cls, String str, int i, boolean z) {
        AppMethodBeat.i(102288);
        int i2 = this.iwL;
        String appId = cVar.getAppId();
        if (i2 == -1) {
            ab.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm on", appId, Integer.valueOf(i));
            AppMethodBeat.o(102288);
            return 1;
        } else if (i2 == -2) {
            ab.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm off", appId, Integer.valueOf(i));
            AppMethodBeat.o(102288);
            return 0;
        } else if (cls.isAssignableFrom(p.class) && (cVar instanceof u)) {
            AppMethodBeat.o(102288);
            return 1;
        } else {
            i2 = c.c(cVar, aj(cls), str);
            if (i2 != j.INVALID_ID) {
                AppMethodBeat.o(102288);
                return i2;
            }
            int E = E(z(cVar), i);
            if (z) {
                g gVar = (g) cVar.B(g.class);
                Object obj = (gVar == null || !gVar.ak(cls)) ? 1 : null;
                if (obj != null) {
                    ab.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, apiName = %s, ctrlIndex = %d, ctrlIndexLength %d, checkRet %d", appId, r3, Integer.valueOf(i), Integer.valueOf(r4.length), Integer.valueOf(E));
                }
            }
            AppMethodBeat.o(102288);
            return E;
        }
    }

    public final byte[] z(com.tencent.mm.plugin.appbrand.jsapi.c cVar) {
        AppMethodBeat.i(102289);
        int i = this.iwL;
        byte[] bArr;
        if (i == -1) {
            bArr = new byte[]{(byte) 1};
            AppMethodBeat.o(102289);
            return bArr;
        } else if (i == -2) {
            bArr = new byte[]{(byte) 0};
            AppMethodBeat.o(102289);
            return bArr;
        } else {
            AppRuntimeApiPermissionBundle aKx = aKx();
            if (cVar instanceof q) {
                switch (this.gPI.gNN.gWy.awz()) {
                    case SUSPEND:
                    case DESTROYED:
                    case BACKGROUND:
                        bArr = aKx.iwH;
                        break;
                    default:
                        bArr = aKx.iwG;
                        break;
                }
            }
            bArr = aKx.iwG;
            AppMethodBeat.o(102289);
            return bArr;
        }
    }

    public final int E(byte[] bArr, int i) {
        int i2 = this.iwL;
        if (i2 == -1) {
            return 1;
        }
        if (i2 == -2) {
            return 0;
        }
        if (i == -2) {
            return 1;
        }
        if (i == -1) {
            if (this.iwM) {
                return 1;
            }
            return 0;
        } else if (i >= bArr.length || i < 0) {
            return 0;
        } else {
            return bArr[i];
        }
    }

    @Deprecated
    public final boolean b(com.tencent.mm.plugin.appbrand.jsapi.c cVar, Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> cls) {
        AppMethodBeat.i(102290);
        if (a(cVar, (Class) cls) == 1) {
            AppMethodBeat.o(102290);
            return true;
        }
        AppMethodBeat.o(102290);
        return false;
    }

    public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, com.tencent.mm.plugin.appbrand.jsapi.b bVar) {
        AppMethodBeat.i(102291);
        if (a(cVar, bVar, null, null).ret == 0) {
            AppMethodBeat.o(102291);
            return true;
        }
        AppMethodBeat.o(102291);
        return false;
    }

    static {
        AppMethodBeat.i(102302);
        AppMethodBeat.o(102302);
    }

    private static int ai(Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> cls) {
        AppMethodBeat.i(102292);
        Integer num = (Integer) iwJ.get(cls);
        int intValue;
        if (num != null) {
            intValue = num.intValue();
            AppMethodBeat.o(102292);
            return intValue;
        }
        try {
            intValue = ((Integer) org.a.a.be(cls).get("CTRL_INDEX")).intValue();
        } catch (org.a.b e) {
            Assert.assertTrue("Must declare CTRL_INDEX in JsApi Class: " + cls.getName(), true);
            intValue = -1;
        }
        iwJ.put(cls, Integer.valueOf(intValue));
        AppMethodBeat.o(102292);
        return intValue;
    }

    private static String aj(Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> cls) {
        AppMethodBeat.i(102293);
        String str = (String) iwK.get(cls);
        if (bo.isNullOrNil(str)) {
            try {
                str = (String) org.a.a.be(cls).get("NAME");
                iwK.put(cls, str);
                AppMethodBeat.o(102293);
                return str;
            } catch (org.a.b e) {
                Assert.assertTrue("Must declare NAME in JsApi Class: " + cls.getName(), true);
                str = cls.getSimpleName();
                AppMethodBeat.o(102293);
                return str;
            }
        }
        AppMethodBeat.o(102293);
        return str;
    }

    public e(i iVar, int i, boolean z) {
        AppMethodBeat.i(102294);
        this.gPI = iVar;
        this.iwO = new byte[0];
        this.iwL = i;
        this.iwM = z;
        a((AppRuntimeApiPermissionBundle) iVar.aa(AppRuntimeApiPermissionBundle.class));
        iVar.gNN.a(new com.tencent.mm.plugin.appbrand.b.c.a() {
            public final void a(String str, com.tencent.mm.plugin.appbrand.b.b bVar) {
                AppMethodBeat.i(102279);
                switch (AnonymousClass3.gWN[bVar.ordinal()]) {
                    case 2:
                        e.b(e.this);
                        break;
                    case 4:
                        e.a(e.this);
                        AppMethodBeat.o(102279);
                        return;
                }
                AppMethodBeat.o(102279);
            }
        });
        AppMethodBeat.o(102294);
    }

    public final void a(AppRuntimeApiPermissionBundle appRuntimeApiPermissionBundle) {
        AppMethodBeat.i(102295);
        if (appRuntimeApiPermissionBundle == null) {
            AppMethodBeat.o(102295);
            return;
        }
        AppRuntimeApiPermissionBundle appRuntimeApiPermissionBundle2;
        synchronized (this.iwO) {
            try {
                appRuntimeApiPermissionBundle2 = this.iwP;
                this.iwP = appRuntimeApiPermissionBundle;
                b(this.iwP);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(102295);
            }
        }
        ab.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePermission old %s, updated %s", appRuntimeApiPermissionBundle2, appRuntimeApiPermissionBundle);
    }

    private void b(AppRuntimeApiPermissionBundle appRuntimeApiPermissionBundle) {
        AppMethodBeat.i(102296);
        byte[] bArr = appRuntimeApiPermissionBundle.iwG;
        byte[] bArr2 = appRuntimeApiPermissionBundle.iwH;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iwQ.size()) {
                ((c) this.iwQ.get(i2)).f(bArr, bArr2);
                i = i2 + 1;
            } else {
                AppMethodBeat.o(102296);
                return;
            }
        }
    }

    public final Vector<byte[]> aKw() {
        AppMethodBeat.i(102297);
        synchronized (this.iwO) {
            try {
                if (this.iwP != null) {
                    byte[] bArr = this.iwP.iwG;
                    byte[] bArr2 = this.iwP.iwH;
                    byte[] bArr3 = this.iwP.iwI;
                    Vector<byte[]> vector = new Vector(3);
                    vector.addElement(bArr);
                    vector.addElement(bArr2);
                    vector.addElement(bArr3);
                    AppMethodBeat.o(102297);
                    return vector;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(102297);
            }
        }
        return null;
    }

    private AppRuntimeApiPermissionBundle aKx() {
        AppRuntimeApiPermissionBundle appRuntimeApiPermissionBundle;
        synchronized (this.iwO) {
            appRuntimeApiPermissionBundle = this.iwP;
        }
        return appRuntimeApiPermissionBundle;
    }

    private void a(b bVar) {
        AppMethodBeat.i(102298);
        if (bVar == null) {
            AppMethodBeat.o(102298);
            return;
        }
        synchronized (this.iwN) {
            try {
                this.iwN.addLast(bVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(102298);
            }
        }
    }

    public final a a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, com.tencent.mm.plugin.appbrand.jsapi.b bVar, String str, final b bVar2) {
        AppMethodBeat.i(102299);
        a aKz;
        if (bVar == null || cVar == null) {
            aKz = a.iwX;
            AppMethodBeat.o(102299);
            return aKz;
        }
        com.tencent.mm.plugin.appbrand.b.b awz = this.gPI.gNN.gWy.awz();
        int a = a(cVar, bVar, str);
        String appId = cVar.getAppId();
        if (a == 6) {
            ((f) cVar.B(f.class)).Dq(bVar.getName());
            aKz = a.iwX;
            AppMethodBeat.o(102299);
            return aKz;
        } else if (a == 1) {
            if ((cVar instanceof q) && awz == com.tencent.mm.plugin.appbrand.b.b.SUSPEND && com.tencent.mm.compatible.loader.a.contains(iwR, bVar.getName())) {
                aKz = new a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[]{bVar.getName(), awz.name().toLowerCase(), "permission ok", "network api interrupted in suspend state"}));
                AppMethodBeat.o(102299);
                return aKz;
            }
            aKz = a.iwY;
            AppMethodBeat.o(102299);
            return aKz;
        } else if (a == 4) {
            if (d.cK(appId, bVar.getName())) {
                aKz = a.iwY;
                AppMethodBeat.o(102299);
                return aKz;
            } else if (d.a((h) cVar, bVar.getName())) {
                aKz = a.iwY;
                AppMethodBeat.o(102299);
                return aKz;
            } else {
                d.a((h) cVar, bVar.getName(), new com.tencent.mm.plugin.appbrand.permission.d.b() {
                    public final void aIX() {
                        AppMethodBeat.i(102280);
                        if (bVar2 != null) {
                            bVar2.a(a.iwY);
                        }
                        AppMethodBeat.o(102280);
                    }

                    public final void CW(String str) {
                        AppMethodBeat.i(102281);
                        if (bVar2 != null) {
                            if (TextUtils.isEmpty(str)) {
                                bVar2.a(a.iwV);
                                AppMethodBeat.o(102281);
                                return;
                            }
                            bVar2.a(new a(-1, str));
                        }
                        AppMethodBeat.o(102281);
                    }

                    public final void onCancel() {
                        AppMethodBeat.i(102282);
                        if (bVar2 != null) {
                            bVar2.a(a.iwU);
                        }
                        AppMethodBeat.o(102282);
                    }
                });
                aKz = a.iwW;
                AppMethodBeat.o(102299);
                return aKz;
            }
        } else if (a == 7) {
            if (this.gPI.gNN.awx()) {
                aKz = a.iwY;
                AppMethodBeat.o(102299);
                return aKz;
            }
            aKz = new a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[]{bVar.getName(), awz.name().toLowerCase(), "permission ok", "jsapi permission required playing audio but current not playing audio in background state"}));
            AppMethodBeat.o(102299);
            return aKz;
        } else if (a == 8) {
            a(bVar2);
            aKz = a.iwW;
            AppMethodBeat.o(102299);
            return aKz;
        } else {
            aKz = a.iwX;
            AppMethodBeat.o(102299);
            return aKz;
        }
    }
}
