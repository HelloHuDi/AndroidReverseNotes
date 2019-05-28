package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.os.Looper;
import android.os.Process;
import android.util.SparseArray;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wxmm.IConfCallBack;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

final class f {
    private IConfCallBack kzF = null;
    final SparseArray<HashSet<a>> kzG = new SparseArray(5);

    interface a<InParamType, OutParamType> {
        InParamType az(byte[] bArr);

        byte[] bP(OutParamType outParamType);

        boolean bgp();

        OutParamType i(int i, InParamType inParamType);
    }

    f() {
        AppMethodBeat.i(135483);
        AppMethodBeat.o(135483);
    }

    /* Access modifiers changed, original: final */
    public final IConfCallBack fT(boolean z) {
        IConfCallBack iConfCallBack;
        AppMethodBeat.i(135484);
        ab.i("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: trigger validate callback %b", Boolean.valueOf(z));
        synchronized (this) {
            if (z) {
                try {
                    this.kzF = new IConfCallBack() {
                        public final byte[] callBackFromConf(int i, int i2, byte[] bArr) {
                            AppMethodBeat.i(135481);
                            ab.i("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: triggered native callback: %d, %d", Integer.valueOf(i), Integer.valueOf(i2));
                            HashSet hashSet = (HashSet) f.this.kzG.get(i);
                            byte[] bArr2;
                            if (hashSet == null || hashSet.size() <= 0) {
                                ab.w("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: nobody's listening to event %d, what a pity!", Integer.valueOf(i));
                                bArr2 = new byte[1];
                                AppMethodBeat.o(135481);
                                return bArr2;
                            }
                            ArrayList arrayList = new ArrayList(1);
                            byte[] bArr3 = new byte[1];
                            Iterator it = hashSet.iterator();
                            bArr2 = bArr3;
                            while (it.hasNext()) {
                                a aVar = (a) it.next();
                                if (aVar != null) {
                                    bArr2 = aVar.bP(aVar.i(i2, aVar.az(bArr)));
                                    if (!aVar.bgp()) {
                                        arrayList.add(aVar);
                                    }
                                } else {
                                    ab.e("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: item is null! weired");
                                }
                            }
                            Iterator it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                hashSet.remove((a) it2.next());
                            }
                            AppMethodBeat.o(135481);
                            return bArr2;
                        }

                        public final void callbackWriteLog(int i, String str, String str2, int i2, String str3, String str4, int i3) {
                            AppMethodBeat.i(135482);
                            if (i >= b.bgo()) {
                                Xlog.logWrite2(i, "CloudVoIPNative:".concat(String.valueOf(str)), str2, str3, Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str4);
                            }
                            AppMethodBeat.o(135482);
                        }
                    };
                } catch (Throwable th) {
                    AppMethodBeat.o(135484);
                }
            } else {
                this.kzF = null;
            }
            this.kzG.clear();
            iConfCallBack = this.kzF;
        }
        AppMethodBeat.o(135484);
        return iConfCallBack;
    }

    /* Access modifiers changed, original: final */
    public final <ConvertedDataType, OutParamType> void a(int i, a<ConvertedDataType, OutParamType> aVar) {
        int i2 = 1;
        AppMethodBeat.i(135485);
        ab.i("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: registering event id: %d", Integer.valueOf(i));
        synchronized (this) {
            try {
                HashSet hashSet = (HashSet) this.kzG.get(i);
                if (hashSet == null) {
                    hashSet = new HashSet(1);
                } else {
                    i2 = 0;
                }
                hashSet.add(aVar);
                if (i2 != 0) {
                    this.kzG.append(i, hashSet);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(135485);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final <ConvertedDataType, OutParamType> void b(int i, a<ConvertedDataType, OutParamType> aVar) {
        AppMethodBeat.i(135486);
        synchronized (this) {
            try {
                HashSet hashSet = (HashSet) this.kzG.get(i);
                if (hashSet != null) {
                    hashSet.remove(aVar);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(135486);
            }
        }
    }
}
