package com.tencent.mm.plugin.webview.luggage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.webview.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.model.ap;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public final class LuggageMMLocalResourceProvider implements c {

    static class GetLocalResourceInfoTask extends MainProcessTask {
        public static final Creator<GetLocalResourceInfoTask> CREATOR = new Creator<GetLocalResourceInfoTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetLocalResourceInfoTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(5981);
                GetLocalResourceInfoTask getLocalResourceInfoTask = new GetLocalResourceInfoTask();
                getLocalResourceInfoTask.g(parcel);
                AppMethodBeat.o(5981);
                return getLocalResourceInfoTask;
            }
        };
        String czD;
        Runnable hyN;
        int infoType;
        String path;

        private GetLocalResourceInfoTask() {
        }

        /* synthetic */ GetLocalResourceInfoTask(byte b) {
            this();
        }

        public final void asP() {
            AppMethodBeat.i(5982);
            switch (this.infoType) {
                case 1:
                    this.path = ap.aeC(this.czD);
                    break;
                case 2:
                    this.path = ap.aeD(this.czD);
                    break;
            }
            aCb();
            AppMethodBeat.o(5982);
        }

        public final void asQ() {
            AppMethodBeat.i(5983);
            if (this.hyN != null) {
                this.hyN.run();
            }
            AppMethodBeat.o(5983);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(5984);
            parcel.writeString(this.czD);
            parcel.writeInt(this.infoType);
            parcel.writeString(this.path);
            AppMethodBeat.o(5984);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(5985);
            this.czD = parcel.readString();
            this.infoType = parcel.readInt();
            this.path = parcel.readString();
            AppMethodBeat.o(5985);
        }

        static {
            AppMethodBeat.i(5986);
            AppMethodBeat.o(5986);
        }
    }

    public final String yk() {
        return "weixin://resourceid/.*";
    }

    public final WebResourceResponse bG(String str) {
        AppMethodBeat.i(5987);
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
                    AppMethodBeat.i(5980);
                    FileInputStream fileInputStream2;
                    try {
                        fileInputStream2 = new FileInputStream(getLocalResourceInfoTask.path);
                        try {
                            LuggageMMLocalResourceProvider.c(fileInputStream2, pipedOutputStream);
                            try {
                                fileInputStream2.close();
                                pipedOutputStream.close();
                                AppMethodBeat.o(5980);
                            } catch (Exception e) {
                                AppMethodBeat.o(5980);
                            }
                        } catch (Exception e2) {
                            if (fileInputStream2 != null) {
                            }
                            pipedOutputStream.close();
                            AppMethodBeat.o(5980);
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                            }
                            pipedOutputStream.close();
                            AppMethodBeat.o(5980);
                            throw th;
                        }
                    } catch (Exception e3) {
                        fileInputStream2 = null;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception e4) {
                                AppMethodBeat.o(5980);
                                return;
                            }
                        }
                        pipedOutputStream.close();
                        AppMethodBeat.o(5980);
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = null;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e5) {
                                AppMethodBeat.o(5980);
                                throw th;
                            }
                        }
                        pipedOutputStream.close();
                        AppMethodBeat.o(5980);
                        throw th;
                    }
                }
            };
            AppBrandMainProcessService.a(getLocalResourceInfoTask);
            WebResourceResponse webResourceResponse = new WebResourceResponse("image/*", ProtocolPackage.ServerEncoding, pipedInputStream);
            AppMethodBeat.o(5987);
            return webResourceResponse;
        } catch (Exception e) {
            AppMethodBeat.o(5987);
            return null;
        }
    }

    static /* synthetic */ void c(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(5988);
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                AppMethodBeat.o(5988);
                return;
            }
        }
    }
}
