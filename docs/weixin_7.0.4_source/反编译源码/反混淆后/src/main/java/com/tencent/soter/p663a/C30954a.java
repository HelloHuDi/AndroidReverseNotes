package com.tencent.soter.p663a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.C40997a;
import com.tencent.soter.core.p1351c.C24321g;
import com.tencent.soter.core.p1351c.C44476d;
import com.tencent.soter.p663a.p1106b.C16163a;
import com.tencent.soter.p663a.p1106b.C16164b;
import com.tencent.soter.p663a.p1106b.C16165c;
import com.tencent.soter.p663a.p1106b.C16166d;
import com.tencent.soter.p663a.p1107c.C16167a;
import com.tencent.soter.p663a.p1108f.C30958e;
import com.tencent.soter.p663a.p664g.C24298b;
import com.tencent.soter.p663a.p664g.C24303i;
import com.tencent.soter.p663a.p664g.C24997l;
import com.tencent.soter.p663a.p664g.C30960j;
import com.tencent.soter.p663a.p664g.C30962k;
import com.tencent.soter.p663a.p664g.C40994f;
import com.tencent.soter.p663a.p664g.C44471e;
import com.tencent.soter.p663a.p664g.C44818h;

/* renamed from: com.tencent.soter.a.a */
public final class C30954a {

    /* renamed from: com.tencent.soter.a.a$1 */
    public static class C309551 implements Runnable {
        final /* synthetic */ C44471e AvI;
        final /* synthetic */ C16164b AvJ;
        final /* synthetic */ Context val$context;

        public C309551(Context context, C44471e c44471e, C16164b c16164b) {
            this.val$context = context;
            this.AvI = c44471e;
            this.AvJ = c16164b;
        }

        public final void run() {
            AppMethodBeat.m2504i(10453);
            C30960j c30960j = new C30960j(this.val$context, this.AvI);
            c30960j.Awl = this.AvJ;
            if (!C40994f.dRn().mo64934a(c30960j, new C16166d())) {
                C44476d.m80483e("Soter.SoterWrapperApi", "soter: add init task failed.", new Object[0]);
            }
            AppMethodBeat.m2505o(10453);
        }
    }

    /* renamed from: a */
    public static void m49587a(C16164b<C16165c> c16164b, boolean z, C30958e c30958e) {
        AppMethodBeat.m2504i(10454);
        C44476d.m80484i("Soter.SoterWrapperApi", "soter: starting prepare ask key. ", new Object[0]);
        C30962k c30962k = new C30962k(c30958e, z);
        c30962k.Awl = c16164b;
        if (!C40994f.dRn().mo64934a(c30962k, new C16165c())) {
            C44476d.m80482d("Soter.SoterWrapperApi", "soter: add prepareAppSecureKey task failed.", new Object[0]);
        }
        AppMethodBeat.m2505o(10454);
    }

    /* renamed from: a */
    public static void m49586a(C16164b<C16165c> c16164b, boolean z, int i, C30958e c30958e, C30958e c30958e2) {
        AppMethodBeat.m2504i(10455);
        C44476d.m80484i("Soter.SoterWrapperApi", "soter: starting prepare auth key: %d", Integer.valueOf(i));
        C24997l c24997l = new C24997l(i, c30958e, c30958e2, z);
        c24997l.Awl = c16164b;
        if (!C40994f.dRn().mo64934a(c24997l, new C16165c())) {
            C44476d.m80482d("Soter.SoterWrapperApi", "soter: add prepareAuthKey task failed.", new Object[0]);
        }
        AppMethodBeat.m2505o(10455);
    }

    /* renamed from: a */
    public static void m49585a(C16164b<C16163a> c16164b, C24298b c24298b) {
        AppMethodBeat.m2504i(10456);
        C44476d.m80484i("Soter.SoterWrapperApi", "soter: request authorize provide challenge. scene: %d", Integer.valueOf(c24298b.gOW));
        if (c24298b.Awh == 1 || c24298b.Awh == 2) {
            C24303i c24303i = new C24303i(c24298b);
            c24303i.Awl = c16164b;
            if (!C40994f.dRn().mo64934a(c24303i, new C16163a())) {
                C44476d.m80482d("Soter.SoterWrapperApi", "soter: add 2.0 requestAuthorizeAndSign task failed.", new Object[0]);
            }
            AppMethodBeat.m2505o(10456);
            return;
        }
        C44818h c44818h = new C44818h(c24298b);
        c44818h.Awl = c16164b;
        if (!C40994f.dRn().mo64934a(c44818h, new C16163a())) {
            C44476d.m80482d("Soter.SoterWrapperApi", "soter: add 1.0 requestAuthorizeAndSign task failed.", new Object[0]);
        }
        AppMethodBeat.m2505o(10456);
    }

    public static boolean dRc() {
        AppMethodBeat.m2504i(10457);
        if (C16167a.dRe().isInit() && C16167a.dRe().dRc()) {
            AppMethodBeat.m2505o(10457);
            return true;
        }
        AppMethodBeat.m2505o(10457);
        return false;
    }

    /* renamed from: Ri */
    public static boolean m49584Ri(int i) {
        AppMethodBeat.m2504i(10458);
        boolean isInit = C16167a.dRe().isInit();
        String str = (String) C16167a.dRe().dRg().get(i);
        if (!isInit || C24321g.isNullOrNil(str)) {
            if (isInit) {
                C44476d.m80486w("Soter.SoterWrapperApi", "soter: scene not registered in init. please make sure", new Object[0]);
                AppMethodBeat.m2505o(10458);
                return false;
            }
            C44476d.m80486w("Soter.SoterWrapperApi", "soter: not initialized yet", new Object[0]);
            AppMethodBeat.m2505o(10458);
            return false;
        } else if (C40997a.m71093cn(str, false).errCode == 0) {
            AppMethodBeat.m2505o(10458);
            return true;
        } else {
            AppMethodBeat.m2505o(10458);
            return false;
        }
    }
}
