package com.tencent.p177mm.plugin.appbrand.permission;

import android.support.p057v4.widget.C8415j;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.loader.C32473a;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10332b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C38309e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C38312g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C45604f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C16667p;
import com.tencent.p177mm.plugin.appbrand.p281b.C10136c.C10137a;
import com.tencent.p177mm.plugin.appbrand.p281b.C45524b;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.permission.C38487d.C2430b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import junit.framework.Assert;
import org.p1430a.C41166a;
import org.p1430a.C46853b;

/* renamed from: com.tencent.mm.plugin.appbrand.permission.e */
public class C33491e {
    private static final HashMap<Class<? extends C10332b>, Integer> iwJ = new HashMap();
    private static final HashMap<Class<? extends C10332b>, String> iwK = new HashMap();
    private static final String[] iwR = new String[]{C45604f.NAME, "createDownloadTask", C38309e.NAME, C38312g.NAME};
    private final C6750i gPI;
    private final int iwL;
    private final boolean iwM;
    private final LinkedList<C33494b> iwN = new LinkedList();
    public final Object iwO;
    private AppRuntimeApiPermissionBundle iwP;
    public List<C33492c> iwQ = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.appbrand.permission.e$1 */
    class C196591 implements C10137a {
        C196591() {
        }

        /* renamed from: a */
        public final void mo6006a(String str, C45524b c45524b) {
            AppMethodBeat.m2504i(102279);
            switch (C196603.gWN[c45524b.ordinal()]) {
                case 2:
                    C33491e.m54706b(C33491e.this);
                    break;
                case 4:
                    C33491e.m54702a(C33491e.this);
                    AppMethodBeat.m2505o(102279);
                    return;
            }
            AppMethodBeat.m2505o(102279);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.permission.e$c */
    public interface C33492c {
        /* renamed from: f */
        void mo44862f(byte[] bArr, byte[] bArr2);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.permission.e$a */
    public static final class C33493a {
        private static final C33493a iwU = new C33493a(-1, "fail:auth canceled");
        private static final C33493a iwV = new C33493a(-1, "fail:auth denied");
        private static final C33493a iwW = new C33493a(-2, "");
        private static final C33493a iwX = new C33493a(-1, "fail:access denied");
        private static final C33493a iwY = new C33493a(0, "");
        public final String bzH;
        public final int ret;

        public C33493a(int i, String str) {
            this.ret = i;
            this.bzH = str;
        }

        static {
            AppMethodBeat.m2504i(102284);
            AppMethodBeat.m2505o(102284);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.permission.e$b */
    public interface C33494b {
        /* renamed from: a */
        void mo5871a(C33493a c33493a);
    }

    /* renamed from: a */
    private int m54698a(C2241c c2241c, C10332b c10332b, String str) {
        AppMethodBeat.m2504i(102285);
        int a = mo53976a(c2241c, c10332b, str, true);
        AppMethodBeat.m2505o(102285);
        return a;
    }

    /* renamed from: a */
    public final int mo53976a(C2241c c2241c, C10332b c10332b, String str, boolean z) {
        AppMethodBeat.m2504i(102286);
        int a = m54700a(c2241c, c10332b.getClass(), str, C33491e.m54703ai(c10332b.getClass()), z);
        AppMethodBeat.m2505o(102286);
        return a;
    }

    /* renamed from: a */
    private int m54699a(C2241c c2241c, Class<? extends C10332b> cls) {
        AppMethodBeat.m2504i(102287);
        int a = m54700a(c2241c, cls, null, C33491e.m54703ai(cls), true);
        AppMethodBeat.m2505o(102287);
        return a;
    }

    /* renamed from: a */
    private int m54700a(C2241c c2241c, Class<? extends C10332b> cls, String str, int i, boolean z) {
        AppMethodBeat.m2504i(102288);
        int i2 = this.iwL;
        String appId = c2241c.getAppId();
        if (i2 == -1) {
            C4990ab.m7411d("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm on", appId, Integer.valueOf(i));
            AppMethodBeat.m2505o(102288);
            return 1;
        } else if (i2 == -2) {
            C4990ab.m7411d("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm off", appId, Integer.valueOf(i));
            AppMethodBeat.m2505o(102288);
            return 0;
        } else if (cls.isAssignableFrom(C16667p.class) && (c2241c instanceof C44709u)) {
            AppMethodBeat.m2505o(102288);
            return 1;
        } else {
            i2 = C42653c.m75525c(c2241c, C33491e.m54704aj(cls), str);
            if (i2 != C8415j.INVALID_ID) {
                AppMethodBeat.m2505o(102288);
                return i2;
            }
            int E = mo53975E(mo53982z(c2241c), i);
            if (z) {
                C31331g c31331g = (C31331g) c2241c.mo5936B(C31331g.class);
                Object obj = (c31331g == null || !c31331g.mo51295ak(cls)) ? 1 : null;
                if (obj != null) {
                    C4990ab.m7417i("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, apiName = %s, ctrlIndex = %d, ctrlIndexLength %d, checkRet %d", appId, r3, Integer.valueOf(i), Integer.valueOf(r4.length), Integer.valueOf(E));
                }
            }
            AppMethodBeat.m2505o(102288);
            return E;
        }
    }

    /* renamed from: z */
    public final byte[] mo53982z(C2241c c2241c) {
        AppMethodBeat.m2504i(102289);
        int i = this.iwL;
        byte[] bArr;
        if (i == -1) {
            bArr = new byte[]{(byte) 1};
            AppMethodBeat.m2505o(102289);
            return bArr;
        } else if (i == -2) {
            bArr = new byte[]{(byte) 0};
            AppMethodBeat.m2505o(102289);
            return bArr;
        } else {
            AppRuntimeApiPermissionBundle aKx = aKx();
            if (c2241c instanceof C38492q) {
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
            AppMethodBeat.m2505o(102289);
            return bArr;
        }
    }

    /* renamed from: E */
    public final int mo53975E(byte[] bArr, int i) {
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
    /* renamed from: b */
    public final boolean mo53981b(C2241c c2241c, Class<? extends C10332b> cls) {
        AppMethodBeat.m2504i(102290);
        if (m54699a(c2241c, (Class) cls) == 1) {
            AppMethodBeat.m2505o(102290);
            return true;
        }
        AppMethodBeat.m2505o(102290);
        return false;
    }

    /* renamed from: a */
    public final boolean mo53979a(C2241c c2241c, C10332b c10332b) {
        AppMethodBeat.m2504i(102291);
        if (mo53977a(c2241c, c10332b, null, null).ret == 0) {
            AppMethodBeat.m2505o(102291);
            return true;
        }
        AppMethodBeat.m2505o(102291);
        return false;
    }

    static {
        AppMethodBeat.m2504i(102302);
        AppMethodBeat.m2505o(102302);
    }

    /* renamed from: ai */
    private static int m54703ai(Class<? extends C10332b> cls) {
        AppMethodBeat.m2504i(102292);
        Integer num = (Integer) iwJ.get(cls);
        int intValue;
        if (num != null) {
            intValue = num.intValue();
            AppMethodBeat.m2505o(102292);
            return intValue;
        }
        try {
            intValue = ((Integer) C41166a.m71619be(cls).get("CTRL_INDEX")).intValue();
        } catch (C46853b e) {
            Assert.assertTrue("Must declare CTRL_INDEX in JsApi Class: " + cls.getName(), true);
            intValue = -1;
        }
        iwJ.put(cls, Integer.valueOf(intValue));
        AppMethodBeat.m2505o(102292);
        return intValue;
    }

    /* renamed from: aj */
    private static String m54704aj(Class<? extends C10332b> cls) {
        AppMethodBeat.m2504i(102293);
        String str = (String) iwK.get(cls);
        if (C5046bo.isNullOrNil(str)) {
            try {
                str = (String) C41166a.m71619be(cls).get("NAME");
                iwK.put(cls, str);
                AppMethodBeat.m2505o(102293);
                return str;
            } catch (C46853b e) {
                Assert.assertTrue("Must declare NAME in JsApi Class: " + cls.getName(), true);
                str = cls.getSimpleName();
                AppMethodBeat.m2505o(102293);
                return str;
            }
        }
        AppMethodBeat.m2505o(102293);
        return str;
    }

    public C33491e(C6750i c6750i, int i, boolean z) {
        AppMethodBeat.m2504i(102294);
        this.gPI = c6750i;
        this.iwO = new byte[0];
        this.iwL = i;
        this.iwM = z;
        mo53978a((AppRuntimeApiPermissionBundle) c6750i.mo14986aa(AppRuntimeApiPermissionBundle.class));
        c6750i.gNN.mo21486a(new C196591());
        AppMethodBeat.m2505o(102294);
    }

    /* renamed from: a */
    public final void mo53978a(AppRuntimeApiPermissionBundle appRuntimeApiPermissionBundle) {
        AppMethodBeat.m2504i(102295);
        if (appRuntimeApiPermissionBundle == null) {
            AppMethodBeat.m2505o(102295);
            return;
        }
        AppRuntimeApiPermissionBundle appRuntimeApiPermissionBundle2;
        synchronized (this.iwO) {
            try {
                appRuntimeApiPermissionBundle2 = this.iwP;
                this.iwP = appRuntimeApiPermissionBundle;
                m54705b(this.iwP);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(102295);
            }
        }
        C4990ab.m7417i("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePermission old %s, updated %s", appRuntimeApiPermissionBundle2, appRuntimeApiPermissionBundle);
    }

    /* renamed from: b */
    private void m54705b(AppRuntimeApiPermissionBundle appRuntimeApiPermissionBundle) {
        AppMethodBeat.m2504i(102296);
        byte[] bArr = appRuntimeApiPermissionBundle.iwG;
        byte[] bArr2 = appRuntimeApiPermissionBundle.iwH;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iwQ.size()) {
                ((C33492c) this.iwQ.get(i2)).mo44862f(bArr, bArr2);
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(102296);
                return;
            }
        }
    }

    public final Vector<byte[]> aKw() {
        AppMethodBeat.m2504i(102297);
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
                    AppMethodBeat.m2505o(102297);
                    return vector;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(102297);
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

    /* renamed from: a */
    private void m54701a(C33494b c33494b) {
        AppMethodBeat.m2504i(102298);
        if (c33494b == null) {
            AppMethodBeat.m2505o(102298);
            return;
        }
        synchronized (this.iwN) {
            try {
                this.iwN.addLast(c33494b);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(102298);
            }
        }
    }

    /* renamed from: a */
    public final C33493a mo53977a(C2241c c2241c, C10332b c10332b, String str, final C33494b c33494b) {
        AppMethodBeat.m2504i(102299);
        C33493a aKz;
        if (c10332b == null || c2241c == null) {
            aKz = C33493a.iwX;
            AppMethodBeat.m2505o(102299);
            return aKz;
        }
        C45524b awz = this.gPI.gNN.gWy.awz();
        int a = m54698a(c2241c, c10332b, str);
        String appId = c2241c.getAppId();
        if (a == 6) {
            ((C19661f) c2241c.mo5936B(C19661f.class)).mo34900Dq(c10332b.getName());
            aKz = C33493a.iwX;
            AppMethodBeat.m2505o(102299);
            return aKz;
        } else if (a == 1) {
            if ((c2241c instanceof C38492q) && awz == C45524b.SUSPEND && C32473a.contains(iwR, c10332b.getName())) {
                aKz = new C33493a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[]{c10332b.getName(), awz.name().toLowerCase(), "permission ok", "network api interrupted in suspend state"}));
                AppMethodBeat.m2505o(102299);
                return aKz;
            }
            aKz = C33493a.iwY;
            AppMethodBeat.m2505o(102299);
            return aKz;
        } else if (a == 4) {
            if (C38487d.m65129cK(appId, c10332b.getName())) {
                aKz = C33493a.iwY;
                AppMethodBeat.m2505o(102299);
                return aKz;
            } else if (C38487d.m65125a((C33327h) c2241c, c10332b.getName())) {
                aKz = C33493a.iwY;
                AppMethodBeat.m2505o(102299);
                return aKz;
            } else {
                C38487d.m65122a((C33327h) c2241c, c10332b.getName(), new C2430b() {
                    public final void aIX() {
                        AppMethodBeat.m2504i(102280);
                        if (c33494b != null) {
                            c33494b.mo5871a(C33493a.iwY);
                        }
                        AppMethodBeat.m2505o(102280);
                    }

                    /* renamed from: CW */
                    public final void mo6342CW(String str) {
                        AppMethodBeat.m2504i(102281);
                        if (c33494b != null) {
                            if (TextUtils.isEmpty(str)) {
                                c33494b.mo5871a(C33493a.iwV);
                                AppMethodBeat.m2505o(102281);
                                return;
                            }
                            c33494b.mo5871a(new C33493a(-1, str));
                        }
                        AppMethodBeat.m2505o(102281);
                    }

                    public final void onCancel() {
                        AppMethodBeat.m2504i(102282);
                        if (c33494b != null) {
                            c33494b.mo5871a(C33493a.iwU);
                        }
                        AppMethodBeat.m2505o(102282);
                    }
                });
                aKz = C33493a.iwW;
                AppMethodBeat.m2505o(102299);
                return aKz;
            }
        } else if (a == 7) {
            if (this.gPI.gNN.awx()) {
                aKz = C33493a.iwY;
                AppMethodBeat.m2505o(102299);
                return aKz;
            }
            aKz = new C33493a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[]{c10332b.getName(), awz.name().toLowerCase(), "permission ok", "jsapi permission required playing audio but current not playing audio in background state"}));
            AppMethodBeat.m2505o(102299);
            return aKz;
        } else if (a == 8) {
            m54701a(c33494b);
            aKz = C33493a.iwW;
            AppMethodBeat.m2505o(102299);
            return aKz;
        } else {
            aKz = C33493a.iwX;
            AppMethodBeat.m2505o(102299);
            return aKz;
        }
    }
}
