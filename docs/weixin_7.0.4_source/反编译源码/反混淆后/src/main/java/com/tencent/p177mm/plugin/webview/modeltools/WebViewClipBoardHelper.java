package com.tencent.p177mm.plugin.webview.modeltools;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.plugin.secinforeport.p1293a.C21734a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.nio.charset.Charset;

/* renamed from: com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper */
public final class WebViewClipBoardHelper implements OnPrimaryClipChangedListener {
    private long lastReportTime = 0;
    private WebViewUI upw;
    public ClipboardManager upx;

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper$a */
    static final class C14537a implements C37866a<ClipBoardDataWrapper, Object> {
        private C14537a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(7018);
            ClipBoardDataWrapper clipBoardDataWrapper = (ClipBoardDataWrapper) obj;
            if (clipBoardDataWrapper != null) {
                C21734a c21734a = C21734a.qjm;
                C21734a.m33276i(clipBoardDataWrapper.url, clipBoardDataWrapper.length, clipBoardDataWrapper.fromScene, clipBoardDataWrapper.username);
                AppMethodBeat.m2505o(7018);
                return;
            }
            C4990ab.m7412e("MicroMsg.WebViewClipBoardHelper", "InvokeTask, mm received invalid data");
            AppMethodBeat.m2505o(7018);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper$ClipBoardDataWrapper */
    static final class ClipBoardDataWrapper implements Parcelable {
        public static final Creator<ClipBoardDataWrapper> CREATOR = new C145361();
        int fromScene;
        int length;
        String url;
        String username;

        /* renamed from: com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper$ClipBoardDataWrapper$1 */
        static class C145361 implements Creator<ClipBoardDataWrapper> {
            C145361() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ClipBoardDataWrapper[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(7014);
                ClipBoardDataWrapper clipBoardDataWrapper = new ClipBoardDataWrapper(parcel);
                AppMethodBeat.m2505o(7014);
                return clipBoardDataWrapper;
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(7015);
            parcel.writeString(this.url);
            parcel.writeInt(this.length);
            parcel.writeInt(this.fromScene);
            parcel.writeString(this.username);
            AppMethodBeat.m2505o(7015);
        }

        ClipBoardDataWrapper() {
        }

        ClipBoardDataWrapper(Parcel parcel) {
            AppMethodBeat.m2504i(7016);
            this.url = parcel.readString();
            this.length = parcel.readInt();
            this.fromScene = parcel.readInt();
            this.username = parcel.readString();
            AppMethodBeat.m2505o(7016);
        }

        static {
            AppMethodBeat.m2504i(7017);
            AppMethodBeat.m2505o(7017);
        }
    }

    public WebViewClipBoardHelper(WebViewUI webViewUI) {
        AppMethodBeat.m2504i(7019);
        this.upw = webViewUI;
        this.upx = (ClipboardManager) webViewUI.getApplicationContext().getSystemService("clipboard");
        try {
            this.upx.addPrimaryClipChangedListener(this);
            AppMethodBeat.m2505o(7019);
        } catch (Exception e) {
            AppMethodBeat.m2505o(7019);
        }
    }

    public final void onPrimaryClipChanged() {
        AppMethodBeat.m2504i(7020);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastReportTime < 200) {
            AppMethodBeat.m2505o(7020);
            return;
        }
        this.lastReportTime = currentTimeMillis;
        ClipData primaryClip = this.upx.getPrimaryClip();
        if (primaryClip == null) {
            AppMethodBeat.m2505o(7020);
            return;
        }
        Item itemAt = primaryClip.getItemAt(0);
        if (itemAt == null) {
            AppMethodBeat.m2505o(7020);
            return;
        }
        ClipBoardDataWrapper clipBoardDataWrapper = new ClipBoardDataWrapper();
        clipBoardDataWrapper.url = this.upw.dae();
        if (C5046bo.m7519ac(itemAt.getText())) {
            C4990ab.m7420w("MicroMsg.WebViewClipBoardHelper", "onPrimaryClipChanged text is null");
            AppMethodBeat.m2505o(7020);
            return;
        }
        clipBoardDataWrapper.length = itemAt.getText().toString().getBytes(Charset.forName("UTF-8")).length;
        clipBoardDataWrapper.fromScene = this.upw.getIntent().getIntExtra("from_scence", 0);
        clipBoardDataWrapper.username = this.upw.getIntent().getStringExtra("geta8key_username");
        XIPCInvoker.m83629a("com.tencent.mm", clipBoardDataWrapper, C14537a.class, null);
        AppMethodBeat.m2505o(7020);
    }
}
