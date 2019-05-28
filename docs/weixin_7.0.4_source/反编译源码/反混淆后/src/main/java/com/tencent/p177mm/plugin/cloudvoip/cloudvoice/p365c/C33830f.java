package com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c;

import android.os.Looper;
import android.os.Process;
import android.util.SparseArray;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p1480b.C38802b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.wxmm.IConfCallBack;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.f */
final class C33830f {
    private IConfCallBack kzF = null;
    final SparseArray<HashSet<C33831a>> kzG = new SparseArray(5);

    /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.f$1 */
    class C68291 implements IConfCallBack {
        C68291() {
        }

        public final byte[] callBackFromConf(int i, int i2, byte[] bArr) {
            AppMethodBeat.m2504i(135481);
            C4990ab.m7417i("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: triggered native callback: %d, %d", Integer.valueOf(i), Integer.valueOf(i2));
            HashSet hashSet = (HashSet) C33830f.this.kzG.get(i);
            byte[] bArr2;
            if (hashSet == null || hashSet.size() <= 0) {
                C4990ab.m7421w("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: nobody's listening to event %d, what a pity!", Integer.valueOf(i));
                bArr2 = new byte[1];
                AppMethodBeat.m2505o(135481);
                return bArr2;
            }
            ArrayList arrayList = new ArrayList(1);
            byte[] bArr3 = new byte[1];
            Iterator it = hashSet.iterator();
            bArr2 = bArr3;
            while (it.hasNext()) {
                C33831a c33831a = (C33831a) it.next();
                if (c33831a != null) {
                    bArr2 = c33831a.mo35499bP(c33831a.mo35501i(i2, c33831a.mo35498az(bArr)));
                    if (!c33831a.bgp()) {
                        arrayList.add(c33831a);
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: item is null! weired");
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                hashSet.remove((C33831a) it2.next());
            }
            AppMethodBeat.m2505o(135481);
            return bArr2;
        }

        public final void callbackWriteLog(int i, String str, String str2, int i2, String str3, String str4, int i3) {
            AppMethodBeat.m2504i(135482);
            if (i >= C38802b.bgo()) {
                Xlog.logWrite2(i, "CloudVoIPNative:".concat(String.valueOf(str)), str2, str3, Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str4);
            }
            AppMethodBeat.m2505o(135482);
        }
    }

    /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.f$a */
    interface C33831a<InParamType, OutParamType> {
        /* renamed from: az */
        InParamType mo35498az(byte[] bArr);

        /* renamed from: bP */
        byte[] mo35499bP(OutParamType outParamType);

        boolean bgp();

        /* renamed from: i */
        OutParamType mo35501i(int i, InParamType inParamType);
    }

    C33830f() {
        AppMethodBeat.m2504i(135483);
        AppMethodBeat.m2505o(135483);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: fT */
    public final IConfCallBack mo54390fT(boolean z) {
        IConfCallBack iConfCallBack;
        AppMethodBeat.m2504i(135484);
        C4990ab.m7417i("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: trigger validate callback %b", Boolean.valueOf(z));
        synchronized (this) {
            if (z) {
                try {
                    this.kzF = new C68291();
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(135484);
                }
            } else {
                this.kzF = null;
            }
            this.kzG.clear();
            iConfCallBack = this.kzF;
        }
        AppMethodBeat.m2505o(135484);
        return iConfCallBack;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final <ConvertedDataType, OutParamType> void mo54388a(int i, C33831a<ConvertedDataType, OutParamType> c33831a) {
        int i2 = 1;
        AppMethodBeat.m2504i(135485);
        C4990ab.m7417i("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: registering event id: %d", Integer.valueOf(i));
        synchronized (this) {
            try {
                HashSet hashSet = (HashSet) this.kzG.get(i);
                if (hashSet == null) {
                    hashSet = new HashSet(1);
                } else {
                    i2 = 0;
                }
                hashSet.add(c33831a);
                if (i2 != 0) {
                    this.kzG.append(i, hashSet);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(135485);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final <ConvertedDataType, OutParamType> void mo54389b(int i, C33831a<ConvertedDataType, OutParamType> c33831a) {
        AppMethodBeat.m2504i(135486);
        synchronized (this) {
            try {
                HashSet hashSet = (HashSet) this.kzG.get(i);
                if (hashSet != null) {
                    hashSet.remove(c33831a);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(135486);
            }
        }
    }
}
