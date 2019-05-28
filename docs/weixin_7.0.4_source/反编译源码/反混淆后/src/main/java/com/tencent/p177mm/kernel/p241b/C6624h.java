package com.tencent.p177mm.kernel.p241b;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.C1326d;
import com.tencent.p177mm.compatible.loader.C1439e;
import com.tencent.p177mm.p217ci.C6454a;
import com.tencent.p177mm.p217ci.C6454a.C1387a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;

/* renamed from: com.tencent.mm.kernel.b.h */
public final class C6624h extends C1681g {
    public C6454a<ApplicationLifeCycle> eMA = new C6454a();
    public ApplicationLike eMz;
    public C1326d ecL;
    public C1439e mProfileCompat;

    /* renamed from: com.tencent.mm.kernel.b.h$1 */
    class C66181 implements C1387a<ApplicationLifeCycle> {
        C66181() {
        }

        /* renamed from: ax */
        public final /* synthetic */ void mo4769ax(Object obj) {
            AppMethodBeat.m2504i(58074);
            ((ApplicationLifeCycle) obj).onCreate();
            AppMethodBeat.m2505o(58074);
        }
    }

    /* renamed from: com.tencent.mm.kernel.b.h$2 */
    public class C66192 implements C1387a<ApplicationLifeCycle> {
        /* renamed from: ax */
        public final /* synthetic */ void mo4769ax(Object obj) {
            AppMethodBeat.m2504i(58075);
            ((ApplicationLifeCycle) obj).onLowMemory();
            AppMethodBeat.m2505o(58075);
        }
    }

    /* renamed from: com.tencent.mm.kernel.b.h$3 */
    public class C66203 implements C1387a<ApplicationLifeCycle> {
        final /* synthetic */ int eMC;

        public C66203(int i) {
            this.eMC = i;
        }

        /* renamed from: ax */
        public final /* synthetic */ void mo4769ax(Object obj) {
            AppMethodBeat.m2504i(58076);
            ((ApplicationLifeCycle) obj).onTrimMemory(this.eMC);
            AppMethodBeat.m2505o(58076);
        }
    }

    /* renamed from: com.tencent.mm.kernel.b.h$4 */
    public class C66214 implements C1387a<ApplicationLifeCycle> {
        /* renamed from: ax */
        public final /* synthetic */ void mo4769ax(Object obj) {
            AppMethodBeat.m2504i(58077);
            ((ApplicationLifeCycle) obj).onTerminate();
            AppMethodBeat.m2505o(58077);
        }
    }

    /* renamed from: com.tencent.mm.kernel.b.h$5 */
    public class C66225 implements C1387a<ApplicationLifeCycle> {
        final /* synthetic */ Configuration eMD;

        public C66225(Configuration configuration) {
            this.eMD = configuration;
        }

        /* renamed from: ax */
        public final /* synthetic */ void mo4769ax(Object obj) {
            AppMethodBeat.m2504i(58078);
            ((ApplicationLifeCycle) obj).onConfigurationChanged(this.eMD);
            AppMethodBeat.m2505o(58078);
        }
    }

    /* renamed from: com.tencent.mm.kernel.b.h$6 */
    public class C66236 implements C1387a<ApplicationLifeCycle> {
        final /* synthetic */ Context val$context;

        public C66236(Context context) {
            this.val$context = context;
        }

        /* renamed from: ax */
        public final /* synthetic */ void mo4769ax(Object obj) {
            AppMethodBeat.m2504i(58079);
            ((ApplicationLifeCycle) obj).onBaseContextAttached(this.val$context);
            AppMethodBeat.m2505o(58079);
        }
    }

    public final String getPackageName() {
        AppMethodBeat.m2504i(139006);
        String packageName = C4996ah.getPackageName();
        AppMethodBeat.m2505o(139006);
        return packageName;
    }

    public C6624h(String str, Application application, ApplicationLike applicationLike) {
        super(str, application);
        AppMethodBeat.m2504i(58081);
        C4996ah.m7430ce(str);
        this.eMz = applicationLike;
        AppMethodBeat.m2505o(58081);
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(58082);
        this.eMA.mo14669a(new C66181());
        AppMethodBeat.m2505o(58082);
    }
}
