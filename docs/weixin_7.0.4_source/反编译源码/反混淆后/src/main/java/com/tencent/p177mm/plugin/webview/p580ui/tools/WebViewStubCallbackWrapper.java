package com.tencent.p177mm.plugin.webview.p580ui.tools;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.stub.C40281e;
import com.tencent.p177mm.plugin.webview.stub.C40281e.C40282a;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper */
public class WebViewStubCallbackWrapper implements Parcelable {
    public static final Creator<WebViewStubCallbackWrapper> CREATOR = new C298701();
    /* renamed from: id */
    public int f16198id;
    public C40281e uuT;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper$1 */
    static class C298701 implements Creator<WebViewStubCallbackWrapper> {
        C298701() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WebViewStubCallbackWrapper[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(7800);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                WebViewStubCallbackWrapper webViewStubCallbackWrapper = new WebViewStubCallbackWrapper(readStrongBinder, (byte) 0);
                AppMethodBeat.m2505o(7800);
                return webViewStubCallbackWrapper;
            }
            AppMethodBeat.m2505o(7800);
            return null;
        }
    }

    public WebViewStubCallbackWrapper(C40281e c40281e, int i) {
        this.uuT = c40281e;
        this.f16198id = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(7801);
        parcel.writeStrongBinder(this.uuT.asBinder());
        AppMethodBeat.m2505o(7801);
    }

    private WebViewStubCallbackWrapper(IBinder iBinder) {
        AppMethodBeat.m2504i(7802);
        this.uuT = C40282a.m69080H(iBinder);
        AppMethodBeat.m2505o(7802);
    }

    static {
        AppMethodBeat.m2504i(7803);
        AppMethodBeat.m2505o(7803);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof WebViewStubCallbackWrapper) && ((WebViewStubCallbackWrapper) obj).f16198id == this.f16198id) {
            return true;
        }
        return false;
    }
}
