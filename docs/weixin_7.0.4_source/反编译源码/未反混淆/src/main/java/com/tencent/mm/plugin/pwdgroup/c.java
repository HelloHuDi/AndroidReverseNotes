package com.tencent.mm.plugin.pwdgroup;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.ah.o;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.pwdgroup.b.a;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class c implements at {
    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(23979);
        a.pqK = new i.a() {
            private Bitmap cdX = null;
            private f<String, WeakReference<Bitmap>> pqL;

            {
                AppMethodBeat.i(23976);
                try {
                    this.cdX = b.b(ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bz.a.getDensity(null));
                } catch (IOException e) {
                    ab.printErrStackTrace("MicroMsg.Facing.SubCorePwdGroup", e, "", new Object[0]);
                }
                this.pqL = new com.tencent.mm.memory.a.b(15, getClass());
                AppMethodBeat.o(23976);
            }

            public final void a(i iVar) {
                AppMethodBeat.i(23977);
                if (iVar instanceof com.tencent.mm.ah.d.a) {
                    o.acd().a((com.tencent.mm.ah.d.a) iVar);
                }
                AppMethodBeat.o(23977);
            }

            public final Bitmap cQ(String str) {
                AppMethodBeat.i(23978);
                WeakReference weakReference = (WeakReference) this.pqL.get(str);
                Bitmap a;
                if (weakReference == null || weakReference.get() == null || ((Bitmap) weakReference.get()).isRecycled() || weakReference.get() != AZ()) {
                    a = com.tencent.mm.ah.b.a(str, false, -1);
                    if (a == null || a.isRecycled()) {
                        a = this.cdX;
                    } else {
                        this.pqL.k(str, new WeakReference(a));
                    }
                    AppMethodBeat.o(23978);
                    return a;
                }
                a = (Bitmap) weakReference.get();
                AppMethodBeat.o(23978);
                return a;
            }

            public final Bitmap AZ() {
                return this.cdX;
            }

            public final Bitmap cR(String str) {
                return null;
            }

            public final Bitmap b(String str, int i, int i2, int i3) {
                return null;
            }
        };
        AppMethodBeat.o(23979);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
    }
}
