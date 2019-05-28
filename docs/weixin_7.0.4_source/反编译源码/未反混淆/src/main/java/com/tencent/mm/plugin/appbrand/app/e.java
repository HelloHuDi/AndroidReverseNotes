package com.tencent.mm.plugin.appbrand.app;

import a.f.b.j;
import a.l;
import android.annotation.SuppressLint;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event;
import com.tencent.mm.vending.g.f;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0004\u0013\u0014\u0015\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0017J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u0010\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u000fH\u0016¨\u0006\u0017"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess;", "Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebView;", "()V", "batchSyncWxaAttr", "", "usernameList", "", "", "preloadEnv", "appId", "privateOpenWeappFunctionalPage", "uuid", "transferJson", "reportMiniProgramPageData", "Lcom/tencent/mm/vending/pipeline/Pipeline;", "", "sendDataToMiniProgram", "data", "webviewId", "BatchSyncWxaAttr", "PreloadCdnEnv", "PrivateOpenFunctionalPage", "SendDataToMiniProgram", "plugin-appbrand-integration_release"})
public final class e extends d {

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess$BatchSyncWxaAttr;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Parcel;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
    static final class a implements i<Parcel, IPCVoid> {
        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(134456);
            IPCVoid h = h((Parcel) obj);
            AppMethodBeat.o(134456);
            return h;
        }

        private static IPCVoid h(Parcel parcel) {
            AppMethodBeat.i(134455);
            if (parcel != null) {
                try {
                    ArrayList createStringArrayList = parcel.createStringArrayList();
                    if (createStringArrayList != null) {
                        ((com.tencent.mm.plugin.appbrand.service.a) g.K(com.tencent.mm.plugin.appbrand.service.a.class)).ax(createStringArrayList);
                    }
                } catch (Exception e) {
                }
            }
            IPCVoid iPCVoid = IPCVoid.eGH;
            j.o(iPCVoid, "IPCVoid.VOID");
            AppMethodBeat.o(134455);
            return iPCVoid;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess$PreloadCdnEnv;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
    static final class b implements com.tencent.mm.ipcinvoker.a<IPCString, IPCVoid> {
        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(134457);
            IPCString iPCString = (IPCString) obj;
            ((com.tencent.mm.plugin.appbrand.service.a) g.K(com.tencent.mm.plugin.appbrand.service.a.class)).xl(iPCString != null ? iPCString.value : null);
            if (cVar != null) {
                cVar.ao(IPCVoid.eGH);
                AppMethodBeat.o(134457);
                return;
            }
            AppMethodBeat.o(134457);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess$SendDataToMiniProgram;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/h5_interact/SendDataToMiniProgramFromH5Event;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
    static final class d implements com.tencent.mm.ipcinvoker.a<SendDataToMiniProgramFromH5Event, IPCVoid> {
        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(134459);
            SendDataToMiniProgramFromH5Event sendDataToMiniProgramFromH5Event = (SendDataToMiniProgramFromH5Event) obj;
            if (sendDataToMiniProgramFromH5Event != null) {
                com.tencent.mm.plugin.appbrand.ipc.d.a(sendDataToMiniProgramFromH5Event.hJW, sendDataToMiniProgramFromH5Event);
            }
            if (cVar != null) {
                cVar.ao(IPCVoid.eGH);
                AppMethodBeat.o(134459);
                return;
            }
            AppMethodBeat.o(134459);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess$PrivateOpenFunctionalPage;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Parcel;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
    static final class c implements i<Parcel, IPCVoid> {
        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(134458);
            Parcel parcel = (Parcel) obj;
            if (parcel != null) {
                ((com.tencent.mm.plugin.appbrand.service.a) g.K(com.tencent.mm.plugin.appbrand.service.a.class)).bq(parcel.readString(), parcel.readString());
            }
            IPCVoid iPCVoid = IPCVoid.eGH;
            j.o(iPCVoid, "IPCVoid.VOID");
            AppMethodBeat.o(134458);
            return iPCVoid;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    static final class e<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        public static final e gRi = new e();

        static {
            AppMethodBeat.i(134461);
            AppMethodBeat.o(134461);
        }

        e() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(134460);
            f.dMj().cR(new IllegalAccessError("Not Support XPC invoke for noew"));
            AppMethodBeat.o(134460);
            return null;
        }
    }

    public final com.tencent.mm.vending.g.e<Integer> xk(String str) {
        AppMethodBeat.i(134462);
        com.tencent.mm.ci.f b = com.tencent.mm.ci.g.dOW().b((com.tencent.mm.vending.c.a) e.gRi);
        j.o(b, "pipelineExt().`$ui` {\n  …turn@`$ui` null\n        }");
        com.tencent.mm.vending.g.e eVar = b;
        AppMethodBeat.o(134462);
        return eVar;
    }

    public final void xl(String str) {
        AppMethodBeat.i(134463);
        XIPCInvoker.a("com.tencent.mm", new IPCString(str), b.class, null);
        AppMethodBeat.o(134463);
    }

    public final void i(String str, String str2, int i) {
        AppMethodBeat.i(134464);
        SendDataToMiniProgramFromH5Event sendDataToMiniProgramFromH5Event = new SendDataToMiniProgramFromH5Event();
        sendDataToMiniProgramFromH5Event.hJW = str;
        sendDataToMiniProgramFromH5Event.data = str2;
        sendDataToMiniProgramFromH5Event.hJX = i;
        XIPCInvoker.a("com.tencent.mm", sendDataToMiniProgramFromH5Event, d.class, null);
        AppMethodBeat.o(134464);
    }

    @SuppressLint({"Recycle"})
    public final void ax(List<String> list) {
        AppMethodBeat.i(134465);
        if (list == null) {
            AppMethodBeat.o(134465);
            return;
        }
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        obtain.writeStringList(list);
        obtain.setDataPosition(0);
        XIPCInvoker.a("com.tencent.mm", obtain, a.class);
        obtain.recycle();
        AppMethodBeat.o(134465);
    }

    public final void bq(String str, String str2) {
        AppMethodBeat.i(134466);
        if (str2 == null) {
            AppMethodBeat.o(134466);
        } else if (str == null) {
            AppMethodBeat.o(134466);
        } else {
            Parcel obtain = Parcel.obtain();
            obtain.setDataPosition(0);
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.setDataPosition(0);
            XIPCInvoker.a("com.tencent.mm", obtain, c.class);
            obtain.recycle();
            AppMethodBeat.o(134466);
        }
    }
}
