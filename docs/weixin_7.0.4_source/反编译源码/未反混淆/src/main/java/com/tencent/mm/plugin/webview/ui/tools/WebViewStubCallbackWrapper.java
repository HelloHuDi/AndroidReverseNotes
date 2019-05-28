package com.tencent.mm.plugin.webview.ui.tools;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.stub.e.a;

public class WebViewStubCallbackWrapper implements Parcelable {
    public static final Creator<WebViewStubCallbackWrapper> CREATOR = new Creator<WebViewStubCallbackWrapper>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WebViewStubCallbackWrapper[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(7800);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                WebViewStubCallbackWrapper webViewStubCallbackWrapper = new WebViewStubCallbackWrapper(readStrongBinder, (byte) 0);
                AppMethodBeat.o(7800);
                return webViewStubCallbackWrapper;
            }
            AppMethodBeat.o(7800);
            return null;
        }
    };
    public int id;
    public e uuT;

    public WebViewStubCallbackWrapper(e eVar, int i) {
        this.uuT = eVar;
        this.id = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(7801);
        parcel.writeStrongBinder(this.uuT.asBinder());
        AppMethodBeat.o(7801);
    }

    private WebViewStubCallbackWrapper(IBinder iBinder) {
        AppMethodBeat.i(7802);
        this.uuT = a.H(iBinder);
        AppMethodBeat.o(7802);
    }

    static {
        AppMethodBeat.i(7803);
        AppMethodBeat.o(7803);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof WebViewStubCallbackWrapper) && ((WebViewStubCallbackWrapper) obj).id == this.id) {
            return true;
        }
        return false;
    }
}
