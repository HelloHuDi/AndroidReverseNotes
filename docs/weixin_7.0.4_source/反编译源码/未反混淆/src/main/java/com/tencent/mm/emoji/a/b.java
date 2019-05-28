package com.tencent.mm.emoji.a;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/emoji/model/EmojiStorageState;", "", "()V", "KVName", "", "KeyCaptureFull", "KeyCaptureSize", "KeyCustomFull", "KeyCustomSize", "KeySync", "TAG", "checkSize", "", "getKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "init", "isCaptureFull", "", "isCustomFull", "setCaptureFull", "full", "setCustomFull", "plugin-emojisdk_release"})
public final class b {
    private static final String TAG = TAG;
    private static final String eyC = eyC;
    public static final b eyD = new b();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class a extends k implements a.f.a.a<y> {
        public static final a eyE = new a();

        static {
            AppMethodBeat.i(63238);
            AppMethodBeat.o(63238);
        }

        a() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            boolean z = true;
            AppMethodBeat.i(63237);
            at dsZ = at.dsZ();
            j.o(dsZ, "EmojiStorageMgr.getInstance()");
            List MD = dsZ.aUp().MD(0);
            a OB = a.OB();
            j.o(OB, "EmojiStorageCache.getInstance()");
            ArrayList<EmojiInfo> OC = OB.OC();
            j.o(OC, "customList");
            for (EmojiInfo emojiInfo : OC) {
                j.o(emojiInfo, "it");
                if (!MD.contains(emojiInfo.Aq())) {
                    MD.add(emojiInfo.Aq());
                }
            }
            int size = MD.size();
            boolean z2 = size >= e.OM();
            b bVar = b.eyD;
            b.OE().putInt("normal_custom_size", size);
            bVar = b.eyD;
            b.OE().putBoolean("custom_full", z2);
            dsZ = at.dsZ();
            j.o(dsZ, "EmojiStorageMgr.getInstance()");
            List MD2 = dsZ.aUp().MD(1);
            OC = a.OB().bZ(false);
            j.o(OC, "captureList");
            for (EmojiInfo emojiInfo2 : OC) {
                j.o(emojiInfo2, "it");
                if (!MD2.contains(emojiInfo2.Aq())) {
                    MD2.add(emojiInfo2.Aq());
                }
            }
            int size2 = MD2.size();
            if (size2 < e.ON()) {
                z = false;
            }
            b bVar2 = b.eyD;
            b.OE().putInt("capture_custom_size", size2);
            bVar2 = b.eyD;
            b.OE().putBoolean("capture_full", z);
            bVar2 = b.eyD;
            ab.i(b.TAG, "init: normal size is " + size + ' ' + z2 + "; capture size is " + size2 + ' ' + z);
            y yVar = y.AUy;
            AppMethodBeat.o(63237);
            return yVar;
        }
    }

    static {
        AppMethodBeat.i(63244);
        AppMethodBeat.o(63244);
    }

    private b() {
    }

    public static as OE() {
        AppMethodBeat.i(63239);
        as amF = as.amF(eyC);
        j.o(amF, "MultiProcessMMKV.getMMKV(KVName)");
        AppMethodBeat.o(63239);
        return amF;
    }

    public static boolean OF() {
        AppMethodBeat.i(63240);
        boolean z = OE().getBoolean("capture_full", false);
        AppMethodBeat.o(63240);
        return z;
    }

    public static void ce(boolean z) {
        AppMethodBeat.i(63241);
        OE().putBoolean("custom_full", z);
        if (z && OE().getInt("normal_custom_size", 0) < e.OM()) {
            ab.w(TAG, "custom state mismatch!");
        }
        AppMethodBeat.o(63241);
    }

    public static void cf(boolean z) {
        AppMethodBeat.i(63242);
        OE().putBoolean("capture_full", z);
        if (z && OE().getInt("capture_custom_size", 0) < e.ON()) {
            ab.w(TAG, "capture state mismatch!");
        }
        AppMethodBeat.o(63242);
    }

    public static void OG() {
        AppMethodBeat.i(63243);
        com.tencent.mm.ab.b.a("EmojiStorageState_checkSize", (a.f.a.a) a.eyE);
        AppMethodBeat.o(63243);
    }
}
