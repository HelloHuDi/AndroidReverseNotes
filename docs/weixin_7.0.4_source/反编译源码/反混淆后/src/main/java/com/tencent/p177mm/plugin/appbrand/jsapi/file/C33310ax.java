package com.tencent.p177mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42367l;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C19377f.C10396a;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.ax */
final class C33310ax extends C38299d {
    C33310ax() {
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final C10396a mo21863a(C2241c c2241c, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(102840);
        String optString = jSONObject.optString("targetDirectory", "");
        C10396a c10396a;
        switch (c2241c.asE().mo5850ye(optString)) {
            case ERR_PERMISSION_DENIED:
            case ERR_IS_FILE:
            case ERR_OP_FAIL:
                c10396a = new C10396a(String.format("fail permission denied, open \"%s\"", new Object[]{optString}), new Object[0]);
                AppMethodBeat.m2505o(102840);
                return c10396a;
            default:
                int i;
                File yg = c2241c.asE().mo34314yg(str);
                if (yg == null || !yg.exists()) {
                    if (c2241c.asE().mo5849yd(str) == C45518j.OK) {
                        C5728b yh = c2241c.asE().mo34315yh(URLEncoder.encode(str));
                        if (yh != null) {
                            C19681j c19681j = new C19681j();
                            c2241c.asE().mo5843b(str, c19681j);
                            try {
                                Channels.newChannel(C5730e.m8641q(yh)).write((ByteBuffer) c19681j.value);
                                yg = new File(C5736j.m8649w(yh.dMD()));
                                i = 1;
                            } catch (IOException e) {
                                C4990ab.m7413e("MicroMsg.AppBrand.FileSystem.UnitUnzip", "copy ByteBuffer failed e = %s", e);
                                yg = null;
                                i = 0;
                            }
                            if (yg == null) {
                                c10396a = new C10396a("fail no such file \"%s\"", str);
                                AppMethodBeat.m2505o(102840);
                                return c10396a;
                            }
                        }
                    }
                    i = 0;
                    if (yg == null) {
                    }
                } else if (yg.isDirectory() || C42367l.m74942F(yg)) {
                    c10396a = new C10396a("fail permission denied, open \"%s\"", str);
                    AppMethodBeat.m2505o(102840);
                    return c10396a;
                } else {
                    i = 0;
                }
                try {
                    C45518j b = c2241c.asE().mo5844b(optString, yg);
                    if (i != 0) {
                        C5730e.deleteFile(yg.getAbsolutePath());
                    }
                    switch (b) {
                        case ERR_PERMISSION_DENIED:
                            c10396a = new C10396a("fail permission denied, open \"%s\"", str);
                            AppMethodBeat.m2505o(102840);
                            return c10396a;
                        case ERR_PARENT_DIR_NOT_EXISTS:
                            c10396a = new C10396a("fail no such file or directory, open \"%s\"", str);
                            AppMethodBeat.m2505o(102840);
                            return c10396a;
                        case RET_ALREADY_EXISTS:
                            c10396a = new C10396a("fail illegal operation on a filePath, open \"%s\"", str);
                            AppMethodBeat.m2505o(102840);
                            return c10396a;
                        case ERR_EXCEED_DIRECTORY_MAX_SIZE:
                            c10396a = new C10396a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
                            AppMethodBeat.m2505o(102840);
                            return c10396a;
                        case ERR_BAD_ZIP_FILE:
                            c10396a = new C10396a("fail read zip data", new Object[0]);
                            AppMethodBeat.m2505o(102840);
                            return c10396a;
                        case ERR_WRITE_ZIP_ENTRY:
                            c10396a = new C10396a("fail write entry", new Object[0]);
                            AppMethodBeat.m2505o(102840);
                            return c10396a;
                        case OK:
                            c10396a = new C10396a("ok", new Object[0]);
                            AppMethodBeat.m2505o(102840);
                            return c10396a;
                        default:
                            c10396a = new C10396a("fail " + b.name(), new Object[0]);
                            AppMethodBeat.m2505o(102840);
                            return c10396a;
                    }
                } catch (Exception e2) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrand.FileSystem.UnitUnzip", e2, "write zip stream", new Object[0]);
                    c10396a = new C10396a("fail read zip data", new Object[0]);
                    AppMethodBeat.m2505o(102840);
                    return c10396a;
                }
                C4990ab.printErrStackTrace("MicroMsg.AppBrand.FileSystem.UnitUnzip", e2, "write zip stream", new Object[0]);
                c10396a = new C10396a("fail read zip data", new Object[0]);
                AppMethodBeat.m2505o(102840);
                return c10396a;
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: y */
    public final String mo44689y(JSONObject jSONObject) {
        AppMethodBeat.m2504i(102841);
        String optString = jSONObject.optString("zipFilePath");
        AppMethodBeat.m2505o(102841);
        return optString;
    }
}
