package com.tencent.mm.plugin.webview.modeltools;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.charset.Charset;

public final class WebViewClipBoardHelper implements OnPrimaryClipChangedListener {
    private long lastReportTime = 0;
    private WebViewUI upw;
    public ClipboardManager upx;

    static final class a implements com.tencent.mm.ipcinvoker.a<ClipBoardDataWrapper, Object> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, c cVar) {
            AppMethodBeat.i(7018);
            ClipBoardDataWrapper clipBoardDataWrapper = (ClipBoardDataWrapper) obj;
            if (clipBoardDataWrapper != null) {
                com.tencent.mm.plugin.secinforeport.a.a aVar = com.tencent.mm.plugin.secinforeport.a.a.qjm;
                com.tencent.mm.plugin.secinforeport.a.a.i(clipBoardDataWrapper.url, clipBoardDataWrapper.length, clipBoardDataWrapper.fromScene, clipBoardDataWrapper.username);
                AppMethodBeat.o(7018);
                return;
            }
            ab.e("MicroMsg.WebViewClipBoardHelper", "InvokeTask, mm received invalid data");
            AppMethodBeat.o(7018);
        }
    }

    static final class ClipBoardDataWrapper implements Parcelable {
        public static final Creator<ClipBoardDataWrapper> CREATOR = new Creator<ClipBoardDataWrapper>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ClipBoardDataWrapper[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(7014);
                ClipBoardDataWrapper clipBoardDataWrapper = new ClipBoardDataWrapper(parcel);
                AppMethodBeat.o(7014);
                return clipBoardDataWrapper;
            }
        };
        int fromScene;
        int length;
        String url;
        String username;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(7015);
            parcel.writeString(this.url);
            parcel.writeInt(this.length);
            parcel.writeInt(this.fromScene);
            parcel.writeString(this.username);
            AppMethodBeat.o(7015);
        }

        ClipBoardDataWrapper() {
        }

        ClipBoardDataWrapper(Parcel parcel) {
            AppMethodBeat.i(7016);
            this.url = parcel.readString();
            this.length = parcel.readInt();
            this.fromScene = parcel.readInt();
            this.username = parcel.readString();
            AppMethodBeat.o(7016);
        }

        static {
            AppMethodBeat.i(7017);
            AppMethodBeat.o(7017);
        }
    }

    public WebViewClipBoardHelper(WebViewUI webViewUI) {
        AppMethodBeat.i(7019);
        this.upw = webViewUI;
        this.upx = (ClipboardManager) webViewUI.getApplicationContext().getSystemService("clipboard");
        try {
            this.upx.addPrimaryClipChangedListener(this);
            AppMethodBeat.o(7019);
        } catch (Exception e) {
            AppMethodBeat.o(7019);
        }
    }

    public final void onPrimaryClipChanged() {
        AppMethodBeat.i(7020);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastReportTime < 200) {
            AppMethodBeat.o(7020);
            return;
        }
        this.lastReportTime = currentTimeMillis;
        ClipData primaryClip = this.upx.getPrimaryClip();
        if (primaryClip == null) {
            AppMethodBeat.o(7020);
            return;
        }
        Item itemAt = primaryClip.getItemAt(0);
        if (itemAt == null) {
            AppMethodBeat.o(7020);
            return;
        }
        ClipBoardDataWrapper clipBoardDataWrapper = new ClipBoardDataWrapper();
        clipBoardDataWrapper.url = this.upw.dae();
        if (bo.ac(itemAt.getText())) {
            ab.w("MicroMsg.WebViewClipBoardHelper", "onPrimaryClipChanged text is null");
            AppMethodBeat.o(7020);
            return;
        }
        clipBoardDataWrapper.length = itemAt.getText().toString().getBytes(Charset.forName("UTF-8")).length;
        clipBoardDataWrapper.fromScene = this.upw.getIntent().getIntExtra("from_scence", 0);
        clipBoardDataWrapper.username = this.upw.getIntent().getStringExtra("geta8key_username");
        XIPCInvoker.a("com.tencent.mm", clipBoardDataWrapper, a.class, null);
        AppMethodBeat.o(7020);
    }
}
