package com.tencent.p177mm.plugin.appbrand.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.ipcinvoker.type.IPCString;
import com.tencent.p177mm.ipcinvoker.type.IPCVoid;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p217ci.C37654f;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.plugin.appbrand.ipc.C10276d;
import com.tencent.p177mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event;
import com.tencent.p177mm.plugin.appbrand.service.C27297a;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p641g.C7582e;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0004\u0013\u0014\u0015\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0017J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u0010\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u000fH\u0016¨\u0006\u0017"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess;", "Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebView;", "()V", "batchSyncWxaAttr", "", "usernameList", "", "", "preloadEnv", "appId", "privateOpenWeappFunctionalPage", "uuid", "transferJson", "reportMiniProgramPageData", "Lcom/tencent/mm/vending/pipeline/Pipeline;", "", "sendDataToMiniProgram", "data", "webviewId", "BatchSyncWxaAttr", "PreloadCdnEnv", "PrivateOpenFunctionalPage", "SendDataToMiniProgram", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.app.e */
public final class C42333e extends C19020d {

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess$BatchSyncWxaAttr;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Parcel;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.app.e$a */
    static final class C19023a implements C45413i<Parcel, IPCVoid> {
        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(134456);
            IPCVoid h = C19023a.m29599h((Parcel) obj);
            AppMethodBeat.m2505o(134456);
            return h;
        }

        /* renamed from: h */
        private static IPCVoid m29599h(Parcel parcel) {
            AppMethodBeat.m2504i(134455);
            if (parcel != null) {
                try {
                    ArrayList createStringArrayList = parcel.createStringArrayList();
                    if (createStringArrayList != null) {
                        ((C27297a) C1720g.m3528K(C27297a.class)).mo34265ax(createStringArrayList);
                    }
                } catch (Exception e) {
                }
            }
            IPCVoid iPCVoid = IPCVoid.eGH;
            C25052j.m39375o(iPCVoid, "IPCVoid.VOID");
            AppMethodBeat.m2505o(134455);
            return iPCVoid;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess$PreloadCdnEnv;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.app.e$b */
    static final class C19024b implements C37866a<IPCString, IPCVoid> {
        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(134457);
            IPCString iPCString = (IPCString) obj;
            ((C27297a) C1720g.m3528K(C27297a.class)).mo34269xl(iPCString != null ? iPCString.value : null);
            if (c18507c != null) {
                c18507c.mo5960ao(IPCVoid.eGH);
                AppMethodBeat.m2505o(134457);
                return;
            }
            AppMethodBeat.m2505o(134457);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess$SendDataToMiniProgram;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/h5_interact/SendDataToMiniProgramFromH5Event;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.app.e$d */
    static final class C19025d implements C37866a<SendDataToMiniProgramFromH5Event, IPCVoid> {
        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(134459);
            SendDataToMiniProgramFromH5Event sendDataToMiniProgramFromH5Event = (SendDataToMiniProgramFromH5Event) obj;
            if (sendDataToMiniProgramFromH5Event != null) {
                C10276d.m17931a(sendDataToMiniProgramFromH5Event.hJW, sendDataToMiniProgramFromH5Event);
            }
            if (c18507c != null) {
                c18507c.mo5960ao(IPCVoid.eGH);
                AppMethodBeat.m2505o(134459);
                return;
            }
            AppMethodBeat.m2505o(134459);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/app/ServiceForWebViewAnyProcess$PrivateOpenFunctionalPage;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Parcel;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.app.e$c */
    static final class C26724c implements C45413i<Parcel, IPCVoid> {
        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(134458);
            Parcel parcel = (Parcel) obj;
            if (parcel != null) {
                ((C27297a) C1720g.m3528K(C27297a.class)).mo34266bq(parcel.readString(), parcel.readString());
            }
            IPCVoid iPCVoid = IPCVoid.eGH;
            C25052j.m39375o(iPCVoid, "IPCVoid.VOID");
            AppMethodBeat.m2505o(134458);
            return iPCVoid;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    /* renamed from: com.tencent.mm.plugin.appbrand.app.e$e */
    static final class C42332e<_Ret, _Var> implements C5681a<_Ret, _Var> {
        public static final C42332e gRi = new C42332e();

        static {
            AppMethodBeat.m2504i(134461);
            AppMethodBeat.m2505o(134461);
        }

        C42332e() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(134460);
            C5698f.dMj().mo11582cR(new IllegalAccessError("Not Support XPC invoke for noew"));
            AppMethodBeat.m2505o(134460);
            return null;
        }
    }

    /* renamed from: xk */
    public final C7582e<Integer> mo34268xk(String str) {
        AppMethodBeat.m2504i(134462);
        C37654f b = C41930g.dOW().mo60487b((C5681a) C42332e.gRi);
        C25052j.m39375o(b, "pipelineExt().`$ui` {\n  …turn@`$ui` null\n        }");
        C7582e c7582e = b;
        AppMethodBeat.m2505o(134462);
        return c7582e;
    }

    /* renamed from: xl */
    public final void mo34269xl(String str) {
        AppMethodBeat.m2504i(134463);
        XIPCInvoker.m83629a("com.tencent.mm", new IPCString(str), C19024b.class, null);
        AppMethodBeat.m2505o(134463);
    }

    /* renamed from: i */
    public final void mo34267i(String str, String str2, int i) {
        AppMethodBeat.m2504i(134464);
        SendDataToMiniProgramFromH5Event sendDataToMiniProgramFromH5Event = new SendDataToMiniProgramFromH5Event();
        sendDataToMiniProgramFromH5Event.hJW = str;
        sendDataToMiniProgramFromH5Event.data = str2;
        sendDataToMiniProgramFromH5Event.hJX = i;
        XIPCInvoker.m83629a("com.tencent.mm", sendDataToMiniProgramFromH5Event, C19025d.class, null);
        AppMethodBeat.m2505o(134464);
    }

    @SuppressLint({"Recycle"})
    /* renamed from: ax */
    public final void mo34265ax(List<String> list) {
        AppMethodBeat.m2504i(134465);
        if (list == null) {
            AppMethodBeat.m2505o(134465);
            return;
        }
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        obtain.writeStringList(list);
        obtain.setDataPosition(0);
        XIPCInvoker.m83628a("com.tencent.mm", obtain, C19023a.class);
        obtain.recycle();
        AppMethodBeat.m2505o(134465);
    }

    /* renamed from: bq */
    public final void mo34266bq(String str, String str2) {
        AppMethodBeat.m2504i(134466);
        if (str2 == null) {
            AppMethodBeat.m2505o(134466);
        } else if (str == null) {
            AppMethodBeat.m2505o(134466);
        } else {
            Parcel obtain = Parcel.obtain();
            obtain.setDataPosition(0);
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.setDataPosition(0);
            XIPCInvoker.m83628a("com.tencent.mm", obtain, C26724c.class);
            obtain.recycle();
            AppMethodBeat.m2505o(134466);
        }
    }
}
