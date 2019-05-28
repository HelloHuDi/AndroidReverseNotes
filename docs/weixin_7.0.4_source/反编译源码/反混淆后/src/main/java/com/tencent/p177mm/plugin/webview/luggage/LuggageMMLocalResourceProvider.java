package com.tencent.p177mm.plugin.webview.luggage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.webview.p1172a.C17831c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.webview.model.C43914ap;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/* renamed from: com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider */
public final class LuggageMMLocalResourceProvider implements C17831c {

    /* renamed from: com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider$GetLocalResourceInfoTask */
    static class GetLocalResourceInfoTask extends MainProcessTask {
        public static final Creator<GetLocalResourceInfoTask> CREATOR = new C314711();
        String czD;
        Runnable hyN;
        int infoType;
        String path;

        /* renamed from: com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider$GetLocalResourceInfoTask$1 */
        static class C314711 implements Creator<GetLocalResourceInfoTask> {
            C314711() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetLocalResourceInfoTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(5981);
                GetLocalResourceInfoTask getLocalResourceInfoTask = new GetLocalResourceInfoTask();
                getLocalResourceInfoTask.mo6032g(parcel);
                AppMethodBeat.m2505o(5981);
                return getLocalResourceInfoTask;
            }
        }

        private GetLocalResourceInfoTask() {
        }

        /* synthetic */ GetLocalResourceInfoTask(byte b) {
            this();
        }

        public final void asP() {
            AppMethodBeat.m2504i(5982);
            switch (this.infoType) {
                case 1:
                    this.path = C43914ap.aeC(this.czD);
                    break;
                case 2:
                    this.path = C43914ap.aeD(this.czD);
                    break;
            }
            aCb();
            AppMethodBeat.m2505o(5982);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(5983);
            if (this.hyN != null) {
                this.hyN.run();
            }
            AppMethodBeat.m2505o(5983);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(5984);
            parcel.writeString(this.czD);
            parcel.writeInt(this.infoType);
            parcel.writeString(this.path);
            AppMethodBeat.m2505o(5984);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(5985);
            this.czD = parcel.readString();
            this.infoType = parcel.readInt();
            this.path = parcel.readString();
            AppMethodBeat.m2505o(5985);
        }

        static {
            AppMethodBeat.m2504i(5986);
            AppMethodBeat.m2505o(5986);
        }
    }

    /* renamed from: yk */
    public final String mo23954yk() {
        return "weixin://resourceid/.*";
    }

    /* renamed from: bG */
    public final WebResourceResponse mo23953bG(String str) {
        AppMethodBeat.m2504i(5987);
        final PipedOutputStream pipedOutputStream = new PipedOutputStream();
        try {
            PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);
            final MainProcessTask getLocalResourceInfoTask = new GetLocalResourceInfoTask();
            getLocalResourceInfoTask.czD = str;
            getLocalResourceInfoTask.infoType = 1;
            getLocalResourceInfoTask.hyN = new Runnable() {
                /* JADX WARNING: Removed duplicated region for block: B:13:0x0029 A:{SYNTHETIC, Splitter:B:13:0x0029} */
                /* JADX WARNING: Removed duplicated region for block: B:22:0x003f A:{SYNTHETIC, Splitter:B:22:0x003f} */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    Throwable th;
                    FileInputStream fileInputStream;
                    AppMethodBeat.m2504i(5980);
                    FileInputStream fileInputStream2;
                    try {
                        fileInputStream2 = new FileInputStream(getLocalResourceInfoTask.path);
                        try {
                            LuggageMMLocalResourceProvider.m87408c(fileInputStream2, pipedOutputStream);
                            try {
                                fileInputStream2.close();
                                pipedOutputStream.close();
                                AppMethodBeat.m2505o(5980);
                            } catch (Exception e) {
                                AppMethodBeat.m2505o(5980);
                            }
                        } catch (Exception e2) {
                            if (fileInputStream2 != null) {
                            }
                            pipedOutputStream.close();
                            AppMethodBeat.m2505o(5980);
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                            }
                            pipedOutputStream.close();
                            AppMethodBeat.m2505o(5980);
                            throw th;
                        }
                    } catch (Exception e3) {
                        fileInputStream2 = null;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception e4) {
                                AppMethodBeat.m2505o(5980);
                                return;
                            }
                        }
                        pipedOutputStream.close();
                        AppMethodBeat.m2505o(5980);
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = null;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e5) {
                                AppMethodBeat.m2505o(5980);
                                throw th;
                            }
                        }
                        pipedOutputStream.close();
                        AppMethodBeat.m2505o(5980);
                        throw th;
                    }
                }
            };
            AppBrandMainProcessService.m54349a(getLocalResourceInfoTask);
            WebResourceResponse webResourceResponse = new WebResourceResponse("image/*", ProtocolPackage.ServerEncoding, pipedInputStream);
            AppMethodBeat.m2505o(5987);
            return webResourceResponse;
        } catch (Exception e) {
            AppMethodBeat.m2505o(5987);
            return null;
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m87408c(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.m2504i(5988);
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                AppMethodBeat.m2505o(5988);
                return;
            }
        }
    }
}
