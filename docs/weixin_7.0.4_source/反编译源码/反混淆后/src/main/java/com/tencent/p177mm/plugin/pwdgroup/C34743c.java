package com.tencent.p177mm.plugin.pwdgroup;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.p259a.C26399b;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.pwdgroup.C34742b.C21505a;
import com.tencent.p177mm.pluginsdk.p597ui.C46507i;
import com.tencent.p177mm.pluginsdk.p597ui.C46507i.C14947a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.pwdgroup.c */
public final class C34743c implements C1816at {

    /* renamed from: com.tencent.mm.plugin.pwdgroup.c$1 */
    class C36431 implements C14947a {
        private Bitmap cdX = null;
        private C1177f<String, WeakReference<Bitmap>> pqL;

        C36431() {
            AppMethodBeat.m2504i(23976);
            try {
                this.cdX = C4977b.m7372b(C4996ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), C1338a.getDensity(null));
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.Facing.SubCorePwdGroup", e, "", new Object[0]);
            }
            this.pqL = new C26399b(15, getClass());
            AppMethodBeat.m2505o(23976);
        }

        /* renamed from: a */
        public final void mo8230a(C46507i c46507i) {
            AppMethodBeat.m2504i(23977);
            if (c46507i instanceof C8915a) {
                C17884o.acd().mo67498a((C8915a) c46507i);
            }
            AppMethodBeat.m2505o(23977);
        }

        /* renamed from: cQ */
        public final Bitmap mo8232cQ(String str) {
            AppMethodBeat.m2504i(23978);
            WeakReference weakReference = (WeakReference) this.pqL.get(str);
            Bitmap a;
            if (weakReference == null || weakReference.get() == null || ((Bitmap) weakReference.get()).isRecycled() || weakReference.get() != mo8229AZ()) {
                a = C41730b.m73490a(str, false, -1);
                if (a == null || a.isRecycled()) {
                    a = this.cdX;
                } else {
                    this.pqL.mo4412k(str, new WeakReference(a));
                }
                AppMethodBeat.m2505o(23978);
                return a;
            }
            a = (Bitmap) weakReference.get();
            AppMethodBeat.m2505o(23978);
            return a;
        }

        /* renamed from: AZ */
        public final Bitmap mo8229AZ() {
            return this.cdX;
        }

        /* renamed from: cR */
        public final Bitmap mo8233cR(String str) {
            return null;
        }

        /* renamed from: b */
        public final Bitmap mo8231b(String str, int i, int i2, int i3) {
            return null;
        }
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(23979);
        C21505a.pqK = new C36431();
        AppMethodBeat.m2505o(23979);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
    }
}
